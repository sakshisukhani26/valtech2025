package hibernateClient;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import hibernate.Customer;
import hibernate.Items;
import hibernate.LineItem;
import hibernate.Orders;

public class HibernateClient {
	public static void main(String[] args) {
		SessionFactory sesFac = new AnnotationConfiguration().addAnnotatedClass(Customer.class)
//								.addAnnotatedClass(Items.class)
//								.addAnnotatedClass(LineItem.class)
								.addAnnotatedClass(Orders.class)
								.buildSessionFactory();
		Session sess = sesFac.openSession();
		
		Transaction tx = sess.beginTransaction();
		
		//inserting data in Items table
//		Long id = (Long)sess.save(new Items("Bag", "It is a bag", 5, 2, 20));
//		Items items= (Items)sess.load(Items.class, id);
		
		//inserting data in customer table
//		Customer c = new Customer("Abc", 20, "CHB jodhpur", "CHB jodhpur");
//		long id = (Long)sess.save(c);
		
		//inserting into order table
//		List<LineItem> item = new ArrayList<LineItem>();
//		item.add(new LineItem())
		Customer c = (Customer) sess.load(Customer.class, 1L);
		Orders o = new Orders();
		o.setStatus("new");
		o.setCustomer(c);
		o.setLineItems(null);
		sess.save(o);
		
		tx.commit();
		sess.close();
		sesFac.close();
	}
}
