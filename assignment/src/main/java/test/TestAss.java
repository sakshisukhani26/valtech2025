package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import hibernate.Customer;
import spring.CustomerDAO;
import spring.CustomerDAOImpl;

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

	public static void main(String[] args) {
		
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
//		Customer c = (Customer) ctx.getBean("customer");
//		System.out.println(c.getClass().getName());
		CustomerDAOImpl dao = ctx.getBean(CustomerDAOImpl.class);
//		dao.save(new Customer("Abc",20,"Kamla Nagar","Kamla Nagar"));
//		long id = c.getId();
		Customer cx = dao.get(1L);
		cx.setName("Ab");
		dao.update(cx);
		System.out.println("Helloooo");
		ctx.close(); 
	}
	
}
