@predefined
Feature: Smoke steps

  @predefined1
  Scenario: Predefined steps for Google
    Given I open url "https://google.com"
    Then I should see page title as "Google"
    Then element with xpath "//input[@name='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@name='q']"
    Then I click on element using JavaScript with xpath "(//input[@name='btnK'])[1]"
    Then I wait for element with xpath "//*[@id='res']" to be present
    Then element with xpath "//*[@id='res']" should contain text "Cucumber"

  @predefined2
  Scenario: Predefined steps for Yahoo
    Given I open url "https://www.yahoo.com"
    Then I should see page title as "Yahoo"
    And element with xpath "//*[@id='header-search-input']" should be present
    When I type "Weather" into element with xpath "//*[@id='header-search-input']"
    And I click on element with xpath "//*[@id='header-desktop-search-button']"
    And I wait for element with xpath "//*[@id='web']" to be present
    Then element with xpath "//*[@id='web']" should contain text "Weather"

    
  @predefined3
  Scenario: Predefined steps for Bing
    Given I open url "https://www.bing.com"
    Then I should see page title as "Bing"
    And element with xpath "//*[@id='sb_form_q']" should be present
    When I type "Weather" into element with xpath "//*[@id='sb_form_q']"
    And I click on element with xpath "//*[@for='sb_form_go']"
    And I wait for element with xpath "//*[@id='b_results']" to be present
    Then element with xpath "//*[@id='b_results']" should contain text "Weather"

  @predefined4
  Scenario: Predefined steps for Gibiru
    Given I open url "http://gibiru.com"
    Then I should see page title as "Gibiru – Protecting your privacy since 2009"
    And element with xpath "//*[@id='q']" should be present
    When I type "Weather" into element with xpath "//*[@id='q']"
    And I click on element with xpath "//*[@type='submit']"
    And I wait for element with xpath "//*[@class='gsc-resultsbox-visible']" to be present
    Then element with xpath "//*[@class='gsc-resultsbox-visible']" should contain text "Weather"

  @predefined5
  Scenario: Predefined steps for DuckDuckGo
    Given I open url "https://duckduckgo.com"
    Then I should see page title contains "DuckDuckGo — Privacy, simplified."
    And element with xpath "//*[@id='search_form_input_homepage']" should be present
    When I type "Weather" into element with xpath "//*[@id='search_form_input_homepage']"
    And I click on element with xpath "//*[@id='search_button_homepage']"
    And I wait for element with xpath "//*[@id='links']" to be present
    Then element with xpath "//*[@id='links']" should contain text "Weather"

  @predefined6
  Scenario: Predefined steps for Swisscows
    Given I open url "https://swisscows.com"
    Then I should see page title as "Swisscows the alternative, data secure search engine."
    And element with xpath "//*[@name='query']" should be present
    When I type "Weather" into element with xpath "//*[@name='query']"
    And I click on element with xpath "//button[@class='search-submit']"
    And I wait for element with xpath "//*[@class='web-results']" to be present
    Then element with xpath "//*[@class='web-results']" should contain text "Weather"

  @predefined7
  Scenario: Predefined steps for Searchencrypt 
    Given I open url "https://www.searchencrypt.com"
    Then I should see page title contains "Search Encrypt | Home"
    And element with xpath "//*[@name='q']" should be present
    When I type "Weather" into element with xpath "//*[@name='q']"
    And I click on element with xpath "//*[@type='submit']"
    And I wait for element with xpath "//*[@class='serp__results container']" to be present
    Then element with xpath "//*[@class='serp__results container']" should contain text "Weather"

  @predefined8
  Scenario: Predefined steps for Startpage
    Given I open url "https://www.startpage.com"
    Then I should see page title contains "Startpage.com - The world's most private search engine"
    And element with xpath "//*[@id='q']" should be present
    When I type "Weather" into element with xpath "//*[@id='q']"
    And I click on element with xpath "//*[@class='search-form-home__form__button']"
    And I wait for element with xpath "//*[@class='show-results']" to be present
    And I wait for 2 sec
    Then element with xpath "//*[@class='show-results']" should contain text "Weather"

  @predefined9
  Scenario: Predefined steps for Yandex
    Given I open url "https://www.yandex.com"
    Then I should see page title contains "Yandex"
    And element with xpath "//*[@id='text']" should be present
    When I type "Weather" into element with xpath "//*[@id='text']"
    And I click on element with xpath "//*[@type='submit']"
    And I wait for element with xpath "//*[@class='content__left']" to be present
    Then element with xpath "//*[@class='content__left']" should contain text "weather"

  @predefined10
  Scenario: Predefined steps for Boardreader
    Given I open url "http://boardreader.com"
    Then I should see page title contains "Boardreader - Forum Search Engine"
    And element with xpath "//*[@id='title-query']" should be present
    When I type "Weather" into element with xpath "//*[@id='title-query']"
    And I click on element with xpath "//*[@id='title-submit']"
    And I wait for element with xpath "//*[@class='mdl-list']" to be present
    And I wait for 2 sec
    Then element with xpath "//*[@class='mdl-list']" should contain text "Weather"

  @predefined11
  Scenario: Predefined steps for Ecosia
    Given I open url "https://www.ecosia.org"
    Then I should see page title contains "Ecosia - the search engine that plants trees"
    And element with xpath "//*[@name='q']" should be present
    When I type "Weather" into element with xpath "//*[@name='q']"
    And I click on element with xpath "//*[@type='submit']"
    And I wait for element with xpath "//*[@class='mainline-results']" to be present
    Then element with xpath "//*[@class='mainline-results']" should contain text "Weather"

  @predefined12
  Scenario: Validate responsive UI behavior
    Given I open url "https://skryabin.com/market/quote.html"
    When I resize window to 1280 and 1024
    Then element with xpath "//*[@id='location']" should be displayed
    When I resize window to 800 and 1024
    Then element with xpath "//*[@id='location']" should be displayed
    When I resize window to 400 and 1024
    Then element with xpath "//*[@id='location']" should not be displayed

  @predefined13
  Scenario: Validate minimal Username field length
    Given I open url "https://skryabin.com/market/quote.html"
    When I type "a" into element with xpath "//input[@name='username']"
    And I click on element with xpath "//*[@id='formSubmit']"
    Then element with xpath "//*[@id='username-error']" should be displayed
    When I clear element with xpath "//input[@name='username']"
    And I type "ab" into element with xpath "//input[@name='username']"
    Then element with xpath "//*[@id='username-error']" should not be displayed


  @predefined14
  Scenario: Validate Email field accepts only valid email addresses
    Given I open url "https://skryabin.com/market/quote.html"
    When I type "test" into element with xpath "//input[@name='email']"
    And I click on element with xpath "//*[@id='formSubmit']"
    Then element with xpath "//label[@id='email-error']" should be displayed
    When I clear element with xpath "//input[@name='username']"
    And I type "test@mail.com" into element with xpath "//input[@name='email']"
    And I click on element with xpath "//*[@id='formSubmit']"
    Then element with xpath "//label[@id='email-error']" should not be displayed

  @predefined15
  Scenario: Validate Confirm Password field is disabled
    Given I open url "https://skryabin.com/market/quote.html"
    Then element with xpath "//input[@id='confirmPassword']" should have attribute "disabled" as "true"

  @predefined16
  Scenario: Validate “Name” field behavior
    Given I open url "https://skryabin.com/market/quote.html"
    When I click on element with xpath "//*[@id='name']"
    Then element with xpath "//*[@id='nameDialog']" should be displayed
    When I type "Chandler" into element with xpath "//*[@id='firstName']"
    And I type "M" into element with xpath "//*[@id='middleName']"
    And I type "Bing" into element with xpath "//*[@id='lastName']"
    And I click on element with xpath "//span[contains(text(),'Save')]"
    Then element with xpath "//*[@id='name']" should have attribute "value" as "Chandler M Bing"

  @predefined17
  Scenario: Validate Accepting Privacy Policy field is required
    Given I open url "https://skryabin.com/market/quote.html"
    When I click on element with xpath "//*[@id='formSubmit']"
    Then element with xpath "//*[@id='agreedToPrivacyPolicy-error']" should be displayed

  @predefined18
  Scenario: Validate non-required fields
    Given I open url "https://skryabin.com/market/quote.html"
    When I type "123" into element with xpath "//input[@name='phone']"
    And I click on element with xpath "//option[contains(text(),'Russia')]"
    And I click on element with xpath "//*[@value='female']"
    And I click on element with xpath "//*[@name='allowedToContact']"
    And I type "100 Main st" into element with xpath "//*[@id='address']"
    And I click on element with xpath "//*[@id='thirdPartyButton']"
    And I accept alert
    And I click on element with xpath "//*[@id='dateOfBirth']"
    And I click on element with xpath "//*[@class='ui-datepicker-year']/*[@value='2000']"
    And I click on element with xpath "//option[contains(text(),'Jan')]"
    And I click on element with xpath "//*[@data-handler='selectDay']/*[text()='1']"

  @predefined19
  Scenario: Verify the data after submission
    Given I open url "https://skryabin.com/market/quote.html"
    When I click on element with xpath "//*[@id='name']"
    And I type "Chandler" into element with xpath "//*[@id='firstName']"
    And I type "M" into element with xpath "//*[@id='middleName']"
    And I type "Bing" into element with xpath "//*[@id='lastName']"
    And I click on element with xpath "//span[contains(text(),'Save')]"
    And I type "Test" into element with xpath "//input[@name='username']"
    And I type "test@mail.com" into element with xpath "//input[@name='email']"
    And I type "12345" into element with xpath "//input[@id='password']"
    And I type "12345" into element with xpath "//input[@id='confirmPassword']"
    And I click on element with xpath "//*[@name='agreedToPrivacyPolicy']"
    And I click on element with xpath "//*[@id='formSubmit']"
    Then I wait for element with xpath "//*[@id='quotePageResult']" to be present
    And element with xpath "//b[@name='firstName']" should contain text "Chandler"
    And element with xpath "//b[@name='lastName']" should contain text "Bing"
    And element with xpath "//b[@name='middleName']" should contain text "M"
    And element with xpath "//b[@name='name']" should contain text "Chandler M Bing"
    And element with xpath "//b[@name='username']" should contain text "test"
    And element with xpath "//b[@name='email']" should contain text "test@mail.com"
    And element with xpath "//b[@name='password']" should not contain text "12345"


  @predefined20
  Scenario: Validate filter on Dice
    Given I open url "https://www.dice.com/"
    When I type "Software QA engineer" into element with xpath "//*[@placeholder='Job title, skills or company']"
    And I type "92130" into element with xpath "//*[@id='google-location-search']"
    And I click on element with xpath "//*[@id='submitSearch-button']"
    And I wait for element with xpath "//*[@id='facets']" to be present
    Then element with xpath "//*[@id='searchDisplay-div']" should contain text "Remote"
    When I click on element with xpath "//*[contains(text(),'Exclude Remote')]"
    And I wait for 3 sec
    Then element with xpath "//*[@id='searchDisplay-div']" should not contain text "Remote"



  @predefined21
  Scenario: Validate search for Skyscanner
    Given I open url "https://www.skyscanner.com/"
    When I type "San Diego" into element with xpath "//*[@id='fsc-origin-search']"
    And I type "London" into element with xpath "//*[@id='fsc-destination-search']"
    And I click on element with xpath "//*[@id='fsc-trip-type-selector-one-way']"
    And I click on element with xpath "//*[@id='depart-fsc-datepicker-button']"
    And I click on element with xpath "//option[contains(text(),'December 2020')]"
    And I click on element with xpath "//*[@type='submit']"
    And I click on element with xpath "//*[text()='25']"
    Then element with xpath "//*[contains(@class,'FlightsDayView_results')]" should be present

  @predefined22
  Scenario: Validate Date Picker functionality
    Given I open url "https://skryabin.com/market/quote.html"
