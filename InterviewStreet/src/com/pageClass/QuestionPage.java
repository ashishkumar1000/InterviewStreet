package com.pageClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class QuestionPage {
	
	WebDriver driver;
	
	public QuestionPage(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		this.driver = driver;
	}
	
	//The Method for this class need to be written
}
