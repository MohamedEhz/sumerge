import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver;
    ConfigFile configurationFile;
    // this method will run before each suite
    @BeforeSuite
    public void startDriver() throws IOException {
        configurationFile = new ConfigFile();
        // Directly initialize ChromeDriver
        System.setProperty("webdriver.chrome.driver", configurationFile.ChromeDriverPath);
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get(configurationFile.WebsiteURL);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL: " + currentUrl);
    }
    // this method will run after each suite
    @AfterSuite(enabled = false)
    public void StopDriver()
    {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.quit();
    }

}
