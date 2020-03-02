package com.hy.powerplatform.oa_flow.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/4/8.
 */

public class FlowGHWillPurchase implements Serializable {


    /**
     * success : true
     * taskId : 8380427
     * pkValue : mainId
     * formRights : {'shuliang4':'1','xgfj':'1','LiuShuiHao':'1','fgldyj':'1','mingcheng1':'1','mingcheng5':'1','sqrq':'1','hejisl':'1','hejije':'1','jine1':'1','bm':'1','danjia4':'1','jine3':'1','danjia5':'1','sqr':'1','shuliang3':'1','mingcheng4':'1','shuliang5':'1','bmfzryj':'1','ghzx':'1','danjia2':'1','caigouren':'1','shuliang2':'1','shuliang1':'1','yt':'1','QiTa':'1','danjia3':'1','mingcheng3':'1','jine5':'1','jine4':'1','jine2':'1','mingcheng2':'1','danjia1':'1','hejidj':'1','cwzjyj':'1'}
     * mainform : [{"shuliang3":"","shuliang4":"","shuliang1":"1","xgfj":"","shuliang2":"2","shuliang5":"","runId":51605,"mingcheng1":"q","mingcheng3":"","mingcheng2":"w","hejidj":"","mingcheng4":"","mingcheng5":"","bm":"宜春公交集团有限公司","mainId":4,"caigouren":"","sqrq":"2019-04-08","ghzx":"","hejije":"5.0","QiTa":"其他","sqr":"超级管理员","jine2":"4.0","cwzjyj":"","jine3":"","jine4":"","jine5":"","danjia5":"","$type$":"WF_dwwpcgjhb","danjia4":"","danjia3":"","danjia2":"2","jine1":"1.0","danjia1":"1","fgldyj":"","hejisl":"3","yt":"用途","bmfzryj":"","LiuShuiHao":""}]
     * formDefId : 10127
     * preTaskName :
     * isSignTask : false
     * trans : [{"destType":"task","destination":"财务总监","name":"to 财务总监","source":"申请人"},{"destType":"task","destination":"部门负责人","name":"to 部门负责人","source":"申请人"}]
     * runId : 51605
     */

    private boolean success;
    private String taskId;
    private String pkValue;
    private String formRights;
    private String formDefId;
    private String preTaskName;
    private boolean revoke;
    private boolean isSignTask;
    private int runId;
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

    public int getRunId() {
        return runId;
    }

