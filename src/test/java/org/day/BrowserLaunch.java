package org.day;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserLaunch {

    public static void main(String[] args) throws IOException {

	FileInputStream stream = new FileInputStream(
		"C:\\Users\\sabas\\OneDrive\\Pictures\\18-07-2023\\src\\test\\resources\\TestData\\datadriven read.xlsx");
	Workbook book = new XSSFWorkbook(stream);
	Sheet sheet = book.getSheet("Sheet1");
	for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
	    Row row = sheet.getRow(i);

	    for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
		Cell cell = row.getCell(j);

		DataFormatter dataFormatter = new DataFormatter();
		String formatCellValue = dataFormatter.formatCellValue(cell);
		System.out.println(formatCellValue);
	    }
	}
	WebDriver driver = WebDriverManager.chromedriver().create();
	driver.get("https://www.facebook.com/");
	WebElement txtUserName = driver.findElement(By.id("email"));
	txtUserName.sendKeys("Welcome Java");
	WebElement txtPassword = driver.findElement(By.id("pass"));
	txtPassword.sendKeys("Hi Java");

    }
}
