package com.sample.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class InfoController {

	
	@GetMapping
	public String getAppInfo() {
		return "<a href='http://localhost:8081/v2/api-docs'>Api Documentation</a>";
	}
}
