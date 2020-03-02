package com.hy.powerplatform.oa_flow.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/1/21.
 */

public class QingJiaWillDoDetail implements Serializable {


    /**
     * success : true
     * taskId : 7780058
     * pkValue : mainId
     * formRights : {'vocationType':'1','bmfzryj':'2','endDate':'1','fullname':'1','jsdayType':'1','ksdayType':'1','fgldyj':'1','zjlyj':'1','beginDate':'1','FuBingLi':'1','TianDanRiQi':'1','shiyou':'1','vocationDays':'1'}
     * mainform : [{"FuBingLi":"","fullnameUId":"888888888","ksdayType":"上午","shiyou":"测试事由","endDate":"2019-01-24","runId":51282,"$type$":"WF_YuanGongQingJiaDan","beginDate":"2019-01-23","fgldyj":"","vocationType":"病假","jsdayType":"上午","TianDanRiQi":"2019-01-23","mainId":127,"vocationDays":"2","zjlyj":"","fullname":"超级管理员","bmfzryj":""}]
     * formDefId : 83
     * preTaskName :
     * isSignTask : false
     * trans : [{"destType":"decision","destination":"决策1","name":"to 决策1","source":"部门负责人"}]
     */

    private boolean success;
    private String taskId;
    private String pkValue;
    private String formRights;
    private String formDefId;
    private String preTaskName;
    private boolean isSignTask;
    private boolean revoke;

    public boolean isRevoke() {
        return revoke;
    }

    public void setRevoke(boolean revoke) {
        this.revoke = revoke;
    }

    private List<MainformBean> mainform;
    private List<TransBean> trans;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getPkValue() {
        return pkValue;
    }

    public void setPkValue(String pkValue) {
        this.pkValue = pkValue;
    }

    public String getFormRights() {
        return formRights;
    }

    public void setFormRights(String formRights) {
        this.formRights = formRights;
    }

    public String getFormDefId() {
        return formDefId;
    }

    public void setFormDefId(String formDefId) {
        this.formDefId = formDefId;
    }

    public String getPreTaskName() {
        return preTaskName;
    }

    public void setPreTaskName(String preTaskName) {
        this.preTaskName = preTaskName;
    }

    public boolean isIsSignTask() {
        return isSignTask;
    }

    public void setIsSignTask(boolean isSignTask) {
        this.isSignTask = isSignTask;
    }

    public List<MainformBean> getMainform() {
        return mainform;
    }

    public void setMainform(List<MainformBean> mainform) {
        this.mainform = mainform;
    }

    public List<TransBean> getTrans() {
        return trans;
    }

    public void setTrans(List<TransBean> trans) {
        this.trans = trans;
    }

    public static class MainformBean {
        /**
         * FuBingLi :
         * fullnameUId : 888888888
         * ksdayType : 上午
         * shiyou : 测试事由
         * endDate : 2019-01-24
         * runId : 51282
         * $type$ : WF_YuanGongQingJiaDan
         * beginDate : 2019-01-23
         * fgldyj :
         * vocationType : 病假
         * jsdayType : 上午
         * TianDanRiQi : 2019-01-23
         * mainId : 127
         * vocationDays : 2
         * zjlyj :
         * fullname : 超级管理员
         * bmfzryj :
         */

        private String FuBingLi;
        private String fullnameUId;
        private String ksdayType;
        private String shiyou;
        private String endDate;
        private String runId;
        private String $type$;
        private String beginDate;
        private String fgldyj;
        private String vocationType;
        private String jsdayType;
        private String TianDanRiQi;
        private int mainId;
        private String vocationDays;
        private String zjlyj;
        private String fullname;
        private String bmfzryj;

        public String getFuBingLi() {
            return FuBingLi;
        }

        public void setFuBingLi(String FuBingLi) {
            this.FuBingLi = FuBingLi;
        }

        public String getFullnameUId() {
            return fullnameUId;
        }

        public void setFullnameUId(String fullnameUId) {
            this.fullnameUId = fullnameUId;
        }

        public String getKsdayType() {
            return ksdayType;
        }

        public void setKsdayType(String ksdayType) {
            this.ksdayType = ksdayType;
        }

        public String getShiyou() {
            return shiyou;
        }

        public void setShiyou(String shiyou) {
            this.shiyou = shiyou;
        }

        public String getEndDate() {
            return endDate;
        }

        public void setEndDate(String endDate) {
            this.endDate = endDate;
        }

        public String getRunId() {
            return runId;
        }

        public void setRunId(String runId) {
            this.runId = runId;
        }

        public String get$type$() {
            return $type$;
        }

        public void set$type$(String $type$) {
            this.$type$ = $type$;
        }

        public String getBeginDate() {
            return beginDate;
        }

        public void setBeginDate(String beginDate) {
            this.beginDate = beginDate;
        }

        public String getFgldyj() {
            return fgldyj;
        }

        public void setFgldyj(String fgldyj) {
            this.fgldyj = fgldyj;
        }

        public String getVocationType() {
            return vocationType;
        }

        public void setVocationType(String vocationType) {
            this.vocationType = vocationType;
        }

        public String getJsdayType() {
            return jsdayType;
        }

        public void setJsdayType(String jsdayType) {
            this.jsdayType = jsdayType;
        }

        public String getTianDanRiQi() {
            return TianDanRiQi;
        }

        public void setTianDanRiQi(String TianDanRiQi) {
            this.TianDanRiQi = TianDanRiQi;
        }

        public int getMainId() {
            return mainId;
        }

        public void setMainId(int mainId) {
            this.mainId = mainId;
        }

        public String getVocationDays() {
            return vocationDays;
        }

        public void setVocationDays(String vocationDays) {
            this.vocationDays = vocationDays;
        }

        public String getZjlyj() {
            return zjlyj;
        }

        public void setZjlyj(String zjlyj) {
            this.zjlyj = zjlyj;
        }

        public String getFullname() {
            return fullname;
        }

        public void setFullname(String fullname) {
            this.fullname = fullname;
        }

        public String getBmfzryj() {
            return bmfzryj;
        }

        public void setBmfzryj(String bmfzryj) {
            this.bmfzryj = bmfzryj;
        }
    }

    public static class TransBean {
        /**
         * destType : decision
         * destination : 决策1
         * name : to 决策1
         * source : 部门负责人
         */

        private String destType;
        private String destination;
        private String name;
        private String source;

        public String getDestType() {
            return destType;
        }

        public void setDestType(String destType) {
            this.destType = destType;
        }

        public String getDestination() {
            return destination;
        }

        public void setDestination(String destination) {
            this.destination = destination;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }
    }
}
