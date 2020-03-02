package com.hy.powerplatform.oa_flow.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/2/19.
 */

public class FlowDriverAssessDetail implements Serializable {

    /**
     * success : true
     * mainform : [{"xgfj":"","xm":"测试","mainId":1,"runId":51456,"rlzybyj":"","$type$":"WF_jsykspfbznews","jbbmyj":"","bmfzryj":""}]
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
         * xgfj :
         * xm : 测试
         * mainId : 1
         * runId : 51456
         * rlzybyj :
         * $type$ : WF_jsykspfbznews
         * jbbmyj :
         * bmfzryj :
         */

        private String xgfj;
        private String xm;
        private int mainId;
        private String runId;
        private String rlzybyj;
        private String $type$;
        private String jbbmyj;
        private String bmfzryj;

        public String getXgfj() {
            return xgfj;
        }

        public void setXgfj(String xgfj) {
            this.xgfj = xgfj;
        }

        public String getXm() {
            return xm;
        }

        public void setXm(String xm) {
            this.xm = xm;
        }

        public int getMainId() {
            return mainId;
        }

        public void setMainId(int mainId) {
            this.mainId = mainId;
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

        public String get$type$() {
            return $type$;
        }

        public void set$type$(String $type$) {
            this.$type$ = $type$;
        }

        public String getJbbmyj() {
            return jbbmyj;
        }

        public void setJbbmyj(String jbbmyj) {
            this.jbbmyj = jbbmyj;
        }

        public String getBmfzryj() {
            return bmfzryj;
        }

        public void setBmfzryj(String bmfzryj) {
            this.bmfzryj = bmfzryj;
        }
    }
}
