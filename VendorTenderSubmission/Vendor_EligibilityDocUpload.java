package VendorTenderSubmission;

import java.io.File;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Vendor_EligibilityDocUpload {
	
 public  WebDriver driver;
//Eligibility doc upload  
	static String eligiblitydoc_upload="D:\\Automationworkspace\\Auctionwizard\\AutoitScripts\\Vendor\\eligiblitydoc_upload.exe";
	static String	signupload_eligibilitydoc="D:\\Automationworkspace\\Auctionwizard\\AutoitScripts\\Vendor\\signupload_eligibilitydoc.exe";
	
	static	By upbtn=	By.xpath("//a[@id='a_button']");
	static	By uploadfile=By.xpath("//input[@value='Upload File']");
	static	By download=By.xpath("//a[contains(@onclick,'adDownload') and(text()='Download')]");
	static	By Upload=By.xpath("//a[contains(@onclick,'adUpload')]");
	static	By clickheretodigitallysign=By.xpath("//input[@id='signUpload']");
	
	
	
	
 public Vendor_EligibilityDocUpload(WebDriver driver)
 {
	 this.driver=driver;
 }
	
 public void eligibilityDocUpload() throws Exception
 {	
	 if(!driver.findElements(download).isEmpty())
		  
	  {
		
			WebElement p1=driver.findElement(download);
			
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", p1);
				
			Thread.sleep(6000);
			driver.findElement(Upload).click();
			Thread.sleep(3000);
			
			
			
			AttachingDocuments.copyFile("C:\\Users\\kavanamn\\Downloads\\Eligibility.xls", "D:\\Automationworkspace\\Auctionwizard\\AutoitScripts\\Vendor\\DownloadVendor\\");
			
			try{
			Alert a1=driver.switchTo().alert();
			a1.accept();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			Thread.sleep(5000);
			
			
			if(!driver.findElements(upbtn).isEmpty())
			{
			
			WebElement ek=driver.findElement(upbtn);
			Actions act=new Actions(driver);
			act.moveToElement(ek).click().build().perform();
			Thread.sleep(9000);
			Runtime.getRuntime().exec(eligiblitydoc_upload);
			Thread.sleep(19000);
			driver.findElement(uploadfile).click();
			Thread.sleep(9000);
			
			}
			
			
			else
			{
				if(!driver.findElements(clickheretodigitallysign).isEmpty());
				{
						driver.findElement(clickheretodigitallysign).click();
						Thread.sleep(9000);
						Runtime.getRuntime().exec(signupload_eligibilitydoc);
						Thread.sleep(27000);
						driver.switchTo().defaultContent();
						WebElement ele5 = driver.findElement(By.xpath("//frame[@name='right']"));
						driver.switchTo().frame(ele5);
						
				}
			}
	  }
	 
	 
	 
		
 }
}
