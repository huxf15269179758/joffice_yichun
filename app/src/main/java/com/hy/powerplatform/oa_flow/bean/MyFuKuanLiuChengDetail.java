package com.hy.powerplatform.oa_flow.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/2/11.
 */

public class MyFuKuanLiuChengDetail implements Serializable {

    /**
     * success : true
     * mainform : [{"fkyt":"用途","jine":"五十","bmDid":"378","sqr":"欧阳晓林","cwzjyj":"","runId":51340,"$type$":"WF_FuKuanChengXUShenPi","fgldyj":"","bm":"测试部门","mainId":53,"sqrq":"2019-02-11","sqrUId":"1729","zjlyj":"","skdwqc":"","YS":"预算内","xiaoxie":"50","XiangGuanFuJian":"","bmfzryj":""}]
     */

    private boolean success;
    private List<MainformBean> mainform;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<MainformBean> getMainform() {
        return mainform;
    }

    public void setMainform(List<MainformBean> mainform) {
        this.mainform = mainform;
    }

    public static class MainformBean {
        /**
         * fkyt : 用途
         * jine : 五十
         * bmDid : 378
         * sqr : 欧阳晓林
         * cwzjyj :
         * runId : 51340
         * $type$ : WF_FuKuanChengXUShenPi
         * fgldyj :
         * bm : 测试部门
         * mainId : 53
         * sqrq : 2019-02-11
         * sqrUId : 1729
         * zjlyj :
         * skdwqc :
         * YS : 预算内
         * xiaoxie : 50
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
}
