package com.zp.entity;

import java.util.List;

public class UserResult {
    private int code;
    private String msg;
    private int count;
    private List<User> date;

    public UserResult(){}

    public UserResult(int code, String msg, int count, List<User> date) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.date = date;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<User> getDate() {
        return date;
    }

    public void setDate(List<User> date) {
        this.date = date;
    }
}
