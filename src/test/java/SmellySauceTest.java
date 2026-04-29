import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SmellySauceTest {

    // SMELL 1: Temporary Field (OO Abuser)
    private String tempUser;

    @Test
    void completeFlow() throws InterruptedException {
        // SMELL 2: Duplicate Code (Dispensable) - Setup should be in @BeforeEach
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        // SMELL 3: Long Method (Bloater) - This method is too long
        // LOGIN
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        // SMELL 4: Feature Envy (Coupler) - Test is directly managing the page IDs

        // SMELL 5: Switch Statement (OO Abuser) - Replace later to make the code more scalable
        String item = "Backpack";
        switch (item) {
            case "Backpack":
                driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
                break;
            case "Bike Light":
                driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
                break;
        }

        // SMELL 6: Dead Code (Dispensable) - Unused variable
        String unusedVariable = "I am not used";

        // SMELL 7: Divergent Change (Change Preventer) - Logic is mixed with ID, should use a variable instead
        driver.findElement(By.className("shopping_cart_link")).click();

        // ASSERTIONS
        assertTrue(driver.getCurrentUrl().contains("cart.html"));

        // SMELL 8: Duplicate Code (Dispensable) - Teardown should be in @AfterEach
        driver.quit();
    }

    // SMELL 9: Inappropriate Intimacy (Coupler) - Accessing internal logic
    public void secretInternalMethod() {
        System.out.println("Breaking encapsulation");
    }

    // SMELL 10: Large Class (Bloater) - Once we add more tests, this file becomes too big
}
