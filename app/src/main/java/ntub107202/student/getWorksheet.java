package ntub107202.student;

import android.util.Log;

import ntub107202.student.Common.Common;
import ntub107202.student.MyAsyncTask.getAsyncTask;
import ntub107202.student.MyAsyncTask.postUpdateAsyncTask;
import ntub107202.student.MyAsyncTask.postUpdateAsyncTask2;
import ntub107202.student.MyAsyncTask.postUpdateAsyncTask3;

import org.json.JSONArray;
import org.json.JSONObject;

//-------------

public class getWorksheet {

        private static String[] row1= new String[100];
        private static String[] row2= new String[100];
        private static String[] row3= new String[100];
        private static String[] row4= new String[100];
        private static String[] row19= new String[100];
        private static String[] row20= new String[100];
        private static String[] row21= new String[100];
        private static String[] row22= new String[100];
        private static String[] row23= new String[100];
        private static String[] row24= new String[100];
        private static String[] row25= new String[100];
    private static String[] row26= new String[100];
    private static String[] row27= new String[100];
    private static String[] row28= new String[100];
    private static String[] row29= new String[100];
    private static String[] row30= new String[100];
    private static String[] row31= new String[100];
    private static String[] row32= new String[100];
    private static String[] row33= new String[100];
    private static String[] row34= new String[100];

        private static String[] row9= new String[100];
        private static String[] row10= new String[100];
        private static String[] row11= new String[100];
        private static String[] row12= new String[100];
        private static String[] row13= new String[100];
        private static String[] row14= new String[100];
        private static String[] row15= new String[100];
        private static String[] row16= new String[100];
        private static String[] row17= new String[100];
        private static String[] row18= new String[100];


        private static int worksheetLength ;
        public static int scheduleLength;
        public static int forumLength;
        public static int hostelLength;

        public static void getJSON() {

            getAsyncTask myAsyncTask = new getAsyncTask(new getAsyncTask.TaskListener() {
                @Override
                public void onFinished(String result) {
                    try {
                        JSONObject object = new JSONObject(result);

                        JSONArray jsonArray = object.getJSONArray("result");
                        worksheetLength = jsonArray.length();

                        int j=0;

                        for (int i = 0 ; i<getWorksheetLength() ; i++){
                            row1[i] = jsonArray.getJSONObject(i).getString("row1");
                            row2[i] = jsonArray.getJSONObject(i).getString("row2");
                            row3[i] = jsonArray.getJSONObject(i).getString("row3");
                            row4[i] = jsonArray.getJSONObject(i).getString("row4");
                            Log.v("Row1", row1[i]);
                        }
                    } catch (Exception e) {
                        Log.v("ABC", Log.getStackTraceString(e));
                    }
                }
            });
            myAsyncTask.execute(Common.getUrl);
        }

