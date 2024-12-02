package MessageBoard_Auction;

import org.apache.log4j.Logger; 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import Listeners.Clarification_Module_Setup;
import TenderCreation.BasePage;
import generic.Auto_const;

public class Auction_Message_Board_Setup extends BasePage implements Auto_const 
{
	static By Message_Board=By.xpath("//html//body//form//div[1]//div//h2[contains(text(),'Message Board')]"); 
	static By Auction_Request_Clarification=By.xpath("//div[2]//div[2]//table//tbody//tr[9]//td[2]");  
	static By PreAward_Clarification_Module=By.xpath("//div[2]//div[2]//table//tbody//tr[11]//td[2]");   
	static By PreLive_Clarification_Module=By.xpath("//div[2]//div[2]//table//tbody//tr[10]//td[2]");   
	static By Auction_Request_Clarification_Status=By.xpath("//select[@id='statusId8']");
	static By PreAward_Clarification_Module_Status=By.xpath("//select[@id='statusId10']"); 
	static By PreLive_Clarification_Module_Status=By.xpath("//select[@id='statusId9']");
	static By Message_Board_Submit =By.xpath("//input[@id='iButton']");
	static By AucReq_bid_B2V_Email =By.xpath("//select[@id='BuyerEmailId8']"); 
	static By AucReq_V2B_Email =By.xpath("//select[@id='VendorEmailId8']");	 
	static By AucReq_B2V_SMS =By.xpath("//select[@id='BuyerSMSid8']");	
	static By AucReq_V2B_SMS =By.xpath("//select[@id='VendorSMSid8']");	   
	static By PreAward_B2V_Email =By.xpath("//select[@id='BuyerEmailId10']");
	static By PreAward_V2B_Email =By.xpath("//select[@id='VendorEmailId10']");	
	static By PreAward_B2V_SMS =By.xpath("//select[@id='BuyerSMSid10']");	
	static By PreAward_V2B_SMS =By.xpath("//select[@id='VendorSMSid10']");	  
	static By PreLive_Clarification_B2V_Email =By.xpath("//select[@id='BuyerEmailId9']");
	static By PreLive_Clarification_V2B_Email =By.xpath("//select[@id='VendorEmailId9']");	
	static By PreLive_Clarification_B2V_SMS =By.xpath("//select[@id='BuyerSMSid9']");	
	static By PreLive_Clarification_V2B_SMS =By.xpath("//select[@id='VendorSMSid9']");
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
	static By Right_Frame=By.xpath("//iframe[@name='right'or @name='active']");   
	static By Left_Frame=By.xpath("//frame[@name='left']");  
	static By File_Submit=By.xpath("//input[@value='Submit']"); 
	public static Clarification_Module_Setup List; 
	
private static Logger log = Logger.getLogger(Auction_Message_Board_Setup.class);
	
	public Auction_Message_Board_Setup(WebDriver driver)
	{
		super(driver);  
	} 
	
	public  void Clarification_ModuleSetup(SoftAssert sa) throws Exception   
	{
		List=PageFactory.initElements(driver, Clarification_Module_Setup.class);
		List.Setup();		
		Thread.sleep(5000);  
		driver.switchTo().defaultContent();
		WebElement f1=driver.findElement(Right_Frame);  
		driver.switchTo().frame(f1); 
		WebElement Page_Header = driver.findElement(Message_Board); 
		String Header = Page_Header.getText();
		if(Header.contains("Message Board"))
		{
		log.info("Message Board Page Verified"); 
		}
		else
		{
			sa.fail("Header Mismatch");
		} 
	}
	public  void PreRequest_Clarification_Email_SMS_Enablement(SoftAssert sa) throws Exception  
	{				
		WebElement AUction_Request_clarification = driver.findElement(Auction_Request_Clarification);
		String Text1 = AUction_Request_clarification.getText();
		if(Text1.contains("Auction Request Clarification"))
		{
			log.info("Auction Pre Request clarification Label Name in Message Board Page Verified");
			Thread.sleep(2000);
			WebElement RC_Status = driver.findElement(Auction_Request_Clarification_Status);
			Select RC_Select1 = new Select(RC_Status); 
			RC_Select1.selectByVisibleText("Enabled");
			log.info("Auction Pre Request clarification clarification Enabled");
			Thread.sleep(2000);
			//1. Pre Request Clarification SMS and Email
			WebElement Auc_Req_BuyertoVendor_Email = driver.findElement(AucReq_bid_B2V_Email);
			Select AR_Email1 = new Select(Auc_Req_BuyertoVendor_Email);
			AR_Email1.selectByVisibleText("Yes"); 
			log.info("Buyer to Vendor Pre Request Clarification Email Enabled");
			Thread.sleep(2000);
			WebElement Auc_Req_VendortoBuyer_Email = driver.findElement(AucReq_V2B_Email);
			Select AC_Email2 = new Select(Auc_Req_VendortoBuyer_Email);
			AC_Email2.selectByVisibleText("Yes"); 
			log.info("Vendor to Buyer Pre Request Clarification Email Enabled"); 
			Thread.sleep(2000);
			WebElement Auc_Req_BuyertoVendor_SMS = driver.findElement(AucReq_B2V_SMS);
			Select AR_SMS1 = new Select(Auc_Req_BuyertoVendor_SMS);
			AR_SMS1.selectByVisibleText("Yes");
			log.info("Buyer to vendor Pre Request Clarification SMS Enabled"); 
			Thread.sleep(2000);
			WebElement Auc_Req_VendortoBuyer_SMS = driver.findElement(AucReq_V2B_SMS);
			Select AR_SMS2 = new Select(Auc_Req_VendortoBuyer_SMS);
			AR_SMS2.selectByVisibleText("Yes");
			log.info("Vendor to Buyer Pre Request Clarification SMS Enabled"); 
			Thread.sleep(2000);
		}
		else
		{
			sa.fail("Auction Pre Request clarification Label Name Mismatch");
		}
	}
	
