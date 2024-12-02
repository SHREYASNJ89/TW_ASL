package VendorTenderSubmission;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import TenderCreation.BasePage;
import generic.Auto_const;

public class Payments extends BasePage implements Auto_const{

	

	
	

	//Payment links
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
		       
		
		//upload file
		static By upbtn= By.xpath("//a[@id='a_button']");
		static By uploadfile=By.xpath("//input[@value='Upload File']");
		static By clickheretodigitallysign=By.xpath("//input[@id='signUpload']");

		//click on payment links
		static By paynoww= By.xpath("//a[text()='Update/Pay Now']");
		
		
		
		public Payments(WebDriver driver)
		{
			super(driver);
		}
	
	public void paymentsection(String ZeroPayment) throws Exception
	{
		String path1=new java.io.File(".").getCanonicalPath();
		if(ZeroPayment.contains("No"))
			
		{
		//click on payment links
     //   Thread.sleep(3000);
    driver.switchTo().defaultContent();
      WebElement ele2 = driver.findElement(By.xpath("//frame[@name='right']"));
		Thread.sleep(3000);
      driver.switchTo().frame(ele2);
     Thread.sleep(3000);

    // WebDriverWait wait=new WebDriverWait(driver, 20);
	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Submit The Tender Form']")));

		
		
		
		
          if(!driver.findElements(paynoww).isEmpty())
          {
        	
         	 List<WebElement> list=driver.findElements(paynoww);
         	 System.out.println(list.size());
          
          for(int i=0;i<list.size();i++)
          	{
         	 
         	String ids= driver.findElement(paynoww).getAttribute("id");
         
        
                WebElement py=driver.findElement(paynoww);
                javaScriptClick(py);
                Thread.sleep(10000);
                try{
                	Alert t=driver.switchTo().alert();
                	Thread.sleep(3000);
                	t.accept();
                 }
                 catch(Exception e)
                 {
                	 e.printStackTrace();
                 }
                  
                Thread.sleep(4000);
                
               
                
              //  if(ids.contains("EMDRequestId"))
                if(!driver.findElements(By.xpath("//input[@value=' Submit ']")).isEmpty())
                {
             	   WebElement e7=driver.findElement(By.xpath("//input[@value=' Submit ']"));
             	   JavascriptExecutor js = (JavascriptExecutor) driver;
             	   js.executeScript("window.scrollBy(0,1000)");
   		        	javaScriptClick(e7);
   		        	Thread.sleep(3000);
                }
                
                
               /* driver.switchTo().defaultContent();
        		
        		WebElement child = driver.findElement(By.xpath(" //frame[@name='right']"));
        		driver.switchTo().frame(child);
        		Thread.sleep(5000);
        		*/
        		
           
           boolean present2;
           
           
           
           
           
          try {
                   driver.findElement(PaymentDrop);
                    present2 = true;
                    
                    
                    WebElement x= driver.findElement(PaymentDrop);

                    Select select = new Select(x);

                    List<WebElement> options = select.getOptions();
                    String Paylist = null;
                    for(int k=0;k<options.size(); k++)
                           
                                 {
                           String dd=options.get(k).getText();
                           Paylist=(Paylist+";"+dd+";"); 
                                       //System.out.println(options.get(i).getText());
                                 }
                    
                   if(Paylist.contains("PROCESSING FEE"))
                   {
                          
                           
                           Select select1 = new Select(driver.findElement(PaymentDrop));
                           select1.selectByVisibleText("PROCESSING FEE");

                           VIPpayment();
                           
                          try{ 
                           WebElement ewe=driver.findElement(By.xpath("//a[@id='a_button']"));
                              Actions ac=new Actions(driver);
                              ac.moveToElement(ewe).click().build().perform();
                              Thread.sleep(4000);
                              Runtime.getRuntime().exec(NormalUploadA+" "+path1+"\\Bids\\tenderwizard1.xls");
                              Thread.sleep(17000);
                          }
                          catch(Exception e)
                          {
                                e.printStackTrace();
                          }
                           driver.findElement(Update).click();
                           waitForAlertToAppear();
                          Alert al= driver.switchTo().alert();
                          
                          al.accept();
                          
                         waitForElementToAppear(By.xpath("//input[@value='Go Back']"));
	                 	driver.findElement(By.xpath("//input[@value='Go Back']")).click();
                          Thread.sleep(5000);

                   }
                   
                   if(Paylist.contains("EMD"))
                   {
                 	  waitForElementToAppear(PaymentDrop);
                           Select select1 = new Select(driver.findElement(PaymentDrop));
                           select1.selectByVisibleText("EMD");

                           VIPpayment();
                           try{
                           WebElement ewe=driver.findElement(By.xpath("//a[@id='a_button']"));
                              Actions ac=new Actions(driver);
                              ac.moveToElement(ewe).click().build().perform();
                              Thread.sleep(4000);
                              Runtime.getRuntime().exec(NormalUploadA+" "+path1+"\\Bids\\tenderwizard2.xls");
                              Thread.sleep(17000);
                           }
                              catch(Exception e)
                          {
                                e.printStackTrace();
                          }
                              
                           driver.findElement(Update).click();
                           
                        
                           
                        try{
                        	waitForAlertToAppear();
                          Alert al= driver.switchTo().alert();
                          Thread.sleep(5000);
                          al.accept();
                        }
                        catch(Exception e)
                        {  
                     	   e.printStackTrace();
                        } 
                        waitForElementToAppear(By.xpath("//input[@value='Go Back']"));
                 		 
                          driver.findElement(By.xpath("//input[@value='Go Back']")).click();
                          Thread.sleep(5000);

                          
                   }
                   
                   
                   if(Paylist.contains("FORM FEE"))
                   {
                 	  
                           Select select1 = new Select(driver.findElement(PaymentDrop));
                           select1.selectByVisibleText("FORM FEE");
                           VIPpayment();
                           
                           
                           try{
                           WebElement ewe=driver.findElement(By.xpath("//a[@id='a_button']"));
                              Actions ac=new Actions(driver);
                              ac.moveToElement(ewe).click().build().perform();
                              Thread.sleep(4000);
                              Runtime.getRuntime().exec(NormalUploadA+" "+path1+"\\Bids\\tenderwizard3.xls");
                              Thread.sleep(18000);
                           }
                           catch(Exception e)
                                 {
                                       e.printStackTrace();
                                 }
                           
                           driver.findElement(Update).click();
                           waitForAlertToAppear();
                          Alert al= driver.switchTo().alert();
                          Thread.sleep(4000);
                          al.accept();
                          waitForElementToAppear(By.xpath("//input[@value='Go Back']"));
	                 		
                         driver.findElement(By.xpath("//input[@value='Go Back']")).click();
                         Thread.sleep(5000);
                          
                   }
                   
                    
                        }
                                                             
                  catch (NoSuchElementException e)
                 {
                    present2 = false;

                    Alert alert3= driver.switchTo().alert();
                         alert3.accept();
                 }
               
          }
          
          try{
                Alert ak=driver.switchTo().alert();
                ak.accept();
          }
          catch(Exception e)
          {
                e.printStackTrace();
          }
          
          
          }
      
   
          
	}
	
	
	}
	
	
	
	
	public  void VIPpayment() throws AWTException, InterruptedException, IOException
	{
		
		Thread.sleep(2000);
		if(!driver.findElements(By.id("scurrencyType")).isEmpty())
		{
			waitForElementToAppear(By.id("scurrencyType"));
			WebElement ct = driver.findElement(By.id("scurrencyType"));
			Select sc=new Select(ct);
			sc.selectByValue("3");
			Thread.sleep(2000);
		}
		Thread.sleep(2000);
		
	       WebElement poi = driver.findElement(Mode);
	          Select select2 = new Select(poi);
	       List<WebElement> l1=select2.getOptions();
	          ArrayList<String> al=new ArrayList<String>();
	          
	          for(WebElement e:l1)
	          {
	                 String s=e.getText();
	                 al.add(s);
	          }
	          
	         if(al.contains("DD"))
	         {
	          
	          select2.selectByVisibleText("DD");
	          JavascriptExecutor js = ((JavascriptExecutor) driver);
	          js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	          
	          driver.findElement(Number).sendKeys("111111111");
	          Thread.sleep(2000);
	          driver.findElement(Date).click();
	          Thread.sleep(2000);
	          
	          
	          WebElement textbox = driver.findElement(Date);
	          textbox.sendKeys(Keys.ENTER);
	          Robot r1 = new Robot();

	          r1.keyPress(KeyEvent.VK_ENTER);
	          Thread.sleep(2000);

	          r1.keyRelease(KeyEvent.VK_ENTER);
	          Thread.sleep(2000);

	          Select Bank=new Select(driver.findElement(By.id("sInstrumentBank")));
	          Bank.selectByIndex(1);
	          driver.findElement(Branch).sendKeys("222222222");
	         }
	         
	         else
	         {
	                select2.selectByVisibleText("NewRegRev");
	         }
	          
	        
	}

	
}
