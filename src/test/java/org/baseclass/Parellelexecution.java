package org.baseclass;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Parellelexecution extends Baseclass {

	
	@org.testng.annotations.Test
	private void tc01() {
		getDriver();
		urlLaunch("https://www.flipkart.com/");
		WebElement findElement2 = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
		findElement2.click();
		attribute(findElement, "xpath","//input[@title='Search for products, brands and more']","iphone");
		
		}
	@org.testng.annotations.Test
	private void tc02() {
		getedge();
		urlLaunch("https://www.flipkart.com/");
		WebElement findElement2 = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
		findElement2.click();
		attribute(findElement, "xpath","//input[@title='Search for products, brands and more']","iphone");
		
		}

}
