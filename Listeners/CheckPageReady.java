package Listeners;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import TenderCreation.E92AttachDescription;

public class CheckPageReady {
	WebDriver driver;
	private static Logger log = Logger.getLogger(CheckPageReady.class);
	public CheckPageReady(WebDriver driver)
	{
		this.driver=driver;
		
	}
	
	public void checkPageIsReady() throws Exception 
	
	
	{
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 JavascriptExecutor js = (JavascriptExecutor)driver;
		  
        Thread.sleep(4000);
        
		  //Initially bellow given if condition will check ready state of page.
		  if (js.executeScript("return document.readyState").toString().equals("complete"))
		  { 
		   //System.out.println("Page Is loaded.");
			  log.info("Page Is Loaded");
		 
		  } 
		  

		  //This loop will rotate for 25 times to check If page Is ready after every 1 second.
		  //You can replace your value with 25 If you wants to Increase or decrease wait time.
		 
		  else{
		  for (int i=0; i<250; i++)
		  { 
			  
			  try {
				  log.info("Loading");
				  Thread.sleep(3000);
				}
			  catch (InterruptedException e) {
			   
			  	} 
		   //To check page ready state.
			  		if (js.executeScript("return document.readyState").toString().equals("complete")){
			  			 log.info("Page Is Loaded");
			  			break; 
		   } 
			  		
		  }
		 }
	}
}
