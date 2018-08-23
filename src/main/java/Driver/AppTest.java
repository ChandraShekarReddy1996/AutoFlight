package Driver;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.flight_Selection.Flight_Selection;
import com.relevantcodes.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import static io.github.bonigarcia.wdm.DriverManagerType.CHROME;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppTest {

	public static WebDriver driver;
	public static ExtentTest test;

	@BeforeSuite
	public void init() throws Exception {
		
	    WebDriverManager.getInstance(CHROME).setup();

		System.setProperty("webdriver.chrome.binary",System.getProperty("user.dir") +  "/Flight/src/main/java/com/chromeDriver/chromedriver");
		System.out.println(System.getProperty("user.dir"));
    	driver = new ChromeDriver();
    	com.flight_Selection.Flight_Selection booking = new Flight_Selection(null);
    	booking.Selection();
	}
	
}