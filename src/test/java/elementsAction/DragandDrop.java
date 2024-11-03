package elementsAction;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import sessions.CreateSession;

public class DragandDrop {
  @Test
  public void clickanddraganddropTest()
  {
	  //create driver session
	  AppiumDriver driver=CreateSession.initializeDriver();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  
	  //views
	  WebElement ele1=driver.findElement(AppiumBy.accessibilityId("Views"));
      
	  //click gesture
	  driver.executeScript("mobile: clickGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) ele1).getId()
			));
	  
	  System.out.println("Clicked through mobile gesture");
	  
	  //drag and drop
	  driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
	  
	  //elemnt-dot3
	  WebElement ele2=driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_3"));
      
	  //drag gesture
	  ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) ele2).getId(),
			    "endX", 615,
			    "endY", 955
			));
	  
	  System.out.println("Drag action is completed");
	  
	  //capture result text
	  String text=driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_result_text")).getText();
      System.out.println("Result text is: "+text);
  
  }
}
