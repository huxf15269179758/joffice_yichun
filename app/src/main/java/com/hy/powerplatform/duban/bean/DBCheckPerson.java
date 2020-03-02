package com.hy.powerplatform.duban.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/12/13.
 */

public class DBCheckPerson implements Serializable {

    /**
     * success : true
     * totalCounts : 811
     * result : [{"userId":9546,"fullname":"王少科","title":1,"mobile":"","department.depId":506,"depName":"营运二分公司","depId":506},{"userId":9547,"fullname":"陈维","title":1,"mobile":"","department.depId":506,"depName":"营运二分公司","depId":506},{"userId":9751,"fullname":"冷丹","title":1,"mobile":"","department.depId":505,"depName":"营运一分公司","depId":505},{"userId":9548,"fullname":"黄金玉","title":1,"mobile":"","department.depId":506,"depName":"营运二分公司","depId":506},{"userId":9752,"fullname":"周林生","title":1,"mobile":"","department.depId":505,"depName":"营运一分公司","depId":505},{"userId":9753,"fullname":"汤亮亮","title":1,"mobile":"","department.depId":505,"depName":"营运一分公司","depId":505},{"userId":9754,"fullname":"梁龙晓","title":1,"mobile":"","department.depId":505,"depName":"营运一分公司","depId":505},{"userId":9943,"fullname":"何俊毅","title":1,"mobile":"","department.depId":507,"depName":"枢纽分公司","depId":507},{"userId":9755,"fullname":"郭纯栋","title":1,"mobile":"","department.depId":505,"depName":"营运一分公司","depId":505},{"userId":9549,"fullname":"黄金刚","title":1,"mobile":"","department.depId":506,"depName":"营运二分公司","depId":506},{"userId":9756,"fullname":"方凤英","title":0,"mobile":"","department.depId":505,"depName":"营运一分公司","depId":505},{"userId":9550,"fullname":"胡海艳","title":0,"mobile":"","department.depId":506,"depName":"营运二分公司","depId":506},{"userId":9551,"fullname":"晏秋香","title":0,"mobile":"","department.depId":506,"depName":"营运二分公司","depId":506},{"userId":9552,"fullname":"王晚秀","title":0,"mobile":"","department.depId":506,"depName":"营运二分公司","depId":506},{"userId":9944,"fullname":"陈汉华","title":1,"mobile":"","department.depId":507,"depName":"枢纽分公司","depId":507},{"userId":9945,"fullname":"张晶亮","title":1,"mobile":"","department.depId":507,"depName":"枢纽分公司","depId":507},{"userId":9757,"fullname":"江鹏","title":1,"mobile":"","department.depId":505,"depName":"营运一分公司","depId":505},{"userId":9553,"fullname":"李春兰","title":0,"mobile":"","department.depId":506,"depName":"营运二分公司","depId":506},{"userId":9758,"fullname":"易和财","title":1,"mobile":"","department.depId":505,"depName":"营运一分公司","depId":505},{"userId":9946,"fullname":"陈虎","title":1,"mobile":"","department.depId":507,"depName":"枢纽分公司","depId":507},{"userId":9947,"fullname":"刘庆彪","title":1,"mobile":"","department.depId":507,"depName":"枢纽分公司","depId":507},{"userId":9554,"fullname":"王海艳","title":0,"mobile":"","department.depId":506,"depName":"营运二分公司","depId":506},{"userId":9948,"fullname":"杨博文","title":1,"mobile":"","department.depId":507,"depName":"枢纽分公司","depId":507},{"userId":9949,"fullname":"郭聪","title":1,"mobile":"","department.depId":507,"depName":"枢纽分公司","depId":507},{"userId":9950,"fullname":"欧阳清","title":1,"mobile":"","department.depId":507,"depName":"枢纽分公司","depId":507}]
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
         * userId : 9546
         * fullname : 王少科
         * title : 1
         * mobile :
         * department.depId : 506
         * depName : 营运二分公司
         * depId : 506
         */

        private String userId;
        private String fullname;
        private int title;
        private String mobile;
        @SerializedName("department.depId")
        private int _$DepartmentDepId148; // FIXME check this code
        private String depName;
        private int depId;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getFullname() {
            return fullname;
        }

        public void setFullname(String fullname) {
            this.fullname = fullname;
        }

        public int getTitle() {
            return title;
        }

        public void setTitle(int title) {
            this.title = title;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public int get_$DepartmentDepId148() {
            return _$DepartmentDepId148;
        }

        public void set_$DepartmentDepId148(int _$DepartmentDepId148) {
            this._$DepartmentDepId148 = _$DepartmentDepId148;
        }

        public String getDepName() {
            return depName;
        }

        public void setDepName(String depName) {
            this.depName = depName;
        }

        public int getDepId() {
            return depId;
        }

        public void setDepId(int depId) {
            this.depId = depId;
        }
    }
}
