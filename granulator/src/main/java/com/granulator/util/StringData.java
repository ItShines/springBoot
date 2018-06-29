package com.granulator.util;

import java.io.Serializable;
import java.util.List;

public class StringData<T> implements Serializable {
    /**
     *
     */
    private String code;
    /**
     *
     */
    private String msg;
    /**
     *
     */
    private List<T> data;
    /**
     *
     */
    private Long time = System.currentTimeMillis();

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }
}
