package com.letsprog.learning.protobuf3.ws.service;

import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.commons.lang.StringUtils;

import com.letsprog.learning.protobuf3.dummyfactories.MilkyWayFactory;
import com.letsprog.learning.protobuf3.model.Universe.Galaxy;

@Stateless
@Path("/universe")
public class UniverseWebService {


	

	@GET
	@Path("/{galaxy}")
	@Consumes(MediaType.TEXT_HTML)
	@Produces(MediaType.APPLICATION_OCTET_STREAM)
	public Response getInfo(@PathParam("galaxy") String galaxyName){

		if(StringUtils.equalsIgnoreCase("MilkyWay", StringUtils.remove(galaxyName, ' '))){
			Galaxy milkyWay = MilkyWayFactory.createGalaxy();
			return Response.ok(milkyWay.toByteArray(),MediaType.APPLICATION_OCTET_STREAM).status(200).build();
		}
		
		return Response.status(Status.NOT_FOUND).build();
	}

}
