package com.hy.powerplatform.oa_flow.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/2/20.
 */

public class FlowDinnerWillDetail implements Serializable {

    /**
     * success : true
     * taskId : 7990116
     * pkValue : mainId
     * formRights : {'lkdwhbm':'1','sqbm':'1','pcry':'1','ycfyxx':'1','zjlyj':'1','lkrs':'1','ycbz':'1','fgldyj':'1','sqr':'1','ycfydx':'1','bmfzryj':'1','xiangguanfujian':'1'}
     * mainform : [{"sqbm":"宜春公交集团有限公司","jine":"五十","ycfydx":"","sqr":"超级管理员","runId":51465,"$type$":"WF_jdycspb","pcry":"人员，人员2","lkrs":"5","fgldyj":"","lkdwhbm":"测试单位","xiangguanfujian":"","mainId":10010,"ycbz":"500","zjlyj":"","ycfyxx":"","xiaoxie":"50","bmfzryj":""}]
     * formDefId : 62
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
         * sqbm : 宜春公交集团有限公司
         * jine : 五十
         * ycfydx :
         * sqr : 超级管理员
         * runId : 51465
         * $type$ : WF_jdycspb
         * pcry : 人员，人员2
         * lkrs : 5
         * fgldyj :
         * lkdwhbm : 测试单位
         * xiangguanfujian :
         * mainId : 10010
         * ycbz : 500
         * zjlyj :
         * ycfyxx :
         * xiaoxie : 50
         * bmfzryj :
         */

        private String sqbm;
        private String jine;
        private String ycfydx;
        private String sqr;
        private String runId;
        private String $type$;
        private String pcry;
        private String lkrs;
        private String fgldyj;
        private String lkdwhbm;
        private String xiangguanfujian;
        private int mainId;
        private String ycbz;
        private String zjlyj;
        private String ycfyxx;
        private String xiaoxie;
        private String bmfzryj;

        public String getSqbm() {
            return sqbm;
        }

        public void setSqbm(String sqbm) {
            this.sqbm = sqbm;
        }

        public String getJine() {
            return jine;
        }

        public void setJine(String jine) {
            this.jine = jine;
        }

        public String getYcfydx() {
            return ycfydx;
        }

        public void setYcfydx(String ycfydx) {
            this.ycfydx = ycfydx;
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

        public String getPcry() {
            return pcry;
        }

        public void setPcry(String pcry) {
            this.pcry = pcry;
        }

        public String getLkrs() {
            return lkrs;
        }

        public void setLkrs(String lkrs) {
            this.lkrs = lkrs;
        }

        public String getFgldyj() {
            return fgldyj;
        }

        public void setFgldyj(String fgldyj) {
            this.fgldyj = fgldyj;
        }

        public String getLkdwhbm() {
            return lkdwhbm;
        }

        public void setLkdwhbm(String lkdwhbm) {
            this.lkdwhbm = lkdwhbm;
        }

        public String getXiangguanfujian() {
            return xiangguanfujian;
        }

        public void setXiangguanfujian(String xiangguanfujian) {
            this.xiangguanfujian = xiangguanfujian;
        }

        public int getMainId() {
            return mainId;
        }

        public void setMainId(int mainId) {
            this.mainId = mainId;
        }

        public String getYcbz() {
            return ycbz;
        }

        public void setYcbz(String ycbz) {
            this.ycbz = ycbz;
        }

        public String getZjlyj() {
            return zjlyj;
        }

        public void setZjlyj(String zjlyj) {
            this.zjlyj = zjlyj;
        }

        public String getYcfyxx() {
            return ycfyxx;
        }

        public void setYcfyxx(String ycfyxx) {
            this.ycfyxx = ycfyxx;
        }

        public String getXiaoxie() {
            return xiaoxie;
        }

        public void setXiaoxie(String xiaoxie) {
            this.xiaoxie = xiaoxie;
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
