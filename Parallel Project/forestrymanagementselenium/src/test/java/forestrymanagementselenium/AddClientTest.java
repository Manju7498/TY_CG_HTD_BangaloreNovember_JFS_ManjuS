package forestrymanagementselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class AddClientTest extends ForestryBaseTest {
	@Test
	public void addClient() {
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/form/ul[2]/li/a")).click();
		driver.findElement(By.name("email")).sendKeys("manju@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Manju@518");
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/form/div/div[2]/div[3]/button")).click();
		driver.findElement(By.xpath("//*[@id=\"navbarDropdown1\"]/b")).click();
		driver.findElement(By.xpath("/html/body/app-root/app-admin/div/nav/ul/li[1]/a/b")).click();
		driver.findElement(By.name("name")).sendKeys("Chinni");
		driver.findElement(By.name("email")).sendKeys("chinni@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Chinni@123");
		driver.findElement(By.name("phoneNumber")).sendKeys("9876543210");
		Select role = new Select(driver.findElement(By.name("role")));
		role.selectByVisibleText("Client");
		driver.findElement(By.xpath("/html/body/app-root/app-admin/app-add-user/div/div/form/div/div[2]/div[6]/button")).click();	
		Reporter.log("Added Client",true);
	}
}
