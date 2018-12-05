package ntub107202.student.Common;

public class Common {
    //--------------------------
    //(1) 若連結自己的主機
    //--------------------------
    // 確認並修改主機的ip位址
    // 若為192.168開頭的虛擬IP, 執行時模擬器與主機應使用同一分享器內之網路
    //public static String url="http://192.168.56.1:3000";

    //--------------------------
    //(2) 若連結現有測試主機
    //--------------------------
    public static String getUrl="http://140.131.114.153/getMysqlJSON";
    public static String postUrl="http://140.131.114.153/getAndroid";
    public static String postJob="http://140.131.114.153/postJob";
    public static String postCalendar="http://140.131.114.153/postCalendar";
    public static String postQuestion="http://140.131.114.153/postQuestion";
    public static String getHostel="http://140.131.114.153/getHostel";
    public static String getHostelname="http://140.131.114.153/getHostelname";
    public static String getSchedule="http://140.131.114.153/getSchedule0";
    public static String getForum="http://140.131.114.153/getForum";
    public static String postForum="http://140.131.114.153/postForum";
    public static String getStudentname="http://140.131.114.153/getStudentname";
    public static String postResumeStudent2Hostel="http://140.131.114.153/postResumeStudent2Hostel";
    public static String getResumeS="http://140.131.114.153/getResumeS";
    public static String getEditStudResume="http://140.131.114.153/getStudentEditResume";
    public static String postStudEditResume="http://140.131.114.153/postStudEditResume";

}