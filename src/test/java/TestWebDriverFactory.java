import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestWebDriverFactory {

    Logger logger = LogManager.getLogger(TestWebDriverFactory.class);



    @Test
    public void test() {

        String browser = System.getProperty("browser");

        if (browser != null) {

            try {

                WebDriverFactory.DriverType driverType = WebDriverFactory.DriverType.valueOf(browser.toUpperCase());
                logger.info(driverType.toString());

                ChromeOptions options = new ChromeOptions();
                options.addArguments("start-maximized");
                WebDriver driver = WebDriverFactory.create(driverType, options);

                driver.get("https://ya.ru");
                logger.info("Well done!");
                driver.quit();

            } catch (IllegalArgumentException e) {
                logger.error("Wrong webdriver type!");
            }
        } else {
            logger.error("Webdriver type is not set!");
        }

    }
}
