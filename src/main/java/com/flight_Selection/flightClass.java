package com.flight_Selection;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import Driver.AppTest;

public class flightClass extends AppTest {

	@Test
	public void flight() throws Exception {
	    Flight_Selection flight_Seelction = PageFactory.initElements(driver, Flight_Selection.class);
		flight_Seelction.Selection();
	}
}
