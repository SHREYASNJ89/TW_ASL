package Registration_RM;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import Listeners.Registration_Template_Setup;
import TenderCreation.BasePage;
import generic.Auto_const;

public class RM_Template extends BasePage implements Auto_const
{
	static By Modify_Temp=By.xpath("//tr[@templatename='E8 REGISTRATION TEMP AUTO']//td[6]//span[2]"); 
	static By Nationality_So=By.xpath("//tr[@txt='Nationality']//td[2]");
	static By Nationality=By.xpath("//tr[@txt='Nationality']");
	static By FS_MAN=By.xpath("//td[contains(text(),'IMM - Foreign Suppliers - Manufacturer')]");
	static By FS_Stoc_Dist=By.xpath("//td[contains(text(),'IMM - Foreign Suppliers - Stockist/Distributor')]");
	static By FS_MAN_So=By.xpath("//tr[@txt='IMM - Foreign Suppliers - Manufacturer']//td[2]");
	static By FS_Stoc_Dist_So=By.xpath("//tr[@txt='IMM - Foreign Suppliers - Stockist/Distributor']//td[2]"); 
	static By Frame=By.xpath("//frame[@name='active' or @name='right']");  
	static By Right_Frame=By.xpath("//frame[@name='right']"); 
	static By Is_GST_App=By.xpath("//td[contains(text(),'Is GST applicable')]"); 
	static By Is_GST_App_So=By.xpath("//tr[@txt='Is GST applicable']//td[2]"); 
	static By GST_Number=By.xpath("//td[contains(text(),'GST Registration Number')]"); 
	static By GST_Number_So=By.xpath("//tr[@txt='GST Registration Number']//td[2]"); 
	static By PAN_Number=By.xpath("//td[contains(text(),'PAN No')]");
	static By PAN_Number_So=By.xpath("//tr[@txt='PAN No']//td[2]"); 
	static By Go_Back=By.xpath("//input[@value='Go Back']");  
	static By Template_status=By.xpath("//tr[@templatename='E8 REGISTRATION TEMP AUTO']//td[2]//input[@id='selectTemplate']"); 
	static By FS_MAN_VP=By.xpath("//tr[@txt='IMM - Foreign Suppliers - Manufacturer']//td[11]//input[@class='viewprofilechkmandatory']"); 
	static By FS_Stoc_Dist_VP=By.xpath("//tr[@txt='IMM - Foreign Suppliers - Stockist/Distributor']//td[11]//input[@class='viewprofilechkmandatory']"); 
		 
