package com.hy.powerplatform.duban.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/12/5.
 */

public class DBTJRCO implements Serializable {

    /**
     * success : true
     * totalCounts : 1
     * result : [{"version":null,"orgId":null,"orgPath":null,"css":null,"planId":37,"startTime":"2019-12-05 09:18:15","endTime":"2019-12-06 19:09:11","urgent":0,"content":"有态度就好几个","status":0,"fullname":"欧阳晓林","assignerId":9354,"assignerName":"欧阳晓林","feedback":null,"showStyle":1,"taskType":1,"userId":9354,"summary":"阿斯达三大","type":"执行任务","operId":196,"statusName":"未完成","color":"#7799BF","urgentName":"一般"}]
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
         * version : null
         * orgId : null
         * orgPath : null
         * css : null
         * planId : 37
         * startTime : 2019-12-05 09:18:15
         * endTime : 2019-12-06 19:09:11
         * urgent : 0
         * content : 有态度就好几个
         * status : 0
         * fullname : 欧阳晓林
         * assignerId : 9354
         * assignerName : 欧阳晓林
         * feedback : null
         * showStyle : 1
         * taskType : 1
         * userId : 9354
         * summary : 阿斯达三大
         * type : 执行任务
         * operId : 196
         * statusName : 未完成
         * color : #7799BF
         * urgentName : 一般
         */

        private Object version;
        private Object orgId;
        private Object orgPath;
        private Object css;
        private int planId;
        private String startTime;
        private String endTime;
        private int urgent;
        private String content;
        private int status;
        private String fullname;
        private int assignerId;
        private String assignerName;
        private Object feedback;
        private int showStyle;
        private int taskType;
        private int userId;
        private String summary;
        private String type;
        private int operId;
        private String statusName;
        private String color;
        private String urgentName;

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

        public Object getCss() {
            return css;
        }

        public void setCss(Object css) {
            this.css = css;
        }

        public int getPlanId() {
            return planId;
        }

        public void setPlanId(int planId) {
            this.planId = planId;
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

        public int getUrgent() {
            return urgent;
        }

        public void setUrgent(int urgent) {
            this.urgent = urgent;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getFullname() {
            return fullname;
        }

        public void setFullname(String fullname) {
            this.fullname = fullname;
        }

        public int getAssignerId() {
            return assignerId;
        }

        public void setAssignerId(int assignerId) {
            this.assignerId = assignerId;
        }

        public String getAssignerName() {
            return assignerName;
        }

        public void setAssignerName(String assignerName) {
            this.assignerName = assignerName;
        }

        public Object getFeedback() {
            return feedback;
        }

        public void setFeedback(Object feedback) {
            this.feedback = feedback;
        }

        public int getShowStyle() {
            return showStyle;
        }

        public void setShowStyle(int showStyle) {
            this.showStyle = showStyle;
        }

        public int getTaskType() {
            return taskType;
        }

        public void setTaskType(int taskType) {
            this.taskType = taskType;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getOperId() {
            return operId;
        }

        public void setOperId(int operId) {
            this.operId = operId;
        }

        public String getStatusName() {
            return statusName;
        }

        public void setStatusName(String statusName) {
            this.statusName = statusName;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getUrgentName() {
            return urgentName;
        }

        public void setUrgentName(String urgentName) {
            this.urgentName = urgentName;
        }
    }
}
