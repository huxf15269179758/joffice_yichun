package com.hy.powerplatform.duban.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/12/6.
 */

public class DBCKLIST implements Serializable {

    /**
     * success : true
     * totalCounts : 2
     * result : [{"version":null,"orgId":null,"orgPath":null,"operId":195,"workId":176,"operator":9354,"operatorName":"欧阳晓林","operStatus":8,"operTime":"2019-12-04 19:18:58","submitTitle":null,"submitContext":null,"fileIds":null,"publishTime":"2019-12-04 19:08:37","operLog":null,"memo":null,"updateType":null,"num":null,"statusName":null,"statusType":null,"annotation":null,"identUrge":null,"judgeSMSzxr":null,"judgeSMSdbr":"20191205","superWorkTask":null,"superTaskOperFiles":[]},{"version":null,"orgId":null,"orgPath":null,"operId":200,"workId":176,"operator":9354,"operatorName":"欧阳晓林","operStatus":1,"operTime":null,"submitTitle":null,"submitContext":null,"fileIds":null,"publishTime":"2019-12-06 09:50:05","operLog":null,"memo":null,"updateType":null,"num":null,"statusName":null,"statusType":null,"annotation":null,"identUrge":null,"judgeSMSzxr":null,"judgeSMSdbr":null,"superWorkTask":null,"superTaskOperFiles":[]}]
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
         * operId : 195
         * workId : 176
         * operator : 9354
         * operatorName : 欧阳晓林
         * operStatus : 8
         * operTime : 2019-12-04 19:18:58
         * submitTitle : null
         * submitContext : null
         * fileIds : null
         * publishTime : 2019-12-04 19:08:37
         * operLog : null
         * memo : null
         * updateType : null
         * num : null
         * statusName : null
         * statusType : null
         * annotation : null
         * identUrge : null
         * judgeSMSzxr : null
         * judgeSMSdbr : 20191205
         * superWorkTask : null
         * superTaskOperFiles : []
         */

        private String version;
        private String orgId;
        private String orgPath;
        private int operId;
        private int workId;
        private int operator;
        private String operatorName;
        private int operStatus;
        private String operTime;
        private String submitTitle;
        private String submitContext;
        private String fileIds;
        private String publishTime;
        private String operLog;
        private String memo;
        private String updateType;
        private String num;
        private String statusName;
        private String statusType;
        private String annotation;
        private String identUrge;
        private String judgeSMSzxr;
        private String judgeSMSdbr;
        private String superWorkTask;
        private List<?> superTaskOperFiles;

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getOrgId() {
            return orgId;
        }

        public void setOrgId(String orgId) {
            this.orgId = orgId;
        }

        public String getOrgPath() {
            return orgPath;
        }

        public void setOrgPath(String orgPath) {
            this.orgPath = orgPath;
        }

        public int getOperId() {
            return operId;
        }

        public void setOperId(int operId) {
            this.operId = operId;
        }

        public int getWorkId() {
            return workId;
        }

        public void setWorkId(int workId) {
            this.workId = workId;
        }

        public int getOperator() {
            return operator;
        }

        public void setOperator(int operator) {
            this.operator = operator;
        }

        public String getOperatorName() {
            return operatorName;
        }

        public void setOperatorName(String operatorName) {
            this.operatorName = operatorName;
        }

        public int getOperStatus() {
            return operStatus;
        }

        public void setOperStatus(int operStatus) {
            this.operStatus = operStatus;
        }

        public String getOperTime() {
            return operTime;
        }

        public void setOperTime(String operTime) {
            this.operTime = operTime;
        }

        public String getSubmitTitle() {
            return submitTitle;
        }

        public void setSubmitTitle(String submitTitle) {
            this.submitTitle = submitTitle;
        }

        public String getSubmitContext() {
            return submitContext;
        }

        public void setSubmitContext(String submitContext) {
            this.submitContext = submitContext;
        }

        public String getFileIds() {
            return fileIds;
        }

        public void setFileIds(String fileIds) {
            this.fileIds = fileIds;
        }

        public String getPublishTime() {
            return publishTime;
        }

        public void setPublishTime(String publishTime) {
            this.publishTime = publishTime;
        }

        public String getOperLog() {
            return operLog;
        }

        public void setOperLog(String operLog) {
            this.operLog = operLog;
        }

        public String getMemo() {
            return memo;
        }

        public void setMemo(String memo) {
            this.memo = memo;
        }

        public String getUpdateType() {
            return updateType;
        }

        public void setUpdateType(String updateType) {
            this.updateType = updateType;
        }

        public String getNum() {
            return num;
        }

        public void setNum(String num) {
            this.num = num;
        }

        public String getStatusName() {
            return statusName;
        }

        public void setStatusName(String statusName) {
            this.statusName = statusName;
        }

        public String getStatusType() {
            return statusType;
        }

        public void setStatusType(String statusType) {
            this.statusType = statusType;
        }

        public String getAnnotation() {
            return annotation;
        }

        public void setAnnotation(String annotation) {
            this.annotation = annotation;
        }

        public String getIdentUrge() {
            return identUrge;
        }

        public void setIdentUrge(String identUrge) {
            this.identUrge = identUrge;
        }

        public String getJudgeSMSzxr() {
            return judgeSMSzxr;
        }

        public void setJudgeSMSzxr(String judgeSMSzxr) {
            this.judgeSMSzxr = judgeSMSzxr;
        }

        public String getJudgeSMSdbr() {
            return judgeSMSdbr;
        }

        public void setJudgeSMSdbr(String judgeSMSdbr) {
            this.judgeSMSdbr = judgeSMSdbr;
        }

        public String getSuperWorkTask() {
            return superWorkTask;
        }

        public void setSuperWorkTask(String superWorkTask) {
            this.superWorkTask = superWorkTask;
        }

        public List<?> getSuperTaskOperFiles() {
            return superTaskOperFiles;
        }

        public void setSuperTaskOperFiles(List<?> superTaskOperFiles) {
            this.superTaskOperFiles = superTaskOperFiles;
        }
    }
}
