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

public class Pre_Request_Clarification extends BasePage implements Auto_const  
{
	static By Message_Board=By.xpath("//html//body//form//div[1]//div//h2[contains(text(),'Message Board')]"); 
	static By PreBid_Clarification_Module=By.xpath("//html//body//form//div[3]//table//tbody//tr[2]//td[2]//input"); 
	static By Negotiation_Clarification_Module=By.xpath("//html//body//form//div[3]//table//tbody//tr[3]//td[2]//input");
	static By Technical_Clarification_Module=By.xpath("//html//body//form//div[3]//table//tbody//tr[4]//td[2]//input"); 
	static By PreBid_Clarification_Module_Status=By.xpath("//select[@id='statusId1']");
	static By Negotiation_Clarification_Module_Status=By.xpath("//select[@id='statusId2']"); 
	static By Technical_Clarification_Module_Status=By.xpath("//select[@id='statusId3']");
	static By Message_Board_Submit =By.xpath("//input[@id='iButton']");	   
	static By Auction_Request_Clarification_Icon =By.xpath("//img[@alt='Request Clarification']");  
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
	public static MessageBoard MB;
	public static AuctionSearch auctionSearch; 
	public static AuctionSearchforApprovedAuction auctionSearchforApprovedAuction;

	
	
private static Logger log = Logger.getLogger(Pre_Request_Clarification.class);
	
	public Pre_Request_Clarification(WebDriver driver)
	{
		super(driver);  
	}  	 
	
	//MODIFIED
	public  void Auction_Search_Inprogress(SoftAssert sa, String AuctionType) throws Exception 
	{
		//Auction Number fetch
				Tendernumber tt=new Tendernumber();
				ArrayList<String> td = tt.fetch("TenderNumber_Line1_Line2");
				String An1=td.get(0);
				String line1=td.get(1);
				String line2=td.get(2);
				log.info("Auction Number "+An1); 
		Thread.sleep(2000);
		auctionSearchforApprovedAuction=PageFactory.initElements(driver, AuctionSearchforApprovedAuction.class);
		auctionSearchforApprovedAuction.auctionsearch(An1, line1,AuctionType);  
		TenderSearchInprogress TS = new TenderSearchInprogress(driver);    
		TS.InProgress(An1);
		log.info("Tender Search Successful");   
		Thread.sleep(2000);
	}
	
	// To Select Pre Request Clarification Response to at vendor end
	public  void Pre_Request_Response_To(SoftAssert sa, String ResponseTo) throws Exception   
	{
		WebElement PR_Response_to = driver.findElement(Auction_Request_Clarification_Response_To);
		Select Rspto = new Select(PR_Response_to);
		Rspto.selectByVisibleText(ResponseTo);   
		Thread.sleep(2000);    
	}
	
	// To Check if Pre Request Clarification Initiation is allowed at Buyer end 
	public  void Auction_Request_Clarification_Buyer_Initiate(SoftAssert sa) throws Exception  
	{
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		WebElement ele = driver.findElement(Active_Frame);  
		driver.switchTo().frame(ele);
		Thread.sleep(2000);
		WebElement PreRequest_icon = driver.findElement(Auction_Request_Clarification_Icon);
		PreRequest_icon.click();
		log.info("Pre Request clarification icon clicked Successfully");	 
		driver.switchTo().defaultContent();
		driver.switchTo().frame(ele);
		Thread.sleep(2000);
		WebElement PreRequest_Header = driver.findElement(Auction_Request_Clarification_Header);
		String text1 = PreRequest_Header.getText(); 
		Thread.sleep(2000); 
		if(text1.contains("Auction Request Clarification"))   
		{
			log.info("Auction Request Clarification Page Header Matching");
			Thread.sleep(2000); 
		List<WebElement> AR_Subject = driver.findElements(Clarification_Subject);
		if(AR_Subject.isEmpty())  
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
 	   		sa.fail("Auction Request Clarification Page Header Mismatch");	 
		}
	} 
	 
