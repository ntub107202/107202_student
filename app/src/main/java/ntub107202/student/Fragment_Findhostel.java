package ntub107202.student;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Fragment_Findhostel extends Fragment {
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
    MyAdapter myAdapter;
    static LinearLayoutManager layoutManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_findhostel, container, false);
        mList = (RecyclerView) view.findViewById(R.id.list_view);
        myDataset = new ArrayList<>();
        myDataset2 = new ArrayList<>();
        myDataset3 = new ArrayList<>();
        myDataset4 = new ArrayList<>();
        myDataset5 = new ArrayList<>();
        myDataset6 = new ArrayList<>();
        myDataset7 = new ArrayList<>();
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
            Log.d("get0000", String.valueOf(getWorksheet.hostelLength) + "hostelLength_resume");
        }
//            mList = (RecyclerView)view.findViewById(R.id.list_view);
        layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mList.setLayoutManager(layoutManager);
        mList.setAdapter(myAdapter);
        //resume
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

    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
        private List<String> mData;
        private Context mContext;

        public class ViewHolder extends RecyclerView.ViewHolder {
            public TextView TextView0001, TextView0002, TextView0003, TextView0004, TextView0005,TextView0006;
            public ImageView TextView0007;
            public ImageButton ib_popup_menu;

            public ViewHolder(View v) {
                super(v);
                TextView0001 = (TextView) v.findViewById(R.id.txt_hostel_name);
                TextView0002 = (TextView) v.findViewById(R.id.txt_hostel_addr);
                TextView0003 = (TextView) v.findViewById(R.id.txt_number_people);
                TextView0004 = (TextView) v.findViewById(R.id.txt_days);
                TextView0005 = (TextView) v.findViewById(R.id.txt_skill);
                TextView0006 = (TextView) v.findViewById(R.id.txt_hostel_star);
                TextView0007 = (ImageView) v.findViewById(R.id.img_S_pic);
                ib_popup_menu = (ImageButton) v.findViewById(R.id.ib_popup_menu);
            }
        }

        public MyAdapter(List<String> data) {
            mData = data;
        }


        @Override
        public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            mContext = parent.getContext();
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.findhostel_item, parent, false);
            MyAdapter.ViewHolder vh = new MyAdapter.ViewHolder(v);
            return vh;
        }

        @Override
        public void onBindViewHolder(final MyAdapter.ViewHolder holder, int position) {
            holder.TextView0001.setText(mData.get(position));
            holder.TextView0002.setText(myDataset2.get(position));
            holder.TextView0003.setText(myDataset6.get(position));
            holder.TextView0004.setText(myDataset5.get(position));
            holder.TextView0005.setText(myDataset6.get(position));
            holder.TextView0006.setText(myDataset3.get(position));
            holder.TextView0007.setImageBitmap(stringToBitmap(myDataset4.get(position)));
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
