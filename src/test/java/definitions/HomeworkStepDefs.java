package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.*;


public class HomeworkStepDefs {
    @When("I click on {string}")
    public void iClickOn(String tab) {
        getDriver().findElement(By.xpath("//div[@id='menu']//a[contains(text(),'"+tab+"')]")).click();
    }

    @And("I set {string} to {string}")
    public void iSetTo(String unit1, String unit2) {
        getDriver().findElement(By.xpath("//*[@id='calFrom']//option[text()='"+unit1+"']")).click();
        getDriver().findElement(By.xpath("//*[@id='calTo']//option[text()='"+unit2+"']")).click();

    }

    @Then("I enter into From field {string} and verify {string} result")
    public void iEnterIntoFromFieldAndVerifyResult(String num1, String num2) {
        getDriver().findElement(By.xpath("//input[@name='fromVal']")).sendKeys(num1);
        WebElement result = getDriver().findElement(By.xpath("//input[@name='toVal']"));

//        assertThat(result.getAttribute("value").substring(0,4)).isEqualTo(num2);
        assertThat(result.getAttribute("value")).contains(num2);

    }

    @When("I navigate to {string}")
    public void iNavigateTo(String autoLoan) {
        getDriver().findElement(By.xpath("//a[text()='"+autoLoan+"']")).click();
    }

    @And("I clear all calculator fields")
    public void iClearAllCalculatorFields() {
        getDriver().findElement(By.xpath("//input[@id='cloanamount']")).clear();
        getDriver().findElement(By.xpath("//input[@id='cloanterm']")).clear();
        getDriver().findElement(By.xpath("//input[@id='cinterestrate']")).clear();
        getDriver().findElement(By.xpath("//input[@id='cdownpayment']")).clear();
        getDriver().findElement(By.xpath("//input[@id='ctradeinvalue']")).clear();
        getDriver().findElement(By.xpath("//input[@id='csaletax']")).clear();
        getDriver().findElement(By.xpath("//input[@id='ctitlereg']")).clear();

    }

    @And("I calculate")
    public void iCalculate() {
        getDriver().findElement(By.xpath("//*[@value='Calculate']")).click();
    }

    @Then("I verify {string} calculator error")
    public void iVerifyCalculatorError(String error) {
        assertThat(getDriver().findElement(By.xpath("//div[@id='content']")).getText()).contains(error);
    }

    @And("I enter {string} price, {string} months, {string} interest, {string} downpayment, {string} trade-in, {string} state, {string} percent tax, {string} fees")
    public void iEnterPriceMonthsInterestDownpaymentTradeInStatePercentTaxFees(String price, String month, String interest, String downpayment, String tradeIn, String state, String tax, String fees) {
        getDriver().findElement(By.xpath("//input[@id='cloanamount']")).sendKeys(price);
        getDriver().findElement(By.xpath("//input[@id='cloanterm']")).sendKeys(month);
        getDriver().findElement(By.xpath("//input[@id='cinterestrate']")).sendKeys(interest);
        getDriver().findElement(By.xpath("//input[@id='cdownpayment']")).sendKeys(downpayment);
        getDriver().findElement(By.xpath("//input[@id='ctradeinvalue']")).sendKeys(tradeIn);
        getDriver().findElement(By.xpath("//input[@id='csaletax']")).sendKeys(tax);
        getDriver().findElement(By.xpath("//input[@id='ctitlereg']")).sendKeys(fees);
    }