    public static void getHostelJSON() {

        getAsyncTask myAsyncTask = new getAsyncTask(new getAsyncTask.TaskListener() {
            @Override
            public void onFinished(String result) {
                try {
                    JSONObject object = new JSONObject(result);

                    JSONArray jsonArray = object.getJSONArray("result");
                    worksheetLength = jsonArray.length();
                    hostelLength = worksheetLength;
                    int j=0;

                    for (int i = 0 ; i<getWorksheetLength() ; i++){
                        row19[i] = jsonArray.getJSONObject(i).getString("hostelName");
                        row20[i] = jsonArray.getJSONObject(i).getString("hostelAddress");
                        row21[i] = jsonArray.getJSONObject(i).getString("hostelPhoto");
                        row22[i] = jsonArray.getJSONObject(i).getString("vacancyName");
                        row23[i] = jsonArray.getJSONObject(i).getString("vacancySalary");
                        row24[i] = jsonArray.getJSONObject(i).getString("vacancyStartDate");
                        row25[i] = jsonArray.getJSONObject(i).getString("vacancyEndDate");
                        row26[i] = jsonArray.getJSONObject(i).getString("vacancyStartTime");
                        row27[i] = jsonArray.getJSONObject(i).getString("vacancEndTime");
                        row28[i] = jsonArray.getJSONObject(i).getString("vacancyNumPeople");
                        row29[i] = jsonArray.getJSONObject(i).getString("vacancyJob");
                        row30[i] = jsonArray.getJSONObject(i).getString("hostelOwnerName");
                        row31[i] = jsonArray.getJSONObject(i).getString("hostelOwnerAccount");
                        row32[i] = jsonArray.getJSONObject(i).getString("hostelOwnerPhone");
                        row33[i] = jsonArray.getJSONObject(i).getString("vacancyDays");
                        row34[i] = jsonArray.getJSONObject(i).getString("hostelRate");

                        Log.v("Row56", row20[i]);
                    }
                } catch (Exception e) {
                    Log.v("ABC", Log.getStackTraceString(e));
                }
            }
        });
        myAsyncTask.execute(Common.getHostel);
    }
    public static void getscheduleJSON() {

        getAsyncTask myAsyncTask = new getAsyncTask(new getAsyncTask.TaskListener() {
            @Override
            public void onFinished(String result) {
                try {
                    JSONObject object = new JSONObject(result);

                    JSONArray jsonArray = object.getJSONArray("result");
                    worksheetLength = jsonArray.length();
                    scheduleLength = worksheetLength;
                    int j=0;

                    for (int i = 0 ; i<getWorksheetLength() ; i++){
                        row9[i] = jsonArray.getJSONObject(i).getString("row1");
                        row10[i] = jsonArray.getJSONObject(i).getString("row2");
                        row11[i] = jsonArray.getJSONObject(i).getString("row3");
                        row12[i] = jsonArray.getJSONObject(i).getString("row4");
                        Log.v("Row5", row9[i]);
                    }
                } catch (Exception e) {
                    Log.v("ABC", Log.getStackTraceString(e));
                }
            }
        });
        myAsyncTask.execute(Common.getSchedule);
    }
    public static void getForumJSON() {

        getAsyncTask myAsyncTask = new getAsyncTask(new getAsyncTask.TaskListener() {
            @Override
            public void onFinished(String result) {
                try {
                    JSONObject object = new JSONObject(result);

                    JSONArray jsonArray = object.getJSONArray("result");
                    worksheetLength = jsonArray.length();
                    forumLength = worksheetLength;
                    int j=0;

                    for (int i = 0 ; i<getWorksheetLength() ; i++){
                        row13[i] = jsonArray.getJSONObject(i).getString("row1");
                        row14[i] = jsonArray.getJSONObject(i).getString("row2");
                        row15[i] = jsonArray.getJSONObject(i).getString("row3");
                        row16[i] = jsonArray.getJSONObject(i).getString("row4");
                        row17[i] = jsonArray.getJSONObject(i).getString("row5");
                        row18[i] = jsonArray.getJSONObject(i).getString("row6");
                        Log.v("Row5", row13[i]);
                    }
                } catch (Exception e) {
                    Log.v("ABC", Log.getStackTraceString(e));
                }
            }
        });
        myAsyncTask.execute(Common.getForum);
    }
        public static void postToPHP(String row1, String row2, String row3) {
            postUpdateAsyncTask myAsyncTask = new postUpdateAsyncTask(new postUpdateAsyncTask.TaskListener() {
                @Override
                public void onFinished(String result) {
                }
            });
            if(!myAsyncTask.isCancelled()) {
                //執行上傳動作
                myAsyncTask.execute(Common.postUrl ,row1,row2,row3);
            }
        }
        public static void postToJob(String row1, String row2, String row3, String row4, String row5, String row6, String row7, String row8, String row9, String row10, String row11, String row12, String row13) {
        postUpdateAsyncTask myAsyncTask = new postUpdateAsyncTask(new postUpdateAsyncTask.TaskListener() {
            @Override
            public void onFinished(String result) {
            }
        });
        if(!myAsyncTask.isCancelled()) {
            //執行上傳動作
            myAsyncTask.execute(Common.postJob ,row1,row2,row3,row4,row5,row6,row7,row8,row9,row10,row11,row12,row13);
        }
    }
        public static void postToCalendar(String row1, String row2, String row3, String row4, String row5) {
        postUpdateAsyncTask2 myAsyncTask = new postUpdateAsyncTask2(new postUpdateAsyncTask2.TaskListener() {
            @Override
            public void onFinished(String result) {
            }
        });
        if(!myAsyncTask.isCancelled()) {
            //執行上傳動作
            myAsyncTask.execute(Common.postCalendar ,row1,row2,row3,row4,row5);
        }
    }
    public static void postToQuestion(String row1) {
        postUpdateAsyncTask3 myAsyncTask = new postUpdateAsyncTask3(new postUpdateAsyncTask3.TaskListener() {
            @Override
            public void onFinished(String result) {
            }
        });
        if(!myAsyncTask.isCancelled()) {
            //執行上傳動作
            myAsyncTask.execute(Common.postQuestion ,row1);
        }
    }

        public static int getWorksheetLength(){
            return worksheetLength;
        }

//        public static String[] getRow1(){
//            return row1;
//        }
//        public static String[] getRow2(){
//            return row2;
//        }
//        public static String[] getRow3(){
//        return row3;
//    }
//    public static String[] getRow4(){
//        return row4;
//    }
        public static String getRow19(int i){
            return row19[i];
       }
        public static String getRow20(int i){
            return row20[i];
        }
        public static String getRow21(int i){
            return row21[i];
        }
        public static String getRow22(int i){
            return row22[i];
        }
        public static String getRow23(int i){
            return row23[i];
        }
        public static String getRow24(int i){
            return row24[i];
        }
        public static String getRow25(int i){
            return row25[i];
        }
    public static String getRow26(int i){
        return row26[i];
    }
    public static String getRow27(int i){
        return row27[i];
    }
    public static String getRow28(int i){
        return row28[i];
    }
    public static String getRow29(int i){
        return row29[i];
    }
    public static String getRow30(int i){
        return row30[i];
    }
    public static String getRow31(int i){
        return row31[i];
    }
    public static String getRow32(int i){
        return row32[i];
    }
    public static String getRow33(int i){
        return row33[i];
    }
    public static String getRow34(int i){
        return row34[i];
    }


        public static String getRow9(int i){
            return row9[i];
        }
        public static String getRow10(int i){
            return row10[i];
        }
        public static String getRow11(int i){
            return row11[i];
        }
        public static String getRow12(int i){
            return row12[i];
        }
        public static String getRow13(int i){
            return row13[i];
        }
        public static String getRow14(int i){
            return row14[i];
        }
        public static String getRow15(int i){
            return row15[i];
        }
        public static String getRow16(int i){
            return row16[i];
        }
        public static String getRow17(int i){
            return row17[i];
        }
        public static String getRow18(int i){
            return row18[i];
        }
    }
