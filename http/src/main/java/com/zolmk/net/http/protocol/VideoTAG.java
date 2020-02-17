package com.zolmk.net.http.protocol;

public enum VideoTAG implements BasicTAG {
    CHAT("chat"),
    DYNAMIC("dynamic"),
    ALBUM("album");

    private String value;
    VideoTAG(String value){
        this.value = value;
    }
    @Override
    public String getValue() {
        return value;
    }
}
