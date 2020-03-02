package com.hy.powerplatform.business_inspect.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by dell on 2018/6/15.
 */

public class ShiGuHis implements Serializable {


    /**
     * success : true
     * totalCounts : 1
     * result : [{"atId":"415","atCode":"00000000896","carNo":"晋K00018 ","busCode":"427","atAtDate":"2018-06-28","atTime":"10:20:08","driverName":"安旭东","driverCode":"101402","atReason":"测试","atPlace":"中国山东省济南市历下区华阳路67-1","lineCode":"1","atType":"事故","atLiability":"全部责任","atEmptysMile":"0","depId":"916","depName":"运营三队","acNature":"轻微事故","acSecurityAward":"0","acBuckleFacilitiesAward":"0","acDeductionMile":0,"driverIdCard":"142423196712154814","driverNowWorkDate":"2018-06-16","smiles":1114.8,"atOperCode":"101866","atOperName":"白峰","partyId":"60","sideName":"对方测试","sideSex":"","sideContact":"10086","sideCarPlate":"1008601","sideLicenseNum":"1008602","atTreatmentId":"52","atOtherPay":1000,"atPersonPay":100}]
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
         * atId : 415
         * atCode : 00000000896
         * carNo : 晋K00018
         * busCode : 427
         * atAtDate : 2018-06-28
         * atTime : 10:20:08
         * driverName : 安旭东
         * driverCode : 101402
         * atReason : 测试
         * atPlace : 中国山东省济南市历下区华阳路67-1
         * lineCode : 1
         * atType : 事故
         * atLiability : 全部责任
         * atEmptysMile : 0
         * depId : 916
         * depName : 运营三队
         * acNature : 轻微事故
         * acSecurityAward : 0
         * acBuckleFacilitiesAward : 0
         * acDeductionMile : 0.0
         * driverIdCard : 142423196712154814
         * driverNowWorkDate : 2018-06-16
         * smiles : 1114.8
         * atOperCode : 101866
         * atOperName : 白峰
         * partyId : 60
         * sideName : 对方测试
         * sideSex :
         * sideContact : 10086
         * sideCarPlate : 1008601
         * sideLicenseNum : 1008602
         * atTreatmentId : 52
         * atOtherPay : 1000.0
         * atPersonPay : 100.0
         */

        private String atId;
        private String atCode;
        private String carNo;
        private String busCode;
        private String atAtDate;
        private String atTime;
        private String driverName;
        private String driverCode;
        private String atReason;
        private String atPlace;
        private String lineCode;
        private String atType;
        private String atLiability;
        private String atEmptysMile;
        private String depId;
        private String depName;
        private String acNature;
        private String acSecurityAward;
        private String acBuckleFacilitiesAward;
        private double acDeductionMile;
        private String driverIdCard;
        private String driverNowWorkDate;
        private double smiles;
        private String atOperCode;
        private String atOperName;
        private String partyId;
        private String sideName;
        private String sideSex;
        private String sideContact;
        private String sideCarPlate;
        private String sideLicenseNum;
        private String atTreatmentId;
        private String atOtherPay;
        private String atPersonPay;

        public String getAtId() {
            return atId;
        }

        public void setAtId(String atId) {
            this.atId = atId;
        }

        public String getAtCode() {
            return atCode;
        }

        public void setAtCode(String atCode) {
            this.atCode = atCode;
        }

        public String getCarNo() {
            return carNo;
        }

        public void setCarNo(String carNo) {
            this.carNo = carNo;
        }

        public String getBusCode() {
            return busCode;
        }

        public void setBusCode(String busCode) {
            this.busCode = busCode;
        }

        public String getAtAtDate() {
            return atAtDate;
        }

        public void setAtAtDate(String atAtDate) {
            this.atAtDate = atAtDate;
        }

        public String getAtTime() {
            return atTime;
        }

        public void setAtTime(String atTime) {
            this.atTime = atTime;
        }

        public String getDriverName() {
            return driverName;
        }

        public void setDriverName(String driverName) {
            this.driverName = driverName;
        }

        public String getDriverCode() {
            return driverCode;
        }

        public void setDriverCode(String driverCode) {
            this.driverCode = driverCode;
        }

