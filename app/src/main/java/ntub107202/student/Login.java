package ntub107202.student;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ntub107202.student.Common.ApplicationController;

public class Login extends AppCompatActivity {

    private Button button,button2,buttonLogin;
    private EditText email;
    private EditText password;
    private String valid_email;
    private String valid_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        button = findViewById(R.id.buttonByPass);
        button2 = findViewById(R.id.buttonRegister);
        buttonLogin = findViewById(R.id.button);
        email = (EditText) findViewById(R.id.editText4);
        password = (EditText) findViewById(R.id.editText6);

        String user = getSharedPreferences("userpw", MODE_PRIVATE).getString("USER", "");
        String pw = getSharedPreferences("userpw", MODE_PRIVATE).getString("PW", "");
        if(! user.equals("") && ! pw.equals("")){
            postATLogin();
        }
        Log.v("useraa", user);
        Log.v("useraa", pw);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBypass();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegister();
            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postLogin();
            }
        });

    }
    public void openBypass(){
        Intent intent =new Intent(this, Bypass.class);
        startActivity(intent);
    }
    public void openRegister(){
        Intent intent =new Intent(this, Register.class);
        startActivity(intent);
    }
    public void showAlert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(Login.this);
        builder.setMessage("帳密輸入錯誤，請重新輸入");

        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void afterTextChanged(Editable s) {
            // TODO Auto-generated method stub
            Log.d("TAG", "afterTextChanged--------------->");
            Is_Valid_Email(email);
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count,
                                      int after) {
            // TODO Auto-generated method stub
            Log.d("TAG", "beforeTextChanged--------------->");
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before,
                                  int count) {
            Log.d("TAG", "onTextChanged--------------->");

        }
        public void Is_Valid_Email(EditText edt) {
            if (edt.getText().toString().equals("")) {
                edt.setError("帳號不得為空!");
                valid_email = null;
            } else if (isEmailValid(edt.getText().toString()) == false) {
                edt.setError("無效的帳號格式!");
                valid_email = null;
            } else {
                valid_email = edt.getText().toString();
            }
        }

        boolean isEmailValid(CharSequence email) {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(email)
                    .matches();
        } // end of TextWatcher (email)
    };

    private TextWatcher textWatcher1 = new TextWatcher() {
        @Override
        public void afterTextChanged(Editable s) {
            // TODO Auto-generated method stub
            Log.d("TAG", "afterTextChanged--------------->");
            Is_Valid_Password(password);
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count,
                                      int after) {
            // TODO Auto-generated method stub
            Log.d("TAG", "beforeTextChanged--------------->");
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before,
                                  int count) {
            Log.d("TAG", "onTextChanged--------------->");

        }
        public void Is_Valid_Password(EditText edt) {
            if (edt.getText().toString().equals("")) {
                edt.setError("密碼不得為空!");
                valid_password = null;
            }else {
                valid_password = edt.getText().toString();
            }
        }
    };

    private void postLogin()
    {
        // Service的URL
        String url = "http://140.131.114.153/postStudentLogin.php";

        //對應Postman StringRequest -> content-type=不設置

        StringRequest request = new StringRequest(Request.Method.POST,url,
                new Response.Listener<String>()
                {
                    @Override
                    //respone = php回應的結果
                    public void onResponse(String response)
                    {
                        Log.i("Log","result:" + response);
                        try {
                            String ret = parsePostLoginJSon(response);
                            if(ret.equals("成功"))
                            {
                                String user = email.getText().toString();
                                String pw = password.getText().toString();
                                SharedPreferences pref = getSharedPreferences("userpw", MODE_PRIVATE);
                                pref.edit()
                                        .putString("USER", user)
                                        .putString("PW", pw)
                                        .commit();
                                openBypass();
                            }
                            else {
                                showAlert();
                                Log.i("Log","帳密錯誤");
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener()
                {
                    // Request失敗處理
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
        )
        {
            @Override


            //=postman keyvalue (formdata)
            protected Map<String, String> getParams() {
                Map<String, String> param = new HashMap<>();

                param.put("row1", email.getText().toString());
                param.put("row2", password.getText().toString());

                return param;
            }
        };
        // 將request放到RequestQueue，Volley會以非同步方式送出request
        ApplicationController.getInstance().addToRequestQueue(request);
    }


    private String parsePostLoginJSon(String response) throws JSONException
    {
        if (response == null)
            return null;

        JSONObject jsonResponse = new JSONObject(response);
        JSONArray jsonStars = jsonResponse.getJSONArray("result");

        if(jsonStars.length() > 0)
        {
            return "成功";

        }
        return "失敗";
    }

    private void postATLogin()
    {
        // Service的URL
        String url = "http://140.131.114.153/postStudentLogin.php";

        //對應Postman StringRequest -> content-type=不設置

        StringRequest request = new StringRequest(Request.Method.POST,url,
                new Response.Listener<String>()
                {
                    @Override
                    //respone = php回應的結果
                    public void onResponse(String response)
                    {
                        Log.i("Log","result:" + response);
                        try {
                            String ret = parsePostLoginJSon(response);
                            if(ret.equals("成功"))
                            {
                                openBypass();
                            }
                            else {
                                Log.i("Log","帳密錯誤");
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener()
                {
                    // Request失敗處理
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
        )
        {
            @Override


            //=postman keyvalue (formdata)
            protected Map<String, String> getParams() {
                Map<String, String> param = new HashMap<>();
                String user = getSharedPreferences("userpw", MODE_PRIVATE).getString("USER", "");
                String pw = getSharedPreferences("userpw", MODE_PRIVATE).getString("PW", "");
                param.put("row1", user);
                param.put("row2", pw);

                return param;
            }
        };
        // 將request放到RequestQueue，Volley會以非同步方式送出request
        ApplicationController.getInstance().addToRequestQueue(request);
    }
}
