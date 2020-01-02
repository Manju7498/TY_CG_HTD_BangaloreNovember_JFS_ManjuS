<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html><body>
	<a href="./home">Home</a>
	<a href="./logout" style='float: right'>Logout</a>
	<form action="./changepassword" method="post">
		<table align="center">
			<tr>
				<td>Enter Password</td>
				<td><input type="password" name="password"></td>
				<td><input type="submit" value="change password"></td>
			</tr>
		</table>
	</form>
</body>
</html>