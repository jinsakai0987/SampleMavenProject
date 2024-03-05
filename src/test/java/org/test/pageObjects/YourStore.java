package org.test.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.test.drivers.DriverInit;

public class YourStore extends DriverInit {

    @FindBy(xpath = "//input[@placeholder='Search']")
    WebElement search_Field;

    @FindBy(xpath = "//i[@class='fas fa-search']")
    WebElement search_Button;

    public YourStore(WebDriver driver) throws Exception {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterText_searchField(String value){
        search_Field.sendKeys(value);
    }

    public void click_searchButton(){
        search_Button.click();
    }
}
