package servlets;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import dao.Employee;
import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/depts")
public class DeptServlet extends HttpServlet {

	private DeptDAO deptDAO;
	private EmployeeDAO empDAO;
	private DeptSortService deptSortService;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		deptDAO = new DeptDAOImpl(config.getServletContext());
		empDAO = new EmployeeDAOImpl();
		deptSortService = new DeptSortService();
//		deptDAO.save(new Dept(1,"HR","Blr"));
//		deptDAO.save(new Dept(2,"HR","Ahm"));
//		deptDAO.save(new Dept(3,"Dev","Blr"));
//		deptDAO.save(new Dept(4,"Dev","Bhm"));
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String column = req.getParameter("column"); // column to sort by
        String order = req.getParameter("order"); 
//        HttpSession session = req.getSession();
		
        if (column == null || order == null) {
            column = "id";
            order = "asc";
        }
        
       
		req.setAttribute("dept", deptDAO.first());
		Dept dept = deptDAO.first();
		HttpSession session = req.getSession();
		Dept current;
//		session.setAttribute("current", deptDAO.first());
		if(session.getAttribute("current")==null) {
			current = (Dept) deptDAO.first();
		}else {
			current = (Dept)session.getAttribute("current");
		}
		req.setAttribute("employee", deptDAO.showEmployeeByDeptId(dept.getId()));
		System.out.println("id in servlet "+dept.getId());
		List<Employee> employeeList=deptDAO.showEmployeeByDeptId(current.getId());
		
//		if ("asc".equals(order)) {
//		    order = "desc"; // Change to descending if currently ascending
//		} else {
//		    order = "asc"; // Change to ascending if currently descending
//		}
//		
		 List<Employee> sortedEmployees = deptSortService.sortEmployees(employeeList,column, order);
//		 req.setAttribute("employee", deptDAO.sortEmployees(employeeList,column, order));
	        // Set sorted employee list as an attribute for JSP
	        req.setAttribute("employee", sortedEmployees);    
	        session.setAttribute("current", current);
	        session.setAttribute("employee", sortedEmployees);
	        req.setAttribute("dept", current);
		req.getRequestDispatcher("dept.jsp").forward(req, resp);
//		req.setAttribute("dept", deptDAO.getDept(1));
//		req.getRequestDispatcher("dept.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String operation = req.getParameter("operation");
		 String searchName = req.getParameter("name");
		 String searchAge = req.getParameter("age");
		 String searchSal = req.getParameter("salary");
		 String searchExp = req.getParameter("exp");
		 String searchLevel = req.getParameter("level");
		HttpSession session = req.getSession();
		Dept current = (Dept) session.getAttribute("current");
		System.out.println("------------------------------------------------------------------");
	      System.out.println("name in servlet "+searchSal);
	      
	     
	      List<Employee> employeesSearch; 
		if(current == null) { 
			current=deptDAO.first();
		}else {
			if("First".equals(operation)) {
				current=deptDAO.first();
			}else if("Last".equals(operation)) {
				current=deptDAO.last();
			}else if("Previous".equals(operation)) {
				current = deptDAO.previous(current.getId());
			}else if("Next".equals(operation)){
				System.out.println("Dept id in next "+current.getId());
				current = deptDAO.next(current.getId());
			}
		}
		
