package com.automation.pages;

import com.automation.steps.BaseSteps;
import com.automation.utils.Checkbox;
import com.automation.utils.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends BasePage {

    WebDriver driver;

    @FindBy(id = "filter_icon")
    private WebElement filterIconBtn;

    @FindBy(id = "base_card_item0")
    private WebElement firstImageElement;

    @FindBy(xpath = "//div[@data-testid='accordion-root']")
    WebElement filterSectionElement;

    @FindBy(xpath = "//div[@data-testid='registration-modal-container']")
    WebElement signInPopupElement;

    @FindBy(xpath = "//*[contains(@class, 'with-auth-modal-closeButton')]")
    WebElement signInPopupCloseButtonElement;

    @FindBy(id = "search-filter-header-clear")
    WebElement filterClearAllBtn;

    By frameElementBy = By.cssSelector("[data-testid='com.picsart.social.search']");
    By personalCheckboxElementBy = By.cssSelector("[aria-label='licenses-Personal-checkbox']");
    By firstImageBy = By.id("base_card_item0");
    By likeButtonBy = By.cssSelector("[data-testid='likeComponent']");
    By saveButtonBy = By.xpath("//*[contains(@class, 'smart-drop-down-actionButton')]");
    By editButtonBy = By.xpath("//*[contains(@class, 'info-block-editButton')]");

    public SearchPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    public void clickOnFilterButton() {
        filterIconBtn.click();
    }

    public boolean isFilterSectionDisplayed() {
        return filterSectionElement.isDisplayed();
    }

    public void switchToFrame() {
        Waits.waitForElementVisible(frameElementBy);
        switchToIframe(driver.findElement(frameElementBy));
    }

    public void switchToPage() {
        switchToDefaultPage();
        Waits.waitToPageLoad();
    }

    public void checkPersonalCheckbox(){
        Checkbox checkbox = Checkbox.getInstance(driver.findElement(personalCheckboxElementBy));
        checkbox.check();
    }

    public void clickOnFirstImage() {
        Waits.waitToPageLoad();
        Waits.waitToElementIsVisible(firstImageElement);
        Waits.waitToElementIsClickable(firstImageElement);
        driver.findElement(firstImageBy).click();
    }

    public boolean isButtonVisible(String buttonName){
        Waits.waitToPageLoad();
        WebElement elem;
        switch(buttonName.toLowerCase()){
            case "like":
                elem = driver.findElement(likeButtonBy);
                break;
            case "save":
                elem = driver.findElement(saveButtonBy);
                break;
            case "edit":
                elem = driver.findElement(editButtonBy);
                break;
            default: throw new IllegalArgumentException(String.format("Invalid  button name \"%s\"",buttonName));
        }
        return elem.isDisplayed();
    }

    public void clickOnLikeButton(){
        driver.findElement(likeButtonBy).click();
    }

    public boolean isSignInPopupVisible() {
        return signInPopupElement.isDisplayed();
    }

    public void clickOnSignInPopUpCloseButton() {
        signInPopupCloseButtonElement.click();
    }

    public void clickOnFilterClearAllButton() {
        filterClearAllBtn.click();
        Waits.waitToPageLoad();
    }
}
