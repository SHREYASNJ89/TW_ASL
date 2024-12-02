package MessageBoard_Auction;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.apache.log4j.Logger; 
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;  
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners; 
import org.testng.asserts.SoftAssert;
import com.relevantcodes.extentreports.LogStatus;  
import TenderCreation.BasePage;
import generic.Auto_const;
import Listeners.Clarification_Module_Setup; 
import Listeners.MessageBoard;
import Listeners.ReadJsonTestData;
import Listeners.Tendernumber; 
import TenderAuctionSearch.AuctionSearch;
import TenderAuctionSearch.AuctionSearchforApprovedAuction;
import TenderAuctionSearch.TenderSearchInprogress;

public class Pre_Award_Clarification extends BasePage implements Auto_const   
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
	static By Pre_Live_Clarification_Icon =By.xpath("//img[@alt='Pre-Live Clarification']");   
	static By Auction_Request_Clarification_Header =By.xpath("(//html//body//div[1]//div[1]//div//h2)[1]"); 
	static By Clarification_Subject =By.xpath("//input[@name='MB_NT_MESSAGE_ID']"); 
	static By Auction_Request_Clarification_Response_To =By.xpath("//select[@name='MB_NT_RECIPIENT']"); 
	static By Clarification_Message =By.xpath("//textarea[@name='MB_NT_SUBJECT']"); 
	static By Send_SMS =By.xpath("//select[@name='MB_NT_SMS_DATE']");
	static By Send_Email =By.xpath("//select[@name='MB_NT_EMAIL_DATE']");
	static By Clarification_Submit =By.xpath("//input[@value='Submit']");
	static By Clarification_Attachments =By.xpath("(//input[@value='Attachments'])[1]");
	static By Clarification_Attachments_Back =By.xpath("//input[@value='Back']");
	static By Choose_File=By.xpath("//input[@type='file']"); 
	static By Clarification_Send =By.xpath("//input[@value='Send']");  
	static By Clarification_Sent_Date =By.xpath("//th[contains(text(),'Sent Date')]");
	static By Reply_Button =By.xpath("//td//input[@value='Reply']");  
	static By Clarification_Send_Buyer =By.xpath("//input[@value='Send']"); 
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
	static By Active_Frame=By.xpath("//iframe[@name='right'or @name='active']");  
	static By Left_Frame=By.xpath("//frame[@name='left']");  
	static By File_Submit=By.xpath("//input[@value='Submit']"); 
	static By New_Vendor_Auction=By.xpath("//img[@alt='New Vendor ']");  
	static By Bidder_List_Payment_Approval=By.xpath("(//a//b)[3]");   
	static By Payment_Approval_Header=By.xpath("//div[@class='caption']//h2");   
	static By Payment_Approval_CheckBox=By.xpath("//input[@id='vendArray']");    
	static By Pre_Clarification_Header=By.xpath("//div[@class='caption']//h2");    
	static By Documents=By.xpath("//a[contains(text(),'Documents')]");    
	static By Clarification_Go_Back=By.xpath("(//input[@name='goback'])[1]"); 
	static By Verify_Documents=By.xpath("//input[@value=' Verify Documents']"); 
	static By Document_Approval_Status=By.xpath("//div[@class='summary'][2]//table//tbody//td[4][@rowspan='5']"); 
	static By Pre_Award_Icon=By.xpath("//img[@alt='Pre-Live Clarification']"); 
	static By Pre_Award_Icon_Vendor=By.xpath("//img[@alt='Pre-Award Clarification']");  
	
	
	public static MessageBoard MB;
	public static AuctionSearch auctionSearch; 
	public static AuctionSearchforApprovedAuction auctionSearchforApprovedAuction;
	
