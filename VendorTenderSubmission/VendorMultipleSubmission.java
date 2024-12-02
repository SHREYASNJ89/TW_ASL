package VendorTenderSubmission;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import TenderCreation.BasePage;
import generic.Auto_const; 

public class VendorMultipleSubmission extends BasePage implements Auto_const
{
	static By Resubmission_Technical_Bid=By.xpath("(//a[@class='upload'])[2]"); 
	static By Resubmission_Cost_Bid=By.xpath("(//a[@class='upload'])[3]");
	static By Acknowledgement=By.xpath("//html//body//div[1]//div//table//tbody//tr[2]//th//u");
	static By Acknowledgement_Ok=By.xpath("//input[@name='btnSubmit']"); 
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
		protected static SoftAssert as;
		static By Edit_Attachment=By.xpath("//img[@alt='EDIT ATTACHMENTS-Level-1']");
		static By Right_Frame=By.xpath("//frame[@name='right']");	 

		
private static Logger log = Logger.getLogger(VendorMultipleSubmission.class);
	
	public VendorMultipleSubmission(WebDriver driver)
	{
		super(driver);  
	} 
	public  void Multiple_Submission_Technical(SoftAssert sa) throws Exception  
	{
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		WebElement ele = driver.findElement(Right_Frame);   
		driver.switchTo().frame(ele);
		 Thread.sleep(2000); 
	 WebElement Edit = driver.findElement(Edit_Attachment);
	 Edit.click();
	 Thread.sleep(3000); 
	 Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(ele);
		 Thread.sleep(2000);	 
	 String path1=new java.io.File(".").getCanonicalPath();
     Thread.sleep(4000);
     waitForElementToAppear(biddocuments);
     WebElement bd=driver.findElement(biddocuments);
     javaScriptClick(bd); 
	 Thread.sleep(2000);	 
     //**************technical doc upload*********** 
     waitForElementToAppear(Resubmission_Technical_Bid);
      WebElement cli=driver.findElement(Resubmission_Technical_Bid);
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
                          driver.switchTo().defaultContent();
                          waitForElementToAppear(By.xpath("//frame[@name='right']"));
                          WebElement ele5 = driver.findElement(By.xpath("//frame[@name='right']"));
                          driver.switchTo().frame(ele5);
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
                   } 
               
               //Code to scroll down
               JavascriptExecutor js = (JavascriptExecutor) driver;
       		js.executeScript("window.scrollBy(0,3000)", "");  
       		log.info("Scrolling of Page Successful");
               
            WebElement Ack = driver.findElement(Acknowledgement_Ok); 
           if(Ack.isDisplayed())
           {
        	   Ack.click();
       		log.info("Technical Bid Resubmission Successful"); 
           }
           else
           {
    	   		sa.fail("Technical Bid Resubmission Unsuccessful");
           }
	}
	
	public  void Multiple_Submission_Cost(SoftAssert sa) throws Exception  
	{ 
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		WebElement ele = driver.findElement(Right_Frame);   
		driver.switchTo().frame(ele);
		 Thread.sleep(2000); 
	 WebElement Edit = driver.findElement(Edit_Attachment);
	 Edit.click();
	 Thread.sleep(3000); 
	 Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(ele);
		 Thread.sleep(2000);
	 String path1=new java.io.File(".").getCanonicalPath();
     Thread.sleep(4000);
     waitForElementToAppear(biddocuments);
     WebElement bd=driver.findElement(biddocuments);
     javaScriptClick(bd); 
	 Thread.sleep(2000);	 
     //**************cost doc upload*********** 
     waitForElementToAppear(Resubmission_Cost_Bid);
      WebElement cli=driver.findElement(Resubmission_Cost_Bid);
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
                          Runtime.getRuntime().exec(SignAndUploadA+" "+path1+"\\src\\test\\resources\\AutoitScripts\\VendorDocUpload\\costsheet.xls");
                          Thread.sleep(48000);
                          driver.switchTo().defaultContent();
                          waitForElementToAppear(By.xpath("//frame[@name='right']"));
                          WebElement ele5 = driver.findElement(By.xpath("//frame[@name='right']"));
                          driver.switchTo().frame(ele5);
             }       
             else{
            	
                 waitForElementToAppear(By.xpath("//a[@id='a_button']"));
       		   		WebElement ek=driver.findElement(upbtn);
                     Actions act=new Actions(driver); 
                     act.moveToElement(ek).click().build().perform();
                     Thread.sleep(4000);
                     Runtime.getRuntime().exec(NormalUploadA+" "+path1+"\\src\\test\\resources\\AutoitScripts\\VendorDocUpload\\costsheet.xls");
                     Thread.sleep(18000);
                     waitForElementToAppear(uploadfile);
                     driver.findElement(uploadfile).click();
                   } 
               
               //Code to scroll down
               JavascriptExecutor js = (JavascriptExecutor) driver;
       		js.executeScript("window.scrollBy(0,3000)", "");  
       		log.info("Scrolling of Page Successful");
               
            WebElement Ack = driver.findElement(Acknowledgement_Ok); 
           if(Ack.isDisplayed())
           {
        	   Ack.click();
       		log.info("Cost Bid Resubmission Successful"); 
           }
           else
           {
    	   		sa.fail("Cost Bid Resubmission Unsuccessful");
           }
	} 
}
