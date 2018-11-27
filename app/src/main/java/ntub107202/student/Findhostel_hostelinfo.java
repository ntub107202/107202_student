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

import android.content.pm.ActivityInfo;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import ntub107202.student.player.YoutubePlayerView;

public class Findhostel_hostelinfo extends AppCompatActivity {
    public TextView hostelName, hostelAddr, jobTitle, salary, startDate,
            endDate, startTime, endTime, numberOfPeople, work,
            contact, email, phone;
    public ImageView imgHostelPic;
    public String hostelNum, hostelOwnerAccount;
    public Button btnResume;

    private Context mContext;

    //參數
    private ViewPager mViewPager;

    //假資料


    private List<YoutubePlayerView> playerViewList;//一个页面可以播放多个视频，将所有的播放控件收集到这里进行维护，主要是控制离开页面时候的暂停
    //定位到youtube的某个视频有三种方式
    public static final String VideoUrl_normal = "https://www.youtube.com/watch?v=DTt7CDJqAa0";//这种是最普通的写在地址栏中的视频地址
    public static final String VideoUrl_embed = "https://www.youtube.com/embed/0xtcWek2tcM";//这种是分享嵌入式的视频地址
    public static final String VideoUrl_short = "https://youtu.be/wQ5Gj0UB_R8";//分享到facebook等社交平台的短url
    private View mVideoProgressView;
    private View mCustomView;//全屏显示的View
    private View mVideoFullScreenBack;
    private LinearLayout ll_player_container;
    private int mOriginalSystemUiVisibility;
    private int mOriginalOrientation;
    private WebChromeClient.CustomViewCallback mCustomViewCallback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.findhostel_hostelinfo);

        mContext = this;
        mViewPager = (ViewPager) findViewById(R.id.view_pager);

        //假資料
        List<String> mUrlList = new ArrayList<>();
        mUrlList.add("http://mh.sfacg.com/Logo/201201/fe5df43e-f699-4d7b-85c0-3876dee217cb.jpg");
        mUrlList.add("http://cdn.makeuseof.com/wp-content/uploads/2017/05/android-apps-eat-battery-670x335.jpg");
        mUrlList.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSpSWJ32XK7TcLUT2XpXTrzwHMOiKHJkzD7QodGrhRzfvRn35Z4mg");
        mUrlList.add("http://android.suvenconsultants.com/newimage/android-developer2.png");

        //呼叫Adapter
        BannerAdapter bannerAdapter = new BannerAdapter(this, mUrlList);
        mViewPager.setAdapter(bannerAdapter);

        String videoUrl = VideoUrl_normal;
        String videoID = YoutubePlayerView.parseIDfromVideoUrl(videoUrl);
        Log.i("Alex","视频的ID是=="+videoID);
        View youtubeView = LayoutInflater.from(this).inflate(R.layout.layout_youtube_player, null);
        YoutubePlayerView youtubePlayerView = (YoutubePlayerView) youtubeView.findViewById(R.id.youtubePlayerView);
        youtubePlayerView.setAutoPlayerHeight(this);
        youtubePlayerView.initialize(videoID, new YoutubePlayerCallBack(youtubePlayerView), mWebChromeClient);
        mVideoFullScreenBack = findViewById(R.id.detail_video_back);
        if(playerViewList == null){
            playerViewList = new ArrayList<>();
        }
        ll_player_container = (LinearLayout) findViewById(R.id.ll_player_container);
        ll_player_container.addView(youtubeView);
        playerViewList.add(youtubePlayerView);

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

    class BannerAdapter extends PagerAdapter {

        private LayoutInflater mInflater;
        private List<String> mUrlList;

        //建構子
        public BannerAdapter(Context context, List<String> mUrlList) {
            //如果把這個寫在instantiateItem的話，每一個Item都會呼叫一次，很吃資源
            mInflater = LayoutInflater.from(context);
            this.mUrlList = mUrlList;
        }

        //看你這ViewPager要有幾頁，靠著List的大小擴充
        @Override
        public int getCount() {
            //如果陣列為空，返回0 防呆機制
            return mUrlList == null ? 0 : mUrlList.size();
        }

        //用來判斷目前的畫面是否和instantiateItem創建的為同一個
        @Override
        public boolean isViewFromObject(View view, Object o) {
            return o == view;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            //每一個Item都創建View
            View view = mInflater.inflate(R.layout.main_viewpager, container, false);
            ImageView imageView = (ImageView) view.findViewById(R.id.image);

            //用Glide下載圖片
            Glide.with(mContext)
                    .load(mUrlList.get(position))
                    .error(R.drawable.image_loading)
                    .placeholder(R.drawable.image_loading)
                    .centerCrop()
                    .fitCenter()
                    .diskCacheStrategy(DiskCacheStrategy.RESULT)
                    .into(imageView);
            container.addView(view);
            return view;
        }

        //移除ViewPager內所對應的視圖
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }

    protected void onStart() {
        super.onStart();
    }
    private class YoutubePlayerCallBack implements YoutubePlayerView.YouTubeListener {

        private YoutubePlayerView mYoutubeView;

        YoutubePlayerCallBack(YoutubePlayerView view){
            this.mYoutubeView = view;
        }

        @Override
        public void onReady() {
        }

        @Override
        public void onStateChange(YoutubePlayerView.STATE state) {
            if(state == YoutubePlayerView.STATE.PLAYING && mYoutubeView!=null){
                if(playerViewList!=null){
                    for(YoutubePlayerView v : playerViewList){
                        if (v != null && v != mYoutubeView && (v.getPlayerState() == YoutubePlayerView.STATE.PLAYING ||
                                v.getPlayerState() == YoutubePlayerView.STATE.PAUSED)) {
                            v.stop();
                        }
                    }
                }
            }
        }

        @Override
        public void onPlaybackQualityChange(String arg) {
        }

        @Override
        public void onPlaybackRateChange(String arg) {

        }

        @Override
        public void onError(String arg) {
        }

        @Override
        public void onApiChange(String arg) {
        }

        @Override
        public void onCurrentSecond(double second) {
        }

        @Override
        public void onDuration(double duration) {
        }

        @Override
        public void logs(String log) {
        }
    }

    /**
     * 用于全屏显示的代码
     */
    private WebChromeClient mWebChromeClient = new WebChromeClient(){

        @Override
        public View getVideoLoadingProgressView() {
            if (mVideoProgressView == null) {
                LayoutInflater inflater = LayoutInflater.from(Findhostel_hostelinfo.this);
                mVideoProgressView = inflater.inflate(R.layout.video_layout_loading, null);
            }
            return mVideoProgressView;
        }

        @Override
        public void onShowCustomView(View view, WebChromeClient.CustomViewCallback callback) {
            // if a view already exists then immediately terminate the new one
            if (mCustomView != null) {
                onHideCustomView();
                return;
            }

            // 1. Stash the current state
            mCustomView = view;
            mOriginalSystemUiVisibility = Findhostel_hostelinfo.this.getWindow().getDecorView().getSystemUiVisibility();
            mOriginalOrientation = Findhostel_hostelinfo.this.getRequestedOrientation();
            Log.i("Alex","原来的屏幕方向是"+mOriginalOrientation);
            // 2. Stash the custom view callback
            mCustomViewCallback = callback;

            // 3. Add the custom view to the view hierarchy
            FrameLayout decor = (FrameLayout) Findhostel_hostelinfo.this.getWindow().getDecorView();
            decor.addView(mCustomView, new FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT));
            if(mVideoFullScreenBack!=null){
                mVideoFullScreenBack.setVisibility(View.VISIBLE);
            }

            // 4. Change the state of the window
            Findhostel_hostelinfo.this.getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                            View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                            View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                            View.SYSTEM_UI_FLAG_FULLSCREEN |
                            View.SYSTEM_UI_FLAG_IMMERSIVE);
            Findhostel_hostelinfo.this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }

        @Override
        public void onHideCustomView() {
            // 1. Remove the custom view
            FrameLayout decor = (FrameLayout) Findhostel_hostelinfo.this.getWindow().getDecorView();
            decor.removeView(mCustomView);
            mCustomView = null;
            if(mVideoFullScreenBack!=null){
                mVideoFullScreenBack.setVisibility(View.GONE);
            }

            // 2. Restore the state to it's original form
            Findhostel_hostelinfo.this.getWindow().getDecorView().setSystemUiVisibility(mOriginalSystemUiVisibility);
            Findhostel_hostelinfo.this.setRequestedOrientation(mOriginalOrientation);

            // 3. Call the custom view callback
            if(mCustomViewCallback!=null){
                mCustomViewCallback.onCustomViewHidden();
                mCustomViewCallback = null;
            }

        }
    };

    @Override
    public void onPause() {
        //视频播放器当页面停止的时候所有的视频播放全部暂停
        if(playerViewList!=null){
            for(YoutubePlayerView v : playerViewList){
                if(v.getPlayerState() == YoutubePlayerView.STATE.PLAYING ){
                    v.pause();
                }else if(v.getPlayerState() == YoutubePlayerView.STATE.BUFFERING){
                    v.stop();
                }
            }
        }
        super.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (playerViewList != null) {
            for (YoutubePlayerView v : playerViewList) {
                if (v != null) v.onDestroy();
            }
        }
    }
    public boolean closeFullScreen(){
        if(mCustomView!=null && mCustomViewCallback!=null){
            mWebChromeClient.onHideCustomView();
            return true;
        }
        return false;
    }

    @Override
    public void onBackPressed() {
        Log.i("Alex", "进入onBackPressed方法");
        closeFullScreen();
        super.onBackPressed();
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