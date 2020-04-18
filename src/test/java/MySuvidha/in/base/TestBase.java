package MySuvidha.in.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import MySuvidha.in.utilities.ExcelReader;
import MySuvidha.in.utilities.ExtentManager;
import MySuvidha.in.utilities.TestUtil;


public class TestBase {
	
public static WebDriver driver;
public static Properties config= new Properties();
public static Properties orProperties= new Properties();
public static FileInputStream fis;
public static ExcelReader excelReader= new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\excels\\TestData.xlsx");
public static Logger log= Logger.getLogger("devpinoyLogger");
public ExtentReports rep= ExtentManager.getInstance();
public static ExtentTest test;
public static String browser;
	
    @BeforeSuite
	public void setUp()
	{
		
		if(driver==null)
		
		{
		
		try {
			
			fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			config.load(fis);
			log.debug("configuration file loaded!!!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	try {
		fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	try {
		orProperties.load(fis);
		
		log.debug("Object Repository OR file loaded!!!");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
  }
		
		if(System.getenv("browser")!=null && !System.getenv("browser").isEmpty() )
		{
			browser= System.getenv("browser");
						
		}else browser= config.getProperty("browser");
		
		config.setProperty("browser", browser);
		
		if(config.getProperty("browser").equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executable\\chromedriver.exe");
			driver= new ChromeDriver();
			log.debug("Chrome has been launched!!!");
			
		} else if(config.getProperty("browser").equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executable\\geckodriver.exe");
			driver= new ChromeDriver();
			
			
		}else if(config.getProperty("browser").equals("ie"))
		{
			
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executable\\IEDriverServer.exe");
			driver= new ChromeDriver();
		}
		
		driver.get(config.getProperty("testsiteurl"));
		log.debug("Facebook is opened!!!");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicitwait")), TimeUnit.SECONDS);
	}
	
	@AfterSuite
	public void tearDown()
	{
		if( driver!=null)
		{
			log.debug("Test Execution completed!!!");
		
			driver.quit();
		}
		
		
	}
	
public static void VerifyEquals(String actual, String Expected) throws IOException
{


	 try {
		
		 Assert.fail();
	} catch (Throwable t) {
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		TestUtil.captureScreenshot(); 
		System.out.println("path:"+ System.getProperty("user.dir"));
		Reporter.log("<a target=\"_blank\"  href= "+System.getProperty("user.dir")+"\\target\\"+TestUtil.screenshotName+"> screenshot </a>");
		 
		 
	}
	
}
	public void click(String locator)
	{
		if(locator.endsWith("_xpath")) {
		driver.findElement(By.xpath(orProperties.getProperty(locator))).click();
		}else if(locator.endsWith("_id")) {
		driver.findElement(By.id(orProperties.getProperty(locator))).click();
		}else if(locator.endsWith("_css")) {
			driver.findElement(By.cssSelector(orProperties.getProperty(locator))).click();
		}
			
		test.log(LogStatus.INFO, "clicking on "+ locator);
	}
	
	public void type(String locator,String value)
	{   if(locator.endsWith("_xpath")) {
		driver.findElement(By.xpath(orProperties.getProperty(locator))).sendKeys(value);
	}else if(locator.endsWith("_id")) {
		driver.findElement(By.id(orProperties.getProperty(locator))).sendKeys(value);		
	}else if(locator.endsWith("_css")) {
		driver.findElement(By.cssSelector(orProperties.getProperty(locator))).sendKeys(value);
		
	}
	
		test.log(LogStatus.INFO, "entering values of :" + value);
		
	}
	
	
	
	public boolean IsElementPresent(By by)
	{
	try {
		driver.findElement(by);
	return true;
	}
	catch(NoSuchElementException e) {
		
		return false;
	}
	
		
	}

}
