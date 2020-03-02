package com.hy.powerplatform.oa_flow.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/3/12.
 */

public class FlowCompMessage implements Serializable {

    /**
     * success : true
     * mainform : [{"rq":"2019-03-12","zhglbyj":"","runId":51526,"$type$":"WF_xxfbspd","fgldyj":"","bt":"标题","fj":"","mainId":6,"ng":"超级管理员","zjlyj":"","jbbmyj":"","fbpt1":"on","fbpt3":"","bmfzryj":"","LiuShuiHao":"No.20190312011","fbpt2":""}]
     */

    private boolean success;
    private List<MainformBean> mainform;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<MainformBean> getMainform() {
        return mainform;
    }

    public void setMainform(List<MainformBean> mainform) {
        this.mainform = mainform;
    }

    public static class MainformBean {
        /**
         * rq : 2019-03-12
         * zhglbyj :
         * runId : 51526
         * $type$ : WF_xxfbspd
         * fgldyj :
         * bt : 标题
         * fj :
         * mainId : 6
         * ng : 超级管理员
         * zjlyj :
         * jbbmyj :
         * fbpt1 : on
         * fbpt3 :
         * bmfzryj :
         * LiuShuiHao : No.20190312011
         * fbpt2 :
         */

        private String rq;
        private String zhglbyj;
        private String runId;
        private String $type$;
        private String fgldyj;
        private String bt;
        private String fj;
        private int mainId;
        private String ng;
        private String zjlyj;
        private String jbbmyj;
        private String fbpt1;
        private String fbpt3;
        private String bmfzryj;
        private String LiuShuiHao;
        private String fbpt2;

        public String getRq() {
            return rq;
        }

        public void setRq(String rq) {
            this.rq = rq;
        }

        public String getZhglbyj() {
            return zhglbyj;
        }

        public void setZhglbyj(String zhglbyj) {
            this.zhglbyj = zhglbyj;
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

        public String getBt() {
            return bt;
        }

        public void setBt(String bt) {
            this.bt = bt;
        }

        public String getFj() {
            return fj;
        }

        public void setFj(String fj) {
            this.fj = fj;
        }

        public int getMainId() {
            return mainId;
        }

        public void setMainId(int mainId) {
            this.mainId = mainId;
        }

        public String getNg() {
            return ng;
        }

        public void setNg(String ng) {
            this.ng = ng;
        }

        public String getZjlyj() {
            return zjlyj;
        }

        public void setZjlyj(String zjlyj) {
            this.zjlyj = zjlyj;
        }

        public String getJbbmyj() {
            return jbbmyj;
        }

        public void setJbbmyj(String jbbmyj) {
            this.jbbmyj = jbbmyj;
        }

        public String getFbpt1() {
            return fbpt1;
        }

        public void setFbpt1(String fbpt1) {
            this.fbpt1 = fbpt1;
        }

        public String getFbpt3() {
            return fbpt3;
        }

        public void setFbpt3(String fbpt3) {
            this.fbpt3 = fbpt3;
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

        public String getFbpt2() {
            return fbpt2;
        }

        public void setFbpt2(String fbpt2) {
            this.fbpt2 = fbpt2;
        }
    }
}
