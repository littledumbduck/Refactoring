package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// REFACTOR: Page Object for Login to fix Feature Envy and Divergent Change.

public class LoginPage {
    // Reference to the WebDriver instance shared across tests
    private WebDriver driver;

    // FIXES SMELL 7: Encapsulated locators avoid hardcoded IDs in the test logic
    // Locators for the login credentials and submit button
    private final By userInput = By.id("user-name");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.id("login-button");

    // Constructor to link the driver to the login page context
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    // FIXES SMELL 4: Performs the login action, hiding implementation details from the test.
    // Inputs user data and clicks the login button to authenticate
    public void login(String user, String pass) {
        driver.findElement(userInput).sendKeys(user);
        driver.findElement(passwordInput).sendKeys(pass);
        driver.findElement(loginButton).click();
    }
}

// version 2