package com.socialmediapost.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HTMLFBLogin {

	@RequestMapping("/fb/loginDialog") 
	public String fbLoginView() {
		return "html/FBLogin.html";
	}
	
}
