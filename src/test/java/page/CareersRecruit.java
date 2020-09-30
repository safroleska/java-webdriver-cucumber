package page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


import java.util.List;

import static support.TestContext.*;

public class CareersRecruit extends CareersHeader {

    // dynamic element
    private WebElement positionCard(String title) {
        return getByXpath("//h4[text()='" + title + "']/ancestor::div[contains(@class,'card-body')]");
    }

    private List<WebElement> positionList(String title) {
        return getAllByXpath("//h4[text()='" + title + "']/ancestor::div[contains(@class,'card-body')]");
    }

    private WebElement closeForPosition(String title) {
        return getByXpath("//h4[text()='" + title + "']/ancestor::div[contains(@class,'card')]//button");
    }



//    @FindBy(xpath = "//div[@class='container']//div[@class='card-body']")
//    private WebElement list;



//    public void iRemovePosition(String position){
//        clickWithJS(deletePosition(position));
//    }

    public CareersRecruit removePosition(String title) {
        WebElement card = positionCard(title);
        WebElement closeButton = closeForPosition(title);

        mouseOver(card);
        waitForClickable(closeButton);
        click(closeButton);
        waitForDisappear(card);

        return new CareersRecruit();
    }

//    public String verifyPositionList(){
//        return positionList(title).getText();
//    }
//
//    public void waitUntilVisibilityOf(){
//        waitForVisible(positionList);
//    }


    public boolean isPositionVisible(String title) {
//        List<WebElement> cards = allPositionCards(title);
//        if (cards.isEmpty()) {
//            return false;
//        } else {
//            return cards.get(0).isDisplayed();
//        }
        try {
            return positionCard(title).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }



}
