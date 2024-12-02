package LoginLogouts;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Listeners.CheckPageReady;
import TenderCreation.BasePage;

public class Logout  extends BasePage{
      
       static By LogoutButton=By.xpath("//a[contains(text(),'Logout')]");
       //static By LogoutButton=By.xpath("//a[@id='LogOut']"); 
       static By Clicklink=By.xpath("//a[contains(text(),'Click here')]");
       static By Left_Frame=By.xpath("//frame[@name='left']");
       static By Left_Frame1=By.xpath("//html//frameset//frameset//frame[1]");
       static By Left_Frame2=By.xpath("//div[@class='cst-tw-rv-left-frame']");
       static By Left_Frame3=By.xpath("(//frameset//frame)[3]");  
       static By Main_Frame4=By.xpath("//html//frameset"); 
     
            
       
       
     
       
       public Logout(WebDriver driver)
       {
             super(driver);
       } 
       
       public void logout_activity(String Centralized) throws Exception
       { 	  
        	   Thread.sleep(3000);
                  driver.switchTo().defaultContent(); 
                  waitForElementToAppear(Left_Frame);
                  WebElement ele1 = driver.findElement(Left_Frame);     
                  driver.switchTo().frame(ele1);
            	  Thread.sleep(3000);
                  waitForElementToAppear(LogoutButton); 
                  WebElement lg=driver.findElement(LogoutButton);
                  javaScriptClick(lg);
            	  Thread.sleep(3000);
            	  driver.switchTo().defaultContent();
              	waitForElementToAppear(By.xpath("//frame[@name='right' or@name='active']"));
                   WebElement ele = driver.findElement(By.xpath("//frame[@name='right' or@name='active']"));
              	 driver.switchTo().frame(ele);
           	  Thread.sleep(3000);
                  waitForElementToAppear(Clicklink);
                  WebElement cli=  driver.findElement(Clicklink);
                  //cli.click(); 
                  javaScriptClick(cli);
                  
       }

       public void logoutactivity(String Centralized) throws Exception {
    	  
    	   Thread.sleep(3000);
              driver.switchTo().defaultContent();
       	   Thread.sleep(5000);
     	  System.out.println("SWITCHED TO DEFAULT FRAME");  
    	   //driver.switchTo().parentFrame();
    	   //driver.switchTo().frame(1);   
    	   
    	   //WebElement Main = driver.findElement(Main_Frame4);
    	   //Thread.sleep(3000); 
    	   //driver.switchTo().frame(Main); 
    	   Thread.sleep(3000);
              waitForElementToAppear(Left_Frame); 
          	   Thread.sleep(5000);
              WebElement ele1 = driver.findElement(Left_Frame);    
         	   Thread.sleep(3000); 
              driver.switchTo().frame(ele1);
        	  Thread.sleep(3000);
        	  System.out.println("SWITCHED TO LEFT FRAME");  
              waitForElementToAppear(LogoutButton); 
              WebElement lg=driver.findElement(LogoutButton);
              //lg.click(); 
             javaScriptClick(lg);  
             
      		Thread.sleep(8000);    
      		 
      	if(Centralized.contains("Yes"))
      		{
              if(driver.findElements(Clicklink).isEmpty()) 
              {
            	 if(driver.findElements(By.xpath("//frame[@name='right' or@name='active']")).isEmpty())
            	 {
            	  
            	driver.switchTo().defaultContent();
            	waitForElementToAppear(By.xpath("//frame[@name='right' or@name='active']"));
                 WebElement ele = driver.findElement(By.xpath("//frame[@name='right' or@name='active']"));
            	 driver.switchTo().frame(ele);
            	/* waitForElementToAppear(By.xpath("//span[text()='I Will Rate Later']"));
             	WebElement btn= driver.findElement(By.xpath("//span[text()='I Will Rate Later']"));
            	*/
            	// waitForElementToAppear(By.xpath("//button[text()='I will Rate Later' or text()='I Will Rate Later']"));
              Thread.sleep(2000);
            	 WebElement btn= driver.findElement(By.xpath("//button[text()='I will Rate Later' or text()='I Will Rate Later']"));
            	 javaScriptClick(btn);
            	Thread.sleep(5000);
            	 }}
      		}
      		Thread.sleep(3000);
      		
      		
      	Set<String> lp = driver.getWindowHandles();
      	for(String hd:lp)
      	{ 
      		driver.switchTo().window(hd);
      		String tt=driver.getTitle();
      		if(tt.contains("LoginPage")||tt.contains("Home"))
      		{
      			driver.close();
      		}
      	}
            waitForElementToAppear(Clicklink);
            WebElement cli=  driver.findElement(Clicklink);
            //cli.click();
            javaScriptClick(cli);
               
       }
}

