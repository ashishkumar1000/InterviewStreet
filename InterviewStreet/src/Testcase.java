import java.io.File;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Testcase {

    private static WebDriver driver1 ;
    private static WebDriver driver2;
    private static WebElement webElement;
    private static String user1 = "User 1";
    private static String user2 = "User 2";

    
    @Parameters({ "browser" })
    @BeforeClass
	public void init(String browser) {
    	
    	if (browser.equalsIgnoreCase("chrome")) {
    		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver1 = new ChromeDriver();
			driver2 = new ChromeDriver(); 
		}
    	
    	if (browser.equalsIgnoreCase("firefox")) {
    		//File profileDirectory = new File("C://USERS//M1020750//APPDATA//ROAMING//MOZILLA//FIREFOX//PROFILES//9FLPB1NI.ASHISH");
			//FirefoxProfile profile = new FirefoxProfile(profileDirectory);
			driver1 = new FirefoxDriver();
			driver2 = new FirefoxDriver();
		}
    	
    	if (browser.equalsIgnoreCase("iexplorer")) {
			driver1 = new InternetExplorerDriver();
			driver2 = new InternetExplorerDriver();
		}
        
		driver1.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
    	driver1.manage().timeouts().pageLoadTimeout(120,TimeUnit.SECONDS);
    	
		
		driver2.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
    	driver2.manage().timeouts().pageLoadTimeout(120,TimeUnit.SECONDS);
	}
	
    @AfterClass
	public void tearDown() {
    	driver1.close(); 
    	driver1.quit(); 
    	
    	driver2.close();
    	driver2.quit();
	}
	
    	@Test
    	public void case1() throws InterruptedException {
		//opening browser one logged as user1
		driver1.get("http://node-chatty.herokuapp.com/chatty");
		driver1.findElement(By.xpath("/html/body/div[5]/div[2]/input")).sendKeys(user1);
		webElement=driver1.findElement(By.xpath("//*[@id='done']"));
		webElement.click();
		Thread.sleep(10000);
		
		//opening browser2 and logged as user2 
		driver2.get("http://node-chatty.herokuapp.com/chatty");
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
    	@Test(dependsOnMethods="case1")
    	public void case2() throws InterruptedException {
    		driver2.findElement(By.xpath("//*[@id='input']/form/input")).sendKeys("from user2");
    		webElement=driver2.findElement(By.xpath("//*[@id='input']/form/button"));
    		webElement.click();
    	
    		//verify the input of user one by user two 
    		Assert.assertEquals(driver1.findElement(By.xpath("//*[@id='messages-inner']/div[2]/div[2]")).getText(),"from user2");
		}
}

