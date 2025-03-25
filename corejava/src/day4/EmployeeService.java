package day4;

import java.util.List;
import java.util.stream.Collectors;

import day4.Employee.Gender;

public class EmployeeService {

	public List<Employee> searchEmployeebyLevel(List<Employee> employee,int level){
		 return employee.stream().filter(emp -> emp.getLevel() == level).collect(Collectors.toList());
	}
	
	public double totalSalaryOfEmployee(List<Employee> employee){
		 return employee.stream().mapToDouble(Employee::getSalary).sum();
	}
	
	public List<Employee> searchEmployeebyGender(List<Employee> employee,Gender gender){
		 return employee.stream().filter(emp -> emp.getGender() == gender).collect(Collectors.toList());
	}
	
	public List<Employee> searchEmployeebyNameByCase(List<Employee> employee,char ch){
		 return employee.stream().filter(emp->emp.getName().toLowerCase().contains(Character.toString(ch).toLowerCase())).collect(Collectors.toList());
	}
	
	public List<Employee> searchEmployeebyName(List<Employee> employee,char ch){
		 return employee.stream().filter(emp->emp.getName().contains(Character.toString(ch))).collect(Collectors.toList());
	}
	
	public List<Employee> searchEmployeebyLevelAndGender(List<Employee> employee,Gender gender,int level){
		 return employee.stream().filter(emp -> emp.getGender() == gender && emp.getLevel()==level).collect(Collectors.toList());
	}
}