    public void setRunId(int runId) {
        this.runId = runId;
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
         * shuliang3 :
         * shuliang4 :
         * shuliang1 : 1
         * xgfj :
         * shuliang2 : 2
         * shuliang5 :
         * runId : 51605
         * mingcheng1 : q
         * mingcheng3 :
         * mingcheng2 : w
         * hejidj :
         * mingcheng4 :
         * mingcheng5 :
         * bm : 宜春公交集团有限公司
         * mainId : 4
         * caigouren :
         * sqrq : 2019-04-08
         * ghzx :
         * hejije : 5.0
         * QiTa : 其他
         * sqr : 超级管理员
         * jine2 : 4.0
         * cwzjyj :
         * jine3 :
         * jine4 :
         * jine5 :
         * danjia5 :
         * $type$ : WF_dwwpcgjhb
         * danjia4 :
         * danjia3 :
         * danjia2 : 2
         * jine1 : 1.0
         * danjia1 : 1
         * fgldyj :
         * hejisl : 3
         * yt : 用途
         * bmfzryj :
         * LiuShuiHao :
         */

        private String shuliang3;
        private String shuliang4;
        private String shuliang1;
        private String xgfj;
        private String shuliang2;
        private String shuliang5;
        private String runId;
        private String mingcheng1;
        private String mingcheng3;
        private String mingcheng2;
        private String hejidj;
        private String mingcheng4;
        private String mingcheng5;
        private String bm;
        private int mainId;
        private String caigouren;
        private String sqrq;
        private String ghzx;
        private String hejije;
        private String QiTa;
        private String sqr;
        private String jine2;
        private String cwzjyj;
        private String jine3;
        private String jine4;
        private String jine5;
        private String danjia5;
        private String $type$;
        private String danjia4;
        private String danjia3;
        private String danjia2;
        private String jine1;
        private String danjia1;
        private String fgldyj;
        private String hejisl;
        private String yt;
        private String bmfzryj;
        private String LiuShuiHao;

        public String getShuliang3() {
            return shuliang3;
        }

        public void setShuliang3(String shuliang3) {
            this.shuliang3 = shuliang3;
        }

        public String getShuliang4() {
            return shuliang4;
        }

        public void setShuliang4(String shuliang4) {
            this.shuliang4 = shuliang4;
        }

        public String getShuliang1() {
            return shuliang1;
        }

        public void setShuliang1(String shuliang1) {
            this.shuliang1 = shuliang1;
        }

        public String getXgfj() {
            return xgfj;
        }

        public void setXgfj(String xgfj) {
            this.xgfj = xgfj;
        }

        public String getShuliang2() {
            return shuliang2;
        }

        public void setShuliang2(String shuliang2) {
            this.shuliang2 = shuliang2;
        }

        public String getShuliang5() {
            return shuliang5;
        }

        public void setShuliang5(String shuliang5) {
            this.shuliang5 = shuliang5;
        }

        public String getRunId() {
            return runId;
        }

        public void setRunId(String runId) {
            this.runId = runId;
        }

        public String getMingcheng1() {
            return mingcheng1;
        }

        public void setMingcheng1(String mingcheng1) {
            this.mingcheng1 = mingcheng1;
        }

        public String getMingcheng3() {
            return mingcheng3;
        }

        public void setMingcheng3(String mingcheng3) {
            this.mingcheng3 = mingcheng3;
        }

        public String getMingcheng2() {
            return mingcheng2;
        }

        public void setMingcheng2(String mingcheng2) {
            this.mingcheng2 = mingcheng2;
        }

        public String getHejidj() {
            return hejidj;
        }

        public void setHejidj(String hejidj) {
            this.hejidj = hejidj;
        }

        public String getMingcheng4() {
            return mingcheng4;
        }

        public void setMingcheng4(String mingcheng4) {
            this.mingcheng4 = mingcheng4;
        }

        public String getMingcheng5() {
            return mingcheng5;
        }

        public void setMingcheng5(String mingcheng5) {
            this.mingcheng5 = mingcheng5;
        }

        public String getBm() {
            return bm;
        }

        public void setBm(String bm) {
            this.bm = bm;
        }

        public int getMainId() {
            return mainId;
        }

        public void setMainId(int mainId) {
            this.mainId = mainId;
        }

        public String getCaigouren() {
            return caigouren;
        }

        public void setCaigouren(String caigouren) {
            this.caigouren = caigouren;
        }

        public String getSqrq() {
            return sqrq;
        }

        public void setSqrq(String sqrq) {
            this.sqrq = sqrq;
        }

        public String getGhzx() {
            return ghzx;
        }

        public void setGhzx(String ghzx) {
            this.ghzx = ghzx;
        }

        public String getHejije() {
            return hejije;
        }

        public void setHejije(String hejije) {
            this.hejije = hejije;
        }

        public String getQiTa() {
            return QiTa;
        }

        public void setQiTa(String QiTa) {
            this.QiTa = QiTa;
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

        public String getCwzjyj() {
            return cwzjyj;
        }

        public void setCwzjyj(String cwzjyj) {
            this.cwzjyj = cwzjyj;
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

        public String getDanjia5() {
            return danjia5;
        }

        public void setDanjia5(String danjia5) {
            this.danjia5 = danjia5;
        }

        public String get$type$() {
            return $type$;
        }

        public void set$type$(String $type$) {
            this.$type$ = $type$;
        }

        public String getDanjia4() {
            return danjia4;
        }

        public void setDanjia4(String danjia4) {
            this.danjia4 = danjia4;
        }

        public String getDanjia3() {
            return danjia3;
        }

        public void setDanjia3(String danjia3) {
            this.danjia3 = danjia3;
        }

        public String getDanjia2() {
            return danjia2;
        }

        public void setDanjia2(String danjia2) {
            this.danjia2 = danjia2;
        }

        public String getJine1() {
            return jine1;
        }

        public void setJine1(String jine1) {
            this.jine1 = jine1;
        }

        public String getDanjia1() {
            return danjia1;
        }

        public void setDanjia1(String danjia1) {
            this.danjia1 = danjia1;
        }

        public String getFgldyj() {
            return fgldyj;
        }

        public void setFgldyj(String fgldyj) {
            this.fgldyj = fgldyj;
        }

        public String getHejisl() {
            return hejisl;
        }

        public void setHejisl(String hejisl) {
            this.hejisl = hejisl;
        }

        public String getYt() {
            return yt;
        }

        public void setYt(String yt) {
            this.yt = yt;
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
         * destination : 财务总监
         * name : to 财务总监
         * source : 申请人
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
