package com.hy.powerplatform.oa_flow.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/2/12.
 */

public class MyRepair implements Serializable {


    /**
     * success : true
     * mainform : [{"wxryyj":"","WeiXiuRenYuanQianZiUId":"","jjbzbyj":"[{\"ui\":\"9467\",\"un\":\"易睿\",\"c\":\"2019-02-18 12:04\",\"v\":\"同意\"}]","WeiXiuQingKuangGaiShu":"","runId":51527,"$type$":"WF_BaoXiuXiangMuDengJiBiao","BaoXiuBuMenMingCheng":"宜春公交集团有限公司","WeiXiuQingKuangFanKui":"","xmclfkyj":"","BaoXiuBuMenMungChengDid":"","mainId":15,"BaoXiuDiDian":"济南","bjap":"","WeiXiuRenYuanQianZi":"","RiQi":"2019-02-18","bjpj":"","JuTiQingKuang":"测试","bmfzryj":"[{\"ui\":\"9354\",\"un\":\"欧阳晓林\",\"c\":\"2019-02-18 12:03\",\"v\":\"同意\"}]","XiangGuanFuJian":"","LiuShuiHao":""}]
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
         * wxryyj :
         * WeiXiuRenYuanQianZiUId :
         * jjbzbyj : [{"ui":"9467","un":"易睿","c":"2019-02-18 12:04","v":"同意"}]
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
         * bmfzryj : [{"ui":"9354","un":"欧阳晓林","c":"2019-02-18 12:03","v":"同意"}]
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
}
