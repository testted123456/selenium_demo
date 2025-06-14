package utils;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

public class ScreenshotUtils {

//    protected static final Logger log = (Logger) LogManager.getLogger(ScreenshotUtils.class);

    public static void takeScreenshot(WebDriver driver, String testName) {
        // Format timestamp
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

        // Capture screenshot
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Set destination path
        String fileName = "test-output/screenshots/" + testName + "_" + timestamp + ".png";

        try {
            FileUtils.copyFile(src, new File(fileName));
//            log.info("Screenshot saved: " + fileName);
        } catch (IOException e) {
//            log.info("Failed to save screenshot: " + e.getMessage());

        }
    }
}
