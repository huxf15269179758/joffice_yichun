package com.hy.powerplatform.car_maintain.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/12/19.
 */

public class AboutData implements Serializable {

    /**
     * success : true
     * data : {"xlbh":"10","ch":"10028","jsy":"1048","carNo":"E10899","carType":"大型普通客车","bus_maker":"厦门金龙联合汽车工业有限公司","bus_supplier":"厦门金龙联合汽车工业有限公司","vehicleType":"XMQ6127G","fullname":"田静","sex":"男","marriage":"已婚","startWorkDate":{"date":25,"day":4,"hours":0,"minutes":0,"month":11,"nanos":0,"seconds":0,"time":535824000000,"timezoneOffset":-480,"year":86},"vehicleClass":"A1A2","workedPosAge":22,"idCard":"340503197001180231","birthday":49,"lc":236008.01}
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

    public static class DataBean implements Serializable {
        /**
         * xlbh : 10
         * ch : 10028
         * jsy : 1048
         * carNo : E10899
         * carType : 大型普通客车
         * bus_maker : 厦门金龙联合汽车工业有限公司
         * bus_supplier : 厦门金龙联合汽车工业有限公司
         * vehicleType : XMQ6127G
         * fullname : 田静
         * sex : 男
         * marriage : 已婚
         * startWorkDate : {"date":25,"day":4,"hours":0,"minutes":0,"month":11,"nanos":0,"seconds":0,"time":535824000000,"timezoneOffset":-480,"year":86}
         * vehicleClass : A1A2
         * workedPosAge : 22
         * idCard : 340503197001180231
         * birthday : 49
         * lc : 236008.01
         */

        private String xlbh;
        private String ch;
        private String jsy;
        private String carNo;
        private String carType;
        private String bus_maker;
        private String bus_supplier;
        private String vehicleType;
        private String fullname;
        private String sex;
        private String marriage;
        private StartWorkDateBean startWorkDate;
        private String vehicleClass;
        private int workedPosAge;
        private String idCard;
        private int birthday;
        private double lc;

        public String getXlbh() {
            return xlbh;
        }

        public void setXlbh(String xlbh) {
            this.xlbh = xlbh;
        }

        public String getCh() {
            return ch;
        }

        public void setCh(String ch) {
            this.ch = ch;
        }

        public String getJsy() {
            return jsy;
        }

        public void setJsy(String jsy) {
            this.jsy = jsy;
        }

        public String getCarNo() {
            return carNo;
        }

        public void setCarNo(String carNo) {
            this.carNo = carNo;
        }

        public String getCarType() {
            return carType;
        }

        public void setCarType(String carType) {
            this.carType = carType;
        }

        public String getBus_maker() {
            return bus_maker;
        }

        public void setBus_maker(String bus_maker) {
            this.bus_maker = bus_maker;
        }

        public String getBus_supplier() {
            return bus_supplier;
        }

        public void setBus_supplier(String bus_supplier) {
            this.bus_supplier = bus_supplier;
        }

        public String getVehicleType() {
            return vehicleType;
        }

        public void setVehicleType(String vehicleType) {
            this.vehicleType = vehicleType;
        }

        public String getFullname() {
            return fullname;
        }

        public void setFullname(String fullname) {
            this.fullname = fullname;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getMarriage() {
            return marriage;
        }

        public void setMarriage(String marriage) {
            this.marriage = marriage;
        }

        public StartWorkDateBean getStartWorkDate() {
            return startWorkDate;
        }

        public void setStartWorkDate(StartWorkDateBean startWorkDate) {
            this.startWorkDate = startWorkDate;
        }

        public String getVehicleClass() {
            return vehicleClass;
        }

        public void setVehicleClass(String vehicleClass) {
            this.vehicleClass = vehicleClass;
        }

        public int getWorkedPosAge() {
            return workedPosAge;
        }

        public void setWorkedPosAge(int workedPosAge) {
            this.workedPosAge = workedPosAge;
        }

        public String getIdCard() {
            return idCard;
        }

        public void setIdCard(String idCard) {
            this.idCard = idCard;
        }

        public int getBirthday() {
            return birthday;
        }

        public void setBirthday(int birthday) {
            this.birthday = birthday;
        }

        public double getLc() {
            return lc;
        }

        public void setLc(double lc) {
            this.lc = lc;
        }

        public static class StartWorkDateBean implements Serializable {
            /**
             * date : 25
             * day : 4
             * hours : 0
             * minutes : 0
             * month : 11
             * nanos : 0
             * seconds : 0
             * time : 535824000000
             * timezoneOffset : -480
             * year : 86
             */

            private int date;
            private int day;
            private int hours;
            private int minutes;
            private int month;
            private int nanos;
            private int seconds;
            private long time;
            private int timezoneOffset;
            private int year;

            public int getDate() {
                return date;
            }

            public void setDate(int date) {
                this.date = date;
            }

            public int getDay() {
                return day;
            }

            public void setDay(int day) {
                this.day = day;
            }

            public int getHours() {
                return hours;
            }

            public void setHours(int hours) {
                this.hours = hours;
            }

            public int getMinutes() {
                return minutes;
            }

            public void setMinutes(int minutes) {
                this.minutes = minutes;
            }

            public int getMonth() {
                return month;
            }

            public void setMonth(int month) {
                this.month = month;
            }

            public int getNanos() {
                return nanos;
            }

            public void setNanos(int nanos) {
                this.nanos = nanos;
            }

            public int getSeconds() {
                return seconds;
            }

            public void setSeconds(int seconds) {
                this.seconds = seconds;
            }

            public long getTime() {
                return time;
            }

            public void setTime(long time) {
                this.time = time;
            }

            public int getTimezoneOffset() {
                return timezoneOffset;
            }

            public void setTimezoneOffset(int timezoneOffset) {
                this.timezoneOffset = timezoneOffset;
            }

            public int getYear() {
                return year;
            }

            public void setYear(int year) {
                this.year = year;
            }
        }
    }
}
