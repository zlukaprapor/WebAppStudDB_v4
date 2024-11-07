package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserAuthorizationSteps {

    WebDriver driver;

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        System.setProperty("webdriver.chrome.driver", "C:/WebDriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/login"); // URL сторінки входу
    }

    @When("the user enters valid email {string} and password {string}")
    public void enterCredentials(String email, String password) {
        driver.findElement(By.name("username")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);
    }

    @When("clicks the login button")
    public void clickLoginButton() {
        driver.findElement(By.cssSelector("input[type='submit']")).click();
    }

    @Then("the user should be redirected to the home page")
    public void redirectToHomePage() {
        String currentUrl = driver.getCurrentUrl();
        assertEquals("http://localhost:8080/", currentUrl);
        driver.quit();
    }
}
