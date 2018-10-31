package ntub107202.student;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;
import android.app.DatePickerDialog;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;

public class Personal_AddResume extends AppCompatActivity {
    private Button startCameraButton = null;
    private Button choiceFromAlbumButton = null;
    private ImageView pictureImageView = null;

    private static final int TAKE_PHOTO_PERMISSION_REQUEST_CODE = 0; // 拍照的权限处理返回码
    private static final int WRITE_SDCARD_PERMISSION_REQUEST_CODE = 1; // 读储存卡内容的权限处理返回码

    private static final int TAKE_PHOTO_REQUEST_CODE = 3; // 拍照返回的 requestCode
    private static final int CHOICE_FROM_ALBUM_REQUEST_CODE = 4; // 相册选取返回的 requestCode
    private static final int CROP_PHOTO_REQUEST_CODE = 5; // 裁剪图片返回的 requestCode

    private Uri photoUri = null;
    private Uri photoOutputUri = null; // 图片最终的输出文件的 Uri

    private EditText start_date, start_time, end_date, end_time;
    private int mYear, mMonth, mDay;

    EditText edit_name;
    RadioButton rad_men;
    RadioButton rad_women;
    EditText edit_birth;
    Spinner spin_address;
    Spinner spin_area;
    EditText edit_address;
    EditText edit_school;
    EditText edit_depart;
    RadioButton rad_study;
    RadioButton rad_graduate;
    RadioButton rad_industry;
    EditText edit_interest;
    CheckBox chk_og;
    CheckBox chk_rs;
    CheckBox chk_cr;
    CheckBox chk_rc;
    CheckBox chk_od;
    CheckBox chk_web;
    CheckBox chk_art;
    CheckBox chk_photograph;
    CheckBox chk_gardening;
    CheckBox chk_cook;
    CheckBox chk_motorcycle;
    CheckBox chk_car;
    CheckBox chk_dance;
    CheckBox chk_sing;
    CheckBox chk_music;
    CheckBox chk_english;
    CheckBox chk_japanese;
    CheckBox chk_minnan;
    EditText edit_work_exp;
    EditText edit_reason;
    RadioButton rad_veg;
    RadioButton rad_forag;
    EditText edit_start_date;
    EditText edit_end_date;
    EditText edit_contact;
    EditText edit_phone;

    Button btn_add_resume;

    String chk_og_S,chk_rs_S,chk_cr_S,chk_rc_S,chk_od_S,chk_web_S,chk_art_S,chk_photograph_S,chk_gardening_S,chk_cook_S,chk_motorcycle_S,chk_car_S,chk_dance_S,chk_sing_S,chk_music_S,chk_english_S,chk_japanese_S,chk_minnan_S;
    String rad_men_S,rad_women_S,rad_study_S,rad_graduate_S,rad_industry_S,rad_veg_S,rad_forag_S;

    private static String pic1;
    private static String pic2;

