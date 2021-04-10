package com.testUtils;

import java.io.FileInputStream;
import java.util.ArrayList;
import com.testUtils.JxlUtility;
import jxl.Sheet;
import jxl.Workbook;

public class JxlUtility {
	static  FileInputStream fileInputStream = null;
	static Workbook workbook = null;
	static Sheet sheet ;
	static int srn ;
	static int scn;

	static  public Sheet readWorkBook(String jxlfilePath,String sheetName) throws Exception {   	  
		fileInputStream = new FileInputStream(jxlfilePath);
		workbook = Workbook.getWorkbook(fileInputStream);
		return sheet =workbook.getSheet(sheetName);    	   
	}

	static  public ArrayList<String> readSpecificRow(String jxlfilePath,String sheetName,int row) throws Exception {    	       
		JxlUtility.readWorkBook(jxlfilePath, sheetName);
		ArrayList<String> rowData = new ArrayList<String>();
		srn = sheet.getRows();
		scn = sheet.getColumns();
		if (srn>row) {
			for (int i = 0; i < scn; i++) {
				String data =sheet.getCell(i, row).getContents();
				rowData.add(data);
			}
		}else {
			System.out.println("Enter The Valid Row Number It Should Be Less Than "+srn);
		}   		   		
		return rowData; 
	}	

	static  public ArrayList<String> readSpecificColoum(String jxlfilePath,String sheetName,int coloum) throws Exception {
		JxlUtility.readWorkBook(jxlfilePath, sheetName);
		ArrayList<String> coloumData = new ArrayList<String>();
		srn = sheet.getRows();
		scn = sheet.getColumns();
		if (scn>coloum) {
			for (int i = 0; i < srn; i++) {
				String data =sheet.getCell(coloum, i).getContents();
				coloumData.add(data);
			}
		} else {
			System.out.println("Enter The Valid Coloum Number It Should Be Less Than "+scn);
		}     	     
		return coloumData;
	}

	static  public ArrayList<String> readDataBetweenColoum(String jxlfilePath,String sheetName,int coloum,int row) throws Exception {
		JxlUtility.readWorkBook(jxlfilePath, sheetName);
		ArrayList<String> coloumData = new ArrayList<String>();
		srn = sheet.getRows();
		scn = sheet.getColumns();
		if (scn>coloum) {
			for (int i = row; i < srn; i++) {
				String data =sheet.getCell(coloum, i).getContents();
				coloumData.add(data);
			}
		} else {
			System.out.println("Enter The Valid Coloum Number It Should Be Less Than "+scn);
		}     	     
		return coloumData;
	}	

	static  public String readCell(String jxlfilePath,String sheetName,int rowNumber,int coloumNumber) throws Exception {
		JxlUtility.readWorkBook(jxlfilePath, sheetName);
		srn = sheet.getRows();
		scn = sheet.getColumns();
		if (srn>rowNumber && scn>coloumNumber && sheet.getCell(coloumNumber, rowNumber).getContents().isEmpty()!=true) {
			String cellData =sheet.getCell(coloumNumber, rowNumber).getContents();
			return cellData;

		} else {
			return "Enter Valid Cell Number or Location";
		}     	
	}	

	static  public void readSheet(String jxlfilePath,String sheetName) throws Exception {
		JxlUtility.readWorkBook(jxlfilePath, sheetName);
		ArrayList<String> nameofsheet = new ArrayList<String>();     	
		srn = sheet.getRows();
		scn =sheet.getColumns();    	  
		for (String sheetsName : workbook.getSheetNames()) {
			nameofsheet.add(sheetsName);
		}  

		for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
			if (sheetName.contains(nameofsheet.get(i))) {       			        			
				for (int j = 0; j < srn; j++) {
					for (int k = 0; k < scn; k++) {
						String data = sheet.getCell(k, j).getContents();
						System.out.print(data+"\t");}
					System.out.println();}}						
		} 	
	}    
}
