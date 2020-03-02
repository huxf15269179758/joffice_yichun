package com.hy.powerplatform.my_utils.base;


import com.hy.powerplatform.business_inspect.bean.CarCode;
import com.hy.powerplatform.business_inspect.bean.CheckPerson;
import com.hy.powerplatform.business_inspect.bean.CheckUp;
import com.hy.powerplatform.business_inspect.bean.Correlat;
import com.hy.powerplatform.business_inspect.bean.DriverP;
import com.hy.powerplatform.business_inspect.bean.InspectAll;
import com.hy.powerplatform.business_inspect.bean.InspectDrive;
import com.hy.powerplatform.business_inspect.bean.InspectHealth;
import com.hy.powerplatform.business_inspect.bean.InspectLine;
import com.hy.powerplatform.business_inspect.bean.InspectSkill;
import com.hy.powerplatform.business_inspect.bean.InspectStarte;
import com.hy.powerplatform.business_inspect.bean.InspectSuffeer;
import com.hy.powerplatform.business_inspect.bean.Matter;
import com.hy.powerplatform.business_inspect.bean.ShiGuHis;
import com.hy.powerplatform.business_inspect.bean.YeWuList;
import com.hy.powerplatform.car_maintain.bean.AboutData;
import com.hy.powerplatform.car_maintain.bean.BaoXiuType;
import com.hy.powerplatform.car_maintain.bean.ClassIfy;
import com.hy.powerplatform.car_maintain.bean.Driver;
import com.hy.powerplatform.car_maintain.bean.JianChaRen;
import com.hy.powerplatform.car_maintain.bean.Line;
import com.hy.powerplatform.car_maintain.bean.LingLiao;
import com.hy.powerplatform.car_maintain.bean.LingLiaoItem;
import com.hy.powerplatform.car_maintain.bean.MainTainList;
import com.hy.powerplatform.car_maintain.bean.WeiXiuChang;
import com.hy.powerplatform.car_maintain.bean.zhibianhao;
import com.hy.powerplatform.duban.bean.DBCheckPerson;
import com.hy.powerplatform.login.bean.Login;
import com.hy.powerplatform.login.bean.MainData;
import com.hy.powerplatform.login.bean.News;
import com.hy.powerplatform.oa_flow.bean.FlowItem;
import com.hy.powerplatform.oa_flow.bean.FlowList;
import com.hy.powerplatform.phone.bean.Phone;
import com.hy.powerplatform.signin.bean.SignHis;
import com.hy.powerplatform.signin.bean.SignIn;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by win764-1 on 2016/12/12.
 */

public interface RetrofitService {
//    ===========================================用户相关===================================================

    /**
     *
     *
     * @param userName
     * @return
     */
    @GET("system/getStatusModuleManagement.do")
    Observable<MainData> getMainData(@Query("userName") String userName);

    /**
     * 登录接口
     * @param username
     * @param password
     * @return
     */
    @GET("mobile.do")
    Observable<Login> lgoin(@Query("username") String username, @Query("password") String password);

    /**
     * 新闻
     * @param username
     * @return
     */
    @GET("listNews.do")
    Observable<News> news(@Query("Q_isNotice_SN_EQ") String username);

    /**
     * 签到
     * @param userName
     * @param addr
     * @param rq
     * @param sj
     * @param photo
     * @return
     */
    @GET("hrm/saveDataAttendanceSheet.do")
    Observable<SignIn> SignIn(@Query("username") String userName, @Query("addr") String addr,
                              @Query("rq") String rq, @Query("sj") String sj, @Query("gps") String gps,
                              @Query("photo") String photo);

    /**
     * 签到历史
     * @param beginDate
     * @param endDate
     * @param userCode
     * @return
     */
    @GET("hrm/listMobileAttendanceSheet.do")
    Observable<SignHis> SignInHis(@Query("beginDate") String beginDate, @Query("endDate") String endDate,
                                  @Query("userCode") String userCode);

    /**
     * 卫生检查记录
     * @param beginDate
     * @param endDate
     * @param operCode
     * @return
     */
    @GET("starkh/listMobileWeishengJc.do")
    Observable<YeWuList> YeWuHis(@Query("beginDate") String beginDate, @Query("endDate") String endDate,
                                 @Query("operCode") String operCode);

    /**
     * 获取车牌号
     * @return
     */
    @GET("admin/getBusStoreCar.do")
    Observable<CarCode> carCode();

    /**
     * 获取关联数据
     * @return
     */
    @GET("admin/getBusLineAll2Car.do")
    Observable<Correlat> getCorrelation(@Query("busCode") String busCode, @Query("rq") String rq);

    /**
     * 获取车辆关联数据
     * @return
     */
    @GET("admin/getBusByLineCodeCar.do")
    Observable<CarCode> getCorrelatCarNo(@Query("lineCode") String lineCode, @Query("rq") String rq);


    /**
     * 获取线路
     * @return
     */
//    @GET("system/getLineStoreAllLineInfo.do")
    @GET("system/getLineStoreLineInfo.do")
    Observable<InspectLine> inspectLine();

    /**
     * 获取驾驶员
     * @return
     */
    @GET("hrm/profileByPosAllEmpProfile.do")
    Observable<InspectDrive> inspectDrive();


    /**
     * 获取驾驶员本地
     * @return
     */
    @GET("hrm/profileByPosEmpProfile.do")
    Observable<DriverP> getDriverP();

