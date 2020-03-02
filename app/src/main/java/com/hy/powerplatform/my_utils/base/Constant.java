package com.hy.powerplatform.my_utils.base;

import com.hy.powerplatform.SharedPreferencesHelper;

/**
 * Created by dell on 2017/4/20.
 */

public class Constant {
    static SharedPreferencesHelper sharedPreferencesHelper = new SharedPreferencesHelper(MyApplication.getContextObject(),"login");
    public static String found = sharedPreferencesHelper.getData(MyApplication.getContextObject(),"Found","");
//    public String BASE_URL="http://"+sharedPreferencesHelper.getData(MyApplication.getContextObject(),"Ip","")
//            +":"+sharedPreferencesHelper.getData(MyApplication.getContextObject(),"Socket","")+"/"+found+"/";

    public String BASE_URL="http://"+sharedPreferencesHelper.getData(MyApplication.getContextObject(),"Ip","")
                +":"+sharedPreferencesHelper.getData(MyApplication.getContextObject(),"Socket","")+"/"+found+"/";
    public static final String BASE_URL1="http://"+sharedPreferencesHelper.getData(MyApplication.getContextObject(),"Ip","")
                +":"+sharedPreferencesHelper.getData(MyApplication.getContextObject(),"Socket","")+"/"+found+"/";
    public static String BASE_URL2="http://"+sharedPreferencesHelper.getData(MyApplication.getContextObject(),"Ip","")
            +":"+sharedPreferencesHelper.getData(MyApplication.getContextObject(),"Socket","")+"/"+found+"/";

    public static final String LOGIN_HTTP_TAG="10001";//登录
    public static final String DOWNLOAD="下载中";
    public static final String GETDATA="获取数据中";
    public static final String REGISTER="注册中...";
    public static final String LOGIN="登录中...";
    public static final String UPRESULT="提交成绩";
    public static final String UPDATA="提交数据";
    public static final String CHECK="修改中";

    public static final int TAG_ONE=1;
    public static final int TAG_TWO=2;
    public static final int TAG_THERE=3;
    public static final int TAG_FOUR=4;
    public static final int TAG_FIVE=5;
    public static final int TAG_SIX=6;
    public static final int TAG_SEVEN=7;
    public static final int TAG_EIGHT=8;
    public static final int TAG_NINE=9;
    public static final int TAG_TEN=10;
    // request参数
    public static final int REQ_QR_CODE = 11002; // // 打开扫描界面请求码
    public static final int REQ_PERM_CAMERA = 11003; // 打开摄像头
    public static final int REQ_PERM_EXTERNAL_STORAGE = 11004; // 读写文件

    public static final String INTENT_EXTRA_KEY_QR_SCAN = "qr_scan_result";
    public static final String TAG="1";


    //获取收件箱列表
    public static final String  GETINBOX = "/communicate/listMail.do";
    //获取签字列表
    public static final String  FLOWMESSAGE = "htmobile/getMobileDetailTask.do";
    //历史列表
    public static final String  HISTORYLIST = "flow/historyProcessRun.do?start=";
    //我的代办列表
    public static final String  MYWILLDOLIST = "flow/mobileTypeListTask.do?start=";
    //与我相关列表
    public static final String  WithMeLIST = "flow/relevantListTask.do?start=";
    //获取版本号
    public static final String  VERSIONNO = "system/getVersionMsgAppVersionSetting.do";

    //我的流程详情
    public static final String  FIELDETAIL = Constant.BASE_URL2+"attachFiles/";

    //附件下载
    public static final String  FILEDATA = "flow/getFileProcessActivity.do";

    //提交数据
    public static final String  PERSONLIST = "hrm/profileByPosEmpProfile.do";

    //获取代办数量
    public static final String  NUMDAIBAN = "flow/mobileGetNoticeTask.do";

    //入职春城通科技选择路径
    public static final String  RZCCT = "system/getUserByDepAppUser.do";

