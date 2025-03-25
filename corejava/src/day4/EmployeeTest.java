package day4;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import day2.Car;
import day4.Employee.Gender;
import day4.Employee;

class EmployeeTest {

	
	private EmployeeService es = new EmployeeService();
	
	
//	Employee emp = Employee.builder().id(1).name("Hemant").age(24).salary(20000).gender(Gender.MALE).level(1).experience(3).build();
//	Employee emp1 = Employee.builder().id(2).name("Jenny").age(22).salary(15000).gender(Gender.FEMALE).level(2).experience(2).build();
//	Employee emp2 = Employee.builder().id(3).name("Travis").age(27).salary(30000).gender(Gender.MALE).level(1).experience(5).build();
//	Employee emp3 = Employee.builder().id(4).name("Lily").age(23).salary(12000).gender(Gender.FEMALE).level(3).experience(1).build();
	
	List<Employee> employees = new ArrayList<Employee>();
	
	@BeforeEach
	void test() {
//		employees = Employee.employee;
		employees.add(Employee.builder().id(1).name("Hemant").age(24).salary(20000).gender(Gender.MALE).level(1).experience(3).build());
		employees.add(Employee.builder().id(2).name("Jenny").age(22).salary(15000).gender(Gender.FEMALE).level(2).experience(2).build());
		employees.add(Employee.builder().id(3).name("Travis").age(27).salary(30000).gender(Gender.MALE).level(1).experience(5).build());
		employees.add(Employee.builder().id(4).name("Lily").age(23).salary(12000).gender(Gender.FEMALE).level(3).experience(1).build());
	}
	
	@Test
	void testSortEmp() {
		System.out.println("Test Sort Employees");
		Collections.sort(employees);
		System.out.println(employees);
		assertEquals(1, employees.get(0).getId());
	}

	
	@Test 
	void testCompareByGender() {
		
//		final int[] totalSalary= {0};
//  	myEmp.stream().forEach(e->totalSalary[0]+=e.getSalary());
//		System.out.println("Sum of all employees sorted by level : "+totalSalary[0]);
				
		Map<Gender,List<Employee>> employeeByGender = employees.stream().collect(Collectors.groupingBy(Employee::getGender));
		employeeByGender.forEach((gender,empList)->{
			System.out.println("Gender : "+ gender);
			empList.forEach(emp->System.out.println(" "+emp.getLevel()+" - "+emp.getSalary()));
		});
		assertNotNull(employeeByGender);
	}
	
	@Test
	void testTotalSalaryofEmployeeByLevel() {
		assertEquals(50000, es.totalSalaryOfEmployee(es.searchEmployeebyLevel(employees, 1)));
	}
	
	@Test 
	void testTotalSalaryOfEmployeeByGender() {
		System.out.println(" ----====="+es.totalSalaryOfEmployee(es.searchEmployeebyGender(employees, Gender.FEMALE)));
		System.out.println(es.searchEmployeebyGender(employees, Gender.FEMALE));
		assertEquals(27000, es.totalSalaryOfEmployee(es.searchEmployeebyGender(employees, Gender.FEMALE)));
	}
	
	@Test 
	void testTotalSalaryOfEmployeeNameByCase() {
		assertEquals(20000, es.totalSalaryOfEmployee(es.searchEmployeebyNameByCase(employees, 'H')));
	}
	
	@Test 
	void testTotalSalaryOfEmployeeByName() {
		assertEquals(20000, es.totalSalaryOfEmployee(es.searchEmployeebyName(employees, 'H')));
	}
	
	@Test 
	void testTotalSalaryOfEmployeeByLevelAndGender() {
		assertEquals(15000, es.totalSalaryOfEmployee(es.searchEmployeebyLevelAndGender(employees, Gender.FEMALE,2)));
	}
	
	@Test
	void testSearchEmployeeByLevel() {
		assertEquals(2, es.searchEmployeebyLevel(employees, 1).size());
	}
	
	@Test
	void testSearchEmployeeByGender() {
		assertEquals(2, es.searchEmployeebyGender(employees, Gender.FEMALE).size());
	}
	
	@Test
	void testSearchEmployeeNameByCase() {
		assertEquals(2, es.searchEmployeebyGender(employees, Gender.FEMALE).size());
	}
	
	@Test
	void testSearchEmployeeByName() {
		assertEquals(1, es.searchEmployeebyLevelAndGender(employees, Gender.FEMALE,2).size());
	}
	
	@Test
	void testSearchEmployeeByLevelAndGender() {
		assertEquals(1, es.searchEmployeebyLevelAndGender(employees, Gender.FEMALE,2).size());
	}
	
	@Test
	void testhashcode() {
		Employee emp=new Employee(1,"Sakshi",23,30000,Gender.FEMALE,1,2);
		int hash = emp.hashCode();
		assertEquals(hash, new Employee(1,"Sakshi",23,30000,Gender.FEMALE,1,2).hashCode());
		emp.setSalary(40000);
		assertNotEquals(hash,emp.hashCode());
	}
	
	@Test
	void testEquals() {
		Employee emp=new Employee(1,"Sakshi",23,30000,Gender.FEMALE,1,2);
		Employee emp2=new Employee(1,"Sakshi",23,30000,Gender.FEMALE,1,2);
		assertTrue(emp.equals(emp));
	}
}
