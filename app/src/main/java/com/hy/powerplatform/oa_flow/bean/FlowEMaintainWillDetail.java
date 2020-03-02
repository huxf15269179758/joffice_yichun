package com.hy.powerplatform.oa_flow.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/2/21.
 */

public class FlowEMaintainWillDetail implements Serializable {

    /**
     * success : true
     * taskId : 8030163
     * pkValue : mainId
     * formRights : {'WeiXiuShiJian':'1','BaoXiuShiJian':'1','XiangGuanFuJian':'1','GuZhangQingKuang':'1','xxjsbyj':'1','bmfzryj':'2','SheBeiShiYongRenQianZi':'1','bjap':'1','WeiXiuQingKuang':'1','WeiXiuRenYuanQianZi':'1','jjbzbyj':'1','BeiZhu':'1','bjpj':'1','BaoXiuBuMen':'1'}
     * mainform : [{"SheBeiShiYongRenQianZiUId":"","WeiXiuRenYuanQianZiUId":"","BaoXiuBuMenDid":"","jjbzbyj":"","WeiXiuQingKuang":"","runId":51482,"SheBeiShiYongRenQianZi":"","$type$":"WF_DianZiSheBeiGuZhangWeiXiuDengJiBiao","BeiZhu":"","xxjsbyj":"","BaoXiuBuMen":"","BaoXiuShiJian":"2019-02-21","bjap":"","mainId":3,"WeiXiuRenYuanQianZi":"","GuZhangQingKuang":"测试","bjpj":"","WeiXiuShiJian":"","bmfzryj":"","XiangGuanFuJian":""}]
     * formDefId : 10111
     * preTaskName :
     * isSignTask : false
     * trans : [{"destType":"task","destination":"信息技术部","name":"信息技术部","source":"部门负责人"}]
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
         * SheBeiShiYongRenQianZiUId :
         * WeiXiuRenYuanQianZiUId :
         * BaoXiuBuMenDid :
         * jjbzbyj :
         * WeiXiuQingKuang :
         * runId : 51482
         * SheBeiShiYongRenQianZi :
         * $type$ : WF_DianZiSheBeiGuZhangWeiXiuDengJiBiao
         * BeiZhu :
         * xxjsbyj :
         * BaoXiuBuMen :
         * BaoXiuShiJian : 2019-02-21
         * bjap :
         * mainId : 3
         * WeiXiuRenYuanQianZi :
         * GuZhangQingKuang : 测试
         * bjpj :
         * WeiXiuShiJian :
         * bmfzryj :
         * XiangGuanFuJian :
         */

        private String SheBeiShiYongRenQianZiUId;
        private String WeiXiuRenYuanQianZiUId;
        private String BaoXiuBuMenDid;
        private String jjbzbyj;
        private String WeiXiuQingKuang;
        private String runId;
        private String SheBeiShiYongRenQianZi;
        private String $type$;
        private String BeiZhu;
        private String xxjsbyj;
        private String BaoXiuBuMen;
        private String BaoXiuShiJian;
        private String bjap;
        private int mainId;
        private String WeiXiuRenYuanQianZi;
        private String GuZhangQingKuang;
        private String bjpj;
        private String WeiXiuShiJian;
        private String bmfzryj;
        private String XiangGuanFuJian;

        public String getSheBeiShiYongRenQianZiUId() {
            return SheBeiShiYongRenQianZiUId;
        }

        public void setSheBeiShiYongRenQianZiUId(String SheBeiShiYongRenQianZiUId) {
            this.SheBeiShiYongRenQianZiUId = SheBeiShiYongRenQianZiUId;
        }

        public String getWeiXiuRenYuanQianZiUId() {
            return WeiXiuRenYuanQianZiUId;
        }

        public void setWeiXiuRenYuanQianZiUId(String WeiXiuRenYuanQianZiUId) {
            this.WeiXiuRenYuanQianZiUId = WeiXiuRenYuanQianZiUId;
        }

        public String getBaoXiuBuMenDid() {
            return BaoXiuBuMenDid;
        }

        public void setBaoXiuBuMenDid(String BaoXiuBuMenDid) {
            this.BaoXiuBuMenDid = BaoXiuBuMenDid;
        }

        public String getJjbzbyj() {
            return jjbzbyj;
        }

        public void setJjbzbyj(String jjbzbyj) {
            this.jjbzbyj = jjbzbyj;
        }

        public String getWeiXiuQingKuang() {
            return WeiXiuQingKuang;
        }

        public void setWeiXiuQingKuang(String WeiXiuQingKuang) {
            this.WeiXiuQingKuang = WeiXiuQingKuang;
        }

        public String getRunId() {
            return runId;
        }

        public void setRunId(String runId) {
            this.runId = runId;
        }

        public String getSheBeiShiYongRenQianZi() {
            return SheBeiShiYongRenQianZi;
        }

        public void setSheBeiShiYongRenQianZi(String SheBeiShiYongRenQianZi) {
            this.SheBeiShiYongRenQianZi = SheBeiShiYongRenQianZi;
        }

        public String get$type$() {
            return $type$;
        }

        public void set$type$(String $type$) {
            this.$type$ = $type$;
        }

        public String getBeiZhu() {
            return BeiZhu;
        }

        public void setBeiZhu(String BeiZhu) {
            this.BeiZhu = BeiZhu;
        }

        public String getXxjsbyj() {
            return xxjsbyj;
        }

        public void setXxjsbyj(String xxjsbyj) {
            this.xxjsbyj = xxjsbyj;
        }

        public String getBaoXiuBuMen() {
            return BaoXiuBuMen;
        }

        public void setBaoXiuBuMen(String BaoXiuBuMen) {
            this.BaoXiuBuMen = BaoXiuBuMen;
        }

        public String getBaoXiuShiJian() {
            return BaoXiuShiJian;
        }

        public void setBaoXiuShiJian(String BaoXiuShiJian) {
            this.BaoXiuShiJian = BaoXiuShiJian;
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

        public String getWeiXiuRenYuanQianZi() {
            return WeiXiuRenYuanQianZi;
        }

        public void setWeiXiuRenYuanQianZi(String WeiXiuRenYuanQianZi) {
            this.WeiXiuRenYuanQianZi = WeiXiuRenYuanQianZi;
        }

        public String getGuZhangQingKuang() {
            return GuZhangQingKuang;
        }

        public void setGuZhangQingKuang(String GuZhangQingKuang) {
            this.GuZhangQingKuang = GuZhangQingKuang;
        }

        public String getBjpj() {
            return bjpj;
        }

        public void setBjpj(String bjpj) {
            this.bjpj = bjpj;
        }

        public String getWeiXiuShiJian() {
            return WeiXiuShiJian;
        }

        public void setWeiXiuShiJian(String WeiXiuShiJian) {
            this.WeiXiuShiJian = WeiXiuShiJian;
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
         * destType : task
         * destination : 信息技术部
         * name : 信息技术部
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
