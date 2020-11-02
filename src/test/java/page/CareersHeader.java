package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static support.TestContext.getDriver;


public class CareersHeader extends Page{

    @FindBy(xpath="//a[@href='/login']/button")
    private WebElement loginButton;

    @FindBy(xpath="//a[@href='/recruit']/button")
    private WebElement recruitButton;

    @FindBy(xpath="//button[contains(text(),'Careers')]")
    private WebElement careersButton;

    @FindBy(xpath="//button[contains(text(),'My Jobs')]")
    private WebElement myJobButton;


    @FindBy(xpath="//span[@class='logout-box']/a")
    private WebElement loggedUserName;

    private WebElement positionCard(String title) {
        return getDriver().findElement(By.xpath("//*[@class='position-name'][contains(text(),'"+title+"')]"));
    }
//    @FindBy(xpath ="//*[contains(@href,'candidates')]")
//    private WebElement loggedCandidateTitle;

    //*[@class='position-name'][contains(text(),'Principal Applications Developer')]
//*[contains(@href,'candidates')]

    public CareersLogin clickLogin() {
        click(loginButton);
        return new CareersLogin();
    }

    public CareersRecruit clickRecruit() {
        click(recruitButton);
        return new CareersRecruit();
    }

    public String getLoggedUserName() {
        return loggedUserName.getText();
    }


    public void verifyLoginAsRecruiter(){
        recruitButton.isDisplayed();
    }

    public CareersRecruit iClickRecruit(){
        recruitButton.click();
        return new CareersRecruit();
    }

    public CareersPosition chosePosition(String title){
        clickWithJS(positionCard(title));
        return new CareersPosition();
    }

    public String nameCandidate(){
        return loggedUserName.getText();
    }

    public CareersProfile clickCandidate(){
        click(loggedUserName);
        return new CareersProfile();
    }

    public CareersCareers clickCareersButton(){
        click(careersButton);
        return new CareersCareers();
    }

    public CareersMyJobs clickMyJobButton(){
        click(myJobButton);
        return new CareersMyJobs();
    }


}
