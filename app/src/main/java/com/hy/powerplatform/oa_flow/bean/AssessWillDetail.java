package com.hy.powerplatform.oa_flow.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2020/2/24.
 */

public class AssessWillDetail implements Serializable {

    /**
     * success : true
     * taskId : 9880154
     * pkValue : 7
     * formRights : {'lxdh':'1','sfzh':'1','xb':'1','xiangguanfujian':'1','cwsjbyj':'1','xm':'1','xxjsbyj':'1','jbbmyj':'2','gonghao':'1','zjcx':'1','cctkjyxgsyj':'1','LiuShuiHao':'1','bumen':'1'}
     * mainform : [{"xm":"罗乐军","sfzh":"362201196706180436","bumen":"充电公司","runId":52597,"$type$":"WF_ygrzlcb","zjcx":"A1,A2,D","xxjsbyj":"","cctkjyxgsyj":"","lxdh":"13707958173","xiangguanfujian":"","mainId":7,"cwsjbyj":"","xmUId":"","xb":"男","gonghao":"","jbbmyj":"","LiuShuiHao":"No.20200224009"}]
     * formDefId : 10142
     * preTaskName :
     * isSignTask : false
     * trans : [{"destType":"task","destination":"财务部负责人","name":"to 财务部负责人","source":"经办部门"}]
     * runId : 52597
     * revoke : false
     */

    private boolean success;
    private String taskId;
    private String pkValue;
    private String formRights;
    private String formDefId;
    private String preTaskName;
    private boolean isSignTask;
    private int runId;
    private boolean revoke;
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

    public int getRunId() {
        return runId;
    }

    public void setRunId(int runId) {
        this.runId = runId;
    }

    public boolean isRevoke() {
        return revoke;
    }

    public void setRevoke(boolean revoke) {
        this.revoke = revoke;
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

    public static class MainformBean implements Serializable {
        /**
         * xm : 罗乐军
         * sfzh : 362201196706180436
         * bumen : 充电公司
         * runId : 52597
         * $type$ : WF_ygrzlcb
         * zjcx : A1,A2,D
         * xxjsbyj :
         * cctkjyxgsyj :
         * lxdh : 13707958173
         * xiangguanfujian :
         * mainId : 7
         * cwsjbyj :
         * xmUId :
         * xb : 男
         * gonghao :
         * jbbmyj :
         * LiuShuiHao : No.20200224009
         */

        private String xm;
        private String sfzh;
        private String bumen;
        private String runId;
        private String $type$;
        private String zjcx;
        private String xxjsbyj;
        private String cctkjyxgsyj;
        private String lxdh;
        private String xiangguanfujian;
        private int mainId;
        private String cwsjbyj;
        private String xmUId;
        private String xb;
        private String gonghao;
        private String jbbmyj;
        private String LiuShuiHao;

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

        public String getBumen() {
            return bumen;
        }

        public void setBumen(String bumen) {
            this.bumen = bumen;
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

        public String getZjcx() {
            return zjcx;
        }

        public void setZjcx(String zjcx) {
            this.zjcx = zjcx;
        }

        public String getXxjsbyj() {
            return xxjsbyj;
        }

        public void setXxjsbyj(String xxjsbyj) {
            this.xxjsbyj = xxjsbyj;
        }

        public String getCctkjyxgsyj() {
            return cctkjyxgsyj;
        }

        public void setCctkjyxgsyj(String cctkjyxgsyj) {
            this.cctkjyxgsyj = cctkjyxgsyj;
        }

        public String getLxdh() {
            return lxdh;
        }

        public void setLxdh(String lxdh) {
            this.lxdh = lxdh;
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

        public String getXb() {
            return xb;
        }

        public void setXb(String xb) {
            this.xb = xb;
        }

        public String getGonghao() {
            return gonghao;
        }

        public void setGonghao(String gonghao) {
            this.gonghao = gonghao;
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

    public static class TransBean implements Serializable {
        /**
         * destType : task
         * destination : 财务部负责人
         * name : to 财务部负责人
         * source : 经办部门
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
