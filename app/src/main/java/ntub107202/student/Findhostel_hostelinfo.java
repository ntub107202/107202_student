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
    public TextView TextView0001, TextView0002, TextView0003, TextView0004, TextView0005;
    public ImageView TextView0007;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.findhostel_hostelinfo);

        TextView0001 = (TextView) findViewById(R.id.txt_hostel_name);
        TextView0002 = (TextView) findViewById(R.id.txt_hostel_addr);
        TextView0003 = (TextView) findViewById(R.id.txt_number_people);
        TextView0004 = (TextView) findViewById(R.id.txt_days);
        TextView0005 = (TextView) findViewById(R.id.txt_skill);
        TextView0007 = (ImageView) findViewById(R.id.imageView_hostel_pic);

        Intent intent = getIntent();
        String row1 = intent.getExtras().getString("row1");
        String row2 = intent.getExtras().getString("row2");
        String row3 = intent.getExtras().getString("row3");
        String row4 = intent.getExtras().getString("row4");
        String row5 = intent.getExtras().getString("row5");
        String row6 = intent.getExtras().getString("row6");

        Log.i("Log", "Register1:" + row1);
        Log.i("Log", "Register2:" + row2);
        Log.i("Log", "Register3:" + row3);
        Log.i("Log", "Register4:" + row4);
        Log.i("Log", "Register5:" + row5);
        Log.i("Log", "Register6:" + row6);



        TextView0001.setText(row1);
        TextView0002.setText(row2);
        TextView0003.setText(row3);
        //TextView0004.setText(row4);
        TextView0005.setText(row5);
        TextView0007.setImageBitmap(stringToBitmap(row6));

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
