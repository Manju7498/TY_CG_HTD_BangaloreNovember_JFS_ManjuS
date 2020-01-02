<%@page import="com.cg.mywebapp.beans.EmployeeInfoBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page session="false"%>
<%String msg= (String)request.getAttribute("msg"); %>
<%List<EmployeeInfoBean> employeesList=
                (List<EmployeeInfoBean>)request.getAttribute("employeelist");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>
		<a href="./home">Home</a>
	</h3>
	<% if(employeesList!=null && !employeesList.isEmpty()) { %>
	<table>
		<tr>
			<th>Emp Id</th>
			<th>name</th>
			<th>Age</th>
			<th>Salary</th>
			<th>Designation</th>
		</tr>
		<% for(EmployeeInfoBean employeeInfoBean:employeesList) { %>
		<tr>
			<td><%=employeeInfoBean.getEmpId() %></td>
			<td><%=employeeInfoBean.getEname() %></td>
			<td><%=employeeInfoBean.getAge() %></td>
			<td><%=employeeInfoBean.getSalary() %></td>
			<td><%=employeeInfoBean.getDesignation()%></td>
		</tr>
		<% } %>
	</table>
	<% } %>
	<% if(msg!=null && !msg.isEmpty()) { %>
	<h3 style='color: orange'><%=msg %></h3>
	<% } %>
</body>
</html>