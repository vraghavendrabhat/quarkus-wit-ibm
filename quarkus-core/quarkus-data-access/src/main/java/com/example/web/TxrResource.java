package com.example.web;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.example.service.TxrService;

@Path("/api/txr")
public class TxrResource {

	@Inject
	TxrService txrService;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public TxrResponse doTxr(TxrRequest request) {
		txrService.txr(request.getAmount(), request.getFromAccNumber(), request.getToAccNumber());
		TxrResponse response = new TxrResponse();
		response.setMessage("Txr sucessfull");
		return response;
	}

}
