package stepdefinitions;

import org.testng.Assert;

import driverFactory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import utils.ConfigReader;
import utils.Constant;
import pages.ProfilePage;

public class ProfileStep {

	private ProfilePage profilepage = new ProfilePage(DriverFactory.getDriver());
	
	
	
	@Given("User is on the Home dashboard page")
	public void user_is_on_the_home_dashboard_page() {
		 DriverFactory.getDriver().get(ConfigReader.getProperty("url"));
		  LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
		  loginPage.dologin(Constant.EMAILID,Constant.PASSWORD);
		 }
	
	@When("User clicks on the profile menu at top right")
	public void user_clicks_on_the_profile_menu_at_top_right() throws InterruptedException {
		Thread.sleep(5000);
	profilepage.clickUserDropdown();
	}

		@And("User clicks on Profile from the dropdown menu")
	public void user_clicks_on_profile_from_the_dropdown_menu()  {
	profilepage.clickProfileMenuItem();
	}

		@Then("User verifies the Profile page is loaded with heading {string}")
	public void user_verifies_the_profile_page_is_loaded_with_heading(String headingText) {
	Assert.assertTrue(profilepage.isProfilePageDisplayed(),
	"Profile page did not load with expected heading: " + headingText);
	}

		@When("User updates the profile name to {string}")
	public void user_updates_the_profile_name_to(String name) {
	profilepage.enterName(name);
	}

		@And("User updates the profile phone to {string}")
	public void user_updates_the_profile_phone_to(String phone) {
	profilepage.enterPhone(phone);
	}
		@Then("user validate  input fields {string} and {string}")
		public void uservalidateinputfields(String expectedname, String expectedphone) {
			String acutalname = profilepage.getnameValue();
			String acutalphone = profilepage.getphonevalue();
			
			System.out.println("name:" + acutalname);
			System.out.println("phone:" + acutalphone);
			
			Assert.assertEquals(acutalname, expectedname);
			Assert.assertEquals(acutalphone, expectedphone);
			
			System.out.println("All input fields validated successfully");
			
			
//			Assert.assertEquals(profilepage.getNameValue(), "Ravi");
//			Assert.assertEquals(profilepage.getphoneValue(), "9876543210");
//			System.out.println("Name:" + profilepage.getNameValue());
//			System.out.println("phone:" + profilepage.getphoneValue());
		}

		@And("User clicks on Save changes button")
	public void user_clicks_on_save_changes_button() {
	profilepage.clickSaveChanges();
	}

		@Then("A profile update success alert should be displayed")
	public void a_profile_update_success_alert_should_be_displayed() {
	Assert.assertTrue(profilepage.isSuccessToastDisplayed(),																				
	"Success notification was not displayed after clicking save.");
	}

		@And("The profile name input should have value {string}")
	public void the_profile_name_input_should_have_value(String expectedName) {
	Assert.assertEquals(profilepage.getEnteredName(), expectedName,
	"Profile name attribute value did not match.");
	}
	}