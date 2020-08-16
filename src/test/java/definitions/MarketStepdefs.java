package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;


import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.*;

public class MarketStepdefs {
    @Given("I go to {string} page")
    public void iGoToPage(String page) throws InterruptedException {
        if (page.equalsIgnoreCase("quote")) {
            getDriver().get("https://skryabin.com/market/quote.html");
        } else if(page.equalsIgnoreCase("google")) {
            getDriver().get("https://www.google.com/");
        } else if (page.equalsIgnoreCase("yahoo")){
            getDriver().get("https://www.yahoo.com/");
        } else {
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

    @When("I fill out required fields")
    public void iFillOutRequiredFields() {
        getDriver().findElement(By.xpath("//*[@id='name']")).click();
        getDriver().findElement(By.xpath("//*[@id='firstName']")).sendKeys("Chandler");
        getDriver().findElement(By.xpath("//*[@id='lastName']")).sendKeys("Bing");
        getDriver().findElement(By.xpath("//span[contains(text(),'Save')]")).click();
        getDriver().findElement(By.xpath("//input[@name='username']")).sendKeys("test");
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys("test@mail.com");
        getDriver().findElement(By.xpath("//input[@id='password']")).sendKeys("12345");
        getDriver().findElement(By.xpath("//input[@id='confirmPassword']")).sendKeys("12345");
        getDriver().findElement(By.xpath("//*[@name='agreedToPrivacyPolicy']")).click();

    }

    @And("I submit the form")
    public void iSubmitTheForm() {
        getDriver().findElement(By.xpath("//*[@id='formSubmit']")).click();
    }

    @Then("I verify required fields")
    public void iVerifyRequiredFields() {
        String name = getDriver().findElement(By.xpath("//b[@name='name']")).getText();
        String userName = getDriver().findElement(By.xpath("//b[@name='username']")).getText();
        String email = getDriver().findElement(By.xpath("//b[@name='email']")).getText();
        System.out.println("Name is: "+name);
        System.out.println("Username is: "+userName);
        System.out.println("Email is: "+email);
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
}