package com.hy.powerplatform.oa_flow.metting.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2020/1/2.
 */

public class JiYaoList implements Serializable {

    public String title;
    public String creator;
    public String createtime;
    public String sumContent;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getSumContent() {
        return sumContent;
    }

    public void setSumContent(String sumContent) {
        this.sumContent = sumContent;
    }
}
