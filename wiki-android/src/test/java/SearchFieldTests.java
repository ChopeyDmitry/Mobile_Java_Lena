import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class SearchFieldTests extends  TestBase {
  @Test
  public  void testTypeWordInSearchField(){
    type(By.xpath("//*[contains(@text, 'Search Wikipedia')]"), "java");

  }


  public void waitAndClick(By locator){
    WebElement element = waitForElementPresent(locator, "Element not found", 10);
    element.click();

  }

  public void type(By locator, String text) {

   waitAndClick(locator);
    //driver.findElement(locator).clear();
    driver.findElement(locator).sendKeys(text);
  }

  public WebElement waitForElementPresent(By locator, String errorMessage, long timeoutSeconds){
    WebDriverWait wait = new WebDriverWait(driver, timeoutSeconds);
    wait.withMessage(errorMessage + "/n");
    return wait.until(ExpectedConditions.presenceOfElementLocated(locator));

  }
}
