package com.socialmediapost.fb.dto;

public class FBLoginResponse {

	private String userId;

	public FBLoginResponse() {
		super();
	}

	public FBLoginResponse(String userId) {
		super();
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	
	
}
