package com.hy.powerplatform.phone.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by dell on 2018/6/12.
 */

public class Phone implements Serializable {

    /**
     * success : true
     * totalCounts : 1
     * result : [{"version":null,"orgId":null,"orgPath":null,"phoneId":4,"fullname":"hu","title":"先生","birthday":null,"nickName":null,"duty":null,"spouse":null,"childs":null,"companyName":null,"companyAddress":null,"companyPhone":null,"companyFax":null,"homeAddress":null,"homeZip":null,"mobile":"15269179759","phone":"","email":"914@qq.com","qqNumber":"","msn":"","note":null,"isShared":1,"appUser":{"version":null,"orgId":null,"orgPath":null,"userId":1,"username":"admin","email":"sdhy@163.com","jobId":640,"phone":"","mobile":"","fax":"","address":"","zip":"","photo":"myDesktop/profile/201611/ed6a3910859745b4a9f97f1821416f7d.png","accessionTime":"2009-12-18","status":1,"education":null,"title":1,"fullname":"超级管理员","delFlag":0,"dynamicPwd":null,"dyPwdStatus":null,"depNames":"信息中心","posNames":"科员","roleNames":"超级管理员","primaryDep":"信息中心","department":{"version":null,"orgId":null,"orgPath":null,"depId":389,"depName":"信息中心","depDesc":"","depLevel":2,"parentId":378,"path":"0.378.389.","orgType":2,"creatorId":1,"createtime":"2016-03-16 09:23:20","updateId":1,"updatetime":"2017-05-18 12:45:34","sn":null,"chargeIds":"","chargeNames":"","demension":{"version":null,"orgId":null,"orgPath":null,"demId":1,"demName":"行政维度","demDesc":"行政维度","demType":1}},"company":null,"czykh":null,"id":"1","enabled":true,"familyName":"超级管理员","supperManage":true,"givenName":"超级管理员","firstKeyColumnName":"userId","functionRights":"","superAdmin":true,"businessEmail":"sdhy@163.com","credentialsNonExpired":true,"accountNonLocked":true,"authorities":[{"version":null,"orgId":null,"orgPath":null,"roleId":-1,"roleName":"超级管理员","roleDesc":"超级管理员,具有所有权限","status":1,"isDefaultIn":0,"rights":"__ALL","name":"超级管理员","id":"-1","type":"candidate","authority":"超级管理员"},{"authority":"ROLE_PUBLIC"}],"accountNonExpired":true,"validTopModules":{}},"phoneGroup":{"version":null,"orgId":null,"orgPath":null,"groupId":2,"groupName":"信息中心","isShared":0,"sn":1,"isPublic":1,"appUser":{"version":null,"orgId":null,"orgPath":null,"userId":1,"username":"admin","email":"sdhy@163.com","jobId":640,"phone":"","mobile":"","fax":"","address":"","zip":"","photo":"myDesktop/profile/201611/ed6a3910859745b4a9f97f1821416f7d.png","accessionTime":"2009-12-18","status":1,"education":null,"title":1,"fullname":"超级管理员","delFlag":0,"dynamicPwd":null,"dyPwdStatus":null,"depNames":"信息中心","posNames":"科员","roleNames":"超级管理员","primaryDep":"信息中心","department":{"version":null,"orgId":null,"orgPath":null,"depId":389,"depName":"信息中心","depDesc":"","depLevel":2,"parentId":378,"path":"0.378.389.","orgType":2,"creatorId":1,"createtime":"2016-03-16 09:23:20","updateId":1,"updatetime":"2017-05-18 12:45:34","sn":null,"chargeIds":"","chargeNames":"","demension":{"version":null,"orgId":null,"orgPath":null,"demId":1,"demName":"行政维度","demDesc":"行政维度","demType":1}},"company":null,"czykh":null,"id":"1","enabled":true,"familyName":"超级管理员","supperManage":true,"givenName":"超级管理员","firstKeyColumnName":"userId","functionRights":"","superAdmin":true,"businessEmail":"sdhy@163.com","credentialsNonExpired":true,"accountNonLocked":true,"authorities":[{"version":null,"orgId":null,"orgPath":null,"roleId":-1,"roleName":"超级管理员","roleDesc":"超级管理员,具有所有权限","status":1,"isDefaultIn":0,"rights":"__ALL","name":"超级管理员","id":"-1","type":"candidate","authority":"超级管理员"},{"authority":"ROLE_PUBLIC"}],"accountNonExpired":true,"validTopModules":{}},"id":2,"userId":1,"firstKeyColumnName":"groupId"},"id":4,"userId":1,"groupId":2,"firstKeyColumnName":"phoneId"}]
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

    public static class ResultBean implements Serializable{
        /**
         * version : null
         * orgId : null
         * orgPath : null
         * phoneId : 4
         * fullname : hu
         * title : 先生
         * birthday : null
         * nickName : null
         * duty : null
         * spouse : null
         * childs : null
         * companyName : null
         * companyAddress : null
         * companyPhone : null
         * companyFax : null
         * homeAddress : null
         * homeZip : null
         * mobile : 15269179759
         * phone :
         * email : 914@qq.com
         * qqNumber :
         * msn :
         * note : null
         * isShared : 1
         * appUser : {"version":null,"orgId":null,"orgPath":null,"userId":1,"username":"admin","email":"sdhy@163.com","jobId":640,"phone":"","mobile":"","fax":"","address":"","zip":"","photo":"myDesktop/profile/201611/ed6a3910859745b4a9f97f1821416f7d.png","accessionTime":"2009-12-18","status":1,"education":null,"title":1,"fullname":"超级管理员","delFlag":0,"dynamicPwd":null,"dyPwdStatus":null,"depNames":"信息中心","posNames":"科员","roleNames":"超级管理员","primaryDep":"信息中心","department":{"version":null,"orgId":null,"orgPath":null,"depId":389,"depName":"信息中心","depDesc":"","depLevel":2,"parentId":378,"path":"0.378.389.","orgType":2,"creatorId":1,"createtime":"2016-03-16 09:23:20","updateId":1,"updatetime":"2017-05-18 12:45:34","sn":null,"chargeIds":"","chargeNames":"","demension":{"version":null,"orgId":null,"orgPath":null,"demId":1,"demName":"行政维度","demDesc":"行政维度","demType":1}},"company":null,"czykh":null,"id":"1","enabled":true,"familyName":"超级管理员","supperManage":true,"givenName":"超级管理员","firstKeyColumnName":"userId","functionRights":"","superAdmin":true,"businessEmail":"sdhy@163.com","credentialsNonExpired":true,"accountNonLocked":true,"authorities":[{"version":null,"orgId":null,"orgPath":null,"roleId":-1,"roleName":"超级管理员","roleDesc":"超级管理员,具有所有权限","status":1,"isDefaultIn":0,"rights":"__ALL","name":"超级管理员","id":"-1","type":"candidate","authority":"超级管理员"},{"authority":"ROLE_PUBLIC"}],"accountNonExpired":true,"validTopModules":{}}
         * phoneGroup : {"version":null,"orgId":null,"orgPath":null,"groupId":2,"groupName":"信息中心","isShared":0,"sn":1,"isPublic":1,"appUser":{"version":null,"orgId":null,"orgPath":null,"userId":1,"username":"admin","email":"sdhy@163.com","jobId":640,"phone":"","mobile":"","fax":"","address":"","zip":"","photo":"myDesktop/profile/201611/ed6a3910859745b4a9f97f1821416f7d.png","accessionTime":"2009-12-18","status":1,"education":null,"title":1,"fullname":"超级管理员","delFlag":0,"dynamicPwd":null,"dyPwdStatus":null,"depNames":"信息中心","posNames":"科员","roleNames":"超级管理员","primaryDep":"信息中心","department":{"version":null,"orgId":null,"orgPath":null,"depId":389,"depName":"信息中心","depDesc":"","depLevel":2,"parentId":378,"path":"0.378.389.","orgType":2,"creatorId":1,"createtime":"2016-03-16 09:23:20","updateId":1,"updatetime":"2017-05-18 12:45:34","sn":null,"chargeIds":"","chargeNames":"","demension":{"version":null,"orgId":null,"orgPath":null,"demId":1,"demName":"行政维度","demDesc":"行政维度","demType":1}},"company":null,"czykh":null,"id":"1","enabled":true,"familyName":"超级管理员","supperManage":true,"givenName":"超级管理员","firstKeyColumnName":"userId","functionRights":"","superAdmin":true,"businessEmail":"sdhy@163.com","credentialsNonExpired":true,"accountNonLocked":true,"authorities":[{"version":null,"orgId":null,"orgPath":null,"roleId":-1,"roleName":"超级管理员","roleDesc":"超级管理员,具有所有权限","status":1,"isDefaultIn":0,"rights":"__ALL","name":"超级管理员","id":"-1","type":"candidate","authority":"超级管理员"},{"authority":"ROLE_PUBLIC"}],"accountNonExpired":true,"validTopModules":{}},"id":2,"userId":1,"firstKeyColumnName":"groupId"}
         * id : 4
         * userId : 1
         * groupId : 2
         * firstKeyColumnName : phoneId
         */

