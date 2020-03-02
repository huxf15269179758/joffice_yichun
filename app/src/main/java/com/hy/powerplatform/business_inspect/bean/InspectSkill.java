package com.hy.powerplatform.business_inspect.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by dell on 2018/5/9.
 */

public class InspectSkill implements Serializable {


    /**
     * success : true
     * totalCounts : 5
     * result : [{"id":201,"type":"运营车辆技术状况","projectName":"内部设施"},{"id":202,"type":"运营车辆技术状况","projectName":"车身外表"},{"id":203,"type":"运营车辆技术状况","projectName":"灯光部分"},{"id":205,"type":"运营车辆技术状况","projectName":"发动机"},{"id":206,"type":"运营车辆技术状况","projectName":"三漏(气、水、电)"}]
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
         * id : 201
         * type : 运营车辆技术状况
         * projectName : 内部设施
         */

        private int id;
        private String type;
        private String projectName;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getProjectName() {
            return projectName;
        }

        public void setProjectName(String projectName) {
            this.projectName = projectName;
        }
    }
}
