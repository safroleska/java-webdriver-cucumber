package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class QuoteResult extends Quote{

    @FindBy(id = "quotePageResult")
    private WebElement resultValue;


    public String requiredFieldsValue(){
        String allValue = resultValue.getText();
        return allValue;
    }

    public String optionalFieldsValue(){
        String requiredValue = resultValue.getText();
        return  requiredValue;
    }


}
