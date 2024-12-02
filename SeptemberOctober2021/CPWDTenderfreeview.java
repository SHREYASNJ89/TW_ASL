package SeptemberOctober2021;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Listeners.CheckPageReady;
import TenderCreation.BasePage;
import TenderCreation.E92AttachDescription;

public class CPWDTenderfreeview extends BasePage {
	
	static By Etenders=By.xpath("//div[text()='E-Tenders']");
	static By OpenedTenders=By.xpath("//div[text()='Opened Tenders']");
	
	static By labelRegion=By.xpath("//th[contains(text(),'Region')]");
	static By labelZone=By.xpath("//th[contains(text(),'Zone')]");
	static By labelDivision=By.xpath("//th[contains(text(),'Division')]");
	static By labelCircle=By.xpath("//th[contains(text(),'Circle')]");
	
	static By region=By.id("regions-values");
	static By zone=By.id("zones-values");
	static By division=By.id("division-values");
	static By circle=By.id("circle-values");
	
	private static Logger log = Logger.getLogger(CPWDTenderfreeview.class);
	public CPWDTenderfreeview(WebDriver driver)
	{
		super(driver);
	}
	
	public  void cPWDfreeview() throws Exception
	{
		CheckPageReady check=new CheckPageReady(driver);
		check.checkPageIsReady();
		Thread.sleep(4000);
		try{
		waitForElementToAppear(Etenders);
			
			WebElement et=driver.findElement(Etenders);
			Actions act=new Actions(driver);
			act.moveToElement(et).perform();
			act.moveToElement(driver.findElement(OpenedTenders)).click();
			act.perform();
			
			Set<String> allWH=driver.getWindowHandles();
			String parent = driver.getWindowHandle();
			
			for(String stng:allWH){
				driver.switchTo().window(stng);
				String title = driver.getTitle();
				System.out.println(title);				}
		
			Thread.sleep(5000);
			log.info("CPWD tender free view  screen displayed");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			
			
			
			
	
	}
	
	public static void verify_newfeildsLabels()
	{
	try{
		Assert.assertFalse(driver.findElements(labelRegion).isEmpty(), 
				"Region lable is displayed");
		Assert.assertFalse(driver.findElements(labelZone).isEmpty(), 
				"Zone lable isdisplayed");
		Assert.assertFalse(driver.findElements(labelCircle).isEmpty(), 
				"circle lable isdisplayed");
		Assert.assertFalse(driver.findElements(labelDivision).isEmpty(), 
				"Division lable isdisplayed");
		log.info("Region, Zone, Circle and Division field labels are displayed");
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	}
	
	public static void verify_newfeilds()
	{
		try{
		// verifying region dropdown options
		WebElement rg=driver.findElement(region);
		Select s=new Select(rg);
		List<WebElement> oop = s.getOptions();
		ArrayList<String> kl=new ArrayList<String>();
		for(WebElement e:oop)
		{
		String tx = e.getText();
		kl.add(tx);
		}
		
		for( int i=0;i<kl.size();i++ ){
		if(kl.contains("ER")||kl.contains("WR")||kl.contains("SR")||kl.contains("NR")||kl.contains("DR")||kl.contains("Select"))
		{
			log.info("region dropdown contains "+kl.get(i));
		}
		}
		
		WebElement zn=driver.findElement(zone);
		Select s1=new Select(zn);
		List<WebElement> zz = s1.getOptions();
		Assert.assertEquals(zz.size(),1);
		
		WebElement cl=driver.findElement(circle);
		Select s2=new Select(cl);
		List<WebElement> cr = s2.getOptions();
		Assert.assertEquals(cr.size(),1);
		
		WebElement dv=driver.findElement(division);
		Select s3=new Select(dv);
		List<WebElement> dn = s3.getOptions();
		Assert.assertEquals(dn.size(),1);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}
	
		
	public static void validate_zonedropdown()
	{
		try{WebElement rg=driver.findElement(region);
		Select s=new Select(rg);
		s.selectByVisibleText("ER");
		if(getOptions(zone)>1){
			log.info("zone dropdown values are prompted based on region selected");}
			else{
				Assert.assertFalse(getOptions(circle)==2, "no zone values present");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	public static void validate_circledropdown()
	{
		try{
		WebElement rg=driver.findElement(region);
		Select s=new Select(rg);
		s.selectByVisibleText("ER");
		WebElement zn=driver.findElement(zone);
		Select s1=new Select(zn);
		s1.selectByValue("EZ I");
		if(getOptions(circle)>1){
		log.info("circle dropdown values are prompted based on region and zone selected");}
		else{
			Assert.assertFalse(getOptions(circle)==2, "no circle values present");
		}}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	public static void validate_divisiondropdown()
	{
		try{
		WebElement rg=driver.findElement(region);
		Select s=new Select(rg);
		s.selectByVisibleText("ER");
		WebElement zn=driver.findElement(zone);
		Select s1=new Select(zn);
		s1.selectByVisibleText("EZ I");
		WebElement cr=driver.findElement(circle);
		Select s3=new Select(cr);
		s3.selectByVisibleText("SILIGURI CENTRAL CIRCLE");
		if(getOptions(division)>1){
		log.info("division dropdown values are prompted based on region,zone and circle selected");}
		else{
			Assert.assertFalse(getOptions(circle)==2, "no circle values present");
		}}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static int getOptions(By ele)
	{
		WebElement el=driver.findElement(ele);
		Select s=new Select(el);
		List<WebElement> op = s.getOptions();
		int val = op.size();
		if(op.size()>1)
		{
			return val;
		}
		else{
			return 1;
		}
		/*ArrayList<String> kl=new ArrayList<String>();
		for(WebElement e:op)
		{
		String tx = e.getText();
		kl.add(tx);
		}
		for( int i=0;i<kl.size();i++ ){
		log.info(kl.get(i));
		}
		*/
		
	}
	
}
