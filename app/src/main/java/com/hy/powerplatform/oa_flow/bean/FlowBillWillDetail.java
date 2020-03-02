package com.hy.powerplatform.oa_flow.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/2/22.
 */

public class FlowBillWillDetail implements Serializable {

    /**
     * success : true
     * taskId : 8050271
     * pkValue : mainId
     * formRights : {'DiDian':'1','JieKuanRen':'1','SanZheDH':'1','ShouShangRenShu':'1','jine':'1','LiuShuiHao':'1','xiangguanfujian':'1','YiJie':'1','ZhiDan':'1','zhidanshijian':'1','cwzjyj':'1','CheHao':'1','JiCi':'1','JieKuanYT':'1','xiaoxie':'1','ShiJian':'1','bennianleiji':'1','ShiGuZeRen':'1','ShiGuYuanYin':'1','aqfwbyj':'2','JiaShiYuan':'1','fgldyj':'1','XianZhong':'1','danyueleiji':'1','riqi':'1','BuMen':'1'}
     * mainform : [{"SanZheDH":"10086","runId":51507,"DiDian":"济南","ShouShangRenShu":"张三","JieKuanYT":"用途","ShiGuYuanYin":"原因","riqi":"2019-02-22","mainId":1,"JiaShiYuan":"超级管理员","xiaoxie":"50","bennianleiji":"50","JieKuanRen":"欧阳翰","jine":"五十","ShiJian":"17:24","ZhiDan":"超级管理员","XianZhong":"车站","BuMen":"宜春公交集团有限公司","aqfwbyj":"","cwzjyj":"","$type$":"WF_JiaoTongFeiYongJieKuanShenPi","danyueleiji":"50","YiJie":"50","fgldyj":"","CheHao":"车号","xiangguanfujian":"","ShiGuZeRen":"责任","zhidanshijian":"2019-02-22 17:23:48","JiCi":"1","LiuShuiHao":"No.20190222136"}]
     * formDefId : 10128
     * preTaskName :
     * isSignTask : false
     * trans : [{"destType":"task","destination":"分管领导","name":"to 分管领导","source":"安全服务部"}]
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
         * SanZheDH : 10086
         * runId : 51507
         * DiDian : 济南
         * ShouShangRenShu : 张三
         * JieKuanYT : 用途
         * ShiGuYuanYin : 原因
         * riqi : 2019-02-22
         * mainId : 1
         * JiaShiYuan : 超级管理员
         * xiaoxie : 50
         * bennianleiji : 50
         * JieKuanRen : 欧阳翰
         * jine : 五十
         * ShiJian : 17:24
         * ZhiDan : 超级管理员
         * XianZhong : 车站
         * BuMen : 宜春公交集团有限公司
         * aqfwbyj :
         * cwzjyj :
         * $type$ : WF_JiaoTongFeiYongJieKuanShenPi
         * danyueleiji : 50
         * YiJie : 50
         * fgldyj :
         * CheHao : 车号
         * xiangguanfujian :
         * ShiGuZeRen : 责任
         * zhidanshijian : 2019-02-22 17:23:48
         * JiCi : 1
         * LiuShuiHao : No.20190222136
         */

        private String SanZheDH;
        private String runId;
        private String DiDian;
        private String ShouShangRenShu;
        private String JieKuanYT;
        private String ShiGuYuanYin;
        private String riqi;
        private int mainId;
        private String JiaShiYuan;
        private String xiaoxie;
        private String bennianleiji;
        private String JieKuanRen;
        private String jine;
        private String ShiJian;
        private String ZhiDan;
        private String XianZhong;
        private String BuMen;
        private String aqfwbyj;
        private String cwzjyj;
        private String $type$;
        private String danyueleiji;
        private String YiJie;
        private String fgldyj;
        private String CheHao;
        private String xiangguanfujian;
        private String ShiGuZeRen;
        private String zhidanshijian;
        private String JiCi;
        private String LiuShuiHao;

        public String getSanZheDH() {
            return SanZheDH;
        }

        public void setSanZheDH(String SanZheDH) {
            this.SanZheDH = SanZheDH;
        }

        public String getRunId() {
            return runId;
        }

        public void setRunId(String runId) {
            this.runId = runId;
        }

        public String getDiDian() {
            return DiDian;
        }

