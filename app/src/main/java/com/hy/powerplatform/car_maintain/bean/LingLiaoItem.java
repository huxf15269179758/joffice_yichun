package com.hy.powerplatform.car_maintain.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/11/22.
 */

public class LingLiaoItem implements Serializable {

    /**
     * success : true
     * data : [{"base":{"id":12017,"memo":"测试","measureBusNo":"A2018103171732","workerCode":"40874,40893","workerName":"黄烈武,李清万","mile":"0","carNo":"赣C02113D","busCode":"100","busmaker":"undefined","bustypeCode":"undefined","driverCode":"undefined","driverName":"蔡韧","enterDate":"2018-10-31","enterTime":"17:43:47","measurePlace":"枢纽站维修厂","measureChejian":"总站维修车间","checkCode":"1322","checkName":"测试","inputPersonName":"蔡韧","lineCode":"12","repairCategory":"回厂小修","repairAddress":"测试","repatrPrePhoto":"","depName":"枢纽分公司","repairTeam":"测试班组","repaireResult":"测试完成","repaireMemo":"测试","materialPrice":0,"repairPrice":0,"checkMoneyStatus":2,"materialType":"单燃料"}},{"project":[{"proId":15584,"proName":"车载显示器 -拆装","proCode":"","proNo":"2655","planTime":"2","planPrice":"20","useTime":"2","usePrice":"20","proMoney":"0.0","money":0,"safe":1,"gsNumber":"1"}]},{"stock":[{"applyId":27239,"materialTypeName":"轮胎","materialDataName":"17年8米纯电备胎","materialDataId":3155,"ver":"","applyNo":"CKD2018110100001","appType":2,"appStatus":1,"unitprice":231,"outprice":231,"je":231,"num":1,"brand":"","houseId":112,"houseName":"总公司仓库","materialName":"轮胎","materialCode":"LT","materialId":24323,"supplier":"湖南东城服饰有限公司（宜春分公司）","materialNum":"1","houseArea":"测试11","uint":"条","inclusive":267.96,"kc":1210}]}]
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

    public static class DataBean implements Serializable {
        /**
         * base : {"id":12017,"memo":"测试","measureBusNo":"A2018103171732","workerCode":"40874,40893","workerName":"黄烈武,李清万","mile":"0","carNo":"赣C02113D","busCode":"100","busmaker":"undefined","bustypeCode":"undefined","driverCode":"undefined","driverName":"蔡韧","enterDate":"2018-10-31","enterTime":"17:43:47","measurePlace":"枢纽站维修厂","measureChejian":"总站维修车间","checkCode":"1322","checkName":"测试","inputPersonName":"蔡韧","lineCode":"12","repairCategory":"回厂小修","repairAddress":"测试","repatrPrePhoto":"","depName":"枢纽分公司","repairTeam":"测试班组","repaireResult":"测试完成","repaireMemo":"测试","materialPrice":0,"repairPrice":0,"checkMoneyStatus":2,"materialType":"单燃料"}
         * project : [{"proId":15584,"proName":"车载显示器 -拆装","proCode":"","proNo":"2655","planTime":"2","planPrice":"20","useTime":"2","usePrice":"20","proMoney":"0.0","money":0,"safe":1,"gsNumber":"1"}]
         * stock : [{"applyId":27239,"materialTypeName":"轮胎","materialDataName":"17年8米纯电备胎","materialDataId":3155,"ver":"","applyNo":"CKD2018110100001","appType":2,"appStatus":1,"unitprice":231,"outprice":231,"je":231,"num":1,"brand":"","houseId":112,"houseName":"总公司仓库","materialName":"轮胎","materialCode":"LT","materialId":24323,"supplier":"湖南东城服饰有限公司（宜春分公司）","materialNum":"1","houseArea":"测试11","uint":"条","inclusive":267.96,"kc":1210}]
         */

        private BaseBean base;
        private List<ProjectBean> project;
        private List<StockBean> stock;

        public BaseBean getBase() {
            return base;
        }

        public void setBase(BaseBean base) {
            this.base = base;
        }

        public List<ProjectBean> getProject() {
            return project;
        }

        public void setProject(List<ProjectBean> project) {
            this.project = project;
        }

        public List<StockBean> getStock() {
            return stock;
        }

        public void setStock(List<StockBean> stock) {
            this.stock = stock;
        }