#    verify that upon clicking dialog appears
    When I click on element with xpath "//*[@id='dateOfBirth']"
    Then element with xpath "//*[@class='ui-datepicker-calendar']" should be displayed
#     choose the date of birth
    And I click on element with xpath "//*[@class='ui-datepicker-year']/*[@value='2000']"
    And I click on element with xpath "//option[contains(text(),'Jan')]"
    And I click on element with xpath "//*[@data-handler='selectDay']/*[text()='1']"
#    fill out required fields
    And I click on element with xpath "//*[@id='name']"
    And I type "Chandler" into element with xpath "//*[@id='firstName']"
    And I type "M" into element with xpath "//*[@id='middleName']"
    And I type "Bing" into element with xpath "//*[@id='lastName']"
    And I click on element with xpath "//span[contains(text(),'Save')]"
    And I type "Test" into element with xpath "//input[@name='username']"
    And I type "test@mail.com" into element with xpath "//input[@name='email']"
    And I type "12345" into element with xpath "//input[@id='password']"
    And I type "12345" into element with xpath "//input[@id='confirmPassword']"
    And I click on element with xpath "//*[@name='agreedToPrivacyPolicy']"
    And I click on element with xpath "//*[@id='formSubmit']"
#     verify that chosen date is formed out correctly
    Then element with xpath "//b[@name='dateOfBirth']" should contain text "01/01/2000"


  @predefined23
  Scenario: Validate iFrame fields
    Given I open url "https://skryabin.com/market/quote.html"
