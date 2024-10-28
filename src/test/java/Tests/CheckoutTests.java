package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckoutTests extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to("https://www.saucedemo.com/");
        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickOnLoginButton();
        productsPage.clickOnAddBackpack();
        productsPage.clickOnCart();
        cartPage.clickOnCheckoutButton();
    }
    @Test
    public void orderProduct(){
        checkoutPage.inputFirstName("Dubravka");
        checkoutPage.inputLastName("Soskic");
        checkoutPage.inputPostalCode("11070");
        checkoutPage.clickOnContinueButton();
        checkoutPage.clickOnFinishButton();
        Assert.assertTrue(checkoutPage.backToProductsButton.isDisplayed());
        Assert.assertTrue(checkoutPage.title.getText().equals("Checkout: Complete!"));
    }
    @Test
    public void userCannotProceedShoppingWithFirstNameFieldEmpty(){
        checkoutPage.inputFirstName("");
        checkoutPage.inputLastName("Soskic");
        checkoutPage.inputPostalCode("11070");
        checkoutPage.clickOnContinueButton();
        Assert.assertTrue
                (checkoutPage.errorMessageCheckOut.getText().equals("Error: First Name is required"));
        Assert.assertTrue(checkoutPage.continueButton.isDisplayed());
    }
    @Test
    public void userCannotProceedShoppingWithLastNameFieldEmpty(){
        checkoutPage.inputFirstName("Dubravka");
        checkoutPage.inputLastName("");
        checkoutPage.inputPostalCode("11070");
        checkoutPage.clickOnContinueButton();
        Assert.assertTrue
                (checkoutPage.errorMessageCheckOut.getText().equals("Error: Last Name is required"));
        Assert.assertTrue(checkoutPage.continueButton.isDisplayed());
    }
    @Test
    public void userCannotProceedShoppingWithZipFieldEmpty(){
        checkoutPage.inputFirstName("Dubravka");
        checkoutPage.inputLastName("Soskic");
        checkoutPage.inputPostalCode("");
        checkoutPage.clickOnContinueButton();
        Assert.assertTrue
                (checkoutPage.errorMessageCheckOut.getText().equals("Error: Postal Code is required"));
        Assert.assertTrue(checkoutPage.continueButton.isDisplayed());
    }
    @Test
    public void userCannotProceedShoppingWithAllFieldsEmpty(){
        checkoutPage.inputFirstName("");
        checkoutPage.inputLastName("");
        checkoutPage.inputPostalCode("");
        checkoutPage.clickOnContinueButton();
        Assert.assertTrue
                (checkoutPage.errorMessageCheckOut.getText().equals("Error: All field are required"));
        Assert.assertTrue(checkoutPage.continueButton.isDisplayed());
    }


}
