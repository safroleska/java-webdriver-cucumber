@homework
Feature: Homework exercise

  @converter1
  Scenario:	Validate Fahrenheit	to	Celsius
    Given I go to "converter" page
    When I click on "Temperature"
    And I set "Fahrenheit" to "Celsius"
    Then I enter into From field "54" and verify "12.2" result

  @converter2
  Scenario:	Validate Pound to Kilogram
    Given I go to "converter" page
    When I click on "Weight"
    And I set "Pound" to "Kilogram"
    Then I enter into From field "170" and verify "77" result

  @converter3
  Scenario:	Validate Mile to Kilometer
    Given I go to "converter" page
    When I click on "Length"
    And I set "Mile" to "Kilometer"
    Then I enter into From field "50" and verify "80.4" result

  @calculator1
  Scenario: Verify calculator result
    Given I go to "calculator" page
    When I navigate to "Auto Loan Calculator"
    And I clear all calculator fields
    And I calculate
    Then I verify "Please provide a positive auto price." calculator error
    Then I verify "Please provide a positive interest value." calculator error
    And I enter "25000" price, "60" months, "4.5" interest, "5000" downpayment, "0" trade-in, "California" state, "7" percent tax, "300" fees
    And I calculate
    Then I verify monthly pay is "$372.86"