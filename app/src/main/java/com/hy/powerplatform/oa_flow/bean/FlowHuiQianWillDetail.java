package com.hy.powerplatform.oa_flow.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/3/6.
 */

public class FlowHuiQianWillDetail implements Serializable {

    /**
     * success : true
     * taskId : 8170112
     * pkValue : mainId
     * formRights : {}
     * mainform : [{"xgfj":"","mainId":8,"sqr":"唐根六","sqrUId":"2399","dszyj":"","runId":51534,"jbfgldyj":"","zjlyj":"","$type$":"WF_huiqian","HuiQianShiXiang":"测代办","LiuShuiHao":"No.20190306212"}]
     * formDefId : 10124
     * preTaskName :
     * isSignTask : true
     * trans : [{"destType":"task","destination":"总经理","name":"to 总经理","source":"会签"},{"destType":"end","destination":"结束1","name":"to 结束1","source":"会签"}]
     */

    private boolean success;
    private String taskId;
    private String pkValue;
    private String formRights;
    private String formDefId;
    private String preTaskName;
    private boolean revoke;
    private boolean isSignTask;
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
         * xgfj :
         * mainId : 8
         * sqr : 唐根六
         * sqrUId : 2399
         * dszyj :
         * runId : 51534
         * jbfgldyj :
         * zjlyj :
         * $type$ : WF_huiqian
         * HuiQianShiXiang : 测代办
         * LiuShuiHao : No.20190306212
         */

        private String xgfj;
        private int mainId;
        private String sqr;
        private String sqrUId;
        private String dszyj;
        private String runId;
        private String jbfgldyj;
        private String zjlyj;
        private String $type$;
        private String HuiQianShiXiang;
        private String LiuShuiHao;

        public String getXgfj() {
            return xgfj;
        }

        public void setXgfj(String xgfj) {
            this.xgfj = xgfj;
        }

        public int getMainId() {
            return mainId;
        }

        public void setMainId(int mainId) {
            this.mainId = mainId;
        }

        public String getSqr() {
            return sqr;
        }

        public void setSqr(String sqr) {
            this.sqr = sqr;
        }

        public String getSqrUId() {
            return sqrUId;
        }

        public void setSqrUId(String sqrUId) {
            this.sqrUId = sqrUId;
        }

        public String getDszyj() {
            return dszyj;
        }

        public void setDszyj(String dszyj) {
            this.dszyj = dszyj;
        }

        public String getRunId() {
            return runId;
        }

        public void setRunId(String runId) {
            this.runId = runId;
        }

        public String getJbfgldyj() {
            return jbfgldyj;
        }

        public void setJbfgldyj(String jbfgldyj) {
            this.jbfgldyj = jbfgldyj;
        }

        public String getZjlyj() {
            return zjlyj;
        }

        public void setZjlyj(String zjlyj) {
            this.zjlyj = zjlyj;
        }

        public String get$type$() {
            return $type$;
        }

        public void set$type$(String $type$) {
            this.$type$ = $type$;
        }

        public String getHuiQianShiXiang() {
            return HuiQianShiXiang;
        }

        public void setHuiQianShiXiang(String HuiQianShiXiang) {
            this.HuiQianShiXiang = HuiQianShiXiang;
        }

        public String getLiuShuiHao() {
            return LiuShuiHao;
        }

        public void setLiuShuiHao(String LiuShuiHao) {
            this.LiuShuiHao = LiuShuiHao;
        }
    }

    public static class TransBean {
        /**
         * destType : task
         * destination : 总经理
         * name : to 总经理
         * source : 会签
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
