

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestCaseWithGrid {
    private static WebDriver driver1;
    private static WebDriver driver2;
    private static WebElement webElement;
    private static String user1 = "User 1";
    private static String user2 = "User 2";

	@Parameters({ "browser" })
	@BeforeClass
	public void setup(String browser) throws MalformedURLException, InterruptedException {
		DesiredCapabilities capability = null;
		if (browser.equalsIgnoreCase("firefox")) {
			System.out.println("firefox");
			capability = DesiredCapabilities.firefox();
			capability.setBrowserName("firefox");
			capability.setPlatform(org.openqa.selenium.Platform.ANY);
		}
		if (browser.equalsIgnoreCase("chrome")) {
			System.out.println("chrome");
			capability = DesiredCapabilities.chrome();
			capability.setBrowserName("chrome");
			capability.setPlatform(org.openqa.selenium.Platform.ANY);
		}
		if (browser.equalsIgnoreCase("iexplorer")) {
			System.out.println("iexplorer");
			capability = DesiredCapabilities.internetExplorer();
			capability.setBrowserName("iexplorer");
			capability.setPlatform(org.openqa.selenium.Platform.WINDOWS);
		}
		
		driver1 = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
		Thread.sleep(100000);
		driver1.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
    	driver1.manage().timeouts().pageLoadTimeout(120,TimeUnit.SECONDS);
    	
    	
    	driver2 = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
		driver2.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    	driver2.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);
    	
	}
	
    @AfterClass
	public void tearDown() {
    	driver1.close(); 
    	driver1.quit(); 
    	
    	driver2.close();
    	driver2.quit();
	}
    
	@Test
	public void testcase1() throws InterruptedException {
		//logged as user1
		driver1.get("http://node-chatty.herokuapp.com/chatty");
		System.out.println("browser 1 opened");
		driver1.findElement(By.xpath("/html/body/div[5]/div[2]/input")).sendKeys(user1);
		webElement=driver1.findElement(By.xpath("//*[@id='done']"));
		webElement.click();
		Thread.sleep(1000);
		
		//opening browser2 and logged as user2 
		driver2.get("http://node-chatty.herokuapp.com/chatty");
		System.out.println("browser 2 opened");
		driver2.findElement(By.xpath("/html/body/div[5]/div[2]/input")).sendKeys(user2);
		webElement=driver2.findElement(By.xpath("//*[@id='done']"));
		webElement.click();
		Thread.sleep(10000);
		
		//Input from user1
		driver1.findElement(By.xpath("//*[@id='input']/form/input")).sendKeys("from user1");
		webElement=driver1.findElement(By.xpath("//*[@id='input']/form/button"));
		webElement.click();
			
	//verify the input of user one by user two 
	Assert.assertEquals(driver2.findElement(By.xpath("//*[@id='messages-inner']/div[1]/div[2]")).getText(),"from user1");

	}
	
	@Test(dependsOnMethods="testcase1")
	public void case2() throws InterruptedException {
		driver2.findElement(By.xpath("//*[@id='input']/form/input")).sendKeys("from user2");
		webElement=driver2.findElement(By.xpath("//*[@id='input']/form/button"));
		webElement.click();
	
		//verify the input of user one by user two 
		Assert.assertEquals(driver1.findElement(By.xpath("//*[@id='messages-inner']/div[2]/div[2]")).getText(),"from user2");
	}
}
