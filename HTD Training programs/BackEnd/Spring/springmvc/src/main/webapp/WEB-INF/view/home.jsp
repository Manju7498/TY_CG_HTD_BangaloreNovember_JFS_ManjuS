<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean id="user" class="com.cg.springmvc.bean.User" scope="session"/>
<html>
<body>
	<h1>Welcome <%=user.getName() %></h1>
</body>
</html>