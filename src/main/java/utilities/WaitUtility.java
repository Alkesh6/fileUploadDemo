package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {

    private WebDriver driver;
    private WebDriverWait wait;

    public WaitUtility(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    /**
     * Wait until element is visible.
     */
    public WebElement waitForVisibility(WebElement element) {

        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Wait until element is clickable.
     */
    public WebElement waitForClickability(WebElement element) {

        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Wait until title contains text.
     */
    public boolean waitForTitleContains(String title) {

        return wait.until(ExpectedConditions.titleContains(title));
    }
}