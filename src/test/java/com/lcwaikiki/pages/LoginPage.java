package com.lcwaikiki.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(id = "LoginEmail")
    public WebElement emailInput;

    @FindBy(id = "Password")
    public WebElement passwordInput;

    @FindBy(id = "loginLink")
    public WebElement loginBtn;

    public void login(String email,String password){
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }
}
