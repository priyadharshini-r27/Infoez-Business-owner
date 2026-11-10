package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Element;

public class ExplorePage {
 private WebDriver driver;
 private Element element;
 private WebDriverWait wait;

 @FindBy(xpath = "//a[text()='Explore']")
 private WebElement exploreModuleLink;

 @FindBy(xpath = "//input[@data-testid='search-query-input']")
 private WebElement shopSearchField;

 @FindBy(xpath = "//input[@data-testid='search-location-input']")
 private WebElement placeSearchField;

 @FindBy(xpath = "//h3[contains(text(),'No businesses found')]")
 private WebElement noBusinessesFoundMsg;

 @FindBy(xpath = "//button[@data-testid='filter-category']")
 private WebElement categoryDropdownBtn;

 @FindBy(xpath = "//button[@data-testid='filter-sort']")
 private WebElement sortByDropdownBtn;

 @FindBy(xpath = "//button[@data-testid='filter-min-rating']")
 private WebElement minRatingDropdownBtn;

 @FindBy(xpath = "//h1[@class='mt-2 font-display font-bold text-3xl sm:text-4xl tracking-tight']")
 private WebElement businessHeadingCount;

 @FindBy(xpath = "//div[@class='relative aspect-[4/3] overflow-hidden bg-muted']")
 private List<WebElement> businessCardsList;

 @FindBy(xpath = "(//*[text()='Aroma Cafe']//preceding::button[1])[1]")
 private WebElement aromacafe;

 @FindBy(xpath = "//span[text()='Bengaluru']")
 private WebElement city;

 @FindBy(xpath = "//span[text()='Restaurants']")
 private WebElement restaurants;

 @FindBy(xpath = "//span[text()='Top rated']")
 private WebElement toprated;

 @FindBy(xpath = "//span[text()='4.0+']")
 private WebElement rating1;

 @FindBy(xpath = "//span[text()='Beauty & Spa']")
 private WebElement Beautyspa;

 @FindBy(xpath = "//span[text()='Most popular']")
 private WebElement mostpopular;

 @FindBy(xpath = "//span[text()='4.5+']")
 private WebElement rating2;

 @FindBy(xpath = "//span[text()='Health & Medical']")
 private WebElement healthmedical;

 @FindBy(xpath = "//span[text()='Recently added']")
 private WebElement recentlyadded;

 @FindBy(xpath = "//span[text()='Any']")
 private WebElement any;

 public ExplorePage(WebDriver driver) {
 this.driver = driver;
 this.element = new Element(driver);
 this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 PageFactory.initElements(driver, this);
 }

 public void clickExploreModule() {
 element.Click(exploreModuleLink);
 }

 public void enterShopName(String shopName) {
 element.clear(shopSearchField);
 element.sendKeys(shopSearchField, shopName);
 shopSearchField.sendKeys(Keys.ENTER);
 }

 public void enterPlace(String place) {
 element.clear(placeSearchField);
 element.sendKeys(placeSearchField, place);
 placeSearchField.sendKeys(Keys.ENTER);
 }

 public void clearSearchField() {
 element.clear(shopSearchField);
 element.clear(placeSearchField);
 }

 public boolean isdisplayedvalidshop() {
 return element.isDisplayed(aromacafe);
 }

 public boolean verifyNoBusinessesFound() {
 WebElement msg = wait.until(ExpectedConditions.visibilityOf(noBusinessesFoundMsg));
 return msg.isDisplayed();
 }

 public boolean isdisplayedPlaceResult() {
 return element.isDisplayed(city);
 }

 public void selectRestaurantsFilter() {
 element.Click(categoryDropdownBtn);
 element.Click(restaurants);
 }

 public void selectTopRatedFilter() {
 element.Click(sortByDropdownBtn);
 element.Click(toprated);
 }

 public void selectMinRating40Filter() {
 element.Click(minRatingDropdownBtn);
 element.Click(rating1);
 }

 public void selectBeautySpaFilter() {
 element.Click(categoryDropdownBtn);
 element.Click(Beautyspa);
 }

 public void selectMostPopularFilter() {
 element.Click(sortByDropdownBtn);
 element.Click(mostpopular);
 }

 public void selectMinRating45Filter() {
 element.Click(minRatingDropdownBtn);
 element.Click(rating2);
 }

 public void selectHealthMedicalFilter() {
 element.Click(categoryDropdownBtn);
 element.Click(healthmedical);
 }

 public void selectRecentlyAddedFilter() {
 element.Click(sortByDropdownBtn);
 element.Click(recentlyadded);
 }

 public void selectAnyRatingFilter() {
 element.Click(minRatingDropdownBtn);
 element.Click(any);
 }

 public boolean areFilteredResultsDisplayed() {
 return element.isDisplayed(businessHeadingCount);
 }

 public boolean isBusinessesHeaderDisplayed() {
 return element.isElementDisplayed(businessHeadingCount);
 }

 public String getBusinessesHeaderText() {
 return element.getText(businessHeadingCount);
 }

 public boolean areBusinessCardsDisplayed() {
 return businessCardsList != null && !businessCardsList.isEmpty();
 }

 public int getBusinessCardsCount() {
 return businessCardsList.size();
 }
}