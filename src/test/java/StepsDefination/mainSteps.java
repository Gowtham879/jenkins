package StepsDefination;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import Bus_pageObjects.BusDeparturePage;
import Bus_pageObjects.BusHomePage;
import Bus_pageObjects.SeatSlectionPage;
import Flight_pageObjects.FlightBookingHomePage;
import Flight_pageObjects.FlightDeparture;
import Flight_pageObjects.FlightReturn;
import Flight_pageObjects.FlightTravellers;
import OrangeHRM.loginPage;
import SeleniumCommands.AllCommands;
import Train_pageObjects.SeatBookinPage;
import Train_pageObjects.TrainDeparturePage;
import Train_pageObjects.TrainHomePage;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;

public class mainSteps extends AllCommands {
	AllCommands allcommand=new AllCommands();
//  ------------------OrangeHRM-----------------
	loginPage loginpage=new loginPage();
	
//	------------------FlightBooking------------------------------
	FlightBookingHomePage flighthome=new FlightBookingHomePage();
	FlightDeparture flightdepart=new FlightDeparture();
	FlightReturn flightreturn=new FlightReturn();
	FlightTravellers flighttravell=new FlightTravellers();
	
//  ------------------BusBooking--------------------------------
	BusHomePage bushome=new BusHomePage();
	BusDeparturePage busdepart=new BusDeparturePage();
	SeatSlectionPage busseat=new SeatSlectionPage();
	
// -------------------TrainBooking------------------------------
	TrainHomePage trainhome =new TrainHomePage();
	TrainDeparturePage traindepart=new TrainDeparturePage();
	SeatBookinPage trainseat=new SeatBookinPage();
//----------------------------------------------------------------	
	@Given("User is Open the OrangeHRM website")
	public void user_is_open_the_orange_hrm_website() {
	   allcommand.HRMBrower();
	}

	@When("User is entering the UserName and Password , click on login button")
	public void user_is_entering_the_user_name_and_password_click_on_login_button() {
	    loginpage.loginpage("Admin", "admin123");
	}

	@Then("Close the OrangeHRM and Open the EasyMyTrip")
	public void close_the_orange_hrm_and_open_the_easy_my_trip() {
		this.delayScript(2);
	    driver.close();
	}
//  --------------------------------Flight-----------------------------------
	@Given("User is able to launch the EasyMyTrip Website")
	public void user_is_able_to_launch_the_easy_my_trip_website() {
	   allcommand.openBrower();
	}

	@When("User is select the source {string} and destination {string}")
	public void user_is_select_the_source_and_destination(String Source, String Destination) {
	   flighthome.journy(Source, Destination);
	}

	@When("select the Departure date and Return Date")
	public void select_the_departure_date_and_return_date() {
	   flightdepart.currentDate();
	   this.delayScript(2);
	   flightreturn.returnDate();
	}

	@When("passenger details adults  and childs  and click on Search")
	public void passenger_details_adults_and_childs_and_click_on_search() {
	   flighttravell.deatils();
	}

	@Then("verify the Booking Page and close the Browser")
	public void verify_the_booking_page_and_close_the_browser() {
	    driver.close();
	}
//  -------------------------------------Bus-------------------------------------
	@When("User is select the Source and Destination, Date click on Search")
	public void user_is_select_the_source_and_destination_date_click_on_search() {
	    bushome.tickets();
	    this.delayScript(2);
	    busdepart.currentDate();
	}

	@When("slecect the bus and BoardingPoint and DropingPoint click on Continue")
	public void slecect_the_bus_and_boarding_point_and_droping_point_click_on_continue() {
	   busseat.SeatSelection();
	}

	@Then("Verify the Bus BookingPage and Close the browser")
	public void verify_the_bus_booking_page_and_close_the_browser() {
	   driver.close();
	}
//  -------------------------------------Train------------------------------------------
	@When("User is select the from {string} and to {string}")
	public void user_is_select_the_from_and_to(String from, String to) {
	  trainhome.traintickets(from, to);
	}

	@When("select Departuredate click Search")
	public void select_departuredate_click_search() {
	  traindepart.futureDate();
	}

	@When("Select the Coach and Book click on continue")
	public void select_the_coach_and_book_click_on_continue() {
	   trainseat.booking(); 
	}

	@Then("Verify the BookingPage and close the website")
	public void verify_the_booking_page_and_close_the_website() {
	   driver.close();
	}
	
	@AfterStep
	public void takeScreenshot(Scenario scenario) throws IOException {
		if(scenario.isFailed()) {
	    byte[] scrennshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	    Allure.addAttachment("ScreenShot", new ByteArrayInputStream(scrennshot));
}
}
}