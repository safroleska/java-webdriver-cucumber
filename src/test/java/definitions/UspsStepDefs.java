package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.eo.Se;
import cucumber.api.java.sl.In;
import org.assertj.core.data.Percentage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.HasTouchScreen;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static support.TestContext.*;
import page.*;

public class UspsStepDefs {
    UspsHome uspsHome = new UspsHome();
    UspsLookupByZip uspsLookupByZip = new UspsLookupByZip();
    UspsByAddressForm uspsByAddressForm = new UspsByAddressForm();
    UspsByAddressResult uspsByAddressResult = new UspsByAddressResult();
    UspsPriceCalculator calculator = new UspsPriceCalculator();
    UspsPostcardPriceCalculator postcardPriceCalculator = new UspsPostcardPriceCalculator();

    @When("Go to Lookup ZIP page by address")
    public void goToLookupZIPPageByAddress() {
//        getDriver().findElement(By.xpath("//*[@id='mail-ship-width']")).click();
//        getDriver().findElement(By.xpath("//*[@class='container-fluid']//a[contains(text(),'Look Up a ZIP Code')]")).click();

        //mouse over
        WebElement mailAndShip = getDriver().findElement(By.xpath("//a[@id='mail-ship-width']"));
        WebElement lookForZip = getDriver().findElement(By.xpath("//li[@class='tool-zip']//a[contains(@href,'Zip')]"));
        Actions actions= getActions();

        actions.moveToElement(mailAndShip)
                .click(lookForZip)
                .perform();//cascading calls

        getDriver().findElement(By.xpath("//*[contains(text(),'Find by Address')]")).click();


    }

    @And("I fill out {string} street, {string} city, {string} state")
    public void iFillOutStreetCityState(String street, String city, String state) {
        getDriver().findElement(By.xpath("//*[@id='tAddress']")).sendKeys(street);
        getDriver().findElement(By.xpath("//*[@id='tCity']")).sendKeys(city);

        Select stateSelect=new Select(getDriver().findElement(By.xpath("//*[@id='tState']")));
        stateSelect.selectByValue(state);

//        getDriver().findElement(By.xpath("//*[@id='tState']//*[contains(text(),'"+ state +"')]")).click();

        getDriver().findElement(By.xpath("//*[@id='zip-by-address']")).click();
    }

    @Then("I validate {string} zip code exists in the result")
    public void iValidateZipCodeExistsInTheResult(String zip) throws InterruptedException {
//        Thread.sleep(2000);
        //explicit wait

        WebElement result = getDriver().findElement(By.xpath("//*[@id='zipByAddressDiv']"));
//        wait.until(ExpectedConditions.textToBePresentInElement(result, zip));
        //same as:
        getWait().until(driver ->result.getText().contains(zip));
//        wait.until(driver->!result.getText().isEmpty()); //the same
//        wait.until(driver->result.getText().length()>0); //the same

//        assertThat(result.getText()).contains(zip);
    }

    @When("I go to Calculate Price Page")
    public void iGoToCalculatePricePage() {
        WebElement mailAndShip = getDriver().findElement(By.xpath("//a[@id='mail-ship-width']"));
        WebElement calAndPrice = getDriver().findElement(By.xpath("//li[@class='tool-calc']//a[contains(text(),'Calculate a Price')]"));
        getActions().moveToElement(mailAndShip)
                .click(calAndPrice).perform();
    }

    @And("I select {string} with {string} shape")
    public void iSelectWithShape(String country, String shape) {
        Select countrySelect = new Select(getDriver().findElement(By.xpath("//select[@id='CountryID']")));
        countrySelect.selectByVisibleText(country);
        getDriver().findElement(By.xpath("//input[@id='ItemValue']")).sendKeys("0");
        getDriver().findElement(By.xpath("//*[@type='submit'][@value='Postcard']")).click();
    }

    @And("I define {string} quantity")
    public void iDefineQuantity(String num) {
        getDriver().findElement(By.xpath("//*[@placeholder='Quantity']")).sendKeys(num);
        getDriver().findElement(By.xpath("//*[@type='button'][@value='Calculate']")).click();

    }

    @Then("I calculate the price and validate cost is {string}")
    public void iCalculateThePriceAndValidateCostIs(String cost) {
        assertThat(getDriver().findElement(By.xpath("//div[@id='total']")).getText()).isEqualTo(cost);
    }

