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
import Listeners.Role_Setup; 


public class Auction_Clarification_Role_Check extends BasePage implements Auto_const   
{
	static By Left_Frame=By.xpath("//frame[@name='left']");  
	static By Right_Frame=By.xpath("//iframe[@name='right'or @name='active']");  
	static By New_Role=By.xpath("//input[@id='newcompany']");   
	static By Auction_Clarification_Role=By.xpath("//td[contains(text(),'AUCTION CLARIFICATION')]");  
	
	 
	public static Role_Setup RS;
	public static MessageBoard MB;
private static Logger log = Logger.getLogger(Auction_Clarification_Role_Check.class);
	
	public Auction_Clarification_Role_Check(WebDriver driver) 
	{
		super(driver);  
	}  	 
	
	//To check Pre-Award Clarification initiation from vendor end  
	public  void Clarification_Role(SoftAssert sa) throws Exception  
	{
		RS=PageFactory.initElements(driver, Role_Setup.class); 			
		RS.Setup();          
		Thread.sleep(3000); 
		log.info("Navigated to Role Setup Page");
		driver.switchTo().defaultContent(); 
		WebElement ele = driver.findElement(Right_Frame);  
		driver.switchTo().frame(ele);
		Thread.sleep(3000);                                 
		waitForElementToAppear(New_Role);   
		WebElement New_Role_Button = driver.findElement(New_Role);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", New_Role_Button); 
		log.info("Navigated to Role Creation Page");              
		Thread.sleep(3000); 
		//MB=PageFactory.initElements(driver, MessageBoard.class); 			
		//MB.Scroll();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(Auction_Clarification_Role));
		Thread.sleep(3000); 
		//waitForElementToAppear(Auction_Clarification_Role);     
		WebElement AuctionClarificationRole = driver.findElement(Auction_Clarification_Role);
		String Role_Text = AuctionClarificationRole.getText();   
        if(Role_Text.contains("AUCTION CLARIFICATION:Level-1"))
        {
    		log.info("Auction Clarification Role Present in Role Setup");
        }
        else
        {
        	sa.fail("Auction Clarification Role Not Present in Role Setup"); 
        }
}
} 