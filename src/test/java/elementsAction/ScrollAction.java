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

public class ScrollAction {
	@Test
	public void ScrollTest() throws InterruptedException 
	{
		// create session
		AppiumDriver driver = CreateSession.initializeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// click on views
		driver.findElement(AppiumBy.accessibilityId("Views")).click();

		// complete page list
		WebElement ele1=driver.findElement(AppiumBy.id("android:id/list"));

		// scroll action -down
		((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
				"elementId",((RemoteWebElement) ele1).getId(), 
				"direction", "down",
				"percent", 0.85
				));

				
				  Thread.sleep(1000);
				  
				  // scroll action -up 
				  ((JavascriptExecutor)driver).executeScript("mobile: scrollGesture", ImmutableMap.of("elementId",
				  ((RemoteWebElement) ele1).getId(), 
				  "direction", "up", 
				  "percent", 0.85));
				 
	}
	
	
}
