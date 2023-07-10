package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.ConfigReader;
import utils.Driver;

public class LogInTests extends TestBase {

    @Test
    public void welcomeMessagePresent()  {

        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//h4")).isDisplayed());

    }

    @Test
    public void verificationOfPresentFields()  {
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//*[@type='email']")).isDisplayed());
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//*[@type='password']")).isDisplayed());

    }

    @Test
    public void positiveSignIn(){
        LoginPage loginPage = new LoginPage();
        loginPage.loginWithValidCredentials();
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), "http://qa-duobank.us-east-2.elasticbeanstalk.com/dashboard.php");
    }

    @Test
    public void negativeSignInNoEmail(){
        LoginPage loginPage = new LoginPage();
        loginPage.getEmailField().sendKeys("");
        loginPage.getPasswordFieldField().sendKeys(ConfigReader.getProperty("password"));
        Assert.assertNotEquals(Driver.getDriver().getCurrentUrl(), "http://qa-duobank.us-east-2.elasticbeanstalk.com/dashboard.php");
    }

    @Test
    public void negativeSignInIncorrectEmailFormat(){
        LoginPage loginPage = new LoginPage();
        loginPage.getEmailField().sendKeys(ConfigReader.getProperty("invalidEmailFormat"));
        loginPage.getPasswordFieldField().sendKeys(ConfigReader.getProperty("password"));
        Assert.assertNotEquals(Driver.getDriver().getCurrentUrl(), "http://qa-duobank.us-east-2.elasticbeanstalk.com/dashboard.php");
    }

    @Test
    public void negativeSignInNoPassword(){
        LoginPage loginPage = new LoginPage();
        loginPage.getEmailField().sendKeys(ConfigReader.getProperty("email"));
        loginPage.getPasswordFieldField().sendKeys("");
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), "http://qa-duobank.us-east-2.elasticbeanstalk.com/dashboard.php");
    }

    @Test
    public void negativeSignInBlank(){
        LoginPage loginPage = new LoginPage();
        loginPage.getEmailField().sendKeys("");
        loginPage.getPasswordFieldField().sendKeys("");
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), "http://qa-duobank.us-east-2.elasticbeanstalk.com/dashboard.php");
    }


    @Test
    public void maskedPasswordField(){
        LoginPage loginPage = new LoginPage();
        Assert.assertTrue(loginPage.getPasswordFieldField().getAttribute("type").equalsIgnoreCase("password"));
    }


    @Test
    public void signInButtonDisabled(){
        LoginPage loginPage = new LoginPage();
        Assert.assertFalse(loginPage.getSignInButton().isEnabled());
    }

    @Test
    public void loginFailed(){
        LoginPage loginPage = new LoginPage();
        loginPage.loginWithInvalidCredentials();
        Assert.assertTrue(Driver.getDriver().getPageSource().contains("Login Failed"));
    }

    @Test
    public void signUpLinkPresent () {

        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//a[@href]")).isDisplayed());
        Driver.getDriver().findElement(By.xpath("//a[@href]")).click();
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), "http://qa-duobank.us-east-2.elasticbeanstalk.com/register.php");
    }





}
