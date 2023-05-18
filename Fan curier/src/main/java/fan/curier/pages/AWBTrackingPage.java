package fan.curier.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AWBTrackingPage {


    @FindBy(id = "response")
    private WebElement response;

    @FindBy(id = "awbi")
    private WebElement awbInput;

    @FindBy(id = "tracking_error")
    private WebElement trackingError;

    public AWBTrackingPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public WebElement getResponse() {
        return response;
    }

    public WebElement getAwbInput() {
        return awbInput;
    }

    public WebElement getTrackingError() {
        return trackingError;
    }

}
