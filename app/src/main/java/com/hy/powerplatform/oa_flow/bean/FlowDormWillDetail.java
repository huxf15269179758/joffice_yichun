package com.hy.powerplatform.oa_flow.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/2/22.
 */

public class FlowDormWillDetail implements Serializable {

    /**
     * success : true
     * taskId : 8040275
     * pkValue : mainId
     * formRights : {'bmfzryj':'2','FangJian':'1','ShenQingLiYou':'1','ChuangHao':'1','jjbzbyj':'1','ShouJiHaoMa':'1','ShiFouXuYaoShouQu':'1','ShenFenZhengHao':'1','TuiFangShiJian':'1','RuZhuShiJian':'1','XingMing':'1','ShenQingRiQi':'1','BeiZhu':'1','HuJiSuoZaiDi':'1','XingBie':'1','NianLing':'1','LiuShuiHao':'1'}
     * mainform : [{"ShenQingLiYou":"测试","ShouJiHaoMa":"456","ChuangHao":"","FangJian":"","jjbzbyj":"","HuJiSuoZaiDi":"济南","runId":51495,"NianLing":"12","$type$":"WF_YuanGongSuSheShenQingBiao","BeiZhu":"","TuiFangShiJian":"","XingMingUId":"888888888","XingMing":"超级管理员","ShiFouXuYaoShouQu":"","XingBie":"男","mainId":3,"cwsjbyj":"","RuZhuShiJian":"","ShenFenZhengHao":"123","ShenQingRiQi":"2019-02-22","bjpj":"","bmfzryj":"","LiuShuiHao":"No.20190222034"}]
     * formDefId : 10104
     * preTaskName :
     * isSignTask : false
     * trans : [{"destType":"task","destination":"基建保障部","name":"to 基建保障部","source":"部门负责人"}]
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
         * ShenQingLiYou : 测试
         * ShouJiHaoMa : 456
         * ChuangHao :
         * FangJian :
         * jjbzbyj :
         * HuJiSuoZaiDi : 济南
         * runId : 51495
         * NianLing : 12
         * $type$ : WF_YuanGongSuSheShenQingBiao
         * BeiZhu :
         * TuiFangShiJian :
         * XingMingUId : 888888888
         * XingMing : 超级管理员
         * ShiFouXuYaoShouQu :
         * XingBie : 男
         * mainId : 3
         * cwsjbyj :
         * RuZhuShiJian :
         * ShenFenZhengHao : 123
         * ShenQingRiQi : 2019-02-22
         * bjpj :
         * bmfzryj :
         * LiuShuiHao : No.20190222034
         */

        private String ShenQingLiYou;
        private String ShouJiHaoMa;
        private String ChuangHao;
        private String FangJian;
        private String jjbzbyj;
        private String HuJiSuoZaiDi;
        private String runId;
        private String NianLing;
        private String $type$;
        private String BeiZhu;
        private String TuiFangShiJian;
        private String XingMingUId;
        private String XingMing;
        private String ShiFouXuYaoShouQu;
        private String XingBie;
        private int mainId;
        private String cwsjbyj;
        private String RuZhuShiJian;
        private String ShenFenZhengHao;
        private String ShenQingRiQi;
        private String bjpj;
        private String bmfzryj;
        private String LiuShuiHao;

        public String getShenQingLiYou() {
            return ShenQingLiYou;
        }

        public void setShenQingLiYou(String ShenQingLiYou) {
            this.ShenQingLiYou = ShenQingLiYou;
        }

        public String getShouJiHaoMa() {
            return ShouJiHaoMa;
        }

        public void setShouJiHaoMa(String ShouJiHaoMa) {
            this.ShouJiHaoMa = ShouJiHaoMa;
        }

        public String getChuangHao() {
            return ChuangHao;
        }

        public void setChuangHao(String ChuangHao) {
            this.ChuangHao = ChuangHao;
        }

        public String getFangJian() {
            return FangJian;
        }

        public void setFangJian(String FangJian) {
            this.FangJian = FangJian;
        }

        public String getJjbzbyj() {
            return jjbzbyj;
        }

        public void setJjbzbyj(String jjbzbyj) {
            this.jjbzbyj = jjbzbyj;
        }

        public String getHuJiSuoZaiDi() {
            return HuJiSuoZaiDi;
        }

        public void setHuJiSuoZaiDi(String HuJiSuoZaiDi) {
            this.HuJiSuoZaiDi = HuJiSuoZaiDi;
        }

        public String getRunId() {
            return runId;
        }

        public void setRunId(String runId) {
            this.runId = runId;
        }

        public String getNianLing() {
            return NianLing;
        }

        public void setNianLing(String NianLing) {
            this.NianLing = NianLing;
        }

        public String get$type$() {
            return $type$;
        }

        public void set$type$(String $type$) {
            this.$type$ = $type$;
        }

        public String getBeiZhu() {
            return BeiZhu;
        }

        public void setBeiZhu(String BeiZhu) {
            this.BeiZhu = BeiZhu;
        }

        public String getTuiFangShiJian() {
            return TuiFangShiJian;
        }

        public void setTuiFangShiJian(String TuiFangShiJian) {
            this.TuiFangShiJian = TuiFangShiJian;
        }

        public String getXingMingUId() {
            return XingMingUId;
        }

        public void setXingMingUId(String XingMingUId) {
            this.XingMingUId = XingMingUId;
        }

        public String getXingMing() {
            return XingMing;
        }

        public void setXingMing(String XingMing) {
            this.XingMing = XingMing;
        }

        public String getShiFouXuYaoShouQu() {
            return ShiFouXuYaoShouQu;
        }

        public void setShiFouXuYaoShouQu(String ShiFouXuYaoShouQu) {
            this.ShiFouXuYaoShouQu = ShiFouXuYaoShouQu;
        }

        public String getXingBie() {
            return XingBie;
        }

        public void setXingBie(String XingBie) {
            this.XingBie = XingBie;
        }

        public int getMainId() {
            return mainId;
        }

        public void setMainId(int mainId) {
            this.mainId = mainId;
        }

        public String getCwsjbyj() {
            return cwsjbyj;
        }

        public void setCwsjbyj(String cwsjbyj) {
            this.cwsjbyj = cwsjbyj;
        }

        public String getRuZhuShiJian() {
            return RuZhuShiJian;
        }

        public void setRuZhuShiJian(String RuZhuShiJian) {
            this.RuZhuShiJian = RuZhuShiJian;
        }

        public String getShenFenZhengHao() {
            return ShenFenZhengHao;
        }

        public void setShenFenZhengHao(String ShenFenZhengHao) {
            this.ShenFenZhengHao = ShenFenZhengHao;
        }

        public String getShenQingRiQi() {
            return ShenQingRiQi;
        }

        public void setShenQingRiQi(String ShenQingRiQi) {
            this.ShenQingRiQi = ShenQingRiQi;
        }

        public String getBjpj() {
            return bjpj;
        }

        public void setBjpj(String bjpj) {
            this.bjpj = bjpj;
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
    }

    public static class TransBean {
        /**
         * destType : task
         * destination : 基建保障部
         * name : to 基建保障部
         * source : 部门负责人
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
