package forestrymanagementselenium;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class UpdateCustomerTest  extends ForestryBaseTest {
	@Test
	public void updateCustomer() {
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/form/ul[2]/li/a")).click();
		driver.findElement(By.name("email")).sendKeys("manju@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Manju@518");
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/form/div/div[2]/div[3]/button")).click();
		driver.findElement(By.xpath("//*[@id=\"navbarDropdown2\"]/b")).click();
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[2]/div/a[2]")).click();
		driver.findElement(By.xpath("/html/body/app-root/app-customer/app-get-all-customers/div/div/table/tbody/tr[2]/td[9]/button")).click();
		driver.findElement(By.id("customerStreetAddress1")).sendKeys("kss");
		driver.findElement(By.xpath("/html/body/app-root/app-edit-customer/div/div/form/div/div[2]/button")).click();
		Reporter.log("Customer updated successfully",true);
	}
}
