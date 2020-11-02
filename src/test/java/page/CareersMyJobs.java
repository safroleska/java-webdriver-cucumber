package page;

import org.openqa.selenium.WebElement;

public class CareersMyJobs extends CareersHeader{

    private WebElement positionCard(String title) {
        return getByXpath("//h4[text()='"+title+"']/../../../..//div[@class='position-info']");
    }

    public String positionInfo(String title){
        return positionCard(title).getText();
    }
}
