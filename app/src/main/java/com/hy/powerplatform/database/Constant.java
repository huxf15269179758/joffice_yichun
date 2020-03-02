package com.hy.powerplatform.database;

/**
 * Created by shang on 2017/6/29.
 */

public class Constant {

    //通讯录
    public static final String DATABASE_NAME = "hengyuwork.db";
    public static final int DATA_VERSION = 1;
    public static final String TABBLE_NAME = "Phone";
    public static final String ID = "id";
    public static final String  DEPARTMENT = "depNames";//部门
    public static final String USERNAME = "username";//姓名
    public static final String USERPHONE = "mobile";//电话


    //车牌号
    public static final String TABBLE_CAR_NAME = "carcode";
    public static final String CARNAME = "name";//车牌号
    public static final String CARVALUE = "value";//

    //线路
    public static final String TABBLE_INSPECT_LINE = "inspectLine";
    public static final String LINEDEPID = "depId";//线路
    public static final String LINECODE = "lineCode";//
    public static final String LINEDEPNAME = "depName";//公司

    //驾驶人员
    public static final String TABBLE_INSPECT_DRIVE = "inspectDrive";
    public static final String DRIVERNAME = "fullname";//姓名
    public static final String DRIVERID = "profileId";//ID
//    public static final String USERCODE = "userCode";//公司名
//    public static final String ECARD = "eCard";//公司名

    //驾驶人员本地
    public static final String TABBLE_INSPECT_DRIVE_P = "inspectDriveP";
    public static final String FULLNAME = "fullname";
    public static final String PROFILEID = "profileId";
    public static final String USERCODE = "userCode";
    public static final String SEX = "sex";

    //检查人
    public static final String TABBLE_CHECK_UP = "checkUp";
    public static final String CHECKUPNAME = "fullname";
    public static final String CHECKUPID = "profileId";
    public static final String CHECKUPUSERCODE = "userCode";
    public static final String CHECKUPSEX = "sex";



    //宜春内部人员
    public static final String TABBLE_YC_PERSON = "ycPerson";
    public static final String FULL_NAME = "fullname";
    public static final String ECARD = "eCard";
    public static final String SORT = "sort";


}
