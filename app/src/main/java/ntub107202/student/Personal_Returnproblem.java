package ntub107202.student;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Personal_Returnproblem extends AppCompatActivity {
    EditText edit_problem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_returnproblem);
        edit_problem = (EditText) findViewById(R.id.edit_problem);
        Button button01 = (Button) findViewById(R.id.btn_sent);
        button01.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                getWorksheet.postToQuestion(edit_problem.getText().toString());
                Intent intent = new Intent(Personal_Returnproblem.this,NavigationActivity.class);
                intent.putExtra("id",4);
                startActivity(intent);
            }
        });
    }
}
