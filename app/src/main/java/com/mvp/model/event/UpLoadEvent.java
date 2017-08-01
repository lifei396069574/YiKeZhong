package com.mvp.model.event;

/**
 * 作者：李飞 on 2017/8/1 11:55
 * 类的用途：
 */

public class UpLoadEvent {

    private int code;

    public UpLoadEvent(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
