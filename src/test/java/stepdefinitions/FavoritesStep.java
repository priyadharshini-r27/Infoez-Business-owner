package stepdefinitions;

import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import driverFactory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.FavoritesPage;
import pages.LoginPage;
import utils.ConfigReader;
import utils.Constant;

public class FavoritesStep {

	private WebDriver driver;
	private FavoritesPage favoritesPage;

	private FavoritesPage getFavoritesPage() {
		if (favoritesPage == null) {
			driver = DriverFactory.getDriver();
			favoritesPage = new FavoritesPage(driver);
		}
		return favoritesPage;
	}

	@Given("User is logged in and on the Home page")
	public void user_is_logged_in_and_on_the_home_page() {
		driver = DriverFactory.getDriver();
		driver.get(ConfigReader.getProperty("url"));
		LoginPage loginPage = new LoginPage(driver);
		loginPage.dologin(Constant.EMAILID, Constant.PASSWORD);
	}

	@When("User clicks on the Explore navigation link")
	public void user_clicks_on_the_explore_navigation_link() throws InterruptedException {
		Thread.sleep(2000);
		getFavoritesPage().clickExploreNavLink();
	}

	@And("User clicks on the Favorite or Heart icon for business")
	public void user_clicks_on_the_favorite_or_heart_icon_for_business() throws InterruptedException {
		Thread.sleep(3000);
		getFavoritesPage().clickFavoriteIconForBusiness();
		System.out.println("Clicked heart/favorite icon for: ");
	}

	@Then("a pop-up message should be displayed with text {string}")
	public void a_pop_up_message_should_be_displayed_with_text(String expectedMessage) {
		String actualMessage = getFavoritesPage().getPopupMessageText();
		System.out.println("Actual Pop-up Message: " + actualMessage);
		
		Assert.assertNotNull(actualMessage, "Pop-up notification message was null!");
		Assert.assertTrue(actualMessage.toLowerCase().contains(expectedMessage.toLowerCase()), 
				"Expected pop-up message to contain '" + expectedMessage + "', but found: " + actualMessage);
	}
	@When("User clicks on the menu at top right")
	public void user_clicks_on_the_menu_at_top_right() throws InterruptedException {
		Thread.sleep(5000);
		getFavoritesPage().clickProfileDropdown();
	}

	@When("User navigates to the Favorites page via profile menu")
	public void user_navigates_to_the_favorites_page_via_profile_menu() throws InterruptedException {
		Thread.sleep(2000);
//		getFavoritesPage().clickProfileDropdown();
		getFavoritesPage().clickFavoritesMenuOption();
		
		boolean isDisplayed = getFavoritesPage().isFavoritesPageDisplayed();
		boolean isUrlCorrect = getFavoritesPage().getCurrentUrl().contains("favorite");
		
		System.out.println("Current Favorites URL: " + getFavoritesPage().getCurrentUrl());
		Assert.assertTrue(isDisplayed || isUrlCorrect, "User failed to navigate to the Favorites page!");
	}

	@Then("the business should be displayed in the Favorites list")
	public void the_business_should_be_displayed_in_the_favorites_list() {
		boolean isPresent = getFavoritesPage().isBusinessPresentInFavorites();
//		Assert.assertTrue(isPresent, "Business " , "was not found in the Favorites list after adding!");
//		System.out.println("Verified: "," is successfully displayed in Favorites.");
	}
}