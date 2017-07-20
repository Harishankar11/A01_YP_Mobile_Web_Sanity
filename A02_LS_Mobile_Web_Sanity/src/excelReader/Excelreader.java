package excelReader;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelreader {

	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFCell cell;
	XSSFRow row;

	public void excelpath(String filepath)
	{
		try {
			
		//Excel sheet path declare
		File fi = new File(filepath);
		//input file load
		FileInputStream fis = new FileInputStream(fi);
		//Copy of the file history
		wb = new XSSFWorkbook(fis);
			
		} catch (Exception ie) {
		
			System.out.println(ie.getMessage()+"Error in excel reader");
		}
		
	}
	
	public String excelreader(int sheetnumber, int row, int column)
	{
		try{
		//get sheet number
		sheet = wb.getSheetAt(sheetnumber);
		//getting cell values in row and column
		cell = sheet.getRow(row).getCell(column);
		//checking data types in cell int = 0 string = 1
		int datatype = cell.getCellType();
		//if data = int execute the first block
		
		
		if (datatype==0)
		{

			long big1 = (long) sheet.getRow(row).getCell(column).getNumericCellValue();
			
			String s2 = String.valueOf(big1);
			
			return s2;
		}else {
			
			String exdata = sheet.getRow(row).getCell(column).getStringCellValue();
			
		return exdata;
		
		}
		
		}catch(Exception ie2)
		{
			
		}
		
		return null;
		
	}
	
	public int excelcellcount(int sheetnumber)
	{
		sheet = wb.getSheetAt(sheetnumber);
		
		int totalrow = sheet.getLastRowNum();
		
		
		return totalrow;
		
	}

}
