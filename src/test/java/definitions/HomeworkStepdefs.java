package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;


public class HomeworkStepdefs {
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

}
