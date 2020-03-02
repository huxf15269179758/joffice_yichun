package com.hy.powerplatform.oa_flow.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/2/13.
 */

public class FlowGCAddwillDetail implements Serializable {


    /**
     * success : true
     * taskId : 8062145
     * pkValue : mainId
     * formRights : {'zjlyj':'1','csbmyj':'1','bmfzryj':'1','fgldyj':'1','RiQi':'1','jcbmyj':'1','LiuShuiHao':'1','xgfj':'1','jbfgldyj':'1','XuQiuBuMen':'1','cwsjbyj':'2','xiangguanfujian':'1','jjbzbyj':'1','JuTiShiXiang':'1','ShenQingRen':'1'}
     * mainform : [{"jcbmyj":"","xgfj":"","jjbzbyj":"[{\"ui\":\"1909\",\"un\":\"易睿\",\"c\":\"2019-02-27 19:02\",\"v\":\"同意\"}]","ShenQingRen":"刘望","runId":51572,"jbfgldyj":"[{\"ui\":\"147\",\"un\":\"李健\",\"c\":\"2019-02-27 19:03\",\"v\":\"同意\"}]","$type$":"WF_JianSheGongChengLiangZengJiaShenPiDan","JuTiShiXiang":"测试","fgldyj":"[{\"ui\":\"2768\",\"un\":\"何爱民\",\"c\":\"2019-02-27 19:01\",\"v\":\"同意\"}]","xiangguanfujian":"","mainId":8,"csbmyj":"","cwsjbyj":"","zjlyj":"","RiQi":"2019-02-27","bmfzryj":"[{\"ui\":\"1907\",\"un\":\"欧阳翰\",\"c\":\"2019-02-27 19:00\",\"v\":\"通知\"}]","LiuShuiHao":"No.20190227496","XuQiuBuMen":"安全服务部"}]
     * formDefId : 10108
     * preTaskName :
     * isSignTask : false
     * trans : [{"destType":"task","destination":"监查部门 ","name":"to 监查部门 ","source":"财务审计部"},{"destType":"task","destination":"退回发起人","name":"to 退回发起人","source":"财务审计部"}]
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
         * jcbmyj :
         * xgfj :
         * jjbzbyj : [{"ui":"1909","un":"易睿","c":"2019-02-27 19:02","v":"同意"}]
         * ShenQingRen : 刘望
         * runId : 51572
         * jbfgldyj : [{"ui":"147","un":"李健","c":"2019-02-27 19:03","v":"同意"}]
         * $type$ : WF_JianSheGongChengLiangZengJiaShenPiDan
         * JuTiShiXiang : 测试
         * fgldyj : [{"ui":"2768","un":"何爱民","c":"2019-02-27 19:01","v":"同意"}]
         * xiangguanfujian :
         * mainId : 8
         * csbmyj :
         * cwsjbyj :
         * zjlyj :
         * RiQi : 2019-02-27
         * bmfzryj : [{"ui":"1907","un":"欧阳翰","c":"2019-02-27 19:00","v":"通知"}]
         * LiuShuiHao : No.20190227496
         * XuQiuBuMen : 安全服务部
         */

        private String jcbmyj;
        private String xgfj;
        private String jjbzbyj;
        private String ShenQingRen;
        private String runId;
        private String jbfgldyj;
        private String $type$;
        private String JuTiShiXiang;
        private String fgldyj;
        private String xiangguanfujian;
        private int mainId;
        private String csbmyj;
        private String cwsjbyj;
        private String zjlyj;
        private String RiQi;
        private String bmfzryj;
        private String LiuShuiHao;
        private String XuQiuBuMen;

        public String getJcbmyj() {
            return jcbmyj;
        }

        public void setJcbmyj(String jcbmyj) {
            this.jcbmyj = jcbmyj;
        }

        public String getXgfj() {
            return xgfj;
        }

        public void setXgfj(String xgfj) {
            this.xgfj = xgfj;
        }

        public String getJjbzbyj() {
            return jjbzbyj;
        }

        public void setJjbzbyj(String jjbzbyj) {
            this.jjbzbyj = jjbzbyj;
        }

        public String getShenQingRen() {
            return ShenQingRen;
        }

        public void setShenQingRen(String ShenQingRen) {
            this.ShenQingRen = ShenQingRen;
        }

        public String getRunId() {
            return runId;
        }

        public void setRunId(String runId) {
            this.runId = runId;
        }

        public String getJbfgldyj() {
            return jbfgldyj;
        }

        public void setJbfgldyj(String jbfgldyj) {
            this.jbfgldyj = jbfgldyj;
        }

        public String get$type$() {
            return $type$;
        }

        public void set$type$(String $type$) {
            this.$type$ = $type$;
        }

        public String getJuTiShiXiang() {
            return JuTiShiXiang;
        }

        public void setJuTiShiXiang(String JuTiShiXiang) {
            this.JuTiShiXiang = JuTiShiXiang;
        }

        public String getFgldyj() {
            return fgldyj;
        }

        public void setFgldyj(String fgldyj) {
            this.fgldyj = fgldyj;
        }

        public String getXiangguanfujian() {
            return xiangguanfujian;
        }

        public void setXiangguanfujian(String xiangguanfujian) {
            this.xiangguanfujian = xiangguanfujian;
        }

        public int getMainId() {
            return mainId;
        }

        public void setMainId(int mainId) {
            this.mainId = mainId;
        }

        public String getCsbmyj() {
            return csbmyj;
        }

        public void setCsbmyj(String csbmyj) {
            this.csbmyj = csbmyj;
        }

        public String getCwsjbyj() {
            return cwsjbyj;
        }

        public void setCwsjbyj(String cwsjbyj) {
            this.cwsjbyj = cwsjbyj;
        }

        public String getZjlyj() {
            return zjlyj;
        }

        public void setZjlyj(String zjlyj) {
            this.zjlyj = zjlyj;
        }

        public String getRiQi() {
            return RiQi;
        }

        public void setRiQi(String RiQi) {
            this.RiQi = RiQi;
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

        public String getXuQiuBuMen() {
            return XuQiuBuMen;
        }

        public void setXuQiuBuMen(String XuQiuBuMen) {
            this.XuQiuBuMen = XuQiuBuMen;
        }
    }

    public static class TransBean {
        /**
         * destType : task
         * destination : 监查部门
         * name : to 监查部门
         * source : 财务审计部
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
