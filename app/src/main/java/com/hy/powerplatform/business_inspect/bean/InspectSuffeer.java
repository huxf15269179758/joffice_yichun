package com.hy.powerplatform.business_inspect.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by dell on 2018/5/9.
 */

public class InspectSuffeer implements Serializable {

    /**
     * success : true
     * totalCounts : 10
     * result : [{"id":181,"type":"运营车辆安全秩序","projectName":"违反标志标线"},{"id":182,"type":"运营车辆安全秩序","projectName":"进靠站"},{"id":183,"type":"运营车辆安全秩序","projectName":"右转弯直行"},{"id":184,"type":"运营车辆安全秩序","projectName":"接打手机"},{"id":185,"type":"运营车辆安全秩序","projectName":"闲谈"},{"id":186,"type":"运营车辆安全秩序","projectName":"交通信号"},{"id":187,"type":"运营车辆安全秩序","projectName":"开快车"},{"id":188,"type":"运营车辆安全秩序","projectName":"安检"},{"id":189,"type":"运营车辆安全秩序","projectName":"疲劳驾驶"},{"id":190,"type":"运营车辆安全秩序","projectName":"其他"}]
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

    public static class ResultBean {
        /**
         * id : 181
         * type : 运营车辆安全秩序
         * projectName : 违反标志标线
         */

        private int id;
        private String type;
        private String projectName;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getProjectName() {
            return projectName;
        }

        public void setProjectName(String projectName) {
            this.projectName = projectName;
        }
    }
}
