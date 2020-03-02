package com.hy.powerplatform.login.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2020/1/8.
 */

public class WillDoNum implements Serializable {

    /**
     * success : true
     * totalCounts : 9
     * result : [{"taskName":"接待用餐审批表","activityName":"部门负责人","assignee":"欧阳晓林","createTime":"2020-01-06 19:17:09","executionId":"JDYCSPB_.9910001","isDue":0,"piId":"JDYCSPB_.9910001","taskId":9910020,"formDefId":62,"showData":" ","creator":"超级管理员","state":"open","isMultipleTask":0,"candidateUsers":"","candidateRoles":""},{"taskName":"物品采购计划表3000元以上","activityName":"部门负责人","assignee":"欧阳晓林","createTime":"2020-01-04 13:42:24","executionId":"WPCGJHB3000YYS4.9890001","isDue":0,"piId":"WPCGJHB3000YYS4.9890001","taskId":9890061,"formDefId":10103,"showData":"测试新单据","creator":"超级管理员","state":"open","isMultipleTask":0,"candidateUsers":"","candidateRoles":""},{"taskName":"物品采购计划表3000元以上","activityName":"部门负责人","assignee":"欧阳晓林","createTime":"2020-01-04 11:17:38","executionId":"WPCGJHB3000YYS4.9840384","isDue":0,"piId":"WPCGJHB3000YYS4.9840384","taskId":9840437,"formDefId":10103,"showData":"","creator":"超级管理员","state":"open","isMultipleTask":0,"candidateUsers":"","candidateRoles":""},{"taskName":"物品采购计划表3000元以上","activityName":"部门负责人","assignee":"欧阳晓林","createTime":"2020-01-04 11:02:44","executionId":"WPCGJHB3000YYS4.9840322","isDue":0,"piId":"WPCGJHB3000YYS4.9840322","taskId":9840382,"formDefId":10103,"showData":" ","creator":"超级管理员","state":"open","isMultipleTask":0,"candidateUsers":"","candidateRoles":""},{"taskName":"物品采购计划表3000元以上","activityName":"部门负责人","assignee":"欧阳晓林","createTime":"2020-01-02 17:30:04","executionId":"WPCGJHB3000YYS4.9840146","isDue":0,"piId":"WPCGJHB3000YYS4.9840146","taskId":9840206,"formDefId":10103,"showData":"测试","creator":"超级管理员","state":"open","isMultipleTask":0,"candidateUsers":"","candidateRoles":""},{"taskName":"合同签订审批流程","activityName":"部门负责人","assignee":"欧阳晓林","createTime":"2019-12-27 13:58:46","executionId":"GTQDSPLC1.9760172","isDue":0,"piId":"GTQDSPLC1.9760172","taskId":9760191,"formDefId":66,"showData":"合同调岗测试2019年12月27日","creator":"超级管理员","state":"open","isMultipleTask":0,"candidateUsers":"","candidateRoles":""},{"taskName":"付款程序审批单","activityName":"部门负责人","assignee":"欧阳晓林","createTime":"2019-12-27 13:54:26","executionId":"FKCXSPS1.9760148","isDue":0,"piId":"FKCXSPS1.9760148","taskId":9760170,"formDefId":10078,"showData":"付款程序调岗测试2019年12月27日","creator":"超级管理员","state":"open","isMultipleTask":0,"candidateUsers":"","candidateRoles":""},{"taskName":"物品采购计划表3000元以上","activityName":"部门负责人","assignee":"欧阳晓林","createTime":"2019-12-27 13:52:19","executionId":"WPCGJHB3000YYS4.9760088","isDue":0,"piId":"WPCGJHB3000YYS4.9760088","taskId":9760146,"formDefId":10103,"showData":"采购3000调岗2019年12月27日","creator":"超级管理员","state":"open","isMultipleTask":0,"candidateUsers":"","candidateRoles":""},{"taskName":"物品采购计划表","activityName":"部门负责人","assignee":"欧阳晓林","createTime":"2019-12-27 13:50:48","executionId":"WPCGJHB7.9760031","isDue":0,"piId":"WPCGJHB7.9760031","taskId":9760086,"formDefId":84,"showData":"采购调岗测试2019年12月27日","creator":"超级管理员","state":"open","isMultipleTask":0,"candidateUsers":"","candidateRoles":""}]
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
         * taskName : 接待用餐审批表
         * activityName : 部门负责人
         * assignee : 欧阳晓林
         * createTime : 2020-01-06 19:17:09
         * executionId : JDYCSPB_.9910001
         * isDue : 0
         * piId : JDYCSPB_.9910001
         * taskId : 9910020
         * formDefId : 62
         * showData :
         * creator : 超级管理员
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
        private int isDue;
        private String piId;
        private int taskId;
        private int formDefId;
        private String showData;
        private String creator;
        private String state;
        private int isMultipleTask;
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

        public int getIsDue() {
            return isDue;
        }

        public void setIsDue(int isDue) {
            this.isDue = isDue;
        }

        public String getPiId() {
            return piId;
        }

        public void setPiId(String piId) {
            this.piId = piId;
        }

        public int getTaskId() {
            return taskId;
        }

        public void setTaskId(int taskId) {
            this.taskId = taskId;
        }

        public int getFormDefId() {
            return formDefId;
        }

        public void setFormDefId(int formDefId) {
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

        public int getIsMultipleTask() {
            return isMultipleTask;
        }

        public void setIsMultipleTask(int isMultipleTask) {
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