	public static Registration_Template_Setup RS;  
		

private static Logger log = Logger.getLogger(RM_Template.class);

public RM_Template(WebDriver driver) 
{
	super(driver);   
} 

public  ArrayList<String> Nationality_Field_In_RM(SoftAssert sa, String Template_Name) throws Exception  
{
	ArrayList<String> a1=new ArrayList<String>();
	//RS=PageFactory.initElements(driver, Registration_Template_Setup.class); 	 
	//RS.Registration_Temp_Setup();
	//Thread.sleep(3000);
	//log.info("Registration Template Setup Setup Clicked Successfully");  
	driver.switchTo().defaultContent();
	WebElement f1=driver.findElement(Right_Frame); 
	driver.switchTo().frame(f1);
	log.info("Switch to Right Frame");  
	WebElement MT = driver.findElement(Modify_Temp);
	MT.click();
	log.info("Define and Modify Icon Clicked Successfully"); 
	Thread.sleep(3000);
	driver.switchTo().defaultContent();
	driver.switchTo().frame(f1);
	log.info("Switch to Right Frame");
	Thread.sleep(3000);
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(Nationality)); 
	waitForElementToAppear(Nationality_So);   
	if(!driver.findElements(Nationality_So).isEmpty()) //Not empty
	{
		boolean Value1 = driver.findElements(Nationality_So).isEmpty();   
		String s1=String.valueOf(Value1); 		 
		log.info("Nationality Field Sort Order Field is Empty? : " + s1);     
		a1.add(s1); 	
	}
	else
	{
		sa.fail("Nationality Field Sort Order is Not Defined");   
	}
	return a1;
}
public  ArrayList<String> IMM_Foreign_Suppliers_Manufacturer_Field_In_RM(SoftAssert sa) throws Exception  
{
	ArrayList<String> a2=new ArrayList<String>();
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(FS_MAN));  
	waitForElementToAppear(FS_MAN); 
	if(!driver.findElements(FS_MAN_So).isEmpty())  
	{
		boolean Value2 = driver.findElements(FS_MAN_So).isEmpty();
		String s2=String.valueOf(Value2); 		 
		log.info("IMM - Foreign Suppliers - Manufacturer Sort order Field is Empty?: " + s2);    
		a2.add(s2);  
	}
	else
	{
		sa.fail("IMM - Foreign Suppliers - Manufacturer Sort order is not Defined"); 
	}
	return a2; 
}
public  ArrayList<String> IMM_Foreign_Suppliers_Stockist_Distributor_Field_In_RM(SoftAssert sa) throws Exception  
{
	ArrayList<String> a3=new ArrayList<String>();
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(FS_Stoc_Dist));  
	waitForElementToAppear(FS_Stoc_Dist);   
	if(!driver.findElements(FS_Stoc_Dist_So).isEmpty())   
	{
		boolean Value3 = driver.findElements(FS_Stoc_Dist_So).isEmpty();
		String s3=String.valueOf(Value3); 		 
		log.info("IMM - Foreign Suppliers - Stockist/Distributor Field Sort order Field is Empty?: " + s3);   
		a3.add(s3);
	}
	else
	{
		sa.fail("IMM - Foreign Suppliers - Stockist/Distributor Sort order is Not Defined"); 
	}
	return a3;
}
public  ArrayList<String> Is_GST_Applicable_Field_In_RM(SoftAssert sa) throws Exception  
{
	ArrayList<String> a4=new ArrayList<String>(); 
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(Is_GST_App));  
	waitForElementToAppear(Is_GST_App);   
	if(!driver.findElements(Is_GST_App_So).isEmpty())   
	{
		boolean Value4 = driver.findElements(Is_GST_App_So).isEmpty();
		String s4=String.valueOf(Value4); 		 
		log.info("Is GST Applicable Field Sort order Field is Empty?: " + s4);   
		a4.add(s4);
	}
	else
	{
		sa.fail("Is GST Applicable Sort order is Not Defined");  
	}
	return a4;
}
public  ArrayList<String> GST_Number_Field_In_RM(SoftAssert sa) throws Exception  
{
	ArrayList<String> a5=new ArrayList<String>(); 
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(GST_Number));  
	waitForElementToAppear(GST_Number);   
	if(!driver.findElements(GST_Number_So).isEmpty())   
	{
		boolean Value5 = driver.findElements(GST_Number_So).isEmpty();
		String s5=String.valueOf(Value5); 		 
		log.info("GST NUmber Field Sort order Field is Empty?: " + s5);     
		a5.add(s5); 
	}
	else
	{
		sa.fail("GST NUmber Sort order is Not Defined");  
	}
	return a5;
}
public  ArrayList<String> PAN_Number_Field_In_RM(SoftAssert sa) throws Exception  
{
	ArrayList<String> a6=new ArrayList<String>(); 
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(PAN_Number));  
	waitForElementToAppear(PAN_Number);   
	if(!driver.findElements(PAN_Number_So).isEmpty())   
	{ 
		boolean Value6 = driver.findElements(PAN_Number_So).isEmpty();
		String s6=String.valueOf(Value6); 		 
		log.info("PAN Number Field Sort order Field is Empty?: " + s6);    
		a6.add(s6);  
	}
	else
	{
		sa.fail("PAN Number Sort order is Not Defined");   
	}
	return a6;
}
public  ArrayList<String> IMM_FS_MANUFACTURER_View_Profile_Checkbox_In_RM_Template(SoftAssert sa) throws Exception   
{
	ArrayList<String> a25=new ArrayList<String>(); 
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(FS_MAN));  
	waitForElementToAppear(FS_MAN);    
	if(!driver.findElements(FS_MAN_VP).isEmpty())    
	{  
		log.info("IMM FS MANUFACTURER Checkbox is present");  
		boolean MAN_Check = driver.findElement(FS_MAN_VP).isSelected();  
		String Fsm_Check=String.valueOf(MAN_Check); 		 
		log.info("IMM FS MANUFACTURER Checkbox is Selected?: " + Fsm_Check);    
		a25.add(Fsm_Check); 
	} 
	else
	{
		sa.fail("IMM FS MANUFACTURER Checkbox is Not present");    
	}
	return a25; 
}
public  ArrayList<String> IMM_FS_Stockist_Dist_View_Profile_Checkbox_In_RM_Template(SoftAssert sa) throws Exception   
{
	ArrayList<String> a26=new ArrayList<String>(); 
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(FS_Stoc_Dist));  
	waitForElementToAppear(FS_Stoc_Dist);     
	if(!driver.findElements(FS_Stoc_Dist_VP).isEmpty())    
	{ 
		log.info("IMM FS Stockist Distributor Checkbox is present");  
		boolean Stock_Dist_Check = driver.findElement(FS_Stoc_Dist_VP).isSelected(); 
		String FsSD_Check=String.valueOf(Stock_Dist_Check);  		 
		log.info("IMM FS Stockist Distributor Checkbox is Selected?: " + FsSD_Check);    
		a26.add(FsSD_Check);   
	}
	else
	{
		sa.fail("IMM FS Stockist Distributor Checkbox is Not present");    
	}
	return a26; 
}
public  ArrayList<String> RM_Template_Enabled_Status(SoftAssert sa) throws Exception  
{
	ArrayList<String> a7=new ArrayList<String>(); 
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(Go_Back));  
	waitForElementToAppear(Go_Back);   
	WebElement GoBack = driver.findElement(Go_Back);
	GoBack.click();
	log.info("Go Back Button Clicked");
	Thread.sleep(3000);
	if(!driver.switchTo().alert().getText().isEmpty())  
	{
		Thread.sleep(3000);
		log.info("Pop-up alert is Present"); 
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		log.info("Pop-up alert Closed Successfully");
	}
	else
	{
		Thread.sleep(3000);
	   		log.info("Pop-up alert Not Present ");
	}
	driver.switchTo().defaultContent();
	WebElement f1=driver.findElement(Right_Frame); 
	driver.switchTo().frame(f1);
	log.info("Switch to Right Frame"); 
	if(driver.findElement(Template_status).isDisplayed())    
	{ 
		log.info("RM Template is Displayed");   
		WebElement Value7 = driver.findElement(Template_status);
		boolean val1 = Value7.isSelected();
		String s7=String.valueOf(val1); 	 	 
		log.info("RM Template is Enabled: " + s7);    
		a7.add(s7);  
	}
	else
	{
		sa.fail("RM Template is Not Displayed");   
	}
	return a7;
}

}