package com.zolmk.net.http.protocol;

/**
 * 文件类型和上传地址枚举
 */
public enum FileType{
    IMAGE("image/*","img_rv.php"),
    TEXT("text/*",""),
    AUDIO("audio/*",""),
    VIDEO("video/*",""),
    APPLICATION("application/*",""),
    EXTENSION_TOKEN("extension-token/*","");
    private String type;
    private String postPath;
    FileType(String type,String postPath) {
        this.type = type;
        this.postPath = postPath;
    }
    public String getType() {
        return type;
    }
    public String getPostPath() {
        return postPath;
    }
}