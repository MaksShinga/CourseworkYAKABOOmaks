package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private By searchBookFieldLocator = By.id("search");

    public final static String TITLE = "Home Page";

    public HomePage(WebDriver driver) {super(driver, TITLE);}

    public SearchResultPage searchForBook(String bookTitle) {
        driver.findElement(searchBookFieldLocator).sendKeys(bookTitle);
        return new SearchResultPage(driver);
    }
}
