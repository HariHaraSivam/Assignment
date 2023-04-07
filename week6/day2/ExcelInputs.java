package week6.day2;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelInputs {
public static String[][] inputData(String fileName) throws IOException {
	// to open excel
	// workbook file path
	XSSFWorkbook wb= new XSSFWorkbook("ExcelData/"+fileName+".xlsx");
	//Access the sheet
	XSSFSheet ws= wb.getSheetAt(0);
	//find row count
	int rowCount = ws.getLastRowNum();
	//find column count
	short columnCount = ws.getRow(0).getLastCellNum();
	String[][] data = new String[rowCount][columnCount];
	for (int i = 1; i <= rowCount; i++) {
		XSSFRow row = ws.getRow(i);
		for (int j = 0; j < data.length; j++) {
			XSSFCell cell = row.getCell(j);
			String cellValue = cell.getStringCellValue();
			data[i-1][j] = cellValue;
			System.out.println(cellValue);
			
		}
		
	}
	wb.close();
	return data;
	
	
}
}
