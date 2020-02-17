package com.zolmk.changzai.beans;

/**
 * type主要用来设置item0 已登录还是未登录
 * type:
 *      -1:未登录
 *      0：普通item
 *      1:已登录
 *
 */

public class MeBean {
    public final static int LOGIN = 1;
    public final static int DEFAULT = 0;
    public final static int UN_LOGIN = -1;
    private String picPath;
    private String name;
    private int type;
    private int rId;

    public int getRId() {
        return rId;
    }

    public void setRId(int r_id) {
        this.rId = r_id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
