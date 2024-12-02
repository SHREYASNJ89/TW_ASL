package VendorTenderSubmission;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Listeners.CheckPageReady;
import TenderCreation.BasePage;
import generic.Auto_const;




public class CheckTenderSubmited extends BasePage implements Auto_const{

	

	static By PaymentDrop=By.xpath("//select[@id='transType']");
	static    By Mode=By.xpath("//select[@id='mode']");
	
	
	//DD payment Fields
	static By Number= By.xpath("//input[@id='sInstrumentNumber']");
	static By Date=By.xpath("//input[@id='sInstrumentDate']");
	static By Branch=By.xpath("//input[@id='sInstrumentBranch']");
	static By Remark=By.xpath("//textarea[@id='sInstrumentRemarks']");
	static By Update=By.xpath("//input[@value='Update']");
	
	//SinglePayment for Multilot
	//By Paynow=By.xpath("//input[@value='Pay Now']");
	static By Paynow=By.xpath("//a[contains(@id,'RequestId')]");
	static By CheckBOX=By.xpath("//input[@id='checkall']");
	static By userid= By.name("Department");
	static By submit =By.xpath("//input[contains(@value,'Submit')]");
	static By ok=By.xpath("//a[contains(text(),'OK')]");
	static By up_ok=By.xpath("//input[contains(@value,'Ok')]");
	              
	//tender search for inprogress request
	static By TendorSearch=By.xpath("//a[contains(text(), 'Tender Search')]");
	static By TenderNumber=By.xpath("//input[@name='tender']");
	static By Submit=By.xpath("//input[@id='submitId']");
	 
	
	//edit attachment
	static By editattachment=By.xpath("//img[@alt='EDIT ATTACHMENTS-Level-1']");
	static  By goback=By.xpath("//input[@value='Go Back']");
	       
	//Bid Documents
	       
	static By biddocuments=By.xpath("//a[@title='Bid Documents']");  
	static By tech_upload=By.xpath("//a[contains(@onclick,'technicalsheet.xls') and contains(@onclick,'adUpload')]");
	static By cost_upload=By.xpath("//a[contains(@onclick,'costsheet.xls') and contains(@onclick,'adUpload')]");
	static By Mand_upload=By.xpath("//a[contains(@onclick,'Mandatory.xls') and contains(@onclick,'adUpload')]");
	static By download=By.xpath("//a[contains(@onclick,'adDownload') and(text()='Download')]");
	static By Technical=By.xpath("//a[contains(@onclick,'technicalsheet00000012')]");
	static By digitalsignupload=By.xpath("//input[@value='Click here to digitally sign and upload']");
	//static By bid_down1=By.xpath("//*[@id='xtr3_xtd2']/td[3]/ul/li[2]/a");
	static By bid_down1=By.xpath("//td[text()='technicalsheet.xls']//ancestor::tr//a[text()='Download']");
	static By bid_down2=By.xpath("//td[text()='costsheet.xls']//ancestor::tr//a[text()='Download']"); 
	//static By bid_down2=By.xpath("//*[@id='xtr3_xtd3']/td[3]/ul/li[2]/a");
	static By gen_Attach=By.xpath("//a[contains(text(),'Attach') and contains(@href,'GENERAL_DOCUMENTS')]");
	static By finishselection=By.xpath("//input[@value='Finish Selection']");
	       
	//file ID
	       
	static By fileid_c=By.xpath("//td[contains(text(),'costshee')]");
	static By fileid_t=By.xpath("//td[contains(text(),'technical')]");
	       
	//upload file
	static By upbtn= By.xpath("//a[@id='a_button']");
	static By uploadfile=By.xpath("//input[@value='Upload File']");
	static By clickheretodigitallysign=By.xpath("//input[@id='signUpload']");

	//click on payment links
	static By paynoww= By.xpath("//a[text()='Update/Pay Now']");
	
