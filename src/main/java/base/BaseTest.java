package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import listerner.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utils.DriverFactory;
import utils.ReportUtils;
import java.lang.reflect.Method;

@Listeners(TestListener.class)
public class BaseTest {

    public WebDriver webDriver;

    ExtentReports extentReports;

    public ExtentTest test;

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("before suite...");
    }

    @AfterSuite
    public void tearDownReport() {
        System.out.println("after suite...");
        extentReports.flush();
    }

    @Parameters("browser")
    @BeforeMethod
    public void setUp(String browser, Method method) {
        System.out.println("before method...");

        extentReports = ReportUtils.getInstance();

        test = extentReports.createTest(method.getName());

        DriverFactory.init(browser);

        webDriver = DriverFactory.getDriver();

        webDriver.manage().window().maximize();

        webDriver.get("https://www.selenium.dev/");

    }

    @AfterMethod
    public void tearDown() {
        System.out.println("after method...");
        DriverFactory.quitDriver();
    }
}
