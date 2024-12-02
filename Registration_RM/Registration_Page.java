package Registration_RM;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import Listeners.Scroll_Horizontal_Vertical;
import Listeners.switch_Windows; 
import TenderCreation.BasePage;
import generic.Auto_const; 

public class Registration_Page extends BasePage implements Auto_const
{
	static By Register=By.xpath("//div[contains(text(),'New User Sign In')]|(//div[contains(text(),'Register')])[1]"); 
	static By Nationality_REG=By.xpath("//label[@for='Nationality']"); 
  	static By Nationality_Drop_Down=By.xpath("//select[@name='Nationality']"); 
	static By Is_GST_App=By.xpath("//label[@for='IsGSTapplicable']");	
	static By GST_Number=By.xpath("//label[@for='GSTRegistrationNumber']"); 
	static By PAN=By.xpath("//label[@id='lblPANNo']");
	static String TnC_AIT ="D:\\AutomationWRKSPACE\\Tenderwizard\\src\\test\\resources\\AutoitScripts\\TermsandConditions.exe";   
	static By FS_Manufacturer=By.xpath("//label[@for='IMMForeignSuppliersManufacturer']"); 
	static By FS_Stockist_Distributer=By.xpath("//label[@for='IMMForeignSuppliersStockistDistributor']");   
	static By Frame=By.xpath("//frame[@name='active' or @name='right']"); 
	static By Right_Frame=By.xpath("//frame[@name='right']"); 
	static By AppTop=By.xpath("//iframe[@name='AppTop']");  
	static By TnC=By.xpath("//div[@id='txtTermsAndConditions']");         
	static By Reg_Policy=By.xpath("//input[@id='REG_POLICY']");  
	static By id_Proceed=By.xpath("//input[@id='btnProceed']"); 
	
	
	public static switch_Windows RS;   
	public static Scroll_Horizontal_Vertical SHV;    
 
		

private static Logger log = Logger.getLogger(Registration_Page.class);

public Registration_Page(WebDriver driver)
{
	super(driver);   
} 

public  void RegistrationPage(SoftAssert sa) throws Exception  
{
	/*driver.switchTo().defaultContent();
	WebElement f1=driver.findElement(AppTop);  
	driver.switchTo().frame(f1);
	log.info("Switch to AppTop Frame");*/  
	Thread.sleep(3000);
	WebElement Reg = driver.findElement(Register);
	Reg.click();
	log.info("Registration Clicked Successfully");
	RS=PageFactory.initElements(driver, switch_Windows.class); 	  
	RS.Switch(); 
	Thread.sleep(3000);
	log.info("Registration Link Clicked Successfully"); 
	driver.manage().window().maximize();
	log.info("Registration Page Maximized");	
}

public  void Terms_and_Conditions(SoftAssert sa) throws Exception   
{   
	SHV=PageFactory.initElements(driver, Scroll_Horizontal_Vertical.class);  
	SHV.Scroll_Vertical(); 
	Thread.sleep(5000); 
	log.info("Scrolling of page Successfull");
	Thread.sleep(10000);
    log.info("autoitstarts");
   Runtime.getRuntime().exec(TnC_AIT); 
   Thread.sleep(45000); 
   log.info("autoit ends");         
	log.info("Registration Policy Scroll down successfull");  
	Thread.sleep(15000);     
	waitForElementToAppear(Reg_Policy); 
	WebElement RP = driver.findElement(Reg_Policy); 
	RP.click();
	log.info("Registration Policy Checkbox click successfull");
	waitForElementToAppear(id_Proceed); 
	WebElement proceed = driver.findElement(id_Proceed); 
	proceed.click(); 
	log.info("Proceed Button Clicked Successfully");  	
}

public  void Nationality_Field_In_Registration_Page(SoftAssert sa,String Value1) throws Exception  
{
	//driver.switchTo().defaultContent();
	//WebElement f1=driver.findElement(Right_Frame);  
	//driver.switchTo().frame(f1);
	//log.info("Switch to Right Frame");
	Thread.sleep(3000);
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(Nationality_REG)); 
	waitForElementToAppear(Nationality_Drop_Down);  
	WebElement National_DD = driver.findElement(Nationality_Drop_Down);
	Select S1 = new Select(National_DD); 
	S1.selectByVisibleText(Value1);   
}
public  ArrayList<String> Is_GST_Applicable(SoftAssert sa) throws Exception  
{
	ArrayList<String> a8=new ArrayList<String>();
	//driver.switchTo().defaultContent();
	//WebElement f1=driver.findElement(Right_Frame); 
	//driver.switchTo().frame(f1);
	//log.info("Switch to Right Frame"); 
	Thread.sleep(3000);
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(Is_GST_App)); 
	if(driver.findElement(Is_GST_App).isDisplayed())    
	{
		log.info("Is GST applicable Field Present"); 
		//boolean Value1 = driver.findElements(Is_GST_App).isEmpty(); 
		boolean value2 = driver.findElement(Is_GST_App).isEnabled(); 
		String s1=String.valueOf(value2);  		  
		log.info("Is GST applicable Field Displayed: " + s1);  
		a8.add(s1);  
	}
	else
	{
		sa.fail("Is GST applicable Field Unavailable");     
	}
	return a8; 
}

