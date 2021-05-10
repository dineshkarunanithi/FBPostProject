package com.socialmediapost.Entities;

import java.util.List;

public class PostSocialMediaRequest {

	private String userId;
	

	private String accessToken;
	

	private String tokenType;


	private String appName;
	
	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getTokenType() {
		return tokenType;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

	@Override
	public String toString() {
		return "PostSocialMediaRequest [userId=" + userId + ", accessToken=" + accessToken + ", tokenType=" + tokenType
				+ ", appName=" + appName + "]";
	}


	
	
	
}
