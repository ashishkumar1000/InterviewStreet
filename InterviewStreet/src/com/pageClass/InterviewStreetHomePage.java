package com.pageClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class InterviewStreetHomePage {
	protected WebDriver driver;

	@FindBy(how = How.ID, using = "createNewTest")
	private WebElement createNewTestButton;
	
	@FindBy(how = How.CLASS_NAME, using = "popover-input")
	private WebElement testName;
	
	@FindBy(how = How.XPATH, using = "//button[@type='submit']")
	private WebElement submitButton;
	
	@FindBy(how = How.CSS, using = "button.btn.editable-cancel")
	private WebElement cancelButton;
	
	@FindBy(how = How.ID, using = "createNewTest")
	private WebElement CreateNewTestButton;

	// Constructor of Interview street home page class
	public InterviewStreetHomePage(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		this.driver = driver;
	}
	
	public void verifyCreateNewTestButton() {
		createNewTestButton.getClass();
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public void close() {
		driver.quit();
	}
	
	public void enterTestName(String testNameString) {
	testName.sendKeys(testNameString);
	}
	
	public InterviewStreetCreateNewTestPage clickOnSubmit() {
		submitButton.click();
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
			}
		return PageFactory.initElements(driver, InterviewStreetCreateNewTestPage.class);
	}
	
	public void clickOnCancel() {
		cancelButton.click();
	}
	
	public void clickOnCreateNewTestButton() {
		CreateNewTestButton.click();
	}
}