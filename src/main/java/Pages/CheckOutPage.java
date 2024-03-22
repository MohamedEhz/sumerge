package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutPage extends PageBase{
    public CheckOutPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "(//span[text()='Mon, Apr 1, 2024'])[1]")
    WebElement savedCheckInValue;
    @FindBy(xpath = "(//span[text()='Sun, Apr 14, 2024'])[1]")
    WebElement savedCheckOutValue;
    public String getSavedCheckInValue(){
        savedCheckInValue.getText();
        return savedCheckInValue.getText();
    }
    public String getSavedCheckOutValue(){
        savedCheckOutValue.getText();
        return savedCheckOutValue.getText();
    }
}
