package com.automation.steps;

import com.automation.driver.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import com.automation.pages.BasePage;
import com.automation.pages.SearchPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class SearchSteps {
    BasePage basePage = new BasePage(DriverManager.getDriver());
    SearchPage searchPage = new SearchPage(DriverManager.getDriver());

    @Given("I open picsart search")
    public void I_open_picsart_search() throws InterruptedException {
        basePage.openApplication("/search/all/");

    }

    @When("^I switch to picsart frame$")
    public void I_switch_to_picart_frame() {
        searchPage.switchToFrame();
    }
    @When("^I switch to picsart page$")
    public void I_switch_to_picart_page() throws InterruptedException {
        searchPage.switchToPage();
        Thread.sleep(5000);
    }

    @When("I click on filter button")
    public void I_click_on_filter_button() throws InterruptedException {
        searchPage.clickOnFilterButton();
        Thread.sleep(5000);
    }

    @Then("The filters should be disappear")
    public void The_filters_should_be_disappear() {
        Assert.assertFalse(searchPage.isFilterSectionDisplayed());
    }

    @And("^I check personal checkbox$")
    public void I_check_personal_checkbox() {
        searchPage.checkPersonalCheckbox();
    }

    @And("^I click on first image$")
    public void I_click_on_first_image() throws InterruptedException {
        Thread.sleep(5000);
        searchPage.clickOnFirstImage();
    }

    @Then("^The (Like|Save|Edit) button should be visible$")
    public void The_like_button_should_be_visible(String buttonName) {
        Assert.assertTrue(searchPage.isButtonVisible(buttonName));
    }

    @When("^I click on like button$")
    public void I_click_on_like_button(){
        searchPage.clickOnLikeButton();
    }

    @Then("^The sign in popup should be visible$")
    public void The_sign_in_popup_should_be_visible() {
        Assert.assertTrue(searchPage.isSignInPopupVisible());
    }

    @When("^I click on sign in popup close button$")
    public void I_click_on_sign_in_popup_close_button() {
        searchPage.clickOnSignInPopUpCloseButton();
    }

    @And("^I click on browser back button$")
    public void I_click_on_browser_back_button() {
        searchPage.clickOnBrowserBackButton();
    }

    @When("^I click on filter clear all button$")
    public void I_click_on_filter_clear_all_button() {
        searchPage.clickOnFilterClearAllButton();
    }




}
