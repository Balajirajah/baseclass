package org.baseclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Baseexecution extends Baseclass {

	public static void main(String[] args) {
		getDriver();
		urlLaunch("https://www.flipkart.com/");
		WebElement findElement2 = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
		findElement2.click();
		attribute(findElement, "xpath","//input[@title='Search for products, brands and more']","iphone");
		
		
		

	}

}