	public  void PreLive_Clarification_Email_SMS_Enablement(SoftAssert sa) throws Exception   
	{
		Thread.sleep(2000);
		WebElement Pre_Live_clarification = driver.findElement(PreLive_Clarification_Module);
		String Text2 = Pre_Live_clarification.getText();
		if(Text2.contains("Auction Pre-Live Clarification"))
		{
		log.info("Auction Pre-Live Clarification Label Name in Message Board Page Verified");
		Thread.sleep(2000);
		WebElement PreLive_Status = driver.findElement(PreLive_Clarification_Module_Status);
		Select Prelive_Select = new Select(PreLive_Status);
		Prelive_Select.selectByVisibleText("Enabled");
		log.info("Auction Pre-Live clarification Enabled"); 
		Thread.sleep(2000);
		//2. Auction Pre-Live Clarification SMS and Email 
		WebElement PreLive_Clarification_BuyertoVendor_Email = driver.findElement(PreLive_Clarification_B2V_Email);
		Select PreLive_Clar_Email1 = new Select(PreLive_Clarification_BuyertoVendor_Email);
		PreLive_Clar_Email1.selectByVisibleText("Yes");
		log.info("Buyer to Vendor Auction Pre-Live Clarification Email Enabled");
		Thread.sleep(2000);
		WebElement PreLive_Clarification_VendortoBuyer_Email = driver.findElement(PreLive_Clarification_V2B_Email);
		Select PreLive_Clar_Email2 = new Select(PreLive_Clarification_VendortoBuyer_Email);
		PreLive_Clar_Email2.selectByVisibleText("Yes");
		log.info("Vendor to Buyer Auction Pre-Live Clarification Email Enabled");
		Thread.sleep(2000);
		WebElement PreLive_Clarification_BuyertoVendor_SMS = driver.findElement(PreLive_Clarification_B2V_SMS);
		Select PreLive_clar_SMS1 = new Select(PreLive_Clarification_BuyertoVendor_SMS);
		PreLive_clar_SMS1.selectByVisibleText("Yes");
		log.info("Buyer to vendor Auction Pre-Live Clarification SMS Enabled");
		Thread.sleep(2000);
		WebElement PreLive_Clarification_VendortoBuyer_SMS = driver.findElement(PreLive_Clarification_V2B_SMS);
		Select PreLive_clar_SMS2 = new Select(PreLive_Clarification_VendortoBuyer_SMS);
		PreLive_clar_SMS2.selectByVisibleText("Yes"); 
		log.info("Vendor to Buyer Auction Pre-Live Clarification SMS Enabled"); 
		Thread.sleep(2000);
		}
		else
		{
			sa.fail("Auction Pre Live clarification Label Name Mismatch");
		}
		}
		
	public  void PreAward_Clarification_Email_SMS_Enablement(SoftAssert sa) throws Exception   
	{
		Thread.sleep(3000); 
		WebElement PreAward_clarification = driver.findElement(PreAward_Clarification_Module);
		String Text3 = PreAward_clarification.getText(); 
		if(Text3.contains("Auction Pre-Award Clarification"))
		{
		log.info("PreAward clarification Label Name in Message Board Page Verified");
		Thread.sleep(2000);
		WebElement PreAward_Status = driver.findElement(PreAward_Clarification_Module_Status);
		Select PreAward_Select = new Select(PreAward_Status);
		PreAward_Select.selectByVisibleText("Enabled");
		log.info("PreAward clarification Enabled");
		//3. PreAward Clarification SMS and Email
		WebElement PreAward_BuyertoVendor_Email = driver.findElement(PreAward_B2V_Email);
		Select PreAward_Email1 = new Select(PreAward_BuyertoVendor_Email);
		PreAward_Email1.selectByVisibleText("Yes");
		log.info("Buyer to Vendor PreAward Clarification Email Enabled");
		Thread.sleep(2000);
		WebElement PreAward_VendortoBuyer_Email = driver.findElement(PreAward_V2B_Email);
		Select PreAward_Email2 = new Select(PreAward_VendortoBuyer_Email);
		PreAward_Email2.selectByVisibleText("Yes");
		log.info("Vendor to Buyer PreAward Clarification Email Enabled");
		Thread.sleep(2000);
		WebElement PreAward_BuyertoVendor_SMS = driver.findElement(PreAward_B2V_SMS);
		Select PreAward_SMS1 = new Select(PreAward_BuyertoVendor_SMS);
		PreAward_SMS1.selectByVisibleText("Yes");
		log.info("Buyer to vendor PreAward Clarification SMS Enabled");
		Thread.sleep(2000);
		WebElement PreAward_VendortoBuyer_SMS = driver.findElement(PreAward_V2B_SMS);
		Select PreAward_SMS2 = new Select(PreAward_VendortoBuyer_SMS);
		PreAward_SMS2.selectByVisibleText("Yes");
		log.info("Vendor to Buyer PreAward Clarification SMS Enabled");
		Thread.sleep(2000);
		}
		else
		{
			sa.fail("Auction PreAward clarification Label Name Mismatch");
		}
	}
		
	public  void Clarification_ModuleSetup_Submit() throws Exception  
	{
		WebElement MessageBoard_Submit = driver.findElement(Message_Board_Submit);
		MessageBoard_Submit.click();
		log.info("Clarification Module/Message Board Setup Submitted Successfully");			
	}
}