package org.baseclass;

import org.openqa.selenium.WebElement;

public class PomExecution extends Baseclass {
	public static void main(String[] args) {
		getDriver();
		urlLaunch("https://www.facebook.com/login/");
		PomclassLogin s=new PomclassLogin ();
		WebElement username=s.getUsername();
		textsend(username,"jack@123.com");
		WebElement password=s.getPassword();
		textsend(password,"76898765");
		WebElement login=s.getLogin();
		buttonclick(login);
		
		
	}

}
