package com.hy.powerplatform.statist.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2020/1/19.
 */

public class Department implements Serializable {

    /**
     * success : true
     * data : {"id":"0","depRoot":"null","text":"全部组织","expanded":true,"orgType":"","depType":"","orgDem":"0","title":"","key":"","children":[{"id":"378","depRoot":"1","text":"宜春公交集团有限公司","expanded":true,"orgType":"1","depType":"1","orgDem":"1","title":"宜春公交集团有限公司","key":"378","children":[{"id":"522","depRoot":"1","text":"企业发展部","expanded":true,"orgType":"2","depType":"","orgDem":"1","title":"企业发展部","key":"522","leaf":true},{"id":"521","depRoot":"1","text":"宣传教育部","expanded":true,"orgType":"2","depType":"","orgDem":"1","title":"宣传教育部","key":"521","leaf":true},{"id":"512","depRoot":"1","text":"领导班子","expanded":true,"orgType":"2","depType":"","orgDem":"1","title":"领导班子","key":"512","leaf":true},{"id":"520","depRoot":"1","text":"监察审计部","expanded":true,"orgType":"2","depType":"","orgDem":"1","title":"监察审计部","key":"520","leaf":true},{"id":"519","depRoot":"1","text":"充电公司","expanded":true,"orgType":"2","depType":"","orgDem":"1","title":"充电公司","key":"519","leaf":true},{"id":"495","depRoot":"1","text":"党群工作部","expanded":true,"orgType":"2","depType":"2","orgDem":"1","title":"党群工作部","key":"495","leaf":true},{"id":"496","depRoot":"1","text":"综合管理部","expanded":true,"orgType":"2","depType":"2","orgDem":"1","title":"综合管理部","key":"496","leaf":true},{"id":"523","depRoot":"1","text":"安全营运部","expanded":true,"orgType":"2","depType":"2","orgDem":"1","title":"安全营运部","key":"523","leaf":true},{"id":"499","depRoot":"1","text":"人力资源部","expanded":true,"orgType":"2","depType":"2","orgDem":"1","title":"人力资源部","key":"499","leaf":true},{"id":"500","depRoot":"1","text":"信息技术部","expanded":true,"orgType":"2","depType":"2","orgDem":"1","title":"信息技术部","key":"500","leaf":true},{"id":"501","depRoot":"1","text":"财务部","expanded":true,"orgType":"2","depType":"2","orgDem":"1","title":"财务部","key":"501","leaf":true},{"id":"502","depRoot":"1","text":"大为物业公司","expanded":true,"orgType":"2","depType":"2","orgDem":"1","title":"大为物业公司","key":"502","leaf":true},{"id":"503","depRoot":"1","text":"采购供应部","expanded":true,"orgType":"2","depType":"2","orgDem":"1","title":"采购供应部","key":"503","leaf":true},{"id":"505","depRoot":"1","text":"营运一分公司","expanded":true,"orgType":"2","depType":"1","orgDem":"1","title":"营运一分公司","key":"505","leaf":true},{"id":"506","depRoot":"1","text":"营运二分公司","expanded":true,"orgType":"2","depType":"1","orgDem":"1","title":"营运二分公司","key":"506","leaf":true},{"id":"507","depRoot":"1","text":"枢纽分公司","expanded":true,"orgType":"2","depType":"1","orgDem":"1","title":"枢纽分公司","key":"507","leaf":true},{"id":"508","depRoot":"1","text":"修理厂","expanded":true,"orgType":"2","depType":"2","orgDem":"1","title":"修理厂","key":"508","leaf":true},{"id":"509","depRoot":"1","text":"广告公司","expanded":true,"orgType":"2","depType":"2","orgDem":"1","title":"广告公司","key":"509","leaf":true},{"id":"510","depRoot":"1","text":"出租车公司","expanded":true,"orgType":"2","depType":"2","orgDem":"1","title":"出租车公司","key":"510","leaf":true},{"id":"504","depRoot":"1","text":"乐途公司","expanded":true,"orgType":"2","depType":"2","orgDem":"1","title":"乐途公司","key":"504","leaf":true},{"id":"511","depRoot":"1","text":"未在岗","expanded":true,"orgType":"2","depType":"","orgDem":"1","title":"未在岗","key":"511","leaf":true},{"id":"514","depRoot":"1","text":"宜春市春城通科技有限公司","expanded":true,"orgType":"2","depType":"2","orgDem":"1","title":"宜春市春城通科技有限公司","key":"514","leaf":true},{"id":"518","depRoot":"1","text":"顺通客运服务有限公司","expanded":true,"orgType":"2","depType":"2","orgDem":"1","title":"顺通客运服务有限公司","key":"518","leaf":true}]}]}
     */

