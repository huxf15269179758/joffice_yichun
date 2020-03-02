package com.hy.powerplatform.oa_flow.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/3/8.
 */

public class FlowMessage1 implements Serializable {

    /**
     * success : true
     * data : [{"version":null,"orgId":null,"orgPath":null,"formId":74602,"activityName":"发起人","createtime":"2019-03-07 17:20:31","creatorId":9417,"creatorName":"刘望","endtime":"2019-03-07 17:20:31","durTimes":0,"fromTask":null,"fromTaskId":null,"taskId":null,"transTo":"to 交保证金","status":2,"usetimes":null,"comments":null,"preFormId":null,"processRun":{"version":null,"orgId":null,"orgPath":null,"runId":51535,"subject":"驾驶员入职流程表20190307-172031","creator":"刘望","assignee":null,"createtime":"2019-03-07 17:20:31","endtime":"2019-03-14 17:20:31","isMany":null,"showData":null,"piId":"JSYRZLCB4.8160169","pdId":"JSYRZLCB4-2","piDbid":8160169,"processName":"驾驶员入职流程表","busDesc":null,"entityName":"WF_jsyrzlcbnews","entityId":"9","formDefId":10117,"runStatus":1,"appUser":{"version":null,"orgId":null,"orgPath":null,"userId":9417,"username":"刘望","email":"","jobId":null,"phone":"","mobile":"","fax":"","address":"","zip":"","photo":"","accessionTime":"2018-08-10","status":1,"xzxt":"0,1","education":null,"title":1,"fullname":"刘望","userCode":"2612","delFlag":0,"dynamicPwd":null,"dyPwdStatus":null,"depNames":"安全服务部","posNames":"科员","roleNames":"安全服务部科员","primaryDep":"安全服务部","department":{"version":null,"orgId":null,"orgPath":null,"depId":497,"depName":"安全服务部","depDesc":"","depLevel":2,"parentId":378,"path":"0.378.497.","orgType":2,"creatorId":1,"createtime":"2018-07-13 17:59:29","updateId":1,"updatetime":"2019-01-04 19:56:05","sn":3,"chargeIds":"20335","chargeNames":"欧阳翰","demension":{"version":null,"orgId":null,"orgPath":null,"demId":1,"demName":"行政维度","demDesc":"行政维度","demType":1}},"company":null,"czykh":null,"id":"9417","enabled":true,"givenName":"刘望","supperManage":false,"firstKeyColumnName":"userId","functionRights":"","validTopModules":{},"superAdmin":false,"businessEmail":"","accountNonExpired":true,"credentialsNonExpired":true,"accountNonLocked":true,"authorities":[{"version":null,"orgId":null,"orgPath":null,"roleId":93,"roleName":"安全服务部科员","roleDesc":"","status":1,"isDefaultIn":0,"rights":"Mod_Oa,MyDesktop,AppHome,_TodoPanelView,_TaskPanelView,_NewTestView,SuperWorkTaskSuperView,DiaryView,_publishSupd,WeeklyView,Flow,NewProcess,MyTaskView,MyProcessRunView,Communication,ProfileForm,PhoneBook,FileSendView,InnerMail,MailForm,PersonalMailBoxView,Mod_Enterprise,star,HYStarLD,HYStarAQ,StardriversStatusView,StarAQKH,StarFWKH,StarWSKH,HYStarFW,CheckAQKH,CheckFWKH,CheckWSKH,HYStarMark,StarDriverView,StarSeeingView,HYStarSetting,StarAQKHSetting,StarFWKHSetting,StarWSKHSetting,StarKHSet,Mod_YF,Excellence,AppygzqLoginView,HrhsDetailView,TypicalPersonView,CommendationView,BrandLineView,GloryListView,MessageBoardView,Mod_insurance,HYStarAQ,ScoreDicManagerView,MoneyicManagerView,RewardPunishmentSurfaceTypeView,IllegalInfo,ChaoSuSetUpView,JcIllegalInfoView,_JcIllegalInfoQueryAll,_JcIllegalInfoQuerySubmit,_JcIllegalInfoCheck,_JcIllegalInfoUnCheck,_JcIllegalInfoSubmit,_JcIllegalInfoUnSubmit,ChaoSuFaKuanView,DriverViolationDetailedView,DriverViolationStatisticsDayView,DriverViolationStatisticsMonthView,DriverViolationStatisticsYearView,StationIntervalRecView,dianjianrichang,BusSelectorJckrichangView,JckrichangJcView,JckrichangMxView,BusSelectorVehicleView,VehicleCarJcView,VehicleCarJcCount,JCStarAQ,JckrichangJcHzView,JckrichangJcChartView,VehicleHzView,VehicleFenXiView,VehicleCarJcChartView,jCZdjiankman,AccidentViolation,AccidentBasicInformationView,AccidentLedgerView,AccidentTaizView,AccidentSituationView,SafetyServiceStatisticsView,AccidentDayStatisticsView,AccidentMonthStatisticsView,AccidentYearStatisticsView,MeasureBusAccident,MeasureBusAccidentView,CheckInsure,HrTimeOutAlert,AutoInsureSetting,AutoInsureView,InsureRecordView,ygbxgl,EmployeeInsuranceView,tj,AccidentRecordCountView,AccidentRecordAQZBView,InsureReportView,InsureYearCountReportView,ViolationRecordCountView,ViolationReportView","name":"安全服务部科员","id":"93","type":"candidate","authority":"安全服务部科员"},{"authority":"ROLE_PUBLIC"}],"familyName":"刘望"},"defId":"10105","userId":9417,"defHtml":"<p align=\"center\">\n\t<span style=\"font-size: 20px;\">驾驶员入职流程表<\/span><\/p>\n<div align=\"center\">\n\t<table border=\"1\" cellspacing=\"1\" class=\"form-info\" style=\"width: 880px;\">\n\t\t<tbody>\n\t\t\t<tr>\n\t\t\t\t<td class=\"td-info\" colspan=\"5\" rowspan=\"1\" style=\"text-align: center;\">\n\t\t\t\t\t&nbsp;<\/td>\n\t\t\t\t<td class=\"td-info\">\n\t\t\t\t\t<input ascenttype=\"23\" class=\"x-form-text x-form-field\" dataformat=\"\" disabled=\"true\" name=\"LiuShuiHao\" style=\"border-width: medium medium 1px; border-style: none none solid; border-color: currentColor currentColor red; width: 171px; background-color: white;\" txtisnotnull=\"0\" txtisprimary=\"0\" txtlabel=\"流水号\" txtsize=\"\" txtvaluetype=\"varchar\" type=\"text\" value=\"\" width=\"\" xtype=\"serialnumber\" /><\/td>\n\t\t\t<\/tr>\n\t\t\t<tr class=\"tr-info\">\n\t\t\t\t<td class=\"td-info\" style=\"height: 30px;\">\n\t\t\t\t\t<p>\n\t\t\t\t\t\t姓名<\/p>\n\t\t\t\t<\/td>\n\t\t\t\t<td class=\"td-info\">\n\t\t\t\t\t<input class=\"x-form-text x-form-field\" dataformat=\"\" name=\"xm\" txtisnotnull=\"1\" txtisprimary=\"0\" txtlabel=\"姓名\" txtsize=\"\" txtvaluetype=\"varchar\" type=\"text\" width=\"\" xtype=\"textfield\" /><input name=\"xmUId\" txtisprimary=\"0\" txtlabel=\"隐藏域\" txtsize=\"\" txtvaluetype=\"varchar\" type=\"hidden\" /><\/td>\n\t\t\t\t<td class=\"td-info\">\n\t\t\t\t\t<p>\n\t\t\t\t\t\t性别<\/p>\n\t\t\t\t<\/td>\n\t\t\t\t<td class=\"td-info\">\n\t\t\t\t\t<select id=\"xb\" name=\"xb\" txtisnotnull=\"1\" txtlabel=\"性别\"><option selected=\"selected\" value=\"男\">男<\/option><option value=\"女\">女<\/option><option value=\"其他\">其他<\/option><\/select><\/td>\n\t\t\t\t<td class=\"td-info\">\n\t\t\t\t\t联系电话<\/td>\n\t\t\t\t<td class=\"td-info\">\n\t\t\t\t\t<input class=\"x-form-text x-form-field\" dataformat=\"\" id=\"lxdh\" name=\"lxdh\" onchange=\"checkPhone()\" style=\"width: 180px;\" txtisnotnull=\"1\" txtisprimary=\"0\" txtlabel=\"联系电话\" txtsize=\"\" txtvaluetype=\"varchar\" type=\"text\" width=\"180\" xtype=\"textfield\" /><\/td>\n\t\t\t<\/tr>\n\t\t\t<tr class=\"tr-info\">\n\t\t\t\t<td class=\"td-info\">\n\t\t\t\t\t身份证号<\/td>\n\t\t\t\t<td class=\"td-info\" colspan=\"3\" rowspan=\"1\">\n\t\t\t\t\t<input class=\"x-form-text x-form-field\" dataformat=\"\" id=\"sfzh\" name=\"sfzh\" onchange=\"checkIdCard(this)\" style=\"width: 250px;\" txtisnotnull=\"1\" txtisprimary=\"0\" txtlabel=\"身份证号\" txtsize=\"\" txtvaluetype=\"varchar\" type=\"text\" width=\"250\" xtype=\"textfield\" /><\/td>\n\t\t\t\t<td class=\"td-info\">\n\t\t\t\t\t准驾车型<\/td>\n\t\t\t\t<td class=\"td-info\">\n\t\t\t\t\t<select name=\"ZhunJiaCheXing1\" txtisnotnull=\"0\" txtlabel=\"准建车型\"><option value=\"A1\">A1<\/option><option value=\"A2\">A2<\/option><option value=\"B1\">B1<\/option><option value=\"B2\">B2<\/option><option value=\"A3\">A3<\/option><option value=\"C1\">C1<\/option><option value=\"C2\">C2<\/option><option value=\"C3\">C3<\/option><option value=\"C4\">C4<\/option><option value=\"C5\">C5<\/option><option value=\"D\">D<\/option><option value=\"E\">E<\/option><option value=\"F\">F<\/option><option value=\"M\">M<\/option><option value=\"N\">N<\/option><option value=\"P\">P<\/option><option selected=\"selected\" value=\" \"><\/option><\/select>&nbsp;<select name=\"ZhunJiaCheXing\" txtisnotnull=\"0\" txtlabel=\"准驾车型\"><option value=\"A1\">A1<\/option><option value=\"A2\">A2<\/option><option value=\"A3\">A3<\/option><option value=\"C1\">C1<\/option><option value=\"C2\">C2<\/option><option value=\"C3\">C3<\/option><option value=\"C4\">C4<\/option><option value=\"C5\">C5<\/option><option value=\"D\">D<\/option><option value=\"E\">E<\/option><option value=\"F\">F<\/option><option value=\"M\">M<\/option><option value=\"N\">N<\/option><option value=\"P\">P<\/option><option selected=\"selected\" value=\"\"><\/option><option value=\" \"><\/option><\/select>&nbsp;<select name=\"ZhunJiaCheXing3\" txtisnotnull=\"0\" txtlabel=\"准驾车型\"><option value=\"A1\">A1<\/option><option value=\"A2\">A2<\/option><option value=\"A3\">A3<\/option><option value=\"B1\">B1<\/option><option value=\"B2\">B2<\/option><option value=\"C1\">C1<\/option><option value=\"C2\">C2<\/option><option value=\"C3\">C3<\/option><option value=\"C4\">C4<\/option><option value=\"C5\">C5<\/option><option value=\"M\">M<\/option><option value=\"N\">N<\/option><option value=\"P\">P<\/option><option selected=\"selected\" value=\"  \"><\/option><option value=\"D\">D<\/option><\/select><\/td>\n\t\t\t<\/tr>\n\t\t\t<tr>\n\t\t\t\t<td class=\"td-info\" colspan=\"1\">\n\t\t\t\t\t相关附件<\/td>\n\t\t\t\t<td class=\"td-info\" colspan=\"5\">\n\t\t\t\t\t<textarea class=\"x-form-textarea x-form-field x-column\" name=\"xiangguanfujian\" style=\"margin: 0px; width: 142px; height: 29px;\" txtlabel=\"相关附件\" txtvaluetype=\"varchar\" width=\"\" xtype=\"fileupload\"><\/textarea><\/td>\n\t\t\t<\/tr>\n\t\t\t<tr class=\"tr-info\">\n\t\t\t\t<td class=\"td-info\" colspan=\"1\">\n\t\t\t\t\t财务审计部<\/td>\n\t\t\t\t<td class=\"td-info\" colspan=\"5\" rowspan=\"1\">\n\t\t\t\t\t<p>\n\t\t\t\t\t\t应缴风险保证金（伍仟元）<input class=\"x-form-text x-form-field\" iscurrent=\"0\" issingle=\"1\" name=\"qqq\" txtisnotnull=\"1\" txtlabel=\"萨达\" txtvaluetype=\"varchar\" type=\"text\" width=\"\" xtype=\"resumeselector\" /><\/p>\n\t\t\t\t\t<p>\n\t\t\t\t\t\t<textarea class=\"x-form-textarea x-form-field x-column\" name=\"cwsjbyj\" style=\"width: 711px; height: 66px;\" txtlabel=\"财务审计部意见\" txtsize=\"1000\" txtvaluetype=\"text\" width=\"\" xtype=\"commoneditor\"><\/textarea><\/p>\n\t\t\t\t<\/td>\n\t\t\t<\/tr>\n\t\t\t<tr class=\"tr-info\">\n\t\t\t\t<td class=\"td-info\" colspan=\"1\">\n\t\t\t\t\t营运管理部<\/td>\n\t\t\t\t<td class=\"td-info\" colspan=\"5\" rowspan=\"1\">\n\t\t\t\t\t分配到<select name=\"fgs\" txtisnotnull=\"1\" txtlabel=\"分公司\"><option value=\"营运一分公司\">营运一分公司<\/option><option value=\"营运二分公司\">营运二分公司<\/option><option value=\"枢纽分公司\">枢纽分公司<\/option><\/select>\n\t\t\t\t\t<p>\n\t\t\t\t\t\t<textarea class=\"x-form-textarea x-form-field x-column\" name=\"yyglbyj\" style=\"width: 710px; height: 68px;\" txtlabel=\"营运管理部意见\" txtsize=\"1000\" txtvaluetype=\"text\" width=\"\" xtype=\"commoneditor\"><\/textarea><\/p>\n\t\t\t\t<\/td>\n\t\t\t<\/tr>\n\t\t\t<tr class=\"tr-info\">\n\t\t\t\t<td class=\"td-info\" colspan=\"1\">\n\t\t\t\t\t信息技术部<\/td>\n\t\t\t\t<td class=\"td-info\" colspan=\"5\" rowspan=\"1\">\n\t\t\t\t\t<p>\n\t\t\t\t\t\t登记工号信息<\/p>\n\t\t\t\t\t<p>\n\t\t\t\t\t\t<textarea class=\"x-form-textarea x-form-field x-column\" name=\"xxjsbyj\" style=\"width: 712px; height: 77px;\" txtlabel=\"信息技术部意见\" txtsize=\"1000\" txtvaluetype=\"text\" width=\"\" xtype=\"commoneditor\"><\/textarea><\/p>\n\t\t\t\t<\/td>\n\t\t\t<\/tr>\n\t\t\t<tr>\n\t\t\t\t<td class=\"td-info\" colspan=\"1\">\n\t\t\t\t\t宜春市春城通科技有限公司<\/td>\n\t\t\t\t<td class=\"td-info\" colspan=\"5\" rowspan=\"1\">\n\t\t\t\t\t<p>\n\t\t\t\t\t\t办理IC卡<\/p>\n\t\t\t\t\t<p>\n\t\t\t\t\t\t<textarea class=\"x-form-textarea x-form-field x-column\" name=\"cctkjyxgsyj\" style=\"width: 709px; height: 75px;\" txtlabel=\"春城通科技有限公司意见\" txtsize=\"1000\" txtvaluetype=\"text\" width=\"\" xtype=\"commoneditor\"><\/textarea><\/p>\n\t\t\t\t<\/td>\n\t\t\t<\/tr>\n\t\t\t<tr class=\"tr-info\">\n\t\t\t\t<td class=\"td-info\" colspan=\"1\">\n\t\t\t\t\t综合管理部<\/td>\n\t\t\t\t<td class=\"td-info\" colspan=\"5\" rowspan=\"1\">\n\t\t\t\t\t<p>\n\t\t\t\t\t\t录取指纹<\/p>\n\t\t\t\t\t<p>\n\t\t\t\t\t\t<textarea class=\"x-form-textarea x-form-field x-column\" name=\"zhglbyj\" style=\"width: 710px; height: 78px; margin-top: 0px; margin-bottom: 0px;\" txtlabel=\"综合管理部意见\" txtsize=\"1000\" txtvaluetype=\"text\" width=\"\" xtype=\"commoneditor\"><\/textarea><\/p>\n\t\t\t\t<\/td>\n\t\t\t<\/tr>\n\t\t\t<tr>\n\t\t\t\t<td class=\"td-info\" colspan=\"1\">\n\t\t\t\t\t分公司接收情况反馈<\/td>\n\t\t\t\t<td class=\"td-info\" colspan=\"5\">\n\t\t\t\t\t<textarea class=\"x-form-textarea x-form-field x-column\" name=\"jbbmyj\" style=\"width: 711px; height: 56px;\" txtlabel=\"分公司接收情况反馈\" txtsize=\"1000\" txtvaluetype=\"text\" width=\"\" xtype=\"commoneditor\"><\/textarea><\/td>\n\t\t\t<\/tr>\n\t\t\t<tr>\n\t\t\t\t<td class=\"td-info\">\n\t\t\t\t\t人力资源部<\/td>\n\t\t\t\t<td class=\"td-info\" colspan=\"5\" rowspan=\"1\">\n\t\t\t\t\t<p>\n\t\t\t\t\t\t<input name=\"rlzyb1\" txtlabel=\"人力资源部1\" type=\"checkbox\" />签订合同&nbsp;&nbsp;<input name=\"rlzyb2\" txtlabel=\"人力资源部2\" type=\"checkbox\" />领取服装&nbsp;&nbsp;<input name=\"rlzyb3\" txtlabel=\"人力资源部3\" type=\"checkbox\" />开介绍信到分公司<\/p>\n\t\t\t\t\t<p>\n\t\t\t\t\t\t<textarea class=\"x-form-textarea x-form-field x-column\" name=\"rlzybyj\" style=\"width: 707px; height: 66px;\" txtlabel=\"人力资源部意见\" txtsize=\"1000\" txtvaluetype=\"text\" width=\"\" xtype=\"commoneditor\"><\/textarea><\/p>\n\t\t\t\t<\/td>\n\t\t\t<\/tr>\n\t\t<\/tbody>\n\t<\/table>\n<\/div>\n<p>\n\t&nbsp;<\/p>\n"},"runId":51535}]
     */

