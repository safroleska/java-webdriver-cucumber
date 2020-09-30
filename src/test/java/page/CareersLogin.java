package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

import static support.TestContext.getData;

public class CareersLogin extends CareersHome{

    @FindBy(xpath = "//input[@placeholder='Please enter an Email']")
    private WebElement username;

    @FindBy(xpath = "//input[@placeholder='Please enter a Password']")
    private WebElement password;

    @FindBy(id = "loginButton")
    private WebElement loginButton;

    @FindBy(xpath = "//*[contains(@class,'alert')]")
    private WebElement errorUsername;

    public CareersRecruit iLogin(String role){
        Map<String,String> data = getData(role);
        username.sendKeys(data.get("email"));
        password.sendKeys(data.get("password"));
        return new CareersRecruit();
    }

    public CareersHome iLogin(String usernameValue, String passwordValue) {
        sendKeys(username, usernameValue);
        sendKeys(password, passwordValue);
        click(loginButton);
        return new CareersHome();
    }

//    public void iLogin(Map<String, String> user) {
//        sendKeys(username, user.get("email"));
//        sendKeys(password, user.get("password"));
//    }
    public void iClickSubmit(){
        loginButton.click();
    }

    public CareersRecruit providePassword(Map<String,String> user){
        sendKeys(password, user.get("password"));
        click(loginButton);
        return new CareersRecruit();
    }

    public String verifyErrorUsernameText(){
        return errorUsername.getText();
    }


}
