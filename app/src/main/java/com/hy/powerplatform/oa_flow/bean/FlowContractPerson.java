package com.hy.powerplatform.oa_flow.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/1/25.
 */

public class FlowContractPerson implements Serializable {


    /**
     * success : true
     * data : [{"role":"分管领导","userCodes":9387,"userNames":"唐根六","route":"","type":""}]
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

    public static class DataBean {
        /**
         * role : 分管领导
         * userCodes : 9387
         * userNames : 唐根六
         * route :
         * type :
         */

        private String role;
        private String userCodes;
        private String userNames;
        private String route;
        private String type;

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public String getUserCodes() {
            return userCodes;
        }

        public void setUserCodes(String userCodes) {
            this.userCodes = userCodes;
        }

        public String getUserNames() {
            return userNames;
        }

        public void setUserNames(String userNames) {
            this.userNames = userNames;
        }

        public String getRoute() {
            return route;
        }

        public void setRoute(String route) {
            this.route = route;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}
