package com.hy.powerplatform.oa_flow.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/2/11.
 */

public class MyGoodsPurchase implements Serializable {

    /**
     * success : true
     * mainform : [{"jcbmyj":"","jbldyj":"","mingcheng1":"测试","mingcheng3":"","mingcheng2":"测试","mingcheng4":"","mingcheng5":"","bm":"宜春公交集团有限公司","iszc":"资产类","QiTa":"","zcgkbmyj":"","jine2":"1.0","jine3":"","cwzjyj":"","jine4":"","jbfgldyj":"","jine5":"","jine1":"1.0","hejisl":"2","danwei1":"1","cbfgldyj":"","beizhu4":"","beizhu3":"","beizhu2":"测试","beizhu1":"测试","danwei2":"1","danwei3":"","danwei4":"","bmfzryj":"[{\"ui\":\"9354\",\"un\":\"欧阳晓林\",\"c\":\"2019-10-16 10:03\",\"v\":\"测试\"}]","beizhu5":"","LiuShuiHao":"No.20191016012","danwei5":"","shuliang3":"","shuliang4":"","shuliang1":"1","xgfj":"","shuliang2":"1","shuliang5":"","runId":52156,"hejidj":"","mainId":66,"sqrq":"2019-10-16","goodsType":"办公家具","cggybyj":"[{\"ui\":\"9407\",\"un\":\"李洪平（代）\",\"c\":\"2019-10-16 10:20\",\"v\":\"撒大声地\"}]","hejije":"2","sqr":"超级管理员","$type$":"WF_WuPinCaiGouJiHuaBiao000YuanYiShangBiao","danjia5":"","danjia4":"","danjia3":"","danjia2":"1","fgldyj":"","danjia1":"1","yt":"测试","zjlyj":"","cgfgldyj":"","zcDepName":""}]
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
         * jcbmyj :
         * jbldyj :
         * mingcheng1 : 测试
         * mingcheng3 :
         * mingcheng2 : 测试
         * mingcheng4 :
         * mingcheng5 :
         * bm : 宜春公交集团有限公司
         * iszc : 资产类
         * QiTa :
         * zcgkbmyj :
         * jine2 : 1.0
         * jine3 :
         * cwzjyj :
         * jine4 :
         * jbfgldyj :
         * jine5 :
         * jine1 : 1.0
         * hejisl : 2
         * danwei1 : 1
         * cbfgldyj :
         * beizhu4 :
         * beizhu3 :
         * beizhu2 : 测试
         * beizhu1 : 测试
         * danwei2 : 1
         * danwei3 :
         * danwei4 :
         * bmfzryj : [{"ui":"9354","un":"欧阳晓林","c":"2019-10-16 10:03","v":"测试"}]
         * beizhu5 :
         * LiuShuiHao : No.20191016012
         * danwei5 :
         * shuliang3 :
         * shuliang4 :
         * shuliang1 : 1
         * xgfj :
         * shuliang2 : 1
         * shuliang5 :
         * runId : 52156
         * hejidj :
         * mainId : 66
         * sqrq : 2019-10-16
         * goodsType : 办公家具
         * cggybyj : [{"ui":"9407","un":"李洪平（代）","c":"2019-10-16 10:20","v":"撒大声地"}]
         * hejije : 2
         * sqr : 超级管理员
         * $type$ : WF_WuPinCaiGouJiHuaBiao000YuanYiShangBiao
         * danjia5 :
         * danjia4 :
         * danjia3 :
         * danjia2 : 1
         * fgldyj :
         * danjia1 : 1
         * yt : 测试
         * zjlyj :
         * cgfgldyj :
         * zcDepName :
         */

        private String jcbmyj;
        private String jbldyj;
        private String mingcheng1;
        private String mingcheng3;
        private String mingcheng2;
        private String mingcheng4;
        private String mingcheng5;
        private String bm;
        private String iszc;
        private String QiTa;
        private String zcgkbmyj;
        private String jine2;
        private String jine3;
        private String cwzjyj;
        private String jine4;
        private String jbfgldyj;
        private String jine5;
        private String jine1;
        private String hejisl;
        private String danwei1;
        private String cbfgldyj;
        private String beizhu4;
        private String beizhu3;
        private String beizhu2;
        private String beizhu1;
        private String danwei2;
        private String danwei3;
        private String danwei4;
        private String bmfzryj;
        private String beizhu5;
        private String LiuShuiHao;
        private String danwei5;
        private String shuliang3;
        private String shuliang4;
        private String shuliang1;
        private String xgfj;
        private String shuliang2;
        private String shuliang5;
        private String runId;
        private String hejidj;
        private int mainId;
        private String sqrq;
        private String goodsType;
        private String cggybyj;
        private String hejije;
        private String sqr;
        private String $type$;
        private String danjia5;
        private String danjia4;
        private String danjia3;
        private String danjia2;
        private String fgldyj;
        private String danjia1;
        private String yt;
        private String zjlyj;
        private String cgfgldyj;
        private String zcDepName;
        private String jine6;
        private String beizhu6;

