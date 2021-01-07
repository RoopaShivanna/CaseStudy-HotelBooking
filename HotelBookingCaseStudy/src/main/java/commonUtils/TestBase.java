package commonUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	
	
	public TestBase() throws IOException {
		
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\lr548299\\eclipse-workspace\\Mvn_framework-Artifact\\HotelBookingCaseStudy\\src\\main\\java\\configuration\\config.properties");
	    prop.load(fis);
	    
	}

	//Driver Initialization
	
 public static void intialization() {
	 
	 String browserName = prop.getProperty("browser");
	 
	 if (browserName.equals("chrome")) {
		 
		 System.setProperty("webdriver.chrome.driver", "C:\\ProgramData\\Drivers\\chromedriver.exe"); 
		 
			driver = new ChromeDriver();
		
	 }
	 
	 driver.manage().window().maximize();
	 driver.manage().deleteAllCookies();
	 driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_Timeout, TimeUnit.SECONDS);
	 driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_wait,TimeUnit.SECONDS);
	 
	 driver.get(prop.getProperty("url"));
	 
		
	 
 }

 

}
