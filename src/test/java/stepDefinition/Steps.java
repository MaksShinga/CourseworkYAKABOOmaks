package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.*;


import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Steps {
    String url = "https://www.yakaboo.ua/";
    protected WebDriver driver;

//    @After
//    public void tearDown() {
//        driver.quit();
//    }

    @Given("I is on the Yakaboo homepage {string}")
    public void iIsOnTheYakabooHomepage(String url) {
        System.setProperty("webdriver.chrome.driver", "/Users/maksmur/IdeaProjects/CourseworkYAKABOOmaks/src/main/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
    }

    @When("I searches for a book {string}")
    public void iSearchesForABook(String bookTitle) {
        HomePage homePage = new HomePage(driver);
        homePage.searchForBook(bookTitle);
    }

    @And("I selects the first search result")
    public void iSelectsTheFirstSearchResult() {
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        searchResultPage.chooseFirstBook();
    }

    @Then("I should see the product details page")
    public void iShouldSeeTheProductDetailsPage() {
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
        assertTrue((productDetailsPage.checkButton()));
    }


    @And("I click on To the basket button")
    public void iClickOnToTheBasketButton() {
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
        productDetailsPage.clickOnToTheBasketButton();
    }

    @And("I should see that the book has been added to the basket")
    public void iShouldSeeThatTheBookHasBeenAddedToTheBasket() {
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
        assertTrue((productDetailsPage.checkBookInBasket()));
    }

    @When("I click on Basket button")
    public void iClickOnBasketButton() {
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
        productDetailsPage.clickOnBasketButton();
    }

    @Then("I should see the basket page with added book")
    public void iShouldSeeTheBasketPageWithAddedBook() {
        BasketPage basketPage = new BasketPage(driver);
        assertTrue((basketPage.checkBookInBasket()));
    }

    @And("I click on Go to checkout button")
    public void iClickOnGoToCheckoutButton() {
        BasketPage basketPage = new BasketPage(driver);
        basketPage.clickOnGoToCheckoutButton();
    }

    @Then("I should be on the checkout page")
    public void iShouldBeOnTheCheckoutPage() {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        assertTrue((checkoutPage.shouldBeOnTheCheckoutPage()));
    }

    @And("I fill in the required contact information")
    public void iFillInTheRequiredContactInformation() {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.fillingContactInformation("Maks", "SH", "0976556435", "test@gmail.com");
    }

    @And("I fill in the required delivery information")
    public void iFillInTheRequiredDeliveryInformation() {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.citySelection().branchAddressSelection();
    }


    @And("I click on Pay button")
    public void iClickOnPayButton() {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.clickingOnPayButton();
    }

    @Then("I go to the payment page")
    public void iGoToThePaymentPage() {
        PaymentPage paymentPage = new PaymentPage(driver);
        paymentPage.cardNumberLocatorIsDisplayed();
    }

    @And("I enter my card details")
    public void iEnterMyCardDetails() {
        PaymentPage paymentPage = new PaymentPage(driver);
        paymentPage.fillingCardDetails("2342345456758769","04","24","363");
    }
}
