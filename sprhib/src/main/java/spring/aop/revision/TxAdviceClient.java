package spring.aop.revision;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.tx.Employee;
import spring.tx.Employee.Gender;

public class TxAdviceClient {

	public static void main(String[] args) {
		ApplicationContext appCtx = new ClassPathXmlApplicationContext("txAdvice.xml");
		EmployeeDAO dao = (EmployeeDAO) appCtx.getBean("employeeDAO");
		SessionFactory sesFac = appCtx.getBean(SessionFactory.class);
		dao.save(sesFac.openSession(), new Employee(11,"TxGuy",23,12000,Gender.MALE,3,1));
	}
}
