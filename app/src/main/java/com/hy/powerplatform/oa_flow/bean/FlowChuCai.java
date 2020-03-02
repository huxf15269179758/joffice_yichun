package com.hy.powerplatform.oa_flow.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/2/2.
 */

public class FlowChuCai implements Serializable {

    /**
     * success : true
     * taskId : 7990029
     * pkValue : mainId
     * formRights : {'fgldyj':'1','jtgj4':'1','jtgj3':'1','jiezhiriqi':'1','bmfzryj':'2','sbbm':'1','zjxj':'1','sqsj':'1','ccrq':'1','ccdd':'1','chuchairenyuan':'1','jtgj1':'1','yqh':'1','jtgj2':'1','zjlyj':'1','ccsy':'1','mudidi':'1','tujing':'1','yjfy':'1','ccts':'1','keshuru':'1','xiangguanfujian':'1'}
     * mainform : [{"sbbmDid":"378","zjxj":"3000","mudidi":"测试c","runId":51336,"chuchairenyuan":"超级管理员","mainId":10009,"jiezhiriqi":"2019-02-08","yjfy":"2000","keshuru":"","sbbm":"宜春公交集团有限公司","jtgj2":"","tujing":"测试b","jtgj1":"on","yqh":"","jtgj4":"","jtgj3":"","$type$":"WF_chuchaishenqingshenpi","ccsy":"测试app 测试app","ccdd":"测试a","fgldyj":"","ccrq":"2019-02-02","sqsj":"2019-02-02","ccts":"6","xiangguanfujian":"","chuchairenyuanUId":"888888888","zjlyj":"","bmfzryj":""}]
     * formDefId : 67
     * preTaskName :
     * isSignTask : false
     * trans : [{"destType":"task","destination":"分管领导意见","name":"to 分管领导意见","source":"部门负责人"}]
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
         * sbbmDid : 378
         * zjxj : 3000
         * mudidi : 测试c
         * runId : 51336
         * chuchairenyuan : 超级管理员
         * mainId : 10009
         * jiezhiriqi : 2019-02-08
         * yjfy : 2000
         * keshuru :
         * sbbm : 宜春公交集团有限公司
         * jtgj2 :
         * tujing : 测试b
         * jtgj1 : on
         * yqh :
         * jtgj4 :
         * jtgj3 :
         * $type$ : WF_chuchaishenqingshenpi
         * ccsy : 测试app 测试app
         * ccdd : 测试a
         * fgldyj :
         * ccrq : 2019-02-02
         * sqsj : 2019-02-02
         * ccts : 6
         * xiangguanfujian :
         * chuchairenyuanUId : 888888888
         * zjlyj :
         * bmfzryj :
         */

        private String sbbmDid;
        private String zjxj;
        private String mudidi;
        private String runId;
        private String chuchairenyuan;
        private int mainId;
        private String jiezhiriqi;
        private String yjfy;
        private String keshuru;
        private String sbbm;
        private String jtgj2;
        private String tujing;
        private String jtgj1;
        private String yqh;
        private String jtgj4;
        private String jtgj3;
        private String $type$;
        private String ccsy;
        private String ccdd;
        private String fgldyj;
        private String ccrq;
        private String sqsj;
        private String ccts;
        private String xiangguanfujian;
        private String chuchairenyuanUId;
        private String cwzjyj;
        private String zjlyj;
        private String bmfzryj;

        public String getCwzjyj() {
            return cwzjyj;
        }

        public void setCwzjyj(String cwzjyj) {
            this.cwzjyj = cwzjyj;
        }

        public String getSbbmDid() {
            return sbbmDid;
        }

        public void setSbbmDid(String sbbmDid) {
            this.sbbmDid = sbbmDid;
        }

        public String getZjxj() {
            return zjxj;
        }

        public void setZjxj(String zjxj) {
            this.zjxj = zjxj;
        }

        public String getMudidi() {
            return mudidi;
        }

        public void setMudidi(String mudidi) {
            this.mudidi = mudidi;
        }

        public String getRunId() {
            return runId;
        }

        public void setRunId(String runId) {
            this.runId = runId;
        }

        public String getChuchairenyuan() {
            return chuchairenyuan;
        }

        public void setChuchairenyuan(String chuchairenyuan) {
            this.chuchairenyuan = chuchairenyuan;
        }

        public int getMainId() {
            return mainId;
        }

        public void setMainId(int mainId) {
            this.mainId = mainId;
        }

        public String getJiezhiriqi() {
            return jiezhiriqi;
        }

        public void setJiezhiriqi(String jiezhiriqi) {
            this.jiezhiriqi = jiezhiriqi;
        }

        public String getYjfy() {
            return yjfy;
        }

        public void setYjfy(String yjfy) {
            this.yjfy = yjfy;
        }

        public String getKeshuru() {
            return keshuru;
        }

        public void setKeshuru(String keshuru) {
            this.keshuru = keshuru;
        }

        public String getSbbm() {
            return sbbm;
        }

        public void setSbbm(String sbbm) {
            this.sbbm = sbbm;
        }

        public String getJtgj2() {
            return jtgj2;
        }

        public void setJtgj2(String jtgj2) {
            this.jtgj2 = jtgj2;
        }

        public String getTujing() {
            return tujing;
        }

        public void setTujing(String tujing) {
            this.tujing = tujing;
        }

        public String getJtgj1() {
            return jtgj1;
        }

        public void setJtgj1(String jtgj1) {
            this.jtgj1 = jtgj1;
        }

        public String getYqh() {
            return yqh;
        }

        public void setYqh(String yqh) {
            this.yqh = yqh;
        }

        public String getJtgj4() {
            return jtgj4;
        }

        public void setJtgj4(String jtgj4) {
            this.jtgj4 = jtgj4;
        }

        public String getJtgj3() {
            return jtgj3;
        }

        public void setJtgj3(String jtgj3) {
            this.jtgj3 = jtgj3;
        }

        public String get$type$() {
            return $type$;
        }

        public void set$type$(String $type$) {
            this.$type$ = $type$;
        }

        public String getCcsy() {
            return ccsy;
        }

        public void setCcsy(String ccsy) {
            this.ccsy = ccsy;
        }

        public String getCcdd() {
            return ccdd;
        }

        public void setCcdd(String ccdd) {
            this.ccdd = ccdd;
        }

        public String getFgldyj() {
            return fgldyj;
        }

        public void setFgldyj(String fgldyj) {
            this.fgldyj = fgldyj;
        }

        public String getCcrq() {
            return ccrq;
        }

        public void setCcrq(String ccrq) {
            this.ccrq = ccrq;
        }

        public String getSqsj() {
            return sqsj;
        }

        public void setSqsj(String sqsj) {
            this.sqsj = sqsj;
        }

        public String getCcts() {
            return ccts;
        }

        public void setCcts(String ccts) {
            this.ccts = ccts;
        }

        public String getXiangguanfujian() {
            return xiangguanfujian;
        }

        public void setXiangguanfujian(String xiangguanfujian) {
            this.xiangguanfujian = xiangguanfujian;
        }

        public String getChuchairenyuanUId() {
            return chuchairenyuanUId;
        }

        public void setChuchairenyuanUId(String chuchairenyuanUId) {
            this.chuchairenyuanUId = chuchairenyuanUId;
        }

        public String getZjlyj() {
            return zjlyj;
        }

        public void setZjlyj(String zjlyj) {
            this.zjlyj = zjlyj;
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
         * destination : 分管领导意见
         * name : to 分管领导意见
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
