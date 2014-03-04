package order.text;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.xc.JaxbAnnotationIntrospector;

import com.cisco.order.model.Order;
import com.cisco.order.model.OrderLineItem;
import com.cisco.order.services.representation.OrderLineItemRepresentation;
import com.cisco.order.services.representation.OrderLineRepresentation;
import com.cisco.order.services.representation.OrderListRepresantation;
import com.cisco.order.services.representation.OrderRepresentation;
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
			
			//Order st = new Order(null,"clachan","1","SUBMITTED",new Date(),new Long(1),orderLine);
			//orderLine.add(new OrderLineItem(st, new Long(1), 10.0));
			//orderLine.add(new OrderLineItem(st, new Long(2), 12.0));
			//orderLine.add(new OrderLineItem(st, new Long(3), 13.0));
			
			//ArrayList<Order> orderList = new ArrayList<Order>();
			//orderList.add(st);
			//OrderListRepresantation listRep = new OrderListRepresantation(orderList);
			ArrayList<OrderLineItemRepresentation> orderLines = new ArrayList<OrderLineItemRepresentation>();
			orderLines.add(new OrderLineItemRepresentation(null,new Long(1), 10.0));
			orderLines.add(new OrderLineItemRepresentation(null,new Long(2), 10.0));
			OrderRepresentation orderRep = new OrderRepresentation(null, "SUBMITTED", new Date(), "1", "clachan", new Long(2), orderLines);
			ClientConfig clientConfig = new DefaultClientConfig();
			
			ObjectMapper mapper = new ObjectMapper();
	         
			AnnotationIntrospector introspector
			    = new JaxbAnnotationIntrospector();
			mapper.setAnnotationIntrospector(introspector);
			         
			// Printing JSON
			/**String result = mapper.writeValueAsString(orderRep);
			String result3 = mapper.writeValueAsString(listRep);
			System.out.println(result3);
			//listRep = mapper.readValue(result,OrderListRepresantation.class);
			//String result2 = mapper.writeValueAsString(orderRep.getOrderLines().get(0));
			System.out.println(result);
			//mapper.readValue(result2, OrderLineRepresentation.class);
			orderRep = mapper.readValue(result, OrderRepresentation.class);
	         
			**/
			clientConfig.getFeatures().put(
					JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);

			Client client = Client.create(clientConfig);

			WebResource webResource = client
					.resource("http://localhost:10080/HackItOrderMgmtRestProject/rest/order/JCreate");
			
			
			ClientResponse response = webResource.accept("application/json")
					.type("application/json").post(ClientResponse.class, orderRep);

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