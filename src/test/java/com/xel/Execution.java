package com.xel;

import java.io.IOException;

import org.baseclass.Baseclass;
import org.baseclass.PomclassLogin;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Execution extends Baseclass {

	@DataProvider(name="firstname")
	private Object[][] getData() throws IOException {
		Object[][] ggg = getdata1();
		return ggg;
		}
	@Test(dataProvider="firstname")
	private void tc01(String user,String pass) {
		getDriver();
		urlLaunch("https://www.facebook.com/login/");
		PomclassLogin s=new PomclassLogin ();
		WebElement username=s.getUsername();
		textsend(username,user);
		WebElement password=s.getPassword();
		textsend(password,pass);
		WebElement login=s.getLogin();
		buttonclick(login);
		
		
	}

}
