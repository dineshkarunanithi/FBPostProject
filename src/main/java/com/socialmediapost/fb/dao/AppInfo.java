package com.socialmediapost.fb.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="app_info")
public class AppInfo {

	@Id
	@Column(name="app_name")
	private String appName;
	
	@Column(name="app_id")
	private String appId;
	
	@Column(name="app_secret")
	private String appSecret;
	
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getAppSecret() {
		return appSecret;
	}
	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}
	
	@Override
	public String toString() {
		return "AppInfo [appName=" + appName + ", appId=" + appId + ", appSecret=" + appSecret + "]";
	}
	
	
	
}
