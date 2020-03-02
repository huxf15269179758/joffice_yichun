package com.hy.powerplatform.safer.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2020/1/2.
 */

public class ShiGuList implements Serializable {

    /**
     * success : true
     * totalCounts : 17
     * result : [{"atId":871,"atCode":"SG03136","carNo":"赣CC4726","atAtDate":"2019-01-04","atTime":"15:57:34","driverName":"周军","atReason":"急刹车致乘客摔伤","atPlace":"六医院对面","lineCode":"6","atType":"承运人","atLiability":"次要","depName":"营运一分公司","acNature":"台帐事故","driverNowWorkDate":"2018-05-26 00:00:00","driverIdCard":"362201197211252471","atEmptysMile":0,"acSecurityAward":0,"acDeductionMile":0,"acPlaceCategory":"","atWeather":"","shry":"超级管理员","shsj":"2019-05-13","shzt":"1","age":"","vehicleClass":"","atInsurePerson":"","atOtherPay":"","atPersonPay":"","atTotalCose":"","atSecurityAwardPenalties":"","atProcessingState":"","atAddBond":"","lcshzt":"","mileType":"","busCode":"279","driverCode":"2706","sex":"男","agee":47},{"atId":872,"atCode":"SG03140","carNo":"赣C09970D","atAtDate":"2019-01-19","atTime":"16:07:39","driverName":"邹得金","atReason":"出站与电动车碰撞","atPlace":"阳光大酒店对面","lineCode":"11","atType":"三者（人伤）","atLiability":"主要","depName":"营运一分公司","acNature":"台帐事故","driverNowWorkDate":"2018-11-09 00:00:00","driverIdCard":"362201198601102836","atEmptysMile":0,"acSecurityAward":0,"acDeductionMile":0,"acPlaceCategory":"","atWeather":"","shry":"","shsj":"","shzt":"0","age":"","vehicleClass":"","atInsurePerson":"","atOtherPay":"","atPersonPay":"","atTotalCose":"","atSecurityAwardPenalties":"","atProcessingState":"","atAddBond":"","lcshzt":"","mileType":"","busCode":"526","driverCode":"2817","sex":"男","agee":34},{"atId":873,"atCode":"SG03141","carNo":"赣C06057D","atAtDate":"2018-12-27","atTime":"16:09:40","driverName":"李海华","atReason":"急刹致乘客摔伤","atPlace":"温汤","lineCode":"115","atType":"承运人","atLiability":"无责","depName":"营运二分公司","acNature":"台帐事故","driverNowWorkDate":"2018-08-31 00:00:00","driverIdCard":"360521197705240032","atEmptysMile":0,"acSecurityAward":0,"acDeductionMile":0,"acPlaceCategory":"","atWeather":"","shry":"","shsj":"","shzt":"0","age":"","vehicleClass":"","atInsurePerson":"","atOtherPay":"","atPersonPay":"","atTotalCose":"","atSecurityAwardPenalties":"","atProcessingState":"","atAddBond":"","lcshzt":"","mileType":"","busCode":"451","driverCode":"2796","sex":"男","agee":42},{"atId":874,"atCode":"SG03142","carNo":"赣CQ2860","atAtDate":"2019-01-03","atTime":"16:14:17","driverName":"徐斌","atReason":"刹车致乘客摔伤","atPlace":"桔园新村","lineCode":"71","atType":"承运人","atLiability":"主要","depName":"枢纽分公司","acNature":"台帐事故","driverNowWorkDate":"2018-09-13 00:00:00","driverIdCard":"362201196812191016","atEmptysMile":0,"acSecurityAward":0,"acDeductionMile":0,"acPlaceCategory":"","atWeather":"","shry":"","shsj":"","shzt":"0","age":"","vehicleClass":"","atInsurePerson":"","atOtherPay":"","atPersonPay":"","atTotalCose":"","atSecurityAwardPenalties":"","atProcessingState":"","atAddBond":"","lcshzt":"","mileType":"","busCode":"178","driverCode":"2803","sex":"男","agee":51},{"atId":875,"atCode":"SG03144","carNo":"赣CQ4340","atAtDate":"2019-01-20","atTime":"16:19:10","driverName":"易清军","atReason":"跟车过近刹车致乘客摔伤","atPlace":"贸易广场","lineCode":"70","atType":"承运人","atLiability":"同等","depName":"枢纽分公司","acNature":"台帐事故","driverNowWorkDate":"2018-10-19 00:00:00","driverIdCard":"362201198608043015","atEmptysMile":0,"acSecurityAward":0,"acDeductionMile":0,"acPlaceCategory":"","atWeather":"","shry":"","shsj":"","shzt":"0","age":"","vehicleClass":"","atInsurePerson":"","atOtherPay":"","atPersonPay":"","atTotalCose":"","atSecurityAwardPenalties":"","atProcessingState":"","atAddBond":"","lcshzt":"","mileType":"","busCode":"193","driverCode":"2818","sex":"男","agee":33},{"atId":876,"atCode":"SG03145","carNo":"赣CQ4479","atAtDate":"2019-01-26","atTime":"16:21:27","driverName":"巢永红","atReason":"注意力不集中剐蹭行人","atPlace":"环城南路国家粮库","lineCode":"23","atType":"三者（人伤）","atLiability":"主要","depName":"营运一分公司","acNature":"台帐事故","driverNowWorkDate":"2008-01-11 00:00:00","driverIdCard":"362201197401120058","atEmptysMile":0,"acSecurityAward":0,"acDeductionMile":0,"acPlaceCategory":"","atWeather":"","shry":"","shsj":"","shzt":"0","age":"","vehicleClass":"","atInsurePerson":"","atOtherPay":"","atPersonPay":"","atTotalCose":"","atSecurityAwardPenalties":"","atProcessingState":"","atAddBond":"","lcshzt":"","mileType":"","busCode":"233","driverCode":"1460","sex":"男","agee":46},{"atId":877,"atCode":"SG03146","carNo":"赣CQ4142","atAtDate":"2019-02-08","atTime":"16:22:55","driverName":"徐长林","atReason":"与小车剐蹭","atPlace":"东风大街转盘","lineCode":"23","atType":"三者（车损）","atLiability":"主要","depName":"营运一分公司","acNature":"台帐事故","driverNowWorkDate":"2012-07-09 00:00:00","driverIdCard":"362201197511070813","atEmptysMile":0,"acSecurityAward":0,"acDeductionMile":0,"acPlaceCategory":"","atWeather":"","shry":"","shsj":"","shzt":"0","age":"","vehicleClass":"","atInsurePerson":"","atOtherPay":"","atPersonPay":"","atTotalCose":"","atSecurityAwardPenalties":"","atProcessingState":"","atAddBond":"","lcshzt":"","mileType":"","busCode":"188","driverCode":"1933","sex":"男","agee":44},{"atId":878,"atCode":"SG03148","carNo":"赣CC4573","atAtDate":"2019-02-12","atTime":"16:24:39","driverName":"邹津","atReason":"变道刮小车","atPlace":"东湖花苑门口","lineCode":"4410","atType":"三者（车损）","atLiability":"主要","depName":"枢纽分公司","acNature":"台帐事故","driverNowWorkDate":"2015-10-21 00:00:00","driverIdCard":"362201197703186079","atEmptysMile":0,"acSecurityAward":0,"acDeductionMile":0,"acPlaceCategory":"","atWeather":"","shry":"","shsj":"","shzt":"0","age":"","vehicleClass":"","atInsurePerson":"","atOtherPay":"","atPersonPay":"","atTotalCose":"","atSecurityAwardPenalties":"","atProcessingState":"","atAddBond":"","lcshzt":"","mileType":"","busCode":"293","driverCode":"2225","sex":"男","agee":42},{"atId":879,"atCode":"SG03149","carNo":"赣CQ4410","atAtDate":"2019-02-14","atTime":"16:26:03","driverName":"赖秋寒","atReason":"剐蹭摩托车","atPlace":"苏瓜塘","lineCode":"70","atType":"三者（人伤）","atLiability":"次要","depName":"枢纽分公司","acNature":"台帐事故","driverNowWorkDate":"2016-01-20 00:00:00","driverIdCard":"362202199209011543","atEmptysMile":0,"acSecurityAward":0,"acDeductionMile":0,"acPlaceCategory":"","atWeather":"","shry":"","shsj":"","shzt":"0","age":"","vehicleClass":"","atInsurePerson":"","atOtherPay":"","atPersonPay":"","atTotalCose":"","atSecurityAwardPenalties":"","atProcessingState":"","atAddBond":"","lcshzt":"","mileType":"","busCode":"203","driverCode":"2249","sex":"女","agee":27},{"atId":880,"atCode":"SG03150","carNo":"赣CQ4410","atAtDate":"2019-02-14","atTime":"16:28:08","driverName":"赖秋寒","atReason":"追尾老人，救治无效死亡","atPlace":"个体街","lineCode":"70","atType":"三者（人伤）","atLiability":"全部","depName":"枢纽分公司","acNature":"台帐事故","driverNowWorkDate":"2016-01-20 00:00:00","driverIdCard":"362202199209011543","atEmptysMile":0,"acSecurityAward":0,"acDeductionMile":0,"acPlaceCategory":"","atWeather":"","shry":"","shsj":"","shzt":"0","age":"","vehicleClass":"","atInsurePerson":"","atOtherPay":"","atPersonPay":"","atTotalCose":"","atSecurityAwardPenalties":"","atProcessingState":"","atAddBond":"","lcshzt":"","mileType":"","busCode":"203","driverCode":"2249","sex":"女","agee":27},{"atId":881,"atCode":"SG03151","carNo":"赣CC4719","atAtDate":"2019-02-27","atTime":"16:29:57","driverName":"周建忠","atReason":"乘客自己摔伤","atPlace":"塔下路口","lineCode":"6","atType":"三者（人伤）","atLiability":"无责","depName":"营运一分公司","acNature":"台帐事故","driverNowWorkDate":"2003-06-26 00:00:00","driverIdCard":"362201196910180054","atEmptysMile":0,"acSecurityAward":0,"acDeductionMile":0,"acPlaceCategory":"","atWeather":"","shry":"","shsj":"","shzt":"0","age":"","vehicleClass":"","atInsurePerson":"","atOtherPay":"","atPersonPay":"","atTotalCose":"","atSecurityAwardPenalties":"","atProcessingState":"","atAddBond":"","lcshzt":"","mileType":"","busCode":"275","driverCode":"754","sex":"男","agee":50},{"atId":882,"atCode":"SG03152","carNo":"赣CC4713","atAtDate":"2019-03-18","atTime":"16:32:49","driverName":"胡林安","atReason":"与小车碰撞","atPlace":"张家山转盘","lineCode":"6","atType":"三者（车损）","atLiability":"","depName":"营运一分公司","acNature":"台帐事故","driverNowWorkDate":"2017-08-28 00:00:00","driverIdCard":"362201196609250236","atEmptysMile":0,"acSecurityAward":0,"acDeductionMile":0,"acPlaceCategory":"","atWeather":"","shry":"","shsj":"","shzt":"0","age":"","vehicleClass":"","atInsurePerson":"","atOtherPay":"","atPersonPay":"","atTotalCose":"","atSecurityAwardPenalties":"","atProcessingState":"","atAddBond":"","lcshzt":"","mileType":"","busCode":"272","driverCode":"2539","sex":"男","agee":53},{"atId":883,"atCode":"SG03153","carNo":"赣CQ2823","atAtDate":"2019-03-03","atTime":"16:37:37","driverName":"范外生","atReason":"乘客未站稳扶好摔伤","atPlace":"明月华府","lineCode":"4401","atType":"承运人","atLiability":"无责","depName":"营运二分公司","acNature":"台帐事故","driverNowWorkDate":"2016-08-24 00:00:00","driverIdCard":"362201197209304818","atEmptysMile":0,"acSecurityAward":0,"acDeductionMile":0,"acPlaceCategory":"","atWeather":"","shry":"","shsj":"","shzt":"0","age":"","vehicleClass":"","atInsurePerson":"","atOtherPay":"","atPersonPay":"","atTotalCose":"","atSecurityAwardPenalties":"","atProcessingState":"","atAddBond":"","lcshzt":"","mileType":"","busCode":"158","driverCode":"2340","sex":"男","agee":47},{"atId":884,"atCode":"SG03154","carNo":"赣CQ4417","atAtDate":"2019-03-18","atTime":"16:42:39","driverName":"孙桂云","atReason":"刹车致乘客摔伤","atPlace":"湖田路段","lineCode":"4401","atType":"承运人","atLiability":"主要","depName":"营运二分公司","acNature":"台帐事故","driverNowWorkDate":"2018-07-02 00:00:00","driverIdCard":"362201197409282633","atEmptysMile":0,"acSecurityAward":0,"acDeductionMile":0,"acPlaceCategory":"","atWeather":"","shry":"","shsj":"","shzt":"0","age":"","vehicleClass":"","atInsurePerson":"","atOtherPay":"","atPersonPay":"","atTotalCose":"","atSecurityAwardPenalties":"","atProcessingState":"","atAddBond":"","lcshzt":"","mileType":"","busCode":"206","driverCode":"2733","sex":"男","agee":45},{"atId":885,"atCode":"SG03155","carNo":"赣CL4462","atAtDate":"2019-03-18","atTime":"16:44:05","driverName":"冯文沅","atReason":"起步致乘客摔伤","atPlace":"汽车西站","lineCode":"4422","atType":"承运人","atLiability":"主要","depName":"营运二分公司","acNature":"台帐事故","driverNowWorkDate":"2018-09-21 00:00:00","driverIdCard":"362201197306040439","atEmptysMile":0,"acSecurityAward":0,"acDeductionMile":0,"acPlaceCategory":"","atWeather":"","shry":"","shsj":"","shzt":"0","age":"","vehicleClass":"","atInsurePerson":"","atOtherPay":"","atPersonPay":"","atTotalCose":"","atSecurityAwardPenalties":"","atProcessingState":"","atAddBond":"","lcshzt":"","mileType":"","busCode":"67","driverCode":"2806","sex":"男","agee":46},{"atId":886,"atCode":"SG03156","carNo":"赣C06670D","atAtDate":"2019-03-18","atTime":"16:45:18","driverName":"张宁","atReason":"与电动车发生碰撞","atPlace":"白马村路段","lineCode":"1111","atType":"三者（人伤）","atLiability":"","depName":"营运一分公司","acNature":"台帐事故","driverNowWorkDate":"2017-06-30 00:00:00","driverIdCard":"362201197202110017","atEmptysMile":0,"acSecurityAward":0,"acDeductionMile":0,"acPlaceCategory":"","atWeather":"","shry":"","shsj":"","shzt":"0","age":"","vehicleClass":"","atInsurePerson":"","atOtherPay":"","atPersonPay":"","atTotalCose":"","atSecurityAwardPenalties":"","atProcessingState":"","atAddBond":"","lcshzt":"","mileType":"","busCode":"5286","driverCode":"2495","sex":"男","agee":47},{"atId":887,"atCode":"SG03157","carNo":"赣C09954D","atAtDate":"2019-03-21","atTime":"16:47:21","driverName":"刘传福","atReason":"与三轮车发生碰撞","atPlace":"温汤","lineCode":"118","atType":"三者（人伤）","atLiability":"","depName":"营运二分公司","acNature":"台帐事故","driverNowWorkDate":"2010-01-07 00:00:00","driverIdCard":"362201197305144412","atEmptysMile":0,"acSecurityAward":0,"acDeductionMile":0,"acPlaceCategory":"","atWeather":"","shry":"","shsj":"","shzt":"0","age":"","vehicleClass":"","atInsurePerson":"","atOtherPay":"","atPersonPay":"","atTotalCose":"","atSecurityAwardPenalties":"","atProcessingState":"","atAddBond":"","lcshzt":"","mileType":"","busCode":"516","driverCode":"1721","sex":"男","agee":46}]
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
         * atId : 871
         * atCode : SG03136
         * carNo : 赣CC4726
         * atAtDate : 2019-01-04
         * atTime : 15:57:34
         * driverName : 周军
         * atReason : 急刹车致乘客摔伤
         * atPlace : 六医院对面
         * lineCode : 6
         * atType : 承运人
         * atLiability : 次要
         * depName : 营运一分公司
         * acNature : 台帐事故
         * driverNowWorkDate : 2018-05-26 00:00:00
         * driverIdCard : 362201197211252471
         * atEmptysMile : 0
         * acSecurityAward : 0
         * acDeductionMile : 0.0
         * acPlaceCategory :
         * atWeather :
         * shry : 超级管理员
         * shsj : 2019-05-13
         * shzt : 1
         * age :
         * vehicleClass :
         * atInsurePerson :
         * atOtherPay :
         * atPersonPay :
         * atTotalCose :
         * atSecurityAwardPenalties :
         * atProcessingState :
         * atAddBond :
         * lcshzt :
         * mileType :
         * busCode : 279
         * driverCode : 2706
         * sex : 男
         * agee : 47
         */

