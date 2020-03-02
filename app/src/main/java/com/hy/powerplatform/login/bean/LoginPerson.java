package com.hy.powerplatform.login.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/12/21.
 */

public class LoginPerson implements Serializable {

    /**
     * success : true
     * totalCounts : 120
     * result : [{"fullName":"欧阳晓林","userCode":"1729","cs":240,"yxcs":179,"rank":1,"dlcs":1557},{"fullName":"施鹏","userCode":"2100","cs":255,"yxcs":186,"rank":2,"dlcs":1506},{"fullName":"易睿","userCode":"1909","cs":243,"yxcs":200,"rank":3,"dlcs":1025},{"fullName":"谢海","userCode":"1804","cs":166,"yxcs":143,"rank":4,"dlcs":646},{"fullName":"袁斌","userCode":"153","cs":207,"yxcs":123,"rank":5,"dlcs":643},{"fullName":"周洋","userCode":"2064","cs":328,"yxcs":137,"rank":6,"dlcs":631},{"fullName":"晏慧锋","userCode":"10","cs":171,"yxcs":118,"rank":7,"dlcs":525},{"fullName":"林婕","userCode":"2467","cs":237,"yxcs":108,"rank":8,"dlcs":489},{"fullName":"邹晓军","userCode":"2365","cs":112,"yxcs":77,"rank":9,"dlcs":433},{"fullName":"陆卫敏","userCode":"25","cs":151,"yxcs":79,"rank":10,"dlcs":377},{"fullName":"李建萍","userCode":"2468","cs":149,"yxcs":96,"rank":11,"dlcs":373},{"fullName":"漆明","userCode":"60","cs":160,"yxcs":88,"rank":12,"dlcs":362},{"fullName":"朱云琴","userCode":"1942","cs":154,"yxcs":77,"rank":13,"dlcs":350},{"fullName":"孙红玮","userCode":"124","cs":141,"yxcs":76,"rank":14,"dlcs":317},{"fullName":"罗文杰","userCode":"2680","cs":137,"yxcs":74,"rank":15,"dlcs":314},{"fullName":"胡宜南","userCode":"2470","cs":137,"yxcs":71,"rank":16,"dlcs":307},{"fullName":"余清华","userCode":"150","cs":127,"yxcs":57,"rank":17,"dlcs":306},{"fullName":"周娜","userCode":"1799","cs":172,"yxcs":72,"rank":18,"dlcs":297},{"fullName":"廖文君","userCode":"2137","cs":76,"yxcs":46,"rank":19,"dlcs":292},{"fullName":"李健","userCode":"147","cs":157,"yxcs":75,"rank":20,"dlcs":283},{"fullName":"谭军","userCode":"530","cs":113,"yxcs":53,"rank":21,"dlcs":281},{"fullName":"张敏","userCode":"1432","cs":132,"yxcs":73,"rank":22,"dlcs":276},{"fullName":"欧阳成金","userCode":"42","cs":107,"yxcs":57,"rank":23,"dlcs":266},{"fullName":"刘竹梅","userCode":"1088","cs":138,"yxcs":54,"rank":24,"dlcs":262},{"fullName":"晏永金","userCode":"111","cs":123,"yxcs":56,"rank":25,"dlcs":248},{"fullName":"付伟博","userCode":"11","cs":96,"yxcs":56,"rank":26,"dlcs":243},{"fullName":"张志平","userCode":"146","cs":121,"yxcs":57,"rank":27,"dlcs":229},{"fullName":"张小兵","userCode":"949","cs":113,"yxcs":50,"rank":28,"dlcs":224},{"fullName":"吴迪","userCode":"1794","cs":113,"yxcs":46,"rank":29,"dlcs":222},{"fullName":"邹霞","userCode":"148","cs":98,"yxcs":42,"rank":30,"dlcs":212},{"fullName":"欧阳翰","userCode":"1907","cs":92,"yxcs":47,"rank":31,"dlcs":207},{"fullName":"罗小灵","userCode":"1011","cs":70,"yxcs":32,"rank":32,"dlcs":205},{"fullName":"喻海","userCode":"131","cs":90,"yxcs":45,"rank":33,"dlcs":186},{"fullName":"刘望","userCode":"2612","cs":87,"yxcs":44,"rank":34,"dlcs":176},{"fullName":"胡新南","userCode":"144","cs":74,"yxcs":40,"rank":35,"dlcs":172},{"fullName":"钟璐","userCode":"1974","cs":134,"yxcs":134,"rank":36,"dlcs":170},{"fullName":"钟璐","userCode":"1974","cs":134,"yxcs":134,"rank":36,"dlcs":170},{"fullName":"汪洁","userCode":"1731","cs":93,"yxcs":41,"rank":38,"dlcs":164},{"fullName":"唐根六","userCode":"2399","cs":80,"yxcs":28,"rank":39,"dlcs":162},{"fullName":"何爱民","userCode":"2768","cs":89,"yxcs":35,"rank":40,"dlcs":152},{"fullName":"刘晓霞","userCode":"138","cs":67,"yxcs":32,"rank":41,"dlcs":149},{"fullName":"田乐","userCode":"2621","cs":80,"yxcs":32,"rank":42,"dlcs":148},{"fullName":"王瑞田","userCode":"2762","cs":88,"yxcs":24,"rank":43,"dlcs":145},{"fullName":"刘娟","userCode":"1653","cs":74,"yxcs":34,"rank":44,"dlcs":140},{"fullName":"凌凡","userCode":"736","cs":78,"yxcs":37,"rank":45,"dlcs":130},{"fullName":"高胜东","userCode":"132","cs":65,"yxcs":34,"rank":46,"dlcs":125},{"fullName":"钟婷","userCode":"2327","cs":67,"yxcs":31,"rank":47,"dlcs":118},{"fullName":"陈国华","userCode":"1806","cs":66,"yxcs":24,"rank":48,"dlcs":113},{"fullName":"易祺","userCode":"1754","cs":57,"yxcs":30,"rank":49,"dlcs":102},{"fullName":"周志勇","userCode":"1039","cs":53,"yxcs":23,"rank":50,"dlcs":96},{"fullName":"孔志林","userCode":"1744","cs":62,"yxcs":13,"rank":51,"dlcs":78},{"fullName":"苏倩","userCode":"1587","cs":54,"yxcs":14,"rank":52,"dlcs":71},{"fullName":"熊倩倩","userCode":"2296","cs":55,"yxcs":9,"rank":52,"dlcs":71},{"fullName":"黄祖能","userCode":"118","cs":48,"yxcs":16,"rank":54,"dlcs":69},{"fullName":"汤思琪","userCode":"2238","cs":39,"yxcs":17,"rank":54,"dlcs":69},{"fullName":"陆应璇","userCode":"1968","cs":44,"yxcs":13,"rank":56,"dlcs":68},{"fullName":"邓爱兰","userCode":"2544","cs":28,"yxcs":17,"rank":57,"dlcs":62},{"fullName":"蔡雯","userCode":"2469","cs":17,"yxcs":16,"rank":58,"dlcs":60},{"fullName":"邓东","userCode":"2098","cs":14,"yxcs":11,"rank":58,"dlcs":60},{"fullName":"王晨","userCode":"2675","cs":32,"yxcs":19,"rank":60,"dlcs":59},{"fullName":"周青","userCode":"2102","cs":29,"yxcs":11,"rank":60,"dlcs":59},{"fullName":"王少云","userCode":"2398","cs":18,"yxcs":12,"rank":62,"dlcs":56},{"fullName":"李嘉","userCode":"1979","cs":32,"yxcs":9,"rank":63,"dlcs":47},{"fullName":"卢子剑","userCode":"2980","cs":25,"yxcs":25,"rank":64,"dlcs":45},{"fullName":"卢莉玲","userCode":"1588","cs":19,"yxcs":14,"rank":65,"dlcs":42},{"fullName":"刘洋","userCode":"1975","cs":22,"yxcs":12,"rank":65,"dlcs":42},{"fullName":"汤爱军","userCode":"685","cs":18,"yxcs":6,"rank":67,"dlcs":41},{"fullName":"肖娅君","userCode":"2101","cs":19,"yxcs":17,"rank":67,"dlcs":41},{"fullName":"钟璐","userCode":"1974","cs":134,"yxcs":134,"rank":67,"dlcs":41},{"fullName":"钟璐","userCode":"1974","cs":134,"yxcs":134,"rank":67,"dlcs":41},{"fullName":"丁世聪","userCode":"1908","cs":26,"yxcs":10,"rank":71,"dlcs":38},{"fullName":"周新科","userCode":"149","cs":17,"yxcs":7,"rank":72,"dlcs":37},{"fullName":"葛曦","userCode":"2015","cs":25,"yxcs":8,"rank":73,"dlcs":33},{"fullName":"周维","userCode":"123","cs":23,"yxcs":5,"rank":74,"dlcs":32},{"fullName":"梁凯","userCode":"1950","cs":20,"yxcs":5,"rank":75,"dlcs":31},{"fullName":"毕芳琴","userCode":"136","cs":17,"yxcs":8,"rank":76,"dlcs":29},{"fullName":"郭艺","userCode":"2353","cs":10,"yxcs":6,"rank":77,"dlcs":24},{"fullName":"王少贵","userCode":"1576","cs":12,"yxcs":5,"rank":78,"dlcs":22},{"fullName":"刘永锋","userCode":"259","cs":12,"yxcs":4,"rank":79,"dlcs":21},{"fullName":"曾宜","userCode":"2471","cs":16,"yxcs":4,"rank":79,"dlcs":21},{"fullName":"谢建军","userCode":"516","cs":13,"yxcs":5,"rank":81,"dlcs":20},{"fullName":"易成玉","userCode":"3045","cs":14,"yxcs":6,"rank":81,"dlcs":20},{"fullName":"邓业雄","userCode":"65","cs":2,"yxcs":2,"rank":83,"dlcs":14},{"fullName":"张辉龙","userCode":"657","cs":6,"yxcs":3,"rank":84,"dlcs":13},{"fullName":"郭晓群","userCode":"2343","cs":5,"yxcs":3,"rank":85,"dlcs":10},{"fullName":"许军","userCode":"528","cs":3,"yxcs":2,"rank":85,"dlcs":10},{"fullName":"龙瑞伟","userCode":"948","cs":3,"yxcs":2,"rank":87,"dlcs":8},{"fullName":"付小红","userCode":"1008","cs":5,"yxcs":2,"rank":87,"dlcs":8},{"fullName":"易臣倩","userCode":"2730","cs":5,"yxcs":2,"rank":87,"dlcs":8},{"fullName":"陈小军","userCode":"1976","cs":4,"yxcs":2,"rank":90,"dlcs":7},{"fullName":"唐也楠","userCode":"1905","cs":5,"yxcs":2,"rank":90,"dlcs":7},{"fullName":"周剑","userCode":"2763","cs":6,"yxcs":1,"rank":90,"dlcs":7},{"fullName":"张倚铭","userCode":"3044","cs":2,"yxcs":1,"rank":90,"dlcs":7},{"fullName":"范园","userCode":"2466","cs":2,"yxcs":2,"rank":94,"dlcs":5},{"fullName":"钟少斌","userCode":"513","cs":2,"yxcs":2,"rank":95,"dlcs":4},{"fullName":"李晖","userCode":"1252","cs":3,"yxcs":0,"rank":96,"dlcs":3},{"fullName":"范会明","userCode":"106","cs":2,"yxcs":0,"rank":97,"dlcs":2},{"fullName":"龚志敏","userCode":"928","cs":1,"yxcs":1,"rank":97,"dlcs":2},{"fullName":"李春华","userCode":"2077","cs":1,"yxcs":1,"rank":97,"dlcs":2},{"fullName":"刘长武","userCode":"1923","cs":1,"yxcs":1,"rank":97,"dlcs":2},{"fullName":"李俊杰","userCode":"2474","cs":1,"yxcs":1,"rank":97,"dlcs":2},{"fullName":"周文赞","userCode":"56","cs":2,"yxcs":0,"rank":97,"dlcs":2},{"fullName":"曾德新","userCode":"653","cs":1,"yxcs":0,"rank":103,"dlcs":1},{"fullName":"夏小明","userCode":"822","cs":1,"yxcs":0,"rank":103,"dlcs":1},{"fullName":"马腾","userCode":"1838","cs":1,"yxcs":0,"rank":103,"dlcs":1},{"fullName":"乐庆","userCode":"135","cs":1,"yxcs":0,"rank":103,"dlcs":1},{"fullName":"杨莎","userCode":"1971","cs":1,"yxcs":0,"rank":103,"dlcs":1},{"fullName":"杨小平","userCode":"2052","cs":1,"yxcs":0,"rank":103,"dlcs":1},{"fullName":"陈继胜","userCode":"1232","cs":0,"yxcs":0,"rank":109,"dlcs":0},{"fullName":"黄秀江","userCode":"99","cs":0,"yxcs":0,"rank":109,"dlcs":0},{"fullName":"黄雅馨","userCode":"2689","cs":0,"yxcs":0,"rank":109,"dlcs":0},{"fullName":"李北平","userCode":"2448","cs":0,"yxcs":0,"rank":109,"dlcs":0},{"fullName":"刘春辉","userCode":"1102","cs":0,"yxcs":0,"rank":109,"dlcs":0},{"fullName":"李松坚","userCode":"1138","cs":0,"yxcs":0,"rank":109,"dlcs":0},{"fullName":"施国荣","userCode":"611","cs":0,"yxcs":0,"rank":109,"dlcs":0},{"fullName":"余丽","userCode":"1580","cs":0,"yxcs":0,"rank":109,"dlcs":0},{"fullName":"易军","userCode":"2277","cs":0,"yxcs":0,"rank":109,"dlcs":0},{"fullName":"晏小明","userCode":"1852","cs":0,"yxcs":0,"rank":109,"dlcs":0},{"fullName":"邹勇","userCode":"2193","cs":0,"yxcs":0,"rank":109,"dlcs":0},{"fullName":"周亚军","userCode":"2436","cs":0,"yxcs":0,"rank":109,"dlcs":0}]
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
         * fullName : 欧阳晓林
         * userCode : 1729
         * cs : 240
         * yxcs : 179
         * rank : 1
         * dlcs : 1557
         */

        private String fullName;
        private String userCode;
        private int cs;
        private int yxcs;
        private int rank;
        private int dlcs;

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public String getUserCode() {
            return userCode;
        }

        public void setUserCode(String userCode) {
            this.userCode = userCode;
        }

        public int getCs() {
            return cs;
        }

        public void setCs(int cs) {
            this.cs = cs;
        }

        public int getYxcs() {
            return yxcs;
        }

        public void setYxcs(int yxcs) {
            this.yxcs = yxcs;
        }

        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }

        public int getDlcs() {
            return dlcs;
        }

        public void setDlcs(int dlcs) {
            this.dlcs = dlcs;
        }
    }
}
