package com.build.qa.build.selenium.pageobjects.search;

import com.build.qa.build.selenium.pageobjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

public class SearchResultsPage extends BasePage {


    public SearchResultsPage(WebDriver driver, Wait<WebDriver> wait) {
        super(driver, wait);
    }

    public boolean pageTitle(String productName) {
        return productName.equalsIgnoreCase(driver.getTitle());
    }
}