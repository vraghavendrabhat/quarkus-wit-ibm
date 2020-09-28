package org.acme;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

@Path("/hello")
public class JaxRsHTTPEndpoint {

//	@GET
//	@Produces(MediaType.TEXT_PLAIN)
//	public String hello() throws InterruptedException {
//		System.out.println("JaxRsHTTPEndpoint - " + Thread.currentThread());
//		TimeUnit.SECONDS.sleep(5); //
//		return "jax-rs : hello";
//	}
	
	
	@Inject
	GreetingService greetingService;

	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Uni<String> hello(){
//		System.out.println("JaxRsHTTPEndpoint - " + Thread.currentThread());
		return greetingService.getMessage();
		
	}
	
	
	@GET
	@Produces(MediaType.SERVER_SENT_EVENTS)
	@Path("/{count}/{name}")
	public Multi<String> greetings(@PathParam("count") int count, @PathParam("name") String name) {
	  return greetingService.greetings(count, name);
	}
	
	
	
	
	
	

	
}