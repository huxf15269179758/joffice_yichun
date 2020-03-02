package com.hy.powerplatform.my_utils.utils;

import android.util.Log;

import com.hy.powerplatform.my_utils.base.MyApplication;


/**
 * 打印信息控制类
 * 控制debug模式
 */

public class LogUtils {
    public static void logMessage(String message){
        if(MyApplication.IS_DEBUG){
            Log.e("Tag",message);
        }
    }
}
