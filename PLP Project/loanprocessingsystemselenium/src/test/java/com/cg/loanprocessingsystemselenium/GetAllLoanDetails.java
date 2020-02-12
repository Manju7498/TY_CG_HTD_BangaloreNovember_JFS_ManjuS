package com.cg.loanprocessingsystemselenium;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class GetAllLoanDetails extends LoanBaseTest {
	@Test
	public void getAllLoanDetails() {
		driver.findElement(By.xpath("/html/body/app-root/app-homeloanmainpage/html/body/header/div/div[1]/nav/ul/li[6]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("admin@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Admin@123");
		driver.findElement(By.xpath("/html/body/app-root/app-login/div[2]/form/button")).click();
		driver.findElement(By.xpath("/html/body/app-root/app-admin/html/body/section/div/div/div/div/ul/li[4]/a")).click();
		Reporter.log("loan details",true);
	}

}
