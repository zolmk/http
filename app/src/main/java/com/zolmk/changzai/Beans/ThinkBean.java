package com.zolmk.changzai.Beans;

/**
 *  根据用户id和说说发表时间确定说说id
 *
 */
public class ThinkBean {
    private String thinkId;
    private int imgNumber;
    private String userId;
    private long publishDate;
    private String name;
    private String text;

    public int getImgNumber() {
        return imgNumber;
    }

    public long getPublishDate() {
        return publishDate;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    public String getThinkId() {
        return thinkId;
    }

    public String getUserId() {
        return userId;
    }

    public void setImgNumber(int imgNumber) {
        this.imgNumber = imgNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPublishDate(long publishDate) {
        this.publishDate = publishDate;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setThinkId(String thinkId) {
        this.thinkId = thinkId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
