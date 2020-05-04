package com.automation.utility;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	
	private Workbook workbook;
	
	
	public ExcelDataProvider(String excelFileLocation)
	{
		try {
			
			File src = new File(excelFileLocation);
			FileInputStream fis = new FileInputStream(src);
			workbook = new XSSFWorkbook(fis);
		}
		catch (IOException e)
		{
			System.out.println("Error while loading Excel file :"+ e.getMessage());
		}
	}
	
	@SuppressWarnings("unused")
	private ArrayList<String> getExcelHeader(String sheetName)
	{
		ArrayList<String> headerData = new ArrayList<String>();
		Sheet excelSheet = workbook.getSheet(sheetName);
		Row colNames = excelSheet.getRow(0);
		
		Iterator<Cell> cellIterator = colNames.iterator();
		//skipping first column
		cellIterator.next();
		
		while(cellIterator.hasNext())
		{
			Cell cell = cellIterator.next();
			headerData.add(cell.getStringCellValue());
		}
		
		return headerData;
	}
	
	public HashMap<String,String> getRowData(String sheetName, String rowId)
	{
		HashMap<String,String> map = new HashMap<String,String>();
		Sheet excelSheet = workbook.getSheet(sheetName);
		
		Iterator<Row> rowIterator = excelSheet.iterator();
		
		Row colNames=rowIterator.next();
		Iterator<Cell> ColNameIterator = colNames.iterator();
		ColNameIterator.next(); //Skiping first Column
		
		while(rowIterator.hasNext())
		{
			Row excelRow = rowIterator.next();
			Iterator<Cell> cellIterator = excelRow.iterator();
			
			if(cellIterator.next().getStringCellValue().equalsIgnoreCase(rowId))
			{
				while(ColNameIterator.hasNext())
				{	
					map.put(ColNameIterator.next().getStringCellValue(), cellIterator.next().getStringCellValue());
				}
			}
			
		}
		
		return map;
	}
	
	
}
