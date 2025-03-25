package servlets;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import dao.Employee;

public class DeptSortService {

	
	 public List<Employee> sortEmployees(List<Employee> employeeList,String column, String order) {
	        Comparator<Employee> comparator = null;
	        
	        // Choose the comparator based on the selected column
	        switch (column) {
	            case "id":
//	            	comparator = (a,b) -> a.getId() - b.getId();
	                comparator = Comparator.comparing(Employee::getId);
	                break;
	            case "name":
	                comparator = Comparator.comparing(Employee::getName);
	                break;
	            case "age":
	                comparator = Comparator.comparing(Employee::getAge);
	                break;
	            case "salary":
	                comparator = Comparator.comparing(Employee::getSalary);
	                break;
	            case "experience":
	                comparator = Comparator.comparing(Employee::getExperience);
	                break;
	            case "gender":
	                comparator = Comparator.comparing(Employee::getGender);
	                break;
	            case "level":
	                comparator = Comparator.comparing(Employee::getLevel);
	                break;
	            default:
	                throw new IllegalArgumentException("Invalid column: " + column);
	        }

	        // Reverse the comparator for descending order
	        if ("desc".equalsIgnoreCase(order)) {
	            comparator = comparator.reversed();
	        }
	       
	        // Apply the comparator to sort the employee list
	        List<Employee> sortedList = employeeList.stream()
	                .sorted(comparator)
	                .collect(Collectors.toList());
	        return sortedList;
	    }
}
