package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasketPage extends BasePage {
    private By addedBookLocator = By.xpath("//div[@class=\"checkout-product-card product-cart\"]");
    private By GoToCheckoutLocator = By.xpath("//button[contains(text(), \"Перейти до оформлення замовлення\")]");
    public final static String TITLE = "Basket Page";

    public BasketPage(WebDriver driver) {
        super(driver, TITLE);
    }

    public boolean checkBookInBasket() {
        driver.findElement(addedBookLocator).isDisplayed();
        return true;
    }

    public CheckoutPage clickOnGoToCheckoutButton() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), \"Перейти до оформлення замовлення\")]")));
        element.click();
        return new CheckoutPage(driver);
    }
//    public CheckoutPage clickOnGoToCheckoutButton() {
//        driver.findElement(GoToCheckoutLocator).click();
//        return new CheckoutPage(driver);
//    }
}
