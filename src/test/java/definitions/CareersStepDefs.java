package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import page.Careers;
import page.CareersHome;
import page.CareersLogin;
import page.CareersRecruit;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class CareersStepDefs {

    CareersHome home = new CareersHome();
    CareersLogin login = new CareersLogin();
    Careers careers = new Careers();
    CareersRecruit recruit = new CareersRecruit();

    @And("I login as {string}")
    public void iLoginAs(String role) {
        home.clickLoginButton();
        login.iLogin(role);
        login.iClickSubmit();
    }

    @Then("I verify {string} login")
    public void iVerifyLogin(String arg) {
        careers.verifyLoginAsRecruiter();
    }

    @When("I remove {string} position")
    public void iRemovePosition(String position){
        careers.iClickRecruit();
        recruit.iRemovePosition(position);
    }

    @And("I verify {string} position is removed")
    public void iVerifyPositionIsRemoved(String position){
        getDriver().navigate().refresh();
        recruit.waitUntilVisibilityOf();
        assertThat(recruit.verifyPositionList()).doesNotContain(position);
    }
}
