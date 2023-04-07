package org.baseclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Parallelexecutiontest {
	
	@Parameters({"browser"})
	@Test
	private void tc01(String browser) {
		
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			WebDriver driver=new ChromeDriver();
		}
		else {
			WebDriverManager.edgedriver().setup();
			WebDriver driver=new EdgeDriver();
			
		}
	}
	

}
