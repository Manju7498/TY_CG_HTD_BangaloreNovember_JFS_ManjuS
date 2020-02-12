Feature: Login 

Scenario:  Test Login with Valid Credentials
			Given googlechrome and enter  url
			When Enter valid   userName and userpassword
			When click on the Login button
			And Click on the Logout 
			Then close  driver