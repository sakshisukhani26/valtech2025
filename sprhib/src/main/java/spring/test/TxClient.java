package spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.tx.Employee;
import spring.tx.Employee.Gender;
import spring.tx.EmployeeService;

public class TxClient {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("tx-hibernate-annotation.xml");
		EmployeeService es = ctx.getBean(EmployeeService.class);
		System.out.println("GETTING ALL RECORDS");
		es.update(new Employee(10,"Ten",10,100000,Gender.FEMALE,10,10));
		es.getAll().forEach(e -> System.out.println(e));
		ctx.close();
	}

}
