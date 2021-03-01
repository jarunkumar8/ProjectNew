package org.test;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SnapDeal {
	public WebDriver driver;
	
	@BeforeClass
	private void launchBrowser() {
	System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\91978\\eclipse-workspace\\TestData\\Driver\\chromedriver.exe");
		 driver = new ChromeDriver();
	}
	
	@Test(dataProvider="Input Data")
	private void tc1(String product) throws InterruptedException {
		
		 driver.get("https://www.snapdeal.com/");

		Thread.sleep(5000);
		driver.findElement(By.xpath("(//input[@name='keyword'])[1]")).sendKeys(product);
		driver.findElement(By.xpath("//span[text()='Search']")).click();
		
		
		if (product=="mobile") {
			Thread.sleep(3000);
			driver.findElement(By.xpath("//p[@title='Gionee s11 lite ( 32 GB , 4 GB ) Blue']")).click();
			//Robot r = new Robot();
			
			
			String parId = driver.getWindowHandle();
			System.out.println(parId);
			
			Set<String> allId = driver.getWindowHandles();
			System.out.println(allId);
			for (String s : allId) {
				if(!(parId.equals(s))) {
					driver.switchTo().window(s);
				}
						}
			
			Thread.sleep(3000);
			driver.findElement(By.xpath("//span[text()='add to cart']")).click();
					}
			}
	@DataProvider(name="Input Data")
	
	public Object[][] data(){
		
		return new Object[][] {
			{"tablet"},	{"mobile"},{"laptop"},{"air conditioner"},{"smart watch"}
		};
	
	
	}

}
