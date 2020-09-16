package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import page.QuoteForm;
import page.QuoteResult;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getData;
import static support.TestContext.getDriver;

public class QuoteStepDefs {

    QuoteForm form = new QuoteForm();
    QuoteResult result = new QuoteResult();

    @Given("I open {string} page")
    public void iOpenPage(String page) throws InterruptedException {
        switch (page) {
            case "quote":
                form.open();
                break;
            default:
                throw new RuntimeException("Unknown page: " + page);
        }
    }

    @When("I fill out required fields for {string} oop")
    public void iFillOutRequiredFieldsForOop(String role) {
        Map<String, String> user = getData(role);
        form.fillUsername(user.get("username"));
        form.fillEmail(user.get("email"));
        form.fillBothPasswords(user.get("password"));
        form.fillName(user.get("firstName"), user.get("lastName"));
        form.agreeWithPrivacyPolicy();
    }

    @And("I submit the form oop")
    public void iSubmitTheFormOop() {
        form.submit();
    }

    @Then("I verify required fields for {string} oop")
    public void iVerifyRequiredFieldsForOop(String role) {
        Map<String, String> user = getData(role);
        assertThat(result.requiredFieldsValue()).containsIgnoringCase(user.get("username"));
        assertThat(result.requiredFieldsValue()).containsIgnoringCase(user.get("email"));
        assertThat(result.requiredFieldsValue()).doesNotContain(user.get("password"));
        assertThat(result.requiredFieldsValue()).containsIgnoringCase(user.get("firstName"));
        assertThat(result.requiredFieldsValue()).containsIgnoringCase(user.get("lastName"));
    }

    @When("I fill out optional fields for {string} oop")
    public void iFillOutOptionalFieldsForOop(String role) {
        Map<String, String> user = getData(role);
        form.fillPhone(user.get("phone"));
        form.selectCountry();
        form.selectGender();
        form.setAllowedToContact();
        form.fillAddress(user.get("address"));
        form.acceptThirdParty();

    }

    @Then("I verify optional fields for {string} oop")
    public void iVerifyOptionalFieldsForOop(String role) {
        Map<String, String> user = getData(role);
        assertThat(result.requiredFieldsValue()).containsIgnoringCase(user.get("phone"));
        assertThat(result.requiredFieldsValue()).containsIgnoringCase(user.get("country"));
        assertThat(result.requiredFieldsValue()).containsIgnoringCase(user.get("gender"));
        assertThat(result.requiredFieldsValue()).containsIgnoringCase(user.get("address"));
        assertThat(result.requiredFieldsValue()).containsIgnoringCase("accepted");

    }

//    @When("I fill out {string} field with {string}")
//    public void iFillOutFieldWith(String arg0, String value) {
//        form.fillUsername(value);
//    }

    @When("I fill out name field with first name {string} and last name {string}")
    public void iFillOutNameFieldWithFirstNameAndLastName(String value1, String value2) {
        form.fillName(value1,value2);
    }

//    @When("I fill out name field with first name {string}, middle name {string}, last name {string}")
//    public void iFillOutNameFieldWithFirstNameMiddleNameLastName(String firstN, String middleN, String lastN) {
//        form.middleName.sendKeys(middleN);
//        form.fillName(firstN,lastN);
//
//    }

    @Then("I verify {string} field value {string}")
    public void iVerifyFieldValue(String arg0, String nameValue) {
        assertThat(form.fieldValue()).isEqualTo(nameValue);

    }

    @Then("I see {string} error message {string}")
    public void iSeeErrorMessage(String fieldName, String error) {
        assertThat(form.getErrorFieldText(fieldName)).contains(error);

        //        switch (errorField) {
//            case "username":
//                assertThat(form.getUsernameErrorText()).isEqualTo(errorMessage);
//                break;
//            case "email":
//                assertThat(form.getEmailErrorText()).isEqualTo(errorMessage);
//                break;
//            default:
//                throw new RuntimeException("Unrecognized field: " + errorField);
//        }
    }

    @When("I fill out name field with first name {string}, middle name {string}, last name {string}")
    public void iFillOutNameFieldWithFirstNameMiddleNameLastName(String firstName, String middleName, String lastName) {
        form.fillName(firstName, middleName, lastName);
    }

    @When("I fill out {string} field with {string}")
    public void iFillOutFieldWith(String nameField, String value) {
        form.fillCertainField(nameField,value);
    }

    @Then("I don't see {string} error message")
    public void iDonTSeeErrorMessage(String errorField) {
        assertThat(form.isErrorFieldDisplayed(errorField)).isFalse();

    }
}