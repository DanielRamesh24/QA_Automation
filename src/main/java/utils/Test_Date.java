package utils;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;

import constants.Constants;

public class Test_Date {

	public static String Datasheet(String sheetname, int rows, int columns) throws Exception{
		File location = new File(Constants.datafilepath);
		FileInputStream fin = new FileInputStream(location);
		Workbook workbook = new XSSFWorkbook(fin);
		Sheet sheet = workbook.getSheet(sheetname);
		Row row1 = sheet.getRow(rows);
		Cell cell2 = row1.getCell(columns);
		String Value = cell2.getStringCellValue();
		return Value;
		}
}
