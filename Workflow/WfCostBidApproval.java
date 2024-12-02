package Workflow;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Listeners.RandomString;
import LoginLogouts.Homepage;
import LoginLogouts.Loginpage;
import LoginLogouts.Logout;
import TenderAuctionSearch.TenderSearchOpen;
import TenderCreation.BasePage;

public class WfCostBidApproval extends BasePage {
	
	
	 public WfCostBidApproval(WebDriver driver)
	 {
		 super(driver);
	 }
	
	
	
	 public void CostBidApproval(String tn) throws Exception
	   {
		  
			
				Thread.sleep(3000);
				TenderSearchOpen tendopen=new TenderSearchOpen(driver);
				tendopen.Open(tn);
				RandomString randomstring=new RandomString(driver);
				String r1 = randomstring.randomString();
				waitForElementToAppear(By.xpath("//img[@alt='Bid Approval']"));
				driver.findElement(By.xpath("//img[@alt='Bid Approval']")).click();
				
			
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
	   
	   
	   
}
