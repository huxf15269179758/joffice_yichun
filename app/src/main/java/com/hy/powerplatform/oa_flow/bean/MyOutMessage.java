package com.hy.powerplatform.oa_flow.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/2/12.
 */

public class MyOutMessage implements Serializable {

    /**
     * success : true
     * mainform : [{"HeGaoRenUId":"1587","YinFaRiQi":"","runId":51330,"$type$":"WF_ycsggjtzgsfw","fgldyj":"[{\"ui\":\"9389\",\"un\":\"袁斌\",\"c\":\"2019-01-31 17:07\",\"v\":\"同意\"}]","FaWenFuJian":"","FaWenBiaoTi":"测试发文流程app","NiGaoRen":"苏倩","ChaoBaoRen":"发文测试","HeGaoRen":"苏倩","NiGaoRenUId":"1587","FaWenXuHao":"1","WenHaoRiQi":"1","YinFaFenShu":"2","FaWenWenHao":"7894562","mainId":4,"zjlyj":"","ChaoSongRen":"发文测试","ZhuSongRen":"发文测试"}]
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
         * HeGaoRenUId : 1587
         * YinFaRiQi :
         * runId : 51330
         * $type$ : WF_ycsggjtzgsfw
         * fgldyj : [{"ui":"9389","un":"袁斌","c":"2019-01-31 17:07","v":"同意"}]
         * FaWenFuJian :
         * FaWenBiaoTi : 测试发文流程app
         * NiGaoRen : 苏倩
         * ChaoBaoRen : 发文测试
         * HeGaoRen : 苏倩
         * NiGaoRenUId : 1587
         * FaWenXuHao : 1
         * WenHaoRiQi : 1
         * YinFaFenShu : 2
         * FaWenWenHao : 7894562
         * mainId : 4
         * zjlyj :
         * ChaoSongRen : 发文测试
         * ZhuSongRen : 发文测试
         */

        private String HeGaoRenUId;
        private String YinFaRiQi;
        private String runId;
        private String $type$;
        private String fgldyj;
        private String FaWenFuJian;
        private String FaWenBiaoTi;
        private String NiGaoRen;
        private String ChaoBaoRen;
        private String HeGaoRen;
        private String NiGaoRenUId;
        private String FaWenXuHao;
        private String WenHaoRiQi;
        private String YinFaFenShu;
        private String FaWenWenHao;
        private int mainId;
        private String zjlyj;
        private String ChaoSongRen;
        private String ZhuSongRen;

        public String getHeGaoRenUId() {
            return HeGaoRenUId;
        }

        public void setHeGaoRenUId(String HeGaoRenUId) {
            this.HeGaoRenUId = HeGaoRenUId;
        }

        public String getYinFaRiQi() {
            return YinFaRiQi;
        }

        public void setYinFaRiQi(String YinFaRiQi) {
            this.YinFaRiQi = YinFaRiQi;
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

        public String getFgldyj() {
            return fgldyj;
        }

        public void setFgldyj(String fgldyj) {
            this.fgldyj = fgldyj;
        }

        public String getFaWenFuJian() {
            return FaWenFuJian;
        }

        public void setFaWenFuJian(String FaWenFuJian) {
            this.FaWenFuJian = FaWenFuJian;
        }

        public String getFaWenBiaoTi() {
            return FaWenBiaoTi;
        }

        public void setFaWenBiaoTi(String FaWenBiaoTi) {
            this.FaWenBiaoTi = FaWenBiaoTi;
        }

        public String getNiGaoRen() {
            return NiGaoRen;
        }

        public void setNiGaoRen(String NiGaoRen) {
            this.NiGaoRen = NiGaoRen;
        }

        public String getChaoBaoRen() {
            return ChaoBaoRen;
        }

        public void setChaoBaoRen(String ChaoBaoRen) {
            this.ChaoBaoRen = ChaoBaoRen;
        }

        public String getHeGaoRen() {
            return HeGaoRen;
        }

        public void setHeGaoRen(String HeGaoRen) {
            this.HeGaoRen = HeGaoRen;
        }

        public String getNiGaoRenUId() {
            return NiGaoRenUId;
        }

        public void setNiGaoRenUId(String NiGaoRenUId) {
            this.NiGaoRenUId = NiGaoRenUId;
        }

        public String getFaWenXuHao() {
            return FaWenXuHao;
        }

        public void setFaWenXuHao(String FaWenXuHao) {
            this.FaWenXuHao = FaWenXuHao;
        }

        public String getWenHaoRiQi() {
            return WenHaoRiQi;
        }

        public void setWenHaoRiQi(String WenHaoRiQi) {
            this.WenHaoRiQi = WenHaoRiQi;
        }

        public String getYinFaFenShu() {
            return YinFaFenShu;
        }

        public void setYinFaFenShu(String YinFaFenShu) {
            this.YinFaFenShu = YinFaFenShu;
        }

        public String getFaWenWenHao() {
            return FaWenWenHao;
        }

        public void setFaWenWenHao(String FaWenWenHao) {
            this.FaWenWenHao = FaWenWenHao;
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

        public String getChaoSongRen() {
            return ChaoSongRen;
        }

        public void setChaoSongRen(String ChaoSongRen) {
            this.ChaoSongRen = ChaoSongRen;
        }

        public String getZhuSongRen() {
            return ZhuSongRen;
        }

        public void setZhuSongRen(String ZhuSongRen) {
            this.ZhuSongRen = ZhuSongRen;
        }
    }
}
