package org.test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BaseOne {
public static WebDriver driver;
	
	//1-launch browser
	public static WebDriver launchBrowser() {
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\91978\\eclipse-workspace\\ProjectSel\\driver\\chromedriver.exe");
		 driver = new ChromeDriver();	
		 return driver;
	}
	
	//2-geturl
		public static String findUrl(String url) {
			
			driver.get(url);
			return url;
		}
		//3-maximize window 
			public static void maxWindow() {
				driver.manage().window().maximize();
			}
			//4-get current url
			public  static String currentUrl() {
				String currentUrl = driver.getCurrentUrl();
				return currentUrl;
			}
			
			//5- get title
			public static String pageTitle() {
				String title = driver.getTitle();
				return title;
			}
			
			//6-sendkeys
			public static void insertText(WebElement element,String text) {
				element.sendKeys(text);
			}
			
			//7-single click
			public static void btnClick(WebElement element) {
			element.click();
			}
			
			//8-get attribute
			public static String atValue(WebElement element,String value) {
				String attribute = element.getAttribute(value);
				return attribute;
				
			}
			
			//9-move to element
			public static void mouseOverAction(WebElement element) {
				Actions a = new Actions(driver);
				a.moveToElement(element).perform();
				
			}
			
			//10-drag and drop
			public static void dragDrop(WebElement source,WebElement target) {
				Actions a = new Actions(driver);
				a.dragAndDrop(source, target).perform();
			}
			
			//11-double click
			public static void twoClick(WebElement element) {
				Actions a = new Actions(driver);
				a.doubleClick(element).perform();
			}
			
			//12-right click 
			public static void rightClick(WebElement element) {
				Actions a = new Actions(driver);
				a.contextClick(element).perform();
			}
			
			//13-up key
			public static void upMovement() throws AWTException {
				Robot r = new Robot();
				r.keyPress(KeyEvent.VK_UP);
				r.keyRelease(KeyEvent.VK_UP);
			}
			
		
			//14-down key
			public static void downMovement() throws AWTException {
				Robot r = new Robot();
				r.keyPress(KeyEvent.VK_DOWN);
				r.keyRelease(KeyEvent.VK_DOWN);
			}
			
			//15-tab key	
			public static void tabButton() throws AWTException {
				Robot r = new Robot();
				r.keyPress(KeyEvent.VK_TAB);
				r.keyRelease(KeyEvent.VK_TAB);
			}
			
			//16-enter key
			public static void enterButton() throws AWTException {
				Robot r = new Robot();
				r.keyPress(KeyEvent.VK_ENTER);
				r.keyRelease(KeyEvent.VK_ENTER);
			}
			
			//17- to copy data
			public static void toCopy() throws AWTException {
				Robot r = new Robot();
				r.keyPress(KeyEvent.VK_CONTROL);
				r.keyPress(KeyEvent.VK_C);
				r.keyRelease(KeyEvent.VK_CONTROL);
				r.keyRelease(KeyEvent.VK_C);
			}
			
			//-18- to paste data
			public static void toPaste() throws AWTException {
				Robot r = new Robot();
				r.keyPress(KeyEvent.VK_CONTROL);
				r.keyPress(KeyEvent.VK_V);
				r.keyRelease(KeyEvent.VK_CONTROL);
				r.keyRelease(KeyEvent.VK_V);
			}
			
			//19-to convert caps 
			public static void toCapital(WebElement element,String text) {
				Actions a = new Actions(driver);
				a.keyDown(element,Keys.SHIFT).sendKeys(text).keyUp(Keys.SHIFT).perform();
			}
			//20-screenshot
			public static void snapShot() throws IOException {
				TakesScreenshot ts =(TakesScreenshot) driver;
				 File src = ts.getScreenshotAs(OutputType.FILE);
				 File des = new File("D:\\snapshot.png");
				 FileUtils.copyFile(src, des);
			}
			
			//21-simple alert to click accept
			public static String simpleAlert(Alert a,String text) {
				 a = driver.switchTo().alert();
				 text= a.getText();
				 a.accept();
				 return text;
			}
			//22-alert with dismiss
			public static String confirmAlert(Alert a,String text) {
					 a=driver.switchTo().alert();
					 text= a.getText();
					 a.dismiss();
					 return text;
					 
			}
			
			//23-alert with text
			public static String alertWithText(String text,String inputtxt) {
				 Alert a=driver.switchTo().alert();
				 a.sendKeys(text);
				 inputtxt=a.getText();
				 a.accept();
				 return text;
			}
			//24-frame id
			public static void frameId(String id) {
				driver.switchTo().frame(id);
			}
			//25-frame name
			public static void frameName(String name) {
				driver.switchTo().frame(name);
			}
			
			//26- frame webelement
			public static void frameWeb(WebElement element) {
				driver.switchTo().frame(element);
			}
			//27-frame index
			public static void frameIndex(int index) {
				driver.switchTo().frame(index);
			}
			//28-dropdown by visibletext
			public static void dropDownText(WebElement element,String text) {
				Select s = new Select(element);
				s.selectByVisibleText(text);
			}
			
			// 29-dropdown by value
			public static void dropDownValue(WebElement element,String value) {
				Select s = new Select(element);
				s.selectByValue(value);
			}
			//30-dropdown by index
			public static void dropDownIndex(WebElement element,int no) {
				Select s = new Select(element);
				s.selectByIndex(no);
			}
			//31-deselect by visible text
			public static void dropDownDeselectText(WebElement element,String text) {
				Select s = new Select(element);
				s.deselectByVisibleText(text);
				}
			
			//32-deselect by value
			public static void dropDownDeselectvalue(WebElement element,String value) {
				Select s = new Select(element);
				s.deselectByValue(value);
				}
			//33-deselect by index
			public static void dropDownDeselectIndex(WebElement element,int no) {
				Select s = new Select(element);
				s.deselectByIndex(no);
			}
			//34-deselect all
			public static void dropDownDeselectAll(WebElement element) {
				Select s = new Select(element);
				s.deselectAll();
			}
			
			//35-check multiple dropdown		
			public static boolean dropDownMultiple(WebElement element,boolean check) {
				Select s = new Select(element);
				check=s.isMultiple();
				return check;
			}
			//36-get options
			public static String dropDownget(WebElement element,String text) {
				Select s = new Select(element);
				List<WebElement> options = s.getOptions();
				for (WebElement alldata : options) {
					text = alldata.getText();
					}
				return text;
			}
			
			//37-get first selected options
			public static String dropDownFirstSelected(WebElement element) {
				Select s = new Select(element);
				 WebElement first = s.getFirstSelectedOption();
				 String text = first.getText();
				 return text;
			}
			//38-get all selected options
			public static String dropDownAllSelected(WebElement element,String text) {
				Select s = new Select(element);
				List<WebElement> all = s.getAllSelectedOptions();
				for (WebElement each : all) {
					text = each.getText();
					}
				return text;
			}
			
			//39-get window handle(parent id)
			public static String parentWindowId() {
				String parId = driver.getWindowHandle();
				return parId;
			}
			//40-get windows handle(all id)
			public static Set<String> allWindowId() {
				Set<String> allId = driver.getWindowHandles();
				return allId;
			}
			//41-switch windows
			public static void swithWindow(Set<String> allId,String parId) {
				for (String x : allId) {
					if (!parId.equals(x)) {
						driver.switchTo().window(x);
						}
				}
			}
			
			//42-switch to parent window
			public static void switchParentWindow() {
				driver.switchTo().defaultContent();
			}
			//43-disable notifications
			public static void disableNotify(String url) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-notifications");
				WebDriver driver = new ChromeDriver(options);
				driver.get(url);
			}
			//44-is enabled
			public static boolean enableVisible(WebElement element) {
				boolean enabled = element.isDisplayed();
				return enabled;
			}
			
			//45-is displayed
			public static boolean displayVisible(WebElement element ) {
				boolean displayed = element.isDisplayed();
				return displayed;
			}
			//46-is selected
			public static boolean selectedVisible(WebElement element) {
				boolean selected = element.isSelected();
				return selected;
			}
			//47-sleep
			public static void stopSeconds(int seconds) throws InterruptedException {
				Thread.sleep(seconds);
			}
			
			//48-to select all
			public static void toSelectAll() throws AWTException {
				Robot r = new Robot();
				r.keyPress(KeyEvent.VK_CONTROL);
				r.keyPress(KeyEvent.VK_A);
				r.keyRelease(KeyEvent.VK_CONTROL);
				r.keyRelease(KeyEvent.VK_A);
			}
			// 49-to press shift key
			public static void shiftPress() throws AWTException {
				Robot r = new Robot();
				r.keyPress(KeyEvent.VK_SHIFT);
				r.keyRelease(KeyEvent.VK_SHIFT);
			}
			
			//50-to click by action class
			public static void actionClick(WebDriver driver,WebElement element) {
				Actions a = new Actions(driver);
				a.moveToElement(element).click().perform();

			}
			//51-quit browser
			public static void closeBrowser() {
			driver.quit();
			}
			
			//52 read file from excel
			public static String readExcel(int rowNo,int cellNo) throws IOException {
				File f = new File("D:\\excel\\data.xlsx");
				FileInputStream instream = new FileInputStream(f);
				
				Workbook w = new XSSFWorkbook(instream);
				Sheet s = w.getSheet("Input");
				String value="";
				for (int i = 0; i <s.getPhysicalNumberOfRows(); i++) {
					Row r = s.getRow(rowNo);
					for (int j = 0; j <r.getPhysicalNumberOfCells(); j++) {
						Cell c = r.getCell(cellNo);
									
				int type = c.getCellType();
				
				if (type==1) {
					value = c.getStringCellValue();
				} else if (DateUtil.isCellDateFormatted(c)) {
				 Date d = c.getDateCellValue();
					SimpleDateFormat sim = new SimpleDateFormat("dd/mm/yyyy");
					value = sim.format(d);
					
							} 
				else {
					double d = c.getNumericCellValue();
					long l=(long)d;
					value = String.valueOf(l);
					
					
				}
				
				}
				}
				
				return value;
			}
			
			// 53 Write file and sheet to excel
			public static String writeExcel(String sheetname) throws IOException, InterruptedException {
				
				
				
					File f = new File("D:\\excel\\data.xlsx");
					Workbook w = new XSSFWorkbook();
					 Sheet s = w.createSheet(sheetname);
					  FileOutputStream fout = new FileOutputStream(f);
							w.write(fout);
					
					return sheetname;
				}
			
			//54 write data in excel
			public static String riteOuputExcel(int rowNo,int cellNo,String value) throws IOException, InterruptedException  {
				
			if ((rowNo== 0 ||rowNo== 1 ||rowNo== 2) && cellNo==0) {
				File f = new File("D:\\excel\\data.xlsx");
				FileInputStream instream = new FileInputStream(f);
				Workbook w = new XSSFWorkbook(instream);
				Sheet s = w.getSheet("Input");
				//Row r = s.getRow(rowNo);
				
				FileOutputStream fout = new FileOutputStream(f);
				Row r = s.createRow(rowNo);
				Cell c = r.createCell(cellNo);
				c.setCellValue(value);
				
				w.write(fout);
				Thread.sleep(3000);
				return value;
				
			} else {
			
					File f = new File("D:\\excel\\data.xlsx");
					FileInputStream instream = new FileInputStream(f);
					Workbook w = new XSSFWorkbook(instream);
					Sheet s = w.getSheet("Input");
					Row r = s.getRow(rowNo);
					
					FileOutputStream fout = new FileOutputStream(f);
					//Row r = s.createRow(rowNo);
					Cell c = r.createCell(cellNo);
					c.setCellValue(value);
					
					w.write(fout);
					Thread.sleep(3000);
					return value;
			}
			}
				


}
