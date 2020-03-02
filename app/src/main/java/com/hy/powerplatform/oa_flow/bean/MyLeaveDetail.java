package com.hy.powerplatform.oa_flow.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/1/24.
 */

public class MyLeaveDetail implements Serializable {

    /**
     * success : true
     * mainform : [{"FuBingLi":"","fullnameUId":"888888888","ksdayType":"上午","shiyou":"测试事由","endDate":"2019-01-24","runId":51282,"$type$":"WF_YuanGongQingJiaDan","beginDate":"2019-01-23","fgldyj":"[{\"ui\":\"153\",\"un\":\"袁斌\",\"c\":\"2019-01-24 09:11\",\"v\":\"同意\"}]","vocationType":"病假","jsdayType":"上午","TianDanRiQi":"2019-01-23","mainId":127,"vocationDays":"2","zjlyj":"","fullname":"超级管理员","bmfzryj":"[{\"ui\":\"1729\",\"un\":\"欧阳晓林\",\"c\":\"2019-01-24 09:10\",\"v\":\"同意\"}]"}]
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
         * FuBingLi :
         * fullnameUId : 888888888
         * ksdayType : 上午
         * shiyou : 测试事由
         * endDate : 2019-01-24
         * runId : 51282
         * $type$ : WF_YuanGongQingJiaDan
         * beginDate : 2019-01-23
         * fgldyj : [{"ui":"153","un":"袁斌","c":"2019-01-24 09:11","v":"同意"}]
         * vocationType : 病假
         * jsdayType : 上午
         * TianDanRiQi : 2019-01-23
         * mainId : 127
         * vocationDays : 2
         * zjlyj :
         * fullname : 超级管理员
         * bmfzryj : [{"ui":"1729","un":"欧阳晓林","c":"2019-01-24 09:10","v":"同意"}]
         */

        private String FuBingLi;
        private String fullnameUId;
        private String ksdayType;
        private String shiyou;
        private String endDate;
        private String runId;
        private String $type$;
        private String beginDate;
        private String fgldyj;
        private String vocationType;
        private String jsdayType;
        private String TianDanRiQi;
        private int mainId;
        private String vocationDays;
        private String zjlyj;
        private String fullname;
        private String bmfzryj;

        public String getFuBingLi() {
            return FuBingLi;
        }

        public void setFuBingLi(String FuBingLi) {
            this.FuBingLi = FuBingLi;
        }

        public String getFullnameUId() {
            return fullnameUId;
        }

        public void setFullnameUId(String fullnameUId) {
            this.fullnameUId = fullnameUId;
        }

        public String getKsdayType() {
            return ksdayType;
        }

        public void setKsdayType(String ksdayType) {
            this.ksdayType = ksdayType;
        }

        public String getShiyou() {
            return shiyou;
        }

        public void setShiyou(String shiyou) {
            this.shiyou = shiyou;
        }

        public String getEndDate() {
            return endDate;
        }

        public void setEndDate(String endDate) {
            this.endDate = endDate;
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

        public String getBeginDate() {
            return beginDate;
        }

        public void setBeginDate(String beginDate) {
            this.beginDate = beginDate;
        }

        public String getFgldyj() {
            return fgldyj;
        }

        public void setFgldyj(String fgldyj) {
            this.fgldyj = fgldyj;
        }

        public String getVocationType() {
            return vocationType;
        }

        public void setVocationType(String vocationType) {
            this.vocationType = vocationType;
        }

        public String getJsdayType() {
            return jsdayType;
        }

        public void setJsdayType(String jsdayType) {
            this.jsdayType = jsdayType;
        }

        public String getTianDanRiQi() {
            return TianDanRiQi;
        }

        public void setTianDanRiQi(String TianDanRiQi) {
            this.TianDanRiQi = TianDanRiQi;
        }

        public int getMainId() {
            return mainId;
        }

        public void setMainId(int mainId) {
            this.mainId = mainId;
        }

        public String getVocationDays() {
            return vocationDays;
        }

        public void setVocationDays(String vocationDays) {
            this.vocationDays = vocationDays;
        }

        public String getZjlyj() {
            return zjlyj;
        }

        public void setZjlyj(String zjlyj) {
            this.zjlyj = zjlyj;
        }

        public String getFullname() {
            return fullname;
        }

        public void setFullname(String fullname) {
            this.fullname = fullname;
        }

        public String getBmfzryj() {
            return bmfzryj;
        }

        public void setBmfzryj(String bmfzryj) {
            this.bmfzryj = bmfzryj;
        }
    }
}
