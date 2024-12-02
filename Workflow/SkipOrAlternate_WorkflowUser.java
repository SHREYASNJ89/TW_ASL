package Workflow;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import TenderCreation.BasePage;
import generic.Auto_const;

public class SkipOrAlternate_WorkflowUser extends BasePage implements Auto_const{
	
	static By workflowLineDetail = By.xpath("//img[@alt='WorkFlow Line Detail']");
	static By skipWorkflow=By.xpath("//img[contains(@title,'SKIP WORKFLOW')]");
	static By alterWorkflow=By.xpath("//img[contains(@title,'ALTER')]");
	static By remarks=By.xpath("//textarea[@name='remarks']");
	static By chooseFile=By.xpath("//input[@name='alterSkipFile' or @id='alterSkipFile']");
	static By submit=By.xpath("//input[@name='sub']");
	static By commite=By.id("committeeLink1");
	public SkipOrAlternate_WorkflowUser(WebDriver driver)
	{
		super(driver);
		
	}
	
	public void skipuser() throws Exception
	{	String path1=new java.io.File(".").getCanonicalPath();
		waitForElementToAppear(workflowLineDetail);
		driver.findElement(workflowLineDetail).click();
		
		waitForElementToAppear(skipWorkflow);
		driver.findElement(skipWorkflow).click();
		waitForAlertToAppear();
		Alert a=driver.switchTo().alert();
		a.accept();
		Thread.sleep(3000);
		Set<String> hand = driver.getWindowHandles();
		
		for(String ha:hand)
		{
			driver.switchTo().window(ha);
			String tit=driver.getTitle();
			if(tit.contains("WflLineDetail servlet"))
			{
				driver.switchTo().window(ha);
				driver.manage().window().maximize();
				break;
			}
			
		}
		driver.findElement(remarks).sendKeys("tfthfhuytruyttfth");
		WebElement sh=driver.findElement(chooseFile);
		javaScriptClick(sh);
		 Thread.sleep(4000);
         Runtime.getRuntime().exec(NormalUploadA+" "+path1+"\\Bids\\file1.xls");
         Thread.sleep(20000);
		driver.switchTo().defaultContent();
		driver.findElement(submit).click();
		
		waitForElementToAppear(commite);
		driver.findElement(commite).click();
		Thread.sleep(3000);
		//switch window

	Set<String> hand1 = driver.getWindowHandles();

	for(String ha1:hand1)
	{
		driver.switchTo().window(ha1);
		String tit=driver.getTitle();
		
		if(ha1.contains("CDwindow-846DBDD1C3FD8CC9DA4D623E9208D12C"))
		{
			driver.switchTo().window(ha1);
			driver.manage().window().maximize();
			Thread.sleep(2000);
			break;
		}
	}





	//driver.switchTo().window("CDwindow-846DBDD1C3FD8CC9DA4D623E9208D12C");

	waitForElementToAppear(By.xpath("//tr[3]//td[5]//img[1]"));
	driver.findElement(By.xpath("//tr[3]//td[5]//img[1]")).click();
	Thread.sleep(5000);
	waitForElementToAppear(By.xpath("//td[@id='light_content']//iframe"));
	WebElement e2=driver.findElement(By.xpath("//td[@id='light_content']//iframe"));
	driver.switchTo().frame(e2);
	Thread.sleep(4000);
	waitForElementToAppear(By.xpath("//td[contains(text(),'QTPWFU2')]/..//td//input"));
	driver.findElement(By.xpath("//td[contains(text(),'QTPWFU2')]/..//td//input")).click();

	if(!driver.findElements(By.name("submit1")).isEmpty());
	{
		List<WebElement> exd = driver.findElements(By.name("submit1"));
		
		for(WebElement er:exd)
		{
			if(er.isDisplayed());
			{
				er.click();
				break;
			}
		}
		
	}

driver.switchTo().defaultContent();
waitForElementToAppear(By.id("submitId"));
WebElement yu=driver.findElement(By.xpath("//input[@id='submitId' and @name='submit1']"));
javaScriptClick(yu);
waitForElementToAppear(By.xpath("//input[@value='Click here to close the Window']"));
driver.findElement(By.xpath("//input[@value='Click here to close the Window']")).click();
Set<String> tams=driver.getWindowHandles();
for(String ha1:tams)
{
	driver.switchTo().window(ha1);
	String tit=driver.getTitle();
	
	if(tit.contains("WflLineDetail servlet"))
	{
		driver.switchTo().window(ha1);
		System.out.println(driver.getTitle());
		Thread.sleep(4000);
		break;
	}
}

waitForElementToAppear(By.id("submitId"));
driver.findElement(By.id("submitId")).click();
waitForElementToAppear(By.xpath("//input[@value='Click here to close the Window']"));
driver.findElement(By.xpath("//input[@value='Click here to close the Window']")).click();

Thread.sleep(3000);
Set<String> hj = driver.getWindowHandles();

		for(String hg:hj)
		{
			driver.switchTo().window(hg);
			if(driver.getTitle().contains("TenderWizard"))
			{
				break;
			}
		
		}
		
	}
	
	
	public void alternate_user() throws Exception
	{	String path1=new java.io.File(".").getCanonicalPath();
		waitForElementToAppear(workflowLineDetail);
		driver.findElement(workflowLineDetail).click();
		
		waitForElementToAppear(alterWorkflow);
		driver.findElement(alterWorkflow).click();
		waitForAlertToAppear();
		Alert a=driver.switchTo().alert();
		a.accept();
		Thread.sleep(3000);
		Set<String> hand = driver.getWindowHandles();
		
		for(String ha:hand)
		{
			driver.switchTo().window(ha);
			String tit=driver.getTitle();
			if(tit.contains("WflLineDetail servlet"))
			{
				driver.switchTo().window(ha);
				driver.manage().window().maximize();
				break;
			}
			
		}
		driver.findElement(remarks).sendKeys("tfthfhuytruyttfth");
		WebElement sh=driver.findElement(chooseFile);
		javaScriptClick(sh);
		 Thread.sleep(4000);
         Runtime.getRuntime().exec(NormalUploadA+" "+path1+"\\Bids\\file2.xls");
         Thread.sleep(20000);
		driver.switchTo().defaultContent();
		driver.findElement(submit).click();
		
		waitForElementToAppear(commite);
		driver.findElement(commite).click();
		Thread.sleep(3000);
		//switch window

	Set<String> hand1 = driver.getWindowHandles();

	for(String ha1:hand1)
	{
		driver.switchTo().window(ha1);
		String tit=driver.getTitle();
		
		if(ha1.contains("CDwindow-846DBDD1C3FD8CC9DA4D623E9208D12C"))
		{
			driver.switchTo().window(ha1);
			driver.manage().window().maximize();
			Thread.sleep(2000);
			break;
		}
	}





	//driver.switchTo().window("CDwindow-846DBDD1C3FD8CC9DA4D623E9208D12C");

	waitForElementToAppear(By.xpath("//tr[3]//td[5]//img[1]"));
	driver.findElement(By.xpath("//tr[3]//td[5]//img[1]")).click();
	Thread.sleep(5000);
	waitForElementToAppear(By.xpath("//td[@id='light_content']//iframe"));
	WebElement e2=driver.findElement(By.xpath("//td[@id='light_content']//iframe"));
	driver.switchTo().frame(e2);
	Thread.sleep(4000);
	waitForElementToAppear(By.xpath("//td[contains(text(),'QTPWFU2')]/..//td//input"));
	driver.findElement(By.xpath("//td[contains(text(),'QTPWFU2')]/..//td//input")).click();
	Thread.sleep(4000);
	//waitForElementToAppear(By.xpath("//td[contains(text(),'QTPUSER_DU')]/..//td//input"));
	driver.findElement(By.xpath("//td[contains(text(),'QTPWFU3')]/..//td//input")).click();

	if(!driver.findElements(By.name("submit1")).isEmpty());
	{
		List<WebElement> exd = driver.findElements(By.name("submit1"));
		
		for(WebElement er:exd)
		{
			if(er.isDisplayed());
			{
				er.click();
				break;
			}
		}
		
	}

driver.switchTo().defaultContent();
waitForElementToAppear(By.id("submitId"));
WebElement yu=driver.findElement(By.xpath("//input[@id='submitId' and @name='submit1']"));
javaScriptScrolltoView(yu);
javaScriptClick(yu);
waitForElementToAppear(By.xpath("//input[@value='Click here to close the Window']"));
WebElement cv=driver.findElement(By.xpath("//input[@value='Click here to close the Window']"));
javaScriptClick(cv);
Set<String> tams=driver.getWindowHandles();
for(String ha1:tams)
{
	driver.switchTo().window(ha1);
	String tit=driver.getTitle();
	
	if(tit.contains("WflLineDetail servlet"))
	{
		driver.switchTo().window(ha1);
		System.out.println(driver.getTitle());
		Thread.sleep(4000);
		break;
	}
}

waitForElementToAppear(By.id("submitId"));
driver.findElement(By.id("submitId")).click();
waitForElementToAppear(By.xpath("//input[@value='Click here to close the Window']"));
driver.findElement(By.xpath("//input[@value='Click here to close the Window']")).click();

Thread.sleep(3000);
Set<String> hj = driver.getWindowHandles();

		for(String hg:hj)
		{
			driver.switchTo().window(hg);
			if(driver.getTitle().contains("TenderWizard"))
			{
				break;
			}
		
		}
		
	}

	
	
	public void switchWindows() throws Exception
	{
		Thread.sleep(3000);
		Set<String> handles = driver.getWindowHandles();
		for(String hd:handles)
		{
			Thread.sleep(2000);
			driver.switchTo().window(hd);
			
		}
	}

	
	
	
}
