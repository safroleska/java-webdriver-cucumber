package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;


import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.*;

public class MarketStepDefs {
    @Given("I go to {string} page")
    public void iGoToPage(String page) throws InterruptedException {
//        switch (page){
//            case "quote": getDriver().get("https://skryabin.com/market/quote.html");
//            break;
//            case


//        default:
//            throw new RuntimeException("Unsupported page! "+page);
//        }


        if (page.equalsIgnoreCase("quote")) {
            getDriver().get("https://skryabin.com/market/quote.html");
        } else if(page.equalsIgnoreCase("google")) {
            getDriver().get("https://www.google.com/");
        } else if (page.equalsIgnoreCase("yahoo")) {
            getDriver().get("https://www.yahoo.com/");
        }else if (page.equalsIgnoreCase("usps")){
            getDriver().get("https://www.usps.com/");
        } else if (page.equalsIgnoreCase("converter")) {
            getDriver().get("https://www.unitconverters.net/");
        } else if (page.equalsIgnoreCase("calculator")) {
            getDriver().get("http://www.calculator.net/");
        } else if (page.equalsIgnoreCase("ups")) {
            getDriver().get("https://www.ups.com/us/en/Home.page");
        }else {
            throw new RuntimeException("Unsupported page! "+page);
        }

    }

    @And("I print page details")
    public void iPrintPageDetails() {
        System.out.println(getDriver().getTitle());
        System.out.println(getDriver().getCurrentUrl());
//        System.out.println(getDriver().getWindowHandle());
//        System.out.println(getDriver().getPageSource());
    }

    @And("I go back and forward, then refresh")
    public void iGoBackAndForwardThenRefresh() {
        getDriver().navigate().back();
        getDriver().navigate().forward();
        getDriver().navigate().refresh();
    }

    @When("I fill out required fields for {string}")
    public void iFillOutRequiredFields(String role) {
        Map<String,String> user = getData(role);

        getDriver().findElement(By.xpath("//*[@id='name']")).click();
        getDriver().findElement(By.xpath("//*[@id='firstName']")).sendKeys(user.get("firstName"));
        getDriver().findElement(By.xpath("//*[@id='lastName']")).sendKeys(user.get("lastName"));
        getDriver().findElement(By.xpath("//span[contains(text(),'Save')]")).click();
        getDriver().findElement(By.xpath("//input[@name='username']")).sendKeys(user.get("username"));
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys(user.get("email"));
        getDriver().findElement(By.xpath("//input[@id='password']")).sendKeys(user.get("password"));
        getDriver().findElement(By.xpath("//input[@id='confirmPassword']")).sendKeys(user.get("password"));
        getDriver().findElement(By.xpath("//*[@name='agreedToPrivacyPolicy']")).click();

    }

    @And("I submit the form")
    public void iSubmitTheForm() {
        getDriver().findElement(By.xpath("//*[@id='formSubmit']")).click();
    }

    @Then("I verify required fields for {string}")
    public void iVerifyRequiredFields(String role) {

        Map<String, String> user = getData(role);
        String result = getDriver().findElement(By.xpath("//div[@id='quotePageResult']")).getText();
        System.out.println(result);

        assertThat(result).containsIgnoringCase(user.get("username"));
        assertThat(result).containsIgnoringCase(user.get("email"));
        assertThat(result).doesNotContain(user.get("password"));
        assertThat(result).contains(user.get("firstName") + " " + user.get("lastName"));

        String privacyPolicy = getDriver().findElement(By.xpath("//b[@name='agreedToPrivacyPolicy']")).getText();
        assertThat(privacyPolicy).isEqualTo("true");


//        String name = getDriver().findElement(By.xpath("//b[@name='name']")).getText();
//        String userName = getDriver().findElement(By.xpath("//b[@name='username']")).getText();
//        String email = getDriver().findElement(By.xpath("//b[@name='email']")).getText();
//        System.out.println("Name is: "+name);
//        System.out.println("Username is: "+userName);
//        System.out.println("Email is: "+email);
    }

    @And("I verify email field behavior")
    public void iVerifyEmailFieldBehavior() {
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys("test");
        getDriver().findElement(By.xpath("//input[@name='username']")).click();
        getDriver().findElement(By.xpath("//label[@id='email-error']")).isDisplayed();
        getDriver().findElement(By.xpath("//input[@name='email']")).clear();
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys("test@mail.com");

        assertThat(getDriver().findElement(By.xpath("//label[@id='email-error']")).isDisplayed()).isFalse();

        getDriver().findElement(By.xpath("//*[@id='name']")).click();
        getDriver().findElement(By.xpath("//*[@id='firstName']")).sendKeys("Chandler");
        getDriver().findElement(By.xpath("//*[@id='lastName']")).sendKeys("Bing");
        getDriver().findElement(By.xpath("//span[contains(text(),'Save')]")).click();
        getDriver().findElement(By.xpath("//input[@name='username']")).sendKeys("test");
        getDriver().findElement(By.xpath("//input[@id='password']")).sendKeys("12345");
        getDriver().findElement(By.xpath("//input[@id='confirmPassword']")).sendKeys("12345");
        getDriver().findElement(By.xpath("//*[@name='agreedToPrivacyPolicy']")).click();

    }

