package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import constants.Constants;

public class Test_Data {

	public static String Datasheet(String sheetname, int rows, int columns) throws Exception{
		File location = new File(Constants.datafilepath);
		FileInputStream fin = new FileInputStream(location);
		XSSFWorkbook workbook = new XSSFWorkbook(fin);
		XSSFSheet sheet = workbook.getSheet(sheetname);
		XSSFRow row1 = sheet.getRow(rows);
		XSSFCell cell2 = row1.getCell(columns);
		//CellType ctype = cell2.getCellType();
		/*System.out.println("ctype" + ctype);
		if (ctype = "STRING") {
			value = cell.getStringCellValue();
		} else if (ctype == 0) {
			double num = cell.getNumericCellValue();
			System.out.println("Number is" + num);
			value = String.valueOf(num);
			System.out.println("string  value is" + value);
		} else {
			Date dateCell = cell.getDateCellValue();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
			value = dateFormat.format(dateCell);
		}
	}*/
		
		String value=cell2.getStringCellValue();
		return value;
}
}

    
		
	
