package com.hy.powerplatform.business_inspect.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by dell on 2018/5/10.
 */

public class InspectDrive implements Serializable {


    /**
     * success : true
     * data : [{"fullname":"张建忠","profileId":38287,"userCode":"100082","eCard":"","sex":"男"},{"fullname":"郭永杰","profileId":38496,"userCode":"100745","eCard":"","sex":"男"},{"fullname":"李云仙","profileId":38571,"userCode":"100991","eCard":"","sex":"女"},{"fullname":"刘有根","profileId":38572,"userCode":"100992","eCard":"","sex":"男"},{"fullname":"董永花","profileId":38573,"userCode":"100996","eCard":"","sex":"女"},{"fullname":"原凤珍","profileId":38574,"userCode":"100997","eCard":"","sex":"女"},{"fullname":"魏翠枝","profileId":38575,"userCode":"101004","eCard":"","sex":"女"},{"fullname":"弓丽萍","profileId":38576,"userCode":"101007","eCard":"","sex":"女"},{"fullname":"安桂香","profileId":38577,"userCode":"101018","eCard":"","sex":"女"},{"fullname":"范二云","profileId":38578,"userCode":"101023","eCard":"","sex":"女"},{"fullname":"袁小宏","profileId":38579,"userCode":"101030","eCard":"","sex":"男"},{"fullname":"郝海涛","profileId":38580,"userCode":"101033","eCard":"","sex":"女"},{"fullname":"刘满枝","profileId":38581,"userCode":"101035","eCard":"","sex":"女"},{"fullname":"张贺德","profileId":38582,"userCode":"101036","eCard":"","sex":"男"},{"fullname":"齐虎林","profileId":38583,"userCode":"101041","eCard":"","sex":"男"},{"fullname":"冯淑珍","profileId":38584,"userCode":"101042","eCard":"","sex":"女"},{"fullname":"孙太海","profileId":38585,"userCode":"101053","eCard":"","sex":"男"},{"fullname":"赵果仙","profileId":38588,"userCode":"101067","eCard":"","sex":"女"},{"fullname":"张卫红","profileId":38603,"userCode":"101153","eCard":"","sex":"女"},{"fullname":"赵春卫","profileId":38616,"userCode":"101206","eCard":"","sex":"男"},{"fullname":"薛珍平","profileId":38617,"userCode":"101218","eCard":"","sex":"女"},{"fullname":"郝玉娥","profileId":38630,"userCode":"101251","eCard":"","sex":"女"},{"fullname":"齐建花","profileId":38639,"userCode":"101288","eCard":"","sex":"女"},{"fullname":"薛艳平","profileId":38649,"userCode":"101330","eCard":"","sex":"女"},{"fullname":"成金练","profileId":38653,"userCode":"101362","eCard":"","sex":"男"},{"fullname":"白利羊","profileId":38655,"userCode":"101369","eCard":"","sex":"男"},{"fullname":"许利根","profileId":38661,"userCode":"101399","eCard":"","sex":"男"},{"fullname":"冀金秀","profileId":38673,"userCode":"101422","eCard":"","sex":"女"},{"fullname":"李小红","profileId":38676,"userCode":"101429","eCard":"","sex":"女"},{"fullname":"薛小文","profileId":38678,"userCode":"101438","eCard":"","sex":"女"},{"fullname":"薛香旦","profileId":38694,"userCode":"101486","eCard":"","sex":"女"},{"fullname":"杜俊利","profileId":38702,"userCode":"101502","eCard":"","sex":"女"},{"fullname":"白艳清","profileId":38712,"userCode":"101532","eCard":"","sex":"女"},{"fullname":"梁建丽","profileId":38714,"userCode":"101536","eCard":"","sex":"女"},{"fullname":"赵秀平","profileId":38744,"userCode":"101608","eCard":"","sex":"男"},{"fullname":"陈翠梅","profileId":38751,"userCode":"101621","eCard":"","sex":"女"},{"fullname":"曹润清","profileId":38776,"userCode":"101686","eCard":"","sex":"女"},{"fullname":"李永贵","profileId":38782,"userCode":"101721","eCard":"","sex":"男"},{"fullname":"白明英","profileId":38799,"userCode":"101759","eCard":"","sex":"女"},{"fullname":"成宝树","profileId":38800,"userCode":"101760","eCard":"","sex":"男"},{"fullname":"张莉","profileId":38813,"userCode":"101790","eCard":"","sex":"女"},{"fullname":"段新梅","profileId":38814,"userCode":"101793","eCard":"","sex":"女"},{"fullname":"张红","profileId":38824,"userCode":"101839","eCard":"","sex":"女"},{"fullname":"薛珍","profileId":38825,"userCode":"101843","eCard":"","sex":"男"},{"fullname":"李金平","profileId":38833,"userCode":"101871","eCard":"","sex":"男"},{"fullname":"刘海萍","profileId":38834,"userCode":"101873","eCard":"","sex":"女"},{"fullname":"张巧珍","profileId":38835,"userCode":"101874","eCard":"","sex":"女"},{"fullname":"魏永军","profileId":38841,"userCode":"101898","eCard":"","sex":"男"},{"fullname":"杨书萍","profileId":38849,"userCode":"101920","eCard":"","sex":"女"},{"fullname":"田宏霞","profileId":38851,"userCode":"101923","eCard":"","sex":"女"},{"fullname":"白改英","profileId":38857,"userCode":"101951","eCard":"","sex":"女"},{"fullname":"李志红","profileId":38859,"userCode":"101955","eCard":"","sex":"男"},{"fullname":"马永红","profileId":38860,"userCode":"101956","eCard":"","sex":"男"},{"fullname":"张艾金","profileId":38864,"userCode":"101990","eCard":"","sex":"女"},{"fullname":"张翠花","profileId":38889,"userCode":"102069","eCard":"","sex":"女"},{"fullname":"常志旺","profileId":38890,"userCode":"102071","eCard":"","sex":"男"},{"fullname":"任改转","profileId":38891,"userCode":"102072","eCard":"","sex":"女"},{"fullname":"朱莹","profileId":38895,"userCode":"102082","eCard":"","sex":"女"},{"fullname":"褚翠萍","profileId":38905,"userCode":"102093","eCard":"","sex":"女"},{"fullname":"张灵花","profileId":38915,"userCode":"102118","eCard":"","sex":"女"},{"fullname":"弓翠萍","profileId":38926,"userCode":"102135","eCard":"","sex":"女"},{"fullname":"李丑斌","profileId":38928,"userCode":"102139","eCard":"","sex":"男"},{"fullname":"李鹏","profileId":38929,"userCode":"102141","eCard":"","sex":"男"},{"fullname":"范志刚","profileId":38934,"userCode":"102155","eCard":"","sex":"男"},{"fullname":"常变仙","profileId":38951,"userCode":"102184","eCard":"","sex":"女"},{"fullname":"王美林","profileId":38959,"userCode":"102199","eCard":"","sex":"女"},{"fullname":"要转花","profileId":38984,"userCode":"102257","eCard":"","sex":"女"},{"fullname":"冀春明","profileId":38985,"userCode":"102258","eCard":"","sex":"女"},{"fullname":"郑永福","profileId":39002,"userCode":"102286","eCard":"","sex":"男"},{"fullname":"薛雪东","profileId":39003,"userCode":"102289","eCard":"","sex":"男"},{"fullname":"张永拴","profileId":39049,"userCode":"102354","eCard":"","sex":"男"},{"fullname":"解富","profileId":39076,"userCode":"102416","eCard":"","sex":"男"},{"fullname":"薛明明","profileId":39077,"userCode":"102420","eCard":"","sex":"女"},{"fullname":"安永前","profileId":39101,"userCode":"102450","eCard":"","sex":"男"},{"fullname":"徐翠香","profileId":39113,"userCode":"102466","eCard":"","sex":"女"},{"fullname":"高东跃","profileId":39114,"userCode":"102467","eCard":"","sex":"男"},{"fullname":"王丽锦","profileId":39117,"userCode":"102473","eCard":"","sex":"女"},{"fullname":"荣爱军","profileId":39149,"userCode":"102517","eCard":"","sex":"男"},{"fullname":"李侯小","profileId":39150,"userCode":"102519","eCard":"","sex":"男"},{"fullname":"孟春明","profileId":39151,"userCode":"102520","eCard":"","sex":"男"},{"fullname":"王咏霞","profileId":39158,"userCode":"102527","eCard":"","sex":"女"},{"fullname":"曹照明","profileId":39167,"userCode":"102536","eCard":"","sex":"男"},{"fullname":"范宝平","profileId":39168,"userCode":"102537","eCard":"","sex":"女"},{"fullname":"赵新亮","profileId":39173,"userCode":"102542","eCard":"","sex":"男"},{"fullname":"薛永明","profileId":39177,"userCode":"102546","eCard":"","sex":"男"},{"fullname":"李红亮","profileId":39178,"userCode":"102547","eCard":"","sex":"男"},{"fullname":"王爱忠","profileId":39179,"userCode":"102548","eCard":"","sex":"男"},{"fullname":"宋新广","profileId":39180,"userCode":"102549","eCard":"","sex":"男"},{"fullname":"梁素军","profileId":39181,"userCode":"102550","eCard":"","sex":"男"},{"fullname":"郝永强","profileId":39182,"userCode":"102551","eCard":"","sex":"男"},{"fullname":"田玉川","profileId":39183,"userCode":"102552","eCard":"","sex":"男"},{"fullname":"侯海元","profileId":39184,"userCode":"102553","eCard":"","sex":"男"},{"fullname":"祁进林","profileId":39185,"userCode":"102554","eCard":"","sex":"男"},{"fullname":"王培军","profileId":39186,"userCode":"102555","eCard":"","sex":"男"},{"fullname":"闫治国","profileId":39187,"userCode":"102556","eCard":"","sex":"男"},{"fullname":"范云兔","profileId":39188,"userCode":"102557","eCard":"","sex":"男"},{"fullname":"段利强","profileId":40298,"userCode":"102562","eCard":"","sex":"男"},{"fullname":"郑秋红","profileId":40327,"userCode":"102565","eCard":"","sex":"女"}]
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

    public static class DataBean implements Serializable{
        /**
         * fullname : 张建忠
         * profileId : 38287
         * userCode : 100082
         * eCard :
         * sex : 男
         */

        private String fullname;
        private String profileId;
        private String userCode;
        private String eCard;
        private String sex;

        public DataBean(String fullname, String profileId, String userCode, String eCard, String sex) {
            this.fullname = fullname;
            this.profileId = profileId;
            this.userCode = userCode;
            this.eCard = eCard;
            this.sex = sex;
        }

        public String getFullname() {
            return fullname;
        }

        public void setFullname(String fullname) {
            this.fullname = fullname;
        }

        public String getProfileId() {
            return profileId;
        }

        public void setProfileId(String profileId) {
            this.profileId = profileId;
        }

        public String getUserCode() {
            return userCode;
        }

        public void setUserCode(String userCode) {
            this.userCode = userCode;
        }

        public String getECard() {
            return eCard;
        }

        public void setECard(String eCard) {
            this.eCard = eCard;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }
    }
}
