package ntub107202.student;

import android.app.Fragment;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ntub107202.student.Schedule.bean.DateEntity;
import ntub107202.student.Schedule.view.DataView;

public class Fragment_Schedule extends Fragment {
    private DataView dataView ;
    private TextView info ;

    static TextView textView4;
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
    MyAdapter myAdapter;
    static LinearLayoutManager layoutManager;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_schedule,container,false);
        textView30 = (TextView)view.findViewById(R.id.text001);
        textView4 = (TextView)view.findViewById(R.id.text4);
        mList = (RecyclerView)view.findViewById(R.id.list_view);

        if (getWorksheet.getRow10(0) != null) {
            textView30.setVisibility(View.INVISIBLE);
        }
        Date date = new Date();
        SimpleDateFormat bartDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String str = bartDateFormat.format(date);

        info = (TextView)view.findViewById(R.id.info);
        dataView = (DataView)view.findViewById(R.id.week);
        dataView.getData("");

        return view;
    }

    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if(hidden){
            //pause
        }else{
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


            myAdapter = new MyAdapter(myDataset);

            textView4.setVisibility(View.VISIBLE);
            for(int i = 0; i < getWorksheet.scheduleLength; i++){
                myDataset.add(getWorksheet.getRow9(i));
                myDataset2.add(getWorksheet.getRow10(i));
                myDataset3.add(getWorksheet.getRow11(i));
                myDataset4.add(getWorksheet.getRow12(i));
                myDataset5.add(getWorksheet.getRow8(i));
            }



//            mList = (RecyclerView)view.findViewById(R.id.list_view);
            layoutManager = new LinearLayoutManager(getActivity());
            layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            mList.setLayoutManager(layoutManager);
            mList.setAdapter(myAdapter);
            //resume
        }
    }

    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
        private List<String> mData;

        public class ViewHolder extends RecyclerView.ViewHolder {
            public TextView TextView0001, TextView0002 ,TextView0003, TextView0004,TextView0005,TextView33;

            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            public ViewHolder(View v) {
                super(v);
                TextView0001 = (TextView) v.findViewById(R.id.textView0001);
                TextView0002 = (TextView) v.findViewById(R.id.textView0002);
                TextView0003 = (TextView) v.findViewById(R.id.textView0003);
                TextView0004 = (TextView) v.findViewById(R.id.textView0004);
                TextView0005 = (TextView) v.findViewById(R.id.textView0005);
                TextView33 = (TextView) v.findViewById(R.id.textView33);

                TextView33.setOnClickListener(new View.OnClickListener() {
                    Boolean flag = true;
                    @Override
                    public void onClick(View v) {
                        if (flag) {
                            flag = false;
                            TextView0002.setMaxLines(5);
                            TextView0002.setEllipsize(null); // 展开
                            TextView33.setText("摺疊內容");
                        } else {
                            flag = true;
                            TextView0002.setLines(1);
                            TextView0002.setEllipsize(TextUtils.TruncateAt.END); // 收缩
                            TextView33.setText("查看更多");
                        }
                    }
                });

            }

        }

        public MyAdapter(List<String> data) {
            mData = data;
        }

        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
        @Override
        public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.schedule_item, parent, false);
            ViewHolder vh = new ViewHolder(v);

            dataView.setOnSelectListener(new DataView.OnSelectListener() {
                @Override
                public void onSelected(DateEntity date) {
                    textView4.setVisibility(View.GONE);
                    myDataset.clear();
                    myDataset2.clear();
                    myDataset3.clear();
                    myDataset4.clear();
                    myDataset5.clear();
                    myDataset6.clear();
                    myDataset7.clear();
                    myDataset8.clear();
                    myDataset9.clear();
                    myDataset10.clear();
                    for(int i = 0; i < getWorksheet.scheduleLength; i++){
                        myDataset.add(getWorksheet.getRow9(i));
                        myDataset2.add(getWorksheet.getRow10(i));
                        myDataset3.add(getWorksheet.getRow11(i));
                        myDataset4.add(getWorksheet.getRow12(i));
                        myDataset5.add(getWorksheet.getRow8(i));
                        Log.v("555",myDataset5.get(i)+"%5");
                    }
                    Log.v("555",date.date+"date999");
                    for (int i = 0; i < getWorksheet.scheduleLength; i++) {
                        if (myDataset5.get(i).equals(date.date)) {
                            myDataset6.add(myDataset.get(i));
                            myDataset7.add(myDataset2.get(i));
                            myDataset8.add(myDataset3.get(i));
                            myDataset9.add(myDataset4.get(i));
                            myDataset10.add(myDataset5.get(i));
//                            Log.v("555",myDataset10.get(i)+"%10");
                        }
                    }
                    if(myDataset10.size() == 0){
                        myDataset.clear();
                        myDataset2.clear();
                        myDataset3.clear();
                        myDataset4.clear();
                        myDataset5.clear();
                        myDataset6.clear();
                        myDataset7.clear();
                        myDataset8.clear();
                        myDataset9.clear();
                        myDataset10.clear();
                        layoutManager = new LinearLayoutManager(getActivity());
                        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                        mList.setLayoutManager(layoutManager);
                        mList.setAdapter(myAdapter);
                        textView30.setVisibility(View.VISIBLE);
                    }
                    else {
                        int j = myDataset10.size();
                        Log.v("555", myDataset5.size() + "88");
                        myDataset.clear();
                        myDataset2.clear();
                        myDataset3.clear();
                        myDataset4.clear();
                        myDataset5.clear();
                        Log.v("555", myDataset6.get(0) + "88");
                        for (int i = 0; i < j; i++) {
                            myDataset.add(myDataset6.get(i));
                            myDataset2.add(myDataset7.get(i));
                            myDataset3.add(myDataset8.get(i));
                            myDataset4.add(myDataset9.get(i));
                            myDataset5.add(myDataset10.get(i));
                            Log.v("555", myDataset5.get(i) + "gg");
                        }
                        layoutManager = new LinearLayoutManager(getActivity());
                        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                        mList.setLayoutManager(layoutManager);
                        mList.setAdapter(myAdapter);
                        textView30.setVisibility(View.GONE);

                    }
                }
            });

            return vh;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {

            holder.TextView0001.setText(mData.get(position));
            holder.TextView0002.setText(myDataset2.get(position));
            holder.TextView0003.setText(myDataset3.get(position));
            holder.TextView0004.setText(myDataset4.get(position));
            holder.TextView0005.setText(myDataset5.get(position));

        }

        @Override
        public int getItemCount() {
            return mData.size();
        }

    }
}
