package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EndToEndTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to("https://www.saucedemo.com/");
    }
    @Test
    public void userCanSuccessfullyOrderTheProduct() {
        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickOnLoginButton();
        Assert.assertTrue(productsPage.cart.isDisplayed());
        productsPage.clickOnAddBackpack();
        Assert.assertTrue(productsPage.quantity.getText().equals("1"));
        productsPage.clickOnCart();
        Assert.assertTrue(cartPage.cartTitle.getText().equals("Your Cart"));
        cartPage.clickOnCheckoutButton();
        Assert.assertTrue(checkoutPage.title.getText().equals("Checkout: Your Information"));
        checkoutPage.inputFirstName("Dubravka");
        checkoutPage.inputLastName("Soskic");
        checkoutPage.inputPostalCode("11070");
        checkoutPage.clickOnContinueButton();
        Assert.assertTrue(checkoutPage.title.getText().equals("Checkout: Overview"));
        checkoutPage.clickOnFinishButton();
        Assert.assertTrue(checkoutPage.title.getText().equals("Checkout: Complete!"));
        checkoutPage.clickOnBackHomeButton();
        String expectedURL = "https://www.saucedemo.com/inventory.html";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL,expectedURL);
        productsPage.clickOnHamburgerMenu();
        productsPage.clickOnLogout();
        Assert.assertTrue(loginPage.loginButton.isDisplayed());
        Assert.assertTrue(loginPage.usernameField.isDisplayed());
        Assert.assertTrue(loginPage.passwordField.isDisplayed());
    }
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
}
