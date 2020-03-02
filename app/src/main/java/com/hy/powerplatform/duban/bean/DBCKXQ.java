package com.hy.powerplatform.duban.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/12/6.
 */

public class DBCKXQ implements Serializable {

    /**
     * success : true
     * data : {"version":null,"orgId":null,"orgPath":null,"operId":262,"workId":131,"operator":9467,"operatorName":"易睿","operStatus":7,"operTime":"2020-01-02","submitTitle":"已完成整改","submitContext":"根据元旦安全检查所发现问题的整改要求，大为物业公司立即组织对所归属问题进行整改，除安全出口标志损坏还在采购及一个消防栓的玻璃还在定制中，其余均已整改完成。（摄像头故障为信息部工作职责，由信息部进行维修）","fileIds":"9758,9759,9760,9761,9762,9763,9764,9765","publishTime":"2019-12-31","operLog":null,"memo":"","updateType":null,"num":null,"statusName":"晏慧锋,张志平","statusType":null,"annotation":"需采购事宜，请抓紧完成，及早修复。\u2014\u2014张志平 2020-01-06 08:44:57","identUrge":null,"judgeSMSzxr":null,"judgeSMSdbr":null,"superWorkTask":{"version":null,"orgId":null,"orgPath":null,"workId":131,"taskType":"公司任务","taskName":"关于元旦安全检查问题的通报","taskContext":"请各部门各生产单位按照通知在1月3日下午下班前整改完毕，并提交整改情况。","planFinishTime":"2020-01-03","fileIds":"9739","supervisorIds":"9386,9387,9398,9390,9389,9391,9403,9388,9404","supervisorNames":"王少云,唐根六,晏慧锋,李健,袁斌,何爱民,张志平,刘永锋,谭军","operatorIds":"9467,9493,9421,9406,9414,9400,9471","operatorNames":"易睿,吴迪,欧阳翰,陆卫敏,刘晓霞,晏永金,凌凡","taskStatus":5,"creater":"9404","createTime":"2019-12-31","updateTime":"2019-12-31","approver":9404,"approveTime":"2019-12-31","fileNames":null,"createrName":"谭军","approverName":"谭军","statusName":null,"contactsName":"谭军","contactsId":"9404","superWorkTaskFiles":[]},"superTaskOperFiles":[{"version":null,"orgId":null,"orgPath":null,"fileId":9760,"fileName":"微信图片_202001021657402.jpg","filePath":"others/202001/6c1cc8f65dfa41038b0a2717c46ce5f8.jpg","createtime":"2020-01-02","ext":"jpg","fileType":"others","note":"51.21 KB","creator":"易睿","creatorId":9467,"totalBytes":52442,"delFlag":0,"globalType":null,"id":9760,"firstKeyColumnName":"fileId"},{"version":null,"orgId":null,"orgPath":null,"fileId":9762,"fileName":"微信图片_202001021657404.jpg","filePath":"others/202001/d0b45111158c47ac93fff4e2058dd864.jpg","createtime":"2020-01-02","ext":"jpg","fileType":"others","note":"44.71 KB","creator":"易睿","creatorId":9467,"totalBytes":45788,"delFlag":0,"globalType":null,"id":9762,"firstKeyColumnName":"fileId"},{"version":null,"orgId":null,"orgPath":null,"fileId":9761,"fileName":"微信图片_202001021657403.jpg","filePath":"others/202001/9207810d4fe447608c2c8ca48cb7529b.jpg","createtime":"2020-01-02","ext":"jpg","fileType":"others","note":"45.92 KB","creator":"易睿","creatorId":9467,"totalBytes":47017,"delFlag":0,"globalType":null,"id":9761,"firstKeyColumnName":"fileId"},{"version":null,"orgId":null,"orgPath":null,"fileId":9758,"fileName":"微信图片_20200102165740.jpg","filePath":"others/202001/ae32070e1d73411cb8cf9b82348e4cbd.jpg","createtime":"2020-01-02","ext":"jpg","fileType":"others","note":"56.06 KB","creator":"易睿","creatorId":9467,"totalBytes":57407,"delFlag":0,"globalType":null,"id":9758,"firstKeyColumnName":"fileId"},{"version":null,"orgId":null,"orgPath":null,"fileId":9765,"fileName":"微信图片_202001021657407.jpg","filePath":"others/202001/1729b9988a5f4b2bbe75b65415046117.jpg","createtime":"2020-01-02","ext":"jpg","fileType":"others","note":"27.17 KB","creator":"易睿","creatorId":9467,"totalBytes":27817,"delFlag":0,"globalType":null,"id":9765,"firstKeyColumnName":"fileId"},{"version":null,"orgId":null,"orgPath":null,"fileId":9764,"fileName":"微信图片_202001021657406.jpg","filePath":"others/202001/00a8cb5a853a4aac8fc52cb472f7d1bd.jpg","createtime":"2020-01-02","ext":"jpg","fileType":"others","note":"33.01 KB","creator":"易睿","creatorId":9467,"totalBytes":33801,"delFlag":0,"globalType":null,"id":9764,"firstKeyColumnName":"fileId"},{"version":null,"orgId":null,"orgPath":null,"fileId":9759,"fileName":"微信图片_202001021657401.jpg","filePath":"others/202001/ae5194a391ba4ab190ce8e46b35471c4.jpg","createtime":"2020-01-02","ext":"jpg","fileType":"others","note":"59.54 KB","creator":"易睿","creatorId":9467,"totalBytes":60971,"delFlag":0,"globalType":null,"id":9759,"firstKeyColumnName":"fileId"},{"version":null,"orgId":null,"orgPath":null,"fileId":9763,"fileName":"微信图片_202001021657405.jpg","filePath":"others/202001/012c4ba94ed5438d81b455cbbf787783.jpg","createtime":"2020-01-02","ext":"jpg","fileType":"others","note":"49.95 KB","creator":"易睿","creatorId":9467,"totalBytes":51153,"delFlag":0,"globalType":null,"id":9763,"firstKeyColumnName":"fileId"}]}
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

    public static class DataBean implements Serializable {
        /**
         * version : null
         * orgId : null
         * orgPath : null
         * operId : 262
         * workId : 131
         * operator : 9467
         * operatorName : 易睿
         * operStatus : 7
         * operTime : 2020-01-02
         * submitTitle : 已完成整改
         * submitContext : 根据元旦安全检查所发现问题的整改要求，大为物业公司立即组织对所归属问题进行整改，除安全出口标志损坏还在采购及一个消防栓的玻璃还在定制中，其余均已整改完成。（摄像头故障为信息部工作职责，由信息部进行维修）
         * fileIds : 9758,9759,9760,9761,9762,9763,9764,9765
         * publishTime : 2019-12-31
         * operLog : null
         * memo :
         * updateType : null
         * num : null
         * statusName : 晏慧锋,张志平
         * statusType : null
         * annotation : 需采购事宜，请抓紧完成，及早修复。——张志平 2020-01-06 08:44:57
         * identUrge : null
         * judgeSMSzxr : null
         * judgeSMSdbr : null
         * superWorkTask : {"version":null,"orgId":null,"orgPath":null,"workId":131,"taskType":"公司任务","taskName":"关于元旦安全检查问题的通报","taskContext":"请各部门各生产单位按照通知在1月3日下午下班前整改完毕，并提交整改情况。","planFinishTime":"2020-01-03","fileIds":"9739","supervisorIds":"9386,9387,9398,9390,9389,9391,9403,9388,9404","supervisorNames":"王少云,唐根六,晏慧锋,李健,袁斌,何爱民,张志平,刘永锋,谭军","operatorIds":"9467,9493,9421,9406,9414,9400,9471","operatorNames":"易睿,吴迪,欧阳翰,陆卫敏,刘晓霞,晏永金,凌凡","taskStatus":5,"creater":"9404","createTime":"2019-12-31","updateTime":"2019-12-31","approver":9404,"approveTime":"2019-12-31","fileNames":null,"createrName":"谭军","approverName":"谭军","statusName":null,"contactsName":"谭军","contactsId":"9404","superWorkTaskFiles":[]}
         * superTaskOperFiles : [{"version":null,"orgId":null,"orgPath":null,"fileId":9760,"fileName":"微信图片_202001021657402.jpg","filePath":"others/202001/6c1cc8f65dfa41038b0a2717c46ce5f8.jpg","createtime":"2020-01-02","ext":"jpg","fileType":"others","note":"51.21 KB","creator":"易睿","creatorId":9467,"totalBytes":52442,"delFlag":0,"globalType":null,"id":9760,"firstKeyColumnName":"fileId"},{"version":null,"orgId":null,"orgPath":null,"fileId":9762,"fileName":"微信图片_202001021657404.jpg","filePath":"others/202001/d0b45111158c47ac93fff4e2058dd864.jpg","createtime":"2020-01-02","ext":"jpg","fileType":"others","note":"44.71 KB","creator":"易睿","creatorId":9467,"totalBytes":45788,"delFlag":0,"globalType":null,"id":9762,"firstKeyColumnName":"fileId"},{"version":null,"orgId":null,"orgPath":null,"fileId":9761,"fileName":"微信图片_202001021657403.jpg","filePath":"others/202001/9207810d4fe447608c2c8ca48cb7529b.jpg","createtime":"2020-01-02","ext":"jpg","fileType":"others","note":"45.92 KB","creator":"易睿","creatorId":9467,"totalBytes":47017,"delFlag":0,"globalType":null,"id":9761,"firstKeyColumnName":"fileId"},{"version":null,"orgId":null,"orgPath":null,"fileId":9758,"fileName":"微信图片_20200102165740.jpg","filePath":"others/202001/ae32070e1d73411cb8cf9b82348e4cbd.jpg","createtime":"2020-01-02","ext":"jpg","fileType":"others","note":"56.06 KB","creator":"易睿","creatorId":9467,"totalBytes":57407,"delFlag":0,"globalType":null,"id":9758,"firstKeyColumnName":"fileId"},{"version":null,"orgId":null,"orgPath":null,"fileId":9765,"fileName":"微信图片_202001021657407.jpg","filePath":"others/202001/1729b9988a5f4b2bbe75b65415046117.jpg","createtime":"2020-01-02","ext":"jpg","fileType":"others","note":"27.17 KB","creator":"易睿","creatorId":9467,"totalBytes":27817,"delFlag":0,"globalType":null,"id":9765,"firstKeyColumnName":"fileId"},{"version":null,"orgId":null,"orgPath":null,"fileId":9764,"fileName":"微信图片_202001021657406.jpg","filePath":"others/202001/00a8cb5a853a4aac8fc52cb472f7d1bd.jpg","createtime":"2020-01-02","ext":"jpg","fileType":"others","note":"33.01 KB","creator":"易睿","creatorId":9467,"totalBytes":33801,"delFlag":0,"globalType":null,"id":9764,"firstKeyColumnName":"fileId"},{"version":null,"orgId":null,"orgPath":null,"fileId":9759,"fileName":"微信图片_202001021657401.jpg","filePath":"others/202001/ae5194a391ba4ab190ce8e46b35471c4.jpg","createtime":"2020-01-02","ext":"jpg","fileType":"others","note":"59.54 KB","creator":"易睿","creatorId":9467,"totalBytes":60971,"delFlag":0,"globalType":null,"id":9759,"firstKeyColumnName":"fileId"},{"version":null,"orgId":null,"orgPath":null,"fileId":9763,"fileName":"微信图片_202001021657405.jpg","filePath":"others/202001/012c4ba94ed5438d81b455cbbf787783.jpg","createtime":"2020-01-02","ext":"jpg","fileType":"others","note":"49.95 KB","creator":"易睿","creatorId":9467,"totalBytes":51153,"delFlag":0,"globalType":null,"id":9763,"firstKeyColumnName":"fileId"}]
         */

