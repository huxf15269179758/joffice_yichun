package com.hy.powerplatform.oa_flow.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/2/11.
 */

public class MyWorkPurchase implements Serializable {


    /**
     * success : true
     * mainform : [{"xuhao1":"","xuhao2":"","chanpinmingcheng5":"","xuhao3":"","xuhao4":"","shuliang3":"","xuhao5":"","chanpinmingcheng2":"","chanpinmingcheng1":"","shuliang4":"","shuliang1":"18","chanpinmingcheng4":"","shuliang2":"","chanpinmingcheng3":"","bmDid":"378","shuliang5":"","runId":51440,"bm":"宜春公交集团有限公司","mainId":14,"sqrq":"2019-02-14","sqrUId":"1432","hejije":"0","QiTa":"","jine2":"","sqr":"张敏","jine3":"","jine4":"","danjia5":"","jine5":"","$type$":"WF_bangongyongpincaigoushenqingdanxin","danjia4":"","danjia3":"","danjia2":"","danjia1":"2","jine1":"36","fgldyj":"","hejisl":"0","danwei1":"","bmyj":"","xiangguanfujian":"","caigouleixing":"","zjlyj":"","danwei2":"","danwei3":"","bmfzryj":"","danwei4":"","danwei5":""}]
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
         * xuhao1 :
         * xuhao2 :
         * chanpinmingcheng5 :
         * xuhao3 :
         * xuhao4 :
         * shuliang3 :
         * xuhao5 :
         * chanpinmingcheng2 :
         * chanpinmingcheng1 :
         * shuliang4 :
         * shuliang1 : 18
         * chanpinmingcheng4 :
         * shuliang2 :
         * chanpinmingcheng3 :
         * bmDid : 378
         * shuliang5 :
         * runId : 51440
         * bm : 宜春公交集团有限公司
         * mainId : 14
         * sqrq : 2019-02-14
         * sqrUId : 1432
         * hejije : 0
         * QiTa :
         * jine2 :
         * sqr : 张敏
         * jine3 :
         * jine4 :
         * danjia5 :
         * jine5 :
         * $type$ : WF_bangongyongpincaigoushenqingdanxin
         * danjia4 :
         * danjia3 :
         * danjia2 :
         * danjia1 : 2
         * jine1 : 36
         * fgldyj :
         * hejisl : 0
         * danwei1 :
         * bmyj :
         * xiangguanfujian :
         * caigouleixing :
         * zjlyj :
         * danwei2 :
         * danwei3 :
         * bmfzryj :
         * danwei4 :
         * danwei5 :
         */

        private String xuhao1;
        private String xuhao2;
        private String chanpinmingcheng5;
        private String xuhao3;
        private String xuhao4;
        private String shuliang3;
        private String xuhao5;
        private String chanpinmingcheng2;
        private String chanpinmingcheng1;
        private String shuliang4;
        private String shuliang1;
        private String chanpinmingcheng4;
        private String shuliang2;
        private String chanpinmingcheng3;
        private String bmDid;
        private String shuliang5;
        private String runId;
        private String bm;
        private int mainId;
        private String sqrq;
        private String sqrUId;
        private String hejije;
        private String QiTa;
        private String jine2;
        private String sqr;
        private String jine3;
        private String jine4;
        private String danjia5;
        private String jine5;
        private String $type$;
        private String danjia4;
        private String danjia3;
        private String danjia2;
        private String danjia1;
        private String jine1;
        private String fgldyj;
        private String hejisl;
        private String danwei1;
        private String bmyj;
        private String xiangguanfujian;
        private String caigouleixing;
        private String zjlyj;
        private String danwei2;
        private String danwei3;
        private String bmfzryj;
        private String danwei4;
        private String danwei5;

        public String getXuhao1() {
            return xuhao1;
        }

        public void setXuhao1(String xuhao1) {
            this.xuhao1 = xuhao1;
        }

        public String getXuhao2() {
            return xuhao2;
        }

        public void setXuhao2(String xuhao2) {
            this.xuhao2 = xuhao2;
        }

        public String getChanpinmingcheng5() {
            return chanpinmingcheng5;
        }

        public void setChanpinmingcheng5(String chanpinmingcheng5) {
            this.chanpinmingcheng5 = chanpinmingcheng5;
        }

        public String getXuhao3() {
            return xuhao3;
        }

        public void setXuhao3(String xuhao3) {
            this.xuhao3 = xuhao3;
        }

