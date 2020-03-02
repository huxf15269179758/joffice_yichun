package com.hy.powerplatform.oa_flow.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/2/25.
 */

public class MyNum implements Serializable {

    /**
     * success : true
     * totalCounts : 2
     * result : [{"processName":"员工请假流程","formDefId":"83","sl":"1"},{"processName":"付款程序审批单","formDefId":"10078","sl":"7"}]
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

    public static class ResultBean {
        /**
         * processName : 员工请假流程
         * formDefId : 83
         * sl : 1
         */

        private String processName;
        private String formDefId;
        private String sl;

        public String getProcessName() {
            return processName;
        }

        public void setProcessName(String processName) {
            this.processName = processName;
        }

        public String getFormDefId() {
            return formDefId;
        }

        public void setFormDefId(String formDefId) {
            this.formDefId = formDefId;
        }

        public String getSl() {
            return sl;
        }

        public void setSl(String sl) {
            this.sl = sl;
        }
    }
}
