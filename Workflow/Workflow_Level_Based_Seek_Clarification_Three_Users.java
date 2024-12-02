package Workflow;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;   
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import Listeners.Frame_Switch_Pop_Up;
import Listeners.RandomString;
import TenderAuctionSearch.TenderSearchInprogress;
import TenderAuctionSearch.TenderSearchOpen;
import TenderCreation.BasePage;
import TenderOpneing.TechnicalOpening;

public class Workflow_Level_Based_Seek_Clarification_Three_Users extends BasePage
{
	static By Notings=By.xpath("//input[@name='notingNo']"); 
	static By Remarks=By.xpath("//textarea[@name='remarks']");
	static By Update=By.xpath("//input[@value='Update']");
	static By Nxt_Stp=By.xpath("//input[@name='nextStep']");
	static By Seek_Clar=By.xpath("(//a[contains(text(),'Seek Clarification From')])[2]");
	static By Seek_Clar1=By.xpath("(//a[contains(text(),'Seek Clarification From')])[1]");
	static By Edit_Attach=By.xpath("//img[@alt='EDIT ATTACHMENTS:Level-1']");
	static By Log_Details=By.xpath("(//div[@class='summary']//form//table//tbody)[2]//tr//td[2]//div//ul//li//a[@title='Log Details']");
	static By View=By.xpath("(//a[@class='view'])[5]");  
	static By Bid_App=By.xpath("//img[@alt='Bid Approval']"); 
	static By Not_Number=By.xpath("//div[@id='sourceText']"); 
	static By Not_Remarks=By.xpath("//textarea[@name='remarks']"); 
	static By Actn_Button=By.xpath("//input[@id='btnAction']"); 
	static By update_Button=By.xpath("//a[contains(text(),'Update')]"); 
	static By Go_To_EDITATCH=By.xpath("//a[contains(text(),'Go to Edit Attachment')]"); 
	static By Input_CB=By.xpath("(//input[@name='inputCheck'])[1]"); 
	static By Sub_Bton=By.xpath("(//input[@name='submit1'])[1]"); 
	static By Seek_Clar_RT=By.xpath("(//a[contains(text(),'Seek Clarification / Discuss From')])[2]"); 
	static By Seek_Clar_RT_New=By.xpath("(//a[contains(text(),'Seek Clarification / Discuss From')])[1]"); 
	public static Frame_Switch_Pop_Up FS;      

	public Workflow_Level_Based_Seek_Clarification_Three_Users(WebDriver driver)
	{
		super(driver);
	}
	public void Techno_Commercial_Open_Seek_Clar(String tn) throws Exception
	 
	 {
		 Thread.sleep(2000);
		
			TenderSearchInprogress tend=new TenderSearchInprogress(driver);
			tend.InProgress(tn);
		
			TechnicalOpening techi=new TechnicalOpening(driver);
			techi.TechOpen(tn);
		
			RandomString randomstring=new RandomString(driver);
			String r1 = randomstring.randomString();
			
		//entering noting number
		waitForElementToAppear(Notings);
		WebElement etr=driver.findElement(Notings);     
		etr.sendKeys(r1);
		  log.info("Notings Updated"); 
		//entering remarks
		waitForElementToAppear(Remarks);
		WebElement etr1=driver.findElement(Remarks);      
		etr1.sendKeys("Tecno Commercial Clarification "+r1+" entered Successfully"); 
		  log.info("Remarks Updated"); 
		//clicking on update button adn approve the same      
		waitForElementToAppear(Update);
		driver.findElement(Update).click();     
		Thread.sleep(2000);
		  log.info("Update Button Clicked"); 
		waitForElementToAppear(Nxt_Stp);
		WebElement rock=driver.findElement(Nxt_Stp);
		Thread.sleep(2000);     
		Actions act=new Actions(driver);
		act.moveToElement(rock).perform();
		Thread.sleep(2000);
		waitForElementToAppear(Seek_Clar);               
		driver.findElement(Seek_Clar).click();
		  log.info("Seek Clarification Button Clicked"); 
		waitForAlertToAppear();
		Alert a =driver.switchTo().alert();     
		a.accept();
		  log.info("Alert Closed"); 
		Thread.sleep(8000);			
		 }  	
	
	public void Techno_Commercial_Open_Seek_Clar_2(String tn) throws Exception  
	 
