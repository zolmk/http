package com.zolmk.net.http.protocol;

/**
 * 图片所属标签接口
 */
public enum ImageTAG implements BasicTAG {
    HEAD("head"),
    DYNAMIC("dynamic"),
    ALBUM("album"),
    CHAT("chat");
    private String value;
    ImageTAG(String value){
        this.value = value;
    }

    @Override
    public String getValue() {
        return this.value;
    }
}
