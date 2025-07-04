package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportUtils {

    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test;

    public static ExtentReports getInstance() {
        if (extent == null) {
            ExtentSparkReporter spark = new ExtentSparkReporter("test-output/test.html");
            extent = new ExtentReports();
            extent.attachReporter(spark);
        }
        return extent;
    }

    public static ThreadLocal<ExtentTest> getTest() {

        if (null == test) {
            test = new ThreadLocal<>();
        }

        return test;
    }

}
