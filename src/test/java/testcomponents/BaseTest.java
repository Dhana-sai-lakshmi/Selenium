package testcomponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WrapsDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import AmazonPageObject.Login;
import creatingpagefactory.AbstractComponents;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public static WebDriver driver;
	public Login login;	
	public WebDriver Browser() throws IOException
	{
	
		Properties pro=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources.properties");
		pro.load(fis);
		String BrowserName=pro.getProperty("browser");
		if(BrowserName.equalsIgnoreCase("chromedriver"))		
		{
			//WebDriverManager.chromedriver().setup();
		    System.setProperty(BrowserName,"D:\\eclipse-workspace\\Jars\\Drivers\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
			
			
		}else if(BrowserName.equalsIgnoreCase("firefoxdriver"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			
			
		}else if(BrowserName.equalsIgnoreCase("edgedriver"))
		{
			WebDriverManager.edgedriver().setup();	
			driver=new EdgeDriver();
			
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		return driver;		
	}
	
	public String getscreenshot(String Testcase) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File sc=ts.getScreenshotAs(OutputType.FILE);
		File fs=new File(System.getProperty("user.dir")+"//reportamazon"+Testcase+".png");
		FileUtils.copyFile(sc, fs);
		return fs.toString();
		//return System.getProperty("user.dir")+"//reports"+testCaseName+".png";
	}
	
	/*public static void takeScreenshot(String fileName) throws IOException {
		
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);	
		String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());	
		File destFile = new File(System.getProperty("user.dir")+
		"/Screenshots/TestCases/Flipkart/"+fileName+"_"+timestamp+"/"+fileName+"_"+timestamp+".png");
		FileUtils.copyFile(sourceFile, destFile);
		System.out.println("Screenshot saved successfully");
		
		}*/

	
	
	@BeforeMethod(alwaysRun=true)
	public Login launchingUrl() throws IOException
	{
		driver=Browser();
		login=new Login(driver);
		login.goTo();
		return login;
	   
	}
	

	@AfterMethod(alwaysRun=true)
	public void tearDown() throws IOException
	{
		
		driver.quit();
	}


}
