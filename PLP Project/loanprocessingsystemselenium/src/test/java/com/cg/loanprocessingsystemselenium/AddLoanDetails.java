package com.cg.loanprocessingsystemselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class AddLoanDetails extends LoanBaseTest {
	@Test
	public void addLoanDetails() {
		driver.findElement(By.xpath("/html/body/app-root/app-homeloanmainpage/html/body/header/div/div[1]/nav/ul/li[6]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("admin@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Admin@123");
		driver.findElement(By.xpath("/html/body/app-root/app-login/div[2]/form/button")).click();
		driver.findElement(By.xpath("/html/body/app-root/app-admin/html/body/section/div/div/div/div/ul/li[3]/a")).click();
		Select role = new Select(driver.findElement(By.name("typeOfLoan")));
		role.selectByVisibleText("Home Construction Loan");
		driver.findElement(By.name("loanDuration")).sendKeys("5");
		driver.findElement(By.name("loanPOI")).sendKeys("54.57");
		driver.findElement(By.xpath("/html/body/app-root/app-add-loan-details/html/div[2]/form/button")).click();
		Reporter.log("loan details added",true);
	}
}
