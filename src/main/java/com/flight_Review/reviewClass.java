package com.flight_Review;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.flight_Selection.Flight_Selection;

import Driver.AppTest;

public class reviewClass extends AppTest{

	@Test
	public void reviewFlight() throws Exception {
		flight_Review review =  PageFactory.initElements(driver, flight_Review.class);
		review.flight_Review();
	}
}
