package com.lcwaikiki.pages;

import com.lcwaikiki.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasketPage extends BasePage {

    @FindBy(className = "rd-cart-item-price")
    public WebElement basketProductPrice;

    @FindBy(className = "oq-up")
    public WebElement addProductBtn;

    @FindBy(className = "item-quantity-input")
    public WebElement productQuantity;

    @FindBy(className = "fa-trash-o")
    public WebElement deleteProductBtn;

    @FindBy(className = "sc-delete")
    public WebElement confirmDeleteProductBtn;

    @FindBy(className = "cart-empty-title")
    public WebElement nullMessage;


    public String basketProductPrice() {
        return basketProductPrice.getText();
    }

    public void addProduct() {
        addProductBtn.click();
        if (productQuantity.getAttribute("value").contains("1")) {
            System.out.println("Ürün arttırılamaz");
        }
        BrowserUtils.waitFor(1);
        System.out.println("Ürün Adedi : "+productQuantity.getAttribute("value"));

    }


    public void deleteProduct() {
        BrowserUtils.waitForClickablility(deleteProductBtn, 5);
        deleteProductBtn.click();
        BrowserUtils.waitForClickablility(confirmDeleteProductBtn, 5);
        confirmDeleteProductBtn.click();

    }


}
