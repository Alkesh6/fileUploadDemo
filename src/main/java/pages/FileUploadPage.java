package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.FileUtility;
import utilities.WaitUtility;

public class FileUploadPage {

    private WebDriver driver;
    private WaitUtility waitUtility;

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

        driver.findElement(chooseFileInput)
              .sendKeys(FileUtility.getUploadFilePath(fileName));
    }

    /**
     * Click Upload button.
     */
    public void clickUpload() {

        driver.findElement(uploadButton).click();
    }

    /**
     * Returns upload success message.
     */
    public String getUploadMessage() {

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