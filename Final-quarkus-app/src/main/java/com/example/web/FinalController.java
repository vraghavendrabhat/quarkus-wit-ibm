package com.example.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FinalController {
	
	@Autowired
	FinalGreetingService finalGreetingService;

	@GetMapping("/api/hello")
	public String hello() {
		return finalGreetingService.getMessage();
	}
	
}
