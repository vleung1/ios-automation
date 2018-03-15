

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class base {

	public static IOSDriver<IOSElement> Capabilities() throws MalformedURLException {
		
		//this is config for automation on iOS emulator
		//create the desiredcapabilities class
		DesiredCapabilities cap = new DesiredCapabilities();
		//set device name
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 8");
		//set platform name
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "IOS");
		//if iOS version is 10.2 or greater, must use the below line because of changes to apps' structure
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
		//set location of app to use
		cap.setCapability(MobileCapabilityType.APP, "//Users//Vince//Desktop//iosAutomation//UICatalog.app");
		//create the driver and set connection to appium server
		IOSDriver<IOSElement> driver = new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	

}