    @When("I fill out optional fields")
    public void iFillOutOptionalFields() throws Exception {
        getDriver().findElement(By.xpath("//input[@name='phone']")).sendKeys("1112233");
        getDriver().findElement(By.xpath("//option[contains(text(),'Russia')]")).click();
        getDriver().findElement(By.xpath("//*[@value='female']")).click();
        getDriver().findElement(By.xpath("//*[@name='allowedToContact']")).click();
        getDriver().findElement(By.xpath("//*[@id='address']")).sendKeys("100 Main st");
        getDriver().findElement(By.xpath("//*[@id='dateOfBirth']")).click();
        getDriver().findElement(By.xpath("//*[@class='ui-datepicker-year']/*[@value='2000']")).click();
        getDriver().findElement(By.xpath("//option[contains(text(),'Jan')]")).click();
        getDriver().findElement(By.xpath("//*[@data-handler='selectDay']/*[text()='1']")).click();
        getDriver().findElement(By.xpath("//button[@id='thirdPartyButton']")).click();
        getDriver().switchTo().alert().accept();


    }

    @Then("I verify that fields values recorded correctly")
    public void iVerifyThatFieldsValuesRecordedCorrectly() {
        String result = getDriver().findElement(By.xpath("//*[@id='quotePageResult']")).getText();
        System.out.println(result);
//        assertThat(result).containsIgnoringCase("Chandler Bing");
//        assertThat(result).containsIgnoringCase("test");
//        assertThat(result).containsIgnoringCase("test@mail.com");
//        assertThat(result).doesNotContain("12345");





//        assertThat(getDriver().findElement(By.xpath("//*[@id='quotePageResult']")).isDisplayed());
//        assertThat(getDriver().findElement(By.xpath("//b[@name='firstName']")).getText()).isEqualTo("Chandler");
//        assertThat(getDriver().findElement(By.xpath("//b[@name='lastName']")).getText()).isEqualTo("Bing");
//        assertThat(getDriver().findElement(By.xpath("//b[@name='name']")).getText()).isEqualTo("Chandler Bing");
//        assertThat(getDriver().findElement(By.xpath("//b[@name='username']")).getText()).isEqualTo("test");
//        assertThat(getDriver().findElement(By.xpath("//b[@name='email']")).getText()).isEqualTo("test@mail.com");
//        assertThat(getDriver().findElement(By.xpath("//b[@name='password']")).getText()).isNotEqualTo("12345");

    }

    @And("I print logs to the console")
    public void iPrintLogsToTheConsole() {
       LogEntries logs =  getDriver().manage().logs().get(LogType.BROWSER);
        System.out.println("Logs begin>>>>");

        for (LogEntry log: logs){
            System.out.println(log);
        }

        System.out.println("Logs end>>>>");
    }

    @When("I {string} third party agreement")
    public void iThirdPartyAgreement(String action) {
        getDriver().findElement(By.xpath("//button[@id='thirdPartyButton']")).click();
        if (action.equals("accept")){
            getDriver().switchTo().alert().accept();
        }else if (action.equals("dismiss")){
            getDriver().switchTo().alert().dismiss();
        }else{
            throw new RuntimeException("incorrect action");
        }
    }
    @And("I fill out {string} name and {string} phone contact")
    public void iFillOutNameAndPhoneContact(String name, String phone) {

        // switch to iframe
        getDriver().switchTo().frame("additionalInfo");

        getDriver().findElement(By.xpath("//input[@id='contactPersonName']")).sendKeys(name);
        getDriver().findElement(By.xpath("//input[@id='contactPersonPhone']")).sendKeys(phone);

        // switch back to the parent page
        getDriver().switchTo().defaultContent();
    }

    @And("I verify document list contains {string}")
    public void iVerifyDocumentList(String expectedDoc) {

        String originalWindow = getDriver().getWindowHandle();

        getDriver().findElement(By.xpath("//button[contains(@onclick, 'new')]")).click();

        // switch to a new window
        for (String handle : getDriver().getWindowHandles()) {
            getDriver().switchTo().window(handle);
        }

        String allDocText = getDriver().findElement(By.xpath("//body")).getText();
        assertThat(allDocText).contains(expectedDoc);

        // switch back to original window
        getDriver().switchTo().window(originalWindow);
    }

//    @Then("I verify {string} field value {string}")
//    public void iVerifyFieldValue(String arg0, String arg1) {
//        assertThat(getDriver().findElement(By.xpath("//input[@id='name']")).getAttribute("value")).isEqualTo(arg1);
//    }
}
