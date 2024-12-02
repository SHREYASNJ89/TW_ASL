package Workflow;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import Listeners.Frame_Switch_Pop_Up;
import Listeners.MessageBoard;
import Listeners.Scroll_Horizontal_Vertical;
import Listeners.switch_Windows;
import LoginLogouts.Logout;
import TenderAuctionSearch.TenderSearchInprogress;
import TenderAuctionSearch.TenderSearchOpen;
import TenderCreation.BasePage;
import TenderOpneing.CostOpen;
import TenderOpneing.TechnicalOpening;

public class MeconBuyer extends BasePage

{
	public static By briefcase=By.xpath("//img[@alt='WorkFlow Detail']");
	public static By tender_approval1=By.id("technicalOpenWorkId");
	public static By tender_approval2=By.id("costOpenWorkId");    
	public static By bid_approval1=By.id("technicalBidWorkId");
	public static By bid_approval2=By.id("costBidWorkId");
	public static By submit=By.xpath("//input[@id='submitId']");   
	public static By selectUser1=By.id("TECHNICAL_WORK_ID_img");
	public static By selectUser2=By.id("COST_WORK_ID_img");    
	public static By selectUser3=By.id("BID_TECH_WORK_ID_img");      
	public static By selectUser4=By.id("BID_COST_WORK_ID_img");   
	public static By commite=By.id("committeeLink1");
	static By Right_Frame=By.xpath("//iframe[@name='right']");                
	static By Header=By.xpath("//div[@class='panel']//div[@class='hpanel']//div[@class='caption']//h2[contains(text(),'WFL Line Detail')]");       
	
	public static MessageBoard MB;
	public static Frame_Switch_Pop_Up FS;      
	public static Scroll_Horizontal_Vertical SV;    
	public static switch_Windows SW;  

	
	public MeconBuyer(WebDriver driver)
	{
		
	super(driver);
	
	}

