package com.hy.powerplatform.oa_flow.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/4/16.
 */

public class Inbox implements Serializable {

    /**
     * success : true
     * totalCounts : 3
     * result : [{"version":null,"orgId":null,"orgPath":null,"boxId":10048,"sendTime":"2019-01-30 15:28:10","delFlag":0,"readFlag":1,"note":"发送出去的邮件","mail":{"version":null,"orgId":null,"orgPath":null,"mailId":10023,"sender":"超级管理员","importantFlag":1,"sendTime":"2019-01-30 15:28:10","content":"<p>\n\t<span style=\"color: rgb(0, 0, 0); font-family: &quot;Microsoft Yahei&quot;, &quot;microsoft yahei&quot;, sans-serif; font-size: 16px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400; letter-spacing: normal; orphans: 2; text-align: justify; text-indent: 0px; text-transform: none; white-space: normal; widows: 2; word-spacing: 0px; -webkit-text-stroke-width: 0px; background-color: rgb(255, 255, 255); text-decoration-style: initial; text-decoration-color: initial; display: inline !important; float: none;\">轻启轩窗，春燕盘旋，杨柳依依，芳草青青，花影斑驳，桃李芳菲尽，夏花次第开。五月的风儿，轻轻的柔柔的暖暖的亲吻过脸颊，鼻间新绿的清香泉水般&ldquo;汩汩&rdquo;的流淌。走过春天，躲过流年，站在五月的时空隧道中，时光竟然还是这般的如此匆匆。绿萝拂过衣襟，青云打湿诺言，红尘陌上，我们独自行走，风儿吹乱了发梢，惊扰了一地的千纸鹤。轻点朱颜淡描妆，树影婆娑，花儿摇曳。也许，我们都很好，只是时光不凑巧。<\/span><\/p>\n","subject":"测试上传","copyToNames":"","copyToIDs":"","recipientNames":"施鹏","recipientIDs":"9371","mailStatus":1,"appSender":{"version":null,"orgId":null,"orgPath":null,"userId":1,"username":"admin","email":"111@qq.com","jobId":148,"phone":null,"mobile":null,"fax":"","address":"","zip":"","photo":"","accessionTime":"2009-12-18","status":1,"xzxt":"0,1","education":null,"title":1,"fullname":"超级管理员","userCode":"888888888","delFlag":0,"dynamicPwd":null,"dyPwdStatus":null,"depNames":"宜春公交集团有限公司","posNames":"科员","roleNames":"超级管理员","primaryDep":"宜春公交集团有限公司","department":{"version":null,"orgId":null,"orgPath":null,"depId":378,"depName":"宜春公交集团有限公司","depDesc":"","depLevel":1,"parentId":0,"path":"0.378.","orgType":1,"creatorId":1,"createtime":"2016-03-16 09:17:49","updateId":1,"updatetime":"2018-12-14 22:43:19","sn":null,"chargeIds":"","chargeNames":"","demension":{"version":null,"orgId":null,"orgPath":null,"demId":1,"demName":"行政维度","demDesc":"行政维度","demType":1}},"company":null,"czykh":null,"id":"1","enabled":true,"givenName":"超级管理员","credentialsNonExpired":true,"accountNonLocked":true,"accountNonExpired":true,"authorities":[{"version":null,"orgId":null,"orgPath":null,"roleId":-1,"roleName":"超级管理员","roleDesc":"超级管理员,具有所有权限","status":1,"isDefaultIn":0,"rights":"__ALL","authority":"超级管理员","name":"超级管理员","id":"-1","type":"candidate"},{"authority":"ROLE_PUBLIC"}],"functionRights":"","firstKeyColumnName":"userId","superAdmin":true,"validTopModules":{},"businessEmail":"111@qq.com","familyName":"超级管理员","supperManage":true},"fileIds":"7723,","filenames":"51CTO下载-MD5加密解密.docx,","img":null,"id":10023,"firstKeyColumnName":"mailId"},"appUser":{"version":null,"orgId":null,"orgPath":null,"userId":9371,"username":"施鹏","email":"11@qq.com","jobId":null,"phone":"","mobile":"","fax":"","address":"","zip":"","photo":"","accessionTime":"2018-07-18","status":1,"xzxt":"0,1","education":null,"title":1,"fullname":"施鹏","userCode":"2100","delFlag":0,"dynamicPwd":null,"dyPwdStatus":null,"depNames":"信息技术部","posNames":"管理员","roleNames":"信息技术部系统管理员","primaryDep":"信息技术部","department":{"version":null,"orgId":null,"orgPath":null,"depId":500,"depName":"信息技术部","depDesc":"","depLevel":2,"parentId":378,"path":"0.378.500.","orgType":2,"creatorId":1,"createtime":"2018-07-13 18:00:53","updateId":1,"updatetime":"2019-01-04 19:56:42","sn":6,"chargeIds":"10102","chargeNames":"欧阳晓林","demension":{"version":null,"orgId":null,"orgPath":null,"demId":1,"demName":"行政维度","demDesc":"行政维度","demType":1}},"company":null,"czykh":null,"id":"9371","enabled":true,"givenName":"施鹏","credentialsNonExpired":true,"accountNonLocked":true,"accountNonExpired":true,"authorities":[{"version":null,"orgId":null,"orgPath":null,"roleId":101,"roleName":"信息技术部系统管理员","roleDesc":"","status":1,"isDefaultIn":0,"rights":"Mod_Oa,MyDesktop,AppHome,_TodoPanelView,_TaskPanelView,_NewTestView,SupervisionTask,SuperTaskOperView,_updateSuper,SuperWorkTaskSuperView,CalendarPlanView_1,DiaryView,_publishSupd,MySubUserDiaryView,WeeklyView,_publishSub,MySubUserWeeklyView,MeetingManager,AddConferenceView,MyJoinConferenceView,MyJoinedConferenceView,ConfSummaryView,_ConfSummaryDel,Flow,NewProcess,MyTaskView,MyProcessRunView,RelevantProcessRunView,ProcessCountView,Archives,NoticeView,_NoticeQuery,Communication,ProfileForm,PhoneBook,FileSendView,InnerMail,MailForm,PersonalMailBoxView,Document,PrivateDocumentView,DocumentSharedView,Mod_Hr,Mod_Enterprise,Mod_YF,Mod_insurance,Mod_costs,Mod_gg,Mod_operate,Mod_cashier,Mod_staffzone,StaffLearn,MoniTestView,OnlineTestView,LineSafetyInstructionView,TrainingMaterialsView,AccidentCaseView,Mod_assistmanager,Mod_Sys,SystemSetting,AppUserView,_AppUserQuery,_AppUserAdd,_AppUserEdit,_AppUserDel,_AppUserReset,AppLoginView,AppRoleView,_AppRoleList,_AppRoleAdd,_AppRoleEdit,_AppRoleDel,_AppRoleGrant,AppRoleDataFuncView,AppRoleOrgFuncView,AppRoleComplaintFuncView,AppRoleRewardPunishmentSurfaceFuncView,HZItemJurisdiction2View,ModuleManagerView,OrgSettingView,BusOrgView,SubordinateView,CompanyView,FileAttachView,_FileAttachQuery,ReportTemplateView,_ReportTemplateQuery,_ReportTemplateAdd,_ReportTemplateEdit,_ReportParamSetting,_ReportTemplateDel,TypeManager,TypeKeyView,GlobalTypeManager,DicManager,_DictionaryQuery,_DictionaryAdd,_DictionaryEdit,_DictionaryDel,SerialNumberView,ModuleManagementView,Mod_zhfx,Mod_clwxgl,Mod_clcrkgl,Mod_zcgl","authority":"信息技术部系统管理员","name":"信息技术部系统管理员","id":"101","type":"candidate"},{"authority":"ROLE_PUBLIC"}],"functionRights":"","firstKeyColumnName":"userId","superAdmin":false,"validTopModules":{},"businessEmail":"11@qq.com","familyName":"施鹏","supperManage":false},"mailFolder":{"version":null,"orgId":null,"orgPath":null,"folderId":1,"folderName":"收件箱","parentId":0,"depLevel":1,"path":"0.1.","isPublic":1,"folderType":1,"appUser":null,"id":1,"userId":null,"firstKeyColumnName":"folderId"},"replyFlag":0,"id":10048,"userId":9371,"folderId":1,"mailId":10023,"firstKeyColumnName":"boxId"},{"version":null,"orgId":null,"orgPath":null,"boxId":10032,"sendTime":"2019-01-30 13:58:41","delFlag":0,"readFlag":0,"note":"发送出去的邮件","mail":{"version":null,"orgId":null,"orgPath":null,"mailId":10015,"sender":"欧阳晓林","importantFlag":1,"sendTime":"2019-01-30 13:58:41","content":"<p>\n\t发对发生的发生的发生的发生地方双方的身份的<\/p>\n","subject":"发达发达","copyToNames":"","copyToIDs":"","recipientNames":"施鹏","recipientIDs":"9371","mailStatus":1,"appSender":{"version":null,"orgId":null,"orgPath":null,"userId":9354,"username":"欧阳晓林","email":"111@qq.com","jobId":null,"phone":"","mobile":"","fax":"","address":"","zip":"","photo":"","accessionTime":"2018-07-18","status":1,"xzxt":"0,1","education":null,"title":1,"fullname":"欧阳晓林","userCode":"1729","delFlag":0,"dynamicPwd":null,"dyPwdStatus":null,"depNames":"信息技术部","posNames":"职能部门副职","roleNames":"信息技术部负责人","primaryDep":"信息技术部","department":{"version":null,"orgId":null,"orgPath":null,"depId":500,"depName":"信息技术部","depDesc":"","depLevel":2,"parentId":378,"path":"0.378.500.","orgType":2,"creatorId":1,"createtime":"2018-07-13 18:00:53","updateId":1,"updatetime":"2019-01-04 19:56:42","sn":6,"chargeIds":"10102","chargeNames":"欧阳晓林","demension":{"version":null,"orgId":null,"orgPath":null,"demId":1,"demName":"行政维度","demDesc":"行政维度","demType":1}},"company":null,"czykh":null,"id":"9354","enabled":true,"givenName":"欧阳晓林","credentialsNonExpired":true,"accountNonLocked":true,"accountNonExpired":true,"authorities":[{"version":null,"orgId":null,"orgPath":null,"roleId":90,"roleName":"信息技术部负责人","roleDesc":"","status":1,"isDefaultIn":0,"rights":"Mod_Oa,MyDesktop,AppHome,_TaskBeginPanelView,_TodoPanelView,_MyDocumentPanelView,_TaskPanelView,_MessagePanelView,_ConferenceView,_NewTestView,_PerformTasksView,SupervisionTask,SuperTaskOperView,_updateSuper,SuperWorkTaskSuperView,CalendarPlanView_1,DiaryView,_publishSupd,MySubUserDiaryView,WeeklyView,_publishSub,MySubUserWeeklyView,MeetingManager,AddConferenceView,MyJoinConferenceView,MyJoinedConferenceView,TemporaryConferenceView,WaitOpenConferenceView,HaveOpenConferenceView,WaitCheckConfView,ConfApplyView,Flow,NewProcess,MyTaskView,MyProcessRunView,RelevantProcessRunView,ProcessCountView,Archives,NoticeView,_NoticeQuery,_NoticeAdd,_NoticeDel,Communication,ProfileForm,PhoneBook,FileSendView,InnerMail,MailForm,PersonalMailBoxView,Document,PrivateDocumentView,Mod_Hr,Hrm,LeaveDaysView,Mod_staffzone,StaffLearn,MoniTestView,OnlineTestView,LineSafetyInstructionView,TrainingMaterialsView,AccidentCaseView,Mod_Sys,SystemSetting,AppUserView,_AppUserQuery,_AppUserAdd,_AppUserEdit,_AppUserDel,_AppUserReset,AppLoginView,AppRoleView,_AppRoleList,_AppRoleAdd,_AppRoleEdit,_AppRoleDel,_AppRoleGrant,AppRoleDataFuncView,AppRoleOrgFuncView,AppRoleComplaintFuncView,AppRoleRewardPunishmentSurfaceFuncView,HZItemJurisdiction2View,OrgSettingView,SubordinateView,PositionUserView,CompanyView,DemensionView,TypeManager,DicManager,_DictionaryQuery,_DictionaryAdd,_DictionaryEdit,_DictionaryDel,SerialNumberView,flowManager,ProDefinitionManager,_FlowCheck,Mod_zcgl,GoodManeger,GoodsApplyView,GoodsCheckView","authority":"信息技术部负责人","name":"信息技术部负责人","id":"90","type":"candidate"},{"authority":"ROLE_PUBLIC"}],"functionRights":"","firstKeyColumnName":"userId","superAdmin":false,"validTopModules":{},"businessEmail":"111@qq.com","familyName":"欧阳晓林","supperManage":false},"fileIds":"7712,","filenames":"L_6.dat,","img":null,"id":10015,"firstKeyColumnName":"mailId"},"appUser":{"version":null,"orgId":null,"orgPath":null,"userId":9371,"username":"施鹏","email":"11@qq.com","jobId":null,"phone":"","mobile":"","fax":"","address":"","zip":"","photo":"","accessionTime":"2018-07-18","status":1,"xzxt":"0,1","education":null,"title":1,"fullname":"施鹏","userCode":"2100","delFlag":0,"dynamicPwd":null,"dyPwdStatus":null,"depNames":"信息技术部","posNames":"管理员","roleNames":"信息技术部系统管理员","primaryDep":"信息技术部","department":{"version":null,"orgId":null,"orgPath":null,"depId":500,"depName":"信息技术部","depDesc":"","depLevel":2,"parentId":378,"path":"0.378.500.","orgType":2,"creatorId":1,"createtime":"2018-07-13 18:00:53","updateId":1,"updatetime":"2019-01-04 19:56:42","sn":6,"chargeIds":"10102","chargeNames":"欧阳晓林","demension":{"version":null,"orgId":null,"orgPath":null,"demId":1,"demName":"行政维度","demDesc":"行政维度","demType":1}},"company":null,"czykh":null,"id":"9371","enabled":true,"givenName":"施鹏","credentialsNonExpired":true,"accountNonLocked":true,"accountNonExpired":true,"authorities":[{"version":null,"orgId":null,"orgPath":null,"roleId":101,"roleName":"信息技术部系统管理员","roleDesc":"","status":1,"isDefaultIn":0,"rights":"Mod_Oa,MyDesktop,AppHome,_TodoPanelView,_TaskPanelView,_NewTestView,SupervisionTask,SuperTaskOperView,_updateSuper,SuperWorkTaskSuperView,CalendarPlanView_1,DiaryView,_publishSupd,MySubUserDiaryView,WeeklyView,_publishSub,MySubUserWeeklyView,MeetingManager,AddConferenceView,MyJoinConferenceView,MyJoinedConferenceView,ConfSummaryView,_ConfSummaryDel,Flow,NewProcess,MyTaskView,MyProcessRunView,RelevantProcessRunView,ProcessCountView,Archives,NoticeView,_NoticeQuery,Communication,ProfileForm,PhoneBook,FileSendView,InnerMail,MailForm,PersonalMailBoxView,Document,PrivateDocumentView,DocumentSharedView,Mod_Hr,Mod_Enterprise,Mod_YF,Mod_insurance,Mod_costs,Mod_gg,Mod_operate,Mod_cashier,Mod_staffzone,StaffLearn,MoniTestView,OnlineTestView,LineSafetyInstructionView,TrainingMaterialsView,AccidentCaseView,Mod_assistmanager,Mod_Sys,SystemSetting,AppUserView,_AppUserQuery,_AppUserAdd,_AppUserEdit,_AppUserDel,_AppUserReset,AppLoginView,AppRoleView,_AppRoleList,_AppRoleAdd,_AppRoleEdit,_AppRoleDel,_AppRoleGrant,AppRoleDataFuncView,AppRoleOrgFuncView,AppRoleComplaintFuncView,AppRoleRewardPunishmentSurfaceFuncView,HZItemJurisdiction2View,ModuleManagerView,OrgSettingView,BusOrgView,SubordinateView,CompanyView,FileAttachView,_FileAttachQuery,ReportTemplateView,_ReportTemplateQuery,_ReportTemplateAdd,_ReportTemplateEdit,_ReportParamSetting,_ReportTemplateDel,TypeManager,TypeKeyView,GlobalTypeManager,DicManager,_DictionaryQuery,_DictionaryAdd,_DictionaryEdit,_DictionaryDel,SerialNumberView,ModuleManagementView,Mod_zhfx,Mod_clwxgl,Mod_clcrkgl,Mod_zcgl","authority":"信息技术部系统管理员","name":"信息技术部系统管理员","id":"101","type":"candidate"},{"authority":"ROLE_PUBLIC"}],"functionRights":"","firstKeyColumnName":"userId","superAdmin":false,"validTopModules":{},"businessEmail":"11@qq.com","familyName":"施鹏","supperManage":false},"mailFolder":{"version":null,"orgId":null,"orgPath":null,"folderId":1,"folderName":"收件箱","parentId":0,"depLevel":1,"path":"0.1.","isPublic":1,"folderType":1,"appUser":null,"id":1,"userId":null,"firstKeyColumnName":"folderId"},"replyFlag":0,"id":10032,"userId":9371,"folderId":1,"mailId":10015,"firstKeyColumnName":"boxId"},{"version":null,"orgId":null,"orgPath":null,"boxId":10030,"sendTime":"2019-01-30 13:55:58","delFlag":0,"readFlag":0,"note":"发送出去的邮件","mail":{"version":null,"orgId":null,"orgPath":null,"mailId":10014,"sender":"欧阳晓林","importantFlag":1,"sendTime":"2019-01-30 13:55:58","content":"<p>\n\t代付电费<\/p>\n","subject":"测试","copyToNames":"","copyToIDs":"","recipientNames":"施鹏","recipientIDs":"9371","mailStatus":1,"appSender":{"version":null,"orgId":null,"orgPath":null,"userId":9354,"username":"欧阳晓林","email":"111@qq.com","jobId":null,"phone":"","mobile":"","fax":"","address":"","zip":"","photo":"","accessionTime":"2018-07-18","status":1,"xzxt":"0,1","education":null,"title":1,"fullname":"欧阳晓林","userCode":"1729","delFlag":0,"dynamicPwd":null,"dyPwdStatus":null,"depNames":"信息技术部","posNames":"职能部门副职","roleNames":"信息技术部负责人","primaryDep":"信息技术部","department":{"version":null,"orgId":null,"orgPath":null,"depId":500,"depName":"信息技术部","depDesc":"","depLevel":2,"parentId":378,"path":"0.378.500.","orgType":2,"creatorId":1,"createtime":"2018-07-13 18:00:53","updateId":1,"updatetime":"2019-01-04 19:56:42","sn":6,"chargeIds":"10102","chargeNames":"欧阳晓林","demension":{"version":null,"orgId":null,"orgPath":null,"demId":1,"demName":"行政维度","demDesc":"行政维度","demType":1}},"company":null,"czykh":null,"id":"9354","enabled":true,"givenName":"欧阳晓林","credentialsNonExpired":true,"accountNonLocked":true,"accountNonExpired":true,"authorities":[{"version":null,"orgId":null,"orgPath":null,"roleId":90,"roleName":"信息技术部负责人","roleDesc":"","status":1,"isDefaultIn":0,"rights":"Mod_Oa,MyDesktop,AppHome,_TaskBeginPanelView,_TodoPanelView,_MyDocumentPanelView,_TaskPanelView,_MessagePanelView,_ConferenceView,_NewTestView,_PerformTasksView,SupervisionTask,SuperTaskOperView,_updateSuper,SuperWorkTaskSuperView,CalendarPlanView_1,DiaryView,_publishSupd,MySubUserDiaryView,WeeklyView,_publishSub,MySubUserWeeklyView,MeetingManager,AddConferenceView,MyJoinConferenceView,MyJoinedConferenceView,TemporaryConferenceView,WaitOpenConferenceView,HaveOpenConferenceView,WaitCheckConfView,ConfApplyView,Flow,NewProcess,MyTaskView,MyProcessRunView,RelevantProcessRunView,ProcessCountView,Archives,NoticeView,_NoticeQuery,_NoticeAdd,_NoticeDel,Communication,ProfileForm,PhoneBook,FileSendView,InnerMail,MailForm,PersonalMailBoxView,Document,PrivateDocumentView,Mod_Hr,Hrm,LeaveDaysView,Mod_staffzone,StaffLearn,MoniTestView,OnlineTestView,LineSafetyInstructionView,TrainingMaterialsView,AccidentCaseView,Mod_Sys,SystemSetting,AppUserView,_AppUserQuery,_AppUserAdd,_AppUserEdit,_AppUserDel,_AppUserReset,AppLoginView,AppRoleView,_AppRoleList,_AppRoleAdd,_AppRoleEdit,_AppRoleDel,_AppRoleGrant,AppRoleDataFuncView,AppRoleOrgFuncView,AppRoleComplaintFuncView,AppRoleRewardPunishmentSurfaceFuncView,HZItemJurisdiction2View,OrgSettingView,SubordinateView,PositionUserView,CompanyView,DemensionView,TypeManager,DicManager,_DictionaryQuery,_DictionaryAdd,_DictionaryEdit,_DictionaryDel,SerialNumberView,flowManager,ProDefinitionManager,_FlowCheck,Mod_zcgl,GoodManeger,GoodsApplyView,GoodsCheckView","authority":"信息技术部负责人","name":"信息技术部负责人","id":"90","type":"candidate"},{"authority":"ROLE_PUBLIC"}],"functionRights":"","firstKeyColumnName":"userId","superAdmin":false,"validTopModules":{},"businessEmail":"111@qq.com","familyName":"欧阳晓林","supperManage":false},"fileIds":"","filenames":"","img":null,"id":10014,"firstKeyColumnName":"mailId"},"appUser":{"version":null,"orgId":null,"orgPath":null,"userId":9371,"username":"施鹏","email":"11@qq.com","jobId":null,"phone":"","mobile":"","fax":"","address":"","zip":"","photo":"","accessionTime":"2018-07-18","status":1,"xzxt":"0,1","education":null,"title":1,"fullname":"施鹏","userCode":"2100","delFlag":0,"dynamicPwd":null,"dyPwdStatus":null,"depNames":"信息技术部","posNames":"管理员","roleNames":"信息技术部系统管理员","primaryDep":"信息技术部","department":{"version":null,"orgId":null,"orgPath":null,"depId":500,"depName":"信息技术部","depDesc":"","depLevel":2,"parentId":378,"path":"0.378.500.","orgType":2,"creatorId":1,"createtime":"2018-07-13 18:00:53","updateId":1,"updatetime":"2019-01-04 19:56:42","sn":6,"chargeIds":"10102","chargeNames":"欧阳晓林","demension":{"version":null,"orgId":null,"orgPath":null,"demId":1,"demName":"行政维度","demDesc":"行政维度","demType":1}},"company":null,"czykh":null,"id":"9371","enabled":true,"givenName":"施鹏","credentialsNonExpired":true,"accountNonLocked":true,"accountNonExpired":true,"authorities":[{"version":null,"orgId":null,"orgPath":null,"roleId":101,"roleName":"信息技术部系统管理员","roleDesc":"","status":1,"isDefaultIn":0,"rights":"Mod_Oa,MyDesktop,AppHome,_TodoPanelView,_TaskPanelView,_NewTestView,SupervisionTask,SuperTaskOperView,_updateSuper,SuperWorkTaskSuperView,CalendarPlanView_1,DiaryView,_publishSupd,MySubUserDiaryView,WeeklyView,_publishSub,MySubUserWeeklyView,MeetingManager,AddConferenceView,MyJoinConferenceView,MyJoinedConferenceView,ConfSummaryView,_ConfSummaryDel,Flow,NewProcess,MyTaskView,MyProcessRunView,RelevantProcessRunView,ProcessCountView,Archives,NoticeView,_NoticeQuery,Communication,ProfileForm,PhoneBook,FileSendView,InnerMail,MailForm,PersonalMailBoxView,Document,PrivateDocumentView,DocumentSharedView,Mod_Hr,Mod_Enterprise,Mod_YF,Mod_insurance,Mod_costs,Mod_gg,Mod_operate,Mod_cashier,Mod_staffzone,StaffLearn,MoniTestView,OnlineTestView,LineSafetyInstructionView,TrainingMaterialsView,AccidentCaseView,Mod_assistmanager,Mod_Sys,SystemSetting,AppUserView,_AppUserQuery,_AppUserAdd,_AppUserEdit,_AppUserDel,_AppUserReset,AppLoginView,AppRoleView,_AppRoleList,_AppRoleAdd,_AppRoleEdit,_AppRoleDel,_AppRoleGrant,AppRoleDataFuncView,AppRoleOrgFuncView,AppRoleComplaintFuncView,AppRoleRewardPunishmentSurfaceFuncView,HZItemJurisdiction2View,ModuleManagerView,OrgSettingView,BusOrgView,SubordinateView,CompanyView,FileAttachView,_FileAttachQuery,ReportTemplateView,_ReportTemplateQuery,_ReportTemplateAdd,_ReportTemplateEdit,_ReportParamSetting,_ReportTemplateDel,TypeManager,TypeKeyView,GlobalTypeManager,DicManager,_DictionaryQuery,_DictionaryAdd,_DictionaryEdit,_DictionaryDel,SerialNumberView,ModuleManagementView,Mod_zhfx,Mod_clwxgl,Mod_clcrkgl,Mod_zcgl","authority":"信息技术部系统管理员","name":"信息技术部系统管理员","id":"101","type":"candidate"},{"authority":"ROLE_PUBLIC"}],"functionRights":"","firstKeyColumnName":"userId","superAdmin":false,"validTopModules":{},"businessEmail":"11@qq.com","familyName":"施鹏","supperManage":false},"mailFolder":{"version":null,"orgId":null,"orgPath":null,"folderId":1,"folderName":"收件箱","parentId":0,"depLevel":1,"path":"0.1.","isPublic":1,"folderType":1,"appUser":null,"id":1,"userId":null,"firstKeyColumnName":"folderId"},"replyFlag":0,"id":10030,"userId":9371,"folderId":1,"mailId":10014,"firstKeyColumnName":"boxId"}]
     */

