package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.apache.logging.log4j.Logger;

import logger.Log;
import base.baseClass;
import pages.FileUploadPage;

public class FileUploadTest extends baseClass {

	private Logger logger = Log.getLogger(FileUploadTest.class);
	
	@Test
	public void verifyFileUpload() {

		logger.info("Starting File Upload Test");
	    FileUploadPage uploadPage =
	            new FileUploadPage(driver);

	    uploadPage.uploadFile("sample.pdf");

	    uploadPage.clickUpload();
	    logger.info("Validating upload confirmation");
	    String actualMessage =
	            uploadPage.getUploadMessage();

	    logger.info("File Upload Test Completed");
	    String expectedMessage =
	            properties.getProperty("expectedUploadMessage");

	    Assert.assertEquals(
	            actualMessage,
	            expectedMessage,
	            "Upload confirmation message mismatch.");
	}

}