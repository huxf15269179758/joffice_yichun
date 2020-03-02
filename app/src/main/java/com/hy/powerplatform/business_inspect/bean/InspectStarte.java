package com.hy.powerplatform.business_inspect.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by dell on 2018/5/9.
 */

public class InspectStarte implements Serializable {

    /**
     * success : true
     * data : [{"type":"规范服务","projectName":"仪容仪表仪态","score":2},{"type":"规范服务","projectName":"普通话","score":3},{"type":"规范服务","projectName":"十字文明用语,服务用语","score":2},{"type":"规范服务","projectName":"服务语言态度","score":3},{"type":"规范服务","projectName":"重点照顾,疏导","score":2},{"type":"规范服务","projectName":"报站器使用","score":2},{"type":"规范服务","projectName":"车辆卫生","score":3},{"type":"规范服务","projectName":"物品摆放","score":2},{"type":"规范服务","projectName":"车辆LED路牌","score":2},{"type":"规范服务","projectName":"车辆标志","score":1},{"type":"规范服务","projectName":"服务展示牌使用","score":5},{"type":"规范服务","projectName":"温度调节,通风","score":2},{"type":"规范服务","projectName":"故障换乘","score":2},{"type":"规范服务","projectName":"服务投诉","score":3},{"type":"驾驶技能","projectName":"出车前停站上客","score":2},{"type":"驾驶技能","projectName":"驾驶预判处理","score":2},{"type":"驾驶技能","projectName":"起动前仪表检查","score":3},{"type":"驾驶技能","projectName":"换挡离合器使用","score":2},{"type":"驾驶技能","projectName":"档位使用","score":2},{"type":"驾驶技能","projectName":"转向灯使用","score":2},{"type":"驾驶技能","projectName":"规范停靠","score":2},{"type":"规范运营安全行车","projectName":"遵守交通规则","score":2},{"type":"规范运营安全行车","projectName":"文明驾驶","score":2},{"type":"规范运营安全行车","projectName":"超速,未按调度指令发车","score":3},{"type":"规范运营安全行车","projectName":"安全事故","score":5},{"type":"规范运营安全行车","projectName":"规范进出站,逢站必停","score":3},{"type":"规范运营安全行车","projectName":"次进站,跑来等","score":2},{"type":"规范运营安全行车","projectName":"开关车门等程序","score":3},{"type":"规范运营安全行车","projectName":"安检","score":2},{"type":"规范运营安全行车","projectName":"配套及消防设施","score":2},{"type":"规范运营安全行车","projectName":"终点站服务","score":3}]
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
         * type : 规范服务
         * projectName : 仪容仪表仪态
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
