package com.hy.powerplatform.comper.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2020/1/2.
 */

public class ShengChanYYList implements Serializable {

    /**
     * success : true
     * totalCounts : 23
     * result : [{"name":"运营车辆数据(辆)","bqnum":574,"sqnum":574,"hb":0,"tqnum":571,"tb":0.0053,"yearCount":0},{"name":"运营线路条数(条)","bqnum":52,"sqnum":52,"hb":0,"tqnum":43,"tb":0.2093,"yearCount":0},{"name":"运营线路长度(公里)","bqnum":1168.1,"sqnum":1168.1,"hb":0,"tqnum":984.3,"tb":0.1867,"yearCount":0},{"name":"总行驶里程(公里)","bqnum":"0","sqnum":2438234.32,"hb":"0","tqnum":2031711.12,"tb":"0","yearCount":2.322554688E7},{"name":"运营里程(公里)","bqnum":"0","sqnum":2350300.83,"hb":"0","tqnum":1933584.38,"tb":"0","yearCount":2.223083835E7},{"name":"里程利用率(%)","bqnum":"0","sqnum":3.61,"hb":"0","tqnum":4.83,"tb":"0","yearCount":4.28},{"name":"车日行程(公里)","bqnum":163.32,"sqnum":162.76,"hb":0.0035,"tqnum":144.66,"tb":0.129,"yearCount":160.21},{"name":"客运总量(人)","bqnum":4368245,"sqnum":5353562,"hb":-0.184,"tqnum":1924591,"tb":1.2697,"yearCount":5.3911949E7},{"name":"IC卡运量(人)","bqnum":2856563,"sqnum":3213023,"hb":-0.1109,"tqnum":0,"tb":0,"yearCount":3.0387577E7},{"name":"投币运量(人)","bqnum":1511682,"sqnum":2140539,"hb":-0.2938,"tqnum":1924591,"tb":-0.2145,"yearCount":2.3524372E7},{"name":"投币收入(元)","bqnum":1657229.5,"sqnum":2361319.5,"hb":-0.2982,"tqnum":2067382.6,"tb":-0.1984,"yearCount":2.53314204E7},{"name":"柴油(元)","bqnum":0,"sqnum":212915.77,"hb":-1,"tqnum":0,"tb":0,"yearCount":1553693.91},{"name":"LNG(元)","bqnum":0,"sqnum":983997.38,"hb":-1,"tqnum":727833.06,"tb":-1,"yearCount":1.02003263E7},{"name":"CNG(元)","bqnum":169,"sqnum":168466.97,"hb":-0.999,"tqnum":58996.53,"tb":-0.9971,"yearCount":607640.01},{"name":"电费(元)","bqnum":474699.64,"sqnum":541809,"hb":-0.1239,"tqnum":312432.55,"tb":0.5194,"yearCount":7453309.36},{"name":"期末职工人数(人)","bqnum":1053,"sqnum":1043,"hb":0.0096,"tqnum":879,"tb":0.198,"yearCount":0},{"name":"离职人数(人)","bqnum":1,"sqnum":1,"hb":0,"tqnum":7,"tb":-0.8571,"yearCount":0},{"name":"退休人数(人)","bqnum":0,"sqnum":1,"hb":-1,"tqnum":1,"tb":-1,"yearCount":0},{"name":"调动人数(人)","bqnum":20,"sqnum":22,"hb":-0.0909,"tqnum":16,"tb":0.25,"yearCount":0},{"name":"入职人数(人)","bqnum":0,"sqnum":0,"hb":0,"tqnum":10,"tb":-1,"yearCount":0},{"name":"人车比","bqnum":1.83,"sqnum":1.8199999999999998,"hb":0.0055,"tqnum":1.54,"tb":0.1883,"yearCount":0},{"name":"异常班次数（趟）","bqnum":0,"sqnum":5,"hb":-1,"tqnum":0,"tb":0,"yearCount":8837},{"name":"驾驶员违规次数","bqnum":0,"sqnum":0,"hb":0,"tqnum":0,"tb":0,"yearCount":4}]
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

    public static class ResultBean implements Serializable {
        /**
         * name : 运营车辆数据(辆)
         * bqnum : 574.0
         * sqnum : 574.0
         * hb : 0.0
         * tqnum : 571.0
         * tb : 0.0053
         * yearCount : 0.0
         */

        private String name;
        private String bqnum;
        private String sqnum;
        private String hb;
        private String tqnum;
        private String tb;
        private String yearCount;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getBqnum() {
            return bqnum;
        }

        public void setBqnum(String bqnum) {
            this.bqnum = bqnum;
        }

        public String getSqnum() {
            return sqnum;
        }

        public void setSqnum(String sqnum) {
            this.sqnum = sqnum;
        }

        public String getHb() {
            return hb;
        }

        public void setHb(String hb) {
            this.hb = hb;
        }

        public String getTqnum() {
            return tqnum;
        }

        public void setTqnum(String tqnum) {
            this.tqnum = tqnum;
        }

        public String getTb() {
            return tb;
        }

        public void setTb(String tb) {
            this.tb = tb;
        }

        public String getYearCount() {
            return yearCount;
        }

        public void setYearCount(String yearCount) {
            this.yearCount = yearCount;
        }
    }
}
