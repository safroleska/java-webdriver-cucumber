package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UspsPostcardPriceCalculator extends Page{

    @FindBy(xpath = "//*[@placeholder='Quantity']")
    private WebElement quantity;

    @FindBy(xpath = "//*[@type='button'][@value='Calculate']")
    private WebElement calculateButton;

    @FindBy(id="total")
    private WebElement totalCost;

    public void defineQuantity(String num){
        quantity.sendKeys(num);
    }

    public void calculateThePrice(){
        calculateButton.click();
    }

    public String validateCost(){
        return totalCost.getText();
    }

}
