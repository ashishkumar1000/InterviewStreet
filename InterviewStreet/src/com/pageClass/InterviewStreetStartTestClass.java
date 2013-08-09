package com.pageClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class InterviewStreetStartTestClass {
	WebDriver driver;
	
	// Constructor of Interview Street Start Test  class
	public  InterviewStreetStartTestClass(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		this.driver = driver;
	}
	
	@FindBy(how = How.ID, using = "username")
	private WebElement username;
	
	@FindBy(how = How.ID, using = "user_full_name")
	private WebElement fullName;
	
	@FindBy(how = How.ID, using = "acknowledge")
	private WebElement checkAck;
	
	@FindBy(how = How.NAME, using = "commit")
	private WebElement logintoTestButton;
	
	public void enterEmail(String uid) {
	username.sendKeys(uid);
	}
	
	public void enterName(String name) {
	fullName.sendKeys(name);	
	}
	
	public void clickOnAcknowledge() {
		checkAck.click();
	}
	
	public QuestionPage clickOnLoginButton() {
		logintoTestButton.click();
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return PageFactory.initElements(driver, QuestionPage.class);
	}
}
