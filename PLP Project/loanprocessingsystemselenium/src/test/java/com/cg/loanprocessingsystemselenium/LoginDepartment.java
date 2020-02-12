package com.cg.loanprocessingsystemselenium;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class LoginDepartment extends LoanBaseTest{
	@Test
	public void loginDept() {
		driver.findElement(By.xpath("/html/body/app-root/app-homeloanmainpage/html/body/header/div/div[1]/nav/ul/li[6]/a")).click();
		driver.findElement(By.name("email")).sendKeys("manju@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Manju@518");
		driver.findElement(By.xpath("/html/body/app-root/app-login/div[2]/form/button")).click();
		Reporter.log("login successfull", true);
	}
}
