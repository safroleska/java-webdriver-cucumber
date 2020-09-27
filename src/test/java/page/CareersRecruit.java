package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import static support.TestContext.*;

public class CareersRecruit  extends Careers{

    private WebElement deletePosition(String position) {
        return getDriver().findElement(By.xpath("//*[contains(text(),'"+position+"')]/../../..//button[contains(@class,'close')]"));
    }

//    private WebElement position(String positionName) {
//        return getDriver().findElement(By.xpath("//*[contains(text(),'"+positionName+"')]"));
//    }

    @FindBy(xpath = "//div[@class='row']")
    private WebElement positionList;


//    @FindBy(xpath = "//div[@class='container']//div[@class='card-body']")
//    private WebElement list;



    public void iRemovePosition(String position){
        clickWithJS(deletePosition(position));
    }

    public String verifyPositionList(){
        return positionList.getText();
    }

    public void waitUntilVisibilityOf(){
        waitForVisible(positionList);
    }


}
