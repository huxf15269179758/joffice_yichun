package com.hy.powerplatform.oa_flow.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/4/9.
 */

public class FlowGHPayDetail implements Serializable {

    /**
     * success : true
     * mainform : [{"fkyt":"测试用途","jine":"伍拾","bmDid":"378","sqr":"超级管理员","cwzjyj":"","runId":51608,"$type$":"WF_dwfkcxspd","mainId":45,"bm":"宜春公交集团有限公司","sqrq":"2019-04-09","sqrUId":"888888888","zjlyj":"","skdwqc":"测试单位","xiaoxie":"50","YS":"预算内","bmfzryj":"","XiangGuanFuJian":"","ghzx":""}]
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
         * fkyt : 测试用途
         * jine : 伍拾
         * bmDid : 378
         * sqr : 超级管理员
         * cwzjyj :
         * runId : 51608
         * $type$ : WF_dwfkcxspd
         * mainId : 45
         * bm : 宜春公交集团有限公司
         * sqrq : 2019-04-09
         * sqrUId : 888888888
         * zjlyj :
         * skdwqc : 测试单位
         * xiaoxie : 50
         * YS : 预算内
         * bmfzryj :
         * XiangGuanFuJian :
         * ghzx :
         */

        private String fkyt;
        private String jine;
        private String bmDid;
        private String sqr;
        private String cwzjyj;
        private String runId;
        private String $type$;
        private int mainId;
        private String bm;
        private String sqrq;
        private String sqrUId;
        private String zjlyj;
        private String skdwqc;
        private String xiaoxie;
        private String YS;
        private String bmfzryj;
        private String XiangGuanFuJian;
        private String ghzx;

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

        public String getGhzx() {
            return ghzx;
        }

        public void setGhzx(String ghzx) {
            this.ghzx = ghzx;
        }
    }
}
