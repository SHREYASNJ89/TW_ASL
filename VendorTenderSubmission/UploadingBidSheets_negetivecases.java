package VendorTenderSubmission;


import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import Listeners.CheckPageReady;
import TenderCreation.BasePage;
import generic.Auto_const;
import junit.framework.Assert;

public class UploadingBidSheets_negetivecases extends BasePage implements Auto_const{
	
	
	static By biddocuments=By.xpath("//a[@title='Bid Documents']");
	static By mandatorydoc=By.xpath("//a[contains(text(),'Mandatory Documents')]");
	static By download=By.xpath("//a[contains(@onclick,'adDownload') and(text()='Download')]");
	static By fileid_c=By.xpath("//td[contains(text(),'costshee')]");
	static By fileid_t=By.xpath("//td[contains(text(),'technical')]");
	static By bid_down1=By.xpath("//*[@id='xtr3_xtd2']/td[3]/ul/li[2]/a");
	static By bid_down2=By.xpath("//*[@id='xtr3_xtd3']/td[3]/ul/li[2]/a");
	static By tech_upload=By.xpath("//a[contains(@onclick,'technicalsheet.xls') and contains(@onclick,'adUpload')]");
	static By clickheretodigitallysign=By.xpath("//input[@id='signUpload']");
	static By upbtn= By.xpath("//a[@id='a_button']");
	static By uploadfile=By.xpath("//input[@value='Upload File']");
	static By submitTenderForm=By.xpath("//input[@name='submit1']");
	
	private static Logger log = Logger.getLogger(UploadingBidSheets_negetivecases.class);

