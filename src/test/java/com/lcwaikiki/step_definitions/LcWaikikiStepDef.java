package com.lcwaikiki.step_definitions;

import com.lcwaikiki.pages.*;
import com.lcwaikiki.utilities.*;
import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import static org.junit.Assert.*;

public class LcWaikikiStepDef {
    LoginPage loginPage = new LoginPage();
    SearchPage searchPage = new SearchPage();
    ProductPage productPage = new ProductPage();
    BasketPage basketPage = new BasketPage();
    WebDriver driver;
    WebDriverWait wait = new WebDriverWait(Driver.get(), 20);
    Actions actions = new Actions(Driver.get());
    String choosingProductPrice;
    String basketProductPrice;

    @Given("go to the lcWaikiki homepage")
    public void go_to_the_lc_waikiki_homepage() {
        driver = Driver.get();
        driver.get(ConfigurationReader.get("url"));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[@class='cookie__dismiss']"))).click();
        String expectedUrl = "https://www.lcwaikiki.com/tr-TR/TR";
        String actualUrl = driver.getCurrentUrl();
        assertEquals(expectedUrl, actualUrl);
        System.out.println("verified that the home page lcWaikiki is opened");
    }

    @Given("the user opened the login page")
    public void the_user_opened_the_login_page() {
        loginPage.hoverAndClickLoginBtn();
        BrowserUtils.waitFor(1);
        String expectedUrl = "https://www.lcwaikiki.com/tr-TR/TR/giris";
        String actualUrl = driver.getCurrentUrl();
        assertEquals(expectedUrl, actualUrl);
    }

    @Given("login with valid credentials and login verified")
    public void login_with_valid_credentials_and_login_verified() {
        loginPage.login(ConfigurationReader.get("email"), ConfigurationReader.get("password"));
        BrowserUtils.waitFor(1);
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.lcwaikiki.com/tr-TR/TR";
        assertEquals(expectedUrl, actualUrl);
    }

    @When("in the search area write {string} and click search button")
    public void in_the_search_area_write_and_click_search_button(String product) {
        searchPage.searchProduct(product);
    }

    @When("scroll to end of the page and click to see more products button")
    public void scroll_to_end_of_the_page_and_click_to_see_more_products_button() {
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
        searchPage.seeMoreProductsBtn.click();
    }

    @When("a random product is selected from the result products")
    public void a_random_product_is_selected_from_the_result_products() {
        BrowserUtils.waitFor(2);
        searchPage.choosingRandomProduct();
    }

    @When("choosing product add to basket")
    public void choosing_product_add_to_basket() {
        productPage.addToBasket();
        choosingProductPrice = productPage.choosingProductPrice();
        System.out.println("Seçilen Ürünün Fiyatı : " + choosingProductPrice);
    }

    @Then("click to basket page")
    public void click_to_basket_page() {
        basketPage.basketBtn.click();
    }

    @Then("this product is the same as the product added to favorites")
    public void this_product_is_the_same_as_the_product_added_to_favorites() {

        basketProductPrice = basketPage.basketProductPrice();
        System.out.println("Spetteki Ürünün Fiyatı : " + basketProductPrice);
        assertEquals(choosingProductPrice, basketProductPrice);
        System.out.println("verify product price");
    }

    @Then("verified that the number of products is two by increasing the number.")
    public void Verified_that_the_number_of_products_is_two_by_increasing_the_number() {
        basketPage.addProduct();

    }

    @Then("the product is deleted from the basket and the basket is checked to be empty.")
    public void the_product_is_deleted_from_the_basket_and_the_basket_is_checked_to_be_empty() {
        basketPage.deleteProduct();
        assertEquals(basketPage.nullMessage.getText(), "Sepetinizde ürün bulunmamaktadır.");
        System.out.println(basketPage.nullMessage.getText());
    }
}
