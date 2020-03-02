package com.hy.powerplatform.oa_flow.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/4/9.
 */

public class FlowGHContractSignDetail implements Serializable {

    /**
     * success : true
     * mainform : [{"jcbmyj":"","runId":51644,"$type$":"WF_dwhtqdspd","flgwyj":"","jbqk":"测试名称","cbbm":"宜春公交集团有限公司","htmc":"测试事由","xiangguanfujian":"","mainId":7,"cwsjbyj":"","cbbmfzr":"超级管理员","spsj":"2019-04-09","ghzx":"","bmfzryj":"[{\"ui\":\"9354\",\"un\":\"欧阳晓林\",\"c\":\"2019-04-09 13:07\",\"v\":\"同意\"}]"}]
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
         * jcbmyj :
         * runId : 51644
         * $type$ : WF_dwhtqdspd
         * flgwyj :
         * jbqk : 测试名称
         * cbbm : 宜春公交集团有限公司
         * htmc : 测试事由
         * xiangguanfujian :
         * mainId : 7
         * cwsjbyj :
         * cbbmfzr : 超级管理员
         * spsj : 2019-04-09
         * ghzx :
         * bmfzryj : [{"ui":"9354","un":"欧阳晓林","c":"2019-04-09 13:07","v":"同意"}]
         */

        private String jcbmyj;
        private String runId;
        private String $type$;
        private String flgwyj;
        private String jbqk;
        private String cbbm;
        private String htmc;
        private String xiangguanfujian;
        private int mainId;
        private String cwsjbyj;
        private String cbbmfzr;
        private String spsj;
        private String ghzx;
        private String bmfzryj;

        public String getJcbmyj() {
            return jcbmyj;
        }

        public void setJcbmyj(String jcbmyj) {
            this.jcbmyj = jcbmyj;
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

        public String getFlgwyj() {
            return flgwyj;
        }

        public void setFlgwyj(String flgwyj) {
            this.flgwyj = flgwyj;
        }

        public String getJbqk() {
            return jbqk;
        }

        public void setJbqk(String jbqk) {
            this.jbqk = jbqk;
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

        public String getCwsjbyj() {
            return cwsjbyj;
        }

        public void setCwsjbyj(String cwsjbyj) {
            this.cwsjbyj = cwsjbyj;
        }

        public String getCbbmfzr() {
            return cbbmfzr;
        }

        public void setCbbmfzr(String cbbmfzr) {
            this.cbbmfzr = cbbmfzr;
        }

        public String getSpsj() {
            return spsj;
        }

        public void setSpsj(String spsj) {
            this.spsj = spsj;
        }

        public String getGhzx() {
            return ghzx;
        }

        public void setGhzx(String ghzx) {
            this.ghzx = ghzx;
        }

        public String getBmfzryj() {
            return bmfzryj;
        }

        public void setBmfzryj(String bmfzryj) {
            this.bmfzryj = bmfzryj;
        }
    }
}