    private ImageButton imageButton1 = null;
    private ImageView choiceFromAlbumButton2 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_addresume);

        edit_name = (EditText) findViewById(R.id.edit_name);
        rad_men = (RadioButton) findViewById(R.id.rad_men);
        rad_women = (RadioButton) findViewById(R.id.rad_women);
        edit_birth = (EditText) findViewById(R.id.edit_birth);

        edit_birth.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                showDatePickerDialogBirth();
            }
        });

        spin_address = (Spinner) findViewById(R.id.spin_address);
        spin_area = (Spinner) findViewById(R.id.spin_area);
        edit_address = (EditText) findViewById(R.id.edit_address);
        edit_school = (EditText) findViewById(R.id.edit_school);
        edit_depart = (EditText) findViewById(R.id.edit_depart);
        rad_study = (RadioButton) findViewById(R.id.rad_study);
        rad_graduate = (RadioButton) findViewById(R.id.rad_graduate);
        rad_industry = (RadioButton) findViewById(R.id.rad_industry);
        edit_interest = (EditText) findViewById(R.id.edit_interest);
        chk_og = (CheckBox) findViewById(R.id.chk_og);
        chk_rs = (CheckBox) findViewById(R.id.chk_rs);
        chk_cr = (CheckBox) findViewById(R.id.chk_cr);
        chk_rc = (CheckBox) findViewById(R.id.chk_rc);
        chk_od = (CheckBox) findViewById(R.id.chk_od);
        chk_web = (CheckBox) findViewById(R.id.chk_web);
        chk_art = (CheckBox) findViewById(R.id.chk_art);
        chk_photograph = (CheckBox) findViewById(R.id.chk_photograph);
        chk_gardening = (CheckBox) findViewById(R.id.chk_gardening);
        chk_cook = (CheckBox) findViewById(R.id.chk_cook);
        chk_motorcycle = (CheckBox) findViewById(R.id.chk_motorcycle);
        chk_car = (CheckBox) findViewById(R.id.chk_car);
        chk_dance = (CheckBox) findViewById(R.id.chk_dance);
        chk_sing = (CheckBox) findViewById(R.id.chk_sing);
        chk_music = (CheckBox) findViewById(R.id.chk_music);
        chk_english = (CheckBox) findViewById(R.id.chk_english);
        chk_japanese = (CheckBox) findViewById(R.id.chk_japanese);
        chk_minnan = (CheckBox) findViewById(R.id.chk_minnan);
        edit_work_exp = (EditText) findViewById(R.id.edit_work_exp);
        edit_reason = (EditText) findViewById(R.id.edit_reason);
        rad_veg = (RadioButton) findViewById(R.id.rad_veg);
        rad_forag = (RadioButton) findViewById(R.id.rad_forag);
        edit_start_date = (EditText) findViewById(R.id.edit_start_date);

        edit_start_date.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                showDatePickerDialogStart();
            }
        });

        edit_end_date = (EditText) findViewById(R.id.edit_end_date);

        edit_end_date.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                showDatePickerDialogEnd();
            }
        });

        edit_contact = (EditText) findViewById(R.id.edit_contact);
        edit_phone = (EditText) findViewById(R.id.edit_phone);
        btn_add_resume = (Button) findViewById(R.id.btn_add_resume);

        btn_add_resume.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v){
                if (chk_og.isChecked()){
                    chk_og_S = "1";
                }
                else{
                    chk_og_S = "0";
                }
                if (chk_rs.isChecked()){
                    chk_rs_S = "1";
                }
                else{
                    chk_rs_S = "0";
                }
                if (chk_cr.isChecked()){
                    chk_cr_S = "1";
                }
                else{
                    chk_cr_S = "0";
                }
                if (chk_rc.isChecked()){
                    chk_rc_S = "1";
                }
                else{
                    chk_rc_S = "0";
                }
                if (chk_od.isChecked()){
                    chk_od_S = "1";
                }
                else{
                    chk_od_S = "0";
                }
                if (chk_web.isChecked()){
                    chk_web_S = "1";
                }
                else{
                    chk_web_S = "0";
                }
                if (chk_art.isChecked()){
                    chk_art_S = "1";
                }
                else{
                    chk_art_S = "0";
                }
                if (chk_photograph.isChecked()){
                    chk_photograph_S = "1";
                }
                else{
                    chk_photograph_S = "0";
                }
                if (chk_gardening.isChecked()){
                    chk_gardening_S = "1";
                }
                else{
                    chk_gardening_S = "0";
                }
                if (chk_cook.isChecked()){
                    chk_cook_S = "1";
                }
                else{
                    chk_cook_S = "0";
                }
                if (chk_motorcycle.isChecked()){
                    chk_motorcycle_S = "1";
                }
                else{
                    chk_motorcycle_S = "0";
                }
                if (chk_car.isChecked()){
                    chk_car_S = "1";
                }
                else{
                    chk_car_S = "0";
                }
                if (chk_dance.isChecked()){
                    chk_dance_S = "1";
                }
                else{
                    chk_dance_S = "0";
                }
                if (chk_sing.isChecked()){
                    chk_sing_S = "1";
                }
                else{
                    chk_sing_S = "0";
                }
                if (chk_music.isChecked()){
                    chk_music_S = "1";
                }
                else{
                    chk_music_S = "0";
                }
                if (chk_english.isChecked()){
                    chk_english_S = "1";
                }
                else{
                    chk_english_S = "0";
                }
                if (chk_japanese.isChecked()){
                    chk_japanese_S = "1";
                }
                else{
                    chk_japanese_S = "0";
                }
                if (chk_minnan.isChecked()){
                    chk_minnan_S = "1";
                }
                else{
                    chk_minnan_S = "0";
                }
                if (rad_men.isChecked()){
                    rad_men_S = "1";
                }
                else{
                    rad_men_S = "0";
                }
                if (rad_women.isChecked()){
                    rad_women_S = "1";
                }
                else{
                    rad_women_S = "0";
                }
                if (rad_study.isChecked()){
                    rad_study_S = "1";
                }
                else{
                    rad_study_S = "0";
                }
                if (rad_graduate.isChecked()){
                    rad_graduate_S = "1";
                }
                else{
                    rad_graduate_S = "0";
                }
                if (rad_industry.isChecked()){
                    rad_industry_S = "1";
                }
                else{
                    rad_industry_S = "0";
                }
                if (rad_veg.isChecked()){
                    rad_veg_S = "1";
                }
                else{
                    rad_veg_S = "0";
                }
                if (rad_forag.isChecked()){
                    rad_forag_S = "1";
                }
                else{
                    rad_forag_S = "0";
                }

//                Log.v("rad_men_S",rad_men_S);
//                Log.v("rad_women_S",rad_women_S);
//                Log.v("8888888", spin_address.getSelectedItem().toString());
//                Log.v("8888888", spin_area.getSelectedItem().toString());
//                Log.v("8888888", pic1);
//                Log.v("8888888", pic2);

            }
        });


        startCameraButton = (Button) findViewById(R.id.button8);
        startCameraButton.setOnClickListener(clickListener);
        choiceFromAlbumButton = (Button) findViewById(R.id.button7);
        choiceFromAlbumButton.setOnClickListener(clickListener);
        pictureImageView = (ImageView) findViewById(R.id.imageView10);
        choiceFromAlbumButton2 = (ImageView) findViewById(R.id.imageView6);
        choiceFromAlbumButton2.setOnClickListener(clickListener);

        //计算图片左右间距之和
        int padding = 15;
        int spacePx = (int) (UIUtil.dp2px(this, padding) * 2);
        //计算图片宽度
        int imageWidth = UIUtil.getScreenWidth(this) - spacePx;
        //计算宽高比，注意数字后面要加上f表示浮点型数字
        float scale = 16f / 9f;
        float scale2 = 16f / 9f;
        //根据图片宽度和比例计算图片高度
        int imageHeight = (int) (imageWidth / scale);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(imageWidth, imageHeight);
        //设置左右边距
        params.leftMargin = (int) UIUtil.dp2px(this, padding);
        params.rightMargin = (int) UIUtil.dp2px(this, padding);
        choiceFromAlbumButton2.setLayoutParams(params);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);



        /*
         * 先判断用户以前有没有对我们的应用程序允许过读写内存卡内容的权限，
         * 用户处理的结果在 onRequestPermissionResult 中进行处理
         */
        if (ContextCompat.checkSelfPermission(Personal_AddResume.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            // 申请读写内存卡内容的权限
            ActivityCompat.requestPermissions(Personal_AddResume.this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, WRITE_SDCARD_PERMISSION_REQUEST_CODE);
        }

        final Spinner spin_address = (Spinner)findViewById(R.id.spin_address);
        final Spinner spin_area = (Spinner)findViewById(R.id.spin_area);
        final String[] Keelung = {"仁愛區","中正區","信義區","中山區","安樂區","暖暖區","七堵區"};
        final String[] Taipei = {"中正區","大同區","中山區","松山區","大安區","萬華區","信義區","士林區","北投區","內湖區","南港區","文山區"};
        final String[] NewTaipei = {"板橋區","新莊區","中和區","永和區","土城區","樹林區","三峽區","鶯歌區","三重區","蘆洲區","五股區","泰山區","林口區","八里區","淡水區","三芝區","石門區","金山區","萬里區","汐止區","瑞芳區","貢寮區","平溪區","雙溪區","新店區","深坑區","石碇區","坪林","烏來區"};
        final String[] Taoyuan = {"桃園區","中壢區","平鎮區","八德區","楊梅區","蘆竹區","大溪區","龍潭區","龜山區","大園區","觀音區","新屋區","復興區"};
        final String[] Hsinchu = {"東區","北區","香山區"};
        final String[] Hsinchu2 = {"竹北市","竹東鎮","新埔鎮","關西鎮","湖口鄉","新豐鄉","峨眉鄉","寶山鄉","北埔鄉","芎林鄉","橫山鄉","尖石鄉","五峰鄉"};
        final String[] Miaoli = {"苗栗市","頭份市","竹南鎮","後龍鎮","通霄鎮","苑裡鎮","卓蘭鎮","造橋鄉","西湖鄉","頭屋鄉","公館鄉","銅鑼鄉","三義鄉","大湖鄉","獅潭鄉","三灣鄉","南庄鄉","泰安鄉"};
        final String[] Taichung = {"中區","東區","南區","西區","北區","北屯區","西屯區","南屯區","太平區","大里區","霧峰區","烏日區","豐原區","后里區","石岡區","東勢區","新社區","潭子區","大雅區","神岡區","大肚區","沙鹿區","龍井區","梧棲區","清水區","大甲區","外埔區","大安區","和平區"};
        final String[] Nantou = {"南投市","埔里鎮","草屯鎮","竹山鎮","集集鎮","名間鄉","鹿谷鄉","中寮鄉","魚池鄉","國姓鄉","水里鄉","信義鄉","仁愛鄉"};
        final String[] Changhua = {"彰化市","員林市","和美鎮","鹿港鎮","溪湖鎮","二林鎮","田中鎮","北斗鎮","花壇鄉","芬園鄉","大村鄉","永靖鄉","伸港鄉","線西鄉","福興鄉","秀水鄉","埔心鄉","埔鹽鄉","大城鄉","芳苑鄉","竹塘鄉","社頭鄉","二水鄉","田尾鄉","埤頭鄉","溪州鄉"};
        final String[] Yunlin = {"斗六市","斗南鎮","虎尾鎮","西螺鎮","土庫鎮","北港鎮","林內鄉","古坑鄉","大埤鄉","莿桐鄉","褒忠鄉","二崙鄉","崙背鄉","麥寮鄉","臺西鄉","東勢鄉","元長鄉","四湖鄉","口湖鄉","水林鄉"};
        final String[] Chiayi = {"東區","西區"};
        final String[] Chiayi2 = {"太保市","朴子市","布袋鎮","大林鎮","民雄鄉","溪口鄉","新港鄉","六腳鄉","東石鄉","義竹鄉","鹿草鄉","水上鄉","中埔鄉","竹崎鄉","梅山鄉","番路鄉","大埔鄉","阿里山鄉"};
        final String[] Tainan = {"中西區","東區","南區","北區","安平區","安南區","永康區","歸仁區","新化區","左鎮區","玉井區","楠西區","南化區","仁德區","關廟區","龍崎區","官田區","麻豆區","佳里區","西港區","七股區","將軍區","學甲區","北門區","新營區","後壁區","白河區","東山區","六甲區","下營區","柳營區","鹽水區","善化區","大內區","山上區","新市區","安定區"};
        final String[] Kaohsiung = {"楠梓區","左營區","鼓山區","三民區","鹽埕區","前金區","新興區","苓雅區","前鎮區","旗津區","小港區","鳳山區","大寮區","鳥松區","林園區","仁武區","大樹區","大社區","岡山區","路竹區","橋頭區","梓官區","彌陀區","永安區","燕巢區","田寮區","阿蓮區","茄萣區","湖內區","旗山區","美濃區","內門區","杉林區","甲仙區","六龜區","茂林區","桃源區","那瑪夏區"};
        final String[] Pingtung = {"屏東市","潮州鎮","東港鎮","恆春鎮","萬丹鄉","長治鄉","麟洛鄉","九如鄉","里港鄉","鹽埔鄉","高樹鄉","萬巒鄉","內埔鄉","竹田鄉","新埤鄉","枋寮鄉","新園鄉","崁頂鄉","林邊鄉","南州鄉","佳冬鄉","琉球鄉","車城鄉","滿州鄉","枋山鄉","霧臺鄉","瑪家鄉","泰武鄉","來義鄉","春日鄉","獅子鄉","牡丹鄉","三地門鄉"};
        final String[] Yilan = {"宜蘭市","頭城鎮","羅東鎮","蘇澳鎮","礁溪鄉","壯圍鄉","員山鄉","冬山鄉","五結鄉","三星鄉","大同鄉","南澳鄉"};
        final String[] Hualien  = {"花蓮市","鳳林鎮","玉里鎮","新城鄉","吉安鄉","壽豐鄉","光復鄉","豐濱鄉","瑞穗鄉","富里鄉","秀林鄉","萬榮鄉","卓溪鄉"};
        final String[] Taitung = {"臺東市","成功鎮","關山鎮","長濱鄉","池上鄉","東河鄉","鹿野鄉","卑南鄉","大武鄉","綠島鄉","太麻里鄉","海端鄉","延平鄉","金峰鄉","達仁鄉","蘭嶼鄉"};
        final String[] Penghu = {"馬公市","湖西鄉","白沙鄉","西嶼鄉","望安鄉","七美鄉"};
        final String[] Kinmen = {"金城鎮","金湖鎮","金沙鎮","金寧鄉","烈嶼鄉","烏坵鄉"};
        final String[] Lienchiang = {"南竿鄉","北竿鄉","莒光鄉","東引鄉"};

        spin_address.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Personal_AddResume.this, "你選的是" + spin_address.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                switch (spin_address.getSelectedItem().toString()) {
                    case "基隆市":
                        ArrayAdapter<String> KeelungList = new ArrayAdapter<>(Personal_AddResume.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                Keelung);
                        spin_area.setAdapter(KeelungList);
                        break;
                    case "台北市":
                        ArrayAdapter<String> TaipeiList = new ArrayAdapter<>(Personal_AddResume.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                Taipei);
                        spin_area.setAdapter(TaipeiList);
                        break;
                    case "新北市":
                        ArrayAdapter<String> NewTaipeiList = new ArrayAdapter<>(Personal_AddResume.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                NewTaipei);
                        spin_area.setAdapter(NewTaipeiList);
                        break;
                    case "桃園市":
                        ArrayAdapter<String> TaoyuanList = new ArrayAdapter<>(Personal_AddResume.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                Taoyuan);
                        spin_area.setAdapter(TaoyuanList);
                        break;
                    case "新竹市":
                        ArrayAdapter<String> HsinchuList = new ArrayAdapter<>(Personal_AddResume.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                Hsinchu);
                        spin_area.setAdapter(HsinchuList);
                        break;
                    case "新竹縣":
                        ArrayAdapter<String> Hsinchu2List = new ArrayAdapter<>(Personal_AddResume.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                Hsinchu2);
                        spin_area.setAdapter(Hsinchu2List);
                        break;
                    case "苗栗縣":
                        ArrayAdapter<String> MiaoliList = new ArrayAdapter<>(Personal_AddResume.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                Miaoli);
                        spin_area.setAdapter(MiaoliList);
                        break;
                    case "台中市":
                        ArrayAdapter<String> TaichungList = new ArrayAdapter<>(Personal_AddResume.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                Taichung);
                        spin_area.setAdapter(TaichungList);
                        break;
                    case "南投縣":
                        ArrayAdapter<String> NantouList = new ArrayAdapter<>(Personal_AddResume.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                Nantou);
                        spin_area.setAdapter(NantouList);
                        break;
                    case "彰化縣":
                        ArrayAdapter<String> ChanghuaList = new ArrayAdapter<>(Personal_AddResume.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                Changhua);
                        spin_area.setAdapter(ChanghuaList);
                        break;
                    case "雲林縣":
                        ArrayAdapter<String> YunlinList = new ArrayAdapter<>(Personal_AddResume.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                Yunlin);
                        spin_area.setAdapter(YunlinList);
                        break;
                    case "嘉義市":
                        ArrayAdapter<String> ChiayiList = new ArrayAdapter<>(Personal_AddResume.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                Chiayi);
                        spin_area.setAdapter(ChiayiList);
                        break;
                    case "嘉義縣":
                        ArrayAdapter<String> Chiayi2List = new ArrayAdapter<>(Personal_AddResume.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                Chiayi2);
                        spin_area.setAdapter(Chiayi2List);
                        break;
                    case "台南市":
                        ArrayAdapter<String> TainanList = new ArrayAdapter<>(Personal_AddResume.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                Tainan);
                        spin_area.setAdapter(TainanList);
                        break;
                    case "高雄市":
                        ArrayAdapter<String> KaohsiungList = new ArrayAdapter<>(Personal_AddResume.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                Kaohsiung);
                        spin_area.setAdapter(KaohsiungList);
                        break;
                    case "屏東縣":
                        ArrayAdapter<String> PingtungList = new ArrayAdapter<>(Personal_AddResume.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                Pingtung);
                        spin_area.setAdapter(PingtungList);
                        break;
                    case "宜蘭縣":
                        ArrayAdapter<String> YilanList = new ArrayAdapter<>(Personal_AddResume.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                Yilan);
                        spin_area.setAdapter(YilanList);
                        break;
                    case "花蓮縣":
                        ArrayAdapter<String> HualienList = new ArrayAdapter<>(Personal_AddResume.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                Hualien);
                        spin_area.setAdapter(HualienList);
                        break;
                    case "台東縣":
                        ArrayAdapter<String> TaitungList = new ArrayAdapter<>(Personal_AddResume.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                Taitung);
                        spin_area.setAdapter(TaitungList);
                        break;
                    case "澎湖縣":
                        ArrayAdapter<String> PenghuList = new ArrayAdapter<>(Personal_AddResume.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                Penghu);
                        spin_area.setAdapter(PenghuList);
                        break;
                    case "金門縣":
                        ArrayAdapter<String> KinmenList = new ArrayAdapter<>(Personal_AddResume.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                Kinmen);
                        spin_area.setAdapter(KinmenList);
                        break;
                    case "連江縣":
                        ArrayAdapter<String> LienchiangList = new ArrayAdapter<>(Personal_AddResume.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                Lienchiang);
                        spin_area.setAdapter(LienchiangList);
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }


    public void showDatePickerDialogBirth() {
        // 設定初始日期
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        // 跳出日期選擇器
        DatePickerDialog dpd = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        // 完成選擇，顯示日期
                        edit_birth.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);

                    }
                }, mYear, mMonth, mDay);
        dpd.show();
    }

    public void showDatePickerDialogStart() {
        // 設定初始日期
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        // 跳出日期選擇器
        DatePickerDialog dpd = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        // 完成選擇，顯示日期
                        edit_start_date.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);

                    }
                }, mYear, mMonth, mDay);
        dpd.show();
    }

    public void showDatePickerDialogEnd() {
        // 設定初始日期
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        // 跳出日期選擇器
        DatePickerDialog dpd = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        // 完成選擇，顯示日期
                        edit_end_date.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);

                    }
                }, mYear, mMonth, mDay);
        dpd.show();
    }


    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // 调用相机拍照
            if (v == startCameraButton) {
                // 同上面的权限申请逻辑
                if (ContextCompat.checkSelfPermission(Personal_AddResume.this, Manifest.permission.CAMERA)
                        != PackageManager.PERMISSION_GRANTED) {
                    /*
                     * 下面是对调用相机拍照权限进行申请
                     */
                    ActivityCompat.requestPermissions(Personal_AddResume.this,
                            new String[]{Manifest.permission.CAMERA,}, TAKE_PHOTO_PERMISSION_REQUEST_CODE);
                } else {
                    startCamera();
                }
                // 从相册获取
            } else if (v == choiceFromAlbumButton) {
                choiceFromAlbum();
            } else if (v == choiceFromAlbumButton2) {
                choiceFromAlbum2();
            }
        }
    };

    /**
     * 拍照
     */
    private void startCamera() {
        /**
         * 设置拍照得到的照片的储存目录，因为我们访问应用的缓存路径并不需要读写内存卡的申请权限，
         * 因此，这里为了方便，将拍照得到的照片存在这个缓存目录中
         */
        File file = new File(getExternalCacheDir(), "image.jpg");
        try {
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        /**
         * 因 Android 7.0 开始，不能使用 file:// 类型的 Uri 访问跨应用文件，否则报异常，
         * 因此我们这里需要使用内容提供器，FileProvider 是 ContentProvider 的一个子类，
         * 我们可以轻松的使用 FileProvider 来在不同程序之间分享数据(相对于 ContentProvider 来说)
         */
        if (Build.VERSION.SDK_INT >= 24) {
            photoUri = FileProvider.getUriForFile(this, "com.zhi_dian.provider", file);
        } else {
            photoUri = Uri.fromFile(file); // Android 7.0 以前使用原来的方法来获取文件的 Uri
        }
        // 打开系统相机的 Action，等同于："android.media.action.IMAGE_CAPTURE"
        Intent takePhotoIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // 设置拍照所得照片的输出目录
        takePhotoIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
        startActivityForResult(takePhotoIntent, TAKE_PHOTO_REQUEST_CODE);
    }

    /**
     * 从相册选取
     */
    private void choiceFromAlbum() {
        // 打开系统图库的 Action，等同于: "android.intent.action.GET_CONTENT"
        Intent choiceFromAlbumIntent = new Intent(Intent.ACTION_GET_CONTENT);
        // 设置数据类型为图片类型
        choiceFromAlbumIntent.setType("image/*");
        startActivityForResult(choiceFromAlbumIntent, CHOICE_FROM_ALBUM_REQUEST_CODE);
    }

    private void choiceFromAlbum2() {
        // 打开系统图库的 Action，等同于: "android.intent.action.GET_CONTENT"
        Intent choiceFromAlbumIntent = new Intent(Intent.ACTION_GET_CONTENT);
        // 设置数据类型为图片类型
        choiceFromAlbumIntent.setType("image/*");
        startActivityForResult(choiceFromAlbumIntent, 6);
    }

    /**
     * 裁剪图片
     */
    private void cropPhoto(Uri inputUri) {
        // 调用系统裁剪图片的 Action
        Intent cropPhotoIntent = new Intent("com.android.camera.action.CROP");
        // 设置数据Uri 和类型
        cropPhotoIntent.setDataAndType(inputUri, "image/*");
        cropPhotoIntent.putExtra("crop", "true");
        // 裁剪框的比例，1：1
        cropPhotoIntent.putExtra("aspectX", 1);
        cropPhotoIntent.putExtra("aspectY", 1);
        // 裁剪后输出图片的尺寸大小
        cropPhotoIntent.putExtra("outputX", 500);
        cropPhotoIntent.putExtra("outputY", 500);
        // 授权应用读取 Uri，这一步要有，不然裁剪程序会崩溃
        cropPhotoIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        // 设置图片的最终输出目录
        cropPhotoIntent.putExtra(MediaStore.EXTRA_OUTPUT,
                photoOutputUri = Uri.parse("file:////sdcard/image_output.jpg"));
        startActivityForResult(cropPhotoIntent, CROP_PHOTO_REQUEST_CODE);
    }

    private void cropPhoto2(Uri inputUri) {
        // 调用系统裁剪图片的 Action
        Intent cropPhotoIntent = new Intent("com.android.camera.action.CROP");
        // 设置数据Uri 和类型
        cropPhotoIntent.setDataAndType(inputUri, "image/*");
        // 授权应用读取 Uri，这一步要有，不然裁剪程序会崩溃
        cropPhotoIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        // 设置图片的最终输出目录
        cropPhotoIntent.putExtra(MediaStore.EXTRA_OUTPUT,
                photoOutputUri = Uri.parse("file:////sdcard/image_output.jpg"));
        startActivityForResult(cropPhotoIntent, 7);
    }

    /**
     * 在这里进行用户权限授予结果处理
     *
     * @param requestCode  权限要求码，即我们申请权限时传入的常量
     * @param permissions  保存权限名称的 String 数组，可以同时申请一个以上的权限
     * @param grantResults 每一个申请的权限的用户处理结果数组(是否授权)
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            // 调用相机拍照：
            case TAKE_PHOTO_PERMISSION_REQUEST_CODE:
                // 如果用户授予权限，那么打开相机拍照
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    startCamera();
                } else {
                    Toast.makeText(this, "拍照权限被拒绝", Toast.LENGTH_SHORT).show();
                }
                break;
            // 打开相册选取：
            case WRITE_SDCARD_PERMISSION_REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                } else {
                    Toast.makeText(this, "读写内存卡内容权限被拒绝", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    /**
     * 通过这个 activity 启动的其他 Activity 返回的结果在这个方法进行处理
     * 我们在这里对拍照、相册选择图片、裁剪图片的返回结果进行处理
     *
     * @param requestCode 返回码，用于确定是哪个 Activity 返回的数据
     * @param resultCode  返回结果，一般如果操作成功返回的是 RESULT_OK
     * @param data        返回对应 activity 返回的数据
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            // 通过返回码判断是哪个应用返回的数据
            switch (requestCode) {
                // 拍照
                case TAKE_PHOTO_REQUEST_CODE:
                    cropPhoto(photoUri);
                    break;
                // 相册选择
                case CHOICE_FROM_ALBUM_REQUEST_CODE:
                    cropPhoto(data.getData());
                    break;
                // 裁剪图片
                case CROP_PHOTO_REQUEST_CODE:
                    File file = new File(photoOutputUri.getPath());
                    if (file.exists()) {
                        Bitmap bitmap = BitmapFactory.decodeFile(photoOutputUri.getPath());
                        pictureImageView.setImageBitmap(bitmap);
//                        file.delete(); // 选取完后删除照片
                    } else {
                        Toast.makeText(this, "找不到照片", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case 6:
                    cropPhoto2(data.getData());
                    break;
                // 裁剪图片
                case 7:
                    File file2 = new File(photoOutputUri.getPath());
                    if (file2.exists()) {
                        Bitmap bitmap = BitmapFactory.decodeFile(photoOutputUri.getPath());
                        BitmapToString2(bitmap);
                        choiceFromAlbumButton2.setImageBitmap(bitmap);
//                        file.delete(); // 选取完后删除照片
                    } else {
                        Toast.makeText(this, "找不到照片", Toast.LENGTH_SHORT).show();
                    }
                    break;
            }
        }
    }

    public static String BitmapToString(Bitmap bitmap) {
        String des = null;
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);
            out.flush();
            out.close();
            byte[] buffer = out.toByteArray();
            byte[] encode = Base64.encode(buffer, Base64.DEFAULT);
            des = new String(encode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        pic1 = des;
        return des;
    }

    public static String BitmapToString2(Bitmap bitmap) {
        String des = null;
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);
            out.flush();
            out.close();
            byte[] buffer = out.toByteArray();
            byte[] encode = Base64.encode(buffer, Base64.DEFAULT);
            des = new String(encode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        pic2 = des;
        return des;
    }
}


