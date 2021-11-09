package com.lcwaikiki.pages;

import com.github.javafaker.Faker;
import com.lcwaikiki.utilities.BrowserUtils;
import com.lcwaikiki.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends BasePage {
    @FindBy(className = "lazy-load-text")
    public WebElement seeMoreProductsBtn;

    @FindBy(css = "div.info")
    public List<WebElement> products;

    public void choosingRandomProduct() {
        Faker faker = new Faker();
        int number = faker.random().nextInt(0, 95);
        Actions actions = new Actions(Driver.get());
        actions.moveToElement(products.get(number)).perform();
        BrowserUtils.waitForVisibility(products.get(number), 5);
        products.get(number).click();
    }
}