	//Mandatory documents
	static By mandatorydoc=By.xpath("//a[contains(text(),'Mandatory Documents')]");
	static By eligibilitydoc =By.xpath("//a[contains(@title,'Eligibility Doc')]");
	static By update=By.xpath("//a[contains(@onclick,'Mandatory.xls') and(text()='Update')]");
/*
	//Payment uploads
	static String File="D:\\Automationworkspace\\Auctionwizard\\AutoitScripts\\Vendor\\File.exe";
	static String File1="D:\\Automationworkspace\\Auctionwizard\\AutoitScripts\\Vendor\\File1.exe";
	static String File2="D:\\Automationworkspace\\Auctionwizard\\AutoitScripts\\Vendor\\File2.exe";
	static String File3="D:\\Automationworkspace\\Auctionwizard\\AutoitScripts\\Vendor\\File3.exe";
	       
	//mandatory doc

	static String Mandatory_src="C:\\Users\\kavanamn\\Downloads\\Mandatory.xls";
	static String Mandatory_dest="D:\\Automationworkspace\\Auctionwizard\\AutoitScripts\\Vendor\\DownloadVendor\\";
	static String Mandatorydoc2="D:\\Automationworkspace\\Auctionwizard\\AutoitScripts\\Vendor\\Mandatory doc2.exe";
	static String signupload_mandatory="D:\\Automationworkspace\\Auctionwizard\\AutoitScripts\\Vendor\\signupload_mandatory.exe";


	// technicalsheet

	static String tech_src="C:\\Users\\kavanamn\\Downloads\\technicalsheet.xls";
	static String tech_dest="D:\\Automationworkspace\\Auctionwizard\\AutoitScripts\\Vendor\\DownloadVendor\\";
	static String signuploadtechsheet="D:\\Automationworkspace\\Auctionwizard\\AutoitScripts\\Vendor\\signuploadtechsheet.exe";
	static String Tenderupload_tech="D:\\Automationworkspace\\Auctionwizard\\AutoitScripts\\Vendor\\Tenderupload_tech.exe";


	// costsheet
	static String cost_src="C:\\Users\\kavanamn\\Downloads\\costsheet.xls";
	static String cost_dest="D:\\Automationworkspace\\Auctionwizard\\AutoitScripts\\Vendor\\DownloadVendor\\";
	static String signuploadcostsheet="D:\\Automationworkspace\\Auctionwizard\\AutoitScripts\\Vendor\\signuploadcostsheet.exe";
	static String TenderUpload="D:\\Automationworkspace\\Auctionwizard\\AutoitScripts\\Vendor\\TenderUpload.exe";
	
	
       */
	public CheckTenderSubmited(WebDriver driver)
	{
      super(driver);
	}
       
	
	
	
	
	
	
	
	public  void checktender(String ad,int j) throws Exception
	
