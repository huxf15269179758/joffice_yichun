package com.hy.powerplatform.oa_flow.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/2/23.
 */

public class FlowSaferDetail implements Serializable {


    /**
     * success : true
     * mainform : [{"Shi":"","BaoXianJieKuan":"","Bai":"","ShiWan":"","runId":51454,"TuanTiYiWaiXianRenShu":"10","Yuan":"","mainId":1,"Wan":"","JieKuanShiJian":"2019-02-23","xiaoxie":"50","XiangGuanFuJian":"","YiWaiXianQianShu":"","jine":"五十","cwzjqz":"","cwzjyj":"","bmfzr":"","$type$":"WF_BaoXianFeiJieKuanDanShangYeXian","fgldyj":"","Fen":"","fgldqz":"","Jiao":"","Qian":"","bmfzryj":"","LiuShuiHao":"No.20190223005"}]
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
         * Shi :
         * BaoXianJieKuan :
         * Bai :
         * ShiWan :
         * runId : 51454
         * TuanTiYiWaiXianRenShu : 10
         * Yuan :
         * mainId : 1
         * Wan :
         * JieKuanShiJian : 2019-02-23
         * xiaoxie : 50
         * XiangGuanFuJian :
         * YiWaiXianQianShu :
         * jine : 五十
         * cwzjqz :
         * cwzjyj :
         * bmfzr :
         * $type$ : WF_BaoXianFeiJieKuanDanShangYeXian
         * fgldyj :
         * Fen :
         * fgldqz :
         * Jiao :
         * Qian :
         * bmfzryj :
         * LiuShuiHao : No.20190223005
         */

        private String Shi;
        private String BaoXianJieKuan;
        private String Bai;
        private String ShiWan;
        private String runId;
        private String TuanTiYiWaiXianRenShu;
        private String Yuan;
        private int mainId;
        private String Wan;
        private String JieKuanShiJian;
        private String xiaoxie;
        private String XiangGuanFuJian;
        private String YiWaiXianQianShu;
        private String jine;
        private String cwzjqz;
        private String cwzjyj;
        private String bmfzr;
        private String $type$;
        private String fgldyj;
        private String Fen;
        private String fgldqz;
        private String Jiao;
        private String Qian;
        private String bmfzryj;
        private String LiuShuiHao;

        public String getShi() {
            return Shi;
        }

        public void setShi(String Shi) {
            this.Shi = Shi;
        }

        public String getBaoXianJieKuan() {
            return BaoXianJieKuan;
        }

        public void setBaoXianJieKuan(String BaoXianJieKuan) {
            this.BaoXianJieKuan = BaoXianJieKuan;
        }

        public String getBai() {
            return Bai;
        }

        public void setBai(String Bai) {
            this.Bai = Bai;
        }

        public String getShiWan() {
            return ShiWan;
        }

        public void setShiWan(String ShiWan) {
            this.ShiWan = ShiWan;
        }

        public String getRunId() {
            return runId;
        }

        public void setRunId(String runId) {
            this.runId = runId;
        }

        public String getTuanTiYiWaiXianRenShu() {
            return TuanTiYiWaiXianRenShu;
        }

        public void setTuanTiYiWaiXianRenShu(String TuanTiYiWaiXianRenShu) {
            this.TuanTiYiWaiXianRenShu = TuanTiYiWaiXianRenShu;
        }

        public String getYuan() {
            return Yuan;
        }

        public void setYuan(String Yuan) {
            this.Yuan = Yuan;
        }

        public int getMainId() {
            return mainId;
        }

        public void setMainId(int mainId) {
            this.mainId = mainId;
        }

        public String getWan() {
            return Wan;
        }

        public void setWan(String Wan) {
            this.Wan = Wan;
        }

        public String getJieKuanShiJian() {
            return JieKuanShiJian;
        }

        public void setJieKuanShiJian(String JieKuanShiJian) {
            this.JieKuanShiJian = JieKuanShiJian;
        }

        public String getXiaoxie() {
            return xiaoxie;
        }

        public void setXiaoxie(String xiaoxie) {
            this.xiaoxie = xiaoxie;
        }

        public String getXiangGuanFuJian() {
            return XiangGuanFuJian;
        }

        public void setXiangGuanFuJian(String XiangGuanFuJian) {
            this.XiangGuanFuJian = XiangGuanFuJian;
        }

        public String getYiWaiXianQianShu() {
            return YiWaiXianQianShu;
        }

        public void setYiWaiXianQianShu(String YiWaiXianQianShu) {
            this.YiWaiXianQianShu = YiWaiXianQianShu;
        }

        public String getJine() {
            return jine;
        }

        public void setJine(String jine) {
            this.jine = jine;
        }

        public String getCwzjqz() {
            return cwzjqz;
        }

        public void setCwzjqz(String cwzjqz) {
            this.cwzjqz = cwzjqz;
        }

        public String getCwzjyj() {
            return cwzjyj;
        }

        public void setCwzjyj(String cwzjyj) {
            this.cwzjyj = cwzjyj;
        }

        public String getBmfzr() {
            return bmfzr;
        }

        public void setBmfzr(String bmfzr) {
            this.bmfzr = bmfzr;
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

        public String getFen() {
            return Fen;
        }

        public void setFen(String Fen) {
            this.Fen = Fen;
        }

        public String getFgldqz() {
            return fgldqz;
        }

        public void setFgldqz(String fgldqz) {
            this.fgldqz = fgldqz;
        }

        public String getJiao() {
            return Jiao;
        }

        public void setJiao(String Jiao) {
            this.Jiao = Jiao;
        }

        public String getQian() {
            return Qian;
        }

        public void setQian(String Qian) {
            this.Qian = Qian;
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
    }
}
