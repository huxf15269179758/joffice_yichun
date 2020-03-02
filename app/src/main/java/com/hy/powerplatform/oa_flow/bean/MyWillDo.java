package com.hy.powerplatform.oa_flow.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/3/6.
 */

public class MyWillDo implements Serializable {


    /**
     * success : true
     * totalCounts : 1
     * result : [{"taskName":"物品采购计划表","activityName":"部门负责人","assignee":"欧阳晓林","createTime":"2019-5-27 10:20:29","executionId":"WPCGJHB7.8740346","isDue":0,"piId":"WPCGJHB7.8740346","taskId":8740386,"formDefId":84,"showData":"微信公众号年审","creator":"漆明","state":"open","isMultipleTask":0,"candidateUsers":"","candidateRoles":""}]
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
         * taskName : 物品采购计划表
         * activityName : 部门负责人
         * assignee : 欧阳晓林
         * createTime : 2019-5-27 10:20:29
         * executionId : WPCGJHB7.8740346
         * isDue : 0
         * piId : WPCGJHB7.8740346
         * taskId : 8740386
         * formDefId : 84
         * showData : 微信公众号年审
         * creator : 漆明
         * state : open
         * isMultipleTask : 0
         * candidateUsers :
         * candidateRoles :
         */

        private String taskName;
        private String activityName;
        private String assignee;
        private String createTime;
        private String executionId;
        private String isDue;
        private String piId;
        private String taskId;
        private String formDefId;
        private String showData;
        private String creator;
        private String state;
        private String isMultipleTask;
        private String candidateUsers;
        private String candidateRoles;

        public String getTaskName() {
            return taskName;
        }

        public void setTaskName(String taskName) {
            this.taskName = taskName;
        }

        public String getActivityName() {
            return activityName;
        }

        public void setActivityName(String activityName) {
            this.activityName = activityName;
        }

        public String getAssignee() {
            return assignee;
        }

        public void setAssignee(String assignee) {
            this.assignee = assignee;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getExecutionId() {
            return executionId;
        }

        public void setExecutionId(String executionId) {
            this.executionId = executionId;
        }

        public String getIsDue() {
            return isDue;
        }

        public void setIsDue(String isDue) {
            this.isDue = isDue;
        }

        public String getPiId() {
            return piId;
        }

        public void setPiId(String piId) {
            this.piId = piId;
        }

        public String getTaskId() {
            return taskId;
        }

        public void setTaskId(String taskId) {
            this.taskId = taskId;
        }

        public String getFormDefId() {
            return formDefId;
        }

        public void setFormDefId(String formDefId) {
            this.formDefId = formDefId;
        }

        public String getShowData() {
            return showData;
        }

        public void setShowData(String showData) {
            this.showData = showData;
        }

        public String getCreator() {
            return creator;
        }

        public void setCreator(String creator) {
            this.creator = creator;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getIsMultipleTask() {
            return isMultipleTask;
        }

        public void setIsMultipleTask(String isMultipleTask) {
            this.isMultipleTask = isMultipleTask;
        }

        public String getCandidateUsers() {
            return candidateUsers;
        }

        public void setCandidateUsers(String candidateUsers) {
            this.candidateUsers = candidateUsers;
        }

        public String getCandidateRoles() {
            return candidateRoles;
        }

        public void setCandidateRoles(String candidateRoles) {
            this.candidateRoles = candidateRoles;
        }
    }
}
