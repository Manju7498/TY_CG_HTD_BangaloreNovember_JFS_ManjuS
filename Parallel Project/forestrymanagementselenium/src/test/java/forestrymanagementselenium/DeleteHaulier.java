package forestrymanagementselenium;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class DeleteHaulier extends ForestryBaseTest {
	@Test
	public void deleteHaulier() {
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/form/ul[2]/li/a")).click();
		driver.findElement(By.name("email")).sendKeys("manju@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Manju@518");
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/form/div/div[2]/div[3]/button")).click();
		driver.findElement(By.xpath("//*[@id=\"navbarDropdown3\"]/b")).click();
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[3]/div/a")).click();
		driver.findElement(By.xpath("/html/body/app-root/app-haulier/app-get-all-hauliers/div/div/table/tbody/tr[2]/td[10]")).click();
		Reporter.log("Haulier deleted");
	}
}
