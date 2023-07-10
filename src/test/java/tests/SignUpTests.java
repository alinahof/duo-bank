package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;
import pages.SignUpPage;
import utils.CSVReader;
import utils.Driver;
import utils.SeleniumUtils;

import java.util.Random;

public class SignUpTests extends TestBase {

    @DataProvider(name = "users")
    public Object [][] getData(){

        return CSVReader.readFromCSVFile("src/test/resources/users.csv");
    }

        @Test
    public void positiveSignup ()  {
            Driver.getDriver().findElement(By.linkText("Sign up")).click();

            SignUpPage signUpPage = new SignUpPage();
            signUpPage.signUp();
            signUpPage.getSignUpButton().click();
            Assert.assertTrue(Driver.getDriver().getPageSource().contains("Registration Successful"));
            new SeleniumUtils().waitForTitleContains("Login", 3);
            Assert.assertEquals(Driver.getDriver().getCurrentUrl(), "http://qa-duobank.us-east-2.elasticbeanstalk.com/index.php");
        }
//
    @Test
    public void negativeSignupNoFirstName ()  {
        Driver.getDriver().findElement(By.linkText("Sign up")).click();

        SignUpPage signUpPage = new SignUpPage();
        signUpPage.signUpCustomFirstName("");
        signUpPage.getSignUpButton().click();

        Assert.assertFalse(Driver.getDriver().getPageSource().contains("Registration Successful"));
    }

    @Test
    public void negativeSignupLongFirstName () {
        Driver.getDriver().findElement(By.linkText("Sign up")).click();

        SignUpPage signUpPage = new SignUpPage();
        signUpPage.signUpCustomFirstName("sfmksadffflsfsjfieowjoiwjefjweoijfowiejfowiejfowiejf");
        signUpPage.getSignUpButton().click();
        Assert.assertFalse(Driver.getDriver().getPageSource().contains("Registration Successful"));
    }

    @Test
    public void negativeSignupNumbersFirstName () {
        Driver.getDriver().findElement(By.linkText("Sign up")).click();
        SignUpPage signUpPage = new SignUpPage();
        signUpPage.signUpCustomFirstName("12345khkjnh");
        signUpPage.getSignUpButton().click();
        Assert.assertFalse(Driver.getDriver().getPageSource().contains("Registration Successful"));
    }


    @Test
    public void negativeSignupNoLastName () {
        Driver.getDriver().findElement(By.linkText("Sign up")).click();

        SignUpPage signUpPage = new SignUpPage();
        signUpPage.signUpCustomLastName("");
        signUpPage.getSignUpButton().click();
        Assert.assertFalse(Driver.getDriver().getPageSource().contains("Registration Successful"));
    }

    @Test
    public void negativeSignupLongLastName ()  {
        Driver.getDriver().findElement(By.linkText("Sign up")).click();

        SignUpPage signUpPage = new SignUpPage();
        signUpPage.signUpCustomLastName("sfmksadffflsfsjfieowjoiwjefjweoijfowiejfowiejfowiejf");
        signUpPage.getSignUpButton().click();
        Assert.assertFalse(Driver.getDriver().getPageSource().contains("Registration Successful"));
    }

    @Test
    public void negativeSignupNumbersLastName () {
        Driver.getDriver().findElement(By.linkText("Sign up")).click();

        SignUpPage signUpPage = new SignUpPage();
        signUpPage.signUpCustomLastName("12345khkjnh");
        signUpPage.getSignUpButton().click();
        Assert.assertFalse(Driver.getDriver().getPageSource().contains("Registration Successful"));
    }

    @Test
    public void negativeSignupNoEmail () {
        Driver.getDriver().findElement(By.linkText("Sign up")).click();

        SignUpPage signUpPage = new SignUpPage();
        signUpPage.signUpCustomEmail("");
        signUpPage.getSignUpButton().click();
        Assert.assertFalse(Driver.getDriver().getPageSource().contains("Registration Successful"));
    }

    @Test
    public void negativeInvalidEmailFormat () {
        Driver.getDriver().findElement(By.linkText("Sign up")).click();

        SignUpPage signUpPage = new SignUpPage();
        signUpPage.signUpCustomEmail("gmail@com");
        signUpPage.getSignUpButton().click();

        Assert.assertFalse(Driver.getDriver().getPageSource().contains("Registration Successful"));
    }

    @Test
    public void negativeInvalidEmailFormatNoAtSign () {
        Driver.getDriver().findElement(By.linkText("Sign up")).click();

        SignUpPage signUpPage = new SignUpPage();
        signUpPage.signUpCustomEmail("gmail.com");
        signUpPage.getSignUpButton().click();
        Assert.assertFalse(Driver.getDriver().getPageSource().contains("Registration Successful"));
    }

