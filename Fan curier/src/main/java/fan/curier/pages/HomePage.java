package fan.curier.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private WebDriver driver;

    @FindBy(id = "home-awb-form")
    private WebElement awbForm;

    @FindBy(id = "home_awb_code")
    private WebElement awbFormInput;

    @FindBy(id = "home_awb_submit")
    private WebElement awbFormSubmit;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getAwbForm() {
        return awbForm;
    }

    public WebElement getAwbFormInput() {
        return awbFormInput;
    }

    public WebElement getAwbFormSubmit() {
        return awbFormSubmit;
    }

}
