package com.letsprog.learning.protobuf3.ws.client;

import java.io.IOException;
import java.io.InputStream;

import javax.ws.rs.core.MediaType;

import org.apache.commons.io.IOUtils;

import com.letsprog.learning.protobuf3.dto.Universe.Galaxy;
import com.letsprog.learning.protobuf3.dummyfactories.MilkyWayFactory;

public class WSClientConsumingProtobuf {


	public static void main(String[] args) throws IOException {

		String serverContext = "learning-protobuf3-ws-service";
		String servicePath = "ws/universe/milkyway";
		String serviceHost = "localhost";
		Integer servicePort = 8080;
		
		javax.ws.rs.client.Client client = javax.ws.rs.client.ClientBuilder.newClient();
		
		javax.ws.rs.client.WebTarget target = client.target("http://"+serviceHost+":"+servicePort+"/"+serverContext)
													.path(servicePath);


		InputStream galaxyByteString = target.request(MediaType.TEXT_HTML)
				.header("accept",MediaType.APPLICATION_OCTET_STREAM)
				.get(InputStream.class);

		Galaxy galaxy = Galaxy.parseFrom(IOUtils.toByteArray(galaxyByteString));

		MilkyWayFactory.displayInfo(galaxy);

	}
}