    //我的流程
    public static final String  MYLIST = "flow/myProcessRun.do?start=";

    //我的流程详情
    public static final String  MYLISTDETAIL = "htmobile/getMoblieFormTask.do?runId=";

    //提交数据
    public static final String  UPDATAU = "flow/saveProcessActivity.do";
    //获取代办列表
    public static final String  WILLDOLIST = "flow/mobileListTask.do?start=";
    //获取代办详情
    public static final String  DETAILWILL = "htmobile/moblieGetTask.do?activityName=";
    //获取代办数量
    public static final String  DETAILWILLNUM = "flow/mobileCountListTask.do";
    // 请求第一个处理人  之后不再让别人处理
    public static final String  LASTPERSON = "flow/checkTask.do";
    // 最后不是end的下一级审核人
    public static final String  NOENDPERSON = "flow/mobileUsersProcessActivity.do";
    // 正常下一级审核人
    public static final String  NESTPERSON = "flow/mobileOuterTransProcessActivity.do";

    // 审核人签字提交
    public static final String  EXAMINEDATA = "flow/nextProcessActivity.do";

    // 获取追回列表
    public static final String  BACKFLOWLIST = "flow/myRunningProcessRun.do";
    // 获取追回
    public static final String  BACKFLOW = "flow/rollbackRevokeFlowDetail.do?runId=";
    // 获取确认列表
    public static final String  BACKFLOWSURELIST = "flow/listRevokeFlowDetail.do";
    // 获取确认
    public static final String  BACKFLOWSURE = "flow/checkRevokeFlowDetail.do";
    // 流程作废
    public static final String  NULLIFY = "flow/discardProcessRun.do";
    // 督办列表
    public static final String  DBLIST = "task/myTaskListSuperWorkTask.do";
    // 代办督办列表
    public static final String  DBLIST1 = "task/mySuperList2SuperWorkTask.do";
    // 督办确认编辑
    public static final String  DBQRBJ = "task/saveSuperWorkTask.do";
    // 督办确认提交
    public static final String  DBQRTJ = "task/submitSuperWorkTask.do";
    // 督办确认综合管理部人员
    public static final String  DBZHGLBRY = "system/subordinateSubordinate.do";
    // 督办发布选好执行人后关联督办人
    public static final String  DBFBABOUTPER = "system/findDinate2Subordinate.do";
    // 督办确认发布
    public static final String  DBQRFB = "task/multiPublishSuperWorkTask.do";
    // 督办详情附件
    public static final String  DBXQFJ = "task/getSuperWorkTask.do";
    // 督办删除
    public static final String  DBDEL = "task/multiDelSuperWorkTask.do";
    // 督办执行
    public static final String  DBZXLIST = "task/myListSuperTaskOper.do";
    // 督办变换状态
    public static final String  DBCHANGETYPE = "task/updateStatusSuperTaskOper.do";
    // 督办处理
    public static final String  DBCHULI = "task/submitSuperTaskOper.do";
    // 督办修改
    public static final String  DBXG = "task/updateTwoSuperTaskOper.do";
    // 督办催办
    public static final String  DBCB = "task/urgeExecutorSuperWorkTask.do";
    // 督办退回
    public static final String  DBBACK = "task/updateStatusSuperTaskOper.do";
    // 督办查看是否已经添加日程
    public static final String  DBTJRCO = "task/listCalendarPlan.do";
    // 督办添加日程
    public static final String  DBTJRC = "task/magSaveCalendarPlan.do";
    // 管理督办列表
    public static final String  DBGLLIST = "task/mySuperListSuperWorkTask.do";
    // 督办冻结
    public static final String  DBDJ = "task/frozenSuperWorkTask.do";
    // 督办启用
    public static final String  DBQY = "task/enableSuperWorkTask.do";
    // 督办查看
    public static final String  DBCKLIST = "task/list2SuperTaskOper.do";
    // 督办查看详情
    public static final String  DBCKXQ = "task/getSuperTaskOper.do";
    // 督办查看催办
    public static final String  DBCKCB = "task/urgeSupervisorSuperWorkTask.do";
    // 督办查看修改
    public static final String  DBCKXG = "task/agreeRs2SuperTaskOper.do";
    // 督办查看审核状态
    public static final String  DBCKSHZT = "task/authControlUserSuperTaskOper.do";
    // 督办查看审核状态确认
    public static final String  DBCKSHZTQR = "task/confirmSuperTaskOper.do";
    // 督办查看审核状态否定
    public static final String  DBCKSHZTFD = "task/negativeSuperTaskOper.do";
    // 督办查看审核状态驳回返回
    public static final String  DBCKSHZTBH = "task/rejectSuperTaskOper.do";
    // 督办检查人
    public static final String  DBPERSON = "system/dialogAppUser.do?curDep=true";
    // 获取应聘人信息
    public static final String  YINGPIN = "hrm/listResume.do";
    // 获取实习人信息
    public static final String  SHIXI = "hrm/getDriverPracticeFileListEmpProfile.do";
    // 获取正式员工信息
    public static final String  ZENGSHI = "hrm/conList1EmpProfile.do";
    // 车型
    public static final String  CARTYPE = "admin/getDataStoreCar.do";
    // 车辆档案
    public static final String  CARDANGAN = "admin/custListCar.do";
    // 获取部门
    public static final String  DEPARTMENT = "system/getTreeNewOrganization.do";
    // 线路查询
    public static final String  LINESEARCH = "system/getLinesByDepLineInfo.do";
    // 公告
    public static final String  NOTICE = "info/listNews.do";
    // 我的待开会议
    public static final String  MYWILLOPEN = "admin/myJoinConference.do";
    // 我的已开会议
    public static final String  MYOVEROPEN = "admin/myJoinedConference.do";
    // 待开会议
    public static final String  WILLOPEN = "admin/waitOpenConference.do";
    // 会议纪要
    public static final String  JIYAO = "admin/listConfSummary.do";
    // 违章查询
    public static final String  WEIZHANG = "busmanager/listViolationRecord.do";
    // 事故档案
    public static final String  SHIGUDANGAN = "busmanager/listAccidentBasicInformation.do";
    // 生产营运
    public static final String  SHENGCHANYY = "starkh/operationIndexReportImportYYData.do";
    // 营运指标
    public static final String  YINGYUNZHIBIAO = "starkh/operationAnalysisImportYYData.do";
    // 通讯录
    public static final String  PHONE = "system/getDepUsersAppUser.do";
    // 通讯录部门
    public static final String  PHONEDEP = "system/getDepStoreOrganization.do";
    // 登录次数
    public static final String  LOGINPERSON = "system/listLoginAnalysisAppUser.do";
    // 获取首页营运数据
    public static final String  YINGYUNDATA = "starkh/dataSynthesisAnalysisImportYYData.do";

