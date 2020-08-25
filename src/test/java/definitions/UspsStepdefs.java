package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.eo.Se;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class UspsStepdefs {
    @When("Go to Lookup ZIP page by address")
    public void goToLookupZIPPageByAddress() {
//        getDriver().findElement(By.xpath("//*[@id='mail-ship-width']")).click();
//        getDriver().findElement(By.xpath("//*[@class='container-fluid']//a[contains(text(),'Look Up a ZIP Code')]")).click();

        //mouse over
        WebElement mailAndShip = getDriver().findElement(By.xpath("//a[@id='mail-ship-width']"));
        WebElement lookForZip = getDriver().findElement(By.xpath("//li[@class='tool-zip']//a[contains(@href,'Zip')]"));
        Actions actions= new Actions(getDriver());

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
        WebDriverWait wait= new WebDriverWait(getDriver(),5);
        WebElement result = getDriver().findElement(By.xpath("//*[@id='zipByAddressDiv']"));
        wait.until(ExpectedConditions.textToBePresentInElement(result, zip));

//        assertThat(getDriver().findElement(By.xpath("//*[@id='zipByAddressDiv']")).getText()).contains(zip);
    }

    @When("I go to Calculate Price Page")
    public void iGoToCalculatePricePage() {
        WebElement mailAndShip = getDriver().findElement(By.xpath("//a[@id='mail-ship-width']"));
        WebElement calAndPrice = getDriver().findElement(By.xpath("//li[@class='tool-calc']//a[contains(text(),'Calculate a Price')]"));
        new Actions(getDriver()).moveToElement(mailAndShip)
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
        WebElement quickTools = getDriver().findElement(By.xpath("//a[@class='nav-first-element menuitem']"));
        WebElement freeBoxes = getDriver().findElement(By.xpath("//p[contains(text(),'"+name+"')]"));
        new Actions(getDriver()).moveToElement(quickTools)
                .click(freeBoxes)
                .perform();
    }

    @And("I set {string} in filters")
    public void iSetInFilters(String filter) {
    }

    @When("I go to {string} tab")
    public void iGoToTab(String arg0) {
        getDriver().findElement(By.xpath("//a[@class='menuitem'][contains(text(),'Help')]")).click();
    }

    @And("I perform {string} help search")
    public void iPerformHelpSearch(String text) {
        getDriver().findElement(By.xpath("//*[@placeholder='Search for a topic']")).sendKeys(text);
        WebDriverWait wait= new WebDriverWait(getDriver(),2);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@class,'search-button')]")));
        getDriver().findElement(By.xpath("//*[contains(@class,'search-button')]")).click();
    }

    @Then("I verify that no results of {string} available in help search")
    public void iVerifyThatNoResultsOfAvailableInHelpSearch(String text) {
        WebDriverWait wait= new WebDriverWait(getDriver(),5);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='resultsWrapper']")));
        assertThat(getDriver().findElement(By.xpath("//div[@class='resultsWrapper']")).getText()).doesNotContain(text);
    }

    @When("I navigate to Find a Location page")
    public void iNavigateToFindALocationPage() {
        WebElement quickTools = getDriver().findElement(By.xpath("//a[@class='nav-first-element menuitem']"));
        WebElement findLocation = getDriver().findElement(By.xpath("//p[contains(text(),'Find USPS Locations')]"));
        new Actions(getDriver()).moveToElement(quickTools)
                .click(findLocation)
                .perform();
    }

    @And("I filter by {string} location types, {string} services, {string} available services")
    public void iFilterByLocationTypesServicesAvailableServices(String location, String services, String availServ)  {
        getDriver().findElement(By.xpath("//button[@id='post-offices-select']")).click();
        getDriver().findElement(By.xpath("//*[@id='post-offices-select']/..//*[text()='"+location+"'][@data-value='po'] ")).click();
        new Actions(getDriver()).click(getDriver().findElement(By.xpath("//button[@id='service-type-select']")))
                .click(getDriver().findElement(By.xpath("//li[@id='pickupPo']"))).perform();
        new Actions(getDriver()).click(getDriver().findElement(By.xpath("//button[@id='available-service-select']")))
                .click(getDriver().findElement(By.xpath("//a[contains(text(),'"+availServ+"')]"))).perform();

//        new Select(getDriver().findElement(By.xpath("//*[@id='post-offices-select']")))
//                .selectByVisibleText(location);
//        new Select(getDriver().findElement(By.xpath("//*[@id='service-type-select']")))
//                .selectByVisibleText(services);
//        Thread.sleep(2000);
////        new WebDriverWait(getDriver(),5)
////                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='available-service-select']")));
//        new Select(getDriver().findElement(By.xpath("//*[@id='available-service-select']")))
//                .selectByVisibleText(availServ);
//        getDriver().findElement(By.xpath("//a[@id='searchLocations']")).click();

    }

    @And("I provide data as {string} street, {string} city, {string} state")
    public void iProvideDataAsStreetCityState(String street, String city, String state) throws InterruptedException {
        getDriver().findElement(By.xpath("//input[@id='search-input']")).click();
        Thread.sleep(1000);
//        new WebDriverWait(getDriver(),5)
//                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='addressLineOne']")));
        getDriver().findElement(By.xpath("//input[@id='addressLineOne']")).sendKeys(street);
        getDriver().findElement(By.xpath("//input[@id='cityOrZipCode']")).sendKeys(city);
        new Select(getDriver().findElement(By.xpath("//select[@id='servicesStateSelect']"))).selectByValue(state);
        getDriver().findElement(By.xpath("//a[contains(text(),'Go to Results')]")).click();
        getDriver().findElement(By.xpath("//a[@id='searchLocations']")).click();



    }

    @Then("I verify phone number is {string}")
    public void iVerifyPhoneNumberIs(String phone) {

    }
}


