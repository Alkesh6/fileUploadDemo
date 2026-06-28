package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import constants.frameworkConstants;
import io.github.bonigarcia.wdm.WebDriverManager;

public class baseClass {

    protected static WebDriver driver;
    protected static Properties properties;

    /**
     * Loads the configuration file.
     */
    public static void loadProperties() throws IOException {

        properties = new Properties();

        FileInputStream fis = new FileInputStream(
                frameworkConstants.CONFIG_FILE_PATH);

        properties.load(fis);

        fis.close();
    }

    /**
     * Initializes the browser and launches the application.
     */
    public static void initializeBrowser() throws IOException {

        loadProperties();

        String browser = properties.getProperty("browser").toLowerCase();

        switch (browser) {

        case "chrome":

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            break;

        /*
        case "edge":

            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            break;
        */

        default:

            throw new IllegalArgumentException(
                    "Unsupported browser : " + browser);
        }

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(
                Duration.ofSeconds(
                        Long.parseLong(properties.getProperty("implicitWait"))));

        driver.manage().timeouts().pageLoadTimeout(
                Duration.ofSeconds(
                        Long.parseLong(properties.getProperty("pageLoadTimeout"))));

        driver.get(properties.getProperty("applicationURL"));
    }

    /**
     * Returns the active WebDriver instance.
     */
    public static WebDriver getDriver() {

        return driver;
    }

    /**
     * Closes the browser.
     */
    public static void tearDown() {

        if (driver != null) {

            driver.quit();
        }
    }
}