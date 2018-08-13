package ntub107202.student;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Bypass extends AppCompatActivity {
    private Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bypass);
        //取得伺服器上JSON資料
        getWorksheet.getJSON();
        getWorksheet.getjobJSON();
        getWorksheet.getscheduleJSON();

        button2 = findViewById(R.id.buttonStdEntry);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStd();
            }
        });
    }

    public void openStd(){
        Intent intent =new Intent(this, NavigationActivity.class);
        startActivity(intent);
    }
    }

