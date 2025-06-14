package pages;

import org.openqa.selenium.By;

public class MainPage extends BasePage {

    private By aboutDropdown = By.cssSelector("a#navbarDropdown");

    private By aboutSeleniumLink = By.cssSelector("#main_navbar > ul > li:nth-child(1) > div > a:nth-child(1)");

    public void clickAboutDropdown() {
        click(aboutDropdown);
    }

    public void clickAboutSeleniumLink () {
        click(aboutSeleniumLink);
    }

}
