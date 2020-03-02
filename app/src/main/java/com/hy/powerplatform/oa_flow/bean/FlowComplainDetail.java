package com.hy.powerplatform.oa_flow.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/2/20.
 */

public class FlowComplainDetail implements Serializable {


    /**
     * success : true
     * mainform : [{"YingYunFenGongSiChuLiJieGuo":"","SuoShuXianLu":"V币","runId":51610,"SuoShuFenGongSi":"营运一分公司","XingBie":"男","TouSuRenZunCheng":"","bjap":"","mainId":8,"bjpj":"","BuMenFuZeRen":"","LianXiDianHua":"5588","FenGongSiChengBanRen":"","ShouLiRen":"刘望","aqfwbyj":"","BeiTouSuChePaiHao":"不不不","$type$":"WF_AnQuanFuWuBuTouSuZhuanBanDan","TouSuRiQi":"2019-02-28","cbbmyj":"","AnQuanFuWuBuYiJian":"","xiangguanfujian":"","BeiTouSuRenXingMing":"哈哈哈","TouSuNeiRong":"要不不不不","TouSuRenXingMing":"刘望","bmfzryj":"同意","LiuShuiHao":"No.20190228140","FanKuiTouSuRenJieGuo":""}]
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
         * YingYunFenGongSiChuLiJieGuo :
         * SuoShuXianLu : V币
         * runId : 51610
         * SuoShuFenGongSi : 营运一分公司
         * XingBie : 男
         * TouSuRenZunCheng :
         * bjap :
         * mainId : 8
         * bjpj :
         * BuMenFuZeRen :
         * LianXiDianHua : 5588
         * FenGongSiChengBanRen :
         * ShouLiRen : 刘望
         * aqfwbyj :
         * BeiTouSuChePaiHao : 不不不
         * $type$ : WF_AnQuanFuWuBuTouSuZhuanBanDan
         * TouSuRiQi : 2019-02-28
         * cbbmyj :
         * AnQuanFuWuBuYiJian :
         * xiangguanfujian :
         * BeiTouSuRenXingMing : 哈哈哈
         * TouSuNeiRong : 要不不不不
         * TouSuRenXingMing : 刘望
         * bmfzryj : 同意
         * LiuShuiHao : No.20190228140
         * FanKuiTouSuRenJieGuo :
         */

        private String YingYunFenGongSiChuLiJieGuo;
        private String SuoShuXianLu;
        private String runId;
        private String SuoShuFenGongSi;
        private String XingBie;
        private String TouSuRenZunCheng;
        private String bjap;
        private int mainId;
        private String bjpj;
        private String BuMenFuZeRen;
        private String LianXiDianHua;
        private String FenGongSiChengBanRen;
        private String ShouLiRen;
        private String aqfwbyj;
        private String BeiTouSuChePaiHao;
        private String $type$;
        private String TouSuRiQi;
        private String cbbmyj;
        private String AnQuanFuWuBuYiJian;
        private String xiangguanfujian;
        private String BeiTouSuRenXingMing;
        private String TouSuNeiRong;
        private String TouSuRenXingMing;
        private String bmfzryj;
        private String LiuShuiHao;
        private String FanKuiTouSuRenJieGuo;

        public String getYingYunFenGongSiChuLiJieGuo() {
            return YingYunFenGongSiChuLiJieGuo;
        }

        public void setYingYunFenGongSiChuLiJieGuo(String YingYunFenGongSiChuLiJieGuo) {
            this.YingYunFenGongSiChuLiJieGuo = YingYunFenGongSiChuLiJieGuo;
        }

        public String getSuoShuXianLu() {
            return SuoShuXianLu;
        }

        public void setSuoShuXianLu(String SuoShuXianLu) {
            this.SuoShuXianLu = SuoShuXianLu;
        }

        public String getRunId() {
            return runId;
        }

        public void setRunId(String runId) {
            this.runId = runId;
        }

        public String getSuoShuFenGongSi() {
            return SuoShuFenGongSi;
        }

