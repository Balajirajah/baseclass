package org.baseclass;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.xel.Writeexcel;

public class Instaprovider extends Baseclass{
	
	@DataProvider(name="signup")
	private Object[][] getData() throws IOException{
		String[][] getdata = Writeexcel .getdata();
		return getdata;
		}
	


     @Test(dataProvider="signup")
     public void tc01(String phonenumber,String fullname,String username,String password) throws InterruptedException {
    	 getDriver();
    	 urlLaunch("https://www.instagram.com/accounts/emailsignup/");
    	 Thread.sleep(3000);
    	  PomInsta p=new PomInsta();
    	  Thread.sleep(3000);
    	 p.getPhonenumber().sendKeys(phonenumber);
    	 Thread.sleep(3000);
    	 p.getFullname().sendKeys(fullname);
    	 Thread.sleep(3000);
    	 p.getUsername().sendKeys(username);
    	 Thread.sleep(3000);
    	 p.getPassword().sendKeys(password);
    	 
    	 
     }
}
     
     
