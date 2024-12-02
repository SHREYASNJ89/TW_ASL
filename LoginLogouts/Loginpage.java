package LoginLogouts;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Listeners.CheckPageReady;
import Listeners.SwitchWindows;
import TenderCreation.BasePage;
import generic.Auto_const;

public class Loginpage extends BasePage implements Auto_const {
	 By Username= By.id("uname");
	 By PassWord=By.name("pass1");
	
	 By Login=By.xpath("//tr[8]//td[1]//input[1]");//ASL
	 By loginbtn=By.id("btnLogin");
	 By PKICertificate=By.xpath("//frame[@name='top']"); 
	//By popclose=By.xpath("//span[contains(text(),'Close')]");

 
	//*****Department selection for CENTRALIZED SITE*********
	 By SelectDepartment=By.xpath("//td[contains(text(),'Select a Department/Government Agency')]");
	 By dep_dropdown=By.xpath("//a[@class='chzn-single chzn-default']");
	 By dep_value=By.xpath("//span[contains(text(),'Department of Atomic Energy')]");   
	 By dep_submit=By.xpath("//input[@value='Submit']");


	
	public Loginpage(WebDriver driver)
	{
		super(driver);
	} 
	
	/*Click og Login button  from the home page
	 * going to gin page
	 * enetring username and passwords and login
	 * 
	 * 
	 * 
	 */
	public void loginpage(String un,String pwd,String centralized,String Dept,String type) throws Exception
	
	{
		waitForElementToAppear(By.xpath("//div[contains(@au-target-id,'355') or contains(text(),'LOGIN') or contains(text(),'Login')]"));
		WebElement ty=	driver.findElement(By.xpath("//div[contains(@au-target-id,'355') or contains(text(),'LOGIN') or contains(text(),'Login')]"));
		javaScriptClick(ty);
		Thread.sleep(3000);
		CheckPageReady check=new CheckPageReady(driver);
		check.checkPageIsReady();
		
		 
		if(driver.findElement(By.xpath("//div[text()='Secure']")).isDisplayed())
		{
			WebElement e=driver.findElement(By.xpath("//iframe"));
			driver.switchTo().frame(e);
			waitVisibility(By.xpath("//input[@id='uname']"));
			WebElement er=driver.findElement(By.xpath("//input[@id='uname']"));
			javaScriptClick(er);
			er.sendKeys(un);
			Thread.sleep(1000);  
			WebElement et=driver.findElement(By.xpath("//input[@id='pwd']"));
			javaScriptClick(et);
			et.sendKeys(pwd);
			WebElement address=driver.findElement(By.xpath("//select[@id='Activity1']"));
			Select s1= new Select(address);
			s1.selectByVisibleText(type);
			waitForElementToAppear(By.xpath("//input[@id='btnLogin']"));
			WebElement bt=driver.findElement(By.xpath("//input[@id='btnLogin']"));
			javaScriptClick(bt);
		}
	
		else{
			Set<String> allWH=driver.getWindowHandles();
			for(String stng:allWH)
			{
			driver.switchTo().window(stng);
			if(driver.getTitle().contains("LoginPage"))
			{
				break;
			}
			}
			WebElement e=driver.findElement(By.xpath("//iframe"));
			driver.switchTo().frame(e);
			waitVisibility(By.xpath("//input[@id='uname']"));
			WebElement er=driver.findElement(By.xpath("//input[@id='uname']"));
			javaScriptClick(er);
			er.sendKeys(un);
			WebElement et=driver.findElement(By.xpath("//input[@id='pwd']"));
			javaScriptClick(et);
			et.sendKeys(pwd);
			WebElement address=driver.findElement(By.xpath("//select[@id='Activity1']"));
			Select s1= new Select(address);
			s1.selectByVisibleText(type);
			waitForElementToAppear(By.xpath("//input[@id='btnLogin']"));
			WebElement bt=driver.findElement(By.xpath("//input[@id='btnLogin']"));
			javaScriptClick(bt);
		}
		Thread.sleep(4000);
		SwitchWindows sd=new SwitchWindows(driver);
		sd.switchwindows();
		driver.manage().window().maximize();
		

/*if(!driver.findElements(By.xpath("//h2[text()='PKI Certificate Selection']")).isEmpty())
	{
		try{
		driver.findElement(By.xpath("//h2[text()='PKI Certificate Selection']"));
		Thread.sleep(4000);
		Runtime.getRuntime().exec(Authorize);
		Thread.sleep(15000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		check.checkPageIsReady();
	}
	*/

	
	
	   //*****Department selection for CENTRALIZED SITE*********
	if(centralized.contains("Yes"))
    {
		check.checkPageIsReady();
	   driver.switchTo().defaultContent();
	   if(driver.findElements(By.xpath("//frame[@name='right']")).isEmpty())
	   {
		     WebElement ele = driver.findElement(By.xpath("//frame[@name='active']"));
		        driver.switchTo().frame(ele);
	   }
	   else{
    WebElement ele = driver.findElement(By.xpath("//frame[@name='right']"));
    driver.switchTo().frame(ele);
	   }
    
    
    
    if(!driver.findElements(SelectDepartment).isEmpty())
    {
 	   WebElement d1=driver.findElement(dep_dropdown);
 	   d1.click();
 	   
 	   if(driver.findElements(By.xpath("//input[@type='text']") ).isEmpty())
 	   {
 		   Select s2=new Select(d1);
 		   s2.selectByVisibleText(Dept);
 	   }
 	   else{
 	   driver.findElement(By.xpath("//input[@type='text']") ).sendKeys(Dept);
 	   driver.findElement(By.xpath("//em[contains(text(),'"+Dept+"')]")).click();
 	   }
 	   driver.findElement(dep_submit).click();
    }
    }
    
    //*****     *********   *********
	   
	try{
	//driver.findElement(popclose).click();
	
	}
	
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
	
	}

public void loginpage1(String un,String pwd,String centralized,String Dept,String type) throws Exception
	
