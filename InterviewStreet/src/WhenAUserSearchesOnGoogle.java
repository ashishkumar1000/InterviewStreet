import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WhenAUserSearchesOnGoogle {

private GoogleSearchPage page;

@BeforeClass
public void openTheBrowser() {
page = PageFactory.initElements(new FirefoxDriver(), GoogleSearchPage.class);
page.open("http://google.co.in/");
}

@AfterClass
public void closeTheBrowser() {
page.close();
}

@Test
public void whenTheUserSearchesForSeleniumTheResultPageTitleShouldContainCats() {
page.searchFor("selenium");
System.out.println(page.getTitle());
Assert.assertEquals(page.getTitle(), "selenium") ;
}
}