        public static class BaseBean implements Serializable {
            /**
             * id : 12017
             * memo : 测试
             * measureBusNo : A2018103171732
             * workerCode : 40874,40893
             * workerName : 黄烈武,李清万
             * mile : 0
             * carNo : 赣C02113D
             * busCode : 100
             * busmaker : undefined
             * bustypeCode : undefined
             * driverCode : undefined
             * driverName : 蔡韧
             * enterDate : 2018-10-31
             * enterTime : 17:43:47
             * measurePlace : 枢纽站维修厂
             * measureChejian : 总站维修车间
             * checkCode : 1322
             * checkName : 测试
             * inputPersonName : 蔡韧
             * lineCode : 12
             * repairCategory : 回厂小修
             * repairAddress : 测试
             * repatrPrePhoto :
             * depName : 枢纽分公司
             * repairTeam : 测试班组
             * repaireResult : 测试完成
             * repaireMemo : 测试
             * materialPrice : 0.0
             * repairPrice : 0.0
             * checkMoneyStatus : 2
             * materialType : 单燃料
             */

            private int id;
            private String memo;
            private String measureBusNo;
            private String workerCode;
            private String workerName;
            private String mile;
            private String carNo;
            private String busCode;
            private String busmaker;
            private String bustypeCode;
            private String driverCode;
            private String driverName;
            private String enterDate;
            private String enterTime;
            private String measurePlace;
            private String measureChejian;
            private String checkCode;
            private String checkName;
            private String inputPersonName;
            private String lineCode;
            private String repairCategory;
            private String repairAddress;
            private String repatrPrePhoto;
            private String depName;
            private String repairTeam;
            private String repaireResult;
            private String repaireMemo;
            private double materialPrice;
            private double repairPrice;
            private int checkMoneyStatus;
            private String materialType;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getMemo() {
                return memo;
            }

            public void setMemo(String memo) {
                this.memo = memo;
            }

            public String getMeasureBusNo() {
                return measureBusNo;
            }

            public void setMeasureBusNo(String measureBusNo) {
                this.measureBusNo = measureBusNo;
            }

            public String getWorkerCode() {
                return workerCode;
            }

            public void setWorkerCode(String workerCode) {
                this.workerCode = workerCode;
            }

            public String getWorkerName() {
                return workerName;
            }

            public void setWorkerName(String workerName) {
                this.workerName = workerName;
            }

            public String getMile() {
                return mile;
            }

            public void setMile(String mile) {
                this.mile = mile;
            }

            public String getCarNo() {
                return carNo;
            }

            public void setCarNo(String carNo) {
                this.carNo = carNo;
            }

            public String getBusCode() {
                return busCode;
            }

            public void setBusCode(String busCode) {
                this.busCode = busCode;
            }

            public String getBusmaker() {
                return busmaker;
            }

            public void setBusmaker(String busmaker) {
                this.busmaker = busmaker;
            }

            public String getBustypeCode() {
                return bustypeCode;
            }

            public void setBustypeCode(String bustypeCode) {
                this.bustypeCode = bustypeCode;
            }

            public String getDriverCode() {
                return driverCode;
            }

            public void setDriverCode(String driverCode) {
                this.driverCode = driverCode;
            }

            public String getDriverName() {
                return driverName;
            }

            public void setDriverName(String driverName) {
                this.driverName = driverName;
            }

            public String getEnterDate() {
                return enterDate;
            }

            public void setEnterDate(String enterDate) {
                this.enterDate = enterDate;
            }

            public String getEnterTime() {
                return enterTime;
            }

            public void setEnterTime(String enterTime) {
                this.enterTime = enterTime;
            }

            public String getMeasurePlace() {
                return measurePlace;
            }

            public void setMeasurePlace(String measurePlace) {
                this.measurePlace = measurePlace;
            }

            public String getMeasureChejian() {
                return measureChejian;
            }

            public void setMeasureChejian(String measureChejian) {
                this.measureChejian = measureChejian;
            }

            public String getCheckCode() {
                return checkCode;
            }

            public void setCheckCode(String checkCode) {
                this.checkCode = checkCode;
            }

            public String getCheckName() {
                return checkName;
            }

            public void setCheckName(String checkName) {
                this.checkName = checkName;
            }

            public String getInputPersonName() {
                return inputPersonName;
            }

            public void setInputPersonName(String inputPersonName) {
                this.inputPersonName = inputPersonName;
            }

