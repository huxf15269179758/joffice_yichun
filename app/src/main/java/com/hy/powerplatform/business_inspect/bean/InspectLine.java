package com.hy.powerplatform.business_inspect.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by dell on 2018/5/10.
 */

public class InspectLine implements Serializable{


    /**
     * success : true
     * data : [{"lineCode":"1","lineName":"1路","depId":506,"depName":"营运二分公司","codeName":"1-1路"},{"lineCode":"2","lineName":"2路","depId":506,"depName":"营运二分公司","codeName":"2-2路"},{"lineCode":"3","lineName":"3路","depId":505,"depName":"营运一分公司","codeName":"3-3路"},{"lineCode":"4","lineName":"4路","depId":507,"depName":"枢纽分公司","codeName":"4-4路"},{"lineCode":"5","lineName":"5路","depId":506,"depName":"营运二分公司","codeName":"5-5路"},{"lineCode":"6","lineName":"6路","depId":505,"depName":"营运一分公司","codeName":"6-6路"},{"lineCode":"8","lineName":"8路","depId":505,"depName":"营运一分公司","codeName":"8-8路"},{"lineCode":"10","lineName":"10路","depId":507,"depName":"枢纽分公司","codeName":"10-10路"},{"lineCode":"11","lineName":"11路","depId":505,"depName":"营运一分公司","codeName":"11-11路"},{"lineCode":"12","lineName":"12路","depId":507,"depName":"枢纽分公司","codeName":"12-12路"},{"lineCode":"13","lineName":"13路","depId":505,"depName":"营运一分公司","codeName":"13-13路"},{"lineCode":"15","lineName":"15路","depId":506,"depName":"营运二分公司","codeName":"15-15路"},{"lineCode":"16","lineName":"16路","depId":506,"depName":"营运二分公司","codeName":"16-16路"},{"lineCode":"18","lineName":"18路","depId":505,"depName":"营运一分公司","codeName":"18-18路"},{"lineCode":"19","lineName":"19路","depId":507,"depName":"枢纽分公司","codeName":"19-19路"},{"lineCode":"20","lineName":"20路","depId":505,"depName":"营运一分公司","codeName":"20-20路"},{"lineCode":"21","lineName":"21路","depId":505,"depName":"营运一分公司","codeName":"21-21路"},{"lineCode":"22","lineName":"22路","depId":507,"depName":"枢纽分公司","codeName":"22-22路"},{"lineCode":"23","lineName":"23路","depId":506,"depName":"营运二分公司","codeName":"23-23路"},{"lineCode":"25","lineName":"25路","depId":506,"depName":"营运二分公司","codeName":"25-25路"},{"lineCode":"26","lineName":"26路","depId":507,"depName":"枢纽分公司","codeName":"26-26路"},{"lineCode":"27","lineName":"27路","depId":507,"depName":"枢纽分公司","codeName":"27-27路"},{"lineCode":"28","lineName":"28路","depId":505,"depName":"营运一分公司","codeName":"28-28路"},{"lineCode":"29","lineName":"29路","depId":506,"depName":"营运二分公司","codeName":"29-29路"},{"lineCode":"30","lineName":"30路","depId":506,"depName":"营运二分公司","codeName":"30-30路"},{"lineCode":"32","lineName":"32路","depId":505,"depName":"营运一分公司","codeName":"32-32路"},{"lineCode":"33","lineName":"33路","depId":505,"depName":"营运一分公司","codeName":"33-33路"},{"lineCode":"35","lineName":"35路","depId":505,"depName":"营运一分公司","codeName":"35-35路"},{"lineCode":"70","lineName":"7外线","depId":507,"depName":"枢纽分公司","codeName":"70-7外线"},{"lineCode":"71","lineName":"7内线","depId":507,"depName":"枢纽分公司","codeName":"71-7内线"},{"lineCode":"91","lineName":"9内线","depId":507,"depName":"枢纽分公司","codeName":"91-9内线"},{"lineCode":"92","lineName":"9外线","depId":507,"depName":"枢纽分公司","codeName":"92-9外线"},{"lineCode":"112","lineName":"112路","depId":506,"depName":"营运二分公司","codeName":"112-112路"},{"lineCode":"115","lineName":"115路","depId":506,"depName":"营运二分公司","codeName":"115-115路"},{"lineCode":"116","lineName":"116路","depId":506,"depName":"营运二分公司","codeName":"116-116路"},{"lineCode":"118","lineName":"118路","depId":506,"depName":"营运二分公司","codeName":"118-118路"},{"lineCode":"190","lineName":"506路","depId":505,"depName":"营运一分公司","codeName":"190-506路"},{"lineCode":"193","lineName":"经2线","depId":505,"depName":"营运一分公司","codeName":"193-经2线"},{"lineCode":"194","lineName":"经3线","depId":505,"depName":"营运一分公司","codeName":"194-经3线"},{"lineCode":"197","lineName":"36路","depId":505,"depName":"营运一分公司","codeName":"197-36路"},{"lineCode":"210","lineName":"31路","depId":505,"depName":"营运一分公司","codeName":"210-31路"},{"lineCode":"301","lineName":"机场专线","depId":507,"depName":"枢纽分公司","codeName":"301-机场专线"},{"lineCode":"605","lineName":"605路","depId":505,"depName":"营运一分公司","codeName":"605-605路"},{"lineCode":"663","lineName":"601","depId":506,"depName":"营运二分公司","codeName":"663-601"},{"lineCode":"664","lineName":"602","depId":506,"depName":"营运二分公司","codeName":"664-602"},{"lineCode":"665","lineName":"603","depId":506,"depName":"营运二分公司","codeName":"665-603"},{"lineCode":"1111","lineName":"一分公司机动","depId":505,"depName":"营运一分公司","codeName":"1111-一分公司机动"},{"lineCode":"2222","lineName":"二分公司机动","depId":506,"depName":"营运二分公司","codeName":"2222-二分公司机动"},{"lineCode":"3333","lineName":"三分公司机动","depId":507,"depName":"枢纽分公司","codeName":"3333-三分公司机动"},{"lineCode":"4172","lineName":"17路","depId":507,"depName":"枢纽分公司","codeName":"4172-17路"},{"lineCode":"4404","lineName":"下线车","depId":505,"depName":"营运一分公司","codeName":"4404-下线车"},{"lineCode":"80001","lineName":"集团机动","depId":378,"depName":"宜春公交集团有限公司","codeName":"80001-集团机动"}]
     */

    private boolean success;
    private List<DataBean> data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * lineCode : 1
         * lineName : 1路
         * depId : 506
         * depName : 营运二分公司
         * codeName : 1-1路
         */

        private String lineCode;
        private String lineName;
        private String depId;
        private String depName;
        private String codeName;

        public String getLineCode() {
            return lineCode;
        }

        public void setLineCode(String lineCode) {
            this.lineCode = lineCode;
        }

        public String getLineName() {
            return lineName;
        }

        public void setLineName(String lineName) {
            this.lineName = lineName;
        }

        public String getDepId() {
            return depId;
        }

        public void setDepId(String depId) {
            this.depId = depId;
        }

        public String getDepName() {
            return depName;
        }

        public void setDepName(String depName) {
            this.depName = depName;
        }

        public String getCodeName() {
            return codeName;
        }

        public void setCodeName(String codeName) {
            this.codeName = codeName;
        }
    }
}