        private Object version;
        private Object orgId;
        private Object orgPath;
        private int phoneId;
        private String fullname;
        private String title;
        private Object birthday;
        private Object nickName;
        private Object duty;
        private Object spouse;
        private Object childs;
        private Object companyName;
        private Object companyAddress;
        private Object companyPhone;
        private Object companyFax;
        private Object homeAddress;
        private Object homeZip;
        private String mobile;
        private String phone;
        private String email;
        private String qqNumber;
        private String msn;
        private Object note;
        private int isShared;
        private AppUserBean appUser;
        private PhoneGroupBean phoneGroup;
        private int id;
        private int userId;
        private int groupId;
        private String firstKeyColumnName;

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

        public int getPhoneId() {
            return phoneId;
        }

        public void setPhoneId(int phoneId) {
            this.phoneId = phoneId;
        }

        public String getFullname() {
            return fullname;
        }

        public void setFullname(String fullname) {
            this.fullname = fullname;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Object getBirthday() {
            return birthday;
        }

        public void setBirthday(Object birthday) {
            this.birthday = birthday;
        }

        public Object getNickName() {
            return nickName;
        }

        public void setNickName(Object nickName) {
            this.nickName = nickName;
        }

        public Object getDuty() {
            return duty;
        }

        public void setDuty(Object duty) {
            this.duty = duty;
        }

        public Object getSpouse() {
            return spouse;
        }

        public void setSpouse(Object spouse) {
            this.spouse = spouse;
        }

        public Object getChilds() {
            return childs;
        }

        public void setChilds(Object childs) {
            this.childs = childs;
        }

        public Object getCompanyName() {
            return companyName;
        }

        public void setCompanyName(Object companyName) {
            this.companyName = companyName;
        }

        public Object getCompanyAddress() {
            return companyAddress;
        }

        public void setCompanyAddress(Object companyAddress) {
            this.companyAddress = companyAddress;
        }

        public Object getCompanyPhone() {
            return companyPhone;
        }

        public void setCompanyPhone(Object companyPhone) {
            this.companyPhone = companyPhone;
        }

        public Object getCompanyFax() {
            return companyFax;
        }

        public void setCompanyFax(Object companyFax) {
            this.companyFax = companyFax;
        }

        public Object getHomeAddress() {
            return homeAddress;
        }

        public void setHomeAddress(Object homeAddress) {
            this.homeAddress = homeAddress;
        }

        public Object getHomeZip() {
            return homeZip;
        }

        public void setHomeZip(Object homeZip) {
            this.homeZip = homeZip;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getQqNumber() {
            return qqNumber;
        }

        public void setQqNumber(String qqNumber) {
            this.qqNumber = qqNumber;
        }

        public String getMsn() {
            return msn;
        }

        public void setMsn(String msn) {
            this.msn = msn;
        }

        public Object getNote() {
            return note;
        }

        public void setNote(Object note) {
            this.note = note;
        }

        public int getIsShared() {
            return isShared;
        }

        public void setIsShared(int isShared) {
            this.isShared = isShared;
        }

        public AppUserBean getAppUser() {
            return appUser;
        }

        public void setAppUser(AppUserBean appUser) {
            this.appUser = appUser;
        }

        public PhoneGroupBean getPhoneGroup() {
            return phoneGroup;
        }

        public void setPhoneGroup(PhoneGroupBean phoneGroup) {
            this.phoneGroup = phoneGroup;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getGroupId() {
            return groupId;
        }

        public void setGroupId(int groupId) {
            this.groupId = groupId;
        }

        public String getFirstKeyColumnName() {
            return firstKeyColumnName;
        }

        public void setFirstKeyColumnName(String firstKeyColumnName) {
            this.firstKeyColumnName = firstKeyColumnName;
        }

        public static class AppUserBean implements Serializable{
            /**
             * version : null
             * orgId : null
             * orgPath : null
             * userId : 1
             * username : admin
             * email : sdhy@163.com
             * jobId : 640
             * phone :
             * mobile :
             * fax :
             * address :
             * zip :
             * photo : myDesktop/profile/201611/ed6a3910859745b4a9f97f1821416f7d.png
             * accessionTime : 2009-12-18
             * status : 1
             * education : null
             * title : 1
             * fullname : 超级管理员
             * delFlag : 0
             * dynamicPwd : null
             * dyPwdStatus : null
             * depNames : 信息中心
             * posNames : 科员
             * roleNames : 超级管理员
             * primaryDep : 信息中心
             * department : {"version":null,"orgId":null,"orgPath":null,"depId":389,"depName":"信息中心","depDesc":"","depLevel":2,"parentId":378,"path":"0.378.389.","orgType":2,"creatorId":1,"createtime":"2016-03-16 09:23:20","updateId":1,"updatetime":"2017-05-18 12:45:34","sn":null,"chargeIds":"","chargeNames":"","demension":{"version":null,"orgId":null,"orgPath":null,"demId":1,"demName":"行政维度","demDesc":"行政维度","demType":1}}
             * company : null
             * czykh : null
             * id : 1
             * enabled : true
             * familyName : 超级管理员
             * supperManage : true
             * givenName : 超级管理员
             * firstKeyColumnName : userId
             * functionRights :
             * superAdmin : true
             * businessEmail : sdhy@163.com
             * credentialsNonExpired : true
             * accountNonLocked : true
             * authorities : [{"version":null,"orgId":null,"orgPath":null,"roleId":-1,"roleName":"超级管理员","roleDesc":"超级管理员,具有所有权限","status":1,"isDefaultIn":0,"rights":"__ALL","name":"超级管理员","id":"-1","type":"candidate","authority":"超级管理员"},{"authority":"ROLE_PUBLIC"}]
             * accountNonExpired : true
             * validTopModules : {}
             */

            private Object version;
            private Object orgId;
            private Object orgPath;
            private int userId;
            private String username;
            private String email;
            private int jobId;
            private String phone;
            private String mobile;
            private String fax;
            private String address;
            private String zip;
            private String photo;
            private String accessionTime;
            private int status;
            private Object education;
            private int title;
            private String fullname;
            private int delFlag;
            private Object dynamicPwd;
            private Object dyPwdStatus;
            private String depNames;
            private String posNames;
            private String roleNames;
            private String primaryDep;
            private DepartmentBean department;
            private Object company;
            private Object czykh;
            private String id;
            private boolean enabled;
            private String familyName;
            private boolean supperManage;
            private String givenName;
            private String firstKeyColumnName;
            private String functionRights;
            private boolean superAdmin;
            private String businessEmail;
            private boolean credentialsNonExpired;
            private boolean accountNonLocked;
            private boolean accountNonExpired;
            private ValidTopModulesBean validTopModules;
            private List<AuthoritiesBean> authorities;

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

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public int getJobId() {
                return jobId;
            }

            public void setJobId(int jobId) {
                this.jobId = jobId;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public String getFax() {
                return fax;
            }

            public void setFax(String fax) {
                this.fax = fax;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getZip() {
                return zip;
            }

            public void setZip(String zip) {
                this.zip = zip;
            }

            public String getPhoto() {
                return photo;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
            }

            public String getAccessionTime() {
                return accessionTime;
            }

            public void setAccessionTime(String accessionTime) {
                this.accessionTime = accessionTime;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public Object getEducation() {
                return education;
            }

            public void setEducation(Object education) {
                this.education = education;
            }

            public int getTitle() {
                return title;
            }

            public void setTitle(int title) {
                this.title = title;
            }

            public String getFullname() {
                return fullname;
            }

            public void setFullname(String fullname) {
                this.fullname = fullname;
            }

            public int getDelFlag() {
                return delFlag;
            }

            public void setDelFlag(int delFlag) {
                this.delFlag = delFlag;
            }

            public Object getDynamicPwd() {
                return dynamicPwd;
            }

            public void setDynamicPwd(Object dynamicPwd) {
                this.dynamicPwd = dynamicPwd;
            }

            public Object getDyPwdStatus() {
                return dyPwdStatus;
            }

            public void setDyPwdStatus(Object dyPwdStatus) {
                this.dyPwdStatus = dyPwdStatus;
            }

            public String getDepNames() {
                return depNames;
            }

            public void setDepNames(String depNames) {
                this.depNames = depNames;
            }

            public String getPosNames() {
                return posNames;
            }

            public void setPosNames(String posNames) {
                this.posNames = posNames;
            }

            public String getRoleNames() {
                return roleNames;
            }

            public void setRoleNames(String roleNames) {
                this.roleNames = roleNames;
            }

            public String getPrimaryDep() {
                return primaryDep;
            }

            public void setPrimaryDep(String primaryDep) {
                this.primaryDep = primaryDep;
            }

            public DepartmentBean getDepartment() {
                return department;
            }

            public void setDepartment(DepartmentBean department) {
                this.department = department;
            }

            public Object getCompany() {
                return company;
            }

            public void setCompany(Object company) {
                this.company = company;
            }

            public Object getCzykh() {
                return czykh;
            }

            public void setCzykh(Object czykh) {
                this.czykh = czykh;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public boolean isEnabled() {
                return enabled;
            }

            public void setEnabled(boolean enabled) {
                this.enabled = enabled;
            }

            public String getFamilyName() {
                return familyName;
            }

            public void setFamilyName(String familyName) {
                this.familyName = familyName;
            }

            public boolean isSupperManage() {
                return supperManage;
            }

            public void setSupperManage(boolean supperManage) {
                this.supperManage = supperManage;
            }

            public String getGivenName() {
                return givenName;
            }

            public void setGivenName(String givenName) {
                this.givenName = givenName;
            }

            public String getFirstKeyColumnName() {
                return firstKeyColumnName;
            }

            public void setFirstKeyColumnName(String firstKeyColumnName) {
                this.firstKeyColumnName = firstKeyColumnName;
            }

            public String getFunctionRights() {
                return functionRights;
            }

            public void setFunctionRights(String functionRights) {
                this.functionRights = functionRights;
            }

            public boolean isSuperAdmin() {
                return superAdmin;
            }

            public void setSuperAdmin(boolean superAdmin) {
                this.superAdmin = superAdmin;
            }

            public String getBusinessEmail() {
                return businessEmail;
            }

            public void setBusinessEmail(String businessEmail) {
                this.businessEmail = businessEmail;
            }

            public boolean isCredentialsNonExpired() {
                return credentialsNonExpired;
            }

            public void setCredentialsNonExpired(boolean credentialsNonExpired) {
                this.credentialsNonExpired = credentialsNonExpired;
            }

            public boolean isAccountNonLocked() {
                return accountNonLocked;
            }

            public void setAccountNonLocked(boolean accountNonLocked) {
                this.accountNonLocked = accountNonLocked;
            }

            public boolean isAccountNonExpired() {
                return accountNonExpired;
            }

            public void setAccountNonExpired(boolean accountNonExpired) {
                this.accountNonExpired = accountNonExpired;
            }

            public ValidTopModulesBean getValidTopModules() {
                return validTopModules;
            }

            public void setValidTopModules(ValidTopModulesBean validTopModules) {
                this.validTopModules = validTopModules;
            }

            public List<AuthoritiesBean> getAuthorities() {
                return authorities;
            }

            public void setAuthorities(List<AuthoritiesBean> authorities) {
                this.authorities = authorities;
            }

            public static class DepartmentBean {
                public static class DemensionBean {
                }
            }

            public static class ValidTopModulesBean {
            }

            public static class AuthoritiesBean implements Serializable{
                /**
                 * version : null
                 * orgId : null
                 * orgPath : null
                 * roleId : -1
                 * roleName : 超级管理员
                 * roleDesc : 超级管理员,具有所有权限
                 * status : 1
                 * isDefaultIn : 0
                 * rights : __ALL
                 * name : 超级管理员
                 * id : -1
                 * type : candidate
                 * authority : 超级管理员
                 */

                private Object version;
                private Object orgId;
                private Object orgPath;
                private int roleId;
                private String roleName;
                private String roleDesc;
                private int status;
                private int isDefaultIn;
                private String rights;
                private String name;
                private String id;
                private String type;
                private String authority;

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

                public int getRoleId() {
                    return roleId;
                }

                public void setRoleId(int roleId) {
                    this.roleId = roleId;
                }

                public String getRoleName() {
                    return roleName;
                }

                public void setRoleName(String roleName) {
                    this.roleName = roleName;
                }

                public String getRoleDesc() {
                    return roleDesc;
                }

                public void setRoleDesc(String roleDesc) {
                    this.roleDesc = roleDesc;
                }

                public int getStatus() {
                    return status;
                }

                public void setStatus(int status) {
                    this.status = status;
                }

                public int getIsDefaultIn() {
                    return isDefaultIn;
                }

                public void setIsDefaultIn(int isDefaultIn) {
                    this.isDefaultIn = isDefaultIn;
                }

                public String getRights() {
                    return rights;
                }

                public void setRights(String rights) {
                    this.rights = rights;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public String getAuthority() {
                    return authority;
                }

                public void setAuthority(String authority) {
                    this.authority = authority;
                }
            }
        }

        public static class PhoneGroupBean implements Serializable{
            /**
             * version : null
             * orgId : null
             * orgPath : null
             * groupId : 2
             * groupName : 信息中心
             * isShared : 0
             * sn : 1
             * isPublic : 1
             * appUser : {"version":null,"orgId":null,"orgPath":null,"userId":1,"username":"admin","email":"sdhy@163.com","jobId":640,"phone":"","mobile":"","fax":"","address":"","zip":"","photo":"myDesktop/profile/201611/ed6a3910859745b4a9f97f1821416f7d.png","accessionTime":"2009-12-18","status":1,"education":null,"title":1,"fullname":"超级管理员","delFlag":0,"dynamicPwd":null,"dyPwdStatus":null,"depNames":"信息中心","posNames":"科员","roleNames":"超级管理员","primaryDep":"信息中心","department":{"version":null,"orgId":null,"orgPath":null,"depId":389,"depName":"信息中心","depDesc":"","depLevel":2,"parentId":378,"path":"0.378.389.","orgType":2,"creatorId":1,"createtime":"2016-03-16 09:23:20","updateId":1,"updatetime":"2017-05-18 12:45:34","sn":null,"chargeIds":"","chargeNames":"","demension":{"version":null,"orgId":null,"orgPath":null,"demId":1,"demName":"行政维度","demDesc":"行政维度","demType":1}},"company":null,"czykh":null,"id":"1","enabled":true,"familyName":"超级管理员","supperManage":true,"givenName":"超级管理员","firstKeyColumnName":"userId","functionRights":"","superAdmin":true,"businessEmail":"sdhy@163.com","credentialsNonExpired":true,"accountNonLocked":true,"authorities":[{"version":null,"orgId":null,"orgPath":null,"roleId":-1,"roleName":"超级管理员","roleDesc":"超级管理员,具有所有权限","status":1,"isDefaultIn":0,"rights":"__ALL","name":"超级管理员","id":"-1","type":"candidate","authority":"超级管理员"},{"authority":"ROLE_PUBLIC"}],"accountNonExpired":true,"validTopModules":{}}
             * id : 2
             * userId : 1
             * firstKeyColumnName : groupId
             */

            private Object version;
            private Object orgId;
            private Object orgPath;
            private int groupId;
            private String groupName;
            private int isShared;
            private int sn;
            private int isPublic;
            private AppUserBeanX appUser;
            private int id;
            private int userId;
            private String firstKeyColumnName;

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

            public int getGroupId() {
                return groupId;
            }

            public void setGroupId(int groupId) {
                this.groupId = groupId;
            }

            public String getGroupName() {
                return groupName;
            }

            public void setGroupName(String groupName) {
                this.groupName = groupName;
            }

            public int getIsShared() {
                return isShared;
            }

            public void setIsShared(int isShared) {
                this.isShared = isShared;
            }

            public int getSn() {
                return sn;
            }

            public void setSn(int sn) {
                this.sn = sn;
            }

            public int getIsPublic() {
                return isPublic;
            }

            public void setIsPublic(int isPublic) {
                this.isPublic = isPublic;
            }

            public AppUserBeanX getAppUser() {
                return appUser;
            }

            public void setAppUser(AppUserBeanX appUser) {
                this.appUser = appUser;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public String getFirstKeyColumnName() {
                return firstKeyColumnName;
            }

            public void setFirstKeyColumnName(String firstKeyColumnName) {
                this.firstKeyColumnName = firstKeyColumnName;
            }

            public static class AppUserBeanX implements Serializable {
                /**
                 * version : null
                 * orgId : null
                 * orgPath : null
                 * userId : 1
                 * username : admin
                 * email : sdhy@163.com
                 * jobId : 640
                 * phone :
                 * mobile :
                 * fax :
                 * address :
                 * zip :
                 * photo : myDesktop/profile/201611/ed6a3910859745b4a9f97f1821416f7d.png
                 * accessionTime : 2009-12-18
                 * status : 1
                 * education : null
                 * title : 1
                 * fullname : 超级管理员
                 * delFlag : 0
                 * dynamicPwd : null
                 * dyPwdStatus : null
                 * depNames : 信息中心
                 * posNames : 科员
                 * roleNames : 超级管理员
                 * primaryDep : 信息中心
                 * department : {"version":null,"orgId":null,"orgPath":null,"depId":389,"depName":"信息中心","depDesc":"","depLevel":2,"parentId":378,"path":"0.378.389.","orgType":2,"creatorId":1,"createtime":"2016-03-16 09:23:20","updateId":1,"updatetime":"2017-05-18 12:45:34","sn":null,"chargeIds":"","chargeNames":"","demension":{"version":null,"orgId":null,"orgPath":null,"demId":1,"demName":"行政维度","demDesc":"行政维度","demType":1}}
                 * company : null
                 * czykh : null
                 * id : 1
                 * enabled : true
                 * familyName : 超级管理员
                 * supperManage : true
                 * givenName : 超级管理员
                 * firstKeyColumnName : userId
                 * functionRights :
                 * superAdmin : true
                 * businessEmail : sdhy@163.com
                 * credentialsNonExpired : true
                 * accountNonLocked : true
                 * authorities : [{"version":null,"orgId":null,"orgPath":null,"roleId":-1,"roleName":"超级管理员","roleDesc":"超级管理员,具有所有权限","status":1,"isDefaultIn":0,"rights":"__ALL","name":"超级管理员","id":"-1","type":"candidate","authority":"超级管理员"},{"authority":"ROLE_PUBLIC"}]
                 * accountNonExpired : true
                 * validTopModules : {}
                 */

                private Object version;
                private Object orgId;
                private Object orgPath;
                private int userId;
                private String username;
                private String email;
                private int jobId;
                private String phone;
                private String mobile;
                private String fax;
                private String address;
                private String zip;
                private String photo;
                private String accessionTime;
                private int status;
                private Object education;
                private int title;
                private String fullname;
                private int delFlag;
                private Object dynamicPwd;
                private Object dyPwdStatus;
                private String depNames;
                private String posNames;
                private String roleNames;
                private String primaryDep;
                private DepartmentBeanX department;
                private Object company;
                private Object czykh;
                private String id;
                private boolean enabled;
                private String familyName;
                private boolean supperManage;
                private String givenName;
                private String firstKeyColumnName;
                private String functionRights;
                private boolean superAdmin;
                private String businessEmail;
                private boolean credentialsNonExpired;
                private boolean accountNonLocked;
                private boolean accountNonExpired;
                private ValidTopModulesBeanX validTopModules;
                private List<AuthoritiesBeanX> authorities;

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

                public int getUserId() {
                    return userId;
                }

                public void setUserId(int userId) {
                    this.userId = userId;
                }

                public String getUsername() {
                    return username;
                }

                public void setUsername(String username) {
                    this.username = username;
                }

                public String getEmail() {
                    return email;
                }

                public void setEmail(String email) {
                    this.email = email;
                }

                public int getJobId() {
                    return jobId;
                }

                public void setJobId(int jobId) {
                    this.jobId = jobId;
                }

                public String getPhone() {
                    return phone;
                }

                public void setPhone(String phone) {
                    this.phone = phone;
                }

                public String getMobile() {
                    return mobile;
                }

                public void setMobile(String mobile) {
                    this.mobile = mobile;
                }

                public String getFax() {
                    return fax;
                }

                public void setFax(String fax) {
                    this.fax = fax;
                }

                public String getAddress() {
                    return address;
                }

                public void setAddress(String address) {
                    this.address = address;
                }

                public String getZip() {
                    return zip;
                }

                public void setZip(String zip) {
                    this.zip = zip;
                }

                public String getPhoto() {
                    return photo;
                }

                public void setPhoto(String photo) {
                    this.photo = photo;
                }

                public String getAccessionTime() {
                    return accessionTime;
                }

                public void setAccessionTime(String accessionTime) {
                    this.accessionTime = accessionTime;
                }

                public int getStatus() {
                    return status;
                }

                public void setStatus(int status) {
                    this.status = status;
                }

                public Object getEducation() {
                    return education;
                }

                public void setEducation(Object education) {
                    this.education = education;
                }

                public int getTitle() {
                    return title;
                }

                public void setTitle(int title) {
                    this.title = title;
                }

                public String getFullname() {
                    return fullname;
                }

                public void setFullname(String fullname) {
                    this.fullname = fullname;
                }

                public int getDelFlag() {
                    return delFlag;
                }

                public void setDelFlag(int delFlag) {
                    this.delFlag = delFlag;
                }

                public Object getDynamicPwd() {
                    return dynamicPwd;
                }

                public void setDynamicPwd(Object dynamicPwd) {
                    this.dynamicPwd = dynamicPwd;
                }

                public Object getDyPwdStatus() {
                    return dyPwdStatus;
                }

                public void setDyPwdStatus(Object dyPwdStatus) {
                    this.dyPwdStatus = dyPwdStatus;
                }

                public String getDepNames() {
                    return depNames;
                }

                public void setDepNames(String depNames) {
                    this.depNames = depNames;
                }

                public String getPosNames() {
                    return posNames;
                }

                public void setPosNames(String posNames) {
                    this.posNames = posNames;
                }

                public String getRoleNames() {
                    return roleNames;
                }

                public void setRoleNames(String roleNames) {
                    this.roleNames = roleNames;
                }

                public String getPrimaryDep() {
                    return primaryDep;
                }

                public void setPrimaryDep(String primaryDep) {
                    this.primaryDep = primaryDep;
                }

                public DepartmentBeanX getDepartment() {
                    return department;
                }

                public void setDepartment(DepartmentBeanX department) {
                    this.department = department;
                }

                public Object getCompany() {
                    return company;
                }

                public void setCompany(Object company) {
                    this.company = company;
                }

                public Object getCzykh() {
                    return czykh;
                }

                public void setCzykh(Object czykh) {
                    this.czykh = czykh;
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public boolean isEnabled() {
                    return enabled;
                }

                public void setEnabled(boolean enabled) {
                    this.enabled = enabled;
                }

                public String getFamilyName() {
                    return familyName;
                }

                public void setFamilyName(String familyName) {
                    this.familyName = familyName;
                }

                public boolean isSupperManage() {
                    return supperManage;
                }

                public void setSupperManage(boolean supperManage) {
                    this.supperManage = supperManage;
                }

                public String getGivenName() {
                    return givenName;
                }

                public void setGivenName(String givenName) {
                    this.givenName = givenName;
                }

                public String getFirstKeyColumnName() {
                    return firstKeyColumnName;
                }

                public void setFirstKeyColumnName(String firstKeyColumnName) {
                    this.firstKeyColumnName = firstKeyColumnName;
                }

                public String getFunctionRights() {
                    return functionRights;
                }

                public void setFunctionRights(String functionRights) {
                    this.functionRights = functionRights;
                }

                public boolean isSuperAdmin() {
                    return superAdmin;
                }

                public void setSuperAdmin(boolean superAdmin) {
                    this.superAdmin = superAdmin;
                }

                public String getBusinessEmail() {
                    return businessEmail;
                }

                public void setBusinessEmail(String businessEmail) {
                    this.businessEmail = businessEmail;
                }

                public boolean isCredentialsNonExpired() {
                    return credentialsNonExpired;
                }

                public void setCredentialsNonExpired(boolean credentialsNonExpired) {
                    this.credentialsNonExpired = credentialsNonExpired;
                }

                public boolean isAccountNonLocked() {
                    return accountNonLocked;
                }

                public void setAccountNonLocked(boolean accountNonLocked) {
                    this.accountNonLocked = accountNonLocked;
                }

                public boolean isAccountNonExpired() {
                    return accountNonExpired;
                }

                public void setAccountNonExpired(boolean accountNonExpired) {
                    this.accountNonExpired = accountNonExpired;
                }

                public ValidTopModulesBeanX getValidTopModules() {
                    return validTopModules;
                }

                public void setValidTopModules(ValidTopModulesBeanX validTopModules) {
                    this.validTopModules = validTopModules;
                }

                public List<AuthoritiesBeanX> getAuthorities() {
                    return authorities;
                }

                public void setAuthorities(List<AuthoritiesBeanX> authorities) {
                    this.authorities = authorities;
                }

                public static class DepartmentBeanX {
                    public static class DemensionBeanX {
                    }
                }

                public static class ValidTopModulesBeanX {
                }

                public static class AuthoritiesBeanX implements Serializable{
                    /**
                     * version : null
                     * orgId : null
                     * orgPath : null
                     * roleId : -1
                     * roleName : 超级管理员
                     * roleDesc : 超级管理员,具有所有权限
                     * status : 1
                     * isDefaultIn : 0
                     * rights : __ALL
                     * name : 超级管理员
                     * id : -1
                     * type : candidate
                     * authority : 超级管理员
                     */

                    private Object version;
                    private Object orgId;
                    private Object orgPath;
                    private int roleId;
                    private String roleName;
                    private String roleDesc;
                    private int status;
                    private int isDefaultIn;
                    private String rights;
                    private String name;
                    private String id;
                    private String type;
                    private String authority;

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

                    public int getRoleId() {
                        return roleId;
                    }

                    public void setRoleId(int roleId) {
                        this.roleId = roleId;
                    }

                    public String getRoleName() {
                        return roleName;
                    }

                    public void setRoleName(String roleName) {
                        this.roleName = roleName;
                    }

                    public String getRoleDesc() {
                        return roleDesc;
                    }

                    public void setRoleDesc(String roleDesc) {
                        this.roleDesc = roleDesc;
                    }

                    public int getStatus() {
                        return status;
                    }

                    public void setStatus(int status) {
                        this.status = status;
                    }

                    public int getIsDefaultIn() {
                        return isDefaultIn;
                    }

                    public void setIsDefaultIn(int isDefaultIn) {
                        this.isDefaultIn = isDefaultIn;
                    }

                    public String getRights() {
                        return rights;
                    }

                    public void setRights(String rights) {
                        this.rights = rights;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public String getId() {
                        return id;
                    }

                    public void setId(String id) {
                        this.id = id;
                    }

                    public String getType() {
                        return type;
                    }

                    public void setType(String type) {
                        this.type = type;
                    }

                    public String getAuthority() {
                        return authority;
                    }

                    public void setAuthority(String authority) {
                        this.authority = authority;
                    }
                }
            }
        }
    }
}
