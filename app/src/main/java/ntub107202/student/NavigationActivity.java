package ntub107202.student;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class NavigationActivity extends AppCompatActivity {
    private TextView mTextMessage;
    private Fragment_Findhostel Fragment1_Findhostel;
    private Fragment_Forum Fragment2_Forum;
    private Fragment_Inbox Fragment3_Inbox;
    private Fragment_Schedule Fragment4_Schedule;
    private Fragment_Personal Fragment5_Personal;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_bnb:
                    mTextMessage.setText(R.string.title_bnb);
                    showNav(R.id.navigation_bnb);
                    return true;
                case R.id.navigation_forum:
                    mTextMessage.setText(R.string.title_forum);
                    showNav(R.id.navigation_forum);
                    return true;
                case R.id.navigation_inbox:
                    mTextMessage.setText(R.string.inbox);
                    showNav(R.id.navigation_inbox);
                    return true;
                case R.id.navigation_schedule:
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
        getWorksheet.getscheduleJSON();
        getWorksheet.getForumJSON();
        getWorksheet.getHostelJSON();
        setContentView(R.layout.activity_navigation);
        init();
        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
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
