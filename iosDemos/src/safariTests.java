import java.net.MalformedURLException;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class safariTests extends baseSafari {

	public static void main(String[] args) throws MalformedURLException {

		IOSDriver<IOSElement> driver = Capabilities();
		
		//log into gmail
		driver.get("http://www.gmail.com");
		driver.findElementById("identifierId").sendKeys("comscorevincent@gmail.com");
		driver.findElementById("identifierNext").click();
		driver.findElementByName("password").sendKeys("comscore3Testing1234!");
		driver.findElementById("passwordNext").click();
		driver.findElementByXPath("//*[text()='I am not interested']").click();
	
	}

}
