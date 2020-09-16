package page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static support.TestContext.getDriver;

public class QuoteForm extends Quote{

    // fields

//    private String url;
//    private String title;

    @FindBy(xpath = "//input[@name='username']")
    private WebElement username;

    @FindBy(name = "email")
    private WebElement email;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(name = "confirmPassword")
    private WebElement confirmPassword;

    @FindBy(id = "name")
    private WebElement name;

    @FindBy(id = "firstName")
    private WebElement firstName;

    @FindBy(id = "middleName")
    private WebElement middleName;

    @FindBy(id = "lastName")
    private WebElement lastName;

    @FindBy(xpath = "//span[text()='Save']")
    private WebElement saveButton;

    @FindBy(name = "agreedToPrivacyPolicy")
    private WebElement privacy;

    @FindBy(id = "formSubmit")
    private WebElement submit;

    @FindBy(name="phone")
    private WebElement phone;

    @FindBy(xpath = "//option[contains(text(),'Russia')]")
    private  WebElement country;

    @FindBy(xpath = "//*[@value='female']")
    private  WebElement gender;

    @FindBy(name = "allowedToContact")
    private  WebElement allowedToContact;

    @FindBy(id = "address")
    private  WebElement address;

    @FindBy(id = "thirdPartyButton")
    private WebElement thirdPartyButton;

    @FindBy (id = "username-error")
    private WebElement usernameError;

    // dynamic field
    private WebElement errorElement(String fieldName) {
        return getDriver().findElement(By.id(fieldName + "-error"));
    }







    // constructor

//    public QuoteForm() {
//        PageFactory.initElements(getDriver(), this);
//        url = "https://skryabin.com/market/quote.html";
//        title = "Get a Quote";
//    }

    // methods

//    public void open() {
//        getDriver().get(url);
//    }

    public void fillUsername(String value) {
        username.sendKeys(value);
    }

    public void fillEmail(String value) {
        email.sendKeys(value);
    }

    public void fillBothPasswords(String value) {
        password.sendKeys(value);
        confirmPassword.sendKeys(value);
    }

    public void fillName(String firstNameValue, String lastNameValue) {
        name.click();
        firstName.sendKeys(firstNameValue);
        lastName.sendKeys(lastNameValue);
        saveButton.click();
    }

    public void fillName(String firstNameValue, String middleNameValue, String lastNameValue) {
        name.click();
        firstName.sendKeys(firstNameValue);
        middleName.sendKeys(middleNameValue);
        lastName.sendKeys(lastNameValue);
        saveButton.click();
    }

    public void agreeWithPrivacyPolicy() {
        if (!privacy.isSelected()) {
            privacy.click();
        }
    }

    public void submit() {
        submit.click();
    }

    public void fillPhone(String number){
        phone.sendKeys(number);
    }

    public void selectCountry(){
        country.click();
    }

    public void selectGender(){
        gender.click();
    }

    public void setAllowedToContact(){
        allowedToContact.click();
    }

    public void fillAddress(String value){
        address.sendKeys(value);
    }
    public void acceptThirdParty(){
        thirdPartyButton.click();
        getDriver().switchTo().alert().accept();
    }

    public void fillCertainField(String fieldName, String value){
        switch (fieldName){
            case "username":
                username.clear();
                username.sendKeys(value);
                break;

            case "email":
                email.clear();
                email.sendKeys(value);
                break;

            case "password":
                password.clear();
                password.sendKeys(value);
                break;

            case "confirmPassword":
                confirmPassword.clear();
                confirmPassword.sendKeys(value);
                break;
            default:
                throw new RuntimeException("Unrecognized field: " + fieldName);
        }

    }

    public String fieldValue(){
        return name.getAttribute("value");
    }

    public String getErrorFieldText(String fieldName) {
        return errorElement(fieldName).getText();
    }


    public boolean isErrorFieldDisplayed(String fieldName) {
        boolean isDisplayed;
        try {
            isDisplayed = errorElement(fieldName).isDisplayed();
        } catch (NoSuchElementException e) {
            isDisplayed = false;
        }
        return isDisplayed;
    }

    public String getUsernameErrorText() {
        return usernameError.getText();
    }






}