    /**
     * 获取洗车人
     * @return
     */
    @GET("hrm/profileByPosAllEmpProfile.do")
    Observable<CheckUp> getCheckUp();

    /**
     * 卫生检查项
     * @return
     */
    @GET("starkh/getProjectPhoneRewardPunishmentSurfaceType.do")
    Observable<Matter> getMatter();

    /**
     * 通讯录
     * @return
     */
    @GET("htmobile/listAddressBook.do?Q_phoneGroup.isPublic_SN_EQ%20=%200")
    Observable<Phone> getPhone(@Query("Q_appUser.userId_L_EQ") String userId);

    /**
     * 获取事故上报记录
     * @param starTime
     * @param endTime
     * @param userCode
     * @return
     */
    @GET("busmanager/listAccidentBasicInformation.do")
    Observable<ShiGuHis> getShiGu(@Query("beginDate") String starTime,
                                  @Query("endDate") String endTime,
                                  @Query("operCode") String userCode);

    /**
     * 服务卫生检查
     * @return
     */
    @GET("starkh/findFWWSCheckClassification.do")
    Observable<InspectHealth> inspectHealth();

    /**
     * 安全秩序
     * @return
     */
    @GET("starkh/findAnquanZhixuCheckClassification.do")
    Observable<InspectSuffeer> inspectSuffer();

    /**
     * 技术状况
     * @return
     */
    @GET("starkh/findJishuzkCheckClassification.do")
    Observable<InspectSkill> inspectSkill();

    /**
     * 综合考核
     * @return
     */
    @GET("starkh/getMoblieStoreCheckClassification.do")
    Observable<InspectAll> inspectAll();

    /**
     * 优服示范车考核
     * @return
     */
    @GET("starkh/getYouFuStoreCheckClassification.do")
    Observable<InspectStarte> inspectStarte();

    /**
     * 获取检查人
     * @return
     * ?depId=385&iswork=1
     */
    @GET("hrm/profileListEmpProfile.do")
    Observable<CheckPerson> getCheckPerson();

    /**
     * 获取督办检查人
     */
    @GET("system/dialogAppUser.do?curDep=true")
    Observable<DBCheckPerson> getDBCheckPerson();

    /**
     * 技术获取检查人
     * @return
     */
    @GET("hrm/profileListEmpProfile.do?depId=440&iswork=1")
    Observable<CheckPerson> getKillCheckPerson();

    /**
     * 获取卫生检查人
     * @return
     */
    @GET("hrm/profileListEmpProfile.do?depId=450&iswork=1")
    Observable<CheckPerson> getHealthCheckPerson();

    /**
     * 维修车辆数据列表
     * @return
     */
    @GET("repair/listMeasureBus.do")
    Observable<MainTainList> getMainTainListData(@Query("Q_createDate_D_GE") String starTime,
                                                 @Query("endDate") String endTime, @Query("Q_busCode_S_EQ") String Q_busCode_S_EQ);


    /**
     * 获取自编号车牌号
     * @return
     */
    @GET("admin/getBusBydepCar.do")
    Observable<zhibianhao> getZiBianHao();


    /**
     * 获取维修线路
     * @return
     */
    @GET("system/getLineStoreAllLineInfo.do")
    Observable<Line> getLine();

    /**
     * 获取维修司机
     * @return
     */
    @GET("hrm/selectJSYEmpProfile.do")
    Observable<Driver> getDriver();

    /**
     * 获取维修检查人
     * @return
     */
    @GET("system/comboItemDictionary.do?nodeKey=weixiujianyanren")
    Observable<JianChaRen> getJianChaRen();

    /**
     * 获取维修维修厂
     * @return
     */
    @GET("system/comboItemDictionary.do?nodeKey=weixiuchang")
    Observable<WeiXiuChang> getWeiXiuChang();

    /**
     * 获取维修维修类型
     * @return
     */
    @GET("system/comboItemDictionary.do?nodeKey=baoxiuleixing")
    Observable<BaoXiuType> getBaoXiuType();

    /**
     * 获取维修关联数据
     * @return
     */
    @GET("admin/getBusLineAllNewCar.do")
    Observable<AboutData> getAboutData(@Query("busCode") String busCode);

    /**
     * 获取维修维修领料列表
     * @return
     */
    @GET("repair/listAppMeasureBusWare.do")
    Observable<LingLiao> getLingLiao(@Query("createDate") String createDate,
                                     @Query("endDate") String endDate,
                                     @Query("busCode") String type);

    /**
     * 获取维修维修领料Item列表
     * @return
     */
    @GET("repair/getMeasureBus.do")
    Observable<LingLiaoItem> getLingLiaoItem(@Query("no") String xiCode);

    /**
     * 获取维修维维修领料添加项
     * @return
     */
    @GET("system/appTreeGlobalType.do?catKey=WZCLLB")
    Observable<ClassIfy> getClassIfy();


    /**
     * @param userName
     * 获取流程项
     * @return
     */
    @GET("system/getStatusModuleManagement.do")
    Observable<FlowItem> getFlowItemData(@Query("userName") String userName);

    /**
     * 获取流程列表
     * @return
     */
    @GET("guide")
    Observable<FlowList> getFlowListData(@Query("size") String size, @Query("page") String page,
                                         @Query("guideCategoryId") String guideCategoryId);
}
