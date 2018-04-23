import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataTest {
	
	public static FileInputStream fis;
    public static FileOutputStream fos;

	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static void main(String[] args) throws IOException {

		String value = getExcelCellData(2,2);
		System.out.println(value);
		String value1 = getExcelCellData(3,2);
		System.out.println(value1);
		value = setExcelCellData(2,2,"hi");
		System.out.println(value);
		

	}

	public static String getExcelCellData(int rownumber, int col) throws IOException {
		fis = new FileInputStream("//Users//Vince//Documents//appiumtestdata.xlsx");
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet("Sheet1");
		row = sheet.getRow(rownumber);
		cell = row.getCell(col);
		return cell.getStringCellValue();
	}
	
	public static String setExcelCellData(int rownumber, int col, String text) throws IOException {
		fis = new FileInputStream("//Users//Vince//Documents//appiumtestdata.xlsx");
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet("Sheet1");
		row = sheet.getRow(rownumber);
		cell = row.getCell(col);
		cell.setCellValue(text);
		saveToFile();
		return cell.getStringCellValue();
	}
	
	public static void saveToFile() throws IOException {
        fis.close();
        fos = new FileOutputStream("//Users//Vince//Documents//appiumtestdata.xlsx");
        wb.write(fos);
        fos.close();
    }
	
}
