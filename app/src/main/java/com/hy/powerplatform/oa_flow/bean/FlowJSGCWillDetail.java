package com.hy.powerplatform.oa_flow.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/2/21.
 */

public class FlowJSGCWillDetail implements Serializable {

    /**
     * success : true
     * taskId : 8030110
     * pkValue : mainId
     * formRights : {'XuQiuShiXiang':'1','LiuShuiHao':'1','jbfgldyj':'1','zjlyj':'1','xiangguanfujian':'1','XuQiuBuMen':'1','bmfzryj':'2','jjbzbyj':'1','RiQi':'1','ShenQingRen':'1','fgldyj':'1'}
     * mainform : [{"jjbzbyj":"","ShenQingRen":"超级管理员","runId":51480,"$type$":"WF_XinJianGongChengQiDongShenPiDan","jbfgldyj":"","fgldyj":"","xiangguanfujian":"","mainId":2,"RiQi":"2019-02-21","zjlyj":"","XuQiuShiXiang":"测试","bmfzryj":"","XuQiuBuMen":"宜春公交集团有限公司","LiuShuiHao":"No.20190221104"}]
     * formDefId : 10107
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
         * jjbzbyj :
         * ShenQingRen : 超级管理员
         * runId : 51480
         * $type$ : WF_XinJianGongChengQiDongShenPiDan
         * jbfgldyj :
         * fgldyj :
         * xiangguanfujian :
         * mainId : 2
         * RiQi : 2019-02-21
         * zjlyj :
         * XuQiuShiXiang : 测试
         * bmfzryj :
         * XuQiuBuMen : 宜春公交集团有限公司
         * LiuShuiHao : No.20190221104
         */

        private String jjbzbyj;
        private String ShenQingRen;
        private String runId;
        private String $type$;
        private String jbfgldyj;
        private String fgldyj;
        private String xiangguanfujian;
        private int mainId;
        private String RiQi;
        private String zjlyj;
        private String XuQiuShiXiang;
        private String bmfzryj;
        private String XuQiuBuMen;
        private String LiuShuiHao;

        public String getJjbzbyj() {
            return jjbzbyj;
        }

        public void setJjbzbyj(String jjbzbyj) {
            this.jjbzbyj = jjbzbyj;
        }

        public String getShenQingRen() {
            return ShenQingRen;
        }

        public void setShenQingRen(String ShenQingRen) {
            this.ShenQingRen = ShenQingRen;
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

        public String getJbfgldyj() {
            return jbfgldyj;
        }

        public void setJbfgldyj(String jbfgldyj) {
            this.jbfgldyj = jbfgldyj;
        }

        public String getFgldyj() {
            return fgldyj;
        }

        public void setFgldyj(String fgldyj) {
            this.fgldyj = fgldyj;
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

        public String getRiQi() {
            return RiQi;
        }

        public void setRiQi(String RiQi) {
            this.RiQi = RiQi;
        }

        public String getZjlyj() {
            return zjlyj;
        }

        public void setZjlyj(String zjlyj) {
            this.zjlyj = zjlyj;
        }

        public String getXuQiuShiXiang() {
            return XuQiuShiXiang;
        }

        public void setXuQiuShiXiang(String XuQiuShiXiang) {
            this.XuQiuShiXiang = XuQiuShiXiang;
        }

        public String getBmfzryj() {
            return bmfzryj;
        }

        public void setBmfzryj(String bmfzryj) {
            this.bmfzryj = bmfzryj;
        }

        public String getXuQiuBuMen() {
            return XuQiuBuMen;
        }

        public void setXuQiuBuMen(String XuQiuBuMen) {
            this.XuQiuBuMen = XuQiuBuMen;
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
