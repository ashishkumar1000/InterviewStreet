package com.pageClass;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/* This Class contains the objects for page https://www.interviewstreet.com/recruit2/recruiter
 * Home page after login.
 * */
public class InterviewStreetCreateNewTestPage {
	protected WebDriver driver;

	// Constructor of Interview street create new test page class
	public InterviewStreetCreateNewTestPage(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		this.driver = driver;
	}

	@FindBy(how = How.LINK_TEXT, using = "Choose from library")
	private WebElement choosefromLibraryButton;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Create a new question')]")
	private WebElement createNewQuestionButton;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Try test')]")
	private WebElement tryTestButton;

	@FindBy(how = How.CSS, using = "a.question-type-blocks.new-question-type")
	private WebElement clickProgrammingTestTypeButton;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Approximate Solution')]")
	private WebElement clickApproximateSolutionButton;

	public void clickOnCreateNewTestCaseButton() {
		createNewQuestionButton.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public ProgrammeStatementPageStep1 clickOnProgrammingButton() {
		clickProgrammingTestTypeButton.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return PageFactory.initElements(driver,
				ProgrammeStatementPageStep1.class);
	}

	public void ClickOnApproximateSolutionButton() {
		clickApproximateSolutionButton.click();

	}

	public ChooseFromLibraryPage clickOnChooseFromLibrabyButton() {
		choosefromLibraryButton.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return PageFactory.initElements(driver, ChooseFromLibraryPage.class);
	}

	public InterviewStreetStartTestClass clickOnTryTest() {
		tryTestButton.click();
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return PageFactory.initElements(driver,
				InterviewStreetStartTestClass.class);
	}
}