public  ArrayList<String> Is_GST_Applicable_For_Foreign_Vendor(SoftAssert sa) throws Exception  
{
	ArrayList<String> a17=new ArrayList<String>(); 
	Thread.sleep(3000);  
	if(!driver.findElement(Is_GST_App).isDisplayed())     
	{
		log.info("Is GST applicable Field Not Present");  
		boolean valueFV1 = driver.findElement(Is_GST_App).isDisplayed(); 
		String sFV1=String.valueOf(valueFV1);  		  
		log.info("Is GST applicable Field Displayed: " + sFV1);  
		a17.add(sFV1);    
	} 
	else
	{
		sa.fail("Is GST applicable Field available");     
	}
	return a17;  
}
public  ArrayList<String> GST_Registration_Number(SoftAssert sa) throws Exception  
{
	ArrayList<String> a9=new ArrayList<String>();
	Thread.sleep(3000);
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(GST_Number));  
	if(driver.findElement(GST_Number).isDisplayed())
	{
		//boolean Value2 = driver.findElements(GST_Number).isEmpty();
		boolean Value2 = driver.findElement(GST_Number).isEnabled();
		String s2=String.valueOf(Value2);  		 
		log.info("GST Number Field Field Displayed: " + s2);   
		a9.add(s2); 
	} 
	else
	{
		sa.fail("GST Number Field Unavailable");  
	}
	return a9;
}
public  ArrayList<String> GST_Registration_Number_For_Foreign_Vendor(SoftAssert sa) throws Exception  
{
	ArrayList<String> a18=new ArrayList<String>();  
	Thread.sleep(3000);  
	if(!driver.findElement(GST_Number).isDisplayed())     
	{
		log.info("GST Registration Number Field Not Present");  
		boolean valueFV2 = driver.findElement(GST_Number).isDisplayed(); 
		String sFV2=String.valueOf(valueFV2);  	 	  
		log.info("GST Registration Number Field Displayed: " + sFV2);  
		a18.add(sFV2);    
	} 
	else
	{
		sa.fail("GST Registration Number Field available");     
	}
	return a18;   
} 
public  ArrayList<String> PAN_Number(SoftAssert sa) throws Exception  
{ 
	ArrayList<String> a10=new ArrayList<String>();
	Thread.sleep(3000);
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(PAN));  
	if(driver.findElement(PAN).isDisplayed()) 
	{
		log.info("PAN Number Field Present");
		//boolean Value3 = driver.findElements(PAN).isEmpty();
		boolean Value3 = driver.findElement(PAN).isEnabled(); 
		String s3=String.valueOf(Value3);  		 
		log.info("PAN Number Field Displayed: " + s3);   
		a10.add(s3);  
	} 
	else
	{
		sa.fail("PAN Number Field Unavailable");  
	}
	return a10; 
}

