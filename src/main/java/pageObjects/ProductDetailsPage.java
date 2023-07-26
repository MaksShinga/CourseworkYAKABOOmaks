package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage extends BasePage {
    private By toTheBasketLocator =
            By.xpath("//parent::div[@class=\"product-sidebar__ordering\"]/button[contains(text(),\"До кошика\")]");
    private By bookInBasketLocator = By.xpath("//span[@class=\"ui-btn-shopping-cart__counter\"]");
    private By basketLocator = By.xpath("//button[@class=\"ui-btn-shopping-cart\"]");
    public final static String TITLE = "Product Details Page";

    public ProductDetailsPage(WebDriver driver) {
        super(driver, TITLE);
    }

    public boolean checkButton() {
        driver.findElement(toTheBasketLocator).isDisplayed();
        return true;
    }

    public boolean checkBookInBasket() {
        driver.findElement(bookInBasketLocator).isDisplayed();
        return true;
    }

    public ProductDetailsPage clickOnToTheBasketButton() {
        driver.findElement(toTheBasketLocator).click();
        return new ProductDetailsPage(driver);
    }

    public BasketPage clickOnBasketButton() {
        driver.findElement(basketLocator).click();
        return new BasketPage(driver);
    }
}