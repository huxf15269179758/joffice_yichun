package com.hy.powerplatform.oa_flow.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by dell on 2018/6/5.
 */

public class FlowItem implements Serializable{

    /**
     * success : true
     * data : [{"version":null,"orgId":null,"orgPath":null,"id":4,"moduleName":"事故管理","moduleStatus":"0","modulePower":"晋中公交","moduleCode":"SGGL"},{"version":null,"orgId":null,"orgPath":null,"id":6,"moduleName":"签到","moduleStatus":"0","modulePower":"晋中公交,主管部门,经理层,财务部门,财务科,信息中心,监控中心,IC卡销售中心,结算中心,人力资源部,行政部门,办公室,人力资源企划部,行政科,服务队,运调科,安全科,企划宣传部,监察室,维修部门,修理后勤,修理车间,维修中心,生产部门,运营一队后勤,运营二队后勤,运营三队后勤,高校队后勤,运营五队后勤,运营六队后勤,其他部门,其他人员,后勤人员,运营部门,运营一队,运营二队,运营三队,高校队,运营五队,运营六队","moduleCode":"QD"}]
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

    public static class DataBean implements Serializable{
        /**
         * version : null
         * orgId : null
         * orgPath : null
         * id : 4
         * moduleName : 事故管理
         * moduleStatus : 0
         * modulePower : 晋中公交
         * moduleCode : SGGL
         */

        private Object version;
        private Object orgId;
        private Object orgPath;
        private int id;
        private String moduleName;
        private String moduleStatus;
        private String modulePower;
        private String moduleCode;

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

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getModuleName() {
            return moduleName;
        }

        public void setModuleName(String moduleName) {
            this.moduleName = moduleName;
        }

        public String getModuleStatus() {
            return moduleStatus;
        }

        public void setModuleStatus(String moduleStatus) {
            this.moduleStatus = moduleStatus;
        }

        public String getModulePower() {
            return modulePower;
        }

        public void setModulePower(String modulePower) {
            this.modulePower = modulePower;
        }

        public String getModuleCode() {
            return moduleCode;
        }

        public void setModuleCode(String moduleCode) {
            this.moduleCode = moduleCode;
        }
    }
}
