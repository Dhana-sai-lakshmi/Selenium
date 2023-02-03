package Tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import AmazonPageObject.AddToCart;
import AmazonPageObject.Excel;
import AmazonPageObject.LogOut;
import AmazonPageObject.Login;
import AmazonPageObject.SearchItem;
import testcomponents.BaseTest;

public class StandAloneTest extends BaseTest {
	
       WebDriver driver;
	
	@Test(dataProvider = "drivenTest", dataProviderClass = Excel.class)
	public void Amazon(String Email, String Password) throws IOException, InterruptedException {
	    //launchingUrl();
		SearchItem si=login.AmazonSignIn(Email, Password);
		AddToCart ac =si.search();
		LogOut logout=ac.AddToCartclick();
		logout.LogOutclick();	
	}

}
