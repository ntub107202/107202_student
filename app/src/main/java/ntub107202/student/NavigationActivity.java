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
    private Fragment_Findhostel fragmentOne;
    private Fragment_Forum fragmentTwo;
    private Fragment_Schedule fragmentThree;
    private Fragment_Personal fragmentFour;
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
        setContentView(R.layout.activity_navigation);
        init();
        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }
    //init（）用来初始化组件
    private void init(){
        fragmentOne=new Fragment_Findhostel();
        fragmentTwo=new Fragment_Forum();
        fragmentThree=new Fragment_Schedule();
        fragmentFour=new Fragment_Personal();
        FragmentTransaction beginTransaction=getFragmentManager().beginTransaction();
        beginTransaction.add(R.id.content,fragmentOne).add(R.id.content,fragmentTwo).add(R.id.content,fragmentThree).add(R.id.content,fragmentFour);//开启一个事务将fragment动态加载到组件
        beginTransaction.hide(fragmentOne).hide(fragmentTwo).hide(fragmentThree).hide(fragmentFour);//隐藏fragment
        beginTransaction.addToBackStack(null);//返回到上一个显示的fragment
        beginTransaction.commit();//每一个事务最后操作必须是commit（），否则看不见效果
        showNav(R.id.navigation_bnb);
    }
    private void showNav(int navid){
        FragmentTransaction beginTransaction=getFragmentManager().beginTransaction();
        switch (navid){
            case R.id.navigation_bnb:
                beginTransaction.hide(fragmentTwo).hide(fragmentThree).hide(fragmentFour);
                beginTransaction.show(fragmentOne);
                beginTransaction.addToBackStack(null);
                beginTransaction.commit();
                break;
            case R.id.navigation_forum:
                beginTransaction.hide(fragmentOne).hide(fragmentThree).hide(fragmentFour);
                beginTransaction.show(fragmentTwo);
                beginTransaction.addToBackStack(null);
                beginTransaction.commit();
                break;
            case R.id.navigation_schedule:
                beginTransaction.hide(fragmentTwo).hide(fragmentOne).hide(fragmentFour);
                beginTransaction.show(fragmentThree);
                beginTransaction.addToBackStack(null);
                beginTransaction.commit();
                break;
            case R.id.navigation_student:
                beginTransaction.hide(fragmentOne).hide(fragmentTwo).hide(fragmentThree);
                beginTransaction.show(fragmentFour);
                beginTransaction.addToBackStack(null);
                beginTransaction.commit();
                break;
        }
    }
}
