package fan.curier.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ServicesPage {

    public ServicesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