    private boolean success;
    private int totalCounts;
    private List<ResultBean> result;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getTotalCounts() {
        return totalCounts;
    }

    public void setTotalCounts(int totalCounts) {
        this.totalCounts = totalCounts;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean implements Serializable{
        /**
         * version : null
         * orgId : null
         * orgPath : null
         * boxId : 10048
         * sendTime : 2019-01-30 15:28:10
         * delFlag : 0
         * readFlag : 1
         * note : 发送出去的邮件
         * mail : {"version":null,"orgId":null,"orgPath":null,"mailId":10023,"sender":"超级管理员","importantFlag":1,"sendTime":"2019-01-30 15:28:10","content":"<p>\n\t<span style=\"color: rgb(0, 0, 0); font-family: &quot;Microsoft Yahei&quot;, &quot;microsoft yahei&quot;, sans-serif; font-size: 16px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400; letter-spacing: normal; orphans: 2; text-align: justify; text-indent: 0px; text-transform: none; white-space: normal; widows: 2; word-spacing: 0px; -webkit-text-stroke-width: 0px; background-color: rgb(255, 255, 255); text-decoration-style: initial; text-decoration-color: initial; display: inline !important; float: none;\">轻启轩窗，春燕盘旋，杨柳依依，芳草青青，花影斑驳，桃李芳菲尽，夏花次第开。五月的风儿，轻轻的柔柔的暖暖的亲吻过脸颊，鼻间新绿的清香泉水般&ldquo;汩汩&rdquo;的流淌。走过春天，躲过流年，站在五月的时空隧道中，时光竟然还是这般的如此匆匆。绿萝拂过衣襟，青云打湿诺言，红尘陌上，我们独自行走，风儿吹乱了发梢，惊扰了一地的千纸鹤。轻点朱颜淡描妆，树影婆娑，花儿摇曳。也许，我们都很好，只是时光不凑巧。<\/span><\/p>\n","subject":"测试上传","copyToNames":"","copyToIDs":"","recipientNames":"施鹏","recipientIDs":"9371","mailStatus":1,"appSender":{"version":null,"orgId":null,"orgPath":null,"userId":1,"username":"admin","email":"111@qq.com","jobId":148,"phone":null,"mobile":null,"fax":"","address":"","zip":"","photo":"","accessionTime":"2009-12-18","status":1,"xzxt":"0,1","education":null,"title":1,"fullname":"超级管理员","userCode":"888888888","delFlag":0,"dynamicPwd":null,"dyPwdStatus":null,"depNames":"宜春公交集团有限公司","posNames":"科员","roleNames":"超级管理员","primaryDep":"宜春公交集团有限公司","department":{"version":null,"orgId":null,"orgPath":null,"depId":378,"depName":"宜春公交集团有限公司","depDesc":"","depLevel":1,"parentId":0,"path":"0.378.","orgType":1,"creatorId":1,"createtime":"2016-03-16 09:17:49","updateId":1,"updatetime":"2018-12-14 22:43:19","sn":null,"chargeIds":"","chargeNames":"","demension":{"version":null,"orgId":null,"orgPath":null,"demId":1,"demName":"行政维度","demDesc":"行政维度","demType":1}},"company":null,"czykh":null,"id":"1","enabled":true,"givenName":"超级管理员","credentialsNonExpired":true,"accountNonLocked":true,"accountNonExpired":true,"authorities":[{"version":null,"orgId":null,"orgPath":null,"roleId":-1,"roleName":"超级管理员","roleDesc":"超级管理员,具有所有权限","status":1,"isDefaultIn":0,"rights":"__ALL","authority":"超级管理员","name":"超级管理员","id":"-1","type":"candidate"},{"authority":"ROLE_PUBLIC"}],"functionRights":"","firstKeyColumnName":"userId","superAdmin":true,"validTopModules":{},"businessEmail":"111@qq.com","familyName":"超级管理员","supperManage":true},"fileIds":"7723,","filenames":"51CTO下载-MD5加密解密.docx,","img":null,"id":10023,"firstKeyColumnName":"mailId"}
         * appUser : {"version":null,"orgId":null,"orgPath":null,"userId":9371,"username":"施鹏","email":"11@qq.com","jobId":null,"phone":"","mobile":"","fax":"","address":"","zip":"","photo":"","accessionTime":"2018-07-18","status":1,"xzxt":"0,1","education":null,"title":1,"fullname":"施鹏","userCode":"2100","delFlag":0,"dynamicPwd":null,"dyPwdStatus":null,"depNames":"信息技术部","posNames":"管理员","roleNames":"信息技术部系统管理员","primaryDep":"信息技术部","department":{"version":null,"orgId":null,"orgPath":null,"depId":500,"depName":"信息技术部","depDesc":"","depLevel":2,"parentId":378,"path":"0.378.500.","orgType":2,"creatorId":1,"createtime":"2018-07-13 18:00:53","updateId":1,"updatetime":"2019-01-04 19:56:42","sn":6,"chargeIds":"10102","chargeNames":"欧阳晓林","demension":{"version":null,"orgId":null,"orgPath":null,"demId":1,"demName":"行政维度","demDesc":"行政维度","demType":1}},"company":null,"czykh":null,"id":"9371","enabled":true,"givenName":"施鹏","credentialsNonExpired":true,"accountNonLocked":true,"accountNonExpired":true,"authorities":[{"version":null,"orgId":null,"orgPath":null,"roleId":101,"roleName":"信息技术部系统管理员","roleDesc":"","status":1,"isDefaultIn":0,"rights":"Mod_Oa,MyDesktop,AppHome,_TodoPanelView,_TaskPanelView,_NewTestView,SupervisionTask,SuperTaskOperView,_updateSuper,SuperWorkTaskSuperView,CalendarPlanView_1,DiaryView,_publishSupd,MySubUserDiaryView,WeeklyView,_publishSub,MySubUserWeeklyView,MeetingManager,AddConferenceView,MyJoinConferenceView,MyJoinedConferenceView,ConfSummaryView,_ConfSummaryDel,Flow,NewProcess,MyTaskView,MyProcessRunView,RelevantProcessRunView,ProcessCountView,Archives,NoticeView,_NoticeQuery,Communication,ProfileForm,PhoneBook,FileSendView,InnerMail,MailForm,PersonalMailBoxView,Document,PrivateDocumentView,DocumentSharedView,Mod_Hr,Mod_Enterprise,Mod_YF,Mod_insurance,Mod_costs,Mod_gg,Mod_operate,Mod_cashier,Mod_staffzone,StaffLearn,MoniTestView,OnlineTestView,LineSafetyInstructionView,TrainingMaterialsView,AccidentCaseView,Mod_assistmanager,Mod_Sys,SystemSetting,AppUserView,_AppUserQuery,_AppUserAdd,_AppUserEdit,_AppUserDel,_AppUserReset,AppLoginView,AppRoleView,_AppRoleList,_AppRoleAdd,_AppRoleEdit,_AppRoleDel,_AppRoleGrant,AppRoleDataFuncView,AppRoleOrgFuncView,AppRoleComplaintFuncView,AppRoleRewardPunishmentSurfaceFuncView,HZItemJurisdiction2View,ModuleManagerView,OrgSettingView,BusOrgView,SubordinateView,CompanyView,FileAttachView,_FileAttachQuery,ReportTemplateView,_ReportTemplateQuery,_ReportTemplateAdd,_ReportTemplateEdit,_ReportParamSetting,_ReportTemplateDel,TypeManager,TypeKeyView,GlobalTypeManager,DicManager,_DictionaryQuery,_DictionaryAdd,_DictionaryEdit,_DictionaryDel,SerialNumberView,ModuleManagementView,Mod_zhfx,Mod_clwxgl,Mod_clcrkgl,Mod_zcgl","authority":"信息技术部系统管理员","name":"信息技术部系统管理员","id":"101","type":"candidate"},{"authority":"ROLE_PUBLIC"}],"functionRights":"","firstKeyColumnName":"userId","superAdmin":false,"validTopModules":{},"businessEmail":"11@qq.com","familyName":"施鹏","supperManage":false}
         * mailFolder : {"version":null,"orgId":null,"orgPath":null,"folderId":1,"folderName":"收件箱","parentId":0,"depLevel":1,"path":"0.1.","isPublic":1,"folderType":1,"appUser":null,"id":1,"userId":null,"firstKeyColumnName":"folderId"}
         * replyFlag : 0
         * id : 10048
         * userId : 9371
         * folderId : 1
         * mailId : 10023
         * firstKeyColumnName : boxId
         */

        private Object version;
        private Object orgId;
        private Object orgPath;
        private int boxId;
        private String sendTime;
        private int delFlag;
        private int readFlag;
        private String note;
        private MailBean mail;
        private AppUserBean appUser;
        private MailFolderBean mailFolder;
        private int replyFlag;
        private int id;
        private int userId;
        private int folderId;
        private int mailId;
        private String firstKeyColumnName;

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

        public int getBoxId() {
            return boxId;
        }

        public void setBoxId(int boxId) {
            this.boxId = boxId;
        }

        public String getSendTime() {
            return sendTime;
        }

        public void setSendTime(String sendTime) {
            this.sendTime = sendTime;
        }

        public int getDelFlag() {
            return delFlag;
        }

        public void setDelFlag(int delFlag) {
            this.delFlag = delFlag;
        }

        public int getReadFlag() {
            return readFlag;
        }

        public void setReadFlag(int readFlag) {
            this.readFlag = readFlag;
        }

        public String getNote() {
            return note;
        }

        public void setNote(String note) {
            this.note = note;
        }

        public MailBean getMail() {
            return mail;
        }

        public void setMail(MailBean mail) {
            this.mail = mail;
        }

        public AppUserBean getAppUser() {
            return appUser;
        }

        public void setAppUser(AppUserBean appUser) {
            this.appUser = appUser;
        }

        public MailFolderBean getMailFolder() {
            return mailFolder;
        }

        public void setMailFolder(MailFolderBean mailFolder) {
            this.mailFolder = mailFolder;
        }

        public int getReplyFlag() {
            return replyFlag;
        }

        public void setReplyFlag(int replyFlag) {
            this.replyFlag = replyFlag;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getFolderId() {
            return folderId;
        }

        public void setFolderId(int folderId) {
            this.folderId = folderId;
        }

        public int getMailId() {
            return mailId;
        }

        public void setMailId(int mailId) {
            this.mailId = mailId;
        }

        public String getFirstKeyColumnName() {
            return firstKeyColumnName;
        }

        public void setFirstKeyColumnName(String firstKeyColumnName) {
            this.firstKeyColumnName = firstKeyColumnName;
        }

        public static class MailBean implements Serializable{
            /**
             * version : null
             * orgId : null
             * orgPath : null
             * mailId : 10023
             * sender : 超级管理员
             * importantFlag : 1
             * sendTime : 2019-01-30 15:28:10
             * content : <p>
             <span style="color: rgb(0, 0, 0); font-family: &quot;Microsoft Yahei&quot;, &quot;microsoft yahei&quot;, sans-serif; font-size: 16px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400; letter-spacing: normal; orphans: 2; text-align: justify; text-indent: 0px; text-transform: none; white-space: normal; widows: 2; word-spacing: 0px; -webkit-text-stroke-width: 0px; background-color: rgb(255, 255, 255); text-decoration-style: initial; text-decoration-color: initial; display: inline !important; float: none;">轻启轩窗，春燕盘旋，杨柳依依，芳草青青，花影斑驳，桃李芳菲尽，夏花次第开。五月的风儿，轻轻的柔柔的暖暖的亲吻过脸颊，鼻间新绿的清香泉水般&ldquo;汩汩&rdquo;的流淌。走过春天，躲过流年，站在五月的时空隧道中，时光竟然还是这般的如此匆匆。绿萝拂过衣襟，青云打湿诺言，红尘陌上，我们独自行走，风儿吹乱了发梢，惊扰了一地的千纸鹤。轻点朱颜淡描妆，树影婆娑，花儿摇曳。也许，我们都很好，只是时光不凑巧。</span></p>

             * subject : 测试上传
             * copyToNames :
             * copyToIDs :
             * recipientNames : 施鹏
             * recipientIDs : 9371
             * mailStatus : 1
             * appSender : {"version":null,"orgId":null,"orgPath":null,"userId":1,"username":"admin","email":"111@qq.com","jobId":148,"phone":null,"mobile":null,"fax":"","address":"","zip":"","photo":"","accessionTime":"2009-12-18","status":1,"xzxt":"0,1","education":null,"title":1,"fullname":"超级管理员","userCode":"888888888","delFlag":0,"dynamicPwd":null,"dyPwdStatus":null,"depNames":"宜春公交集团有限公司","posNames":"科员","roleNames":"超级管理员","primaryDep":"宜春公交集团有限公司","department":{"version":null,"orgId":null,"orgPath":null,"depId":378,"depName":"宜春公交集团有限公司","depDesc":"","depLevel":1,"parentId":0,"path":"0.378.","orgType":1,"creatorId":1,"createtime":"2016-03-16 09:17:49","updateId":1,"updatetime":"2018-12-14 22:43:19","sn":null,"chargeIds":"","chargeNames":"","demension":{"version":null,"orgId":null,"orgPath":null,"demId":1,"demName":"行政维度","demDesc":"行政维度","demType":1}},"company":null,"czykh":null,"id":"1","enabled":true,"givenName":"超级管理员","credentialsNonExpired":true,"accountNonLocked":true,"accountNonExpired":true,"authorities":[{"version":null,"orgId":null,"orgPath":null,"roleId":-1,"roleName":"超级管理员","roleDesc":"超级管理员,具有所有权限","status":1,"isDefaultIn":0,"rights":"__ALL","authority":"超级管理员","name":"超级管理员","id":"-1","type":"candidate"},{"authority":"ROLE_PUBLIC"}],"functionRights":"","firstKeyColumnName":"userId","superAdmin":true,"validTopModules":{},"businessEmail":"111@qq.com","familyName":"超级管理员","supperManage":true}
             * fileIds : 7723,
             * filenames : 51CTO下载-MD5加密解密.docx,
             * img : null
             * id : 10023
             * firstKeyColumnName : mailId
             */

            private Object version;
            private Object orgId;
            private Object orgPath;
            private int mailId;
            private String sender;
            private int importantFlag;
            private String sendTime;
            private String content;
            private String subject;
            private String copyToNames;
            private String copyToIDs;
            private String recipientNames;
            private String recipientIDs;
            private int mailStatus;
            private AppSenderBean appSender;
            private String fileIds;
            private String filenames;
            private Object img;
            private int id;
            private String firstKeyColumnName;

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

            public int getMailId() {
                return mailId;
            }

            public void setMailId(int mailId) {
                this.mailId = mailId;
            }

            public String getSender() {
                return sender;
            }

            public void setSender(String sender) {
                this.sender = sender;
            }

            public int getImportantFlag() {
                return importantFlag;
            }

            public void setImportantFlag(int importantFlag) {
                this.importantFlag = importantFlag;
            }

            public String getSendTime() {
                return sendTime;
            }

            public void setSendTime(String sendTime) {
                this.sendTime = sendTime;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getSubject() {
                return subject;
            }

            public void setSubject(String subject) {
                this.subject = subject;
            }

            public String getCopyToNames() {
                return copyToNames;
            }

            public void setCopyToNames(String copyToNames) {
                this.copyToNames = copyToNames;
            }

            public String getCopyToIDs() {
                return copyToIDs;
            }

            public void setCopyToIDs(String copyToIDs) {
                this.copyToIDs = copyToIDs;
            }

            public String getRecipientNames() {
                return recipientNames;
            }

            public void setRecipientNames(String recipientNames) {
                this.recipientNames = recipientNames;
            }

            public String getRecipientIDs() {
                return recipientIDs;
            }

            public void setRecipientIDs(String recipientIDs) {
                this.recipientIDs = recipientIDs;
            }

            public int getMailStatus() {
                return mailStatus;
            }

            public void setMailStatus(int mailStatus) {
                this.mailStatus = mailStatus;
            }

            public AppSenderBean getAppSender() {
                return appSender;
            }

            public void setAppSender(AppSenderBean appSender) {
                this.appSender = appSender;
            }

            public String getFileIds() {
                return fileIds;
            }

            public void setFileIds(String fileIds) {
                this.fileIds = fileIds;
            }

            public String getFilenames() {
                return filenames;
            }

            public void setFilenames(String filenames) {
                this.filenames = filenames;
            }

            public Object getImg() {
                return img;
            }

            public void setImg(Object img) {
                this.img = img;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getFirstKeyColumnName() {
                return firstKeyColumnName;
            }

            public void setFirstKeyColumnName(String firstKeyColumnName) {
                this.firstKeyColumnName = firstKeyColumnName;
            }

            public static class AppSenderBean {
                /**
                 * version : null
                 * orgId : null
                 * orgPath : null
                 * userId : 1
                 * username : admin
                 * email : 111@qq.com
                 * jobId : 148
                 * phone : null
                 * mobile : null
                 * fax :
                 * address :
                 * zip :
                 * photo :
                 * accessionTime : 2009-12-18
                 * status : 1
                 * xzxt : 0,1
                 * education : null
                 * title : 1
                 * fullname : 超级管理员
                 * userCode : 888888888
                 * delFlag : 0
                 * dynamicPwd : null
                 * dyPwdStatus : null
                 * depNames : 宜春公交集团有限公司
                 * posNames : 科员
                 * roleNames : 超级管理员
                 * primaryDep : 宜春公交集团有限公司
                 * department : {"version":null,"orgId":null,"orgPath":null,"depId":378,"depName":"宜春公交集团有限公司","depDesc":"","depLevel":1,"parentId":0,"path":"0.378.","orgType":1,"creatorId":1,"createtime":"2016-03-16 09:17:49","updateId":1,"updatetime":"2018-12-14 22:43:19","sn":null,"chargeIds":"","chargeNames":"","demension":{"version":null,"orgId":null,"orgPath":null,"demId":1,"demName":"行政维度","demDesc":"行政维度","demType":1}}
                 * company : null
                 * czykh : null
                 * id : 1
                 * enabled : true
                 * givenName : 超级管理员
                 * credentialsNonExpired : true
                 * accountNonLocked : true
                 * accountNonExpired : true
                 * authorities : [{"version":null,"orgId":null,"orgPath":null,"roleId":-1,"roleName":"超级管理员","roleDesc":"超级管理员,具有所有权限","status":1,"isDefaultIn":0,"rights":"__ALL","authority":"超级管理员","name":"超级管理员","id":"-1","type":"candidate"},{"authority":"ROLE_PUBLIC"}]
                 * functionRights :
                 * firstKeyColumnName : userId
                 * superAdmin : true
                 * validTopModules : {}
                 * businessEmail : 111@qq.com
                 * familyName : 超级管理员
                 * supperManage : true
                 */

                private Object version;
                private Object orgId;
                private Object orgPath;
                private int userId;
                private String username;
                private String email;
                private int jobId;
                private Object phone;
                private Object mobile;
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
                private boolean credentialsNonExpired;
                private boolean accountNonLocked;
                private boolean accountNonExpired;
                private String functionRights;
                private String firstKeyColumnName;
                private boolean superAdmin;
                private ValidTopModulesBean validTopModules;
                private String businessEmail;
                private String familyName;
                private boolean supperManage;
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

                public int getJobId() {
                    return jobId;
                }

                public void setJobId(int jobId) {
                    this.jobId = jobId;
                }

                public Object getPhone() {
                    return phone;
                }

                public void setPhone(Object phone) {
                    this.phone = phone;
                }

                public Object getMobile() {
                    return mobile;
                }

                public void setMobile(Object mobile) {
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

                public boolean isAccountNonExpired() {
                    return accountNonExpired;
                }

                public void setAccountNonExpired(boolean accountNonExpired) {
                    this.accountNonExpired = accountNonExpired;
                }

                public String getFunctionRights() {
                    return functionRights;
                }

                public void setFunctionRights(String functionRights) {
                    this.functionRights = functionRights;
                }

                public String getFirstKeyColumnName() {
                    return firstKeyColumnName;
                }

                public void setFirstKeyColumnName(String firstKeyColumnName) {
                    this.firstKeyColumnName = firstKeyColumnName;
                }

                public boolean isSuperAdmin() {
                    return superAdmin;
                }

                public void setSuperAdmin(boolean superAdmin) {
                    this.superAdmin = superAdmin;
                }

                public ValidTopModulesBean getValidTopModules() {
                    return validTopModules;
                }

                public void setValidTopModules(ValidTopModulesBean validTopModules) {
                    this.validTopModules = validTopModules;
                }

                public String getBusinessEmail() {
                    return businessEmail;
                }

                public void setBusinessEmail(String businessEmail) {
                    this.businessEmail = businessEmail;
                }

                public String getFamilyName() {
                    return familyName;
                }

                public void setFamilyName(String familyName) {
                    this.familyName = familyName;
                }

                public boolean isSupperManage() {
                    return supperManage;
                }

                public void setSupperManage(boolean supperManage) {
                    this.supperManage = supperManage;
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
                     * roleId : -1
                     * roleName : 超级管理员
                     * roleDesc : 超级管理员,具有所有权限
                     * status : 1
                     * isDefaultIn : 0
                     * rights : __ALL
                     * authority : 超级管理员
                     * name : 超级管理员
                     * id : -1
                     * type : candidate
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
                    private String authority;
                    private String name;
                    private String id;
                    private String type;

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

                    public String getAuthority() {
                        return authority;
                    }

                    public void setAuthority(String authority) {
                        this.authority = authority;
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
                }
            }
        }

        public static class AppUserBean {
            /**
             * version : null
             * orgId : null
             * orgPath : null
             * userId : 9371
             * username : 施鹏
             * email : 11@qq.com
             * jobId : null
             * phone :
             * mobile :
             * fax :
             * address :
             * zip :
             * photo :
             * accessionTime : 2018-07-18
             * status : 1
             * xzxt : 0,1
             * education : null
             * title : 1
             * fullname : 施鹏
             * userCode : 2100
             * delFlag : 0
             * dynamicPwd : null
             * dyPwdStatus : null
             * depNames : 信息技术部
             * posNames : 管理员
             * roleNames : 信息技术部系统管理员
             * primaryDep : 信息技术部
             * department : {"version":null,"orgId":null,"orgPath":null,"depId":500,"depName":"信息技术部","depDesc":"","depLevel":2,"parentId":378,"path":"0.378.500.","orgType":2,"creatorId":1,"createtime":"2018-07-13 18:00:53","updateId":1,"updatetime":"2019-01-04 19:56:42","sn":6,"chargeIds":"10102","chargeNames":"欧阳晓林","demension":{"version":null,"orgId":null,"orgPath":null,"demId":1,"demName":"行政维度","demDesc":"行政维度","demType":1}}
             * company : null
             * czykh : null
             * id : 9371
             * enabled : true
             * givenName : 施鹏
             * credentialsNonExpired : true
             * accountNonLocked : true
             * accountNonExpired : true
             * authorities : [{"version":null,"orgId":null,"orgPath":null,"roleId":101,"roleName":"信息技术部系统管理员","roleDesc":"","status":1,"isDefaultIn":0,"rights":"Mod_Oa,MyDesktop,AppHome,_TodoPanelView,_TaskPanelView,_NewTestView,SupervisionTask,SuperTaskOperView,_updateSuper,SuperWorkTaskSuperView,CalendarPlanView_1,DiaryView,_publishSupd,MySubUserDiaryView,WeeklyView,_publishSub,MySubUserWeeklyView,MeetingManager,AddConferenceView,MyJoinConferenceView,MyJoinedConferenceView,ConfSummaryView,_ConfSummaryDel,Flow,NewProcess,MyTaskView,MyProcessRunView,RelevantProcessRunView,ProcessCountView,Archives,NoticeView,_NoticeQuery,Communication,ProfileForm,PhoneBook,FileSendView,InnerMail,MailForm,PersonalMailBoxView,Document,PrivateDocumentView,DocumentSharedView,Mod_Hr,Mod_Enterprise,Mod_YF,Mod_insurance,Mod_costs,Mod_gg,Mod_operate,Mod_cashier,Mod_staffzone,StaffLearn,MoniTestView,OnlineTestView,LineSafetyInstructionView,TrainingMaterialsView,AccidentCaseView,Mod_assistmanager,Mod_Sys,SystemSetting,AppUserView,_AppUserQuery,_AppUserAdd,_AppUserEdit,_AppUserDel,_AppUserReset,AppLoginView,AppRoleView,_AppRoleList,_AppRoleAdd,_AppRoleEdit,_AppRoleDel,_AppRoleGrant,AppRoleDataFuncView,AppRoleOrgFuncView,AppRoleComplaintFuncView,AppRoleRewardPunishmentSurfaceFuncView,HZItemJurisdiction2View,ModuleManagerView,OrgSettingView,BusOrgView,SubordinateView,CompanyView,FileAttachView,_FileAttachQuery,ReportTemplateView,_ReportTemplateQuery,_ReportTemplateAdd,_ReportTemplateEdit,_ReportParamSetting,_ReportTemplateDel,TypeManager,TypeKeyView,GlobalTypeManager,DicManager,_DictionaryQuery,_DictionaryAdd,_DictionaryEdit,_DictionaryDel,SerialNumberView,ModuleManagementView,Mod_zhfx,Mod_clwxgl,Mod_clcrkgl,Mod_zcgl","authority":"信息技术部系统管理员","name":"信息技术部系统管理员","id":"101","type":"candidate"},{"authority":"ROLE_PUBLIC"}]
             * functionRights :
             * firstKeyColumnName : userId
             * superAdmin : false
             * validTopModules : {}
             * businessEmail : 11@qq.com
             * familyName : 施鹏
             * supperManage : false
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
            private DepartmentBeanX department;
            private Object company;
            private Object czykh;
            private String id;
            private boolean enabled;
            private String givenName;
            private boolean credentialsNonExpired;
            private boolean accountNonLocked;
            private boolean accountNonExpired;
            private String functionRights;
            private String firstKeyColumnName;
            private boolean superAdmin;
            private ValidTopModulesBeanX validTopModules;
            private String businessEmail;
            private String familyName;
            private boolean supperManage;
            private List<AuthoritiesBeanX> authorities;

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

            public DepartmentBeanX getDepartment() {
                return department;
            }

            public void setDepartment(DepartmentBeanX department) {
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

            public boolean isAccountNonExpired() {
                return accountNonExpired;
            }

            public void setAccountNonExpired(boolean accountNonExpired) {
                this.accountNonExpired = accountNonExpired;
            }

            public String getFunctionRights() {
                return functionRights;
            }

            public void setFunctionRights(String functionRights) {
                this.functionRights = functionRights;
            }

            public String getFirstKeyColumnName() {
                return firstKeyColumnName;
            }

            public void setFirstKeyColumnName(String firstKeyColumnName) {
                this.firstKeyColumnName = firstKeyColumnName;
            }

            public boolean isSuperAdmin() {
                return superAdmin;
            }

            public void setSuperAdmin(boolean superAdmin) {
                this.superAdmin = superAdmin;
            }

            public ValidTopModulesBeanX getValidTopModules() {
                return validTopModules;
            }

            public void setValidTopModules(ValidTopModulesBeanX validTopModules) {
                this.validTopModules = validTopModules;
            }

            public String getBusinessEmail() {
                return businessEmail;
            }

            public void setBusinessEmail(String businessEmail) {
                this.businessEmail = businessEmail;
            }

            public String getFamilyName() {
                return familyName;
            }

            public void setFamilyName(String familyName) {
                this.familyName = familyName;
            }

            public boolean isSupperManage() {
                return supperManage;
            }

            public void setSupperManage(boolean supperManage) {
                this.supperManage = supperManage;
            }

            public List<AuthoritiesBeanX> getAuthorities() {
                return authorities;
            }

            public void setAuthorities(List<AuthoritiesBeanX> authorities) {
                this.authorities = authorities;
            }

            public static class DepartmentBeanX {
                public static class DemensionBeanX {
                }
            }

            public static class ValidTopModulesBeanX {
            }

            public static class AuthoritiesBeanX {
                /**
                 * version : null
                 * orgId : null
                 * orgPath : null
                 * roleId : 101
                 * roleName : 信息技术部系统管理员
                 * roleDesc :
                 * status : 1
                 * isDefaultIn : 0
                 * rights : Mod_Oa,MyDesktop,AppHome,_TodoPanelView,_TaskPanelView,_NewTestView,SupervisionTask,SuperTaskOperView,_updateSuper,SuperWorkTaskSuperView,CalendarPlanView_1,DiaryView,_publishSupd,MySubUserDiaryView,WeeklyView,_publishSub,MySubUserWeeklyView,MeetingManager,AddConferenceView,MyJoinConferenceView,MyJoinedConferenceView,ConfSummaryView,_ConfSummaryDel,Flow,NewProcess,MyTaskView,MyProcessRunView,RelevantProcessRunView,ProcessCountView,Archives,NoticeView,_NoticeQuery,Communication,ProfileForm,PhoneBook,FileSendView,InnerMail,MailForm,PersonalMailBoxView,Document,PrivateDocumentView,DocumentSharedView,Mod_Hr,Mod_Enterprise,Mod_YF,Mod_insurance,Mod_costs,Mod_gg,Mod_operate,Mod_cashier,Mod_staffzone,StaffLearn,MoniTestView,OnlineTestView,LineSafetyInstructionView,TrainingMaterialsView,AccidentCaseView,Mod_assistmanager,Mod_Sys,SystemSetting,AppUserView,_AppUserQuery,_AppUserAdd,_AppUserEdit,_AppUserDel,_AppUserReset,AppLoginView,AppRoleView,_AppRoleList,_AppRoleAdd,_AppRoleEdit,_AppRoleDel,_AppRoleGrant,AppRoleDataFuncView,AppRoleOrgFuncView,AppRoleComplaintFuncView,AppRoleRewardPunishmentSurfaceFuncView,HZItemJurisdiction2View,ModuleManagerView,OrgSettingView,BusOrgView,SubordinateView,CompanyView,FileAttachView,_FileAttachQuery,ReportTemplateView,_ReportTemplateQuery,_ReportTemplateAdd,_ReportTemplateEdit,_ReportParamSetting,_ReportTemplateDel,TypeManager,TypeKeyView,GlobalTypeManager,DicManager,_DictionaryQuery,_DictionaryAdd,_DictionaryEdit,_DictionaryDel,SerialNumberView,ModuleManagementView,Mod_zhfx,Mod_clwxgl,Mod_clcrkgl,Mod_zcgl
                 * authority : 信息技术部系统管理员
                 * name : 信息技术部系统管理员
                 * id : 101
                 * type : candidate
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
                private String authority;
                private String name;
                private String id;
                private String type;

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

                public String getAuthority() {
                    return authority;
                }

                public void setAuthority(String authority) {
                    this.authority = authority;
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
            }
        }

        public static class MailFolderBean {
            /**
             * version : null
             * orgId : null
             * orgPath : null
             * folderId : 1
             * folderName : 收件箱
             * parentId : 0
             * depLevel : 1
             * path : 0.1.
             * isPublic : 1
             * folderType : 1
             * appUser : null
             * id : 1
             * userId : null
             * firstKeyColumnName : folderId
             */

            private Object version;
            private Object orgId;
            private Object orgPath;
            private int folderId;
            private String folderName;
            private int parentId;
            private int depLevel;
            private String path;
            private int isPublic;
            private int folderType;
            private Object appUser;
            private int id;
            private Object userId;
            private String firstKeyColumnName;

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

            public int getFolderId() {
                return folderId;
            }

            public void setFolderId(int folderId) {
                this.folderId = folderId;
            }

            public String getFolderName() {
                return folderName;
            }

            public void setFolderName(String folderName) {
                this.folderName = folderName;
            }

            public int getParentId() {
                return parentId;
            }

            public void setParentId(int parentId) {
                this.parentId = parentId;
            }

            public int getDepLevel() {
                return depLevel;
            }

            public void setDepLevel(int depLevel) {
                this.depLevel = depLevel;
            }

            public String getPath() {
                return path;
            }

            public void setPath(String path) {
                this.path = path;
            }

            public int getIsPublic() {
                return isPublic;
            }

            public void setIsPublic(int isPublic) {
                this.isPublic = isPublic;
            }

            public int getFolderType() {
                return folderType;
            }

            public void setFolderType(int folderType) {
                this.folderType = folderType;
            }

            public Object getAppUser() {
                return appUser;
            }

            public void setAppUser(Object appUser) {
                this.appUser = appUser;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public Object getUserId() {
                return userId;
            }

            public void setUserId(Object userId) {
                this.userId = userId;
            }

            public String getFirstKeyColumnName() {
                return firstKeyColumnName;
            }

            public void setFirstKeyColumnName(String firstKeyColumnName) {
                this.firstKeyColumnName = firstKeyColumnName;
            }
        }
    }
}
