package Workflow; 

import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import Listeners.MessageBoard;
import TenderCreation.BasePage;
import generic.Auto_const;

public class Collapse_and_Print_View extends BasePage implements Auto_const
{
	static By Edit_Attachment=By.xpath("//img[@alt='EDIT ATTACHMENTS:Level-1']"); 
	static By Log_Details_Tab=By.xpath("//a[@title='Log Details']");
	static By View=By.xpath("//tr[@id='xtr5_xtd5']//td[5]//ul//li//a"); 
	static By Header=By.xpath("//div[@id='hpanelSec']//div//h2");  
	static By Print_View=By.xpath("//a[contains(text(),'Print View')]");  
	static By Action_Button=By.xpath("//input[@name='btnAction1']");  
	static By Print=By.xpath("//a[contains(text(),'Print')]");  
	static By Collapse_View=By.xpath("//a[contains(text(),'Collapsed View')]"); 
	static By Go_Back=By.xpath("//input[@id='goBack']"); 
	static By Bid_Approval=By.xpath("//img[@alt='Bid Approval']"); 
	static By Expand_View=By.xpath("(//div[@class='expandedVw'])[1]"); 
	static By Frame=By.xpath("//iframe[@name='active' or @name='right']");     
	static By Text_Box=By.xpath("//html//body//div[2]//form//div[4]//div[1]//table//tbody//tr[2]//td[2]//div"); 
	static By Notings=By.xpath("//html//body//div[2]//form//div[4]//div[1]//table//tbody//tr[1]//td[2]");  
	
	
	public static MessageBoard MB; 

private static Logger log = Logger.getLogger(Collapse_and_Print_View.class);

public Collapse_and_Print_View(WebDriver driver)
{
	super(driver);  
} 

public  void Notings_Workflow_Feature_Yes_Page_Verification(SoftAssert sa) throws Exception   
{ 
	driver.switchTo().defaultContent(); 
	WebElement ele = driver.findElement(Frame);
    driver.switchTo().frame(ele);                    
	Thread.sleep(2000);
	waitForElementToAppear(Edit_Attachment); 
	WebElement EA = driver.findElement(Edit_Attachment);
	EA.click();
	log.info("Edit Attachment Icon Clicked successfully");
	waitForElementToAppear(Log_Details_Tab);  
	WebElement LDT = driver.findElement(Log_Details_Tab);
	LDT.click(); 
	log.info("Log Details Tab Clicked successfully");
	waitForElementToAppear(View);   
	WebElement View_Log = driver.findElement(View);
	View_Log.click(); 
	log.info("Workflow Notings View Clicked successfully"); 
	waitForElementToAppear(Header);   
	WebElement Header1 = driver.findElement(Header);
	String H1 = Header1.getText();
	log.info("Header Text is: " + H1); 
	if(H1.contains("Notings"))
	{
		log.info("Workflow Notings Page verified successfully"); 
	}
	else
	{
		sa.fail("Workflow Notings Page verification unsuccessfull"); 
	}
}
public  void Workflow_Notings_Print_View(SoftAssert sa) throws Exception  
{ 
	Thread.sleep(3000);   
	if(driver.findElement(Print_View).isDisplayed())
	{
		Thread.sleep(3000); 
		log.info("Print View Link Verified successfully");
		WebElement Print_View_link = driver.findElement(Print_View); 
		Print_View_link.click();   
		log.info("Print View Link Clicked successfully");
		Thread.sleep(3000); 
		if(driver.findElement(Action_Button).isEnabled()) 
		{
			log.info("Action Button Not Present. Verified successfully"); 
			WebElement TB = driver.findElement(Text_Box);
			log.info("Remarks Text Area is Non-Editable: " + TB.getAttribute("readonly"));  
			WebElement Notngs = driver.findElement(Notings);
			log.info("Notings Text Area is Non-Editable: " + Notngs.getAttribute("readonly"));  
		}
		else
		{ 
			sa.fail("Action Button Present"); 
		}
	}
	else
	{
		sa.fail("Print View Link Not Present");
	}
}
public void switch_Windows() throws Exception
{
	Set<String> handler1 =driver.getWindowHandles();
	System.out.println("window size "+handler1);
	for(String stng:handler1){
driver.switchTo().window(stng);
Thread.sleep(2000);
System.out.println(" window title "+driver.getTitle());
driver.manage().window().maximize();
		}
}
public  void Workflow_Notings_Print(SoftAssert sa) throws Exception  
{ 
	Thread.sleep(3000); 
	WebElement Print_link = driver.findElement(Print); 
	Print_link.click(); 
	Thread.sleep(3000); 
	log.info("Print Link Clicked successfully");
	Thread.sleep(3000);
	Runtime.getRuntime().exec(Printclose);
	Thread.sleep(3000); 
	switch_Windows();	 
    Thread.sleep(5000);
}
public  void Workflow_Notings_Collapse_View(SoftAssert sa) throws Exception   
{ 
	driver.switchTo().defaultContent(); 
	WebElement ele = driver.findElement(Frame);
    driver.switchTo().frame(ele);      
	Thread.sleep(2000);
	waitForElementToAppear(Collapse_View);   
	WebElement Coll_View = driver.findElement(Collapse_View); 
	Coll_View.click();    
	log.info("Collapse View Clicked successfully");
	Thread.sleep(3000); 
	if(driver.findElement(Action_Button).isDisplayed()) 
	{
		log.info("Action Button Present. Verified successfully"); 
	}
	else
	{
		sa.fail("Action Button Not Present");  
	} 
}


public  void Notings_Workflow_Feature_Rich_Text_Editor_Page_Verification(SoftAssert sa) throws Exception   
{ 
	driver.switchTo().defaultContent();  
	WebElement ele = driver.findElement(Frame);
    driver.switchTo().frame(ele);      
	Thread.sleep(2000);
	waitForElementToAppear(Bid_Approval); 
	WebElement BA = driver.findElement(Bid_Approval);
	BA.click(); 
	log.info("Bid Approval Icon Clicked successfully");   
	waitForElementToAppear(Header);   
	WebElement Header1 = driver.findElement(Header);
	String H1 = Header1.getText();
	log.info("Header Text is: " + H1); 
	if(H1.contains("Notings"))
	{
		log.info("Workflow Notings Page verified successfully"); 
	}
	else
	{
		sa.fail("Workflow Notings Page verification unsuccessfull"); 
	}
}
public  void Workflow_Rich_Text_Notings_Print_View(SoftAssert sa) throws Exception  
{ 
	Thread.sleep(3000);   
	if(driver.findElement(Print_View).isDisplayed()) 
	{
		Thread.sleep(3000); 
		log.info("Print View Link Verified successfully");
		WebElement Print_View_link = driver.findElement(Print_View); 
		Print_View_link.click();   
		log.info("Print View Link Clicked successfully");
		Thread.sleep(3000); 
		if(driver.findElement(Action_Button).isEnabled())  
		{
			log.info("Action Button Not Present. Verified successfully"); 
			WebElement EV = driver.findElement(Expand_View);
			log.info("Remarks Text Area is Non-Editable: " + EV.getAttribute("readonly"));     
		}
		else
		{ 
			sa.fail("Action Button Present"); 
		}
	}
	else
	{
		sa.fail("Print View Link Not Present");
	}
}
}