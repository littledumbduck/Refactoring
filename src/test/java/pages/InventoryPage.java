package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

 // REFACTOR: Page Object for Inventory to resolve OO Abusers and Bloaters.

public class InventoryPage {
    // Reference to the WebDriver session
    private WebDriver driver;

    // FIXES SMELL 7: Centralized locators for easy maintenance
    // Locates the shopping cart icon to check selection
    private final By cartIcon = By.className("shopping_cart_link");
    // Locates the specific button to add a backpack to the cart
    private final By backpackAddButton = By.id("add-to-cart-sauce-labs-backpack");

    // Constructor to initialize the driver for this page
    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    // FIXES SMELL 5: Specific methods replace rigid Switch Statements for better scalability.
    // Performs a click on the add-to-cart button for the backpack
    public void addBackpackToCart() {
        driver.findElement(backpackAddButton).click();
    }


    // Navigates to the shopping cart page.
    // Clicks on the cart icon to transition to the checkout flow
    public void goToCart() {
        driver.findElement(cartIcon).click();
    }
}

// version 2