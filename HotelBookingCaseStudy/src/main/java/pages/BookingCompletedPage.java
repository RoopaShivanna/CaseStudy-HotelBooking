package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonUtils.TestBase;

public class BookingCompletedPage extends TestBase {
	
	//Locators in Booking Completed Page
	
	@FindBy(xpath="//h1[contains(text(),'Booking Completed!')]")
	WebElement bookingComplete;

	public BookingCompletedPage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	//Actions in Booking Completed Page
	
	public String validateBooking() {
		return bookingComplete.getText();
	}
	
}
