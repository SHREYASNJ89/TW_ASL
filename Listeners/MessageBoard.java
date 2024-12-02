package Listeners;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger; 
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners; 
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus; 

import TenderCreation.BasePage;
import generic.Auto_const;
import Listeners.Clarification_Module_Setup;
import Listeners.ReadJsonTestData;
import TenderAuctionSearch.TenderSearchInprogress;

public class MessageBoard extends BasePage implements Auto_const 
{
	static By Message_Board=By.xpath("//html//body//form//div[1]//div//h2[contains(text(),'Message Board')]"); 
	static By PreBid_Clarification_Module=By.xpath("//html//body//form//div[3]//table//tbody//tr[2]//td[2]//input"); 
	static By Negotiation_Clarification_Module=By.xpath("//html//body//form//div[3]//table//tbody//tr[3]//td[2]//input");
	static By Technical_Clarification_Module=By.xpath("//html//body//form//div[3]//table//tbody//tr[4]//td[2]//input"); 
	static By PreBid_Clarification_Module_Status=By.xpath("//select[@id='statusId1']");
	static By Negotiation_Clarification_Module_Status=By.xpath("//select[@id='statusId2']"); 
	static By Technical_Clarification_Module_Status=By.xpath("//select[@id='statusId3']");
	static By Message_Board_Submit =By.xpath("//input[@id='iButton']");
	static By Pre_bid_B2V_Email =By.xpath("//select[@id='BuyerEmailId1']"); 
	static By Pre_bid_V2B_Email =By.xpath("//select[@id='VendorEmailId1']");	
	static By Pre_bid_B2V_SMS =By.xpath("//select[@id='BuyerSMSid1']");	
	static By Pre_bid_V2B_SMS =By.xpath("//select[@id='VendorSMSid1']");	   
	static By Negotiation_B2V_Email =By.xpath("//select[@id='BuyerEmailId2']");
	static By Negotiation_V2B_Email =By.xpath("//select[@id='VendorEmailId2']");	
	static By Negotiation_B2V_SMS =By.xpath("//select[@id='BuyerSMSid2']");	
	static By Negotiation_V2B_SMS =By.xpath("//select[@id='VendorSMSid2']");	 
	static By Technical_Clarification_B2V_Email =By.xpath("//select[@id='BuyerEmailId3']");
	static By Technical_Clarification_V2B_Email =By.xpath("//select[@id='VendorEmailId3']");	
	static By Technical_Clarification_B2V_SMS =By.xpath("//select[@id='BuyerSMSid3']");	
	static By Technical_Clarification_V2B_SMS =By.xpath("//select[@id='VendorSMSid3']");
	static By Pre_Bid_Clarification_Icon =By.xpath("//img[@alt='Pre-Bid Meeting Clarification']"); 
	static By Pre_Bid_Clarification_Header =By.xpath("//html//body//div[1]//div[1]//div//h2"); 
	static By Clarification_Subject =By.xpath("//input[@name='MB_NT_MESSAGE_ID']"); 
	static By Pre_Bid_Clarification_Response_To =By.xpath("//select[@name='MB_NT_RECIPIENT']"); 
	static By Clarification_Message =By.xpath("//textarea[@name='MB_NT_SUBJECT']"); 
	static By Send_SMS =By.xpath("//select[@name='MB_NT_SMS_DATE']");
	static By Send_Email =By.xpath("//select[@name='MB_NT_EMAIL_DATE']");
	static By Clarification_Submit =By.xpath("//input[@value='Submit']");
	static By Clarification_Attachments =By.xpath("(//input[@value='Attachments'])[1]");
	static By Clarification_Attachments_Back =By.xpath("//input[@value='Back']");
	static By Choose_File=By.xpath("//input[@type='file']"); 
	static By Clarification_Send =By.xpath("//input[@id='Send']");  
	static By Clarification_Sent_Date =By.xpath("//th[contains(text(),'Sent Date')]");
	//static By Reply_Button =By.xpath("//input[@value='Reply']");
	//static By Reply_Button =By.xpath("//html//body//div[1]//div[2]//table//tbody//tr//td//table//tbody//tr[7]//td//table//tbody//tr[1]//td//form//table//tbody//tr[6]//td//input[2]");
	static By Reply_Button =By.xpath("//td//input[@value='Reply']"); 
	static By Clarification_Send_Buyer =By.xpath("//input[@id='send']"); 
	static By Clarification_Sent_Date1 =By.xpath("(//th[contains(text(),'Sent Date')])[2]");
	static By Qualified_Bidder =By.xpath("(//a[contains(text(),'Techno Commercial Open')])[2]");
	static By Technical_Clarification =By.xpath("//img[@alt='Technical Clarification']");
	static By Technical_Clarification_Header =By.xpath("//html//body//div[1]//div[1]//div//h2"); 
	static By Clarification_Reply_Due_date =By.xpath("(//input[@id='TECHNICAL_CLR_DATE'])[1]"); 
	static By Clarification_GoBack =By.xpath("(//input[@name='goback'])[1]");  
	static By Clarification_GoBack_Vendor =By.xpath("(//input[@name='goback'])[3]");  
	static By Qualified_Bidder_Cost =By.xpath("(//a[contains(text(),'Cost Open')])[2]"); 
	static By Negotiation_Clarification_Icon =By.xpath("//img[@alt='Negotiation Clarification']");
	static By Negotiation_Clarification_Header =By.xpath("//html//body//div[1]//div[1]//div//h2"); 
	static By Clarification_Message2 =By.xpath("(//textarea[@name='MB_NT_SUBJECT'])[2]"); 
	static By Clarification_Submit2 =By.xpath("(//input[@value='Submit'])[2]"); 
	static By Clarification_Attachments2 =By.xpath("(//input[@value='Attachments'])[2]");
	static By admin=By.xpath("//div[text()='Admin']");
	static By setup=By.xpath("//a[text()=' SetUp']");
	static By ClarificationModule_Setup=By.xpath("(//a[contains(text(),'Clarification')])[1]");
	static By File_Delete=By.xpath("//a[@title='Delete']"); 
	static By Right_Frame=By.xpath("//frame[@name='right']"); 
	static By Left_Frame=By.xpath("//frame[@name='left']");  
	static By File_Submit=By.xpath("//input[@value='Submit']");   
	static By Vendor_Doc=By.xpath("//select[@name='MB_NT_ALLOW_VENDOR_TO_ATT_DOCS']");   
	static By Attach_Vendor_Doc=By.xpath("//input[@name='AttVendorDocs']");   
	static By Attach_Vendor_Doc_Header=By.xpath("(//div[@class='caption']//h2)[1]");   
	static By Attach_Vendor_Doc_CheckBox=By.xpath("//input[@id='fileId1']");   
	static By Attach_Vendor_Doc_Submit=By.xpath("//input[@id='iButton']");   
	static By Attach_Vendor_Doc_Status=By.xpath("//html//body//form//div[1]//div[3]//table//tbody//tr[2]//td[5]");   
	static By Attach_Vendor_Doc_Go_Back=By.xpath("//input[@name='Go_Back']");   
	static By Documents=By.xpath("//a[contains(text(),'Documents')]");    

	
	
	
private static Logger log = Logger.getLogger(MessageBoard.class);
	
