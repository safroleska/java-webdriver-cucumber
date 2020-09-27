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

    public void iLogin(String role){
        Map<String,String> data = getData(role);
        username.sendKeys(data.get("email"));
        password.sendKeys(data.get("password"));
    }
    public void iClickSubmit(){
        loginButton.click();
    }


}
