package com.hy.powerplatform.oa_flow.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/2/12.
 */

public class MyGCAdd implements Serializable {


    /**
     * success : true
     * mainform : [{"jcbmyj":"","xgfj":"","jjbzbyj":"[{\"ui\":\"1909\",\"un\":\"易睿\",\"c\":\"2019-02-28 16:40\",\"v\":\"同意\"}]","ShenQingRen":"田乐","runId":51654,"jbfgldyj":"[{\"ui\":\"147\",\"un\":\"李健\",\"c\":\"2019-02-28 16:41\",\"v\":\"同意\"}]","$type$":"WF_JianSheGongChengLiangZengJiaShenPiDan","JuTiShiXiang":"测试","fgldyj":"[{\"ui\":\"147\",\"un\":\"李健\",\"c\":\"2019-02-28 16:39\",\"v\":\"同意\"}]","xiangguanfujian":"","mainId":11,"csbmyj":"","cwsjbyj":"[{\"ui\":\"1432\",\"un\":\"张敏\",\"c\":\"2019-02-28 16:42\",\"v\":\"同意\"}]","zjlyj":"","RiQi":"2019-02-28","bmfzryj":"[{\"ui\":\"1909\",\"un\":\"易睿\",\"c\":\"2019-02-28 16:37\",\"v\":\"同意\"}]","LiuShuiHao":"No.20190228417","XuQiuBuMen":"基建保障部"}]
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
         * jcbmyj :
         * xgfj :
         * jjbzbyj : [{"ui":"1909","un":"易睿","c":"2019-02-28 16:40","v":"同意"}]
         * ShenQingRen : 田乐
         * runId : 51654
         * jbfgldyj : [{"ui":"147","un":"李健","c":"2019-02-28 16:41","v":"同意"}]
         * $type$ : WF_JianSheGongChengLiangZengJiaShenPiDan
         * JuTiShiXiang : 测试
         * fgldyj : [{"ui":"147","un":"李健","c":"2019-02-28 16:39","v":"同意"}]
         * xiangguanfujian :
         * mainId : 11
         * csbmyj :
         * cwsjbyj : [{"ui":"1432","un":"张敏","c":"2019-02-28 16:42","v":"同意"}]
         * zjlyj :
         * RiQi : 2019-02-28
         * bmfzryj : [{"ui":"1909","un":"易睿","c":"2019-02-28 16:37","v":"同意"}]
         * LiuShuiHao : No.20190228417
         * XuQiuBuMen : 基建保障部
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
}
