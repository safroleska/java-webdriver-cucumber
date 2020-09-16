package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import page.UpsShipment;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getData;
import static support.TestContext.getWait;

public class UpsStepDefs {

    UpsShipment shipment = new UpsShipment();

    @Given("I follow to {string} page")
    public void iFollowToPage(String url) {
        shipment.open();

    }

    @And("I open Shipping menu")
    public void iOpenShippingMenu() {
        shipment.openShipping();
    }

    @And("I go to Create a Shipment")
    public void iGoToCreateAShipment() {
        shipment.createShipment();
    }

    @When("I fill out origin shipment fields")
    public void iFillOutOriginShipmentFields() {
        shipment.fillOriginFields();
    }

    @And("I submit the shipment form")
    public void iSubmitTheShipmentForm() {
        shipment.clickSubmitButton();
    }

    @Then("I verify origin shipment fields submitted")
    public void iVerifyOriginShipmentFieldsSubmitted() {
        Map<String,String> ups = getData("ups");
        assertThat(shipment.getShipFormResult()).contains(ups.get("name"));
        assertThat(shipment.getShipFormResult()).contains(ups.get("address"));
        assertThat(shipment.getShipFormResult()).contains(ups.get("zip"));
        assertThat(shipment.getShipFormResult()).contains(ups.get("phone"));
        assertThat(shipment.getShipFormResult()).contains(ups.get("email"));
    }

    @And("I cancel the shipment form")
    public void iCancelTheShipmentForm() {
        shipment.cancelShipment();

    }

    @Then("I verify shipment form is reset")
    public void iVerifyShipmentFormIsReset() {
        assertThat(shipment.nameFieldResult()).isEmpty();
        assertThat(shipment.addressFieldResult()).isEmpty();
        assertThat(shipment.zipFieldResult()).isEmpty();
        assertThat(shipment.emailFieldResult()).isEmpty();
        assertThat(shipment.phoneFieldResult()).isEmpty();

    }
}
