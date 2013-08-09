package com.pageClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class InterviewStreetLoginPage {
	
	// Constructor of Interview street login page class
	public InterviewStreetLoginPage(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		this.driver = driver;
	}
	
	protected WebDriver driver;

	@FindBy(how = How.ID, using = "login_button")
	private WebElement loginButton;

	@FindBy(how = How.XPATH, using = "/html/body/div[3]/div/div/ul/li[6]/a")
	private WebElement signupButton;
	
	@FindBy(how = How.ID, using = "email")
	private WebElement email;
	
	@FindBy(how = How.ID, using = "password")
	private WebElement password;
	
	@FindBy(how = How.ID, using = "login_action")
	private WebElement login_action;
	


	public void open(String url) {
		driver.get(url);
	}

	public void close() {
		driver.quit();
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public void clickOnLoginButton() {
		loginButton.click();
	}

	public void clickOnSignUpButton() {
		signupButton.click();
	}
	
	public void enterEmail(String emailId) {
		email.clear();
		email.sendKeys(emailId);
	}
	
	public void enterPaswword(String pass) {
		password.clear();
		password.sendKeys(pass);
	}
	
	public InterviewStreetHomePage clickOnLoginActioButton() {
		login_action.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return PageFactory.initElements(driver,InterviewStreetHomePage.class);

	}
}
