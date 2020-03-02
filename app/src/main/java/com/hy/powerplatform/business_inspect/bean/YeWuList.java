package com.hy.powerplatform.business_inspect.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/6/28.
 */

public class YeWuList implements Serializable {

    /**
     * success : true
     * totalCounts : 3
     * result : [{"id":"75","carNo":"晋K00020","busCode":"428","jcDate":"2018-06-28","xcgCode":"39101","xcgName":"安永前","jcrCode":"101866","jcr":"白峰","jcrDepId":"921","jcrDepName":"运调科","note":"","projects":[{}]},{"id":"76","carNo":"晋K00020","busCode":"428","jcDate":"2018-06-28","xcgCode":"39101","xcgName":"安永前","jcrCode":"101866","jcr":"白峰","jcrDepId":"921","jcrDepName":"运调科","note":"","projects":[{}]},{"id":"77","carNo":"晋K00018","busCode":"427","jcDate":"2018-06-28","xcgCode":"38577","xcgName":"安桂香","jcrCode":"101866","jcr":"白峰","jcrDepId":"921","jcrDepName":"运调科","note":"","projects":[{}]}]
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
         * id : 75
         * carNo : 晋K00020
         * busCode : 428
         * jcDate : 2018-06-28
         * xcgCode : 39101
         * xcgName : 安永前
         * jcrCode : 101866
         * jcr : 白峰
         * jcrDepId : 921
         * jcrDepName : 运调科
         * note :
         * projects : [{}]
         */

        private String id;
        private String carNo;
        private String busCode;
        private String jcDate;
        private String xcgCode;
        private String xcgName;
        private String jcrCode;
        private String jcr;
        private String jcrDepId;
        private String jcrDepName;
        private String note;
        private List<ProjectsBean> projects;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCarNo() {
            return carNo;
        }

        public void setCarNo(String carNo) {
            this.carNo = carNo;
        }

        public String getBusCode() {
            return busCode;
        }

        public void setBusCode(String busCode) {
            this.busCode = busCode;
        }

        public String getJcDate() {
            return jcDate;
        }

        public void setJcDate(String jcDate) {
            this.jcDate = jcDate;
        }

        public String getXcgCode() {
            return xcgCode;
        }

        public void setXcgCode(String xcgCode) {
            this.xcgCode = xcgCode;
        }

        public String getXcgName() {
            return xcgName;
        }

        public void setXcgName(String xcgName) {
            this.xcgName = xcgName;
        }

        public String getJcrCode() {
            return jcrCode;
        }

        public void setJcrCode(String jcrCode) {
            this.jcrCode = jcrCode;
        }

        public String getJcr() {
            return jcr;
        }

        public void setJcr(String jcr) {
            this.jcr = jcr;
        }

        public String getJcrDepId() {
            return jcrDepId;
        }

        public void setJcrDepId(String jcrDepId) {
            this.jcrDepId = jcrDepId;
        }

        public String getJcrDepName() {
            return jcrDepName;
        }

        public void setJcrDepName(String jcrDepName) {
            this.jcrDepName = jcrDepName;
        }

        public String getNote() {
            return note;
        }

        public void setNote(String note) {
            this.note = note;
        }

        public List<ProjectsBean> getProjects() {
            return projects;
        }

        public void setProjects(List<ProjectsBean> projects) {
            this.projects = projects;
        }

        public static class ProjectsBean {
        }
    }
}
