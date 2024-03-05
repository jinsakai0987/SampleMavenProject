package org.test.testClasses;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.test.drivers.DriverInit;
import org.test.pageObjects.HomePage;
import org.test.pageObjects.YourStore;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class WindowHandlesFeatureTest extends DriverInit {
    HomePage homePage;
    YourStore yourStore;

    @BeforeClass
    public void intializeDriver() throws FileNotFoundException {
        DriverInit.driverInstantiation("Chrome");
    }

    @BeforeMethod(alwaysRun = true)
    public void init_PageObjects() throws Exception {
        homePage = new HomePage(driver);
        yourStore = new YourStore(driver);
    }

    @Test(groups = {"Sanity","smoke"})
    public void windowHandlesTest(){
        homePage.click_NewBrowserWindow();
        String parent = driver.getWindowHandle(); // focus is on parent

        Set<String> s = driver.getWindowHandles();

        Iterator<String> iterator = s.iterator();

        while(iterator.hasNext()){
            String childWindow = iterator.next();

            if(!parent.equals(childWindow)){
                driver.switchTo().window(childWindow);
                Assert.assertEquals(driver.getTitle(),"Your Store");
                yourStore.enterText_searchField("Iphone");
                yourStore.click_searchButton();
                driver.close();
            }
        }
        driver.switchTo().window(parent);
        Assert.assertEquals(driver.getTitle(),"Automation Testing Practice");
        System.out.println("In Parent window");
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        if(ITestResult.FAILURE == result.getStatus()){
            TakesScreenshot ts = (TakesScreenshot) driver;
            File file = ts.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(file,new File(System.getProperty("user.dir") + "\\screenshots\\Test.PNG"));
        }
    }

    @AfterSuite
    public void kill(){
        driver.close();
    }
}
