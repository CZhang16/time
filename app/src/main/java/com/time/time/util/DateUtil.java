package com.time.time.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ZC on 2017/2/20.
 */

public class DateUtil {

    /**
     * 返回YYYY-MM-DD
     * @return
     */
    public static String getNowTime(String type) {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        String day = dateString.substring(0, 10);
        String time = dateString.substring(11);
        switch (type) {
            case "day":
                return day;
            case "time":
                return time;
            case "date":
                return dateString;
            default:
                break;
        }
        throw new RuntimeException("No such time type");
    }
}
