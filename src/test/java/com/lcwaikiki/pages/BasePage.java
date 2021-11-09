package com.lcwaikiki.pages;

import com.lcwaikiki.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    public void searchProduct(String product){
        searchInput.click();
        searchInput.sendKeys(product);
        searchBtn.click();
    }

    public void hoverAndClickLoginBtn() {
        Actions actions = new Actions(Driver.get());
        actions.moveToElement(scrollLogin).perform();
        loginBtn.click();
    }
    public static void main(String[] args) {
        Random random = new Random();
        int number=6;
        List<Integer> sizelist=new ArrayList<>();
        for (int i=0;i<=number;i++) {
            sizelist.add(i,i);
        }
        for (int i = 0; i < number; i++) {
            int randomIndex = random.nextInt(sizelist.size());
            int randomElement = sizelist.get(randomIndex);
            System.out.println("randomElement = " + randomElement);
            sizelist.remove(randomIndex);
        }
        System.out.println("sizelist = " + sizelist);
    }
}