    private boolean success;
    private String msg;
    private DataBean data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean implements Serializable {
        /**
         * id : 0
         * depRoot : null
         * text : 全部组织
         * expanded : true
         * orgType :
         * depType :
         * orgDem : 0
         * title :
         * key :
         * children : [{"id":"378","depRoot":"1","text":"宜春公交集团有限公司","expanded":true,"orgType":"1","depType":"1","orgDem":"1","title":"宜春公交集团有限公司","key":"378","children":[{"id":"522","depRoot":"1","text":"企业发展部","expanded":true,"orgType":"2","depType":"","orgDem":"1","title":"企业发展部","key":"522","leaf":true},{"id":"521","depRoot":"1","text":"宣传教育部","expanded":true,"orgType":"2","depType":"","orgDem":"1","title":"宣传教育部","key":"521","leaf":true},{"id":"512","depRoot":"1","text":"领导班子","expanded":true,"orgType":"2","depType":"","orgDem":"1","title":"领导班子","key":"512","leaf":true},{"id":"520","depRoot":"1","text":"监察审计部","expanded":true,"orgType":"2","depType":"","orgDem":"1","title":"监察审计部","key":"520","leaf":true},{"id":"519","depRoot":"1","text":"充电公司","expanded":true,"orgType":"2","depType":"","orgDem":"1","title":"充电公司","key":"519","leaf":true},{"id":"495","depRoot":"1","text":"党群工作部","expanded":true,"orgType":"2","depType":"2","orgDem":"1","title":"党群工作部","key":"495","leaf":true},{"id":"496","depRoot":"1","text":"综合管理部","expanded":true,"orgType":"2","depType":"2","orgDem":"1","title":"综合管理部","key":"496","leaf":true},{"id":"523","depRoot":"1","text":"安全营运部","expanded":true,"orgType":"2","depType":"2","orgDem":"1","title":"安全营运部","key":"523","leaf":true},{"id":"499","depRoot":"1","text":"人力资源部","expanded":true,"orgType":"2","depType":"2","orgDem":"1","title":"人力资源部","key":"499","leaf":true},{"id":"500","depRoot":"1","text":"信息技术部","expanded":true,"orgType":"2","depType":"2","orgDem":"1","title":"信息技术部","key":"500","leaf":true},{"id":"501","depRoot":"1","text":"财务部","expanded":true,"orgType":"2","depType":"2","orgDem":"1","title":"财务部","key":"501","leaf":true},{"id":"502","depRoot":"1","text":"大为物业公司","expanded":true,"orgType":"2","depType":"2","orgDem":"1","title":"大为物业公司","key":"502","leaf":true},{"id":"503","depRoot":"1","text":"采购供应部","expanded":true,"orgType":"2","depType":"2","orgDem":"1","title":"采购供应部","key":"503","leaf":true},{"id":"505","depRoot":"1","text":"营运一分公司","expanded":true,"orgType":"2","depType":"1","orgDem":"1","title":"营运一分公司","key":"505","leaf":true},{"id":"506","depRoot":"1","text":"营运二分公司","expanded":true,"orgType":"2","depType":"1","orgDem":"1","title":"营运二分公司","key":"506","leaf":true},{"id":"507","depRoot":"1","text":"枢纽分公司","expanded":true,"orgType":"2","depType":"1","orgDem":"1","title":"枢纽分公司","key":"507","leaf":true},{"id":"508","depRoot":"1","text":"修理厂","expanded":true,"orgType":"2","depType":"2","orgDem":"1","title":"修理厂","key":"508","leaf":true},{"id":"509","depRoot":"1","text":"广告公司","expanded":true,"orgType":"2","depType":"2","orgDem":"1","title":"广告公司","key":"509","leaf":true},{"id":"510","depRoot":"1","text":"出租车公司","expanded":true,"orgType":"2","depType":"2","orgDem":"1","title":"出租车公司","key":"510","leaf":true},{"id":"504","depRoot":"1","text":"乐途公司","expanded":true,"orgType":"2","depType":"2","orgDem":"1","title":"乐途公司","key":"504","leaf":true},{"id":"511","depRoot":"1","text":"未在岗","expanded":true,"orgType":"2","depType":"","orgDem":"1","title":"未在岗","key":"511","leaf":true},{"id":"514","depRoot":"1","text":"宜春市春城通科技有限公司","expanded":true,"orgType":"2","depType":"2","orgDem":"1","title":"宜春市春城通科技有限公司","key":"514","leaf":true},{"id":"518","depRoot":"1","text":"顺通客运服务有限公司","expanded":true,"orgType":"2","depType":"2","orgDem":"1","title":"顺通客运服务有限公司","key":"518","leaf":true}]}]
         */

        private String id;
        private String depRoot;
        private String text;
        private boolean expanded;
        private String orgType;
        private String depType;
        private String orgDem;
        private String title;
        private String key;
        private List<ChildrenBeanX> children;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getDepRoot() {
            return depRoot;
        }

        public void setDepRoot(String depRoot) {
            this.depRoot = depRoot;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public boolean isExpanded() {
            return expanded;
        }

        public void setExpanded(boolean expanded) {
            this.expanded = expanded;
        }

        public String getOrgType() {
            return orgType;
        }

        public void setOrgType(String orgType) {
            this.orgType = orgType;
        }

        public String getDepType() {
            return depType;
        }

        public void setDepType(String depType) {
            this.depType = depType;
        }

        public String getOrgDem() {
            return orgDem;
        }

        public void setOrgDem(String orgDem) {
            this.orgDem = orgDem;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public List<ChildrenBeanX> getChildren() {
            return children;
        }

        public void setChildren(List<ChildrenBeanX> children) {
            this.children = children;
        }

        public static class ChildrenBeanX implements Serializable {
            /**
             * id : 378
             * depRoot : 1
             * text : 宜春公交集团有限公司
             * expanded : true
             * orgType : 1
             * depType : 1
             * orgDem : 1
             * title : 宜春公交集团有限公司
             * key : 378
             * children : [{"id":"522","depRoot":"1","text":"企业发展部","expanded":true,"orgType":"2","depType":"","orgDem":"1","title":"企业发展部","key":"522","leaf":true},{"id":"521","depRoot":"1","text":"宣传教育部","expanded":true,"orgType":"2","depType":"","orgDem":"1","title":"宣传教育部","key":"521","leaf":true},{"id":"512","depRoot":"1","text":"领导班子","expanded":true,"orgType":"2","depType":"","orgDem":"1","title":"领导班子","key":"512","leaf":true},{"id":"520","depRoot":"1","text":"监察审计部","expanded":true,"orgType":"2","depType":"","orgDem":"1","title":"监察审计部","key":"520","leaf":true},{"id":"519","depRoot":"1","text":"充电公司","expanded":true,"orgType":"2","depType":"","orgDem":"1","title":"充电公司","key":"519","leaf":true},{"id":"495","depRoot":"1","text":"党群工作部","expanded":true,"orgType":"2","depType":"2","orgDem":"1","title":"党群工作部","key":"495","leaf":true},{"id":"496","depRoot":"1","text":"综合管理部","expanded":true,"orgType":"2","depType":"2","orgDem":"1","title":"综合管理部","key":"496","leaf":true},{"id":"523","depRoot":"1","text":"安全营运部","expanded":true,"orgType":"2","depType":"2","orgDem":"1","title":"安全营运部","key":"523","leaf":true},{"id":"499","depRoot":"1","text":"人力资源部","expanded":true,"orgType":"2","depType":"2","orgDem":"1","title":"人力资源部","key":"499","leaf":true},{"id":"500","depRoot":"1","text":"信息技术部","expanded":true,"orgType":"2","depType":"2","orgDem":"1","title":"信息技术部","key":"500","leaf":true},{"id":"501","depRoot":"1","text":"财务部","expanded":true,"orgType":"2","depType":"2","orgDem":"1","title":"财务部","key":"501","leaf":true},{"id":"502","depRoot":"1","text":"大为物业公司","expanded":true,"orgType":"2","depType":"2","orgDem":"1","title":"大为物业公司","key":"502","leaf":true},{"id":"503","depRoot":"1","text":"采购供应部","expanded":true,"orgType":"2","depType":"2","orgDem":"1","title":"采购供应部","key":"503","leaf":true},{"id":"505","depRoot":"1","text":"营运一分公司","expanded":true,"orgType":"2","depType":"1","orgDem":"1","title":"营运一分公司","key":"505","leaf":true},{"id":"506","depRoot":"1","text":"营运二分公司","expanded":true,"orgType":"2","depType":"1","orgDem":"1","title":"营运二分公司","key":"506","leaf":true},{"id":"507","depRoot":"1","text":"枢纽分公司","expanded":true,"orgType":"2","depType":"1","orgDem":"1","title":"枢纽分公司","key":"507","leaf":true},{"id":"508","depRoot":"1","text":"修理厂","expanded":true,"orgType":"2","depType":"2","orgDem":"1","title":"修理厂","key":"508","leaf":true},{"id":"509","depRoot":"1","text":"广告公司","expanded":true,"orgType":"2","depType":"2","orgDem":"1","title":"广告公司","key":"509","leaf":true},{"id":"510","depRoot":"1","text":"出租车公司","expanded":true,"orgType":"2","depType":"2","orgDem":"1","title":"出租车公司","key":"510","leaf":true},{"id":"504","depRoot":"1","text":"乐途公司","expanded":true,"orgType":"2","depType":"2","orgDem":"1","title":"乐途公司","key":"504","leaf":true},{"id":"511","depRoot":"1","text":"未在岗","expanded":true,"orgType":"2","depType":"","orgDem":"1","title":"未在岗","key":"511","leaf":true},{"id":"514","depRoot":"1","text":"宜春市春城通科技有限公司","expanded":true,"orgType":"2","depType":"2","orgDem":"1","title":"宜春市春城通科技有限公司","key":"514","leaf":true},{"id":"518","depRoot":"1","text":"顺通客运服务有限公司","expanded":true,"orgType":"2","depType":"2","orgDem":"1","title":"顺通客运服务有限公司","key":"518","leaf":true}]
             */

            private String id;
            private String depRoot;
            private String text;
            private boolean expanded;
            private String orgType;
            private String depType;
            private String orgDem;
            private String title;
            private String key;
            private List<ChildrenBean> children;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getDepRoot() {
                return depRoot;
            }

            public void setDepRoot(String depRoot) {
                this.depRoot = depRoot;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }

            public boolean isExpanded() {
                return expanded;
            }

            public void setExpanded(boolean expanded) {
                this.expanded = expanded;
            }

            public String getOrgType() {
                return orgType;
            }

            public void setOrgType(String orgType) {
                this.orgType = orgType;
            }

            public String getDepType() {
                return depType;
            }

            public void setDepType(String depType) {
                this.depType = depType;
            }

            public String getOrgDem() {
                return orgDem;
            }

            public void setOrgDem(String orgDem) {
                this.orgDem = orgDem;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getKey() {
                return key;
            }

            public void setKey(String key) {
                this.key = key;
            }

            public List<ChildrenBean> getChildren() {
                return children;
            }

            public void setChildren(List<ChildrenBean> children) {
                this.children = children;
            }

            public static class ChildrenBean implements Serializable {
                /**
                 * id : 522
                 * depRoot : 1
                 * text : 企业发展部
                 * expanded : true
                 * orgType : 2
                 * depType :
                 * orgDem : 1
                 * title : 企业发展部
                 * key : 522
                 * leaf : true
                 */

                private String id;
                private String depRoot;
                private String text;
                private boolean expanded;
                private String orgType;
                private String depType;
                private String orgDem;
                private String title;
                private String key;
                private boolean leaf;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getDepRoot() {
                    return depRoot;
                }

                public void setDepRoot(String depRoot) {
                    this.depRoot = depRoot;
                }

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public boolean isExpanded() {
                    return expanded;
                }

                public void setExpanded(boolean expanded) {
                    this.expanded = expanded;
                }

                public String getOrgType() {
                    return orgType;
                }

                public void setOrgType(String orgType) {
                    this.orgType = orgType;
                }

                public String getDepType() {
                    return depType;
                }

                public void setDepType(String depType) {
                    this.depType = depType;
                }

                public String getOrgDem() {
                    return orgDem;
                }

                public void setOrgDem(String orgDem) {
                    this.orgDem = orgDem;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getKey() {
                    return key;
                }

                public void setKey(String key) {
                    this.key = key;
                }

                public boolean isLeaf() {
                    return leaf;
                }

                public void setLeaf(boolean leaf) {
                    this.leaf = leaf;
                }
            }
        }
    }
}
