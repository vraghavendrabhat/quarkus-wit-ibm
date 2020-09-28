package com.example;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;


@Path("/critical")
public class CriticalResource {

	@LOCK
	@Path("{id}")
	public String lockResource(@PathParam("id") long id) {
		//
		return id + " resource locked";
	}

}
