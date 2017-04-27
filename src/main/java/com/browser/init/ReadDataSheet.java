package com.browser.init;


/**
 * @author Avinash
 *
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadDataSheet {
	XSSFSheet sheet1;
	XSSFWorkbook wb;
	File src;
	FileInputStream fis;
	FileOutputStream fo;
	
	public  ReadDataSheet(String Path){
		
			try {
				src=new File(Path);
				fis = new FileInputStream(src);
				wb= new XSSFWorkbook(fis);
				sheet1=wb.getSheetAt(0);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			
			}
		}
	

	public String  ReadFile(String SheetNumber, int row_id, int column_id ){
		
		String data=sheet1.getRow(row_id).getCell(column_id).getStringCellValue();
		return data	;
		
	}
		
	public void WriteFile(String custID) throws IOException{
		sheet1.getRow(0).createCell(9).setCellValue(custID);
		fo =new FileOutputStream(src);
		wb.write(fo);
		wb.close();
	}
	
	}



