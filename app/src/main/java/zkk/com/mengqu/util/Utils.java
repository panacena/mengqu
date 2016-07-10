package zkk.com.mengqu.util;

import android.content.Context;
import android.text.format.DateFormat;
import android.view.Display;
import android.view.WindowManager;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/6/30 0030.
 */
public class Utils {
    public static final DecimalFormat DF = new DecimalFormat("0.00");
    public static final DecimalFormat DF1 = new DecimalFormat("0.00");
    public static String getDownloadPerSize(long finished, long total) {
        return DF.format((float) finished / (1024 * 1024)) + "M/" + DF.format((float) total / (1024 * 1024)) + "M";
    }



    public static String getDownloadPer(int  now,int all){
        return DF1.format( ((float)now/(float)all)*100)+"%";
    }

    public static String getDate(long paramLong) {
        return getDate(paramLong, "MM/dd").toString();
    }
    public static String getDate(long paramLong, String paramString) {
        return DateFormat.format(paramString, 1000L * paramLong).toString();
    }




    //获取屏幕的宽度
    public static int getScreenWidth(Context context) {
        WindowManager manager = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        Display display = manager.getDefaultDisplay();
        return display.getWidth();
    }
    //获取屏幕的高度
    public static int getScreenHeight(Context context) {
        WindowManager manager = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        Display display = manager.getDefaultDisplay();
        return display.getHeight();
    }


    public static String getRefreshTimeText(String paramg){

        long l1 = System.currentTimeMillis();

    /*Date dt= new Date();
    l1= dt.getTime();*//*

    SimpleDateFormat sdf = new SimpleDateFormat(yyyyMMddHHmm);

    long paramLong=0;
	try {
		paramLong = sdf.parse(paramg).getTime();
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/
        paramg=paramg+"000";
        long paramLong=Long.parseLong(paramg);

        long l2 = l1 - paramLong;
        Date localDate1 = new Date(l1);
        Date localDate2 = new Date(paramLong);

        Calendar localCalendar = Calendar.getInstance();
        localCalendar.setTime(localDate1);
        int i = localCalendar.get(Calendar.YEAR);

        localCalendar.setTime(localDate2);
        int j = localCalendar.get(Calendar.YEAR);

        if (l2 < 60000){
            return "刚刚";
        }

        if ((l2 >= 60000) && (l2 < 3600000)){
            return l2 / 60000L + "分钟前";
        }

        if ((l2 >= 3600000) && (l2 < 86400000)){
            return l2 / 3600000L + "小时前";
        }

        if ((l2 >= 86400000) && (l2 < 259200000)){
            return l2 / 86400000 + "天前";
        }

        if ((l2 >= 259200000) && (i == j)){
            return getDateInMillis(paramLong, "hh:mm");
        }
        return getDateInMillis(paramLong, "MM-dd");
    }


    public static String getDateInMillis(long paramLong, String paramString)
    {
        return DateFormat.format(paramString, paramLong).toString();
    }


    public static boolean   isNull(String  str){
        if(!"".equals(str)&& str!=null){
           return false;
        }else{
            return  true;
        }
    }

    public static boolean  isTwoList(List a,List b){
        if(a!=null&&b!=null&&a.size()==b.size()
                &&a.get(0)==b.get(0)){
            return  true;
        }else{
            return false;
        }
    }
}
