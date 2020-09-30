package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static support.TestContext.getWait;

public class CareersHome extends Page{
    public CareersHome() {
        url = "https://skryabin-careers.herokuapp.com/";
    }

    @FindBy(xpath = "//*[contains(@href,'login')]")
    private WebElement login;

    public CareersLogin clickLoginButton(){

        login.click();
        return new CareersLogin();
    }


}
