package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static support.TestContext.getDriver;

public class Careers extends CareersHome{

    @FindBy(xpath = "//*[contains(@href,'recruit')]")
    private WebElement recruitButton;


    public void verifyLoginAsRecruiter(){
        recruitButton.isDisplayed();
    }

    public void iClickRecruit(){
        recruitButton.click();
    }
}
