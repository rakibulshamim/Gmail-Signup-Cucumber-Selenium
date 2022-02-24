import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class StepDefinitions {
    public WebDriver driver;
    Signup signup;

    @Given("user visits to gmail signup page")
    public void user_visits_to_gmail_signup_page() {
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--headed"); //uncomment if you want to run in headless mode
        driver = new ChromeDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://accounts.google.com/signup?hl=en");
        //throw new io.cucumber.java.PendingException();
    }
    @When("user inputs {string}, {string}, {string} and {string}")
    public void user_inputs_and(String firstname, String lastname, String username, String password) {
        signup = new Signup(driver);
        signup.doSignup(firstname,lastname, username, password);
        //throw new io.cucumber.java.PendingException();
    }
    @Then("user can not Sign up")
    public void user_can_not_sign_up() {
        signup = new Signup(driver);
        String text = signup.getErrorMessage();
        //Assert.assertEquals(text, "Invalid credentials");
        //driver.close();
        //throw new io.cucumber.java.PendingException();
    }
}
