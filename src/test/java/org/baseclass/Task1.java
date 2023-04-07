package org.baseclass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Task1 extends Baseclass{

	public static void main(String[] args) throws IOException {
		getDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		urlLaunch("https://www.flipkart.com/");
		
		locator("xpath", "//button[@class='_2KpZ6l _2doB4z']").click();
		mouseover("xpath","//div[text()='Home']");
		mouseover("xpath","//a[text()='Cleaning & Bath']");
		mouseover("xpath","//a[text()='Air Fresheners']").click();
		locator("xpath","//div[@class='_2hVSre _1eAP-x']").click();
		locator("xpath","//button[@class='_2KpZ6l _2doB4z']").click();
		//locator("xpath","//input[@class='_2IX_2- VJZDxU']").sendKeys("8248768477");
		//locator("xpath","//button[text()='Request OTP']").click();
		screenshot();
		//locator("xpath","(//p[@id()='xLJeZFJgVtyTXGu'])[6]");
		
		
		}
}