        public void setSuoShuFenGongSi(String SuoShuFenGongSi) {
            this.SuoShuFenGongSi = SuoShuFenGongSi;
        }

        public String getXingBie() {
            return XingBie;
        }

        public void setXingBie(String XingBie) {
            this.XingBie = XingBie;
        }

        public String getTouSuRenZunCheng() {
            return TouSuRenZunCheng;
        }

        public void setTouSuRenZunCheng(String TouSuRenZunCheng) {
            this.TouSuRenZunCheng = TouSuRenZunCheng;
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

        public String getBjpj() {
            return bjpj;
        }

        public void setBjpj(String bjpj) {
            this.bjpj = bjpj;
        }

        public String getBuMenFuZeRen() {
            return BuMenFuZeRen;
        }

        public void setBuMenFuZeRen(String BuMenFuZeRen) {
            this.BuMenFuZeRen = BuMenFuZeRen;
        }

        public String getLianXiDianHua() {
            return LianXiDianHua;
        }

        public void setLianXiDianHua(String LianXiDianHua) {
            this.LianXiDianHua = LianXiDianHua;
        }

        public String getFenGongSiChengBanRen() {
            return FenGongSiChengBanRen;
        }

        public void setFenGongSiChengBanRen(String FenGongSiChengBanRen) {
            this.FenGongSiChengBanRen = FenGongSiChengBanRen;
        }

        public String getShouLiRen() {
            return ShouLiRen;
        }

        public void setShouLiRen(String ShouLiRen) {
            this.ShouLiRen = ShouLiRen;
        }

        public String getAqfwbyj() {
            return aqfwbyj;
        }

        public void setAqfwbyj(String aqfwbyj) {
            this.aqfwbyj = aqfwbyj;
        }

        public String getBeiTouSuChePaiHao() {
            return BeiTouSuChePaiHao;
        }

        public void setBeiTouSuChePaiHao(String BeiTouSuChePaiHao) {
            this.BeiTouSuChePaiHao = BeiTouSuChePaiHao;
        }

        public String get$type$() {
            return $type$;
        }

        public void set$type$(String $type$) {
            this.$type$ = $type$;
        }

        public String getTouSuRiQi() {
            return TouSuRiQi;
        }

        public void setTouSuRiQi(String TouSuRiQi) {
            this.TouSuRiQi = TouSuRiQi;
        }

        public String getCbbmyj() {
            return cbbmyj;
        }

        public void setCbbmyj(String cbbmyj) {
            this.cbbmyj = cbbmyj;
        }

        public String getAnQuanFuWuBuYiJian() {
            return AnQuanFuWuBuYiJian;
        }

        public void setAnQuanFuWuBuYiJian(String AnQuanFuWuBuYiJian) {
            this.AnQuanFuWuBuYiJian = AnQuanFuWuBuYiJian;
        }

        public String getXiangguanfujian() {
            return xiangguanfujian;
        }

        public void setXiangguanfujian(String xiangguanfujian) {
            this.xiangguanfujian = xiangguanfujian;
        }

        public String getBeiTouSuRenXingMing() {
            return BeiTouSuRenXingMing;
        }

        public void setBeiTouSuRenXingMing(String BeiTouSuRenXingMing) {
            this.BeiTouSuRenXingMing = BeiTouSuRenXingMing;
        }

        public String getTouSuNeiRong() {
            return TouSuNeiRong;
        }

        public void setTouSuNeiRong(String TouSuNeiRong) {
            this.TouSuNeiRong = TouSuNeiRong;
        }

        public String getTouSuRenXingMing() {
            return TouSuRenXingMing;
        }

        public void setTouSuRenXingMing(String TouSuRenXingMing) {
            this.TouSuRenXingMing = TouSuRenXingMing;
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

        public String getFanKuiTouSuRenJieGuo() {
            return FanKuiTouSuRenJieGuo;
        }

        public void setFanKuiTouSuRenJieGuo(String FanKuiTouSuRenJieGuo) {
            this.FanKuiTouSuRenJieGuo = FanKuiTouSuRenJieGuo;
        }
    }
}
