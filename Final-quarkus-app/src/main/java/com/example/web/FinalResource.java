package com.example.web;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;

@Path("/api/jaxrshello")
public class FinalResource {

	@Autowired
	FinalGreetingService finalGreetingService;

}
