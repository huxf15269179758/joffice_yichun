package com.hy.powerplatform.oa_flow.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/1/24.
 */

public class MyLeave implements Serializable {


    /**
     * success : true
     * totalCounts : 110
     * result : [{"version":null,"orgId":null,"orgPath":null,"runId":52009,"subject":"公司信息发布审批单20190816-150723","creator":"苏倩","assignee":null,"createtime":"2019-08-16 15:07:23","endtime":null,"isMany":null,"showData":null,"relationId":null,"processRunNo":null,"urgetime":null,"piId":null,"pdId":"GSXXFBSPS5-1","piDbid":9301671,"processName":"公司信息发布审批单","busDesc":null,"entityName":"WF_xxfbspd","entityId":"6","formDefId":10110,"runStatus":2,"appUser":null,"defId":"10094","defHtml":null,"userId":null},{"version":null,"orgId":null,"orgPath":null,"runId":52005,"subject":"请示上报流程20190816-144812","creator":"苏倩","assignee":"何爱民","createtime":"2019-08-16 14:48:12","endtime":null,"isMany":null,"showData":null,"relationId":null,"processRunNo":null,"urgetime":null,"piId":"CSQSLC_.9301497","pdId":"CSQSLC_-1","piDbid":9301497,"processName":"请示上报流程","busDesc":null,"entityName":"WF_QingShiHuiBao","entityId":"14","formDefId":10113,"runStatus":1,"appUser":null,"defId":"20321","defHtml":null,"userId":null},{"version":null,"orgId":null,"orgPath":null,"runId":52003,"subject":"合同签订审批流程20190816-144159","creator":"王晨","assignee":null,"createtime":"2019-08-16 14:41:59","endtime":null,"isMany":null,"showData":null,"relationId":null,"processRunNo":null,"urgetime":null,"piId":null,"pdId":"GTQDSPLC1-1","piDbid":9301421,"processName":"合同签订审批流程","busDesc":null,"entityName":"WF_htqdspd","entityId":"140","formDefId":66,"runStatus":2,"appUser":null,"defId":"10165","defHtml":null,"userId":null},{"version":null,"orgId":null,"orgPath":null,"runId":52002,"subject":"宜春公交集团发文20190816-144132","creator":"周青","assignee":null,"createtime":"2019-08-16 14:41:32","endtime":null,"isMany":null,"showData":null,"relationId":null,"processRunNo":null,"urgetime":null,"piId":null,"pdId":"YCSGGJTZGSFW3-1","piDbid":9301388,"processName":"宜春公交集团发文","busDesc":null,"entityName":"WF_ycsggjtzgsfw","entityId":"9","formDefId":10076,"runStatus":2,"appUser":null,"defId":"20200","defHtml":null,"userId":null},{"version":null,"orgId":null,"orgPath":null,"runId":51993,"subject":"接待用餐审批表_人力资源部","creator":"刘竹梅","assignee":null,"createtime":"2019-08-16 14:23:29","endtime":null,"isMany":null,"showData":null,"relationId":null,"processRunNo":null,"urgetime":null,"piId":null,"pdId":"JDYCSPB_-3","piDbid":9301060,"processName":"接待用餐审批表","busDesc":null,"entityName":"WF_jdycspb","entityId":"10010","formDefId":62,"runStatus":2,"appUser":null,"defId":"10152","defHtml":null,"userId":null},{"version":null,"orgId":null,"orgPath":null,"runId":51990,"subject":"新建工程启动审批流程20190816-141541","creator":"杨雯","assignee":null,"createtime":"2019-08-16 14:15:41","endtime":null,"isMany":null,"showData":null,"relationId":null,"processRunNo":null,"urgetime":null,"piId":null,"pdId":"XJGCQDSPLC3-2","piDbid":9300984,"processName":"新建工程启动审批流程","busDesc":null,"entityName":"WF_XinJianGongChengQiDongShenPiDan","entityId":"1","formDefId":10107,"runStatus":2,"appUser":null,"defId":"20233","defHtml":null,"userId":null},{"version":null,"orgId":null,"orgPath":null,"runId":51987,"subject":"建设工程变更审批单20190816-140928","creator":"邓维","assignee":null,"createtime":"2019-08-16 14:09:28","endtime":null,"isMany":null,"showData":null,"relationId":null,"processRunNo":null,"urgetime":null,"piId":null,"pdId":"JSGCBGSPS3-1","piDbid":9300884,"processName":"建设工程变更审批单","busDesc":null,"entityName":"WF_JianSheGongChengBianGengShenQingDan","entityId":"1","formDefId":10109,"runStatus":2,"appUser":null,"defId":"20244","defHtml":null,"userId":null},{"version":null,"orgId":null,"orgPath":null,"runId":51986,"subject":"请假流程_邓业雄","creator":"邓业雄","assignee":null,"createtime":"2019-08-16 14:05:52","endtime":null,"isMany":null,"showData":null,"relationId":null,"processRunNo":null,"urgetime":null,"piId":null,"pdId":"QJLC111-2","piDbid":9300849,"processName":"请假流程","busDesc":null,"entityName":"WF_YuanGongQingJiaDan","entityId":"185","formDefId":83,"runStatus":2,"appUser":null,"defId":"10135","defHtml":null,"userId":null},{"version":null,"orgId":null,"orgPath":null,"runId":51985,"subject":"建设工程量增加审批单20190816-140005","creator":"田乐","assignee":null,"createtime":"2019-08-16 14:00:05","endtime":null,"isMany":null,"showData":null,"relationId":null,"processRunNo":null,"urgetime":null,"piId":null,"pdId":"JSGCLZJSPD2-2","piDbid":9300785,"processName":"建设工程量增加审批单","busDesc":null,"entityName":"WF_JianSheGongChengLiangZengJiaShenPiDan","entityId":"5","formDefId":10108,"runStatus":2,"appUser":null,"defId":"20249","defHtml":null,"userId":null},{"version":null,"orgId":null,"orgPath":null,"runId":51984,"subject":"请假流程_李春华","creator":"李春华","assignee":null,"createtime":"2019-08-16 13:59:50","endtime":null,"isMany":null,"showData":null,"relationId":null,"processRunNo":null,"urgetime":null,"piId":null,"pdId":"QJLC111-2","piDbid":9300759,"processName":"请假流程","busDesc":null,"entityName":"WF_YuanGongQingJiaDan","entityId":"184","formDefId":83,"runStatus":2,"appUser":null,"defId":"10135","defHtml":null,"userId":null},{"version":null,"orgId":null,"orgPath":null,"runId":51981,"subject":"付款程序审批单_周青","creator":"周青","assignee":null,"createtime":"2019-08-16 13:45:50","endtime":null,"isMany":null,"showData":null,"relationId":null,"processRunNo":null,"urgetime":null,"piId":null,"pdId":"FKCXSPS1-1","piDbid":9300642,"processName":"付款程序审批单","busDesc":null,"entityName":"WF_FuKuanChengXUShenPi","entityId":"122","formDefId":10078,"runStatus":2,"appUser":null,"defId":"10151","defHtml":null,"userId":null},{"version":null,"orgId":null,"orgPath":null,"runId":51965,"subject":"出差申请审批表_人力资源部","creator":"周青","assignee":null,"createtime":"2019-08-16 13:04:31","endtime":null,"isMany":null,"showData":null,"relationId":null,"processRunNo":null,"urgetime":null,"piId":null,"pdId":"CCSQSPB1-3","piDbid":9300017,"processName":"出差申请审批表","busDesc":null,"entityName":"WF_chuchaishenqingshenpi","entityId":"10011","formDefId":67,"runStatus":2,"appUser":null,"defId":"10149","defHtml":null,"userId":null},{"version":null,"orgId":null,"orgPath":null,"runId":51919,"subject":"合同签订审批流程20190726-112227","creator":"漆明","assignee":"晏慧锋","createtime":"2019-07-26 11:22:27","endtime":null,"isMany":null,"showData":"30台补登机、分段消费项目合同","relationId":null,"processRunNo":null,"urgetime":null,"piId":"GTQDSPLC1.9130071","pdId":"GTQDSPLC1-1","piDbid":9130071,"processName":"合同签订审批流程","busDesc":null,"entityName":"WF_htqdspd","entityId":"136","formDefId":66,"runStatus":1,"appUser":null,"defId":"10165","defHtml":null,"userId":null},{"version":null,"orgId":null,"orgPath":null,"runId":51907,"subject":"物品采购计划表3000元以上_彭颖","creator":"彭颖","assignee":null,"createtime":"2019-07-19 09:02:40","endtime":null,"isMany":null,"showData":"卡套","relationId":null,"processRunNo":null,"urgetime":null,"piId":null,"pdId":"WPCGJHB3000YYS4-1","piDbid":9080327,"processName":"物品采购计划表3000元以上","busDesc":null,"entityName":"WF_WuPinCaiGouJiHuaBiao000YuanYiShangBiao","entityId":"48","formDefId":10103,"runStatus":2,"appUser":null,"defId":"20271","defHtml":null,"userId":null},{"version":null,"orgId":null,"orgPath":null,"runId":51902,"subject":"物品采购计划表3000元以上_漆明","creator":"漆明","assignee":null,"createtime":"2019-07-17 16:43:52","endtime":null,"isMany":null,"showData":"服务大厅购电脑","relationId":null,"processRunNo":null,"urgetime":null,"piId":null,"pdId":"WPCGJHB3000YYS4-1","piDbid":9080123,"processName":"物品采购计划表3000元以上","busDesc":null,"entityName":"WF_WuPinCaiGouJiHuaBiao000YuanYiShangBiao","entityId":"46","formDefId":10103,"runStatus":2,"appUser":null,"defId":"20271","defHtml":null,"userId":null},{"version":null,"orgId":null,"orgPath":null,"runId":51865,"subject":"物品采购计划表3000元以上_刘望","creator":"刘望","assignee":null,"createtime":"2019-07-02 09:09:08","endtime":null,"isMany":null,"showData":"   ","relationId":null,"processRunNo":null,"urgetime":null,"piId":null,"pdId":"WPCGJHB3000YYS4-1","piDbid":8980055,"processName":"物品采购计划表3000元以上","busDesc":null,"entityName":"WF_WuPinCaiGouJiHuaBiao000YuanYiShangBiao","entityId":"42","formDefId":10103,"runStatus":2,"appUser":null,"defId":"20271","defHtml":null,"userId":null},{"version":null,"orgId":null,"orgPath":null,"runId":51832,"subject":"合同签订审批流程20190626-092515","creator":"漆明","assignee":"","createtime":"2019-06-26 09:25:15","endtime":null,"isMany":null,"showData":"移动统付业务受理单","relationId":null,"processRunNo":null,"urgetime":null,"piId":"GTQDSPLC1.8950006","pdId":"GTQDSPLC1-1","piDbid":8950006,"processName":"合同签订审批流程","busDesc":null,"entityName":"WF_htqdspd","entityId":"135","formDefId":66,"runStatus":1,"appUser":null,"defId":"10165","defHtml":null,"userId":null},{"version":null,"orgId":null,"orgPath":null,"runId":51830,"subject":"付款程序审批单_漆明","creator":"漆明","assignee":null,"createtime":"2019-06-24 10:10:34","endtime":null,"isMany":null,"showData":"公交行APP二次付款","relationId":null,"processRunNo":null,"urgetime":null,"piId":null,"pdId":"FKCXSPS1-1","piDbid":8940147,"processName":"付款程序审批单","busDesc":null,"entityName":"WF_FuKuanChengXUShenPi","entityId":"104","formDefId":10078,"runStatus":2,"appUser":null,"defId":"10151","defHtml":null,"userId":null},{"version":null,"orgId":null,"orgPath":null,"runId":51828,"subject":"请假流程_晏慧锋","creator":"晏慧锋","assignee":null,"createtime":"2019-06-21 08:45:30","endtime":null,"isMany":null,"showData":"病假","relationId":null,"processRunNo":null,"urgetime":null,"piId":null,"pdId":"QJLC111-2","piDbid":8940001,"processName":"请假流程","busDesc":null,"entityName":"WF_YuanGongQingJiaDan","entityId":"175","formDefId":83,"runStatus":2,"appUser":null,"defId":"10135","defHtml":null,"userId":null},{"version":null,"orgId":null,"orgPath":null,"runId":51794,"subject":"合同签订审批流程20190531-111155","creator":"胡宜南","assignee":"晏慧锋","createtime":"2019-05-31 11:11:55","endtime":null,"isMany":null,"showData":"美团与宜春公交项目合作协议","relationId":null,"processRunNo":null,"urgetime":null,"piId":"GTQDSPLC1.8780036","pdId":"GTQDSPLC1-1","piDbid":8780036,"processName":"合同签订审批流程","busDesc":null,"entityName":"WF_htqdspd","entityId":"132","formDefId":66,"runStatus":1,"appUser":null,"defId":"10165","defHtml":null,"userId":null}]
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

    public static class ResultBean {
        /**
         * version : null
         * orgId : null
         * orgPath : null
         * runId : 52009
         * subject : 公司信息发布审批单20190816-150723
         * creator : 苏倩
         * assignee : null
         * createtime : 2019-08-16 15:07:23
         * endtime : null
         * isMany : null
         * showData : null
         * relationId : null
         * processRunNo : null
         * urgetime : null
         * piId : null
         * pdId : GSXXFBSPS5-1
         * piDbid : 9301671
         * processName : 公司信息发布审批单
         * busDesc : null
         * entityName : WF_xxfbspd
         * entityId : 6
         * formDefId : 10110
         * runStatus : 2
         * appUser : null
         * defId : 10094
         * defHtml : null
         * userId : null
         */