        public String getJine6() {
            return jine6;
        }

        public void setJine6(String jine6) {
            this.jine6 = jine6;
        }

        public String getBeizhu6() {
            return beizhu6;
        }

        public void setBeizhu6(String beizhu6) {
            this.beizhu6 = beizhu6;
        }

        public String getJcbmyj() {
            return jcbmyj;
        }

        public void setJcbmyj(String jcbmyj) {
            this.jcbmyj = jcbmyj;
        }

        public String getJbldyj() {
            return jbldyj;
        }

        public void setJbldyj(String jbldyj) {
            this.jbldyj = jbldyj;
        }

        public String getMingcheng1() {
            return mingcheng1;
        }

        public void setMingcheng1(String mingcheng1) {
            this.mingcheng1 = mingcheng1;
        }

        public String getMingcheng3() {
            return mingcheng3;
        }

        public void setMingcheng3(String mingcheng3) {
            this.mingcheng3 = mingcheng3;
        }

        public String getMingcheng2() {
            return mingcheng2;
        }

        public void setMingcheng2(String mingcheng2) {
            this.mingcheng2 = mingcheng2;
        }

        public String getMingcheng4() {
            return mingcheng4;
        }

        public void setMingcheng4(String mingcheng4) {
            this.mingcheng4 = mingcheng4;
        }

        public String getMingcheng5() {
            return mingcheng5;
        }

        public void setMingcheng5(String mingcheng5) {
            this.mingcheng5 = mingcheng5;
        }

        public String getBm() {
            return bm;
        }

        public void setBm(String bm) {
            this.bm = bm;
        }

        public String getIszc() {
            return iszc;
        }

        public void setIszc(String iszc) {
            this.iszc = iszc;
        }

        public String getQiTa() {
            return QiTa;
        }

        public void setQiTa(String QiTa) {
            this.QiTa = QiTa;
        }

        public String getZcgkbmyj() {
            return zcgkbmyj;
        }

        public void setZcgkbmyj(String zcgkbmyj) {
            this.zcgkbmyj = zcgkbmyj;
        }

        public String getJine2() {
            return jine2;
        }

        public void setJine2(String jine2) {
            this.jine2 = jine2;
        }

        public String getJine3() {
            return jine3;
        }

        public void setJine3(String jine3) {
            this.jine3 = jine3;
        }

        public String getCwzjyj() {
            return cwzjyj;
        }

        public void setCwzjyj(String cwzjyj) {
            this.cwzjyj = cwzjyj;
        }

        public String getJine4() {
            return jine4;
        }

        public void setJine4(String jine4) {
            this.jine4 = jine4;
        }

        public String getJbfgldyj() {
            return jbfgldyj;
        }

        public void setJbfgldyj(String jbfgldyj) {
            this.jbfgldyj = jbfgldyj;
        }

        public String getJine5() {
            return jine5;
        }

        public void setJine5(String jine5) {
            this.jine5 = jine5;
        }

        public String getJine1() {
            return jine1;
        }

        public void setJine1(String jine1) {
            this.jine1 = jine1;
        }

        public String getHejisl() {
            return hejisl;
        }

        public void setHejisl(String hejisl) {
            this.hejisl = hejisl;
        }

        public String getDanwei1() {
            return danwei1;
        }

        public void setDanwei1(String danwei1) {
            this.danwei1 = danwei1;
        }

        public String getCbfgldyj() {
            return cbfgldyj;
        }

        public void setCbfgldyj(String cbfgldyj) {
            this.cbfgldyj = cbfgldyj;
        }

        public String getBeizhu4() {
            return beizhu4;
        }

        public void setBeizhu4(String beizhu4) {
            this.beizhu4 = beizhu4;
        }

        public String getBeizhu3() {
            return beizhu3;
        }

        public void setBeizhu3(String beizhu3) {
            this.beizhu3 = beizhu3;
        }

        public String getBeizhu2() {
            return beizhu2;
        }

        public void setBeizhu2(String beizhu2) {
            this.beizhu2 = beizhu2;
        }

        public String getBeizhu1() {
            return beizhu1;
        }

        public void setBeizhu1(String beizhu1) {
            this.beizhu1 = beizhu1;
        }

        public String getDanwei2() {
            return danwei2;
        }

        public void setDanwei2(String danwei2) {
            this.danwei2 = danwei2;
        }

