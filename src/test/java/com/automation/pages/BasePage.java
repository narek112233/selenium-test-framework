package com.automation.pages;

import com.automation.utils.ConfigManager;
import com.automation.utils.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public class BasePage {

    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openApplication(String url) {
        driver.get(ConfigManager.getBaseUrl()+url);
        Waits.waitToPageLoad();
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
    }

    public void switchToIframe(WebElement elem) {
        driver.switchTo().frame(elem);
    }

    public void switchToDefaultPage() {
        driver.switchTo().defaultContent();
    }

    public void clickOnBrowserBackButton() {
        driver.navigate().back();
        Waits.waitToPageLoad();
    }
}
