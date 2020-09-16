package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Map;

import static support.TestContext.*;
import static support.TestContext.getWait;

public class UpsShipment extends Ups{

    @FindBy(xpath = "//a[@id='ups-menuLinks2']")
    private WebElement shipping;

    @FindBy(xpath = "//a[contains(text(),'Create a Shipment:')]")
    private WebElement createShipment;

    @FindBy(id="originname")
    private WebElement originName;

    @FindBy(xpath = "//*[@placeholder='Street Address']")
    private WebElement originAddress;

    @FindBy(id="originpostal")
    private WebElement originPostal;

    @FindBy(id="originemail")
    private WebElement originEmail;

    @FindBy(id="originphone")
    private WebElement originPhone;

    @FindBy(id="nbsBackForwardNavigationContinueButton")
    private WebElement submitButton;

    @FindBy(xpath = "//div[@class='ups-group ups-group_condensed']")
    private WebElement shipFormResult;

    @FindBy(id= "nbsBackForwardNavigationCancelShipmentButton")
    private WebElement cancelShipmentButton;

    @FindBy(id= "nbsCancelShipmentWarningYes")
    private WebElement warningCancelShipmentButton;



    public void openShipping(){
        shipping.click();
    }

    public void createShipment(){
        createShipment.click();
    }

    public void fillOriginFields(){
        Map<String,String> ups = getData("ups");
        originName.sendKeys(ups.get("name"));
        originAddress.sendKeys(ups.get("address"));
        originPostal.sendKeys(ups.get("zip"));
        //don't know how to optimize these 2 steps
        getWait().until(ExpectedConditions.textToBePresentInElementValue(By.xpath("//input[@id='origincity']"),"LOS ALTOS" ));
        getWait().until(ExpectedConditions.elementToBeSelected(By.xpath("//option[contains(text(),'California')]")));

        originEmail.sendKeys(ups.get("email"));
        originPhone.sendKeys(ups.get("phone"));
    }

    public void clickSubmitButton(){
        getExecutor().executeScript("arguments[0].click()",submitButton);
    }

    public String  getShipFormResult(){
        return shipFormResult.getText();
    }

    public void cancelShipment(){
                String originalWindow = getDriver().getWindowHandle();
        getExecutor().executeScript("arguments[0].click()",cancelShipmentButton);

        for (String handle : getDriver().getWindowHandles()) {
            getDriver().switchTo().window(handle);
        }
        warningCancelShipmentButton.click();

        getDriver().switchTo().window(originalWindow);

    }
    public String nameFieldResult(){
        return originName.getText();
    }

    public String addressFieldResult(){
        return originAddress.getText();
    }

    public String zipFieldResult(){
        return originPostal.getText();
    }

    public String emailFieldResult(){
        return originEmail.getText();
    }

    public String phoneFieldResult(){
        return originPhone.getText();
    }



}
