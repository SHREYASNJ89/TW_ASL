package VendorTenderSubmission;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import TenderCreation.BasePage;
import generic.Auto_const;


public class AttachingDocuments extends BasePage implements Auto_const {
	
	
	
	
		By checkbox=By.xpath("//input[@value='1']");
		By finishselection=By.xpath("//input[@value='Finish Selection']");
		By attach=By.xpath("//input[@value='Attach']");
		By proceed=By.xpath("//input[@value='Proceed']");
	 By mandatorydoc=By.xpath("//a[contains(text(),'Mandatory Documents')]");
		
		By Attach=By.xpath("//a[text()='Attach']");
	 By Attach_add =	By.xpath("//a[contains(@href,'flow=ADD_ELIGIBILITY_DOCS')and(text()='Attach')]");
	 By Attach_def =	By.xpath("//a[contains(@onclick,'flow=ELIGIBILITY_DOCS')and(text()='Attach')]");
		//doc library
	 By Doclib=By.xpath("//a[text()=' Doc. Library']");
		
		By uploaddoc=By.xpath("//input[@value='Upload Document']");
		By browse=By.id("a_button");
		By attachname=By.name("attachName");
		By attachdes=By.name("attachDesc");
		By Filegroup=By.name("fileGroup");
		By upload=By.xpath("//input[@value='Upload']");
		By update=By.xpath("//input[@value='Update']");
		By editattachment=By.xpath("//img[@alt='EDIT ATTACHMENTS-Level-1']");
		

		
		//upload file
		By upbtn=	By.xpath("//a[@id='a_button']");
		By uploadfile=By.xpath("//input[@value='Upload File']");
		By download=By.xpath("//a[contains(@onclick,'adDownload') and(text()='Download')]");
		By eligibilitydoc =By.xpath("//a[contains(@title,'Request Documents/Payments')]");

	By clickheretodigitallysign=By.xpath("//input[@id='signUpload']");
		By Upload=By.xpath("//a[contains(@onclick,'adUpload')]");
		By paynoww= By.xpath("//a[text()='Update/Pay Now']");
		 By PaymentDrop=By.xpath("//select[@id='transType']");
		 
			//DD payment Fields
			By Number= By.xpath("//input[@id='sInstrumentNumber']");
			By Date=By.xpath("//input[@id='sInstrumentDate']");
			By Branch=By.xpath("//input[@id='sInstrumentBranch']");
			By Remark=By.xpath("//textarea[@id='sInstrumentRemarks']");
		By Update=By.xpath("//input[@value='Update']");
		By Mode=By.xpath("//select[@id='mode']");
			By completereq=By.xpath("//input[@onclick='completeRequest()']");


	/*//Eligibility doc upload  
	 String eligiblitydoc_upload="D:\\Automationworkspace\\Auctionwizard\\AutoitScripts\\Vendor\\eligiblitydoc_upload.exe";
	 String	signupload_eligibilitydoc="D:\\Automationworkspace\\Auctionwizard\\AutoitScripts\\Vendor\\signupload_eligibilitydoc.exe";
	 String elig_attach="D:\\elig_attach.exe";
	 String FileUpload ="D:\\FileUpload.exe";

	//payments section 
	 String File="D:\\Automationworkspace\\Auctionwizard\\AutoitScripts\\Vendor\\File.exe";
	 String File1="D:\\Automationworkspace\\Auctionwizard\\AutoitScripts\\Vendor\\File1.exe";
	 String File2="D:\\Automationworkspace\\Auctionwizard\\AutoitScripts\\Vendor\\File2.exe";
	 String File3="D:\\Automationworkspace\\Auctionwizard\\AutoitScripts\\Vendor\\File3.exe";
	  */  
			
	public AttachingDocuments(WebDriver driver)
	{
		super(driver);
	}

