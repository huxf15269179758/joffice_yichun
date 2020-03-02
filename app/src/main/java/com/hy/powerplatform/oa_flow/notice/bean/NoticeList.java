package com.hy.powerplatform.oa_flow.notice.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2019/12/31.
 */

public class NoticeList implements Serializable {
    public String newsId;
    public String title;
    public String content;
    public String author;
    public String endtime;
    public String createtime;
    public String fileName;
    public String fileId;
    public String readtimes;
    public String readUserids;

    public String getNewsId() {
        return newsId;
    }

    public void setNewsId(String newsId) {
        this.newsId = newsId;
    }

    public String getReadUserids() {
        return readUserids;
    }

    public void setReadUserids(String readUserids) {
        this.readUserids = readUserids;
    }

    public String getId() {
        return newsId;
    }

    public void setId(String newsId) {
        this.newsId = newsId;
    }

    public String getReadtimes() {
        return readtimes;
    }

    public void setReadtimes(String readtimes) {
        this.readtimes = readtimes;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }
}
