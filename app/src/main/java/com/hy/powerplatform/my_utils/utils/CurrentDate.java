package com.hy.powerplatform.my_utils.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by dell on 2018/5/8.
 * 获取当前时间
 */

public class CurrentDate {
    /**
     * 获取当前日期
     * @return
     */
    public String getCurrentData(){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日");
        Date curDate = new Date(System.currentTimeMillis());//获取当前时间
        String currentDate = formatter.format(curDate);
        return currentDate;
    }


    /**
     * 获取当前时间
     * @return
     */
    public String getCurrentTime(){
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        Date curDate = new Date(System.currentTimeMillis());//获取当前时间
        String currentTime = formatter.format(curDate);
        return currentTime;
    }
}
