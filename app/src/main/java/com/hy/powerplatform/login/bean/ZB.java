package com.hy.powerplatform.login.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 李明璐 on 2020/2/8.
 */

public class ZB implements Serializable {

    /**
     * result : [{"sqnum":"532.00","name":"运营车辆数据(辆)","hb":"0.00%","yearCount":"0.00","id":"1","bqnum":"532.00","tqnum":"532.00","tb":"0.00%"},{"sqnum":"431.00","name":"新能源车辆数（辆）","hb":"0.00%","yearCount":"0.00","id":"2","bqnum":"431.00","tqnum":"431.00","tb":"0.00%"},{"sqnum":"47.00","name":"运营线路条数(条)","hb":"0.00%","yearCount":"0.00","id":"3","bqnum":"47.00","tqnum":"38.00","tb":"23.68%"},{"sqnum":"1168.10","name":"运营线路长度(公里)","hb":"0.00%","yearCount":"0.00","id":"4","bqnum":"1168.10","tqnum":"984.30","tb":"18.67%"},{"sqnum":"309.21","name":"总行驶里程（万公里）","hb":"-81.86%","yearCount":"365.30","id":"5","bqnum":"56.09","tqnum":"268.18","tb":"-79.08%"},{"sqnum":"309.21","name":"运营里程（万公里）","hb":"-81.86%","yearCount":"365.30","id":"6","bqnum":"56.09","tqnum":"268.18","tb":"-79.08%"},{"sqnum":"3934.00","name":"人均营运里程（公里）","hb":"-81.86%","yearCount":"4647.59","id":"7","bqnum":"713.59","tqnum":"3943.85","tb":"-81.91%"},{"sqnum":"100.00","name":"里程利用率(%)","hb":"0.00%","yearCount":"100.00","id":"8","bqnum":"100.00","tqnum":"100.00","tb":"0.00%"},{"sqnum":"88.49%","name":"工作车率","hb":"-78.68%","yearCount":"8.77%","id":"9","bqnum":"18.87%","tqnum":"86.48%","tb":"-78.18%"},{"sqnum":"159.69","name":"车日行程(公里)","hb":"-12.20%","yearCount":"156.34","id":"10","bqnum":"140.21","tqnum":"160.89","tb":"-12.85%"},{"sqnum":"489.43","name":"客运总量（万人）","hb":"-97.40%","yearCount":"502.15","id":"11","bqnum":"12.72","tqnum":"426.85","tb":"-97.02%"},{"sqnum":"284.66","name":"IC卡运量（万人）","hb":"-97.56%","yearCount":"291.60","id":"12","bqnum":"6.94","tqnum":"188.40","tb":"-96.32%"},{"sqnum":"204.77","name":"投币运量（万人）","hb":"-97.18%","yearCount":"210.55","id":"13","bqnum":"5.78","tqnum":"238.45","tb":"-97.58%"},{"sqnum":"337.15","name":"总营运收入（万元）","hb":"-97.42%","yearCount":"345.86","id":"14","bqnum":"8.71","tqnum":"333.90","tb":"-97.39%"},{"sqnum":"4289.46","name":"人均营运收入（元）","hb":"-97.42%","yearCount":"4400.24","id":"15","bqnum":"110.78","tqnum":"4910.27","tb":"-97.74%"},{"sqnum":"217.15","name":"投币收入（万元）","hb":"-97.27%","yearCount":"223.07","id":"16","bqnum":"5.92","tqnum":"251.18","tb":"-97.64%"},{"sqnum":"35.10","name":"普通卡收入（万元）","hb":"-98.49%","yearCount":"35.63","id":"17","bqnum":"0.53","tqnum":"23.28","tb":"-97.72%"},{"sqnum":"84.90","name":"电子钱包收入（万元）","hb":"-97.34%","yearCount":"87.16","id":"18","bqnum":"2.26","tqnum":"59.44","tb":"-96.20%"},{"sqnum":"91.71","name":"百公里营运收入（元）","hb":"602.39%","yearCount":"105.62","id":"19","bqnum":"644.16","tqnum":"80.32","tb":"701.99%"},{"sqnum":"206.89","name":"总燃料消耗（万元）","hb":"-96.29%","yearCount":"214.57","id":"20","bqnum":"7.68","tqnum":"146.01","tb":"-94.74%"},{"sqnum":"23.99","name":"柴油（万元）","hb":"-100.00%","yearCount":"23.99","id":"21","bqnum":"0.00","tqnum":"0.00","tb":"0.00%"},{"sqnum":"104.89","name":"LNG（万元）","hb":"-100.00%","yearCount":"104.89","id":"22","bqnum":"0.00","tqnum":"76.59","tb":"-100.00%"},{"sqnum":"15.76","name":"CNG（万元）","hb":"-100.00%","yearCount":"15.76","id":"23","bqnum":"0.00","tqnum":"2.45","tb":"-100.00%"},{"sqnum":"62.24","name":"电费（万元）","hb":"-87.66%","yearCount":"69.92","id":"24","bqnum":"7.68","tqnum":"66.98","tb":"-88.53%"},{"sqnum":"1046.00","name":"期末职工人数(人)","hb":"0.00%","yearCount":"0.00","id":"25","bqnum":"1046.00","tqnum":"889.00","tb":"17.66%"},{"sqnum":"3.00","name":"离职人数(人)","hb":"-100.00%","yearCount":"0.00","id":"26","bqnum":"0.00","tqnum":"9.00","tb":"-100.00%"},{"sqnum":"0.00","name":"退休人数(人)","hb":"0.00%","yearCount":"0.00","id":"27","bqnum":"0.00","tqnum":"0.00","tb":"0.00%"},{"sqnum":"87.00","name":"调动人数(人)","hb":"-100.00%","yearCount":"0.00","id":"28","bqnum":"0.00","tqnum":"25.00","tb":"-100.00%"},{"sqnum":"0.00","name":"入职人数(人)","hb":"0.00%","yearCount":"0.00","id":"29","bqnum":"0.00","tqnum":"3.00","tb":"-100.00%"},{"sqnum":"1.97","name":"人车比","hb":"0.00%","yearCount":"0.00","id":"30","bqnum":"1.97","tqnum":"1.67","tb":"17.96%"},{"sqnum":"0.00","name":"异常班次数（趟）","hb":"0.00%","yearCount":"0.00","id":"31","bqnum":"0.00","tqnum":"494.50","tb":"0.00%"},{"sqnum":"0.00","name":"驾驶员违规次数","hb":"0.00%","yearCount":"0.00","id":"32","bqnum":"0.00","tqnum":"18.00","tb":"-100.00%"}]
     * success : true
     * totalCounts : 32
     */
    private List<ResultEntity> result;
    private boolean success;
    private int totalCounts;

