package com.zolmk.net.http.helper;

public interface BasicListener<T,R> {
    void success(T t);
    void error(R r);
}
