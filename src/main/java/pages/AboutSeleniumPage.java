package pages;

import org.openqa.selenium.By;

public class AboutSeleniumPage extends BasePage {

     private By historyOfSeleniumTitle =  By.cssSelector("body > div > main > div.row.-bg-selenium-cyan-20 > div > div.card-body > h2");

     public boolean checkHistoryOfSeleniumTitle() {
          return checkVisible(historyOfSeleniumTitle);
     }
}