        private int atId;
        private String atCode;
        private String carNo;
        private String atAtDate;
        private String atTime;
        private String driverName;
        private String atReason;
        private String atPlace;
        private String lineCode;
        private String atType;
        private String atLiability;
        private String depName;
        private String acNature;
        private String driverNowWorkDate;
        private String driverIdCard;
        private int atEmptysMile;
        private int acSecurityAward;
        private double acDeductionMile;
        private String acPlaceCategory;
        private String atWeather;
        private String shry;
        private String shsj;
        private String shzt;
        private String age;
        private String vehicleClass;
        private String atInsurePerson;
        private String atOtherPay;
        private String atPersonPay;
        private String atTotalCose;
        private String atSecurityAwardPenalties;
        private String atProcessingState;
        private String atAddBond;
        private String lcshzt;
        private String mileType;
        private String busCode;
        private String driverCode;
        private String sex;
        private int agee;

        public int getAtId() {
            return atId;
        }

        public void setAtId(int atId) {
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

        public String getDriverNowWorkDate() {
            return driverNowWorkDate;
        }

        public void setDriverNowWorkDate(String driverNowWorkDate) {
            this.driverNowWorkDate = driverNowWorkDate;
        }

        public String getDriverIdCard() {
            return driverIdCard;
        }

        public void setDriverIdCard(String driverIdCard) {
            this.driverIdCard = driverIdCard;
        }

        public int getAtEmptysMile() {
            return atEmptysMile;
        }

        public void setAtEmptysMile(int atEmptysMile) {
            this.atEmptysMile = atEmptysMile;
        }

        public int getAcSecurityAward() {
            return acSecurityAward;
        }

        public void setAcSecurityAward(int acSecurityAward) {
            this.acSecurityAward = acSecurityAward;
        }

        public double getAcDeductionMile() {
            return acDeductionMile;
        }

        public void setAcDeductionMile(double acDeductionMile) {
            this.acDeductionMile = acDeductionMile;
        }

        public String getAcPlaceCategory() {
            return acPlaceCategory;
        }

        public void setAcPlaceCategory(String acPlaceCategory) {
            this.acPlaceCategory = acPlaceCategory;
        }

        public String getAtWeather() {
            return atWeather;
        }

        public void setAtWeather(String atWeather) {
            this.atWeather = atWeather;
        }

        public String getShry() {
            return shry;
        }

        public void setShry(String shry) {
            this.shry = shry;
        }

        public String getShsj() {
            return shsj;
        }

        public void setShsj(String shsj) {
            this.shsj = shsj;
        }

        public String getShzt() {
            return shzt;
        }

        public void setShzt(String shzt) {
            this.shzt = shzt;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public String getVehicleClass() {
            return vehicleClass;
        }

        public void setVehicleClass(String vehicleClass) {
            this.vehicleClass = vehicleClass;
        }

        public String getAtInsurePerson() {
            return atInsurePerson;
        }

        public void setAtInsurePerson(String atInsurePerson) {
            this.atInsurePerson = atInsurePerson;
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

        public String getAtTotalCose() {
            return atTotalCose;
        }

        public void setAtTotalCose(String atTotalCose) {
            this.atTotalCose = atTotalCose;
        }

        public String getAtSecurityAwardPenalties() {
            return atSecurityAwardPenalties;
        }

        public void setAtSecurityAwardPenalties(String atSecurityAwardPenalties) {
            this.atSecurityAwardPenalties = atSecurityAwardPenalties;
        }

        public String getAtProcessingState() {
            return atProcessingState;
        }

        public void setAtProcessingState(String atProcessingState) {
            this.atProcessingState = atProcessingState;
        }

        public String getAtAddBond() {
            return atAddBond;
        }

        public void setAtAddBond(String atAddBond) {
            this.atAddBond = atAddBond;
        }

        public String getLcshzt() {
            return lcshzt;
        }

        public void setLcshzt(String lcshzt) {
            this.lcshzt = lcshzt;
        }

        public String getMileType() {
            return mileType;
        }

        public void setMileType(String mileType) {
            this.mileType = mileType;
        }

        public String getBusCode() {
            return busCode;
        }

        public void setBusCode(String busCode) {
            this.busCode = busCode;
        }

        public String getDriverCode() {
            return driverCode;
        }

        public void setDriverCode(String driverCode) {
            this.driverCode = driverCode;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public int getAgee() {
            return agee;
        }

        public void setAgee(int agee) {
            this.agee = agee;
        }
    }
}
