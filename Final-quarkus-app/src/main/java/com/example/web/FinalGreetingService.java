package com.example.web;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("singleton")
public class FinalGreetingService {

	public String getMessage() {
		return "hello, thanks to all";
	}
	
}
