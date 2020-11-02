package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import support.TestContext;

import java.util.Map;

import static support.TestContext.getDriver;
import static support.TestContext.getWait;

public class CareersProfile extends CareersHeader {

    @FindBy(xpath ="//button[text()='Delete Account']")
    private WebElement deleteAccountButton;

    @FindBy(xpath ="//button[text()='Edit']")
    private WebElement editButton;

    @FindBy(xpath ="//input[@placeholder='Enter First Name']")
    private WebElement firstNameEdit;

    @FindBy(xpath ="//input[@placeholder='Enter Last Name']")
    private WebElement lastNameEdit;

    @FindBy(xpath ="//input[@placeholder='Enter Email']")
    private WebElement emailEdit;

    @FindBy(xpath ="//input[@placeholder='Enter Password']")
    private WebElement passwordEdit;

    @FindBy(xpath ="//input[@placeholder='Confirm Password']")
    private WebElement confirmPasswordEdit;

    @FindBy(xpath ="//textarea[@placeholder='Enter detailed Summary']")
    private WebElement summaryEdit;

    @FindBy(xpath ="//*[@for='candidateAddress']/..//input")
    private WebElement addressEdit;

    @FindBy(xpath ="//*[@for='candidateAddress']/..//*[@type='text']")
    private WebElement addressText;

    @FindBy(xpath ="//input[@placeholder='City']")
    private WebElement cityEdit;

    @FindBy(xpath ="//*[@for='candidateCity']/..//*[@type='text']")
    private WebElement cityText;

    private WebElement stateEdit(String stateName) {
        return getDriver().findElement(By.xpath("//option[contains(text(),'"+stateName+"')]"));
    }

    @FindBy(xpath ="//input[@placeholder='Zip code. Zip plus']")
    private WebElement zipEdit;

    @FindBy(xpath ="//button[@id='candidateSubmit']")
    private WebElement submitEditButton;

    @FindBy(xpath ="//div[contains(@class,'card-body')]")
    private WebElement profileDetails;


    public CareersHome clickDeleteAccount(){
        deleteAccountButton.click();
        return new CareersHome();
    }

    public CareersProfile editCandidateProfile(){
        click(editButton);
        Map<String,String > candidate = TestContext.getCandidate("qa_updated");
        addressEdit.clear();
        addressEdit.sendKeys(candidate.get("address"));
        cityEdit.clear();
        cityEdit.sendKeys(candidate.get("city"));
        submitEditButton.click();
        return new CareersProfile();
    }

    public String  updatedInfo(){
        getWait().until(driver->!cityText.getText().isEmpty());
         String updatetInfo = cityText.getText()+addressText.getText();
        return updatetInfo;
    }

}
