package com.hy.powerplatform.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by shang on 2017/6/29.
 */

public class MyDatabaseHelper extends SQLiteOpenHelper {

    public MyDatabaseHelper(Context context){
        super(context,Constant.DATABASE_NAME,null,Constant.DATA_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //创建题库表
        String sql = "create table "+Constant.TABBLE_NAME
                +"("+Constant.ID+","+Constant.DEPARTMENT+","+Constant.USERNAME
                +","+Constant.USERPHONE+")";
        Log.i("xyz",sql);
        db.execSQL(sql);


        //创建车辆表
        String sql_car = "create table "+Constant.TABBLE_CAR_NAME
                +"("+Constant.ID+","+Constant.CARNAME+","+Constant.CARVALUE +")";
        Log.i("xyz",sql_car);
        db.execSQL(sql_car);

        //创建线路表
        String sql_inspect_line = "create table "+Constant.TABBLE_INSPECT_LINE
                +"("+Constant.ID+","+Constant.LINEDEPID+","+Constant.LINECODE+","+Constant.LINEDEPNAME+")";
        Log.i("xyz",sql_inspect_line);
        db.execSQL(sql_inspect_line);

        //创建线路表
        String sql_inspect_drive = "create table "+Constant.TABBLE_INSPECT_DRIVE
                +"("+Constant.ID+","+Constant.DRIVERNAME+","+Constant.DRIVERID
                +","+Constant.SEX+")";
        Log.i("xyz",sql_inspect_drive);
        db.execSQL(sql_inspect_drive);

        //创建本地驾驶员表
        String sql_inspect_drive_p = "create table "+Constant.TABBLE_INSPECT_DRIVE_P
                +"("+Constant.ID+","+Constant.FULLNAME+","+Constant.PROFILEID
                +","+Constant.SEX+","+Constant.USERCODE+")";
        Log.i("xyz",sql_inspect_drive_p);
        db.execSQL(sql_inspect_drive_p);

        //创建检查人表
        String sql_check_up = "create table "+Constant.TABBLE_CHECK_UP
                +"("+Constant.ID+","+Constant.CHECKUPNAME+","+Constant.CHECKUPID
                +","+Constant.CHECKUPUSERCODE+","+Constant.CHECKUPSEX+")";
        Log.i("xyz",sql_check_up);
        db.execSQL(sql_check_up);


        //创建检查人表
        String sql_yc_person = "create table "+Constant.TABBLE_YC_PERSON
                +"("+Constant.ID+","+Constant.FULL_NAME+","+Constant.ECARD
                +","+Constant.PROFILEID+","+Constant.SEX+","+Constant.USERCODE+","+Constant.SORT+")";
        Log.i("xyz",sql_yc_person);
        db.execSQL(sql_yc_person);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
