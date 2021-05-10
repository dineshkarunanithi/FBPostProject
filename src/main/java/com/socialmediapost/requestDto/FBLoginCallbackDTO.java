package com.socialmediapost.requestDto;

public class FBLoginCallbackDTO {

	private String status;
	private FBLoginCallbackReqAuthResponse authResponse;
	
	
	public FBLoginCallbackDTO() {
		super();
	}
	public FBLoginCallbackDTO(String status, FBLoginCallbackReqAuthResponse authResponse) {
		super();
		this.status = status;
		this.authResponse = authResponse;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public FBLoginCallbackReqAuthResponse getAuthResponse() {
		return authResponse;
	}
	public void setAuthResponse(FBLoginCallbackReqAuthResponse authResponse) {
		this.authResponse = authResponse;
	}
	@Override
	public String toString() {
		return "FBLoginCallbackDTO [status=" + status + ", authResponse=" + authResponse.toString() + "]";
	}
	
	
	
}
