import java.net.MalformedURLException;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class menuBrowse extends base{

	public static void main(String[] args) throws MalformedURLException {

		IOSDriver<IOSElement> driver = Capabilities();
		TouchAction t = new TouchAction(driver);
		t.tap(driver.findElementByAccessibilityId("Alert Views")).perform();
		t.tap(driver.findElementByXPath("//*[@value='Text Entry']")).perform();
		driver.findElementByClassName("XCUIElementTypeTextField").sendKeys("hello");
		//could not use touchaction tap here because it did not allow for navigate().back() in next step to work
		driver.findElementByName("OK").click();
		driver.navigate().back();
		
		t.tap(driver.findElementByAccessibilityId("Steppers")).perform();
		t.tap(driver.findElementsByName("Increment").get(0)).perform();
		t.tap(driver.findElementsByName("Increment").get(0)).perform();
		System.out.println(driver.findElementsByClassName("XCUIElementTypeStaticText").get(0).getText());
		System.out.println(driver.findElementsByClassName("XCUIElementTypeStaticText").get(1).getText());
		System.out.println(driver.findElementsByClassName("XCUIElementTypeStaticText").get(2).getText());
		t.tap(driver.findElementsByName("Decrement").get(0)).perform();
		System.out.println(driver.findElementsByClassName("XCUIElementTypeStaticText").get(0).getText());
		System.out.println(driver.findElementsByClassName("XCUIElementTypeStaticText").get(1).getText());
		System.out.println(driver.findElementsByClassName("XCUIElementTypeStaticText").get(2).getText());
		driver.navigate().back();
		t.tap(driver.findElementByAccessibilityId("Picker View")).perform();
		driver.findElementByName("Blue color component value").sendKeys("140");
		driver.findElementsByClassName("XCUIElementTypePickerWheel").get(0).sendKeys("50");
		driver.findElementByAccessibilityId("Green color component value").sendKeys("220");
		//changing any 2 wheels is OK, but the 3rd one causes UICatalog app to crash, no matter which order the wheels are used-- could not reproduce during manual interaction
		//driver.findElementByXPath("//*[@name='Blue color component value']").sendKeys("130");
		driver.navigate().back();


		
		/* this works
		Dimension size = driver.manage().window().getSize();
		System.out.println(size);
		int x = (int) (size.width / 2);
		int starty = (int)(size.height / 1.1);
		int endy = (int)(size.height / 10);
		t.press(x, starty).moveTo(x, endy).release().perform();
		*/
		
		/* this didnt work
		MobileElement el = driver.findElementByAccessibilityId("Web View");
		scrollToDirection_iOS_XCTest(el, "d");
		*/
		
		/* need to test this more
		JavascriptExecutor js = (JavascriptExecutor) driver;
		HashMap scrollObject = new HashMap();
		scrollObject.put("direction", "down");
		js.executeScript("mobile: scroll", scrollObject);
		*/
		
		/* this is opening 2 emulator sessions and failing
		JavascriptExecutor js = (JavascriptExecutor) driver;
		HashMap<String, String> swipeObject = new HashMap<String, String>();
		IOSElement el = driver.findElementByAccessibilityId("Web View");
		swipeObject.put("element", el.getId());
	     swipeObject.put("direction", "down");
	     swipeObject.put("toVisible", "true");
	     js.executeScript("mobile: scroll", swipeObject);
	     */
		
		
	}
	
	/* iOS scroll by object
    public static boolean swipeToDirection_iOS_XCTest(MobileElement el, String direction) throws MalformedURLException {
		IOSDriver<IOSElement> driver = Capabilities();
    		try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            HashMap<String, String> swipeObject = new HashMap<String, String>();
            if (direction.equals("d")) {
                swipeObject.put("direction", "down");
            } else if (direction.equals("u")) {
                swipeObject.put("direction", "up");
            } else if (direction.equals("l")) {
                swipeObject.put("direction", "left");
            } else if (direction.equals("r")) {
                swipeObject.put("direction", "right");
            }
            swipeObject.put("element", el.getId());
            js.executeScript("mobile:swipe", swipeObject);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
	*/
	/*
    public static boolean scrollToDirection_iOS_XCTest(MobileElement el, String direction) throws MalformedURLException {
        // The main difference from swipe call with the same argument is that scroll will try to move
        // the current viewport exactly to the next/previous page (the term "page" means the content,
        // which fits into a single device screen)
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            HashMap<String, String> scrollObject = new HashMap<String, String>();
            if (direction.equals("d")) {
                scrollObject.put("direction", "down");
            } else if (direction.equals("u")) {
                scrollObject.put("direction", "up");
            } else if (direction.equals("l")) {
                scrollObject.put("direction", "left");
            } else if (direction.equals("r")) {
                scrollObject.put("direction", "right");
            }
            scrollObject.put("element", el.getId());
            scrollObject.put("toVisible", "true"); // optional but needed sometimes
            js.executeScript("mobile:scroll", scrollObject);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
	*/
}
