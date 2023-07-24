import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait webDriverWait;
    private String title;

    public BasePage(WebDriver driver, String title){
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, 5);
        this.title = title;
    }
}
