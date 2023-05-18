package fan.curier.utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FrameworkUtils {

    public static void log(String text) {
        System.out.println(text);
    }

    public static void sleep(int millis) {
        log(String.format("Waiting for %d millis.", millis));

        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            log("EXCEPTION: " + e.getMessage());
        }
    }

    public static WebElement shouldBeVisible(WebElement element, WebDriverWait wait) {
        log("Check if element is visible.");
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static boolean shouldHaveText(WebElement element, WebDriverWait wait, String text) {
        log("Check if element has text: " + text);
        return wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public static boolean shouldHaveAttribute(WebElement element, WebDriverWait wait, String attribute, String text) {
        log("Check if element has attribute: " + attribute + " as: " + text);
        return wait.until(ExpectedConditions.attributeToBe(element, attribute, text));
    }

    public static void click(WebElement element, WebDriverWait wait) {
        log("Click on element.");
        shouldBeVisible(element, wait);
        element.click();
    }

    public static String sendKeys(WebElement element, WebDriverWait wait, String givenText) {
        log("Send keys to element: " + givenText);
        click(element, wait);
        element.clear();
        element.sendKeys(givenText);

        return element.getAttribute("value");
    }
}
