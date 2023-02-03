package AmazonPageObject;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import creatingpagefactory.AbstractComponents;

public class Excel   {

	
	/*
	 * @Test(dataProvider="drivenTest",priority=1)
	 * 
	 * public void data(String Email,String Password) throws IOException { Excel
	 * ex=new Excel(); ex.getExceldata(); System.out.println(Email+""+Password); }
	 */
	 
	 

	@DataProvider(name = "drivenTest")
	public Object[][] getExceldata() throws IOException 
	{
		DataFormatter formatter = new DataFormatter();
		FileInputStream fis = new FileInputStream("D:\\Amazon\\AmazonUserNamePassword.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheetname = wb.getSheetAt(0);
		int rownumbers = sheetname.getPhysicalNumberOfRows();
		XSSFRow row = sheetname.getRow(0);
		int columncount = row.getLastCellNum();
		Object[][] data = new Object[rownumbers - 1][columncount];
		for (int i = 0; i < rownumbers - 1; i++)
            {
			row = sheetname.getRow(i + 1);
			for (int j = 0; j < columncount; j++) 
			{
				XSSFCell cell = row.getCell(j);
				data[i][j] = formatter.formatCellValue(cell);
				
			}
		}
		
		return data;
	}

}