    @Test(dataProvider = "users")
    public void previouslyUsedEmail (String firstName,
                                             String lastName,
                                             String email,
                                             String password) {
        Driver.getDriver().findElement(By.linkText("Sign up")).click();

        SignUpPage signUpPage = new SignUpPage();
        signUpPage.signUpExistingCustomers(firstName, lastName, email, password);
        signUpPage.getSignUpButton().click();
        Assert.assertFalse(Driver.getDriver().getPageSource().contains("Registration Successful"));
    }

    @Test
    public void negativeLongEmail () {
        Driver.getDriver().findElement(By.linkText("Sign up")).click();

        SignUpPage signUpPage = new SignUpPage();
        signUpPage.signUpCustomEmail("sfmksadffflsfsjfieowjoiwjefjweoijfowiejfowiejfowiejfsfmksadffflsfsjfieowjoiwjefjweoijfowiejfowiejfowiejfsfmksadffflsfsjfieowjoiwjefjweoijfowiejfowiejfowiejfsfmksadffflsfsjfieowjoiwjefjweoijfowiejfowiejfowiejfsfmksadffflsfsjfieowjoiwjefjweoijfowiejfowiejfowiejfewdwefwf@gmail.com");
        signUpPage.getSignUpButton().click();
        Assert.assertFalse(Driver.getDriver().getPageSource().contains("Registration Successful"));
    }

    @Test
    public void negativeSignupNoPassword () {
        Driver.getDriver().findElement(By.linkText("Sign up")).click();

        SignUpPage signUpPage = new SignUpPage();
        signUpPage.signUpCustomPassword("");
        signUpPage.getSignUpButton().click();
        Assert.assertFalse(Driver.getDriver().getPageSource().contains("Registration Successful"));
    }

    @Test
    public void negativeShortPassword () {
        Driver.getDriver().findElement(By.linkText("Sign up")).click();

        SignUpPage signUpPage = new SignUpPage();
        signUpPage.signUpCustomPassword("Pa1");
        signUpPage.getSignUpButton().click();
        Assert.assertFalse(Driver.getDriver().getPageSource().contains("Registration Successful"));
    }

    @Test
    public void negativeNoUpperCaseLetterPassword () {
        Driver.getDriver().findElement(By.linkText("Sign up")).click();

        SignUpPage signUpPage = new SignUpPage();
        signUpPage.signUpCustomPassword("aaaaaaa1");
        signUpPage.getSignUpButton().click();
        Assert.assertFalse(Driver.getDriver().getPageSource().contains("Registration Successful"));
    }
    @Test
    public void negativeNoLowerCaseLetterPassword ()  {
        Driver.getDriver().findElement(By.linkText("Sign up")).click();

        SignUpPage signUpPage = new SignUpPage();
        signUpPage.signUpCustomPassword("AAAAAAAA1");
        signUpPage.getSignUpButton().click();
        Assert.assertFalse(Driver.getDriver().getPageSource().contains("Registration Successful"));
    }

    @Test
    public void negativeNoNumberPassword () throws InterruptedException {
        Driver.getDriver().findElement(By.linkText("Sign up")).click();

        SignUpPage signUpPage = new SignUpPage();
        signUpPage.signUpCustomPassword("aaaaaaa");
        signUpPage.getSignUpButton().click();
        Assert.assertFalse(Driver.getDriver().getPageSource().contains("Registration Successful"));
    }

    @Test
    public void negativeNoInput () {
        Driver.getDriver().findElement(By.linkText("Sign up")).click();

        SignUpPage signUpPage = new SignUpPage();
        signUpPage.getSignUpButton().click();
       Assert.assertFalse(Driver.getDriver().getPageSource().contains("Registration Successful"));
    }

    @Test(dataProvider = "users")
    public void emailErrorMessage (String firstName,
                                 String lastName,
                                 String email,
                                 String password) {
        Driver.getDriver().findElement(By.linkText("Sign up")).click();

        SignUpPage signUpPage = new SignUpPage();
        signUpPage.signUpExistingCustomers(firstName, lastName, email, password);
        signUpPage.getSignUpButton().click();
        Assert.assertTrue(Driver.getDriver().findElement(By.id("emailerror")).isDisplayed());
    }

    @Test
    public void signInLinkPresent () {
        Driver.getDriver().findElement(By.linkText("Sign up")).click();


        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//a[@href]")).isDisplayed());
        Driver.getDriver().findElement(By.xpath("//a[@href]")).click();
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), "http://qa-duobank.us-east-2.elasticbeanstalk.com/index.php");
    }

    @Test
    public void signUpButtonDisabled () {
        Driver.getDriver().findElement(By.linkText("Sign up")).click();
        Assert.assertFalse(new SignUpPage().getSignUpButton().isEnabled());
    }


















}
