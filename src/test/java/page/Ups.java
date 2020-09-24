package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static support.TestContext.getDriver;
import static support.TestContext.getWait;

public class Ups {
    private String url;

    public Ups(){
        PageFactory.initElements(getDriver(), this);
        url = "https://www.ups.com/us/en/Home.page";
    }

    public void open(){
        getDriver().get(url);
    }

    protected void waitUntilContainsText(WebElement element, String text) {
        getWait().until(ExpectedConditions.textToBePresentInElementValue(element,text));
    }

    protected void waitToBeSelected(WebElement element) {
        getWait().until(ExpectedConditions.elementToBeSelected(element));
    }

}
