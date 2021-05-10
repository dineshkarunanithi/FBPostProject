package com.socialmediapost.Entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="accesstokens")
public class PostSocialMediaRequest {
	
	@Id
	@Column(name="UserID")
	private String userId;
	
	@Column(name="Access_Token")
	private String accessToken;
	
	@Column(name="Token_Type")
	private String tokenType;

	@Column(name="App_Name")
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
