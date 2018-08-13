package ntub107202.student;


import android.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Fragment_Forum extends Fragment{
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
    MyAdapter myAdapter;
    static LinearLayoutManager layoutManager;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_forum,container,false);
        textView30 = (TextView)view.findViewById(R.id.text001);
        mList = (RecyclerView)view.findViewById(R.id.list_view);
        if (getWorksheet.getRow9(0) != null) {
            textView30.setVisibility(View.INVISIBLE);
        }
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
            myAdapter = new MyAdapter(myDataset);
            for(int i = 0; i < getWorksheet.forumLength; i++){
//                myDataset.add(i + "");
                myDataset.add(getWorksheet.getRow13(i));
                myDataset2.add(getWorksheet.getRow14(i));
                myDataset3.add(getWorksheet.getRow15(i));
                myDataset4.add(getWorksheet.getRow16(i));
                myDataset5.add(getWorksheet.getRow17(i));
                myDataset6.add(getWorksheet.getRow18(i));
                Log.d("get0000", String.valueOf(getWorksheet.forumLength)+"forumLength_resume");
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
            public TextView TextView0001, TextView0002 ,TextView0003, TextView0004 ,TextView0005;
            public  ImageView TextView0006;

            public ViewHolder(View v) {
                super(v);
                TextView0001 = (TextView) v.findViewById(R.id.textView0001);
                TextView0002 = (TextView) v.findViewById(R.id.textView0002);
                TextView0003 = (TextView) v.findViewById(R.id.textView0003);
                TextView0004 = (TextView) v.findViewById(R.id.textView0004);
                TextView0005 = (TextView) v.findViewById(R.id.textView0005);
                TextView0006 = (ImageView) v.findViewById(R.id.image000006);
            }
        }

        public MyAdapter(List<String> data) {
            mData = data;
        }


        @Override
        public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.forum_item, parent, false);
            MyAdapter.ViewHolder vh = new MyAdapter.ViewHolder(v);
            return vh;
        }

        @Override
        public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
            holder.TextView0001.setText(mData.get(position));
            holder.TextView0002.setText(myDataset2.get(position));
            holder.TextView0003.setText(myDataset3.get(position));
            holder.TextView0004.setText(myDataset4.get(position));
            holder.TextView0005.setText(myDataset5.get(position));
            holder.TextView0006.setImageBitmap(stringToBitmap(myDataset6.get(position)));
        }

        @Override
        public int getItemCount() {
            return mData.size();
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
