package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.apache.logging.log4j.Logger;

import logger.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import constants.frameworkConstants;
import io.github.bonigarcia.wdm.WebDriverManager;

public class baseClass {

    protected WebDriver driver;
    protected Properties properties;
    protected Logger logger = Log.getLogger(baseClass.class);
    
    @BeforeMethod
    public void setup() throws IOException {

    	logger.info("Loading configuration...");
        loadProperties();

        String browser =
                properties.getProperty("browser").toLowerCase();

        logger.info("Launching Chrome browser...");
        switch (browser) {

        case "chrome":

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            break;

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

        logger.info("Opening application URL...");
        driver.get(properties.getProperty("applicationURL"));
        logger.info("Browser launched successfully.");
    }
    
    

    private void loadProperties() throws IOException {

        properties = new Properties();

        FileInputStream fis =
                new FileInputStream(frameworkConstants.CONFIG_FILE_PATH);

        properties.load(fis);

        fis.close();
    }

    @AfterMethod
    public void tearDown() {

        if(driver != null) {

            driver.quit();

        }

    }

}