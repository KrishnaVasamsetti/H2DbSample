package com.sample.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping
public class InfoController {
	
	@RequestMapping("/index")
	public String indexPage() {
		return "index";
	}

}
