package com.hy.powerplatform.oa_flow.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/3/11.
 */

public class WithMeList implements Serializable {


    /**
     * success : true
     * totalCounts : 40
     * result : [{"runId":"51475","subject":"报修项目登记表new20190228-104157","createtime":"2019-02-28 10:41:57.277","defId":"20307","piId":"","runStatus":"2","formTitle":"报修项目登记表","formDefId":"10105","processName":"报修项目登记表new","creator":"陈国华"},{"runId":"51451","subject":"公司信息发布审批单20190222-152241","createtime":"2019-02-22 15:22:41.987","defId":"10094","piId":"","runStatus":"2","formTitle":"信息发布审批单","formDefId":"10110","processName":"公司信息发布审批单","creator":"漆明"},{"runId":"51438","subject":"报修项目登记表new20190220-124027","createtime":"2019-02-20 12:40:27.373","defId":"20307","piId":"","runStatus":"2","formTitle":"报修项目登记表","formDefId":"10105","processName":"报修项目登记表new","creator":"刘娟"},{"runId":"51437","subject":"宜春公交集团安装改造项目申办表20190220-114805","createtime":"2019-02-20 11:48:05.547","defId":"20232","piId":"","runStatus":"2","formTitle":"宜春公交集团有限公司项目申办表","formDefId":"10087","processName":"宜春公交集团安装改造项目申办表","creator":"刘晓霞"},{"runId":"51427","subject":"报修项目登记表new20190216-111750","createtime":"2019-02-16 11:17:50.96","defId":"20307","piId":"","runStatus":"2","formTitle":"报修项目登记表","formDefId":"10105","processName":"报修项目登记表new","creator":"周洋"},{"runId":"51419","subject":"付款程序审批单_李春华","createtime":"2019-02-13 10:36:28.21","defId":"10151","piId":"","runStatus":"2","formTitle":"付款程序审批单","formDefId":"10078","processName":"付款程序审批单","creator":"田乐"},{"runId":"51418","subject":"员工请假流程_刘竹梅","createtime":"2019-02-13 09:26:34.257","defId":"10135","piId":"","runStatus":"2","formTitle":"宜春公交集团请假表单","formDefId":"83","processName":"员工请假流程","creator":"刘竹梅"},{"runId":"51417","subject":"员工请假流程_刘娟","createtime":"2019-02-13 09:11:29.07","defId":"10135","piId":"","runStatus":"2","formTitle":"宜春公交集团请假表单","formDefId":"83","processName":"员工请假流程","creator":"刘娟"},{"runId":"51405","subject":"宜春公交集团安装改造项目申办表20190211-104341","createtime":"2019-02-11 10:43:41.107","defId":"20232","piId":"","runStatus":"2","formTitle":"宜春公交集团有限公司项目申办表","formDefId":"10087","processName":"宜春公交集团安装改造项目申办表","creator":"罗小灵"},{"runId":"51399","subject":"报修项目登记表new20190201-152944","createtime":"2019-02-01 15:29:44.627","defId":"20307","piId":"","runStatus":"2","formTitle":"报修项目登记表","formDefId":"10105","processName":"报修项目登记表new","creator":"罗小灵"},{"runId":"51398","subject":"合同签订审批流程20190201-144454","createtime":"2019-02-01 14:44:54.797","defId":"10165","piId":"","runStatus":"2","formTitle":"合同签订审批单","formDefId":"66","processName":"合同签订审批流程","creator":"漆明"},{"runId":"51397","subject":"驾驶员入职流程表20190131-160406","createtime":"2019-01-31 16:04:06.907","defId":"10105","piId":"","runStatus":"2","formTitle":"驾驶员入职流程表news","formDefId":"10117","processName":"驾驶员入职流程表","creator":"林婕"},{"runId":"51385","subject":"宜春公交集团安装改造项目申办表20190130-093510","createtime":"2019-01-30 09:35:10.55","defId":"20232","piId":"","runStatus":"2","formTitle":"宜春公交集团有限公司项目申办表","formDefId":"10087","processName":"宜春公交集团安装改造项目申办表","creator":"罗小灵"},{"runId":"51384","subject":"员工请假流程_喻海","createtime":"2019-01-29 17:06:50.047","defId":"10135","piId":"","runStatus":"2","formTitle":"宜春公交集团请假表单","formDefId":"83","processName":"员工请假流程","creator":"喻海"},{"runId":"51383","subject":"驾驶员入职流程表20190129-151253","createtime":"2019-01-29 15:12:53.763","defId":"10105","piId":"","runStatus":"2","formTitle":"驾驶员入职流程表news","formDefId":"10117","processName":"驾驶员入职流程表","creator":"林婕"},{"runId":"51382","subject":"驾驶员入职流程表20190129-150932","createtime":"2019-01-29 15:09:32.857","defId":"10105","piId":"","runStatus":"2","formTitle":"驾驶员入职流程表news","formDefId":"10117","processName":"驾驶员入职流程表","creator":"林婕"},{"runId":"51380","subject":"驾驶员入职流程表20190129-110549","createtime":"2019-01-29 11:05:49.36","defId":"10105","piId":"","runStatus":"2","formTitle":"驾驶员入职流程表news","formDefId":"10117","processName":"驾驶员入职流程表","creator":"李建萍"},{"runId":"51379","subject":"报修项目登记表new20190128-194103","createtime":"2019-01-28 19:41:03.047","defId":"20307","piId":"","runStatus":"2","formTitle":"报修项目登记表","formDefId":"10105","processName":"报修项目登记表new","creator":"付伟博"},{"runId":"51378","subject":"员工请假流程_乐朋","createtime":"2019-01-28 19:33:17.02","defId":"10135","piId":"","runStatus":"2","formTitle":"宜春公交集团请假表单","formDefId":"83","processName":"员工请假流程","creator":"付伟博"},{"runId":"51376","subject":"员工请假流程_魏福健","createtime":"2019-01-28 10:50:45.2","defId":"10135","piId":"","runStatus":"2","formTitle":"宜春公交集团请假表单","formDefId":"83","processName":"员工请假流程","creator":"付伟博"}]
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
         * runId : 51475
         * subject : 报修项目登记表new20190228-104157
         * createtime : 2019-02-28 10:41:57.277
         * defId : 20307
         * piId :
         * runStatus : 2
         * formTitle : 报修项目登记表
         * formDefId : 10105
         * processName : 报修项目登记表new
         * creator : 陈国华
         */

        private String runId;
        private String subject;
        private String createtime;
        private String defId;
        private String piId;
        private String runStatus;
        private String formTitle;
        private String formDefId;
        private String processName;
        private String creator;

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

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public String getDefId() {
            return defId;
        }

        public void setDefId(String defId) {
            this.defId = defId;
        }

        public String getPiId() {
            return piId;
        }

        public void setPiId(String piId) {
            this.piId = piId;
        }

        public String getRunStatus() {
            return runStatus;
        }

        public void setRunStatus(String runStatus) {
            this.runStatus = runStatus;
        }

        public String getFormTitle() {
            return formTitle;
        }

        public void setFormTitle(String formTitle) {
            this.formTitle = formTitle;
        }

        public String getFormDefId() {
            return formDefId;
        }

        public void setFormDefId(String formDefId) {
            this.formDefId = formDefId;
        }

        public String getProcessName() {
            return processName;
        }

        public void setProcessName(String processName) {
            this.processName = processName;
        }

        public String getCreator() {
            return creator;
        }

        public void setCreator(String creator) {
            this.creator = creator;
        }
    }
}
