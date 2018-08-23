package com.flight_Selection;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.constants.constants;
import com.relevantcodes.extentreports.ExtentTest;

import Driver.AppTest;
import io.github.bonigarcia.wdm.WebDriverManager;

import static io.github.bonigarcia.wdm.DriverManagerType.CHROME;
import static org.testng.Assert.assertEquals;
import org.testng.Assert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Flight_Selection {

	WebDriver driver;

	public Flight_Selection(WebDriver dr) {
		driver = dr;
	}

	@FindBy(xpath = constants.Location_From)
	WebElement Location_From;
	@FindBy(xpath = constants.Location_From_Place)
	WebElement Location_From_Place;
	@FindBy(xpath = constants.Location_to)
	WebElement Location_to;
	@FindBy(xpath = constants.Location_to_Place)
	WebElement Location_to_Place;
	@FindBy(xpath = constants.Return_box)
	WebElement Return_box;
	@FindBy(xpath = constants.Search)
	WebElement Search;
	@FindBy(xpath = constants.Book)
	WebElement Book;
	@FindBy(xpath = constants.Price_Filter)
	WebElement Price_Filter;

	public void Selection() throws Exception {

		try {
			driver.get("https://www.makemytrip.com/");

			WebDriverWait wait = new WebDriverWait(driver, 3000);
		    JavascriptExecutor jse = (JavascriptExecutor) driver;

			driver.navigate().refresh();
			Location_From.click();
			Thread.sleep(3000);
			Location_From_Place.click();

			Location_to.click();
			Thread.sleep(3000);
			Location_to_Place.click();

			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");

			// get current date time with Date()
			Date date = new Date();

			// Now format the date
			String date1 = dateFormat.format(date);

			String datearr[] = date1.split("/");

			int datenum = Integer.parseInt(datearr[1]) + 1;

			Return_box.click();
			driver.findElement(By.xpath("(//*[text()='" + datenum + "'])[3]")).click();

			String Location_url = driver.getCurrentUrl();
			Search.click();

			try {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(constants.Price_Filter)));
				Assert.assertNotEquals(Location_url, driver.getCurrentUrl());
				Price_Filter.click();
					
				jse.executeScript("arguments[0].click();",
						driver.findElement(By.xpath(constants.Price_Filter)));

				System.out.println("The Price Filter is working just Fine");
				// Assert.assertEquals(Price_Filter.getText().trim(),"PRICE");
			} catch (Exception e1) {
				System.out.println("The Error in Finding the Price Filter" + e1);
			}

			// wait until the element is visible and later execute as soon as the element
			// appears in DOM
			String Flights_url = driver.getCurrentUrl();

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(constants.Book)));
			Book.click();
			Thread.sleep(2000);
			try {
				Assert.assertNotEquals(Flights_url, driver.getCurrentUrl());
			} catch (Exception e1) {
				System.out.println(e1);
			}

		} catch (Exception e) {
			System.out.println("Error in the Flight Selction is " + e);
		}
	}
}