	// Buyer End Auction Pre Request Clarification Response Details 
	public  void Auction_Request_Clarification_Buyer_Response(SoftAssert sa, String ACMessage, String Auction_Number, String Line_Number, String Value, String Pop_Text) throws Exception  
	{
		WebElement ReplyButton = wait.until(ExpectedConditions.visibilityOfElementLocated(Reply_Button));
		if(ReplyButton.isDisplayed())  
		{ 
			log.info("Reply Button Available, Vendor Clarification Verified Successfully");
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", ReplyButton); 
			log.info("Reply Button Clicked Successfully"); 
			Thread.sleep(2000);
	
			MB=PageFactory.initElements(driver, MessageBoard.class);  
			MB.Scroll();
			 
			Thread.sleep(3000);                 
			WebElement B2V_Clarification_Message = driver.findElement(Clarification_Message);
			Thread.sleep(2000); 
			//B2V_Clarification_Message.sendKeys("Buyer Repose to Vendor Pre Bid Clarification");
			//org.json.JSONObject testData1 = ReadJsonTestData.getTestData("2022R7_MB","ENHANCEMENT");
			//String Pre_Bid_Message = testData1.getString("PreBidMessage"); 
			B2V_Clarification_Message.sendKeys(ACMessage);    
			Thread.sleep(2000);
			
			//MB.Send_SMS_Email(sa);  
			
			Thread.sleep(5000); 
			WebElement ClarificationSubmit = driver.findElement(Clarification_Submit);
			js.executeScript("arguments[0].click();", ClarificationSubmit); 
			Thread.sleep(2000);
			log.info("Auction Request clarification Submit Button clicked Successfully"); 
			Thread.sleep(5000); 
			//driver.navigate().refresh();
			//Thread.sleep(5000);  
			//String TenderNumber1 = testData1.getString("TenderNumber"); 
			//Auction_Search_Inprogress(sa,AuctionType);  
			AuctionSearchforApprovedAuction Search = new AuctionSearchforApprovedAuction(driver);
			Search.Auction_Search_New(Auction_Number, Line_Number, Value);  
			Thread.sleep(5000);             
			driver.switchTo().defaultContent();
			WebElement ele = driver.findElement(Active_Frame); 
			driver.switchTo().frame(ele);
			Thread.sleep(2000);
			WebElement Prereq_icon1 = driver.findElement(Auction_Request_Clarification_Icon);
			js.executeScript("arguments[0].click();", Prereq_icon1); 
			
			Thread.sleep(3000);
			log.info("Auction Request clarification icon clicked Successfully");	
			driver.switchTo().defaultContent();  
		    driver.switchTo().frame(ele);
			Thread.sleep(2000);	
			 
			WebElement ReplyButton1 = wait.until(ExpectedConditions.visibilityOfElementLocated(Reply_Button));
			js.executeScript("arguments[0].click();", ReplyButton1); 
			log.info("Reply Button Clicked Successfully");
			Thread.sleep(2000);
			
			MB.Scroll();
			
			Thread.sleep(3000); 
			/*WebElement ClarificationAttachments = driver.findElement(Clarification_Attachments);
			ClarificationAttachments.click();
			Thread.sleep(2000);
			log.info("Attachement Button Clicked Successfully");
			MB=PageFactory.initElements(driver, MessageBoard.class);
			MB.File_Upload(sa);
			Thread.sleep(25000);
			//WebElement submit =  driver.findElement(Clarification_Submit);
		    //submit.click(); 
			//Thread.sleep(3000);
			WebElement Back_button = driver.findElement(Clarification_Attachments_Back);
			Back_button.click();
			Thread.sleep(5000);
			driver.switchTo().defaultContent();  
		    driver.switchTo().frame(ele);
			Thread.sleep(2000); 
			WebElement ReplyButton2 = wait.until(ExpectedConditions.visibilityOfElementLocated(Reply_Button));
			ReplyButton2.click();   
			
			Thread.sleep(2000);
			log.info("Reply Button Clicked Successfully");  
			Thread.sleep(2000);*/       
			
			//MB.Scroll();
			
			Thread.sleep(3000); 
			WebElement Send = driver.findElement(Clarification_Send_Buyer); 
			js.executeScript("arguments[0].click();", Send); 
			log.info("Auction Request clarification Send Button clicked Successfully");
			Thread.sleep(5000); 

			MB.Pop_up(sa, Pop_Text); 
			 
			Thread.sleep(5000);   
			WebElement Sent_date = driver.findElement(Clarification_Sent_Date1); 
			Sent_date.isDisplayed();  
			Thread.sleep(3000); 
			log.info("Auction Request clarification Sent Successfully from Buyer to Vendor"); 
		}
		else
		{
 	   		sa.fail("Reply Button Unavailable");  
		}
	}  
	
