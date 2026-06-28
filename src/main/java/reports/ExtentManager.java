package reports;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import constants.frameworkConstants;

public class ExtentManager {

    private static ExtentReports extent;

    private ExtentManager() {

    }

    public static ExtentReports getInstance() {

        if (extent == null) {

            String timeStamp =
                    LocalDateTime.now()
                            .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

            String reportPath =
                    frameworkConstants.REPORT_PATH
                            + "ExtentReport_"
                            + timeStamp
                            + ".html";

            ExtentSparkReporter spark =
                    new ExtentSparkReporter(reportPath);

            spark.config().setDocumentTitle("Automation Report");

            spark.config().setReportName("File Upload Automation");

            extent = new ExtentReports();

            extent.attachReporter(spark);

        }

        return extent;

    }

}