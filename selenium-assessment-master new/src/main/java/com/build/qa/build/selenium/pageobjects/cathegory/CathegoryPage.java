package com.build.qa.build.selenium.pageobjects.cathegory;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import com.build.qa.build.selenium.pageobjects.BasePage;

import java.util.List;


public class CathegoryPage extends BasePage {
    @FindBy (css = "#product-composite-1240319 > div")
    private WebElement secondProduct;

    @FindBy (css = "#email-subscribe-splash > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > " +
            "button:nth-child(2) > span:nth-child(1) > svg:nth-child(1)")
    private WebElement closeAdBtn;

    @FindBy (css = "a[data-automation='chrome-tones']")
    private WebElement chromeFinishFilter;

    @FindBy (css = "a[data-automation='construct-tab']")
    private List<WebElement> constructTab;

    @FindBy (css = "li[data-groupname='Theme'] > div > span.js-group-display-name")
    private WebElement themeFilter;

    @FindBy (css = "label[data-facet-value='Modern'][data-facet-group='Theme']")
    private WebElement modernThemeFilter;

    @FindBy (css = "div.js-selected-facets.theme-accent")
    private List<WebElement> enabledFilters;

    public CathegoryPage(WebDriver driver, Wait<WebDriver> wait) {
        super(driver, wait);
    }

    public void goToProductPage(){
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#product-composite-1240319 > div")));
        secondProduct.click();
    }

    public void closeAd(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div#newsletter-modal")));
        closeAdBtn.click();
    }

    public void openFinishFilter(){
        constructTab.get(1).click();
    }

    public void addFinishFilter(){
        chromeFinishFilter.click();
    }


    public void openThemeFilter(){
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[data-groupname='Theme'] > div > " +
                "span.js-group-display-name")));
        driver.findElement(By.cssSelector("li[data-groupname='Theme'] > div > span.js-group-display-name")).click();
    }

    public void addModernThemeFilter(){
        wait.until(ExpectedConditions.elementToBeClickable(modernThemeFilter));
        modernThemeFilter.click();
    }


    public boolean modernFilterIsOn(){

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span[data-automation='limit-facet-item']")));
        List<WebElement> list = driver.findElements(By.cssSelector("span[data-automation='limit-facet-item']"));
        return list.get(1).getText().equalsIgnoreCase("\"Modern\"");
    }

    public boolean chromeFilterIsOn(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span[data-automation='limit-facet-item']")));
        List<WebElement> list = driver.findElements(By.cssSelector("span[data-automation='limit-facet-item']"));
        String s = list.get(0).getText();
        String z = list.get(1).getText();
        return list.get(0).getText().equalsIgnoreCase("\"chromes\"");
    }

    public boolean goToProductPage(String productName) {
        return productName.equalsIgnoreCase(driver.getTitle());
    }
}
