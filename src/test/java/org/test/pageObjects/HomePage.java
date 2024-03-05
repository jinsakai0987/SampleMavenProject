package org.test.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.test.drivers.DriverInit;

public class HomePage extends DriverInit{

    @FindBy(xpath = "//button[@onclick='myFunction()']")
    WebElement newBrowserWindow_Button;

    public HomePage(WebDriver driver) throws Exception {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void click_NewBrowserWindow(){
       newBrowserWindow_Button.click();
    }
}
