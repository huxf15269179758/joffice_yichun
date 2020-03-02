package com.hy.powerplatform.oa_flow.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/2/21.
 */

public class FlowJSGCDetail implements Serializable {

    /**
     * success : true
     * mainform : [{"jjbzbyj":"","ShenQingRen":"超级管理员","runId":51480,"$type$":"WF_XinJianGongChengQiDongShenPiDan","jbfgldyj":"","fgldyj":"","xiangguanfujian":"","mainId":2,"RiQi":"2019-02-21","zjlyj":"","XuQiuShiXiang":"测试","bmfzryj":"","XuQiuBuMen":"宜春公交集团有限公司","LiuShuiHao":"No.20190221104"}]
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
         * jjbzbyj :
         * ShenQingRen : 超级管理员
         * runId : 51480
         * $type$ : WF_XinJianGongChengQiDongShenPiDan
         * jbfgldyj :
         * fgldyj :
         * xiangguanfujian :
         * mainId : 2
         * RiQi : 2019-02-21
         * zjlyj :
         * XuQiuShiXiang : 测试
         * bmfzryj :
         * XuQiuBuMen : 宜春公交集团有限公司
         * LiuShuiHao : No.20190221104
         */

        private String jjbzbyj;
        private String ShenQingRen;
        private String runId;
        private String $type$;
        private String jbfgldyj;
        private String fgldyj;
        private String xiangguanfujian;
        private int mainId;
        private String RiQi;
        private String zjlyj;
        private String XuQiuShiXiang;
        private String bmfzryj;
        private String XuQiuBuMen;
        private String LiuShuiHao;

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

        public String get$type$() {
            return $type$;
        }

        public void set$type$(String $type$) {
            this.$type$ = $type$;
        }

        public String getJbfgldyj() {
            return jbfgldyj;
        }

        public void setJbfgldyj(String jbfgldyj) {
            this.jbfgldyj = jbfgldyj;
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

        public String getRiQi() {
            return RiQi;
        }

        public void setRiQi(String RiQi) {
            this.RiQi = RiQi;
        }

        public String getZjlyj() {
            return zjlyj;
        }

        public void setZjlyj(String zjlyj) {
            this.zjlyj = zjlyj;
        }

        public String getXuQiuShiXiang() {
            return XuQiuShiXiang;
        }

        public void setXuQiuShiXiang(String XuQiuShiXiang) {
            this.XuQiuShiXiang = XuQiuShiXiang;
        }

        public String getBmfzryj() {
            return bmfzryj;
        }

        public void setBmfzryj(String bmfzryj) {
            this.bmfzryj = bmfzryj;
        }

        public String getXuQiuBuMen() {
            return XuQiuBuMen;
        }

        public void setXuQiuBuMen(String XuQiuBuMen) {
            this.XuQiuBuMen = XuQiuBuMen;
        }

        public String getLiuShuiHao() {
            return LiuShuiHao;
        }

        public void setLiuShuiHao(String LiuShuiHao) {
            this.LiuShuiHao = LiuShuiHao;
        }
    }
}
