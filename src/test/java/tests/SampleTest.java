package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import base.base;
import utilities.ReadExcel;

public class SampleTest {   ///getting data from excel sheet
	@Test
	public void testingExcel() throws InvalidFormatException, IOException{
	
		ReadExcel re = new ReadExcel();   // to get data from arrays and for loop we write in Class ReadExcell.java
		re.getExcelData("Daily schedule");  // name of the sheet
	
	
	/*@Test
	public void testingExcel() throws InvalidFormatException, IOException{
		File f = new File("C:\\Users\\dfarr\\eclipse-workspace\\daryoush.hybrid\\src\\test\\resources\\testdata\\testdata.xlsx");
	    FileInputStream fis = new FileInputStream(f);
 	    Workbook w = WorkbookFactory.create(fis);
		    Sheet s = w.getSheetAt(0);     //sheet 0 of excel file 
		    
		 /*   Row r = s.getRow(0);      // to get specific value from excel sheet by defining index
		    Cell c = r.getCell(0);
		    System.out.println(c); */
		    
		    
		 /*   for (Row row: s) {         // to get all the values from excel sheet
		    	for(Cell cell: row) {
		    		System.out.println(cell.getStringCellValue()); 
		    	}
		    } */
	}
}