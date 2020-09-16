package page;

import org.openqa.selenium.support.PageFactory;

import static support.TestContext.getDriver;

public class Ups {
    private String url;

    public Ups(){
        PageFactory.initElements(getDriver(), this);
        url = "https://www.ups.com/us/en/Home.page";
    }

    public void open(){
        getDriver().get(url);
    }

}
