package day4;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import day2.Car;
import day4.Employee.Gender;

class EmployeeTest {

	@Test 
	void testCompareByLevel() {
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(Employee.builder().id(1).name("Hemant").age(24).salary(20000).gender(Gender.MALE).level(1).experience(3).build());
		employees.add(Employee.builder().id(2).name("Jenny").age(22).salary(15000).gender(Gender.FEMALE).level(2).experience(2).build());
		employees.add(Employee.builder().id(3).name("Travis").age(27).salary(30000).gender(Gender.MALE).level(1).experience(5).build());
		employees.add(Employee.builder().id(4).name("Lily").age(23).salary(12000).gender(Gender.FEMALE).level(3).experience(1).build());
		
		
		
//		employees.sort(Employee.compareByGender);
//		employees.sort(Employee.compareBySalary);
//		employees.sort(Employee.compareByLevel);
//		employees.sort(Employee.compareByExperience);
		
		Collections.sort(employees);
		
//		Set<Employee> myEmp= employees.stream().map(emp -> emp.getLevel()).collect(Collectors.toSet());
		
		for(Employee e : employees) {
			System.out.println(e);
		}
//		assertEquals(Gender.MALE, employees.get(0).getGender());
		
		List<Employee> myEmp= employees.stream().filter(emp -> emp.getLevel() == 1).collect(Collectors.toList());
		System.out.println("Employees sorted by level : "+myEmp);
		
		System.out.println("Salary"+myEmp.stream().mapToDouble(Employee::getSalary).sum());//:: is k/a method reference
		
		System.out.println("Employees sorted by gender : "+employees.stream().filter(emp -> emp.getGender() == Gender.FEMALE).collect(Collectors.toList()));
		
	
//		System.out.println(employees.stream().map(Employee::getSalary));
		
		final int[] totalSalary= {0};
		myEmp.stream().forEach(e->totalSalary[0]+=e.getSalary());
		System.out.println("Sum of all employees sorted by level : "+totalSalary[0]);
		
 		
		System.out.println("Employees sorted by name : "+employees.stream().filter(emp->emp.getName().toLowerCase().contains(Character.toString('E').toLowerCase())).collect(Collectors.toList()));
		
		System.out.println("Employees sorted by name : "+employees.stream().filter(emp->emp.getName().contains(Character.toString('e'))).collect(Collectors.toList()));
		
		System.out.println("Employees sorted by name : "+employees.stream().filter(emp->emp.getName().equalsIgnoreCase("e")).collect(Collectors.toList()));
		
		System.out.println("Employees sorted by level and gender : "+employees.stream().filter(emp -> emp.getGender() == Gender.FEMALE && emp.getLevel()==1).collect(Collectors.toList()));
		
		Map<Gender,List<Employee>> employeeByGender = employees.stream().collect(Collectors.groupingBy(Employee::getGender));
		employeeByGender.forEach((gender,empList)->{
			System.out.println("Gender : "+ gender);
			empList.forEach(emp->System.out.println(" "+emp.getLevel()+" - "+emp.getSalary()));
		});
	}
	
	
	@Test
	void testByLevel()
	{
		
	}
	
	@Test
	void testhashcode() {
//		Employeee emp=new Employee();
//		int hash=car.hashCode();
//		System.out.println(car+" "+car.hashCode());
//		assertEquals(hash,car.hashCode());
//		assertEquals(hash,new Car("Honda","City","VX",2024,7).hashCode());
////		assertEquals("Honda City VX 2024 Version 7",car.toString());
//		car.setVariant("ZX");
//		assertEquals("Honda City ZX 2024 Version 7",car.toString());
	}
}
