package com.lcwaikiki.pages;

import com.lcwaikiki.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//span[text()='Giriş Yap']")
    public WebElement scrollLogin;

    @FindBy(className = "bg-blue")
    public WebElement loginBtn;

    @FindBy(id = "search_input")
    public WebElement searchInput;

    @FindBy(className = "searchButton")
    public WebElement searchBtn;

    @FindBy(xpath = "//div[text()='Sepetim']")
    public WebElement basketBtn;

    public void searchProduct(String product) {
        searchInput.click();
        searchInput.sendKeys(product);
        searchBtn.click();
    }

    public void hoverAndClickLoginBtn() {
        Actions actions = new Actions(Driver.get());
        actions.moveToElement(scrollLogin).perform();
        loginBtn.click();
    }
}
