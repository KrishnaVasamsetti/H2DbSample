package com.sample.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class InfoController {


	@GetMapping
	public String getAppInfo() {
		return 
				"<H1>Employee Details </H1>"
				+ "<a href='http://localhost:8081/swagger-ui/'>Swagger UI docs</a>"
				+ "<br>"
				+ "<a href='http://localhost:8081/v2/api-docs'>Api Docs</a>"
				;
	}

}
