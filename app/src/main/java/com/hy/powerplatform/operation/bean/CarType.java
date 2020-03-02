package com.hy.powerplatform.operation.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/12/30.
 */

public class CarType implements Serializable {

    /**
     * success : true
     * data : [{"name":"HFF6105G39C","value":"HFF6105G39C"},{"name":"HFF6111G64C","value":"HFF6111G64C"},{"name":"HK6105G","value":"HK6105G"},{"name":"HK6940HGQ","value":"HK6940HGQ"},{"name":"JYK6100GBEV","value":"JYK6100GBEV"},{"name":"JYK6100GBEV4","value":"JYK6100GBEV4"},{"name":"JYK6100HNGCHEV","value":"JYK6100HNGCHEV"},{"name":"JYK6101GBEV1","value":"JYK6101GBEV1"},{"name":"JYK6800GBEV","value":"JYK6800GBEV"},{"name":"JYK6800GBEV2","value":"JYK6800GBEV2"},{"name":"KLQ6109GAHEVC5A","value":"KLQ6109GAHEVC5A"},{"name":"XML6102JEVY0C","value":"XML6102JEVY0C"},{"name":"XML6105JEV70C","value":"XML6105JEV70C"},{"name":"XML6115JHEVA5CN","value":"XML6115JHEVA5CN"},{"name":"XML6807J55N","value":"XML6807J55N"},{"name":"ZK6105BEVG25","value":"ZK6105BEVG25"},{"name":"ZK6105CHEVNPG4","value":"ZK6105CHEVNPG4"},{"name":"ZK6108HGC","value":"ZK6108HGC"},{"name":"ZK6110H","value":"ZK6110H"},{"name":"ZK6116HNGS2","value":"ZK6116HNGS2"},{"name":"ZK6120HGM","value":"ZK6120HGM"},{"name":"ZK6650BEVG21","value":"ZK6650BEVG21"},{"name":"ZK6710Q1","value":"ZK6710Q1"},{"name":"ZK6729DT1","value":"ZK6729DT1"},{"name":"ZK6805BEVG3","value":"ZK6805BEVG3"},{"name":"ZK6815BEVG1","value":"ZK6815BEVG1"},{"name":"ZK6896HGA","value":"ZK6896HGA"}]
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
         * name : HFF6105G39C
         * value : HFF6105G39C
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
