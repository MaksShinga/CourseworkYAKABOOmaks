package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckoutPage extends BasePage {
    List<WebElement> cityList = driver.findElements(By.xpath
            ("//ul[@class=\"item-with-list__options\"]"));
    List<WebElement> branchAddressList = driver.findElements(By.xpath
            ("//div[contains(text(), \"Відділення №\")]"));
    private By placingAnOrderLocator = By.xpath("//h2[contains(text(), \"Оформлення замовлення\")]");
    private By firstNameFieldLocator = By.name("first name");
    private By lastNameFieldLocator = By.name("last name");
    private By phoneNumberFieldLocator = By.xpath("//input[@style=\"padding-left: 40px;\"]");
    private By emailFieldLocator = By.name("email");
    private By cityLocator = By.xpath("//input[@placeholder=\"Введіть назву міста...\"]");
    private By branchAddressLocator = By.xpath("//input[@placeholder=\"Адреса відділення\"]");
    private By payButtonLocator = By.xpath("//descendant::div[@class=\"checkout-grid__side\"]//button[contains(text(), \"Оплатити\")]");
    public final static String TITLE = "Checkout Page";

    public CheckoutPage(WebDriver driver) {
        super(driver, TITLE);
    }

    public boolean shouldBeOnTheCheckoutPage() {
        driver.findElement(placingAnOrderLocator).isDisplayed();
        return true;
    }

    public CheckoutPage fillingContactInformation(String firstName, String lastName, String phoneNumber, String email) {
        driver.findElement(firstNameFieldLocator).sendKeys(firstName);
        driver.findElement(lastNameFieldLocator).sendKeys(lastName);
        driver.findElement(phoneNumberFieldLocator).sendKeys(phoneNumber);
        driver.findElement(emailFieldLocator).sendKeys(email);
        return new CheckoutPage(driver);
    }

    public CheckoutPage citySelection() {
        driver.findElement(cityLocator).click();
        WebElement firstCity = cityList.get(0);
        firstCity.click();
        return new CheckoutPage(driver);
    }

    public CheckoutPage branchAddressSelection() {
        driver.findElement(branchAddressLocator).click();
        WebElement firstAddress = branchAddressList.get(1);
        firstAddress.click();
        return new CheckoutPage(driver);
    }

    public PaymentPage clickingOnPayButton() {
        WebElement element = driver.findElement(payButtonLocator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        driver.findElement(payButtonLocator).click();
        return new PaymentPage(driver);
    }
}

//    public PaymentPage clickingOnPayButton() {
////        driver.findElement(payButtonLocator).click();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        WebElement element = driver.findElement(payButtonLocator);
//        element.click();
//        return new PaymentPage(driver);
//    }

//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        WebElement element = driver.findElement(payButtonLocator);
//        element.click();

//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//descendant::div[@class=\"checkout-grid__side\"]//button[contains(text(), \"Оплатити\")]")));
//        element.click();
