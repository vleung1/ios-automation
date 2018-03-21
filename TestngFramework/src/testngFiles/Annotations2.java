package testngFiles;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Annotations2 {

	@BeforeSuite
	public void installsoftware() {
		System.out.println("This executes first before all");
	}
	
	@AfterSuite
	public void uninstallsoftware() {
		System.out.println("This executes last after all");
	}
	
}
