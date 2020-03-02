package com.hy.powerplatform.oa_flow.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/3/6.
 */

public class FlowHuiQianDetail implements Serializable {

    /**
     * success : true
     * mainform : [{"xgfj":"","mainId":8,"sqr":"唐根六","sqrUId":"2399","dszyj":"","runId":51534,"jbfgldyj":"","zjlyj":"","$type$":"WF_huiqian","HuiQianShiXiang":"测代办","LiuShuiHao":"No.20190306212"}]
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
         * xgfj :
         * mainId : 8
         * sqr : 唐根六
         * sqrUId : 2399
         * dszyj :
         * runId : 51534
         * jbfgldyj :
         * zjlyj :
         * $type$ : WF_huiqian
         * HuiQianShiXiang : 测代办
         * LiuShuiHao : No.20190306212
         */

        private String xgfj;
        private int mainId;
        private String sqr;
        private String sqrUId;
        private String dszyj;
        private String runId;
        private String jbfgldyj;
        private String zjlyj;
        private String $type$;
        private String HuiQianShiXiang;
        private String LiuShuiHao;

        public String getXgfj() {
            return xgfj;
        }

        public void setXgfj(String xgfj) {
            this.xgfj = xgfj;
        }

        public int getMainId() {
            return mainId;
        }

        public void setMainId(int mainId) {
            this.mainId = mainId;
        }

        public String getSqr() {
            return sqr;
        }

        public void setSqr(String sqr) {
            this.sqr = sqr;
        }

        public String getSqrUId() {
            return sqrUId;
        }

        public void setSqrUId(String sqrUId) {
            this.sqrUId = sqrUId;
        }

        public String getDszyj() {
            return dszyj;
        }

        public void setDszyj(String dszyj) {
            this.dszyj = dszyj;
        }

        public String getRunId() {
            return runId;
        }

        public void setRunId(String runId) {
            this.runId = runId;
        }

        public String getJbfgldyj() {
            return jbfgldyj;
        }

        public void setJbfgldyj(String jbfgldyj) {
            this.jbfgldyj = jbfgldyj;
        }

        public String getZjlyj() {
            return zjlyj;
        }

        public void setZjlyj(String zjlyj) {
            this.zjlyj = zjlyj;
        }

        public String get$type$() {
            return $type$;
        }

        public void set$type$(String $type$) {
            this.$type$ = $type$;
        }

        public String getHuiQianShiXiang() {
            return HuiQianShiXiang;
        }

        public void setHuiQianShiXiang(String HuiQianShiXiang) {
            this.HuiQianShiXiang = HuiQianShiXiang;
        }

        public String getLiuShuiHao() {
            return LiuShuiHao;
        }

        public void setLiuShuiHao(String LiuShuiHao) {
            this.LiuShuiHao = LiuShuiHao;
        }
    }
}
