package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AboutSeleniumPage;
import pages.MainPage;

public class MainTest extends BaseTest {

    MainPage mainPage = new MainPage();

    AboutSeleniumPage aboutSeleniumPage = new AboutSeleniumPage();

    @Test
    public void testMain() {
        test.info("begin to test.");
        mainPage.clickAboutDropdown();
        mainPage.clickAboutSeleniumLink();
        boolean result = aboutSeleniumPage.checkHistoryOfSeleniumTitle();

        if (result) {
            test.pass("test_1 passed.");
        } else {
            test.fail("test_1 failed.");
            Assert.fail("the element doesn't appear within timeout.");
        }
    }

}
