package com.hy.powerplatform.oa_flow.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/2/19.
 */

public class FlowCarSafeWillDetail implements Serializable {

    /**
     * success : true
     * taskId : 7970278
     * pkValue : mainId
     * formRights : {'xulie':'1','xianzhong2':'1','bm':'1','xianzhong5':'1','qibaoriqi2':'1','sqr':'1','fgldyj':'1','bmyj':'1','baoxiangongsi4':'1','chepaihao3':'1','zjlyj':'1','jine3':'1','qibaoriqi5':'1','chepaihao':'1','hjje':'1','baoxiangongsi2':'1','xuhao3':'1','bmfzryj':'1','jine':'1','sqrq':'1','xianzhong1':'1','qibaoriqi':'1','xianzhong':'1','jine1':'1','xuhao4':'1','chepaihao2':'1','jine2':'1','xuhao2':'1','chepaihao5':'1','baoxiangongsi1':'1','jine4':'1','chepaihao4':'1','qibaoriqi3':'1','jine5':'1','qibaoriqi1':'1','xianzhong4':'1','baoxiangongsi3':'1','chepaihao1':'1','baoxiangongsi5':'1','qibaoriqi4':'1','xuhao1':'1','xuhao5':'1','xianzhong3':'1','baoxiangongsi':'1','xiangguanfujian':'1'}
     * mainform : [{"baoxiangongsi":"","xuhao1":"","chepaihao2":"","xuhao2":"","chepaihao3":"","qibaoriqi1":"","chepaihao4":"","xuhao3":"","qibaoriqi2":"","chepaihao5":"","xuhao4":"","qibaoriqi3":"","xuhao5":"","qibaoriqi4":"","chepaihao":"","qibaoriqi5":"","chepaihao1":"测试","runId":51446,"xianzhong":"","mainId":10004,"bm":"","sqrq":"2019-02-19","xulie":"","hjje":"1.0","baoxiangongsi5":"","jine":"","sqr":"超级管理员","jine2":"","jine3":"","jine4":"","jine5":"","$type$":"WF_clbxfspd","fgldyj":"","jine1":"1","xianzhong5":"","xianzhong4":"","bmyj":"","xiangguanfujian":"","zjlyj":"","baoxiangongsi2":"","xianzhong1":"现在","baoxiangongsi1":"公司","qibaoriqi":"","baoxiangongsi4":"","bmfzryj":"","xianzhong3":"","baoxiangongsi3":"","xianzhong2":""}]
     * formDefId : 60
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
         * baoxiangongsi :
         * xuhao1 :
         * chepaihao2 :
         * xuhao2 :
         * chepaihao3 :
         * qibaoriqi1 :
         * chepaihao4 :
         * xuhao3 :
         * qibaoriqi2 :
         * chepaihao5 :
         * xuhao4 :
         * qibaoriqi3 :
         * xuhao5 :
         * qibaoriqi4 :
         * chepaihao :
         * qibaoriqi5 :
         * chepaihao1 : 测试
         * runId : 51446
         * xianzhong :
         * mainId : 10004
         * bm :
         * sqrq : 2019-02-19
         * xulie :
         * hjje : 1.0
         * baoxiangongsi5 :
         * jine :
         * sqr : 超级管理员
         * jine2 :
         * jine3 :
         * jine4 :
         * jine5 :
         * $type$ : WF_clbxfspd
         * fgldyj :
         * jine1 : 1
         * xianzhong5 :
         * xianzhong4 :
         * bmyj :
         * xiangguanfujian :
         * zjlyj :
         * baoxiangongsi2 :
         * xianzhong1 : 现在
         * baoxiangongsi1 : 公司
         * qibaoriqi :
         * baoxiangongsi4 :
         * bmfzryj :
         * xianzhong3 :
         * baoxiangongsi3 :
         * xianzhong2 :
         */