#    fill out required fields
    When I click on element with xpath "//*[@id='name']"
    And I type "Chandler" into element with xpath "//*[@id='firstName']"
    And I type "M" into element with xpath "//*[@id='middleName']"
    And I type "Bing" into element with xpath "//*[@id='lastName']"
    And I click on element with xpath "//span[contains(text(),'Save')]"
    And I type "Test" into element with xpath "//input[@name='username']"
    And I type "test@mail.com" into element with xpath "//input[@name='email']"
    And I type "12345" into element with xpath "//input[@id='password']"
    And I type "12345" into element with xpath "//input[@id='confirmPassword']"
    And I click on element with xpath "//*[@name='agreedToPrivacyPolicy']"
#    fill out iFrames
    And I switch to iframe with xpath "//iframe[@name='additionalInfo']"
    And I type "Ann" into element with xpath "//input[@id='contactPersonName']"
    And I type "54321" into element with xpath "//input[@id='contactPersonPhone']"
    And I switch to default content
#    submit the form
    And I click on element with xpath "//*[@id='formSubmit']"

  @predefined24
  Scenario: Verify "3rd party agreement" button
    Given I open url "https://skryabin.com/market/quote.html"
    When I click on element with xpath "//*[@id='thirdPartyButton']"
    And I accept alert
    Then element with xpath "//*[@id='thirdPartyAgreement']" should have attribute "value" as "accepted"
    When I click on element with xpath "//*[@id='thirdPartyButton']"
    And I dismiss alert
    Then element with xpath "//*[@id='thirdPartyAgreement']" should have attribute "value" as "declined"

  @predefined25
  Scenario: Validate "Related documents" button
    Given I open url "https://skryabin.com/market/quote.html"
    When I click on element with xpath "//*[contains(text(),'Related documents')]"
    And I switch to new window
    And element with xpath "//ul" should contain text "Document 1"
    And element with xpath "//ul" should contain text "Document 2"
    And element with xpath "//ul" should contain text "Document 3"
    #    Return back to the main page and change contents of Address field
    When I switch to first window
    And I clear element with xpath "//*[@id='address']"
    And I type "100 Ocean ave" into element with xpath "//*[@id='address']"

  @predefined26
  Scenario: Validate submit page
    Given I open url "https://skryabin.com/market/quote.html"