	public MessageBoard(WebDriver driver)
	{
		super(driver);  
	} 
	
	public  void File_Upload(SoftAssert sa) throws Exception  
	{
		Thread.sleep(5000);
		String path1=new java.io.File(".").getCanonicalPath(); 
		WebElement el= driver.findElement(Choose_File);
	    Actions acc =  new Actions(driver);
	    acc.moveToElement(el).click().perform();
	    Thread.sleep(20000);
	    Runtime.getRuntime().exec(NormalUploadA+" "+path1+"\\Bids\\KSCSCBuyer5.pdf");
	    Thread.sleep(50000);  
	    WebElement submit = driver.findElement(File_Submit);
	    submit.click();
		Thread.sleep(5000); 
	    WebElement fileDelete = driver.findElement(File_Delete);
	    if(fileDelete.isDisplayed())
	    {
			Thread.sleep(3000);  
			log.info("File Upload Successful"); 
	    }
	    else 
	    {
			Thread.sleep(3000);
 	   		sa.fail("File Upload Unsuccessful");
	    }
	}
	
	public  void Scroll() throws Exception   
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1500)", "");  
		log.info("Scrolling of Page Successful");
	}
	 
	public  void Reply_Button(SoftAssert sa) throws Exception 
	{
		WebElement ReplyButton1 = driver.findElement(Reply_Button);
		ReplyButton1.click();
	}
	 
	public  void Pop_up(SoftAssert sa) throws Exception  
	{ 
		Thread.sleep(3000);
		String pop_up_text = driver.switchTo().alert().getText();
		Thread.sleep(3000);
		log.info("Pop-up alert upon clicking send button is: " +pop_up_text);
		if(pop_up_text.equalsIgnoreCase("Are you sure to send ?"))
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
	
	public  void Send_SMS_Email(SoftAssert sa) throws Exception  
	{
		WebElement SendSMS = driver.findElement(Send_SMS);
		Select sms = new Select(SendSMS);
		sms.selectByValue("Yes");
		Thread.sleep(2000);
		log.info("Send SMS Selected as YES Successfully");	  
		WebElement SendEmail = driver.findElement(Send_Email); 
		Select Email = new Select(SendEmail);
		Email.selectByValue("Yes");
		Thread.sleep(2000);
		log.info("Send Email Selected as YES Successfully");	  
	}
	
	public  void Send_Email(SoftAssert sa) throws Exception  
	{
		WebElement SendEmail = driver.findElement(Send_Email); 
		Select Email = new Select(SendEmail);
		Email.selectByValue("Yes");
		Thread.sleep(2000);
		log.info("Send Email Selected as YES Successfully");
	}
	
	public void Clarification_Due_date(String ClarificationDate) throws Exception 
	{
		Thread.sleep(2000);  
		WebElement TC_Calender = driver.findElement(Clarification_Reply_Due_date);	
		TC_Calender.clear();
		Thread.sleep(2000);   
		//org.json.JSONObject testData1 = ReadJsonTestData.getTestData("2022R7_MB","ENHANCEMENT");
		//String Clarification_Date = testData1.getString("ClarificationDate"); 
		TC_Calender.sendKeys(ClarificationDate); 
		Thread.sleep(2000);     
	}
	public  void Qualified_Bidder_Cost_Open(SoftAssert sa) throws Exception  
	{
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		WebElement ele = driver.findElement(Right_Frame);  
		driver.switchTo().frame(ele);
		Thread.sleep(2000);
		WebElement QualifiedBidder = driver.findElement(Qualified_Bidder_Cost);
		QualifiedBidder.click(); 
		log.info("Qualified Bidder Clicked Successfully");
	}
	public  void Qualified_Bidder_Tech_Open(SoftAssert sa) throws Exception  
	{
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		WebElement ele = driver.findElement(Right_Frame); 
		driver.switchTo().frame(ele); 
		Thread.sleep(2000);
		WebElement QualifiedBidder = driver.findElement(Qualified_Bidder);
		QualifiedBidder.click(); 
		log.info("Qualified Bidder Clicked Successfully");
	}
	
	public void Allow_Vendor_To_Attach_Documents(SoftAssert sa) throws Exception 
	{
		Thread.sleep(2000); 
		WebElement VendorDocuments_Attach = driver.findElement(Vendor_Doc);
		Select S1 = new Select(VendorDocuments_Attach);
		S1.selectByValue("Y");
		Thread.sleep(2000);   
		log.info("Allow Vendor to Attach Documents Selected Successfully");     
	}
	public  void Vendor_Documents_Status(SoftAssert sa, String Status) throws Exception  
    {
		WebElement Documents_Link = driver.findElement(Documents);
		Documents_Link.click();
		log.info("Documents Link clicked successfully"); 
		WebElement Documents_Status = driver.findElement(Attach_Vendor_Doc_Status);
		String Status1 = Documents_Status.getText();
		if(Status1.equals(Status))
		{
			log.info("Documents Status Verified Successfully"); 	
		}
		else
		{
			sa.fail("Documents Status Mismatch");
		}
    }
	public void Attach_Vendors_Docs(SoftAssert sa) throws Exception 
	{
		Thread.sleep(2000);  
		WebElement VendorDocuments_Attach = driver.findElement(Attach_Vendor_Doc);
		VendorDocuments_Attach.click();
		Thread.sleep(2000);   
		log.info("Attach Vendor Docs Clicked Successfully"); 
		WebElement VendorDocuments_Header = driver.findElement(Attach_Vendor_Doc_Header);
		String Header = VendorDocuments_Header.getText();
        if(Header.contains("Auction Number Documents")) 
        {
    		log.info("Auction Number Documents Page Verified Successfully"); 
    		WebElement VendorDocuments_CheckBox = driver.findElement(Attach_Vendor_Doc_CheckBox);
    		VendorDocuments_CheckBox.click();
    		log.info("Auction Number Documents Checkbox Clicked Successfully"); 
    		Thread.sleep(2000);   
    		WebElement VendorDocuments_Submit = driver.findElement(Attach_Vendor_Doc_Submit);
    		VendorDocuments_Submit.click();
    		log.info("Auction Number Documents Submit Button Clicked Successfully"); 
    		WebElement VendorDocuments_Status = driver.findElement(Attach_Vendor_Doc_Status);
    		String Status1 = VendorDocuments_Status.getText();
    		if(Status1.equals("Clarification Created"))
    		{
        		log.info("Document Status Verified Successfully");
        		WebElement VendorDocuments_GoBack = driver.findElement(Attach_Vendor_Doc_Go_Back);
        		VendorDocuments_GoBack.click();
    		}
    		else
    		{
    			sa.fail("Document Status Mismatch");
    		}	
        }
        else
        {
			sa.fail("Auction Number Documents Page Header Mismatch");
        }
	}
	}