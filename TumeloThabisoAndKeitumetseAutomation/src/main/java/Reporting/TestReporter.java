package Reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestResult;
public class TestReporter {
    private final ExtentReports extent;
    private ExtentTest test;

    public TestReporter(String reportPath) {
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(reportPath);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    public void createTest(String testName) {

        test = extent.createTest(testName);
    }

    public void logTestStatus(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, "Test Failed: " + result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, "Test Passed");
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.log(Status.SKIP, "Test Skipped");
        }
    }

    public void logTestStatus(String stepName, boolean passed) {
        if (passed) {
            test.log(Status.PASS, stepName);
        } else {
            test.log(Status.FAIL, stepName);
        }
    }

    public void addScreenshot(String screenshotPath) {

        test.addScreenCaptureFromPath(screenshotPath);
    }

    public void flushReport() {

        extent.flush();
    }
}
