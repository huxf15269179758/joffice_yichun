package com.hy.powerplatform.oa_flow.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/1/31.
 */

public class FlowOutMessage implements Serializable {

    /**
     * success : true
     * taskId : 7950095
     * pkValue : 3
     * formRights : {'HeGaoRen':'1','FaWenBiaoTi':'1','ChaoSongRen':'1','ZhuSongRen':'1','WenHaoRiQi':'1','NiGaoRen':'1','FaWenFuJian':'1','YinFaRiQi':'1','YinFaFenShu':'1','fgldyj':'1','ChaoBaoRen':'1','FaWenWenHao':'1','FaWenXuHao':'1'}
     * mainform : [{"HeGaoRenUId":"888888888","YinFaRiQi":"2019-01-31","runId":51329,"$type$":"WF_ycsggjtzgsfw","fgldyj":"","FaWenFuJian":"","FaWenBiaoTi":"测试发文流程app","NiGaoRen":"超级管理员","ChaoBaoRen":"测试发文流程app","HeGaoRen":"超级管理员","NiGaoRenUId":"888888888","FaWenXuHao":"4","WenHaoRiQi":"14","YinFaFenShu":"1","FaWenWenHao":"789456","mainId":3,"zjlyj":"[{\"ui\":\"1\",\"un\":\"超级管理员\",\"c\":\"2019-01-31 14:40\",\"v\":\"测试\"}]","ChaoSongRen":"测试发文流程app","ZhuSongRen":"测试发文流程app"}]
     * formDefId : 10076
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
    private boolean revoke;
    private boolean isSignTask;
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
         * HeGaoRenUId : 888888888
         * YinFaRiQi : 2019-01-31
         * runId : 51329
         * $type$ : WF_ycsggjtzgsfw
         * fgldyj :
         * FaWenFuJian :
         * FaWenBiaoTi : 测试发文流程app
         * NiGaoRen : 超级管理员
         * ChaoBaoRen : 测试发文流程app
         * HeGaoRen : 超级管理员
         * NiGaoRenUId : 888888888
         * FaWenXuHao : 4
         * WenHaoRiQi : 14
         * YinFaFenShu : 1
         * FaWenWenHao : 789456
         * mainId : 3
         * zjlyj : [{"ui":"1","un":"超级管理员","c":"2019-01-31 14:40","v":"测试"}]
         * ChaoSongRen : 测试发文流程app
         * ZhuSongRen : 测试发文流程app
         */

        private String HeGaoRenUId;
        private String YinFaRiQi;
        private String runId;
        private String $type$;
        private String fgldyj;
        private String FaWenFuJian;
        private String FaWenBiaoTi;
        private String NiGaoRen;
        private String ChaoBaoRen;
        private String HeGaoRen;
        private String NiGaoRenUId;
        private String FaWenXuHao;
        private String WenHaoRiQi;
        private String YinFaFenShu;
        private String FaWenWenHao;
        private int mainId;
        private String zjlyj;
        private String ChaoSongRen;
        private String ZhuSongRen;

        public String getHeGaoRenUId() {
            return HeGaoRenUId;
        }

        public void setHeGaoRenUId(String HeGaoRenUId) {
            this.HeGaoRenUId = HeGaoRenUId;
        }

        public String getYinFaRiQi() {
            return YinFaRiQi;
        }

        public void setYinFaRiQi(String YinFaRiQi) {
            this.YinFaRiQi = YinFaRiQi;
        }

        public String getRunId() {
            return runId;
        }

        public void setRunId(String runId) {
            this.runId = runId;
        }

        public String get$type$() {
            return $type$;
        }

        public void set$type$(String $type$) {
            this.$type$ = $type$;
        }

        public String getFgldyj() {
            return fgldyj;
        }

        public void setFgldyj(String fgldyj) {
            this.fgldyj = fgldyj;
        }

        public String getFaWenFuJian() {
            return FaWenFuJian;
        }

        public void setFaWenFuJian(String FaWenFuJian) {
            this.FaWenFuJian = FaWenFuJian;
        }

        public String getFaWenBiaoTi() {
            return FaWenBiaoTi;
        }

        public void setFaWenBiaoTi(String FaWenBiaoTi) {
            this.FaWenBiaoTi = FaWenBiaoTi;
        }

        public String getNiGaoRen() {
            return NiGaoRen;
        }

        public void setNiGaoRen(String NiGaoRen) {
            this.NiGaoRen = NiGaoRen;
        }

        public String getChaoBaoRen() {
            return ChaoBaoRen;
        }

        public void setChaoBaoRen(String ChaoBaoRen) {
            this.ChaoBaoRen = ChaoBaoRen;
        }

        public String getHeGaoRen() {
            return HeGaoRen;
        }

        public void setHeGaoRen(String HeGaoRen) {
            this.HeGaoRen = HeGaoRen;
        }

        public String getNiGaoRenUId() {
            return NiGaoRenUId;
        }

        public void setNiGaoRenUId(String NiGaoRenUId) {
            this.NiGaoRenUId = NiGaoRenUId;
        }

        public String getFaWenXuHao() {
            return FaWenXuHao;
        }

        public void setFaWenXuHao(String FaWenXuHao) {
            this.FaWenXuHao = FaWenXuHao;
        }

        public String getWenHaoRiQi() {
            return WenHaoRiQi;
        }

        public void setWenHaoRiQi(String WenHaoRiQi) {
            this.WenHaoRiQi = WenHaoRiQi;
        }

        public String getYinFaFenShu() {
            return YinFaFenShu;
        }

        public void setYinFaFenShu(String YinFaFenShu) {
            this.YinFaFenShu = YinFaFenShu;
        }

        public String getFaWenWenHao() {
            return FaWenWenHao;
        }

        public void setFaWenWenHao(String FaWenWenHao) {
            this.FaWenWenHao = FaWenWenHao;
        }

        public int getMainId() {
            return mainId;
        }

        public void setMainId(int mainId) {
            this.mainId = mainId;
        }

        public String getZjlyj() {
            return zjlyj;
        }

        public void setZjlyj(String zjlyj) {
            this.zjlyj = zjlyj;
        }

        public String getChaoSongRen() {
            return ChaoSongRen;
        }

        public void setChaoSongRen(String ChaoSongRen) {
            this.ChaoSongRen = ChaoSongRen;
        }

        public String getZhuSongRen() {
            return ZhuSongRen;
        }

        public void setZhuSongRen(String ZhuSongRen) {
            this.ZhuSongRen = ZhuSongRen;
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
