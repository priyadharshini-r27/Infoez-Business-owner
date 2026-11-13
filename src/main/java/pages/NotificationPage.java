package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Element;

public class NotificationPage {

	private WebDriver driver;
	private Element element;

	@FindBy(xpath = "//a[@data-testid='biz-nav-my-businesses']")
	private WebElement myBusinessesMenu;

	@FindBy(xpath = "//button[@data-testid='user-menu-btn']")
	private WebElement profileDropdownBtn;

	@FindBy(xpath = "//div[@data-testid='menu-notifications']")
	private WebElement notificationsMenuOption;

	@FindBy(xpath = "//h1[text()='Notifications']")
	private WebElement notificationsPageHeader;

	@FindBy(xpath = "(//div[contains(@class,'rounded-xl') and contains(@class,'p-4') and contains(@class,'flex') and contains(@class,'gap-3')])[1]")
	private WebElement firstNotificationCard;

	@FindBy(xpath = "//button[text()='Mark read']")
	private WebElement markReadButton;

	public NotificationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.element = new Element(driver);
	}

	public void clickNotificationsMenuOption() {
		element.clickOnElement(notificationsMenuOption);
	}

	public boolean isNotificationsPageDisplayed() {
		return element.isElementDisplayed(notificationsPageHeader);
	}

	public String getNotificationBackgroundColor() {
		WebElement card = element.waitForVisibility(firstNotificationCard);
		String colour = card.getCssValue("background-color");
		return colour;
	}

	public void clickMarkRead() {
		element.clickOnElement(markReadButton);
	}

	public String getCurrentUrl() {
		return element.getCurrentUrl();
	}

	public boolean isNotificationmenudisplayed() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		return wait.until(ExpectedConditions.visibilityOf(notificationsMenuOption)).isDisplayed();
	}

	public String getprofileexpandedstatus() {
		return profileDropdownBtn.getAttribute("aria-expanded");
	}

}
