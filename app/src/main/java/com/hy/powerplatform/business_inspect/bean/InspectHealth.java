package com.hy.powerplatform.business_inspect.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by dell on 2018/5/9.
 */

public class InspectHealth implements Serializable {

    /**
     * success : true
     * totalCounts : 9
     * result : [{"id":132,"type":"服务卫生类","projectName":"车容整洁"},{"id":133,"type":"服务卫生类","projectName":"车长卫生区"},{"id":134,"type":"服务卫生类","projectName":"服务设施"},{"id":135,"type":"服务卫生类","projectName":"着装仪容"},{"id":136,"type":"服务卫生类","projectName":"普通话应用"},{"id":137,"type":"服务卫生类","projectName":"服务质量"},{"id":138,"type":"服务卫生类","projectName":"文明驾驶"},{"id":139,"type":"服务卫生类","projectName":"执行票制"},{"id":140,"type":"服务卫生类","projectName":"遵章守纪"}]
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
         * id : 132
         * type : 服务卫生类
         * projectName : 车容整洁
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