#        fill out required fields
    When I click on element with xpath "//*[@id='name']"
    And I type "Chandler" into element with xpath "//*[@id='firstName']"
    And I type "M" into element with xpath "//*[@id='middleName']"
    And I type "Bing" into element with xpath "//*[@id='lastName']"
    And I click on element with xpath "//span[contains(text(),'Save')]"
    And I type "Test" into element with xpath "//input[@name='username']"
    And I type "test@mail.com" into element with xpath "//input[@name='email']"
    And I type "12345" into element with xpath "//input[@id='password']"
    And I type "12345" into element with xpath "//input[@id='confirmPassword']"
    And I type "100 Main st" into element with xpath "//*[@id='address']"
    And I click on element with xpath "//*[@name='agreedToPrivacyPolicy']"
    And I click on element with xpath "//*[@id='formSubmit']"
#    Validate that after submit title for the form changes
    Then element with xpath "//legend[@class='applicationResult']" should contain text "Submitted Application"
#    validate values upon submitting are exactly same as user entered
    And I wait for element with xpath "//*[@id='quotePageResult']" to be present
    And element with xpath "//b[@name='firstName']" should contain text "Chandler"
    And element with xpath "//b[@name='lastName']" should contain text "Bing"
    And element with xpath "//b[@name='middleName']" should contain text "M"
    And element with xpath "//b[@name='name']" should contain text "Chandler M Bing"
    And element with xpath "//b[@name='username']" should contain text "test"
    And element with xpath "//b[@name='email']" should contain text "test@mail.com"
    And element with xpath "//b[@name='password']" should not contain text "12345"
    And element with xpath "//b[@name='address']" should contain text "100 Main st"
#    Validate that upon submitting it only displays fields that were previously entered by the user
    And element with xpath "//span[contains(text(),'Phone')]" should not be present






    



    
    

  