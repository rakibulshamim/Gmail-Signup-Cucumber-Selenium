import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
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
    @When("user inputs invalid data on signup page")
    public void user_inputs_invalid_data_on_signup_page(DataTable dataTable) throws InterruptedException {
        signup = new Signup(driver);
        signup.doSignup(dataTable);
    }
    @Then("User registration should be unsuccessful")
    public void user_registration_should_be_unsuccessful() {
        //signup = new Signup(driver);
        //String text = signup.getErrorMessage();
        //Assert.assertEquals(text, "Invalid credentials");
        //driver.close();
    }
}
