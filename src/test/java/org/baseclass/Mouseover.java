package org.baseclass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Mouseover extends Baseclass {

	public static void main(String[] args)  {
		getDriver();
		urlLaunch("http://www.greenstechnologys.com/");
		mouseover("//a[text()='COURSES']");
		List<WebElement> elements = driver.findElements(By.tagName("ul"));
		for(int i=0;i<elements.size();i++) {
			WebElement element = elements.get(i);
			String text = element.getText();
			System.out.println(text);
		}
		mouseover("//a[text()='Online Courses']");
		List<WebElement> elements1 = driver.findElements(By.tagName("ul"));
		for(int i=0;i<elements1.size();i++) {
			WebElement element = elements1.get(i);
			String text1 = element.getText();
			System.out.println(text1);
		}
		mouseover("//a[text()='Master Program']");
		List<WebElement> elements2 = driver.findElements(By.tagName("ul"));
		for(int i=0;i<elements2.size();i++) {
			WebElement element = elements2.get(i);
			String text2 = element.getText();
			System.out.println(text2);
		}
		
		
		
		

		
	
	}
}
