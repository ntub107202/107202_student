package ntub107202.student;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Fragment_Findhostel extends Fragment {
    public String city, district;
    static TextView textView30;
    static TextView textView31;
    static TextView textView32;
    static TextView textView33;
    static TextView textView34;
    static String[] row = new String[100];
    static String row9;
    static String row10;
    static String row11;
    static String row12;
    RecyclerView mList;
    ArrayList<String> myDataset;
    ArrayList<String> myDataset2;
    ArrayList<String> myDataset3;
    ArrayList<String> myDataset4;
    ArrayList<String> myDataset5;
    ArrayList<String> myDataset6;
    ArrayList<String> myDataset7;
    ArrayList<String> myDataset8;
    ArrayList<String> myDataset9;
    ArrayList<String> myDataset10;
    ArrayList<String> myDataset11;
    ArrayList<String> myDataset12;
    ArrayList<String> myDataset13;
    ArrayList<String> myDataset14;
    ArrayList<String> myDataset15;
    ArrayList<String> myDataset16;
    ArrayList<String> myDataset17;
    MyAdapter myAdapter;

    static LinearLayoutManager layoutManager;

    Spinner spnCity;
    Spinner spnDistrict;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_findhostel, container, false);
        mList = (RecyclerView) view.findViewById(R.id.list_view);

        spnCity = (Spinner) view.findViewById(R.id.spinnerCity);
        spnDistrict = (Spinner) view.findViewById(R.id.spinnerDistrict);

        myDataset = new ArrayList<>();
        myDataset2 = new ArrayList<>();
        myDataset3 = new ArrayList<>();
        myDataset4 = new ArrayList<>();
        myDataset5 = new ArrayList<>();
        myDataset6 = new ArrayList<>();
        myDataset7 = new ArrayList<>();
        myDataset8 = new ArrayList<>();
        myDataset9 = new ArrayList<>();
        myDataset10 = new ArrayList<>();
        myDataset11 = new ArrayList<>();
        myDataset12 = new ArrayList<>();
        myDataset13 = new ArrayList<>();
        myDataset14 = new ArrayList<>();
        myDataset15 = new ArrayList<>();
        myDataset16 = new ArrayList<>();
        myDataset17 = new ArrayList<>();

        myAdapter = new MyAdapter(myDataset);
        for (int i = 0; i < getWorksheet.hostelLength; i++) {
//                myDataset.add(i + "");
            myDataset.add(getWorksheet.getRow19(i));
            myDataset2.add(getWorksheet.getRow20(i));
            myDataset3.add(getWorksheet.getRow21(i));
            myDataset4.add(getWorksheet.getRow22(i));
            myDataset5.add(getWorksheet.getRow23(i));
            myDataset6.add(getWorksheet.getRow24(i));
            myDataset7.add(getWorksheet.getRow25(i));
            myDataset8.add(getWorksheet.getRow26(i));
            myDataset9.add(getWorksheet.getRow27(i));
            myDataset10.add(getWorksheet.getRow28(i));
            myDataset11.add(getWorksheet.getRow29(i));
            myDataset12.add(getWorksheet.getRow30(i));
            myDataset13.add(getWorksheet.getRow31(i));
            myDataset14.add(getWorksheet.getRow32(i));
            myDataset15.add(getWorksheet.getRow33(i));
            myDataset16.add(getWorksheet.getRow34(i));
            myDataset17.add(getWorksheet.getRow35(i));

            Log.d("get5487", "fuckfuck" + myDataset17);
            Log.d("get0000", String.valueOf(getWorksheet.hostelLength) + "hostelLength_resume");
        }
