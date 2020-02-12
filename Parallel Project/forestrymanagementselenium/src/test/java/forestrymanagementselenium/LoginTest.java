package forestrymanagementselenium;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class LoginTest  extends ForestryBaseTest {
	@Test
	public void login() {
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/form/ul[2]/li/a")).click();
		driver.findElement(By.name("email")).sendKeys("syamala@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Syamala@123");
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/form/div/div[2]/div[3]/button")).click();
		Reporter.log("login successfull", true);
	}
}
