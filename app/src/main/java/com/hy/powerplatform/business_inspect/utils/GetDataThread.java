package com.hy.powerplatform.business_inspect.utils;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.hy.powerplatform.business_inspect.bean.CarCode;
import com.hy.powerplatform.business_inspect.bean.CheckUp;
import com.hy.powerplatform.business_inspect.bean.DriverP;
import com.hy.powerplatform.business_inspect.bean.InspectDrive;
import com.hy.powerplatform.business_inspect.bean.InspectLine;
import com.hy.powerplatform.business_inspect.bean.NewDriver;
import com.hy.powerplatform.business_inspect.bean.ShowLine;
import com.hy.powerplatform.database.Constant;
import com.hy.powerplatform.database.DbManager;
import com.hy.powerplatform.database.MyDatabaseHelper;

import java.util.List;


/**
 * Created by dell on 2017/12/18.
 */

public class GetDataThread {

    /**
     * 保存车牌号信息
     * @param carCode
     * @param db
     * @param helper
     * @param listCarCode
     */
    public static void saveCarCoodeData(final CarCode carCode, final SQLiteDatabase db,
                                        MyDatabaseHelper helper, final List<CarCode.DataBean> listCarCode) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                int num = carCode.getData().size();
                for (int i = 0; i < carCode.getData().size(); i++) {
                    String carName = carCode.getData().get(i).getName();
                    String carvalue = carCode.getData().get(i).getValue();
                    CarCode.DataBean carCode = new CarCode.DataBean(carName, carvalue);
                    listCarCode.add(carCode);
                    ContentValues values = new ContentValues();
                    values.put(Constant.CARNAME, carName);
                    values.put(Constant.CARVALUE, carvalue);
                    db.insert(Constant.TABBLE_CAR_NAME, null, values);
                    values.clear();
                }
            }
        }).start();
    }

    /**
     * 保存检查人信息
     * @param checkUp
     * @param db
     * @param helper
     * @param listCheckUp
     */
    public static void saveCheckUpData(final CheckUp checkUp, final SQLiteDatabase db,
                                        MyDatabaseHelper helper, final List<CheckUp.DataBean> listCheckUp) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                int num = checkUp.getData().size();
                for (int i = 0; i < checkUp.getData().size(); i++) {
                    String checkUpName = checkUp.getData().get(i).getFullname();
                    String checkUpId = checkUp.getData().get(i).getProfileId();
                    String checkUpSex = checkUp.getData().get(i).getSex();
                    String checkUpUserCode = checkUp.getData().get(i).getUserCode();
                    CheckUp.DataBean checkUp = new CheckUp.DataBean(checkUpName,checkUpId,checkUpUserCode,checkUpSex);
                    listCheckUp.add(checkUp);
                    ContentValues values = new ContentValues();
                    values.put(Constant.CHECKUPNAME, checkUpName);
                    values.put(Constant.CHECKUPID, checkUpId);
                    values.put(Constant.CHECKUPUSERCODE, checkUpUserCode);
                    values.put(Constant.CHECKUPSEX, checkUpSex);
                    db.insert(Constant.TABBLE_CHECK_UP, null, values);
                    values.clear();
                }
            }
        }).start();
    }

    /**
     * 保存线路信息
     * @param inspectLine
     * @param db
     * @param helper
     * @param listInspectLine
     */
    public static void saveInspectLineData(final InspectLine inspectLine, final SQLiteDatabase db,
                                           MyDatabaseHelper helper, final List<InspectLine.DataBean> listInspectLine) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < inspectLine.getData().size(); i++) {
                    String depID = inspectLine.getData().get(i).getDepId();
                    String lineCode = inspectLine.getData().get(i).getLineCode();
                    String depName = inspectLine.getData().get(i).getDepName();
//                    InspectLine.DataBean inspectLine = new InspectLine.DataBean(lineName,lineCode);
                    listInspectLine.add(inspectLine.getData().get(i));
                    ContentValues values = new ContentValues();
                    values.put(Constant.LINEDEPID, depID);
                    values.put(Constant.LINECODE, lineCode);
                    values.put(Constant.LINEDEPNAME, depName);
                    db.insert(Constant.TABBLE_INSPECT_LINE, null, values);
                    values.clear();
                }
            }
        }).start();
    }

    /**
     * 保存驾驶员
     * @param inspectDrive
     * @param db
     * @param helper
     * @param listInspectDrive
     */
    public static void saveInspectDriveData(final InspectDrive inspectDrive, final SQLiteDatabase db,
                                            MyDatabaseHelper helper, final List<InspectDrive.DataBean> listInspectDrive) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < inspectDrive.getData().size(); i++) {
                    String driveName = inspectDrive.getData().get(i).getFullname();
                    String driveId = inspectDrive.getData().get(i).getProfileId();
                    String userCode = inspectDrive.getData().get(i).getUserCode();
                    String eCard = inspectDrive.getData().get(i).getECard();
                    String sex = inspectDrive.getData().get(i).getSex();
                    InspectDrive.DataBean inspectDrive = new InspectDrive.DataBean(driveName,driveId,userCode,eCard,sex);
                    listInspectDrive.add(inspectDrive);
                    ContentValues values = new ContentValues();
                    values.put(Constant.DRIVERNAME, driveName);
                    values.put(Constant.DRIVERID, driveId);
//                    values.put(Constant.USERCODE, userCode);
//                    values.put(Constant.ECARD, eCard);
                    values.put(Constant.SEX, sex);
                    db.insert(Constant.TABBLE_INSPECT_DRIVE, null, values);
                    values.clear();
                }
            }
        }).start();
    }

    /**
     * 保存驾驶员
     * @param inspectDrive
     * @param db
     * @param helper
     * @param listInspectDrive
     */
    public static void saveInspectDrivePData(final DriverP inspectDrive, final SQLiteDatabase db,
                                             MyDatabaseHelper helper, final List<DriverP.DataBean> listInspectDrive) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < inspectDrive.getData().size(); i++) {
                    String driveName = inspectDrive.getData().get(i).getFullname();
                    String driveId = inspectDrive.getData().get(i).getProfileId();
                    String depId = String.valueOf(inspectDrive.getData().get(i).getSex());
                    DriverP.DataBean inspectDrive = new DriverP.DataBean(driveName,driveId,depId);
                    listInspectDrive.add(inspectDrive);
                    ContentValues values = new ContentValues();
                    values.put(Constant.FULLNAME, driveName);
                    values.put(Constant.PROFILEID, driveId);
                    values.put(Constant.SEX, depId);
                    db.insert(Constant.TABBLE_INSPECT_DRIVE_P, null, values);
                    values.clear();
                }
            }
        }).start();
    }

    /**
     * 将车牌号course转化成list
     * @param etText
     * @param cursor
     * @param db
     * @param listCarCodeFromdb
     * @param baseRequestAssessLisenter
     */
    public static void getCarCoodeData(String etText, Cursor cursor, SQLiteDatabase db, List<CarCode.DataBean> listCarCodeFromdb,
                                       BaseRequestAssessLisenter baseRequestAssessLisenter) {
        String sql = "select * from carcode where name like '%" + etText + "%'";
        cursor = DbManager.queryBySQL(db, sql, null);
        listCarCodeFromdb = DbManager.cursorToClassCar(cursor);
        //通过回调讲结果发出
        if (baseRequestAssessLisenter != null) {
            baseRequestAssessLisenter.success(listCarCodeFromdb);
        }
    }

    /**
     * 将洗车工course转化成list
     * @param etText
     * @param cursor
     * @param db
     * @param listCheckUpFromdb
     * @param baseRequestAssessLisenter
     */
    public static void getCheckUpData(String etText, Cursor cursor, SQLiteDatabase db, List<CheckUp.DataBean> listCheckUpFromdb,
                                       BaseRequestAssessLisenter baseRequestAssessLisenter) {
        String sql = "select * from checkUp where fullname like '%" + etText + "%'";
        cursor = DbManager.queryBySQL(db, sql, null);
        listCheckUpFromdb = DbManager.cursorToCheckUp(cursor);
        //通过回调讲结果发出
        if (baseRequestAssessLisenter != null) {
            baseRequestAssessLisenter.success(listCheckUpFromdb);
        }
    }

    /**
     * 将线路course转换成list
     * @param etText
     * @param cursor
     * @param db
     * @param listInspectLine
     * @param baseRequestAssessLisenter
     */
    public static void getInspectLineData(String etText, Cursor cursor, SQLiteDatabase db, List<ShowLine> listInspectLine,
                                       BaseRequestAssessLisenter baseRequestAssessLisenter) {
        String sql = "select * from inspectLine where lineCode like '" + etText + "%'";
        cursor = DbManager.queryBySQL(db, sql, null);
        listInspectLine = DbManager.cursorToInspectLine(cursor);
        //通过回调讲结果发出
        if (baseRequestAssessLisenter != null) {
            baseRequestAssessLisenter.success(listInspectLine);
        }
    }


    public static void getInspectDriveData(String etText, Cursor cursor, SQLiteDatabase db, List<NewDriver.DataBean> listInspectDrive,
                                          BaseRequestAssessLisenter baseRequestAssessLisenter) {
        String sql = "select * from inspectDrive where driverName like '%" + etText + "%'";
        cursor = DbManager.queryBySQL(db, sql, null);
        listInspectDrive = DbManager.cursorToInspectDrive(cursor);
        //通过回调讲结果发出
        if (baseRequestAssessLisenter != null) {
            baseRequestAssessLisenter.success(listInspectDrive);
        }
    }

    public static void getInspectDrivePData(String etText, Cursor cursor, SQLiteDatabase db, List<DriverP.DataBean> listInspectDrive,
                                           BaseRequestAssessLisenter baseRequestAssessLisenter) {
        String sql = "select * from inspectDriveP where fullname like '%" + etText + "%'";
        cursor = DbManager.queryBySQL(db, sql, null);
        listInspectDrive = DbManager.cursorToInspectDriveP(cursor);
        //通过回调讲结果发出
        if (baseRequestAssessLisenter != null) {
            baseRequestAssessLisenter.success(listInspectDrive);
        }
    }


