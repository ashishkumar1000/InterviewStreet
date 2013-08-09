package com.testcases;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.pageClass.InterviewStreetCreateNewTestPage;
import com.pageClass.InterviewStreetHomePage;
import com.pageClass.InterviewStreetLoginPage;
import com.pageClass.InterviewStreetStartTestClass;
import com.pageClass.ProgrammeStatementPageStep1;
import com.pageClass.ProgrammeStatementPageStep2;
import com.pageClass.ProgrammeStatementPageStep3;
import com.pageClass.QuestionPage;

public class TestCase1 {
	
	private InterviewStreetLoginPage loginPage;
	private InterviewStreetHomePage homePage;
	private InterviewStreetCreateNewTestPage createTestPage;
	private ProgrammeStatementPageStep1 prgrmStatemntPage1;
	private ProgrammeStatementPageStep2 prgrmStatemntPage2;
	private ProgrammeStatementPageStep3 prgrmStatemntPage3;
	private InterviewStreetStartTestClass tryTest;
	private QuestionPage qstnPage;
	
	 	@Parameters({ "browser" })
	    @BeforeClass
		public void init(String browser) {
	 	if (browser.equalsIgnoreCase("chrome")) {
    		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    		loginPage = PageFactory.initElements(new ChromeDriver(), InterviewStreetLoginPage.class);
	 		}
    	if (browser.equalsIgnoreCase("firefox")) {
    		loginPage = PageFactory.initElements(new FirefoxDriver(), InterviewStreetLoginPage.class);
			}
    	if (browser.equalsIgnoreCase("iexplorer")) {
    		loginPage = PageFactory.initElements(new InternetExplorerDriver(), InterviewStreetLoginPage.class);
			}
		
    		loginPage.open("https://www.interviewstreet.com");
	}
	
	//Test Case for Login
	@Test
	public void testCase1() {
		loginPage.clickOnLoginButton();
		loginPage.enterEmail("ashishkumar1000@gmail.com");
		loginPage.enterPaswword("12345");
		homePage = loginPage.clickOnLoginActioButton();
		homePage.verifyCreateNewTestButton();
		}
	
	//Test case for create new test  name
	@Test(dependsOnMethods="testCase1")
	public void testCase2() {
		homePage.clickOnCreateNewTestButton();
		homePage.enterTestName("from eclipse");
		createTestPage = homePage.clickOnSubmit();
		createTestPage.clickOnCreateNewTestCaseButton();
		prgrmStatemntPage1 = createTestPage.clickOnProgrammingButton();
	}
	
	//Test Case to create new test question.
	@Test(dependsOnMethods="testCase2")
	public void testCase3() {
		prgrmStatemntPage1.enterProblemName("problem from program");
		prgrmStatemntPage1.enterProblemStatement("Write a program to check if a number is multiple of 5 or not ?");
		prgrmStatemntPage2 = prgrmStatemntPage1.clickOnsaveAndProceedButton();
	}
	
	//Test case to select language 
	@Test(dependsOnMethods="testCase3")
	public void testCase4(){
		prgrmStatemntPage2.uncheckallRadioButtons();
		prgrmStatemntPage2.clickOnCheckJavaButton();
		prgrmStatemntPage2.clickWriteFullCodeButton();
		prgrmStatemntPage3 = prgrmStatemntPage2.clickSaveAndProceedAllowedLanguageButton();
	}
	
	//Test case to set difficulty level,input and output.
	@Test(dependsOnMethods="testCase4")
	public void testCase5() {
		prgrmStatemntPage3.clickOnaddATestCaseButton();
		prgrmStatemntPage3.enterinputText("TestCase1");
		prgrmStatemntPage3.selectTestCaseDifficulty("Easy");
		prgrmStatemntPage3.settestCaseScore("1");
		prgrmStatemntPage3.enterinputText("5");
		prgrmStatemntPage3.enteroutputText("true");
		prgrmStatemntPage3.clickOnsaveChangesButton();
		createTestPage = prgrmStatemntPage3.clicksaveAndFinishButton();
	}
	
	//test case for try the above created test
	@Test(dependsOnMethods="testCase5")
	public void testCase6() {
	tryTest = createTestPage.clickOnTryTest();	
	tryTest.enterEmail("ashishkumar1000@gmail.com");
	tryTest.enterName("Ashish");
	tryTest.clickOnAcknowledge();
	qstnPage = tryTest.clickOnLoginButton();
	}
	
	@AfterClass
	public void done() {
		//Code for close Web driver.
		}
}