        private Object version;
        private Object orgId;
        private Object orgPath;
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
        private Object operLog;
        private String memo;
        private Object updateType;
        private Object num;
        private String statusName;
        private Object statusType;
        private String annotation;
        private Object identUrge;
        private Object judgeSMSzxr;
        private Object judgeSMSdbr;
        private SuperWorkTaskBean superWorkTask;
        private List<SuperTaskOperFilesBean> superTaskOperFiles;

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

        public Object getOperLog() {
            return operLog;
        }

        public void setOperLog(Object operLog) {
            this.operLog = operLog;
        }

        public String getMemo() {
            return memo;
        }

        public void setMemo(String memo) {
            this.memo = memo;
        }

        public Object getUpdateType() {
            return updateType;
        }

        public void setUpdateType(Object updateType) {
            this.updateType = updateType;
        }

        public Object getNum() {
            return num;
        }

        public void setNum(Object num) {
            this.num = num;
        }

        public String getStatusName() {
            return statusName;
        }

        public void setStatusName(String statusName) {
            this.statusName = statusName;
        }

        public Object getStatusType() {
            return statusType;
        }

        public void setStatusType(Object statusType) {
            this.statusType = statusType;
        }

        public String getAnnotation() {
            return annotation;
        }

        public void setAnnotation(String annotation) {
            this.annotation = annotation;
        }