	{
       
     
		
      

   	CheckPageReady check=new CheckPageReady(driver);  
   	check.checkPageIsReady();
       if(j==0)
       {
                     
              //*******Mandatory documents download************
                           
                           
              if(!driver.findElements(mandatorydoc).isEmpty())
              {
                     WebElement p2=driver.findElement(mandatorydoc);
                     javaScriptClick(p2);
                     WebElement p1=driver.findElement(download);
                     javaScriptClick(p1);
                     Thread.sleep(5000);
                     copyFile(source+"Mandatory.xls", destination);
                     Thread.sleep(3000);
              }
                           
                           
                           //*********BidDocuments download***********
                           
                           if(!driver.findElements(biddocuments).isEmpty())
                           {
                                  WebElement bd=driver.findElement(biddocuments);
                                  javaScriptClick(bd);
                           
                                  String costsheet=driver.findElement(fileid_c).getAttribute("textContent");
                                   String technicalsheet=driver.findElement(fileid_t).getAttribute("textContent");
                                
                                 
                           
                   //technical sheet download
                                  if(!driver.findElements(bid_down1).isEmpty());
                     
                               {
                            	   waitForElementToAppear(bid_down1);
                                      WebElement ko=   driver.findElement(bid_down1);
                                      javaScriptClick(ko);
                                       
                                       Thread.sleep(5000);
                                       copyFile(source+"technicalsheet.xls", destination);
                                               File file =    new File(destination+technicalsheet);
                                                FileInputStream fis = new FileInputStream(file);
                                                Workbook wb=WorkbookFactory.create(fis);
                                                Sheet sh= wb.getSheet("Sheet1");
                                                Cell cell=null;
                                                cell = sh.getRow(10).getCell(2);
                                                cell.setCellValue("pavana");
                                                fis.close();
                            FileOutputStream fos = new FileOutputStream(file);
                                                wb.write(fos);
                                                fos.close();
                                                System.out.println("END OF WRITING DATA IN EXCEL");
                                                Thread.sleep(3000);
                               }
                               
                               
                     //cost sheet download
                                  if(!driver.findElements(bid_down2).isEmpty());
                                  {
                                           WebElement ko=driver.findElement(bid_down2);
                                           ko.click();
                                           Thread.sleep(7000);
                                           copyFile(source+"costsheet.xls", destination);
                        
                                  File file =    new File(destination+costsheet);
                                           FileInputStream fis = new FileInputStream(file);
                                           Workbook wb=WorkbookFactory.create(fis);
                                           Sheet sh= wb.getSheet("Sheet1");
                                           Cell cell=null;
                                           cell = sh.getRow(6).getCell(3);
                                           cell.setCellValue("kavana");
                                           fis.close();
                          FileOutputStream fos = new FileOutputStream(file);
                                           wb.write(fos);
                                           fos.close();
                                           System.out.println("END OF WRITING DATA IN EXCEL");
                                  }
                                         
                           }
                           
                           
              
       }
                           
	}             
                           
            
	
	
	
                           
       public   void BiddocUpload(String ad,int j) throws Exception
   	{
    	   String path1=new java.io.File(".").getCanonicalPath();
          Thread.sleep(4000);
          waitForElementToAppear(biddocuments);
          WebElement bd=driver.findElement(biddocuments);
          javaScriptClick(bd); 
          //**************technical doc upload*********** 
          waitForElementToAppear(tech_upload);
           WebElement cli=driver.findElement(tech_upload);
              javaScriptClick(cli);
              try{
            	  waitForAlertToAppear();
                  Alert a1=driver.switchTo().alert();
                  a1.accept();
                  }
              catch(Exception e)
                 {
                  	e.printStackTrace();
                 }
                 
                   Thread.sleep(4000);               
                    if(!driver.findElements(clickheretodigitallysign).isEmpty())
                          {
                               driver.findElement(clickheretodigitallysign).click();
                               Thread.sleep(3000);
                               Runtime.getRuntime().exec(SignAndUploadA+" "+path1+"\\src\\test\\resources\\AutoitScripts\\VendorDocUpload\\technicalsheet.xls");
                               Thread.sleep(48000);
                                  
                                  
                                  
                               /*   //*****to check by uploading the document without altering********
                           
                                  Alert a=driver.switchTo().alert();
                                  a.accept();
                                  driver.findElement(goback).click();
                                  Thread.sleep(4000);
                                  WebElement cl=driver.findElement(tech_upload);
                                   ((JavascriptExecutor) driver).executeScript("arguments[0].click();", cl);
                                  Thread.sleep(3000);
                                  try{
                                  Alert a1=driver.switchTo().alert();
                                  a1.accept();
                                  }
                                  catch(Exception e)
                                  {
                                         e.printStackTrace();
                                  }
                                  
                                  
                                  Thread.sleep(5000);
                                  
                                  driver.findElement(clickheretodigitallysign).click();
                                  Thread.sleep(3000);
                               Runtime.getRuntime().exec("D:\\signuploadtechsheet.exe");
                                  Thread.sleep(48000);
                                  
                                  
                              */    
                                  
                                  driver.switchTo().defaultContent();
                                  waitForElementToAppear(By.xpath("//frame[@name='right']"));
                                  WebElement ele5 = driver.findElement(By.xpath("//frame[@name='right']"));
                                  driver.switchTo().frame(ele5);
                                  waitForElementToAppear(bid_down2); 
                     
                     
                     }
                     
                     
                     
                     else{
                    	
                         waitForElementToAppear(By.xpath("//a[@id='a_button']"));
               		   		WebElement ek=driver.findElement(upbtn);
                             Actions act=new Actions(driver);
                             act.moveToElement(ek).click().build().perform();
                             Thread.sleep(4000);
                            Runtime.getRuntime().exec(NormalUploadA+" "+path1+"\\src\\test\\resources\\AutoitScripts\\VendorDocUpload\\technicalsheet.xls");
                             Thread.sleep(18000);
                             waitForElementToAppear(uploadfile);
                             driver.findElement(uploadfile).click();
                             waitForElementToAppear(bid_down2); 
                           }
             		    
             
        //************Cost sheet doc upload********     
             		   	 
                           if(!driver.findElements(bid_down2).isEmpty());
                     
                           {
                        	   waitForElementToAppear(cost_upload);
                  		   		WebElement cli1= driver.findElement(cost_upload);
                  		   		javaScriptClick(cli1);
                  		   		try{
                                  Alert a1=driver.switchTo().alert();
                                  a1.accept();
                                  }
                                  catch(Exception e)
                                  {
                                         e.printStackTrace();
                                  }
                          	
                        		
                                  Thread.sleep(3000);
                                         
                                  
                                  if(!driver.findElements(clickheretodigitallysign).isEmpty())
                                  {
                                         driver.findElement(clickheretodigitallysign).click();
                                         Thread.sleep(3000);
                                         Runtime.getRuntime().exec(SignAndUploadA+" "+path1+"\\src\\test\\resources\\AutoitScripts\\VendorDocUpload\\costsheet.xls");
                                         Thread.sleep(28000);
                                         try{
                                        	 waitForAlertToAppear();
                                             Alert all=driver.switchTo().alert();
                                             all.accept();
                                      }
                                      catch(Exception e)
                                      {
                                             e.printStackTrace();
                                      }
                                         
                                         
                                         driver.switchTo().defaultContent();
                                         waitForElementToAppear(By.xpath("//frame[@name='right']"));
                                         WebElement ele5 = driver.findElement(By.xpath("//frame[@name='right']"));
                                         driver.switchTo().frame(ele5);
                                         Thread.sleep(10000);
                                                
                                         
                                  }
                                  
                                  
                     else
                     {
                    	
                           if(!driver.findElements(upbtn).isEmpty())
                           {
                                  WebElement ek=driver.findElement(upbtn);
                               Actions act=new Actions(driver);
                               act.moveToElement(ek).click().build().perform();
                               Thread.sleep(4000);
                               Runtime.getRuntime().exec(NormalUploadA+" "+path1+"\\src\\test\\resources\\AutoitScripts\\VendorDocUpload\\costsheet.xls");
                               Thread.sleep(18000);
                               driver.findElement(uploadfile).click();
                               Thread.sleep(2000);
                             
                           
                           }
                           
                     }      
                                  
                                  
                                  
     
              try{
            	  waitForAlertToAppear();
                       Alert al=driver.switchTo().alert();
                       al.accept();
                  }
                                  catch(Exception e)
                                  {
                                         e.printStackTrace();
                                  }
                                  

              
                           }
              

                     
   	}
                     
    
       
       
     
      
    		 
       
       
       
       
       
   