        public void setDiDian(String DiDian) {
            this.DiDian = DiDian;
        }

        public String getShouShangRenShu() {
            return ShouShangRenShu;
        }

        public void setShouShangRenShu(String ShouShangRenShu) {
            this.ShouShangRenShu = ShouShangRenShu;
        }

        public String getJieKuanYT() {
            return JieKuanYT;
        }

        public void setJieKuanYT(String JieKuanYT) {
            this.JieKuanYT = JieKuanYT;
        }

        public String getShiGuYuanYin() {
            return ShiGuYuanYin;
        }

        public void setShiGuYuanYin(String ShiGuYuanYin) {
            this.ShiGuYuanYin = ShiGuYuanYin;
        }

        public String getRiqi() {
            return riqi;
        }

        public void setRiqi(String riqi) {
            this.riqi = riqi;
        }

        public int getMainId() {
            return mainId;
        }

        public void setMainId(int mainId) {
            this.mainId = mainId;
        }

        public String getJiaShiYuan() {
            return JiaShiYuan;
        }

        public void setJiaShiYuan(String JiaShiYuan) {
            this.JiaShiYuan = JiaShiYuan;
        }

        public String getXiaoxie() {
            return xiaoxie;
        }

        public void setXiaoxie(String xiaoxie) {
            this.xiaoxie = xiaoxie;
        }

        public String getBennianleiji() {
            return bennianleiji;
        }

        public void setBennianleiji(String bennianleiji) {
            this.bennianleiji = bennianleiji;
        }

        public String getJieKuanRen() {
            return JieKuanRen;
        }

        public void setJieKuanRen(String JieKuanRen) {
            this.JieKuanRen = JieKuanRen;
        }

        public String getJine() {
            return jine;
        }

        public void setJine(String jine) {
            this.jine = jine;
        }

        public String getShiJian() {
            return ShiJian;
        }

        public void setShiJian(String ShiJian) {
            this.ShiJian = ShiJian;
        }

        public String getZhiDan() {
            return ZhiDan;
        }

        public void setZhiDan(String ZhiDan) {
            this.ZhiDan = ZhiDan;
        }

        public String getXianZhong() {
            return XianZhong;
        }

        public void setXianZhong(String XianZhong) {
            this.XianZhong = XianZhong;
        }

        public String getBuMen() {
            return BuMen;
        }

        public void setBuMen(String BuMen) {
            this.BuMen = BuMen;
        }

        public String getAqfwbyj() {
            return aqfwbyj;
        }

        public void setAqfwbyj(String aqfwbyj) {
            this.aqfwbyj = aqfwbyj;
        }

        public String getCwzjyj() {
            return cwzjyj;
        }

        public void setCwzjyj(String cwzjyj) {
            this.cwzjyj = cwzjyj;
        }

        public String get$type$() {
            return $type$;
        }

        public void set$type$(String $type$) {
            this.$type$ = $type$;
        }

        public String getDanyueleiji() {
            return danyueleiji;
        }

        public void setDanyueleiji(String danyueleiji) {
            this.danyueleiji = danyueleiji;
        }

        public String getYiJie() {
            return YiJie;
        }

        public void setYiJie(String YiJie) {
            this.YiJie = YiJie;
        }

        public String getFgldyj() {
            return fgldyj;
        }

        public void setFgldyj(String fgldyj) {
            this.fgldyj = fgldyj;
        }

        public String getCheHao() {
            return CheHao;
        }

        public void setCheHao(String CheHao) {
            this.CheHao = CheHao;
        }

        public String getXiangguanfujian() {
            return xiangguanfujian;
        }

        public void setXiangguanfujian(String xiangguanfujian) {
            this.xiangguanfujian = xiangguanfujian;
        }

        public String getShiGuZeRen() {
            return ShiGuZeRen;
        }

        public void setShiGuZeRen(String ShiGuZeRen) {
            this.ShiGuZeRen = ShiGuZeRen;
        }

        public String getZhidanshijian() {
            return zhidanshijian;
        }

        public void setZhidanshijian(String zhidanshijian) {
            this.zhidanshijian = zhidanshijian;
        }

        public String getJiCi() {
            return JiCi;
        }

        public void setJiCi(String JiCi) {
            this.JiCi = JiCi;
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
         * source : 安全服务部
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
