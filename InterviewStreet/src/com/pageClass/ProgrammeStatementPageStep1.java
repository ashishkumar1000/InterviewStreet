package com.pageClass;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ProgrammeStatementPageStep1 {
	protected WebDriver driver;
	
	@FindBy(how = How.XPATH, using = "//div[2]/div/ul/a/li")
	public WebElement	problemStatementTab;
	
	@FindBy(how = How.NAME, using = "problem-name")
	public WebElement	problemName;
	
	@FindBy(how = How.XPATH, using = "/html/body/p")
	public WebElement	problemStatement;
	
	@FindBy(how = How.XPATH, using = "	//div[@id='step1']/div[3]/button")
	public WebElement	saveAndProcessProblemStatement;
	
	@FindBy(how = How.XPATH, using = "//*[@id='step1']/div[3]/button")
	public WebElement 	saveAndProceedButton;
	


	// Constructor of Interview street create new test page class
	public ProgrammeStatementPageStep1(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		this.driver = driver;
	}
	
	public void enterProblemName(String pName) {
		problemName.sendKeys(pName);
	}
	
	public void enterProblemStatement(String pStatement) {
		try {
			Thread.sleep(10000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.switchTo().frame(1);
		WebElement problmframe = driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(problmframe);
		problemStatement =  driver.findElement(By.xpath("//*[@id='cke_9']/span[1]"));
		problemStatement.sendKeys(pStatement);
	}
	
	public ProgrammeStatementPageStep2 clickOnsaveAndProceedButton() {
		saveAndProceedButton.click();
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return PageFactory.initElements(driver, ProgrammeStatementPageStep2.class);
	}
	
}
