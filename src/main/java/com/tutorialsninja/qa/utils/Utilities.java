package com.tutorialsninja.qa.utils;

import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utilities {
	
	public static final int IMPLICIT_WAIT_TIME=40;
	public static final int PAGE_LOAD_TIME=40;

	public static String generateEmailWithTimeStamp()
	{
		Date date =new Date();
		String timestamp = date.toString().replace(" ","_").replace(":", "_");
		return "amotoori"+timestamp+"@gmail.com";
				}

public static void  getTesDataFromExcel(String sheetName) {
	XSSFWorkbook workbook = new XSSFWorkbook();
	XSSFSheet sheet=workbook.getSheet(sheetName);
	
	int rows =sheet.getLastRowNum();
	int cols =sheet.getRow(0).getLastCellNum();
	
	Object[][] data=new Object[rows][cols];
			XSSFRow row;
			for(int i=0;i<rows;i++) {
			row=sheet.getRow(i+1);
}

}
}


