package forestrymanagementselenium;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class AddCustomerTest extends ForestryBaseTest {
	@Test
	public void addCustomer() {
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/form/ul[2]/li/a")).click();
		driver.findElement(By.name("email")).sendKeys("pranitha@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Pranitha@1243");
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/form/div/div[2]/div[3]/button")).click();
		driver.findElement(By.xpath("//*[@id=\"navbarDropdown2\"]/b")).click();
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[2]/div/a[2]")).click();
		driver.findElement(By.xpath("/html/body/app-root/app-customer/div/nav/ul/li[1]/a/b")).click();
		driver.findElement(By.id("customerId2")).sendKeys("1245");
		driver.findElement(By.name("customerName")).sendKeys("manju");
		driver.findElement(By.id("customerStreetAddress1")).sendKeys("ks");
		driver.findElement(By.id("customerStreetAddress2")).sendKeys("hs");
		driver.findElement(By.id("customerTown")).sendKeys("plmr");
		driver.findElement(By.id("customerPincode")).sendKeys("517408");
		driver.findElement(By.id("customerEmail")).sendKeys("manju@gmail.com");
		driver.findElement(By.id("customerPhoneNumber")).sendKeys("9550316616");
		driver.findElement(By.xpath("/html/body/app-root/app-customer/app-add-customer/div/div/form/div/div[2]/button")).click();
		Reporter.log("Customer added successfully",true);
	}
}
