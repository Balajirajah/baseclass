package com.xel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.format.CellFormatType;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFDataFormat;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Writeexcel {
     
	public static String[][] getdata()  throws IOException {
		File file=new File("C:\\Users\\BALAJI RAJAH\\OneDrive\\Documents\\Dataprovider.xlsx");
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
	String[][] getdata = getdata();
	for(int i=0;i<getdata.length;i++) {
		for(int j=0;j<getdata.length;j++) {
				System.out.println(getdata[i][j]);			}		}
	}
}		
