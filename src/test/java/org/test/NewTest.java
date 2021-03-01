package org.test;


import java.awt.AWTException;


import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NewTest  {
	public WebDriver driver;
	
	@BeforeClass
	private void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\91978\\eclipse-workspace\\TestData\\Driver\\chromedriver.exe");
		 driver= new ChromeDriver();
		 driver.get("https://www.amazon.in/");
		 	}
	@Test
	private void tc1() throws AWTException, InterruptedException {
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("hp laptops");
		driver.findElement(By.xpath("(//input[@class='nav-input'])[2]")).click();
		Thread.sleep(3000);
		}
	@Test
	private void tc2()  {
		List<WebElement> data = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		
		List<String> l=new LinkedList();
		for (int i = 0; i < data.size(); i++) {
		WebElement w = data.get(i);	
		String text = w.getText();
		l.add(text);
		}
		Set<String> s=new LinkedHashSet();
		s.addAll(l);
		System.out.println("Count of Duplicates: "+(l.size()-s.size()));
		
				System.out.println("HP laptops are listed below:\n");
		for (String str : s) {
			System.out.println("\n"+str);
			}
			}
	@Test
	private void tc3() {
		List<WebElement> price = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		List<String> l=new LinkedList();
		System.out.println("HP laptop price value greater than 35000 rupees");
		for (int i = 0; i < price.size(); i++) {
		WebElement w = price.get(i);	
		String text = w.getText();
		String replace = text.replace(",","");
		
	
		if (Integer.parseInt(replace)>35000) {
			System.out.println("\n"+replace);
		}
		
		}
		

	}
		
	}
	
	
	
	

