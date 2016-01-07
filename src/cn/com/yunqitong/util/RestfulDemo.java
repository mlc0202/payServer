package cn.com.yunqitong.util;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.MediaType;
import org.apache.log4j.Logger;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class RestfulDemo {
	private static final Logger log = Logger.getLogger(RestfulDemo.class
			.getName());

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String url = PropertyFactory.getProperty("ZOOMADDR");
		log.debug("url = " + url);
		Client client = Client.create();
		WebResource webResource = client.resource(url);
		String buf = "";
		log.info("parameter = " + buf);
		ClientResponse res = webResource.path("syncDevice")
				.type(MediaType.APPLICATION_JSON)
				.post(ClientResponse.class, buf);
		log.info("response status = " + res.getStatus());
		String textEntity = res.getEntity(String.class); 
	}

}
