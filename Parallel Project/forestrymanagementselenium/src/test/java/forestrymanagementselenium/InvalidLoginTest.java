package forestrymanagementselenium;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class InvalidLoginTest extends ForestryBaseTest {
	@Test
	public void invalidLogin() {
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/form/ul[2]/li/a")).click();
		driver.findElement(By.name("email")).sendKeys("hema@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Hema@123");
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/form/div/div[2]/div[3]/button")).click();
		Reporter.log("Invalid login",true);
	}
	
}
