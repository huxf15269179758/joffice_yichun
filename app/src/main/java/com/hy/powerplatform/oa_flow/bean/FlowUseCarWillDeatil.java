package com.hy.powerplatform.oa_flow.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/2/20.
 */

public class FlowUseCarWillDeatil implements Serializable {


    /**
     * success : true
     * taskId : 7990057
     * pkValue : mainId
     * formRights : {'ZhiWu':'1','RenWuDiDian':'1','YongCheShiJian':'1','YongCheBuMen':'1','FuWULiCheng':'1','xiangguanfujian':'1','bmfzryj':'2','YongCheRen':'1','JieShuLiChengShu':'1','YongCheRenWu':'1','FuWuKaiShiLiCheng':'1','LiuShuiHao':'1','zjlyj':'1','PaiCheYuan':'1','FuWuCheHao':'1','LianXiDianHua':'1','FuWuJieShuShiJian':'1','FuWuKaiShiShiJian':'1','zhglbyj':'1','PaiCheShiJian':'1','fgldyj':'1','CheXIng':'1'}
     * mainform : [{"FuWuCheHao":"186","YongCheShiJian":"2019-02-20","runId":51463,"ZhiWu":"义务","YongCheRenWu":"任务","FuWULiCheng":"5","YongCheBuMen":"宜春公交集团有限公司","mainId":4,"FuWuJieShuShiJian":"2019-02-20 18:02:47","CheXIng":"4646","zhglbyj":"","LianXiDianHua":"10086","PaiCheYuan":"超级管理员","RenWuDiDian":"地点","$type$":"WF_GongWuYongChePaiCheDannew","FuWuKaiShiLiCheng":"10","fgldyj":"","JieShuLiChengShu":"15","FuWuKaiShiShiJian":"2019-02-20 16:05:33","YongCheRen":"超级管理员","xiangguanfujian":"","zjlyj":"","PaiCheShiJian":"2019-02-20","bmfzryj":"","LiuShuiHao":""}]
     * formDefId : 10114
     * preTaskName :
     * isSignTask : false
     * trans : [{"destType":"task","destination":"分管领导","name":"to 分管领导","source":"部门负责人"}]
     */

    private boolean success;
    private String taskId;
    private String pkValue;
    private String formRights;
    private String formDefId;
    private String preTaskName;
    private boolean isSignTask;
    private boolean revoke;

    public boolean isRevoke() {
        return revoke;
    }

    public void setRevoke(boolean revoke) {
        this.revoke = revoke;
    }

    private List<MainformBean> mainform;
    private List<TransBean> trans;

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
         * FuWuCheHao : 186
         * YongCheShiJian : 2019-02-20
         * runId : 51463
         * ZhiWu : 义务
         * YongCheRenWu : 任务
         * FuWULiCheng : 5
         * YongCheBuMen : 宜春公交集团有限公司
         * mainId : 4
         * FuWuJieShuShiJian : 2019-02-20 18:02:47
         * CheXIng : 4646
         * zhglbyj :
         * LianXiDianHua : 10086
         * PaiCheYuan : 超级管理员
         * RenWuDiDian : 地点
         * $type$ : WF_GongWuYongChePaiCheDannew
         * FuWuKaiShiLiCheng : 10
         * fgldyj :
         * JieShuLiChengShu : 15
         * FuWuKaiShiShiJian : 2019-02-20 16:05:33
         * YongCheRen : 超级管理员
         * xiangguanfujian :
         * zjlyj :
         * PaiCheShiJian : 2019-02-20
         * bmfzryj :
         * LiuShuiHao :
         */

        private String FuWuCheHao;
        private String YongCheShiJian;
        private String runId;
        private String ZhiWu;
        private String YongCheRenWu;
        private String FuWULiCheng;
        private String YongCheBuMen;
        private int mainId;
        private String FuWuJieShuShiJian;
        private String CheXIng;
        private String zhglbyj;
        private String LianXiDianHua;
        private String PaiCheYuan;
        private String RenWuDiDian;
        private String $type$;
        private String FuWuKaiShiLiCheng;
        private String fgldyj;
        private String JieShuLiChengShu;
        private String FuWuKaiShiShiJian;
        private String YongCheRen;
        private String xiangguanfujian;
        private String zjlyj;
        private String PaiCheShiJian;
        private String bmfzryj;
        private String LiuShuiHao;

        public String getFuWuCheHao() {
            return FuWuCheHao;
        }

