package SeptemberOctober2021;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import TenderCreation.BasePage;

public class PopUpmssageCSGeneration extends BasePage {

	private static Logger log = Logger.getLogger(CPWDTenderfreeview.class);
	
	By bideval=By.xpath("//img[@alt='Bid Evaluation']");
	//static By techopen=By.xpath("//a[text()='Techno Commercial Open Evaluation']");
	 By techopen=By.xpath("//a[contains(text(),'Technical Bid Open Evaluation') or contains(text(),'Techno Commercial Open Evaluation') or contains(text(),'Bid Opening Date and Time Evaluation')]");
	public PopUpmssageCSGeneration(WebDriver driver)
	{
		super(driver);
	}
	
	
	public  String evaluation() throws Exception
	{
		driver.switchTo().defaultContent();
		waitForElementToAppear(By.xpath("//frame[@name='right']"));
		WebElement ele1 = driver.findElement(By.xpath("//frame[@name='right']"));
		driver.switchTo().frame(ele1);
		
		if(!driver.findElements(bideval).isEmpty());
		{
		 Actions act=new Actions(driver);
		 WebElement ele=driver.findElement(bideval);
		 act.moveToElement(ele).perform();
		 Thread.sleep(4000);
		
		if(!driver.findElements(techopen).isEmpty());
		
		{
		  WebElement tec=driver.findElement(techopen);
		  javaScriptClick(tec);
		}}
		waitForAlertToAppear();
		
		Alert a=driver.switchTo().alert();
		log.info(a.getText());
		a.accept();
		return a.getText();
	}
}
