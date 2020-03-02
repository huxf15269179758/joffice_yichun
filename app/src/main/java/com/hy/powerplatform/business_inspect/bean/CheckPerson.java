package com.hy.powerplatform.business_inspect.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/7/5.
 */

public class CheckPerson implements Serializable {

    /**
     * success : true
     * data : [{"profileId":"1771","userCode":"718","name":"安兵","fullname":"安兵(718)","position":"职能部门副职","depId":"385","depName":"安全科","sex":"男","idCard":"130924198505235231"},{"profileId":"1812","userCode":"211","name":"常照倩","fullname":"常照倩(211)","position":"科员","depId":"385","depName":"安全科","sex":"女","idCard":"130981198310242447"},{"profileId":"1719","userCode":"41","name":"郭建","fullname":"郭建(41)","position":"总经理助理","depId":"385","depName":"安全科","sex":"男","idCard":"130921197807123610"},{"profileId":"1442","userCode":"1028","name":"李钧","fullname":"李钧(1028)","position":"职能部门副职","depId":"385","depName":"安全科","sex":"男","idCard":"13090219841110323X"},{"profileId":"1299","userCode":"433","name":"秦学林","fullname":"秦学林(433)","position":"职能部门副职","depId":"385","depName":"安全科","sex":"男","idCard":"130903196108241514"},{"profileId":"2752","userCode":"797","name":"张超","fullname":"张超(797)","position":"科员","depId":"385","depName":"安全科","sex":"男","idCard":"130904198305030631"}]
     */

    private boolean success;
    private List<DataBean> data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean implements Serializable {
        /**
         * profileId : 1771
         * userCode : 718
         * name : 安兵
         * fullname : 安兵(718)
         * position : 职能部门副职
         * depId : 385
         * depName : 安全科
         * sex : 男
         * idCard : 130924198505235231
         */

        private String profileId;
        private String userCode;
        private String name;
        private String fullname;
        private String position;
        private String depId;
        private String depName;
        private String sex;
        private String idCard;

        public String getProfileId() {
            return profileId;
        }

        public void setProfileId(String profileId) {
            this.profileId = profileId;
        }

        public String getUserCode() {
            return userCode;
        }

        public void setUserCode(String userCode) {
            this.userCode = userCode;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getFullname() {
            return fullname;
        }

        public void setFullname(String fullname) {
            this.fullname = fullname;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public String getDepId() {
            return depId;
        }

        public void setDepId(String depId) {
            this.depId = depId;
        }

        public String getDepName() {
            return depName;
        }

        public void setDepName(String depName) {
            this.depName = depName;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getIdCard() {
            return idCard;
        }

        public void setIdCard(String idCard) {
            this.idCard = idCard;
        }
    }
}
