package page;

import org.openqa.selenium.support.PageFactory;

import static support.TestContext.getDriver;

public class Quote {

    private String url;
    private String title;

    public Quote(){
        PageFactory.initElements(getDriver(), this);
        url = "https://skryabin.com/market/quote.html";
        title = "Get a Quote";
    }
    public void open() {
        getDriver().get(url);
    }
}
