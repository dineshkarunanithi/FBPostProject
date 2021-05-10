package com.socialmediapost.requestDto;

public class FBLoginCallbackReqAuthResponse {

	private String accessToken;
	private String expiresIn;
	private String reauthorize_required_in;
	private String signedRequest;
	private String userID;
	
	
	public FBLoginCallbackReqAuthResponse() {
		super();
	}
	public FBLoginCallbackReqAuthResponse(String accessToken, String expiresIn, String reauthorize_required_in,
			String signedRequest, String userID) {
		super();
		this.accessToken = accessToken;
		this.expiresIn = expiresIn;
		this.reauthorize_required_in = reauthorize_required_in;
		this.signedRequest = signedRequest;
		this.userID = userID;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public String getExpiresIn() {
		return expiresIn;
	}
	public void setExpiresIn(String expiresIn) {
		this.expiresIn = expiresIn;
	}
	public String getReauthorize_required_in() {
		return reauthorize_required_in;
	}
	public void setReauthorize_required_in(String reauthorize_required_in) {
		this.reauthorize_required_in = reauthorize_required_in;
	}
	public String getSignedRequest() {
		return signedRequest;
	}
	public void setSignedRequest(String signedRequest) {
		this.signedRequest = signedRequest;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	@Override
	public String toString() {
		return "FBLoginCallbackReqAuthResponse [accessToken=" + accessToken + ", expiresIn=" + expiresIn
				+ ", reauthorize_required_in=" + reauthorize_required_in + ", signedRequest=" + signedRequest
				+ ", userID=" + userID + "]";
	}
	
	
}
