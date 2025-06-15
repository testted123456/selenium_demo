package tests;

import base.BaseTest;
import biz.AboutSeleniumBiz;
import biz.MainBiz;
import org.testng.annotations.Test;

public class DemoTest extends BaseTest {

    MainBiz mainBiz = new MainBiz();

    AboutSeleniumBiz aboutSeleniumBiz = new AboutSeleniumBiz();

    @Test
    public void testMain() {
        test.info("begin to test.");
        mainBiz.navigateToAboutSelenium();

        aboutSeleniumBiz.loadedSuccess();
    }

}
