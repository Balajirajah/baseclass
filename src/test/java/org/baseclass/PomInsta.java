package org.baseclass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PomInsta extends Baseclass{
	public PomInsta() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@aria-label='Mobile Number or Email']")
	private WebElement phonenumber;
	
	@FindBy(xpath="//input[@aria-label='Full Name']")
	private WebElement fullname;
	
	@FindBy(xpath="//input[@aria-label='Username']")
	private WebElement username;
	
	@FindBy(xpath="//input[@aria-label='Password']")
	private WebElement password;
	
	@FindBy(xpath="//button[text()='Sign up']")
	private WebElement signup;

	public WebElement getPhonenumber() {
		return phonenumber;
	}

	public WebElement getFullname() {
		return fullname;
	}

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getSignup() {
		return signup;
	}

}