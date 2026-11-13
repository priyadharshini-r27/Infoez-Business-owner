package stepdefinitions;

import java.util.Properties;
import org.testng.Assert;
import driverFactory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ExplorePage;
import utils.ConfigReader;

public class ExploreStep {
	private ExplorePage explorePage;
	private Properties prop = new ConfigReader().init_prop();

	private ExplorePage getExplorePage() {
		if (explorePage == null) {
			explorePage = new ExplorePage(DriverFactory.getDriver());
		}
		return explorePage;
	}

	@Given("user is on the Explore Page")
	public void user_is_on_the_explore_page() {
		DriverFactory.getDriver().get(prop.getProperty("url"));
	}

	@When("Business owner click the Explore module")
	public void business_owner_click_the_explore_module() {
		getExplorePage().clickExploreModule();
	}

	@And("Business owner enter {string} in shop search field")
	public void business_owner_enter_in_shop_search_field(String shopName) {
		getExplorePage().enterShopName(shopName);
	}

	@Then("verify the {string} valid {string} details")
	public void verify_the_valid_details(String status, String expected) {
		if (status.equalsIgnoreCase("valid")) {
			Assert.assertTrue(getExplorePage().isdisplayedvalidshop(), "Valid shop details not found for: ");
		} else {
			Assert.assertTrue(getExplorePage().verifyNoBusinessesFound(),
					"Expected 'No businesses found' message was not displayed!");
		}
	}

	@When("Business owner clear the search field in Explore module")
	public void business_owner_clear_the_search_field_in_explore_module() {
		getExplorePage().clearSearchField();
	}

	@And("Business owner enter the shop place {string} search field")
	public void business_owner_enter_the_shop_place_search_field(String place) {
		getExplorePage().enterPlace(place);
	}

	@Then("Business owner should see shop from place {string} with {string} and expected {string}")
	public void business_owner_should_see_shop_from_place_with_and_expected(String place, String status,
			String expected) {
		if (status.equalsIgnoreCase("valid")) {
			Assert.assertTrue(getExplorePage().isdisplayedPlaceResult(), "Shop for place " + place + " not found!");
		} else {
			Assert.assertTrue(getExplorePage().verifyNoBusinessesFound(),
					"Expected 'No businesses found' message was not displayed!");
		}
	}

	@When("user selects category filter Restaurants and Top rated and minirating")
	public void user_selects_category_filter_restaurants_and_top_rated_and_minirating() {
		getExplorePage().selectRestaurantsFilter();
		getExplorePage().selectTopRatedFilter();
		getExplorePage().selectMinRating40Filter();
	}

	@When("user selects categorys filter Beauty & spa and Most popular and minirating")
	public void user_selects_categorys_filter_beauty_spa_and_most_popular_and_minirating() {
		getExplorePage().selectBeautySpaFilter();
		getExplorePage().selectMostPopularFilter();
		getExplorePage().selectMinRating45Filter();
	}

	@When("user selects category filters Health & Medical and Recently added and Any")
	public void user_selects_category_filters_health_medical_and_recently_added_and_any() {
		getExplorePage().selectHealthMedicalFilter();
		getExplorePage().selectRecentlyAddedFilter();
		getExplorePage().selectAnyRatingFilter();
	}

	@Then("filtered business listings should be displayed successfully")
	public void filtered_business_listings_should_be_displayed_successfully() {
		Assert.assertTrue(getExplorePage().areFilteredResultsDisplayed(),
				"Filtered business listings heading is not displayed!");
	}

	@And("User validates that the businesses count header is displayed with text containing {string}")
	public void user_validates_that_the_businesses_count_header_is_displayed_with_text_containing(String expectedText) {
		Assert.assertTrue(getExplorePage().isBusinessesHeaderDisplayed(), "Businesses header is not displayed!");

		String headerText = getExplorePage().getBusinessesHeaderText();
		System.out.println("Header Count Displayed: " + headerText);

		Assert.assertTrue(headerText.contains(expectedText),
				"Header text does not contain expected keyword: " + expectedText);
	}

	@And("User verifies that business cards are displayed in the list")
	public void user_verifies_that_business_cards_are_displayed_in_the_list() {
		Assert.assertTrue(getExplorePage().areBusinessCardsDisplayed(), "No business cards found on the Explore page!");

		int count = getExplorePage().getBusinessCardsCount();
		System.out.println("Total business cards displayed on page: " + count);
		Assert.assertTrue(count > 0, "Business list is empty!");
	}
}