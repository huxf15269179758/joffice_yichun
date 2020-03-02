package com.hy.powerplatform.oa_flow.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/2/21.
 */

public class FlowEMaintainDetail implements Serializable {

    /**
     * success : true
     * mainform : [{"SheBeiShiYongRenQianZiUId":"","WeiXiuRenYuanQianZiUId":"","BaoXiuBuMenDid":"","jjbzbyj":"","WeiXiuQingKuang":"","runId":51482,"SheBeiShiYongRenQianZi":"","$type$":"WF_DianZiSheBeiGuZhangWeiXiuDengJiBiao","BeiZhu":"","xxjsbyj":"","BaoXiuBuMen":"","BaoXiuShiJian":"2019-02-21","bjap":"","mainId":3,"WeiXiuRenYuanQianZi":"","GuZhangQingKuang":"测试","bjpj":"","WeiXiuShiJian":"","bmfzryj":"","XiangGuanFuJian":""}]
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
         * SheBeiShiYongRenQianZiUId :
         * WeiXiuRenYuanQianZiUId :
         * BaoXiuBuMenDid :
         * jjbzbyj :
         * WeiXiuQingKuang :
         * runId : 51482
         * SheBeiShiYongRenQianZi :
         * $type$ : WF_DianZiSheBeiGuZhangWeiXiuDengJiBiao
         * BeiZhu :
         * xxjsbyj :
         * BaoXiuBuMen :
         * BaoXiuShiJian : 2019-02-21
         * bjap :
         * mainId : 3
         * WeiXiuRenYuanQianZi :
         * GuZhangQingKuang : 测试
         * bjpj :
         * WeiXiuShiJian :
         * bmfzryj :
         * XiangGuanFuJian :
         */

        private String SheBeiShiYongRenQianZiUId;
        private String WeiXiuRenYuanQianZiUId;
        private String BaoXiuBuMenDid;
        private String jjbzbyj;
        private String WeiXiuQingKuang;
        private String runId;
        private String SheBeiShiYongRenQianZi;
        private String $type$;
        private String BeiZhu;
        private String xxjsbyj;
        private String BaoXiuBuMen;
        private String BaoXiuShiJian;
        private String bjap;
        private int mainId;
        private String WeiXiuRenYuanQianZi;
        private String GuZhangQingKuang;
        private String bjpj;
        private String WeiXiuShiJian;
        private String bmfzryj;
        private String XiangGuanFuJian;

        public String getSheBeiShiYongRenQianZiUId() {
            return SheBeiShiYongRenQianZiUId;
        }

        public void setSheBeiShiYongRenQianZiUId(String SheBeiShiYongRenQianZiUId) {
            this.SheBeiShiYongRenQianZiUId = SheBeiShiYongRenQianZiUId;
        }

        public String getWeiXiuRenYuanQianZiUId() {
            return WeiXiuRenYuanQianZiUId;
        }

        public void setWeiXiuRenYuanQianZiUId(String WeiXiuRenYuanQianZiUId) {
            this.WeiXiuRenYuanQianZiUId = WeiXiuRenYuanQianZiUId;
        }

        public String getBaoXiuBuMenDid() {
            return BaoXiuBuMenDid;
        }

        public void setBaoXiuBuMenDid(String BaoXiuBuMenDid) {
            this.BaoXiuBuMenDid = BaoXiuBuMenDid;
        }

        public String getJjbzbyj() {
            return jjbzbyj;
        }

        public void setJjbzbyj(String jjbzbyj) {
            this.jjbzbyj = jjbzbyj;
        }

        public String getWeiXiuQingKuang() {
            return WeiXiuQingKuang;
        }

        public void setWeiXiuQingKuang(String WeiXiuQingKuang) {
            this.WeiXiuQingKuang = WeiXiuQingKuang;
        }

        public String getRunId() {
            return runId;
        }

        public void setRunId(String runId) {
            this.runId = runId;
        }

        public String getSheBeiShiYongRenQianZi() {
            return SheBeiShiYongRenQianZi;
        }

        public void setSheBeiShiYongRenQianZi(String SheBeiShiYongRenQianZi) {
            this.SheBeiShiYongRenQianZi = SheBeiShiYongRenQianZi;
        }

        public String get$type$() {
            return $type$;
        }

        public void set$type$(String $type$) {
            this.$type$ = $type$;
        }

        public String getBeiZhu() {
            return BeiZhu;
        }

        public void setBeiZhu(String BeiZhu) {
            this.BeiZhu = BeiZhu;
        }

        public String getXxjsbyj() {
            return xxjsbyj;
        }

        public void setXxjsbyj(String xxjsbyj) {
            this.xxjsbyj = xxjsbyj;
        }

        public String getBaoXiuBuMen() {
            return BaoXiuBuMen;
        }

        public void setBaoXiuBuMen(String BaoXiuBuMen) {
            this.BaoXiuBuMen = BaoXiuBuMen;
        }

        public String getBaoXiuShiJian() {
            return BaoXiuShiJian;
        }

        public void setBaoXiuShiJian(String BaoXiuShiJian) {
            this.BaoXiuShiJian = BaoXiuShiJian;
        }

        public String getBjap() {
            return bjap;
        }

        public void setBjap(String bjap) {
            this.bjap = bjap;
        }

        public int getMainId() {
            return mainId;
        }

        public void setMainId(int mainId) {
            this.mainId = mainId;
        }

        public String getWeiXiuRenYuanQianZi() {
            return WeiXiuRenYuanQianZi;
        }

        public void setWeiXiuRenYuanQianZi(String WeiXiuRenYuanQianZi) {
            this.WeiXiuRenYuanQianZi = WeiXiuRenYuanQianZi;
        }

        public String getGuZhangQingKuang() {
            return GuZhangQingKuang;
        }

        public void setGuZhangQingKuang(String GuZhangQingKuang) {
            this.GuZhangQingKuang = GuZhangQingKuang;
        }

        public String getBjpj() {
            return bjpj;
        }

        public void setBjpj(String bjpj) {
            this.bjpj = bjpj;
        }

        public String getWeiXiuShiJian() {
            return WeiXiuShiJian;
        }

        public void setWeiXiuShiJian(String WeiXiuShiJian) {
            this.WeiXiuShiJian = WeiXiuShiJian;
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
