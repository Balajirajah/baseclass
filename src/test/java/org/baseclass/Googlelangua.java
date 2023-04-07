package org.baseclass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Googlelangua extends Baseclass{
	
	public static void main(String[] args) {
		getDriver();
		urlLaunch("https://www.google.com/");
		List<WebElement> findElements = driver.findElements(By.tagName("a"));
		for(int i=0;i<findElements.size();i++) {
			WebElement webElement = findElements.get(i);
			String text = webElement.getText();
			System.out.println(text);
		}
	}

}
