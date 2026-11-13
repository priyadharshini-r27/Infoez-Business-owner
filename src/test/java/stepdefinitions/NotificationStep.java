package stepdefinitions;

import org.testng.Assert;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverFactory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.MyBusinessPage;
import pages.NotificationPage;
import utils.ConfigReader;
import utils.Constant;

public class NotificationStep {
	private WebDriver driver;
	private NotificationPage notificationpage = new NotificationPage(DriverFactory.getDriver());
	private String initialBackgroundColor;

	@And("User clicks on the Notifications from the dropdown menu")
	public void user_clicks_on_the_notifications_from_the_dropdown_menu() {

		notificationpage.clickNotificationsMenuOption();
		boolean isDisplayed = notificationpage.isNotificationmenudisplayed();
		Assert.assertTrue(isDisplayed, "notificationmenu is not displayed");
		System.out.println("notification menu displayed successfully");
	}

	@Then("User should be successfully navigated to the Notifications page")
	public void user_should_be_successfully_navigated_to_the_notifications_page() {
		boolean isDisplayed = notificationpage.isNotificationsPageDisplayed();
		boolean isUrlCorrect = notificationpage.getCurrentUrl().contains("notification");

		System.out.println("Current Notifications URL: " + notificationpage.getCurrentUrl());
		Assert.assertTrue(isDisplayed || isUrlCorrect, "User failed to navigate to the Notifications page!");
	}

	@When("User clicks on {string} for the first notification")
	public void user_clicks_on_for_the_first_notification(String actionText)  {

		initialBackgroundColor = notificationpage.getNotificationBackgroundColor();
		System.out.println("Background color before clicking Mark read: " + initialBackgroundColor);

		notificationpage.clickMarkRead();
		System.out.println("Clicked '" + actionText + "' on the first notification.");

		
	}

	@Then("the notification background colour should change to indicate it is read")
	public void the_notification_background_colour_should_change_to_indicate_it_is_read() {

		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(30));
		wait.until(d -> !notificationpage.getNotificationBackgroundColor().equals(initialBackgroundColor));
		String finalBackgroundColor = notificationpage.getNotificationBackgroundColor();
		System.out.println("Before: " + initialBackgroundColor);
		System.out.println("After:" + finalBackgroundColor);

		Assert.assertNotNull(finalBackgroundColor, "Notification background color is null!");

		Assert.assertNotEquals(finalBackgroundColor, initialBackgroundColor,
				"Notification background color did not change after clicking Mark read!");

	}
}