	 {
		 Thread.sleep(2000);
		
			TenderSearchInprogress tend=new TenderSearchInprogress(driver);
			tend.InProgress(tn);
		
			TechnicalOpening techi=new TechnicalOpening(driver);
			techi.TechOpen(tn);
		
			RandomString randomstring=new RandomString(driver);
			String r1 = randomstring.randomString();
			
			
		//entering noting number
		waitForElementToAppear(Notings);
		WebElement etr=driver.findElement(Notings);     
		etr.sendKeys(r1);
		  log.info("Notings Updated"); 

		//entering remarks
		waitForElementToAppear(Remarks);
		WebElement etr1=driver.findElement(Remarks);      
		etr1.sendKeys("Tecno Commercial Clarification "+r1+" entered Successfully");
		//clicking on update button adn approve the same    
		  log.info("Remarks Updated"); 

		waitForElementToAppear(Update);
		driver.findElement(Update).click();     
		Thread.sleep(2000);
		  log.info("Update Button Clicked"); 
		waitForElementToAppear(Nxt_Stp);
		WebElement rock=driver.findElement(Nxt_Stp);
		Thread.sleep(2000);     
		Actions act=new Actions(driver);
		act.moveToElement(rock).perform();
		Thread.sleep(2000);
		waitForElementToAppear(Seek_Clar1);
		driver.findElement(Seek_Clar1).click();
		  log.info("Seek Clarification Button Clicked"); 
		waitForAlertToAppear();
		Alert a =driver.switchTo().alert();     
		a.accept();
		Thread.sleep(8000);	
		  log.info("Alert Closed"); 
		 }
	
