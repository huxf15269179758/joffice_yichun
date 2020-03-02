package com.hy.powerplatform.oa_flow.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/1/19.
 */

public class QingJiaWillDo implements Serializable {

    /**
     * success : true
     * totalCounts : 1
     * result : [{"taskName":"测试","activityName":"测试","assignee":"超级管理员","createTime":"2019-1-7 10:47:29","executionId":"CSLC20192.6890069","isDue":0,"piId":"CSLC20192.6890069","taskId":6890090,"state":"open","isMultipleTask":0,"candidateUsers":"","candidateRoles":""}]
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
         * taskName : 测试
         * activityName : 测试
         * assignee : 超级管理员
         * createTime : 2019-1-7 10:47:29
         * executionId : CSLC20192.6890069
         * isDue : 0
         * piId : CSLC20192.6890069
         * taskId : 6890090
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
