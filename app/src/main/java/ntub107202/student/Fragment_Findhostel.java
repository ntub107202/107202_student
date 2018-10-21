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
    ArrayList<String> myDataset8;
    ArrayList<String> myDataset9;
    ArrayList<String> myDataset10;
    ArrayList<String> myDataset11;
    ArrayList<String> myDataset12;
    ArrayList<String> myDataset13;
    ArrayList<String> myDataset14;
    ArrayList<String> myDataset15;
    ArrayList<String> myDataset16;
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
        myDataset8 = new ArrayList<>();
        myDataset9 = new ArrayList<>();
        myDataset10 = new ArrayList<>();
        myDataset11 = new ArrayList<>();
        myDataset12 = new ArrayList<>();
        myDataset13 = new ArrayList<>();
        myDataset14 = new ArrayList<>();
        myDataset15 = new ArrayList<>();
        myDataset16 = new ArrayList<>();
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
            myDataset8 = new ArrayList<>();
            myDataset9 = new ArrayList<>();
            myDataset10 = new ArrayList<>();
            myDataset11 = new ArrayList<>();
            myDataset12 = new ArrayList<>();
            myDataset13 = new ArrayList<>();
            myDataset14 = new ArrayList<>();
            myDataset15 = new ArrayList<>();
            myDataset16 = new ArrayList<>();

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
            mData = data;
        }


        @Override
        public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            mContext = parent.getContext();
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.findhostel_item, parent, false);
            MyAdapter.ViewHolder vh = new MyAdapter.ViewHolder(v);

            vh.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent i = new Intent(mContext, Findhostel_hostelinfo.class);
                    i.putExtra("hostelName",mData.get(vh.getAdapterPosition()));
                    i.putExtra("hostelAddress",myDataset2.get(vh.getAdapterPosition()));
                    i.putExtra("hostelPhoto",myDataset3.get(vh.getAdapterPosition()));
                    i.putExtra("vacancyName",myDataset4.get(vh.getAdapterPosition()));
                    i.putExtra("vacancySalary",myDataset5.get(vh.getAdapterPosition()));
                    i.putExtra("vacancyStartDate",myDataset6.get(vh.getAdapterPosition()));
                    i.putExtra("vacancyEndDate",myDataset7.get(vh.getAdapterPosition()));
                    i.putExtra("vacancyStartTime",myDataset8.get(vh.getAdapterPosition()));
                    i.putExtra("vacancEndTime",myDataset9.get(vh.getAdapterPosition()));
                    i.putExtra("vacancyNumPeople",myDataset10.get(vh.getAdapterPosition()));
                    i.putExtra("vacancyJob",myDataset11.get(vh.getAdapterPosition()));
                    i.putExtra("hostelOwnerName",myDataset12.get(vh.getAdapterPosition()));
                    i.putExtra("hostelOwnerAccount",myDataset13.get(vh.getAdapterPosition()));
                    i.putExtra("hostelOwnerPhone",myDataset14.get(vh.getAdapterPosition()));
                    i.putExtra("vacancyDays",myDataset15.get(vh.getAdapterPosition()));

                    Log.d("get0000", "你好" + "hostelLength_resume");
                    mContext.startActivity(i);



                }
            });

            return vh;
        }

        @Override
        public void onBindViewHolder(final MyAdapter.ViewHolder holder, int position) {
            holder.TextViewHostelName.setText(mData.get(position));
            holder.TextViewHostelAddr.setText(myDataset2.get(position));
            holder.TextViewNumPeople.setText(myDataset10.get(position));
            holder.TextViewDays.setText(myDataset15.get(position));
            holder.TextViewSkill.setText(myDataset11.get(position));
            holder.TextViewHostelStar.setText(myDataset16.get(position));
            holder.TextViewHostelPic.setImageBitmap(stringToBitmap(myDataset3.get(position)));
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
