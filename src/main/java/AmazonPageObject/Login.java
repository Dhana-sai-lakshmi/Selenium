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
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import creatingpagefactory.AbstractComponents;

public class Login extends AbstractComponents {
	WebDriver driver;

	public Login(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@data-csa-c-content-id='nav_ya_signin']")
	WebElement SignIn;
	@FindBy(id = "ap_email")
	WebElement EmailID;
	@FindBy(css = ".a-button-input")
	WebElement Continue;
	@FindBy(xpath = "//input[@id='ap_password']")
	WebElement Password;
	@FindBy(id = "signInSubmit")
	WebElement SignInClick;
	
	
	public SearchItem AmazonSignIn(String Email, String password) throws IOException 
	{
		SignIn.click();
		EmailID.sendKeys(Email);
		Continue.click();
		Password.sendKeys(password);
		
		File src1=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src1, new File("D:\\Amazon\\Screenshot1"));
		
		SignInClick.click();
		SearchItem si = new SearchItem(driver);
		return si;
	}

	

	public void goTo() {
		
		driver.navigate().to("https://www.amazon.in/");	

	}
	


}