    @Then("I verify monthly pay is {string}")
    public void iVerifyMonthlyPayIs(String result) {
        assertThat(getDriver().findElement(By.xpath("//h2[@class='h2result']")).getText()).contains(result);

    }

//    @And("I open Shipping menu")
//    public void iOpenShippingMenu() {
//        getDriver().findElement(By.xpath("//a[@id='ups-menuLinks2']")).click();
//    }

//    @And("I go to Create a Shipment")
//    public void iGoToCreateAShipment() {
//        getDriver().findElement(By.xpath("//a[contains(text(),'Create a Shipment:')]")).click();
//    }

//    @When("I fill out origin shipment fields")
//    public void iFillOutOriginShipmentFields() {
//        getWait().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='ups-app_inner']")));
//        Map<String,String> ups = getData("ups");
//        getDriver().findElement(By.xpath("//input[@id='originname']")).sendKeys(ups.get("name"));
//        getDriver().findElement(By.xpath("//*[@placeholder='Street Address']")).sendKeys(ups.get("address"));
//        getDriver().findElement(By.xpath("//input[@id='originpostal']")).sendKeys(ups.get("zip"));
//        getWait().until(ExpectedConditions.textToBePresentInElementValue(By.xpath("//input[@id='origincity']"),"LOS ALTOS" ));
//        getWait().until(ExpectedConditions.elementToBeSelected(By.xpath("//option[contains(text(),'California')]")));
//        getDriver().findElement(By.xpath("//input[@id='originemail']")).sendKeys(ups.get("email"));
//        getDriver().findElement(By.xpath("//input[@id='originphone']")).sendKeys(ups.get("phone"));
//
//    }

//    @And("I submit the shipment form")
//    public void iSubmitTheShipmentForm() {
//        getExecutor().executeScript("arguments[0].click()",getDriver().findElement(By.xpath("//button[@id='nbsBackForwardNavigationContinueButton']")));
//        //button[@id='nbsBackForwardNavigationReviewPrimaryButton']
//    }

//    @Then("I verify origin shipment fields submitted")
//    public void iVerifyOriginShipmentFieldsSubmitted() {
//        String result = getDriver().findElement(By.xpath("//div[@class='ups-group ups-group_condensed']")).getText();
//        Map<String, String> ups= getData("ups");
//        assertThat(result).containsIgnoringCase(ups.get("name"));
//        assertThat(result).containsIgnoringCase(ups.get("address"));
//        assertThat(result).containsIgnoringCase(ups.get("zip"));
//        assertThat(result).containsIgnoringCase(ups.get("email"));
//        assertThat(result).containsIgnoringCase(ups.get("phone"));
//    }

//    @And("I cancel the shipment form")
//    public void iCancelTheShipmentForm() {
//        String originalWindow = getDriver().getWindowHandle();
//        getExecutor().executeScript("arguments[0].click()",getDriver().findElement(By.xpath("//button[@id='nbsBackForwardNavigationCancelShipmentButton']")));
//
//        for (String handle : getDriver().getWindowHandles()) {
//            getDriver().switchTo().window(handle);
//        }
//        getDriver().findElement(By.xpath("//button[@id='nbsCancelShipmentWarningYes']")).click();
//
//        getDriver().switchTo().window(originalWindow);
//
//    }

//    @Then("I verify shipment form is reset")
//    public void iVerifyShipmentFormIsReset() {
//        Map<String,String> ups = getData("ups");
//        assertThat(getDriver().findElement(By.xpath("//input[@id='originname']")).getText()).doesNotContain(ups.get("name"));
//        assertThat(getDriver().findElement(By.xpath("//*[@placeholder='Street Address']")).getText()).doesNotContain(ups.get("address"));
//        assertThat(getDriver().findElement(By.xpath("//input[@id='originpostal']")).getText()).doesNotContain(ups.get("zip"));
//        assertThat(getDriver().findElement(By.xpath("//input[@id='originemail']")).getText()).doesNotContain(ups.get("email"));
//        assertThat(getDriver().findElement(By.xpath("//input[@id='originphone']")).getText()).doesNotContain(ups.get("phone"));
//    }

    @When("I fill out destination shipment fields")
    public void iFillOutDestinationShipmentFields() {
        Map<String,String> ups = getData("ups");
        getDriver().findElement(By.xpath("//input[@id='destinationname']")).sendKeys(ups.get("destName"));
        getDriver().findElement(By.xpath("//*[@placeholder='Street Address']")).sendKeys(ups.get("destAddress"));
        getDriver().findElement(By.xpath("//input[@id='destinationpostal']")).sendKeys(ups.get("destZip"));
        getWait().until(ExpectedConditions.textToBePresentInElementValue(By.xpath("//input[@id='destinationcity']"),"NEW YORK" ));
        getWait().until(ExpectedConditions.elementToBeSelected(By.xpath("//option[contains(text(),'New York')]")));
    }

