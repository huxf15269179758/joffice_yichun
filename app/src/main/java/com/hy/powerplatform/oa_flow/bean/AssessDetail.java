package com.hy.powerplatform.oa_flow.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2020/2/24.
 */

public class AssessDetail implements Serializable {

    /**
     * success : true
     * mainform : [{"xm":"罗乐军","sfzh":"362201196706180436","bumen":"充电公司","runId":52597,"$type$":"WF_ygrzlcb","zjcx":"A1,A2,D","xxjsbyj":"","cctkjyxgsyj":"","lxdh":"13707958173","xiangguanfujian":"","mainId":7,"cwsjbyj":"","xmUId":"","xb":"男","gonghao":"","jbbmyj":"","LiuShuiHao":"No.20200224009"}]
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

    public static class MainformBean implements Serializable {
        /**
         * xm : 罗乐军
         * sfzh : 362201196706180436
         * bumen : 充电公司
         * runId : 52597
         * $type$ : WF_ygrzlcb
         * zjcx : A1,A2,D
         * xxjsbyj :
         * cctkjyxgsyj :
         * lxdh : 13707958173
         * xiangguanfujian :
         * mainId : 7
         * cwsjbyj :
         * xmUId :
         * xb : 男
         * gonghao :
         * jbbmyj :
         * LiuShuiHao : No.20200224009
         */

        private String xm;
        private String sfzh;
        private String bumen;
        private String runId;
        private String $type$;
        private String zjcx;
        private String xxjsbyj;
        private String cctkjyxgsyj;
        private String lxdh;
        private String xiangguanfujian;
        private int mainId;
        private String cwsjbyj;
        private String xmUId;
        private String xb;
        private String gonghao;
        private String jbbmyj;
        private String LiuShuiHao;

        public String getXm() {
            return xm;
        }

        public void setXm(String xm) {
            this.xm = xm;
        }

        public String getSfzh() {
            return sfzh;
        }

        public void setSfzh(String sfzh) {
            this.sfzh = sfzh;
        }

        public String getBumen() {
            return bumen;
        }

        public void setBumen(String bumen) {
            this.bumen = bumen;
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

        public String getZjcx() {
            return zjcx;
        }

        public void setZjcx(String zjcx) {
            this.zjcx = zjcx;
        }

        public String getXxjsbyj() {
            return xxjsbyj;
        }

        public void setXxjsbyj(String xxjsbyj) {
            this.xxjsbyj = xxjsbyj;
        }

        public String getCctkjyxgsyj() {
            return cctkjyxgsyj;
        }

        public void setCctkjyxgsyj(String cctkjyxgsyj) {
            this.cctkjyxgsyj = cctkjyxgsyj;
        }

        public String getLxdh() {
            return lxdh;
        }

        public void setLxdh(String lxdh) {
            this.lxdh = lxdh;
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

        public String getXmUId() {
            return xmUId;
        }

        public void setXmUId(String xmUId) {
            this.xmUId = xmUId;
        }

        public String getXb() {
            return xb;
        }

        public void setXb(String xb) {
            this.xb = xb;
        }

        public String getGonghao() {
            return gonghao;
        }

        public void setGonghao(String gonghao) {
            this.gonghao = gonghao;
        }

        public String getJbbmyj() {
            return jbbmyj;
        }

        public void setJbbmyj(String jbbmyj) {
            this.jbbmyj = jbbmyj;
        }

        public String getLiuShuiHao() {
            return LiuShuiHao;
        }

        public void setLiuShuiHao(String LiuShuiHao) {
            this.LiuShuiHao = LiuShuiHao;
        }
    }
}
