package com.hy.powerplatform.duban.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/12/16.
 */

public class DBFile implements Serializable {

    /**
     * success : true
     * data : {"version":null,"orgId":null,"orgPath":null,"workId":220,"taskType":"公司任务","taskName":"美人迟暮4","taskContext":"英雄落幕4","planFinishTime":"2019-12-16 13:26:54","fileIds":"9422","supervisorIds":"9386,9387,9398,9408,1","supervisorNames":"王少云,唐根六,晏慧锋,余清华,超级管理员","operatorIds":"9546","operatorNames":"王少科","taskStatus":3,"creater":"1","createTime":"2019-12-16 13:27:28","updateTime":"2019-12-16 15:26:58","approver":1,"approveTime":"2019-12-16 15:27:28","fileNames":null,"createrName":"超级管理员","approverName":"超级管理员","statusName":null,"contactsName":"超级管理员","contactsId":"1","superWorkTaskFiles":[{"version":null,"orgId":null,"orgPath":null,"fileId":9422,"fileName":"ERP各地区访问地址及密码.txt","filePath":"others/201912/563a57347ca64cc88f250a1e8804b02d.txt","createtime":"2019-12-16 13:27:20","ext":"txt","fileType":"others","note":"777.0 bytes","creator":"超级管理员","creatorId":1,"totalBytes":777,"delFlag":0,"globalType":null,"id":9422,"firstKeyColumnName":"fileId"}]}
     */

