package order.text;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cisco.order.model.Order;
import com.cisco.order.model.OrderLineItem;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

public class JerseyClient {

	public static void main(String[] args) {
		try {

			//Order st = new Order(0, "clachan", "dfs", "TEdfST" + (Integer.MIN_VALUE + (int)(Math.random() * ((100 - 1) + 1))), 9, "NEW");
			List<OrderLineItem> orderLine = new ArrayList<OrderLineItem>();
			
			Order st = new Order(null,"clachan","1","SUBMITTED",new Date(),new Long(1),orderLine);
			orderLine.add(new OrderLineItem(st, new Long(1), 10.0));
			ClientConfig clientConfig = new DefaultClientConfig();

			clientConfig.getFeatures().put(
					JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);

			Client client = Client.create(clientConfig);

			WebResource webResource = client
					.resource("http://localhost:10080/HackItOrderMgmtRestProject/rest/order/JCreate");
			
			
			ClientResponse response = webResource.accept("application/json")
					.type("application/json").post(ClientResponse.class, st);

			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatus());
			}

			String output = response.getEntity(String.class);

			System.out.println("Server response .... \n");
			System.out.println(output);

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}