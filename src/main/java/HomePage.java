import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class HomePage extends BasePage {

    private By searchBookFieldLocator = By.id("search");
    List<WebElement> booksList = driver.findElements(By.xpath("//div[@class=\"ui-search-product\"]"));

    public final static String TITLE = "Home Page";

    public HomePage(WebDriver driver) {
        super(driver, TITLE);
    }

    public ProductDetailsPage searchAndChooseBook(String bookTitle) {
        driver.findElement(searchBookFieldLocator).sendKeys(bookTitle);
        WebElement firstBook = booksList.get(0);
        firstBook.click();
        return new ProductDetailsPage(driver);
    }
}
