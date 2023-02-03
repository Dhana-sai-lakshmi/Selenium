package AmazonPageObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import creatingpagefactory.AbstractComponents;

public class LogOut extends AbstractComponents {
	WebDriver driver;

	public LogOut(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(id= "nav-link-accountList-nav-line-1")
	WebElement Signoutoptions;
	@FindBy(xpath = "//span[text()='Sign Out']")
	WebElement Signoutclick;
	
	
	public void LogOutclick() throws IOException, InterruptedException
	{
		Thread.sleep(3000);	
		Actions act=new Actions(driver);
		act.moveToElement(Signoutoptions).perform();
		Signoutclick.click();
		Thread.sleep(2000);
		
	
		File src3=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	
		FileUtils.copyFile(src3, new File("D:\\\\Amazon\\\\Screenshot3"));
		
	}
	

	


}
