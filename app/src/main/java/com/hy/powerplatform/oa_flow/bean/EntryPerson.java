package com.hy.powerplatform.oa_flow.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2020/1/17.
 */

public class EntryPerson implements Serializable {

    /**
     * success : true
     * totalCounts : 1
     * result : [{"resumeId":"361","fullname":"测试试用申请","sex":"男","mobile":"","idNo":"371327199001010011","vehicleClass":"A1,A2"}]
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
         * resumeId : 361
         * fullname : 测试试用申请
         * sex : 男
         * mobile :
         * idNo : 371327199001010011
         * vehicleClass : A1,A2
         */

        private String resumeId;
        private String fullname;
        private String sex;
        private String mobile;
        private String idNo;
        private String vehicleClass;

        public String getResumeId() {
            return resumeId;
        }

        public void setResumeId(String resumeId) {
            this.resumeId = resumeId;
        }

        public String getFullname() {
            return fullname;
        }

        public void setFullname(String fullname) {
            this.fullname = fullname;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getIdNo() {
            return idNo;
        }

        public void setIdNo(String idNo) {
            this.idNo = idNo;
        }

        public String getVehicleClass() {
            return vehicleClass;
        }

        public void setVehicleClass(String vehicleClass) {
            this.vehicleClass = vehicleClass;
        }
    }
}