            public String getLineCode() {
                return lineCode;
            }

            public void setLineCode(String lineCode) {
                this.lineCode = lineCode;
            }

            public String getRepairCategory() {
                return repairCategory;
            }

            public void setRepairCategory(String repairCategory) {
                this.repairCategory = repairCategory;
            }

            public String getRepairAddress() {
                return repairAddress;
            }

            public void setRepairAddress(String repairAddress) {
                this.repairAddress = repairAddress;
            }

            public String getRepatrPrePhoto() {
                return repatrPrePhoto;
            }

            public void setRepatrPrePhoto(String repatrPrePhoto) {
                this.repatrPrePhoto = repatrPrePhoto;
            }

            public String getDepName() {
                return depName;
            }

            public void setDepName(String depName) {
                this.depName = depName;
            }

            public String getRepairTeam() {
                return repairTeam;
            }

            public void setRepairTeam(String repairTeam) {
                this.repairTeam = repairTeam;
            }

            public String getRepaireResult() {
                return repaireResult;
            }

            public void setRepaireResult(String repaireResult) {
                this.repaireResult = repaireResult;
            }

            public String getRepaireMemo() {
                return repaireMemo;
            }

            public void setRepaireMemo(String repaireMemo) {
                this.repaireMemo = repaireMemo;
            }

            public double getMaterialPrice() {
                return materialPrice;
            }

            public void setMaterialPrice(double materialPrice) {
                this.materialPrice = materialPrice;
            }

            public double getRepairPrice() {
                return repairPrice;
            }

            public void setRepairPrice(double repairPrice) {
                this.repairPrice = repairPrice;
            }

            public int getCheckMoneyStatus() {
                return checkMoneyStatus;
            }

            public void setCheckMoneyStatus(int checkMoneyStatus) {
                this.checkMoneyStatus = checkMoneyStatus;
            }

            public String getMaterialType() {
                return materialType;
            }

            public void setMaterialType(String materialType) {
                this.materialType = materialType;
            }
        }

        public static class ProjectBean implements Serializable {
            /**
             * proId : 15584
             * proName : 车载显示器 -拆装
             * proCode :
             * proNo : 2655
             * planTime : 2
             * planPrice : 20
             * useTime : 2
             * usePrice : 20
             * proMoney : 0.0
             * money : 0.0
             * safe : 1.0
             * gsNumber : 1
             */

            private int proId;
            private String proName;
            private String proCode;
            private String proNo;
            private String planTime;
            private String planPrice;
            private String useTime;
            private String usePrice;
            private String proMoney;
            private double money;
            private double safe;
            private String gsNumber;

            public int getProId() {
                return proId;
            }

            public void setProId(int proId) {
                this.proId = proId;
            }

            public String getProName() {
                return proName;
            }

            public void setProName(String proName) {
                this.proName = proName;
            }

            public String getProCode() {
                return proCode;
            }

            public void setProCode(String proCode) {
                this.proCode = proCode;
            }

            public String getProNo() {
                return proNo;
            }

            public void setProNo(String proNo) {
                this.proNo = proNo;
            }

            public String getPlanTime() {
                return planTime;
            }

            public void setPlanTime(String planTime) {
                this.planTime = planTime;
            }

            public String getPlanPrice() {
                return planPrice;
            }

            public void setPlanPrice(String planPrice) {
                this.planPrice = planPrice;
            }

            public String getUseTime() {
                return useTime;
            }

            public void setUseTime(String useTime) {
                this.useTime = useTime;
            }

            public String getUsePrice() {
                return usePrice;
            }

            public void setUsePrice(String usePrice) {
                this.usePrice = usePrice;
            }

            public String getProMoney() {
                return proMoney;
            }

            public void setProMoney(String proMoney) {
                this.proMoney = proMoney;
            }

            public double getMoney() {
                return money;
            }

            public void setMoney(double money) {
                this.money = money;
            }

            public double getSafe() {
                return safe;
            }

            public void setSafe(double safe) {
                this.safe = safe;
            }

            public String getGsNumber() {
                return gsNumber;
            }

            public void setGsNumber(String gsNumber) {
                this.gsNumber = gsNumber;
            }
        }

