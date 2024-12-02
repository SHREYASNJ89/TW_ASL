package Workflow;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

import Listeners.RandomString;
import LoginLogouts.Homepage;
import LoginLogouts.Loginpage;
import LoginLogouts.Logout;
import TenderAuctionSearch.TenderSearchInprogress;
import TenderCreation.BasePage;
import TenderOpneing.TechnicalOpening;

public class WfTechnoCommercialOpen extends BasePage{

	public WfTechnoCommercialOpen(WebDriver driver)
	{
		super(driver);
	}
	public void TechnoCommercialOpen (String tn) throws Exception
	 
	 {
		 Thread.sleep(2000);
		
			TenderSearchInprogress tend=new TenderSearchInprogress(driver);   
			tend.InProgress(tn);
		
			TechnicalOpening techi=new TechnicalOpening(driver);
			techi.TechOpen(tn);
		
			RandomString randomstring=new RandomString(driver);   
			String r1 = randomstring.randomString();                                       
			
		//entering noting number
		waitForElementToAppear(By.xpath("//input[@name='notingNo']"));
		WebElement etr=driver.findElement(By.xpath("//input[@name='notingNo']"));
		etr.sendKeys(r1);
		//entering remarks
		waitForElementToAppear(By.xpath("//textarea[@name='remarks']"));
		WebElement etr1=driver.findElement(By.xpath("//textarea[@name='remarks']"));
		etr1.sendKeys("TecnoCommercialopen"+r1+"enteredSuccessfully");
		//clicking on update button adn approve the same
		waitForElementToAppear(By.xpath("//input[@value='Update']"));
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		Thread.sleep(2000);
		waitForElementToAppear(By.xpath("//input[@name='nextStep']"));
		WebElement rock=driver.findElement(By.xpath("//input[@name='nextStep']"));
		Thread.sleep(2000);
		Actions act=new Actions(driver);
		act.moveToElement(rock).perform();
		Thread.sleep(2000);
		waitForElementToAppear(By.xpath("//a[contains(text(),'Approve')]"));
		driver.findElement(By.xpath("//a[contains(text(),'Approve')]")).click();
		waitForAlertToAppear();
		Alert a =driver.switchTo().alert();
		a.accept();
		Thread.sleep(8000);		
		 }  
}
