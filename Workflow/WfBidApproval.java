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

public class WfBidApproval extends BasePage{
	
	
	static By workflowLineDetail = By.xpath("//img[@alt='WorkFlow Line Detail']");
	static By Right_Frame=By.xpath("//iframe[@name='right']"); 

	 public WfBidApproval(WebDriver driver)
	 {
		super(driver);
	 }
	 public void bidApproval(String tn) throws Exception
	   {
		 
			  TenderSearchOpen tendopen=new TenderSearchOpen(driver);
				tendopen.Open(tn);
				
				RandomString randomstring=new RandomString(driver);
				String r1 = randomstring.randomString();  
				
				waitForElementToAppear(By.xpath("//img[@alt='Bid Approval']"));
				driver.findElement(By.xpath("//img[@alt='Bid Approval']")).click();
				//enter noting number
				waitForElementToAppear(By.xpath("//input[@name='notingNo']"));
				WebElement etr=driver.findElement(By.xpath("//input[@name='notingNo']"));
				etr.sendKeys(r1);
				waitForElementToAppear(By.xpath("//textarea[@name='remarks']"));
				WebElement etr1=driver.findElement(By.xpath("//textarea[@name='remarks']"));
				etr1.sendKeys("technicalBidApproval"+r1+"enteredSuccessfully");
				waitForElementToAppear(By.xpath("//input[@value='Update']"));
				driver.findElement(By.xpath("//input[@value='Update']")).click();
				Thread.sleep(2000);
				waitForElementToAppear(By.xpath("//input[@name='nextStep']"));
				WebElement rock=driver.findElement(By.xpath("//input[@name='nextStep']"));
				Actions act=new Actions(driver);
				act.moveToElement(rock).perform();
				waitForElementToAppear(By.xpath("//a[contains(text(),'Approve')]"));
				WebElement cli=	driver.findElement(By.xpath("//a[contains(text(),'Approve')]"));
				javaScriptClick(cli);
				Thread.sleep(2000);
				waitForAlertToAppear();
				Alert a =driver.switchTo().alert();
				a.accept();
				 waitForElementToAppear(workflowLineDetail);
				 Thread.sleep(2000);
			}
	 
	 public void rich_bidApproval(String tn) throws Exception
	 {
		 TenderSearchOpen tendopen=new TenderSearchOpen(driver);
		 tendopen.Open(tn);

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
		 waitForElementToAppear(By.xpath("//a[contains(text(),'Update')]"));
		 WebElement click= driver.findElement(By.xpath("//a[contains(text(),'Update')]"));
		 javaScriptClick(click);
		 Thread.sleep(2000);


		 // click on edit attachment[contains(text(),'Go to Edit Attachment')]
		 waitForElementToAppear(By.xpath("//input[@id='btnAction']"));
		 WebElement action_edit=driver.findElement(By.xpath("//input[@id='btnAction']"));
		 Actions act1=new Actions(driver);
		 act1.moveToElement(action_edit).perform();
		 waitForElementToAppear(By.xpath("//a[contains(text(),'Go to Edit Attachment')]"));
		 WebElement click1= driver.findElement(By.xpath("//a[contains(text(),'Go to Edit Attachment')]"));
		 javaScriptClick(click1);
		 Thread.sleep(5000);
		 
		 driver.switchTo().defaultContent();
		 WebElement ele = driver.findElement(By.xpath("//iframe[@name='right']"));   
    	 driver.switchTo().frame(ele);       

		 //Click on first check box to attach the doc
		 waitForElementToAppear(By.xpath(("(//input[@name='inputCheck'])[1]")));
		 WebElement click2= driver.findElement(By.xpath("(//input[@name='inputCheck'])[1]")); 
		 javaScriptClick(click2); 
		 //click2.click();
		 Thread.sleep(2000);

		 //click on attach tender documents

		 waitForElementToAppear(By.xpath(("(//input[@name='submit1'])[1]")));
		 WebElement click3= driver.findElement(By.xpath("(//input[@name='submit1'])[1]")); 
		javaScriptClick(click3);
		 //click3.click();  
		 Thread.sleep(2000);

		 //click on Approve
		 waitForElementToAppear(By.xpath("//input[@id='btnAction']"));
		 WebElement action_approve=driver.findElement(By.xpath("//input[@id='btnAction']"));
		 Actions act2=new Actions(driver);
		 act2.moveToElement(action_approve).perform();
		 waitForElementToAppear(By.xpath("//a[contains(text(),'Approve')]|//a[contains(text(),'Forward')]|//a[contains(text(),'Approve/Accept')]"));   
		 WebElement click4= driver.findElement(By.xpath("//a[contains(text(),'Approve')]|//a[contains(text(),'Forward')]|//a[contains(text(),'Approve/Accept')]"));     
		 javaScriptClick(click4);
		 waitForAlertToAppear();
		 Alert a=driver.switchTo().alert();     
		 a.accept();
		 waitForElementToAppear(workflowLineDetail);
Thread.sleep(2000);

	 }
	   
}
