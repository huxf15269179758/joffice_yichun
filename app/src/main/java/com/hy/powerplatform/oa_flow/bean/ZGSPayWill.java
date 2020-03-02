package com.hy.powerplatform.oa_flow.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/11/26.
 */

public class ZGSPayWill implements Serializable {

    /**
     * success : true
     * taskId : 9870229
     * pkValue : 9
     * formRights : {'sqrq':'1','bm':'1','XiangGuanFuJian':'1','xiaoxie':'1','fkyt':'1','sqr':'1','fgldyj':'1','skdwqc':'1','YS':'1','jine':'1','bmfzryj':'2'}
     * mainform : [{"fkyt":"ujf","jine":"肆佰伍拾陆圆整","bmDid":"378","sqr":"超级管理员","runId":52310,"$type$":"WF_zgsfkcxspd","fgldyj":"","mainId":9,"bm":"宜春公交集团有限公司","sqrq":"2019-11-26","sqrUId":"888888888","skdwqc":"bdbd","xiaoxie":456,"YS":"预算内","bmfzryj":"","XiangGuanFuJian":""}]
     * formDefId : 10133
     * preTaskName :
     * isSignTask : false
     * trans : [{"destType":"decision","destination":"决策1","name":"to 决策1","source":"部门负责人"}]
     * runId : 52310
     * revoke : false
     */

    private boolean success;
    private String taskId;
    private String pkValue;
    private String formRights;
    private String formDefId;
    private String preTaskName;
    private boolean isSignTask;
    private int runId;
    private boolean revoke;
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

    public int getRunId() {
        return runId;
    }

    public void setRunId(int runId) {
        this.runId = runId;
    }

    public boolean isRevoke() {
        return revoke;
    }

    public void setRevoke(boolean revoke) {
        this.revoke = revoke;
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
         * fkyt : ujf
         * jine : 肆佰伍拾陆圆整
         * bmDid : 378
         * sqr : 超级管理员
         * runId : 52310
         * $type$ : WF_zgsfkcxspd
         * fgldyj :
         * mainId : 9
         * bm : 宜春公交集团有限公司
         * sqrq : 2019-11-26
         * sqrUId : 888888888
         * skdwqc : bdbd
         * xiaoxie : 456
         * YS : 预算内
         * bmfzryj :
         * XiangGuanFuJian :
         */

        private String fkyt;
        private String jine;
        private String bmDid;
        private String sqr;
        private String runId;
        private String $type$;
        private String fgldyj;
        private int mainId;
        private String bm;
        private String sqrq;
        private String sqrUId;
        private String skdwqc;
        private String xiaoxie;
        private String YS;
        private String bmfzryj;
        private String XiangGuanFuJian;

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

        public int getMainId() {
            return mainId;
        }

        public void setMainId(int mainId) {
            this.mainId = mainId;
        }

        public String getBm() {
            return bm;
        }

        public void setBm(String bm) {
            this.bm = bm;
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

        public String getSkdwqc() {
            return skdwqc;
        }

        public void setSkdwqc(String skdwqc) {
            this.skdwqc = skdwqc;
        }

        public String getXiaoxie() {
            return xiaoxie;
        }

        public void setXiaoxie(String xiaoxie) {
            this.xiaoxie = xiaoxie;
        }

        public String getYS() {
            return YS;
        }

        public void setYS(String YS) {
            this.YS = YS;
        }

        public String getBmfzryj() {
            return bmfzryj;
        }

        public void setBmfzryj(String bmfzryj) {
            this.bmfzryj = bmfzryj;
        }

        public String getXiangGuanFuJian() {
            return XiangGuanFuJian;
        }

        public void setXiangGuanFuJian(String XiangGuanFuJian) {
            this.XiangGuanFuJian = XiangGuanFuJian;
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
