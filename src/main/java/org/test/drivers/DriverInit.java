package org.test.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.test.utilities.PropertyTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.io.FileNotFoundException;
import java.io.IOException;

public class DriverInit {

    public static WebDriver driver;

    @BeforeSuite
    public void killDriverInstances() throws IOException {
        Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
    }

    public static void driverInstantiation(String browserName) throws FileNotFoundException {

        if(browserName.equalsIgnoreCase("Chrome")) {

            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe");

            driver = new ChromeDriver(); // Driver Instantiation

            driver.get(PropertyTest.getUrlProperty("url"));

            driver.manage().window().maximize();

        } else if(browserName.equalsIgnoreCase("Firefox")){

            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe");

            driver = new FirefoxDriver() ;// Driver Instantiation

            driver.get(PropertyTest.getUrlProperty("url"));

            driver.manage().window().maximize();

        } else if (browserName.equalsIgnoreCase("edge")){

            System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe");

            driver = new EdgeDriver();// Driver Instantiation

            driver.get(PropertyTest.getUrlProperty("url"));

            driver.manage().window().maximize();
        }
    }
}