    @When("I perform {string} search")
    public void iPerformSearch(String name) {
//        getDriver().findElement(By.xpath("//a[contains(text(),'Search USPS.com')]")).click();
//        getDriver().findElement(By.xpath("//div[@class='repos']//a[contains(text(),'"+name+"')]")).click();
        String correctName = name.toUpperCase();
        WebElement search = getDriver().findElement(By.xpath("//a[contains(text(),'Search USPS.com')]"));
        WebElement searchName = getDriver().findElement(By.xpath("//div[@class='repos']//a[text()='"+correctName+"']"));
        getActions().moveToElement(search)
                .click(searchName)
                .perform();
    }

    @And("I set {string} in filters")
    public void iSetInFilters(String filter)  {
        WebElement spinner = getDriver().findElement(By.xpath("//div[@class='white-spinner-container']"));
//        wait.until(ExpectedConditions.invisibilityOf(spinner));
        WebElement filterElement = getDriver().findElement(By.xpath("//a[@class='dn-attr-a'][contains(text(),'"+filter+"')]"));


        getExecutor().executeScript("arguments[0].click()",filterElement);

//        getDriver().findElement(By.xpath("//a[@class='dn-attr-a'][contains(text(),'"+filter+"')]")).click();
        getWait().until(invisibilityOf(spinner));
    }

    @Then("I verify that {string} results found")
    public void iVerifyThatResultsFound(String expectedCount) throws InterruptedException {
//        Thread.sleep(2000);
//
//        getWait().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@id='records']")));
        int expectedSize = Integer.parseInt(expectedCount);

        String heading = getDriver().findElement(By.xpath("//*[@id='searchResultsHeading']")).getText();

        //removing everything except the number
        String headingCount = heading.replaceAll("\\D*","");
        int parsedHeadingCount = Integer.parseInt(headingCount);
        List<WebElement> result = getDriver().findElements(By.xpath("//ul[@id='records']//li"));
        int actualResult = result.size();

        assertThat(actualResult).isEqualTo(expectedSize);
        assertThat(actualResult).isEqualTo(parsedHeadingCount);

    }

    @When("I go to {string} tab")
    public void iGoToTab(String tabName) {
//        getDriver().findElement(By.xpath("//a[@class='menuitem'][contains(text(),'Help')]")).click();
        getDriver().findElement(By.xpath("//li/a[text()='"+tabName+"']")).click();
    }

    @And("I perform {string} help search")
    public void iPerformHelpSearch(String text) {
        getDriver().findElement(By.xpath("//*[@placeholder='Search for a topic']")).sendKeys(text);
        getWait().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@class,'search-button')]")));
        getDriver().findElement(By.xpath("//*[contains(@class,'search-button')]")).click();
    }

    @Then("I verify that no results of {string} available in help search")
    public void iVerifyThatNoResultsOfAvailableInHelpSearch(String text) {
        getWait().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='resultsWrapper']")));
        assertThat(getDriver().findElement(By.xpath("//div[@class='resultsWrapper']")).getText()).doesNotContain(text);
    }

    @When("I navigate to Find a Location page")
    public void iNavigateToFindALocationPage() {
        WebElement quickTools = getDriver().findElement(By.xpath("//a[@class='nav-first-element menuitem']"));
        WebElement findLocation = getDriver().findElement(By.xpath("//p[contains(text(),'Find USPS Locations')]"));
        getActions().moveToElement(quickTools)
                .click(findLocation)
                .perform();
    }

    @And("I filter by {string} location types, {string} services, {string} available services")
    public void iFilterByLocationTypesServicesAvailableServices(String location, String services, String availServ)  {
        getDriver().findElement(By.xpath("//button[@id='post-offices-select']")).click();
        getDriver().findElement(By.xpath("//*[@id='post-offices-select']/..//*[text()='"+location+"'][@data-value='po'] ")).click();
        getActions().click(getDriver().findElement(By.xpath("//button[@id='service-type-select']")))
                .click(getDriver().findElement(By.xpath("//li[@id='pickupPo']"))).perform();
        getActions().click(getDriver().findElement(By.xpath("//button[@id='available-service-select']")))
                .click(getDriver().findElement(By.xpath("//a[contains(text(),'"+availServ+"')]"))).perform();

//        new Select(getDriver().findElement(By.xpath("//*[@id='post-offices-select']")))
//                .selectByVisibleText(location);
//        new Select(getDriver().findElement(By.xpath("//*[@id='service-type-select']")))
//                .selectByVisibleText(services);
//        Thread.sleep(2000);
////                getWait().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='available-service-select']")));
//        new Select(getDriver().findElement(By.xpath("//*[@id='available-service-select']")))
//                .selectByVisibleText(availServ);
//        getDriver().findElement(By.xpath("//a[@id='searchLocations']")).click();

    }

    @And("I provide data as {string} street, {string} city, {string} state")
    public void iProvideDataAsStreetCityState(String street, String city, String state) throws InterruptedException {
        getDriver().findElement(By.xpath("//input[@id='search-input']")).click();
        Thread.sleep(1000);

//                getWait().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='addressLineOne']")));
        getDriver().findElement(By.xpath("//input[@id='addressLineOne']")).sendKeys(street);
        getDriver().findElement(By.xpath("//input[@id='cityOrZipCode']")).sendKeys(city);
        new Select(getDriver().findElement(By.xpath("//select[@id='servicesStateSelect']"))).selectByValue(state);
        getDriver().findElement(By.xpath("//a[contains(text(),'Go to Results')]")).click();
        getDriver().findElement(By.xpath("//a[@id='searchLocations']")).click();


    }

    @Then("I verify phone number is {string}")
    public void iVerifyPhoneNumberIs(String phone) {

        getWait().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='resultBox']")));
        getDriver().findElement(By.xpath("//div[@id='1440608']//span[@class='listArrow']")).click();
        String result= getDriver().findElement(By.xpath("//p[@class='ask-usps']")).getText();
        assertThat(result).contains(phone);

