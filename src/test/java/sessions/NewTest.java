package sessions;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class NewTest {

    private AppiumDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("platformName", "Android");
        cap.setCapability("appium:automationName", "UiAutomator2");
        cap.setCapability("appium:deviceName", "pixel_6a");
        cap.setCapability("appium:udid", "emulator-5554");

        // Application path
        String appPath = System.getProperty("user.dir") + "/src/test/resources/ApiDemos-debug.apk";
        cap.setCapability("appium:app", appPath);

        // Server Connectivity
        URL url = new URL("http://127.0.0.1:4723/wd/hub");

        // Create a session
        driver = new AndroidDriver(url, cap);
    }

    
    public void sessionTest() {
        System.out.println("Session ID is: " + driver.getSessionId());
        // Add your test steps here
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
