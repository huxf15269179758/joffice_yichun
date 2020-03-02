package com.hy.powerplatform.oa_flow.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/2/19.
 */

public class FlowCarVideoDetail implements Serializable {

    /**
     * success : true
     * mainform : [{"ShiGuDiDian":"地点","ZhiDanRenUId":"888888888","jine":"五十","ZhiDanRen":"超级管理员","XianLu":"102","DiaoYueRenZhengJian":"10012","ShenQingRen":"超级管理员","jkczyyj":"","runId":51454,"$type$":"WF_czspdyspb","ZhiDanShiJIan":"2019-02-19","ShiFouDiaoQu":"是","DiaoYueBuMen":"测试部门","xxjsbyj":"","CheHao":"12","mainId":10,"ShiGuXingZhi":"性质","ChuLiZhuangKuang":"状况","xiaoxie":"50","bmfzryj":"","XiangGuanFuJian":"","LiuShuiHao":"","ShiGuShiJian":"2019-02-19"}]
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
         * ShiGuDiDian : 地点
         * ZhiDanRenUId : 888888888
         * jine : 五十
         * ZhiDanRen : 超级管理员
         * XianLu : 102
         * DiaoYueRenZhengJian : 10012
         * ShenQingRen : 超级管理员
         * jkczyyj :
         * runId : 51454
         * $type$ : WF_czspdyspb
         * ZhiDanShiJIan : 2019-02-19
         * ShiFouDiaoQu : 是
         * DiaoYueBuMen : 测试部门
         * xxjsbyj :
         * CheHao : 12
         * mainId : 10
         * ShiGuXingZhi : 性质
         * ChuLiZhuangKuang : 状况
         * xiaoxie : 50
         * bmfzryj :
         * XiangGuanFuJian :
         * LiuShuiHao :
         * ShiGuShiJian : 2019-02-19
         */

        private String ShiGuDiDian;
        private String ZhiDanRenUId;
        private String jine;
        private String ZhiDanRen;
        private String XianLu;
        private String DiaoYueRenZhengJian;
        private String ShenQingRen;
        private String jkczyyj;
        private String runId;
        private String $type$;
        private String ZhiDanShiJIan;
        private String ShiFouDiaoQu;
        private String DiaoYueBuMen;
        private String xxjsbyj;
        private String CheHao;
        private int mainId;
        private String ShiGuXingZhi;
        private String ChuLiZhuangKuang;
        private String xiaoxie;
        private String bmfzryj;
        private String XiangGuanFuJian;
        private String LiuShuiHao;
        private String ShiGuShiJian;

        public String getShiGuDiDian() {
            return ShiGuDiDian;
        }

        public void setShiGuDiDian(String ShiGuDiDian) {
            this.ShiGuDiDian = ShiGuDiDian;
        }

        public String getZhiDanRenUId() {
            return ZhiDanRenUId;
        }

        public void setZhiDanRenUId(String ZhiDanRenUId) {
            this.ZhiDanRenUId = ZhiDanRenUId;
        }

        public String getJine() {
            return jine;
        }

        public void setJine(String jine) {
            this.jine = jine;
        }

        public String getZhiDanRen() {
            return ZhiDanRen;
        }

        public void setZhiDanRen(String ZhiDanRen) {
            this.ZhiDanRen = ZhiDanRen;
        }

        public String getXianLu() {
            return XianLu;
        }

        public void setXianLu(String XianLu) {
            this.XianLu = XianLu;
        }

        public String getDiaoYueRenZhengJian() {
            return DiaoYueRenZhengJian;
        }

        public void setDiaoYueRenZhengJian(String DiaoYueRenZhengJian) {
            this.DiaoYueRenZhengJian = DiaoYueRenZhengJian;
        }

        public String getShenQingRen() {
            return ShenQingRen;
        }

        public void setShenQingRen(String ShenQingRen) {
            this.ShenQingRen = ShenQingRen;
        }

        public String getJkczyyj() {
            return jkczyyj;
        }

        public void setJkczyyj(String jkczyyj) {
            this.jkczyyj = jkczyyj;
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

        public String getZhiDanShiJIan() {
            return ZhiDanShiJIan;
        }

        public void setZhiDanShiJIan(String ZhiDanShiJIan) {
            this.ZhiDanShiJIan = ZhiDanShiJIan;
        }

        public String getShiFouDiaoQu() {
            return ShiFouDiaoQu;
        }

        public void setShiFouDiaoQu(String ShiFouDiaoQu) {
            this.ShiFouDiaoQu = ShiFouDiaoQu;
        }

        public String getDiaoYueBuMen() {
            return DiaoYueBuMen;
        }

        public void setDiaoYueBuMen(String DiaoYueBuMen) {
            this.DiaoYueBuMen = DiaoYueBuMen;
        }

        public String getXxjsbyj() {
            return xxjsbyj;
        }

        public void setXxjsbyj(String xxjsbyj) {
            this.xxjsbyj = xxjsbyj;
        }

        public String getCheHao() {
            return CheHao;
        }

        public void setCheHao(String CheHao) {
            this.CheHao = CheHao;
        }

        public int getMainId() {
            return mainId;
        }

        public void setMainId(int mainId) {
            this.mainId = mainId;
        }

        public String getShiGuXingZhi() {
            return ShiGuXingZhi;
        }

        public void setShiGuXingZhi(String ShiGuXingZhi) {
            this.ShiGuXingZhi = ShiGuXingZhi;
        }

        public String getChuLiZhuangKuang() {
            return ChuLiZhuangKuang;
        }

        public void setChuLiZhuangKuang(String ChuLiZhuangKuang) {
            this.ChuLiZhuangKuang = ChuLiZhuangKuang;
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

        public String getXiangGuanFuJian() {
            return XiangGuanFuJian;
        }

        public void setXiangGuanFuJian(String XiangGuanFuJian) {
            this.XiangGuanFuJian = XiangGuanFuJian;
        }

        public String getLiuShuiHao() {
            return LiuShuiHao;
        }

        public void setLiuShuiHao(String LiuShuiHao) {
            this.LiuShuiHao = LiuShuiHao;
        }

        public String getShiGuShiJian() {
            return ShiGuShiJian;
        }

        public void setShiGuShiJian(String ShiGuShiJian) {
            this.ShiGuShiJian = ShiGuShiJian;
        }
    }
}
