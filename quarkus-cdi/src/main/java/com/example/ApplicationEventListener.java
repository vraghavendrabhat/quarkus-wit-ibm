package com.example;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;

@ApplicationScoped
public class ApplicationEventListener {

	public void start(@Observes StartupEvent startupEvent) {
		System.out.println("ApplicationEventListener : onStart");
	}

	public void shutdown(@Observes ShutdownEvent shutdownEvent) {
		System.out.println("ApplicationEventListener : onStop");
	}

}
