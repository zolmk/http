package com.zolmk.net.http.protocol;

public enum AudioTAG implements BasicTAG {
    CHAT("chat"),
    DYNAMIC("dynamic"),
    ALBUM("album");

    private String value;
    AudioTAG(String value){
        this.value = value;
    }
    @Override
    public String getValue() {
        return value;
    }
}
