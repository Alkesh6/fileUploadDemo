package constants;

/**
 * Stores all framework-level constant values.
 * This class cannot be instantiated.
 */
public final class frameworkConstants {

    private frameworkConstants() {
        // Prevent object creation
    }

    // Project Root Directory
    public static final String PROJECT_PATH = System.getProperty("user.dir");

    // Configuration File
    public static final String CONFIG_FILE_PATH =
            PROJECT_PATH + "/src/main/resources/config.properties";

    // Reports Directory
    public static final String REPORT_PATH =
            PROJECT_PATH + "/Reports/";

    // Screenshots Directory
    public static final String SCREENSHOT_PATH =
            PROJECT_PATH + "/Screenshots/";

    // Upload Files Directory
    public static final String UPLOAD_FILE_PATH =
            PROJECT_PATH + "/UploadFiles/";

    // Logs Directory
    public static final String LOG_PATH =
            PROJECT_PATH + "/Logs/";
}