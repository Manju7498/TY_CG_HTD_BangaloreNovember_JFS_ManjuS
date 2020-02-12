package com.capgemini.forestrymanagementcucumber.stepdefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Login {
	static {
		System.setProperty("webdriver.chrome.driver","./src/test/resources/chromedriver.exe");
	}

	WebDriver driver;

	@Given("^chrome and enter  url$")
	public void chrome_and_enter_url() throws Throwable {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:4200");
		driver.manage().window().maximize();
	}

	@When("^Enter valid   email and password$")
	public void enter_valid_email_and_password() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-homeloanmainpage/html/body/header/div/div[1]/nav/ul/li[6]/a")).click();
		driver.findElement(By.name("email")).sendKeys("manju@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Manju@518");
	}

	@When("^click on the Login$")
	public void click_on_the_Login() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-login/div[2]/form/button")).click();	
	}

	@When("^Click on the Logout button$")
	public void click_on_the_Logout_button() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-homeloanmainpage/html/body/header/div/div[1]/nav/ul/li[7]/a")).click();
	}

	@Then("^close the driver$")
	public void close_the_driver() throws Throwable {
		driver.close();
	}

}
