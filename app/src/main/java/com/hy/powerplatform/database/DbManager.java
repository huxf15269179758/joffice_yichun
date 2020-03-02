package com.hy.powerplatform.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.hy.powerplatform.business_inspect.bean.CarCode;
import com.hy.powerplatform.business_inspect.bean.CheckUp;
import com.hy.powerplatform.business_inspect.bean.DriverP;
import com.hy.powerplatform.business_inspect.bean.NewDriver;
import com.hy.powerplatform.business_inspect.bean.ShowLine;
import com.hy.powerplatform.oa_flow.bean.PersonList;

import java.util.ArrayList;
import java.util.List;

public class DbManager {
    private static MyDatabaseHelper helper;
    //试题
    public static MyDatabaseHelper getInstance(Context context){
        if (helper==null){
            helper = new MyDatabaseHelper(context);
        }
        return helper;
    }

    public static Cursor queryBySQL(SQLiteDatabase db, String sql, String []selectionArgs){
        Cursor cursor = null;
        if (db!=null){
            cursor = db.rawQuery(sql,selectionArgs);
        }
        return cursor;
    }
//
//    //将用户电话cause转化成list
//    public static List<UserPhone> cursorToPerson(Cursor cursor){
//        List<UserPhone> list = new ArrayList<>();
//        while (cursor.moveToNext()){
//            // 根据参数指定的字段来读取字段下标
//            int index = cursor.getColumnIndex(Constant.ID);
//            // 根据参数中指定的字段下标来获取指定的数据
//            int id = cursor.getInt(index);
//            String ID = cursor.getString(cursor.getColumnIndex(Constant.ID));
//            String department = cursor.getString(cursor.getColumnIndex(Constant.DEPARTMENT));
//            String userName = cursor.getString(cursor.getColumnIndex(Constant.USERNAME));
//            String userPhone = cursor.getString(cursor.getColumnIndex(Constant.USERPHONE));
//            UserPhone userPhone1 = new UserPhone(userName,userPhone,department);
//            list.add(userPhone1);
//        }
//        return list;
//    }

    //将车牌号cause转化成list
    public static List<CarCode.DataBean> cursorToClassCar(Cursor cursor){
        List<CarCode.DataBean> list = new ArrayList<>();
        while (cursor.moveToNext()){
            String carName = cursor.getString(cursor.getColumnIndex(Constant.CARNAME));
            String carValue = cursor.getString(cursor.getColumnIndex(Constant.CARVALUE));
            CarCode.DataBean resultBean = new CarCode.DataBean(carName,carValue);
            list.add(resultBean);
        }
        return list;
    }

    //将检查人cause转化成list
    public static List<CheckUp.DataBean> cursorToCheckUp(Cursor cursor){
        List<CheckUp.DataBean> list = new ArrayList<>();
        while (cursor.moveToNext()){
            String checkUpName = cursor.getString(cursor.getColumnIndex(Constant.CHECKUPNAME));
            String checkUpId = cursor.getString(cursor.getColumnIndex(Constant.CHECKUPID));
            String checkUpSex = cursor.getString(cursor.getColumnIndex(Constant.CHECKUPSEX));
            String checkUpUserCode = cursor.getString(cursor.getColumnIndex(Constant.CHECKUPUSERCODE));
            CheckUp.DataBean resultBean = new CheckUp.DataBean(checkUpName,checkUpId,checkUpUserCode,checkUpSex);
            list.add(resultBean);
        }
        return list;
    }

    //将车牌号cause转化成list
    public static List<ShowLine> cursorToInspectLine(Cursor cursor){
        List<ShowLine> listInspectLine = new ArrayList<>();
        while (cursor.moveToNext()){
            String depId = cursor.getString(cursor.getColumnIndex(Constant.LINEDEPID));
            String lineCode = cursor.getString(cursor.getColumnIndex(Constant.LINECODE));
            String depName = cursor.getString(cursor.getColumnIndex(Constant.LINEDEPNAME));
            ShowLine resultBean = new ShowLine(lineCode,depId,depName);
            listInspectLine.add(resultBean);
        }
        return listInspectLine;
    }

    //将驾驶员cause转化成list
    public static List<NewDriver.DataBean> cursorToInspectDrive(Cursor cursor){
        List<NewDriver.DataBean> listInspectDrive = new ArrayList<>();
        while (cursor.moveToNext()){
            String driverName = cursor.getString(cursor.getColumnIndex(Constant.DRIVERNAME));
            String driverId = cursor.getString(cursor.getColumnIndex(Constant.DRIVERID));
            String sex = cursor.getString(cursor.getColumnIndex(Constant.SEX));
            String userCode = cursor.getString(cursor.getColumnIndex(Constant.USERCODE));
            NewDriver.DataBean resultBean = new NewDriver.DataBean(driverName,driverId,sex,userCode);
            listInspectDrive.add(resultBean);
        }
        return listInspectDrive;
    }


    //将本地驾驶员cause转化成list
    public static List<DriverP.DataBean> cursorToInspectDriveP(Cursor cursor){
        List<DriverP.DataBean> listInspectDrive = new ArrayList<>();
        while (cursor.moveToNext()){
            String driverName = cursor.getString(cursor.getColumnIndex(Constant.FULLNAME));
            String driverId = cursor.getString(cursor.getColumnIndex(Constant.PROFILEID));
            String depId = cursor.getString(cursor.getColumnIndex(Constant.SEX));
            DriverP.DataBean resultBean = new DriverP.DataBean(driverName,driverId,depId);
            listInspectDrive.add(resultBean);
        }
        return listInspectDrive;
    }


    //将宜春内部人员cause转化成list
    public static List<PersonList> cursorToYCPersonList(Cursor cursor){
        List<PersonList> listInspectDrive = new ArrayList<>();
        while (cursor.moveToNext()){
            PersonList bean = new PersonList();
            String fullname = cursor.getString(cursor.getColumnIndex(Constant.FULLNAME));
            String eCard = cursor.getString(cursor.getColumnIndex(Constant.ECARD));
            String profileId = cursor.getString(cursor.getColumnIndex(Constant.PROFILEID));
            String userCode = cursor.getString(cursor.getColumnIndex(Constant.USERCODE));
            String sex = cursor.getString(cursor.getColumnIndex(Constant.SEX));
            bean.setFullname(cursor.getString(cursor.getColumnIndex(Constant.FULLNAME)));
            bean.seteCard(cursor.getString(cursor.getColumnIndex(Constant.ECARD)));
            bean.setProfileId(cursor.getString(cursor.getColumnIndex(Constant.PROFILEID)));
            bean.setSex(cursor.getString(cursor.getColumnIndex(Constant.SEX)));
            bean.setUserCode(cursor.getString(cursor.getColumnIndex(Constant.USERCODE)));
            bean.setLetters(cursor.getString(cursor.getColumnIndex(Constant.SORT)));
            listInspectDrive.add(bean);
        }
        return listInspectDrive;
    }

}
