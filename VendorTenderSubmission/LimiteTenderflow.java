package VendorTenderSubmission;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Listeners.CheckPageReady;
import Listeners.Utility;
import TenderCreation.BasePage;


public class LimiteTenderflow extends BasePage{
	
	 By editattachment=By.xpath("//img[@alt='EDIT ATTACHMENTS-Level-1']");
	 By unaplied_editattachment=By.xpath("//img[@alt='EDIT ATTACHMENTS:Level-1']");
	  By tendor_request=By.xpath("//img[@alt='REQUEST TENDER FORM-Level-1']");
	 By upbtn=	By.xpath("//a[@id='a_button']");
			By uploadfile=By.xpath("//input[@value='Upload File']");
		By download=By.xpath("//a[contains(@onclick,'adDownload') and(text()='Download')]");
		By eligibilitydoc =By.xpath("//a[contains(@title,'Request Documents/Payments')]");
		By clickheretodigitallysign=By.xpath("//input[@id='signUpload']");
			By Upload=By.xpath("//a[contains(@onclick,'adUpload')]");
			By completereq=By.xpath("//input[@onclick='completeRequest()']");
		By mandatorydoc=By.xpath("//a[contains(text(),'Mandatory Documents')]");
		//Eligibility doc upload  
		String eligiblitydoc_upload="D:\\Automationworkspace\\Auctionwizard\\AutoitScripts\\Vendor\\eligiblitydoc_upload.exe";
		 String	signupload_eligibilitydoc="D:\\Automationworkspace\\Auctionwizard\\AutoitScripts\\Vendor\\signupload_eligibilitydoc.exe";
		
     
public LimiteTenderflow(WebDriver driver)
     {
		super(driver);
     }
     
public void limitflow(String tn,String tenderflow,String ZeroPayment) throws Exception
{

	if(tenderflow.contains("LimitedTender"))
	{
		CheckPageReady check=new CheckPageReady(driver);
		check.checkPageIsReady();
		VendorTenderSearch vn=new VendorTenderSearch(driver);
		vn.vendortendorsearch(tn);
		
		Thread.sleep(2000);
		
		if(!driver.findElements(By.xpath("//a[text()='1']")).isEmpty())
		{
			for(int i=0;i<=25;i++)
			{
				VendorTenderSearch vn1=new VendorTenderSearch(driver);
				vn1.vendortendorsearch(tn);
				Thread.sleep(10000);
				try{
					driver.findElement(tendor_request).click();
					
					break;
					}
				catch(Exception e)
					{
						e.printStackTrace();
					}
			}
			
		Thread.sleep(5000);
			Alert a=driver.switchTo().alert();
			a.accept();
			
			try{
			driver.findElement(editattachment).click();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			check.checkPageIsReady();
			Thread.sleep(3000);
			if(!driver.findElements(eligibilitydoc).isEmpty())
         		{
         		driver.findElement(eligibilitydoc).click();
				Vendor_EligibilityDocUpload el=new Vendor_EligibilityDocUpload(driver);
         		el.eligibilityDocUpload();
         		 Thread.sleep(3000);
      		
             	if(!driver.findElements(By.xpath("//input[@value='Finish Upload']")).isEmpty())
             	{
             		driver.findElement(By.xpath("//input[@value='Finish Upload']")).click();
             		Thread.sleep(2000);
             		Alert at=driver.switchTo().alert();
             		Thread.sleep(3000);
             		at.accept();
             		Thread.sleep(2000);
             	}
         		
         		
         		Payments pay=new Payments(driver);
         		pay.paymentsection(ZeroPayment);
         		
         		
         		 Thread.sleep(10000);
         		 
       		  if(!driver.findElements(completereq).isEmpty())
       			{
       				boolean ds=driver.findElement(completereq).isEnabled();
       				System.out.println(ds);
       				if(!ds==false)
       				{
       					driver.findElement(completereq).click();
       					Thread.sleep(4000);
       					Alert ae=driver.switchTo().alert();
       					ae.accept();
       				}
       			}
       		  
       		  
       		  
       		 else{
       			 Thread.sleep(3000);
       			 if(driver.findElements(mandatorydoc).isEmpty())
                 {
       		 
       		  VendorTenderSearch vend=new VendorTenderSearch(driver);
       				vend.vendortendorsearch(tn);
       		  
       				Thread.sleep(4000);
                    driver.switchTo().defaultContent();
                    WebElement ele = driver.findElement(By.xpath("//frame[@name='right']"));
                    driver.switchTo().frame(ele);
                    Thread.sleep(2000);
                    
                    driver.findElement(tendor_request).click();
                    Thread.sleep(3000);
       		  
       		  Alert ar = driver.switchTo().alert();
       		  ar.accept();
       		  
       		  VendorInprogress vend1=new VendorInprogress(driver);
       		vend1.inprogress(tn);
       		  
       		driver.findElement(editattachment).click();
       		Thread.sleep(5000);
       		 }
       		 }
		}
		
		}
		
		
		
		
		
		else{
		
	VendorInprogress vend1=new VendorInprogress(driver);
	vend1.inprogress(tn);
	
	waitForElementToAppear(editattachment);
 		
	driver.findElement(editattachment).click();
	Thread.sleep(5000);
	
	
	
	
		}
	
	
	}
	
	
	
	
}






public void limitedTenderRequest(String tenderflow,String tn) throws Exception
{
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	
	if(tenderflow.contains("LimitedTender"))
	{
		
		
		VendorTenderSearch vn=new VendorTenderSearch(driver);
		vn.vendortendorsearch(tn);
		Thread.sleep(5000);
		
		if(!driver.findElements(By.xpath("//a[text()='1']")).isEmpty())
		{
			for(int i=0;i<=25;i++)
			{
				VendorTenderSearch vn1=new VendorTenderSearch(driver);
				vn1.vendortendorsearch(tn);
				Thread.sleep(10000);
				try{
					driver.findElement(tendor_request).click();
					
					break;
					}
				catch(Exception e)
					{
						e.printStackTrace();
					}
			}
		}
			
		
		
	
	
	
}
	}
}
