import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Signup {
    @FindBy(id = "firstName")
    WebElement txtFirstName;
    @FindBy(id = "lastName")
    WebElement txtLastName;
    @FindBy(id = "userName")
    WebElement txtUserName;
    //@FindBy(xpath = "//input[@type='password']")
    //List<WebElement> txtPassword;
    @FindBy(name = "Passwd")
    WebElement txtPassword;
    @FindBy(id = "spanMessage")
    WebElement spanMessage;
    @FindBy(xpath = "//button[@type='button']")
    List<WebElement> btnNext;

    public Signup(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    public void doSignup(String firstname, String lastname, String username, String password) {
        txtFirstName.sendKeys(firstname);
        txtLastName.sendKeys(lastname);
        txtUserName.sendKeys(username);
        txtPassword.sendKeys(password);
    }
    public String getErrorMessage(){
        return spanMessage.getText();
    }

}