	public void Techno_Commercial_Open_Seek_Clarification_Rich_Text_Editor (String tn, SoftAssert sa) throws Exception
	 {
		
	 TenderSearchOpen tendopen=new TenderSearchOpen(driver);
	 tendopen.Open(tn);

	 RandomString randomstring=new RandomString(driver);
	 String r1 = randomstring.randomString();

	 waitForElementToAppear(Bid_App);
	 driver.findElement(Bid_App).click();       
	  log.info("Bid Approval icon Clicked"); 
	 //enter notings number
	 waitForElementToAppear(Not_Number);
	 WebElement etr=driver.findElement(Not_Number);    
	 etr.sendKeys(r1);
	  log.info("Notings Updated"); 
	 //Enter Remarks
	 waitForElementToAppear(Not_Remarks);
	 WebElement etr1=driver.findElement(Not_Remarks);    
	 etr1.sendKeys("Technical Bid Clarification "+r1+" entered Successfully");
	  log.info("Remarks Updated"); 
	 //move mouse to Actions and select update from drop down
	 Thread.sleep(2000);
	 waitForElementToAppear(Actn_Button);
	 WebElement action=driver.findElement(Actn_Button);   
	 Actions act=new Actions(driver);
	 act.moveToElement(action).perform();
	 waitForElementToAppear(update_Button);
	 WebElement click= driver.findElement(update_Button);   
	 javaScriptClick(click);
	 Thread.sleep(2000);
	  log.info("Updated Button Clicked"); 

	 // click on edit attachment[contains(text(),'Go to Edit Attachment')]
	 waitForElementToAppear(Actn_Button);
	 WebElement action_edit=driver.findElement(Actn_Button);    
	 Actions act1=new Actions(driver);
	 act1.moveToElement(action_edit).perform();
	 waitForElementToAppear(Go_To_EDITATCH);
	 WebElement click1= driver.findElement(Go_To_EDITATCH);    
	 javaScriptClick(click1);
	 Thread.sleep(5000);
	  log.info("Docs attached from edit attachment"); 
	 FS=PageFactory.initElements(driver, Frame_Switch_Pop_Up.class);  
	  driver.switchTo().defaultContent();
	  FS.Right(sa);
	  log.info("Switched"); 
	 //Click on first check box to attach the doc   
	 waitForElementToAppear(Input_CB);
	 WebElement click2= driver.findElement(Input_CB);     
	 javaScriptClick(click2); 
	 //click2.click();
	 Thread.sleep(2000);
	  log.info("Checkbox selected"); 
	 //click on attach tender documents

	 waitForElementToAppear(Sub_Bton);    
	 WebElement click3= driver.findElement(Sub_Bton);     
	javaScriptClick(click3);
	 //click3.click();  
	 Thread.sleep(2000);
	  log.info("Submit Button Clicked"); 
	 //click on Approve
	 waitForElementToAppear(Actn_Button);
	 WebElement action_approve=driver.findElement(Actn_Button);               
	 Actions act2=new Actions(driver);
	 act2.moveToElement(action_approve).perform();
	 waitForElementToAppear(Seek_Clar_RT);   
	 WebElement click4= driver.findElement(Seek_Clar_RT);            
	 javaScriptClick(click4);
	  log.info("Seek Clarification Button Clicked"); 
	 waitForAlertToAppear();    
	 Alert a=driver.switchTo().alert();     
	 a.accept();     
Thread.sleep(2000);
log.info("Alert Closed"); 

}
	public void Techno_Commercial_Open_Seek_Clarification_Rich_Text_Editor_Two (String tn, SoftAssert sa) throws Exception
	 {          
		
	 TenderSearchOpen tendopen=new TenderSearchOpen(driver);
	 tendopen.Open(tn);

	 RandomString randomstring=new RandomString(driver);
	 String r1 = randomstring.randomString();
                            
	 waitForElementToAppear(Bid_App);
	 driver.findElement(Bid_App).click();       
	  log.info("Bid Approval Icon CLicked"); 
	 //enter notings number
	 waitForElementToAppear(Not_Number);
	 WebElement etr=driver.findElement(Not_Number);    
	 etr.sendKeys(r1);
	  log.info("Notings Updated"); 
	 //Enter Remarks
	 waitForElementToAppear(Not_Remarks);
	 WebElement etr1=driver.findElement(Not_Remarks);    
	 etr1.sendKeys("Technical Bid Clarification "+r1+" entered Successfully");
	  log.info("Remarks Updated"); 
	 //move mouse to Actions and select update from drop down
	 Thread.sleep(2000);
	 waitForElementToAppear(Actn_Button);
	 WebElement action=driver.findElement(Actn_Button);   
	 Actions act=new Actions(driver);
	 act.moveToElement(action).perform();
	 waitForElementToAppear(update_Button);
	 WebElement click= driver.findElement(update_Button);   
	 javaScriptClick(click);
	 Thread.sleep(2000);
	  log.info("Update Button CLicked"); 

	 // click on edit attachment[contains(text(),'Go to Edit Attachment')]
	 waitForElementToAppear(Actn_Button);
	 WebElement action_edit=driver.findElement(Actn_Button);    
	 Actions act1=new Actions(driver);
	 act1.moveToElement(action_edit).perform();
	 waitForElementToAppear(Go_To_EDITATCH);
	 WebElement click1= driver.findElement(Go_To_EDITATCH);    
	 javaScriptClick(click1);
	 Thread.sleep(5000);
	 
	 FS=PageFactory.initElements(driver, Frame_Switch_Pop_Up.class);  
	  driver.switchTo().defaultContent();
	  FS.Right(sa);
	 
	 //Click on first check box to attach the doc
	 waitForElementToAppear(Input_CB);
	 WebElement click2= driver.findElement(Input_CB);     
	 javaScriptClick(click2); 
	 //click2.click();
	 Thread.sleep(2000);
	  log.info("Check Box Selected"); 
	 //click on attach tender documents

	 waitForElementToAppear(Sub_Bton);    
	 WebElement click3= driver.findElement(Sub_Bton);     
	javaScriptClick(click3);
	 //click3.click();  
	 Thread.sleep(2000);
	  log.info("Submit Button CLicked"); 
	 //click on Approve
	 waitForElementToAppear(Actn_Button);
	 WebElement action_approve=driver.findElement(Actn_Button);               
	 Actions act2=new Actions(driver);
	 act2.moveToElement(action_approve).perform();
	 waitForElementToAppear(Seek_Clar_RT_New);   
	 WebElement click4= driver.findElement(Seek_Clar_RT_New);                
	 javaScriptClick(click4);
	  log.info("Seek CLarification Button CLicked"); 
	 waitForAlertToAppear();    
	 Alert a=driver.switchTo().alert();     
	 a.accept();     
Thread.sleep(2000);
log.info("Alert Closed"); 
}
}
