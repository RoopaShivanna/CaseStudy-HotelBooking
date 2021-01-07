package pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import commonUtils.ExcelReader;
import commonUtils.TestBase;
//import cucumber.api.DataTable;
//import commonUtils.TestUtil;

public class HotelBookingPage extends TestBase {
	
	ExcelReader excelreader= new ExcelReader();
	
 //************************Locators in Hotel Booking Page*****************************************//
	
	@FindBy(id="txtFirstName")  public  WebElement firstName;
	@FindBy(id="txtLastName")   public WebElement lastName;
	@FindBy(id="txtEmail")      public WebElement email;
	@FindBy(id="txtPhone")       public WebElement phone;
	@FindBy(xpath="/html/body/div/div/form/table/tbody/tr[6]/td[2]/textarea") public WebElement address;
	@FindBy(name="city")        public WebElement selectCity;
	@FindBy(name="state")       public WebElement selectState;
	@FindBy(name="persons")     WebElement selectPersons;
	@FindBy(id="txtCardholderName") public WebElement cardHolderName;
	@FindBy(id="txtDebit")      public WebElement debitCardNumber;
	@FindBy(id="txtCvv")        public WebElement cvv;
	@FindBy(id="txtMonth")      public WebElement expirationMonth;
	@FindBy(id="txtYear")       public WebElement expirationYear;
	@FindBy(id="btnPayment")    public WebElement confirmBooking;
	@FindBy(xpath="//h2[contains(text(),'Hotel Booking Form')]") WebElement pageHeading;
	
	
	
	public HotelBookingPage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	

	
	//******************Actions in Hotel Booking Page********************************//
	
		public String validateHotelBookingPageTitle() {
			return driver.getCurrentUrl();
			
		}
		
		public boolean validateHotelBookingPage() {
			return pageHeading.isDisplayed();
			
		}




}

	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
