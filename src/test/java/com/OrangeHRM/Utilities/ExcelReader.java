package com.OrangeHRM.Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelReader {
	/* Workbook-----Sheet----Row----cell */
	public XSSFWorkbook xssfWorkbook;
	public XSSFSheet xssfSheet;

	@DataProvider
	public String[][] getData() {
		try {
			String pathString = System.getProperty("user.dir") + "./Configurations/data1.xlsx";
			FileInputStream fileInputStream = new FileInputStream(pathString);
			xssfWorkbook = new XSSFWorkbook(fileInputStream);
		} catch (Exception e) {

			e.printStackTrace();
		}
		int count = xssfWorkbook.getNumberOfSheets();
		System.out.println("Total number of sheets in excel=" + count);
		int numberofrows = 0;
		int numberOfCols = 0;
		for (int i = 0; i < count; i++) {
			// String sheetNames=xssfWorkbook.getSheetAt(i).getSheetName();
			xssfSheet = xssfWorkbook.getSheetAt(i);
			System.out.println("Sheets are =" + xssfSheet);
			// xssfSheet.getLastRowNum()
			// xssfSheet.getRows
			numberofrows = xssfSheet.getPhysicalNumberOfRows();

			/* With the above statement */
			System.out.println("Number of physical rows = " + numberofrows);
			numberOfCols = xssfSheet.getRow(0).getLastCellNum();
			System.out.println("Number of Columns = " + numberOfCols);
		}
		String[][] data = new String[numberofrows - 1][numberOfCols];
		for (int i = 0; i < numberofrows - 1; i++) {
			for (int j = 0; j < numberOfCols; j++) {
				DataFormatter dataFormatter = new DataFormatter();
				data[i][j] = dataFormatter.formatCellValue(xssfSheet.getRow(i + 1).getCell(j));

			}
		}

		try {
			xssfWorkbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		for(String[] dataArr:data) {
//			System.out.println(Arrays.toString(dataArr));
//		}
		return data;

	}

}