        public String getXuhao4() {
            return xuhao4;
        }

        public void setXuhao4(String xuhao4) {
            this.xuhao4 = xuhao4;
        }

        public String getShuliang3() {
            return shuliang3;
        }

        public void setShuliang3(String shuliang3) {
            this.shuliang3 = shuliang3;
        }

        public String getXuhao5() {
            return xuhao5;
        }

        public void setXuhao5(String xuhao5) {
            this.xuhao5 = xuhao5;
        }

        public String getChanpinmingcheng2() {
            return chanpinmingcheng2;
        }

        public void setChanpinmingcheng2(String chanpinmingcheng2) {
            this.chanpinmingcheng2 = chanpinmingcheng2;
        }

        public String getChanpinmingcheng1() {
            return chanpinmingcheng1;
        }

        public void setChanpinmingcheng1(String chanpinmingcheng1) {
            this.chanpinmingcheng1 = chanpinmingcheng1;
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

        public String getChanpinmingcheng4() {
            return chanpinmingcheng4;
        }

        public void setChanpinmingcheng4(String chanpinmingcheng4) {
            this.chanpinmingcheng4 = chanpinmingcheng4;
        }

        public String getShuliang2() {
            return shuliang2;
        }

        public void setShuliang2(String shuliang2) {
            this.shuliang2 = shuliang2;
        }

        public String getChanpinmingcheng3() {
            return chanpinmingcheng3;
        }

        public void setChanpinmingcheng3(String chanpinmingcheng3) {
            this.chanpinmingcheng3 = chanpinmingcheng3;
        }

        public String getBmDid() {
            return bmDid;
        }

        public void setBmDid(String bmDid) {
            this.bmDid = bmDid;
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

        public String getJine2() {
            return jine2;
        }

        public void setJine2(String jine2) {
            this.jine2 = jine2;
        }

        public String getSqr() {
            return sqr;
        }

        public void setSqr(String sqr) {
            this.sqr = sqr;
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

        public String getJine5() {
            return jine5;
        }

        public void setJine5(String jine5) {
            this.jine5 = jine5;
        }

        public String get$type$() {
            return $type$;
        }

        public void set$type$(String $type$) {
            this.$type$ = $type$;
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

        public String getDanjia1() {
            return danjia1;
        }

        public void setDanjia1(String danjia1) {
            this.danjia1 = danjia1;
        }

        public String getJine1() {
            return jine1;
        }

        public void setJine1(String jine1) {
            this.jine1 = jine1;
        }

        public String getFgldyj() {
            return fgldyj;
        }

        public void setFgldyj(String fgldyj) {
            this.fgldyj = fgldyj;
        }

        public String getHejisl() {
            return hejisl;
        }

        public void setHejisl(String hejisl) {
            this.hejisl = hejisl;
        }

        public String getDanwei1() {
            return danwei1;
        }

        public void setDanwei1(String danwei1) {
            this.danwei1 = danwei1;
        }

        public String getBmyj() {
            return bmyj;
        }

        public void setBmyj(String bmyj) {
            this.bmyj = bmyj;
        }

        public String getXiangguanfujian() {
            return xiangguanfujian;
        }

        public void setXiangguanfujian(String xiangguanfujian) {
            this.xiangguanfujian = xiangguanfujian;
        }

        public String getCaigouleixing() {
            return caigouleixing;
        }

        public void setCaigouleixing(String caigouleixing) {
            this.caigouleixing = caigouleixing;
        }

        public String getZjlyj() {
            return zjlyj;
        }

        public void setZjlyj(String zjlyj) {
            this.zjlyj = zjlyj;
        }

        public String getDanwei2() {
            return danwei2;
        }

        public void setDanwei2(String danwei2) {
            this.danwei2 = danwei2;
        }

        public String getDanwei3() {
            return danwei3;
        }

        public void setDanwei3(String danwei3) {
            this.danwei3 = danwei3;
        }

        public String getBmfzryj() {
            return bmfzryj;
        }

        public void setBmfzryj(String bmfzryj) {
            this.bmfzryj = bmfzryj;
        }

        public String getDanwei4() {
            return danwei4;
        }

        public void setDanwei4(String danwei4) {
            this.danwei4 = danwei4;
        }

        public String getDanwei5() {
            return danwei5;
        }

        public void setDanwei5(String danwei5) {
            this.danwei5 = danwei5;
        }
    }
}
