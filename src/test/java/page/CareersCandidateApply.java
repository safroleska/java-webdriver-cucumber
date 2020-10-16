package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import support.TestContext;

import java.util.Map;

import static support.TestContext.getCandidate;
import static support.TestContext.getDriver;

public class CareersCandidateApply extends CareersHeader {

    @FindBy(xpath ="//input[@placeholder='Enter First Name']")
    private WebElement firstName;

    @FindBy(xpath ="//input[@placeholder='Enter Last Name']")
    private WebElement lastName;

    @FindBy(xpath ="//input[@placeholder='Enter Email']")
    private WebElement email;

    @FindBy(xpath ="//input[@placeholder='Enter Password']")
    private WebElement password;

    @FindBy(xpath ="//input[@placeholder='Confirm Password']")
    private WebElement confirmPassword;

    @FindBy(xpath ="//textarea[@placeholder='Enter detailed Summary']")
    private WebElement summary;

    @FindBy(xpath ="//*[@for='candidateAddress']/..//input")
    private WebElement address;

    @FindBy(xpath ="//input[@placeholder='City']")
    private WebElement city;

    private WebElement state(String stateName) {
        return getDriver().findElement(By.xpath("//option[contains(text(),'"+stateName+"')]"));
    }

    @FindBy(xpath ="//input[@placeholder='Zip code. Zip plus']")
    private WebElement zip;

    @FindBy(xpath ="//button[@id='candidateSubmit']")
    private WebElement submitButton;

    public CareersCandidateApply fillApplyForm(){
        Map<String,String > candidate = TestContext.getCandidate("qa");
        firstName.sendKeys(candidate.get("firstName"));
        lastName.sendKeys(candidate.get("lastName"));
        email.sendKeys(candidate.get("email"));
        password.sendKeys(candidate.get("password"));
        confirmPassword.sendKeys(candidate.get("password"));
        summary.sendKeys(candidate.get("password"));
        address.sendKeys(candidate.get("address"));
        city.sendKeys(candidate.get("city"));
        state(candidate.get("state")).click();
        zip.sendKeys(candidate.get("zip"));
        return new CareersCandidateApply();
    }

    public void clickSubmit(){
        submitButton.click();
    }
}
