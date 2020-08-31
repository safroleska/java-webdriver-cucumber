package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.eo.Se;
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


import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.*;

public class UspsStepdefs {
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
        getDriver().findElement(By.xpath("//*[@placeholder='Quantity']")).sendKeys("2");
        getDriver().findElement(By.xpath("//*[@type='button'][@value='Calculate']")).click();

    }

    @Then("I calculate the price and validate cost is {string}")
    public void iCalculateThePriceAndValidateCostIs(String cost) {
        assertThat(getDriver().findElement(By.xpath("//div[@id='total']")).getText()).isEqualTo(cost);
    }

    @When("I perform {string} search")
    public void iPerformSearch(String name) {
        WebElement search = getDriver().findElement(By.xpath("//a[contains(text(),'Search USPS.com')]"));
        WebElement freeBoxes = getDriver().findElement(By.xpath("//div[@class='repos']//a[text()='FREE BOXES']"));
        getActions().moveToElement(search)
                .click(freeBoxes)
                .perform();
    }

    @And("I set {string} in filters")
    public void iSetInFilters(String filter)  {
        WebElement spinner = getDriver().findElement(By.xpath("//div[@class='white-spinner-container']"));
//        wait.until(ExpectedConditions.invisibilityOf(spinner));
        WebElement filterElement = getDriver().findElement(By.xpath("//a[@class='dn-attr-a'][contains(text(),'"+filter+"')]"));


        getExecutor().executeScript("arguments[0].click()",filterElement);

//        getDriver().findElement(By.xpath("//a[@class='dn-attr-a'][contains(text(),'"+filter+"')]")).click();
        getWait().until(ExpectedConditions.invisibilityOf(spinner));
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
    public void iGoToTab(String arg0) {
        getDriver().findElement(By.xpath("//a[@class='menuitem'][contains(text(),'Help')]")).click();
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
    public void iSelectInResults(String priorityMail) {
        getDriver().findElement(By.xpath("//span[contains(text(),'"+priorityMail+"')]")).click();
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
        getActions().moveToElement(getDriver().findElement(By.xpath("//a[@class='menuitem'][text()='Business']")))
                .click(getDriver().findElement(By.xpath("//a[text()='Every Door Direct Mail']")))
                .perform();
    }

    @And("I search for {string}")
    public void iSearchFor(String address) {
        getDriver().findElement(By.xpath("//input[@id='address']")).sendKeys(address);
        getDriver().findElement(By.xpath("//button[@type='submit']//span[@class='icon']")).click();

    }

    @And("I click {string} on the map")
    public void iClickOnTheMap(String arg0) throws InterruptedException {
//        Thread.sleep(5000);
        getWait().until(driver ->!getDriver().findElement(By.xpath("//*[@id='eddm_overlay-progress'] ")).isDisplayed());
        getWait().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='toggle-icon']")));
        getDriver().findElement(By.xpath("//span[@class='toggle-icon']")).click();

    }

    @When("I click {string} on the table")
    public void iClickOnTheTable(String selectAll) {
        getDriver().findElement(By.xpath("//*[@id='grid']//*[contains(text(),'"+selectAll+"')]")).click();
    }

    @And("I close modal window")
    public void iCloseModalWindow() {
//        WebElement modal = getDriver().findElement(By.xpath("//div[@id='modal-box']"));
//        getDriver().switchTo().alert().dismiss();
        String originalWindow = getDriver().getWindowHandle();
        for (String handle : getDriver().getWindowHandles()) {
            getDriver().switchTo().window(handle);
        }
//
//        ////div[@id='modal-box-closeModal']
        getDriver().findElement(By.xpath("//button[@id='dropOffDone']")).click();
        getDriver().switchTo().window(originalWindow);
    }


}