//        WebElement resultBox = getDriver().findElement(By.xpath("//div[@id='resultBox']"));
//
//        getWait().until(driver->!resultBox.getText().isEmpty());
//        resultBox.findElement(By.xpath("//span[@class='listArrow']")).click();
//        String resultPhoneNumber = getDriver().findElement(By.xpath("//p[@class='ask-usps']")).getText();
//        resultPhoneNumber = resultPhoneNumber.substring(resultPhoneNumber.indexOf("(")+1,resultPhoneNumber.indexOf(")"));
//        assertThat(resultPhoneNumber).isEqualTo(phone);
//        System.out.println("Actual phone number: " + resultPhoneNumber);
//        System.out.println("Expected phone number: " + phone);

    }



    @When("I select {string} in results")
    public void iSelectInResults(String resultOption) {
        getWait(10).until(invisibilityOf(getDriver().findElement(By.xpath("//div[@class='white-spinner-container']"))));
        getDriver().findElement(By.xpath("//span[contains(text(),'"+resultOption+"')]")).click();
    }

    @And("I click {string} button")
    public void iClickButton(String buttonTitle) throws InterruptedException {
            int numOfWin = getDriver().getWindowHandles().size();



        //until less then initial numOfWin+1 click on that button
            while (getDriver().getWindowHandles().size() < numOfWin + 1) {
                getDriver().findElement(By.xpath("//a[contains(text(),'" + buttonTitle + "')]")).click();
                Thread.sleep(100);
            }
        }
//        getDriver().findElement(By.xpath("//a[@class='button--primary']")).click();


    @Then("I validate that Sign In is required")
    public void iValidateThatSignInIsRequired() {
        String originalWindow = getDriver().getWindowHandle();
        // switch to new window
        for (String handle : getDriver().getWindowHandles()) {
            getDriver().switchTo().window(handle);
        }

        getWait(10).until(ExpectedConditions.titleContains("Sign In"));

        getDriver().findElement(By.xpath("//button[@id='btn-submit']")).click();
        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='error-username']")));
        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='error-password']")));

        // switch back
        getDriver().switchTo().window(originalWindow);
