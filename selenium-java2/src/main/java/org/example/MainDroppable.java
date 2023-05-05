package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;


public class MainDroppable {


    public static WebDriver driver;
    public static String draggableID = "draggable";
    public static String droppableID = "droppable";

    public static void main(String[] args) throws InterruptedException {
        browserSetUp();
        openURL("https://demoqa.com/droppable");
        wait(1000);
        WebElement draggableWebElement = findElementByID(draggableID);
        WebElement droppableWebElement = findElementByID(droppableID);
        System.out.println(droppableWebElement.getCssValue("background-color"));
        dragAndDrop(draggableWebElement, droppableWebElement);
        wait(1000);
        System.out.println(droppableWebElement.getCssValue("background-color"));
        quitBrowser();
    }

    public static void browserSetUp() {
        log("Setting up Chrome browser.");
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }

    public static WebElement findElementByXpath(String xPath) {
        log("Trying to find: " + xPath);
        return driver.findElement(By.xpath(xPath));
    }

    public static WebElement findElementByID(String id) {
        log("Trying to find: " + id);
        return driver.findElement(By.id(id));
    }

    public static void clickByJS(WebElement element) {
        log("Clicking by JavaScript: " + element.getText());
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    /**
     * Do click by Actions API.
     *
     *
     * @param element web element
     * @param typeOfClick doubleClick / oneClick / rightClick
     */
    public static void clickByAction(WebElement element, String typeOfClick) {
        log("Clicking by Actions lib. on : " + element.getText());
        Actions actions = new Actions(driver);
        if (typeOfClick.equalsIgnoreCase("doubleClick")) {
            actions.moveToElement(element).doubleClick().build().perform();
        } else if (typeOfClick.equalsIgnoreCase("oneClick")) {
            actions.moveToElement(element).click().build().perform();
        } else if (typeOfClick.equalsIgnoreCase("rightClick")) {
            actions.moveToElement(element).contextClick().build().perform();
        }
    }

    public static void dragAndDrop(WebElement source, WebElement target) {
        log("Moving : " + source.getText() + " to " + target.getText());
        Actions actions = new Actions(driver);
        actions
                .moveToElement(source)
                .clickAndHold()
                .pause(1000)
                .moveToElement(target)
                .pause(3000)
                .release()
                .build()
                .perform();
        //actions.dragAndDrop(source, target).build().perform();
    }

    public static void quitBrowser() {
        log("Closing Chrome browser.");
        driver.quit();
    }

    public static void openURL(String url) {
        log("Opening URL: " + url);
        driver.get(url);
    }

    public static void log(String login) {
        System.out.println(login);
    }

    public static void wait(int millis) throws InterruptedException {
        log(String.format("Waiting for %d millis.", millis));
        Thread.sleep(millis);
    }

}
