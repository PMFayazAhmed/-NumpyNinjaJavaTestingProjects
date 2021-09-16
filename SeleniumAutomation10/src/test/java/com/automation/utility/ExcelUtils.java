package com.automation.utility;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	 static XSSFWorkbook workbook;
	 static XSSFSheet sheet;
	 
	 
	 //Constructor - same as class name
	 public ExcelUtils(String excelpath, String sheetname)
	 {
	  try {
	   
	   workbook = new XSSFWorkbook(excelpath);
	   sheet = workbook.getSheet(sheetname);
	   
	  } catch (IOException e) {
	   // TODO Auto-generated catch block
	   e.printStackTrace();
	  }
	 }
	
	
	
public static int getRowCount()
{ 
 int rowCount = 0;
 rowCount = sheet.getPhysicalNumberOfRows();
 //System.out.println("Number of rows : " + rowCount);   
 return rowCount; 
        
}

public static int getColumnCount()
{
 int colCount = 0; 
 colCount = sheet.getRow(0).getPhysicalNumberOfCells();
 //System.out.println("Number of rows : " + colCount);
 return colCount;
}




public String getCellDataString(int i, int j) {
	// TODO Auto-generated method stub
	return null;
}

}