        private String baoxiangongsi;
        private String xuhao1;
        private String chepaihao2;
        private String xuhao2;
        private String chepaihao3;
        private String qibaoriqi1;
        private String chepaihao4;
        private String xuhao3;
        private String qibaoriqi2;
        private String chepaihao5;
        private String xuhao4;
        private String qibaoriqi3;
        private String xuhao5;
        private String qibaoriqi4;
        private String chepaihao;
        private String qibaoriqi5;
        private String chepaihao1;
        private String runId;
        private String xianzhong;
        private int mainId;
        private String bm;
        private String sqrq;
        private String xulie;
        private String hjje;
        private String baoxiangongsi5;
        private String jine;
        private String sqr;
        private String jine2;
        private String jine3;
        private String jine4;
        private String jine5;
        private String $type$;
        private String fgldyj;
        private String jine1;
        private String xianzhong5;
        private String xianzhong4;
        private String bmyj;
        private String xiangguanfujian;
        private String zjlyj;
        private String baoxiangongsi2;
        private String xianzhong1;
        private String baoxiangongsi1;
        private String qibaoriqi;
        private String baoxiangongsi4;
        private String bmfzryj;
        private String xianzhong3;
        private String baoxiangongsi3;
        private String xianzhong2;

        public String getBaoxiangongsi() {
            return baoxiangongsi;
        }

        public void setBaoxiangongsi(String baoxiangongsi) {
            this.baoxiangongsi = baoxiangongsi;
        }

        public String getXuhao1() {
            return xuhao1;
        }

        public void setXuhao1(String xuhao1) {
            this.xuhao1 = xuhao1;
        }

        public String getChepaihao2() {
            return chepaihao2;
        }

        public void setChepaihao2(String chepaihao2) {
            this.chepaihao2 = chepaihao2;
        }

        public String getXuhao2() {
            return xuhao2;
        }

        public void setXuhao2(String xuhao2) {
            this.xuhao2 = xuhao2;
        }

        public String getChepaihao3() {
            return chepaihao3;
        }

        public void setChepaihao3(String chepaihao3) {
            this.chepaihao3 = chepaihao3;
        }

        public String getQibaoriqi1() {
            return qibaoriqi1;
        }

        public void setQibaoriqi1(String qibaoriqi1) {
            this.qibaoriqi1 = qibaoriqi1;
        }

        public String getChepaihao4() {
            return chepaihao4;
        }

        public void setChepaihao4(String chepaihao4) {
            this.chepaihao4 = chepaihao4;
        }

        public String getXuhao3() {
            return xuhao3;
        }

        public void setXuhao3(String xuhao3) {
            this.xuhao3 = xuhao3;
        }

        public String getQibaoriqi2() {
            return qibaoriqi2;
        }

        public void setQibaoriqi2(String qibaoriqi2) {
            this.qibaoriqi2 = qibaoriqi2;
        }

        public String getChepaihao5() {
            return chepaihao5;
        }

        public void setChepaihao5(String chepaihao5) {
            this.chepaihao5 = chepaihao5;
        }

        public String getXuhao4() {
            return xuhao4;
        }

        public void setXuhao4(String xuhao4) {
            this.xuhao4 = xuhao4;
        }

        public String getQibaoriqi3() {
            return qibaoriqi3;
        }

        public void setQibaoriqi3(String qibaoriqi3) {
            this.qibaoriqi3 = qibaoriqi3;
        }

        public String getXuhao5() {
            return xuhao5;
        }

        public void setXuhao5(String xuhao5) {
            this.xuhao5 = xuhao5;
        }

        public String getQibaoriqi4() {
            return qibaoriqi4;
        }

        public void setQibaoriqi4(String qibaoriqi4) {
            this.qibaoriqi4 = qibaoriqi4;
        }

        public String getChepaihao() {
            return chepaihao;
        }

        public void setChepaihao(String chepaihao) {
            this.chepaihao = chepaihao;
        }

        public String getQibaoriqi5() {
            return qibaoriqi5;
        }

        public void setQibaoriqi5(String qibaoriqi5) {
            this.qibaoriqi5 = qibaoriqi5;
        }

        public String getChepaihao1() {
            return chepaihao1;
        }

        public void setChepaihao1(String chepaihao1) {
            this.chepaihao1 = chepaihao1;
        }

