package com.hy.powerplatform.oa_flow.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/2/21.
 */

public class FlowInstallDetail implements Serializable {


    /**
     * success : true
     * mainform : [{"BanJieQingKuangYuPingJia":"","runId":51706,"wczt":"已完成","$type$":"WF_ycsgjjtazgzxmsbb","jbfgldyj":"[{\"ui\":\"9390\",\"un\":\"李健\",\"c\":\"2019-05-13 09:06\",\"v\":\"同意\"}]","BanJieRen":"","fgldyj":"[{\"ui\":\"153\",\"un\":\"袁斌\",\"c\":\"2019-04-30 15:24\",\"v\":\"属实\"}]","ShenBanBuMen":"营运二分公司","ShenBanShiJian":"2019-04-30","xiangguanfujian":"","bjap":"","mainId":30,"ShenBanShiXiang":"南站场站需要加设进出站减速带和场站内需要加两个消防栓。","BanJieShiJian":"","zjlyj":"","jbbmyj":"[{\"ui\":\"9467\",\"un\":\"易睿\",\"c\":\"2019-05-13 09:08\",\"v\":\"已安排进行加装改造\"}]","bjpj":"","BanJieJiHuaAnPai":"","bmfzryj":"[{\"ui\":\"9408\",\"un\":\"余清华\",\"c\":\"2019-04-30 15:23\",\"v\":\"请领导审批！\"}]","LiuShuiHao":"No.20190430032","ShenBanBuMenYiJian":""}]
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
         * BanJieQingKuangYuPingJia :
         * runId : 51706
         * wczt : 已完成
         * $type$ : WF_ycsgjjtazgzxmsbb
         * jbfgldyj : [{"ui":"9390","un":"李健","c":"2019-05-13 09:06","v":"同意"}]
         * BanJieRen :
         * fgldyj : [{"ui":"153","un":"袁斌","c":"2019-04-30 15:24","v":"属实"}]
         * ShenBanBuMen : 营运二分公司
         * ShenBanShiJian : 2019-04-30
         * xiangguanfujian :
         * bjap :
         * mainId : 30
         * ShenBanShiXiang : 南站场站需要加设进出站减速带和场站内需要加两个消防栓。
         * BanJieShiJian :
         * zjlyj :
         * jbbmyj : [{"ui":"9467","un":"易睿","c":"2019-05-13 09:08","v":"已安排进行加装改造"}]
         * bjpj :
         * BanJieJiHuaAnPai :
         * bmfzryj : [{"ui":"9408","un":"余清华","c":"2019-04-30 15:23","v":"请领导审批！"}]
         * LiuShuiHao : No.20190430032
         * ShenBanBuMenYiJian :
         */

        private String BanJieQingKuangYuPingJia;
        private String runId;
        private String wczt;
        private String $type$;
        private String jbfgldyj;
        private String BanJieRen;
        private String fgldyj;
        private String ShenBanBuMen;
        private String ShenBanShiJian;
        private String xiangguanfujian;
        private String bjap;
        private int mainId;
        private String ShenBanShiXiang;
        private String BanJieShiJian;
        private String zjlyj;
        private String jbbmyj;
        private String bjpj;
        private String BanJieJiHuaAnPai;
        private String bmfzryj;
        private String LiuShuiHao;
        private String ShenBanBuMenYiJian;
        private String yusuan;

        public String getYusuan() {
            return yusuan;
        }

        public void setYusuan(String yusuan) {
            this.yusuan = yusuan;
        }

        public String getBanJieQingKuangYuPingJia() {
            return BanJieQingKuangYuPingJia;
        }

        public void setBanJieQingKuangYuPingJia(String BanJieQingKuangYuPingJia) {
            this.BanJieQingKuangYuPingJia = BanJieQingKuangYuPingJia;
        }

        public String getRunId() {
            return runId;
        }

        public void setRunId(String runId) {
            this.runId = runId;
        }

        public String getWczt() {
            return wczt;
        }

        public void setWczt(String wczt) {
            this.wczt = wczt;
        }

        public String get$type$() {
            return $type$;
        }

        public void set$type$(String $type$) {
            this.$type$ = $type$;
        }

        public String getJbfgldyj() {
            return jbfgldyj;
        }

        public void setJbfgldyj(String jbfgldyj) {
            this.jbfgldyj = jbfgldyj;
        }

        public String getBanJieRen() {
            return BanJieRen;
        }

        public void setBanJieRen(String BanJieRen) {
            this.BanJieRen = BanJieRen;
        }

        public String getFgldyj() {
            return fgldyj;
        }

        public void setFgldyj(String fgldyj) {
            this.fgldyj = fgldyj;
        }

        public String getShenBanBuMen() {
            return ShenBanBuMen;
        }

        public void setShenBanBuMen(String ShenBanBuMen) {
            this.ShenBanBuMen = ShenBanBuMen;
        }

        public String getShenBanShiJian() {
            return ShenBanShiJian;
        }

        public void setShenBanShiJian(String ShenBanShiJian) {
            this.ShenBanShiJian = ShenBanShiJian;
        }

        public String getXiangguanfujian() {
            return xiangguanfujian;
        }

        public void setXiangguanfujian(String xiangguanfujian) {
            this.xiangguanfujian = xiangguanfujian;
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

        public String getShenBanShiXiang() {
            return ShenBanShiXiang;
        }

        public void setShenBanShiXiang(String ShenBanShiXiang) {
            this.ShenBanShiXiang = ShenBanShiXiang;
        }

        public String getBanJieShiJian() {
            return BanJieShiJian;
        }

        public void setBanJieShiJian(String BanJieShiJian) {
            this.BanJieShiJian = BanJieShiJian;
        }

        public String getZjlyj() {
            return zjlyj;
        }

        public void setZjlyj(String zjlyj) {
            this.zjlyj = zjlyj;
        }

        public String getJbbmyj() {
            return jbbmyj;
        }

        public void setJbbmyj(String jbbmyj) {
            this.jbbmyj = jbbmyj;
        }

        public String getBjpj() {
            return bjpj;
        }

        public void setBjpj(String bjpj) {
            this.bjpj = bjpj;
        }

        public String getBanJieJiHuaAnPai() {
            return BanJieJiHuaAnPai;
        }

        public void setBanJieJiHuaAnPai(String BanJieJiHuaAnPai) {
            this.BanJieJiHuaAnPai = BanJieJiHuaAnPai;
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

        public String getShenBanBuMenYiJian() {
            return ShenBanBuMenYiJian;
        }

        public void setShenBanBuMenYiJian(String ShenBanBuMenYiJian) {
            this.ShenBanBuMenYiJian = ShenBanBuMenYiJian;
        }
    }
}
