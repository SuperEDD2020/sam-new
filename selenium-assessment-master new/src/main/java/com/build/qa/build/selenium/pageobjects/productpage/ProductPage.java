package com.build.qa.build.selenium.pageobjects.productpage;

import com.build.qa.build.selenium.pageobjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

public class ProductPage extends BasePage {

    @FindBy (css = "button.add-to-cart")
    private WebElement addToCartBtn;

    @FindBy (css = "span.lh-title-ns")
    private WebElement productName;

    public void addProductToCart(){
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.add-to-cart")));
        addToCartBtn.click();
    }

    public String getProductName(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span.lh-title-ns")));
        return productName.getText();
    }

    public ProductPage(WebDriver driver, Wait<WebDriver> wait) {
        super(driver, wait);
    }
}
