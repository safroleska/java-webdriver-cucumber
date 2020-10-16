package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CareersPosition extends CareersHeader{

    @FindBy(xpath = "//button[@type='submit'][text()='Edit']")
    private WebElement editButton;

    @FindBy(xpath = "//button[@type='submit'][text()='Apply']")
    private WebElement applyButton;

    public CareersEditPosition clickEdit(){
        editButton.click();
        return new CareersEditPosition();
    }

    public CareersMyJobs clickApply(){
        applyButton.click();
        return new CareersMyJobs();
    }

}
