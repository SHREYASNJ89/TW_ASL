package Listeners;

import java.io.File;

import org.openqa.selenium.WebDriver;

import generic.Auto_const;

public class Deletingfile implements Auto_const{
       
    
       
       public  static void  deletingfile()
       {
              File file= new File(source+"technicalsheet.xls");
              File file1=new File(destination+"technicalsheet.xls");
              
              
              File file2= new File(source+"costsheet.xls");
            File file3 =    new File(destination+"costsheet.xls");
            
            File file4=new File(source+"Mandatory.xls");
                     File file5=new File(destination+"Mandatory.xls");
                     
                     File file6=new File(destination+"Eligibility.xls");
                           File file7=new File(source+"Eligibility.xls");    
                        
                           
                           File file8=new File(destination+"auctionexceldoc.xls");
                           File file9=new File(source+"auctionexceldoc.xls");    
                        
                           
                           file1.delete();
                           file3.delete();
                           file4.delete();
                           file6.delete();
                           file2.delete();
                           file.delete();
                           file5.delete();
                           file7.delete();
                           file8.delete();
                           file9.delete();
                           
       }

}


