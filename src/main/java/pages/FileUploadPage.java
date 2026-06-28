package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.Logger;

import logger.Log;

import utilities.FileUtility;
import utilities.WaitUtility;

public class FileUploadPage {

    private WebDriver driver;
    private WaitUtility waitUtility;
    private Logger logger = Log.getLogger(FileUploadPage.class);

    // Locators
    private By chooseFileInput = By.id("file-upload");
    private By uploadButton = By.id("upload-btn");
    private By uploadMessage = By.xpath("//div[@class='wpcf7-response-output']");

    /**
     * Constructor
     */
    public FileUploadPage(WebDriver driver) {

        this.driver = driver;
        this.waitUtility = new WaitUtility(driver);
    }

    /**
     * Uploads the given file.
     */
    public void uploadFile(String fileName) {

    	logger.info("Uploading file : " + fileName);
        driver.findElement(chooseFileInput)
              .sendKeys(FileUtility.getUploadFilePath(fileName));
    }

    /**
     * Click Upload button.
     */
    public void clickUpload() {

    	logger.info("Clicking Upload button");
        driver.findElement(uploadButton).click();
    }

    /**
     * Returns upload success message.
     */
    public String getUploadMessage() {

    	logger.info("Reading upload confirmation message");
        return waitUtility
                .waitForVisibility(driver.findElement(uploadMessage))
                .getText();
    } 
    
   /* public String getUploadMessage() {

        String message = waitUtility
                .waitForVisibility(driver.findElement(uploadMessage))
                .getText();

        System.out.println("Upload Message : " + message);

        return message;
    }   */

    /**
     * Verifies successful upload.
     */
    public boolean isUploadSuccessful() {

        return getUploadMessage()
                .contains("Thank you for your message. It has been sent.");
    }

}