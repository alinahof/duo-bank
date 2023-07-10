package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class SignUpPage {

    public SignUpPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(name = "first_name")
    private WebElement firstNameField;

    @FindBy(name = "last_name")
    private WebElement lastName;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "exampleInputPassword1")
    private WebElement password;

    @FindBy(id = "register")
    private WebElement signUpButton;

    public WebElement getFirstName() {
        return firstNameField;
    }

    public WebElement getLastName() {
        return lastName;
    }

    public WebElement getEmail() {
        return email;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getSignUpButton(){
        return signUpButton;
    }

    public void signUp(){
        SignUpPage signUpPage = new SignUpPage();
        Faker faker = new Faker();
        String firstName=faker.name().firstName();
        String lastName=faker.name().lastName();
        String email=faker.name().username().replace(".","")+"@"+faker.internet().domainName();
        String password=faker.internet().password(8,50,true,true,true);
        signUpPage.getFirstName().sendKeys(firstName);
        signUpPage.getLastName().sendKeys(lastName);
        signUpPage.getEmail().sendKeys(email);
        signUpPage.getPassword().sendKeys(password);
    }

    public void signUpExistingCustomers(String firstName, String lastName,String email,String password){
        SignUpPage signUpPage = new SignUpPage();
        signUpPage.getFirstName().sendKeys(firstName);
        signUpPage.getLastName().sendKeys(lastName);
        signUpPage.getEmail().sendKeys(email);
        signUpPage.getPassword().sendKeys(password);
    }

    public void signUpCustomFirstName(String firstName){
        SignUpPage signUpPage = new SignUpPage();
        Faker faker = new Faker();
        String lastName=faker.name().lastName();
        String email=faker.name().username().replace(".","")+"@"+faker.internet().domainName();
        String password=faker.internet().password(8,50,true,true,true);
        signUpPage.getFirstName().sendKeys(firstName);
        signUpPage.getLastName().sendKeys(lastName);
        signUpPage.getEmail().sendKeys(email);
        signUpPage.getPassword().sendKeys(password);
    }

    public void signUpCustomLastName(String lastName){
        SignUpPage signUpPage = new SignUpPage();
        Faker faker = new Faker();
        String firstName=faker.name().firstName();
        String email=faker.name().username().replace(".","")+"@"+faker.internet().domainName();
        String password=faker.internet().password(8,50,true,true,true);
        signUpPage.getFirstName().sendKeys(firstName);
        signUpPage.getLastName().sendKeys(lastName);
        signUpPage.getEmail().sendKeys(email);
        signUpPage.getPassword().sendKeys(password);
    }

    public void signUpCustomEmail(String email){
        SignUpPage signUpPage = new SignUpPage();
        Faker faker = new Faker();
        String firstName=faker.name().firstName();
        String lastName=faker.name().lastName();
        String password=faker.internet().password(8,50,true,true,true);
        signUpPage.getFirstName().sendKeys(firstName);
        signUpPage.getLastName().sendKeys(lastName);
        signUpPage.getEmail().sendKeys(email);
        signUpPage.getPassword().sendKeys(password);
    }

    public void signUpCustomPassword(String password){
        SignUpPage signUpPage = new SignUpPage();
        Faker faker = new Faker();
        String firstName=faker.name().firstName();
        String lastName=faker.name().lastName();
        String email=faker.name().username().replace(".","")+"@"+faker.internet().domainName();
        signUpPage.getFirstName().sendKeys(firstName);
        signUpPage.getLastName().sendKeys(lastName);
        signUpPage.getEmail().sendKeys(email);
        signUpPage.getPassword().sendKeys(password);
    }




}
