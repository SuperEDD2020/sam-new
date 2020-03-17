package com.build.qa.build.selenium.pageobjects.Cart;

import com.build.qa.build.selenium.pageobjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

public class CartPage extends BasePage {

    @FindBy (css = "div.product-header__title.lh-title")
    private WebElement productTitle;

    @FindBy (css = "div.dropdown-container")
    private WebElement cartDropDown;

    @FindBy (css = "div.di")
    private WebElement emailCart;

    @FindBy (css = "input#yourName")
    private WebElement nameField;

    @FindBy (css = "input#yourEmail")
    private WebElement emailField;

    @FindBy (css = "input#recipientName")
    private WebElement recipientNameField;

    @FindBy (css = "input#recipientEmail")
    private WebElement recipientEmailField;

    @FindBy (css = "textarea#quoteMessage")
    private WebElement messageField;

    @FindBy (css = "button.js-email-cart-submit-button")
    private WebElement sendMailBtn;

    @FindBy (css = "li.theme-success")
    private WebElement confirmationMessage;


    public CartPage(WebDriver driver, Wait<WebDriver> wait) {
        super(driver, wait);
    }

    public void openCartDropDown(){
        wait.until(ExpectedConditions.elementToBeClickable(cartDropDown));
        cartDropDown.click();
    }

    public void openEmailCartForm(){
        wait.until(ExpectedConditions.elementToBeClickable(emailCart));
        emailCart.click();
    }


    public void setYourName(String name){
        wait.until(ExpectedConditions.elementToBeClickable(nameField));
        nameField.sendKeys(name);
    }

    public void setEmailField(String email){
        emailField.sendKeys(email);
    }

    public void setRecipientName(String name){
        recipientNameField.sendKeys(name);
    }

    public void setRecipientEmail(String email){
        recipientEmailField.sendKeys(email);
    }

    public void setMessage(String message){
        messageField.sendKeys(message);
    }

    public boolean emailIsSent(){

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("li.theme-success")));
        String s = confirmationMessage.getText();

        return s.contains("Cart Sent! The cart has been submitted to the recipient via email.");
    }

    public boolean productInCart(String productName) {
        String[] s = productTitle.getText().split("\n");
        return s[0].contains(productName);
    }

    public void sendCart() {
        sendMailBtn.click();
    }
}
