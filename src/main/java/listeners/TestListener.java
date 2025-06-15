package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.DriverFactory;
import utils.ReportUtils;
import utils.ScreenshotUtils;

public class TestListener implements ITestListener {

    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test;

    @Override
    public void onStart(ITestContext context) {
        extent = ReportUtils.getInstance();
        test = ReportUtils.getTest();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.get().fail(result.getThrowable());
        WebDriver driver = DriverFactory.getDriver();
        ScreenshotUtils.takeScreenshot(driver, result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().pass("Test Passed");
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
