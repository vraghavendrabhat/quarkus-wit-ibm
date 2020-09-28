package org.acme;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.vertx.web.Route;
import io.smallrye.mutiny.Uni;
import io.vertx.core.http.HttpMethod;

@ApplicationScoped
public class ReactiveRouteHttpEndPoint {

	@Route(path = "/reactive-hello", methods = { HttpMethod.GET })
	public Uni<String> hello() throws InterruptedException {
	
		System.out.println("ReactiveRouteHttpEndPoint - " + Thread.currentThread());
		
//		TimeUnit.SECONDS.sleep(5);
//		return "reactive-route : hello";
		
		System.out.println("JaxRsHTTPEndpoint - " + Thread.currentThread());
		
		return Uni
		.createFrom()
		.item(()->"reactive-route : hello")
		.onItem()
		.delayIt()
		.by(Duration.ofSeconds(5));
//	
	}

}
