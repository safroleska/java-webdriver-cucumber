package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import page.*;
import support.RestClient;


import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.*;


public class CareersStepDefs {

    CareersHome home = new CareersHome();
    CareersLogin login = new CareersLogin();
    CareersHeader careersHeader = new CareersHeader();
    CareersRecruit recruit = new CareersRecruit();

    @And("I login as {string}")
    public void iLoginAs(String role) {
        home.clickLoginButton();
        login.iLogin(role);
        login.iClickSubmit();

//        Map<String,String> data= getData(role);
//        new CareersHome().clickLoginButton();
//        new CareersLogin().iLogin(data.get("email"), data.get("password"));
    }

    @Then("I verify {string} login")
    public void iVerifyLogin(String arg) {
        careersHeader.verifyLoginAsRecruiter();
    }

    @When("I remove {string} position")
    public void iRemovePosition(String position){
        new CareersHeader()
                .clickRecruit()
                .removePosition(position);
//        careersHeader.iClickRecruit();
//        recruit.iRemovePosition(position);
    }

    @And("I verify {string} position is removed")
    public void iVerifyPositionIsRemoved(String title){
        new CareersRecruit().refresh();
//        recruit.waitUntilVisibilityOf();
//        assertThat(recruit.verifyPositionList()).doesNotContain(position);
        boolean isVisible = new CareersRecruit().isPositionVisible(title);
        boolean errorsPresent = new CareersRecruit().areErrorsPresent();
        assertThat(errorsPresent).isFalse();
        assertThat(isVisible).isFalse();
    }

    @And("I provide only password when login as {string}")
    public void iProvideOnlyPasswordWhenLoginAs(String role) {
        new CareersHome().clickLoginButton()
                .providePassword(getData(role));
    }

    @Then("I verify {string} is displayed")
    public void iVerifyIsDisplayed(String error) {
        assertThat(new CareersLogin().verifyErrorUsernameText()).isEqualTo(error);
    }

    @When("I create new position")
    public void iCreateNewPosition(){
        new CareersHeader().clickRecruit().clickCreateNewPosition().fillNewPositionFieldsFor();
    }

    @Then("I verify new position is created")
    public void iVerifyNewPositionIsCreated() {
//        Map<String, String> position = getData("automation");
//        Object[] actualPositions = new CareersRecruit().listOfCreatedPositions();
//        Object expectedPositionTitle = position.get("title");
//
//
//        boolean isFound = false;
//        for (Object actualPosition : actualPositions) {
//            if(actualPosition.equals(expectedPositionTitle)){
//                isFound = true;
//                break;
//            }
//        }
//        assertThat(isFound).isTrue();
    }

    @When("I remove new position")
    public void iRemoveNewPosition() {
        Map<String, String> position = getData("automation");
        new CareersRecruit().removePosition(position.get("title"));
    }

    @And("I verify new position is removed")
    public void iVerifyNewPositionIsRemoved() {
        new CareersRecruit().refresh();
        boolean isVisible = new CareersRecruit().isPositionVisible(getData("automation").get("title"));
        assertThat(isVisible).isFalse();

    }
}
