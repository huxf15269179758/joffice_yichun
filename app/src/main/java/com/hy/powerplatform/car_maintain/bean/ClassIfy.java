package com.hy.powerplatform.car_maintain.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/11/27.
 */

public class ClassIfy implements Serializable {

    /**
     * success : true
     * totalCounts : 9
     * result : [{"version":null,"orgId":null,"orgPath":null,"proTypeId":4597,"typeName":"水箱","path":"0.4597.","depth":1,"parentId":0,"nodeKey":"shuixiang","catKey":"WZCLLB","sn":1,"userId":7515,"code":null,"useTime":null,"usePrice":null,"wxfl":null},{"version":null,"orgId":null,"orgPath":null,"proTypeId":3520,"typeName":"轮胎","path":"0.3520.","depth":1,"parentId":0,"nodeKey":"luntai","catKey":"WZCLLB","sn":1,"userId":1,"code":null,"useTime":null,"usePrice":null,"wxfl":1},{"version":null,"orgId":null,"orgPath":null,"proTypeId":3549,"typeName":"电器类","path":"0.3549.","depth":1,"parentId":0,"nodeKey":"dianqilei","catKey":"WZCLLB","sn":1,"userId":7460,"code":null,"useTime":null,"usePrice":null,"wxfl":1},{"version":null,"orgId":null,"orgPath":null,"proTypeId":3554,"typeName":"底盘及附件","path":"0.3554.","depth":1,"parentId":0,"nodeKey":"depanjifujian,dipanjifujian","catKey":"WZCLLB","sn":1,"userId":7460,"code":null,"useTime":null,"usePrice":null,"wxfl":1},{"version":null,"orgId":null,"orgPath":null,"proTypeId":3557,"typeName":"玻璃","path":"0.3557.","depth":1,"parentId":0,"nodeKey":"boli","catKey":"WZCLLB","sn":1,"userId":7460,"code":null,"useTime":null,"usePrice":null,"wxfl":1},{"version":null,"orgId":null,"orgPath":null,"proTypeId":3548,"typeName":"变速箱类","path":"0.3548.","depth":1,"parentId":0,"nodeKey":"biansuxianglei","catKey":"WZCLLB","sn":1,"userId":7460,"code":null,"useTime":null,"usePrice":null,"wxfl":1},{"version":null,"orgId":null,"orgPath":null,"proTypeId":3550,"typeName":"发动机类","path":"0.3550.","depth":1,"parentId":0,"nodeKey":"fadongjilei","catKey":"WZCLLB","sn":1,"userId":7460,"code":null,"useTime":null,"usePrice":null,"wxfl":1},{"version":null,"orgId":null,"orgPath":null,"proTypeId":3556,"typeName":"油品","path":"0.3556.","depth":1,"parentId":0,"nodeKey":"youpin","catKey":"WZCLLB","sn":1,"userId":7460,"code":null,"useTime":null,"usePrice":null,"wxfl":1},{"version":null,"orgId":null,"orgPath":null,"proTypeId":4376,"typeName":"外加工类","path":"0.4376.","depth":1,"parentId":0,"nodeKey":"waijiagonglei","catKey":"WZCLLB","sn":1,"userId":7739,"code":null,"useTime":null,"usePrice":null,"wxfl":null}]
     */

    private boolean success;
    private int totalCounts;
    private List<ResultBean> result;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getTotalCounts() {
        return totalCounts;
    }

    public void setTotalCounts(int totalCounts) {
        this.totalCounts = totalCounts;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean implements Serializable {
        /**
         * version : null
         * orgId : null
         * orgPath : null
         * proTypeId : 4597
         * typeName : 水箱
         * path : 0.4597.
         * depth : 1
         * parentId : 0
         * nodeKey : shuixiang
         * catKey : WZCLLB
         * sn : 1
         * userId : 7515
         * code : null
         * useTime : null
         * usePrice : null
         * wxfl : null
         */

        private Object version;
        private Object orgId;
        private Object orgPath;
        private int proTypeId;
        private String typeName;
        private String path;
        private int depth;
        private int parentId;
        private String nodeKey;
        private String catKey;
        private int sn;
        private int userId;
        private Object code;
        private Object useTime;
        private Object usePrice;
        private Object wxfl;

        public Object getVersion() {
            return version;
        }

        public void setVersion(Object version) {
            this.version = version;
        }

        public Object getOrgId() {
            return orgId;
        }

        public void setOrgId(Object orgId) {
            this.orgId = orgId;
        }

        public Object getOrgPath() {
            return orgPath;
        }

        public void setOrgPath(Object orgPath) {
            this.orgPath = orgPath;
        }

        public int getProTypeId() {
            return proTypeId;
        }

        public void setProTypeId(int proTypeId) {
            this.proTypeId = proTypeId;
        }

        public String getTypeName() {
            return typeName;
        }

        public void setTypeName(String typeName) {
            this.typeName = typeName;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public int getDepth() {
            return depth;
        }

        public void setDepth(int depth) {
            this.depth = depth;
        }

        public int getParentId() {
            return parentId;
        }

        public void setParentId(int parentId) {
            this.parentId = parentId;
        }

        public String getNodeKey() {
            return nodeKey;
        }

        public void setNodeKey(String nodeKey) {
            this.nodeKey = nodeKey;
        }

        public String getCatKey() {
            return catKey;
        }

        public void setCatKey(String catKey) {
            this.catKey = catKey;
        }

        public int getSn() {
            return sn;
        }

        public void setSn(int sn) {
            this.sn = sn;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public Object getCode() {
            return code;
        }

        public void setCode(Object code) {
            this.code = code;
        }

        public Object getUseTime() {
            return useTime;
        }

        public void setUseTime(Object useTime) {
            this.useTime = useTime;
        }

        public Object getUsePrice() {
            return usePrice;
        }

        public void setUsePrice(Object usePrice) {
            this.usePrice = usePrice;
        }

        public Object getWxfl() {
            return wxfl;
        }

        public void setWxfl(Object wxfl) {
            this.wxfl = wxfl;
        }
    }
}
