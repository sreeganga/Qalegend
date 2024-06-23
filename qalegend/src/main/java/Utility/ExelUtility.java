package Utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExelUtility {
	public static FileInputStream file;
	public static XSSFWorkbook wb;
	public static XSSFSheet sh ; 

	public static String readStringData(int i , int j, String sheet) throws IOException 
	{
		file = new FileInputStream("C:\\Users\\user\\git\\Qalegend\\qalegend\\src\\main\\resources\\Test_data.xlsx" );
		wb = new XSSFWorkbook(file);
		sh= wb.getSheet(sheet);
		XSSFRow row = sh.getRow(i);
		XSSFCell cell = row.getCell(j);
		return cell.getStringCellValue();
		
		
	}
		public static String readIntegerData(int i, int j, String sheet) throws IOException 
		{
			file = new FileInputStream("C:\\Users\\user\\git\\Qalegend\\qalegend\\src\\main\\resources\\Test_data.xlsx" );
			wb = new XSSFWorkbook(file);
			sh= wb.getSheet(sheet);
			XSSFRow row = sh.getRow(i);
			XSSFCell cell = row.getCell(j);
			int x = (int) cell.getNumericCellValue();
			return String.valueOf(x); 
			
		}

}
