package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultPage extends  BasePage {
    List<WebElement> booksList = driver.findElements(By.xpath
            ("//a[@class=\"ui-search-product__link no-underline no-outline\"]"));
    public final static String TITLE = "Search Result Page";

    public SearchResultPage(WebDriver driver) {
        super(driver, TITLE);
    }

    public ProductDetailsPage chooseFirstBook() {
        WebElement firstBook = booksList.get(0);
        firstBook.click();
        return new ProductDetailsPage(driver);
    }
}