	public UploadingBidSheets_negetivecases(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void testByuploading_nonupdatedDoc() throws Exception
	{
		
		String path1=new java.io.File(".").getCanonicalPath();
        Thread.sleep(4000);
        waitForElementToAppear(biddocuments);
        log.info("bid document tab is present");
        WebElement bd=driver.findElement(biddocuments);
        javaScriptClick(bd);
        log.info("bid document tab was clickable");
        
         //**************technical doc upload*********** 
          waitForElementToAppear(tech_upload);
          log.info("technical sheet upload link is present");
           WebElement cli=driver.findElement(tech_upload);
              javaScriptClick(cli);
              log.info("technical document upload in progress ");
              try{
            	  waitForAlertToAppear();
            	  log.info("alert is present");
                  Alert a1=driver.switchTo().alert();
                  log.info("switched to alert");
                  a1.accept();
                  log.info("alert accepted");
                  }
              catch(Exception e)
                 {
                  	e.printStackTrace();
                 }
                 
                   Thread.sleep(4000); 
                   String Errormsg;
                    if(!driver.findElements(clickheretodigitallysign).isEmpty())
                          {
                    	 log.info("Sign and upload document is in progress");
                               driver.findElement(clickheretodigitallysign).click();
                               log.info("clich here to digitally sign button was clickable");
                               Thread.sleep(3000);
                               log.info("AutoIT script is preogress");
                               Runtime.getRuntime().exec(SignAndUploadA+" "+path1+"\\src\\test\\resources\\AutoitScripts\\VendorDocUpload\\technicalsheet.xls");
                               Thread.sleep(48000);
                               log.info("AutiIT script completed");
                              
                                 }
                    
                else{
                 		waitForElementToAppear(By.xpath("//a[@id='a_button']"));
            		   	WebElement ek=driver.findElement(upbtn);
            		   	log.info("browse button is present");
                        Actions act=new Actions(driver);
                        act.moveToElement(ek).click().build().perform();
                        log.info("browse button is clickable");
                        Thread.sleep(4000);
                        log.info("AUTOIT script is in progress");
                        Runtime.getRuntime().exec(NormalUploadA+" "+path1+"\\src\\test\\resources\\AutoitScripts\\VendorDocUpload\\technicalsheet.xls");
                        Thread.sleep(18000);
                        log.info("AutoIT script executin completed");
                        waitForElementToAppear(uploadfile);
                        log.info("Upload button is present");
                        driver.findElement(uploadfile).click();
                        log.info("upload button is clickable");
                        
                        
                               
                         
              }
	
	}
	
	public String verify_alertPresent()
	{
		boolean aler=false;
		String msg=null;
		try{
			waitForAlertToAppear();
			Alert a=driver.switchTo().alert();
			 log.info("switched to alert");
			aler=true;
			log.info("Alert is present");
			msg=a.getText();
			log.info("alert text captured ");
			a.accept();
			log.info("alert accepted");
		}
		catch(Exception e)
		{
			log.info("No alert displayed");
			e.printStackTrace();
		}
		return msg;
	}
	public String verify_errorMessage(String type_file,SoftAssert sa) throws Exception
	{
		log.info("very alert message called");
		String Errormsg=verify_alertPresent();
		
		if(Errormsg!=null)
		{
		 switch (type_file)
         {
         case "protectedBlanksheet" :{
         
         if(Errormsg.contentEquals("Bid uploaded is not updated."))
         {
       	  log.info(Errormsg);
       	  log.info("Errormsg displayed when uploaded the non updated protected sheet is correct");
         }
         else{
       	  log.info("EXPECTED "+"Bid uploaded is not updated."+"  ACTUAL IS "+Errormsg);
        	  sa.fail("Validation when we Upload protected sheet with out updating is not correct.");
         }
         
         break;
         }
         case "Blanksheet_withSameName" :{
       	  if(Errormsg.contentEquals("Bid uploaded by Department is altered."))
             {
           	  log.info(Errormsg);
           	  log.info("Errormsg displayed when uploaded 'blank document with same name' is correct");
             }
             else{
           	  log.info("EXPECTED "+"Bid uploaded by Department is altered."+"  ACTUAL IS "+Errormsg);
           	  sa.fail("Validation when uploaded 'blank document with same name' is not correct.");
           	  
             }
            
         
       	break;  
         }
          default: {
       	   log.info("default case executed");
       	   break;
         }
         }
          Thread.sleep(2000);
          driver.switchTo().defaultContent();
          driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='right']")));
          Thread.sleep(2000);
          driver.findElement(By.xpath("//input[@name='submit2']")).click();
          log.info("Goo back button is clickable");
		}
		else{
			log.info("No error message captured and string contains "+Errormsg);
			Assert.fail("No alert  / error message displayed");
			
		}
		return Errormsg;
	}
	public void docDownload() throws Exception
	{
	  	CheckPageReady check=new CheckPageReady(driver);  
	   	check.checkPageIsReady();
	       
	                       
	                           //*********BidDocuments download***********
	                           
	                           if(!driver.findElements(biddocuments).isEmpty())
	                           {
	                                  WebElement bd=driver.findElement(biddocuments);
	                                  javaScriptClick(bd);
	                                  log.info("entered Biddocuments  section");
	                                  String costsheet=driver.findElement(fileid_c).getAttribute("textContent");
	                                   String technicalsheet=driver.findElement(fileid_t).getAttribute("textContent");
	                                
	                                 
	                           
	                   //technical sheet download
	                                  if(!driver.findElements(bid_down1).isEmpty());
	                     
	                               {
	                            	   log.info("dowloading technical sheet document");
	                            	   waitForElementToAppear(bid_down1);
	                                      WebElement ko=   driver.findElement(bid_down1);
	                                      javaScriptClick(ko);
	                                       
	                                       Thread.sleep(5000);
	                                       log.info("dowloaded technical sheet document");
	                                       CheckTenderSubmited.copyFile(source+"technicalsheet.xls", destination);
	                                       log.info("technical sheet document copied to destination folder");        
	                               }
	                               
	                     //cost sheet download
	                                  if(!driver.findElements(bid_down2).isEmpty());
	                                  {
	                                	  log.info("dowloading cost sheet document");
	                                           WebElement ko=driver.findElement(bid_down2);
	                                           ko.click();
	                                           Thread.sleep(5000);
	                                           log.info("dowloaded cost sheet document");
	                                           CheckTenderSubmited. copyFile(source+"costsheet.xls", destination);
	                                           log.info("cost sheet document copied to destination folder");
	                                  }
	                                         
	                           }
	                           
	                           }
	
	
	public String submitTender_withoutuploadingBidsheets(SoftAssert sa)
	{
		waitForElementToAppear(submitTenderForm);
		log.info("'Submit the tender form' button is present");
		driver.findElement(submitTenderForm).click();
		log.info("'Submit the Tender Form' button is clickable");
		waitForAlertToAppear();
		log.info("Alert dispalyed");
		Alert al=driver.switchTo().alert();
		log.info("control switched to alert");
		String tx;
		log.info("text fetched from alert");
		if(al.getText().contentEquals("Kindly work on all highlighted documents/links to submit the tender form."))
		{
			tx=al.getText();
			al.accept();
			log.info("the expected error message is displayed on click of 'submit tender' without uploading any biddocuments");
			log.info("the error message present in the pop up is "+tx);
		}
		else{
			tx=al.getText();
			al.accept();
			sa.fail("on click of 'submit tender' there is no valid error message displayed");
			sa.fail("the actual message displayed is "+tx);
		}
		return tx;
	}
	
	
	
}
