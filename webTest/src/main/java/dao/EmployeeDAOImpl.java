package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class EmployeeDAOImpl implements EmployeeDAO{

	static {
		try {
			Class.forName("org.postgresql.Driver");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
//	private DataSource dataSource;
	
	
	
	private Connection getConnection() throws SQLException{
		return DriverManager.getConnection
				("jdbc:postgresql://localhost:5432/training","postgres","postgres");
//		return dataSource.getConnection();
	}
	@Override
	public void save(Employee e) {
		try(Connection con= getConnection()){
			PreparedStatement ps= con.prepareStatement
					("INSERT INTO EMPLOYEE (NAME,AGE,GENDER,SALARY,EXPERIENCE,LEVEL,DEPT_ID,ID) VALUES(?,?,?,?,?,?,?,?)");
			setValuesToPreparedStatement(e, ps);
			System.out.println("ID"+e.getDept_id());
			int rowsAffected = ps.executeUpdate();
			System.out.println("Rows inserted = "+rowsAffected);
		}catch(Exception ex) {
			throw new RuntimeException(ex);
		}
	}
	private void setValuesToPreparedStatement(Employee e, PreparedStatement ps) throws SQLException {
		ps.setString(1, e.getName());
		ps.setInt(2, e.getAge());
		ps.setString(3, e.getGender().name());
		ps.setFloat(4, e.getSalary());
		ps.setInt(5, e.getExperience());
		ps.setInt(6, e.getLevel());
		ps.setInt(7, e.getDept_id());
		ps.setLong(8, e.getId());
	}

	@Override
	public void update(Employee e) {
		try(Connection con= getConnection()){
			PreparedStatement ps= con.prepareStatement
					("UPDATE EMPLOYEE SET NAME=?,AGE=?,GENDER=?,SALARY=?,EXPERIENCE=?,LEVEL=?,DEPT_ID=? WHERE ID= ?");
			setValuesToPreparedStatement(e, ps);
			int rowsAffected= ps.executeUpdate();
			System.out.println("Rows Updated = "+rowsAffected);
		}catch(Exception err) {
			throw new RuntimeException(err);
		}
	}

	@Override
	public void delete(int id) {
		try(Connection con= getConnection()){
			PreparedStatement ps= con.prepareStatement
					("DELETE FROM EMPLOYEE WHERE ID=?");
			ps.setInt(1, id);
//			ResultSet rs= ps.executeQuery();
			int rowsAffected =ps.executeUpdate();
			System.out.println("Rows Deleted = "+rowsAffected);
		}catch(Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	@Override
	public Employee get(int id) {
		try(Connection con= getConnection()){
			PreparedStatement ps= con.prepareStatement
					("SELECT ID,NAME,AGE,GENDER,SALARY,EXPERIENCE,LEVEL,DEPT_ID FROM EMPLOYEE WHERE ID=?");
			ps.setInt(1, id);
			ResultSet rs= ps.executeQuery();
			if(rs.next()) {
				Employee e= populateEmployee(rs);
				return e;
			}else {
				new RuntimeException("No employee with Id "+id+" found.");
			}
		}catch(Exception ex) {
			throw new RuntimeException(ex);
		}
		return null;
	}

	public Employee populateEmployee(ResultSet rs) throws SQLException{
		return Employee.builder().id(rs.getInt(1)).name(rs.getString(2)).age(rs.getInt(3)).gender(dao.Employee.Gender.valueOf(rs.getString(4))).salary(rs.getFloat(5)).experience(rs.getInt(6)).level(rs.getInt(7)).dept_id(rs.getInt(8)).build();
	}

	@Override
	public List<Employee> getAll() {
		List<Employee> emps = new ArrayList<Employee>();
		try (Connection con= getConnection()){
			PreparedStatement ps= con.prepareStatement("SELECT ID,NAME,AGE,GENDER,SALARY,EXPERIENCE,LEVEL,DEPT_ID FROM EMPLOYEE");
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				emps.add(populateEmployee(rs));
			}
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
		return emps;
	}

}