    @And("I set packaging type and weight")
    public void iSetPackagingTypeAndWeight() {
        getDriver().findElement(By.xpath("//option[contains(text(),'UPS Express Box - Small')]")).click();
        getDriver().findElement(By.xpath("//input[@id='nbsPackagePackageWeightField0']")).sendKeys("1");
    }

    @Then("I verify total charges appear")
    public void iVerifyTotalChargesAppear() {
        assertThat(getDriver().findElement(By.xpath("//span[@id='nbsBalanceBarTotalCharges']")).isDisplayed());
    }

    @And("I select cheapest delivery option")
    public void iSelectCheapestDeliveryOption() {
        getExecutor().executeScript("arguments[0].click()",getDriver().findElement(By.xpath("//input[@id='nbsServiceTileServiceRadio7']")));
    }

    @And("I set description and check Saturday Delivery type")
    public void iSetDescriptionAndCheckSaturdayDeliveryType() throws InterruptedException {
        getDriver().findElement(By.xpath("//input[@id='nbsShipmentDescription']")).sendKeys("Book");
        getExecutor().executeScript("arguments[0].click()",getDriver().findElement(By.xpath("//input[@id='nbsSaturdayDeliveryOptionBaseOptionSwitch']")));

    }

    @Then("I verify total charges changed")
    public void iVerifyTotalChargesChanged() throws InterruptedException {
        String totalCharges = getDriver().findElement(By.xpath("//span[@id='total-charges-spinner']")).getText();
        getExecutor().executeScript("arguments[0].click()",getDriver().findElement(By.xpath("//input[@id='nbsSaturdayDeliveryOptionBaseOptionSwitch']")));
        Thread.sleep(4000);
        assertThat(totalCharges).isNotEqualTo(getDriver().findElement(By.xpath("//span[@id='total-charges-spinner']")).getText());
        getExecutor().executeScript("arguments[0].click()",getDriver().findElement(By.xpath("//input[@id='nbsSaturdayDeliveryOptionBaseOptionSwitch']")));

    }

    @And("I select Paypal payment type")
    public void iSelectPaypalPaymentType() {
        getWait(10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//fieldset[@id='nbsTransportationPaymentControl']")));
        getDriver().findElement(By.xpath("//span[contains(text(),'Other Ways to Pay')]")).click();
    }

    @Then("I review all recorded details on the review page")
    public void iReviewAllRecordedDetailsOnTheReviewPage() {
        getWait().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//origin[@id='nbsSpaOrigin']//section[@class='ups-section']")));
        Map<String,String> ups = getData("ups");
        String shipFrom = getDriver().findElement(By.xpath("//origin[@id='nbsSpaOrigin']//section[@class='ups-section']")).getText();
        String shipTo = getDriver().findElement(By.xpath("//destination[@id='nbsSpaDestination']//section[@class='ups-section']")).getText();
        String packInfo = getDriver().findElement(By.xpath("//package-drawer//div[@class='ups-drawer-content']")).getText();
        assertThat(shipFrom).contains(ups.get("name"));
        assertThat(shipFrom).contains(ups.get("address"));
        assertThat(shipFrom).contains(ups.get("zip"));
        assertThat(shipFrom).contains(ups.get("email"));
        assertThat(shipFrom).contains(ups.get("phone"));
        assertThat(shipTo).contains(ups.get("destName"));
        assertThat(shipTo).contains(ups.get("destAddress"));
        assertThat(shipTo).contains(ups.get("destZip"));
        assertThat(packInfo).contains("UPS Express Box - Small");
        assertThat(packInfo).contains("1 lbs");


    }

    @And("I click Review button")
    public void iClickReviewButton() {
        getDriver().findElement(By.xpath("//button[@id='nbsBackForwardNavigationReviewPrimaryButton']")).click();

    }
}
