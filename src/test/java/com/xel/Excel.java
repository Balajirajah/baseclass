package com.xel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {

	public static void main(String[] args) throws IOException{
		
		File f=new File("C:\\Users\\BALAJI RAJAH\\eclipse-workspace\\Maven2\\src\\test\\resources\\PROJECT XXX.xlsx");
		FileInputStream fs=new FileInputStream(f);
		Workbook w=new XSSFWorkbook(fs);
		Sheet sheet=w.getSheet("Sheet1");
		Row row=sheet.getRow(1);
		Cell cell=row.getCell(1);
		String stringcell=cell.getStringCellValue();
		System.out.println(stringcell);
		
		

	}

}
