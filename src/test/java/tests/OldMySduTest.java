import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class OldMySduTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Set up the WebDriver
        driver = new ChromeDriver();
    }

    @Test
    public void testLogin() {
        // Open the website
        driver.get("https://oldmy.sdu.edu.kz");

        // Enter login credentials
        WebElement usernameInput = driver.findElement(By.id("username"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.name("LogIn"));

        usernameInput.sendKeys("200103472");
        passwordInput.sendKeys("kama6281440");
        loginButton.click();

        // Verify successful login
        WebElement welcomeMessage = driver.findElement(By.xpath("//*[@id=\"divModule\"]/div[1]"));
        Assert.assertTrue(welcomeMessage.isDisplayed(), "Login failed!");
    }

    @AfterMethod
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
