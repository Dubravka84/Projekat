package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to("https://www.saucedemo.com/");
    }

    @Test
    public void userCanLoginWithValidCredentials() {
        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickOnLoginButton();
        String expectedURL = "https://www.saucedemo.com/inventory.html";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL);
        Assert.assertTrue(productsPage.cart.isDisplayed());
    }

    @Test
    public void userCannotLoginWithValidUsernameAndInvalidPassword() {
        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("Dubravka");
        loginPage.clickOnLoginButton();
        Assert.assertTrue(loginPage.loginButton.isDisplayed());
        Assert.assertTrue(loginPage.errorMessage.getText().equals
                ("Epic sadface: Username and password do not match any user in this service"));
    }

    @Test
    public void userCannotLoginWithInvalidUsernameAndValidPassword() {
        loginPage.inputUsername("Dubravka");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickOnLoginButton();
        Assert.assertTrue(loginPage.loginButton.isDisplayed());
        Assert.assertTrue(loginPage.errorMessage.getText().equals
                ("Epic sadface: Username and password do not match any user in this service"));
    }

    @Test
    public void userCannotLoginWithUsernameTextFieldEmpty() {
        loginPage.inputUsername("");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickOnLoginButton();
        Assert.assertTrue(loginPage.loginButton.isDisplayed());
        Assert.assertTrue(loginPage.errorMessage.getText().equals
                ("Epic sadface: Username is required"));
    }

    @Test
    public void userCannotLoginWithPasswordTextFieldEmpty() {
        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("");
        loginPage.clickOnLoginButton();
        Assert.assertTrue(loginPage.loginButton.isDisplayed());
        Assert.assertTrue(loginPage.errorMessage.getText().equals
                ("Epic sadface: Password is required"));
    }

    @Test
    public void userCannotLoginWithBothTextFieldsEmpty(){
        loginPage.inputUsername("");
        loginPage.inputPassword("");
        loginPage.clickOnLoginButton();
        Assert.assertTrue(loginPage.loginButton.isDisplayed());
        Assert.assertTrue(loginPage.errorMessage.getText().equals
                ("Epic sadface: All text fields are required"));
    }
   @Test
    public void userCanLoginWithAllValidUsernamesAndPassword() throws InterruptedException {
        for (int i = 1; i<=excelReader.getLastRow("Sheet1");i++){
            String validUsername = excelReader.getStringData("Sheet1",i,0);
            String validPassword = excelReader.getStringData("Sheet1",1,1);
            loginPage.inputUsername(validUsername);
            loginPage.inputPassword(validPassword);
            Thread.sleep(3000);
            loginPage.clickOnLoginButton();
            String expectedURL = "https://www.saucedemo.com/inventory.html";
            String actualURL = driver.getCurrentUrl();
            Assert.assertEquals(actualURL, expectedURL);
            driver.navigate().back();
        }

    }


}
