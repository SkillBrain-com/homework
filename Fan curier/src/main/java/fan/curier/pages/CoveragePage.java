package fan.curier.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CoveragePage {

    public CoveragePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
