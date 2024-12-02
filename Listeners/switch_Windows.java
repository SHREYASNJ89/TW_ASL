package Listeners;

import java.util.ArrayList;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import R3P2_2022.E88_VerifyVendorProfileInBidDetailPage;
import TenderCreation.BasePage;

public class switch_Windows extends BasePage
{
	public switch_Windows(WebDriver driver)
	{
		super(driver);
	}
	public void Switch() throws InterruptedException
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
