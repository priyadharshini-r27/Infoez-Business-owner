package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverFactory.DriverFactory;
import utils.Element;

public class FavoritesPage {

	private WebDriver driver;
	private Element element;

	
	@FindBy(xpath = "//a[@data-testid='nav-explore']")
	private WebElement exploreNavLink;

	
	@FindBy(xpath = "//button[@data-testid='user-menu-btn']")
	private WebElement profileDropdownBtn;

	
	@FindBy(xpath = "//div[@role='menuitem' and @data-testid='menu-favorites']")
	private WebElement favoritesMenuOption;
	
	@FindBy(xpath = "(//*[text()='Aroma Cafe']//preceding::button[1])[1]")
	private WebElement Aromacafe;

	
	@FindBy(xpath = "//h1[text()='Your favorites']")
	private WebElement favoritesPageHeader;
	
	@FindBy(xpath = "//button[contains(@data-testid,'favorite-toggle-btn')]//*[name()='svg']")
	private WebElement Explorehearticon;
	
	@FindBy(xpath = "//*[@class='lucide lucide-heart h-4 w-4 fill-current'])[2]")
	private WebElement favoritesremovebtn;

	
	@FindBy(xpath = "//div[contains(text(),'Added to favorites')]")
	private WebElement successPopupMessage;
	
	@FindBy(xpath = "//button[@data-testid='favorite-toggle-btn-1d115ad7-76ef-4b04-9732-93f9b1aff0e8']")
	private WebElement removePopupMessage;

	public FavoritesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.element = new Element(driver);
	}

	public void clickExploreNavLink() {
		element.clickOnElement(exploreNavLink);
	}

	public void clickProfileDropdown() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement profileBtn = wait.until(ExpectedConditions.elementToBeClickable(profileDropdownBtn));
		element.clickOnElement(profileDropdownBtn);
	}

	public void clickFavoritesMenuOption() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement favOption = wait.until(ExpectedConditions.elementToBeClickable(favoritesMenuOption));
		element.clickOnElement(favoritesMenuOption);
	}

	public boolean isFavoritesPageDisplayed() {
		return element.isElementDisplayed(favoritesPageHeader);
	}

	public void clickFavoriteIconForBusiness() {
		
		element.Click(Aromacafe);
	}

	public String getPopupMessageText() {
		return element.getText(successPopupMessage);
	}

	public boolean isBusinessPresentInFavorites() {
		return element.isElementDisplayed(Aromacafe);
	}

	public String getCurrentUrl() {
		return element.getCurrentUrl();
	}
}