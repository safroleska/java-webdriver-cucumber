package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

import static support.TestContext.getData;

public class CareersEditPosition extends CareersHeader{

    @FindBy(xpath = "//input[@placeholder='Enter position Title']")
    private WebElement titleEditField;

    @FindBy(xpath = "//*[@placeholder='Enter detailed Description']")
    private WebElement descriptionEditField;

    @FindBy(xpath = "//*[@for='positionAddress']/..//input")
    private WebElement addressEditField;

    @FindBy(xpath = "//*[@placeholder='City']")
    private WebElement cityEditField;

    @FindBy(xpath = "//*[@placeholder='Zip code. Zip plus']")
    private WebElement zipEditField;

    @FindBy(id="positionDateOpen")
    private WebElement dateOpenEditField;

    @FindBy(id="positionSubmit")
    private WebElement submitEditButton;

    public CareersPosition editPosition(){
        Map<String, String> position = getData("automation_updated");
        addressEditField.sendKeys(position.get("address"));
        cityEditField.sendKeys(position.get("city"));
        dateOpenEditField.sendKeys(position.get("dateOpen"));
        submitEditButton.click();
        return new CareersPosition();
    }

}
