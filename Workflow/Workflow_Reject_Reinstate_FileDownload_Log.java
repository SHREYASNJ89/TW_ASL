package Workflow; 
            
import java.io.File;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import Listeners.MessageBoard;
import Listeners.RandomString;
import Listeners.Scroll_Horizontal_Vertical;
import TenderAuctionSearch.TenderSearchOpen;
import TenderCreation.BasePage;
import generic.Auto_const;

public class Workflow_Reject_Reinstate_FileDownload_Log extends BasePage implements Auto_const
{
	static By WFL_Line_Detail=By.xpath("//img[@alt='WorkFlow Line Detail']"); 
	static By WFL_Reinstate=By.xpath("//img[@title='REINSTATE WORKFLOW:Level-1']");
	static By File_Upload=By.xpath("//input[@id='reInitFile']");
	static By File_Upload_Submit=By.xpath("//input[@value='Submit']");         
	static By Right_Frame=By.xpath("//iframe[@name='right']");                
	static By Bid_Approval=By.xpath("//img[@alt='Bid Approval']"); 
	static By Action_Button=By.xpath("//input[@id='btnAction1'] | //input[@id='btnAction']");   
	static By Bid_Approval_Icon=By.xpath("//img[@alt='Bid Approval']");
	static By Bid_Approval_REinstate=By.xpath("(//a[contains(text(),'Re-initiate')])[1]");
	static By Bid_Approval_Reject=By.xpath("//a[contains(text(),'Reject')]");
	static By Edit_Attachment=By.xpath("//img[@alt='EDIT ATTACHMENTS:Level-1']");
	static By Log_Details=By.xpath("(//a[contains(text(),'Log Details')])[1]");
	static By Bid_Approval_Tech_Log=By.xpath("(//a[contains(text(),'Bid Approval Log Details')])[1]");
	static By Bid_Approval_Cost_Log=By.xpath("(//a[contains(text(),'Bid Approval Log Details')])[2]");
	static By Open_Approval_Tech_Log=By.xpath("(//a[contains(text(),'Tender Open Approval Log Details')])[2]");
	static By Open_Approval_Cost_Log=By.xpath("(//a[contains(text(),'Tender Open Approval Log Details')])[2]");
	static By Bid_Approval_Attachments=By.xpath("(//a[contains(text(),'Attachment')])[1]");
	static By Attachment_New=By.xpath("//input[@value='New']");
	static By Attachment_Choose_File=By.xpath("//input[@id='userFile']");
	static By Attachment_Choose_Description=By.xpath("//textarea[@name='description']");
	static By Attachment_Choose_Upload_File=By.xpath("//input[@value='Upload File']");
	static By Attachment_Go_Back=By.xpath("//input[@value='Go Back']");
	static By Attachment_Go_Back2=By.xpath("(//input[@type='button'])[4]");
	static By Attachment_File_Download_Link=By.xpath("((//a[@class='td_Summarylink1'])[2] | //tr[@id='ref']//td[7]//a)[2]");     
	static By Attachment_File_Download_Link1=By.xpath("((//a[@class='td_Summarylink1'])[1] | //tr[@id='ref']//td[7]//a)[1]");     
	static By Rejected_status_Header=By.xpath("//td[contains(text(),'Rejected')]"); 
	static By Reject_status_Notings_page=By.xpath("(//td[contains(text(),'Reject')])[2]"); 
	static By Bid_Approval_Icon1=By.xpath("//img[@alt='Bid Approval']");     
	static By Notings_TB=By.xpath("//div[@id='sourceText']"); 
	static By Remarks_TB=By.xpath("//textarea[@name='remarks']"); 
	static By Action_button=By.xpath("//input[@id='btnAction']"); 
	static By Update_Update_Modify=By.xpath("//a[contains(text(),'Update')] | //a[contains(text(),'Update/Modify')]"); 
	static By Go_To_Edit_Attachment=By.xpath("//a[contains(text(),'Go to Edit Attachment')]"); 
	static By Go_To_Bid_Detail=By.xpath("//a[contains(text(),'Go to Bid Detail')]"); 
	static By Check_Box1=By.xpath("(//input[@name='inputCheck'])[1]"); 
	static By Submit_Button=By.xpath("(//input[@name='submit1'])[1]");  
	static By Show_Form=By.xpath("(//img[@id='showformlink'])[1]");  
	static By Bid_Doc_Tab=By.xpath("//a[contains(text(),'Bid Documents')]");  
	static By Check_Box2=By.xpath("(//input[@name='inputCheck'])[1]");  
	static By Attach_Vendor_Doc=By.xpath("//input[@value='Attach Vendor Documents-WFL']");
	static By Random_on_Page=By.xpath("(//tr[@id='ref']//td[8])[1]");   
	static By Upload_Rich_Text=By.xpath("//div[@id='btnAction_menu']//a[contains(text(),'Upload')]");    
	static By Upload_Rich_Text_New_Button=By.xpath("//input[@value='New']");
	
