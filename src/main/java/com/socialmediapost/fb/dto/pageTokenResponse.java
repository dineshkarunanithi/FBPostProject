package com.socialmediapost.fb.dto;

public class pageTokenResponse {
	
	private String access_token;
	private String id;
	
	public pageTokenResponse() {
		super();
	}
	public pageTokenResponse(String access_token, String id) {
		super();
		this.access_token = access_token;
		this.id = id;
	}
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
