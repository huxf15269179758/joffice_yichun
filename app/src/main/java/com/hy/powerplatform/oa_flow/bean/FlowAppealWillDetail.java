package com.hy.powerplatform.oa_flow.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/2/22.
 */

public class FlowAppealWillDetail implements Serializable {


    /**
     * success : true
     * taskId : 9730069
     * pkValue : 3
     * formRights : {'XiangGuanFuJian':'1','jbfgldyj':'1','ShenQingShiJian':'1','bjap':'1','sqbm':'1','qingshishangbaoneirong':'1','zjlyj':'1','dszyj':'1','bmfzryj':'2','LiuShuiHao':'1','ShenQingRen':'1','fgldyj':'1'}
     * mainform : [{"sqbm":"宜春公交集团有限公司","ShenQingRen":"超级管理员","dszyj":"","runId":52203,"jbfgldyj":"","$type$":"WF_QingShiShangBaoNew","fgldyj":"","ShenQingBuMenDid":"","ShenQingShiJian":"2019-11-28","qingshishangbaoneirong":"测试","bjap":"","mainId":3,"ShenQingRenUId":"888888888","zjlyj":"","XiangGuanFuJian":"","bmfzryj":"","LiuShuiHao":"No.20191128097"}]
     * formDefId : 10134
     * preTaskName :
     * isSignTask : false
     * trans : [{"destType":"task","destination":"分管领导","name":"to 分管领导","source":"部门负责人"}]
     * runId : 52203
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
         * sqbm : 宜春公交集团有限公司
         * ShenQingRen : 超级管理员
         * dszyj :
         * runId : 52203
         * jbfgldyj :
         * $type$ : WF_QingShiShangBaoNew
         * fgldyj :
         * ShenQingBuMenDid :
         * ShenQingShiJian : 2019-11-28
         * qingshishangbaoneirong : 测试
         * bjap :
         * mainId : 3
         * ShenQingRenUId : 888888888
         * zjlyj :
         * XiangGuanFuJian :
         * bmfzryj :
         * LiuShuiHao : No.20191128097
         */

        private String sqbm;
        private String ShenQingRen;
        private String dszyj;
        private String runId;
        private String jbfgldyj;
        private String $type$;
        private String fgldyj;
        private String ShenQingBuMenDid;
        private String ShenQingShiJian;
        private String qingshishangbaoneirong;
        private String bjap;
        private int mainId;
        private String ShenQingRenUId;
        private String zjlyj;
        private String XiangGuanFuJian;
        private String bmfzryj;
        private String LiuShuiHao;

        public String getSqbm() {
            return sqbm;
        }

        public void setSqbm(String sqbm) {
            this.sqbm = sqbm;
        }

        public String getShenQingRen() {
            return ShenQingRen;
        }

        public void setShenQingRen(String ShenQingRen) {
            this.ShenQingRen = ShenQingRen;
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

        public String getShenQingBuMenDid() {
            return ShenQingBuMenDid;
        }

        public void setShenQingBuMenDid(String ShenQingBuMenDid) {
            this.ShenQingBuMenDid = ShenQingBuMenDid;
        }

        public String getShenQingShiJian() {
            return ShenQingShiJian;
        }

        public void setShenQingShiJian(String ShenQingShiJian) {
            this.ShenQingShiJian = ShenQingShiJian;
        }

        public String getQingshishangbaoneirong() {
            return qingshishangbaoneirong;
        }

        public void setQingshishangbaoneirong(String qingshishangbaoneirong) {
            this.qingshishangbaoneirong = qingshishangbaoneirong;
        }

        public String getBjap() {
            return bjap;
        }

        public void setBjap(String bjap) {
            this.bjap = bjap;
        }

        public int getMainId() {
            return mainId;
        }

        public void setMainId(int mainId) {
            this.mainId = mainId;
        }

        public String getShenQingRenUId() {
            return ShenQingRenUId;
        }

        public void setShenQingRenUId(String ShenQingRenUId) {
            this.ShenQingRenUId = ShenQingRenUId;
        }

        public String getZjlyj() {
            return zjlyj;
        }

        public void setZjlyj(String zjlyj) {
            this.zjlyj = zjlyj;
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
