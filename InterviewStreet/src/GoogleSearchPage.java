import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class GoogleSearchPage {

protected WebDriver driver;

@FindBy(how = How.NAME, using = "q")
private WebElement q;

@FindBy(how = How.NAME, using = "btnK")
private WebElement btnK;



public GoogleSearchPage(WebDriver driver) {
	driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
	this.driver = driver;

}

public void open(String url) {
driver.get(url);
}
public void close() {
driver.quit();
}
public String getTitle() {
return driver.getTitle();
}
public void searchFor(String searchTerm) {
q.sendKeys(searchTerm);
btnK.click();
}
public void typeSearchTerm(String searchTerm) {
q.sendKeys(searchTerm);
}
public void clickOnSearch() {
btnK.click();
}

}


