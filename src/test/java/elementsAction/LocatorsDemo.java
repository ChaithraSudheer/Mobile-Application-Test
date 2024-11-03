package elementsAction;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import sessions.CreateSession;

public class LocatorsDemo {
  @Test
  public void androidLocators() throws InterruptedException 
  {
	  //create a driver session
	  AppiumDriver driver=CreateSession.initializeDriver();
	  
	  System.out.println("Session Id is: "+driver.getSessionId());
	  
	  //Locators-accesability
	  WebElement ele1=driver.findElement(AppiumBy.accessibilityId("Access'ibility"));
	  System.out.println("Text of Element is: "+ele1.getText());
	  ele1.click();
	  
	  //click on Acessability service
	  WebElement ele2=driver.findElements(AppiumBy.id("android:id/text1")).get(2);
	  System.out.println("Text of Element is: "+ele2.getText());
	  ele2.click();
	  
	  //go back to previous page
	  driver.navigate().back();
	  Thread.sleep(2000);
	  driver.navigate().back();
	  System.out.println("Navigation to main page again");
	  
	  //views by xpath
	  driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Views\"]")).click();
	  System.out.println("Clicked on views");
	  
	  //buttons-classname
	  driver.findElements(AppiumBy.className("android.widget.TextView")).get(3).click();
	  System.out.println("Button options got clicked");
	  
	  
	  
  }
}