        private Object version;
        private Object orgId;
        private Object orgPath;
        private String runId;
        private String subject;
        private String creator;
        private Object assignee;
        private String createtime;
        private Object endtime;
        private Object isMany;
        private Object showData;
        private Object relationId;
        private Object processRunNo;
        private Object urgetime;
        private Object piId;
        private String pdId;
        private int piDbid;
        private String processName;
        private Object busDesc;
        private String entityName;
        private String entityId;
        private String formDefId;
        private int runStatus;
        private Object appUser;
        private String defId;
        private Object defHtml;
        private Object userId;

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

        public String getRunId() {
            return runId;
        }

        public void setRunId(String runId) {
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

        public Object getEndtime() {
            return endtime;
        }

        public void setEndtime(Object endtime) {
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

        public Object getRelationId() {
            return relationId;
        }

        public void setRelationId(Object relationId) {
            this.relationId = relationId;
        }

        public Object getProcessRunNo() {
            return processRunNo;
        }

        public void setProcessRunNo(Object processRunNo) {
            this.processRunNo = processRunNo;
        }

        public Object getUrgetime() {
            return urgetime;
        }

        public void setUrgetime(Object urgetime) {
            this.urgetime = urgetime;
        }

        public Object getPiId() {
            return piId;
        }

        public void setPiId(Object piId) {
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

        public String getFormDefId() {
            return formDefId;
        }

        public void setFormDefId(String formDefId) {
            this.formDefId = formDefId;
        }

        public int getRunStatus() {
            return runStatus;
        }

        public void setRunStatus(int runStatus) {
            this.runStatus = runStatus;
        }

        public Object getAppUser() {
            return appUser;
        }

        public void setAppUser(Object appUser) {
            this.appUser = appUser;
        }

        public String getDefId() {
            return defId;
        }

        public void setDefId(String defId) {
            this.defId = defId;
        }

        public Object getDefHtml() {
            return defHtml;
        }

        public void setDefHtml(Object defHtml) {
            this.defHtml = defHtml;
        }

        public Object getUserId() {
            return userId;
        }

        public void setUserId(Object userId) {
            this.userId = userId;
        }
    }
}
