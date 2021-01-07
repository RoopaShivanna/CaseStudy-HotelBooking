package stepdefs;


import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import com.cucumber.listener.Reporter;
import commonUtils.ExcelReader;
import commonUtils.TestBase;
import commonUtils.TestUtil;
import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.BookingCompletedPage;
import pages.HotelBookingPage;
import pages.LoginPage;

public class HotelBooking extends TestBase {
	
	
	LoginPage loginpage;
	HotelBookingPage hotelbookingpage = new HotelBookingPage();
	BookingCompletedPage bookingcompletedpage = new BookingCompletedPage();
	ExcelReader excelreader= new ExcelReader();
	
	
	public HotelBooking() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Given("^user opens browser$")
	public void user_opens_browser() throws Throwable {
	
	    //Initializing driver
		
		TestBase.intialization();
	    
	}

	@When("^user is on login page$")
	public void user_is_on_login_page() throws Throwable {
		loginpage = new LoginPage();
		System.out.println("**User is on Hotel Booking Application **"+loginpage.validateLoginPageTitle());
		
	}
	
	@When("^user clicks on login button without entering username/password display error message$")
	public void user_enters_wrong_username_and_password() throws Throwable {
	   //Error message Display after clicking login button without entering usename/password
	   System.out.println("Message Displayed When user clicks on login button without entering Usaername&Password:" +loginpage.getUsereErrMsg());
	   System.out.println("Message Displayed When user clicks  login button without entering Password:" +loginpage.getPwdeErrMsg("uname"));
	   loginpage.clearFields();
	}



	@Then("^user logged into the application after entering proper credentials$")
	public void user_enters_username_and_password() throws Throwable {
		//Successfull login flow
		loginpage.login(prop.getProperty("Username"), prop.getProperty("Password"));
	    
	}

	

	@Given("^user is on hotel booking form page$")
	public void user_is_on_hotel_booking_form_page() throws Throwable {
		
		Assert.assertTrue(hotelbookingpage.validateHotelBookingPage());
		System.out.println("**User Successfully Looged in to the Hotwl Booking Application**");
	
	    }
	
	@When("^user doesnot enter firstname and clicks on confirm booking$")
	public void user_doesnot_enter_firstname_and_clicks_on_confirm_booking() throws Throwable {
		
		// User clicks on Confirm booking without entering First name
		hotelbookingpage.confirmBooking.click();
		Alert alert=driver.switchTo().alert();
		String firstNameAlert=alert.getText();
		Assert.assertEquals("Please fill the First Name", firstNameAlert);
	    Thread.sleep(600);
	    alert.accept();
	    hotelbookingpage.firstName.sendKeys(excelreader.readData("FirstName"));
		 
		}

	@When("^user doesnot enter lastname and clicks on confirm booking$")
	public void user_doesnot_enter_lastname_and_clicks_on_confirm_booking() throws Throwable {
		
		// User clicks on Confirm booking without entering Last name
		hotelbookingpage.confirmBooking.click();
		Alert alert=driver.switchTo().alert();
		String laststNameAlert=alert.getText();
	    Assert.assertEquals("Please fill the Last Name", laststNameAlert);
	    Thread.sleep(600);
	    alert.accept();
	    hotelbookingpage.lastName.sendKeys(excelreader.readData("LastName"));
	    
	   
	}

	@When("^user enter wrong email and clicks on confirm booking$")
	public void user_enter_wrong_email_and_clicks_on_confirm_booking() throws Throwable {
		
		// User clicks on Confirm booking by entering invalid email
		hotelbookingpage.email.sendKeys("abc");
		hotelbookingpage.confirmBooking.click();
		Alert alert=driver.switchTo().alert();
		String emailAlert=alert.getText();
	    Assert.assertEquals("Please enter valid Email Id.", emailAlert);
	    Thread.sleep(600);
	    alert.accept();
	    hotelbookingpage.email.clear();
	    hotelbookingpage.email.sendKeys(excelreader.readData("Email"));
	}
	   
	  
	@When("^user enters  valid and invalid Phone number$")
	public void user_enters_invalid_Phone_number(DataTable phoneNums) throws Throwable {
		
		 // User enters Valid and Invalid Phone Number
		 List<List<String>> data =phoneNums.raw();
		 hotelbookingpage.phone.sendKeys(data.get(0).get(0));
		 hotelbookingpage.confirmBooking.click();
		 Alert alert=driver.switchTo().alert();
		 String PhoneNoAlert=alert.getText();
	     Assert.assertEquals("Please enter valid Contact no.", PhoneNoAlert);
	     Thread.sleep(1000);
	     alert.accept();
	     hotelbookingpage.phone.clear();
	     hotelbookingpage.phone.sendKeys(data.get(1).get(0));
	     hotelbookingpage.confirmBooking.click();
		 Assert.assertEquals("Please enter valid Contact no.", PhoneNoAlert);
		 Thread.sleep(1000);
	     alert.accept();
	     hotelbookingpage.phone.clear();
	     hotelbookingpage.phone.sendKeys(data.get(2).get(0));
	     hotelbookingpage.confirmBooking.click();
		 Assert.assertEquals("Please enter valid Contact no.", PhoneNoAlert);
		 Thread.sleep(1000);
	     alert.accept();
	     hotelbookingpage.phone.clear();
	     hotelbookingpage.phone.sendKeys(data.get(3).get(0));
	     hotelbookingpage.address.sendKeys(excelreader.readData("Address"));
		
	   
	}

	
	@When("^user clicks on confirm booking without selecting city$")
	public void user_clicks_on_confirm_booking_without_selecting_city() throws Throwable {
		
		//User clicks on confirm booking without selecting City
		hotelbookingpage.confirmBooking.click();
		Alert alert=driver.switchTo().alert();
		String cityAlert=alert.getText();
	    Assert.assertEquals("Please select city", cityAlert);
	    Thread.sleep(600);
	    alert.accept();
	    Select city = new Select(hotelbookingpage.selectCity);
		city.selectByIndex(2);
	     
	}

