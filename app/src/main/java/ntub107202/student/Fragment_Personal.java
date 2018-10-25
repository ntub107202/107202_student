package ntub107202.student;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import static ntub107202.student.getWorksheet.username;

public class Fragment_Personal extends Fragment {
    TextView textView31;
    TextView textView30;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_personal,container,false);

        Button button00 = (Button)view.findViewById(R.id.btn_edit_resume);
        Button button01 = (Button)view.findViewById(R.id.btn_hire_history);
        Button button02 = (Button)view.findViewById(R.id.btn_logout);
        Button btn_collection = (Button)view.findViewById(R.id.btn_collection);
        Button button03 = (Button)view.findViewById(R.id.btn_return);
        Button button04 = (Button)view.findViewById(R.id.btn_about);
        Button button05 = (Button)view.findViewById(R.id.btn_specification);
        Button button06 = (Button) view.findViewById(R.id.btn_notice);
        Button button07 = (Button)view.findViewById(R.id.btn_login);
        Button button08 = (Button)view.findViewById(R.id.btn_reg);
        getWorksheet.getStudentnameJSON();
        textView31 = (TextView)view.findViewById(R.id.textView31);
        textView30 = (TextView)view.findViewById(R.id.textView30);
        ImageView imageView4 = (ImageView)view.findViewById(R.id.imageView4);


        textView31.setText(getWorksheet.getRow42(0));
//        Log.v("QQQQQQ",username);
        imageView4.setImageBitmap(stringToBitmap(getWorksheet.getuserpic()));
//        Log.v("QQQQQQ",getWorksheet.getRow42(0));
        textView30.setText(Login.getUser());
        Log.v("1516651",Login.getUser());
        button00.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(),Personal_Resume.class);
                startActivity(intent);
            }
        });
        button01.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(),Personal_Hirehistory.class);
                startActivity(intent);
            }
        });
        button02.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(),Login.class);
                startActivity(intent);
            }
        });
        btn_collection.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(),Personal_Collection.class);
                startActivity(intent);
            }
        });
        button03.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(),Personal_Returnproblem.class);
                startActivity(intent);
            }
        });
        button04.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(),Personal_Aboutme.class);
                startActivity(intent);
            }
        });
        button05.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(),Personal_Specification.class);
                startActivity(intent);
            }
        });
        button06.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(),Personal_Notification.class);
                startActivity(intent);
            }
        });

        button07.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(),Login.class);
                startActivity(intent);
            }
        });
        button08.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(),Register.class);
                startActivity(intent);
            }
        });

        return view;
    }
    public Bitmap stringToBitmap(String string) {
        Bitmap bitmap = null;
        try {
            byte[] bitmapArray = Base64.decode(string, Base64.DEFAULT);
            bitmap = BitmapFactory.decodeByteArray(bitmapArray, 0, bitmapArray.length);
            return bitmap;
        } catch (NullPointerException e) {
            e.getMessage();
            return null;
        } catch (OutOfMemoryError e) {
            return null;
        }
    }
}
