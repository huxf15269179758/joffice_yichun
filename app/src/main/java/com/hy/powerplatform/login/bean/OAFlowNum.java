package com.hy.powerplatform.login.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2020/1/6.
 */

public class OAFlowNum implements Serializable {

    /**
     * success : true
     * totalCounts : 4
     * result : [{"name":"未启动","num":"0"},{"name":"正在运行","num":"144"},{"name":"运行结束","num":"701"},{"name":"废弃","num":"127"}]
     */

    private boolean success;
    private int totalCounts;
    private String mag;
    private List<ResultBean> result;

    public String getMag() {
        return mag;
    }

    public void setMag(String msg) {
        this.mag = msg;
    }

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
         * name : 未启动
         * num : 0
         */

        private String name;
        private String num;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getNum() {
            return num;
        }

        public void setNum(String num) {
            this.num = num;
        }
    }
}
