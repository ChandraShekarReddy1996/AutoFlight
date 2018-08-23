package com.flight_Review;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.constants.constants;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class flight_Review {

	WebDriver driver;

	public flight_Review(WebDriver dr) {
		driver = dr;
	}

	@FindBy(xpath = constants.Grandtotal)
	WebElement Grandtotal;
	@FindBy(xpath = constants.Email)
	WebElement Email;
	@FindBy(xpath = constants.continue_as_guest)
	WebElement continue_as_guest;
	@FindBy(xpath = constants.Coupon)
	WebElement Coupon;

	public void flight_Review() throws Exception {
		 JavascriptExecutor jse = (JavascriptExecutor) driver;
		 
		try {
			//System.out.println("GRAND TOTAL : " + Grandtotal.getText());
			Email.sendKeys("d.chandrasheker1996@gmail.com");
			
			Thread.sleep(2000);
			Coupon.click();
			
			String Review_Url = driver.getCurrentUrl();
			Thread.sleep(2000);
			jse.executeScript("arguments[0].click();",
					driver.findElement(By.xpath(constants.continue_as_guest)));
			
			try {
				Assert.assertNotEquals(Review_Url, driver.getCurrentUrl());
			} catch (Exception e1) {
				System.out.println(e1);
			}

		} catch (Exception e) {
			System.out.println("Error While Reviewing The Flights : " + e);
		}

	}
}
