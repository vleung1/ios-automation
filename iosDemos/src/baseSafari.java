import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class baseSafari {

	public static IOSDriver<IOSElement> Capabilities() throws MalformedURLException {

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 8");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "IOS");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
		//uses the BROWSER_NAME capability instead of APP
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "safari");
		IOSDriver<IOSElement> driver = new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

}
