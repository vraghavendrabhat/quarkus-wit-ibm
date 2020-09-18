package com.example;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;

@Path("/hello")
public class GreetingResource {

	@Path("/messages")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> helloForMessages(@QueryParam("s") String s) {
		String[] messages = { "hello", "hi", "howdy", "hey", "ola", "dude" };
		return Arrays.stream(messages).filter(message -> message.startsWith(s)).collect(Collectors.toList());
	}

	@Path("/{name}")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String helloWithName(@PathParam("name") String name) {
		return "hello " + name;
	}

//	@ConfigProperty(name = "greeting.message",defaultValue = "hello")
//	String message;
	
	@ConfigProperty(name="greeting.who")
	List<String> who;
	
	@ConfigProperty(name = "greeting.date")
	LocalDate localDate;
	
	
	@Inject
	Config config;
	
	
	private static Logger logger=Logger.getLogger(GreetingResource.class);

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String hello(@HeaderParam("Accept-Language") String language, @Context UriInfo uriInfo) {

//		System.out.println(uriInfo.getAbsolutePath());
//		if ("es".equals(language)) {
//			return "ola";
//		} else {
//			return "hello";
//		}
		
		logger.info("i said hello");
		
		String message=config.getValue("greeting.message", String.class);
		return message +" "+who.get(1) + localDate.toString();

	}

	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	public void create(String message) {
		//
		System.out.println("create");
	}

	@PUT
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public String update(String message) {
		System.out.println("update");
		return message;
	}

	@DELETE
	public void delete() {
		System.out.println("delete");
	}

}
