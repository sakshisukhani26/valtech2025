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
<%-- ${customer.name} --%>

	<table>
	<form action="handleClick" method="post">
		<tr>
			<td>ID</td>
			<td>Name</td>
			<td>Description</td>
			<td>Set Quantity</td>
		</tr>
		<c:forEach items="${item}" var="i">
			<tr>
				<td>${i.id}</td>
				<td>${i.name}</td>
				<td>${i.description}</td>
				<td><input type = "text" name="qty" id = "qty"/></td>
				<td>
				<input type="hidden" name="userId" value="${i.id}"/>
				<input type = "submit" name="${i.id}" value="add"/>
				</td>
			</tr>
		</c:forEach>
		<tr>
		</tr>
		
		<%-- <h2>Place orders</h2>
		
		<tr>
			<td>Id</td>
			<td><input type="text" name="ids" id="ids"/></td>
		</tr>
		<tr>
			<td>Quantity</td>
			<td><input type="text" name="qty" id="qty"/></td>
		</tr>
		<tr>
			<td colspan=2><input type="submit" name="submit" value="add"/></td>
		</tr>
		<c:forEach items="${itemIds}" var="i">
		<tr>
			<td>ID  : ${i}</td>
		</tr>
		</c:forEach>
		<c:forEach items="${itemQty}" var="i">
		<tr>
			<td>Qty  : ${i}</td>
		</tr>
		</c:forEach> --%>
		</form>
	</table>
	
	
</body>
</html>