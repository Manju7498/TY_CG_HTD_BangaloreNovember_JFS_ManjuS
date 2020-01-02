<%@page import="com.cg.empwebapp.bean.EmployeeBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:useBean id="bean" class="com.cg.empwebapp.bean.EmployeeBean"
	scope="session"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="./changepassword">Change Password</a>
	<a href="./logout" style='float: right'>Logout</a>

	<h1 style='color: orange'>
		Welcome
		<%=bean.getEmployeeName()%></h1>
	<form action="./search">
		<table>
			<tr>
				<td>Enter key :</td>
				<td><input type="text" name="key"></td>
				<td><input type="submit" name="key"></td>
			</tr>
		</table>
	</form>
	<%
	List<EmployeeBean> list=(List<EmployeeBean>)request.getAttribute("list");
	%>
	<%
	if(list!=null) {
	%>
	<%
	if(list.isEmpty()) {
	%>
	<h3>No Data Found</h3>
	<%
	}else {
	%>
	<!-- To Task -->
	<table>
		<tr>
			<th>Id</th>
			<th>employeeName</th>
			<th>employeeEmail</th>
		</tr>
		<%for(EmployeeBean employee:list) { %>
		<tr>
			<td><%=employee.getEmployeeId() %></td>
			<td><%=employee.getEmployeeName() %></td>
			<td><%=employee.getEmployeeEmail() %></td>
		</tr>
		<%} %>
	</table>
	<% } %>
	<%} %>
</body>
</html>