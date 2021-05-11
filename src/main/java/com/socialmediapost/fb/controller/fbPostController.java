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
import com.socialmediapost.db.AccessTokenRepository;
import com.socialmediapost.fb.dto.PostHomeListingCommerceManagerRequest;
import com.socialmediapost.fb.dto.PostMessageResponse;
import com.socialmediapost.fb.dto.longLivedToken;
import com.socialmediapost.fb.dto.pageTokenResponse;


@RestController
public class fbPostController {

	@Autowired
	private RestTemplate restTemplate;
	
	/*
	 * @Autowired private AccessTokenRepository accessTokenRepo;
	 */
	
	  
	  @GetMapping(path = "/fb/postMessage") 
	  public PostMessageResponse postMessage(@RequestParam("message") String message) {
		  
		  longLivedToken longLivedToken = longLivedToken();
		  pageTokenResponse pageTokenResponse = pageAccessToken(longLivedToken);
		  PostMessageResponse messageResponse = postMessage(pageTokenResponse,message);

		  return messageResponse;

	  }

	  @PostMapping(path = "/fb/postHomeListings")
	  public PostMessageResponse postHomeListings(@RequestBody PostHomeListingCommerceManagerRequest commerceManagerRequest ) {

		  longLivedToken longLivedToken = longLivedToken();
		  pageTokenResponse pageTokenResponse = pageAccessToken(longLivedToken);
		  commerceManagerRequest.setAccess_token(pageTokenResponse.getAccess_token());
		  PostMessageResponse messageResponse = postHomeListingToFaceBook(commerceManagerRequest);
		  return messageResponse;
		  
	  }

	private PostMessageResponse postHomeListingToFaceBook(PostHomeListingCommerceManagerRequest commerceManagerRequest) {
		String uri = "https://graph.facebook.com/v10.0/303202654661385/home_listings";
		
		  HttpHeaders headers = new HttpHeaders();
		  headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		  HttpEntity<PostHomeListingCommerceManagerRequest> entity = new HttpEntity<PostHomeListingCommerceManagerRequest>(commerceManagerRequest);
		  
		  PostMessageResponse messageResponse = restTemplate.postForObject(uri, entity, PostMessageResponse.class);
		
		return messageResponse;
	}

	private longLivedToken longLivedToken() {
		String uri = "https://graph.facebook.com/oauth/access_token?grant_type=fb_exchange_token"
		  		+ "&client_id=1614553392073694&client_secret=a119a3d57c68f75f0fd0c039f6fd28de"
		  		+ "&fb_exchange_token="
		  		+ "EAAW8bYFny94BALUUC7QjyFzpGWxyZBU22dNDZCwZAYa4IepZCilC40dZB5y108dLcIrOGfemhkrYvaxty3op3IrqEJXPTXAwGhCbnopnP76cZCn3cNlZC0DNPRZBlR65FgGaHnwe5vdZCdimOSOQTzfDcyE5ZAMF8rFyxFJNTRm7UAuLDs9XdK9ZBO3TvXAFMX456iJmXVwu9h2lgZDZD";
		  
		  longLivedToken longLivedToken = restTemplate.getForObject(uri,longLivedToken.class);
		return longLivedToken;
	}

	private pageTokenResponse pageAccessToken(longLivedToken livedToken) {
		String uri = "https://graph.facebook.com/107954321462447?"
				+ "fields=access_token"
				+ "&access_token="+livedToken.getAccess_token();
		  
		pageTokenResponse pageTokenResponse = restTemplate.getForObject(uri,pageTokenResponse.class);
		return pageTokenResponse;
	}
	
	private PostMessageResponse postMessage(pageTokenResponse pageTokenResponse,String message) {
		String uri = "https://graph.facebook.com/107954321462447/feed"
				+ "?message="+message
				+ "&access_token="+pageTokenResponse.getAccess_token();
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
