package com.cg.loanprocessingsystemselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class AddEmployee extends LoanBaseTest{
	@Test
	public void addEmployee() {
		driver.findElement(By.xpath("/html/body/app-root/app-homeloanmainpage/html/body/header/div/div[1]/nav/ul/li[6]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("admin@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Admin@123");
		driver.findElement(By.xpath("/html/body/app-root/app-login/div[2]/form/button")).click();
		driver.findElement(By.xpath("/html/body/app-root/app-admin/html/body/section/div/div/div/div/ul/li[2]/a")).click();
		driver.findElement(By.name("employeeName")).sendKeys("Pranitha");
		Select role = new Select(driver.findElement(By.name("employeeRole")));
		role.selectByVisibleText("Field Manager");
		driver.findElement(By.name("email")).sendKeys("pranitha@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Pranitha@123");
		driver.findElement(By.xpath("/html/body/app-root/app-add-employee/html/div[2]/form/button")).click();
		Reporter.log("Employee Added",true);
	}

}
