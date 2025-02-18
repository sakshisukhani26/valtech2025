package servlets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import dao.Employee;
import jakarta.servlet.ServletContext;

public class DeptDAOImpl implements DeptDAO {
//	static {
//		try {
//			Class.forName("org.postgresql.Driver");
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		
//	}
 	ServletContext sc;
  	public DeptDAOImpl(ServletContext sc) {
 		this.sc = sc;
	}
  	
	private Connection getConnection(ServletContext sc) throws SQLException{
		String url = (String)sc.getAttribute("dbUrl");
		String user = (String)sc.getAttribute("dbUser");
		String pass = (String)sc.getAttribute("dbPass");
		return DriverManager.getConnection
				(url,user,pass);
	}

//	private Map<Integer,Dept> depts;
	List<Dept> depts = new ArrayList<Dept>();
//    private List<Employee> employeeList;
//	public DeptDAOImpl() {
//		depts = new HashMap<Integer, Dept>();
//	}
	
	@Override
	public void save(Dept dept) {
//		depts.put(dept.getId(),dept);
		try(Connection con= getConnection(this.sc)){
			PreparedStatement ps= con.prepareStatement
					("INSERT INTO DEPT (NAME,LOCATION,DEPT_ID) VALUES(?,?,?)");
			setValuesToPreparedStatement(dept, ps);
			int rowsAffected = ps.executeUpdate();
			System.out.println("Rows inserted = "+rowsAffected);
		}catch(Exception ex) {
			throw new RuntimeException(ex);
		}
	}
	
	private void setValuesToPreparedStatement(Dept dept, PreparedStatement ps) throws SQLException {
		ps.setString(1, dept.getName());
		ps.setString(2, dept.getLocation());
		ps.setInt(3, dept.getId());
	}
	
	@Override
	public void update(Dept dept) {
//		depts.put(dept.getId(), dept);
		try(Connection con= getConnection(this.sc)){
			PreparedStatement ps= con.prepareStatement
					("UPDATE DEPT SET NAME=?,LOCATION=? WHERE DEPT_ID= ?");
			setValuesToPreparedStatement(dept, ps);
			int rowsAffected= ps.executeUpdate();
			System.out.println("Rows Updated = "+rowsAffected);
		}catch(Exception err) {
			throw new RuntimeException(err);
		}
	}
	
	@Override
	public Dept getDept(int id) {
//		return depts.get(id);
		try(Connection con= getConnection(this.sc)){
			PreparedStatement ps= con.prepareStatement
					("SELECT DEPT_ID,NAME,LOCATION FROM DEPT WHERE DEPT_ID=?");
			ps.setInt(1, id);
			ResultSet rs= ps.executeQuery();
			if(rs.next()) {
				Dept dept= populateDept(rs);
				return dept;
			}else {
				new RuntimeException("No employee with Id "+id+" found.");
			}
		}catch(Exception ex) {
			throw new RuntimeException(ex);
		}
		return null;
	}
	
	public Dept populateDept(ResultSet rs) throws SQLException{
		return Dept.builder().id(rs.getInt(1)).name(rs.getString(2)).location(rs.getString(3)).build();
	}
	
	@Override
	public void delete(int id) {
		depts.remove(id);
	}
	
//	@Override
//	public Set<Dept> getAll(){
//		Set<Dept> all = new HashSet<Dept>();
//		for(int id : depts.keySet()) {
//			all.add(depts.get(id));
//		}
//		return all;
//	}
	
	@Override
	public List<Dept> getAll() {
		List<Dept> depts = new ArrayList<Dept>();
		try (Connection con= getConnection(this.sc)){
			PreparedStatement ps= con.prepareStatement("SELECT DEPT_ID,NAME,LOCATION FROM DEPT");
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				depts.add(populateDept(rs));
			}
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
		return depts;
	}

	@Override
	public Dept first() {
		depts = getAll();
		System.out.println(depts);
//		return null;
		return depts.stream() .min((a, b) -> Integer.compare(a.getId(), b.getId())).orElse(null);
	}

	@Override
	public Dept last() {
//		return depts.get(depts.keySet().stream().max((a,b) -> (a - b)).get());
//		return null;
		return depts.stream() .max((a, b) -> Integer.compare(a.getId(), b.getId())).orElse(null);
	}

	@Override
	public Dept next(int id) {
		System.out.println("id---------------------"+id);
		if(id == depts.size()) return getDept(depts.size());
		return getDept(id+1);
	}

	@Override
	public Dept previous(int id) {
		if(id == 1) return getDept(1);
		return getDept(id-1);
	}

	@Override
	public List<Employee> showEmployeeByDeptId(int id) {
		List<Employee> employee = new ArrayList<Employee>();
		try(Connection con= getConnection(this.sc)){
			PreparedStatement ps= con.prepareStatement
					("SELECT ID,NAME,AGE,GENDER,SALARY,EXPERIENCE,LEVEL,DEPT_ID FROM EMPLOYEE WHERE DEPT_ID=?");
			ps.setInt(1, id);
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				employee.add(populateEmployee(rs));
			}
		}catch(Exception ex) {
			throw new RuntimeException(ex);
		}
		System.out.println("employee"+employee);
		return employee;
	}
	
	public Employee populateEmployee(ResultSet rs) throws SQLException{
		return Employee.builder().id(rs.getInt(1)).name(rs.getString(2)).age(rs.getInt(3)).gender(dao.Employee.Gender.valueOf(rs.getString(4))).salary(rs.getFloat(5)).experience(rs.getInt(6)).level(rs.getInt(7)).dept_id(rs.getInt(8)).build();
	}
	
//	public void sortByName() {
//		
//	}
	
	  public List<Employee> sortEmployees(List<Employee> employeeList,String column, String order) {
	        Comparator<Employee> comparator = null;
	        
	        // Choose the comparator based on the selected column
	        switch (column) {
	            case "id":
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