   public void generaldocAttach() throws Exception
   {         
   //************General doc attach*********
	 //  driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
	 Thread.sleep(4000);
	 
         if(!driver.findElements(gen_Attach).isEmpty())
         {
         	driver.findElement(gen_Attach).click();
         	waitForElementToAppear(By.xpath("//input[@type='checkbox' and @value='1']"));
         	driver.findElement(By.xpath("//input[@type='checkbox' and @value='1']")).click();
         	waitForElementToAppear(finishselection);
         	driver.findElement(finishselection).click();
         	waitForElementToAppear(By.xpath("//input[@value='Attach']"));
         	driver.findElement(By.xpath("//input[@value='Attach']")).click();
         	
         	
         	
         			
         				
      }

                     

               Thread.sleep(2000);      
                    
                     
               
   }    
               
               
               
   
   
   
   
   
   
               
               

                     
                     
   public void MandatorydocUpload(String ad,int j) throws Exception
   {         
	    
	   String path1=new java.io.File(".").getCanonicalPath();
	       CheckPageReady check=new CheckPageReady(driver); 
  //***************Mandatory doc upload**********
	       check.checkPageIsReady();
           waitForElementToAppear(mandatorydoc);
                     WebElement p2=driver.findElement(mandatorydoc);
                     javaScriptClick(p2);
                    
       		   		waitForElementToAppear(By.xpath("//a[contains(@onclick,'Mandatory.xls') and contains(@onclick,'adUpload')]"));
       		   		driver.findElement(Mand_upload).click();
                     
       		   		check.checkPageIsReady();
                                  Thread.sleep(2000);
                                 
                                  
                                  
                                  
                                  if(!driver.findElements(clickheretodigitallysign).isEmpty())
                                  {
                                	  driver.findElement(clickheretodigitallysign).click();
                                      Thread.sleep(3000);
                                      Runtime.getRuntime().exec(SignAndUploadA+" "+path1+"\\src\\test\\resources\\AutoitScripts\\VendorDocUpload\\Mandatory.xls");
                                      Thread.sleep(27000);
                                      
                                      
                                	  
                                  }
                                  
                                 
                                  
                                  
                                  else
                                  {
                                	 Thread.sleep(2000);
                                	  WebElement ek=driver.findElement(upbtn);
                                      Actions act=new Actions(driver);
                                      act.moveToElement(ek).click().build().perform();
                                      Thread.sleep(4000);
                                      Runtime.getRuntime().exec(NormalUploadA+" "+path1+"\\src\\test\\resources\\AutoitScripts\\VendorDocUpload\\Mandatory.xls");
                                      Thread.sleep(18000);
                                      driver.switchTo().defaultContent();
                                      WebElement ele5 = driver.findElement(By.xpath("//frame[@name='right']"));
                                       driver.switchTo().frame(ele5);
                                      driver.findElement(uploadfile).click();
                                     Thread.sleep(5000);
                               
                                  }
                try{
                	
                	 
                    Alert fin=driver.switchTo().alert();
                     Thread.sleep(2000);
                     fin.accept();
                    	 }
                     catch(Exception e)
                     {
                           e.printStackTrace();
                     }
                 
                
                try{
                	
                	Alert fin=driver.switchTo().alert();
                    Thread.sleep(2000);
                    fin.accept();
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
                Thread.sleep(3000);
                 waitForElementToAppear(By.xpath("//input[@value='Submit The Tender Form']"));
                   WebElement dt=   driver.findElement(By.xpath("//input[@value='Submit The Tender Form']"));
              javaScriptClick(dt);
                   for(int i=0;i<2;i++){
                      try{
                    	  waitForAlertToAppear();
                    	  Alert at=   driver.switchTo().alert();
                    	  at.accept();
                      }
                      catch(Exception e)
                      {
                    	  e.printStackTrace();
                      }
               }
                      waitForElementToAppear(By.xpath("//input[@value='accepted']"));
                      driver.findElement(By.xpath("//input[@value='accepted']")).click();
                      waitForElementToAppear(By.xpath("//input[@value='Submit']"));
                    WebElement ed=  driver.findElement(By.xpath("//input[@value='Submit']"));
                    javaScriptClick(ed);
                    waitForAlertToAppear();
                    Alert at=   driver.switchTo().alert();
                    at.accept();
                    JavascriptExecutor js = (JavascriptExecutor) driver;
                    js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
                    
                   
                    waitForElementToAppear(By.name("btnSubmit"));
       		   		
                    driver.findElement(By.name("btnSubmit")).click();       
                    Thread.sleep(3000);
                    
                    
                  /*  
                    //******update the document after tender submission*******
                    
                    if(j==0)
                    {
                    
                    if(!driver.findElements(update).isEmpty())
                    {
                    WebElement up=driver.findElement(update);
                    up.click();
                    Thread.sleep(6000);
                    
                    
                    
                    if(!driver.findElements(clickheretodigitallysign).isEmpty());
                    {
                           driver.findElement(clickheretodigitallysign).click();
                           Thread.sleep(3000);
                           Runtime.getRuntime().exec(signupload_mandatory);
                           Thread.sleep(37000);
                           
                           Thread.sleep(10000);
                           
                    }
                                        
                     
                    
                    
                    
                  
                    else
                    {
                    	if(!driver.findElements(upbtn).isEmpty())
                        {
                        
                        WebElement ek=driver.findElement(upbtn);
                        Actions act=new Actions(driver);
                        act.moveToElement(ek).click().build().perform();
                        Thread.sleep(4000);
                        Runtime.getRuntime().exec(Mandatorydoc2);
                        Thread.sleep(18000);
                        driver.findElement(uploadfile).click();
                        Thread.sleep(9000);
                 
                        Thread.sleep(3000);
                        }
                    }
                          Thread.sleep(4000);
                           
                           WebElement d1=driver.findElement(up_ok);
                           ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", d1);
                           d1.click();
                    }
                    
                    
*/                    }  
                    
           









public static void copyFile(String src, String tar) throws IOException
{
          String source = src;
          String target=tar;
          
          System.out.println("source is"+ source);
          System.out.println("target is"+ target);
          File sourceFile = new File(source);
          String name = sourceFile.getName();
          File targetFile = new File(target+name);
          
          

          FileHandler.copy(sourceFile,targetFile);
          
          System.out.println("copied successfully");
         
       }



}

