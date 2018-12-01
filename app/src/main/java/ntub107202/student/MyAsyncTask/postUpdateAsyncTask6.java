package ntub107202.student.MyAsyncTask;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class postUpdateAsyncTask6 extends AsyncTask<String, Integer, String> {
    //----------------------------------------------------
    // 宣告一個TaskListener介面, 接收回傳值的物件必須實作它
    //----------------------------------------------------
    public interface TaskListener {
        void onFinished(String result);
    }

    //----------------------
    // 接收回傳值的物件參考
    //----------------------
    private final TaskListener taskListener;

    //---------------------------------------
    // 建構元, 傳入context及接收回傳值的物件
    //---------------------------------------
    public postUpdateAsyncTask6(TaskListener taskListener) {
        this.taskListener = taskListener;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }

    //=========================================================
    // 執行非同步工作, 建立一個HttpURLConnection, 讀取主機的資料.
    //=========================================================
    @Override
    protected String doInBackground(String... params) {
        String data=null;
        InputStream inputStream = null;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        try {
            URL url = new URL(params[0]); //params[0] 是myNavigationAsyncTask.execute(Common.updateUrl, getId);的第一個參數
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(100000);
            conn.setConnectTimeout(150000);
            conn.setRequestMethod("POST");
            conn.setDoInput(true);
            conn.setDoOutput(true);

            //----------------------------------------------
            //  傳給主機的參數(name, amount, deliverDate)
            //----------------------------------------------
            //params[1] 是myNavigationAsyncTask.execute(Common.updateUrl, getId);的第二個參數


            String args =
                        "row1=" + URLEncoder.encode(params[1], "UTF-8") +
                                "&row2=" + URLEncoder.encode(params[2], "UTF-8")+
                        "&row3=" + URLEncoder.encode(params[3], "UTF-8") +
                                "&row4=" + URLEncoder.encode(params[4], "UTF-8")+
                        "&row5=" + URLEncoder.encode(params[5], "UTF-8") +
                                "&row6=" + URLEncoder.encode(params[6], "UTF-8")+
                                "&row7=" + URLEncoder.encode(params[7], "UTF-8") +
                                "&row8=" + URLEncoder.encode(params[8], "UTF-8")+
                                "&row9=" + URLEncoder.encode(params[9], "UTF-8") +
                                "&row10=" + URLEncoder.encode(params[10], "UTF-8")+
                                "&row11=" + URLEncoder.encode(params[11], "UTF-8")+
                                "&row12=" + URLEncoder.encode(params[12], "UTF-8") +
                                "&row13=" + URLEncoder.encode(params[13], "UTF-8")+
                                "&row14=" + URLEncoder.encode(params[14], "UTF-8") +
                                "&row15=" + URLEncoder.encode(params[15], "UTF-8")+
                                "&row16=" + URLEncoder.encode(params[16], "UTF-8")+
                                "&row17=" + URLEncoder.encode(params[17], "UTF-8") +
                                "&row18=" + URLEncoder.encode(params[18], "UTF-8")+
                                "&row19=" + URLEncoder.encode(params[19], "UTF-8") +
                                "&row20=" + URLEncoder.encode(params[20], "UTF-8")+
                                "&row21=" + URLEncoder.encode(params[21], "UTF-8")+
                                "&row22=" + URLEncoder.encode(params[22], "UTF-8") +
                                "&row23=" + URLEncoder.encode(params[23], "UTF-8")+
                                "&row24=" + URLEncoder.encode(params[24], "UTF-8") +
                                "&row25=" + URLEncoder.encode(params[25], "UTF-8")+
                                "&row26=" + URLEncoder.encode(params[26], "UTF-8") +
                                "&row27=" + URLEncoder.encode(params[27], "UTF-8")+
                                "&row28=" + URLEncoder.encode(params[28], "UTF-8") +
                                "&row29=" + URLEncoder.encode(params[29], "UTF-8")+
                                "&row30=" + URLEncoder.encode(params[30], "UTF-8")+
                                "&row31=" + URLEncoder.encode(params[31], "UTF-8") +
                                "&row32=" + URLEncoder.encode(params[32], "UTF-8")+
                                "&row33=" + URLEncoder.encode(params[33], "UTF-8") +
                                "&row34=" + URLEncoder.encode(params[34], "UTF-8")+
                                "&row35=" + URLEncoder.encode(params[35], "UTF-8");

//            for (i=1;i<=35;i++){
//                String args = "row"+ i +"=" + URLEncoder.encode(params[i], "UTF-8");
//            }



            Log.v("TTTTTTTTTTTTTTTTTTTT", "TTTTTTTTTTTTTTTTTTTT:"+args);
            //-----------------------------這裡寫你要接的參數

            OutputStream os = conn.getOutputStream();
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(os, "UTF-8"));
            writer.write(args);
            writer.flush();
            writer.close();
            os.close();

            conn.connect();
            inputStream = conn.getInputStream();

            BufferedReader bufferedReader=new BufferedReader(
                    new InputStreamReader(inputStream, "utf-8"));

            data=bufferedReader.readLine();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
                outputStream.close();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        return data;
    }


    //===========================
    // 執行完非同步工作之後執行
    //===========================
    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        taskListener.onFinished(result);
    }

    @Override
    protected void onCancelled(String result) {
        super.onCancelled(result);
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
    }
}
