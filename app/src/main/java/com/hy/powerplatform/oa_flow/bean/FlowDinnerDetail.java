package com.hy.powerplatform.oa_flow.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/2/20.
 */

public class FlowDinnerDetail implements Serializable {

    /**
     * success : true
     * mainform : [{"sqbm":"宜春公交集团有限公司","jine":"五十","ycfydx":"","sqr":"欧阳晓林","runId":51464,"$type$":"WF_jdycspb","pcry":"测试","lkrs":"6","fgldyj":"","lkdwhbm":"测试单位","xiangguanfujian":"","mainId":10009,"ycbz":"500","zjlyj":"","ycfyxx":"","xiaoxie":"50","bmfzryj":""}]
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
         * sqbm : 宜春公交集团有限公司
         * jine : 五十
         * ycfydx :
         * sqr : 欧阳晓林
         * runId : 51464
         * $type$ : WF_jdycspb
         * pcry : 测试
         * lkrs : 6
         * fgldyj :
         * lkdwhbm : 测试单位
         * xiangguanfujian :
         * mainId : 10009
         * ycbz : 500
         * zjlyj :
         * ycfyxx :
         * xiaoxie : 50
         * bmfzryj :
         */

        private String sqbm;
        private String jine;
        private String ycfydx;
        private String sqr;
        private String runId;
        private String $type$;
        private String pcry;
        private String lkrs;
        private String fgldyj;
        private String lkdwhbm;
        private String xiangguanfujian;
        private int mainId;
        private String ycbz;
        private String zjlyj;
        private String ycfyxx;
        private String xiaoxie;
        private String bmfzryj;

        public String getSqbm() {
            return sqbm;
        }

        public void setSqbm(String sqbm) {
            this.sqbm = sqbm;
        }

        public String getJine() {
            return jine;
        }

        public void setJine(String jine) {
            this.jine = jine;
        }

        public String getYcfydx() {
            return ycfydx;
        }

        public void setYcfydx(String ycfydx) {
            this.ycfydx = ycfydx;
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

        public String getPcry() {
            return pcry;
        }

        public void setPcry(String pcry) {
            this.pcry = pcry;
        }

        public String getLkrs() {
            return lkrs;
        }

        public void setLkrs(String lkrs) {
            this.lkrs = lkrs;
        }

        public String getFgldyj() {
            return fgldyj;
        }

        public void setFgldyj(String fgldyj) {
            this.fgldyj = fgldyj;
        }

        public String getLkdwhbm() {
            return lkdwhbm;
        }

        public void setLkdwhbm(String lkdwhbm) {
            this.lkdwhbm = lkdwhbm;
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

        public String getYcbz() {
            return ycbz;
        }

        public void setYcbz(String ycbz) {
            this.ycbz = ycbz;
        }

        public String getZjlyj() {
            return zjlyj;
        }

        public void setZjlyj(String zjlyj) {
            this.zjlyj = zjlyj;
        }

        public String getYcfyxx() {
            return ycfyxx;
        }

        public void setYcfyxx(String ycfyxx) {
            this.ycfyxx = ycfyxx;
        }

        public String getXiaoxie() {
            return xiaoxie;
        }

        public void setXiaoxie(String xiaoxie) {
            this.xiaoxie = xiaoxie;
        }

        public String getBmfzryj() {
            return bmfzryj;
        }

        public void setBmfzryj(String bmfzryj) {
            this.bmfzryj = bmfzryj;
        }
    }
}
