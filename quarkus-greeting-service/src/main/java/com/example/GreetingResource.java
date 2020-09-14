package com.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String hello(@HeaderParam("Accept-Language") String language, @Context UriInfo uriInfo) {
		System.out.println(uriInfo.getAbsolutePath());
		if ("es".equals(language)) {
			return "ola";
		} else {
			return "hello";
		}
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