    // 统计分析（一级菜单）
    //人员统计分析
    public static final String  PERSONTJ = "hrm/postCountListEmpProfile.do";
    //获取所有部门
    public static final String  DEPARTMENTS = "system/treeNewOrganization.do?demId=1";
    //获取更新历史
    public static final String  APPUPDATA = "system/listAppVersionSetting.do";
    //获取首页指标数据
    public static final String  ZB = "system/getIndexReportIndexAuthority.do";

    //年度每月里程
    public static final String  YEARMILE = "busmanager/getMile_bigDataDriverMileDetail.do";
    //百公里营收成本对比
    public static final String  COSTCOMPARISON = "starkh/revenueCostAnalysisImportYYData.do";
    //月度燃油燃气和充电金额汇总占比
    public static final String  HUIZONG = "starkh/elecAndFuelCountImportYYData.do";
    //月度材料消耗类型统计
    public static final String  CLXHTJ = "starkh/materialOutgoingAmountImportYYData.do";
    //月度异常班次
    public static final String  YUEDUYCBC = "starkh/getCountTypeAbnormalShiftsRecord.do";
    //月度违规次数
    public static final String  YUEDUWGCS = "starkh/getViolationsCountDriverViolation.do";
    //营运收入类型分析
    public static final String  YINGYUNSHOURU = "starkh/revenueTypeDataImportYYData.do";
    //人员变动统计分析
    public static final String  PERSONCHANGE = "hrm/getEmpDepChangeBar_bigDataEmpProfile.do";
    // 获取首页流程审核情况
    public static final String  OAFLOWNUM = "flow/getHistoryCountProcessRun.do";
    // 公告状态
    public static final String  NOTICETYPE = "info/addReadCountNews.do";
    // 个人中心数据
    public static final String  PERSONCENTER = "system/getLogTimeByIpAppUser.do";
    // 获取督办数量
    public static final String  DBNUM = "task/getSuperviseCountSuperTaskOper.do";
    // 获取公告数量
    public static final String  GGNUM = "info/getNoticeCountNews.do";
    // 获取会议数量
    public static final String  HYNUM = "admin/getMeetingCountConference.do";
    // 获取入职人员
    public static final String  ENTRYPERSON = "hrm/getListResume.do";