//            mList = (RecyclerView)view.findViewById(R.id.list_view);
        layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mList.setLayoutManager(layoutManager);
        mList.setAdapter(myAdapter);

        final Spinner spnCity = (Spinner)view.findViewById(R.id.spinnerCity);
        final Spinner spnDistrict = (Spinner)view.findViewById(R.id.spinnerDistrict);
        //resume

        final String[][] cDistrict = {{"鄉鎮市區"},
                {"鄉鎮市區","仁愛區","中正區","信義區","中山區","安樂區","暖暖區","七堵區"},
                {"鄉鎮市區","中正區","大同區","中山區","松山區","大安區","萬華區","信義區","士林區","北投區","內湖區","南港區","文山區"},
                {"鄉鎮市區","板橋區","新莊區","中和區","永和區","土城區","樹林區","三峽區","鶯歌區","三重區","蘆洲區","五股區","泰山區","林口區","八里區","淡水區","三芝區","石門區","金山區","萬里區","汐止區","瑞芳區","貢寮區","平溪區","雙溪區","新店區","深坑區","石碇區","坪林","烏來區"},
                {"鄉鎮市區","桃園區","中壢區","平鎮區","八德區","楊梅區","蘆竹區","大溪區","龍潭區","龜山區","大園區","觀音區","新屋區","復興區"},
                {"鄉鎮市區","東區","北區","香山區"},
                {"鄉鎮市區","竹北市","竹東鎮","新埔鎮","關西鎮","湖口鄉","新豐鄉","峨眉鄉","寶山鄉","北埔鄉","芎林鄉","橫山鄉","尖石鄉","五峰鄉"},
                {"鄉鎮市區","苗栗市","頭份市","竹南鎮","後龍鎮","通霄鎮","苑裡鎮","卓蘭鎮","造橋鄉","西湖鄉","頭屋鄉","公館鄉","銅鑼鄉","三義鄉","大湖鄉","獅潭鄉","三灣鄉","南庄鄉","泰安鄉"},
                {"鄉鎮市區","中區","東區","南區","西區","北區","北屯區","西屯區","南屯區","太平區","大里區","霧峰區","烏日區","豐原區","后里區","石岡區","東勢區","新社區","潭子區","大雅區","神岡區","大肚區","沙鹿區","龍井區","梧棲區","清水區","大甲區","外埔區","大安區","和平區"},
                {"鄉鎮市區","南投市","埔里鎮","草屯鎮","竹山鎮","集集鎮","名間鄉","鹿谷鄉","中寮鄉","魚池鄉","國姓鄉","水里鄉","信義鄉","仁愛鄉"},
                {"鄉鎮市區","彰化市","員林市","和美鎮","鹿港鎮","溪湖鎮","二林鎮","田中鎮","北斗鎮","花壇鄉","芬園鄉","大村鄉","永靖鄉","伸港鄉","線西鄉","福興鄉","秀水鄉","埔心鄉","埔鹽鄉","大城鄉","芳苑鄉","竹塘鄉","社頭鄉","二水鄉","田尾鄉","埤頭鄉","溪州鄉"},
                {"鄉鎮市區","斗六市","斗南鎮","虎尾鎮","西螺鎮","土庫鎮","北港鎮","林內鄉","古坑鄉","大埤鄉","莿桐鄉","褒忠鄉","二崙鄉","崙背鄉","麥寮鄉","臺西鄉","東勢鄉","元長鄉","四湖鄉","口湖鄉","水林鄉"},
                {"鄉鎮市區","東區","西區"},
                {"鄉鎮市區","太保市","朴子市","布袋鎮","大林鎮","民雄鄉","溪口鄉","新港鄉","六腳鄉","東石鄉","義竹鄉","鹿草鄉","水上鄉","中埔鄉","竹崎鄉","梅山鄉","番路鄉","大埔鄉","阿里山鄉"},
                {"鄉鎮市區","中西區","東區","南區","北區","安平區","安南區","永康區","歸仁區","新化區","左鎮區","玉井區","楠西區","南化區","仁德區","關廟區","龍崎區","官田區","麻豆區","佳里區","西港區","七股區","將軍區","學甲區","北門區","新營區","後壁區","白河區","東山區","六甲區","下營區","柳營區","鹽水區","善化區","大內區","山上區","新市區","安定區"},
                {"鄉鎮市區","楠梓區","左營區","鼓山區","三民區","鹽埕區","前金區","新興區","苓雅區","前鎮區","旗津區","小港區","鳳山區","大寮區","鳥松區","林園區","仁武區","大樹區","大社區","岡山區","路竹區","橋頭區","梓官區","彌陀區","永安區","燕巢區","田寮區","阿蓮區","茄萣區","湖內區","旗山區","美濃區","內門區","杉林區","甲仙區","六龜區","茂林區","桃源區","那瑪夏區"},
                {"鄉鎮市區","屏東市","潮州鎮","東港鎮","恆春鎮","萬丹鄉","長治鄉","麟洛鄉","九如鄉","里港鄉","鹽埔鄉","高樹鄉","萬巒鄉","內埔鄉","竹田鄉","新埤鄉","枋寮鄉","新園鄉","崁頂鄉","林邊鄉","南州鄉","佳冬鄉","琉球鄉","車城鄉","滿州鄉","枋山鄉","霧臺鄉","瑪家鄉","泰武鄉","來義鄉","春日鄉","獅子鄉","牡丹鄉","三地門鄉"},
                {"鄉鎮市區","宜蘭市","頭城鎮","羅東鎮","蘇澳鎮","礁溪鄉","壯圍鄉","員山鄉","冬山鄉","五結鄉","三星鄉","大同鄉","南澳鄉"},
                {"鄉鎮市區","花蓮市","鳳林鎮","玉里鎮","新城鄉","吉安鄉","壽豐鄉","光復鄉","豐濱鄉","瑞穗鄉","富里鄉","秀林鄉","萬榮鄉","卓溪鄉"},
                {"鄉鎮市區","臺東市","成功鎮","關山鎮","長濱鄉","池上鄉","東河鄉","鹿野鄉","卑南鄉","大武鄉","綠島鄉","太麻里鄉","海端鄉","延平鄉","金峰鄉","達仁鄉","蘭嶼鄉"},
                {"鄉鎮市區","馬公市","湖西鄉","白沙鄉","西嶼鄉","望安鄉","七美鄉"},
                {"鄉鎮市區","金城鎮","金湖鎮","金沙鎮","金寧鄉","烈嶼鄉","烏坵鄉"},
                {"鄉鎮市區","南竿鄉","北竿鄉","莒光鄉","東引鄉"}};

        spnCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int pos = spnCity.getSelectedItemPosition();
                city = spnCity.getSelectedItem().toString();
                ArrayAdapter<String> cityDistrict = new ArrayAdapter<>(getActivity().getBaseContext(),
                        android.R.layout.simple_spinner_dropdown_item,
                        cDistrict[pos]);
                spnDistrict.setAdapter(cityDistrict);
                district = spnDistrict.getSelectedItem().toString();
                myAdapter.getFilter().filter(city);
                Toast.makeText(getActivity().getBaseContext(), "你選的是" + city + district, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spnDistrict.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                city = spnCity.getSelectedItem().toString();
                district = spnDistrict.getSelectedItem().toString();
                myAdapter.getFilter().filter(city);

                Toast.makeText(getActivity().getBaseContext(), "你選的是" + city + district, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        return view;
    }

    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden) {
            //pause
        } else {
            myDataset = new ArrayList<>();
            myDataset2 = new ArrayList<>();
            myDataset3 = new ArrayList<>();
            myDataset4 = new ArrayList<>();
            myDataset5 = new ArrayList<>();
            myDataset6 = new ArrayList<>();
            myDataset7 = new ArrayList<>();
            myDataset8 = new ArrayList<>();
            myDataset9 = new ArrayList<>();
            myDataset10 = new ArrayList<>();
            myDataset11 = new ArrayList<>();
            myDataset12 = new ArrayList<>();
            myDataset13 = new ArrayList<>();
            myDataset14 = new ArrayList<>();
            myDataset15 = new ArrayList<>();
            myDataset16 = new ArrayList<>();
            myDataset17 = new ArrayList<>();

            myAdapter = new MyAdapter(myDataset);
            for (int i = 0; i < getWorksheet.hostelLength; i++) {
//                myDataset.add(i + "");
                myDataset.add(getWorksheet.getRow19(i));
                myDataset2.add(getWorksheet.getRow20(i));
                myDataset3.add(getWorksheet.getRow21(i));
                myDataset4.add(getWorksheet.getRow22(i));
                myDataset5.add(getWorksheet.getRow23(i));
                myDataset6.add(getWorksheet.getRow24(i));
                myDataset7.add(getWorksheet.getRow25(i));
                myDataset8.add(getWorksheet.getRow26(i));
                myDataset9.add(getWorksheet.getRow27(i));
                myDataset10.add(getWorksheet.getRow28(i));
                myDataset11.add(getWorksheet.getRow29(i));
                myDataset12.add(getWorksheet.getRow30(i));
                myDataset13.add(getWorksheet.getRow31(i));
                myDataset14.add(getWorksheet.getRow32(i));
                myDataset15.add(getWorksheet.getRow33(i));
                myDataset16.add(getWorksheet.getRow34(i));
                myDataset17.add(getWorksheet.getRow35(i));
                Log.d("get00010","123456789" + getWorksheet.getRow34(i) );

                Log.d("get0000", String.valueOf(getWorksheet.hostelLength) + "hostelLength_resume");
            }
//            mList = (RecyclerView)view.findViewById(R.id.list_view);
            layoutManager = new LinearLayoutManager(getActivity());
            layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            mList.setLayoutManager(layoutManager);
            mList.setAdapter(myAdapter);
            //resume
        }
    }

    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>
            implements Filterable {
        private List<String> mData;
        private List<String> hostelName, hostelAddress, hostelPhoto, vacancyName, vacancySalary, vacancyStartDate, vacancyEndDate,
                vacancyStartTime, vacancEndTime, vacancyNumPeople, vacancyJob, hostelOwnerName, hostelOwnerAccount,
                hostelOwnerPhone, vacancyDays, star;
        private Context mContext;

        @Override
        public Filter getFilter() {
            return new Filter() {
                @Override
                protected FilterResults performFiltering(CharSequence charSequence) {
                    if(city.equals("選擇縣市") && district.equals("鄉鎮市區")){
                        hostelName = myDataset; //restore filtered list to full data
                        hostelAddress = myDataset2;
                        hostelPhoto = myDataset3;
                        vacancyName = myDataset4;
                        vacancyName = myDataset5;
                        vacancySalary = myDataset6;
                        vacancyStartDate = myDataset7;
                        vacancyEndDate = myDataset8;
                        vacancEndTime = myDataset9;
                        vacancyNumPeople = myDataset10;
                        vacancyJob = myDataset11;
                        hostelOwnerName = myDataset12;
                        hostelOwnerAccount = myDataset13;
                        hostelOwnerPhone = myDataset14;
                        vacancyDays = myDataset15;
                        star = myDataset16;


                    }else if(!city.equals("選擇縣市") && district.equals("鄉鎮市區")){
                        List<String> hName = new ArrayList<>();
                        List<String> hAddr = new ArrayList<>();
                        List<String> hPhoto = new ArrayList<>();
                        List<String> vName = new ArrayList<>();
                        List<String> vSal = new ArrayList<>();
                        List<String> vSDate = new ArrayList<>();
                        List<String> vEDate = new ArrayList<>();
                        List<String> vSTime = new ArrayList<>();
                        List<String> vETime = new ArrayList<>();
                        List<String> vNum = new ArrayList<>();
                        List<String> vJob = new ArrayList<>();
                        List<String> vDays = new ArrayList<>();
                        List<String> oName = new ArrayList<>();
                        List<String> oAcc = new ArrayList<>();
                        List<String> oPhone = new ArrayList<>();
                        List<String> mStar = new ArrayList<>();

                        for(int i = 0; i < getWorksheet.hostelLength; i++){
                            if(myDataset2.get(i).contains(city)) {
                                hName.add(mData.get(i));
                                hAddr.add(myDataset2.get(i));
                                hPhoto.add(myDataset3.get(i));
                                vName.add(myDataset4.get(i));
                                vSal.add(myDataset5.get(i));
                                vSDate.add(myDataset6.get(i));
                                vEDate.add(myDataset7.get(i));
                                vSTime.add(myDataset8.get(i));
                                vETime.add(myDataset9.get(i));
                                vNum.add(myDataset10.get(i));
                                vJob.add(myDataset11.get(i));
                                oName.add(myDataset12.get(i));
                                oAcc.add(myDataset13.get(i));
                                oPhone.add(myDataset14.get(i));
                                vDays.add(myDataset15.get(i));
                                mStar.add(myDataset16.get(i));
                            }
                        }
                        hostelName = hName;
                        hostelAddress = hAddr;
                        hostelPhoto = hPhoto;
                        vacancyName = vName;
                        vacancySalary = vSal;
                        vacancyStartDate = vSDate;
                        vacancyEndDate = vEDate;
                        vacancyStartTime = vSTime;
                        vacancEndTime = vETime;
                        vacancyNumPeople = vNum;
                        vacancyJob = vJob;
                        hostelOwnerName = oName;
                        hostelOwnerAccount = oAcc;
                        hostelOwnerPhone = oPhone;
                        vacancyDays = vDays;
                        star = mStar;

                    }else{
                        List<String> hName = new ArrayList<>();
                        List<String> hAddr = new ArrayList<>();
                        List<String> hPhoto = new ArrayList<>();
                        List<String> vName = new ArrayList<>();
                        List<String> vSal = new ArrayList<>();
                        List<String> vSDate = new ArrayList<>();
                        List<String> vEDate = new ArrayList<>();
                        List<String> vSTime = new ArrayList<>();
                        List<String> vETime = new ArrayList<>();
                        List<String> vNum = new ArrayList<>();
                        List<String> vJob = new ArrayList<>();
                        List<String> vDays = new ArrayList<>();
                        List<String> oName = new ArrayList<>();
                        List<String> oAcc = new ArrayList<>();
                        List<String> oPhone = new ArrayList<>();
                        List<String> mStar = new ArrayList<>();

                        for(int i = 0; i < getWorksheet.hostelLength; i++){
                            if(myDataset2.get(i).contains(city + district)) {
                                hName.add(mData.get(i));
                                hAddr.add(myDataset2.get(i));
                                hPhoto.add(myDataset3.get(i));
                                vName.add(myDataset4.get(i));
                                vSal.add(myDataset5.get(i));
                                vSDate.add(myDataset6.get(i));
                                vEDate.add(myDataset7.get(i));
                                vSTime.add(myDataset8.get(i));
                                vETime.add(myDataset9.get(i));
                                vNum.add(myDataset10.get(i));
                                vJob.add(myDataset11.get(i));
                                oName.add(myDataset12.get(i));
                                oAcc.add(myDataset13.get(i));
                                oPhone.add(myDataset14.get(i));
                                vDays.add(myDataset15.get(i));
                                mStar.add(myDataset16.get(i));
                            }
                        }
                        hostelName = hName;
                        hostelAddress = hAddr;
                        hostelPhoto = hPhoto;
                        vacancyName = vName;
                        vacancySalary = vSal;
                        vacancyStartDate = vSDate;
                        vacancyEndDate = vEDate;
                        vacancyStartTime = vSTime;
                        vacancEndTime = vETime;
                        vacancyNumPeople = vNum;
                        vacancyJob = vJob;
                        hostelOwnerName = oName;
                        hostelOwnerAccount = oAcc;
                        hostelOwnerPhone = oPhone;
                        vacancyDays = vDays;
                        star = mStar;
                    }
                    FilterResults filterResults = new FilterResults();
                    filterResults.values = hostelName;
                    return filterResults;
                }

                @Override
                protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                    hostelName = (ArrayList<String>)filterResults.values;
                    notifyDataSetChanged();
                }
            };
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public TextView TextViewHostelName, TextViewHostelAddr, TextViewNumPeople, TextViewDays,
                    TextViewSkill,TextViewHostelStar;
            public ImageView TextViewHostelPic;
            public ImageButton ib_popup_menu;
            public CardView cardView;

            public ViewHolder(View v) {
                super(v);
                TextViewHostelName = (TextView) v.findViewById(R.id.txt_hostel_name);
                TextViewHostelAddr = (TextView) v.findViewById(R.id.txt_hostel_addr);
                TextViewNumPeople = (TextView) v.findViewById(R.id.txt_number_people);
                TextViewDays = (TextView) v.findViewById(R.id.txt_days);
                TextViewSkill = (TextView) v.findViewById(R.id.txt_skill);
                TextViewHostelStar = (TextView) v.findViewById(R.id.txt_hostel_star);
                TextViewHostelPic = (ImageView) v.findViewById(R.id.img_S_pic);
                ib_popup_menu = (ImageButton) v.findViewById(R.id.ib_popup_menu);
                cardView = (CardView) v.findViewById(R.id.card_view_calender);
            }
        }

        public MyAdapter(List<String> data) {
            this.mData = data;
            this.hostelName = data;
            this.hostelAddress = myDataset2;
            this.hostelPhoto = myDataset3;
            this.vacancyName = myDataset4;
            this.vacancySalary = myDataset5;
            this.vacancyStartDate = myDataset6;
            this.vacancyEndDate = myDataset7;
            this.vacancyStartTime = myDataset8;
            this.vacancEndTime = myDataset9;
            this.vacancyNumPeople = myDataset10;
            this.vacancyJob = myDataset11;
            this.hostelOwnerName = myDataset12;
            this.hostelOwnerAccount = myDataset13;
            this.hostelOwnerPhone = myDataset14;
            this.vacancyDays = myDataset15;
            this.star = myDataset16;
        }


        @Override
        public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            mContext = parent.getContext();
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.findhostel_item, parent, false);
            MyAdapter.ViewHolder vh = new MyAdapter.ViewHolder(v);

            vh.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle=new Bundle();
                    bundle.putInt("position", vh.getAdapterPosition());
                    Intent i=new Intent();
                    i.putExtras(bundle);
                    i.setClass(mContext, Findhostel_hostelinfo.class);
                    mContext.startActivity(i);
                }
            });
            return vh;
        }

        @Override
        public void onBindViewHolder(final MyAdapter.ViewHolder holder, int position) {
            holder.TextViewHostelName.setText(hostelName.get(position));
            holder.TextViewHostelAddr.setText(hostelAddress.get(position));
            holder.TextViewNumPeople.setText(vacancyNumPeople.get(position));
            holder.TextViewDays.setText(vacancyDays.get(position));
            holder.TextViewSkill.setText(vacancyJob.get(position));
            holder.TextViewHostelStar.setText(star.get(position));
            holder.TextViewHostelPic.setImageBitmap(stringToBitmap(hostelPhoto.get(position)));
//
            holder.ib_popup_menu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    PopupMenu popupMenu = new PopupMenu(mContext,holder.ib_popup_menu);
                    popupMenu.inflate(R.menu.findhostel_popup_menu);
                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            switch (item.getItemId()){
                                case  R.id.menu_collection:
                                    Toast.makeText(mContext,"已收藏換宿",Toast.LENGTH_LONG).show();
                                    break;
                                default:
                                    break;
                            }
                            return false;
                        }
                    });
                    popupMenu.show();
                }
            });
        }

        @Override
        public int getItemCount() {
            return hostelName.size();
        }
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
