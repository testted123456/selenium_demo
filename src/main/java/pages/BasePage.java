package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverFactory;
import java.time.Duration;

public class BasePage {

    WebDriverWait wait;

    public BasePage() {
        wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10));
    }

    void click(By by) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
        element.click();
    }

    void sendKeys(By by, String text) {
        WebElement inputField = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        inputField.sendKeys(text);
    }

    boolean checkVisible(By by) {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (TimeoutException e) {
            return false;
        }

        return true;
    }

}