//        String originalWindow = getDriver().getWindowHandle();
//        //switch to the new window
//        for (String handle: getDriver().getWindowHandles()){
//            getDriver().switchTo().window(handle);
//        }
//        getWait().until(ExpectedConditions.titleContains("Sign in"));
//        WebElement username= getDriver().findElement(By.xpath("//*[id='username']"));
//        assertThat(username.isDisplayed()).isTrue();
//        //switch back
//        getDriver().switchTo().window(originalWindow);

    }

    @When("I go to {string} under {string}")
    public void iGoToUnder(String link, String menu) {
        getActions().moveToElement(getDriver().findElement(By.xpath("//a[@class='menuitem'][text()='"+menu+"']")))
                .click(getDriver().findElement(By.xpath("//li/a[text()='"+link+"']")))
                .perform();
    }

    @And("I search for {string}")
    public void iSearchFor(String address) {
        getDriver().findElement(By.xpath("//input[@id='address']")).sendKeys(address);
        getDriver().findElement(By.xpath("//button[@type='submit']//span[@class='icon']")).click();

    }

    @And("I click {string} on the map")
    public void iClickOnTheMap(String text) throws InterruptedException {
////        Thread.sleep(5000);
//        getWait().until(driver ->!getDriver().findElement(By.xpath("//*[@id='eddm_overlay-progress'] ")).isDisplayed());
//        getWait(10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='toggle-icon']")));
//        getDriver().findElement(By.xpath("//span[@class='toggle-icon']")).click();

        WebElement overlay = getDriver().findElement(By.xpath("//div[@id='eddm_overlay-progress']"));
        getWait().until(visibilityOf(overlay));
        getWait(10).until(invisibilityOf(overlay));
        getDriver().findElement(By.xpath("//a[contains(text(),'" + text + "')]")).click();
    }

    @When("I click {string} on the table")
    public void iClickOnTheTable(String text) {
        getDriver().findElement(By.xpath("//*[@id='route-table']//*[contains(text(),'"+text+"')]")).click();
    }

    @And("I close modal window")
    public void iCloseModalWindow() {
        getDriver().findElement(By.xpath("//div[@id='modal-box-closeModal']")).click();
    }


    @Then("I verify that summary of all rows of Cost column is equal Approximate Cost in Order Summary")
    public void iVerifyThatSummaryOfAllRowsOfCostColumnIsEqualApproximateCostInOrderSummary() throws ParseException {

            String totalCountString = getDriver().findElement(By.xpath("//a[contains(@class, 'totalsArea')]")).getText();
            int totalCount = Integer.parseInt(totalCountString.replaceAll("\\D*", ""));

            By costListSelector = By.xpath("//td[@idx='7']");
            List<WebElement> costList = getDriver().findElements(costListSelector);
            System.out.println("Expected elements size: " + totalCount);

            // dealing with infinite scroll
            while (costList.size() < totalCount) {
                System.out.println("Actual elements size: " + costList.size());
                int lastIndex = costList.size() - 1;
                getActions().moveToElement(costList.get(lastIndex)).perform();
                costList = getDriver().findElements(costListSelector);
            }
            System.out.println("Actual elements size: " + costList.size());

            Locale locale = new Locale("en", "US");
            NumberFormat formatter = NumberFormat.getCurrencyInstance(locale);
            double actualTotal = 0;
            for (WebElement cost : costList) {
                double costTotal = formatter.parse(cost.getText()).doubleValue();
                actualTotal += costTotal;
            }
            System.out.println("Actual total " + actualTotal);

            String expectedTotalString = getDriver().findElement(By.xpath("//span[@class='approx-cost']")).getText();
            double expectedTotal = Double.parseDouble(expectedTotalString);
            System.out.println("Expected total " + expectedTotal);

            assertThat(actualTotal).isCloseTo(expectedTotal, Percentage.withPercentage(1));


    }

    @And("I enter {string} into store search")
    public void iEnterIntoStoreSearch(String text) {
        getDriver().findElement(By.xpath("//input[@id='store-search']")).sendKeys(text);
        getDriver().findElement(By.xpath("//input[@id='store-search-btn']")).click();
    }

    @Then("I search and validate no products found")
    public void iSearchAndValidateNoProductsFound() {
        assertThat(getDriver().findElement(By.xpath("//p[contains(text(),'Your search did not match any products.')]")).isDisplayed());

    }

    @And("choose mail service Priority Mail")
    public void chooseMailServicePriorityMail() throws InterruptedException {
        getExecutor().executeScript("arguments[0].click()",getDriver().findElement(By.xpath("//input[@id='checkbox-type-Mail Service-Priority Mail-1']")));
    }

    @Then("I verify {int} items found")
    public void iVerifyItemsFound(int num) {
        String count= Integer.toString(num);
        assertThat(getDriver().findElement(By.xpath("//div[@class='header-menu']//*[contains(@class,'results')]"))
                .getText()).contains(count);
    }

    @And("I submit {string}")
    public void iSubmit(String buttonName) {
        getDriver().findElement(By.xpath("//a[@class='button--primary'][contains(text(),'"+buttonName+"')]")).click();
    }

    @And("verify {string} service exists")
    public void verifyServiceExists(String serviceName) {
        assertThat(getDriver().findElement(By.xpath("//option[contains(text(),'"+serviceName+"')]")).isDisplayed());
    }

    @When("I unselect Stamps checkbox")
    public void iUnselectStampsCheckbox() {
        getDriver().findElement(By.xpath("//*[@for='checkbox-type-Category-Stamps']")).click();
    }

    @And("select Vertical stamp Shape")
    public void selectVerticalStampShape() {
        getExecutor().executeScript("arguments[0].click()",getDriver().findElement(By.xpath("//*[contains(@for,'Vertical')]")));
    }

    @And("I click {string} color")
    public void iClickColor(String color) {
        String colorLowCase= color.toLowerCase();
        getExecutor().executeScript("arguments[0].click()",getDriver().findElement(By.xpath("//*[contains(@onclick,'"+colorLowCase+"')]")));
    }

    @Then("I verify {string} and {string} filters")
    public void iVerifyAndFilters(String color, String filter) {
        WebElement vertical = getDriver().findElement(By.xpath("//input[contains(@id,'"+filter+"')]"));
        assertThat(vertical.getAttribute("checked"));
        assertThat(getDriver().findElement(By.xpath("//div[@class='result-grid active']")).isSelected());
        assertThat(getDriver().findElement(By.xpath("//div[@class='cartridge-viewport']//span[contains(text(),'"+color+"')]")).isDisplayed());
        assertThat(getDriver().findElement(By.xpath("//div[@class='cartridge-viewport']//span[contains(text(),'"+filter+"')]")).isDisplayed());


    }

    @And("I reserve new PO box for {string}")
    public void iReserveNewPOBoxFor(String zip) {
        getDriver().findElement(By.xpath("//input[@id='searchInput']")).sendKeys(zip);
        getDriver().findElement(By.xpath("//a[@class='searchBtn']")).click();


    }

    @Then("I verify that {string} present")
    public void iVerifyThatPresent(String officeName) {
        getWait(15).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='locationContainer_1']")));
        assertThat(getDriver().findElement(By.xpath("//div[@id='locationContainer_1']")).getText()).contains(officeName);
    }

    @And("I verify that {string} PO Box is available in {string}")
    public void iVerifyThatPOBoxIsAvailableIn(String size, String officeName) {
        getDriver().findElement(By.xpath("//div[@id='locationContainer_1']")).click();
        assertThat(getDriver().findElement(By.xpath("//div[@id='availableboxes']")).getText()).contains(size);
    }

    @And("I verify that items below {int} dollars exists")
    public void iVerifyThatItemsBelowDollarsExists(int priceToCheck) throws ParseException {
        List<WebElement> priceList = getDriver().findElements(By.xpath("//*[@class='results-product-preview-price']"));
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        for (WebElement cost: priceList) {
            double value = formatter.parse(cost.getText()).doubleValue();
            if (value<priceToCheck){
                break;
            }
        }
    }

    @When("I go to Lookup ZIP page by address oop")
    public void iGoToLookupZIPPageByAddressOop() {
        uspsHome.goToLookupByZip();
        uspsLookupByZip.clickFindByAddress();
    }

    @And("I fill out {string} street, {string} city, {string} state oop")
    public void iFillOutStreetCityStateOop(String street, String city, String state) {
        uspsByAddressForm.fillStreet(street);
        uspsByAddressForm.fillCity(city);
        uspsByAddressForm.selectState(state);
        uspsByAddressForm.clickFind();
    }

    @Then("I validate {string} zip code exists in the result oop")
    public void iValidateZipCodeExistsInTheResultOop(String zip) {
        String actualTotalResult = uspsByAddressResult.getSearchResult();
        assertThat(actualTotalResult).contains(zip);

        boolean areAllItemsContainZip = uspsByAddressResult.areAllResultsContainZip(zip);
        assertThat(areAllItemsContainZip).isTrue();
    }

    @When("I go to Calculate Price Page oop")
    public void iGoToCalculatePricePageOop() {
        uspsHome.goToCalculatePrice();
    }

    @And("I select {string} with {string} shape oop")
    public void iSelectWithShapeOop(String country, String shape) {
       calculator.countrySelect(country);
       calculator.shapeChoose(shape);
    }



// I do not understand why I get nullPointerException calling these two methods below. Please, help!



    @And("I define {string} quantity oop")
    public void iDefineQuantityOop(String num) {
        postcardPriceCalculator.defineQuantity(num);
    }

    @Then("I calculate the price and validate cost is {string} oop")
    public void iCalculateThePriceAndValidateCostIsOop(String costValue) {
        postcardPriceCalculator.calculateThePrice();
        assertThat(postcardPriceCalculator.validateCost()).isEqualTo(costValue);
    }
}


