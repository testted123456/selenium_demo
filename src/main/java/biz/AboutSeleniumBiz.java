package biz;

import org.testng.Assert;
import pages.AboutSeleniumPage;
import utils.ReportUtils;

public class AboutSeleniumBiz {

    AboutSeleniumPage aboutSeleniumPage = new AboutSeleniumPage();

    public void loadedSuccess() {
        boolean isLoadedSuccess = aboutSeleniumPage.checkHistoryOfSeleniumTitle();

        if (isLoadedSuccess) {
            ReportUtils.getTest().get().pass("test_1 passed.");
        } else {
            ReportUtils.getTest().get().fail("test_1 failed.");
            Assert.fail("the element doesn't appear within timeout.");
        }
    }
}
