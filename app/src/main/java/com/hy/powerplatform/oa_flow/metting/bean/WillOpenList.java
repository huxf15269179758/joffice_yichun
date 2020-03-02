package com.hy.powerplatform.oa_flow.metting.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/12/31.
 */

public class WillOpenList implements Serializable {

    /**
     * success : true
     * totalCounts : 2
     * result : [{"version":null,"orgId":null,"orgPath":null,"confId":148,"confTopic":"标题","confProperty":"其他","importLevel":0,"feeBudget":0,"compere":"9546","recorder":"9547","attendUsers":"9354","status":1,"isEmail":1,"isMobile":0,"startTime":"2020-01-10 11:00:00","endTime":"2020-01-13 12:00:00","roomId":4,"roomName":"大会议室","roomLocation":"大会议室","confContent":"奥术大师多","compereName":"王少科","recorderName":"陈维","attendUsersName":"欧阳晓林","checkUserId":null,"checkName":"超级管理员","checkReason":"","createtime":"2020-01-10 10:30:57","sendtime":"2020-01-10 10:30:57","typeId":4,"attProbablyCount":"2","confInitiatorId":9354,"readPersonIds":"","readPersonNames":"","readCount":0,"approvedUserId":9354,"approvedName":"欧阳晓林","approvedText":"部门负责人发起的会议直接跳过初审","confPrivilege":[{"version":null,"orgId":null,"orgPath":null,"privilegeId":1276,"userId":9354,"confId":148,"fullname":"欧阳晓林","rights":1},{"version":null,"orgId":null,"orgPath":null,"privilegeId":1281,"userId":1,"confId":148,"fullname":"超级管理员","rights":1},{"version":null,"orgId":null,"orgPath":null,"privilegeId":1280,"userId":9547,"confId":148,"fullname":"陈维","rights":1},{"version":null,"orgId":null,"orgPath":null,"privilegeId":1278,"userId":9404,"confId":148,"fullname":"谭军","rights":1},{"version":null,"orgId":null,"orgPath":null,"privilegeId":1277,"userId":9547,"confId":148,"fullname":"陈维","rights":3},{"version":null,"orgId":null,"orgPath":null,"privilegeId":1274,"userId":9546,"confId":148,"fullname":"王少科","rights":1},{"version":null,"orgId":null,"orgPath":null,"privilegeId":1279,"userId":9404,"confId":148,"fullname":"谭军","rights":2},{"version":null,"orgId":null,"orgPath":null,"privilegeId":1275,"userId":9354,"confId":148,"fullname":"欧阳晓林","rights":2}],"attachFiles":[{"version":null,"orgId":null,"orgPath":null,"fileId":9696,"fileName":"D3.js笔记.txt","filePath":"admin/conference/202001/e5d905cca1054e43ab54c4f4a0762f62.txt","createtime":"2020-01-10 10:30:51","ext":"txt","fileType":"admin/conference","note":"1.20 KB","creator":"欧阳晓林","creatorId":9354,"totalBytes":1228,"delFlag":0,"globalType":null,"id":9696,"firstKeyColumnName":"fileId"}]},{"version":null,"orgId":null,"orgPath":null,"confId":147,"confTopic":"标题","confProperty":"其他","importLevel":0,"feeBudget":0,"compere":"9546","recorder":"9547","attendUsers":"9354","status":1,"isEmail":1,"isMobile":0,"startTime":"2020-01-10 11:00:00","endTime":"2020-01-13 12:00:00","roomId":4,"roomName":"大会议室","roomLocation":"大会议室","confContent":"阿萨德萨达多","compereName":"王少科","recorderName":"陈维","attendUsersName":"欧阳晓林","checkUserId":null,"checkName":"超级管理员","checkReason":"","createtime":"2020-01-10 10:30:13","sendtime":"2020-01-10 10:30:13","typeId":4,"attProbablyCount":"2","confInitiatorId":9354,"readPersonIds":"","readPersonNames":"","readCount":0,"approvedUserId":9354,"approvedName":"欧阳晓林","approvedText":"部门负责人发起的会议直接跳过初审","confPrivilege":[{"version":null,"orgId":null,"orgPath":null,"privilegeId":1265,"userId":9546,"confId":147,"fullname":"王少科","rights":1},{"version":null,"orgId":null,"orgPath":null,"privilegeId":1259,"userId":9404,"confId":147,"fullname":"谭军","rights":2},{"version":null,"orgId":null,"orgPath":null,"privilegeId":1263,"userId":9547,"confId":147,"fullname":"陈维","rights":1},{"version":null,"orgId":null,"orgPath":null,"privilegeId":1261,"userId":9354,"confId":147,"fullname":"欧阳晓林","rights":2},{"version":null,"orgId":null,"orgPath":null,"privilegeId":1258,"userId":9547,"confId":147,"fullname":"陈维","rights":3},{"version":null,"orgId":null,"orgPath":null,"privilegeId":1260,"userId":9354,"confId":147,"fullname":"欧阳晓林","rights":1},{"version":null,"orgId":null,"orgPath":null,"privilegeId":1262,"userId":9404,"confId":147,"fullname":"谭军","rights":1},{"version":null,"orgId":null,"orgPath":null,"privilegeId":1264,"userId":1,"confId":147,"fullname":"超级管理员","rights":1}],"attachFiles":[{"version":null,"orgId":null,"orgPath":null,"fileId":9694,"fileName":"D3.js笔记.txt","filePath":"admin/conference/202001/86f1ebd8e9b64a488c877df9aa5b4b36.txt","createtime":"2020-01-10 10:29:24","ext":"txt","fileType":"admin/conference","note":"1.20 KB","creator":"欧阳晓林","creatorId":9354,"totalBytes":1228,"delFlag":0,"globalType":null,"id":9694,"firstKeyColumnName":"fileId"},{"version":null,"orgId":null,"orgPath":null,"fileId":9695,"fileName":"ERP各地区访问地址及密码.txt","filePath":"admin/conference/202001/711d6095801947489136f779c00e272d.txt","createtime":"2020-01-10 10:29:30","ext":"txt","fileType":"admin/conference","note":"777.0 bytes","creator":"欧阳晓林","creatorId":9354,"totalBytes":777,"delFlag":0,"globalType":null,"id":9695,"firstKeyColumnName":"fileId"}]}]
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
         * version : null
         * orgId : null
         * orgPath : null
         * confId : 148
         * confTopic : 标题
         * confProperty : 其他
         * importLevel : 0
         * feeBudget : 0.0
         * compere : 9546
         * recorder : 9547
         * attendUsers : 9354
         * status : 1
         * isEmail : 1
         * isMobile : 0
         * startTime : 2020-01-10 11:00:00
         * endTime : 2020-01-13 12:00:00
         * roomId : 4
         * roomName : 大会议室
         * roomLocation : 大会议室
         * confContent : 奥术大师多
         * compereName : 王少科
         * recorderName : 陈维
         * attendUsersName : 欧阳晓林
         * checkUserId : null
         * checkName : 超级管理员
         * checkReason :
         * createtime : 2020-01-10 10:30:57
         * sendtime : 2020-01-10 10:30:57
         * typeId : 4
         * attProbablyCount : 2
         * confInitiatorId : 9354
         * readPersonIds :
         * readPersonNames :
         * readCount : 0
         * approvedUserId : 9354
         * approvedName : 欧阳晓林
         * approvedText : 部门负责人发起的会议直接跳过初审
         * confPrivilege : [{"version":null,"orgId":null,"orgPath":null,"privilegeId":1276,"userId":9354,"confId":148,"fullname":"欧阳晓林","rights":1},{"version":null,"orgId":null,"orgPath":null,"privilegeId":1281,"userId":1,"confId":148,"fullname":"超级管理员","rights":1},{"version":null,"orgId":null,"orgPath":null,"privilegeId":1280,"userId":9547,"confId":148,"fullname":"陈维","rights":1},{"version":null,"orgId":null,"orgPath":null,"privilegeId":1278,"userId":9404,"confId":148,"fullname":"谭军","rights":1},{"version":null,"orgId":null,"orgPath":null,"privilegeId":1277,"userId":9547,"confId":148,"fullname":"陈维","rights":3},{"version":null,"orgId":null,"orgPath":null,"privilegeId":1274,"userId":9546,"confId":148,"fullname":"王少科","rights":1},{"version":null,"orgId":null,"orgPath":null,"privilegeId":1279,"userId":9404,"confId":148,"fullname":"谭军","rights":2},{"version":null,"orgId":null,"orgPath":null,"privilegeId":1275,"userId":9354,"confId":148,"fullname":"欧阳晓林","rights":2}]
         * attachFiles : [{"version":null,"orgId":null,"orgPath":null,"fileId":9696,"fileName":"D3.js笔记.txt","filePath":"admin/conference/202001/e5d905cca1054e43ab54c4f4a0762f62.txt","createtime":"2020-01-10 10:30:51","ext":"txt","fileType":"admin/conference","note":"1.20 KB","creator":"欧阳晓林","creatorId":9354,"totalBytes":1228,"delFlag":0,"globalType":null,"id":9696,"firstKeyColumnName":"fileId"}]
         */

