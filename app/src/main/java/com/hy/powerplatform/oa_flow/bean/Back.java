package com.hy.powerplatform.oa_flow.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/7/24.
 */

public class Back implements Serializable {

    /**
     * success : true
     * totalCounts : 2
     * result : [{"version":null,"orgId":null,"orgPath":null,"id":6,"runId":"51880","piId":"WPCGJHB3000YYS4.9030170","assignee":"9406","preTaskName":"部门负责人","status":"3","neednum":1,"alreadnum":1,"revokeReason":"采购数量有误，申请撤回","revokeDate":"20190708","revokePerson":"陆卫敏","subject":"物品采购计划表3000元以上_罗文杰","alreadAssignee":"9407","currentAssignee":"9407"},{"version":null,"orgId":null,"orgPath":null,"id":7,"runId":"51912","piId":"WPCGJHB3000YYS4.9160001","assignee":"9354","preTaskName":"部门负责人","status":"2","neednum":1,"alreadnum":1,"revokeReason":"","revokeDate":"20190724","revokePerson":"欧阳晓林","subject":"物品采购计划表3000元以上_施鹏","alreadAssignee":"9407","currentAssignee":"9407"}]
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
         * version : null
         * orgId : null
         * orgPath : null
         * id : 6
         * runId : 51880
         * piId : WPCGJHB3000YYS4.9030170
         * assignee : 9406
         * preTaskName : 部门负责人
         * status : 3
         * neednum : 1
         * alreadnum : 1
         * revokeReason : 采购数量有误，申请撤回
         * revokeDate : 20190708
         * revokePerson : 陆卫敏
         * subject : 物品采购计划表3000元以上_罗文杰
         * alreadAssignee : 9407
         * currentAssignee : 9407
         */

        private Object version;
        private Object orgId;
        private Object orgPath;
        private String id;
        private String runId;
        private String piId;
        private String assignee;
        private String preTaskName;
        private String status;
        private int neednum;
        private int alreadnum;
        private String revokeReason;
        private String revokeDate;
        private String revokePerson;
        private String subject;
        private String alreadAssignee;
        private String currentAssignee;

        public Object getVersion() {
            return version;
        }

        public void setVersion(Object version) {
            this.version = version;
        }

        public Object getOrgId() {
            return orgId;
        }

        public void setOrgId(Object orgId) {
            this.orgId = orgId;
        }

        public Object getOrgPath() {
            return orgPath;
        }

        public void setOrgPath(Object orgPath) {
            this.orgPath = orgPath;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getRunId() {
            return runId;
        }

        public void setRunId(String runId) {
            this.runId = runId;
        }

        public String getPiId() {
            return piId;
        }

        public void setPiId(String piId) {
            this.piId = piId;
        }

        public String getAssignee() {
            return assignee;
        }

        public void setAssignee(String assignee) {
            this.assignee = assignee;
        }

        public String getPreTaskName() {
            return preTaskName;
        }

        public void setPreTaskName(String preTaskName) {
            this.preTaskName = preTaskName;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public int getNeednum() {
            return neednum;
        }

        public void setNeednum(int neednum) {
            this.neednum = neednum;
        }

        public int getAlreadnum() {
            return alreadnum;
        }

        public void setAlreadnum(int alreadnum) {
            this.alreadnum = alreadnum;
        }

        public String getRevokeReason() {
            return revokeReason;
        }

        public void setRevokeReason(String revokeReason) {
            this.revokeReason = revokeReason;
        }

        public String getRevokeDate() {
            return revokeDate;
        }

        public void setRevokeDate(String revokeDate) {
            this.revokeDate = revokeDate;
        }

        public String getRevokePerson() {
            return revokePerson;
        }

        public void setRevokePerson(String revokePerson) {
            this.revokePerson = revokePerson;
        }

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public String getAlreadAssignee() {
            return alreadAssignee;
        }

        public void setAlreadAssignee(String alreadAssignee) {
            this.alreadAssignee = alreadAssignee;
        }

        public String getCurrentAssignee() {
            return currentAssignee;
        }

        public void setCurrentAssignee(String currentAssignee) {
            this.currentAssignee = currentAssignee;
        }
    }
}
