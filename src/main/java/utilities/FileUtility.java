package utilities;

import java.io.File;

import constants.frameworkConstants;

public class FileUtility {

    /**
     * Returns the absolute path of a file
     * inside the UploadFiles directory.
     */
    public static String getUploadFilePath(String fileName) {

        File file = new File(
                frameworkConstants.UPLOAD_FILE_PATH + fileName);

        return file.getAbsolutePath();
    }

    /**
     * Checks whether the file exists.
     */
    public static boolean fileExists(String fileName) {

        File file = new File(
                frameworkConstants.UPLOAD_FILE_PATH + fileName);

        return file.exists();
    }
}