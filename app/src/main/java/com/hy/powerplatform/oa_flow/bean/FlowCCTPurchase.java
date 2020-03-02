package com.hy.powerplatform.oa_flow.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/4/8.
 */

public class FlowCCTPurchase implements Serializable {

    /**
     * success : true
     * mainform : [{"shuliang3":"","shuliang4":"","shuliang1":"1","xgfj":"","shuliang2":"2","shuliang5":"","runId":51601,"mingcheng1":"啊","mingcheng3":"","hejidj":"","mingcheng2":"李","mingcheng4":"","mingcheng5":"","bm":"宜春公交集团有限公司","mainId":4,"sqrq":"2019-04-08","hejije":"5.0","QiTa":"其他","sqr":"超级管理员","jine2":"4.0","jine3":"","jine4":"","danjia5":"","$type$":"WF_CCTKJYXGSWPCGJHB","jine5":"","danjia4":"","danjia3":"","danjia2":"2","fgldyj":"","jine1":"1.0","danjia1":"1","hejisl":"3","yt":"用途","bmfzryj":"","LiuShuiHao":""}]
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
         * shuliang3 :
         * shuliang4 :
         * shuliang1 : 1
         * xgfj :
         * shuliang2 : 2
         * shuliang5 :
         * runId : 51601
         * mingcheng1 : 啊
         * mingcheng3 :
         * hejidj :
         * mingcheng2 : 李
         * mingcheng4 :
         * mingcheng5 :
         * bm : 宜春公交集团有限公司
         * mainId : 4
         * sqrq : 2019-04-08
         * hejije : 5.0
         * QiTa : 其他
         * sqr : 超级管理员
         * jine2 : 4.0
         * jine3 :
         * jine4 :
         * danjia5 :
         * $type$ : WF_CCTKJYXGSWPCGJHB
         * jine5 :
         * danjia4 :
         * danjia3 :
         * danjia2 : 2
         * fgldyj :
         * jine1 : 1.0
         * danjia1 : 1
         * hejisl : 3
         * yt : 用途
         * bmfzryj :
         * LiuShuiHao :
         */

        private String shuliang3;
        private String shuliang4;
        private String shuliang1;
        private String xgfj;
        private String shuliang2;
        private String shuliang5;
        private String runId;
        private String mingcheng1;
        private String mingcheng3;
        private String hejidj;
        private String mingcheng2;
        private String mingcheng4;
        private String mingcheng5;
        private String bm;
        private int mainId;
        private String sqrq;
        private String hejije;
        private String QiTa;
        private String sqr;
        private String jine2;
        private String jine3;
        private String jine4;
        private String danjia5;
        private String $type$;
        private String jine5;
        private String danjia4;
        private String danjia3;
        private String danjia2;
        private String fgldyj;
        private String cwzjyj;
        private String ghzx;
        private String jine1;
        private String danjia1;
        private String hejisl;
        private String yt;
        private String bmfzryj;
        private String LiuShuiHao;

        public String getCwzjyj() {
            return cwzjyj;
        }

        public void setCwzjyj(String cwzjyj) {
            this.cwzjyj = cwzjyj;
        }

        public String getGhzx() {
            return ghzx;
        }

        public void setGhzx(String ghzx) {
            this.ghzx = ghzx;
        }

        public String getShuliang3() {
            return shuliang3;
        }

        public void setShuliang3(String shuliang3) {
            this.shuliang3 = shuliang3;
        }

        public String getShuliang4() {
            return shuliang4;
        }

        public void setShuliang4(String shuliang4) {
            this.shuliang4 = shuliang4;
        }

        public String getShuliang1() {
            return shuliang1;
        }

        public void setShuliang1(String shuliang1) {
            this.shuliang1 = shuliang1;
        }

        public String getXgfj() {
            return xgfj;
        }

        public void setXgfj(String xgfj) {
            this.xgfj = xgfj;
        }

        public String getShuliang2() {
            return shuliang2;
        }

        public void setShuliang2(String shuliang2) {
            this.shuliang2 = shuliang2;
        }

        public String getShuliang5() {
            return shuliang5;
        }

        public void setShuliang5(String shuliang5) {
            this.shuliang5 = shuliang5;
        }

        public String getRunId() {
            return runId;
        }

        public void setRunId(String runId) {
            this.runId = runId;
        }

        public String getMingcheng1() {
            return mingcheng1;
        }

        public void setMingcheng1(String mingcheng1) {
            this.mingcheng1 = mingcheng1;
        }

        public String getMingcheng3() {
            return mingcheng3;
        }

        public void setMingcheng3(String mingcheng3) {
            this.mingcheng3 = mingcheng3;
        }

        public String getHejidj() {
            return hejidj;
        }

        public void setHejidj(String hejidj) {
            this.hejidj = hejidj;
        }

        public String getMingcheng2() {
            return mingcheng2;
        }

        public void setMingcheng2(String mingcheng2) {
            this.mingcheng2 = mingcheng2;
        }

        public String getMingcheng4() {
            return mingcheng4;
        }

        public void setMingcheng4(String mingcheng4) {
            this.mingcheng4 = mingcheng4;
        }

        public String getMingcheng5() {
            return mingcheng5;
        }

        public void setMingcheng5(String mingcheng5) {
            this.mingcheng5 = mingcheng5;
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

        public String getHejije() {
            return hejije;
        }

        public void setHejije(String hejije) {
            this.hejije = hejije;
        }

        public String getQiTa() {
            return QiTa;
        }

        public void setQiTa(String QiTa) {
            this.QiTa = QiTa;
        }

        public String getSqr() {
            return sqr;
        }

        public void setSqr(String sqr) {
            this.sqr = sqr;
        }

        public String getJine2() {
            return jine2;
        }

        public void setJine2(String jine2) {
            this.jine2 = jine2;
        }

        public String getJine3() {
            return jine3;
        }

        public void setJine3(String jine3) {
            this.jine3 = jine3;
        }

        public String getJine4() {
            return jine4;
        }

        public void setJine4(String jine4) {
            this.jine4 = jine4;
        }

        public String getDanjia5() {
            return danjia5;
        }

        public void setDanjia5(String danjia5) {
            this.danjia5 = danjia5;
        }

        public String get$type$() {
            return $type$;
        }

        public void set$type$(String $type$) {
            this.$type$ = $type$;
        }

        public String getJine5() {
            return jine5;
        }

        public void setJine5(String jine5) {
            this.jine5 = jine5;
        }

        public String getDanjia4() {
            return danjia4;
        }

        public void setDanjia4(String danjia4) {
            this.danjia4 = danjia4;
        }

        public String getDanjia3() {
            return danjia3;
        }

        public void setDanjia3(String danjia3) {
            this.danjia3 = danjia3;
        }

        public String getDanjia2() {
            return danjia2;
        }

        public void setDanjia2(String danjia2) {
            this.danjia2 = danjia2;
        }

        public String getFgldyj() {
            return fgldyj;
        }

        public void setFgldyj(String fgldyj) {
            this.fgldyj = fgldyj;
        }

        public String getJine1() {
            return jine1;
        }

        public void setJine1(String jine1) {
            this.jine1 = jine1;
        }

        public String getDanjia1() {
            return danjia1;
        }

        public void setDanjia1(String danjia1) {
            this.danjia1 = danjia1;
        }

        public String getHejisl() {
            return hejisl;
        }

        public void setHejisl(String hejisl) {
            this.hejisl = hejisl;
        }

        public String getYt() {
            return yt;
        }

        public void setYt(String yt) {
            this.yt = yt;
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
}
