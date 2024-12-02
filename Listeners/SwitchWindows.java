package Listeners;

import java.util.ResourceBundle.Control;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import TenderCreation.BasePage;
import TenderCreation.E92AttachDescription;
import junit.framework.Assert;

public class SwitchWindows extends BasePage{
	
	public SwitchWindows(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	private static Logger log = Logger.getLogger(SwitchWindows.class);
	public static void switchwindow_login() throws Exception{
		Thread.sleep(5000);
	    for(int i=0;i<=3;i++){
		Thread.sleep(3000);
		Set<String> allWH1=driver.getWindowHandles();
		if(allWH1.size()>1)
		{
			for(String stng:allWH1)
			{
				driver.switchTo().window(stng);
				driver.manage().window().maximize();
				String tt = driver.getTitle();
				if(tt.contains("Auction")|| tt.contains("Select Company")||tt.contains("TenderWizard"))
				{
					log.info("currently Control is on "+driver.getTitle());
					break;
				}
				
			}
		
		Thread.sleep(5000);
		String tt = driver.getTitle();
		if(tt.contains("Auction")|| tt.contains("Select Company")||tt.contains("TenderWizard"))
		{
			break;
		}
		
		}
		else{
			Thread.sleep(3000);
			String tt1=driver.getTitle();
			if(tt1.contains("Auction")|| tt1.contains("Select Company")||tt1.contains("TenderWizard"))
			{
				log.info("currently Control is on "+driver.getTitle());
				break;
			}
			
			if(i==3)
			{
				Assert.fail("No windown opened on click of login");
			}
		}
		
		}
	}
	
	
	
	public void switchwindows() throws InterruptedException
	{
		Set<String> lastWindow = driver.getWindowHandles();
		 try {
		 int l = lastWindow.size() - 1;

		 int inc = -1;
		 for (String win : lastWindow) 
		 {
		 inc++;

		 if (inc == l) 
		 {
		 driver.switchTo().window(win);
		 Thread.sleep(4000);
		 driver.manage().window().maximize();
		 System.out.println(driver.getTitle());
		 }

		 }
		 }
		 catch (Exception e)
		 {


		 }
	}
}
