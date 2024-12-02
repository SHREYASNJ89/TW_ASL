package VendorTenderSubmission;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import Listeners.CheckPageReady;
import TenderCreation.BasePage;
import generic.Auto_const;

public class HTML_TenderSubmission extends BasePage implements Auto_const{

	public HTML_TenderSubmission(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	static By mandatorydoc=By.xpath("//a[contains(text(),'Mandatory Documents')]");
	static By download=By.xpath("//a[contains(@onclick,'adDownload') and(text()='Download')]");
	static By editLink=By.xpath("//a[text()='Edit Bid' and @class='modify']");
	static By editLink2=By.xpath("(//a[text()='Edit Bid' and @class='modify'])[2]");
	static By editBidscreen=By.xpath("//input[@id='sm_basicRatePerUOM_1_1_1']");
	static By save=By.xpath("//input[@name='btnSubmit' and @value='Save']");
	static By biddocuments=By.xpath("//a[@title='Bid Documents']");
	static By retriev_button=By.xpath("//input[@value='Retrieve']");
	static By finish=By.xpath("//input[@value='Finish']");
	static By closeButton=By.xpath("//input[@value='Close']");
	
	//*******Mandatory documents download************
	public void mandatory_Download() throws Exception
	{
	
		CheckPageReady check=new CheckPageReady(driver);  
	   	check.checkPageIsReady();
    	waitForElementToAppear(mandatorydoc);
           WebElement p2=driver.findElement(mandatorydoc);
           javaScriptClick(p2);
           WebElement p1=driver.findElement(download);
           javaScriptClick(p1);
           Thread.sleep(5000);
           CheckTenderSubmited. copyFile(source+"Mandatory.xls", destination);
           Thread.sleep(3000);
    
	}
	
	public void htmlBidUpload(int flag) throws Exception
	{
		
          Thread.sleep(4000);
          driver.switchTo().defaultContent();
          driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='right']")));
          waitForElementToAppear(biddocuments);
          WebElement bd=driver.findElement(biddocuments);
          javaScriptClick(bd); 
          //click on edit bit links
          waitForElementToAppear(editLink);
         WebElement et;
         if(flag==1)
         {
        	  et= driver.findElement(editLink2);
         }
         else{
        	 et= driver.findElement(editLink);
         }
         javaScriptClick(et);
       String parentwin = driver.getWindowHandle();
       Set<String> allhandles = driver.getWindowHandles();
       for(String hand:allhandles)
       {
    	   
    	   driver.switchTo().window(hand);
    	   if(driver.getTitle().contains("Automation"))
    	   {
    		   driver.switchTo().window(hand);
    		   break;
    	   }
       }
       
      
       CheckPageReady ch=new CheckPageReady(driver);
       ch.checkPageIsReady();
       //entering the bid balue
       waitForElementToAppear(editBidscreen);
       String val="80";
       driver.findElement(editBidscreen).sendKeys(val);
       driver.findElement(save).click();
       waitForAlertToAppear();
       Alert a=driver.switchTo().alert();
       a.accept();
       Thread.sleep(2000);
       Runtime.getRuntime().exec(Htmlsign);
       Thread.sleep(7000);
      Thread.sleep(200);
       //waitForAlertToAppear();
       try{
       Alert a2=driver.switchTo().alert();
       a2.accept();
       }
       catch(Exception e){
      a.accept();}
       driver.switchTo().defaultContent();
     driver.findElement(retriev_button).click();
     Thread.sleep(4000);
       Runtime.getRuntime().exec(Htmlsign);
      Thread.sleep(7000);
      driver.switchTo().defaultContent();
      //verifying  retrieved data
      waitForElementToAppear(editBidscreen);
      String retrieved_value=driver.findElement(editBidscreen).getAttribute("value");
      Assert.assertTrue(val.equals(retrieved_value), "The retrieved value is not matching with the enterd value");
      Thread.sleep(3000);
      //click on finish
     driver.findElement(finish).click();
     Thread.sleep(2000);
     try{
         Alert a2=driver.switchTo().alert();
         a2.accept();
         }
         catch(Exception e){
        a.accept();}
     Runtime.getRuntime().exec(Htmlsign);
      Thread.sleep(7000);
      driver.switchTo().defaultContent();
      waitForElementToAppear(closeButton);
     driver.findElement(closeButton).click();
     Thread.sleep(4000);
     Set<String> allhandles1 = driver.getWindowHandles();
     for(String hand:allhandles1)
     {
  	   
  	   driver.switchTo().window(hand);
  	   if(driver.getTitle().contains("Tender Wizard"))
  	   {
  		   driver.switchTo().window(hand);
  		   break;
  	   }
     }
     
    
    
       
	}
}
