package Tests;

import Base.BaseTest;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class ProductsTests extends BaseTest {

    @BeforeMethod
    public void pageSetUp(){
        driver.navigate().to("https://www.saucedemo.com/");
        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickOnLoginButton();
    }

    @Test
    public void hamburgerMenuCanBeOpenedAndClosed() throws InterruptedException {
        productsPage.clickOnHamburgerMenu();
        Thread.sleep(3000);
        productsPage.clickOnHamburgerCloseButton();
        Assert.assertTrue(!productsPage.aboutButton.isDisplayed());
        Assert.assertTrue(!productsPage.hamburgerCloseButton.isDisplayed());
    }

    @Test
    public void userCanChooseAboutPageFromTheHamburgerMenu() {
        productsPage.clickOnHamburgerMenu();
        productsPage.clickOnAboutButton();
        String expectedURL = "https://saucelabs.com/";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL,expectedURL);

    }
    @Test
    public void  userCanLogout(){
        productsPage.clickOnHamburgerMenu();
        productsPage.clickOnLogout();
        String expectedURL = "https://www.saucedemo.com/";
        String actualURL = driver.getCurrentUrl();
        Assert.assertTrue(loginPage.loginButton.isDisplayed());
        Assert.assertEquals(actualURL,expectedURL);
    }

    //-------------

    @Test
    public void userCanSeeDetailsAboutProductsByClickingOnThePhotoOrTitle(){
        productsPage.clickOnBackpack();
        Assert.assertTrue(productsPage.backPackDescription.isDisplayed());
        Assert.assertTrue(productsPage.back.isDisplayed());
    }
    @Test
    public void addAndRemoveAllProductsToCart() throws InterruptedException {
        productsPage.clickOnAddButton();
        Assert.assertTrue(productsPage.quantity.getText().equals("6"));
        Thread.sleep(3000);
        productsPage.clickOnRemoveButton();
        boolean isPresent=false;
        try{
            isPresent=productsPage.quantity.isDisplayed();
        }catch(Exception e){
        }
        Assert.assertFalse(isPresent);
    }
    @Test
    public void userCanOrderTwoOfTheSameProducts(){
        productsPage.clickOnAddBackpack();
        Assert.assertTrue(productsPage.quantity.getText().equals("1"));
        productsPage.clickOnAddBackpack();
        Assert.assertTrue(productsPage.quantity.getText().equals("2"));
    }
    @Test
    public void userCanResetAppState(){
        productsPage.clickOnAddBackpack();
        Assert.assertTrue(productsPage.cartCounter.getText().equals("1"));
        productsPage.clickOnHamburgerMenu();
        productsPage.clickOnResetButton();
        boolean isPresent = false;
        try{
            isPresent = productsPage.cartCounter.isDisplayed();
        }catch(Exception e){
        }
        Assert.assertFalse(isPresent);
    }
    @Test
    public void redirectToTwitter() throws InterruptedException {
        productsPage.clickOnTwitter();
        Thread.sleep(5000);
        ArrayList<String>listTabova = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window((listTabova.get(1)));
        String expectedURL = "https://x.com/saucelabs";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL,expectedURL);
    }
    @Test
    public void redirectToFacebook() throws InterruptedException {
        productsPage.clickOnFacebook();
        Thread.sleep(3000);
        ArrayList<String>listTabova = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window((listTabova.get(1)));
        String expectedURL = "https://www.facebook.com/saucelabs";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL,expectedURL);
    }
    @Test
    public void redirectToLinkedIn() throws InterruptedException {
        productsPage.clickOnLinkedIn();
        Thread.sleep(3000);
        ArrayList<String>listTabova = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window((listTabova.get(1)));
        String expectedURL = "https://www.linkedin.com/company/sauce-labs/";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL,expectedURL);
    }







}
