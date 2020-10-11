package definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import support.RestClient;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.*;

public class RestStepDefs {

    @Given("I login via REST as {string}")
    public void iLoginViaRESTAs(String role) {
        new RestClient().login(getData(role));
    }

    @When("I create via REST {string} position")
    public void iCreateViaRESTPosition(String type) {
        new RestClient().createPosition(getPosition(type));
    }

    @Then("I verify via REST new {string} position is in the list")
    public void iVerifyViaRESTNewPositionIsInTheList(String type) {
        List<Map<String, Object>> actualPositions = new RestClient().getPositions();
        Object expectedPositionId = getTestDataMap("newPosition").get("id");
        Map<String, String> expectedPosition = getPosition(type);

        boolean isFound = false;
        for (Map<String, Object> actualPosition : actualPositions) {
            if (actualPosition.get("id").equals(expectedPositionId)) {
                isFound = true;

                for(String key : expectedPosition.keySet()) {
                    System.out.println("Verifying " + key);
                    assertThat(actualPosition.get(key)).isEqualTo(expectedPosition.get(key));
                }
                break;
            }
        }
        assertThat(isFound).isTrue();
    }

    @When("I update via REST {string} position")
    public void iUpdateViaRESTPosition(String type) {
        Map<String, String> updatedPosition = getPosition(type + "_updated");
        Object id = getTestDataMap("newPosition").get("id");
        new RestClient().updatePosition(updatedPosition, id);
    }

    @Then("I verify via REST new {string} position is updated")
    public void iVerifyViaRESTNewPositionIsUpdated(String type) {
        Object expectedPositionId = getTestDataMap("newPosition").get("id");
        Map<String, Object> actualPosition = new RestClient().getPosition(expectedPositionId);
        Map<String, String> expectedFields = getPosition(type + "_updated");

        for (String key : expectedFields.keySet()) {
            System.out.println("Verifying " + key);
            assertThat(actualPosition.get(key)).isEqualTo(expectedFields.get(key));
        }
    }

    @When("I delete via REST new position")
    public void iDeleteViaRESTNewPosition() {
        Object expectedPositionId = getTestDataMap("newPosition").get("id");
        new RestClient().deletePositionById(expectedPositionId);

    }

    @Then("I verity via REST new position is deleted")
    public void iVerityViaRESTNewPositionIsDeleted() {
        Object deletedId = getTestDataMap("newPosition").get("id");
        List<Map<String, Object>> actualPositions = new RestClient().getPositions();

        for (Map<String, Object> position : actualPositions) {
            assertThat(position.get("id")).isNotEqualTo(deletedId);
        }
    }
}