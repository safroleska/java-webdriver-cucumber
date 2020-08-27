@market
  Feature: Marketing test suite

    @market1
    Scenario: Navigation for Quote
      Given I go to "yahoo" page
      And I print logs to the console
#      And I print page details
#      And I go to "quote" page
#      And I go back and forward, then refresh


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

    @market5
    Scenario: Verify fields values recorded correctly
      Given I go to "quote" page
      When I fill out required fields
      And I submit the form
      Then I verify that fields values recorded correctly

    @market6
    Scenario: Alert, iFrame and Window
      Given I go to "quote" page
      When I "accept" third party agreement
      And I wait for 1 sec
      And I fill out "Richard Roe" name and "0123456789" phone contact
      And I wait for 1 sec
      And I verify document list contains "Document 2"
      And I fill out required fields



