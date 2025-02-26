package spring.ioc.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.ioc.SimpleInterest;
import spring.ioc.UtilsBean;

class IOCTest {

	@Test
	void testUtils() {
		ClassPathXmlApplicationContext utils = new ClassPathXmlApplicationContext("utils.xml");
		UtilsBean bean = (UtilsBean) utils.getBean("utils");
		System.out.println(bean.getNames());
		bean.getPoints().forEach(t -> System.out.println(t));
		System.out.println(bean.getNumbers());
		System.out.println(bean.getProps());
		try {
			SimpleInterest si = (SimpleInterest) utils.getBean("siAbs");
			System.out.println(si.compute(200, 3, 4));
			fail("No exception thrown....");
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
		SimpleInterest si = (SimpleInterest) utils.getBean("si");
		System.out.println(si.compute(200, 3, 4));
	}
	
	@Test
	void testParentChild() {
		ClassPathXmlApplicationContext parent = new ClassPathXmlApplicationContext("parent.xml");
		ClassPathXmlApplicationContext child = new ClassPathXmlApplicationContext(new String[] {"child.xml"},parent);
		System.out.println("Parent child = "+child.getBean("line"));
	}
	
	@Test
	void test() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ioc.xml");
		SimpleInterest si = (SimpleInterest) context.getBean("si");
		assertEquals(200, si.compute(200, 20, 5));
		System.out.println(context.getBean("p"));
		System.out.println(context.getBean("p1"));
		System.out.println(context.getBean("l"));
		System.out.println(context.getBean("l1"));
		context.close();
	}

}
