package VendorTenderSubmission;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import TenderCreation.BasePage;

public class VendorTenderSearch extends BasePage {
      
       
      static  By TendorSearch=By.xpath("//a[contains(text(), 'Tender Search')]");
     static  By TenderNumber=By.xpath("//input[@name='tender']");
    static  By Submit=By.xpath("//input[@id='submitId']");
    static By Search=By.xpath("//div[text()='Search']");
public VendorTenderSearch(WebDriver driver)
       {
              super(driver);
       }
       
       public   void vendortendorsearch(String an) throws InterruptedException
       {
    	  
    	  
    	  Thread.sleep(2000);
    	   
    	   
    	  	driver.switchTo().defaultContent();
    	  	WebElement ele1 = driver.findElement(By.xpath("//frame[@name='left']"));
              driver.switchTo().frame(ele1);
              if(!driver.findElement(TendorSearch).isDisplayed()){
              waitForElementToAppear(Search);
        	  driver.findElement(Search).click();}
              waitForElementToAppear(TendorSearch);
              driver.findElement(TendorSearch).click();
              driver.switchTo().defaultContent();
              waitForElementToAppear(By.xpath("//frame[@name='right']"));
              WebElement ele4 = driver.findElement(By.xpath("//frame[@name='right']"));
              driver.switchTo().frame(ele4);
             waitForElementToAppear(TenderNumber);
  			driver.findElement(TenderNumber).sendKeys(an);
              waitForElementToAppear(By.name("tenderStatus"));
              WebElement address=driver.findElement(By.name("tenderStatus"));
              Select s1= new Select(address);
              s1.selectByValue("UnApplied");
              waitForElementToAppear(Submit);
              driver.findElement(Submit).click();

}
}


