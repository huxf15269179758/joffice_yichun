package com.hy.powerplatform.oa_flow.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/4/9.
 */

public class FlowGHContractSign implements Serializable {


    /**
     * success : true
     * taskId : 8430114
     * pkValue : mainId
     * formRights : {'flgwyj':'1','xiangguanfujian':'2','spsj':'1','ghzx':'1','cbbm':'1','cbbmfzr':'1','cwsjbyj':'2','jcbmyj':'1','bmfzryj':'1','htmc':'1','jbqk':'1'}
     * mainform : [{"jcbmyj":"","runId":51644,"$type$":"WF_dwhtqdspd","flgwyj":"","jbqk":"测试名称","cbbm":"宜春公交集团有限公司","htmc":"测试事由","xiangguanfujian":"","mainId":7,"cwsjbyj":"","cbbmfzr":"超级管理员","spsj":"2019-04-09","ghzx":"","bmfzryj":"[{\"ui\":\"9354\",\"un\":\"欧阳晓林\",\"c\":\"2019-04-09 13:07\",\"v\":\"同意\"}]"}]
     * formDefId : 10129
     * preTaskName :
     * isSignTask : false
     * trans : [{"destType":"task","destination":"监查部门","name":"to 监查部门","source":"财务审计部"}]
     * runId : 51644
     */

    private boolean success;
    private String taskId;
    private String pkValue;
    private String formRights;
    private String formDefId;
    private String preTaskName;
    private boolean revoke;
    private boolean isSignTask;
    private int runId;
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

    public int getRunId() {
        return runId;
    }

    public void setRunId(int runId) {
        this.runId = runId;
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
         * jcbmyj :
         * runId : 51644
         * $type$ : WF_dwhtqdspd
         * flgwyj :
         * jbqk : 测试名称
         * cbbm : 宜春公交集团有限公司
         * htmc : 测试事由
         * xiangguanfujian :
         * mainId : 7
         * cwsjbyj :
         * cbbmfzr : 超级管理员
         * spsj : 2019-04-09
         * ghzx :
         * bmfzryj : [{"ui":"9354","un":"欧阳晓林","c":"2019-04-09 13:07","v":"同意"}]
         */

        private String jcbmyj;
        private String runId;
        private String $type$;
        private String flgwyj;
        private String jbqk;
        private String cbbm;
        private String htmc;
        private String xiangguanfujian;
        private int mainId;
        private String cwsjbyj;
        private String cbbmfzr;
        private String spsj;
        private String ghzx;
        private String bmfzryj;

        public String getJcbmyj() {
            return jcbmyj;
        }

        public void setJcbmyj(String jcbmyj) {
            this.jcbmyj = jcbmyj;
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

        public String getFlgwyj() {
            return flgwyj;
        }

        public void setFlgwyj(String flgwyj) {
            this.flgwyj = flgwyj;
        }

        public String getJbqk() {
            return jbqk;
        }

        public void setJbqk(String jbqk) {
            this.jbqk = jbqk;
        }

        public String getCbbm() {
            return cbbm;
        }

        public void setCbbm(String cbbm) {
            this.cbbm = cbbm;
        }

        public String getHtmc() {
            return htmc;
        }

        public void setHtmc(String htmc) {
            this.htmc = htmc;
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

        public String getCwsjbyj() {
            return cwsjbyj;
        }

        public void setCwsjbyj(String cwsjbyj) {
            this.cwsjbyj = cwsjbyj;
        }

        public String getCbbmfzr() {
            return cbbmfzr;
        }

        public void setCbbmfzr(String cbbmfzr) {
            this.cbbmfzr = cbbmfzr;
        }

        public String getSpsj() {
            return spsj;
        }

        public void setSpsj(String spsj) {
            this.spsj = spsj;
        }

        public String getGhzx() {
            return ghzx;
        }

        public void setGhzx(String ghzx) {
            this.ghzx = ghzx;
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
         * destination : 监查部门
         * name : to 监查部门
         * source : 财务审计部
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
