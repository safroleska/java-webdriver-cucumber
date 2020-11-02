package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import page.*;
import support.Loggable;
import support.RestClient;
import support.TestContext;


import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.*;


public class CareersStepDefs implements Loggable {

    CareersHome home = new CareersHome();
    CareersLogin login = new CareersLogin();
    CareersHeader header = new CareersHeader();
    CareersRecruit recruit = new CareersRecruit();
    CareersProfile profile = new CareersProfile();
    CareersCareers careers = new CareersCareers();

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
    public void iVerifyLogin(String role) {
        String expectedName = getData(role).get("name");
        String actualName = header.getLoggedUserName();
        assertThat(actualName).isEqualTo(expectedName);
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
        home
                .clickLoginButton()
                .providePassword(getData(role));
    }

    @Then("I verify {string} is displayed")
    public void iVerifyIsDisplayed(String error) {
        assertThat(login.verifyErrorUsernameText()).isEqualTo(error);
    }

    @When("I create new position")
    public void iCreateNewPosition(){
        header
                .clickRecruit()
                .clickCreateNewPosition()
                .fillNewPositionFieldsFor();
    }

    @Then("I verify new position is created")
    public void iVerifyNewPositionIsCreated() {
        Map<String, String> position = getData("automation");
        assertThat(recruit.listOfCreatedPositions(position.get("title")).contains(position.get("title")));

    }

    @When("I remove new position")
    public void iRemoveNewPosition() {
        Map<String, String> position = getData("automation");
        recruit.removePosition(position.get("title"));
    }

    @And("I verify new position is removed")
    public void iVerifyNewPositionIsRemoved() {
        recruit.refresh();
        boolean isVisible = recruit.isPositionVisible(getData("automation").get("title"));
        assertThat(isVisible).isFalse();

    }

    @When("I update new position")
    public void iUpdateNewPosition() {
        Map<String, String> position = getData("automation");
        header.chosePosition(position.get("title"))
                .clickEdit()
                .editPosition()
                .clickApply();

    }

    @Then("I verify new position is updated")
    public void iVerifyNewPositionIsUpdated() {
        Map<String, String> position = getData("automation");
        Map<String, String> update = getData("automation_updated");
        assertThat(new CareersMyJobs().positionInfo(position.get("title")))
                .contains(update.get("city"))
                .contains(update.get("address"));
    }

    @And("I submit application to a new position")
    public void iSubmitApplicationToANewPosition() {
        Map<String, String> position = getData("automation");
        home
                .clickApply()
                .fillApplyForm()
                .clickSubmit();
    }

    @Then("I verify new candidate is created")
    public void iVerifyNewCandidateIsCreated() {
        Map<String,String > candidate = TestContext.getCandidate("qa");
        String expectedNameCandidate = candidate.get("firstName")+" "+candidate.get("lastName");
        assertThat(header.nameCandidate()).isEqualTo(expectedNameCandidate);
    }

    @When("I delete candidate profile")
    public void iDeleteCandidateProfile() {
        header
                .clickCandidate()
                .clickDeleteAccount();
    }

    @Then("I verify new candidate is removed")
    public void iVerifyNewCandidateIsRemoved() {
        assertThat(home.loginButtonIsDisplayed()).isTrue();
    }

    @When("I update new candidate")
    public void iUpdateNewCandidate() {
        header
                .clickCandidate()
                .editCandidateProfile();
    }

    @Then("I verify new candidate is updated")
    public void iVerifyNewCandidateIsUpdated() {
        Map<String,String > candidateUpdate = TestContext.getCandidate("qa_updated");
        String addressExpected = candidateUpdate.get("address");
        String cityExpected = candidateUpdate.get("city");
        assertThat(profile.updatedInfo()).isEqualTo(cityExpected+addressExpected);
        header.clickCandidate();
    }

    @When("I apply for a new position")
    public void iApplyForANewPosition() {
        careers
                .choosePosition("Automation Engineer")
                .clickApply();
    }

    @Then("I see new position marked as applied")
    public void iSeeNewPositionMarkedAsApplied() {
        header.clickCareersButton();
    }

    @And("I see new position in my jobs")
    public void iSeeNewPositionInMyJobs() {
        header.clickMyJobButton();
    }
}
