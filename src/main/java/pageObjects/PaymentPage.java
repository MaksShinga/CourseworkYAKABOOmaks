package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentPage extends BasePage {
    private By cardNumberLocator = By.id("create[n]");
    private By validityMonthLocator = By.id("create[m]");
    private By validityYearLocator = By.id("create[y]");
    private By CVVLocator = By.id("create[c]");

    public final static String TITLE = "Payment Page";

    public PaymentPage(WebDriver driver) {
        super(driver, TITLE);
    }

    public boolean cardNumberLocatorIsDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("create[n]")));
        return true;
    }

    public PaymentPage fillingCardDetails(String cardNumber, String month, String year, String CVV) {
        driver.findElement(cardNumberLocator).sendKeys(cardNumber);
        driver.findElement(validityMonthLocator).sendKeys(month);
        driver.findElement(validityYearLocator).sendKeys(year);
        driver.findElement(CVVLocator).sendKeys(CVV);
        return new PaymentPage(driver);
    }
}