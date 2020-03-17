package com.build.qa.build.selenium.tests;

import com.build.qa.build.selenium.pageobjects.Cart.CartPage;
import com.build.qa.build.selenium.pageobjects.cathegory.CathegoryPage;
import com.build.qa.build.selenium.pageobjects.productpage.ProductPage;
import com.build.qa.build.selenium.pageobjects.search.SearchResultsPage;
import org.junit.Test;

import com.build.qa.build.selenium.framework.BaseFramework;
import com.build.qa.build.selenium.pageobjects.homepage.HomePage;

public class BuildTest extends BaseFramework {

	/**
	 * Extremely basic test that outlines some basic
	 * functionality and page objects as well as assertJ
	 */
	@Test
	public void navigateToHomePage() {
		driver.get(getConfiguration("HOMEPAGE"));
		HomePage homePage = new HomePage(driver, wait);

		softly.assertThat(homePage.onBuildTheme())
			.as("The website should load up with the Build.com desktop theme.")
			.isTrue();
	}

	/**
	 * Search for the Quoizel MY1613 from the search bar
	 * @assert: That the product page we land on is what is expected by checking the product title
	 * @difficulty Easy
	 */
	@Test
	public void searchForProductLandsOnCorrectProduct() {
	    String productName = "Quoizel MY1613";
		driver.get(getConfiguration("HOMEPAGE"));
		HomePage homePage = new HomePage(driver, wait);
		homePage.closeAd();
		homePage.searchFromSearchBar(productName);
		SearchResultsPage searchResultsPage = new SearchResultsPage(driver, wait);
		softly.assertThat(searchResultsPage.pageTitle(productName))
				.as("Product page should have title of product name - Quoizel MY1613.")
				.isTrue();
	}

	/**
	 * Go to the Bathroom Sinks category directly (https://www.build.com/bathroom-sinks/c108504)
	 * and add the second product on the search results (Category Drop) page to the cart.
	 * @assert: the product that is added to the cart is what is expected
	 * @difficulty Easy-Medium
	 */
	@Test
	public void addProductToCartFromCategoryDrop() {
		// TODO: Implement this test
		driver.get(getConfiguration("Bathroom Sinks"));
		CathegoryPage cathegoryPage = new CathegoryPage(driver, wait);
		cathegoryPage.closeAd();

		cathegoryPage.goToProductPage();
		ProductPage productPage = new ProductPage(driver, wait);
		String productName = productPage.getProductName();
		productPage.addProductToCart();
		CartPage cartPage = new CartPage(driver, wait);
		softly.assertThat(cartPage.productInCart(productName))
				.as("Product should be in cart.")
				.isTrue();
	}

	/**
	 * Add a product to the cart and email the cart to yourself, also to my email address: test.automation+SeleniumTest@build.com
	 * Include this message in the "message field" of the email form: "This is {yourName}, sending you a cart from my automation!"
	 * @assert that the "Cart Sent" success message is displayed after emailing the cart
	 * @difficulty Medium-Hard
	 */
	@Test
	public void addProductToCartAndEmailIt() {
		// TODO: Implement this test
		driver.get(getConfiguration("Bathroom Sinks"));
		CathegoryPage cathegoryPage = new CathegoryPage(driver, wait);
		cathegoryPage.closeAd();
		cathegoryPage.goToProductPage();
		ProductPage productPage = new ProductPage(driver, wait);
		String productName = productPage.getProductName();
		productPage.addProductToCart();
		CartPage cartPage = new CartPage(driver, wait);

		cartPage.openCartDropDown();
		cartPage.openEmailCartForm();
		cartPage.setYourName("Name");
		cartPage.setEmailField("email@email.com");
		cartPage.setRecipientName("Name");
		cartPage.setRecipientEmail("test.automation+SeleniumTest@build.com");
		cartPage.setMessage("This is {yourName}, sending you a cart from my automation!");
		cartPage.sendCart();
		softly.assertThat(cartPage.emailIsSent())
				.as("Cart should be mailed.")
				.isTrue();

	}

	/**
	 * Go to a category drop page (such as Bathroom Faucets) and narrow by
	 * at least two filters (facets), e.g: Finish=Chromes and Theme=Modern
	 * @assert that the correct filters are being narrowed, and the result count
	 * is correct, such that each facet selection is narrowing the product count.
	 * @difficulty Hard
	 */

	@Test
	public void facetNarrowBysResultInCorrectProductCounts() {
		// TODO: Implement this test
		driver.get(getConfiguration("Bathroom Faucets"));
		CathegoryPage cathegoryPage = new CathegoryPage(driver, wait);
		cathegoryPage.closeAd();

		cathegoryPage.openFinishFilter();
		cathegoryPage.addFinishFilter();
		cathegoryPage.openThemeFilter();
		cathegoryPage.addModernThemeFilter();
		softly.assertThat(cathegoryPage.chromeFilterIsOn())
				.as("Chrome finish filter is off")
				.isTrue();
		softly.assertThat(cathegoryPage.modernFilterIsOn())
				.as("Modern theme filter is off")
				.isTrue();

	}
}
