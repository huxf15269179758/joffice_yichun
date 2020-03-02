package com.hy.powerplatform.oa_flow.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/1/29.
 */

public class FlowPayLiuCheng implements Serializable {

    /**
     * success : true
     * taskId : 7890177
     * pkValue : mainId
     * formRights : {'skdwqc':'1','fkyt':'1','jine':'1','fgldyj':'1','sqr':'1','bmfzryj':'2','YS':'1','bm':'1','sqrq':'1','xiaoxie':'1','zjlyj':'1','cwzjyj':'1','XiangGuanFuJian':'1'}
     * mainform : [{"fkyt":"测试付款程序审批单app","jine":"伍佰捌拾贰元整","bmDid":"378","sqr":"超级管理员","cwzjyj":"","runId":51306,"$type$":"WF_FuKuanChengXUShenPi","fgldyj":"","bm":"宜春公交集团有限公司","mainId":49,"sqrq":"2019-01-29","sqrUId":"888888888","zjlyj":"","skdwqc":"测试付款程序审批单","YS":"预算内","xiaoxie":"582","XiangGuanFuJian":"","bmfzryj":""}]
     * formDefId : 10078
     * preTaskName :
     * isSignTask : false
     * trans : [{"destType":"task","destination":"分管领导","name":"to 分管领导","source":"部门负责人"}]
     */

    private boolean success;
    private String taskId;
    private String pkValue;
    private String formRights;
    private String formDefId;
    private String preTaskName;
    private boolean isSignTask;
    private boolean revoke;
    private List<MainformBean> mainform;
    private List<TransBean> trans;

    public boolean isRevoke() {
        return revoke;
    }

    public void setRevoke(boolean revoke) {
        this.revoke = revoke;
    }

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
         * fkyt : 测试付款程序审批单app
         * jine : 伍佰捌拾贰元整
         * bmDid : 378
         * sqr : 超级管理员
         * cwzjyj :
         * runId : 51306
         * $type$ : WF_FuKuanChengXUShenPi
         * fgldyj :
         * bm : 宜春公交集团有限公司
         * mainId : 49
         * sqrq : 2019-01-29
         * sqrUId : 888888888
         * zjlyj :
         * skdwqc : 测试付款程序审批单
         * YS : 预算内
         * xiaoxie : 582
         * XiangGuanFuJian :
         * bmfzryj :
         */

        private String fkyt;
        private String jine;
        private String bmDid;
        private String sqr;
        private String cwzjyj;
        private String runId;
        private String $type$;
        private String fgldyj;
        private String bm;
        private int mainId;
        private String sqrq;
        private String sqrUId;
        private String zjlyj;
        private String skdwqc;
        private String YS;
        private String xiaoxie;
        private String XiangGuanFuJian;
        private String bmfzryj;

        public String getFkyt() {
            return fkyt;
        }

        public void setFkyt(String fkyt) {
            this.fkyt = fkyt;
        }

        public String getJine() {
            return jine;
        }

        public void setJine(String jine) {
            this.jine = jine;
        }

        public String getBmDid() {
            return bmDid;
        }

        public void setBmDid(String bmDid) {
            this.bmDid = bmDid;
        }

        public String getSqr() {
            return sqr;
        }

        public void setSqr(String sqr) {
            this.sqr = sqr;
        }

        public String getCwzjyj() {
            return cwzjyj;
        }

        public void setCwzjyj(String cwzjyj) {
            this.cwzjyj = cwzjyj;
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

        public String getFgldyj() {
            return fgldyj;
        }

        public void setFgldyj(String fgldyj) {
            this.fgldyj = fgldyj;
        }

        public String getBm() {
            return bm;
        }

        public void setBm(String bm) {
            this.bm = bm;
        }

        public int getMainId() {
            return mainId;
        }

        public void setMainId(int mainId) {
            this.mainId = mainId;
        }

        public String getSqrq() {
            return sqrq;
        }

        public void setSqrq(String sqrq) {
            this.sqrq = sqrq;
        }

        public String getSqrUId() {
            return sqrUId;
        }

        public void setSqrUId(String sqrUId) {
            this.sqrUId = sqrUId;
        }

        public String getZjlyj() {
            return zjlyj;
        }

        public void setZjlyj(String zjlyj) {
            this.zjlyj = zjlyj;
        }

        public String getSkdwqc() {
            return skdwqc;
        }

        public void setSkdwqc(String skdwqc) {
            this.skdwqc = skdwqc;
        }

        public String getYS() {
            return YS;
        }

        public void setYS(String YS) {
            this.YS = YS;
        }

        public String getXiaoxie() {
            return xiaoxie;
        }

        public void setXiaoxie(String xiaoxie) {
            this.xiaoxie = xiaoxie;
        }

        public String getXiangGuanFuJian() {
            return XiangGuanFuJian;
        }

        public void setXiangGuanFuJian(String XiangGuanFuJian) {
            this.XiangGuanFuJian = XiangGuanFuJian;
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
         * destType : task
         * destination : 分管领导
         * name : to 分管领导
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
