package com.zolmk.changzai.beans;

/**
 * 聊天页面最新消息bean
 *
 */
public class ChatUsersBean {
    private String userId;
    private String userName;
    private String imgHeadPath;
    private String message;
    private int type;
    private long time;

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

    public String getImgHeadPath() {
        return imgHeadPath;
    }

    public void setImgHeadPath(String imgHeadPath) {
        this.imgHeadPath = imgHeadPath;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "ChatUsersBean{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", imgHeadPath='" + imgHeadPath + '\'' +
                ", message='" + message + '\'' +
                ", type=" + type +
                ", time=" + time +
                '}';
    }
}
