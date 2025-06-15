package biz;

import pages.MainPage;

public class MainBiz {

    MainPage mainPage = new MainPage();

    public void navigateToAboutSelenium() {
        mainPage.clickAboutDropdown();
        mainPage.clickAboutSeleniumLink();
    }
}
