package stepdefinitions;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import driverFactory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.MyBusinessPage;
import utils.ConfigReader;
import utils.Constant;

public class MyBusinessStep {

	private WebDriver driver;
	private LoginPage loginPage;
	private MyBusinessPage myBusinessesPage = new MyBusinessPage(DriverFactory.getDriver());


	@Given("User is on the Home page")
	public void user_is_on_the_home_page() {
		DriverFactory.getDriver().get(ConfigReader.getProperty("url"));
		LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
		myBusinessesPage = loginPage.dologin(Constant.EMAILID, Constant.PASSWORD);
	}

	@When("User clicks on the My Businesses button")
	public void user_clicks_on_the_my_businesses_button() {
		myBusinessesPage.clickMyBusinessesButton();
	}

	@When("User clicks on the Add Business button")
	public void user_clicks_on_the_add_business_button() {
		myBusinessesPage.clickAddBusinessButton();
	}

	@When("User verify the Add Business navigation")
	public void user_verify_the_add_business_navigation() {
		myBusinessesPage.clickAddBusinessButton();
	}

	@And("User enters new business name {string}")
	public void user_enters_new_business_name(String businessName) {
		myBusinessesPage.enterBusinessName(businessName);
	}

	@And("User enters new business description {string}")
	public void user_enters_new_business_description(String description) {
		myBusinessesPage.enterDescription(description);
	}

	@And("User enters new business city {string}")
	public void user_enters_new_business_city(String city) {
		myBusinessesPage.enterCity(city);
	}

	@And("User enters new business address {string}")
	public void user_enters_new_business_address(String address) {
		myBusinessesPage.enterAddress(address);
	}

	@And("User enters new business phone {string}")
	public void user_enters_new_business_phone(String phone) {
		myBusinessesPage.enterPhone(phone);
	}

	@And("User enters new business email {string}")
	public void user_enters_new_business_email(String email) {
		myBusinessesPage.enterEmail(email);
	}

	@When("User enters new business photo {string}")
	public void user_enters_new_business_photo(String string) {

		File uploadFile = new File("src/test/resources/photo.jpeg");
		String absolutePath = uploadFile.getAbsolutePath();
		myBusinessesPage.uploadphoto(absolutePath);
	}

	@Then("User verify the input fields {string} {string} {string} {string} {string} and {string}")
	public void user_verify_the_input_fields_and(String expectedBusinessName, String expectedDescription,
			String expectedCity, String expectedAddress, String expectedPhone, String expectedEmail) {

		String actualBusinessName = myBusinessesPage.getbusinessNameValue();
		String actualDescription = myBusinessesPage.getdescriptionValue();
		String actualCity = myBusinessesPage.getcityValue();
		String actualAddress = myBusinessesPage.getaddressValue();
		String actualPhone = myBusinessesPage.getphoneValue();
		String actualEmail = myBusinessesPage.getemailValue();

		System.out.println("Business Name: " + actualBusinessName);
		System.out.println("Description: " + actualDescription);
		System.out.println("City: " + actualCity);
		System.out.println("Address: " + actualAddress);
		System.out.println("Phone: " + actualPhone);
		System.out.println("Email: " + actualEmail);

		if (actualBusinessName.equals(expectedBusinessName) && actualDescription.equals(expectedDescription)
				&& actualCity.equals(expectedCity) && actualAddress.equals(expectedAddress)
				&& actualPhone.equals(expectedPhone) && actualEmail.equals(expectedEmail)) {

			Assert.fail("FAIL: Application accepted invalid values and created business account");
		}
		{

			Assert.assertEquals(actualBusinessName, expectedBusinessName);

			Assert.assertEquals(actualDescription, expectedDescription);

			Assert.assertEquals(actualCity, expectedCity);

			Assert.assertEquals(actualAddress, expectedAddress);

			Assert.assertEquals(actualPhone, expectedPhone);

			Assert.assertEquals(actualEmail, expectedEmail);

			System.out.println("All business input fields validated successfully.");
		}
	}

	@When("User verify the business count")
	public void user_verify_the_business_count() {

		myBusinessesPage.clickoverview();
		int totalCount = Integer.parseInt(myBusinessesPage.getbusinesstotalcount().trim());

		myBusinessesPage.clickMyBusinessesButton();

		int cardcount = myBusinessesPage.getbusinessdisplayedcount();
		System.out.println("CardCount:" + cardcount);
		System.out.println("TotalCount:" + totalCount);
		Assert.assertEquals(cardcount, totalCount, "count is not matching");
		System.out.println("Business Count validate sucessfully");
	}

	@When("User verify the leads count")
	public void user_verify_the_leads_count() {
		myBusinessesPage.clickoverview();
		int totalCount = Integer.parseInt(myBusinessesPage.getleadtotalcount().trim());
		myBusinessesPage.clickLeadsButton();
		int cardcount = myBusinessesPage.getleaddisplayedcount();
		System.out.println("CardCount:" + cardcount);
		System.out.println("TotalCount:" + totalCount);
		Assert.assertEquals(cardcount, totalCount, "count is not matching");
		System.out.println("Business Count validate sucessfully");

	}

	@And("User clicks on submit new business button")
	public void user_clicks_on_submit_new_business_button() {
		myBusinessesPage.clickSubmitBusiness();
	}

	@Given("User is on the Business dashboard page")
	public void user_is_on_the_business_dashboard_page() {
		LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
		myBusinessesPage = loginPage.dologin(Constant.EMAILID, Constant.PASSWORD);
		myBusinessesPage.clickMyBusinessesButton();
		String acutalurl = myBusinessesPage.getcurrentUrl();
		System.out.println("Actualurl:" + acutalurl);
		Assert.assertTrue(acutalurl.contains("businesses"));
	}

	@When("User clicks on the edit button")
	public void user_clicks_on_the_edit_button() {
		myBusinessesPage.clickEditButton();
	}

	@When("User enters business name{string}")
	public void user_enters_business_name(String businessName) {
		myBusinessesPage.enterEditBusinessName(businessName);
	}

	@When("User enters business description{string}")
	public void user_enters_business_description(String description) {
		myBusinessesPage.enterDescription(description);
	}

	@Then("User verify the input field {string} and {string}")
	public void user_verify_the_input_field_and(String ExpectedbusinessName, String Expecteddescription) {

		String actualbusinessName = myBusinessesPage.getbusinessNameValue();
		String actualdescription = myBusinessesPage.getdescriptionValue();

		System.out.println("Business Name: " + actualbusinessName);
		System.out.println("Description: " + actualdescription);
		if (actualbusinessName.equals(ExpectedbusinessName) && actualdescription.equals(Expecteddescription)) {

			Assert.fail("FAIL: Application accepted invalid values and created business account");
		}

		Assert.assertEquals(actualbusinessName, ExpectedbusinessName);

		Assert.assertEquals(actualdescription, Expecteddescription);

	}

	@Then("User click on Save changes button")
	public void user_click_on_save_changes_button() {
		myBusinessesPage.clickSaveChanges();
	}

	@When("User clicks on the Leads button")
	public void user_clicks_on_the_leads_button() {
		myBusinessesPage.clickLeadsButton();
	}

	@Then("User should be navigated to leads module")
	public void user_should_be_navigated_to_leads_module() {
		Assert.assertTrue(myBusinessesPage.isLeadsModuleDisplayed(),
				"User was not successfully navigated to the leads module.");
	}
}