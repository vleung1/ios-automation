package testngFiles2;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotations {

	@BeforeTest
	public void DeleteCookies() {
		System.out.println("This block executes before all test cases");
	}
	
	@BeforeMethod
	public void UserIdGeneration() {
		System.out.println("This block executes before EACH test case");
	}
	
	@AfterTest
	public void DeleteCookiesClose() {
		System.out.println("This block executes after all test cases");
	}
	
	@AfterMethod
	public void TestReporting() {
		System.out.println("This block executes after EACH test case");
	}
	
	@Test
	public void TestCase1() {
		System.out.println("This is test case 1");
	}
	
	@Test
	public void TestCase2() {
		System.out.println("This is test case 2");
	}
	
	@Test
	public void TestCase3() {
		System.out.println("This is test case 3");
	}
}