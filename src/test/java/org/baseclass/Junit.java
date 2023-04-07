package org.baseclass;

import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Junit extends Baseclass {
	 
     @BeforeClass
     public static void l1() {
    	 getDriver();
    	 urlLaunch("https://www.flipkart.com/");
     }
    	 
    	 @Before
    	 public  void l2() {
    		 locator("xpath", "//button[@class='_2KpZ6l _2doB4z']").click();
    			mouseover("xpath","//div[text()='Home']");
    	 }
    	 @Test
    	 public  void l3() {
    		 mouseover("xpath","//a[text()='Cleaning & Bath']");
    			mouseover("xpath","//a[text()='Air Fresheners']").click();
    	 }
    	 @AfterClass
    	 public static void l4() {
    		 locator("xpath","//div[@class='_2hVSre _1eAP-x']").click();
    			locator("xpath","//input[@class='_2IX_2- VJZDxU']").sendKeys("8248768477");
    	 }
    	 @After
    	 public  void l5() throws IOException {
    		 locator("xpath","//button[text()='Request OTP']").click();
    			screenshot();
    		 
    	 }

}
