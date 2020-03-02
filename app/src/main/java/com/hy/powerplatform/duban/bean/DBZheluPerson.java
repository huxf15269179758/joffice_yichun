package com.hy.powerplatform.duban.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/12/16.
 */

public class DBZheluPerson implements Serializable {

    /**
     * success : true
     * totalCounts : 7
     * result : [{"fullname":"黄雅馨","userId":9438},{"fullname":"刘娟","userId":9439},{"fullname":"王晨","userId":9441},{"fullname":"易祺","userId":9443},{"fullname":"苏倩","userId":9440},{"fullname":"易成玉","userId":10238},{"fullname":"易臣倩","userId":9442}]
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

    public static class ResultBean implements Serializable{
        /**
         * fullname : 黄雅馨
         * userId : 9438
         */

        private String fullname;
        private String userId;

        public String getFullname() {
            return fullname;
        }

        public void setFullname(String fullname) {
            this.fullname = fullname;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }
    }
}