    private boolean success;
    private List<DataBean> data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * version : null
         * orgId : null
         * orgPath : null
         * formId : 74602
         * activityName : 发起人
         * createtime : 2019-03-07 17:20:31
         * creatorId : 9417
         * creatorName : 刘望
         * endtime : 2019-03-07 17:20:31
         * durTimes : 0
         * fromTask : null
         * fromTaskId : null
         * taskId : null
         * transTo : to 交保证金
         * status : 2
         * usetimes : null
         * comments : null
         * preFormId : null
         * processRun : {"version":null,"orgId":null,"orgPath":null,"runId":51535,"subject":"驾驶员入职流程表20190307-172031","creator":"刘望","assignee":null,"createtime":"2019-03-07 17:20:31","endtime":"2019-03-14 17:20:31","isMany":null,"showData":null,"piId":"JSYRZLCB4.8160169","pdId":"JSYRZLCB4-2","piDbid":8160169,"processName":"驾驶员入职流程表","busDesc":null,"entityName":"WF_jsyrzlcbnews","entityId":"9","formDefId":10117,"runStatus":1,"appUser":{"version":null,"orgId":null,"orgPath":null,"userId":9417,"username":"刘望","email":"","jobId":null,"phone":"","mobile":"","fax":"","address":"","zip":"","photo":"","accessionTime":"2018-08-10","status":1,"xzxt":"0,1","education":null,"title":1,"fullname":"刘望","userCode":"2612","delFlag":0,"dynamicPwd":null,"dyPwdStatus":null,"depNames":"安全服务部","posNames":"科员","roleNames":"安全服务部科员","primaryDep":"安全服务部","department":{"version":null,"orgId":null,"orgPath":null,"depId":497,"depName":"安全服务部","depDesc":"","depLevel":2,"parentId":378,"path":"0.378.497.","orgType":2,"creatorId":1,"createtime":"2018-07-13 17:59:29","updateId":1,"updatetime":"2019-01-04 19:56:05","sn":3,"chargeIds":"20335","chargeNames":"欧阳翰","demension":{"version":null,"orgId":null,"orgPath":null,"demId":1,"demName":"行政维度","demDesc":"行政维度","demType":1}},"company":null,"czykh":null,"id":"9417","enabled":true,"givenName":"刘望","supperManage":false,"firstKeyColumnName":"userId","functionRights":"","validTopModules":{},"superAdmin":false,"businessEmail":"","accountNonExpired":true,"credentialsNonExpired":true,"accountNonLocked":true,"authorities":[{"version":null,"orgId":null,"orgPath":null,"roleId":93,"roleName":"安全服务部科员","roleDesc":"","status":1,"isDefaultIn":0,"rights":"Mod_Oa,MyDesktop,AppHome,_TodoPanelView,_TaskPanelView,_NewTestView,SuperWorkTaskSuperView,DiaryView,_publishSupd,WeeklyView,Flow,NewProcess,MyTaskView,MyProcessRunView,Communication,ProfileForm,PhoneBook,FileSendView,InnerMail,MailForm,PersonalMailBoxView,Mod_Enterprise,star,HYStarLD,HYStarAQ,StardriversStatusView,StarAQKH,StarFWKH,StarWSKH,HYStarFW,CheckAQKH,CheckFWKH,CheckWSKH,HYStarMark,StarDriverView,StarSeeingView,HYStarSetting,StarAQKHSetting,StarFWKHSetting,StarWSKHSetting,StarKHSet,Mod_YF,Excellence,AppygzqLoginView,HrhsDetailView,TypicalPersonView,CommendationView,BrandLineView,GloryListView,MessageBoardView,Mod_insurance,HYStarAQ,ScoreDicManagerView,MoneyicManagerView,RewardPunishmentSurfaceTypeView,IllegalInfo,ChaoSuSetUpView,JcIllegalInfoView,_JcIllegalInfoQueryAll,_JcIllegalInfoQuerySubmit,_JcIllegalInfoCheck,_JcIllegalInfoUnCheck,_JcIllegalInfoSubmit,_JcIllegalInfoUnSubmit,ChaoSuFaKuanView,DriverViolationDetailedView,DriverViolationStatisticsDayView,DriverViolationStatisticsMonthView,DriverViolationStatisticsYearView,StationIntervalRecView,dianjianrichang,BusSelectorJckrichangView,JckrichangJcView,JckrichangMxView,BusSelectorVehicleView,VehicleCarJcView,VehicleCarJcCount,JCStarAQ,JckrichangJcHzView,JckrichangJcChartView,VehicleHzView,VehicleFenXiView,VehicleCarJcChartView,jCZdjiankman,AccidentViolation,AccidentBasicInformationView,AccidentLedgerView,AccidentTaizView,AccidentSituationView,SafetyServiceStatisticsView,AccidentDayStatisticsView,AccidentMonthStatisticsView,AccidentYearStatisticsView,MeasureBusAccident,MeasureBusAccidentView,CheckInsure,HrTimeOutAlert,AutoInsureSetting,AutoInsureView,InsureRecordView,ygbxgl,EmployeeInsuranceView,tj,AccidentRecordCountView,AccidentRecordAQZBView,InsureReportView,InsureYearCountReportView,ViolationRecordCountView,ViolationReportView","name":"安全服务部科员","id":"93","type":"candidate","authority":"安全服务部科员"},{"authority":"ROLE_PUBLIC"}],"familyName":"刘望"},"defId":"10105","userId":9417,"defHtml":"<p align=\"center\">\n\t<span style=\"font-size: 20px;\">驾驶员入职流程表<\/span><\/p>\n<div align=\"center\">\n\t<table border=\"1\" cellspacing=\"1\" class=\"form-info\" style=\"width: 880px;\">\n\t\t<tbody>\n\t\t\t<tr>\n\t\t\t\t<td class=\"td-info\" colspan=\"5\" rowspan=\"1\" style=\"text-align: center;\">\n\t\t\t\t\t&nbsp;<\/td>\n\t\t\t\t<td class=\"td-info\">\n\t\t\t\t\t<input ascenttype=\"23\" class=\"x-form-text x-form-field\" dataformat=\"\" disabled=\"true\" name=\"LiuShuiHao\" style=\"border-width: medium medium 1px; border-style: none none solid; border-color: currentColor currentColor red; width: 171px; background-color: white;\" txtisnotnull=\"0\" txtisprimary=\"0\" txtlabel=\"流水号\" txtsize=\"\" txtvaluetype=\"varchar\" type=\"text\" value=\"\" width=\"\" xtype=\"serialnumber\" /><\/td>\n\t\t\t<\/tr>\n\t\t\t<tr class=\"tr-info\">\n\t\t\t\t<td class=\"td-info\" style=\"height: 30px;\">\n\t\t\t\t\t<p>\n\t\t\t\t\t\t姓名<\/p>\n\t\t\t\t<\/td>\n\t\t\t\t<td class=\"td-info\">\n\t\t\t\t\t<input class=\"x-form-text x-form-field\" dataformat=\"\" name=\"xm\" txtisnotnull=\"1\" txtisprimary=\"0\" txtlabel=\"姓名\" txtsize=\"\" txtvaluetype=\"varchar\" type=\"text\" width=\"\" xtype=\"textfield\" /><input name=\"xmUId\" txtisprimary=\"0\" txtlabel=\"隐藏域\" txtsize=\"\" txtvaluetype=\"varchar\" type=\"hidden\" /><\/td>\n\t\t\t\t<td class=\"td-info\">\n\t\t\t\t\t<p>\n\t\t\t\t\t\t性别<\/p>\n\t\t\t\t<\/td>\n\t\t\t\t<td class=\"td-info\">\n\t\t\t\t\t<select id=\"xb\" name=\"xb\" txtisnotnull=\"1\" txtlabel=\"性别\"><option selected=\"selected\" value=\"男\">男<\/option><option value=\"女\">女<\/option><option value=\"其他\">其他<\/option><\/select><\/td>\n\t\t\t\t<td class=\"td-info\">\n\t\t\t\t\t联系电话<\/td>\n\t\t\t\t<td class=\"td-info\">\n\t\t\t\t\t<input class=\"x-form-text x-form-field\" dataformat=\"\" id=\"lxdh\" name=\"lxdh\" onchange=\"checkPhone()\" style=\"width: 180px;\" txtisnotnull=\"1\" txtisprimary=\"0\" txtlabel=\"联系电话\" txtsize=\"\" txtvaluetype=\"varchar\" type=\"text\" width=\"180\" xtype=\"textfield\" /><\/td>\n\t\t\t<\/tr>\n\t\t\t<tr class=\"tr-info\">\n\t\t\t\t<td class=\"td-info\">\n\t\t\t\t\t身份证号<\/td>\n\t\t\t\t<td class=\"td-info\" colspan=\"3\" rowspan=\"1\">\n\t\t\t\t\t<input class=\"x-form-text x-form-field\" dataformat=\"\" id=\"sfzh\" name=\"sfzh\" onchange=\"checkIdCard(this)\" style=\"width: 250px;\" txtisnotnull=\"1\" txtisprimary=\"0\" txtlabel=\"身份证号\" txtsize=\"\" txtvaluetype=\"varchar\" type=\"text\" width=\"250\" xtype=\"textfield\" /><\/td>\n\t\t\t\t<td class=\"td-info\">\n\t\t\t\t\t准驾车型<\/td>\n\t\t\t\t<td class=\"td-info\">\n\t\t\t\t\t<select name=\"ZhunJiaCheXing1\" txtisnotnull=\"0\" txtlabel=\"准建车型\"><option value=\"A1\">A1<\/option><option value=\"A2\">A2<\/option><option value=\"B1\">B1<\/option><option value=\"B2\">B2<\/option><option value=\"A3\">A3<\/option><option value=\"C1\">C1<\/option><option value=\"C2\">C2<\/option><option value=\"C3\">C3<\/option><option value=\"C4\">C4<\/option><option value=\"C5\">C5<\/option><option value=\"D\">D<\/option><option value=\"E\">E<\/option><option value=\"F\">F<\/option><option value=\"M\">M<\/option><option value=\"N\">N<\/option><option value=\"P\">P<\/option><option selected=\"selected\" value=\" \"><\/option><\/select>&nbsp;<select name=\"ZhunJiaCheXing\" txtisnotnull=\"0\" txtlabel=\"准驾车型\"><option value=\"A1\">A1<\/option><option value=\"A2\">A2<\/option><option value=\"A3\">A3<\/option><option value=\"C1\">C1<\/option><option value=\"C2\">C2<\/option><option value=\"C3\">C3<\/option><option value=\"C4\">C4<\/option><option value=\"C5\">C5<\/option><option value=\"D\">D<\/option><option value=\"E\">E<\/option><option value=\"F\">F<\/option><option value=\"M\">M<\/option><option value=\"N\">N<\/option><option value=\"P\">P<\/option><option selected=\"selected\" value=\"\"><\/option><option value=\" \"><\/option><\/select>&nbsp;<select name=\"ZhunJiaCheXing3\" txtisnotnull=\"0\" txtlabel=\"准驾车型\"><option value=\"A1\">A1<\/option><option value=\"A2\">A2<\/option><option value=\"A3\">A3<\/option><option value=\"B1\">B1<\/option><option value=\"B2\">B2<\/option><option value=\"C1\">C1<\/option><option value=\"C2\">C2<\/option><option value=\"C3\">C3<\/option><option value=\"C4\">C4<\/option><option value=\"C5\">C5<\/option><option value=\"M\">M<\/option><option value=\"N\">N<\/option><option value=\"P\">P<\/option><option selected=\"selected\" value=\"  \"><\/option><option value=\"D\">D<\/option><\/select><\/td>\n\t\t\t<\/tr>\n\t\t\t<tr>\n\t\t\t\t<td class=\"td-info\" colspan=\"1\">\n\t\t\t\t\t相关附件<\/td>\n\t\t\t\t<td class=\"td-info\" colspan=\"5\">\n\t\t\t\t\t<textarea class=\"x-form-textarea x-form-field x-column\" name=\"xiangguanfujian\" style=\"margin: 0px; width: 142px; height: 29px;\" txtlabel=\"相关附件\" txtvaluetype=\"varchar\" width=\"\" xtype=\"fileupload\"><\/textarea><\/td>\n\t\t\t<\/tr>\n\t\t\t<tr class=\"tr-info\">\n\t\t\t\t<td class=\"td-info\" colspan=\"1\">\n\t\t\t\t\t财务审计部<\/td>\n\t\t\t\t<td class=\"td-info\" colspan=\"5\" rowspan=\"1\">\n\t\t\t\t\t<p>\n\t\t\t\t\t\t应缴风险保证金（伍仟元）<input class=\"x-form-text x-form-field\" iscurrent=\"0\" issingle=\"1\" name=\"qqq\" txtisnotnull=\"1\" txtlabel=\"萨达\" txtvaluetype=\"varchar\" type=\"text\" width=\"\" xtype=\"resumeselector\" /><\/p>\n\t\t\t\t\t<p>\n\t\t\t\t\t\t<textarea class=\"x-form-textarea x-form-field x-column\" name=\"cwsjbyj\" style=\"width: 711px; height: 66px;\" txtlabel=\"财务审计部意见\" txtsize=\"1000\" txtvaluetype=\"text\" width=\"\" xtype=\"commoneditor\"><\/textarea><\/p>\n\t\t\t\t<\/td>\n\t\t\t<\/tr>\n\t\t\t<tr class=\"tr-info\">\n\t\t\t\t<td class=\"td-info\" colspan=\"1\">\n\t\t\t\t\t营运管理部<\/td>\n\t\t\t\t<td class=\"td-info\" colspan=\"5\" rowspan=\"1\">\n\t\t\t\t\t分配到<select name=\"fgs\" txtisnotnull=\"1\" txtlabel=\"分公司\"><option value=\"营运一分公司\">营运一分公司<\/option><option value=\"营运二分公司\">营运二分公司<\/option><option value=\"枢纽分公司\">枢纽分公司<\/option><\/select>\n\t\t\t\t\t<p>\n\t\t\t\t\t\t<textarea class=\"x-form-textarea x-form-field x-column\" name=\"yyglbyj\" style=\"width: 710px; height: 68px;\" txtlabel=\"营运管理部意见\" txtsize=\"1000\" txtvaluetype=\"text\" width=\"\" xtype=\"commoneditor\"><\/textarea><\/p>\n\t\t\t\t<\/td>\n\t\t\t<\/tr>\n\t\t\t<tr class=\"tr-info\">\n\t\t\t\t<td class=\"td-info\" colspan=\"1\">\n\t\t\t\t\t信息技术部<\/td>\n\t\t\t\t<td class=\"td-info\" colspan=\"5\" rowspan=\"1\">\n\t\t\t\t\t<p>\n\t\t\t\t\t\t登记工号信息<\/p>\n\t\t\t\t\t<p>\n\t\t\t\t\t\t<textarea class=\"x-form-textarea x-form-field x-column\" name=\"xxjsbyj\" style=\"width: 712px; height: 77px;\" txtlabel=\"信息技术部意见\" txtsize=\"1000\" txtvaluetype=\"text\" width=\"\" xtype=\"commoneditor\"><\/textarea><\/p>\n\t\t\t\t<\/td>\n\t\t\t<\/tr>\n\t\t\t<tr>\n\t\t\t\t<td class=\"td-info\" colspan=\"1\">\n\t\t\t\t\t宜春市春城通科技有限公司<\/td>\n\t\t\t\t<td class=\"td-info\" colspan=\"5\" rowspan=\"1\">\n\t\t\t\t\t<p>\n\t\t\t\t\t\t办理IC卡<\/p>\n\t\t\t\t\t<p>\n\t\t\t\t\t\t<textarea class=\"x-form-textarea x-form-field x-column\" name=\"cctkjyxgsyj\" style=\"width: 709px; height: 75px;\" txtlabel=\"春城通科技有限公司意见\" txtsize=\"1000\" txtvaluetype=\"text\" width=\"\" xtype=\"commoneditor\"><\/textarea><\/p>\n\t\t\t\t<\/td>\n\t\t\t<\/tr>\n\t\t\t<tr class=\"tr-info\">\n\t\t\t\t<td class=\"td-info\" colspan=\"1\">\n\t\t\t\t\t综合管理部<\/td>\n\t\t\t\t<td class=\"td-info\" colspan=\"5\" rowspan=\"1\">\n\t\t\t\t\t<p>\n\t\t\t\t\t\t录取指纹<\/p>\n\t\t\t\t\t<p>\n\t\t\t\t\t\t<textarea class=\"x-form-textarea x-form-field x-column\" name=\"zhglbyj\" style=\"width: 710px; height: 78px; margin-top: 0px; margin-bottom: 0px;\" txtlabel=\"综合管理部意见\" txtsize=\"1000\" txtvaluetype=\"text\" width=\"\" xtype=\"commoneditor\"><\/textarea><\/p>\n\t\t\t\t<\/td>\n\t\t\t<\/tr>\n\t\t\t<tr>\n\t\t\t\t<td class=\"td-info\" colspan=\"1\">\n\t\t\t\t\t分公司接收情况反馈<\/td>\n\t\t\t\t<td class=\"td-info\" colspan=\"5\">\n\t\t\t\t\t<textarea class=\"x-form-textarea x-form-field x-column\" name=\"jbbmyj\" style=\"width: 711px; height: 56px;\" txtlabel=\"分公司接收情况反馈\" txtsize=\"1000\" txtvaluetype=\"text\" width=\"\" xtype=\"commoneditor\"><\/textarea><\/td>\n\t\t\t<\/tr>\n\t\t\t<tr>\n\t\t\t\t<td class=\"td-info\">\n\t\t\t\t\t人力资源部<\/td>\n\t\t\t\t<td class=\"td-info\" colspan=\"5\" rowspan=\"1\">\n\t\t\t\t\t<p>\n\t\t\t\t\t\t<input name=\"rlzyb1\" txtlabel=\"人力资源部1\" type=\"checkbox\" />签订合同&nbsp;&nbsp;<input name=\"rlzyb2\" txtlabel=\"人力资源部2\" type=\"checkbox\" />领取服装&nbsp;&nbsp;<input name=\"rlzyb3\" txtlabel=\"人力资源部3\" type=\"checkbox\" />开介绍信到分公司<\/p>\n\t\t\t\t\t<p>\n\t\t\t\t\t\t<textarea class=\"x-form-textarea x-form-field x-column\" name=\"rlzybyj\" style=\"width: 707px; height: 66px;\" txtlabel=\"人力资源部意见\" txtsize=\"1000\" txtvaluetype=\"text\" width=\"\" xtype=\"commoneditor\"><\/textarea><\/p>\n\t\t\t\t<\/td>\n\t\t\t<\/tr>\n\t\t<\/tbody>\n\t<\/table>\n<\/div>\n<p>\n\t&nbsp;<\/p>\n"}
         * runId : 51535
         */

