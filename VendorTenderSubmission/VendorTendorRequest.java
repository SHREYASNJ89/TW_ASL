package VendorTenderSubmission;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import TenderCreation.BasePage;

public class VendorTendorRequest extends BasePage{
       
       
      static  By tendor_request=By.xpath("//img[@alt='REQUEST TENDER FORM-Level-1' or @alt='REQUEST TENDER DOC-Level-1']");
      static  By Attach=By.xpath("//a[text()='Attach']");
       static By proceed=By.xpath("//input[@value='Proceed']");
     static  	By editattachment=By.xpath("//img[@alt='EDIT ATTACHMENTS-Level-1']");
		
       
       public VendorTendorRequest(WebDriver driver)
       {
              super(driver);
       }

       public  void vendortenderreuest(String TN,String tenderflow) throws InterruptedException
       {
    	   
    	   if(!tenderflow.contains("LimitedTender"))
    	   {
    	   Thread.sleep(4000);
              driver.switchTo().defaultContent();
              WebElement ele = driver.findElement(By.xpath("//frame[@name='right']"));
              driver.switchTo().frame(ele);
           
              for(int i=0;i<20;i++)
              {
            	  Thread.sleep(2000); 
              if(!driver.findElements(tendor_request).isEmpty())
              {
              driver.findElement(tendor_request).click();
              Thread.sleep(3000);
              
             
              break;
              }
       
              
              else
              {
                    
                     {      
                           Thread.sleep(10000);
                           VendorTenderSearch v1=new VendorTenderSearch(driver);
                           v1.vendortendorsearch(TN);
                           
                     }
                     
              
                   
              }
              Thread.sleep(3000);
              }
              

              
         /*     try{
              Alert al=driver.switchTo().alert();
              al.accept();
              Thread.sleep(5000);
              }
              catch(Exception e)
              
              {
                     e.printStackTrace();
              }
              //driver.findElement(Attach).click();
//driver.findElement(proceed).click();
              Thread.sleep(3000);*/
              
                           
              
       }
       }
}
