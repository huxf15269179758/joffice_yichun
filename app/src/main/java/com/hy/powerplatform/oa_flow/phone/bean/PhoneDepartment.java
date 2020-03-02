package com.hy.powerplatform.oa_flow.phone.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2020/1/3.
 */

public class PhoneDepartment implements Serializable {

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean implements Serializable {
        /**
         * name : 宜春公交集团有限公司
         * value : 378
         */

        private String name;
        private String value;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
