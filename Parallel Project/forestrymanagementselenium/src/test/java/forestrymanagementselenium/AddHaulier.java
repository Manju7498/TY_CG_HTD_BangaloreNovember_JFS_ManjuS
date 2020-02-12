package forestrymanagementselenium;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class AddHaulier  extends ForestryBaseTest {
	@Test
	public void addHaulier() {
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/form/ul[2]/li/a")).click();
		driver.findElement(By.name("email")).sendKeys("manju@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Manju@518");
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/form/div/div[2]/div[3]/button")).click();
		driver.findElement(By.xpath("//*[@id=\"navbarDropdown3\"]/b")).click();
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[3]/div/a")).click();
		driver.findElement(By.xpath("/html/body/app-root/app-haulier/div/nav/ul/li[1]/a/b")).click();
		driver.findElement(By.id("haulierId")).sendKeys("1245");
		driver.findElement(By.name("haulierName")).sendKeys("manju");
		driver.findElement(By.id("streetAddress1")).sendKeys("ks");
		driver.findElement(By.id("streetAddress2")).sendKeys("hs");
		driver.findElement(By.id("town")).sendKeys("plmr");
		driver.findElement(By.id("pincode")).sendKeys("517408");
		driver.findElement(By.id("email")).sendKeys("manju@gmail.com");
		driver.findElement(By.id("phoneNumber")).sendKeys("9550316616");
		driver.findElement(By.xpath("/html/body/app-root/app-haulier/div/nav/ul/li[1]/a/b")).click();
		Reporter.log("Customer added successfully",true);
	}
}