        private Object version;
        private Object orgId;
        private Object orgPath;
        private int confId;
        private String confTopic;
        private String confProperty;
        private int importLevel;
        private double feeBudget;
        private String compere;
        private String recorder;
        private String attendUsers;
        private int status;
        private int isEmail;
        private int isMobile;
        private String startTime;
        private String endTime;
        private int roomId;
        private String roomName;
        private String roomLocation;
        private String confContent;
        private String compereName;
        private String recorderName;
        private String attendUsersName;
        private Object checkUserId;
        private String checkName;
        private String checkReason;
        private String createtime;
        private String sendtime;
        private int typeId;
        private String attProbablyCount;
        private int confInitiatorId;
        private String readPersonIds;
        private String readPersonNames;
        private int readCount;
        private int approvedUserId;
        private String approvedName;
        private String approvedText;
        private List<ConfPrivilegeBean> confPrivilege;
        private List<AttachFilesBean> attachFiles;

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

        public int getConfId() {
            return confId;
        }

        public void setConfId(int confId) {
            this.confId = confId;
        }

        public String getConfTopic() {
            return confTopic;
        }

        public void setConfTopic(String confTopic) {
            this.confTopic = confTopic;
        }

        public String getConfProperty() {
            return confProperty;
        }

        public void setConfProperty(String confProperty) {
            this.confProperty = confProperty;
        }

