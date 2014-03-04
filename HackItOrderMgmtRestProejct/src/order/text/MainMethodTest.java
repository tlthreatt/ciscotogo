package order.text;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.cisco.order.model.Order;
import com.cisco.order.model.OrderLineItem;

public class MainMethodTest {

	public MainMethodTest() {
		// TODO Auto-generated constructor stub
	}
	
	 public static void main(String[] args) {
		//Location location = new Location();
		//location.setName("test Location");
		 List<OrderLineItem> orderLine = new ArrayList<OrderLineItem>();
			
			Order st = new Order(null,"clachan","1","SUBMITTED",new Date(),new Long(1),orderLine);
			orderLine.add(new OrderLineItem(new Long(1), 10.0));
			orderLine.add(new OrderLineItem(new Long(2), 12.0));
			orderLine.add(new OrderLineItem(new Long(3), 13.0));
			

		Configuration configuration = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);



		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(st);

		session.getTransaction().commit();

		session.close();
		}
}
