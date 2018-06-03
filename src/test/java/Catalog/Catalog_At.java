package Catalog;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.*;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.*;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class Catalog_At 
{
   static XSSFRow row;
   public static void main(String[] args) throws Exception 
   {
	   try {
      String fileName = "D:\\targetr.xlsx";
      String fileName2 = "D:\\catalog1.xlsx";

      InputStream input = new FileInputStream(fileName);
      InputStream input2 = new FileInputStream(fileName2);

      XSSFWorkbook wb1 = new XSSFWorkbook(input);
      XSSFSheet sheet = wb1.getSheetAt(0);
      
      XSSFWorkbook wb2 = new XSSFWorkbook(input2);
      XSSFSheet sheet2 = wb2.getSheetAt(0);
      
     int innrowcount = sheet.getPhysicalNumberOfRows();
     int outrowcount = sheet2.getPhysicalNumberOfRows();
     
     HashMap<String, Integer> inputmp = new HashMap<String,Integer>();
     System.out.println("count : "+innrowcount);
     System.out.println("count : "+outrowcount);
     for(int i=1;i<innrowcount;i++) {
    	 inputmp.put(sheet.getRow(i).getCell(0).getStringCellValue(),i);
     }
     
     System.out.println("existing map :"+inputmp.toString());
     //outrowcount menas new catalog file
     for(int j=1;j<outrowcount;j++) {
    	 if(inputmp.containsKey(sheet2.getRow(j).getCell(0).getStringCellValue())) {
    		 //Code to update the existing row in target file as it it updated in new catalog file
    		 System.out.println("key :"+sheet2.getRow(j).getCell(0).getStringCellValue());
    		 int inputrowVlue = inputmp.get(sheet2.getRow(j).getCell(0).getStringCellValue());
    		 String col2value = sheet2.getRow(j).getCell(1).getStringCellValue();
    		 String col3value = sheet2.getRow(j).getCell(2).getStringCellValue();
    		 //column for loop
    		 sheet.getRow(inputrowVlue).getCell(1).setCellValue(col2value);
    		 sheet.getRow(inputrowVlue).getCell(2).setCellValue(col3value);
    	 }else {
    		 //Code to update target file when there is new entry in new catalog file
    		 System.out.println("need to update the excel with new line :"+sheet2.getRow(j).getCell(0).getStringCellValue());
    		 String inputrowVlue = sheet2.getRow(j).getCell(0).getStringCellValue();
    		 String col2value = sheet2.getRow(j).getCell(1).getStringCellValue();
    		 String col3value = sheet2.getRow(j).getCell(2).getStringCellValue();
    		 Row r = sheet.createRow(sheet.getPhysicalNumberOfRows());
    		 r.createCell(0).setCellValue(inputrowVlue);
    		 r.createCell(1).setCellValue(col2value);
    		 r.createCell(2).setCellValue(col3value);
   	 inputmp.put( sheet.getRow(j).getCell(0).getStringCellValue(),j);
    	 }
     }
     
     FileOutputStream out = new FileOutputStream(new File("D:\\targetr.xlsx"));
 		wb1.write(out);
 		out.close();
 		
 		FileOutputStream out2 = new FileOutputStream(new File("D:\\catalog1.xlsx"));
 	 		wb2.write(out2);
 	 		out2.close();

//      rownr = findRow(sheet, cellContent);
//      System.out.println("row number :"+ rownr);
      
     

//      Cell celltoUpdate = sheet.getRow(rownr).getCell(2);
//      System.out.println("before update :" + celltoUpdate.getStringCellValue());
//      celltoUpdate.setCellValue((String)"updated value");
//      System.out.println("after update :" + celltoUpdate.getStringCellValue());
//      while (rowIterator.hasNext()) {
//         row = (XSSFRow) rowIterator.next();
//         Iterator < Cell >  cellIterator = row.cellIterator();
//         
//         while ( cellIterator.hasNext()) {
//            Cell cell = cellIterator.next();
//            
//            switch (cell.getCellType()) {
//               case Cell.CELL_TYPE_NUMERIC:
//                  System.out.print(cell.getNumericCellValue() + " \t\t ");
//                  break;
//               
//               case Cell.CELL_TYPE_STRING:
//                  System.out.print(
//                  cell.getStringCellValue() + " \t\t ");
//                  
//                  break;
//            }
//         }
//         System.out.println();
//      }
//      fis.close();
      
//		FileOutputStream out = 
//			new FileOutputStream(new File("D:\\targetr.xlsx"));
//		wb.write(out);
//		out.close();
		
	} catch (FileNotFoundException e) 
	{
		e.printStackTrace();
	} catch (IOException e) 
	{
		e.printStackTrace();
   }
}
   
   private static int findRow(XSSFSheet sheet, String cellContent) {
	    for (Row row : sheet) {
	        for (Cell cell : row) {
	            if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
	                if (cell.getRichStringCellValue().getString().trim().equals(cellContent)) {
	                    return row.getRowNum();  
	                }
	            }
	        }
	    }               
	    return 0;
	}
}