        public String getDanwei3() {
            return danwei3;
        }

        public void setDanwei3(String danwei3) {
            this.danwei3 = danwei3;
        }

        public String getDanwei4() {
            return danwei4;
        }

        public void setDanwei4(String danwei4) {
            this.danwei4 = danwei4;
        }

        public String getBmfzryj() {
            return bmfzryj;
        }

        public void setBmfzryj(String bmfzryj) {
            this.bmfzryj = bmfzryj;
        }

        public String getBeizhu5() {
            return beizhu5;
        }

        public void setBeizhu5(String beizhu5) {
            this.beizhu5 = beizhu5;
        }

        public String getLiuShuiHao() {
            return LiuShuiHao;
        }

        public void setLiuShuiHao(String LiuShuiHao) {
            this.LiuShuiHao = LiuShuiHao;
        }

        public String getDanwei5() {
            return danwei5;
        }

        public void setDanwei5(String danwei5) {
            this.danwei5 = danwei5;
        }

        public String getShuliang3() {
            return shuliang3;
        }

        public void setShuliang3(String shuliang3) {
            this.shuliang3 = shuliang3;
        }

        public String getShuliang4() {
            return shuliang4;
        }

        public void setShuliang4(String shuliang4) {
            this.shuliang4 = shuliang4;
        }

        public String getShuliang1() {
            return shuliang1;
        }

        public void setShuliang1(String shuliang1) {
            this.shuliang1 = shuliang1;
        }

        public String getXgfj() {
            return xgfj;
        }

        public void setXgfj(String xgfj) {
            this.xgfj = xgfj;
        }

        public String getShuliang2() {
            return shuliang2;
        }

        public void setShuliang2(String shuliang2) {
            this.shuliang2 = shuliang2;
        }

        public String getShuliang5() {
            return shuliang5;
        }

        public void setShuliang5(String shuliang5) {
            this.shuliang5 = shuliang5;
        }

        public String getRunId() {
            return runId;
        }

        public void setRunId(String runId) {
            this.runId = runId;
        }

        public String getHejidj() {
            return hejidj;
        }

        public void setHejidj(String hejidj) {
            this.hejidj = hejidj;
        }

        public int getMainId() {
            return mainId;
        }

        public void setMainId(int mainId) {
            this.mainId = mainId;
        }

        public String getSqrq() {
            return sqrq;
        }

        public void setSqrq(String sqrq) {
            this.sqrq = sqrq;
        }

        public String getGoodsType() {
            return goodsType;
        }

        public void setGoodsType(String goodsType) {
            this.goodsType = goodsType;
        }

        public String getCggybyj() {
            return cggybyj;
        }

        public void setCggybyj(String cggybyj) {
            this.cggybyj = cggybyj;
        }

        public String getHejije() {
            return hejije;
        }

        public void setHejije(String hejije) {
            this.hejije = hejije;
        }

        public String getSqr() {
            return sqr;
        }

        public void setSqr(String sqr) {
            this.sqr = sqr;
        }

        public String get$type$() {
            return $type$;
        }

        public void set$type$(String $type$) {
            this.$type$ = $type$;
        }

        public String getDanjia5() {
            return danjia5;
        }

        public void setDanjia5(String danjia5) {
            this.danjia5 = danjia5;
        }

        public String getDanjia4() {
            return danjia4;
        }

        public void setDanjia4(String danjia4) {
            this.danjia4 = danjia4;
        }

        public String getDanjia3() {
            return danjia3;
        }

        public void setDanjia3(String danjia3) {
            this.danjia3 = danjia3;
        }

        public String getDanjia2() {
            return danjia2;
        }

        public void setDanjia2(String danjia2) {
            this.danjia2 = danjia2;
        }

        public String getFgldyj() {
            return fgldyj;
        }

        public void setFgldyj(String fgldyj) {
            this.fgldyj = fgldyj;
        }

        public String getDanjia1() {
            return danjia1;
        }

        public void setDanjia1(String danjia1) {
            this.danjia1 = danjia1;
        }

        public String getYt() {
            return yt;
        }

        public void setYt(String yt) {
            this.yt = yt;
        }

        public String getZjlyj() {
            return zjlyj;
        }

        public void setZjlyj(String zjlyj) {
            this.zjlyj = zjlyj;
        }

        public String getCgfgldyj() {
            return cgfgldyj;
        }

        public void setCgfgldyj(String cgfgldyj) {
            this.cgfgldyj = cgfgldyj;
        }

        public String getZcDepName() {
            return zcDepName;
        }

        public void setZcDepName(String zcDepName) {
            this.zcDepName = zcDepName;
        }
    }
}
