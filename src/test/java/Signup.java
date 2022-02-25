import io.cucumber.datatable.DataTable;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

import java.util.List;
import java.util.Map;

public class Signup {
    @FindBy(id = "firstName")
    WebElement txtFirstName;
    @FindBy(id = "lastName")
    WebElement txtLastName;
    @FindBy(id = "username")
    WebElement txtUserName;
    @FindBy(name = "Passwd")
    WebElement txtPassword;
    @FindBy(name = "ConfirmPasswd")
    WebElement txtConfirmPasswd;
    @FindBy(xpath = "//input[@id='i3']")
    WebElement btnCheckBox;
    @FindBy(xpath = "//button[@type='button']")
    List<WebElement> btnNext;

    public Signup(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    public void doSignup(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String firstName = data.get(0).get("firstname");
        txtFirstName.sendKeys(firstName);
        String lastName = data.get(0).get("lastname");
        txtLastName.sendKeys(lastName);
        String userName = data.get(0).get("username");
        txtUserName.sendKeys(userName);
        String Password = data.get(0).get("password");
        txtPassword.sendKeys(Password);
        String ConfirmPassword = data.get(0).get("confirmPassword");
        txtConfirmPasswd.sendKeys(ConfirmPassword);
        btnCheckBox.click();
        btnNext.get(1).click();

    }

}
