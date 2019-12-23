package com.xdlr.civilization.controller;

public class UserInfo {
    private String userId;
    private long time;
    private int value;
    private String userImg;

    public UserInfo(String userId, long time, int value, String userImg) {
        this.userId = userId;
        this.time = time;
        this.value = value;
        this.userImg = userImg;
    }

    public String getUserId() {
        return userId;
    }

    public long getTime() {
        return time;
    }

    public int getValue() {
        return value;
    }

    public String getUserImg() {
        return userImg;
    }

    @Override
    public String toString() {
        return value + "," + userId + "," + userImg;
    }
}
