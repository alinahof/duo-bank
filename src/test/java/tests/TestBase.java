package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;
import utils.Driver;

import java.time.Duration;

public class TestBase {

    @BeforeMethod(alwaysRun = true)
    public void setUp(){

        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().get(ConfigReader.getProperty("url"));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){

        Driver.quitDriver();
    }
}
