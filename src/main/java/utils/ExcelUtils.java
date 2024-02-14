package utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import constants.Constants;


public class ExcelUtils {

	
	
	static FileInputStream filelocation;
	static Workbook wb;
	static Sheet sheet;
	static Row row;
	static Cell cell;
	static int totalrows;
	static int totalcolumns;

	public static void openExcel() throws IOException {// to open the excel
		filelocation = new FileInputStream(Constants.datafilepath);
//		String fileExtension = FilenameUtils.getExtension(Constant.datafilepath);
		String fileExtension = Constants.datafilepath.substring(Constants.datafilepath.indexOf("."));// to get the= extension of the file
		if (fileExtension.equals(".xlsx")) {
			wb = new XSSFWorkbook(filelocation);
		} else if (fileExtension.equals(".xls")) {
			wb = new HSSFWorkbook(filelocation);
		}
	}

	public static String readExcel(String Sheetname, String TestCase_ID, String HeaderValue) throws Exception{// to read and get the data from the excel
		
		if(!(TestCase_ID.equalsIgnoreCase(""))) {// Condition for custom exception
		
		Object result = new Object();
//		String result;
		sheet = wb.getSheet(Sheetname);
		row = sheet.getRow(0);
		totalrows = sheet.getLastRowNum();

		totalcolumns = row.getLastCellNum();

		for (int i = 0; i <= totalrows; i++) { // iteration for rows
			String TCID = sheet.getRow(i).getCell(0).getStringCellValue();
			if (TCID.equalsIgnoreCase(TestCase_ID)) {
				System.out.println(TCID);
				for (int j = 1; j < totalcolumns; j++) {// iteration for columns
					
					String TestdataHeadervalues = sheet.getRow(0).getCell(j).getStringCellValue();
					if (TestdataHeadervalues.equalsIgnoreCase(HeaderValue)) {
						cell = sheet.getRow(i).getCell(j);
						System.out.println(cell);
						if (cell != null) {
							switch (cell.getCellType()) { // to get different types of cell values
							case NUMERIC:// numeric value in excel
								result = cell.getNumericCellValue();
								break;

							case STRING: // string value in excel
								result = cell.getStringCellValue();
								break;

							case BOOLEAN: // boolean value in excel
								result = cell.getBooleanCellValue();
								break;

							case BLANK: // blank value in excel
								result = cell.getStringCellValue();
								break;
							default:
								break;
							}
							
						}
					}
				}
			}
		}
		return result.toString();
	}

		
	
	else {
		throw new Exception("TCID value is null and its format TC_001"); // custom exception for null tc id value
	}
}	
		
	public static void closeExcel() throws IOException { // to close the excel
		filelocation.close();
	}
}