//    //得到判断题
//    public static void getTorFData(final TorFActivity torFActivity, final String classId, final MyDatabaseHelper helper,
//                                   final List<Question.BodyBean.ListBean> beanList,
//                                   final List<View> viewItems, final BaseRequestAssessLisenter baseRequestAssessLisenter){
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                SQLiteDatabase db = helper.getReadableDatabase();
//                String sql = "select * from moni where classid='"+classId+"' and quType='2'";
//                // cursor = db.query(Constant.TABBLE_NAME,null,Constant.ANSWER+"=?",new String[]{"1"},null,null,Constant.ID+" desc");
//                Cursor cursor = DbManager.queryBySQL(db, sql, null);
//                while (cursor.moveToNext()) {
//                    // 根据参数指定的字段来读取字段下标
//                    int index = cursor.getColumnIndex(Constant.ID);
//                    // 根据参数中指定的字段下标来获取指定的数据
//                    int id = cursor.getInt(index);
//                    String ID = cursor.getString(cursor.getColumnIndex(Constant.ID));
//                    String quContent = cursor.getString(cursor.getColumnIndex(Constant.QUCONTENT));
//                    String quType = cursor.getString(cursor.getColumnIndex(Constant.QUTYPE));
//                    String quAnswer = cursor.getString(cursor.getColumnIndex(Constant.QUANSWER));
//                    String quA = cursor.getString(cursor.getColumnIndex(Constant.QUA));
//                    String quB = cursor.getString(cursor.getColumnIndex(Constant.QUB));
//                    String quC = cursor.getString(cursor.getColumnIndex(Constant.QUC));
//                    String quD = cursor.getString(cursor.getColumnIndex(Constant.QUD));
//                    String quE = cursor.getString(cursor.getColumnIndex(Constant.QUE));
//                    String quF = cursor.getString(cursor.getColumnIndex(Constant.QUF));
//                    String quAnalyze = cursor.getString(cursor.getColumnIndex(Constant.QUANALYZE));
//                    String quCategory = cursor.getString(cursor.getColumnIndex(Constant.QUCATEGORY));
//                    String classId = cursor.getString(cursor.getColumnIndex(Constant.CLASSID));
//                    Question.BodyBean.ListBean resultBean = new Question.BodyBean.ListBean
//                            (ID, quType, quContent, quA, quB, quC, quD, quE, quF, quAnswer,quCategory, quAnalyze, classId);
//                    beanList.add(resultBean);
//                }
//                for (int i = 0; i < beanList.size(); i++) {
//                    viewItems.add(torFActivity.getLayoutInflater().inflate(
//                            R.layout.vote_submit_viewpager_item, null));
//                }
//                //通过回调讲结果发出
//                if (baseRequestAssessLisenter!=null){
//                    baseRequestAssessLisenter.success(viewItems,beanList);
//                }
//
//            }
//        }).start();
//    }
//
//
//
//    //得到判断题
//    public static void getMoreSelectData(final MoreSelectActivity moreSelectActivity, final String classId, final MyDatabaseHelper helper,
//                                         final List<Question.BodyBean.ListBean> beanList,
//                                         final List<View> viewItems, final BaseRequestAssessLisenter baseRequestAssessLisenter){
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                SQLiteDatabase db = helper.getReadableDatabase();
//                String sql = "select * from moni where classid='"+classId+"' and quType='1'";
//                // cursor = db.query(Constant.TABBLE_NAME,null,Constant.ANSWER+"=?",new String[]{"1"},null,null,Constant.ID+" desc");
//                Cursor cursor = DbManager.queryBySQL(db, sql, null);
//                while (cursor.moveToNext()) {
//                    // 根据参数指定的字段来读取字段下标
//                    int index = cursor.getColumnIndex(Constant.ID);
//                    // 根据参数中指定的字段下标来获取指定的数据
//                    int id = cursor.getInt(index);
//                    String ID = cursor.getString(cursor.getColumnIndex(Constant.ID));
//                    String quContent = cursor.getString(cursor.getColumnIndex(Constant.QUCONTENT));
//                    String quType = cursor.getString(cursor.getColumnIndex(Constant.QUTYPE));
//                    String quAnswer = cursor.getString(cursor.getColumnIndex(Constant.QUANSWER));
//                    String quA = cursor.getString(cursor.getColumnIndex(Constant.QUA));
//                    String quB = cursor.getString(cursor.getColumnIndex(Constant.QUB));
//                    String quC = cursor.getString(cursor.getColumnIndex(Constant.QUC));
//                    String quD = cursor.getString(cursor.getColumnIndex(Constant.QUD));
//                    String quE = cursor.getString(cursor.getColumnIndex(Constant.QUE));
//                    String quF = cursor.getString(cursor.getColumnIndex(Constant.QUF));
//                    String quAnalyze = cursor.getString(cursor.getColumnIndex(Constant.QUANALYZE));
//                    String quCategory = cursor.getString(cursor.getColumnIndex(Constant.QUCATEGORY));
//                    String classId = cursor.getString(cursor.getColumnIndex(Constant.CLASSID));
//                    Question.BodyBean.ListBean resultBean = new Question.BodyBean.ListBean
//                            (ID, quType, quContent, quA, quB, quC, quD, quE, quF, quAnswer, quAnalyze,quCategory, classId);
//                    beanList.add(resultBean);
//                }
//                for (int i = 0; i < beanList.size(); i++) {
//                    viewItems.add(moreSelectActivity.getLayoutInflater().inflate(
//                            R.layout.vote_submit_viewpager_item, null));
//                }
//                //通过回调讲结果发出
//                if (baseRequestAssessLisenter!=null){
//                    baseRequestAssessLisenter.success(viewItems,beanList);
//                }
//
//            }
//        }).start();
//    }
//
//
//
//    //得到错题集
//    public static void getErrorData(final ErrorActivity errorActivity, final String classId, final MyDatabaseHelper helper,
//                                    final List<Question.BodyBean.ListBean> beanList,
//                                    final List<View> viewItems, final BaseRequestAssessLisenter baseRequestAssessLisenter){
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                SQLiteDatabase db = helper.getReadableDatabase();
//                String sql = "select * from error";
//                Cursor cursor = DbManager.queryBySQL(db, sql, null);
//                while (cursor.moveToNext()) {
//                    // 根据参数指定的字段来读取字段下标
//                    int index = cursor.getColumnIndex(Constant.ID);
//                    // 根据参数中指定的字段下标来获取指定的数据
//                    int id = cursor.getInt(index);
//                    String ID = cursor.getString(cursor.getColumnIndex(Constant.ID));
//                    String quContent = cursor.getString(cursor.getColumnIndex(Constant.QUCONTENT));
//                    String quType = cursor.getString(cursor.getColumnIndex(Constant.QUTYPE));
//                    String quAnswer = cursor.getString(cursor.getColumnIndex(Constant.QUANSWER));
//                    String quA = cursor.getString(cursor.getColumnIndex(Constant.QUA));
//                    String quB = cursor.getString(cursor.getColumnIndex(Constant.QUB));
//                    String quC = cursor.getString(cursor.getColumnIndex(Constant.QUC));
//                    String quD = cursor.getString(cursor.getColumnIndex(Constant.QUD));
//                    String quE = cursor.getString(cursor.getColumnIndex(Constant.QUE));
//                    String quF = cursor.getString(cursor.getColumnIndex(Constant.QUF));
//                    String quAnalyze = cursor.getString(cursor.getColumnIndex(Constant.QUANALYZE));
//                    String quCategory = cursor.getString(cursor.getColumnIndex(Constant.QUCATEGORY));
//                    String classId = cursor.getString(cursor.getColumnIndex(Constant.CLASSID));
//                    Question.BodyBean.ListBean resultBean = new Question.BodyBean.ListBean
//                            (ID, quType, quContent, quA, quB, quC, quD, quE, quF, quAnswer, quAnalyze,quCategory, classId);
//                    beanList.add(resultBean);
//                }
//                for (int i = 0; i < beanList.size(); i++) {
//                    viewItems.add(errorActivity.getLayoutInflater().inflate(
//                            R.layout.vote_submit_viewpager_item, null));
//                }
//                //通过回调讲结果发出
//                if (baseRequestAssessLisenter!=null){
//                    baseRequestAssessLisenter.success(viewItems,beanList);
//                }
//
//            }
//        }).start();
//    }
}
