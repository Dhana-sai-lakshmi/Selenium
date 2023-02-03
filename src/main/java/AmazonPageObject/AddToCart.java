package AmazonPageObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

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
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import creatingpagefactory.AbstractComponents;

public class AddToCart extends AbstractComponents{
	WebDriver driver;

	public AddToCart(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='add-to-cart-button']")
	WebElement Addtocart;
	
	@FindBy(xpath = "//input[@data-feature-id='proceed-to-checkout-action']")
	WebElement ProceedToCart;
	
	By proceedtocartwait1 = By.xpath("//span[@id='attach-sidesheet-checkout-button']/span/input");
	By proceedtocartwait2 = By.xpath("//div[@id='sw-atc-confirmation']//div[@id='sw-atc-actions']//input[@data-feature-id='proceed-to-checkout-action']");
	By proceedtocartwait3=By.xpath("//span[@id='attach-sidesheet-checkout-button']");
	
	@FindBy(xpath = "//span[@id='attach-sidesheet-checkout-button']")
	WebElement ProceedToCart3;
	
	@FindBy(xpath = "//div[@id='sw-atc-confirmation']//div[@id='sw-atc-actions']//input[@data-feature-id='proceed-to-checkout-action']")
	WebElement ProceedToCart2;
	
	@FindBy(xpath = "//span[@id='attach-sidesheet-checkout-button']/span/input")
	WebElement ProceedToCart1;
	
	
	
	
	public LogOut AddToCartclick() throws InterruptedException, IOException
	{
		Set<String> allwindows=driver.getWindowHandles();
		Iterator<String> it=allwindows.iterator();
		String parent=it.next();
		String Child=it.next();
		driver.switchTo().window(Child);
		Thread.sleep(3000);
		Addtocart.click();
		Thread.sleep(3000);	
		 if(ProceedToCart1.isDisplayed())
		{
			waitforeelementtoapper(proceedtocartwait1);
			ProceedToCart1.click();

		}else
		{
			waitforeelementtoapper(proceedtocartwait2);
			ProceedToCart2.click();
		}
			
		
		 /*else
		{
			waitforeelementtoapper(proceedtocartwait3);
			ProceedToCart3.click();
		}*/
		
		driver.switchTo().window(parent);
		
		File src2=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src2, new File("D:\\Amazon\\Screenshot2"));	
		
		LogOut logout = new LogOut(driver);
		Thread.sleep(3000);
		return logout;
	}
	
	

	


}
