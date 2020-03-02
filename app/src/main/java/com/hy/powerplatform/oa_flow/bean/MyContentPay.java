package com.hy.powerplatform.oa_flow.bean;

import java.util.List;

/**
 * Created by Administrator on 2019/2/13.
 */

public class MyContentPay {

    /**
     * success : true
     * mainform : [{"runId":51417,"$type$":"WF_HeTongFuKuanShenPi","fgcwldyj":"","fgldyj":"","cbbm":"宜春公交集团有限公司","htmc":"测试","jbqk":"计算机","jbr":"刘洋","xiangguanfujian":"","mainId":18,"zjlyj":"","spsj":"2019-02-13","bmfzryj":""}]
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
         * runId : 51417
         * $type$ : WF_HeTongFuKuanShenPi
         * fgcwldyj :
         * fgldyj :
         * cbbm : 宜春公交集团有限公司
         * htmc : 测试
         * jbqk : 计算机
         * jbr : 刘洋
         * xiangguanfujian :
         * mainId : 18
         * zjlyj :
         * spsj : 2019-02-13
         * bmfzryj :
         */

        private String runId;
        private String $type$;
        private String fgcwldyj;
        private String fgldyj;
        private String cbbm;
        private String htmc;
        private String jbqk;
        private String jbr;
        private String xiangguanfujian;
        private int mainId;
        private String zjlyj;
        private String spsj;
        private String bmfzryj;

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

        public String getFgcwldyj() {
            return fgcwldyj;
        }

        public void setFgcwldyj(String fgcwldyj) {
            this.fgcwldyj = fgcwldyj;
        }

        public String getFgldyj() {
            return fgldyj;
        }

        public void setFgldyj(String fgldyj) {
            this.fgldyj = fgldyj;
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

        public String getJbqk() {
            return jbqk;
        }

        public void setJbqk(String jbqk) {
            this.jbqk = jbqk;
        }

        public String getJbr() {
            return jbr;
        }

        public void setJbr(String jbr) {
            this.jbr = jbr;
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

        public String getZjlyj() {
            return zjlyj;
        }

        public void setZjlyj(String zjlyj) {
            this.zjlyj = zjlyj;
        }

        public String getSpsj() {
            return spsj;
        }

        public void setSpsj(String spsj) {
            this.spsj = spsj;
        }

        public String getBmfzryj() {
            return bmfzryj;
        }

        public void setBmfzryj(String bmfzryj) {
            this.bmfzryj = bmfzryj;
        }
    }
}