        private Object version;
        private Object orgId;
        private Object orgPath;
        private int formId;
        private String activityName;
        private String createtime;
        private int creatorId;
        private String creatorName;
        private String endtime;
        private String durTimes;
        private Object fromTask;
        private Object fromTaskId;
        private Object taskId;
        private String transTo;
        private String status;
        private String usetimes;
        private String comments;
        private Object preFormId;
        private ProcessRunBean processRun;
        private int runId;

        public Object getVersion() {
            return version;
        }

        public void setVersion(Object version) {
            this.version = version;
        }

        public Object getOrgId() {
            return orgId;
        }

        public void setOrgId(Object orgId) {
            this.orgId = orgId;
        }

        public Object getOrgPath() {
            return orgPath;
        }

        public void setOrgPath(Object orgPath) {
            this.orgPath = orgPath;
        }

        public int getFormId() {
            return formId;
        }

        public void setFormId(int formId) {
            this.formId = formId;
        }

        public String getActivityName() {
            return activityName;
        }

        public void setActivityName(String activityName) {
            this.activityName = activityName;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public int getCreatorId() {
            return creatorId;
        }

        public void setCreatorId(int creatorId) {
            this.creatorId = creatorId;
        }

        public String getCreatorName() {
            return creatorName;
        }

        public void setCreatorName(String creatorName) {
            this.creatorName = creatorName;
        }

        public String getEndtime() {
            return endtime;
        }

        public void setEndtime(String endtime) {
            this.endtime = endtime;
        }

        public String getDurTimes() {
            return durTimes;
        }

        public void setDurTimes(String durTimes) {
            this.durTimes = durTimes;
        }

        public Object getFromTask() {
            return fromTask;
        }

        public void setFromTask(Object fromTask) {
            this.fromTask = fromTask;
        }

        public Object getFromTaskId() {
            return fromTaskId;
        }

        public void setFromTaskId(Object fromTaskId) {
            this.fromTaskId = fromTaskId;
        }

        public Object getTaskId() {
            return taskId;
        }

        public void setTaskId(Object taskId) {
            this.taskId = taskId;
        }

        public String getTransTo() {
            return transTo;
        }

        public void setTransTo(String transTo) {
            this.transTo = transTo;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getUsetimes() {
            return usetimes;
        }

        public void setUsetimes(String usetimes) {
            this.usetimes = usetimes;
        }

        public String getComments() {
            return comments;
        }

        public void setComments(String comments) {
            this.comments = comments;
        }

        public Object getPreFormId() {
            return preFormId;
        }

        public void setPreFormId(Object preFormId) {
            this.preFormId = preFormId;
        }

        public ProcessRunBean getProcessRun() {
            return processRun;
        }

        public void setProcessRun(ProcessRunBean processRun) {
            this.processRun = processRun;
        }

        public int getRunId() {
            return runId;
        }

        public void setRunId(int runId) {
            this.runId = runId;
        }

        public static class ProcessRunBean {
            /**
             * version : null
             * orgId : null
             * orgPath : null
             * runId : 51535
             * subject : 驾驶员入职流程表20190307-172031
             * creator : 刘望
             * assignee : null
             * createtime : 2019-03-07 17:20:31
             * endtime : 2019-03-14 17:20:31
             * isMany : null
             * showData : null
             * piId : JSYRZLCB4.8160169
             * pdId : JSYRZLCB4-2
             * piDbid : 8160169
             * processName : 驾驶员入职流程表
             * busDesc : null
             * entityName : WF_jsyrzlcbnews
             * entityId : 9
             * formDefId : 10117
             * runStatus : 1
             * appUser : {"version":null,"orgId":null,"orgPath":null,"userId":9417,"username":"刘望","email":"","jobId":null,"phone":"","mobile":"","fax":"","address":"","zip":"","photo":"","accessionTime":"2018-08-10","status":1,"xzxt":"0,1","education":null,"title":1,"fullname":"刘望","userCode":"2612","delFlag":0,"dynamicPwd":null,"dyPwdStatus":null,"depNames":"安全服务部","posNames":"科员","roleNames":"安全服务部科员","primaryDep":"安全服务部","department":{"version":null,"orgId":null,"orgPath":null,"depId":497,"depName":"安全服务部","depDesc":"","depLevel":2,"parentId":378,"path":"0.378.497.","orgType":2,"creatorId":1,"createtime":"2018-07-13 17:59:29","updateId":1,"updatetime":"2019-01-04 19:56:05","sn":3,"chargeIds":"20335","chargeNames":"欧阳翰","demension":{"version":null,"orgId":null,"orgPath":null,"demId":1,"demName":"行政维度","demDesc":"行政维度","demType":1}},"company":null,"czykh":null,"id":"9417","enabled":true,"givenName":"刘望","supperManage":false,"firstKeyColumnName":"userId","functionRights":"","validTopModules":{},"superAdmin":false,"businessEmail":"","accountNonExpired":true,"credentialsNonExpired":true,"accountNonLocked":true,"authorities":[{"version":null,"orgId":null,"orgPath":null,"roleId":93,"roleName":"安全服务部科员","roleDesc":"","status":1,"isDefaultIn":0,"rights":"Mod_Oa,MyDesktop,AppHome,_TodoPanelView,_TaskPanelView,_NewTestView,SuperWorkTaskSuperView,DiaryView,_publishSupd,WeeklyView,Flow,NewProcess,MyTaskView,MyProcessRunView,Communication,ProfileForm,PhoneBook,FileSendView,InnerMail,MailForm,PersonalMailBoxView,Mod_Enterprise,star,HYStarLD,HYStarAQ,StardriversStatusView,StarAQKH,StarFWKH,StarWSKH,HYStarFW,CheckAQKH,CheckFWKH,CheckWSKH,HYStarMark,StarDriverView,StarSeeingView,HYStarSetting,StarAQKHSetting,StarFWKHSetting,StarWSKHSetting,StarKHSet,Mod_YF,Excellence,AppygzqLoginView,HrhsDetailView,TypicalPersonView,CommendationView,BrandLineView,GloryListView,MessageBoardView,Mod_insurance,HYStarAQ,ScoreDicManagerView,MoneyicManagerView,RewardPunishmentSurfaceTypeView,IllegalInfo,ChaoSuSetUpView,JcIllegalInfoView,_JcIllegalInfoQueryAll,_JcIllegalInfoQuerySubmit,_JcIllegalInfoCheck,_JcIllegalInfoUnCheck,_JcIllegalInfoSubmit,_JcIllegalInfoUnSubmit,ChaoSuFaKuanView,DriverViolationDetailedView,DriverViolationStatisticsDayView,DriverViolationStatisticsMonthView,DriverViolationStatisticsYearView,StationIntervalRecView,dianjianrichang,BusSelectorJckrichangView,JckrichangJcView,JckrichangMxView,BusSelectorVehicleView,VehicleCarJcView,VehicleCarJcCount,JCStarAQ,JckrichangJcHzView,JckrichangJcChartView,VehicleHzView,VehicleFenXiView,VehicleCarJcChartView,jCZdjiankman,AccidentViolation,AccidentBasicInformationView,AccidentLedgerView,AccidentTaizView,AccidentSituationView,SafetyServiceStatisticsView,AccidentDayStatisticsView,AccidentMonthStatisticsView,AccidentYearStatisticsView,MeasureBusAccident,MeasureBusAccidentView,CheckInsure,HrTimeOutAlert,AutoInsureSetting,AutoInsureView,InsureRecordView,ygbxgl,EmployeeInsuranceView,tj,AccidentRecordCountView,AccidentRecordAQZBView,InsureReportView,InsureYearCountReportView,ViolationRecordCountView,ViolationReportView","name":"安全服务部科员","id":"93","type":"candidate","authority":"安全服务部科员"},{"authority":"ROLE_PUBLIC"}],"familyName":"刘望"}
             * defId : 10105
             * userId : 9417
             * defHtml : <p align="center">
             <span style="font-size: 20px;">驾驶员入职流程表</span></p>
             <div align="center">
             <table border="1" cellspacing="1" class="form-info" style="width: 880px;">
             <tbody>
             <tr>
             <td class="td-info" colspan="5" rowspan="1" style="text-align: center;">
             &nbsp;</td>
             <td class="td-info">
             <input ascenttype="23" class="x-form-text x-form-field" dataformat="" disabled="true" name="LiuShuiHao" style="border-width: medium medium 1px; border-style: none none solid; border-color: currentColor currentColor red; width: 171px; background-color: white;" txtisnotnull="0" txtisprimary="0" txtlabel="流水号" txtsize="" txtvaluetype="varchar" type="text" value="" width="" xtype="serialnumber" /></td>
             </tr>
             <tr class="tr-info">
             <td class="td-info" style="height: 30px;">
             <p>
             姓名</p>
             </td>
             <td class="td-info">
             <input class="x-form-text x-form-field" dataformat="" name="xm" txtisnotnull="1" txtisprimary="0" txtlabel="姓名" txtsize="" txtvaluetype="varchar" type="text" width="" xtype="textfield" /><input name="xmUId" txtisprimary="0" txtlabel="隐藏域" txtsize="" txtvaluetype="varchar" type="hidden" /></td>
             <td class="td-info">
             <p>
             性别</p>
             </td>
             <td class="td-info">
             <select id="xb" name="xb" txtisnotnull="1" txtlabel="性别"><option selected="selected" value="男">男</option><option value="女">女</option><option value="其他">其他</option></select></td>
             <td class="td-info">
             联系电话</td>
             <td class="td-info">
             <input class="x-form-text x-form-field" dataformat="" id="lxdh" name="lxdh" onchange="checkPhone()" style="width: 180px;" txtisnotnull="1" txtisprimary="0" txtlabel="联系电话" txtsize="" txtvaluetype="varchar" type="text" width="180" xtype="textfield" /></td>
             </tr>
             <tr class="tr-info">
             <td class="td-info">
             身份证号</td>
             <td class="td-info" colspan="3" rowspan="1">
             <input class="x-form-text x-form-field" dataformat="" id="sfzh" name="sfzh" onchange="checkIdCard(this)" style="width: 250px;" txtisnotnull="1" txtisprimary="0" txtlabel="身份证号" txtsize="" txtvaluetype="varchar" type="text" width="250" xtype="textfield" /></td>
             <td class="td-info">
             准驾车型</td>
             <td class="td-info">
             <select name="ZhunJiaCheXing1" txtisnotnull="0" txtlabel="准建车型"><option value="A1">A1</option><option value="A2">A2</option><option value="B1">B1</option><option value="B2">B2</option><option value="A3">A3</option><option value="C1">C1</option><option value="C2">C2</option><option value="C3">C3</option><option value="C4">C4</option><option value="C5">C5</option><option value="D">D</option><option value="E">E</option><option value="F">F</option><option value="M">M</option><option value="N">N</option><option value="P">P</option><option selected="selected" value=" "></option></select>&nbsp;<select name="ZhunJiaCheXing" txtisnotnull="0" txtlabel="准驾车型"><option value="A1">A1</option><option value="A2">A2</option><option value="A3">A3</option><option value="C1">C1</option><option value="C2">C2</option><option value="C3">C3</option><option value="C4">C4</option><option value="C5">C5</option><option value="D">D</option><option value="E">E</option><option value="F">F</option><option value="M">M</option><option value="N">N</option><option value="P">P</option><option selected="selected" value=""></option><option value=" "></option></select>&nbsp;<select name="ZhunJiaCheXing3" txtisnotnull="0" txtlabel="准驾车型"><option value="A1">A1</option><option value="A2">A2</option><option value="A3">A3</option><option value="B1">B1</option><option value="B2">B2</option><option value="C1">C1</option><option value="C2">C2</option><option value="C3">C3</option><option value="C4">C4</option><option value="C5">C5</option><option value="M">M</option><option value="N">N</option><option value="P">P</option><option selected="selected" value="  "></option><option value="D">D</option></select></td>
             </tr>
             <tr>
             <td class="td-info" colspan="1">
             相关附件</td>
             <td class="td-info" colspan="5">
             <textarea class="x-form-textarea x-form-field x-column" name="xiangguanfujian" style="margin: 0px; width: 142px; height: 29px;" txtlabel="相关附件" txtvaluetype="varchar" width="" xtype="fileupload"></textarea></td>
             </tr>
             <tr class="tr-info">
             <td class="td-info" colspan="1">
             财务审计部</td>
             <td class="td-info" colspan="5" rowspan="1">
             <p>
             应缴风险保证金（伍仟元）<input class="x-form-text x-form-field" iscurrent="0" issingle="1" name="qqq" txtisnotnull="1" txtlabel="萨达" txtvaluetype="varchar" type="text" width="" xtype="resumeselector" /></p>
             <p>
             <textarea class="x-form-textarea x-form-field x-column" name="cwsjbyj" style="width: 711px; height: 66px;" txtlabel="财务审计部意见" txtsize="1000" txtvaluetype="text" width="" xtype="commoneditor"></textarea></p>
             </td>
             </tr>
             <tr class="tr-info">
             <td class="td-info" colspan="1">
             营运管理部</td>
             <td class="td-info" colspan="5" rowspan="1">
             分配到<select name="fgs" txtisnotnull="1" txtlabel="分公司"><option value="营运一分公司">营运一分公司</option><option value="营运二分公司">营运二分公司</option><option value="枢纽分公司">枢纽分公司</option></select>
             <p>
             <textarea class="x-form-textarea x-form-field x-column" name="yyglbyj" style="width: 710px; height: 68px;" txtlabel="营运管理部意见" txtsize="1000" txtvaluetype="text" width="" xtype="commoneditor"></textarea></p>
             </td>
             </tr>
             <tr class="tr-info">
             <td class="td-info" colspan="1">
             信息技术部</td>
             <td class="td-info" colspan="5" rowspan="1">
             <p>
             登记工号信息</p>
             <p>
             <textarea class="x-form-textarea x-form-field x-column" name="xxjsbyj" style="width: 712px; height: 77px;" txtlabel="信息技术部意见" txtsize="1000" txtvaluetype="text" width="" xtype="commoneditor"></textarea></p>
             </td>
             </tr>
             <tr>
             <td class="td-info" colspan="1">
             宜春市春城通科技有限公司</td>
             <td class="td-info" colspan="5" rowspan="1">
             <p>
             办理IC卡</p>
             <p>
             <textarea class="x-form-textarea x-form-field x-column" name="cctkjyxgsyj" style="width: 709px; height: 75px;" txtlabel="春城通科技有限公司意见" txtsize="1000" txtvaluetype="text" width="" xtype="commoneditor"></textarea></p>
             </td>
             </tr>
             <tr class="tr-info">
             <td class="td-info" colspan="1">
             综合管理部</td>
             <td class="td-info" colspan="5" rowspan="1">
             <p>
             录取指纹</p>
             <p>
             <textarea class="x-form-textarea x-form-field x-column" name="zhglbyj" style="width: 710px; height: 78px; margin-top: 0px; margin-bottom: 0px;" txtlabel="综合管理部意见" txtsize="1000" txtvaluetype="text" width="" xtype="commoneditor"></textarea></p>
             </td>
             </tr>
             <tr>
             <td class="td-info" colspan="1">
             分公司接收情况反馈</td>
             <td class="td-info" colspan="5">
             <textarea class="x-form-textarea x-form-field x-column" name="jbbmyj" style="width: 711px; height: 56px;" txtlabel="分公司接收情况反馈" txtsize="1000" txtvaluetype="text" width="" xtype="commoneditor"></textarea></td>
             </tr>
             <tr>
             <td class="td-info">
             人力资源部</td>
             <td class="td-info" colspan="5" rowspan="1">
             <p>
             <input name="rlzyb1" txtlabel="人力资源部1" type="checkbox" />签订合同&nbsp;&nbsp;<input name="rlzyb2" txtlabel="人力资源部2" type="checkbox" />领取服装&nbsp;&nbsp;<input name="rlzyb3" txtlabel="人力资源部3" type="checkbox" />开介绍信到分公司</p>
             <p>
             <textarea class="x-form-textarea x-form-field x-column" name="rlzybyj" style="width: 707px; height: 66px;" txtlabel="人力资源部意见" txtsize="1000" txtvaluetype="text" width="" xtype="commoneditor"></textarea></p>
             </td>
             </tr>
             </tbody>
             </table>
             </div>
             <p>
             &nbsp;</p>

             */

            private Object version;
            private Object orgId;
            private Object orgPath;
            private int runId;
            private String subject;
            private String creator;
            private Object assignee;
            private String createtime;
            private String endtime;
            private Object isMany;
            private Object showData;
            private String piId;
            private String pdId;
            private int piDbid;
            private String processName;
            private Object busDesc;
            private String entityName;
            private String entityId;
            private int formDefId;
            private int runStatus;
            private AppUserBean appUser;
            private String defId;
            private int userId;
            private String defHtml;

            public Object getVersion() {
                return version;
            }

            public void setVersion(Object version) {
                this.version = version;
            }

            public Object getOrgId() {
                return orgId;
            }

            public void setOrgId(Object orgId) {
                this.orgId = orgId;
            }

            public Object getOrgPath() {
                return orgPath;
            }

            public void setOrgPath(Object orgPath) {
                this.orgPath = orgPath;
            }

            public int getRunId() {
                return runId;
            }

            public void setRunId(int runId) {
                this.runId = runId;
            }

            public String getSubject() {
                return subject;
            }

            public void setSubject(String subject) {
                this.subject = subject;
            }

            public String getCreator() {
                return creator;
            }

            public void setCreator(String creator) {
                this.creator = creator;
            }

            public Object getAssignee() {
                return assignee;
            }

            public void setAssignee(Object assignee) {
                this.assignee = assignee;
            }

            public String getCreatetime() {
                return createtime;
            }

            public void setCreatetime(String createtime) {
                this.createtime = createtime;
            }

            public String getEndtime() {
                return endtime;
            }

            public void setEndtime(String endtime) {
                this.endtime = endtime;
            }

            public Object getIsMany() {
                return isMany;
            }

            public void setIsMany(Object isMany) {
                this.isMany = isMany;
            }

            public Object getShowData() {
                return showData;
            }

            public void setShowData(Object showData) {
                this.showData = showData;
            }

            public String getPiId() {
                return piId;
            }

            public void setPiId(String piId) {
                this.piId = piId;
            }

            public String getPdId() {
                return pdId;
            }

            public void setPdId(String pdId) {
                this.pdId = pdId;
            }

            public int getPiDbid() {
                return piDbid;
            }

            public void setPiDbid(int piDbid) {
                this.piDbid = piDbid;
            }

            public String getProcessName() {
                return processName;
            }

            public void setProcessName(String processName) {
                this.processName = processName;
            }

            public Object getBusDesc() {
                return busDesc;
            }

            public void setBusDesc(Object busDesc) {
                this.busDesc = busDesc;
            }

            public String getEntityName() {
                return entityName;
            }

            public void setEntityName(String entityName) {
                this.entityName = entityName;
            }

            public String getEntityId() {
                return entityId;
            }

            public void setEntityId(String entityId) {
                this.entityId = entityId;
            }

            public int getFormDefId() {
                return formDefId;
            }

            public void setFormDefId(int formDefId) {
                this.formDefId = formDefId;
            }

            public int getRunStatus() {
                return runStatus;
            }

            public void setRunStatus(int runStatus) {
                this.runStatus = runStatus;
            }

            public AppUserBean getAppUser() {
                return appUser;
            }

            public void setAppUser(AppUserBean appUser) {
                this.appUser = appUser;
            }

            public String getDefId() {
                return defId;
            }

            public void setDefId(String defId) {
                this.defId = defId;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public String getDefHtml() {
                return defHtml;
            }

            public void setDefHtml(String defHtml) {
                this.defHtml = defHtml;
            }

            public static class AppUserBean {
                /**
                 * version : null
                 * orgId : null
                 * orgPath : null
                 * userId : 9417
                 * username : 刘望
                 * email :
                 * jobId : null
                 * phone :
                 * mobile :
                 * fax :
                 * address :
                 * zip :
                 * photo :
                 * accessionTime : 2018-08-10
                 * status : 1
                 * xzxt : 0,1
                 * education : null
                 * title : 1
                 * fullname : 刘望
                 * userCode : 2612
                 * delFlag : 0
                 * dynamicPwd : null
                 * dyPwdStatus : null
                 * depNames : 安全服务部
                 * posNames : 科员
                 * roleNames : 安全服务部科员
                 * primaryDep : 安全服务部
                 * department : {"version":null,"orgId":null,"orgPath":null,"depId":497,"depName":"安全服务部","depDesc":"","depLevel":2,"parentId":378,"path":"0.378.497.","orgType":2,"creatorId":1,"createtime":"2018-07-13 17:59:29","updateId":1,"updatetime":"2019-01-04 19:56:05","sn":3,"chargeIds":"20335","chargeNames":"欧阳翰","demension":{"version":null,"orgId":null,"orgPath":null,"demId":1,"demName":"行政维度","demDesc":"行政维度","demType":1}}
                 * company : null
                 * czykh : null
                 * id : 9417
                 * enabled : true
                 * givenName : 刘望
                 * supperManage : false
                 * firstKeyColumnName : userId
                 * functionRights :
                 * validTopModules : {}
                 * superAdmin : false
                 * businessEmail :
                 * accountNonExpired : true
                 * credentialsNonExpired : true
                 * accountNonLocked : true
                 * authorities : [{"version":null,"orgId":null,"orgPath":null,"roleId":93,"roleName":"安全服务部科员","roleDesc":"","status":1,"isDefaultIn":0,"rights":"Mod_Oa,MyDesktop,AppHome,_TodoPanelView,_TaskPanelView,_NewTestView,SuperWorkTaskSuperView,DiaryView,_publishSupd,WeeklyView,Flow,NewProcess,MyTaskView,MyProcessRunView,Communication,ProfileForm,PhoneBook,FileSendView,InnerMail,MailForm,PersonalMailBoxView,Mod_Enterprise,star,HYStarLD,HYStarAQ,StardriversStatusView,StarAQKH,StarFWKH,StarWSKH,HYStarFW,CheckAQKH,CheckFWKH,CheckWSKH,HYStarMark,StarDriverView,StarSeeingView,HYStarSetting,StarAQKHSetting,StarFWKHSetting,StarWSKHSetting,StarKHSet,Mod_YF,Excellence,AppygzqLoginView,HrhsDetailView,TypicalPersonView,CommendationView,BrandLineView,GloryListView,MessageBoardView,Mod_insurance,HYStarAQ,ScoreDicManagerView,MoneyicManagerView,RewardPunishmentSurfaceTypeView,IllegalInfo,ChaoSuSetUpView,JcIllegalInfoView,_JcIllegalInfoQueryAll,_JcIllegalInfoQuerySubmit,_JcIllegalInfoCheck,_JcIllegalInfoUnCheck,_JcIllegalInfoSubmit,_JcIllegalInfoUnSubmit,ChaoSuFaKuanView,DriverViolationDetailedView,DriverViolationStatisticsDayView,DriverViolationStatisticsMonthView,DriverViolationStatisticsYearView,StationIntervalRecView,dianjianrichang,BusSelectorJckrichangView,JckrichangJcView,JckrichangMxView,BusSelectorVehicleView,VehicleCarJcView,VehicleCarJcCount,JCStarAQ,JckrichangJcHzView,JckrichangJcChartView,VehicleHzView,VehicleFenXiView,VehicleCarJcChartView,jCZdjiankman,AccidentViolation,AccidentBasicInformationView,AccidentLedgerView,AccidentTaizView,AccidentSituationView,SafetyServiceStatisticsView,AccidentDayStatisticsView,AccidentMonthStatisticsView,AccidentYearStatisticsView,MeasureBusAccident,MeasureBusAccidentView,CheckInsure,HrTimeOutAlert,AutoInsureSetting,AutoInsureView,InsureRecordView,ygbxgl,EmployeeInsuranceView,tj,AccidentRecordCountView,AccidentRecordAQZBView,InsureReportView,InsureYearCountReportView,ViolationRecordCountView,ViolationReportView","name":"安全服务部科员","id":"93","type":"candidate","authority":"安全服务部科员"},{"authority":"ROLE_PUBLIC"}]
                 * familyName : 刘望
                 */

                private Object version;
                private Object orgId;
                private Object orgPath;
                private int userId;
                private String username;
                private String email;
                private Object jobId;
                private String phone;
                private String mobile;
                private String fax;
                private String address;
                private String zip;
                private String photo;
                private String accessionTime;
                private int status;
                private String xzxt;
                private Object education;
                private int title;
                private String fullname;
                private String userCode;
                private int delFlag;
                private Object dynamicPwd;
                private Object dyPwdStatus;
                private String depNames;
                private String posNames;
                private String roleNames;
                private String primaryDep;
                private DepartmentBean department;
                private Object company;
                private Object czykh;
                private String id;
                private boolean enabled;
                private String givenName;
                private boolean supperManage;
                private String firstKeyColumnName;
                private String functionRights;
                private ValidTopModulesBean validTopModules;
                private boolean superAdmin;
                private String businessEmail;
                private boolean accountNonExpired;
                private boolean credentialsNonExpired;
                private boolean accountNonLocked;
                private String familyName;
                private List<AuthoritiesBean> authorities;

                public Object getVersion() {
                    return version;
                }

                public void setVersion(Object version) {
                    this.version = version;
                }

                public Object getOrgId() {
                    return orgId;
                }

                public void setOrgId(Object orgId) {
                    this.orgId = orgId;
                }

                public Object getOrgPath() {
                    return orgPath;
                }

                public void setOrgPath(Object orgPath) {
                    this.orgPath = orgPath;
                }

                public int getUserId() {
                    return userId;
                }

                public void setUserId(int userId) {
                    this.userId = userId;
                }

                public String getUsername() {
                    return username;
                }

                public void setUsername(String username) {
                    this.username = username;
                }

                public String getEmail() {
                    return email;
                }

                public void setEmail(String email) {
                    this.email = email;
                }

                public Object getJobId() {
                    return jobId;
                }

                public void setJobId(Object jobId) {
                    this.jobId = jobId;
                }

                public String getPhone() {
                    return phone;
                }

                public void setPhone(String phone) {
                    this.phone = phone;
                }

                public String getMobile() {
                    return mobile;
                }

                public void setMobile(String mobile) {
                    this.mobile = mobile;
                }

                public String getFax() {
                    return fax;
                }

                public void setFax(String fax) {
                    this.fax = fax;
                }

                public String getAddress() {
                    return address;
                }

                public void setAddress(String address) {
                    this.address = address;
                }

                public String getZip() {
                    return zip;
                }

                public void setZip(String zip) {
                    this.zip = zip;
                }

                public String getPhoto() {
                    return photo;
                }

                public void setPhoto(String photo) {
                    this.photo = photo;
                }

                public String getAccessionTime() {
                    return accessionTime;
                }

                public void setAccessionTime(String accessionTime) {
                    this.accessionTime = accessionTime;
                }

                public int getStatus() {
                    return status;
                }

                public void setStatus(int status) {
                    this.status = status;
                }

                public String getXzxt() {
                    return xzxt;
                }

                public void setXzxt(String xzxt) {
                    this.xzxt = xzxt;
                }

                public Object getEducation() {
                    return education;
                }

                public void setEducation(Object education) {
                    this.education = education;
                }

                public int getTitle() {
                    return title;
                }

                public void setTitle(int title) {
                    this.title = title;
                }

                public String getFullname() {
                    return fullname;
                }

                public void setFullname(String fullname) {
                    this.fullname = fullname;
                }

                public String getUserCode() {
                    return userCode;
                }

                public void setUserCode(String userCode) {
                    this.userCode = userCode;
                }

                public int getDelFlag() {
                    return delFlag;
                }

                public void setDelFlag(int delFlag) {
                    this.delFlag = delFlag;
                }

                public Object getDynamicPwd() {
                    return dynamicPwd;
                }

                public void setDynamicPwd(Object dynamicPwd) {
                    this.dynamicPwd = dynamicPwd;
                }

                public Object getDyPwdStatus() {
                    return dyPwdStatus;
                }

                public void setDyPwdStatus(Object dyPwdStatus) {
                    this.dyPwdStatus = dyPwdStatus;
                }

                public String getDepNames() {
                    return depNames;
                }

                public void setDepNames(String depNames) {
                    this.depNames = depNames;
                }

                public String getPosNames() {
                    return posNames;
                }

                public void setPosNames(String posNames) {
                    this.posNames = posNames;
                }

                public String getRoleNames() {
                    return roleNames;
                }

                public void setRoleNames(String roleNames) {
                    this.roleNames = roleNames;
                }

                public String getPrimaryDep() {
                    return primaryDep;
                }

                public void setPrimaryDep(String primaryDep) {
                    this.primaryDep = primaryDep;
                }

                public DepartmentBean getDepartment() {
                    return department;
                }

                public void setDepartment(DepartmentBean department) {
                    this.department = department;
                }

                public Object getCompany() {
                    return company;
                }

                public void setCompany(Object company) {
                    this.company = company;
                }

                public Object getCzykh() {
                    return czykh;
                }

                public void setCzykh(Object czykh) {
                    this.czykh = czykh;
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public boolean isEnabled() {
                    return enabled;
                }

                public void setEnabled(boolean enabled) {
                    this.enabled = enabled;
                }

                public String getGivenName() {
                    return givenName;
                }

                public void setGivenName(String givenName) {
                    this.givenName = givenName;
                }

                public boolean isSupperManage() {
                    return supperManage;
                }

                public void setSupperManage(boolean supperManage) {
                    this.supperManage = supperManage;
                }

                public String getFirstKeyColumnName() {
                    return firstKeyColumnName;
                }

                public void setFirstKeyColumnName(String firstKeyColumnName) {
                    this.firstKeyColumnName = firstKeyColumnName;
                }

                public String getFunctionRights() {
                    return functionRights;
                }

                public void setFunctionRights(String functionRights) {
                    this.functionRights = functionRights;
                }

                public ValidTopModulesBean getValidTopModules() {
                    return validTopModules;
                }

                public void setValidTopModules(ValidTopModulesBean validTopModules) {
                    this.validTopModules = validTopModules;
                }

                public boolean isSuperAdmin() {
                    return superAdmin;
                }

                public void setSuperAdmin(boolean superAdmin) {
                    this.superAdmin = superAdmin;
                }

                public String getBusinessEmail() {
                    return businessEmail;
                }

                public void setBusinessEmail(String businessEmail) {
                    this.businessEmail = businessEmail;
                }

                public boolean isAccountNonExpired() {
                    return accountNonExpired;
                }

                public void setAccountNonExpired(boolean accountNonExpired) {
                    this.accountNonExpired = accountNonExpired;
                }

                public boolean isCredentialsNonExpired() {
                    return credentialsNonExpired;
                }

                public void setCredentialsNonExpired(boolean credentialsNonExpired) {
                    this.credentialsNonExpired = credentialsNonExpired;
                }

                public boolean isAccountNonLocked() {
                    return accountNonLocked;
                }

                public void setAccountNonLocked(boolean accountNonLocked) {
                    this.accountNonLocked = accountNonLocked;
                }

                public String getFamilyName() {
                    return familyName;
                }

                public void setFamilyName(String familyName) {
                    this.familyName = familyName;
                }

                public List<AuthoritiesBean> getAuthorities() {
                    return authorities;
                }

                public void setAuthorities(List<AuthoritiesBean> authorities) {
                    this.authorities = authorities;
                }

                public static class DepartmentBean {
                    public static class DemensionBean {
                    }
                }

                public static class ValidTopModulesBean {
                }

                public static class AuthoritiesBean {
                    /**
                     * version : null
                     * orgId : null
                     * orgPath : null
                     * roleId : 93
                     * roleName : 安全服务部科员
                     * roleDesc :
                     * status : 1
                     * isDefaultIn : 0
                     * rights : Mod_Oa,MyDesktop,AppHome,_TodoPanelView,_TaskPanelView,_NewTestView,SuperWorkTaskSuperView,DiaryView,_publishSupd,WeeklyView,Flow,NewProcess,MyTaskView,MyProcessRunView,Communication,ProfileForm,PhoneBook,FileSendView,InnerMail,MailForm,PersonalMailBoxView,Mod_Enterprise,star,HYStarLD,HYStarAQ,StardriversStatusView,StarAQKH,StarFWKH,StarWSKH,HYStarFW,CheckAQKH,CheckFWKH,CheckWSKH,HYStarMark,StarDriverView,StarSeeingView,HYStarSetting,StarAQKHSetting,StarFWKHSetting,StarWSKHSetting,StarKHSet,Mod_YF,Excellence,AppygzqLoginView,HrhsDetailView,TypicalPersonView,CommendationView,BrandLineView,GloryListView,MessageBoardView,Mod_insurance,HYStarAQ,ScoreDicManagerView,MoneyicManagerView,RewardPunishmentSurfaceTypeView,IllegalInfo,ChaoSuSetUpView,JcIllegalInfoView,_JcIllegalInfoQueryAll,_JcIllegalInfoQuerySubmit,_JcIllegalInfoCheck,_JcIllegalInfoUnCheck,_JcIllegalInfoSubmit,_JcIllegalInfoUnSubmit,ChaoSuFaKuanView,DriverViolationDetailedView,DriverViolationStatisticsDayView,DriverViolationStatisticsMonthView,DriverViolationStatisticsYearView,StationIntervalRecView,dianjianrichang,BusSelectorJckrichangView,JckrichangJcView,JckrichangMxView,BusSelectorVehicleView,VehicleCarJcView,VehicleCarJcCount,JCStarAQ,JckrichangJcHzView,JckrichangJcChartView,VehicleHzView,VehicleFenXiView,VehicleCarJcChartView,jCZdjiankman,AccidentViolation,AccidentBasicInformationView,AccidentLedgerView,AccidentTaizView,AccidentSituationView,SafetyServiceStatisticsView,AccidentDayStatisticsView,AccidentMonthStatisticsView,AccidentYearStatisticsView,MeasureBusAccident,MeasureBusAccidentView,CheckInsure,HrTimeOutAlert,AutoInsureSetting,AutoInsureView,InsureRecordView,ygbxgl,EmployeeInsuranceView,tj,AccidentRecordCountView,AccidentRecordAQZBView,InsureReportView,InsureYearCountReportView,ViolationRecordCountView,ViolationReportView
                     * name : 安全服务部科员
                     * id : 93
                     * type : candidate
                     * authority : 安全服务部科员
                     */

                    private Object version;
                    private Object orgId;
                    private Object orgPath;
                    private int roleId;
                    private String roleName;
                    private String roleDesc;
                    private int status;
                    private int isDefaultIn;
                    private String rights;
                    private String name;
                    private String id;
                    private String type;
                    private String authority;

                    public Object getVersion() {
                        return version;
                    }

                    public void setVersion(Object version) {
                        this.version = version;
                    }

                    public Object getOrgId() {
                        return orgId;
                    }

                    public void setOrgId(Object orgId) {
                        this.orgId = orgId;
                    }

                    public Object getOrgPath() {
                        return orgPath;
                    }

                    public void setOrgPath(Object orgPath) {
                        this.orgPath = orgPath;
                    }

                    public int getRoleId() {
                        return roleId;
                    }

                    public void setRoleId(int roleId) {
                        this.roleId = roleId;
                    }

                    public String getRoleName() {
                        return roleName;
                    }

                    public void setRoleName(String roleName) {
                        this.roleName = roleName;
                    }

                    public String getRoleDesc() {
                        return roleDesc;
                    }

                    public void setRoleDesc(String roleDesc) {
                        this.roleDesc = roleDesc;
                    }

                    public int getStatus() {
                        return status;
                    }

                    public void setStatus(int status) {
                        this.status = status;
                    }

                    public int getIsDefaultIn() {
                        return isDefaultIn;
                    }

                    public void setIsDefaultIn(int isDefaultIn) {
                        this.isDefaultIn = isDefaultIn;
                    }

                    public String getRights() {
                        return rights;
                    }

                    public void setRights(String rights) {
                        this.rights = rights;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public String getId() {
                        return id;
                    }

                    public void setId(String id) {
                        this.id = id;
                    }

                    public String getType() {
                        return type;
                    }

                    public void setType(String type) {
                        this.type = type;
                    }

                    public String getAuthority() {
                        return authority;
                    }

                    public void setAuthority(String authority) {
                        this.authority = authority;
                    }
                }
            }
        }
    }
}
