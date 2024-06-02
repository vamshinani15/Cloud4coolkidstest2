package testBase;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class BaseClass {
	public static WebDriver driver;
	public static Logger logger;
	
	@BeforeSuite
	public void setUp() {
		logger=LogManager.getLogger(this.getClass());
		driver=new ChromeDriver();
		driver.get("https://cloud4coolkids.com/");
		logger.info("***********Launched cloud4coolkids Webpage**********");
		driver.manage().window().maximize();
	}
	
	public String captureScreen(String tname)  {

		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		
		TakesScreenshot ss=(TakesScreenshot) driver;
		File source=ss.getScreenshotAs(OutputType.FILE);
		String destination= System.getProperty("user.dir")+"\\screenshots\\"+tname+timeStamp+".png";
		
		try {
			FileUtils.copyFile(source, new File(destination));
		}catch(Exception e) {
			e.getMessage();
		}
		return destination;
	}
	
	@AfterSuite
	public void tearDown() {
		driver.quit();
	}
}
