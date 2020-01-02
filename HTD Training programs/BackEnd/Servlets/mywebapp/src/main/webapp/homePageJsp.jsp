<%@page import="com.cg.mywebapp.beans.EmployeeInfoBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page session="false" %>
    <%HttpSession session=request.getSession(false);
    EmployeeInfoBean employeeInfoBean=(EmployeeInfoBean)session.getAttribute("employeeInfoBean");
    String msg=(String)request.getAttribute("msg");
    %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3 style='color:orange'>Welcome <%=employeeInfoBean.getEname()%></h3>
	<a href="./addEmployeeJspForm"><br>Add Employee </a>
	<a href="./updateEmployeeJsp"><br>Update Employee </a>
	<a href="./deleteEmployeeJspForm"><br>Delete Employee </a>
	<a href="./searchEmployeeJspForm"><br>Search Employee </a>
	<a href="./seeAllEmployees"><br>Search All Employees</a>
	<br><br>
	<a href="./logout2">Logout</a>
</body>
</html>