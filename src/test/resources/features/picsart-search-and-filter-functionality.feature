Feature: Picsart search and filter functionality

  Scenario: Picsart search and filter functionality

    Given I open picsart search
    When I switch to picsart frame
    When I click on filter button
    Then The filters should be disappear
    When I click on filter button
    And I check personal checkbox
    And I click on first image
    When I switch to picsart page
    Then The Like button should be visible
    And The Save button should be visible
    And The Edit button should be visible
    When I click on like button
    Then The sign in popup should be visible
    When I click on sign in popup close button
    And I click on browser back button
    When I switch to picsart frame
    And I click on filter clear all button
