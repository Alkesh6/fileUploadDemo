package listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import reports.ExtentManager;
import base.baseClass;
import utilities.ScreenshotUtility;

public class TestListener implements ITestListener {

    private static ExtentReports extent = ExtentManager.getInstance();

    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onStart(ITestContext context) {

        System.out.println("========== Test Execution Started ==========");
    }

    @Override
    public void onTestStart(ITestResult result) {

        ExtentTest extentTest =
                extent.createTest(result.getMethod().getMethodName());

        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test.get().pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.get().fail(result.getThrowable());

        try {

            WebDriver driver =
                    ((baseClass) result.getInstance()).getDriver();

            String screenshotPath =
                    ScreenshotUtility.captureScreenshot(
                            driver,
                            result.getMethod().getMethodName());

            test.get()
                    .addScreenCaptureFromPath(screenshotPath);

        }

        catch (Exception e) {

            e.printStackTrace();

        }

    }

    @Override
    public void onTestSkipped(ITestResult result) {

        test.get().skip("Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {

        extent.flush();

        System.out.println("========== Test Execution Finished ==========");
    }
}