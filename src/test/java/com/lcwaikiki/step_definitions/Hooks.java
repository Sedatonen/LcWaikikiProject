package com.lcwaikiki.step_definitions;

import com.lcwaikiki.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class Hooks {

    public WebDriver driver;
    public WebDriverWait wait;
    public Actions action;

    @Before
    public void setUp() {
        driver = Driver.get();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        action = new Actions(driver);
        wait = new WebDriverWait(driver, 10);
    }

    @After
    public void tearDown() {
        Driver.closeDriver();
    }
}
