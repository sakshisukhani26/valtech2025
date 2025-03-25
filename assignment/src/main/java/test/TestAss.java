package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;



import hibernate.Customer;
import hibernate.Customer.CustomerStatus;
import hibernate.Items;
import hibernate.LineItem;
import hibernate.Orders;
import hibernate.Orders.Status;
import spring.CustomerDAO;
import spring.CustomerDAOImpl;
import spring.CustomerService;
import spring.CustomerServiceImpl;
import spring.ItemDAOImpl;
import spring.OrderDAOImpl;
import spring.OrderServiceImpl;
import spring.OrderStatusService;

class TestAss {

//	@Test
//	void test() {
//		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
//		Customer c = (Customer) ctx.getBean("customer");
//		System.out.println(c.getClass().getName());
//		CustomerDAOImpl dao = ctx.getBean(CustomerDAOImpl.class);
//		dao.save(new Customer("Def",23,"Nehru Nagar","Nehru Nagar"));
//		System.out.println("Helloooo");
////		CustomerDAO dao = new CustomerDAOImpl();
////		dao.save(new Customer("Def",23,"Nehru Nagar","Nehru Nagar"));
//		ctx.close(); 
//	}

	static ClassPathXmlApplicationContext ctx;
	ItemDAOImpl itemdao;
	CustomerServiceImpl cs;
	Customer c;
	CustomerDAOImpl dao ;
	OrderDAOImpl orderdao;
	OrderServiceImpl os;

	@Test
	void test() {
		ctx = new ClassPathXmlApplicationContext("config.xml");
//		cs.addCustomer(new Customer("Def",23,"Kuber Nagar","Kuber Nagar",CustomerStatus.ENABLED));
		itemdao = ctx.getBean(ItemDAOImpl.class);
//		itemdao.save(new Items("Shampoo","It's a shampoo",5,2,10));
		cs = ctx.getBean(CustomerServiceImpl.class);
		c = ctx.getBean(Customer.class);
		System.out.println(c.getClass().getName());
		dao = ctx.getBean(CustomerDAOImpl.class);
		orderdao = ctx.getBean(OrderDAOImpl.class);
		os = ctx.getBean(OrderServiceImpl.class);
		List<LineItem> lineItems = new ArrayList<>();
		 Customer cust = dao.get(2);
		 Orders o = ctx.getBean(Orders.class);
		 o = new Orders(Status.ORDERED);
		 o.setCustomer(cust);
		 Items i = ctx.getBean(Items.class);
		 LineItem lt1 = new LineItem(3);
		 i = itemdao.get(1);
		 lt1.setItem(i);
		 Items i2 = ctx.getBean(Items.class);
		 LineItem lt2 = new LineItem(2);
		 i2 = itemdao.get(2);
		 lt2.setItem(i2);
		 
	    // Assume Item IDs are already known and exist in the database
	    lineItems.add(lt1);
	    // LineItem with ItemID 101 and Qty 2
	    lineItems.add(lt2);
	    o.setLineItems(lineItems);
	    os.createOrder(o);
	    System.out.println("-------------"+itemdao.get(1));
	    assertEquals("Bag", itemdao.get(1).getName());
		assertFalse(lineItems.isEmpty());
//		long id = c.getId();
//		Customer cx = dao.get(1L);
//		cx.setName("Ab");
//		dao.update(cx);
//		System.out.println("Helloooo");
//		Orders o = orderdao.get(1L);
		 OrderStatusService orderstatus = ctx.getBean(OrderStatusService.class);
	        System.out.println("STATUS IS ..."+orderstatus.checkStatus(21));
	        assertEquals("ORDERED", orderstatus.checkStatus(21).name());
	        ctx.close(); 
	}
	
	
}