   public void addWorkFlowUsers(String workflowID) throws Exception
   {
	   try{
	   Thread.sleep(2000);
	   waitForElementToAppear(briefcase);
		   driver.findElement(briefcase).click();
		   waitForElementToAppear(tender_approval1);        
			WebElement t=driver.findElement(tender_approval1);
			Select s=new Select(t);
			s.selectByVisibleText(workflowID);
			WebElement t1=driver.findElement(tender_approval2);
			Select s1=new Select(t1);
			s1.selectByVisibleText(workflowID);
			WebElement t2=driver.findElement(bid_approval1);
			Select s2=new Select(t2);
			s2.selectByVisibleText(workflowID);
			WebElement t3=driver.findElement(bid_approval2);
			Select s3=new Select(t3);
			s3.selectByVisibleText(workflowID);
			driver.findElement(submit).click();
	
	
	
	//*******SelectUser****** Flow Started******    
	
	Thread.sleep(1000);
		
	waitForElementToAppear(selectUser1);
	driver.findElement(selectUser1).click();
	Thread.sleep(3000);
	Set<String> hand = driver.getWindowHandles();
	
	for(String ha:hand)
	{
		driver.switchTo().window(ha);
		String tit=driver.getTitle();
		if(tit.contains("WflLineDetail servlet"))
		{
			driver.switchTo().window(ha);
			driver.manage().window().maximize();
			break;
		}
		
	}
	waitForElementToAppear(commite);
	driver.findElement(commite).click();
	Thread.sleep(1000);
	//switch window

Set<String> hand1 = driver.getWindowHandles();

for(String ha1:hand1)
{
	driver.switchTo().window(ha1);
	driver.manage().window().maximize();
	String tit=driver.getTitle();
	
	if(ha1.contains("CDwindow-846DBDD1C3FD8CC9DA4D623E9208D12C"))
	{
		driver.switchTo().window(ha1);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		break;
	}
}





//driver.switchTo().window("CDwindow-846DBDD1C3FD8CC9DA4D623E9208D12C");

waitForElementToAppear(By.xpath("//tr[2]//td[5]//img[1]"));
Thread.sleep(3000);
javaScriptClick(driver.findElement(By.xpath("//tr[2]//td[5]//img[1]")));
Thread.sleep(3000);
waitForElementToAppear(By.xpath("//td[@id='light_content']//iframe"));
WebElement e2=driver.findElement(By.xpath("//td[@id='light_content']//iframe"));
driver.switchTo().frame(e2);
Thread.sleep(3000);
waitForElementToAppear(By.xpath("//td[contains(text(),'SHREYAS_USER1')]/..//td//input[1]"));
driver.findElement(By.xpath("//td[contains(text(),'SHREYAS_USER1')]/..//td//input[1]")).click();
Thread.sleep(3000); 

if(!driver.findElements(By.name("submit1")).isEmpty());
{
	List<WebElement> exd = driver.findElements(By.name("submit1"));
	
	for(WebElement er:exd)
	{
		if(er.isDisplayed());
		{
			er.click();
			break;
		}
	}
	 
}


	
driver.switchTo().defaultContent();

waitForElementToAppear(By.xpath("//tr[3]//td[5]//img[1]"));
Thread.sleep(3000);
javaScriptClick(driver.findElement(By.xpath("//tr[3]//td[5]//img[1]")));
Thread.sleep(3000);
waitForElementToAppear(By.xpath("//td[@id='light_content']//iframe"));
WebElement e=driver.findElement(By.xpath("//td[@id='light_content']//iframe"));
driver.switchTo().frame(e);
Thread.sleep(3000);

waitForElementToAppear(By.xpath("//td[contains(text(),'SHREYAS_USER2')]/..//td//input[1]"));
driver.findElement(By.xpath("//td[contains(text(),'SHREYAS_USER2')]/..//td//input[1]")).click();
  
if(!driver.findElements(By.name("submit1")).isEmpty());
{
	List<WebElement> exd = driver.findElements(By.name("submit1"));
	
	for(WebElement er:exd)
	{
		if(er.isDisplayed());
		{
			er.click();
			driver.switchTo().defaultContent();
			break;
		}
	}
	
}


driver.findElement(By.id("submitId")).click();
waitForElementToAppear(By.xpath("//input[@value='Click here to close the Window']"));

driver.findElement(By.xpath("//input[@value='Click here to close the Window']")).click();

Set<String> tam=driver.getWindowHandles();
for(String ha1:tam)
{
	driver.switchTo().window(ha1);
	driver.manage().window().maximize();
	String tit=driver.getTitle();
	
	if(tit.contains("WflLineDetail servlet"))
	{
		driver.switchTo().window(ha1);
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		Thread.sleep(4000);
		break;
	}
}


driver.findElement(By.id("submitId")).click();
waitForElementToAppear(By.xpath("//input[@value='Click here to close the Window']"));

driver.findElement(By.xpath("//input[@value='Click here to close the Window']")).click();


//********************************************











Thread.sleep(3000);
Set<String> gst1 = driver.getWindowHandles();
for(String eone:gst1)
{
	driver.switchTo().window(eone);
	String title1=driver.getTitle();
	if(title1.contains("TenderWizard"))
	{
driver.switchTo().window(eone);
driver.manage().window().maximize();
break;
	}
}

Thread.sleep(3000);
driver.switchTo().defaultContent();
waitForElementToAppear(Right_Frame);
WebElement righ1 = driver.findElement(Right_Frame);
driver.switchTo().frame(righ1);    
	Thread.sleep(1000);



//*******SelectUser****** Flow Started******

	waitForElementToAppear(selectUser2);

	driver.findElement(selectUser2).click();
	

	Set<String> han = driver.getWindowHandles();
	
	for(String ha:han)
	{
		driver.switchTo().window(ha);
		driver.manage().window().maximize();
		String tit=driver.getTitle();
		if(tit.contains("WflLineDetail servlet"))
		{
			driver.switchTo().window(ha);
			driver.manage().window().maximize();
			break;
		}
		
	}
	waitForElementToAppear(commite);
	driver.findElement(commite).click();
	
	//switch window

Set<String> handy = driver.getWindowHandles();

for(String ha1:handy)
{
	driver.switchTo().window(ha1);
	driver.manage().window().maximize(); 
	String tit=driver.getTitle();
	System.out.println(tit  +  ha1);
	if(ha1.contains("CDwindow-846DBDD1C3FD8CC9DA4D623E9208D12C"))
	{
		driver.switchTo().window(ha1);
		driver.manage().window().maximize();
		Thread.sleep(4000);
		break;
	}
}





//driver.switchTo().window("CDwindow-846DBDD1C3FD8CC9DA4D623E9208D12C");

waitForElementToAppear(By.xpath("//tr[2]//td[5]//img[1]"));
driver.findElement(By.xpath("//tr[2]//td[5]//img[1]"));
Thread.sleep(3000);
javaScriptClick(driver.findElement(By.xpath("//tr[2]//td[5]//img[1]")));
Thread.sleep(3000);
waitForElementToAppear(By.xpath("//td[@id='light_content']//iframe"));

WebElement e0=driver.findElement(By.xpath("//td[@id='light_content']//iframe"));
driver.switchTo().frame(e0);
Thread.sleep(3000);
waitForElementToAppear(By.xpath("//td[contains(text(),'SHREYAS_USER1')]/..//td//input[1]"));
driver.findElement(By.xpath("//td[contains(text(),'SHREYAS_USER1')]/..//td//input[1]")).click();

if(!driver.findElements(By.name("submit1")).isEmpty());
{
	List<WebElement> exd = driver.findElements(By.name("submit1"));
	
	for(WebElement er:exd)
	{
		if(er.isDisplayed());
		{
			er.click();
			break;
		}
	}
	
}


	
driver.switchTo().defaultContent();

waitForElementToAppear(By.xpath("//tr[3]//td[5]//img[1]"));
Thread.sleep(3000);
javaScriptClick(driver.findElement(By.xpath("//tr[3]//td[5]//img[1]")));
Thread.sleep(3000);
waitForElementToAppear(By.xpath("//td[@id='light_content']//iframe"));
Thread.sleep(2000);
WebElement e11=driver.findElement(By.xpath("//td[@id='light_content']//iframe"));
Thread.sleep(3000);
driver.switchTo().frame(e11);
waitForElementToAppear(By.xpath("//td[contains(text(),'SHREYAS_USER2')]/..//td//input[1]"));
driver.findElement(By.xpath("//td[contains(text(),'SHREYAS_USER2')]/..//td//input[1]")).click();

if(!driver.findElements(By.name("submit1")).isEmpty());
{
	List<WebElement> exd = driver.findElements(By.name("submit1"));
	Thread.sleep(3000);
	for(WebElement er:exd)
	{
		if(er.isDisplayed());
		{
			er.click();
			driver.switchTo().defaultContent();
			break;
		}
	}
	
}


driver.findElement(By.id("submitId")).click();
waitForElementToAppear(By.xpath("//input[@value='Click here to close the Window']"));
driver.findElement(By.xpath("//input[@value='Click here to close the Window']")).click();

Set<String> tam1=driver.getWindowHandles();
for(String ha1:tam1)
{
	driver.switchTo().window(ha1);
	driver.manage().window().maximize();
	String tit=driver.getTitle();
	
	if(tit.contains("WflLineDetail servlet"))
	{
		driver.switchTo().window(ha1);
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		Thread.sleep(4000);
		break;
	}
}

waitForElementToAppear(By.id("submitId"));
driver.findElement(By.id("submitId")).click();
waitForElementToAppear(By.xpath("//input[@value='Click here to close the Window']"));
driver.findElement(By.xpath("//input[@value='Click here to close the Window']")).click();


//********************************************






Thread.sleep(4000);

Set<String> gst2 = driver.getWindowHandles();
for(String eone:gst2)
{
	driver.switchTo().window(eone);
	driver.manage().window().maximize();
	String title1=driver.getTitle();
	if(title1.contains("TenderWizard"))
	{
driver.switchTo().window(eone);
driver.manage().window().maximize();
break;
	}
}



driver.switchTo().defaultContent();

WebElement righ = driver.findElement(Right_Frame);    
	
 driver.switchTo().frame(righ);
	Thread.sleep(1000);

//*******SelectUser****** Flow Started******
	waitForElementToAppear(selectUser3);


	driver.findElement(selectUser3).click();
	

	Set<String> handi = driver.getWindowHandles();
	
	for(String ha:handi)
	{
		driver.switchTo().window(ha);
		driver.manage().window().maximize();
		String tit=driver.getTitle();
		if(tit.contains("WflLineDetail servlet"))
		{
			driver.switchTo().window(ha);
			driver.manage().window().maximize();
			break;
		}
		
	}
	waitForElementToAppear(commite);
	driver.findElement(commite).click();
	
	//switch window

Set<String> hands = driver.getWindowHandles();

for(String ha1:hands)
{
	driver.switchTo().window(ha1);
	driver.manage().window().maximize();
	String tit=driver.getTitle();
	System.out.println(tit  +  ha1);
	if(ha1.contains("CDwindow-846DBDD1C3FD8CC9DA4D623E9208D12C"))
	{
		driver.switchTo().window(ha1);
		driver.manage().window().maximize();
		Thread.sleep(4000);
		break;
	}
}





//driver.switchTo().window("CDwindow-846DBDD1C3FD8CC9DA4D623E9208D12C");

waitForElementToAppear(By.xpath("//tr[2]//td[5]//img[1]"));
Thread.sleep(3000);
javaScriptClick(driver.findElement(By.xpath("//tr[2]//td[5]//img[1]")));
Thread.sleep(3000);
waitForElementToAppear(By.xpath("//td[@id='light_content']//iframe"));
Thread.sleep(3000);
WebElement e12=driver.findElement(By.xpath("//td[@id='light_content']//iframe"));
driver.switchTo().frame(e12);
Thread.sleep(3000);
waitForElementToAppear(By.xpath("//td[contains(text(),'SHREYAS_USER1')]/..//td//input[1]"));
driver.findElement(By.xpath("//td[contains(text(),'SHREYAS_USER1')]/..//td//input[1]")).click();
if(!driver.findElements(By.name("submit1")).isEmpty());
{
	List<WebElement> exd = driver.findElements(By.name("submit1"));
	Thread.sleep(3000);
	for(WebElement er:exd)
	{
		if(er.isDisplayed());
		{
			er.click();
			break;
		}
	}
	
}


	
driver.switchTo().defaultContent();
waitForElementToAppear(By.xpath("//tr[3]//td[5]//img[1]"));
Thread.sleep(3000);
javaScriptClick(driver.findElement(By.xpath("//tr[3]//td[5]//img[1]")));
Thread.sleep(3000);
waitForElementToAppear(By.xpath("//td[@id='light_content']//iframe"));
Thread.sleep(2000);
WebElement e15=driver.findElement(By.xpath("//td[@id='light_content']//iframe"));
driver.switchTo().frame(e15);
Thread.sleep(3000);
waitForElementToAppear(By.xpath("//td[contains(text(),'SHREYAS_USER2')]/..//td//input[1]"));
driver.findElement(By.xpath("//td[contains(text(),'SHREYAS_USER2')]/..//td//input[1]")).click();
if(!driver.findElements(By.name("submit1")).isEmpty());
{
	List<WebElement> exd = driver.findElements(By.name("submit1"));
	
	for(WebElement er:exd)
	{
		if(er.isDisplayed());
		{
			er.click();
			driver.switchTo().defaultContent();
			break;
		}
	}
	
}


driver.findElement(By.id("submitId")).click();
waitForElementToAppear(By.xpath("//input[@value='Click here to close the Window']"));
driver.findElement(By.xpath("//input[@value='Click here to close the Window']")).click();
Set<String> tams=driver.getWindowHandles();
for(String ha1:tams)
{
	driver.switchTo().window(ha1);
	driver.manage().window().maximize();
	String tit=driver.getTitle();
	
	if(tit.contains("WflLineDetail servlet"))
	{
		driver.switchTo().window(ha1);
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		Thread.sleep(4000);
		break;
	}
}

waitForElementToAppear(By.id("submitId"));
driver.findElement(By.id("submitId")).click();
waitForElementToAppear(By.xpath("//input[@value='Click here to close the Window']"));
driver.findElement(By.xpath("//input[@value='Click here to close the Window']")).click();


//********************************************














Thread.sleep(4000);
Set<String> gst3 = driver.getWindowHandles();
for(String eone:gst3)
{
	driver.switchTo().window(eone);
	driver.manage().window().maximize();
	String title1=driver.getTitle();
	if(title1.contains("TenderWizard"))
	{
driver.switchTo().window(eone);
driver.manage().window().maximize();
break;
	}
}


driver.switchTo().defaultContent();
waitForElementToAppear(Right_Frame);
WebElement righ11 = driver.findElement(Right_Frame);
driver.switchTo().frame(righ11);    
	Thread.sleep(1000);


//*******SelectUser****** Flow Started******
	waitForElementToAppear(selectUser4);
	driver.findElement(selectUser4).click();
	Set<String> handp = driver.getWindowHandles();
	
	for(String ha:handp)
	{
		driver.switchTo().window(ha);
		driver.manage().window().maximize();
		String tit=driver.getTitle();
		if(tit.contains("WflLineDetail servlet"))
		{
			driver.switchTo().window(ha);
			driver.manage().window().maximize();
			break;
		}
		
	}
	waitForElementToAppear(commite);
	driver.findElement(commite).click();
	
	//switch window

Set<String> handl = driver.getWindowHandles();

for(String ha1:handl)
{
	driver.switchTo().window(ha1);
	driver.manage().window().maximize();
	String tit=driver.getTitle();
	System.out.println(tit  +  ha1);
	if(ha1.contains("CDwindow-846DBDD1C3FD8CC9DA4D623E9208D12C"))
	{
		driver.switchTo().window(ha1);
		driver.manage().window().maximize();
		Thread.sleep(4000);
		break;
	}
}





//driver.switchTo().window("CDwindow-846DBDD1C3FD8CC9DA4D623E9208D12C");

waitForElementToAppear(By.xpath("//tr[2]//td[5]//img[1]"));
Thread.sleep(3000);
javaScriptClick(driver.findElement(By.xpath("//tr[2]//td[5]//img[1]")));
Thread.sleep(3000);
waitForElementToAppear(By.xpath("//td[@id='light_content']//iframe"));
Thread.sleep(2000);
WebElement e20=driver.findElement(By.xpath("//td[@id='light_content']//iframe"));
driver.switchTo().frame(e20);
Thread.sleep(3000);
waitForElementToAppear(By.xpath("//td[contains(text(),'SHREYAS_USER1')]/..//td//input[1]"));
driver.findElement(By.xpath("//td[contains(text(),'SHREYAS_USER1')]/..//td//input[1]")).click();
Thread.sleep(3000);
if(!driver.findElements(By.name("submit1")).isEmpty());
{
	List<WebElement> exd = driver.findElements(By.name("submit1"));
	
	for(WebElement er:exd)
	{
		if(er.isDisplayed());
		{
			er.click();
			break;
		}
	}
	
}


	
driver.switchTo().defaultContent();
waitForElementToAppear(By.xpath("//tr[3]//td[5]//img[1]"));
Thread.sleep(3000);
javaScriptClick(driver.findElement(By.xpath("//tr[3]//td[5]//img[1]")));
Thread.sleep(3000);
waitForElementToAppear(By.xpath("//td[@id='light_content']//iframe"));
Thread.sleep(2000);
WebElement e21=driver.findElement(By.xpath("//td[@id='light_content']//iframe"));
driver.switchTo().frame(e21);
Thread.sleep(2000);
waitForElementToAppear(By.xpath("//td[contains(text(),'SHREYAS_USER2')]/..//td//input[1]"));
driver.findElement(By.xpath("//td[contains(text(),'SHREYAS_USER2')]/..//td//input[1]")).click();
Thread.sleep(3000);
if(!driver.findElements(By.name("submit1")).isEmpty());
{
	List<WebElement> exd = driver.findElements(By.name("submit1"));
	
	for(WebElement er:exd)
	{
		if(er.isDisplayed());
		{
			er.click();
			driver.switchTo().defaultContent();
			break;
		}
	}
	
}


	driver.findElement(By.id("submitId")).click();
	waitForElementToAppear(By.xpath("//input[@value='Click here to close the Window']"));

driver.findElement(By.xpath("//input[@value='Click here to close the Window']")).click();
Thread.sleep(3000);
Set<String> tamm=driver.getWindowHandles();
for(String ha1:tamm)
{
	driver.switchTo().window(ha1);
	driver.manage().window().maximize();
	String tit=driver.getTitle();
	
	if(tit.contains("WflLineDetail servlet"))
	{
		driver.switchTo().window(ha1);
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		Thread.sleep(4000);
		break;
	}
}


driver.findElement(By.id("submitId")).click();
waitForElementToAppear(By.xpath("//input[@value='Click here to close the Window']"));

driver.findElement(By.xpath("//input[@value='Click here to close the Window']")).click();


//********************************************
Thread.sleep(4000);
Set<String> gst5 = driver.getWindowHandles();
for(String eone:gst5)
{
	driver.switchTo().window(eone);
	driver.manage().window().maximize();
	String title1=driver.getTitle();
	if(title1.contains("TenderWizard"))
	{
driver.switchTo().window(eone);
driver.manage().window().maximize();
break;
	}
}


driver.switchTo().defaultContent();

WebElement righ12 = driver.findElement(Right_Frame);   
	
 driver.switchTo().frame(righ12);
 waitForElementToAppear(By.id("submitId"));
	
	
	driver.findElement(By.id("submitId")).click();
	
	   }
	   catch(Exception e)
	   {
		   e.printStackTrace();
		   Assert.fail("failed to mecon buy "+e.getMessage());
	}
   } 
	   
