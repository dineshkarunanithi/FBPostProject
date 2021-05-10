package com.socialmediapost.insta.dto;

public class InstaContainerImagePostRequest {

	private String image_url;
	private String access_token;
	
	public InstaContainerImagePostRequest(String image_url, String access_token) {
		super();
		this.image_url = image_url;
		this.access_token = access_token;
	}
	
	public InstaContainerImagePostRequest() {
		super();
	}

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	
	
	
}