        public String getAtReason() {
            return atReason;
        }

        public void setAtReason(String atReason) {
            this.atReason = atReason;
        }

        public String getAtPlace() {
            return atPlace;
        }

        public void setAtPlace(String atPlace) {
            this.atPlace = atPlace;
        }

        public String getLineCode() {
            return lineCode;
        }

        public void setLineCode(String lineCode) {
            this.lineCode = lineCode;
        }

        public String getAtType() {
            return atType;
        }

        public void setAtType(String atType) {
            this.atType = atType;
        }

        public String getAtLiability() {
            return atLiability;
        }

        public void setAtLiability(String atLiability) {
            this.atLiability = atLiability;
        }

        public String getAtEmptysMile() {
            return atEmptysMile;
        }

        public void setAtEmptysMile(String atEmptysMile) {
            this.atEmptysMile = atEmptysMile;
        }

        public String getDepId() {
            return depId;
        }

        public void setDepId(String depId) {
            this.depId = depId;
        }

        public String getDepName() {
            return depName;
        }

        public void setDepName(String depName) {
            this.depName = depName;
        }

        public String getAcNature() {
            return acNature;
        }

        public void setAcNature(String acNature) {
            this.acNature = acNature;
        }

        public String getAcSecurityAward() {
            return acSecurityAward;
        }

        public void setAcSecurityAward(String acSecurityAward) {
            this.acSecurityAward = acSecurityAward;
        }

        public String getAcBuckleFacilitiesAward() {
            return acBuckleFacilitiesAward;
        }

        public void setAcBuckleFacilitiesAward(String acBuckleFacilitiesAward) {
            this.acBuckleFacilitiesAward = acBuckleFacilitiesAward;
        }

        public double getAcDeductionMile() {
            return acDeductionMile;
        }

        public void setAcDeductionMile(double acDeductionMile) {
            this.acDeductionMile = acDeductionMile;
        }

        public String getDriverIdCard() {
            return driverIdCard;
        }

        public void setDriverIdCard(String driverIdCard) {
            this.driverIdCard = driverIdCard;
        }

        public String getDriverNowWorkDate() {
            return driverNowWorkDate;
        }

        public void setDriverNowWorkDate(String driverNowWorkDate) {
            this.driverNowWorkDate = driverNowWorkDate;
        }

        public double getSmiles() {
            return smiles;
        }

        public void setSmiles(double smiles) {
            this.smiles = smiles;
        }

        public String getAtOperCode() {
            return atOperCode;
        }

        public void setAtOperCode(String atOperCode) {
            this.atOperCode = atOperCode;
        }

        public String getAtOperName() {
            return atOperName;
        }

        public void setAtOperName(String atOperName) {
            this.atOperName = atOperName;
        }

        public String getPartyId() {
            return partyId;
        }

        public void setPartyId(String partyId) {
            this.partyId = partyId;
        }

        public String getSideName() {
            return sideName;
        }

        public void setSideName(String sideName) {
            this.sideName = sideName;
        }

        public String getSideSex() {
            return sideSex;
        }

        public void setSideSex(String sideSex) {
            this.sideSex = sideSex;
        }

        public String getSideContact() {
            return sideContact;
        }

        public void setSideContact(String sideContact) {
            this.sideContact = sideContact;
        }

        public String getSideCarPlate() {
            return sideCarPlate;
        }

        public void setSideCarPlate(String sideCarPlate) {
            this.sideCarPlate = sideCarPlate;
        }

        public String getSideLicenseNum() {
            return sideLicenseNum;
        }

        public void setSideLicenseNum(String sideLicenseNum) {
            this.sideLicenseNum = sideLicenseNum;
        }

        public String getAtTreatmentId() {
            return atTreatmentId;
        }

        public void setAtTreatmentId(String atTreatmentId) {
            this.atTreatmentId = atTreatmentId;
        }

        public String getAtOtherPay() {
            return atOtherPay;
        }

        public void setAtOtherPay(String atOtherPay) {
            this.atOtherPay = atOtherPay;
        }

        public String getAtPersonPay() {
            return atPersonPay;
        }

        public void setAtPersonPay(String atPersonPay) {
            this.atPersonPay = atPersonPay;
        }
    }
}
