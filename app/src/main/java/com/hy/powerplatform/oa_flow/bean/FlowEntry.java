package com.hy.powerplatform.oa_flow.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/1/31.
 */

public class FlowEntry implements Serializable {

    /**
     * success : true
     * taskId : 10020048
     * pkValue : 162
     * formRights : {'lxdh':'1','xb':'1','xxjsbyj':'1','cwsjbyj':'1','sfzh':'1','xingmingA':'1','LiuShuiHao':'1','rlzyb1':'1','jbbmyj':'1','xiangguanfujian':'1','ygbh':'1','fgs':'1','cctkjyxgsyj':'1','zhglbyj':'1','yyglbyj':'1','rlzyb2':'1','ZhunJiaCheXing3':'1','ZhunJiaCheXing1':'1','xm':'1','rlzyb3':'1','rlzybyj':'1','zjcx':'1','ZhunJiaCheXing':'1'}
     * mainform : [{"ZhunJiaCheXing":"","ygbh":"","ZhunJiaCheXing1":"","ZhunJiaCheXing3":"","xm":"周建平","sfzh":"370724199102011212","runId":52390,"rlzybyj":"","xxjsbyj":"","rlzyb1":"","rlzyb2":"","rlzyb3":"","yyglbyj":"[{\"ui\":\"9403\",\"un\":\"张志平\",\"c\":\"2020-01-10 15:49\",\"v\":\"测试\"}]","mainId":162,"xingmingA":"","xb":"男","zhglbyj":"","fgs":"营运一分公司","$type$":"WF_jsyrzlcbnews","zjcx":"A1","cctkjyxgsyj":"","xiangguanfujian":"","lxdh":"12345678910","cwsjbyj":"[{\"ui\":\"9455\",\"un\":\"张敏\",\"c\":\"2020-01-10 11:31\",\"v\":\"测试\"}]","xmUId":"","jbbmyj":"","LiuShuiHao":"No.20200110007"}]
     * formDefId : 10117
     * preTaskName :
     * isSignTask : false
     * trans : [{"destType":"task","destination":"信息技术部","name":"to 信息技术部","source":"信息技术部负责人"}]
     * runId : 52390
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
         * ZhunJiaCheXing :
         * ygbh :
         * ZhunJiaCheXing1 :
         * ZhunJiaCheXing3 :
         * xm : 周建平
         * sfzh : 370724199102011212
         * runId : 52390
         * rlzybyj :
         * xxjsbyj :
         * rlzyb1 :
         * rlzyb2 :
         * rlzyb3 :
         * yyglbyj : [{"ui":"9403","un":"张志平","c":"2020-01-10 15:49","v":"测试"}]
         * mainId : 162
         * xingmingA :
         * xb : 男
         * zhglbyj :
         * fgs : 营运一分公司
         * $type$ : WF_jsyrzlcbnews
         * zjcx : A1
         * cctkjyxgsyj :
         * xiangguanfujian :
         * lxdh : 12345678910
         * cwsjbyj : [{"ui":"9455","un":"张敏","c":"2020-01-10 11:31","v":"测试"}]
         * xmUId :
         * jbbmyj :
         * LiuShuiHao : No.20200110007
         */

        private String ZhunJiaCheXing;
        private String ygbh;
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
        private String xingmingA;
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
        private String LiuShuiHao;

        public String getZhunJiaCheXing() {
            return ZhunJiaCheXing;
        }

        public void setZhunJiaCheXing(String ZhunJiaCheXing) {
            this.ZhunJiaCheXing = ZhunJiaCheXing;
        }

        public String getYgbh() {
            return ygbh;
        }

        public void setYgbh(String ygbh) {
            this.ygbh = ygbh;
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

        public String getXingmingA() {
            return xingmingA;
        }

        public void setXingmingA(String xingmingA) {
            this.xingmingA = xingmingA;
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

    public static class TransBean implements Serializable {
        /**
         * destType : task
         * destination : 信息技术部
         * name : to 信息技术部
         * source : 信息技术部负责人
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
