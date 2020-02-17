package com.zolmk.changzai.beans;

public class UserDynamicBean {
    private String dynamicId;
    private String userId;
    private String userName;
    private String setting;
    private String label;
    private String whoLike;
    private long time;
    private String text;
    private String[] picPath;


    private int imgNumber;
    public static final int SEARCH = -1;
    public static final int ZERO_PICTURE = 0;
    public static final int ONT_PICTURE = 1;
    public static final int TWO_PICTURE = 2;
    public static final int FOUR_PICTURE = 4;

    public UserDynamicBean(){
        this.dynamicId = "test_id";
        this.userId = "test_userID";
        this.userName = "test_userName";
        this.setting = "{}";
        this.label = "";
        this.whoLike = "";
        this.time = 0;
        this.text = "";
        this.picPath = null;
    }
    public String getDynamicId() {
        return dynamicId;
    }

    public void setDynamicId(String dynamicId) {
        this.dynamicId = dynamicId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSetting() {
        return setting;
    }

    public void setSetting(String setting) {
        this.setting = setting;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getWhoLike() {
        return whoLike;
    }

    public void setWhoLike(String whoLike) {
        this.whoLike = whoLike;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String[] getPicPath() {
        return picPath;
    }

    public void setPicPath(String[] picPath) {
        this.picPath = picPath;
    }
    public int getImgNumber() {
        return imgNumber;
    }

    public void setImgNumber(int imgNumber) {
        this.imgNumber = imgNumber;
    }

}
