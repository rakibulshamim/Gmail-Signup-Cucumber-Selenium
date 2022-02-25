import Pages.Signup;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;

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
    }
    @When("user inputs password less than 8 chars on signup page")
    public void user_inputs_password_less_than_8_chars_on_signup_page(DataTable dataTable) {
        signup = new Signup(driver);
        signup.doSignup(dataTable);
    }
    @Then("User registration should be unsuccessful")
    public void user_registration_should_be_unsuccessful() {
        signup = new Signup(driver);
        String text = signup.firstErrorMessage();
        Assert.assertEquals(text, "Use 8 characters or more for your password");
        driver.close();
    }
    @When("user inputs password more than 8 chars but it is not strong")
    public void user_inputs_password_more_than_8_chars_but_it_is_not_strong(DataTable dataTable) {
        signup = new Signup(driver);
        signup.doSignup(dataTable);
    }
    @Then("User registration should be unsuccessful again")
    public void user_registration_should_be_unsuccessful_again() {
        signup = new Signup(driver);
        String text = signup.secondErrorMessage();
        Assert.assertEquals(text, "Please choose a stronger password. Try a mix of letters, numbers, and symbols.");
        driver.close();
    }
}