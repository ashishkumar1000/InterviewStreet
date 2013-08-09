package com.pageClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ProgrammeStatementPageStep3 {
	private WebDriver driver;
	
	public ProgrammeStatementPageStep3(WebDriver driver){
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		this.driver = driver;
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id='cke_problem-statement']")
	private WebElement	testCasesTab;
	
	@FindBy(how = How.XPATH, using = "//*[@id='step3']/div[2]/button[1]")
	private WebElement	addATestCaseButton;
	
	@FindBy(how = How.NAME, using = "testcase-name")
	private WebElement	testCaseName;
	
	@FindBy(how = How.NAME, using = "testcase-type")
	private WebElement	testCaseDifficulty;
	
	@FindBy(how = How.NAME, using = "testcase-score")
	private WebElement	testCaseScore;
	
	@FindBy(how = How.NAME, using = "input")
	private WebElement	inputText;
	
	@FindBy(how = How.NAME, using = "output")
	private WebElement	outputText;
	
	@FindBy(how = How.LINK_TEXT, using = "Save changes")
	private WebElement	saveChangesButton;
	
	@FindBy(how = How.LINK_TEXT, using = "Save & Finish")
	private WebElement	saveAndFinishButton;
	
	public void ClickOntestCasesTab() {
		testCasesTab.click();
	}
	
	public void clickOnaddATestCaseButton() {
		addATestCaseButton.click();
	}
	
	public void entertestCaseName(String testCaseNme) {
		testCaseName.sendKeys(testCaseNme);
	}
	
	public void selectTestCaseDifficulty(String level) {
		testCaseDifficulty.sendKeys(level);
	}
	
	public void settestCaseScore(String score) {
		testCaseScore.sendKeys(score);
	}
	
	public void enterinputText(String inputTxt) {
		inputText.sendKeys(inputTxt);

	}
	
	public void enteroutputText(String outputTxt) {
		outputText.sendKeys(outputTxt);
	}
	
	public void clickOnsaveChangesButton() {
		saveChangesButton.click();

	}
	public InterviewStreetCreateNewTestPage clicksaveAndFinishButton() {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		saveAndFinishButton.click();
		return PageFactory.initElements(driver, InterviewStreetCreateNewTestPage.class);

	}

}
