package com.hy.powerplatform.login.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/2/28.
 */

public class Version implements Serializable {

    /**
     * success : true
     * data : {"version":null,"orgId":null,"orgPath":null,"id":2,"changeDate":"2019-02-28","versionNo":"2","createName":"超级管理员","substance":"","downurl":"flow/201902/0ec67b9d7120412b882ac880b4525699.doc","appVersionFiles":[{"version":null,"orgId":null,"orgPath":null,"fileId":7989,"fileName":"总分公司绩效总2018.doc","filePath":"flow/201902/0ec67b9d7120412b882ac880b4525699.doc","createtime":"2019-02-27 13:50:55","ext":"doc","fileType":"flow","note":"57.50 KB","creator":"超级管理员","creatorId":1,"totalBytes":58880,"delFlag":0,"globalType":null,"id":7989,"firstKeyColumnName":"fileId"}]}
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

    public static class DataBean {
        /**
         * version : null
         * orgId : null
         * orgPath : null
         * id : 2
         * changeDate : 2019-02-28
         * versionNo : 2
         * createName : 超级管理员
         * substance :
         * downurl : flow/201902/0ec67b9d7120412b882ac880b4525699.doc
         * appVersionFiles : [{"version":null,"orgId":null,"orgPath":null,"fileId":7989,"fileName":"总分公司绩效总2018.doc","filePath":"flow/201902/0ec67b9d7120412b882ac880b4525699.doc","createtime":"2019-02-27 13:50:55","ext":"doc","fileType":"flow","note":"57.50 KB","creator":"超级管理员","creatorId":1,"totalBytes":58880,"delFlag":0,"globalType":null,"id":7989,"firstKeyColumnName":"fileId"}]
         */

        private Object version;
        private Object orgId;
        private Object orgPath;
        private int id;
        private String changeDate;
        private String versionNo;
        private String createName;
        private String substance;
        private String downurl;
        private List<AppVersionFilesBean> appVersionFiles;

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

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getChangeDate() {
            return changeDate;
        }

        public void setChangeDate(String changeDate) {
            this.changeDate = changeDate;
        }

        public String getVersionNo() {
            return versionNo;
        }

        public void setVersionNo(String versionNo) {
            this.versionNo = versionNo;
        }

        public String getCreateName() {
            return createName;
        }

        public void setCreateName(String createName) {
            this.createName = createName;
        }

        public String getSubstance() {
            return substance;
        }

        public void setSubstance(String substance) {
            this.substance = substance;
        }

        public String getDownurl() {
            return downurl;
        }

        public void setDownurl(String downurl) {
            this.downurl = downurl;
        }

        public List<AppVersionFilesBean> getAppVersionFiles() {
            return appVersionFiles;
        }

        public void setAppVersionFiles(List<AppVersionFilesBean> appVersionFiles) {
            this.appVersionFiles = appVersionFiles;
        }

        public static class AppVersionFilesBean {
            /**
             * version : null
             * orgId : null
             * orgPath : null
             * fileId : 7989
             * fileName : 总分公司绩效总2018.doc
             * filePath : flow/201902/0ec67b9d7120412b882ac880b4525699.doc
             * createtime : 2019-02-27 13:50:55
             * ext : doc
             * fileType : flow
             * note : 57.50 KB
             * creator : 超级管理员
             * creatorId : 1
             * totalBytes : 58880
             * delFlag : 0
             * globalType : null
             * id : 7989
             * firstKeyColumnName : fileId
             */

            private Object version;
            private Object orgId;
            private Object orgPath;
            private int fileId;
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

            public int getFileId() {
                return fileId;
            }

            public void setFileId(int fileId) {
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
