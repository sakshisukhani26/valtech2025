<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Counters = ${counters}
Current Employee = ${current}
<form action="depts" method="post">
<%
  /*   String column = request.getParameter("column");
    String order = request.getParameter("order");

    // Default to "id" and "asc" if not set
    if (column == null || order == null) {
        column = "id";
        order = "asc";
    }

    // Toggle order for the next click
    String nextOrder = "asc";
    if ("asc".equals(order)) {
        nextOrder = "desc";
    } */
%>

	<table>
		<tr>
			<td>Id</td>
			<td>${dept.id}</td>
		</tr>
		<tr>
			<td>Name</td>
			<td>${dept.name}</td>
		</tr>
		<tr>
			<td>Location</td>
			<td>${dept.location}</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" name="operation" value="First"/>
				<input type="submit" name="operation" value="Previous"/>
				<input type="submit" name="operation" value="Next"/>
				<input type="submit" name="operation" value="Last"/>
			</td>
		</tr>
		<!-- </table>
		</form>
		<form action="depts" method="post">
		<table> -->
		<tr>
			<td>Name : </td>
			<td><input type="text" name="name" /></td>
		</tr>
		<tr>
			<td>Age : </td>
			<td><input type="text" name="age"/></td>
		</tr>
		<tr>
			<td>Salary : </td>
			<td><input type="text" name="salary"/></td>
		</tr>
		<tr>
			<td>Experience : </td>
			<td><input type="text" name="exp"/></td>
		</tr>
		<tr>
			<td>Level : </td>
			<td><input type="text" name="level"/></td>
		</tr>
		<tr>
		<td>
			 <input type="submit" value="Search" name="operation"/>
			 <!-- <button type="submit" value="true" name="search">Search</button> -->
		</td>
		</tr>
		<tr>
			<th><a href="depts?column=id&order=<%= request.getParameter("order") != null && request.getParameter("column").equals("id") && request.getParameter("order").equals("asc") ? "desc" : "asc" %>">Id</a></th>
			<th><a href="depts?column=name&order=<%= request.getParameter("order") != null && request.getParameter("column").equals("name") && request.getParameter("order").equals("asc") ? "desc" : "asc" %>">Name</a></th>
			<th><a href="depts?column=age&order=<%= request.getParameter("order") != null && request.getParameter("column").equals("age") && request.getParameter("order").equals("asc") ? "desc" : "asc" %>">Age</a></th>
			<th><a href="depts?column=gender&order=<%= request.getParameter("order") != null && request.getParameter("column").equals("gender") && request.getParameter("order").equals("asc") ? "desc" : "asc" %>">Gender</a></th>
			<th><a href="depts?column=salary&order=<%= request.getParameter("order") != null && request.getParameter("column").equals("salary") && request.getParameter("order").equals("asc") ? "desc" : "asc" %>">Salary</a></th>
			<th><a href="depts?column=experience&order=<%= request.getParameter("order") != null && request.getParameter("column").equals("experience") && request.getParameter("order").equals("asc") ? "desc" : "asc" %>">Experience</a></th>
			<th><a href="depts?column=level&order=<%= request.getParameter("order") != null && request.getParameter("column").equals("level") && request.getParameter("order").equals("asc") ? "desc" : "asc" %>">Level</a></th>
			<th>Dept_id</th>
			<!-- <th>Actions</th> -->
		</tr>
		
			<%-- <c:forEach items="${employee}" var="e">
			<tr>
				<td>${e.id}</td>
				<td>${e.name}</td>
				<td>${e.age}</td>
				<td>${e.gender}</td>
				<td>${e.salary}</td>
				<td>${e.experience}</td>
				<td>${e.level}</td>
				<td>${e.dept_id}</td>
				<td>
					<a href="employees?operation=Update&id=${e.id}">Update</a>
					<a href="employees?operation=Delete&id=${e.id}">Delete</a>
				</td>
			</tr>
			
		
			<c:forEach var="employee" items="${employeeList}">
            <tr>
                <td>${employee.id}</td>
                <td>${employee.name}</td>
                <td>${employee.age}</td>
                <td>${employee.department}</td>
            </tr>
        </c:forEach>
		</c:forEach>
			 --%>
			<c:forEach items="${employee}" var="e">
			<tr>
				<td>${e.id}</td>
				<td>${e.name}</td>
				<td>${e.age}</td>
				<td>${e.gender}</td>
				<td>${e.salary}</td>
				<td>${e.experience}</td>
				<td>${e.level}</td>
				<td>${e.dept_id}</td>
				<%-- <td>
					<a href="employees?operation=Update&id=${e.id}">Update</a>
					<a href="employees?operation=Delete&id=${e.id}">Delete</a>
				</td> --%>
			</tr>
		</c:forEach>
	</table>
</form>
</body>
</html>