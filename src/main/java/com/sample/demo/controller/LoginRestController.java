package com.sample.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginRestController {
	
	public LoginRestController() {
		
	}
	
	@GetMapping
	public String getUserDetails() {
		return "This is Krishna";
	}
	
	@GetMapping("/sample")
	public String getSampleDetails() {
		return "This is Sample";
	}

}
