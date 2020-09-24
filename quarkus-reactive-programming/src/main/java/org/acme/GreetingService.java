package org.acme;

import java.time.Duration;

import javax.enterprise.context.ApplicationScoped;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

@ApplicationScoped
public class GreetingService {
	
	Uni<String> getMessage() {

		return Uni
		.createFrom()
		.item(()->"jax-rs : hello")
		.onItem()
		.delayIt()
		.by(Duration.ofSeconds(5));
		
	}
	
	 Multi<String> greetings(int count, String name) {
		  return Multi
				.createFrom().ticks().every(Duration.ofSeconds(1))
		        .onItem()
		        .transform(n -> String.format("hello %s - %d", name, n))
		        .transform().byTakingFirstItems(count);
		}

}