	public  void attach(String Tn,String tenderflow) throws InterruptedException, IOException
	
	
	{
		String path1=new java.io.File(".").getCanonicalPath();
		Thread.sleep(2000);
		String tn=Tn;
		boolean bol=	isAlertPresent();
		if(!bol==false)
		{
			Alert al=driver.switchTo().alert();
			String alertmsg=al.getText();
			al.accept();
			Thread.sleep(5000);
		
			if(alertmsg.contains("You have successfully requested for the Tender No: "+tn+" and Line No: 1"))
			{
				VendorInprogress vend2=new VendorInprogress(driver);
					vend2.inprogress(tn);
					Thread.sleep(1000);  
					waitForElementToAppear(editattachment);
			 		driver.findElement(editattachment).click();
					Thread.sleep(5000);
					
			}
			
			else{

		
		driver.switchTo().defaultContent();
	    WebElement ele2 = driver.findElement(By.xpath("//frame[@name='right']"));
		driver.switchTo().frame(ele2);
		Thread.sleep(9000);
		
		try{
		driver.findElement(eligibilitydoc).isDisplayed();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
			try{
				driver.findElement(editattachment).click();
				Thread.sleep(5000);
				Alert a=driver.switchTo().alert();
				a.accept();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		
		
		
		
		
		
		
		//Click on Request Documents/Payments link  and attaching the eligibility document
		
			Thread.sleep(4000);
			
			
		if(!driver.findElements(eligibilitydoc).isEmpty())
		{
		  driver.findElement(eligibilitydoc).click();
		  Thread.sleep(4000);
		  if(!driver.findElements(download).isEmpty())
		  	{
			  if(driver.findElement(download).isDisplayed())
			  	{
				  WebElement p1=driver.findElement(download);
				  javaScriptClick(p1);
				  Thread.sleep(3000);
				  waitForElementToAppear(Upload);
				  driver.findElement(Upload).click();
				  Thread.sleep(3000);
				  copyFile(source+"Eligibility.xls", destination);
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
						Runtime.getRuntime().exec(NormalUploadA+" "+path1+"\\src\\test\\resources\\AutoitScripts\\VendorDocUpload\\Eligibility.xls");
						Thread.sleep(19000);
						driver.findElement(uploadfile).click();
						waitForElementToAppear(By.xpath("//input[@value='Finish Upload']"));
					}
				else
				{
					waitForElementToAppear(clickheretodigitallysign);
						 driver.findElement(clickheretodigitallysign).click();
						Thread.sleep(9000);
						Runtime.getRuntime().exec(SignAndUploadA+" "+path1+"\\src\\test\\resources\\AutoitScripts\\VendorDocUpload\\Eligibility.xls");
						Thread.sleep(27000);
							
							 driver.switchTo().defaultContent();
							 waitForElementToAppear(By.xpath("//frame[@name='right']"));
							WebElement ele5 = driver.findElement(By.xpath("//frame[@name='right']"));
							driver.switchTo().frame(ele5);
							waitForElementToAppear(By.xpath("//input[@value='Finish Upload']"));
							
					
				}}
		  }
			
				

		// Attaching the additional documents 
	Thread.sleep(2000);
		  if(!driver.findElements(Attach_add).isEmpty())
			{
			  
			  driver.findElement(Attach_add).click();
			   Thread.sleep(3000);
			  waitForElementToAppear(By.xpath("//input[@type='checkbox' and @value='1']"));
				driver.findElement(By.xpath("//input[@type='checkbox' and @value='1']")).click();
				waitForElementToAppear(finishselection);
				driver.findElement(finishselection).click();
				waitForElementToAppear(attach);
				driver.findElement(attach).click();
				
				
		try{
			waitForAlertToAppear();
				Alert we=driver.switchTo().alert();
				we.accept();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		waitForElementToAppear(By.xpath("//input[@value='Finish Upload']"));
			}
		  
			
		
		  
		  
		  
		  Thread.sleep(3000);
     	  
       	if(!driver.findElements(By.xpath("//input[@value='Finish Upload']")).isEmpty())
       	{
       		driver.findElement(By.xpath("//input[@value='Finish Upload']")).click();
       		waitForAlertToAppear();
       		Alert a=driver.switchTo().alert();
       		a.accept();
       		Thread.sleep(3000);
       	}
       	  
		
		//********** Payments************
		  
		  if(!driver.findElements(paynoww).isEmpty())
			{
			
			
			List<WebElement> list=driver.findElements(paynoww);
			System.out.println(list.size());
			
			for(int i=0;i<list.size();i++)
			{
				waitForElementToAppear(paynoww);
			WebElement ee=	driver.findElement(paynoww);
			javaScriptClick(ee);
       
		        Thread.sleep(5000);
		       try{ 
		        if(!driver.findElements(By.xpath("//input[@value=' Submit ']")).isEmpty());
		        {
		        	WebElement e7=driver.findElement(By.xpath("//input[@value=' Submit ']"));
		        	javaScriptClick(e7);
		        	Thread.sleep(4000);
		        }
		       }
		       catch(Exception e)
		       {
		    	   e.printStackTrace();
		       }
		        
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
		    		   System.out.println(Paylist);
		    		   
		    		  if(Paylist.contains("DOCUMENT FEE"))
		    		  {
		    			  
		    			   
		    			   Select select1 = new Select(driver.findElement(PaymentDrop));
		    			   select1.selectByVisibleText("DOCUMENT FEE");

		    			   VIPpayment();
		    			   
		    			  try{ 
		    			   WebElement ewe=driver.findElement(By.xpath("//a[@id='a_button']"));
		    				Actions ac=new Actions(driver);
		    				ac.moveToElement(ewe).click().build().perform();
		    				Thread.sleep(4000);
		    				Runtime.getRuntime().exec(NormalUploadA+" "+path1+"\\Bids\\file1.xls");
		    				Thread.sleep(17000);
		    			  }
		    			  catch(Exception e)
		    			  {
		    				  e.printStackTrace();
		    			  }
		    			  waitForElementToAppear(Update);
		    			   driver.findElement(Update).click();
		    			   waitForAlertToAppear();
		    			 Alert a1= driver.switchTo().alert();
		    			  a1.accept();
		    			 Thread.sleep(2000);
	                 		waitForElementToAppear(By.xpath("//input[@value='Go Back']"));
	                 	 driver.findElement(By.xpath("//input[@value='Go Back']")).click();
		    			  Thread.sleep(4000); 

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
	                          Alert a2= driver.switchTo().alert();
	                          a2.accept();
	                         
	                          Thread.sleep(2000);
		                 		waitForElementToAppear(By.xpath("//input[@value='Go Back']"));
		                 	 driver.findElement(By.xpath("//input[@value='Go Back']")).click();
			    			  Thread.sleep(4000); 

	                  }
	                  
	                  if(Paylist.contains("EMD"))
	                  {
	                         
	                
	                          Select select1 = new Select(driver.findElement(PaymentDrop));
	                          select1.selectByVisibleText("EMD");

	                          VIPpayment();
	                          try{
	                          WebElement ewe=driver.findElement(By.xpath("//a[@id='a_button']"));
	                             Actions ac=new Actions(driver);
	                             ac.moveToElement(ewe).click().build().perform();
	                             Thread.sleep(4000);
	                             Runtime.getRuntime().exec(NormalUploadA+" "+path1+"\\Bids\\tenderwizard2.xls");
	                             Thread.sleep(20000);
	                          }
	                             catch(Exception e)
	                         {
	                               e.printStackTrace();
	                         }
	                             
	                          driver.findElement(Update).click();
	                         waitForAlertToAppear();
	                          Alert a9= driver.switchTo().alert();
	                         
	                         a9.accept();
	                        
	                         Thread.sleep(2000);
		                 		waitForElementToAppear(By.xpath("//input[@value='Go Back']"));
		                 	 driver.findElement(By.xpath("//input[@value='Go Back']")).click();
			    			  Thread.sleep(4000); 

	                         
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
	                             Thread.sleep(20000);
	                          }
	                          catch(Exception e)
	                                {
	                                      e.printStackTrace();
	                                }
	                          
	                          driver.findElement(Update).click();
	                          waitForAlertToAppear();
	                         Alert a2= driver.switchTo().alert();
	                         Thread.sleep(2000);
	                         a2.accept();
	                         Thread.sleep(2000);
		                 		waitForElementToAppear(By.xpath("//input[@value='Go Back']"));
		                 	 driver.findElement(By.xpath("//input[@value='Go Back']")).click();
			    			  Thread.sleep(4000); 
	                        
	                         
	                  }
	                  
		    	}
		    	 catch(Exception e)
				  {
					  e.printStackTrace();
				  }
		    	
			 }//forloop ended
			
			}//if ended
		  
		  Thread.sleep(10000);
		  if(!driver.findElements(completereq).isEmpty())
			{
				boolean ds=driver.findElement(completereq).isEnabled();
				System.out.println(ds);
				if(!ds==false)
				{
					driver.findElement(completereq).click();
					Thread.sleep(4000);
					Alert a=driver.switchTo().alert();
					a.accept();
				}
			}
		  else{
			  if(driver.findElements(mandatorydoc).isEmpty())
              {
		 try{
		  VendorTenderSearch vend=new VendorTenderSearch(driver);
				vend.vendortendorsearch(tn);
		  
		  VendorTendorRequest req=new VendorTendorRequest(driver);
		  req.vendortenderreuest(tn,tenderflow);
		  
		  Alert a = driver.switchTo().alert();
		  a.accept();
		  
		  VendorInprogress vend1=new VendorInprogress(driver);
		vend1.inprogress(tn);
		  
		driver.findElement(editattachment).click();
		Thread.sleep(5000);
		
		  
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

	
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
public  boolean isAlertPresent()
	
	{
	    boolean foundAlert = false;
	    WebDriverWait wait = new WebDriverWait(driver, 0 /*timeout in seconds*/);
	    try {
	        wait.until(ExpectedConditions.alertIsPresent());
	        foundAlert = true;
	    } catch (TimeoutException eTO) {
	        foundAlert = false;
	    }
	    return foundAlert;
	}
	
	
	public static void copyFile(String src, String tar) throws IOException
	{
		   String source = src;
		   String target=tar;
		   File sourceFile = new File(source);
		   String name = sourceFile.getName();
		   File targetFile = new File(target+name);
		   
		   

		   FileHandler.copy(sourceFile,targetFile);
		   
		   System.out.println("copied successfully");
		  
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


