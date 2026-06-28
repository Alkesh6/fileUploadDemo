package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.baseClass;
import pages.FileUploadPage;

public class FileUploadTest extends baseClass {

	@Test
	public void verifyFileUpload() {

	    FileUploadPage uploadPage =
	            new FileUploadPage(driver);

	    uploadPage.uploadFile("sample.pdf");

	    uploadPage.clickUpload();

	    String actualMessage =
	            uploadPage.getUploadMessage();

	    String expectedMessage =
	            properties.getProperty("expectedUploadMessage");

	    Assert.assertEquals(
	            actualMessage,
	            expectedMessage,
	            "Upload confirmation message mismatch.");
	}

}