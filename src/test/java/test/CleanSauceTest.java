package test;

import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.InventoryPage;
import static org.junit.jupiter.api.Assertions.assertTrue;

 // REFACTOR: Final clean test inheriting from BaseTest to avoid boilerplate code.
 // This class fixes SMELL 10 (Large Class) by delegating responsibilities.
public class CleanSauceTest extends BaseTest {

    @Test
    void testSuccessfulPurchaseFlow() {
        // Initializing Page Objects with the shared driver instance from BaseTest
        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = new InventoryPage(driver);

        // FIXES SMELL 3: The test flow is now concise and uses descriptive method names
        // Navigate to the base URL of the store
        driver.get("https://www.saucedemo.com/");

        // Execute clean business logic
        loginPage.login("standard_user", "secret_sauce");

        // Interact with the inventory and proceed to the cart
        inventoryPage.addBackpackToCart();
        inventoryPage.goToCart();

        // Final validation: Ensure navigation was successful
        assertTrue(driver.getCurrentUrl().contains("cart.html"));
    }
}