	public static MessageBoard MB; 
	public static Scroll_Horizontal_Vertical Scroll; 

private static Logger log = Logger.getLogger(Workflow_Reject_Reinstate_FileDownload_Log.class); 

public Workflow_Reject_Reinstate_FileDownload_Log(WebDriver driver)
{
	super(driver);  
} 
public  void Pop_up(SoftAssert sa) throws Exception  
{ 
	Thread.sleep(3000); 
	String pop_up_text = driver.switchTo().alert().getText();
	Thread.sleep(3000);
	log.info("Pop-up alert upon clicking send button is: " +pop_up_text);
	if(pop_up_text.equalsIgnoreCase("Work flow will be Reinstated, do you want to proceed?"))
	{
		Thread.sleep(3000);
		log.info("Pop-up alert content is matching"); 
	}
	else
	{
		Thread.sleep(3000);
	   		sa.fail("Pop-up alert content mismatch");
	}  
	Thread.sleep(3000);
	driver.switchTo().alert().accept();
	Thread.sleep(3000);
	log.info("Pop-up alert Closed Successfully");
}
public  void File_Upload(SoftAssert sa) throws Exception  
{
	Thread.sleep(5000);
	String path1=new java.io.File(".").getCanonicalPath(); 
	WebElement el= driver.findElement(File_Upload); 
    Actions acc =  new Actions(driver);
    acc.moveToElement(el).click().perform();
    Thread.sleep(20000);
    Runtime.getRuntime().exec(NormalUploadA+" "+path1+"\\Bids\\tenderwizard3.xls");                                                          
    Thread.sleep(50000);  
    WebElement submit = driver.findElement(File_Upload_Submit);
    submit.click();
	Thread.sleep(5000); 
}
//R5 
public  void Workflow_Reinstate(SoftAssert sa) throws Exception
{
driver.switchTo().defaultContent();
WebElement ele = driver.findElement(Right_Frame);  
driver.switchTo().frame(ele);
log.info("Switched to Right Frame Successfully");	
if(driver.findElement(WFL_Line_Detail).isDisplayed())
{
	log.info("WFL Line Detail icon Present");
	driver.findElement(WFL_Line_Detail).click();
	log.info("WFL Line Detail Icon Clicked Successfully");	
	if(driver.findElement(WFL_Reinstate).isDisplayed())
	{
		log.info("WFL Reinstate icon Present");
		driver.findElement(WFL_Reinstate).click(); 
		log.info("WFL Reinstate Icon Clicked Successfully");
		Thread.sleep(3000); 
		Pop_up(sa);
		log.info("Pop-up Handled Successfully");
		Thread.sleep(3000);  
		File_Upload(sa);
		Thread.sleep(10000);   
		log.info("File Upload Handled Successfully");	
	}
	else
	{
		sa.fail("WFL Reinstate icon not present");
	}
}
else
{
	sa.fail("WFL Line Detail icon not present");
}
}
public  void Workflow_Reinstate_Verification(SoftAssert sa) throws Exception
{
	if(driver.findElements(WFL_Reinstate).isEmpty())
	{
		log.info("WFL Reinstated Successfully");
}
	else
	{
		sa.fail("WFL Reinstated Unsuccessful");  
	}
}
public  void Workflow_Notings_Reject(SoftAssert sa) throws Exception   
{      
	RandomString randomstring=new RandomString(driver);
	String r1 = randomstring.randomString();
	driver.switchTo().defaultContent();
	WebElement ele = driver.findElement(Right_Frame);  
	driver.switchTo().frame(ele);
	log.info("Switched to Right Frame Successfully");	  
	waitForElementToAppear(Bid_Approval_Icon);
	driver.findElement(Bid_Approval_Icon).click();
	waitForElementToAppear(By.xpath("//input[@name='notingNo']"));
	WebElement etr=driver.findElement(By.xpath("//input[@name='notingNo']"));
	etr.sendKeys(r1+"costBidApprovalEntered");
	waitForElementToAppear(By.xpath("//textarea[@name='remarks']"));
	WebElement etr1=driver.findElement(By.xpath("//textarea[@name='remarks']"));
	etr1.sendKeys("costbidApproval"+r1+"remarksentered");
	driver.findElement(By.xpath("//input[@value='Update']")).click();
	Thread.sleep(2000);
	waitForElementToAppear(By.xpath("//input[@name='nextStep']"));
	WebElement rock=driver.findElement(By.xpath("//input[@name='nextStep']"));               
	Actions act=new Actions(driver);
	act.moveToElement(rock).perform();
	Thread.sleep(2000);
	waitForElementToAppear(Bid_Approval_Reject);
	WebElement cli=	driver.findElement(Bid_Approval_Reject);
	JavascriptExecutor executor = (JavascriptExecutor)driver;  
	executor.executeScript("arguments[0].click();", cli);
	Thread.sleep(2000);
	waitForAlertToAppear();
	Alert a =driver.switchTo().alert();  
	a.accept();
	Thread.sleep(8000);
}
public  void Workflow_Notings_Reinstate(SoftAssert sa) throws Exception
{
	driver.switchTo().defaultContent();
	WebElement ele = driver.findElement(Right_Frame);  
	driver.switchTo().frame(ele);
	log.info("Switched to Right Frame Successfully");	  
	waitForElementToAppear(Bid_Approval_Icon);
	driver.findElement(Bid_Approval_Icon).click();
	Thread.sleep(2000);
	waitForElementToAppear(Action_Button);
	WebElement rock=driver.findElement(Action_Button);  
	Actions act=new Actions(driver);
	act.moveToElement(rock).perform();
	Thread.sleep(2000);
	waitForElementToAppear(Bid_Approval_REinstate);    
 	WebElement cli=	driver.findElement(Bid_Approval_REinstate);
	JavascriptExecutor executor = (JavascriptExecutor)driver;  
	executor.executeScript("arguments[0].click();", cli);
	Thread.sleep(2000);  
	waitForAlertToAppear();
	Alert a =driver.switchTo().alert();  
	a.accept();
	Thread.sleep(8000);
}
public  void Workflow_Notings_Approval(SoftAssert sa) throws Exception
{
	RandomString randomstring=new RandomString(driver);
	String r1 = randomstring.randomString();
	waitForElementToAppear(Bid_Approval_Icon);
	driver.findElement(Bid_Approval_Icon).click();
	waitForElementToAppear(By.xpath("//input[@name='notingNo']"));
	WebElement etr=driver.findElement(By.xpath("//input[@name='notingNo']"));
	etr.sendKeys(r1+"costBidApprovalEntered");
	waitForElementToAppear(By.xpath("//textarea[@name='remarks']"));
	WebElement etr1=driver.findElement(By.xpath("//textarea[@name='remarks']"));
	etr1.sendKeys("costbidApproval"+r1+"remarksentered");
	driver.findElement(By.xpath("//input[@value='Update']")).click();
	Thread.sleep(2000);
	waitForElementToAppear(By.xpath("//input[@name='nextStep']"));
	WebElement rock=driver.findElement(By.xpath("//input[@name='nextStep']"));
	Actions act=new Actions(driver);
	act.moveToElement(rock).perform();
	Thread.sleep(2000);
	waitForElementToAppear(By.xpath("//a[contains(text(),'Approve')]"));
	WebElement cli=	driver.findElement(By.xpath("//a[contains(text(),'Approve')]"));
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	executor.executeScript("arguments[0].click();", cli);
	Thread.sleep(2000);
	waitForAlertToAppear();
	Alert a =driver.switchTo().alert();
	a.accept();
	Thread.sleep(8000);	
}
public  void Workflow_Notings_Reject_Rich_Text_Editor(SoftAssert sa) throws Exception   
{      
	RandomString randomstring=new RandomString(driver);
	 String r1 = randomstring.randomString();

	 waitForElementToAppear(By.xpath("//img[@alt='Bid Approval']"));
	 driver.findElement(By.xpath("//img[@alt='Bid Approval']")).click();

	 //enter notings number
	 waitForElementToAppear(By.xpath("//div[@id='sourceText']"));
	 WebElement etr=driver.findElement(By.xpath("//div[@id='sourceText']"));
	 etr.sendKeys(r1);

	 //Enter Remarks
	 waitForElementToAppear(By.xpath("//textarea[@name='remarks']"));
	 WebElement etr1=driver.findElement(By.xpath("//textarea[@name='remarks']"));
	 etr1.sendKeys("technicalBidApproval"+r1+"enteredSuccessfully");

	 //move mouse to Actions and select update from drop down
	 Thread.sleep(2000);
	 waitForElementToAppear(By.xpath("//input[@id='btnAction']"));
	 WebElement action=driver.findElement(By.xpath("//input[@id='btnAction']"));
	 Actions act=new Actions(driver);
	 act.moveToElement(action).perform();
	 waitForElementToAppear(By.xpath("//a[contains(text(),'Update/Modify')]"));
	 WebElement click= driver.findElement(By.xpath("//a[contains(text(),'Update/Modify')]"));   
	 javaScriptClick(click);
	 Thread.sleep(2000);
	 
	//click on Approve
	 waitForElementToAppear(By.xpath("//input[@id='btnAction']"));
	 WebElement action_approve=driver.findElement(By.xpath("//input[@id='btnAction']"));
	 Actions act2=new Actions(driver);
	 act2.moveToElement(action_approve).perform();
	 waitForElementToAppear(By.xpath("//a[contains(text(),'Reject')]"));
	 WebElement click4= driver.findElement(By.xpath("//a[contains(text(),'Reject')]"));  
	 javaScriptClick(click4);
	 waitForAlertToAppear();
	 Alert a=driver.switchTo().alert();
	 a.accept();  
Thread.sleep(2000);    

}
public  void Workflow_Notings_Reinstate_Rich_Text_Editor(SoftAssert sa) throws Exception  
{
	driver.switchTo().defaultContent();
	WebElement ele = driver.findElement(Right_Frame);  
	driver.switchTo().frame(ele);
	log.info("Switched to Right Frame Successfully");	  
	waitForElementToAppear(Bid_Approval_Icon);
	driver.findElement(Bid_Approval_Icon).click();
	Thread.sleep(2000);
	log.info("Bid Approval icon Clicked Successfully");	  
	if(driver.findElement(Rejected_status_Header).isDisplayed())
	{
		log.info("Status is Matching");
		if(driver.findElement(Reject_status_Notings_page).isDisplayed())   
		{
			log.info("Status is Matching");
			waitForElementToAppear(Action_Button);
			WebElement rock=driver.findElement(Action_Button);  
			Actions act=new Actions(driver);
			act.moveToElement(rock).perform();
			Thread.sleep(2000);
			waitForElementToAppear(Bid_Approval_REinstate);    
		 	WebElement cli=	driver.findElement(Bid_Approval_REinstate);    
			JavascriptExecutor executor = (JavascriptExecutor)driver;  
			executor.executeScript("arguments[0].click();", cli);
			Thread.sleep(2000);  
			waitForAlertToAppear();
			Alert a =driver.switchTo().alert();  
			a.accept();
			Thread.sleep(8000);  
		}
		else
		{
			sa.fail("Status Mismatch");
		}
	}
	else
	{
		sa.fail("Status Mismatch");
	} 
}
public  void Workflow_Logs(SoftAssert sa) throws Exception
{
	driver.switchTo().defaultContent();
	WebElement ele = driver.findElement(Right_Frame);  
	driver.switchTo().frame(ele);
	log.info("Switched to Right Frame Successfully");	  
	waitForElementToAppear(Edit_Attachment);
	driver.findElement(Edit_Attachment).click();
	Thread.sleep(2000);
	log.info("Edit Attachment Clicked Successfully");	  
	driver.findElement(Log_Details).click();
	log.info("Log Details in AAC Screen Clicked Successfully");	  
	driver.switchTo().frame(ele);
	log.info("Switched to Right Frame Successfully");	  
    driver.findElement(Bid_Approval_Tech_Log).isDisplayed(); 
	log.info("Technocommercial Bid Approval Log Link Verified Successfully");	  
    driver.findElement(Bid_Approval_Cost_Log).isDisplayed();
	log.info("Cost Bid Approval Log Link Verified Successfully");	  
    driver.findElement(Open_Approval_Tech_Log).isDisplayed();
	log.info("Technocommercial Open Approval Log Link Verified Successfully");	  
    driver.findElement(Open_Approval_Cost_Log).isDisplayed();
	log.info("Cost Open Approval Log Link Verified Successfully");	    
}   
public  void Workflow_File_Download(SoftAssert sa) throws Exception   
{
	RandomString randomstring=new RandomString(driver);          
	String r1 = randomstring.randomString();
	driver.switchTo().defaultContent();
	WebElement ele = driver.findElement(Right_Frame);  
	driver.switchTo().frame(ele);
	log.info("Switched to Right Frame Successfully");	  
	waitForElementToAppear(Bid_Approval_Icon);   
	driver.findElement(Bid_Approval_Icon).click();
	waitForElementToAppear(By.xpath("//input[@name='notingNo']"));
	WebElement etr=driver.findElement(By.xpath("//input[@name='notingNo']"));
	etr.sendKeys(r1+"costBidApprovalEntered");
	waitForElementToAppear(By.xpath("//textarea[@name='remarks']"));
	WebElement etr1=driver.findElement(By.xpath("//textarea[@name='remarks']"));
	etr1.sendKeys("costbidApproval"+r1+"remarksentered");
	driver.findElement(By.xpath("//input[@value='Update']")).click();
	Thread.sleep(5000);   
	waitForElementToAppear(Action_Button);
	WebElement rock=driver.findElement(Action_Button);  
	Actions act=new Actions(driver);
	act.moveToElement(rock).perform();
	Thread.sleep(2000);
	waitForElementToAppear(Bid_Approval_Attachments);    
 	WebElement cli=	driver.findElement(Bid_Approval_Attachments);  
	JavascriptExecutor executor = (JavascriptExecutor)driver;  
	executor.executeScript("arguments[0].click();", cli);
	Thread.sleep(5000); 
	log.info("Attachments Clicked Successfully");
	driver.switchTo().defaultContent();  
	driver.switchTo().frame(ele); 
	log.info("Switched to Right Frame Successfully");
 	WebElement New1 = driver.findElement(Attachment_New);  
 	executor.executeScript("arguments[0].click();", New1);     
	Thread.sleep(2000);
	log.info("New Button Clicked Successfully");
 	WebElement Description = driver.findElement(Attachment_Choose_Description);  
 	Description.sendKeys("TESTING Description"); 
	Thread.sleep(2000);
	log.info("Description Updated Successfully");   
	//File Upload
	Thread.sleep(5000);
	String path1=new java.io.File(".").getCanonicalPath(); 
	WebElement el= driver.findElement(Attachment_Choose_File); 
    Actions acc =  new Actions(driver);
    acc.moveToElement(el).click().perform();
    Thread.sleep(20000);
    Runtime.getRuntime().exec(NormalUploadA+" "+path1+"\\Bids\\WFLUP1.xls");                                          
    Thread.sleep(50000);   
    WebElement submit = driver.findElement(Attachment_Choose_Upload_File); 
    submit.click();
	Thread.sleep(5000);   
	WebElement Go_Back = driver.findElement(Attachment_Go_Back);  
 	executor.executeScript("arguments[0].click();", Go_Back);  
	Thread.sleep(5000);   
	log.info("Go Back Button Clicked Successfully");   	
}
public void verifydownload(int j) throws Exception
{   
	Thread.sleep(5000);       
	driver.switchTo().defaultContent();  
	WebElement ele = driver.findElement(Right_Frame);  
	driver.switchTo().frame(ele);
	log.info("Switched to Right Frame Successfully");         
	Thread.sleep(3000);  
	WebElement Download_Link = driver.findElement(Attachment_File_Download_Link1);                          
	JavascriptExecutor executor = (JavascriptExecutor)driver;  
 	executor.executeScript("arguments[0].click();", Download_Link);         
 	String Text1 = Download_Link.getText();
	log.info("File Name: " + Text1); 
	Thread.sleep(5000); 
	File F;
	if(j==0){
	F = new File("C:/Users/shreyasn/Downloads/"+Text1);    
	}
	else{
		F = new File("C:/Users/shreyasn/Downloads/VDOC_"+Text1);         
	} 
	if(F.exists())    
			{
		Thread.sleep(3000); 
		log.info("File exists"); 
		Thread.sleep(3000);
		F.delete();
			}
	else
	{ 
		log.info("File does not exist");
	}
}   

public void verifydownload_BidDetail(int j) throws Exception
{  
	driver.switchTo().defaultContent();  
	WebElement ele = driver.findElement(Right_Frame);  
	driver.switchTo().frame(ele);
	log.info("Switched to Right Frame Successfully");
	Thread.sleep(3000);    
	WebElement Download_Link = driver.findElement(Attachment_File_Download_Link1);    
	JavascriptExecutor executor = (JavascriptExecutor)driver;  
 	executor.executeScript("arguments[0].click();", Download_Link);  
 	String Text1 = Download_Link.getText();
	log.info("File Name: " + Text1);      
	Thread.sleep(5000); 
	File F;
	if(j==0){
	F = new File("C:/Users/shreyasn/Downloads/"+Text1);    
	}
	else{
		F = new File("C:/Users/shreyasn/Downloads/VDOC_"+Text1); 
	} 
	if(F.exists())    
			{
		Thread.sleep(3000); 
		log.info("File exists"); 
		Thread.sleep(3000);
		F.delete();
			}
	else
	{ 
		log.info("File does not exist");
	}
}

public void Workflow_Rich_Text_Document_Attach_Go_To_Edit_Attachment(SoftAssert sa) throws Exception 
{
	 RandomString randomstring=new RandomString(driver);   
	 String r1 = randomstring.randomString(); 

	 waitForElementToAppear(Bid_Approval_Icon1);
	 driver.findElement(Bid_Approval_Icon1).click(); 

	 //enter notings number
	 waitForElementToAppear(Notings_TB);
	 WebElement etr=driver.findElement(Notings_TB); 
	 etr.sendKeys(r1);

	 //Enter Remarks
	 waitForElementToAppear(Remarks_TB);
	 WebElement etr1=driver.findElement(Remarks_TB); 
	 etr1.sendKeys("technicalBidApproval"+r1+"enteredSuccessfully");

	 //move mouse to Actions and select update from drop down
	 Thread.sleep(2000);
	 waitForElementToAppear(Action_button);
	 WebElement action=driver.findElement(Action_button); 
	 Actions act=new Actions(driver);
	 act.moveToElement(action).perform();
	 waitForElementToAppear(Update_Update_Modify);
	 WebElement click= driver.findElement(Update_Update_Modify); 
	 javaScriptClick(click);
	 Thread.sleep(2000);


	 // click on edit attachment[contains(text(),'Go to Edit Attachment')]
	 waitForElementToAppear(Action_button);
	 WebElement action_edit=driver.findElement(Action_button);  
	 Actions act1=new Actions(driver);
	 act1.moveToElement(action_edit).perform();
	 waitForElementToAppear(Go_To_Edit_Attachment);
	 WebElement click1= driver.findElement(Go_To_Edit_Attachment); 
	 javaScriptClick(click1);
	 Thread.sleep(5000);
	 
	 driver.switchTo().defaultContent();
	 WebElement ele = driver.findElement(By.xpath("//iframe[@name='right']"));   
	 driver.switchTo().frame(ele);      

	 //Click on first check box to attach the doc
	 waitForElementToAppear(Check_Box1);
	 WebElement click2= driver.findElement(Check_Box1);  
	 javaScriptClick(click2); 
	 //click2.click();
	 Thread.sleep(2000);
	
	 //click on attach tender documents

	 waitForElementToAppear(Submit_Button);
	 WebElement click3= driver.findElement(Submit_Button);  
	javaScriptClick(click3);
	 //click3.click();  
	 Thread.sleep(2000);
}

public void Workflow_Rich_Text_Document_Attach_Go_To_Bid_Detail(SoftAssert sa) throws Exception 
{
	 waitForElementToAppear(Action_button);
	 WebElement action_edit=driver.findElement(Action_button);  
	 Actions act1=new Actions(driver);
	 act1.moveToElement(action_edit).perform();
	 waitForElementToAppear(Go_To_Bid_Detail);
	 WebElement click1= driver.findElement(Go_To_Bid_Detail); 
	 javaScriptClick(click1);
	 Thread.sleep(5000);
	 
	 driver.switchTo().defaultContent();
	 driver.switchTo().frame("right"); 

	 waitForElementToAppear(Show_Form);
	 WebElement click2= driver.findElement(Show_Form);  
	 javaScriptClick(click2); 
	 Thread.sleep(2000);
	 
	 driver.switchTo().defaultContent();
	 WebElement ele = driver.findElement(By.xpath("//iframe[@name='right']"));   
	 driver.switchTo().frame(ele);      
	 
	 waitForElementToAppear(Bid_Doc_Tab);
	 WebElement click3= driver.findElement(Bid_Doc_Tab);  
	 javaScriptClick(click3);      
	 Thread.sleep(2000);
	 
	 waitForElementToAppear(Check_Box2);
	 WebElement click4= driver.findElement(Check_Box2);   
	 javaScriptClick(click4);     
	 Thread.sleep(2000);

	 waitForElementToAppear(Attach_Vendor_Doc);
	 WebElement click5= driver.findElement(Attach_Vendor_Doc);  
	 javaScriptClick(click5);      
	 Thread.sleep(2000);		
}        

public  void File_Upload_Rich_Text(SoftAssert sa) throws Exception         
{
	 waitForElementToAppear(Action_button);
	 WebElement action_edit=driver.findElement(Action_button);  
	 Actions act1=new Actions(driver);
	 act1.moveToElement(action_edit).perform();
	 waitForElementToAppear(Upload_Rich_Text);
	 WebElement click1= driver.findElement(Upload_Rich_Text);       
	 javaScriptClick(click1);
	 Thread.sleep(5000);
	 
	 driver.switchTo().defaultContent();
	 WebElement ele = driver.findElement(By.xpath("//iframe[@name='right']"));   
	 driver.switchTo().frame(ele);                            
	Thread.sleep(5000);
	waitForElementToAppear(Upload_Rich_Text_New_Button);
	 WebElement New_button=driver.findElement(Upload_Rich_Text_New_Button); 
	 javaScriptClick(New_button);   
		Thread.sleep(5000); 
		log.info("New Button Clicked Successfully");   
	 	WebElement Description = driver.findElement(Attachment_Choose_Description);  
	 	Description.sendKeys("TESTING Description"); 
		Thread.sleep(2000);
		log.info("Description Updated Successfully");   
		//File Upload
		Thread.sleep(5000);
		String path1=new java.io.File(".").getCanonicalPath(); 
		WebElement el= driver.findElement(Attachment_Choose_File); 
	    Actions acc =  new Actions(driver);
	    acc.moveToElement(el).click().perform();
	    Thread.sleep(20000);
	    Runtime.getRuntime().exec(NormalUploadA+" "+path1+"\\Bids\\WFLUP3.xls");                                                                              
	    Thread.sleep(50000);   
	    WebElement submit = driver.findElement(Attachment_Choose_Upload_File); 
	    submit.click();
		Thread.sleep(5000);   
		WebElement Go_Back = driver.findElement(Attachment_Go_Back);     
		JavascriptExecutor executor = (JavascriptExecutor)driver;     
	 	executor.executeScript("arguments[0].click();", Go_Back);  
		Thread.sleep(3000);   
		log.info("Go Back Button Clicked Successfully");
		driver.switchTo().defaultContent();
   	 driver.switchTo().frame(ele);                 
	    Thread.sleep(3000);   
		WebElement Go_Back2 = driver.findElement(Attachment_Go_Back2);   
	 	executor.executeScript("arguments[0].click();", Go_Back2);             
		Thread.sleep(3000);       
		log.info("Go Back Button Clicked Successfully");     
}

//R6 changes     
static By Buyer_ID_Left_Menu=By.xpath("//div[@id='subDiv4']//p//u");  
static By Buyer_ID_Rich_Text2=By.xpath("(//tr[@id='ref'])[1]//td[8]");         
static By Buyer_User_Name_Rich_Text2=By.xpath("(//tr[@id='ref'])[1]//td[9]");  
static By Vendor_Comp_Name_Rich_Text2=By.xpath("(//tr[@id='ref'])[1]//td[3]");        
static By Buyer_ID_Rich_Text1=By.xpath("(//tr[@id='ref'])[2]//td[8]");         
static By Buyer_User_Name_Rich_Text1=By.xpath("(//tr[@id='ref'])[2]//td[9]");  
static By Vendor_Comp_Name_Rich_Text1=By.xpath("(//tr[@id='ref'])[2]//td[3]");   
static By Vendor_Comp_Name_BD=By.xpath("//tr[@class='odd']//td[@class='tdbodytext']//a");   
static By BD_Go_Back=By.xpath("//input[@value='Go Back']");      

   
public void Workflow_Rich_Text_Editor_Attach_Draft(SoftAssert sa) throws Exception  
{
    
}
public void Workflow_Rich_Text_Editor_User_Details(SoftAssert sa) throws Exception 
{
    
}
public void Workflow_Rich_Text_Editor_Vendor_Details(SoftAssert sa) throws Exception  
{
  	  
}

public void Workflow_Rich_Text_Editor_File_Attach_Details(SoftAssert sa) throws Exception 
{
  	  
}
}          