package com.hy.powerplatform.oa_flow.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/2/12.
 */

public class MyEntry implements Serializable {


    /**
     * success : true
     * mainform : [{"ZhunJiaCheXing":"","ZhunJiaCheXing1":"","ZhunJiaCheXing3":"","xm":"彭兵","sfzh":"362201197907086010","runId":51547,"rlzybyj":"","xxjsbyj":"","rlzyb1":"","rlzyb2":"","rlzyb3":"","yyglbyj":"","mainId":25,"xb":"男","zhglbyj":"","fgs":"","$type$":"WF_jsyrzlcbnews","zjcx":"A1,A2,D","cctkjyxgsyj":"","xiangguanfujian":"","lxdh":"13870589739","cwsjbyj":"","xmUId":"","jbbmyj":"","LiuShuiHao":"No.20190314017"}]
     */

    private boolean success;
    private List<MainformBean> mainform;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<MainformBean> getMainform() {
        return mainform;
    }

    public void setMainform(List<MainformBean> mainform) {
        this.mainform = mainform;
    }

    public static class MainformBean {
        /**
         * ZhunJiaCheXing :
         * ZhunJiaCheXing1 :
         * ZhunJiaCheXing3 :
         * xm : 彭兵
         * sfzh : 362201197907086010
         * runId : 51547
         * rlzybyj :
         * xxjsbyj :
         * rlzyb1 :
         * rlzyb2 :
         * rlzyb3 :
         * yyglbyj :
         * mainId : 25
         * xb : 男
         * zhglbyj :
         * fgs :
         * $type$ : WF_jsyrzlcbnews
         * zjcx : A1,A2,D
         * cctkjyxgsyj :
         * xiangguanfujian :
         * lxdh : 13870589739
         * cwsjbyj :
         * xmUId :
         * jbbmyj :
         * LiuShuiHao : No.20190314017
         */

        private String ZhunJiaCheXing;
        private String ZhunJiaCheXing1;
        private String ZhunJiaCheXing3;
        private String xm;
        private String sfzh;
        private String runId;
        private String rlzybyj;
        private String xxjsbyj;
        private String rlzyb1;
        private String rlzyb2;
        private String rlzyb3;
        private String yyglbyj;
        private int mainId;
        private String xb;
        private String zhglbyj;
        private String fgs;
        private String $type$;
        private String zjcx;
        private String cctkjyxgsyj;
        private String xiangguanfujian;
        private String lxdh;
        private String cwsjbyj;
        private String xmUId;
        private String jbbmyj;
        private String ygbh;
        private String LiuShuiHao;

        public String getYgbh() {
            return ygbh;
        }

        public void setYgbh(String ygbh) {
            this.ygbh = ygbh;
        }

        public String getZhunJiaCheXing() {
            return ZhunJiaCheXing;
        }

        public void setZhunJiaCheXing(String ZhunJiaCheXing) {
            this.ZhunJiaCheXing = ZhunJiaCheXing;
        }

        public String getZhunJiaCheXing1() {
            return ZhunJiaCheXing1;
        }

        public void setZhunJiaCheXing1(String ZhunJiaCheXing1) {
            this.ZhunJiaCheXing1 = ZhunJiaCheXing1;
        }

        public String getZhunJiaCheXing3() {
            return ZhunJiaCheXing3;
        }

        public void setZhunJiaCheXing3(String ZhunJiaCheXing3) {
            this.ZhunJiaCheXing3 = ZhunJiaCheXing3;
        }

        public String getXm() {
            return xm;
        }

        public void setXm(String xm) {
            this.xm = xm;
        }

        public String getSfzh() {
            return sfzh;
        }

        public void setSfzh(String sfzh) {
            this.sfzh = sfzh;
        }

        public String getRunId() {
            return runId;
        }

        public void setRunId(String runId) {
            this.runId = runId;
        }

        public String getRlzybyj() {
            return rlzybyj;
        }

        public void setRlzybyj(String rlzybyj) {
            this.rlzybyj = rlzybyj;
        }

        public String getXxjsbyj() {
            return xxjsbyj;
        }

        public void setXxjsbyj(String xxjsbyj) {
            this.xxjsbyj = xxjsbyj;
        }

        public String getRlzyb1() {
            return rlzyb1;
        }

        public void setRlzyb1(String rlzyb1) {
            this.rlzyb1 = rlzyb1;
        }

        public String getRlzyb2() {
            return rlzyb2;
        }

        public void setRlzyb2(String rlzyb2) {
            this.rlzyb2 = rlzyb2;
        }

        public String getRlzyb3() {
            return rlzyb3;
        }

        public void setRlzyb3(String rlzyb3) {
            this.rlzyb3 = rlzyb3;
        }

        public String getYyglbyj() {
            return yyglbyj;
        }

        public void setYyglbyj(String yyglbyj) {
            this.yyglbyj = yyglbyj;
        }

        public int getMainId() {
            return mainId;
        }

        public void setMainId(int mainId) {
            this.mainId = mainId;
        }

        public String getXb() {
            return xb;
        }

        public void setXb(String xb) {
            this.xb = xb;
        }

        public String getZhglbyj() {
            return zhglbyj;
        }

        public void setZhglbyj(String zhglbyj) {
            this.zhglbyj = zhglbyj;
        }

        public String getFgs() {
            return fgs;
        }

        public void setFgs(String fgs) {
            this.fgs = fgs;
        }

        public String get$type$() {
            return $type$;
        }

        public void set$type$(String $type$) {
            this.$type$ = $type$;
        }

        public String getZjcx() {
            return zjcx;
        }

        public void setZjcx(String zjcx) {
            this.zjcx = zjcx;
        }

        public String getCctkjyxgsyj() {
            return cctkjyxgsyj;
        }

        public void setCctkjyxgsyj(String cctkjyxgsyj) {
            this.cctkjyxgsyj = cctkjyxgsyj;
        }

        public String getXiangguanfujian() {
            return xiangguanfujian;
        }

        public void setXiangguanfujian(String xiangguanfujian) {
            this.xiangguanfujian = xiangguanfujian;
        }

        public String getLxdh() {
            return lxdh;
        }

        public void setLxdh(String lxdh) {
            this.lxdh = lxdh;
        }

        public String getCwsjbyj() {
            return cwsjbyj;
        }

        public void setCwsjbyj(String cwsjbyj) {
            this.cwsjbyj = cwsjbyj;
        }

        public String getXmUId() {
            return xmUId;
        }

        public void setXmUId(String xmUId) {
            this.xmUId = xmUId;
        }

        public String getJbbmyj() {
            return jbbmyj;
        }

        public void setJbbmyj(String jbbmyj) {
            this.jbbmyj = jbbmyj;
        }

        public String getLiuShuiHao() {
            return LiuShuiHao;
        }

        public void setLiuShuiHao(String LiuShuiHao) {
            this.LiuShuiHao = LiuShuiHao;
        }
    }
}
