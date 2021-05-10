package com.socialmediapost.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.socialmediapost.Entities.PostSocialMediaRequest;



@RestController
public class GetFBLoginResponse {
	
	@Autowired
	private RestTemplate restTemplate;

	
	  @PostMapping(path = "/socialMedia/postUserAccess") 
	  public String postSocialMedia(@RequestBody PostSocialMediaRequest postSocialMediaRequest )
	  {
	  
	  System.out.println(postSocialMediaRequest.toString());
	  
	  return postSocialMediaRequest.toString(); }
	
	
}
