package Listeners;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility {
	
	public static String capturescreenshot(WebDriver driver,String screenshotname) throws IOException
	{
		try{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File Source=ts.getScreenshotAs(OutputType.FILE);
		String dest="./screenshots/"+screenshotname+".png";
		File Destination=new File(dest);
		FileUtils.copyFile(Source, Destination);
	    return dest;
		
	}
		
		
		
	catch(Exception e)
	{
		System.out.println("Exception while taking screenshot" +e.getMessage());
		return e.getMessage();
	}

}

}