        public void setFuWuCheHao(String FuWuCheHao) {
            this.FuWuCheHao = FuWuCheHao;
        }

        public String getYongCheShiJian() {
            return YongCheShiJian;
        }

        public void setYongCheShiJian(String YongCheShiJian) {
            this.YongCheShiJian = YongCheShiJian;
        }

        public String getRunId() {
            return runId;
        }

        public void setRunId(String runId) {
            this.runId = runId;
        }

        public String getZhiWu() {
            return ZhiWu;
        }

        public void setZhiWu(String ZhiWu) {
            this.ZhiWu = ZhiWu;
        }

        public String getYongCheRenWu() {
            return YongCheRenWu;
        }

        public void setYongCheRenWu(String YongCheRenWu) {
            this.YongCheRenWu = YongCheRenWu;
        }

        public String getFuWULiCheng() {
            return FuWULiCheng;
        }

        public void setFuWULiCheng(String FuWULiCheng) {
            this.FuWULiCheng = FuWULiCheng;
        }

        public String getYongCheBuMen() {
            return YongCheBuMen;
        }

        public void setYongCheBuMen(String YongCheBuMen) {
            this.YongCheBuMen = YongCheBuMen;
        }

        public int getMainId() {
            return mainId;
        }

        public void setMainId(int mainId) {
            this.mainId = mainId;
        }

        public String getFuWuJieShuShiJian() {
            return FuWuJieShuShiJian;
        }

        public void setFuWuJieShuShiJian(String FuWuJieShuShiJian) {
            this.FuWuJieShuShiJian = FuWuJieShuShiJian;
        }

        public String getCheXIng() {
            return CheXIng;
        }

        public void setCheXIng(String CheXIng) {
            this.CheXIng = CheXIng;
        }

        public String getZhglbyj() {
            return zhglbyj;
        }

        public void setZhglbyj(String zhglbyj) {
            this.zhglbyj = zhglbyj;
        }

        public String getLianXiDianHua() {
            return LianXiDianHua;
        }

        public void setLianXiDianHua(String LianXiDianHua) {
            this.LianXiDianHua = LianXiDianHua;
        }

        public String getPaiCheYuan() {
            return PaiCheYuan;
        }

        public void setPaiCheYuan(String PaiCheYuan) {
            this.PaiCheYuan = PaiCheYuan;
        }

        public String getRenWuDiDian() {
            return RenWuDiDian;
        }

        public void setRenWuDiDian(String RenWuDiDian) {
            this.RenWuDiDian = RenWuDiDian;
        }

        public String get$type$() {
            return $type$;
        }

        public void set$type$(String $type$) {
            this.$type$ = $type$;
        }

        public String getFuWuKaiShiLiCheng() {
            return FuWuKaiShiLiCheng;
        }

        public void setFuWuKaiShiLiCheng(String FuWuKaiShiLiCheng) {
            this.FuWuKaiShiLiCheng = FuWuKaiShiLiCheng;
        }

        public String getFgldyj() {
            return fgldyj;
        }

        public void setFgldyj(String fgldyj) {
            this.fgldyj = fgldyj;
        }

        public String getJieShuLiChengShu() {
            return JieShuLiChengShu;
        }

        public void setJieShuLiChengShu(String JieShuLiChengShu) {
            this.JieShuLiChengShu = JieShuLiChengShu;
        }

        public String getFuWuKaiShiShiJian() {
            return FuWuKaiShiShiJian;
        }

        public void setFuWuKaiShiShiJian(String FuWuKaiShiShiJian) {
            this.FuWuKaiShiShiJian = FuWuKaiShiShiJian;
        }

        public String getYongCheRen() {
            return YongCheRen;
        }

        public void setYongCheRen(String YongCheRen) {
            this.YongCheRen = YongCheRen;
        }

        public String getXiangguanfujian() {
            return xiangguanfujian;
        }

        public void setXiangguanfujian(String xiangguanfujian) {
            this.xiangguanfujian = xiangguanfujian;
        }

        public String getZjlyj() {
            return zjlyj;
        }

        public void setZjlyj(String zjlyj) {
            this.zjlyj = zjlyj;
        }

        public String getPaiCheShiJian() {
            return PaiCheShiJian;
        }

        public void setPaiCheShiJian(String PaiCheShiJian) {
            this.PaiCheShiJian = PaiCheShiJian;
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
         * destination : 分管领导
         * name : to 分管领导
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
