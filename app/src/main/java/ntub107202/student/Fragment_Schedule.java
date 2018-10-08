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

import java.util.ArrayList;
import java.util.List;

import ntub107202.student.Schedule.bean.DateEntity;
import ntub107202.student.Schedule.view.DataView;

public class Fragment_Schedule extends Fragment {
    private DataView dataView ;
    private TextView info ;

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
    MyAdapter myAdapter;
    static LinearLayoutManager layoutManager;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_schedule,container,false);
        textView30 = (TextView)view.findViewById(R.id.text001);
        mList = (RecyclerView)view.findViewById(R.id.list_view);

        if (getWorksheet.getRow10(0) != null) {
            textView30.setVisibility(View.INVISIBLE);
        }


        info = (TextView)view.findViewById(R.id.info);
        dataView = (DataView)view.findViewById(R.id.week);
        dataView.setOnSelectListener(new DataView.OnSelectListener() {
            @Override
            public void onSelected(DateEntity date) {
                info.setText("日期："+ date.date+"\n"+
                        "周幾："+ date.weekName+"\n"+
                        "今日："+ date.isToday+"\n"+
                        "時間戳："+ date.million+"\n");
                Log.e("wenzhiao--------------",date.toString());
            }
        });
        dataView.getData("2018-10-1");
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
            myAdapter = new MyAdapter(myDataset);
            for(int i = 0; i < getWorksheet.scheduleLength; i++){
//                myDataset.add(i + "");
                myDataset.add(getWorksheet.getRow9(i));
                myDataset2.add(getWorksheet.getRow10(i));
                myDataset3.add(getWorksheet.getRow11(i));
                myDataset4.add(getWorksheet.getRow12(i));
                Log.d("get0000", String.valueOf(getWorksheet.scheduleLength)+"calendarLength_resume");
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
            public TextView TextView0001, TextView0002 ,TextView0003, TextView0004,TextView33;

            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            public ViewHolder(View v) {
                super(v);
                TextView0001 = (TextView) v.findViewById(R.id.textView0001);
                TextView0002 = (TextView) v.findViewById(R.id.textView0002);
                TextView0003 = (TextView) v.findViewById(R.id.textView0003);
                TextView0004 = (TextView) v.findViewById(R.id.textView0004);
                TextView33 = (TextView) v.findViewById(R.id.textView33);

                TextView33.setOnClickListener(new View.OnClickListener() {
                    Boolean flag = true;
                    @Override
                    public void onClick(View v) {
                        if (flag) {
                            flag = false;
                            TextView0002.setMaxLines(5);
                            TextView0002.setEllipsize(null); // 展开
                            TextView33.setText("... 摺疊內容");
                        } else {
                            flag = true;
                            TextView0002.setLines(1);
                            TextView0002.setEllipsize(TextUtils.TruncateAt.END); // 收缩
                            TextView33.setText("... 查看更多");
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
            return vh;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.TextView0001.setText(mData.get(position));
            holder.TextView0002.setText(myDataset2.get(position));
            holder.TextView0003.setText(myDataset3.get(position));
            holder.TextView0004.setText(myDataset4.get(position));
        }

        @Override
        public int getItemCount() {
            return mData.size();
        }


    }
}
