package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


// REFACTOR: This class handles the browser infrastructure to eliminate Duplicate Code.
// It serves as a parent class for all test suites
public class BaseTest {
    protected WebDriver driver;

    @BeforeEach
    public void setUp() {
        // FIXES SMELL 2: Centralized browser setup using WebDriverManager
        // Executed before every test method to ensure a clean browser session
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    public void tearDown() {
        // FIXES SMELL 8: Centralized teardown to ensure the browser closes after every test
        // Executed after every test to free up system resources
        if (driver != null) {
            driver.quit();
        }
    }
}
