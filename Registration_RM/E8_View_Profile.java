package Registration_RM;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;
import Listeners.Scroll_Horizontal_Vertical;
import Listeners.VendorManagement;
import Listeners.switch_Windows; 
import TenderCreation.BasePage;
import generic.Auto_const; 

public class E8_View_Profile extends BasePage implements Auto_const
{
	static By Enabled_Vend=By.xpath("//div[@au-target-id='160']//div[@class='cst-right-top'][1]//div[contains(text(),'Enabled Vendors')]"); 
	static By Search_Cont=By.xpath("//div[@class='cst-s-form-container']"); 	
  	static By Search=By.xpath("//div[@class='cst-pg035-chart-filter-header']//div[@click.trigger='evtClickUpdateFilter()']"); 
  	static By User_ID=By.xpath("//div[@id='SEARCH_USERID']//div[@data-vid='id']//input[@value.bind='inputMdl']");
	static By Search_Button=By.xpath("//div[@class='cst-search-form-btn-container']//div[@class='cst-search-form-btn'][1]//div[@ref='pgElm']"); 
	static By View_Profile=By.xpath("//img[@alt='View Profile']");
	static String Print_Close= "D:\\AutomationWRKSPACE\\Tenderwizard\\src\\test\\resources\\AutoitScripts\\Printclose.exe"; 
	static String Vendor_Mngment= "D:\\AutomationWRKSPACE\\Tenderwizard\\src\\test\\resources\\AutoitScripts\\VendorManagementDB.exe"; 
	static String View_pro= "D:\\AutomationWRKSPACE\\Tenderwizard\\src\\test\\resources\\AutoitScripts\\ViewProfile.exe"; 

