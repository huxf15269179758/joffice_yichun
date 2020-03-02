package com.hy.powerplatform.business_inspect.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by dell on 2018/5/9.
 */

public class InspectAll implements Serializable {

    /**
     * success : true
     * data : [{"type":"安全行车","projectName":"安全文明驾驶","score":2},{"type":"安全行车","projectName":"平稳驾驶","score":3},{"type":"安全行车","projectName":"规范进出站","score":3},{"type":"安全行车","projectName":"安检","score":2},{"type":"安全行车","projectName":"正点、规范运营","score":100},{"type":"安全行车","projectName":"应急情况处理","score":3},{"type":"安全行车","projectName":"到站停车","score":100},{"type":"安全行车","projectName":"车辆发生故障时引导接应换乘乘客","score":2},{"type":"安全行车","projectName":"终点站上客","score":100},{"type":"驾驶技能","projectName":"八不走","score":2},{"type":"驾驶技能","projectName":"出车前怠速运转","score":3},{"type":"驾驶技能","projectName":"启动前仪表检查","score":2},{"type":"驾驶技能","projectName":"起动","score":2},{"type":"驾驶技能","projectName":"起步档位","score":2},{"type":"驾驶技能","projectName":"灯光使用","score":2},{"type":"驾驶技能","projectName":"开关门和起步程序","score":100},{"type":"驾驶技能","projectName":"增减档","score":2},{"type":"驾驶技能","projectName":"总电源关闭","score":2},{"type":"服务规范","projectName":"仪容仪表","score":1},{"type":"服务规范","projectName":"服务语言态度","score":3},{"type":"服务规范","projectName":"普通话","score":3},{"type":"服务规范","projectName":"重点照顾","score":1},{"type":"服务规范","projectName":"疏导","score":2},{"type":"服务规范","projectName":"报站器使用","score":2},{"type":"服务规范","projectName":"温度调节","score":2},{"type":"服务规范","projectName":"车辆卫生","score":2},{"type":"服务规范","projectName":"物品摆放","score":1},{"type":"服务规范","projectName":"服务展示牌使用","score":3},{"type":"服务规范","projectName":"违站不停","score":100},{"type":"服务规范","projectName":"二次进站、跑来等","score":2},{"type":"服务规范","projectName":"班前吃异味食品","score":1},{"type":"服务规范","projectName":"终点站检查","score":1}]
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
         * type : 安全行车
         * projectName : 安全文明驾驶
         * score : 2
         */

        private String type;
        private String projectName;
        private int score;

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

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }
    }
}
