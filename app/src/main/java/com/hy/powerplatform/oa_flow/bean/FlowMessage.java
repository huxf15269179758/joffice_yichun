package com.hy.powerplatform.oa_flow.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2019/3/8.
 */

public class FlowMessage implements Serializable {
    public String num;
    public String taskName;
    public String person;
    public String startTime;
    public String endTime;
    public String time;
    public String aggre;

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAggre() {
        return aggre;
    }

    public void setAggre(String aggre) {
        this.aggre = aggre;
    }
}
