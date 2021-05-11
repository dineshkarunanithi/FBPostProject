package com.socialmediapost.fb.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.socialmediapost.db.AccessTokenEntity;
import com.socialmediapost.fb.repository.*;
import com.socialmediapost.fb.constants.AppConstants;
import com.socialmediapost.fb.dao.AccessTokens;
import com.socialmediapost.fb.dao.AppInfo;
import com.socialmediapost.fb.dao.UserPages;
import com.socialmediapost.fb.dto.PostHomeListingCommerceManagerRequest;
import com.socialmediapost.fb.dto.PostMessageResponse;
import com.socialmediapost.fb.dto.longLivedToken;
import com.socialmediapost.fb.dto.pageTokenResponse;

@RestController
public class fbPostController {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private AccessTokenRepository accessTokenRepo;

	private AppInfo appInfo;

	@Autowired
	private AppInfoRepository appRepository; 

	@Autowired
	private UserPageRepository userPageRepository; 

	@GetMapping(path = "/fb/postMessage")
	public PostMessageResponse postMessage(@RequestParam("message") String message,
			@RequestParam("userId") String userId) {

		AccessTokens accessTokens = accessTokenRepo.findByUserId(userId);
		UserPages userPages =  userPageRepository.findByUserId(userId); 
		appInfo = appRepository.findByAppName(AppConstants.appName);

		System.out.println(accessTokens);
		System.out.println(userPages);
		System.out.println(appInfo);

		longLivedToken longLivedToken = longLivedToken(accessTokens.getAccessToken()); 
		pageTokenResponse pageTokenResponse = pageAccessToken(longLivedToken,userPages); 
		PostMessageResponse messageResponse = postMessage(pageTokenResponse,userPages,message);

		return messageResponse;

	}

	@PostMapping(path = "/fb/postHomeListings")
	public PostMessageResponse postHomeListings(
			@RequestBody PostHomeListingCommerceManagerRequest commerceManagerRequest) {

		longLivedToken longLivedToken = longLivedToken(null);// to add the access token
		pageTokenResponse pageTokenResponse = pageAccessToken(longLivedToken,null);//add page ID or catalog ID
		commerceManagerRequest.setAccess_token(pageTokenResponse.getAccess_token());
		PostMessageResponse messageResponse = postHomeListingToFaceBook(commerceManagerRequest);
		return messageResponse;

	}

	private PostMessageResponse postHomeListingToFaceBook(
			PostHomeListingCommerceManagerRequest commerceManagerRequest) {
		String uri = "https://graph.facebook.com/v10.0/303202654661385/home_listings";

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<PostHomeListingCommerceManagerRequest> entity = new HttpEntity<PostHomeListingCommerceManagerRequest>(
				commerceManagerRequest);

		PostMessageResponse messageResponse = restTemplate.postForObject(uri, entity, PostMessageResponse.class);

		return messageResponse;
	}

	private longLivedToken longLivedToken(String userAccessToken) {
		String uri = "https://graph.facebook.com/oauth/access_token?grant_type=fb_exchange_token"
				+ "&client_id="+appInfo.getAppId()+"&client_secret="+ appInfo.getAppSecret() + "&fb_exchange_token="+ userAccessToken;

		longLivedToken longLivedToken = restTemplate.getForObject(uri, longLivedToken.class);
		return longLivedToken;
	}

	private pageTokenResponse pageAccessToken(longLivedToken livedToken,UserPages pages) {
		String uri = "https://graph.facebook.com/"+pages.getPageId()+"?" + "fields=access_token" + "&access_token="
				+ livedToken.getAccess_token();

		pageTokenResponse pageTokenResponse = restTemplate.getForObject(uri, pageTokenResponse.class);
		return pageTokenResponse;
	}

	private PostMessageResponse postMessage(pageTokenResponse pageTokenResponse,UserPages pages, String message) {
		String uri = "https://graph.facebook.com/"+pages.getPageId()+"/feed" + "?message=" + message + "&access_token="
				+ pageTokenResponse.getAccess_token();
		System.out.println(uri);

		/*
		 * AccessTokenEntity accessToken = new AccessTokenEntity();
		 * 
		 * accessToken.setApp_Name("test_app_Development_mode");
		 * accessToken.setAccess_Token(pageTokenResponse.getAccess_token());
		 * accessToken.setToken_Type("Page Access Token");
		 */

		/* accessTokenRepo.save(accessToken); */

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<String> entity = new HttpEntity<String>(headers);

		PostMessageResponse messageResponse = restTemplate.postForObject(uri, entity, PostMessageResponse.class);
		return messageResponse;
	}

}
