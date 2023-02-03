package AmazonPageObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import creatingpagefactory.AbstractComponents;

public class SearchItem extends AbstractComponents{
	WebDriver driver;

	public SearchItem(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(id = "twotabsearchtextbox")
	WebElement searchbox;
	@FindBy(id = "nav-search-submit-button")
	WebElement searchbutton;
	@FindBy(xpath = "//span[@class='a-size-medium a-color-base a-text-normal']")
	List<WebElement> Searchlist;
	@FindBy(xpath = "//span[@class='a-size-medium a-color-base a-text-normal']")
	WebElement firstelementclick;
	
	
	public AddToCart search() throws IOException {
		Properties pro=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources.properties");
		pro.load(fis);
		String Searchboxitem=pro.getProperty("Search");
		searchbox.sendKeys(Searchboxitem);
		searchbutton.click();
		
		for (int i = 0; i < Searchlist.size(); i++)
		{
			//System.out.println(Searchlist.get(i).getText()); 
			String[] name=Searchlist.get(i).getText().split("\\(");
			System.out.println(name[0]);
		
			//System.out.println(FormattedName);

		}
		firstelementclick.click();	
		 AddToCart ac = new AddToCart(driver);
	     return ac;
		}
	    
}
