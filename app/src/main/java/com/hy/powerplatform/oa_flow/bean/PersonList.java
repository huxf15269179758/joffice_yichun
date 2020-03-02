package com.hy.powerplatform.oa_flow.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2019/2/26.
 */

public class PersonList implements Serializable {

    public String fullname;
    public String profileId;
    public String eCard;
    public String sex;
    public String userCode;
    //显示拼音的首字母
    public String letters;

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    public String geteCard() {
        return eCard;
    }

    public void seteCard(String eCard) {
        this.eCard = eCard;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getLetters() {
        return letters;
    }

    public void setLetters(String letters) {
        this.letters = letters;
    }
}