	static By FS_Manufacturer=By.xpath("//td[contains(text(),'IMM - Foreign Suppliers - Manufacturer')]");  
	static By FS_Manufacturer_Vend=By.xpath("//label[contains(text(),'IMM - Foreign Suppliers - Manufacturer')]");  
	static By Foreign_Suppliers_Stockist_Distributor_Vend=By.xpath("//label[contains(text(),'IMM - Foreign Suppliers - Stockist/Distributor')]");   
	static By Foreign_Suppliers_Stockist_Distributor=By.xpath("//td[contains(text(),'IMM - Foreign Suppliers - Stockist/Distributor')]");   
	static By Frame=By.xpath("//frame[@name='active' or @name='right']");  
	static By Left_Frame=By.xpath("//frame[@name='left']"); 
	static By AppTop=By.xpath("//iframe[@name='AppTop']"); 
	static By Header1=By.xpath("//div[@class='au-target cst-pg035-card-header']//div[3]"); 
	static By Qualified_Bidder=By.xpath("//a[@title='Techno Commercial Open']|//a[@title='Cost Open']|//a[@title='Cost Open Open']"); 
	static By Header2=By.xpath("//h2[contains(text(),'Bid Detail')]"); 
	static By Vendor_Name=By.xpath("(//td[@class='tdbodytext'])[1]//a");  
	static By USer_ID=By.xpath("//input[@id='SEARCH_USERID']");  
	static By Btn_Search=By.xpath("//input[@name='btnSearch']");   
	static By View_Profile1=By.xpath("//img[@alt='View Profile']"); 	
	static By Foreign1=By.xpath("(//div[@class='summary']//table//tbody//tr)[1]//td[2]"); 
	static By Nationality1=By.xpath("//select[@name='Nationality']"); 
	
	
	
		
	public static VendorManagement RS;    
	public static Scroll_Horizontal_Vertical SHV;  
	public static switch_Windows SW;   
	protected static SoftAssert as;    

private static Logger log = Logger.getLogger(E8_View_Profile.class);

public E8_View_Profile(WebDriver driver) 
{ 
	super(driver);   
} 

public  void Search_Vendor(SoftAssert sa, String VendN) throws Exception    
{
	driver.switchTo().defaultContent();
	WebElement f1=driver.findElement(Frame);   
	driver.switchTo().frame(f1);
	log.info("Switched to Right Frame");
	WebElement ID = driver.findElement(USer_ID);
	ID.sendKeys(VendN); 
	log.info("Vendor Name Entered Successfully"); 
	WebElement Button = driver.findElement(Btn_Search);
	Button.click();
	log.info("Search Button Clicked Successfully");
} 

public  ArrayList<String> View_Profile(SoftAssert sa) throws Exception         
{
	ArrayList<String> a6=new ArrayList<String>();   
	driver.switchTo().defaultContent(); 
	WebElement f1=driver.findElement(Frame);   
	driver.switchTo().frame(f1);
	log.info("Switched to Right Frame");
	WebElement VP = driver.findElement(View_Profile1); 
	VP.click(); 
	log.info("View Profile Clicked Successfully"); 
	SW=PageFactory.initElements(driver, switch_Windows.class); 	   
	SW.Switch();  
	Thread.sleep(8000);
    log.info("autoitstarts");
   Runtime.getRuntime().exec(Print_Close);   
   Thread.sleep(30000);
   log.info("autoit ends");  
   WebElement Nationality = driver.findElement(Foreign1);
   String Text= Nationality.getText();   
   log.info("Vendor Nationality: " + Text); 
   a6.add(Text);  
   Boolean FSM = driver.findElement(FS_Manufacturer).isDisplayed();   
   String s1=String.valueOf(FSM);  	
   log.info("FS Manufacturer is Displayed? : " + s1);   
   a6.add(s1); 
   Boolean FSSD = driver.findElement(Foreign_Suppliers_Stockist_Distributor).isDisplayed(); 
   String s2=String.valueOf(FSSD);   
   log.info("FS Stockist Distributor is Displayed? : " + s2); 
   a6.add(s2);   
   return a6;  
   
}

public  ArrayList<String> View_Profile_Bid_Detail_Page_FS_Manufacturer(SoftAssert sa) throws Exception    
{
	ArrayList<String> a4=new ArrayList<String>();  
	//waitForElementToAppear(Vendor_Name);        
	WebElement Vend_Name = driver.findElement(Vendor_Name);   
	Vend_Name.click();
	log.info("Vendor Name Clicked Successfully");   
	SW=PageFactory.initElements(driver, switch_Windows.class); 	   
	SW.Switch();  
	Thread.sleep(8000);
    log.info("autoitstarts");
   Runtime.getRuntime().exec(Print_Close);   
   Thread.sleep(30000);
   log.info("autoit ends");
   Boolean FSM = driver.findElement(FS_Manufacturer).isDisplayed();   
   String s1=String.valueOf(FSM);  	
   log.info("FS Manufacturer is Displayed? : " + s1); 
   a4.add(s1); 
   return a4;  
}
public  ArrayList<String> View_Profile_Bid_Detail_Page_FS_StockistDistributor(SoftAssert sa) throws Exception    
{
	ArrayList<String> a5=new ArrayList<String>();    	    
   Boolean FSSD = driver.findElement(Foreign_Suppliers_Stockist_Distributor).isDisplayed(); 
   String s2=String.valueOf(FSSD);   
   log.info("FS Stockist Distributor is Displayed? : " + s2); 
   a5.add(s2);   
   return a5;  
}

public  ArrayList<String> Vendor_Modify_Profile(SoftAssert sa) throws Exception         
{
	ArrayList<String> a7=new ArrayList<String>();   
	driver.switchTo().defaultContent(); 
	WebElement f1=driver.findElement(Frame);   
	driver.switchTo().frame(f1);
	log.info("Switched to Right Frame");   
   WebElement Nationality = driver.findElement(Nationality1); 
   String Text= Nationality.getText();   
   log.info("Vendor Nationality: " + Text);    
   Boolean FSM = driver.findElement(FS_Manufacturer_Vend).isDisplayed();   
   String s1=String.valueOf(FSM);  	
   log.info("FS Manufacturer is Displayed? : " + s1);   
   a7.add(s1); 
   Boolean FSSD = driver.findElement(Foreign_Suppliers_Stockist_Distributor_Vend).isDisplayed(); 
   String s2=String.valueOf(FSSD);      
   log.info("FS Stockist Distributor is Displayed? : " + s2); 
   a7.add(s2);    
   return a7;     
}
} 