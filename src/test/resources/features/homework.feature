@homework
Feature: Homework exercise

  @converter1
  Scenario Outline:    Validate
    Given I go to "converter" page
    When I click on "<Measure>"
    And I set "<FromUnit>" to "<ToUnit>"
    Then I enter into From field "<EnterNumber>" and verify "<VerifyNumber>" result
    Examples:
      | Measure     | FromUnit   | ToUnit    | EnterNumber | VerifyNumber |
      | Temperature | Fahrenheit | Celsius   | 54          | 12.2         |
      | Weight      | Pound      | Kilogram  | 170         | 77           |
      | Length      | Mile       | Kilometer | 50          | 80.4         |


#  @converter2
#  Scenario:    Validate Pound to Kilogram
#    Given I go to "converter" page
#    When I click on "<Measure>"
#    And I set "Weight" to "Kilogram"
#    Then I enter into From field "170" and verify "77" result
#
#  @converter3
#  Scenario:    Validate Mile to Kilometer
#    Given I go to "converter" page
#    When I click on "Length"
#    And I set "Mile" to "Kilometer"
#    Then I enter into From field "50" and verify "80.4" result

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

  @ups1
  Scenario: UPS end to end first
    Given I go to "ups" page
    And I open Shipping menu
    And I go to Create a Shipment
    When I fill out origin shipment fields
    And I submit the shipment form
    Then I verify origin shipment fields submitted
    And I cancel the shipment form
    Then I verify shipment form is reset

  @ups2
  Scenario: UPS end to end full
    Given I go to "ups" page
    And I open Shipping menu
    And I go to Create a Shipment
    When I fill out origin shipment fields
    And I submit the shipment form
    Then I verify origin shipment fields submitted
    When I fill out destination shipment fields
    When I submit the shipment form
    And I set packaging type and weight
    When I submit the shipment form
    Then I verify total charges appear
    And I select cheapest delivery option
    And I submit the shipment form
    And I set description and check Saturday Delivery type
    Then I verify total charges changed
    When I submit the shipment form
    And I select Paypal payment type
    And I click Review button
    Then I review all recorded details on the review page
    And I cancel the shipment form
    Then I verify shipment form is reset

  @ups3
  Scenario: UPS end to end first OOP
    Given I follow to "ups" page
    And I open Shipping menu
    And I go to Create a Shipment
    When I fill out origin shipment fields
#    And I wait for 3 sec
    And I submit the shipment form
    And I wait for 3 sec
    Then I verify origin shipment fields submitted
    And I cancel the shipment form
    Then I verify shipment form is reset