        public String getRunId() {
            return runId;
        }

        public void setRunId(String runId) {
            this.runId = runId;
        }

        public String getXianzhong() {
            return xianzhong;
        }

        public void setXianzhong(String xianzhong) {
            this.xianzhong = xianzhong;
        }

        public int getMainId() {
            return mainId;
        }

        public void setMainId(int mainId) {
            this.mainId = mainId;
        }

        public String getBm() {
            return bm;
        }

        public void setBm(String bm) {
            this.bm = bm;
        }

        public String getSqrq() {
            return sqrq;
        }

        public void setSqrq(String sqrq) {
            this.sqrq = sqrq;
        }

        public String getXulie() {
            return xulie;
        }

        public void setXulie(String xulie) {
            this.xulie = xulie;
        }

        public String getHjje() {
            return hjje;
        }

        public void setHjje(String hjje) {
            this.hjje = hjje;
        }

        public String getBaoxiangongsi5() {
            return baoxiangongsi5;
        }

        public void setBaoxiangongsi5(String baoxiangongsi5) {
            this.baoxiangongsi5 = baoxiangongsi5;
        }

        public String getJine() {
            return jine;
        }

        public void setJine(String jine) {
            this.jine = jine;
        }

        public String getSqr() {
            return sqr;
        }

        public void setSqr(String sqr) {
            this.sqr = sqr;
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

        public String getJine4() {
            return jine4;
        }

        public void setJine4(String jine4) {
            this.jine4 = jine4;
        }

        public String getJine5() {
            return jine5;
        }

        public void setJine5(String jine5) {
            this.jine5 = jine5;
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

        public String getJine1() {
            return jine1;
        }

        public void setJine1(String jine1) {
            this.jine1 = jine1;
        }

        public String getXianzhong5() {
            return xianzhong5;
        }

        public void setXianzhong5(String xianzhong5) {
            this.xianzhong5 = xianzhong5;
        }

        public String getXianzhong4() {
            return xianzhong4;
        }

        public void setXianzhong4(String xianzhong4) {
            this.xianzhong4 = xianzhong4;
        }

        public String getBmyj() {
            return bmyj;
        }

        public void setBmyj(String bmyj) {
            this.bmyj = bmyj;
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

        public String getBaoxiangongsi2() {
            return baoxiangongsi2;
        }

        public void setBaoxiangongsi2(String baoxiangongsi2) {
            this.baoxiangongsi2 = baoxiangongsi2;
        }

        public String getXianzhong1() {
            return xianzhong1;
        }

        public void setXianzhong1(String xianzhong1) {
            this.xianzhong1 = xianzhong1;
        }

        public String getBaoxiangongsi1() {
            return baoxiangongsi1;
        }

        public void setBaoxiangongsi1(String baoxiangongsi1) {
            this.baoxiangongsi1 = baoxiangongsi1;
        }

        public String getQibaoriqi() {
            return qibaoriqi;
        }

        public void setQibaoriqi(String qibaoriqi) {
            this.qibaoriqi = qibaoriqi;
        }

        public String getBaoxiangongsi4() {
            return baoxiangongsi4;
        }

        public void setBaoxiangongsi4(String baoxiangongsi4) {
            this.baoxiangongsi4 = baoxiangongsi4;
        }

        public String getBmfzryj() {
            return bmfzryj;
        }

        public void setBmfzryj(String bmfzryj) {
            this.bmfzryj = bmfzryj;
        }

        public String getXianzhong3() {
            return xianzhong3;
        }

        public void setXianzhong3(String xianzhong3) {
            this.xianzhong3 = xianzhong3;
        }

        public String getBaoxiangongsi3() {
            return baoxiangongsi3;
        }

        public void setBaoxiangongsi3(String baoxiangongsi3) {
            this.baoxiangongsi3 = baoxiangongsi3;
        }

        public String getXianzhong2() {
            return xianzhong2;
        }

        public void setXianzhong2(String xianzhong2) {
            this.xianzhong2 = xianzhong2;
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
