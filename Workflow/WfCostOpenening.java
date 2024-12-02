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
import TenderCreation.BasePage;
import TenderOpneing.CostOpen;

public class WfCostOpenening extends BasePage{
	
	static By workflowLineDetail = By.xpath("//img[@alt='WorkFlow Line Detail']");
	 public WfCostOpenening(WebDriver driver)
	 {
		super(driver);
	 }
	 public void workflowCostOpenening(String tn) throws Exception
	   {
		  
				Thread.sleep(2000);
				CostOpen c1=new CostOpen(driver);
				c1.costOpening(tn,"Yes");
				RandomString randomstring=new RandomString(driver);
				String r1 = randomstring.randomString();
				try{
					waitForAlertToAppear();
					Alert as=driver.switchTo().alert();
					as.accept();
				}
				
				catch(Exception e)
				{
					e.printStackTrace();
				}
				//noting no
				waitForElementToAppear(By.xpath("//input[@name='notingNo']"));
				WebElement etr=driver.findElement(By.xpath("//input[@name='notingNo']"));
				etr.sendKeys(r1+"costopenapproval");
				waitForElementToAppear(By.xpath("//textarea[@name='remarks']"));
				WebElement etr1=driver.findElement(By.xpath("//textarea[@name='remarks']"));
				etr1.sendKeys("costopenApproval"+r1+"remarksentered");
				driver.findElement(By.xpath("//input[@value='Update']")).click();
				Thread.sleep(2000);
				waitForElementToAppear(By.xpath("//input[@name='nextStep']"));
				WebElement rock=driver.findElement(By.xpath("//input[@name='nextStep']"));
				Thread.sleep(2000);
				Actions act=new Actions(driver);
				act.moveToElement(rock).perform();
				Thread.sleep(2000);
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
	   
	   
	   
}
