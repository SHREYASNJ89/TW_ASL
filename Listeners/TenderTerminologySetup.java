package Listeners;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import TenderCreation.BasePage;


public class TenderTerminologySetup extends BasePage 
{	
	By admin=By.xpath("//div[text()='Admin']");
	By setup=By.xpath("//a[text()=' SetUp']");
	By TerminologySetup=By.xpath("(//a[contains(text(),'Terminology')])[1]");
	
	public TenderTerminologySetup(WebDriver driver)
	{
		super(driver);
	}
	public  void Setup() throws Exception
	{
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		WebElement ele = driver.findElement(By.xpath("//frame[@name='left']"));
		driver.switchTo().frame(ele);
		WebDriverWait wait1=new WebDriverWait(driver, 60);
		if(!driver.findElement(setup).isDisplayed()){
		wait1.until(ExpectedConditions.visibilityOfElementLocated(admin));
		driver.findElement(admin).click();
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(setup));
		driver.findElement(setup).click();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		WebElement f1=driver.findElement(By.name("right"));
		driver.switchTo().frame(f1);
		
		wait1.until(ExpectedConditions.visibilityOfElementLocated(TerminologySetup));
		driver.findElement(TerminologySetup).click();
		Thread.sleep(5000);
		WebElement TenderTerminologySetup = driver.findElement(By.xpath("//a[contains(text(),'Tendering Terminology Setup')]"));
		TenderTerminologySetup.click();
	}
}