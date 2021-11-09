package com.lcwaikiki.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProductPage extends BasePage {

    @FindBy(id = "pd_add_to_cart")
    public WebElement addToBasketBtn;

    @FindBy(xpath = "//a[@data-toggle='popover']")
    public List<WebElement> choosingProductSize;

    @FindBy(xpath = "(//div[@class='basket-discount'])[3]")
    public WebElement productPrice;

    public void addToBasket() {
        Random random = new Random();
        int number = choosingProductSize.size();
        number = (number / 2) - 1;
        List<Integer> sizeList = new ArrayList<>();
        for (int i = 0; i <= number; i++) {
            sizeList.add(i, i);
        }

        for (int i = 0; i < number; i++) {
            int randomIndex1 = random.nextInt(sizeList.size());
            int randomElement1 = sizeList.get(randomIndex1);
            choosingProductSize.get(randomElement1).click();
            if (!choosingProductSize.get(randomElement1).isSelected()) {
                sizeList.remove(randomIndex1);
            }
        }


        addToBasketBtn.click();
    }

    public String choosingProductPrice() {
        return productPrice.getText();
    }


}
