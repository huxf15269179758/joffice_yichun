package com.hy.powerplatform.comper.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2020/1/3.
 */

public class YingYunList implements Serializable {

    /**
     * success : true
     * totalCounts : 5
     * result : [{"depName":"合计","zlc":"23225704.70","yycz":"49877085.46","xjsr":"25331420.40","icsr":"12784978.86","flaxk":"11760686.20","ry":"1541865.55","cd":"7440320.86","bx":"1963184.30","lng":"10139331.13","lngxh":"1559887.80","cng":"557323.02","cngxh":"132668.62","ryxh":"259377.53","cdxh":"10701184.26","bglsy":"214.75","bglyh":"1.12","bgldh":"46.07","bglqh":"7.29"},{"depId":99999,"depName":"其他","zlc":"0.00","yycz":"24392.63","xjsr":"0.00","icsr":"13886.63","flaxk":"10506.00","ry":"0.00","cd":"0.00","bx":"0.00","bglsy":"0.00","lng":"0.00","lngxh":"0.00","cng":"0.00","cngxh":"0.00","ryxh":"0.00","cdxh":"0.00","bglyh":"0.00","bgldh":"0.00","bglqh":"0.00"},{"depId":505,"depName":"营运一分公司","zlc":"7248043.00","yycz":"14582867.78","xjsr":"6966351.20","icsr":"4190515.78","flaxk":"3426000.80","ry":"17624.26","cd":"2517242.52","bx":"630726.34","bglsy":"201.20","lng":"2898250.41","lngxh":"445881.75","cng":"262427.27","cngxh":"62482.66","ryxh":"3093.00","cdxh":"3733955.06","bglyh":"0.04","bgldh":"51.52","bglqh":"7.01"},{"depId":506,"depName":"营运二分公司","zlc":"7666925.20","yycz":"16668720.36","xjsr":"11014079.20","icsr":"2921540.56","flaxk":"2733100.60","ry":"47056.13","cd":"2187882.19","bx":"597474.33","bglsy":"217.41","lng":"4847344.14","lngxh":"745741.35","cng":"288117.99","cngxh":"68572.21","ryxh":"7784.59","cdxh":"3041988.38","bglyh":"0.10","bgldh":"39.68","bglqh":"10.62"},{"depId":507,"depName":"枢纽分公司","zlc":"8310736.50","yycz":"18601104.69","xjsr":"7350990.00","icsr":"5659035.89","flaxk":"5591078.80","ry":"1477185.16","cd":"2735196.15","bx":"734983.63","bglsy":"223.82","lng":"2393736.58","lngxh":"368264.70","cng":"6777.76","cngxh":"1613.75","ryxh":"248499.94","cdxh":"3925240.82","bglyh":"2.99","bgldh":"47.23","bglqh":"4.45"}]
     */

    private boolean success;
    private int totalCounts;
    private List<ResultBean> result;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getTotalCounts() {
        return totalCounts;
    }

    public void setTotalCounts(int totalCounts) {
        this.totalCounts = totalCounts;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean implements Serializable {
        /**
         * depName : 合计
         * zlc : 23225704.70
         * yycz : 49877085.46
         * xjsr : 25331420.40
         * icsr : 12784978.86
         * flaxk : 11760686.20
         * ry : 1541865.55
         * cd : 7440320.86
         * bx : 1963184.30
         * lng : 10139331.13
         * lngxh : 1559887.80
         * cng : 557323.02
         * cngxh : 132668.62
         * ryxh : 259377.53
         * cdxh : 10701184.26
         * bglsy : 214.75
         * bglyh : 1.12
         * bgldh : 46.07
         * bglqh : 7.29
         * depId : 99999
         */

        private String depName;
        private String zlc;
        private String yycz;
        private String xjsr;
        private String icsr;
        private String flaxk;
        private String ry;
        private String cd;
        private String bx;
        private String lng;
        private String lngxh;
        private String cng;
        private String cngxh;
        private String ryxh;
        private String cdxh;
        private String bglsy;
        private String bglyh;
        private String bgldh;
        private String bglqh;
        private int depId;

        public String getDepName() {
            return depName;
        }

        public void setDepName(String depName) {
            this.depName = depName;
        }

        public String getZlc() {
            return zlc;
        }

        public void setZlc(String zlc) {
            this.zlc = zlc;
        }

        public String getYycz() {
            return yycz;
        }

        public void setYycz(String yycz) {
            this.yycz = yycz;
        }

        public String getXjsr() {
            return xjsr;
        }

        public void setXjsr(String xjsr) {
            this.xjsr = xjsr;
        }

        public String getIcsr() {
            return icsr;
        }

        public void setIcsr(String icsr) {
            this.icsr = icsr;
        }

        public String getFlaxk() {
            return flaxk;
        }

        public void setFlaxk(String flaxk) {
            this.flaxk = flaxk;
        }

        public String getRy() {
            return ry;
        }

        public void setRy(String ry) {
            this.ry = ry;
        }

        public String getCd() {
            return cd;
        }

        public void setCd(String cd) {
            this.cd = cd;
        }

        public String getBx() {
            return bx;
        }

        public void setBx(String bx) {
            this.bx = bx;
        }

        public String getLng() {
            return lng;
        }

        public void setLng(String lng) {
            this.lng = lng;
        }

        public String getLngxh() {
            return lngxh;
        }

        public void setLngxh(String lngxh) {
            this.lngxh = lngxh;
        }

        public String getCng() {
            return cng;
        }

        public void setCng(String cng) {
            this.cng = cng;
        }

        public String getCngxh() {
            return cngxh;
        }

        public void setCngxh(String cngxh) {
            this.cngxh = cngxh;
        }

        public String getRyxh() {
            return ryxh;
        }

        public void setRyxh(String ryxh) {
            this.ryxh = ryxh;
        }

        public String getCdxh() {
            return cdxh;
        }

        public void setCdxh(String cdxh) {
            this.cdxh = cdxh;
        }

        public String getBglsy() {
            return bglsy;
        }

        public void setBglsy(String bglsy) {
            this.bglsy = bglsy;
        }

        public String getBglyh() {
            return bglyh;
        }

        public void setBglyh(String bglyh) {
            this.bglyh = bglyh;
        }

        public String getBgldh() {
            return bgldh;
        }

        public void setBgldh(String bgldh) {
            this.bgldh = bgldh;
        }

        public String getBglqh() {
            return bglqh;
        }

        public void setBglqh(String bglqh) {
            this.bglqh = bglqh;
        }

        public int getDepId() {
            return depId;
        }

        public void setDepId(int depId) {
            this.depId = depId;
        }
    }
}
