package stepdefinitions;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.FlipkartPage;

public class Flipkart {
	WebDriver driver;
	FlipkartPage flipkart = new FlipkartPage(driver);

	@Given("Open Google  and run in {string}")
	public void open_google_and_add_the_case_for_cross_browsers_firefox_and_chrome(String string) {
		flipkart.launchUrlAndVerify(string);
		driver = common_functions.Utils.getDriver();
		flipkart = new FlipkartPage(driver);
	}

	@When("Search for Flipkart")
	public void search_for_flipkart() {
		flipkart.enterInSearch("flipkart");
	}

	@Then("Write all the search options displayed in the console from googles search field while we write Flipkart in that")
	public void write_all_the_search_options_displayed_in_the_console_from_googles_search_field_while_we_write_flipkart_in_that() {
		flipkart.getSuggestions();
	}

	@Then("Press enter to give out the search results and open the link for the flipkart website available")
	public void press_enter_to_give_out_the_search_results_and_open_the_link_for_the_flipkart_website_available() {
		flipkart.clickOnSearch();
		flipkart.clickOnFlipkart();
	}

	@Then("Close the login popup on the website if available")
	public void close_the_login_popup_on_the_website_if_available() {
		flipkart.closeLoginPopup();
	}

	@Then("Click on TV & Appliances dropdown button and Navigate to Air Conditioners  Window ACs page")
	public void click_on_tv_appliances_dropdown_button_and_navigate_to_air_conditioners_window_a_cs_page() {
		flipkart.goToItem("Appliances");
		flipkart.chooseAppliancesItem("Air Conditioners");
		flipkart.clickAppliancesItem("Window ACs");
	}

	@Then("Click on the Add To Compare checkbox of the second third and sixth products displayed")
	public void click_on_the_add_to_compare_checkbox_of_the_second_third_and_sixth_products_displayed() {
		flipkart.selectCompareCheckBox(2);
		flipkart.selectCompareCheckBox(3);
		flipkart.selectCompareCheckBox(6);
	}

	@Then("Click on the COMPARE button")
	public void click_on_the_compare_button() {
		flipkart.clickCompareButton();
	}

	@Then("Print Name and price of all three products in the console")
	public void print_name_and_price_of_all_three_products_in_the_console() {
		flipkart.printProductNameandPrice();
	}

	@Then("Add all the three products into the cart one by one")
	public void add_all_the_three_products_into_the_cart_one_by_one() {
		flipkart.addToCart();
	}

	@Then("Go to the cart and add your area Pincode and check the availability of the product delivery there")
	public void go_to_the_cart_and_add_your_area_pincode_and_check_the_availability_of_the_product_delivery_there() {
		flipkart.enterPinCode("132103");
		flipkart.clickCheckButton();
	}

	@Then("Print the message getting displayed for the availability delivery of the product in the console")
	public void print_the_message_getting_displayed_for_the_availability_delivery_of_the_product_in_the_console() {
		flipkart.printMessage();
	}

	@Then("Click the Deliver to input box available to the top of the page and add another pin code and check the availability of the product delivery there")
	public void click_the_deliver_to_input_box_available_to_the_top_of_the_page_and_add_another_pin_code_and_check_the_availability_of_the_product_delivery_there() {
		flipkart.clickOnDropdown();
		flipkart.enterPinCode("411057");
		flipkart.clickCheckButton();
	}

	@Then("Print the message getting displayed for the availability delivery of the product in the console for the changed Pincode")
	public void print_the_message_getting_displayed_for_the_availability_delivery_of_the_product_in_the_console_for_the_changed_pincode() {
		flipkart.printMessage();
	}

	@Then("Close the browser")
	public void close_the_browser() {
		System.out.println("Hooks are handling the case of closing the browsers");
	}

}
