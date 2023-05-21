package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExcel {

	//Method m    // to get data from excel sheet
	
	public String[][] getExcelData(String sheetName) throws InvalidFormatException, IOException {
        File file = new File(System.clearProperty("user.dir")+ "\\src\\test\\resources\\testdata\\testdata.xlsx");
        FileInputStream fis = new FileInputStream(file);
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheet(sheetName);

        int totalRows = sheet.getLastRowNum();
        Row rowCells = sheet.getRow(0);
        int totalCols = rowCells.getLastCellNum();
        String testdata[][] = new String[totalRows + 1][totalCols];
        DataFormatter df = new DataFormatter();
        for (int i = 1; i <= totalRows; i++) {
            for (int j = 0; j < totalCols; j++) {
                testdata[i][j] = df.formatCellValue(sheet.getRow(i).getCell(j));
                System.out.println(testdata[i][j]);
            }
        }
        return testdata;
    }
}



