package com.hy.powerplatform.my_utils.myViews.ToastUtils;

/**
 * Created by along on 2017/3/5.
 */

import android.content.Context;
import android.graphics.PixelFormat;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;

import com.hy.powerplatform.R;

import java.util.Timer;
import java.util.TimerTask;

public class ToastCustom {

    private WindowManager wdm;
    private double time;
    private View mView;
    private WindowManager.LayoutParams params;
    private Timer timer;

    /**
     * 通过构造方法初始化Window的参数
     *
     * @param context
\     * @param time
     */
    private ToastCustom(Context context, View customView, double time){
        wdm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        timer = new Timer();

       // Toast toast = Toast.makeText(context, , Toast.LENGTH_SHORT);
       // mView = toast.getView();

        mView = customView;

        params = new WindowManager.LayoutParams();
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        params.width = WindowManager.LayoutParams.WRAP_CONTENT;
        params.format = PixelFormat.TRANSLUCENT;
        params.windowAnimations = R.style.Lite_Animation_Toast;
        params.type = WindowManager.LayoutParams.TYPE_TOAST;
        params.setTitle("Toast");


        params.flags = WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON
                | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                | WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE;
        params.gravity = Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM;

        //获取屏幕高度
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        int height = wm.getDefaultDisplay().getHeight();
        //Toast的Y坐标是屏幕高度的1/8
        params.y = height / 8;

        this.time = time;
    }

    public static ToastCustom makeText(Context context, View customView, double time){
        ToastCustom toastCustom = new ToastCustom(context, customView, time);
        return toastCustom;
    }



    public void show(){
        wdm.addView(mView, params);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                wdm.removeView(mView);
            }
        }, (long)(time * 1000));
    }

    public void cancel(){
        wdm.removeView(mView);
        timer.cancel();
    }


}
