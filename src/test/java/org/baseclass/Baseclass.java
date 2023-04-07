package org.baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
	public static WebDriver driver;
	public static WebElement findElement;
	
	public static void getDriver() {
		WebDriverManager.chromedriver().setup() ;
		 driver=new ChromeDriver();
		driver.manage().window().maximize();
	}
	public static void getedge() {
		WebDriverManager.edgedriver().setup() ;
		 driver=new EdgeDriver();
		driver.manage().window().maximize();
		
	}
	public static  void urlLaunch(String url) {
		driver.get(url);
	}
	//public static WebElement idLocator(String id) {
	//	WebElement findElement=driver.findElement(By.id(id));
	//	return findElement;	
	//}
	public static WebElement locator(String locatortype,String locatorvalue) {
		if(locatortype.equals("id")) {
		findElement=driver.findElement(By.id(locatorvalue));
		return findElement;
	}
	else if(locatortype.equals("name")) {
	findElement=driver.findElement(By.name(locatorvalue));
	return findElement;
	}
	else if(locatortype.equals("classname")) {
		findElement=driver.findElement(By.className(locatorvalue));
		return findElement;
	}
	else if(locatortype.equals("xpath")) {
		findElement=driver.findElement(By.xpath(locatorvalue));
		return findElement;
	}else {
		return findElement;
	}
	
}
	public static void textsend(WebElement findElement,String phonenumber) {
		findElement.sendKeys(phonenumber);
	}
	public static void buttonclick(WebElement findElement) {
		findElement.click();
	}
	public static void scrolldown(String locatorvalue) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		WebElement text=driver.findElement(By.xpath(locatorvalue));
		js.executeScript("arguments[0].scrollIntoView(true)",text);
		
	}
	public static void scrollup(String locatorvalue) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		WebElement text=driver.findElement(By.xpath(locatorvalue));
		js.executeScript("arguments[0].scrollIntoView(false)", text);
	}
	public static WebElement mouseover (String locatorvalue) {
		Actions ac=new Actions(driver);
		findElement=driver.findElement(By.xpath(locatorvalue));
		ac.moveToElement(findElement).perform();
		return findElement;
		
	}
	public static WebElement doubleclick(String locatorvalue) {
		Actions ac=new Actions(driver);
		findElement=driver.findElement(By.xpath(locatorvalue));
		ac.doubleClick(findElement).perform();
		return findElement;
		}
	public static WebElement rightclick(String locatorvalue) {
		Actions ac=new Actions(driver);
		findElement=driver.findElement(By.xpath(locatorvalue));
		ac.contextClick(findElement).perform();
		return findElement;
	}
	public static void draganddrop(String locatorvalue,String locatorvalue1) {
		Actions ac=new Actions(driver);
		WebElement drag=driver.findElement(By.xpath(locatorvalue));
		WebElement drop=driver.findElement(By.xpath(locatorvalue1));
		ac.dragAndDrop(drag, drop).perform();
		return;
		}
	public static File screenshot() throws IOException {
		TakesScreenshot ts=(TakesScreenshot) driver;
		File ScreenShot=ts.getScreenshotAs(OutputType.FILE);
		System.out.println(ScreenShot);
		File file=new File("D:\\screenshots.png");
		FileUtils.copyFile(ScreenShot, file);
		return ScreenShot;
		}
	public static WebElement attribute(WebElement findElement,String type,String value,String text) {
		WebElement locator = locator(type,value);
		locator.sendKeys(text);
		String attributevalue=locator.getAttribute("value");
		System.out.println(attributevalue);
	return locator;
	}
	public static WebElement text(WebElement findElement,String type,String value,String text1) {
		WebElement locator = locator(type,value);
		locator.sendKeys(text1);
		String textvalue=locator.getText();
		System.out.println(textvalue);
	return locator;
	
	}
	public static WebElement setAttribute(String text,String locator) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value',text)",locator);
		return findElement;
		}
	public static WebElement select(String type,WebElement locator,String selectBy) {
		Select s=new Select(locator);
		if(type.equals("value")) {
			List<WebElement> options = s.getOptions();
			for(int i=0;i<options.size();i++) {
				WebElement element = options.get(i);
				String text = element.getText();
				if(text.equals(selectBy)) {
					s.selectByValue(selectBy);
					element.click();
				}
			}
			return findElement;
		}
		else {
			if(type.equals("visibleText")) {
				List<WebElement> options = s.getOptions();
				for(int i=0;i<options.size();i++) {
					WebElement element = options.get(i);
					String text = element.getText();
					if(text.equals(selectBy)) {
						s.selectByVisibleText(selectBy);
						element.click();
			}}
		}

	}
		return findElement;
		}
	public static WebElement selectbyindex(WebElement locator,int index) {
		Select s=new Select(locator);
		s.selectByIndex(index);
		return findElement;
	}
	public static WebElement getTitle(WebElement findElement,String locatorType,String locator) {
		WebElement locator1=locator(locatorType,locator);
		String tagname=locator1.getTagName();
		System.out.println(tagname);
		return findElement;
		}
	public static WebElement getTagname(WebElement findElement,String locatorType,String locator) {
		WebElement locator2=locator(locatorType,locator);
		String tagname=locator2.getTagName();
		System.out.println(tagname);
		return findElement;
	}
	public void alert(String locatorType,String locator,String alert,WebElement findElement) {
		Alert al=driver.switchTo().alert();
		WebElement locator3=locator(locatorType,locator);
		if(alert.equals("simple")) {
			al.accept();
			}
		else {
			if(alert.equals("conform")) {
				al.dismiss();
			}
			else {
				if(alert.equals("prompt")) {
					al.sendKeys(alert);
					al.accept();
				}
			}
		}
	}
	public void waits() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.MILLISECONDS);
		
	}
	public static String[][] getdata1() throws IOException {
		
		File file=new File("C:\\Users\\BALAJI RAJAH\\OneDrive\\Desktop\\New folder\\Book2.xlsx");
		FileInputStream f = new FileInputStream(file);
		Workbook book=new XSSFWorkbook(f);
		Sheet sheet=book.getSheet("Sheet1");
		
		List<ArrayList<String>> s=new ArrayList();
		for(int i=0;i<sheet.getPhysicalNumberOfRows();i++) {
			Row row=sheet.getRow(i);
			
			ArrayList<String> r=new ArrayList();
			for(int j=0;j<row.getPhysicalNumberOfCells();j++) {
				Cell c=row.getCell(j);
				System.out.println(j);
				CellType cellType = c.getCellType();
				String stringCellValue="";
				switch(cellType) {
				
				case STRING:
					stringCellValue = c.getStringCellValue();
					break;
					default:
						if(DateUtil.isCellDateFormatted(c)) {
							Date dateCellValue = c.getDateCellValue();
							SimpleDateFormat s1=new SimpleDateFormat();
							stringCellValue = s1.format(dateCellValue);
						}
						else {
							double numericCellValue=c.getNumericCellValue();
							long l=(long)numericCellValue;
							BigDecimal valueof=BigDecimal.valueOf(l);
							stringCellValue=valueof.toString();
						}
				}
				System.out.println(stringCellValue);
				r.add(stringCellValue);
			}
			s.add(r);
		}
		for(int i=0;i<s.size();i++) {
			ArrayList<String> l = s.get(i);
			for(int j=0;j<l.size();j++) {
				System.out.println(l.get(j));
			}
		}
		String s2[][]=new String[s.size()][s.get(0).size()];
		for(int i=0;i<s.size();i++) {
			ArrayList<String> arraylist=s.get(i);
			for(int j=0;j<arraylist.size();j++) {
				s2[i][j]=arraylist.get(j);
			}
		}
		return s2;
	
	}
	public static void main(String[] args) throws IOException {
	String[][] getdata = getdata1();
	for(int i=0;i<getdata.length;i++) {
		for(int j=0;j<getdata.length;j++) {
				System.out.println(getdata[i][j]);			}		}
			

	}
	}
	




























