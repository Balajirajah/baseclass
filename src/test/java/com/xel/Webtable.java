package com.xel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.baseclass.Baseclass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Webtable extends Baseclass{

	public static void main(String[] args) throws IOException {
		getDriver();
		urlLaunch("https://www.google.com/search?q=ipl+2022+table&oq=ipl+2022&aqs=chrome.4.69i57j46i131i433i512j0i131i433i512j0i512j0i131i433i512l6.8033j0j7&sourceid=chrome&ie=UTF-8");
		WebElement locator = locator("xpath", "//div[@aria-label='Standings section']");
		List<WebElement> row = locator.findElements(By.tagName("tr"));
		File f=new File("C:\\Users\\BALAJI RAJAH\\OneDrive\\Desktop\\Book4.xlsx");
		FileInputStream fs=new FileInputStream(f);
		Workbook w=new XSSFWorkbook(fs);
		Sheet createSheet = w.createSheet("Sheet2");
        for(int i=0;i<row.size();i++) {
        	WebElement element = row.get(i);
        	Row createRow = createSheet.createRow(i);
        	List<WebElement> list = element.findElements(By.tagName("td"));
        	for(int j=0;j<list.size();j++) {
        		WebElement element2 = list.get(j);
        		String text = element2.getText();
        		Cell createCell = createRow.createCell(j);
        		createCell.setCellValue(text);
        	}
        	FileOutputStream out=new FileOutputStream(f);
        	
        	w.write(out);
        	
        }
	}
}
