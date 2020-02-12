package forestrymanagementselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class RegisterTest extends ForestryBaseTest {

	@Test
	public void register() {
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/form/ul[1]/li/a")).click();
		driver.findElement(By.name("name")).sendKeys("s");
		driver.findElement(By.name("email")).sendKeys("syamala@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Syamala@123");
		driver.findElement(By.name("phoneNumber")).sendKeys("9550228395");
		Select role = new Select(driver.findElement(By.name("role")));
		role.selectByVisibleText("Admin");
		driver.findElement(By.xpath("/html/body/app-root/app-register/div/div/form/div/div[2]/div[6]/button")).click();
		Reporter.log("register successfull", true);
	}

}
