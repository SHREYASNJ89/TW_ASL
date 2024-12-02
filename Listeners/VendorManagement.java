package Listeners;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import TenderCreation.BasePage;


public class VendorManagement extends BasePage 
{	
	By admin=By.xpath("//div[text()='Admin']");
	By vendor_management=By.xpath("//a[text()=' Vendor Mgmt']");
	By search_Name=By.xpath("//input[@id='SEARCH_NAME']");
	private static Logger log = Logger.getLogger(VendorManagement.class);

	public VendorManagement(WebDriver driver)
	{
		super(driver);
	}
	//public static Properties prop;
	//FileInputStream ip = new FileInputStream(“pass the path of test.properties text file”);

public void Vendor_Management() throws InterruptedException

{
	Thread.sleep(5000);
	driver.switchTo().defaultContent();
	WebElement ele = driver.findElement(By.xpath("//frame[@name='left']"));
	driver.switchTo().frame(ele);
	Thread.sleep(2000);
	if(driver.findElement(vendor_management).isDisplayed())
	{
		driver.findElement(vendor_management).click(); 
		Thread.sleep(2000);
	}
	else
	{
		    WebDriverWait wait1=new WebDriverWait(driver, 60);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(admin));
			driver.findElement(admin).click();
			Thread.sleep(2000);
			driver.findElement(vendor_management).click(); 
			Thread.sleep(2000);			
	}
	driver.switchTo().defaultContent();
	WebElement f1=driver.findElement(By.name("right"));
	driver.switchTo().frame(f1);
	WebElement Vendor_Name = driver.findElement(search_Name);
	if(Vendor_Name.isDisplayed())
	{
		log.info("Vendor name Field Present in Vendor Management Page");
		log.info("Vendor Management Page Verified");
	}
}
}