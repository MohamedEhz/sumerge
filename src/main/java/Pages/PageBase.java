package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.Set;

public class PageBase {
    public Wait<WebDriver> wait;
    protected WebDriver driver;
    public JavascriptExecutor js;
    // Create Contractor
    public PageBase(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
        this.wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);

    }
    public void scrollDownToElement(WebElement element) {
        new Actions(driver).moveToElement(element).perform();
    }

    public void scrollDownUsingPixel(int pixels) {
        new Actions(driver).moveByOffset(10, pixels).perform();
    }

    public void scrollDownUsingPixelJs(int pixels) {
        if (driver instanceof JavascriptExecutor) {
            js.executeScript("window.scrollBy(0," + pixels + ")");
        }
    }
//    public void switchToNewPage(){
//        String firstTab = null;
//        String secondTab = driver.getWindowHandle();
//        for (String handle : driver.getWindowHandles()) {
//            if (!handle.equals(firstTab)) {
//                secondTab = handle;
//                break;
//            }
//        }
//
//        // Switch to the second tab
//        driver.switchTo().window(secondTab);
//        System.out.println("The secound tab is opened");
//
//        // Switch back to the first tab
//        driver.switchTo().window(firstTab);
//    }
public void switchToNewPage() {
    // Get the current window handle
    String mainWindowHandle = driver.getWindowHandle();

    // Get all window handles
    Set<String> allWindowHandles = driver.getWindowHandles();

    // Iterate through all handles
    for (String handle : allWindowHandles) {
        if (!handle.equals(mainWindowHandle)) {
            // Switch to the new window
            driver.switchTo().window(handle);
            System.out.println("Switched to new window");
            break;
        }
    }
}

}
