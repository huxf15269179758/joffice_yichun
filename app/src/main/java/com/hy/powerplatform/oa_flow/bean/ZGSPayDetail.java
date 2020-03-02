package com.hy.powerplatform.oa_flow.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/11/26.
 */

public class ZGSPayDetail implements Serializable {

    /**
     * success : true
     * mainform : [{"fkyt":"bdhdh","jine":"壹佰贰拾叁圆整","bmDid":"378","sqr":"超级管理员","runId":52308,"$type$":"WF_zgsfkcxspd","fgldyj":"","mainId":8,"bm":"宜春公交集团有限公司","sqrq":"2019-11-26","sqrUId":"888888888","skdwqc":"bbd","xiaoxie":123,"YS":"预算内","bmfzryj":"","XiangGuanFuJian":""}]
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

    public static class MainformBean implements Serializable{
        /**
         * fkyt : bdhdh
         * jine : 壹佰贰拾叁圆整
         * bmDid : 378
         * sqr : 超级管理员
         * runId : 52308
         * $type$ : WF_zgsfkcxspd
         * fgldyj :
         * mainId : 8
         * bm : 宜春公交集团有限公司
         * sqrq : 2019-11-26
         * sqrUId : 888888888
         * skdwqc : bbd
         * xiaoxie : 123
         * YS : 预算内
         * bmfzryj :
         * XiangGuanFuJian :
         */

        private String fkyt;
        private String jine;
        private String bmDid;
        private String sqr;
        private String runId;
        private String $type$;
        private String fgldyj;
        private int mainId;
        private String bm;
        private String sqrq;
        private String sqrUId;
        private String skdwqc;
        private String xiaoxie;
        private String YS;
        private String bmfzryj;
        private String XiangGuanFuJian;

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
    }
}
