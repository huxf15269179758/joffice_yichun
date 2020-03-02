package com.hy.powerplatform.oa_flow.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/1/23.
 */

public class QianZhiData implements Serializable{

    /**
     * success : true
     * data : [{"route":"\"to 用户任务2\"","role":"\"分管领导\"","type":"\"task\"","userNames":"\"9389","userCodes":"袁斌\""},{"route":"\"to 人力资源部\"","role":"\"人力资源部\"","type":"\"task\"","userNames":"\"9370,9404,9377,9376,9348","userCodes":"周青,谭军,林婕,李建萍,刘竹梅\""}]
     */

    private boolean success;
    private List<DataBean> data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean implements Serializable {
        /**
         * route : "to 用户任务2"
         * role : "分管领导"
         * type : "task"
         * userNames : "9389
         * userCodes : 袁斌"
         */

        private String route;
        private String role;
        private String type;
        private String userNames;
        private String userCodes;

        public String getRoute() {
            return route;
        }

        public void setRoute(String route) {
            this.route = route;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUserNames() {
            return userNames;
        }

        public void setUserNames(String userNames) {
            this.userNames = userNames;
        }

        public String getUserCodes() {
            return userCodes;
        }

        public void setUserCodes(String userCodes) {
            this.userCodes = userCodes;
        }
    }
}
