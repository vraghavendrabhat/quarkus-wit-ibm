package org.acme;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.HealthCheckResponseBuilder;
import org.eclipse.microprofile.health.Readiness;

@ApplicationScoped
@Readiness
public class MemoryHealthCheck implements HealthCheck {

	@Override
	public HealthCheckResponse call() {

		HealthCheckResponseBuilder healthCheckResponseBuilder = HealthCheckResponse.named("memory health check");

		Runtime runtime = Runtime.getRuntime();

		long freeMemory = runtime.freeMemory();

		if (freeMemory <= 1024000000000L)
			healthCheckResponseBuilder.down().withData("message", "No enough memory, please restart");
		else
			healthCheckResponseBuilder.up();
		return healthCheckResponseBuilder.build();
	}

}
