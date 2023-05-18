package fan.curier;

import fan.curier.pages.AWBTrackingPage;
import fan.curier.pages.CoveragePage;
import fan.curier.pages.HomePage;
import fan.curier.pages.ServicesPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.HashMap;

import static fan.curier.utils.FrameworkUtils.*;

public class BaseTest {

    private WebDriver driver;
    private WebDriverWait wait;
    private final static Integer WAIT_PAGE = 1000;
    private final static Integer WAIT_ACTION = 500;
    private final static Integer EXPLICIT_WAIT_SECONDS = 10;
    String URL = "https://www.fancourier.ro/";

   public HomePage homePage;
   public AWBTrackingPage awbTrackingPage;
   public CoveragePage coveragePage;
   public ServicesPage servicesPage;

    @BeforeSuite()
    public void beforeSuite() {
        System.out.println(" > BeforeSuite < ");
        browserSetUp();
        wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT_SECONDS));
        homePage = new HomePage(driver);
        awbTrackingPage = new AWBTrackingPage(driver);
        coveragePage = new CoveragePage(driver);
        servicesPage = new ServicesPage(driver);
    }

    @AfterSuite()
    public void afterSuite() {
        System.out.println(" > AfterSuite < ");
        quitBrowser();
    }
    @BeforeTest
    public void beforeTest() {
        System.out.println(" > BeforeTest < ");
    }
    @AfterTest
    public void afterTest() {
        System.out.println(" > AfterTest < ");
    }
    @BeforeGroups
    public void beforeGroups() {
        System.out.println(" > BeforeGroups < ");
    }
    @AfterGroups
    public void afterGroups() {
        System.out.println(" > AfterGroups < ");
    }

    @BeforeMethod()
    public void beforeMethod(){
        log(" > BeforeMethod <");
        openURL(URL);
    }

    @AfterMethod()
    public void afterMethod(){
        log(" > AfterMethod <");
        sleep(WAIT_ACTION);
    }

    public void quitBrowser() {
        log("Closing Chrome browser.");
        driver.quit();
        sleep(WAIT_ACTION);
    }

    public void openURL(String url) {
        log("Opening URL: " + url);
        driver.get(url);
        sleep(WAIT_PAGE);
    }

    private void browserSetUp() {
        log("Setting up Chrome browser.");
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("profile.default_content_settings.popups", 0);

        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--no-sandbox");
        options.addArguments("--incognito");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("disable-infobars");
        options.addArguments("--disable-extensions");

        options.addArguments("--whitelisted-ips");
        options.addArguments("--disable-notifications");
        options.addArguments("--kiosk");
        options.setExperimentalOption("prefs", chromePrefs);
        driver = new ChromeDriver(options);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }
}
