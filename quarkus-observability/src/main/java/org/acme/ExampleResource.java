package org.acme;

import java.util.Random;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Gauge;
import org.eclipse.microprofile.metrics.annotation.Metered;
import org.eclipse.microprofile.metrics.annotation.Timed;

@Path("/hello")
public class ExampleResource {

//  @Counted(name = "hello-req-count")
//	@Timed(name = "hello-request",unit = MetricUnits.SECONDS)
	@Metered
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String hello() {
		getBytes();
		return "hello";
	}

	@Gauge(name = "BYTES", unit = MetricUnits.BYTES)
	public int getBytes() {
		Random random = new Random();
		int rn = random.nextInt(1000);
		System.out.println(rn);
		return rn;
	}

}