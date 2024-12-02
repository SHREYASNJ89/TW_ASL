package Listeners;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;

public class Tendernumber {
	
	public  ArrayList<String> fetch(String details) throws Exception
	
	{
		ArrayList<String> a1= new ArrayList<String>();
		File file =    new File("./src/test/resources/TenderNumber/tendernum.xlsx");
        FileInputStream fis = new FileInputStream(file);
        Workbook wb=WorkbookFactory.create(fis);
        Sheet sh= wb.getSheet("Sheet1");
        
        switch(details){
        case "TenderNumber":{
        	Row r= sh.getRow(1);
             					Cell c=r.getCell(1);
             					String tender = c.getStringCellValue();	
             					a1.add(tender);
             					break;
        					}
        case "TenderNumber_Line1":{
        	Row r= sh.getRow(1);
        	Row r1= sh.getRow(3);
        						Cell c=r.getCell(1);
        						Cell c1=r1.getCell(1);
        						String tender = c.getStringCellValue();	
        						String line1=c1.getStringCellValue();
        						a1.add(tender);
        						a1.add(line1);
        						break;
        						}
        case "TenderNumber_Line1_Line2":{  
        	Row r= sh.getRow(1);
        	Row r1= sh.getRow(3);
        	Row r2= sh.getRow(5);
        	Cell c=r.getCell(1);
			Cell c1=r1.getCell(1);
			Cell c2=r2.getCell(1);
			String tender = c.getStringCellValue();	
			String line1=c1.getStringCellValue();
			String line2=c2.getStringCellValue();
			a1.add(tender);
			a1.add(line1);
			a1.add(line2);
			break;
        	}
        
        default:{
        	break;
        }
        
        }
        fis.close();	
       return a1;
    
	}
	
	public void Write_TendernumberAndLine(String num,String line1,String line2) throws Exception
	{
		
		
		//*******Writing Auction number into a excel file********
		  

	    File file =    new File(".\\src\\test\\resources\\TenderNumber\\tendernum.xlsx");
        FileInputStream fis = new FileInputStream(file);
        Workbook wb=WorkbookFactory.create(fis);
        Sheet sh= wb.getSheet("Sheet1");
        //writing tender number
        Row rw=   sh.createRow(1);
        Cell c=rw.createCell(1);
        c.setCellValue(num);
        //writing line1
        Row rw1=   sh.createRow(3);
        Cell cl1=rw1.createCell(1);
        cl1.setCellValue(line1);
        //writing line2
        Row rw2=   sh.createRow(5);
        Cell cl2=rw2.createCell(1);
        cl2.setCellValue(line2);
        
        fis.close();
        FileOutputStream fos = new FileOutputStream(file);
        wb.write(fos);
        fos.close();
        System.out.println("END OF WRITING TENDER Number IN EXCEL"); 
         
         
	}
	
	
public static String fetch_tendernum() throws Exception
	
	{
		File file =    new File("./src/test/resources/TenderNumber/tendernum.xlsx");
        FileInputStream fis = new FileInputStream(file);
        Workbook wb=WorkbookFactory.create(fis);
        Sheet sh= wb.getSheet("Sheet1");
     //   Cell cell=null;
       Row r= sh.getRow(1);
       Cell c=r.getCell(1);
       String tender = c.getStringCellValue();
       System.out.println(tender);
       fis.close();
		return tender;
		
		
		
	}


}
