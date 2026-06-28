package utilities;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import constants.frameworkConstants;

public class ScreenshotUtility {

    /**
     * Captures a screenshot and returns its path.
     */
    public static String captureScreenshot(WebDriver driver, String testName)
            throws IOException {

        String timeStamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

        String fileName = testName + "_" + timeStamp + ".png";

        String destination =
                frameworkConstants.SCREENSHOT_PATH + fileName;

        File source =
                ((TakesScreenshot) driver)
                        .getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(source, new File(destination));

        return destination;
    }
}