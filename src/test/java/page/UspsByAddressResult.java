package page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

import static support.TestContext.getWait;

public class UspsByAddressResult extends UspsHeader{
    @FindBy(id="zipByAddressDiv")
    private WebElement searchResult;

    @FindBy(xpath = "//*[@class='zipcode-result-address']")
    private List<WebElement> results;

    public String getSearchResult() {
        waitForVisible(searchResult);
        waitUntilContainsText(searchResult);
        return searchResult.getText();
    }

    public boolean areAllResultsContainZip(String zip) {
        for (WebElement result : results) {
            if (!result.getText().contains(zip)) {
                return false;
            }
        }
        return true;
    }

}
