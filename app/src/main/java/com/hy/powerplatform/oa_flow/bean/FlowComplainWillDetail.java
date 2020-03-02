package com.hy.powerplatform.oa_flow.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/2/20.
 */

public class FlowComplainWillDetail implements Serializable {


    /**
     * success : true
     * taskId : 8150876
     * pkValue : mainId
     * formRights : {'bjpj':'1','YingYunFenGongSiChuLiJieGuo':'2','bjap':'2','bmfzryj':'1','TouSuNeiRong':'1','XingBie':'1','ShouLiRen':'1','SuoShuFenGongSi':'1','BeiTouSuChePaiHao':'1','TouSuRenXingMing':'1','TouSuRenZunCheng':'1','AnQuanFuWuBuYiJian':'1','cbbmyj':'1','BeiTouSuRenXingMing':'1','FanKuiTouSuRenJieGuo':'1','TouSuRiQi':'1','FenGongSiChengBanRen':'2','LianXiDianHua':'1','LiuShuiHao':'1','xiangguanfujian':'1','aqfwbyj':'1','BuMenFuZeRen':'1','SuoShuXianLu':'1'}
     * mainform : [{"YingYunFenGongSiChuLiJieGuo":"","SuoShuXianLu":"23","runId":51671,"SuoShuFenGongSi":"营运一分公司","XingBie":"男","TouSuRenZunCheng":"","bjap":"","mainId":11,"bjpj":"","BuMenFuZeRen":"","LianXiDianHua":"123","FenGongSiChengBanRen":"","ShouLiRen":"刘望","aqfwbyj":"","BeiTouSuChePaiHao":"车牌号","$type$":"WF_AnQuanFuWuBuTouSuZhuanBanDan","TouSuRiQi":"2019-02-28","cbbmyj":"","AnQuanFuWuBuYiJian":"","xiangguanfujian":"","BeiTouSuRenXingMing":"通过熟人","TouSuNeiRong":"内容","TouSuRenXingMing":"刘望","bmfzryj":"同意","LiuShuiHao":"No.20190228541","FanKuiTouSuRenJieGuo":""}]
     * formDefId : 10082
     * preTaskName :
     * isSignTask : false
     * trans : [{"destType":"task","destination":"安全服务部确认与反馈","name":"to 安全服务部确认与反馈","source":"办结安排"}]
     */

    private boolean success;
    private String taskId;
    private String pkValue;
    private String formRights;
    private String formDefId;
    private String preTaskName;
    private boolean isSignTask;
    private boolean revoke;
    private List<MainformBean> mainform;
    private List<TransBean> trans;

    public boolean isRevoke() {
        return revoke;
    }

