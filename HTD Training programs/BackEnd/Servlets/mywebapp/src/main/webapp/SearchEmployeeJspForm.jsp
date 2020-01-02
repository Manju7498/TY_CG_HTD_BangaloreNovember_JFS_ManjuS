<%@page import="com.cg.mywebapp.beans.EmployeeInfoBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page session="false" %>
    <%EmployeeInfoBean employeeInfoBean=(EmployeeInfoBean)request.getAttribute("employeeInfoBean"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<fieldset>
		<legend>search Employee</legend>
		<form action="./searchEmployee3" method="get">
			Employee Id : <input type="number" name="empId" required > <br>
			<input type="submit" value="search">
		</form>
	</fieldset>
	<br><br>
	<%if(employeeInfoBean==null) { %>
	<h3 style='color:red'>Employee Id not found</h3>
	<%} else { %>
	<h3 style='color:green'>Details for employee Id : <%=employeeInfoBean.getEmpId() %></h3>
	<br>Employee Name : <%=employeeInfoBean.getEname() %>
	<br> Age : <%=employeeInfoBean.getAge() %>
	<br>Salary : <%=employeeInfoBean.getSalary() %>
	<br>Designation: <%=employeeInfoBean.getDesignation() %>
	<%} %>
</body>
</html>