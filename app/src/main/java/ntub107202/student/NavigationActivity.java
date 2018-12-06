package ntub107202.student;

import android.app.ActivityManager;
import android.app.FragmentTransaction;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class NavigationActivity extends AppCompatActivity {
    private TextView mTextMessage;
    private Fragment_Findhostel Fragment1_Findhostel;
    private Fragment_Forum Fragment2_Forum;
    private Fragment_Inbox Fragment3_Inbox;
    private Fragment_Schedule Fragment4_Schedule;
    private Fragment_Personal Fragment5_Personal;
    BottomNavigationView navigation;
    private int TIME = 3000;
    private int x  = 5 ;
    private int y  = 5 ;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_bnb:
                    getWorksheet.getHostelJSON();
                    mTextMessage.setText(R.string.title_bnb);
                    showNav(R.id.navigation_bnb);
                    return true;
                case R.id.navigation_forum:
                    getWorksheet.getForumJSON();
//                    getWorksheet.getStudentnameJSON();
                    mTextMessage.setText(R.string.title_forum);
                    showNav(R.id.navigation_forum);
                    return true;
                case R.id.navigation_inbox:
                    mTextMessage.setText(R.string.inbox);
                    showNav(R.id.navigation_inbox);
                    return true;
                case R.id.navigation_schedule:
                    getWorksheet.getscheduleJSON();
                    mTextMessage.setText(R.string.title_schedule);
                    showNav(R.id.navigation_schedule);
                    return true;
                case R.id.navigation_student:
                    mTextMessage.setText(R.string.title_student);
                    showNav(R.id.navigation_student);
                    return true;
            }
            return false;
        }

    };
    public void onBackPressed() {
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        init();
        mTextMessage = (TextView) findViewById(R.id.message);
        int maxMemory = (int) Runtime.getRuntime().maxMemory();
        Log.i("给应用分配的最大内存是：",maxMemory+"");
        ActivityManager activityManager = (ActivityManager) (getSystemService(Context.ACTIVITY_SERVICE));
        int memorySize = activityManager.getMemoryClass();
        int largeMemorySize = activityManager.getLargeMemoryClass();
        Log.i("memorySize内存是：",maxMemory+"");
        Log.i("largeMemorySize内存是：",maxMemory+"");
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setPositiveButton("點擊關閉", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        if(y==1){
            final AlertDialog dialog = builder.create();
            LayoutInflater inflater = getLayoutInflater();
            View dialogLayout = inflater.inflate(R.layout.ad_banner, null);
            dialog.setView(dialogLayout);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

            dialog.show();

            dialog.setOnShowListener(new DialogInterface.OnShowListener() {
                @Override
                public void onShow(DialogInterface d) {
                    ImageView image = (ImageView) dialog.findViewById(R.id.goProDialogImage);
                    Bitmap icon = BitmapFactory.decodeResource(getResources(),
                            R.drawable.ad2);
                    float imageWidthInPX = (float)image.getWidth();

                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(Math.round(imageWidthInPX),
                            Math.round(imageWidthInPX * (float)icon.getHeight() / (float)icon.getWidth()));
                    image.setLayoutParams(layoutParams);


                }
            });
            y=0;
        }

        Handler handler = new Handler();
        // 在初始化方法里.
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    handler.postDelayed(this, TIME);
                    getWorksheet.getResumeJSON();
                    if (getWorksheet.getRow50(0) != null) {
                        alarm();
                    }


                    Log.i("print","1-------------");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        handler.postDelayed(runnable, TIME);

    }
    public void cleanshit(){
        SharedPreferences pref = getSharedPreferences("userpwS", MODE_PRIVATE);
        pref.edit()
                .clear()
                .commit();
    }
    public void alarm(){
        if (x==5) {
            NotificationManager mNotificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

            //Step2. 設定當按下這個通知之後要執行的activity
            Intent notifyIntent = new Intent(NavigationActivity.this, NavigationActivity.class);
            notifyIntent.setFlags( Intent.FLAG_ACTIVITY_NEW_TASK);
            PendingIntent appIntent = PendingIntent.getActivity(NavigationActivity.this, 0, notifyIntent, 0);
            Notification notification
                    = new Notification.Builder(NavigationActivity.this)
                    .setContentIntent(appIntent)
                    .setSmallIcon(R.drawable.logo2) // 設置狀態列裡面的圖示（小圖示）　　
                    .setLargeIcon(BitmapFactory.decodeResource(NavigationActivity.this.getResources(), R.drawable.logo1)) // 下拉下拉清單裡面的圖示（大圖示）
                    .setTicker("notification on status bar.") // 設置狀態列的顯示的資訊
                    .setWhen(System.currentTimeMillis())// 設置時間發生時間
                    .setAutoCancel(false) // 設置通知被使用者點擊後是否清除  //notification.flags = Notification.FLAG_AUTO_CANCEL;
                    .setContentTitle("一家順順") // 設置下拉清單裡的標題
                    .setContentText("來自"+getWorksheet.getRow50(0)+"的請求")// 設置上下文內容
                    .setOngoing(true)      //true使notification变为ongoing，用户不能手动清除  // notification.flags = Notification.FLAG_ONGOING_EVENT; notification.flags = Notification.FLAG_NO_CLEAR;

                    .setDefaults(Notification.DEFAULT_ALL) //使用所有默認值，比如聲音，震動，閃屏等等
                    .setDefaults(Notification.DEFAULT_VIBRATE) //使用默認手機震動提示
                    .setDefaults(Notification.DEFAULT_SOUND) //使用默認聲音提示
                    .setDefaults(Notification.DEFAULT_LIGHTS) //使用默認閃光提示
                    .setDefaults(Notification.DEFAULT_LIGHTS | Notification.DEFAULT_SOUND) //使用默認閃光提示 與 默認聲音提示

//                 .setVibrate(vibrate) //自訂震動長度
//                 .setSound(uri) //自訂鈴聲
                    .setLights(0xff00ff00, 300, 1000) //自訂燈光閃爍 (ledARGB, ledOnMS, ledOffMS)
                    .build();

//把指定ID的通知持久的發送到狀態條上
            notification.flags = Notification.FLAG_ONGOING_EVENT;

            // 表明在點擊了通知欄中的"清除通知"後，此通知不清除，
            // 經常與FLAG_ONGOING_EVENT一起使用
            notification.flags = Notification.FLAG_NO_CLEAR;

            //閃爍燈光
            notification.flags = Notification.FLAG_SHOW_LIGHTS;

            // 重複的聲響,直到用戶響應。
            notification.flags = Notification.FLAG_INSISTENT;


            // 把指定ID的通知持久的發送到狀態條上.
            mNotificationManager.notify(0, notification);

            // 取消以前顯示的一個指定ID的通知.假如是一個短暫的通知，
            // 試圖將之隱藏，假如是一個持久的通知，將之從狀態列中移走.
//              mNotificationManager.cancel(0);

            //取消以前顯示的所有通知.
//              mNotificationManager.cancelAll();
            x=10;
        }
    }
    @Override
    public void onResume() {
        getWorksheet.getscheduleJSON();
        getWorksheet.getForumJSON();
        getWorksheet.getHostelJSON();
        getWorksheet.getStudentnameJSON();
        getWorksheet.getResumeJSON();
        int id = getIntent().getIntExtra("id", 0);
        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
        switch (id) {
            case 1:
                beginTransaction.hide(Fragment2_Forum).hide(Fragment3_Inbox).hide(Fragment4_Schedule).hide(Fragment5_Personal);
                beginTransaction.show(Fragment1_Findhostel);
                beginTransaction.addToBackStack(null);
                beginTransaction.commit();
                navigation.getMenu().getItem(0).setChecked(true);
                break;
            case 2:
                beginTransaction.hide(Fragment1_Findhostel).hide(Fragment3_Inbox).hide(Fragment4_Schedule).hide(Fragment5_Personal);
                beginTransaction.show(Fragment2_Forum);
                beginTransaction.addToBackStack(null);
                beginTransaction.commit();
                navigation.getMenu().getItem(1).setChecked(true);
                break;
            case 3:
                beginTransaction.hide(Fragment2_Forum).hide(Fragment1_Findhostel).hide(Fragment5_Personal).hide(Fragment4_Schedule);
                beginTransaction.show(Fragment3_Inbox);
                beginTransaction.addToBackStack(null);
                beginTransaction.commit();
                navigation.getMenu().getItem(2).setChecked(true);
                break;
            case 4:
                beginTransaction.hide(Fragment2_Forum).hide(Fragment3_Inbox).hide(Fragment1_Findhostel).hide(Fragment5_Personal);
                beginTransaction.show(Fragment4_Schedule);
                beginTransaction.addToBackStack(null);
                beginTransaction.commit();
                navigation.getMenu().getItem(2).setChecked(true);
                break;
            case 5:
                beginTransaction.hide(Fragment1_Findhostel).hide(Fragment2_Forum).hide(Fragment3_Inbox).hide(Fragment4_Schedule);
                beginTransaction.show(Fragment5_Personal);
                beginTransaction.addToBackStack(null);
                beginTransaction.commit();
                mTextMessage.setText("");
                navigation.getMenu().getItem(3).setChecked(true);
                break;
        }

        super.onResume();
    }
    //init（）用来初始化组件
    private void init(){
        Fragment1_Findhostel =new Fragment_Findhostel();
        Fragment2_Forum =new Fragment_Forum();
        Fragment3_Inbox = new Fragment_Inbox();
        Fragment4_Schedule =new Fragment_Schedule();
        Fragment5_Personal =new Fragment_Personal();
        FragmentTransaction beginTransaction=getFragmentManager().beginTransaction();
        beginTransaction.add(R.id.content, Fragment1_Findhostel).add(R.id.content, Fragment2_Forum).add(R.id.content, Fragment3_Inbox).add(R.id.content, Fragment4_Schedule).add(R.id.content, Fragment5_Personal);//开启一个事务将fragment动态加载到组件
        beginTransaction.hide(Fragment1_Findhostel).hide(Fragment2_Forum).hide(Fragment3_Inbox).hide(Fragment4_Schedule).hide(Fragment5_Personal);//隐藏fragment
        beginTransaction.addToBackStack(null);//返回到上一个显示的fragment
        beginTransaction.commit();//每一个事务最后操作必须是commit（），否则看不见效果
        showNav(R.id.navigation_bnb);
    }
    private void showNav(int navid){
        FragmentTransaction beginTransaction=getFragmentManager().beginTransaction();
        switch (navid){
            case R.id.navigation_bnb:
                beginTransaction.hide(Fragment2_Forum).hide(Fragment3_Inbox).hide(Fragment4_Schedule).hide(Fragment5_Personal);
                beginTransaction.show(Fragment1_Findhostel);
                beginTransaction.addToBackStack(null);
                beginTransaction.commit();
                break;
            case R.id.navigation_forum:
                beginTransaction.hide(Fragment1_Findhostel).hide(Fragment3_Inbox).hide(Fragment4_Schedule).hide(Fragment5_Personal);
                beginTransaction.show(Fragment2_Forum);
                beginTransaction.addToBackStack(null);
                beginTransaction.commit();
                break;
            case R.id.navigation_inbox:
                beginTransaction.hide(Fragment2_Forum).hide(Fragment4_Schedule).hide(Fragment1_Findhostel).hide(Fragment5_Personal);
                beginTransaction.show(Fragment3_Inbox);
                beginTransaction.addToBackStack(null);
                beginTransaction.commit();
                break;
            case R.id.navigation_schedule:
                beginTransaction.hide(Fragment2_Forum).hide(Fragment3_Inbox).hide(Fragment1_Findhostel).hide(Fragment5_Personal);
                beginTransaction.show(Fragment4_Schedule);
                beginTransaction.addToBackStack(null);
                beginTransaction.commit();
                break;
            case R.id.navigation_student:
                beginTransaction.hide(Fragment1_Findhostel).hide(Fragment2_Forum).hide(Fragment3_Inbox).hide(Fragment4_Schedule);
                beginTransaction.show(Fragment5_Personal);
                beginTransaction.addToBackStack(null);
                beginTransaction.commit();
                break;
        }
    }
}
