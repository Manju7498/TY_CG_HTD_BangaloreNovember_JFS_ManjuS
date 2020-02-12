package com.cg.loanprocessingsystemselenium;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class AdminLogin  extends LoanBaseTest {
	@Test
	public void adminLogin() {
		driver.findElement(By.xpath("/html/body/app-root/app-homeloanmainpage/html/body/header/div/div[1]/nav/ul/li[6]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("admin@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Admin@123");
		driver.findElement(By.xpath("/html/body/app-root/app-login/div[2]/form/button")).click();
		Reporter.log("admin logged in ",true);
	}
}
