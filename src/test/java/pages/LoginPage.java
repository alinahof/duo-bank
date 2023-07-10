package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ConfigReader;
import utils.Driver;

public class LoginPage{

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(name = "email")
    private WebElement emailField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(name = "login")
    private WebElement signInButton;


    public WebElement getEmailField() {
        return emailField;
    }

    public WebElement getPasswordFieldField() {
        return passwordField;
    }

    public WebElement getSignInButton(){
        return signInButton;
    }

    public void loginWithValidCredentials(){
        login(ConfigReader.getProperty("email"),ConfigReader.getProperty("password"));
    }

    public void loginWithInvalidCredentials(){
        login(ConfigReader.getProperty("invalidEmail"),ConfigReader.getProperty("invalidPassword"));
    }

    public void login(String email, String password){
        emailField.sendKeys(email, Keys.TAB, password, Keys.ENTER);
    }


}