        public static class StockBean implements Serializable {
            /**
             * applyId : 27239
             * materialTypeName : 轮胎
             * materialDataName : 17年8米纯电备胎
             * materialDataId : 3155
             * ver :
             * applyNo : CKD2018110100001
             * appType : 2
             * appStatus : 1
             * unitprice : 231.0
             * outprice : 231.0
             * je : 231.0
             * num : 1.0
             * brand :
             * houseId : 112
             * houseName : 总公司仓库
             * materialName : 轮胎
             * materialCode : LT
             * materialId : 24323
             * supplier : 湖南东城服饰有限公司（宜春分公司）
             * materialNum : 1
             * houseArea : 测试11
             * uint : 条
             * inclusive : 267.96
             * kc : 1210.0
             */

            private int applyId;
            private String materialTypeName;
            private String materialDataName;
            private int materialDataId;
            private String ver;
            private String applyNo;
            private int appType;
            private int appStatus;
            private double unitprice;
            private double outprice;
            private double je;
            private double num;
            private String brand;
            private int houseId;
            private String houseName;
            private String materialName;
            private String materialCode;
            private int materialId;
            private String supplier;
            private String materialNum;
            private String houseArea;
            private String uint;
            private double inclusive;
            private double kc;

            public int getApplyId() {
                return applyId;
            }

            public void setApplyId(int applyId) {
                this.applyId = applyId;
            }

            public String getMaterialTypeName() {
                return materialTypeName;
            }

            public void setMaterialTypeName(String materialTypeName) {
                this.materialTypeName = materialTypeName;
            }

            public String getMaterialDataName() {
                return materialDataName;
            }

            public void setMaterialDataName(String materialDataName) {
                this.materialDataName = materialDataName;
            }

            public int getMaterialDataId() {
                return materialDataId;
            }

            public void setMaterialDataId(int materialDataId) {
                this.materialDataId = materialDataId;
            }

            public String getVer() {
                return ver;
            }

            public void setVer(String ver) {
                this.ver = ver;
            }

            public String getApplyNo() {
                return applyNo;
            }

            public void setApplyNo(String applyNo) {
                this.applyNo = applyNo;
            }

            public int getAppType() {
                return appType;
            }

            public void setAppType(int appType) {
                this.appType = appType;
            }

            public int getAppStatus() {
                return appStatus;
            }

            public void setAppStatus(int appStatus) {
                this.appStatus = appStatus;
            }

            public double getUnitprice() {
                return unitprice;
            }

            public void setUnitprice(double unitprice) {
                this.unitprice = unitprice;
            }

            public double getOutprice() {
                return outprice;
            }

            public void setOutprice(double outprice) {
                this.outprice = outprice;
            }

            public double getJe() {
                return je;
            }

            public void setJe(double je) {
                this.je = je;
            }

            public double getNum() {
                return num;
            }

            public void setNum(double num) {
                this.num = num;
            }

            public String getBrand() {
                return brand;
            }

            public void setBrand(String brand) {
                this.brand = brand;
            }

            public int getHouseId() {
                return houseId;
            }

            public void setHouseId(int houseId) {
                this.houseId = houseId;
            }

            public String getHouseName() {
                return houseName;
            }

            public void setHouseName(String houseName) {
                this.houseName = houseName;
            }

            public String getMaterialName() {
                return materialName;
            }

            public void setMaterialName(String materialName) {
                this.materialName = materialName;
            }

            public String getMaterialCode() {
                return materialCode;
            }

            public void setMaterialCode(String materialCode) {
                this.materialCode = materialCode;
            }

            public int getMaterialId() {
                return materialId;
            }

            public void setMaterialId(int materialId) {
                this.materialId = materialId;
            }

            public String getSupplier() {
                return supplier;
            }

            public void setSupplier(String supplier) {
                this.supplier = supplier;
            }

            public String getMaterialNum() {
                return materialNum;
            }

            public void setMaterialNum(String materialNum) {
                this.materialNum = materialNum;
            }

            public String getHouseArea() {
                return houseArea;
            }

            public void setHouseArea(String houseArea) {
                this.houseArea = houseArea;
            }

            public String getUint() {
                return uint;
            }

            public void setUint(String uint) {
                this.uint = uint;
            }

            public double getInclusive() {
                return inclusive;
            }

            public void setInclusive(double inclusive) {
                this.inclusive = inclusive;
            }

            public double getKc() {
                return kc;
            }

            public void setKc(double kc) {
                this.kc = kc;
            }
        }
    }
}