   public void addWorkFlowUsers_Level_Based(SoftAssert sa, String workflowID) throws Exception                         
   {
		JavascriptExecutor executor = (JavascriptExecutor)driver;                 
	   Thread.sleep(3000);
	     FS=PageFactory.initElements(driver, Frame_Switch_Pop_Up.class);  
		  driver.switchTo().defaultContent();
		  FS.Right(sa);   
		log.info("Switch to Right Frame");
		Thread.sleep(3000);
	waitForElementToAppear(briefcase);
	WebElement WFL_LD =  driver.findElement(briefcase);
	executor.executeScript("arguments[0].click();", WFL_LD);    
	log.info("WFL Line Detail Clicked");
	driver.switchTo().defaultContent();
	  FS.Right(sa);       
	log.info("Switch to Right Frame");
	Thread.sleep(3000);                
	if(driver.findElement(Header).isDisplayed())    
 	{
		log.info("Header is Matching");
		waitForElementToAppear(tender_approval1);
		WebElement tech_Open=driver.findElement(tender_approval1);
		Select s=new Select(tech_Open);
		s.selectByVisibleText(workflowID);
		WebElement cost_Open=driver.findElement(tender_approval2);
		Select s1=new Select(cost_Open);
		s1.selectByVisibleText(workflowID);
		WebElement Bid_Approval_Tech=driver.findElement(bid_approval1);
		Select s2=new Select(Bid_Approval_Tech);    
		s2.selectByVisibleText(workflowID);
		WebElement Bid_Approval_Cost=driver.findElement(bid_approval2);
		Select s3=new Select(Bid_Approval_Cost);     
		s3.selectByVisibleText(workflowID);
		Thread.sleep(2000);       
		log.info("WFL ID's Selected");
		WebElement Submit_but = driver.findElement(submit);
		executor.executeScript("arguments[0].click();", Submit_but);                
		log.info("Submitted");   
		Thread.sleep(2000);                 
		add_Users1(sa);  
		log.info("User Added to Tech Open Approval");        
		FS.Right(sa);   
		log.info("Switch to Right Frame"); 
		add_Users2(sa);    
		log.info("User Added to Cost Open Approval");
		FS.Right(sa);   
		log.info("Switch to Right Frame");
		add_Users3(sa);
		log.info("User Added to Tech Bid Approval");
		FS.Right(sa);   
		log.info("Switch to Right Frame");
		add_Users4(sa);
		log.info("User Added to Cost Bid Approval");
		FS.Right(sa);   
		log.info("Switch to Right Frame");          
		WebElement sub = driver.findElement(submit);
		executor.executeScript("arguments[0].click();", sub);  
		log.info("Submit Button Clicked");         
	}
	else
	{
		sa.fail("Header Mismatch");
	}
   }
   //public static By selectUser1=By.id("TECHNICAL_WORK_ID_img");
	//public static By selectUser2=By.id("COST_WORK_ID_img");
	//public static By selectUser3=By.id("BID_TECH_WORK_ID_img");
	//public static By selectUser4=By.id("BID_COST_WORK_ID_img");
   
