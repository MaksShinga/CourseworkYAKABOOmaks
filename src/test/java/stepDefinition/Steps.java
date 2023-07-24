package stepDefinition;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Steps{
    String url = "https://www.yakaboo.ua/";
    protected WebDriver driver;

    @After
    public void tearDown() {
        driver.quit();
    }

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
    }
}
