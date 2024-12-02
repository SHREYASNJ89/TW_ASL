package LoginLogouts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Listeners.CheckPageReady;
import TenderCreation.BasePage;

public class Homepage extends BasePage{
	

	 By Username= By.id("uname");
	 By PassWord=By.name("pass1");
	
	 By Login=By.xpath("//tr[8]//td[1]//input[1]");//ASL
	 By loginbtn=By.id("btnLogin");
	 By PKICertificate=By.xpath("//frame[@name='top']"); 
	By popclose=By.xpath("//span[contains(text(),'Close')]");


	//*****Department selection for CENTRALIZED SITE*********
	 By SelectDepartment=By.xpath("//td[contains(text(),'Select a Department/Government Agency')]");
	 By dep_dropdown=By.xpath("//a[@class='chzn-single chzn-default']");
	 By dep_value=By.xpath("//span[contains(text(),'Department of Atomic Energy')]");   
	 By dep_submit=By.xpath("//input[@value='Submit']");






	public Homepage(WebDriver driver)
	{
		super(driver);
	}

	/*This method is the handle home page
	 * up on url lauch, wait for the information pop up in the home and click the popup
	 * 
	 * 
	 */

	public  void homepage() throws Exception
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait=new WebDriverWait(driver, 50);
		WebDriverWait waite=new WebDriverWait(driver, 120);
		
		//check page is fully loaded
		CheckPageReady check=new CheckPageReady(driver);
		check.checkPageIsReady();
		
		try{
		waite.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Information' or text()='Scheduled Server Maintenance downtime' or text()='Useful Information']")));
		if(driver.findElements(By.id("AppTop")).isEmpty())
			{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='fa fa-times cst-icon-2']")));
			
			}
			else{
				WebElement fra=driver.findElement(By.id("AppTop"));
				driver.switchTo().frame(fra);
			}
		
			WebElement e1=driver.findElement(By.xpath("//i[@class='fa fa-times cst-icon-2']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", e1);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}	
}
