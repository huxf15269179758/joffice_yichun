package com.hy.powerplatform.safer.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2020/1/2.
 */

public class WeiZhangList implements Serializable {

    /**
     * success : true
     * totalCounts : 4
     * result : [{"version":null,"orgId":505,"orgPath":null,"vnId":903,"busCode":"356","vnDate":"2019-03-21","vnTime":"10:40:34","driverCode":"2570","vnPlace":"","vnFine":200,"vnMark":"3","vnMemo":"","vnProject":"违反禁令标志指示","lineCode":"112","driveDirection":"","penaltyResult":"","carNo":"赣CC8118","driverName":"黄金玉","violationResp":"","penaltyStatus":"未处理"},{"version":null,"orgId":506,"orgPath":null,"vnId":904,"busCode":"447","vnDate":"2019-03-21","vnTime":"10:41:00","driverCode":"2566","vnPlace":"","vnFine":200,"vnMark":"6","vnMemo":"","vnProject":"违反信号行驶","lineCode":"112","driveDirection":"","penaltyResult":"","carNo":"赣C06038D","driverName":"汤亮亮","violationResp":"","penaltyStatus":"未处理"},{"version":null,"orgId":507,"orgPath":null,"vnId":908,"busCode":"470","vnDate":"2019-03-19","vnTime":"14:11:26","driverCode":"1480","vnPlace":"","vnFine":200,"vnMark":"3","vnMemo":"","vnProject":"违反禁止标线","lineCode":"91","driveDirection":"","penaltyResult":"","carNo":"赣C07174D","driverName":"彭国来","violationResp":"","penaltyStatus":"未处理"},{"version":null,"orgId":505,"orgPath":null,"vnId":909,"busCode":"209","vnDate":"2019-03-29","vnTime":"10:30:00","driverCode":"1633","vnPlace":"","vnFine":100,"vnMark":"6","vnMemo":"","vnProject":"超速行驶","lineCode":"21","driveDirection":"","penaltyResult":"","carNo":"赣CQ4429","driverName":"胡耀明","violationResp":"","penaltyStatus":"未处理"}]
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
         * version : null
         * orgId : 505
         * orgPath : null
         * vnId : 903
         * busCode : 356
         * vnDate : 2019-03-21
         * vnTime : 10:40:34
         * driverCode : 2570
         * vnPlace :
         * vnFine : 200.0
         * vnMark : 3
         * vnMemo :
         * vnProject : 违反禁令标志指示
         * lineCode : 112
         * driveDirection :
         * penaltyResult :
         * carNo : 赣CC8118
         * driverName : 黄金玉
         * violationResp :
         * penaltyStatus : 未处理
         */

        private Object version;
        private int orgId;
        private Object orgPath;
        private int vnId;
        private String busCode;
        private String vnDate;
        private String vnTime;
        private String driverCode;
        private String vnPlace;
        private double vnFine;
        private String vnMark;
        private String vnMemo;
        private String vnProject;
        private String lineCode;
        private String driveDirection;
        private String penaltyResult;
        private String carNo;
        private String driverName;
        private String violationResp;
        private String penaltyStatus;

        public Object getVersion() {
            return version;
        }

        public void setVersion(Object version) {
            this.version = version;
        }

        public int getOrgId() {
            return orgId;
        }

        public void setOrgId(int orgId) {
            this.orgId = orgId;
        }

        public Object getOrgPath() {
            return orgPath;
        }

        public void setOrgPath(Object orgPath) {
            this.orgPath = orgPath;
        }

        public int getVnId() {
            return vnId;
        }

        public void setVnId(int vnId) {
            this.vnId = vnId;
        }

        public String getBusCode() {
            return busCode;
        }

        public void setBusCode(String busCode) {
            this.busCode = busCode;
        }

        public String getVnDate() {
            return vnDate;
        }

        public void setVnDate(String vnDate) {
            this.vnDate = vnDate;
        }

        public String getVnTime() {
            return vnTime;
        }

        public void setVnTime(String vnTime) {
            this.vnTime = vnTime;
        }

        public String getDriverCode() {
            return driverCode;
        }

        public void setDriverCode(String driverCode) {
            this.driverCode = driverCode;
        }

        public String getVnPlace() {
            return vnPlace;
        }

        public void setVnPlace(String vnPlace) {
            this.vnPlace = vnPlace;
        }

        public double getVnFine() {
            return vnFine;
        }

        public void setVnFine(double vnFine) {
            this.vnFine = vnFine;
        }

        public String getVnMark() {
            return vnMark;
        }

        public void setVnMark(String vnMark) {
            this.vnMark = vnMark;
        }

        public String getVnMemo() {
            return vnMemo;
        }

        public void setVnMemo(String vnMemo) {
            this.vnMemo = vnMemo;
        }

        public String getVnProject() {
            return vnProject;
        }

        public void setVnProject(String vnProject) {
            this.vnProject = vnProject;
        }

        public String getLineCode() {
            return lineCode;
        }

        public void setLineCode(String lineCode) {
            this.lineCode = lineCode;
        }

        public String getDriveDirection() {
            return driveDirection;
        }

        public void setDriveDirection(String driveDirection) {
            this.driveDirection = driveDirection;
        }

        public String getPenaltyResult() {
            return penaltyResult;
        }

        public void setPenaltyResult(String penaltyResult) {
            this.penaltyResult = penaltyResult;
        }

        public String getCarNo() {
            return carNo;
        }

        public void setCarNo(String carNo) {
            this.carNo = carNo;
        }

        public String getDriverName() {
            return driverName;
        }

        public void setDriverName(String driverName) {
            this.driverName = driverName;
        }

        public String getViolationResp() {
            return violationResp;
        }

        public void setViolationResp(String violationResp) {
            this.violationResp = violationResp;
        }

        public String getPenaltyStatus() {
            return penaltyStatus;
        }

        public void setPenaltyStatus(String penaltyStatus) {
            this.penaltyStatus = penaltyStatus;
        }
    }
}
