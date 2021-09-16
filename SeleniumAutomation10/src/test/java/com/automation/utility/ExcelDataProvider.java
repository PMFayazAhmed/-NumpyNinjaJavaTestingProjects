package com.automation.utility;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDataProvider {
	
	
	
	@Test(dataProvider = "test1data")
	 
	 public void GetCellDatafromExcel(String username, String password)
	 {
	  //Get input parameters equal to parameters in excel
	  System.out.println(username + " | " + password);  
	 }

	
	//Create a function and provide TestNG annotation
	 @DataProvider(name = "test1data")
	 
	 public Object[][] getData()
	 {
	  
	  String excelpath = ".\\TestData\\Login.xlsx";
	  
	  String sheetname = "Sheet1";
	  
	  //Call the excel data provider function
	  Object data [][] = testData(excelpath,sheetname);
	  
	  return data; //return the data object
	  
	 }
	
	 public static Object[][] testData(String excelpath, String sheetname)
	 {
	  
	  ExcelUtils excel = new ExcelUtils(excelpath,sheetname);
	  
	  int rowCount = excel.getRowCount();
	  
	  int colCount = excel.getColumnCount();
	  
	  
	  //Create the Object
	  Object data [][] = new Object [rowCount-1] [colCount];
	  
	  for (int i=1; i<= rowCount; i++)  
	  {   
	   for (int j=0; j <= colCount; j++)
	   {
	    String cellData = excel.getCellDataString(i, j);
	    System.out.println(cellData + " | ");
	    data [i-1][j] = cellData; //Store the value in the object array
	   } 
	   
	    System.out.println();
	    
	 }
	  return data;
	 }
	
	
	

}
