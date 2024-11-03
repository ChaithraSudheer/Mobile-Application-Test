package appiumAssignments;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class Assignment3_DragandDrop {

	public static void main(String[] args) 
	{
		//create driver session
		AppiumDriver driver=CreateSession.initializeDriver();
		
		//view
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		//drag and drop
		driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
        
		//first elemnt
		WebElement ele=driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));
		
		System.out.println("First Element is dragging......!!!");
		
		//drag and drop
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", 
			ImmutableMap.of(
		    "elementId", ((RemoteWebElement) ele).getId(),
		    "endX",577, 
		    "endY",992
		));
		
		System.out.println("First element is dropped!!!");
		
		String resultText=driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_result_text")).getText();
        System.out.println("Drag and Drop Result Rext is: "+resultText);
		
	}

}