	// Vendor End Auction Pre Request Clarification Response Details 
	public  void Auction_Request_Clarification_Vendor_Response(SoftAssert sa, String ARSubject, String ARMessage, String ResponseTo, String Pop_Text) throws Exception  
	{
		WebElement AR_Subject = driver.findElement(Clarification_Subject);  
		AR_Subject.sendKeys(ARSubject);
		Thread.sleep(2000);
		log.info("Auction Request clarification Subject Updated Successfully");	 
		Thread.sleep(2000);
		Pre_Request_Response_To(sa,ResponseTo); 
		Thread.sleep(2000); 
		log.info("Auction Request clarification Response To Updated Successfully");	
		WebElement PB_Message = driver.findElement(Clarification_Message); 
		PB_Message.sendKeys(ARMessage);  
		log.info("Auction Request clarification Message Updated Successfully");
		Thread.sleep(5000);
		WebElement ClarificationSubmit = driver.findElement(Clarification_Submit);
		ClarificationSubmit.click();
		Thread.sleep(2000); 
		log.info("Auction Request clarification Submit Button clicked Successfully");
		
		WebElement ClarificationAttachments = driver.findElement(Clarification_Attachments);
		ClarificationAttachments.click();
		Thread.sleep(2000);
		log.info("Attachement Button Clicked Successfully");
		
		MB=PageFactory.initElements(driver, MessageBoard.class);
		MB.File_Upload(sa);
		Thread.sleep(25000); 
		//WebElement submit =  driver.findElement(Clarification_Submit);
	    //submit.click(); 
		//Thread.sleep(3000); 
		WebElement Back_button = driver.findElement(Clarification_Attachments_Back);
		Back_button.click();
		Thread.sleep(5000); 
		WebElement Send = driver.findElement(Clarification_Send); 
		Send.click(); 
		log.info("Auction Request clarification Send Button clicked Successfully");	 
		Thread.sleep(3000);
		
		MB.Pop_up(sa, Pop_Text); 
		
		Thread.sleep(5000); 
		WebElement Sent_date = driver.findElement(Clarification_Sent_Date);
		Sent_date.isDisplayed();
		Thread.sleep(5000); 
		log.info("Auction Request clarification Sent Successfully from Vendor to Buyer"); 
	}	
	
	// Buyer End Response to Auction Pre Request Clarification seeked by Vendor 
	public  void Auction_Request_Clarification_Buyer(SoftAssert sa, String ACMessage_Buyer, String Auction_Number, String Line_Number, String AuctionType, String Pop_Text) throws Exception  
	{
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		WebElement ele = driver.findElement(Active_Frame);  //Right Frame 
		driver.switchTo().frame(ele);
		Thread.sleep(2000);
		WebElement AuctionReq_icon = driver.findElement(Auction_Request_Clarification_Icon);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", AuctionReq_icon); 
		log.info("Auction Request clarification icon clicked Successfully");	
		driver.switchTo().defaultContent();
		driver.switchTo().frame(ele);
		Thread.sleep(2000);
		WebElement AuctionReq_Header = driver.findElement(Auction_Request_Clarification_Header); 
		String text1 = AuctionReq_Header.getText();  
		if(text1.contains("Auction Request Clarification")) 
		{
			log.info("Auction Request clarification Page Verified Successfully");   
			Thread.sleep(5000);  
			//WebElement ReplyButton = driver.findElement(Reply_Button);
			Auction_Request_Clarification_Buyer_Response(sa,ACMessage_Buyer,Auction_Number, Line_Number, AuctionType, Pop_Text); 
 	   		log.info("Auction Pre Request Clarification Sent Successfully from Buyer");    
		}
		else
		{   
 	   		sa.fail("Page Header mismatch");   
		} 
	}
	
	// Auction Pre Request Clarification Initiation from Vendor end 
	public  void Auction_Request_Clarification_Vendor(SoftAssert sa, String ACSubject, String ACMessage, String ResponseTo, String Pop_Text) throws Exception  
	{
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		WebElement ele = driver.findElement(Active_Frame);    //Right Frame 
		driver.switchTo().frame(ele); 
		Thread.sleep(2000);
		WebElement AuctionReq_icon = driver.findElement(Auction_Request_Clarification_Icon);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", AuctionReq_icon);                  
		log.info("Auction Request clarification icon clicked Successfully");	
		Thread.sleep(2000);                        
		driver.switchTo().defaultContent();
		driver.switchTo().frame(ele);         
		Thread.sleep(2000);
		WebElement AuctionReq_Header = driver.findElement(Auction_Request_Clarification_Header);  
		String text1 = AuctionReq_Header.getText();     
		if(text1.contains("Auction Request Clarification"))  
		{
			log.info("Auction Request clarification Page Verified Successfully");
			Thread.sleep(5000);
			Auction_Request_Clarification_Vendor_Response(sa,ACSubject,ACMessage, ResponseTo, Pop_Text);
			log.info("Auction Request clarification Sent Successfully To Buyer");
		}
		else
		{ 
 	   		sa.fail("Auction Request clarification Page Header mismatch");   
		} 
	}
	public  void Auction_Pre_Live_Icon(SoftAssert sa, String ACSubject, String ACMessage, String ResponseTo) throws Exception  
	{
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		WebElement ele = driver.findElement(Active_Frame);    //Right Frame 
		driver.switchTo().frame(ele); 
		Thread.sleep(2000);
		WebElement AuctionReq_icon = driver.findElement(Auction_Request_Clarification_Icon);
		AuctionReq_icon.click(); 
		log.info("Auction Request clarification icon clicked Successfully");
	}
}