    private boolean success;
    private DataBean data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean implements Serializable{
        /**
         * version : null
         * orgId : null
         * orgPath : null
         * workId : 220
         * taskType : 公司任务
         * taskName : 美人迟暮4
         * taskContext : 英雄落幕4
         * planFinishTime : 2019-12-16 13:26:54
         * fileIds : 9422
         * supervisorIds : 9386,9387,9398,9408,1
         * supervisorNames : 王少云,唐根六,晏慧锋,余清华,超级管理员
         * operatorIds : 9546
         * operatorNames : 王少科
         * taskStatus : 3
         * creater : 1
         * createTime : 2019-12-16 13:27:28
         * updateTime : 2019-12-16 15:26:58
         * approver : 1
         * approveTime : 2019-12-16 15:27:28
         * fileNames : null
         * createrName : 超级管理员
         * approverName : 超级管理员
         * statusName : null
         * contactsName : 超级管理员
         * contactsId : 1
         * superWorkTaskFiles : [{"version":null,"orgId":null,"orgPath":null,"fileId":9422,"fileName":"ERP各地区访问地址及密码.txt","filePath":"others/201912/563a57347ca64cc88f250a1e8804b02d.txt","createtime":"2019-12-16 13:27:20","ext":"txt","fileType":"others","note":"777.0 bytes","creator":"超级管理员","creatorId":1,"totalBytes":777,"delFlag":0,"globalType":null,"id":9422,"firstKeyColumnName":"fileId"}]
         */

        private Object version;
        private Object orgId;
        private Object orgPath;
        private int workId;
        private String taskType;
        private String taskName;
        private String taskContext;
        private String planFinishTime;
        private String fileIds;
        private String supervisorIds;
        private String supervisorNames;
        private String operatorIds;
        private String operatorNames;
        private int taskStatus;
        private String creater;
        private String createTime;
        private String updateTime;
        private int approver;
        private String approveTime;
        private Object fileNames;
        private String createrName;
        private String approverName;
        private Object statusName;
        private String contactsName;
        private String contactsId;
        private List<SuperWorkTaskFilesBean> superWorkTaskFiles;

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

        public int getWorkId() {
            return workId;
        }

        public void setWorkId(int workId) {
            this.workId = workId;
        }

        public String getTaskType() {
            return taskType;
        }

        public void setTaskType(String taskType) {
            this.taskType = taskType;
        }

        public String getTaskName() {
            return taskName;
        }

        public void setTaskName(String taskName) {
            this.taskName = taskName;
        }

        public String getTaskContext() {
            return taskContext;
        }

        public void setTaskContext(String taskContext) {
            this.taskContext = taskContext;
        }

        public String getPlanFinishTime() {
            return planFinishTime;
        }

        public void setPlanFinishTime(String planFinishTime) {
            this.planFinishTime = planFinishTime;
        }

        public String getFileIds() {
            return fileIds;
        }

        public void setFileIds(String fileIds) {
            this.fileIds = fileIds;
        }

        public String getSupervisorIds() {
            return supervisorIds;
        }

        public void setSupervisorIds(String supervisorIds) {
            this.supervisorIds = supervisorIds;
        }

        public String getSupervisorNames() {
            return supervisorNames;
        }

        public void setSupervisorNames(String supervisorNames) {
            this.supervisorNames = supervisorNames;
        }

        public String getOperatorIds() {
            return operatorIds;
        }

        public void setOperatorIds(String operatorIds) {
            this.operatorIds = operatorIds;
        }

        public String getOperatorNames() {
            return operatorNames;
        }

        public void setOperatorNames(String operatorNames) {
            this.operatorNames = operatorNames;
        }

        public int getTaskStatus() {
            return taskStatus;
        }

        public void setTaskStatus(int taskStatus) {
            this.taskStatus = taskStatus;
        }

        public String getCreater() {
            return creater;
        }

        public void setCreater(String creater) {
            this.creater = creater;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public int getApprover() {
            return approver;
        }

        public void setApprover(int approver) {
            this.approver = approver;
        }

        public String getApproveTime() {
            return approveTime;
        }

        public void setApproveTime(String approveTime) {
            this.approveTime = approveTime;
        }

        public Object getFileNames() {
            return fileNames;
        }

        public void setFileNames(Object fileNames) {
            this.fileNames = fileNames;
        }

        public String getCreaterName() {
            return createrName;
        }

        public void setCreaterName(String createrName) {
            this.createrName = createrName;
        }

        public String getApproverName() {
            return approverName;
        }

        public void setApproverName(String approverName) {
            this.approverName = approverName;
        }

        public Object getStatusName() {
            return statusName;
        }

        public void setStatusName(Object statusName) {
            this.statusName = statusName;
        }

        public String getContactsName() {
            return contactsName;
        }

        public void setContactsName(String contactsName) {
            this.contactsName = contactsName;
        }

        public String getContactsId() {
            return contactsId;
        }

        public void setContactsId(String contactsId) {
            this.contactsId = contactsId;
        }

        public List<SuperWorkTaskFilesBean> getSuperWorkTaskFiles() {
            return superWorkTaskFiles;
        }

        public void setSuperWorkTaskFiles(List<SuperWorkTaskFilesBean> superWorkTaskFiles) {
            this.superWorkTaskFiles = superWorkTaskFiles;
        }

        public static class SuperWorkTaskFilesBean {
            /**
             * version : null
             * orgId : null
             * orgPath : null
             * fileId : 9422
             * fileName : ERP各地区访问地址及密码.txt
             * filePath : others/201912/563a57347ca64cc88f250a1e8804b02d.txt
             * createtime : 2019-12-16 13:27:20
             * ext : txt
             * fileType : others
             * note : 777.0 bytes
             * creator : 超级管理员
             * creatorId : 1
             * totalBytes : 777
             * delFlag : 0
             * globalType : null
             * id : 9422
             * firstKeyColumnName : fileId
             */

            private Object version;
            private Object orgId;
            private Object orgPath;
            private String fileId;
            private String fileName;
            private String filePath;
            private String createtime;
            private String ext;
            private String fileType;
            private String note;
            private String creator;
            private int creatorId;
            private int totalBytes;
            private int delFlag;
            private Object globalType;
            private int id;
            private String firstKeyColumnName;

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

            public String getFileId() {
                return fileId;
            }

            public void setFileId(String fileId) {
                this.fileId = fileId;
            }

            public String getFileName() {
                return fileName;
            }

            public void setFileName(String fileName) {
                this.fileName = fileName;
            }

            public String getFilePath() {
                return filePath;
            }

            public void setFilePath(String filePath) {
                this.filePath = filePath;
            }

            public String getCreatetime() {
                return createtime;
            }

            public void setCreatetime(String createtime) {
                this.createtime = createtime;
            }

            public String getExt() {
                return ext;
            }

            public void setExt(String ext) {
                this.ext = ext;
            }

            public String getFileType() {
                return fileType;
            }

            public void setFileType(String fileType) {
                this.fileType = fileType;
            }

            public String getNote() {
                return note;
            }

            public void setNote(String note) {
                this.note = note;
            }

            public String getCreator() {
                return creator;
            }

            public void setCreator(String creator) {
                this.creator = creator;
            }

            public int getCreatorId() {
                return creatorId;
            }

            public void setCreatorId(int creatorId) {
                this.creatorId = creatorId;
            }

            public int getTotalBytes() {
                return totalBytes;
            }

            public void setTotalBytes(int totalBytes) {
                this.totalBytes = totalBytes;
            }

            public int getDelFlag() {
                return delFlag;
            }

            public void setDelFlag(int delFlag) {
                this.delFlag = delFlag;
            }

            public Object getGlobalType() {
                return globalType;
            }

            public void setGlobalType(Object globalType) {
                this.globalType = globalType;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getFirstKeyColumnName() {
                return firstKeyColumnName;
            }

            public void setFirstKeyColumnName(String firstKeyColumnName) {
                this.firstKeyColumnName = firstKeyColumnName;
            }
        }
    }
}
