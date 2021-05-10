package com.socialmediapost.controller;

import java.util.Arrays;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.socialmediapost.Entities.PostSocialMediaRequest;
import com.socialmediapost.Entities.PostSocialMediaRequestRepository;
import com.socialmediapost.db.AccessTokenEntity;
import com.socialmediapost.db.AccessTokenRepository;
import com.socialmediapost.fb.controller.fbPostController;
import com.socialmediapost.fb.dto.PostHomeListingCommerceManagerRequest;
import com.socialmediapost.fb.dto.PostMessageResponse;
import com.socialmediapost.fb.dto.longLivedToken;
import com.socialmediapost.fb.dto.pageTokenResponse;

@RestController
/* @CrossOrigin("http://localhost:8080") */
public class SocialMediaPostController {
	/*
	 * 
	 * @Autowired private RestTemplate restTemplate;
	 * 
	 * @Autowired private PostSocialMediaRequestRepository socialMediaPostRepo;
	 * 
	 * @CrossOrigin
	 * 
	 * @PostMapping(path = "/socialMedia/postUserAccess") public PostMessageResponse
	 * postSocialMedia(@RequestBody PostSocialMediaRequest postSocialMediaRequest )
	 * {
	 * 
	 * System.out.println(postSocialMediaRequest.toString());
	 * 
	 * socialMediaPostRepo.save(postSocialMediaRequest);
	 * 
	 * return null; }
	 * 
	 * 
	 * @Option(path = "/socialMedia/postUserAccess") public PostMessageResponse
	 * postSocialMedia(@RequestBody PostSocialMediaRequest postSocialMediaRequest )
	 * {
	 * 
	 * System.out.println(postSocialMediaRequest.toString());
	 * 
	 * socialMediaPostRepo.save(postSocialMediaRequest);
	 * 
	 * return null; }
	 * 
	 * 
	 * @ModelAttribute public void setResponseHeader(HttpServletResponse response) {
	 * response.setHeader("Access-Control-Allow-Origin", "*"); }
	 * 
	 */ }
