package com.hy.powerplatform.oa_flow.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/1/25.
 */

public class FlowContracterPayWillDetail implements Serializable {


    /**
     * success : true
     * taskId : 7890038
     * pkValue : mainId
     * formRights : {'spsj':'1','jbqk':'1','zjlyj':'1','fgcwldyj':'1','bmfzryj':'2','fgldyj':'1','cbbm':'1','jbr':'1','htbh':'1','xiangguanfujian':'1','htmc':'1'}
     * mainform : [{"runId":51303,"$type$":"WF_HTFKSPBD","fgcwldyj":"","fgldyj":"","htmc":"测试合同付款审批","cbbm":"宜春公交集团有限公司","jbqk":"测试合同付款审批测试合同付款审批","jbr":"超级管理员","xiangguanfujian":"","mainId":1,"zjlyj":"","spsj":"2019-01-29","bmfzryj":"","htbh":"No.20190129016"}]
     * formDefId : 10104
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
         * runId : 51303
         * $type$ : WF_HTFKSPBD
         * fgcwldyj :
         * fgldyj :
         * htmc : 测试合同付款审批
         * cbbm : 宜春公交集团有限公司
         * jbqk : 测试合同付款审批测试合同付款审批
         * jbr : 超级管理员
         * xiangguanfujian :
         * mainId : 1
         * zjlyj :
         * spsj : 2019-01-29
         * bmfzryj :
         * htbh : No.20190129016
         */

        private String runId;
        private String $type$;
        private String fgcwldyj;
        private String fgldyj;
        private String htmc;
        private String cbbm;
        private String jbqk;
        private String jbr;
        private String xiangguanfujian;
        private int mainId;
        private String zjlyj;
        private String spsj;
        private String bmfzryj;
        private String htbh;

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

        public String getFgcwldyj() {
            return fgcwldyj;
        }

        public void setFgcwldyj(String fgcwldyj) {
            this.fgcwldyj = fgcwldyj;
        }

        public String getFgldyj() {
            return fgldyj;
        }

        public void setFgldyj(String fgldyj) {
            this.fgldyj = fgldyj;
        }

        public String getHtmc() {
            return htmc;
        }

        public void setHtmc(String htmc) {
            this.htmc = htmc;
        }

        public String getCbbm() {
            return cbbm;
        }

        public void setCbbm(String cbbm) {
            this.cbbm = cbbm;
        }

        public String getJbqk() {
            return jbqk;
        }

        public void setJbqk(String jbqk) {
            this.jbqk = jbqk;
        }

        public String getJbr() {
            return jbr;
        }

        public void setJbr(String jbr) {
            this.jbr = jbr;
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

        public String getZjlyj() {
            return zjlyj;
        }

        public void setZjlyj(String zjlyj) {
            this.zjlyj = zjlyj;
        }

        public String getSpsj() {
            return spsj;
        }

        public void setSpsj(String spsj) {
            this.spsj = spsj;
        }

        public String getBmfzryj() {
            return bmfzryj;
        }

        public void setBmfzryj(String bmfzryj) {
            this.bmfzryj = bmfzryj;
        }

        public String getHtbh() {
            return htbh;
        }

        public void setHtbh(String htbh) {
            this.htbh = htbh;
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