	@When("^user clicks on confirm booking without selecting state$")
	public void user_clicks_on_confirm_booking_without_selecting_state() throws Throwable {
		
		//User clicks on confirm booking without selecting State
		hotelbookingpage.confirmBooking.click();
		Alert alert=driver.switchTo().alert();
		String stateAlert=alert.getText();
	    Assert.assertEquals("Please select state", stateAlert);
	    Thread.sleep(600);
	    alert.accept(); 
	    Select state = new Select(hotelbookingpage.selectState);
		state.selectByIndex(1);
		
	}

	@When("^user clicks on confirm booking without entering card holder name$")
	public void user_clicks_on_confirm_booking_without_entering_card_holder_name() throws Throwable {
		
		//User clicks on confirm booking without entering Card Holder name
		hotelbookingpage.confirmBooking.click();
		Alert alert=driver.switchTo().alert();
		String cardHolderAlert=alert.getText();
	    Assert.assertEquals("Please fill the Card holder name", cardHolderAlert);
	    Thread.sleep(600);
	    alert.accept();
	    hotelbookingpage.cardHolderName.sendKeys(excelreader.readData("CardHolderName"));
	     
	    
	     
	}

	@When("^user clicks on confirm booking without entering debit card number$")
	public void user_clicks_on_confirm_booking_without_entering_debit_card_number(DataTable cardNumber) throws Throwable {
		
		//User clicks on confirm booking without entering Debit Card Number
		 List<List<String>> data =cardNumber.raw();
		 hotelbookingpage.confirmBooking.click();
		 Alert alert=driver.switchTo().alert();
		 String debitcardAlert=alert.getText();
		 Assert.assertEquals("Please fill the Debit card Number", debitcardAlert);
		 alert.accept();
		 hotelbookingpage.cardHolderName.sendKeys(excelreader.readData("CardHolderName"));
		 alert.accept();
		 hotelbookingpage.debitCardNumber.sendKeys(data.get(0).get(0));
		 hotelbookingpage.cvv.sendKeys(data.get(1).get(0));
		       
		 
	
	}

	@When("^user clicks on confirm booking without entering expiration month$")
	public void user_clicks_on_confirm_booking_without_entering_expiration_month(DataTable expMonth) throws Throwable {
		
		//User clicks on confirm booking without entering Expiration Month
		List<List<String>> data =expMonth.raw();
		hotelbookingpage.confirmBooking.click();
		Alert alert=driver.switchTo().alert();
		String expirationMonthAlert=alert.getText();
	    Assert.assertEquals("Please fill expiration month", expirationMonthAlert);
	    alert.accept();
	    hotelbookingpage.cardHolderName.sendKeys(excelreader.readData("CardHolderName"));
	    alert.accept();
	    hotelbookingpage.expirationMonth.sendKeys(data.get(0).get(0));
	}

	@When("^user clicks on confirm booking without entering expiration year$")
	public void user_clicks_on_confirm_booking_without_entering_expiration_year(DataTable expYear) throws Throwable {
		
		//User clicks on confirm booking without entering Expiration Year
		List<List<String>> data =expYear.raw();
		hotelbookingpage.confirmBooking.click();
		Alert alert=driver.switchTo().alert();
		String expirationYearAlert=alert.getText();
	    Assert.assertEquals("Please fill the expiration year", expirationYearAlert);
	    alert.accept();
	    hotelbookingpage.cardHolderName.sendKeys(excelreader.readData("CardHolderName"));
	    alert.accept();
	    hotelbookingpage.expirationYear.sendKeys(data.get(0).get(0));
	}




	
	@When("^user enters all the required deatils$")

	public void user_enters_all_the_required_deatils() throws Throwable {
		
		
        //user clicks on confirm booking by entering all required deatils
		hotelbookingpage.confirmBooking.click();
	   	} 

	@Then("^user successfully booked the hotel$")
	public void user_successfully_booked_the_hotel() throws Throwable {
		
	 // Successful Hotel Booking Message
	 Assert.assertEquals(bookingcompletedpage.validateBooking(), "Booking Completed!");
	 System.out.println("Hotel Booking Completed Successfully");
		
	   	}

	

}