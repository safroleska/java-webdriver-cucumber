package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;


import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class UspsStepdefs {
    @When("Go to Lookup ZIP page by address")
    public void goToLookupZIPPageByAddress() {
        getDriver().findElement(By.xpath("//*[@id='mail-ship-width']")).click();
        getDriver().findElement(By.xpath("//*[@class='container-fluid']//a[contains(text(),'Look Up a ZIP Code')]")).click();
        getDriver().findElement(By.xpath("//*[contains(text(),'Find by Address')]")).click();
    }

    @And("And I fill out {string} street, {string} city, {string} state")
    public void andIFillOutStreetCityState(String street, String city, String state) {
        getDriver().findElement(By.xpath("//*[@id='tAddress']")).sendKeys(street);
        getDriver().findElement(By.xpath("//*[@id='tCity']")).sendKeys(city);
        getDriver().findElement(By.xpath("//*[@id='tState']//*[contains(text(),'"+ state +"')]")).click();
        getDriver().findElement(By.xpath("//*[@id='zip-by-address']")).click();
    }

    @Then("I validate {string} zip code exists in the result")
    public void iValidateZipCodeExistsInTheResult(String zip) {
        assertThat(getDriver().findElement(By.xpath("//*[@id='zipByAddressDiv']")).isDisplayed());

    }
}
