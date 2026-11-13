package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Element;

public class SubscriptionPage {

	private WebDriver driver;
	private WebDriverWait wait;
	private Element element;

	@FindBy(xpath = "//span[@class='hidden sm:inline text-sm font-medium']")
	private WebElement profileDropdownBtn;

	@FindBy(xpath = "//div[@role='menuitem'][contains(text(),'Subscription')]")
	private WebElement subscriptionMenuOption;

	@FindBy(xpath = "//h1[text()='Choose your plan']")
	private WebElement subscriptionPageHeader;
	
	@FindBy(xpath = "//button[@data-testid='subscribe-starter']")
	private WebElement starteractiveplan;

	@FindBy(xpath = "//div[text()='Subscription updated']")
	private WebElement successPopupMessage;
	
	
	
	

	public SubscriptionPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		PageFactory.initElements(driver, this);
		this.element = new Element(driver);
	}
	
	
	
	public void clickProfileDropdown() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement profiledropdown = wait.until(ExpectedConditions.elementToBeClickable(profileDropdownBtn));
//		profiledropdown.click();

		 element.clickOnElement(profileDropdownBtn);
//		element.scrollToElement(profileDropdownBtn);
//		element.clickOnElement(profileDropdownBtn);
		
				
	}

	public void clickSubscriptionMenuOption() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement subscription = wait.until(ExpectedConditions.elementToBeClickable(subscriptionMenuOption));
		element.clickOnElement(subscription);
	}
	public boolean isSubscriptionPageDisplayed() {
		return element.isElementDisplayed(subscriptionPageHeader);
	}

	public void clickChoosePlanFor() {
		element.scrollToElement(starteractiveplan);
		element.Click(starteractiveplan);
	}

	public String getPopupMessageText() {
		return element.getText(successPopupMessage);
	}

	public String getCurrentUrl() {
		return element.getCurrentUrl();
	}
	

}
