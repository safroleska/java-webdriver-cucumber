package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static support.TestContext.getDriver;
import static support.TestContext.getWait;

public class CareersHome extends Page{
    public CareersHome() {
        url = "https://skryabin-careers.herokuapp.com/";
    }

    @FindBy(xpath = "//*[contains(@href,'login')]")
    private WebElement login;

    @FindBy(xpath = "//*[contains(@href,'/new_candidate')]")
    private WebElement apply;

    private WebElement positionCard(String title) {
        return getDriver().findElement(By.xpath("//*[@class='position-name'][contains(text(),'"+title+"')]"));
    }

    public CareersLogin clickLoginButton(){

        login.click();
        return new CareersLogin();
    }

    public CareersCandidateApply clickApply(){
        apply.click();
        return new CareersCandidateApply();
    }

    public boolean loginButtonIsDisplayed(){
        return login.isDisplayed();
    }


}
