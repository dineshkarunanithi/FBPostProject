package com.socialmediapost.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.socialmediapost.Entities.PostSocialMediaRequest;
import com.socialmediapost.requestDto.FBLoginCallbackDTO;



@RestController
public class GetFBLoginResponse {
	
	@Autowired
	private RestTemplate restTemplate;

	
	  @PostMapping(path = "/socialMedia/postUserAccess") 
	  public String postSocialMedia(@RequestBody FBLoginCallbackDTO fBLoginCallbackDTO )
	  {
	  
	  System.out.println(fBLoginCallbackDTO.toString());
	  
	  return fBLoginCallbackDTO.toString(); }
	
	
}
