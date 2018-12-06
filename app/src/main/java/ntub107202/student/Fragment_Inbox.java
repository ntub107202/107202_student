package ntub107202.student;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Fragment_Inbox extends Fragment {
    RecyclerView mList;
    ArrayList<String> myDatasetName;
    ArrayList<String> myDatasetAddr;
    ArrayList<String> myDatasetJobName;
    ArrayList<String> myDatasetJobContent;
    ArrayList<String> myDatasetImg;
    TextView textView0;
    MyAdapter myAdapter;
    Button btnOK;
    Button btnNO;
    static LinearLayoutManager layoutManager;
    private int TIME = 3000;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_inbox, container, false);
        mList = (RecyclerView) view.findViewById(R.id.list_view);
        textView0 = (TextView)view.findViewById(R.id.txt_noinbox);


        //每隔1s执行一次.

//        Handler handler=new Handler();
//        Runnable runnable=new Runnable() {
//            @Override
//            public void run() {
//// TODO Auto-generated method stub
////要做的事情
//                handler.postDelayed(this, 2000);
//        }

        Handler handler = new Handler();
         // 在初始化方法里.
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
            try {
                 handler.postDelayed(this, TIME);
                getWorksheet.getResumeJSON();
                setResumeview();
                    Log.i("print","1-------------");
            } catch (Exception e) {
                e.printStackTrace();
            }
          }
        };
        handler.postDelayed(runnable, TIME);

        return view;
    }

    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden) {

            //pause
        } else {

            setResumeview();
            //resume
        }
    }

    public void setResumeview() {
        myDatasetName = new ArrayList<>();
        myDatasetAddr = new ArrayList<>();
        myDatasetJobName = new ArrayList<>();
        myDatasetJobContent = new ArrayList<>();
        myDatasetImg = new ArrayList<>();

        myAdapter = new MyAdapter(myDatasetName);
        for (int i = 0; i < getWorksheet.resumeLength; i++) {
//
            myDatasetName.add(getWorksheet.getRow50(i));
            myDatasetAddr.add(getWorksheet.getRow51(i));
            myDatasetJobName.add(getWorksheet.getRow52(i));
            myDatasetJobContent.add(getWorksheet.getRow53(i));
            myDatasetImg.add(getWorksheet.getRow54(i));
//            Log.v("wtf",myDatasetName.get(i));
//            Log.d("get5478787", myDatasetName.get(i));
//            Log.d("get5478787", myDatasetAddr.get(i) );
//            Log.d("get5478787", myDatasetJobName.get(i) );
//            Log.d("get5478787", myDatasetJobContent.get(i) );
//            Log.d("get5478787", myDatasetImg.get(i));
        }
        if (getWorksheet.getRow50(0) != null) {
            textView0.setVisibility(View.INVISIBLE);
        }
//            mList = (RecyclerView)view.findViewById(R.id.list_view);
        layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mList.setLayoutManager(layoutManager);
        mList.setAdapter(myAdapter);
    }

    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
        private List<String> mData;
        private Context mContext;

        public class ViewHolder extends RecyclerView.ViewHolder {
            public TextView TextView0001, TextView0002, TextView0003, TextView0004;
            public ImageView Img01;
            public CardView cardView;
            Button btnOK;
            Button btnNO;


            public ViewHolder(View v) {
                super(v);
                TextView0001 = (TextView) v.findViewById(R.id.textView0001);
                TextView0002 = (TextView) v.findViewById(R.id.textView0002);
                TextView0003 = (TextView) v.findViewById(R.id.textView0003);
                TextView0004 = (TextView) v.findViewById(R.id.textView0004);
                Img01 = (ImageView) v.findViewById(R.id.img01);
                cardView = (CardView) v.findViewById(R.id.card_view);
                btnOK = (Button)v.findViewById(R.id.btn_accept);
                btnNO = (Button)v.findViewById(R.id.btn_denied);
            }
        }

        public MyAdapter(List<String> data) {
            mData = data;
        }

        public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            mContext = parent.getContext();
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.inboxview_item, parent, false);
            MyAdapter.ViewHolder vh = new MyAdapter.ViewHolder(v);
            vh.btnOK.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getWorksheet.delToResume(getWorksheet.getRow60(vh.getAdapterPosition()));
                    Log.d("get5487", "fuck123fuck" + getWorksheet.getRow60(vh.getAdapterPosition()));
                }
            });
            vh.btnNO.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getWorksheet.delToResume(getWorksheet.getRow60(vh.getAdapterPosition()));
                    Log.d("get5487", "fuck123fuck" + getWorksheet.getRow60(vh.getAdapterPosition()));
                }
            });
            vh.cardView.setOnClickListener(new View.OnClickListener() {
                int position;

                @Override
                public void onClick(View v) {
////                    Bundle bundle=new Bundle();
//                    bundle.putInt("position", vh.getAdapterPosition());
//                    Intent i=new Intent();
//                    i.putExtras(bundle);
//                    i.setClass(mContext, Humansearch_Info.class);
//                    mContext.startActivity(i);
                }
            });
            return vh;
        }

        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.TextView0001.setText(myDatasetName.get(position));
            holder.TextView0002.setText(myDatasetAddr.get(position));
            holder.TextView0003.setText(myDatasetJobName.get(position));
            holder.TextView0004.setText(myDatasetJobContent.get(position));
            holder.Img01.setImageBitmap(stringToBitmap(myDatasetImg.get(position)));
            Log.d("get0000", "position" + myDatasetImg.get(position));
        }

        public int getItemCount() {
            return mData.size();
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
}
