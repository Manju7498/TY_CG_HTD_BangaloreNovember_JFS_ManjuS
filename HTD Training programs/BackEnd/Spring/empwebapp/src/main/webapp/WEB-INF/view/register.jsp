<html>
<body>
	<form action="./register" method="post">
		<fieldset>
			<legend>Employee Details</legend>
			<table>
				<tr>
					<td>Employee Name:</td>
					<td><input type="text" name="employeeName"></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><input type="email" name="employeeEmail"></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" name="password"></td>
				</tr>
			</table>
		</fieldset>
		<fieldset>
			<legend>Employee Address Details 1</legend>
			<table>
				<tr>
					<td>Address Type:</td>
					<td><select name="addressBeans[0].addType">
							<option>----------Select-----------</option>
							<option value="permanent">Permanent</option>
							<option value="temporary">Temporary</option>
					</select></td>
				</tr>
				<tr>
					<td>Address1:</td>
					<td><input type="text" name="addressBeans[0].address1"></td>
				</tr>
				<tr>
					<td>Address2:</td>
					<td><input type="text" name="addressBeans[0].address2"></td>
				</tr>
			</table>
		</fieldset>
		<fieldset>
			<legend>Employee Address Details 2</legend>
			<table>
				<tr>
					<td>Address Type:</td>
					<td><select name="addressBeans[1].addType">
							<option>----------Select-----------</option>
							<option value="permanent">Permanent</option>
							<option value="temporary">Temporary</option>
					</select></td>
				</tr>
				<tr>
					<td>Address1:</td>
					<td><input type="text" name="addressBeans[1].address1"></td>
				</tr>
				<tr>
					<td>Address2:</td>
					<td><input type="text" name="addressBeans[1].address2"></td>
				</tr>
			</table>
		</fieldset>
		<table>
			<tr>
				<td><input type="submit" value="Register"></td>
				<td><input type="reset" value="Reset"></td>
			</tr>
		</table>
	</form>
</body>
</html>