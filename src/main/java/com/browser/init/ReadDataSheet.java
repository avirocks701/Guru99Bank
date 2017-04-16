package com.browser.init;


/**
 * @author Avinash
 *
 */

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadDataSheet {
	XSSFSheet sheet1;
	XSSFWorkbook wb;
	
	public  ReadDataSheet(String Path){
		
			try {
				File src=new File(Path);
				FileInputStream fis;
				fis = new FileInputStream(src);
				wb= new XSSFWorkbook(fis);
				sheet1=wb.getSheetAt(0);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			
			}
		}
	

	public String  ReadFile(String SheetNumber, int row_id, int column_id ){
		
		String data=sheet1.getRow(row_id).getCell(column_id).getStringCellValue();
		return data;
		
		
		
	}
		
	
	}



