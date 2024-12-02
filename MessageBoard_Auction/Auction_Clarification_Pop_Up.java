package MessageBoard_Auction;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
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

public class Auction_Clarification_Pop_Up extends BasePage implements Auto_const   
{
	static By Clarification_Dialogue_Box_Header=By.xpath("//div[@id='dialog']//div[@class='caption']//h1");   
	static By Clarification_Dialogue_Box_Ok=By.xpath("//input[@name='SkipAndContinue']");   
private static Logger log = Logger.getLogger(Auction_Clarification_Pop_Up.class);
	
	public Auction_Clarification_Pop_Up(WebDriver driver)
	{
		super(driver);  
	}  	 
	
	//To check Auction Clarification Pop-up at vendor end 
	public  void Clarification_pop_up_Vendor(SoftAssert sa) throws Exception  
	{
		String MainWindow=driver.getWindowHandle();				
		    Set<String> s1=driver.getWindowHandles();		
		Iterator<String> i1=s1.iterator();		
				
		while(i1.hasNext())			
		{		
		    String ChildWindow=i1.next();		
		    		
		    if(!MainWindow.equalsIgnoreCase(ChildWindow))			
		    {    		
		            // Switching to Child window
		            driver.switchTo().window(ChildWindow);
					Thread.sleep(3000);  
					log.info("Switched to Child Window Successfully");	
		            WebElement Dialogue_HeaderText = driver.findElement(Clarification_Dialogue_Box_Header);
		            String PopUp_Text = Dialogue_HeaderText.getText();
		            if(PopUp_Text.contains("Here's your Pre-Live/Pre-Award Clarification asked by Department. Please reply"))
		            {
					Thread.sleep(2000);  
					log.info("Auction clarification Pop-up verified Successfully");	
		            driver.findElement(Clarification_Dialogue_Box_Ok).click();	
					Thread.sleep(3000);  
					log.info("Auction clarification Pop-up Closed Successfully");
		            }
		            else
		            {
		            	sa.fail("Auction clarification Pop-up Unavailable"); 
		            }
		    }		
		}		
		// Switching to Main Window.
		    driver.switchTo().window(MainWindow);	
			log.info("Switched to Main Window Successfully");	
		}
}