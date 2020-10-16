package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CareersProfile extends CareersHeader {

    @FindBy(xpath ="//button[text()='Delete Account']")
    private WebElement deleteAccountButton;

    public CareersHome clickDeleteAccount(){
        deleteAccountButton.click();
        return new CareersHome();
    }
}
