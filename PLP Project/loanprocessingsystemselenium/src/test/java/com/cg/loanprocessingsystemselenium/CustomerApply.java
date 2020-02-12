package com.cg.loanprocessingsystemselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class CustomerApply extends LoanBaseTest {
	@Test
	public void customerApply() {
		driver.findElement(By.xpath("//*[@id=\"class-1\"]/div/div/div[2]/div/a")).click();
		driver.findElement(By.name("customerName")).sendKeys("John");
		driver.findElement(By.name("customerContactNo")).sendKeys("9587412365");
		driver.findElement(By.name("customerAddress")).sendKeys("SaiNagar");
		driver.findElement(By.name("aadharNo")).sendKeys("987654321412");
		driver.findElement(By.name("occupation")).sendKeys("teacher");
		driver.findElement(By.name("annualIncome")).sendKeys("2000000");
		driver.findElement(By.name("loanAmount")).sendKeys("400000");
		driver.findElement(By.name("assertId")).sendKeys("5465");
		driver.findElement(By.name("nomineeName")).sendKeys("Ram");
		driver.findElement(By.name("nomineePanId")).sendKeys("85Fh15");
		driver.findElement(By.name("nomineeContactNo")).sendKeys("9556745896");
		driver.findElement(By.name("dateOfBirth")).sendKeys("01-05-1995");
		Select role = new Select(driver.findElement(By.name("loanType")));
		role.selectByVisibleText("Home Construction Loan");
		driver.findElement(By.xpath("/html/body/app-root/app-add-customer/html/div[2]/form/button")).click();
		Reporter.log("Customer applied successfully", true);
	}
}
