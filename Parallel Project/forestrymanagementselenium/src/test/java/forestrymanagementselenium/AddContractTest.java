package forestrymanagementselenium;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class AddContractTest extends ForestryBaseTest {
	@Test
	public void addContract() {
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/form/ul[2]/li/a")).click();
		driver.findElement(By.name("email")).sendKeys("manju@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Manju@518");
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/form/div/div[2]/div[3]/button")).click();
		driver.findElement(By.xpath("//*[@id=\"navbarDropdown2\"]/b")).click();
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[2]/div/a[1]")).click();
		driver.findElement(By.xpath("/html/body/app-root/app-contract/div/nav/ul/li[1]/a/b")).click();
		driver.findElement(By.name("contractNo")).sendKeys("5645");
		driver.findElement(By.name("customerId")).sendKeys("5454");
		driver.findElement(By.name("productId")).sendKeys("1544");
		driver.findElement(By.name("haulierId")).sendKeys("6512");
		driver.findElement(By.name("deliveryDate")).sendKeys("01/05/2021");
		driver.findElement(By.name("deliveryDay")).sendKeys("monday");
		driver.findElement(By.name("quantity")).sendKeys("5000");
		driver.findElement(By.xpath("/html/body/app-root/app-contract/app-add-contract/div/div/form/div/div[2]/div[2]/div[6]/button")).click();
		Reporter.log("Contract added successfully",true);
	}
}
