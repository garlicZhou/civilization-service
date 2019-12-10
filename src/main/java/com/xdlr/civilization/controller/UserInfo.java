package com.xdlr.civilization.controller;

public class UserInfo {
    private String userId;
    private long time;
    private int value;


    public UserInfo(String userId, long time, int value) {
        this.userId = userId;
        this.value = value;
        this.time = time;
    }

    public String getUserId() {
        return userId;
    }

    public int getValue() {
        return value;
    }

    public long getTime() {
        return time;
    }
}
