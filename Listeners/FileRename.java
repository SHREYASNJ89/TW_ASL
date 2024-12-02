package Listeners;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import generic.Auto_const;

public class FileRename implements Auto_const{
public WebDriver driver;
	
	public FileRename(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void fileRename(String nam,String filename) throws Exception
	{
		
		//copying file to different location
		
		String source = "./Bids/"+filename;
       String target=destination;
        File sourceFile = new File(source);
        String name = sourceFile.getName();
        File targetFile = new File(target+name);
        
        

        FileHandler.copy(sourceFile,targetFile);
        
        System.out.println("copied successfully");
		
        
        
        
        
        File oldName = 
                new File(destination+filename); 
             File newName =  
                       new File(destination+nam); 
                
               
               
               if (oldName.renameTo(newName))  {
                   System.out.println("Renamed successfully");  }       
               else {
                   System.out.println("Error");}
	}
	
	
	
	
	
}