    public void setRevoke(boolean revoke) {
        this.revoke = revoke;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getPkValue() {
        return pkValue;
    }

    public void setPkValue(String pkValue) {
        this.pkValue = pkValue;
    }

    public String getFormRights() {
        return formRights;
    }

    public void setFormRights(String formRights) {
        this.formRights = formRights;
    }

    public String getFormDefId() {
        return formDefId;
    }

    public void setFormDefId(String formDefId) {
        this.formDefId = formDefId;
    }

    public String getPreTaskName() {
        return preTaskName;
    }

    public void setPreTaskName(String preTaskName) {
        this.preTaskName = preTaskName;
    }

    public boolean isIsSignTask() {
        return isSignTask;
    }

    public void setIsSignTask(boolean isSignTask) {
        this.isSignTask = isSignTask;
    }

    public List<MainformBean> getMainform() {
        return mainform;
    }

    public void setMainform(List<MainformBean> mainform) {
        this.mainform = mainform;
    }

    public List<TransBean> getTrans() {
        return trans;
    }

    public void setTrans(List<TransBean> trans) {
        this.trans = trans;
    }

    public static class MainformBean {
        /**
         * YingYunFenGongSiChuLiJieGuo :
         * SuoShuXianLu : 23
         * runId : 51671
         * SuoShuFenGongSi : 营运一分公司
         * XingBie : 男
         * TouSuRenZunCheng :
         * bjap :
         * mainId : 11
         * bjpj :
         * BuMenFuZeRen :
         * LianXiDianHua : 123
         * FenGongSiChengBanRen :
         * ShouLiRen : 刘望
         * aqfwbyj :
         * BeiTouSuChePaiHao : 车牌号
         * $type$ : WF_AnQuanFuWuBuTouSuZhuanBanDan
         * TouSuRiQi : 2019-02-28
         * cbbmyj :
         * AnQuanFuWuBuYiJian :
         * xiangguanfujian :
         * BeiTouSuRenXingMing : 通过熟人
         * TouSuNeiRong : 内容
         * TouSuRenXingMing : 刘望
         * bmfzryj : 同意
         * LiuShuiHao : No.20190228541
         * FanKuiTouSuRenJieGuo :
         */

        private String YingYunFenGongSiChuLiJieGuo;
        private String SuoShuXianLu;
        private String runId;
        private String SuoShuFenGongSi;
        private String XingBie;
        private String TouSuRenZunCheng;
        private String bjap;
        private int mainId;
        private String bjpj;
        private String BuMenFuZeRen;
        private String LianXiDianHua;
        private String FenGongSiChengBanRen;
        private String ShouLiRen;
        private String aqfwbyj;
        private String BeiTouSuChePaiHao;
        private String $type$;
        private String TouSuRiQi;
        private String cbbmyj;
        private String AnQuanFuWuBuYiJian;
        private String xiangguanfujian;
        private String BeiTouSuRenXingMing;
        private String TouSuNeiRong;
        private String TouSuRenXingMing;
        private String bmfzryj;
        private String LiuShuiHao;
        private String FanKuiTouSuRenJieGuo;

        public String getYingYunFenGongSiChuLiJieGuo() {
            return YingYunFenGongSiChuLiJieGuo;
        }

        public void setYingYunFenGongSiChuLiJieGuo(String YingYunFenGongSiChuLiJieGuo) {
            this.YingYunFenGongSiChuLiJieGuo = YingYunFenGongSiChuLiJieGuo;
        }

        public String getSuoShuXianLu() {
            return SuoShuXianLu;
        }

        public void setSuoShuXianLu(String SuoShuXianLu) {
            this.SuoShuXianLu = SuoShuXianLu;
        }

        public String getRunId() {
            return runId;
        }

        public void setRunId(String runId) {
            this.runId = runId;
        }

        public String getSuoShuFenGongSi() {
            return SuoShuFenGongSi;
        }

        public void setSuoShuFenGongSi(String SuoShuFenGongSi) {
            this.SuoShuFenGongSi = SuoShuFenGongSi;
        }

        public String getXingBie() {
            return XingBie;
        }

        public void setXingBie(String XingBie) {
            this.XingBie = XingBie;
        }

        public String getTouSuRenZunCheng() {
            return TouSuRenZunCheng;
        }

        public void setTouSuRenZunCheng(String TouSuRenZunCheng) {
            this.TouSuRenZunCheng = TouSuRenZunCheng;
        }

        public String getBjap() {
            return bjap;
        }

        public void setBjap(String bjap) {
            this.bjap = bjap;
        }

        public int getMainId() {
            return mainId;
        }

        public void setMainId(int mainId) {
            this.mainId = mainId;
        }

        public String getBjpj() {
            return bjpj;
        }

        public void setBjpj(String bjpj) {
            this.bjpj = bjpj;
        }

        public String getBuMenFuZeRen() {
            return BuMenFuZeRen;
        }

        public void setBuMenFuZeRen(String BuMenFuZeRen) {
            this.BuMenFuZeRen = BuMenFuZeRen;
        }

        public String getLianXiDianHua() {
            return LianXiDianHua;
        }

        public void setLianXiDianHua(String LianXiDianHua) {
            this.LianXiDianHua = LianXiDianHua;
        }

        public String getFenGongSiChengBanRen() {
            return FenGongSiChengBanRen;
        }

        public void setFenGongSiChengBanRen(String FenGongSiChengBanRen) {
            this.FenGongSiChengBanRen = FenGongSiChengBanRen;
        }

        public String getShouLiRen() {
            return ShouLiRen;
        }

        public void setShouLiRen(String ShouLiRen) {
            this.ShouLiRen = ShouLiRen;
        }

        public String getAqfwbyj() {
            return aqfwbyj;
        }

        public void setAqfwbyj(String aqfwbyj) {
            this.aqfwbyj = aqfwbyj;
        }

        public String getBeiTouSuChePaiHao() {
            return BeiTouSuChePaiHao;
        }

        public void setBeiTouSuChePaiHao(String BeiTouSuChePaiHao) {
            this.BeiTouSuChePaiHao = BeiTouSuChePaiHao;
        }

        public String get$type$() {
            return $type$;
        }

        public void set$type$(String $type$) {
            this.$type$ = $type$;
        }

        public String getTouSuRiQi() {
            return TouSuRiQi;
        }

        public void setTouSuRiQi(String TouSuRiQi) {
            this.TouSuRiQi = TouSuRiQi;
        }

        public String getCbbmyj() {
            return cbbmyj;
        }

        public void setCbbmyj(String cbbmyj) {
            this.cbbmyj = cbbmyj;
        }

        public String getAnQuanFuWuBuYiJian() {
            return AnQuanFuWuBuYiJian;
        }

        public void setAnQuanFuWuBuYiJian(String AnQuanFuWuBuYiJian) {
            this.AnQuanFuWuBuYiJian = AnQuanFuWuBuYiJian;
        }

        public String getXiangguanfujian() {
            return xiangguanfujian;
        }

        public void setXiangguanfujian(String xiangguanfujian) {
            this.xiangguanfujian = xiangguanfujian;
        }

        public String getBeiTouSuRenXingMing() {
            return BeiTouSuRenXingMing;
        }

        public void setBeiTouSuRenXingMing(String BeiTouSuRenXingMing) {
            this.BeiTouSuRenXingMing = BeiTouSuRenXingMing;
        }

        public String getTouSuNeiRong() {
            return TouSuNeiRong;
        }

        public void setTouSuNeiRong(String TouSuNeiRong) {
            this.TouSuNeiRong = TouSuNeiRong;
        }

        public String getTouSuRenXingMing() {
            return TouSuRenXingMing;
        }

        public void setTouSuRenXingMing(String TouSuRenXingMing) {
            this.TouSuRenXingMing = TouSuRenXingMing;
        }

        public String getBmfzryj() {
            return bmfzryj;
        }

        public void setBmfzryj(String bmfzryj) {
            this.bmfzryj = bmfzryj;
        }

        public String getLiuShuiHao() {
            return LiuShuiHao;
        }

        public void setLiuShuiHao(String LiuShuiHao) {
            this.LiuShuiHao = LiuShuiHao;
        }

        public String getFanKuiTouSuRenJieGuo() {
            return FanKuiTouSuRenJieGuo;
        }

        public void setFanKuiTouSuRenJieGuo(String FanKuiTouSuRenJieGuo) {
            this.FanKuiTouSuRenJieGuo = FanKuiTouSuRenJieGuo;
        }
    }

    public static class TransBean {
        /**
         * destType : task
         * destination : 安全服务部确认与反馈
         * name : to 安全服务部确认与反馈
         * source : 办结安排
         */

        private String destType;
        private String destination;
        private String name;
        private String source;

        public String getDestType() {
            return destType;
        }

        public void setDestType(String destType) {
            this.destType = destType;
        }

        public String getDestination() {
            return destination;
        }

        public void setDestination(String destination) {
            this.destination = destination;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }
    }
}