	{
		waitForElementToAppear(By.xpath("//div[contains(@au-target-id,'355') or contains(text(),'LOGIN') or contains(text(),'Login')]"));
		WebElement ty=	driver.findElement(By.xpath("//div[contains(@au-target-id,'355') or contains(text(),'LOGIN') or contains(text(),'Login')]"));
		javaScriptClick(ty);
		Thread.sleep(3000);
		CheckPageReady check=new CheckPageReady(driver);
		check.checkPageIsReady();
		
		 
		if(driver.findElement(By.xpath("//div[text()='Secure']")).isDisplayed())
		{
			WebElement e=driver.findElement(By.xpath("//iframe"));
			driver.switchTo().frame(e);
			waitVisibility(By.xpath("//input[@id='uname']"));
			WebElement er=driver.findElement(By.xpath("//input[@id='uname']"));
			javaScriptClick(er);
			er.sendKeys(un); 
			Thread.sleep(1000);  
			WebElement et=driver.findElement(By.xpath("//input[@id='pwd']"));
			javaScriptClick(et);
			et.sendKeys(pwd);
			WebElement address=driver.findElement(By.xpath("//select[@id='Activity1']"));
			Select s1= new Select(address);
			s1.selectByVisibleText("Auction");   
			//s1.selectByVisibleText(type); 
			waitForElementToAppear(By.xpath("//input[@id='btnLogin']"));
			WebElement bt=driver.findElement(By.xpath("//input[@id='btnLogin']"));
			javaScriptClick(bt);
		}
	
		else{
			Set<String> allWH=driver.getWindowHandles();
			for(String stng:allWH)
			{
			driver.switchTo().window(stng);
			if(driver.getTitle().contains("LoginPage"))
			{
				break;
			}
			}
			WebElement e=driver.findElement(By.xpath("//iframe"));
			driver.switchTo().frame(e);
			waitVisibility(By.xpath("//input[@id='uname']"));
			WebElement er=driver.findElement(By.xpath("//input[@id='uname']"));
			javaScriptClick(er);
			er.sendKeys(un);
			WebElement et=driver.findElement(By.xpath("//input[@id='pwd']"));
			javaScriptClick(et);
			et.sendKeys(pwd);
			WebElement address=driver.findElement(By.xpath("//select[@id='Activity1']"));
			Select s1= new Select(address);
			//s1.selectByVisibleText(type);
			s1.selectByVisibleText("Auction");   
			waitForElementToAppear(By.xpath("//input[@id='btnLogin']"));
			WebElement bt=driver.findElement(By.xpath("//input[@id='btnLogin']"));
			javaScriptClick(bt);
		}
		Thread.sleep(4000);
		SwitchWindows sd=new SwitchWindows(driver);
		sd.switchwindows();
		driver.manage().window().maximize();
		

/*if(!driver.findElements(By.xpath("//h2[text()='PKI Certificate Selection']")).isEmpty())
	{
		try{
		driver.findElement(By.xpath("//h2[text()='PKI Certificate Selection']"));
		Thread.sleep(4000);
		Runtime.getRuntime().exec(Authorize);
		Thread.sleep(15000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		check.checkPageIsReady();
	}
	*/

	
	
	   //*****Department selection for CENTRALIZED SITE*********
	if(centralized.contains("Yes"))
    {
		check.checkPageIsReady();
	   driver.switchTo().defaultContent();
	   if(driver.findElements(By.xpath("//frame[@name='right']")).isEmpty())
	   {
		     WebElement ele = driver.findElement(By.xpath("//frame[@name='active']"));
		        driver.switchTo().frame(ele);
	   }
	   else{
    WebElement ele = driver.findElement(By.xpath("//frame[@name='right']"));
    driver.switchTo().frame(ele);
	   }
    
    
    
    if(!driver.findElements(SelectDepartment).isEmpty())
    {
 	   WebElement d1=driver.findElement(dep_dropdown);
 	   d1.click();
 	   
 	   if(driver.findElements(By.xpath("//input[@type='text']") ).isEmpty())
 	   {
 		   Select s2=new Select(d1);
 		   s2.selectByVisibleText(Dept);
 	   }
 	   else{
 	   driver.findElement(By.xpath("//input[@type='text']") ).sendKeys(Dept);
 	   driver.findElement(By.xpath("//em[contains(text(),'"+Dept+"')]")).click();
 	   }
 	   driver.findElement(dep_submit).click();
    }
    }
    
    //*****     *********   *********
	   
	try{
	//driver.findElement(popclose).click();
	
	}
	
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
	
	}

	

}
