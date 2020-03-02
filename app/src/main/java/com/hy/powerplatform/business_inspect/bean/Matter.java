package com.hy.powerplatform.business_inspect.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by dell on 2018/6/7.
 */

public class Matter implements Serializable {

    /**
     * success : true
     * totalCounts : 2
     * result : [{"projectId":102,"projectName":"测试","fkje":-3.75,"state":1,"projectKey":"WGJCJFWSCS"},{"projectId":103,"projectName":"测试2","fkje":-3.25,"state":1,"projectKey":"WGJCJFWSCS2"}]
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
         * projectId : 102
         * projectName : 测试
         * fkje : -3.75
         * state : 1
         * projectKey : WGJCJFWSCS
         */

        private int projectId;
        private String projectName;
        private double fkje;
        private int state;
        private String projectKey;

        public int getProjectId() {
            return projectId;
        }

        public void setProjectId(int projectId) {
            this.projectId = projectId;
        }

        public String getProjectName() {
            return projectName;
        }

        public void setProjectName(String projectName) {
            this.projectName = projectName;
        }

        public double getFkje() {
            return fkje;
        }

        public void setFkje(double fkje) {
            this.fkje = fkje;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public String getProjectKey() {
            return projectKey;
        }

        public void setProjectKey(String projectKey) {
            this.projectKey = projectKey;
        }
    }
}
