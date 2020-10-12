package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

import static support.TestContext.*;

public class CareersOpenPosition extends CareersHeader{

    @FindBy(xpath = "//input[@placeholder='Enter position Title']")
    private WebElement title;

    @FindBy(xpath = "//*[@placeholder='Enter detailed Description']")
    private WebElement description;

    @FindBy(xpath = "//*[@for='positionAddress']/..//input")
    private WebElement address;

    @FindBy(xpath = "//*[@placeholder='City']")
    private WebElement city;

    @FindBy(xpath = "//*[@placeholder='Zip code. Zip plus']")
    private WebElement zip;

    @FindBy(id="positionDateOpen")
    private WebElement dateOpen;

    private WebElement state(String stateName) {
        return getDriver().findElement(By.xpath("//option[contains(text(),'"+stateName+"')]"));
    }

    @FindBy(id="positionSubmit")
    private WebElement submitButton;

     public void fillNewPositionFieldsFor(){
        Map<String, String> position = getData("automation");
        title.sendKeys(position.get("title"));
        description.sendKeys(position.get("description"));
        address.sendKeys(position.get("address"));
        city.sendKeys(position.get("city"));
        state(position.get("state")).click();
        zip.sendKeys(position.get("zip"));
        dateOpen.sendKeys(position.get("dateOpen"));
        submitButton.click();
    }


}
