package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductsPage extends BaseTest {

    public ProductsPage() {
        PageFactory.initElements(driver, this);
    }

    // hamburger menu

    @FindBy(id = "react-burger-menu-btn")
    public WebElement hamburgerMenu;

    public void clickOnHamburgerMenu() {
        hamburgerMenu.click();
    }
    @FindBy(id = "about_sidebar_link")
    public WebElement aboutButton;

    public void clickOnAboutButton() {
        aboutButton.click();
    }
    @FindBy(id = "logout_sidebar_link")
    public WebElement logoutButton;

    public void clickOnLogout() {
        logoutButton.click();
    }
    @FindBy(id = "react-burger-cross-btn")
    public WebElement hamburgerCloseButton;

    public void clickOnHamburgerCloseButton() {
        hamburgerCloseButton.click();
    }
    @FindBy(className="shopping_cart_badge")
    public WebElement cartCounter;

    @FindBy(id = "reset_sidebar_link")
    public WebElement resetButton;

    public void clickOnResetButton(){
        resetButton.click();
    }

    //---CART ------------------

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    public WebElement addToCartBackpack;

    public void clickOnAddBackpack() {
        addToCartBackpack.click();
    }

    @FindBy(id = "shopping_cart_container")
    public WebElement cart;

    public void clickOnCart() {
        cart.click();
    }
    @FindBy(id = "item_4_title_link")
    public WebElement backPack;

    public void clickOnBackpack(){
        backPack.click();
    }
    @FindBy(css = ".inventory_details_desc.large_size")
    public WebElement backPackDescription;

    @FindBy(id = "back-to-products")
    public WebElement back;

    //------------------------------
    @FindBy(css = ".btn.btn_primary.btn_small.btn_inventory ")
    public List<WebElement> addButton;

    public void clickOnAddButton(){
        for(int i=addButton.size()-1;i>=0;i--){
            addButton.get(i).click();
        }
    }
    @FindBy(css=".btn.btn_secondary.btn_small.btn_inventory ")
    public List<WebElement> removeButton;

    public void clickOnRemoveButton(){
        for(int i = removeButton.size()-1;i>=0; i--){
            removeButton.get(i).click();
        }
    }
    @FindBy(className = "shopping_cart_badge")
    public WebElement quantity;

    //-----------------
    @FindBy(linkText = "Twitter")
    public WebElement twitter;

    public void clickOnTwitter(){
        twitter.click();
    }
    @FindBy(linkText = "Facebook")
    public WebElement facebook;

    public void clickOnFacebook(){
        facebook.click();
    }
    @FindBy(linkText = "LinkedIn")
    public WebElement linkedIn;

    public void clickOnLinkedIn(){
        linkedIn.click();
    }
    @FindBy(id = "title")
    public WebElement title;













}
