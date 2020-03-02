package com.hy.powerplatform.operation.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/12/31.
 */

public class Department implements Serializable {

    /**
     * success : true
     * data : {"id":"0","depRoot":"null","text":"全部组织","expanded":true,"orgType":"","depType":"","orgDem":"0","title":"","key":"","children":[{"id":"378","depRoot":"1","text":"宜春公交集团有限公司","expanded":true,"orgType":"1","depType":"1","orgDem":"1","title":"宜春公交集团有限公司","key":"378","children":[{"id":"505","depRoot":"1","text":"营运一分公司","expanded":true,"orgType":"2","depType":"1","orgDem":"1","title":"营运一分公司","key":"505","leaf":true},{"id":"506","depRoot":"1","text":"营运二分公司","expanded":true,"orgType":"2","depType":"1","orgDem":"1","title":"营运二分公司","key":"506","leaf":true},{"id":"507","depRoot":"1","text":"枢纽分公司","expanded":true,"orgType":"2","depType":"1","orgDem":"1","title":"枢纽分公司","key":"507","leaf":true}]}]}
     */

    private boolean success;
    private DataBean data;

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

    public static class DataBean {
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
         * children : [{"id":"378","depRoot":"1","text":"宜春公交集团有限公司","expanded":true,"orgType":"1","depType":"1","orgDem":"1","title":"宜春公交集团有限公司","key":"378","children":[{"id":"505","depRoot":"1","text":"营运一分公司","expanded":true,"orgType":"2","depType":"1","orgDem":"1","title":"营运一分公司","key":"505","leaf":true},{"id":"506","depRoot":"1","text":"营运二分公司","expanded":true,"orgType":"2","depType":"1","orgDem":"1","title":"营运二分公司","key":"506","leaf":true},{"id":"507","depRoot":"1","text":"枢纽分公司","expanded":true,"orgType":"2","depType":"1","orgDem":"1","title":"枢纽分公司","key":"507","leaf":true}]}]
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

        public static class ChildrenBeanX {
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
             * children : [{"id":"505","depRoot":"1","text":"营运一分公司","expanded":true,"orgType":"2","depType":"1","orgDem":"1","title":"营运一分公司","key":"505","leaf":true},{"id":"506","depRoot":"1","text":"营运二分公司","expanded":true,"orgType":"2","depType":"1","orgDem":"1","title":"营运二分公司","key":"506","leaf":true},{"id":"507","depRoot":"1","text":"枢纽分公司","expanded":true,"orgType":"2","depType":"1","orgDem":"1","title":"枢纽分公司","key":"507","leaf":true}]
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

            public static class ChildrenBean {
                /**
                 * id : 505
                 * depRoot : 1
                 * text : 营运一分公司
                 * expanded : true
                 * orgType : 2
                 * depType : 1
                 * orgDem : 1
                 * title : 营运一分公司
                 * key : 505
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
