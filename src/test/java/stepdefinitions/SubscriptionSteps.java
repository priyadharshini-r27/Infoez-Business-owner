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
import pages.SubscriptionPage;

public class SubscriptionSteps {

	private WebDriver driver;
	private WebDriverWait wait;
	private SubscriptionPage subscriptionPage;

	private SubscriptionPage SubscriptionPage = new SubscriptionPage(DriverFactory.getDriver());

	@When("User clicks on the profile dropdown menu")
	public void user_clicks_on_the_profile_dropdown_menu() throws InterruptedException {
		Thread.sleep(5000);

		SubscriptionPage.clickProfileDropdown();

	}

	@And("User clicks on the Subscription option from the menu")
	public void user_clicks_on_the_subscription_option_from_the_menu() {
		SubscriptionPage.clickSubscriptionMenuOption();
	}

	@Then("User should be successfully navigated to the Subscription page")
	public void user_should_be_successfully_navigated_to_the_subscription_page() {

		boolean isDisplayed = SubscriptionPage.isSubscriptionPageDisplayed();
		boolean isUrlCorrect = SubscriptionPage.getCurrentUrl().contains("subscription");

		System.out.println("Current Subscription URL: " + SubscriptionPage.getCurrentUrl());
		Assert.assertTrue(isDisplayed || isUrlCorrect, "User failed to navigate to the Subscription page!");
	}

	@When("User clicks on Choose plan for the Starter plan")
	public void user_clicks_on_choose_plan_for_the_Starter_plan() {
		SubscriptionPage.clickChoosePlanFor();
		System.out.println("Clicked Choose plan for the Starter plan.");
	}

	@Then("a subscription pop-up message should be displayed")
	public void a_subscription_pop_up_message_should_be_displayed() {
		String actualMessage = SubscriptionPage.getPopupMessageText();
		System.out.println("Actual Subscription Pop-up Message: " + actualMessage);

		Assert.assertNotNull(actualMessage, "Subscription pop-up message was null!");
		Assert.assertFalse(actualMessage.isEmpty(), "Subscription pop-up message is empty!");
		System.out.println("Validated successfully: Subscription pop-up message is displayed.");
	}
}
