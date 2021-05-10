package com.socialmediapost.fb.dto;

public class PostMessageResponse {

	private String id;

	public PostMessageResponse() {
		super();
	}

	public PostMessageResponse(String id) {
		super();
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