public  ArrayList<String> PAN_Number_For_Foreign_Vendor(SoftAssert sa) throws Exception  
{
	ArrayList<String> a19=new ArrayList<String>();  
	Thread.sleep(3000);  
	if(!driver.findElement(PAN).isDisplayed())     
	{
		log.info("PAN Number Field Not Present");  
		boolean valueFV3 = driver.findElement(PAN).isDisplayed(); 
		String sFV3=String.valueOf(valueFV3);  	 	  
		log.info("PAN Number Field Displayed: " + sFV3);  
		a19.add(sFV3);     
	} 
	else
	{
		sa.fail("PAN Number Field available");     
	}
	return a19;    
}

public  ArrayList<String> IMM_Foreign_Bidder_Manufacturer_Field_For_Indian_Vendor(SoftAssert sa) throws Exception   
{
	ArrayList<String> a20=new ArrayList<String>();  
	Thread.sleep(3000);
	if(!driver.findElement(FS_Manufacturer).isDisplayed())   
	{
		log.info("Foreign Bidder Manufacturer Field Not Present"); 
		boolean ValueFM1 = driver.findElement(FS_Manufacturer).isDisplayed();
		String FBM1=String.valueOf(ValueFM1);    		 
		log.info("Foreign Bidder Manufacturer Field Displayed: " + FBM1);   
		a20.add(FBM1); 
	} 
	else
	{
		sa.fail("Foreign Bidder Manufacturer Field available");          
	} 
	return a20;
}

public  ArrayList<String> IMM_Foreign_Bidder_Stockist_Distributor_Field_For_Indian_Vendor(SoftAssert sa) throws Exception   
{
	ArrayList<String> a21=new ArrayList<String>();  
	Thread.sleep(3000);
	if(!driver.findElement(FS_Stockist_Distributer).isDisplayed())     
	{
		log.info("Foreign Bidder Manufacturer Field Present"); 
		boolean ValueFM2 = driver.findElement(FS_Stockist_Distributer).isDisplayed();
		String FBSD1=String.valueOf(ValueFM2);   	 	 
		log.info("Foreign Bidder Stockist Distributer Field Displayed: " + FBSD1); 
		a21.add(FBSD1);    
	} 
	else
	{
		sa.fail("Foreign Bidder Stockist Distributer Field available");        
	} 
	return a21; 
}

public  ArrayList<String> IMM_Foreign_Bidder_Stockist_Distributor_Field_For_Foreign_Vendor(SoftAssert sa) throws Exception   
{	
	ArrayList<String> a15=new ArrayList<String>();
	Thread.sleep(3000);
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(FS_Stockist_Distributer));
	waitForElementToAppear(FS_Stockist_Distributer);   
	if(driver.findElement(FS_Stockist_Distributer).isDisplayed())    
	{
		log.info("Foreign Bidder Stockist Distributor Field Present"); 
		boolean ValueFBSD = driver.findElement(FS_Stockist_Distributer).isDisplayed();
		String FB_SD=String.valueOf(ValueFBSD);   		 
		log.info("Foreign Bidder Stockist Distributer Field Present: " + FB_SD);  
		a15.add(FB_SD); 
 	} 
	else
	{
		sa.fail("Foreign Bidder Stockist Distributor Field Unavailable");      
	}
	return a15; 
}



public  ArrayList<String> IMM_Foreign_Bidder_Manufacturer_Field_For_Foreign_Vendor(SoftAssert sa) throws Exception  
{
	ArrayList<String> a16=new ArrayList<String>();
	Thread.sleep(3000);
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(FS_Manufacturer));
	waitForElementToAppear(FS_Manufacturer);   
	if(driver.findElement(FS_Manufacturer).isDisplayed())    
	{
		log.info("Foreign Bidder Manufacturer Field Present"); 
		boolean ValueFBSD = driver.findElement(FS_Stockist_Distributer).isDisplayed();
		String FB_SD=String.valueOf(ValueFBSD);   		 
		log.info("Foreign Bidder Manufacturer Field Present: " + FB_SD);  
		a16.add(FB_SD); 
 	} 
	else
	{
		sa.fail("Foreign Bidder Manufacturer Field Unavailable");      
	}
	return a16;    
}  
}