        public int getImportLevel() {
            return importLevel;
        }

        public void setImportLevel(int importLevel) {
            this.importLevel = importLevel;
        }

        public double getFeeBudget() {
            return feeBudget;
        }

        public void setFeeBudget(double feeBudget) {
            this.feeBudget = feeBudget;
        }

        public String getCompere() {
            return compere;
        }

        public void setCompere(String compere) {
            this.compere = compere;
        }

        public String getRecorder() {
            return recorder;
        }

        public void setRecorder(String recorder) {
            this.recorder = recorder;
        }

        public String getAttendUsers() {
            return attendUsers;
        }

        public void setAttendUsers(String attendUsers) {
            this.attendUsers = attendUsers;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getIsEmail() {
            return isEmail;
        }

        public void setIsEmail(int isEmail) {
            this.isEmail = isEmail;
        }

        public int getIsMobile() {
            return isMobile;
        }

        public void setIsMobile(int isMobile) {
            this.isMobile = isMobile;
        }

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public int getRoomId() {
            return roomId;
        }

        public void setRoomId(int roomId) {
            this.roomId = roomId;
        }

        public String getRoomName() {
            return roomName;
        }

        public void setRoomName(String roomName) {
            this.roomName = roomName;
        }

        public String getRoomLocation() {
            return roomLocation;
        }

        public void setRoomLocation(String roomLocation) {
            this.roomLocation = roomLocation;
        }

        public String getConfContent() {
            return confContent;
        }

        public void setConfContent(String confContent) {
            this.confContent = confContent;
        }

        public String getCompereName() {
            return compereName;
        }

        public void setCompereName(String compereName) {
            this.compereName = compereName;
        }

        public String getRecorderName() {
            return recorderName;
        }

        public void setRecorderName(String recorderName) {
            this.recorderName = recorderName;
        }

        public String getAttendUsersName() {
            return attendUsersName;
        }

        public void setAttendUsersName(String attendUsersName) {
            this.attendUsersName = attendUsersName;
        }

        public Object getCheckUserId() {
            return checkUserId;
        }

        public void setCheckUserId(Object checkUserId) {
            this.checkUserId = checkUserId;
        }

        public String getCheckName() {
            return checkName;
        }

        public void setCheckName(String checkName) {
            this.checkName = checkName;
        }

        public String getCheckReason() {
            return checkReason;
        }

        public void setCheckReason(String checkReason) {
            this.checkReason = checkReason;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public String getSendtime() {
            return sendtime;
        }

        public void setSendtime(String sendtime) {
            this.sendtime = sendtime;
        }

        public int getTypeId() {
            return typeId;
        }

        public void setTypeId(int typeId) {
            this.typeId = typeId;
        }

        public String getAttProbablyCount() {
            return attProbablyCount;
        }

        public void setAttProbablyCount(String attProbablyCount) {
            this.attProbablyCount = attProbablyCount;
        }

        public int getConfInitiatorId() {
            return confInitiatorId;
        }

        public void setConfInitiatorId(int confInitiatorId) {
            this.confInitiatorId = confInitiatorId;
        }

        public String getReadPersonIds() {
            return readPersonIds;
        }

        public void setReadPersonIds(String readPersonIds) {
            this.readPersonIds = readPersonIds;
        }

        public String getReadPersonNames() {
            return readPersonNames;
        }

        public void setReadPersonNames(String readPersonNames) {
            this.readPersonNames = readPersonNames;
        }

        public int getReadCount() {
            return readCount;
        }

        public void setReadCount(int readCount) {
            this.readCount = readCount;
        }

        public int getApprovedUserId() {
            return approvedUserId;
        }

        public void setApprovedUserId(int approvedUserId) {
            this.approvedUserId = approvedUserId;
        }

        public String getApprovedName() {
            return approvedName;
        }

        public void setApprovedName(String approvedName) {
            this.approvedName = approvedName;
        }

        public String getApprovedText() {
            return approvedText;
        }

        public void setApprovedText(String approvedText) {
            this.approvedText = approvedText;
        }

        public List<ConfPrivilegeBean> getConfPrivilege() {
            return confPrivilege;
        }

        public void setConfPrivilege(List<ConfPrivilegeBean> confPrivilege) {
            this.confPrivilege = confPrivilege;
        }

        public List<AttachFilesBean> getAttachFiles() {
            return attachFiles;
        }

        public void setAttachFiles(List<AttachFilesBean> attachFiles) {
            this.attachFiles = attachFiles;
        }

        public static class ConfPrivilegeBean implements Serializable {
            /**
             * version : null
             * orgId : null
             * orgPath : null
             * privilegeId : 1276
             * userId : 9354
             * confId : 148
             * fullname : 欧阳晓林
             * rights : 1
             */

            private Object version;
            private Object orgId;
            private Object orgPath;
            private int privilegeId;
            private int userId;
            private int confId;
            private String fullname;
            private int rights;

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

            public int getPrivilegeId() {
                return privilegeId;
            }

            public void setPrivilegeId(int privilegeId) {
                this.privilegeId = privilegeId;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public int getConfId() {
                return confId;
            }

            public void setConfId(int confId) {
                this.confId = confId;
            }

            public String getFullname() {
                return fullname;
            }

            public void setFullname(String fullname) {
                this.fullname = fullname;
            }

            public int getRights() {
                return rights;
            }

            public void setRights(int rights) {
                this.rights = rights;
            }
        }

        public static class AttachFilesBean implements Serializable {
            /**
             * version : null
             * orgId : null
             * orgPath : null
             * fileId : 9696
             * fileName : D3.js笔记.txt
             * filePath : admin/conference/202001/e5d905cca1054e43ab54c4f4a0762f62.txt
             * createtime : 2020-01-10 10:30:51
             * ext : txt
             * fileType : admin/conference
             * note : 1.20 KB
             * creator : 欧阳晓林
             * creatorId : 9354
             * totalBytes : 1228
             * delFlag : 0
             * globalType : null
             * id : 9696
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
