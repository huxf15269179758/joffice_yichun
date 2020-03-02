package com.hy.powerplatform.statist.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/12/21.
 */

public class PersonTongJi implements Serializable {

    /**
     * success : true
     * totalCounts : 8
     * result : [{"position":"辅助岗","total":"100"},{"position":"广告/出租/乐途/春城通","total":"24"},{"position":"驾驶员","total":"736"},{"position":"退休退养","total":"10"},{"position":"未在岗","total":"13"},{"position":"行政机关","total":"84"},{"position":"修理工","total":"39"},{"position":"营运分公司及修理厂工作人员","total":"58"}]
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
         * position : 辅助岗
         * total : 100
         */

        private String position;
        private String total;

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }
    }
}
