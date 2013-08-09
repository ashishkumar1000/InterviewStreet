package com.pageClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ProgrammeStatementPageStep2 {
	
	private WebDriver driver;
	
	public ProgrammeStatementPageStep2(WebDriver driver){
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		this.driver = driver;
	}
	
	@FindBy(how = How.CSS, using = "div.wizard_title.firepath-matching-node")
	private WebElement	AllowedLanguagesTab;
	
	@FindBy(how = How.CSS, using = "a.checked")
	private WebElement	checkSelectAllRadioButton;
	
	@FindBy(how = How.XPATH, using = "//td[3]/div/a")
	private WebElement	checkJavaButton;
	
	@FindBy(how = How.XPATH, using = "//div[4]/div/label")
	private WebElement	writeFullCodeButton;
	
	@FindBy(how = How.XPATH, using = "//div[2]/div[3]/button")
	private WebElement	saveAndProceedAllowedLanguageButton;
	
	public void clickOnAllowedLanguagesTab() {
		AllowedLanguagesTab.click();
	}
	
	public void uncheckallRadioButtons() {
		checkSelectAllRadioButton.click();
	}
	
	public void clickWriteFullCodeButton() {
		writeFullCodeButton.click();
	}
	
	public void clickOnCheckJavaButton() {
		checkJavaButton.click();
	}
	
	public ProgrammeStatementPageStep3 clickSaveAndProceedAllowedLanguageButton() {
		saveAndProceedAllowedLanguageButton.click();
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return PageFactory.initElements(driver, ProgrammeStatementPageStep3.class);
	}
	
}
