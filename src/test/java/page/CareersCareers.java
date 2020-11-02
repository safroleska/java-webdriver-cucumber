package page;

import org.openqa.selenium.WebElement;

import java.util.List;

public class CareersCareers extends CareersHeader{

    private WebElement positionCard(String title) {
        return getByXpath("//h4[text()='" + title + "']/ancestor::div[contains(@class,'position')]");
    }
    private List<WebElement> careersList(String title) {
        return getAllByXpath("//h4[text()='" + title + "']/ancestor::div[contains(@class,'card-body')]");
    }

    public CareersPosition choosePosition(String title){
        positionCard(title).click();
        return new CareersPosition();
    }

}
