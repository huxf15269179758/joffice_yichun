package com.hy.powerplatform.oa_flow.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/2/1.
 */

public class FlowRepair implements Serializable {


    /**
     * success : true
     * taskId : 8030900
     * pkValue : mainId
     * formRights : {'LiuShuiHao':'1','xmclfkyj':'1','wxryyj':'1','WeiXiuRenYuanQianZi':'1','BaoXiuDiDian':'1','jjbzbyj':'1','JuTiQingKuang':'1','bmfzryj':'2','XiangGuanFuJian':'1','bjap':'1','RiQi':'1','bjpj':'1','WeiXiuQingKuangGaiShu':'1','WeiXiuQingKuangFanKui':'1','BaoXiuBuMenMingCheng':'1'}
     * mainform : [{"wxryyj":"","WeiXiuRenYuanQianZiUId":"","jjbzbyj":"","WeiXiuQingKuangGaiShu":"","runId":51527,"$type$":"WF_BaoXiuXiangMuDengJiBiao","BaoXiuBuMenMingCheng":"宜春公交集团有限公司","WeiXiuQingKuangFanKui":"","xmclfkyj":"","BaoXiuBuMenMungChengDid":"","mainId":15,"BaoXiuDiDian":"济南","bjap":"","WeiXiuRenYuanQianZi":"","RiQi":"2019-02-18","bjpj":"","JuTiQingKuang":"测试","bmfzryj":"","XiangGuanFuJian":"","LiuShuiHao":""}]
     * formDefId : 10105
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
         * wxryyj :
         * WeiXiuRenYuanQianZiUId :
         * jjbzbyj :
         * WeiXiuQingKuangGaiShu :
         * runId : 51527
         * $type$ : WF_BaoXiuXiangMuDengJiBiao
         * BaoXiuBuMenMingCheng : 宜春公交集团有限公司
         * WeiXiuQingKuangFanKui :
         * xmclfkyj :
         * BaoXiuBuMenMungChengDid :
         * mainId : 15
         * BaoXiuDiDian : 济南
         * bjap :
         * WeiXiuRenYuanQianZi :
         * RiQi : 2019-02-18
         * bjpj :
         * JuTiQingKuang : 测试
         * bmfzryj :
         * XiangGuanFuJian :
         * LiuShuiHao :
         */

        private String wxryyj;
        private String WeiXiuRenYuanQianZiUId;
        private String jjbzbyj;
        private String WeiXiuQingKuangGaiShu;
        private String runId;
        private String $type$;
        private String BaoXiuBuMenMingCheng;
        private String WeiXiuQingKuangFanKui;
        private String xmclfkyj;
        private String BaoXiuBuMenMungChengDid;
        private int mainId;
        private String BaoXiuDiDian;
        private String bjap;
        private String WeiXiuRenYuanQianZi;
        private String RiQi;
        private String bjpj;
        private String JuTiQingKuang;
        private String bmfzryj;
        private String XiangGuanFuJian;
        private String LiuShuiHao;

        public String getWxryyj() {
            return wxryyj;
        }

        public void setWxryyj(String wxryyj) {
            this.wxryyj = wxryyj;
        }

        public String getWeiXiuRenYuanQianZiUId() {
            return WeiXiuRenYuanQianZiUId;
        }

        public void setWeiXiuRenYuanQianZiUId(String WeiXiuRenYuanQianZiUId) {
            this.WeiXiuRenYuanQianZiUId = WeiXiuRenYuanQianZiUId;
        }

        public String getJjbzbyj() {
            return jjbzbyj;
        }

        public void setJjbzbyj(String jjbzbyj) {
            this.jjbzbyj = jjbzbyj;
        }

        public String getWeiXiuQingKuangGaiShu() {
            return WeiXiuQingKuangGaiShu;
        }

        public void setWeiXiuQingKuangGaiShu(String WeiXiuQingKuangGaiShu) {
            this.WeiXiuQingKuangGaiShu = WeiXiuQingKuangGaiShu;
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

        public String getBaoXiuBuMenMingCheng() {
            return BaoXiuBuMenMingCheng;
        }

        public void setBaoXiuBuMenMingCheng(String BaoXiuBuMenMingCheng) {
            this.BaoXiuBuMenMingCheng = BaoXiuBuMenMingCheng;
        }

        public String getWeiXiuQingKuangFanKui() {
            return WeiXiuQingKuangFanKui;
        }

        public void setWeiXiuQingKuangFanKui(String WeiXiuQingKuangFanKui) {
            this.WeiXiuQingKuangFanKui = WeiXiuQingKuangFanKui;
        }

        public String getXmclfkyj() {
            return xmclfkyj;
        }

        public void setXmclfkyj(String xmclfkyj) {
            this.xmclfkyj = xmclfkyj;
        }

        public String getBaoXiuBuMenMungChengDid() {
            return BaoXiuBuMenMungChengDid;
        }

        public void setBaoXiuBuMenMungChengDid(String BaoXiuBuMenMungChengDid) {
            this.BaoXiuBuMenMungChengDid = BaoXiuBuMenMungChengDid;
        }

        public int getMainId() {
            return mainId;
        }

        public void setMainId(int mainId) {
            this.mainId = mainId;
        }

        public String getBaoXiuDiDian() {
            return BaoXiuDiDian;
        }

        public void setBaoXiuDiDian(String BaoXiuDiDian) {
            this.BaoXiuDiDian = BaoXiuDiDian;
        }

        public String getBjap() {
            return bjap;
        }

        public void setBjap(String bjap) {
            this.bjap = bjap;
        }

        public String getWeiXiuRenYuanQianZi() {
            return WeiXiuRenYuanQianZi;
        }

        public void setWeiXiuRenYuanQianZi(String WeiXiuRenYuanQianZi) {
            this.WeiXiuRenYuanQianZi = WeiXiuRenYuanQianZi;
        }

        public String getRiQi() {
            return RiQi;
        }

        public void setRiQi(String RiQi) {
            this.RiQi = RiQi;
        }

        public String getBjpj() {
            return bjpj;
        }

        public void setBjpj(String bjpj) {
            this.bjpj = bjpj;
        }

        public String getJuTiQingKuang() {
            return JuTiQingKuang;
        }

        public void setJuTiQingKuang(String JuTiQingKuang) {
            this.JuTiQingKuang = JuTiQingKuang;
        }

        public String getBmfzryj() {
            return bmfzryj;
        }

        public void setBmfzryj(String bmfzryj) {
            this.bmfzryj = bmfzryj;
        }

        public String getXiangGuanFuJian() {
            return XiangGuanFuJian;
        }

        public void setXiangGuanFuJian(String XiangGuanFuJian) {
            this.XiangGuanFuJian = XiangGuanFuJian;
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
