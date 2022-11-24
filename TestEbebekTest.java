import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class TestEbebekTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void testing() {
    driver.get("https://www.e-bebek.com/");
    driver.manage().window().setSize(new Dimension(1382, 744));
    driver.findElement(By.id("txtSearchBox")).click();
    driver.findElement(By.id("txtSearchBox")).sendKeys("biberon");
    driver.findElement(By.id("txtSearchBox")).sendKeys(Keys.ENTER);
    js.executeScript("window.scrollTo(0,12)");
    driver.findElement(By.cssSelector(".col-6:nth-child(1) .is-initialized > .ng-star-inserted")).click();
    {
      WebElement element = driver.findElement(By.cssSelector(".col-6:nth-child(1) .is-initialized > .ng-star-inserted"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    js.executeScript("window.scrollTo(0,50)");
    driver.findElement(By.id("addToCartBtn")).click();
    driver.findElement(By.id("btnShowCart")).click();
    js.executeScript("window.scrollTo(0,202)");
  }
}