   public void add_Users1(SoftAssert sa) throws Exception                      
   {
		JavascriptExecutor executor = (JavascriptExecutor)driver;                     
	   Thread.sleep(3000);
		WebElement selectUser = driver.findElement(selectUser1);
	executor.executeScript("arguments[0].click();", selectUser);                    
	Thread.sleep(3000);
	log.info("Select Users Clicked");
	select_Users(sa);
	log.info("Users Selected");
}
   public void add_Users2(SoftAssert sa) throws Exception                      
   {
		JavascriptExecutor executor = (JavascriptExecutor)driver;                     
	   Thread.sleep(3000);
		WebElement selectUser = driver.findElement(selectUser2);
	executor.executeScript("arguments[0].click();", selectUser);                    
	Thread.sleep(3000);     
	log.info("Select Users Clicked");
	select_Users(sa);
	log.info("Users Selected");    
}
   public void add_Users3(SoftAssert sa) throws Exception                      
   {
		JavascriptExecutor executor = (JavascriptExecutor)driver;                     
	   Thread.sleep(3000);
		WebElement selectUser = driver.findElement(selectUser3);
	executor.executeScript("arguments[0].click();", selectUser);                       
	Thread.sleep(3000);     
	log.info("Select Users Clicked");
	select_Users(sa);
	log.info("Users Selected");
}
   public void add_Users4(SoftAssert sa) throws Exception                      
   {
		JavascriptExecutor executor = (JavascriptExecutor)driver;                     
	   Thread.sleep(3000);
		WebElement selectUser = driver.findElement(selectUser4);     
	executor.executeScript("arguments[0].click();", selectUser);                       
	Thread.sleep(3000);     
	log.info("Select Users Clicked");
	select_Users(sa);
	log.info("Users Selected");    
}
   public void select_Users(SoftAssert sa) throws Exception                      
   {
	JavascriptExecutor executor = (JavascriptExecutor)driver;                     
   Set<String> hand = driver.getWindowHandles();
	log.info("Title1: " + hand);           
	for(String ha:hand)    
	{           
		driver.switchTo().window(ha);
		String tit=driver.getTitle();
		log.info("Title2: " + tit);     
		if(tit.contains("WflLineDetail servlet"))
		{
			driver.switchTo().window(ha);
			driver.manage().window().maximize();
			//User 1   
			waitForElementToAppear(By.xpath("(//table)[2]//tbody//tr[2]//td[4]//img[@alt='Click here to select the User']"));
			Thread.sleep(3000);     
			javaScriptClick(driver.findElement(By.xpath("(//table)[2]//tbody//tr[2]//td[4]//img[@alt='Click here to select the User']")));
			Thread.sleep(3000);      
			waitForElementToAppear(By.xpath("//td[@id='light_content']//iframe"));     
			WebElement e2=driver.findElement(By.xpath("//td[@id='light_content']//iframe"));
			driver.switchTo().frame(e2);
			Thread.sleep(3000);
			waitForElementToAppear(By.xpath("//td[contains(text(),'LEVEL1_SHREYAS')]/..//td//input[1]"));
			driver.findElement(By.xpath("//td[contains(text(),'LEVEL1_SHREYAS')]/..//td//input[1]")).click();      
			Thread.sleep(3000); 
			log.info("User Selected");
			driver.switchTo().window(ha);
			
			//User 2
			waitForElementToAppear(By.xpath("(//table)[2]//tbody//tr[3]//td[4]//img[@alt='Click here to select the User']"));
			Thread.sleep(3000);     
			javaScriptClick(driver.findElement(By.xpath("(//table)[2]//tbody//tr[3]//td[4]//img[@alt='Click here to select the User']")));
			Thread.sleep(3000);      
			waitForElementToAppear(By.xpath("//td[@id='light_content']//iframe"));     
			WebElement e3=driver.findElement(By.xpath("//td[@id='light_content']//iframe"));
			driver.switchTo().frame(e3);   
			Thread.sleep(3000);
			waitForElementToAppear(By.xpath("//td[contains(text(),'LEVEL2_SHREYAS')]/..//td//input[1]"));
			driver.findElement(By.xpath("//td[contains(text(),'LEVEL2_SHREYAS')]/..//td//input[1]")).click();      
			Thread.sleep(3000);
			log.info("User Selected");
			driver.switchTo().window(ha);
			
			//User 3
			waitForElementToAppear(By.xpath("(//table)[2]//tbody//tr[4]//td[4]//img[@alt='Click here to select the User']"));
			Thread.sleep(3000);     
			javaScriptClick(driver.findElement(By.xpath("(//table)[2]//tbody//tr[4]//td[4]//img[@alt='Click here to select the User']")));
			Thread.sleep(3000);      
			waitForElementToAppear(By.xpath("//td[@id='light_content']//iframe"));     
			WebElement e4=driver.findElement(By.xpath("//td[@id='light_content']//iframe"));
			driver.switchTo().frame(e4);       
			Thread.sleep(3000);
			waitForElementToAppear(By.xpath("//td[contains(text(),'LEVEL3_SHREYAS')]/..//td//input[1]"));
			driver.findElement(By.xpath("//td[contains(text(),'LEVEL3_SHREYAS')]/..//td//input[1]")).click();      
			Thread.sleep(3000); 
			log.info("User Selected");
			driver.switchTo().window(ha);
			log.info("User Selected");
			if(!driver.findElements(By.name("submit1")).isEmpty());
			{
				List<WebElement> exd = driver.findElements(By.name("submit1"));   
				
				for(WebElement er:exd)
				{
					if(er.isDisplayed());
					{
						executor.executeScript("arguments[0].click();", er);    
						log.info("Submitted Button Clicked");     
						WebElement Close_But = driver.findElement(By.xpath("//input[@value='Click here to close the Window']"));
						executor.executeScript("arguments[0].click();", Close_But);  
						log.info("Close Button Clicked");  
					   Set<String> allWindows = driver.getWindowHandles();
					   for(String currentWindow : allWindows)
					   {
					      driver.switchTo().window(currentWindow);
							log.info("Switched to current window");  
					   }   
					   
					}                     
				}
				 
			}
		}
}
   }
}