    public void setResult(List<ResultEntity> result) {
        this.result = result;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setTotalCounts(int totalCounts) {
        this.totalCounts = totalCounts;
    }

    public List<ResultEntity> getResult() {
        return result;
    }

    public boolean isSuccess() {
        return success;
    }

    public int getTotalCounts() {
        return totalCounts;
    }

    public class ResultEntity implements Serializable {
        /**
         * sqnum : 532.00
         * name : 运营车辆数据(辆)
         * hb : 0.00%
         * yearCount : 0.00
         * id : 1
         * bqnum : 532.00
         * tqnum : 532.00
         * tb : 0.00%
         */
        private String sqnum;
        private String name;
        private String hb;
        private String yearCount;
        private String id;
        private String bqnum;
        private String tqnum;
        private String tb;

        public void setSqnum(String sqnum) {
            this.sqnum = sqnum;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setHb(String hb) {
            this.hb = hb;
        }

        public void setYearCount(String yearCount) {
            this.yearCount = yearCount;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setBqnum(String bqnum) {
            this.bqnum = bqnum;
        }

        public void setTqnum(String tqnum) {
            this.tqnum = tqnum;
        }

        public void setTb(String tb) {
            this.tb = tb;
        }

        public String getSqnum() {
            return sqnum;
        }

        public String getName() {
            return name;
        }

        public String getHb() {
            return hb;
        }

        public String getYearCount() {
            return yearCount;
        }

        public String getId() {
            return id;
        }

        public String getBqnum() {
            return bqnum;
        }

        public String getTqnum() {
            return tqnum;
        }

        public String getTb() {
            return tb;
        }
    }
}
