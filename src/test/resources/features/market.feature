@market
  Feature: Marketing test suite

    @market1
    Scenario: Navigation for Quote
      Given I go to "google" page
      And I print page details
      And I go to "quote" page
      And I go back and forward, then refresh


    @market2
    Scenario: Required fields for quote
      Given I go to "quote" page
      And I print page details
      When I fill out required fields
      And I submit the form
      Then I verify required fields

    @market3
    Scenario: Email field behavior
      Given I go to "quote" page
      When I verify email field behavior
      Then I submit the form

    @market4
    Scenario: Fill out optional fields
      Given I go to "quote" page
      When I fill out optional fields