private static Logger log = Logger.getLogger(Pre_Award_Clarification.class);
	
	public Pre_Award_Clarification(WebDriver driver)
	{
		super(driver);  
	}  	 
	
	//To check Pre-Award Clarification initiation from vendor end  
	public  void Pre_Award_Clarification_Vendor_Initiate(SoftAssert sa) throws Exception  
	{
		driver.switchTo().defaultContent(); 
		WebElement ele = driver.findElement(Active_Frame);  
		driver.switchTo().frame(ele);
		Thread.sleep(3000); 
		waitForElementToAppear(Pre_Award_Icon);   
		WebElement Preaward_Clarification_Icon = driver.findElement(Pre_Award_Icon);
		Preaward_Clarification_Icon.click();
		log.info("Auction Pre Award Clarification Icon Clicked");
		Thread.sleep(3000); 
		WebElement Header = driver.findElement(Pre_Clarification_Header);
		String Text1= Header.getText();
		if(Text1.equals("Auction Pre-Award Clarification")) 
		{
			log.info("Auction Pre-Award Clarification Page Verification Successful");
			List<WebElement> Subject = driver.findElements(Clarification_Subject);
			if(Subject.isEmpty())
			{
				log.info("Subject Field Unavailable");
			}
			else
			{
	 	   		sa.fail("Subject Field Available");	   
			}
		}
		else
		{
			sa.fail("Auction Pre-Award Clarification Page Header Mismatch");
		} 
	}
	
	//Buyer End Pre-Award Clarification Details 
		public  void Pre_Award_Clarification_Buyer_Response(SoftAssert sa,String value, String PASubject, String PAMessage, String ClarificationDate, String Pop_Text) throws Exception  
	    {
			driver.switchTo().defaultContent();  
			WebElement ele = driver.findElement(Active_Frame);  
			driver.switchTo().frame(ele);
			Thread.sleep(3000); 
			WebElement TC_Subject = driver.findElement(Clarification_Subject);
			TC_Subject.sendKeys(PASubject);   
			Thread.sleep(2000);
			log.info("Auction Pre Award clarification Subject Updated Successfully");  
			WebElement TC_Message = driver.findElement(Clarification_Message);  
			TC_Message.sendKeys(PAMessage);    
			log.info("Auction Pre Award clarification Message Updated Successfully");
			Thread.sleep(2000);
			 
			MB=PageFactory.initElements(driver, MessageBoard.class); 			
			//MB.Send_Email(sa);
			//Thread.sleep(5000);
			//log.info("Auction Pre Award clarification Email Selected");  
			
			MB.Clarification_Due_date(ClarificationDate);
			log.info("Auction Pre Award clarification Reply Due Date Selected"); 
			
			Thread.sleep(3000);   
			WebElement ClarificationSubmit = driver.findElement(Clarification_Submit);
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", ClarificationSubmit);
			Thread.sleep(2000);
			log.info("Auction Pre Award clarification Submit Button clicked Successfully");  
			 
			WebElement ClarificationAttachments = driver.findElement(Clarification_Attachments);
			js.executeScript("arguments[0].click();", ClarificationAttachments);
			Thread.sleep(2000);  
			log.info("Attachement Button Clicked Successfully"); 
			
			MB.File_Upload(sa);
			
			Thread.sleep(25000);
			WebElement Back_button = driver.findElement(Clarification_Attachments_Back);
			js.executeScript("arguments[0].click();", Back_button);
			Thread.sleep(5000); 
			WebElement Send = driver.findElement(Clarification_Send);
			js.executeScript("arguments[0].click();", Send);
			log.info("Auction Pre Award clarification Send Button clicked Successfully");	
			Thread.sleep(3000);  
			
			MB.Pop_up(sa, Pop_Text);
			
			Thread.sleep(5000); 
			WebElement Sent_date = driver.findElement(Clarification_Sent_Date);
			Sent_date.isDisplayed();             
			Thread.sleep(3000); 
			log.info("Auction Pre Award clarification Sent Successfully from Buyer to Vendor"); 
	    }
		
		//Vendor End Pre Award Clarification Details
		public  void Pre_Award_Clarification_Vendor_Response(SoftAssert sa, String PAMessageVend, String Pop_Text) throws Exception  
	    { 
			driver.switchTo().defaultContent(); 
			WebElement ele = driver.findElement(Active_Frame);  
			driver.switchTo().frame(ele);
			Thread.sleep(3000); 
			WebElement ReplyButton = driver.findElement(Reply_Button);    
			if(ReplyButton.isDisplayed())
			{
				log.info("Seeked Auction Pre Award clarification visible at vendor end"); 
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("arguments[0].click();", ReplyButton);
				Thread.sleep(2000);
				log.info("Reply Button Clicked Successfully");
				Thread.sleep(2000);
				
				MB=PageFactory.initElements(driver, MessageBoard.class);
	            MB.Scroll();  
	            
				Thread.sleep(3000); 
				WebElement V2B_Pre_Award_Clarification_Message = driver.findElement(Clarification_Message);
				//V2B_Tech_Clarification_Message.sendKeys("Vendor Repose to Buyer Technical Clarification");
				//org.json.JSONObject testData1 = ReadJsonTestData.getTestData("2022R7_MB","ENHANCEMENT");
				//String Technical_Bid_Message_Vendor = testData1.getString("TechnicalBidMessagevend"); 
				V2B_Pre_Award_Clarification_Message.sendKeys(PAMessageVend);     
				Thread.sleep(2000); 
				
				//MB.Send_Email(sa);  
	            
				Thread.sleep(5000); 
				WebElement ClarificationSubmit = driver.findElement(Clarification_Submit);
				js.executeScript("arguments[0].click();", ClarificationSubmit);
				Thread.sleep(2000);
				log.info("Auction Pre Award clarification Submit Button clicked Successfully");  
							
				MB.Reply_Button(sa);
				
				Thread.sleep(2000);
				log.info("Reply Button Clicked Successfully");
				Thread.sleep(2000);
				 
	            MB.Scroll();

				Thread.sleep(3000); 
				/*WebElement ClarificationAttachments = driver.findElement(Clarification_Attachments);
				
				js.executeScript("arguments[0].click();", ClarificationAttachments);
				Thread.sleep(2000);
				log.info("Attachement Button Clicked Successfully");
				
	            MB.File_Upload(sa);

				Thread.sleep(25000);
				WebElement Back_button = driver.findElement(Clarification_Attachments_Back); 
				Back_button.click();
				Thread.sleep(5000);
							
				MB.Reply_Button(sa); 
				
				Thread.sleep(2000);
				log.info("Reply Button Clicked Successfully");
				Thread.sleep(2000);
				
	            MB.Scroll();
	            
				Thread.sleep(3000); */
				WebElement Send = driver.findElement(Clarification_Send_Buyer);  
				js.executeScript("arguments[0].click();", Send); 
				log.info("Auction Pre Award clarification Send Button clicked Successfully"); 
				Thread.sleep(5000); 
				
	            MB.Pop_up(sa, Pop_Text); 
	            
				Thread.sleep(5000); 
				WebElement Sent_date = driver.findElement(Clarification_Sent_Date1); 
				Sent_date.isDisplayed();
				Thread.sleep(3000); 
				log.info("Auction Pre Award clarification Sent Successfully from Vendor to Buyer"); 
			} 
			else 
			{ 
				sa.fail("Seeked Auction Pre Award clarification not visible at vendor end"); 
			}  
	    }

		//To Initiate Pre-Award Clarification from Buyer End
		public  void Auction_PreAward_Clarification_Buyer(SoftAssert sa,String value, String PASubject, String PAMessage, String ClarificationDate, String Pop_Text) throws Exception  
		{ 
			Thread.sleep(2000); 
			MB=PageFactory.initElements(driver, MessageBoard.class);
			MB.Auction_BidDetail(sa);   
			log.info("Navigated to Pre Award Clarification Page Successfully");
			Thread.sleep(3000);
			driver.switchTo().defaultContent();
			WebElement ele = driver.findElement(Active_Frame);  
			driver.switchTo().frame(ele);  
			Thread.sleep(3000); 
			Pre_Award_Clarification_Buyer_Response(sa, value, PASubject, PAMessage, ClarificationDate, Pop_Text);  
			log.info("Pre Award Clarification Buyer End Verifcation Successful");  
		}
		//Reply from vendor end to Pre-Award Clarification seeked from Buyer end 
		public  void Auction_PreAward_Clarification_Vendor(SoftAssert sa, String PAMessageVend, String Pop_Text) throws Exception  
		{
			Thread.sleep(2000); 
			driver.switchTo().defaultContent();
			WebElement ele = driver.findElement(Active_Frame);  
			driver.switchTo().frame(ele);
			Thread.sleep(2000);
			waitForElementToAppear(Pre_Award_Icon_Vendor); 
			WebElement Pre_Live_Icon = driver.findElement(Pre_Award_Icon_Vendor);   
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", Pre_Live_Icon);
			Thread.sleep(2000); 
			log.info("Pre Award Clarification Icon Clicked Successfully"); 
			Thread.sleep(2000);
			WebElement PreAward_Clarification_Header = driver.findElement(Pre_Clarification_Header);
			String Header_Text = PreAward_Clarification_Header.getText(); 
			if(Header_Text.contains("Auction Pre-Award Clarification"))  
			{
				log.info("Pre Award Clarification Page Verified Successfully"); 
				Thread.sleep(5000);
				Pre_Award_Clarification_Vendor_Response(sa, PAMessageVend, Pop_Text);   
				log.info("Pre Award Clarification Vendor End Verifcation Successful");  
			}
			else  
			{
				sa.fail("Pre Award Clarification Page Header mismatch");  
			}
		}
}  