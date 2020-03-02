package com.hy.powerplatform.duban.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/12/7.
 */

public class DBCKSHZT implements Serializable {

    /**
     * success : true
     * data : [{"flag":"true"}]
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

    public static class DataBean {
        /**
         * flag : true
         */

        private String flag;

        public String getFlag() {
            return flag;
        }

        public void setFlag(String flag) {
            this.flag = flag;
        }
    }
}
