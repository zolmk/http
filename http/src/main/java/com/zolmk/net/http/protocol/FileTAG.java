package com.zolmk.net.http.protocol;

/**
 * 文件所属标签
 */
public enum FileTAG implements BasicTAG {
    USER("user");
    private String value;
    FileTAG(String value){
        this.value = value;
    }
    @Override
    public String getValue() {
        return value;
    }
}