        public Object getIdentUrge() {
            return identUrge;
        }

        public void setIdentUrge(Object identUrge) {
            this.identUrge = identUrge;
        }

        public Object getJudgeSMSzxr() {
            return judgeSMSzxr;
        }

        public void setJudgeSMSzxr(Object judgeSMSzxr) {
            this.judgeSMSzxr = judgeSMSzxr;
        }

        public Object getJudgeSMSdbr() {
            return judgeSMSdbr;
        }

        public void setJudgeSMSdbr(Object judgeSMSdbr) {
            this.judgeSMSdbr = judgeSMSdbr;
        }

        public SuperWorkTaskBean getSuperWorkTask() {
            return superWorkTask;
        }

        public void setSuperWorkTask(SuperWorkTaskBean superWorkTask) {
            this.superWorkTask = superWorkTask;
        }

        public List<SuperTaskOperFilesBean> getSuperTaskOperFiles() {
            return superTaskOperFiles;
        }

        public void setSuperTaskOperFiles(List<SuperTaskOperFilesBean> superTaskOperFiles) {
            this.superTaskOperFiles = superTaskOperFiles;
        }

        public static class SuperWorkTaskBean implements Serializable {
            /**
             * version : null
             * orgId : null
             * orgPath : null
             * workId : 131
             * taskType : 公司任务
             * taskName : 关于元旦安全检查问题的通报
             * taskContext : 请各部门各生产单位按照通知在1月3日下午下班前整改完毕，并提交整改情况。
             * planFinishTime : 2020-01-03
             * fileIds : 9739
             * supervisorIds : 9386,9387,9398,9390,9389,9391,9403,9388,9404
             * supervisorNames : 王少云,唐根六,晏慧锋,李健,袁斌,何爱民,张志平,刘永锋,谭军
             * operatorIds : 9467,9493,9421,9406,9414,9400,9471
             * operatorNames : 易睿,吴迪,欧阳翰,陆卫敏,刘晓霞,晏永金,凌凡
             * taskStatus : 5
             * creater : 9404
             * createTime : 2019-12-31
             * updateTime : 2019-12-31
             * approver : 9404
             * approveTime : 2019-12-31
             * fileNames : null
             * createrName : 谭军
             * approverName : 谭军
             * statusName : null
             * contactsName : 谭军
             * contactsId : 9404
             * superWorkTaskFiles : []
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
            private List<?> superWorkTaskFiles;

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

            public List<?> getSuperWorkTaskFiles() {
                return superWorkTaskFiles;
            }

            public void setSuperWorkTaskFiles(List<?> superWorkTaskFiles) {
                this.superWorkTaskFiles = superWorkTaskFiles;
            }
        }

        public static class SuperTaskOperFilesBean implements Serializable {
            /**
             * version : null
             * orgId : null
             * orgPath : null
             * fileId : 9760
             * fileName : 微信图片_202001021657402.jpg
             * filePath : others/202001/6c1cc8f65dfa41038b0a2717c46ce5f8.jpg
             * createtime : 2020-01-02
             * ext : jpg
             * fileType : others
             * note : 51.21 KB
             * creator : 易睿
             * creatorId : 9467
             * totalBytes : 52442
             * delFlag : 0
             * globalType : null
             * id : 9760
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