    public static final String  LEAVERNAME = "请假流程";
    public static final String  PAYFLOWNAME = "付款程序审批单";
    public static final String  CONTRACEPAYNAME = "合同付款审批单";
    public static final String  CONTRACTSIGNNAME = "合同签订审批流程";
    public static final String  GHCONTRACTSIGNNAME = "工会合同签订审批单";
    public static final String  GOODSPUECHASENAME = "物品采购计划表";
    public static final String  WORKPUECHASENAME = "办公用品采购申请单";
    public static final String  CCTPUECHASENAME = "子公司物品采购计划表";
    public static final String  GHPUECHASENAME = "工会物品采购计划表";
    public static final String  ZGSPAYNAME = "子公司付款流程";
    public static final String  GHPAYFLOWNAME = "工会付款程序审批单";
    public static final String  PUECHASEFLOWNAME = "物品采购计划表3000元以上";
    public static final String  ENTRYNAMENAME = "驾驶员入职流程表";
    public static final String  OUTMESSAGENAME = "宜春公交集团发文";
    public static final String  CARNAME = "公务车用车派车单";
    public static final String  REPAIRNAME = "报修项目登记表";
    public static final String  CHUCAINAME = "出差申请审批表";
    public static final String  GCADDNAME = "建设工程量增加审批单";
    public static final String  GCCHECKNAME = "建设工程变更审批单";
    public static final String  OVERTINENAME = "公司员工加班申请单";
    public static final String  CARSAFENAME = "车辆保险费审批单";
    public static final String  CARVIDEONAME = "车载监控视频调阅审批";
    public static final String  DRIVERASSESSNAME = "驾驶员考核评分表";
    public static final String  ASSESSNAME = "员工入职";
    public static final String  USERCARNAME = "公务车用车派车单";
    public static final String  DINNERNAME = "接待用餐审批表";
    public static final String  COMPLAINNAME = "安全服务部投诉转办单";
    public static final String  INSTALLNNAME = "宜春公交集团项目申办表";
    public static final String  JSGCNAME = "新建工程启动审批流程";
    public static final String  EMAINTAINNAME = "信息技术部电子设备故障维修";
    public static final String  DORMNAME = "员工宿舍申请表";
    public static final String  APPEALNAME = "公司请示上报流程";
    public static final String  BILLNAME = "交通事故费用借款审批单";
    public static final String  SAFERNAMES = "保险费借款单商业险";
    public static final String  SAFERNAMEY = "保险费借款单意外险";
    public static final String  HUIQIANNAME = "会签流程";
    public static final String  COMPMESSAGENAME = "公司信息发布审批单";

//    formdifid
    public static final String  LEAVER = "83";
    public static final String  PAYFLOW = "10078";
    public static final String  CONTRACEPAY = "85";
    public static final String  CONTRACTSIGN = "66";
    public static final String  GOODSPUECHASE = "84";
    public static final String  CCTPUECHASE = "10100";
    public static final String  GHPUECHASE = "10127";
    public static final String  GHPAYFLOW = "10128";
    public static final String  ZGSFLOW = "10132";//10133
    public static final String  GHCONTRACTSINGLE = "10129";
    public static final String  PUECHASEFLOW = "10103";
    public static final String  ENTRY = "10117";
    public static final String  WORKENTRY = "10142";
    public static final String  OUTMESSAGE = "10076";
    public static final String  WORKPUECHASE = "86";
    public static final String  REPAIR = "10105";
    public static final String  CHUCAI = "67";
    public static final String  GCADD = "10108";
    public static final String  GCCHECK = "10109";
    public static final String  OVERTIME = "73";
    public static final String  CARSAFE = "60";
    public static final String  CARVIDEO = "10125";
    public static final String  DRIVERASSESS = "10121";
    public static final String  USERCAR = "10114";
    public static final String  DINNER = "62";
    public static final String  COMPLAIN = "10082";
    public static final String  INSTALL = "10087";
    public static final String  GCQD = "10107";
    public static final String  EMAINTAIN = "10111";
    public static final String  DORM = "10104";
    public static final String  APPEAL = "10134";//10113
    public static final String  BILL = "10098";
    public static final String  SAFER1 = "10084";
    public static final String  SAFER2 = "10083";
    public static final String  HUIQIAN = "10124";
    public static final String  COMPMESSAGE = "10110";
    public static final String  GHSINGLE = "10129";

//defid
    public static final String  LEAVERDIFID = "10135";
    public static final String  PAYFLOWDIFID = "10151";
    public static final String  CONTRACEPAYDIFID = "10093";
    public static final String  CONTRACTSIGNDIFID = "10165";
    public static final String  GHCONTRACTSIGNDIFID = "20461";
    public static final String  GOODSPUECHASEDIFID = "10183";
    public static final String  CCTPUECHASEDIFID = "20274";
    public static final String  GHPUECHASEDIFID = "20459";
    public static final String  GHPAYFLOWDIFID = "20460";
    public static final String  ZGSFLOWDIFID = "20504";//20513
    public static final String  PUECHASEFLOWDIFID = "20271";
    public static final String  ENTRYDIFID = "10105";
    public static final String  WORKENTRYDIFID = "20534";
    public static final String  OUTMESSAGEDIFID = "20200";
    public static final String  WORKPUECHASEDIFID = "10092";
    public static final String  REPAIRDIFID = "20307";
    public static final String  CHUCAIDIFID = "10149";
    public static final String  GCADDDIFID = "20249";
    public static final String  GCCHECKDIFID = "20244";
    public static final String  OVERTIMEDIFID = "10106";
    public static final String  CARSAFEDIFID = "10150";
    public static final String  CARVIDEODIFID = "20324";
    public static final String  DRIVERASSESSDIFID = "20373";
    public static final String  USERCARDIFID = "20393";
    public static final String  DINNERDIFID = "10152";
    public static final String  COMPLAINDIFID = "20239";
    public static final String  INSTALLDIFID = "20232";
    public static final String  GCQDDIFID = "20233";
    public static final String  EMAINTAINDIFID = "20411";
    public static final String  DORMDIFID = "20308";
    public static final String  APPEALDIFID = "20520";//20528
    public static final String  BILLDIFID = "20226";
    public static final String  SAFER1DIFID = "20224";
    public static final String  SAFER2DIFID = "20225";
    public static final String  HUIQIANDIFID = "20382";
    public static final String  COMPMESSAGEDIFID = "10094";

}
