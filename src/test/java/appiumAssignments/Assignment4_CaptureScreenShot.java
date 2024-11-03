package appiumAssignments;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class Assignment4_CaptureScreenShot {

	public static void main(String[] args) throws IOException {
		// open APIdemos application
		// Capabilities
		DesiredCapabilities descap = new DesiredCapabilities();
		descap.setCapability("platformName", "Android");
		descap.setCapability("appium:automationName", "Uiautomator2");
		descap.setCapability("appium:deviceName", "pixel_6a");
		descap.setCapability("appium:udid", "emulator-5554");

		// application path
		String appPath = System.getProperty("user.dir") + "/src/test/resources/ApiDemos-debug.apk";
		descap.setCapability("appium:app", appPath);

		// server connectivity
		URL url = new URL("http://0.0.0.0:4723");

		// create session
		AppiumDriver driver = new AndroidDriver(url, descap);

		// capture screenshot
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//location
		File dest=new File(System.getProperty("user.dir")+"//Screenshot//devicescreen"+System.currentTimeMillis()+".png");
		FileHandler.copy(source, dest);
		
		System.out.println("Session ID is: " + driver.getSessionId());
	}

}
