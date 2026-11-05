package stepdefinitions;

import org.testng.Assert;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverFactory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CreateAccountPage;

public class CreateAccountStep {

	private WebDriver driver;
	private CreateAccountPage createAccountPage;

	@Given("the user navigates to the Infoez login page")
	public void the_user_navigates_to_the_infoez_login_page() {
		driver = DriverFactory.getDriver();
		createAccountPage = new CreateAccountPage(driver);
	}

	@When("the user clicks on the {string} link")
	public void the_user_clicks_on_the_link(String linkName) {
		createAccountPage.clickCreateOneLink();
	}

	@When("the user selects the {string} account type option")
	public void the_user_selects_the_account_type_option(String accountType) {
		createAccountPage.selectBusinessOption();
	}

	@And("the user enters the full name {string}")
	public void the_user_enters_the_full_name(String fullName) {
		createAccountPage.enterFullName(fullName);
	}

	@And("the user enters the email {string}")
	public void the_user_enters_the_email(String email) {
		createAccountPage.enterEmail(email);
	}

	@And("the user enters the phone number {string}")
	public void the_user_enters_the_phone_number(String phone) {
		createAccountPage.enterPhone(phone);
	}

	@And("the user enters the password {string}")
	public void the_user_enters_the_password(String password) {
		createAccountPage.enterPassword(password);
	}
	
	@Then("user validates registration input fields {string} {string} and {string}")
	public void user_validates_registration_input_fields(String Expectedfullname, String Expectedemail,
			String Expectedphone) {
		String actualFullName = createAccountPage.getFullNameValue();
		String actualEmail = createAccountPage.getEmailValue();
		String actualPhone = createAccountPage.getPhoneValue();

		System.out.println("Full Name: " + actualFullName);
		System.out.println("Email: " + actualEmail);
		System.out.println("Phone: " + actualPhone);

		Assert.assertEquals(actualFullName, Expectedfullname);
		Assert.assertEquals(actualEmail, Expectedemail);
		Assert.assertEquals(actualPhone, Expectedphone);

		System.out.println("All input fields validated successfully against scenario parameters.");
	}

	@And("the user clicks on the {string} button")
	public void the_user_clicks_on_the_button(String buttonName) {
		createAccountPage.clickCreateAccountButton();
	}

	@Then("the page outcome should match {string} and {string}")
	 public void the_page_outcome_should_match_and(String expectedResult, String message) {

	 if (expectedResult.equalsIgnoreCase("valid")) {
		 if (expectedResult.equalsIgnoreCase("valid")) {

			 WebDriverWait wait = new WebDriverWait(
			 driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(createAccountPage.getWelcomeMessageElement()));
			 //wait.until(ExpectedConditions.visibilityOf(createAccountPage.getwelcomemessage()));

			 String actualMessage = createAccountPage.getwelcomemessage();

			 System.out.println("Expected Message: " + message);
			 System.out.println("Actual Message: " + actualMessage);

			 Assert.assertTrue(
			 actualMessage.contains(message),
			 "Account creation success message not displayed"
			 );
			 }
	 //Assert.assertFalse(driver.getCurrentUrl().contains("register"),
	// "Registration failed: User remained on the register page.");

	 } else if (expectedResult.equalsIgnoreCase("failed")) {
	 String actualMessage;

	 if (message.contains("@")) {
	 actualMessage = createAccountPage.getEmailValidationMessage();
	 System.out.println("Expected Message: " + message);
	 System.out.println("Actual Message: " + actualMessage);
	 Assert.assertTrue(actualMessage != null && actualMessage.contains("@"),
	 "HTML email validation message not displayed");
	 } else {
	 
	 actualMessage = createAccountPage.getPasswordValidationMessage();
	 System.out.println("Expected Message: " + message);
	 System.out.println("Actual Message: " + actualMessage);
	 Assert.assertTrue(
	 actualMessage != null && actualMessage.toLowerCase().contains(message.toLowerCase()),
	 "HTML password length validation message not displayed");
	 }

	 } else if (expectedResult.equalsIgnoreCase("Empty")) {
	   //String actualMessage;
	 }
	 else if (expectedResult.equalsIgnoreCase("Empty")) {

		 if (message == null || message.trim().isEmpty()) {

		 Assert.assertTrue(
		 createAccountPage.getFullNameValue().isEmpty(),
		 "Full Name field is not empty");

		 Assert.assertTrue(
		 createAccountPage.getEmailValue().isEmpty(),
		 "Email field is not empty");

		 Assert.assertTrue(
		 createAccountPage.getPhoneValue().isEmpty(),
		 "Phone field is not empty");

		 System.out.println("All input fields are empty");

		 } else {

		 if (message.equalsIgnoreCase("FullName")) {
		 expectedResult = createAccountPage.getFullNameValidationMessage();

		 } else if (message.equalsIgnoreCase("Email")) {
		 expectedResult = createAccountPage.getEmailValidationMessage();

		 } else if (message.equalsIgnoreCase("Password")) {
		 expectedResult = createAccountPage.getPasswordValidationMessage();

		 } else {
		 throw new IllegalArgumentException("Unknown field: " + message);
		 }

		 System.out.println("Validation Message: " + expectedResult);
		 Assert.assertNotNull(expectedResult);
		 Assert.assertFalse(expectedResult.isEmpty());
		 }}
		 }

}