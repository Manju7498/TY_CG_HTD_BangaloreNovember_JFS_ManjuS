package com.capgemini.forestrymanagementcucumber.stepdefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CustomerLogin {
	static {
		System.setProperty("webdriver.chrome.driver","./src/test/resources/chromedriver.exe");
	}
	WebDriver driver;
	@Given("^googlechrome and enter  url$")
	public void googlechrome_and_enter_url() throws Throwable {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:4200");
		driver.manage().window().maximize();
	}

	@When("^Enter valid   userName and userpassword$")
	public void enter_valid_userName_and_userpassword() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-homeloanmainpage/html/body/header/div/div[1]/nav/ul/li[3]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("manju@lap.com");
		driver.findElement(By.name("password")).sendKeys("manju");
	}

	@When("^click on the Login button$")
	public void click_on_the_Login_button() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-add-customer-login/div[2]/form/button")).click();	
		
	}

	@When("^Click on the Logout$")
	public void click_on_the_Logout() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-homeloanmainpage/html/body/header/div/div[1]/nav/ul/li[7]/a")).click();
	}

	@Then("^close  driver$")
	public void close_driver() throws Throwable {
		driver.close();
	}
	
}
