package page;

import org.openqa.selenium.support.PageFactory;

import static support.TestContext.getDriver;

public class QuoteResult {

    public QuoteResult() {
        PageFactory.initElements(getDriver(), this);
    }
}
