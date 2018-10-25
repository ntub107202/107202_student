package ntub107202.student;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Findhostel_hostelinfo extends AppCompatActivity {
    public TextView hostelName, hostelAddr, jobTitle, salary, startDate,
            endDate, startTime, endTime, numberOfPeople, work,
            contact, email, phone;
    public ImageView imgHostelPic;
    public String hostelNum, hostelOwnerAccount;
    public Button btnResume;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.findhostel_hostelinfo);

        Bundle bundle=getIntent().getExtras();
        int position=bundle.getInt("position");

        btnResume =  findViewById(R.id.btn_resume);

        hostelName = (TextView) findViewById(R.id.txt_hostel_name);//row19
        hostelAddr = (TextView) findViewById(R.id.txt_hostel_addr);//20
        jobTitle = (TextView) findViewById(R.id.txt_job_title);//22
        salary = (TextView) findViewById(R.id.txt_salary);//23
        startDate = (TextView) findViewById(R.id.start_date);//24
        endDate = (TextView) findViewById(R.id.end_date);//25
        startTime = (TextView) findViewById(R.id.startTime);//26
        endTime = (TextView) findViewById(R.id.endTime);//27
        numberOfPeople = (TextView) findViewById(R.id.txt_number_people);//28
        work = (TextView) findViewById(R.id.txt_work);//29
        contact = (TextView) findViewById(R.id.txt_contact);//30
        email = (TextView) findViewById(R.id.txt_email);//31
        phone = (TextView) findViewById(R.id.txt_phone);//32
        imgHostelPic = (ImageView) findViewById(R.id.imageView_hostel_pic);//21
        String user = getSharedPreferences("userpw", MODE_PRIVATE).getString("USER", "");

        btnResume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getWorksheet.postToResume(user, hostelOwnerAccount, hostelNum);
                Log.d("get5487", "我是User" + user);
                Log.d("get5487", "fuck123fuck" + getWorksheet.getRow35(position));
                Log.d("get5487", "fuck123fuck" + getWorksheet.getRow31(position));
            }
        });



        hostelName.setText(getWorksheet.getRow19(position));
        hostelAddr.setText(getWorksheet.getRow20(position));
        jobTitle.setText(getWorksheet.getRow22(position));
        salary.setText(getWorksheet.getRow23(position));
        startDate.setText(getWorksheet.getRow24(position));
        endDate.setText(getWorksheet.getRow25(position));
        startTime.setText(getWorksheet.getRow26(position));
        endTime.setText(getWorksheet.getRow27(position));
        numberOfPeople.setText(getWorksheet.getRow28(position));
        work.setText(getWorksheet.getRow29(position));
        contact.setText(getWorksheet.getRow30(position));
        email.setText(getWorksheet.getRow31(position));
        phone.setText(getWorksheet.getRow32(position));
        imgHostelPic.setImageBitmap(stringToBitmap(getWorksheet.getRow21(position)));

        hostelNum = getWorksheet.getRow45(position);
        hostelOwnerAccount = getWorksheet.getRow31(position);

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