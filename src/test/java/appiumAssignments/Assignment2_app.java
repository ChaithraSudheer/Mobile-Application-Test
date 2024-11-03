package appiumAssignments;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class Assignment2_app 
{
	public static void main(String[] args) throws MalformedURLException 
	{
		
	    //To launch mobile application
		//Capabilities
		DesiredCapabilities descap=new DesiredCapabilities();
		descap.setCapability("platformName","Android");
		descap.setCapability("appium:automationName","Uiautomator2");
		descap.setCapability("appium:deviceName","pixel_6a");
		descap.setCapability("appium:udid","emulator-5554");
		
		//application path
		String appPath=System.getProperty("user.dir")+"/src/test/resources/ApiDemos-debug.apk";
		descap.setCapability("appium:app",appPath);
		
		//server connectivity
		URL url=new URL("http://0.0.0.0:4723");
		
		//create session
		AppiumDriver driver=new AndroidDriver(url,descap);
		System.out.println("Session ID is: "+driver.getSessionId());

		//application current state
		System.out.println("App Current Status is: "+((AndroidDriver)driver).queryAppState("io.appium.android.apis"));
         
		//background
		((AndroidDriver)driver).runAppInBackground(Duration.ofMillis(5000));
		System.out.println("Application is running in background");
		System.out.println("App Current Status is: "+((AndroidDriver)driver).queryAppState("io.appium.android.apis"));

		//Uninstall app
		((AndroidDriver)driver).removeApp("io.appium.android.apis");
		System.out.println("APIdemos application is uninstalled from device");
		System.out.println("App Current Status is: "+((AndroidDriver)driver).queryAppState("io.appium.android.apis"));

		//install app
		((AndroidDriver)driver).installApp(appPath);
		System.out.println("APIdemos application is installed");
		System.out.println("App Current Status is: "+((AndroidDriver)driver).queryAppState("io.appium.android.apis"));
		}
}

