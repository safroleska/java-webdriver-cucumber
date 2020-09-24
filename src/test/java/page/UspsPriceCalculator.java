package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static support.TestContext.getDriver;

public class UspsPriceCalculator {

    private WebElement shape(String shape) {
        return getDriver().findElement(By.xpath("//*[@value='"+shape+"']"));
    }
    private WebElement country(String countryValue) {
        return getDriver().findElement(By.xpath("//option[text()='"+countryValue+"']"));

    }
    public void countrySelect(String countryValue){
        country(countryValue).click();
//        new Select(country(countryValue)).selectByVisibleText(countryValue);
    }

    public void shapeChoose(String shapeValue){
        shape(shapeValue).click();
    }




}
