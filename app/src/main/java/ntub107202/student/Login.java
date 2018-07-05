package ntub107202.student;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Login extends AppCompatActivity {
    private Button button,button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        button = findViewById(R.id.buttonByPass);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBypass();
            }
        });
        button2 = findViewById(R.id.buttonRegister);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegister();
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
}
