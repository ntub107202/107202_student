package ntub107202.student;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class Findhostel_hostelinfo extends AppCompatActivity {
    public TextView TextView0001, TextView0002, TextView0003, TextView0004, TextView0005,
    TextView0006, TextView0007, TextView0008, TextView0009, TextView0010,
            TextView0011, TextView0012, TextView0013;
    public ImageView TextView0014;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.findhostel_hostelinfo);

        TextView0001 = (TextView) findViewById(R.id.txt_hostel_name);
        TextView0002 = (TextView) findViewById(R.id.txt_hostel_addr);
        TextView0003 = (TextView) findViewById(R.id.txt_job_title);
        TextView0004 = (TextView) findViewById(R.id.txt_salary);
        TextView0005 = (TextView) findViewById(R.id.start_date);
        TextView0006 = (TextView) findViewById(R.id.end_date);
        TextView0007 = (TextView) findViewById(R.id.startTime);
        TextView0008 = (TextView) findViewById(R.id.endTime);
        TextView0009 = (TextView) findViewById(R.id.txt_number_people);
        TextView0010 = (TextView) findViewById(R.id.txt_work);
        TextView0011 = (TextView) findViewById(R.id.txt_contact);
        TextView0012 = (TextView) findViewById(R.id.txt_email);
        TextView0013 = (TextView) findViewById(R.id.txt_phone);
        TextView0014 = (ImageView) findViewById(R.id.imageView_hostel_pic);


        Intent intent = getIntent();
        String row1 = intent.getExtras().getString("hostelName");
        String row2 = intent.getExtras().getString("hostelAddress");
        String row3 = intent.getExtras().getString("hostelPhoto");
        String row4 = intent.getExtras().getString("vacancyName");
        String row5 = intent.getExtras().getString("vacancySalary");
        String row6 = intent.getExtras().getString("vacancyStartDate");
        String row7 = intent.getExtras().getString("vacancyEndDate");
        String row8 = intent.getExtras().getString("vacancyStartTime");
        String row9 = intent.getExtras().getString("vacancEndTime");
        String row10 = intent.getExtras().getString("vacancyNumPeople");
        String row11 = intent.getExtras().getString("vacancyJob");
        String row12 = intent.getExtras().getString("hostelOwnerName");
        String row13 = intent.getExtras().getString("hostelOwnerAccount");
        String row14 = intent.getExtras().getString("hostelOwnerPhone");
        String row15 = intent.getExtras().getString("vacancyDays");

        Log.i("Log", "Register1:" + row1);
        Log.i("Log", "Register2:" + row2);
        Log.i("Log", "Register3:" + row3);
        Log.i("Log", "Register4:" + row4);
        Log.i("Log", "Register5:" + row5);
        Log.i("Log", "Register6:" + row6);
        Log.i("Log", "Register7:" + row7);


        TextView0001.setText(row1);
        TextView0002.setText(row2);
        TextView0003.setText(row4);
        TextView0004.setText(row5);
        TextView0005.setText(row6);
        TextView0006.setText(row7);
        TextView0007.setText(row8);
        TextView0008.setText(row9);
        TextView0009.setText(row10);
        TextView0010.setText(row11);
        TextView0011.setText(row12);
        TextView0012.setText(row13);
        TextView0013.setText(row14);
        TextView0014.setImageBitmap(stringToBitmap(row3));

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