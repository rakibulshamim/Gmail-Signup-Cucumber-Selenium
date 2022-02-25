package Pages;

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
    @FindBy(xpath = "//button[@type='button']")
    List<WebElement> btnNext;
    @FindBy(xpath = "//span[contains(text(),'Use 8 characters or more for your password')]")
    WebElement firstSpanText;
    @FindBy(xpath = "//span[contains(text(),'Please choose a stronger password. Try a mix of le')]")
    WebElement secondSpanText;

    public Signup(WebDriver driver){

        PageFactory.initElements(driver,this);
    }
    public void doSignup(DataTable dataTable) {
        Map<String,String> data = dataTable.asMap(String.class, String.class);
        String firstName = data.get("firstname");
        txtFirstName.sendKeys(firstName);
        String lastName = data.get("lastname");
        txtLastName.sendKeys(lastName);
        String userName = data.get("username");
        txtUserName.sendKeys(userName);
        String Password = data.get("password");
        txtPassword.sendKeys(Password);
        String ConfirmPassword = data.get("confirmPassword");
        txtConfirmPasswd.sendKeys(ConfirmPassword);
        btnNext.get(1).click();
    }
    public String firstErrorMessage(){
        return firstSpanText.getText();
    }
    public String secondErrorMessage(){
        return secondSpanText.getText();
    }
}