		 //Search algo
		employeesSearch = deptDAO.showEmployeeByDeptId(current.getId());
		if("Search".equals(operation)) {
			if(searchName !=null)
				employeesSearch = employeesSearch.stream().filter(employee ->employee.getName().toLowerCase().contains(searchName.toLowerCase())).collect(Collectors.toList());
			if(!searchAge.isEmpty()) {
				if(searchAge.charAt(0)=='>') {
					String age = searchAge.substring(1);
					employeesSearch = employeesSearch.stream().filter(employee ->employee.getAge()>Integer.parseInt(age)).collect(Collectors.toList());
				}else if(searchAge.charAt(0)=='<') {
					String age = searchAge.substring(1);
					employeesSearch = employeesSearch.stream().filter(employee ->employee.getAge()<Integer.parseInt(age)).collect(Collectors.toList());
				}else {
					employeesSearch = employeesSearch.stream().filter(employee ->employee.getAge()==Integer.parseInt(searchAge)).collect(Collectors.toList());
				}
//				employeesSearch = employeesSearch.stream().filter(employee ->employee.getAge()==Integer.parseInt(searchAge)).collect(Collectors.toList());
			}
			if(!searchSal.isEmpty())
				if(searchSal.charAt(0)=='>') {
					String sal = searchSal.substring(1);
					employeesSearch = employeesSearch.stream().filter(employee ->employee.getSalary()>Integer.parseInt(sal)).collect(Collectors.toList());
				}else if(searchSal.charAt(0)=='<') {
					String sal = searchSal.substring(1);
					employeesSearch = employeesSearch.stream().filter(employee ->employee.getSalary()<Integer.parseInt(sal)).collect(Collectors.toList());
				}else {
					employeesSearch = employeesSearch.stream().filter(employee ->employee.getSalary()==Integer.parseInt(searchSal)).collect(Collectors.toList());
				}
//				employeesSearch = employeesSearch.stream().filter(employee ->Float.compare(employee.getSalary(), Float.parseFloat(searchSal)) ==0).collect(Collectors.toList());
			if(!searchExp.isEmpty())
				if(searchExp.charAt(0)=='>') {
					String exp = searchExp.substring(1);
					employeesSearch = employeesSearch.stream().filter(employee ->employee.getExperience()>Integer.parseInt(exp)).collect(Collectors.toList());
				}else if(searchExp.charAt(0)=='<') {
					String exp = searchExp.substring(1);
					employeesSearch = employeesSearch.stream().filter(employee ->employee.getExperience()<Integer.parseInt(exp)).collect(Collectors.toList());
				}else {
					employeesSearch = employeesSearch.stream().filter(employee ->employee.getExperience()==Integer.parseInt(searchExp)).collect(Collectors.toList());
				}
//				employeesSearch = employeesSearch.stream().filter(employee ->employee.getExperience()==Integer.parseInt(searchExp)).collect(Collectors.toList());
			if(!searchLevel.isEmpty())
				if(searchLevel.charAt(0)=='>') {
					String level = searchLevel.substring(1);
					employeesSearch = employeesSearch.stream().filter(employee ->employee.getLevel()>Integer.parseInt(level)).collect(Collectors.toList());
				}else if(searchLevel.charAt(0)=='<') {
					String level = searchLevel.substring(1);
					employeesSearch = employeesSearch.stream().filter(employee ->employee.getLevel()<Integer.parseInt(level)).collect(Collectors.toList());
				}else {
					employeesSearch = employeesSearch.stream().filter(employee ->employee.getLevel()==Integer.parseInt(searchLevel)).collect(Collectors.toList());
				}
//				employeesSearch = employeesSearch.stream().filter(employee ->employee.getLevel()==Integer.parseInt(searchLevel)).collect(Collectors.toList());
			System.out.println("Search" +employeesSearch);
		}
		
//      if(searchName != null) {
//      	if(searchName == "name")
//      		employeesSearch = employeesSearch.stream().filter(employee ->employee.getName().toLowerCase().contains("bond".toLowerCase())).collect(Collectors.toList());
//      }
		session.setAttribute("current", current);
		//expression in jsp can work with session also....
		req.setAttribute("dept", current);
		req.setAttribute("employee", employeesSearch);
		Cookie[] cookies= req.getCookies();
		for (int i = 0; i < cookies.length; i++) {
			System.out.println(cookies[i].getName()+" "+cookies[i].getValue());
		}
		
//		req.setAttribute("employee", deptDAO.showEmployeeByDeptId(current.getId()));
		resp.addCookie(new Cookie("operation",operation));
		req.getRequestDispatcher("dept.jsp").forward(req, resp);
	}
}
