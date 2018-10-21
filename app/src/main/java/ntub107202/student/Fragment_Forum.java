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
import android.text.TextUtils;
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
    ArrayList<String> myDataset7;
    ArrayList<String> myDataset8;

    MyAdapter myAdapter;
    static LinearLayoutManager layoutManager;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_forum,container,false);
        mList = (RecyclerView)view.findViewById(R.id.list_view);

        FloatingActionButton fab = (FloatingActionButton)view.findViewById(R.id.fab_go_to_forum_add) ;
        fab.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),Forum_Add.class);
                startActivity(intent);
            }
        });
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

            myAdapter = new MyAdapter(myDataset);
            for(int i = 0; i < getWorksheet.forumLength; i++){
//                myDataset.add(i + "");
                myDataset.add(getWorksheet.getRow13(i));
                myDataset2.add(getWorksheet.getRow14(i));
                myDataset3.add(getWorksheet.getRow15(i));
                myDataset4.add(getWorksheet.getRow16(i));
                myDataset5.add(getWorksheet.getRow17(i));
                myDataset6.add(getWorksheet.getRow18(i));
                myDataset7.add(getWorksheet.getRow40(i));
                myDataset8.add(getWorksheet.getRow41(i));
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
        private Context mContext;

        public class ViewHolder extends RecyclerView.ViewHolder {
            public TextView TextView0001, TextView0002 ,TextView0003, TextView0004 ,TextView0005,TextView33,TextViewAddress;
            public  ImageView TextView0006,TextViewFace;
            public ImageButton ib_popup_menu;


            public ViewHolder(View v) {
                super(v);
                TextView0001 = (TextView) v.findViewById(R.id.textView0001);
                TextView0002 = (TextView) v.findViewById(R.id.textView0002);
                TextView0003 = (TextView) v.findViewById(R.id.textView0003);
                TextView0004 = (TextView) v.findViewById(R.id.textView0004);
                TextView0005 = (TextView) v.findViewById(R.id.textView0005);
                TextViewAddress = (TextView) v.findViewById(R.id.textView9);
                TextView0006 = (ImageView) v.findViewById(R.id.image000006);
                TextViewFace = (ImageView) v.findViewById(R.id.imageView);
                ib_popup_menu = (ImageButton) v.findViewById(R.id.ib_popup_menu);
                TextView33 = (TextView) v.findViewById(R.id.textView33);

                TextView33.setOnClickListener(new View.OnClickListener() {
                    Boolean flag = true;
                    @Override
                    public void onClick(View v) {
                        if (flag) {
                            flag = false;
                            TextView0005.setMaxLines(10);
                            TextView0005.setEllipsize(null); // 展开
                            TextView33.setText("... 摺疊內容");
                        } else {
                            flag = true;
                            TextView0005.setLines(1);
                            TextView0005.setEllipsize(TextUtils.TruncateAt.END); // 收缩
                            TextView33.setText("... 查看更多");
                        }
                    }
                });
            }


        }

        public MyAdapter(List<String> data) {
            mData = data;
        }


        @Override
        public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            mContext = parent.getContext();
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.forum_item, parent, false);
            MyAdapter.ViewHolder vh = new MyAdapter.ViewHolder(v);
            return vh;
        }

        @Override
        public void onBindViewHolder(final MyAdapter.ViewHolder holder, int position) {
            holder.TextView0001.setText(mData.get(position));
            holder.TextView0002.setText(myDataset2.get(position));
            holder.TextView0003.setText(myDataset3.get(position));
            holder.TextView0004.setText(myDataset4.get(position));
            holder.TextView0005.setText(myDataset5.get(position));
            holder.TextView0006.setImageBitmap(stringToBitmap(myDataset6.get(position)));
            holder.TextViewAddress.setText(myDataset7.get(position));
            holder.TextViewFace.setImageBitmap(stringToBitmap(myDataset8.get(position)));
            holder.ib_popup_menu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    PopupMenu popupMenu = new PopupMenu(mContext,holder.ib_popup_menu);
                    popupMenu.inflate(R.menu.forum_popup_menu);
                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            switch (item.getItemId()){
                                case  R.id.menu_edit:
                                    Toast.makeText(mContext,"開始編輯貼文",Toast.LENGTH_LONG).show();
                                    Intent intent = new Intent(getActivity(),Forum_Edit.class);
                                    startActivity(intent);
                                    break;
                                case  R.id.menu_collection:
                                    Toast.makeText(mContext,"已收藏貼文",Toast.LENGTH_LONG).show();
                                    break;
                                case  R.id.menu_report:
                                    Toast.makeText(mContext,"已檢舉貼文",Toast.LENGTH_LONG).show();
                                    intent = new Intent(getActivity(),Forum_Report.class);
                                    startActivity(intent);
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
