package forestrymanagementselenium;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class DeleteClientTest  extends ForestryBaseTest {
	@Test
	public void deleteClient() {
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/form/ul[2]/li/a")).click();
		driver.findElement(By.name("email")).sendKeys("manju@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Manju@518");
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/form/div/div[2]/div[3]/button")).click();
		driver.findElement(By.xpath("//*[@id=\"navbarDropdown\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"navbarDropdown\"]")).click();
		driver.findElement(By.xpath("/html/body/app-root/app-admin/app-get-all-users/div/div/table/tbody/tr/td[6]")).click();
		Reporter.log("Client deleted",true);
	}
}