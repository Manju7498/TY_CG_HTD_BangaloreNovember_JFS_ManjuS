Feature: Login 

Scenario:  Test Login with Valid Credentials
			Given chrome and enter  url
			When Enter valid   email and password
			When click on the Login
			And Click on the Logout button
			Then close the driver