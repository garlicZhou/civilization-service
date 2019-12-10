package com.xdlr.civilization.controller;

public class UserActionResponse {

	private final String userId;
	private final int userToken;
	private final int userAction;
	private final boolean successOnChain;

	public static final int ACTION_TYPE_REGISTER = 0;
	public static final int ACTION_TYPE_GARBAGE = 1;
	public static final int ACTION_TYPE_VENDING_MACHINE = 2;
	public static final int ACTION_TYPE_UPDATE = 3;

	public UserActionResponse(String userId, int userToken, int userAction, boolean successOnChain) {
		this.userId = userId;
		this.userToken = userToken;
		this.userAction = userAction;
		this.successOnChain = successOnChain;
	}

	public String getUserId() {
		return userId;
	}

	public int getUserToken() {
		return userToken;
	}

	public int getUserAction() {
		return userAction;
	}

	public boolean isSuccessOnChain() {
		return successOnChain;
	}
}
