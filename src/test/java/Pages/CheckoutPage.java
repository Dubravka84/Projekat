package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends BaseTest {

    public CheckoutPage() {
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "first-name")
    public WebElement firstNameField;

    public void inputFirstName(String firstName){
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
    }
    @FindBy(id = "last-name")
    public WebElement lastNameField;

    public void inputLastName(String lastName){
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
    }
    @FindBy(id = "postal-code")
    public WebElement postalCodeField;

    public void inputPostalCode(String postalCode){
        postalCodeField.clear();
        postalCodeField.sendKeys(postalCode);
    }
    @FindBy(id = "continue")
    public WebElement continueButton;

    public void clickOnContinueButton(){
        continueButton.click();
    }
    @FindBy(id = "finish")
    public WebElement finishButton;

    public void clickOnFinishButton(){
        finishButton.click();
    }
    @FindBy(id = "back-to-products")
    public WebElement backToProductsButton;

    @FindBy(className = "title")
    public WebElement title;

    @FindBy(css=".error-message-container.error")
    public WebElement errorMessageCheckOut;

    @FindBy(id = "back-to-products")
    public WebElement backHomeButton;

    public void clickOnBackHomeButton(){
        backHomeButton.click();
    }

}
