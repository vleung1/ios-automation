import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelGmailLoginDemo {
	
	//set the POI values to null to start with
	XSSFWorkbook excelWorkbook = null;
	XSSFSheet excelSheet = null;
	XSSFRow row = null;
	XSSFCell cell = null;
	WebDriver driver = null;

	//these tests login to gmail, using data from an Excel sheet with parameters for username, password, and browser to test
	
	@Test(dataProvider = "getData") // dataProvider value should be equal to @DataProvider method name below
	public void doLogin(String username, String password, String browser) { // these values should reflect the columns available in excel sheet data
		
		//use browsers as defined by values set in excel sheet
		if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "//Users//Vince//Downloads//geckodriver");
			driver = new FirefoxDriver();
		} else if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "//Users//Vince//Downloads//chromedriver");
			driver = new ChromeDriver();
		}
		
		//the test: log into gmail 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://gmail.com");
		driver.findElement(By.xpath("//*[@id='identifierId']")).sendKeys(username);
		driver.findElement(By.id("identifierNext")).click();
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
		driver.quit();
	}

	@DataProvider // supplies data to @Test method above
	public Object[][] getData() throws IOException {
		
		// Your .xlsx file name along with path
		FileInputStream fis = new FileInputStream("//Users//Vince//Documents//seleniumtestdata.xlsx"); 
		excelWorkbook = new XSSFWorkbook(fis);
		// Read sheet inside the workbook by its name
		excelSheet = excelWorkbook.getSheet("Sheet1"); // Your sheet name
		
		//print out index of rows (excel and POI starts at 0)
		System.out.println("First row number/index:" + excelSheet.getFirstRowNum());
		System.out.println("Last row number/index:" + excelSheet.getLastRowNum());
		
		//get the count of rows and columns available in sheet
		int rowCount = excelSheet.getLastRowNum() - excelSheet.getFirstRowNum() + 1;
		int colCount = excelSheet.getRow(0).getLastCellNum();
		
		//print out row and column count
		System.out.println("Row count is: " + rowCount);
		System.out.println("Column count is: " + colCount);
		
		//create two dimensional array for data from cells
		Object data[][] = new Object[rowCount - 1][colCount];
		System.out.println("Data in Excel sheet below:");
		
		//iterate through the rows
		for (int rNum = 2; rNum <= rowCount; rNum++) {
			//iterate through the columns to print contents column by column
			for (int cNum = 0; cNum < colCount; cNum++) {
				System.out.print(getCellData("Sheet1", cNum, rNum) + " "); // Your sheet name
				data[rNum - 2][cNum] = getCellData("Sheet1", cNum, rNum); // Your sheet name
			}		
			System.out.println();
		}
		return data;
	}

	
	// Function will return the data from a cell 
	public String getCellData(String sheetName, int colNum, int rowNum) {
		try {
			if (rowNum <= 0)
				return "";
			int index = excelWorkbook.getSheetIndex(sheetName);
			if (index == -1)
				return "";
			excelSheet = excelWorkbook.getSheetAt(index);
			row = excelSheet.getRow(rowNum - 1);
			if (row == null)
				return "";
			cell = row.getCell(colNum);
			if (cell == null)
				return "";
			if (cell.getCellTypeEnum() == CellType.STRING)
				return cell.getStringCellValue();
			else if (cell.getCellTypeEnum() == CellType.NUMERIC || cell.getCellTypeEnum() == CellType.FORMULA) {
				String cellText = String.valueOf(cell.getNumericCellValue());
				return cellText;
			} else if (cell.getCellTypeEnum() == CellType.BLANK)
				return "";
			else
				return String.valueOf(cell.getBooleanCellValue());
		} catch (Exception e) {
			e.printStackTrace();
			return "row " + rowNum + " or column " + colNum + " does not exist in excel sheet";
		}
	}
}