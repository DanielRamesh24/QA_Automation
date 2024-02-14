package utils;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import constants.Constants;

public class Test_Data {

	public static String Datasheet(String sheetname, int rows, int columns) throws Exception {
		Object result = new Object();
		File location = new File(Constants.datafilepath);
		FileInputStream fin = new FileInputStream(location);
		XSSFWorkbook workbook = new XSSFWorkbook(fin);
		XSSFSheet sheet = workbook.getSheet(sheetname);
		XSSFRow row1 = sheet.getRow(rows);
		XSSFCell cell2 = row1.getCell(columns);

		if (cell2 != null) {
			switch (cell2.getCellType()) { // to get different types of cell values
			case NUMERIC:// numeric value in excel
				result = cell2.getNumericCellValue();
				break;

			case STRING: // string value in excel
				result = cell2.getStringCellValue();
				break;

			case BOOLEAN: // boolean value in excel
				result = cell2.getBooleanCellValue();
				break;

			case BLANK: // blank value in excel
				result = cell2.getStringCellValue();
				break;
			default:
				break;
			}

			// CellType ctype = cell2.getCellType();
			/*
			 * System.out.println("ctype" + ctype); if (ctype = "STRING") { value =
			 * cell.getStringCellValue(); } else if (ctype == 0) { double num =
			 * cell.getNumericCellValue(); System.out.println("Number is" + num); value =
			 * String.valueOf(num); System.out.println("string  value is" + value); } else {
			 * Date dateCell = cell.getDateCellValue(); SimpleDateFormat dateFormat = new
			 * SimpleDateFormat("dd-mm-yyyy"); value = dateFormat.format(dateCell); } }
			 */

			/*
			 * String value=cell2.getStringCellValue(); return value;
			 */
		}
		return result.toString();
	}
}
