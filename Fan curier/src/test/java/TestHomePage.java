import fan.curier.BaseTest;
import fan.curier.pages.HomePage;
import fan.curier.utils.FrameworkUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TestHomePage extends BaseTest {


    @Test
    public void testAWBForm() {
       assertNotNull(FrameworkUtils.shouldBeVisible(homePage.getAwbForm(), getWait()));
       assertTrue(FrameworkUtils.shouldHaveText(homePage.getAwbForm(), getWait(), "AWB tracking\n" +
        "Caută"));
       assertNotNull(FrameworkUtils.shouldBeVisible(homePage.getAwbFormInput(), getWait()));
       assertNotNull(FrameworkUtils.shouldBeVisible(homePage.getAwbFormSubmit(), getWait()));

       String inputField = FrameworkUtils.sendKeys(homePage.getAwbFormInput(), getWait(), "AWB TEST 0000");
       assertEquals(inputField, "AWB TEST 0000", "Wrong message registered.");

       FrameworkUtils.click(homePage.getAwbFormSubmit(), getWait());
       assertNotNull(FrameworkUtils.shouldBeVisible(awbTrackingPage.getResponse(), getWait()));
       assertEquals(inputField, awbTrackingPage.getAwbInput().getAttribute("value"));
       assertNotNull(FrameworkUtils.shouldBeVisible(awbTrackingPage.getTrackingError(), getWait()));
       assertTrue(FrameworkUtils.shouldHaveAttribute(awbTrackingPage.getTrackingError(), getWait(), "textContent", "AWB-ul nu este inregistrat in sistemul FAN Courier."));

    }

}
