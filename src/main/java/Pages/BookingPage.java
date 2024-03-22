package Pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BookingPage extends PageBase{
    public BookingPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//input[@placeholder=\"Where are you going?\"]")
    WebElement locationField ;
    @FindBy(xpath = "//button[@data-testid=\"date-display-field-start\"]")
    WebElement startDateBtn;
    @FindBy(xpath = "//button[@data-testid=\"date-display-field-end\"]")
    WebElement endDateBtn;
    @FindBy(xpath = "//button[@aria-label=\"Dismiss sign-in info.\" and @type=\"button\"]")
    WebElement closePopUpBtn;
    @FindBy(xpath = "//span[@data-date=\"2024-04-01\"]")
    WebElement startDateValue;
    @FindBy(xpath = "//span[@data-date=\"2024-04-14\"]")
    WebElement endDateValue;
    @FindBy(xpath = "//button[@aria-label=\"Next month\"]")
    WebElement nextMonthBtn;
    @FindBy(xpath = "//button[@type=\"submit\"]")
    WebElement searchBtn;
    @FindBy(xpath = "//div[@data-testid='title' and text()='Tolip Hotel Alexandria']")
    WebElement hotelName;
    @FindBy(xpath = "//div[@data-testid='title'][contains(text()" +
            ", 'Plaza Hotel Alexandria')]/following-sibling::span[contains(text(), 'See availability')])")
    WebElement availabilityButton;


    public void enterLocation(String location){
        wait.until(ExpectedConditions.elementToBeClickable(locationField)).sendKeys(location);
    }
    public void startDateBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(startDateBtn)).click();
    }
    public void selectStartDate(){
        wait.until(ExpectedConditions.visibilityOf(startDateValue)).click();
    }
    public void closePopUpBtnAndSelectAlex(String location){

        try {
            wait.until(ExpectedConditions.elementToBeClickable(locationField)).sendKeys(location);
            System.out.println("Select Alex without close popup");
        }catch (Exception e){}
    try {
        wait.until(ExpectedConditions.visibilityOf(closePopUpBtn)).click();
        // If popup is displayed, close it
        System.out.println("Closed the popup.");
        wait.until(ExpectedConditions.elementToBeClickable(locationField)).sendKeys(location);
        System.out.println("Closed the popup and select location");
    } catch (Exception e) {
        // If popup is not displayed, click on the button
        System.out.println("Pop up isn't displayed");
    }
    }

    public void selectStartDateValue() {
        while (true) {
            try {
                // If start date value is displayed, click on it
                if (startDateValue.isDisplayed()) {
                    selectStartDate();
                    System.out.println("Clicked on start date 01-04-2024");
                    break; // Exit the loop once start date is clicked
                }
            } catch (org.openqa.selenium.NoSuchElementException e) {
            }
            try {
                // If start date value is not found, click on next month button
                nextMonthBtn.click();
                // Wait for the start date value to be visible
                selectStartDate();
                System.out.println("We found start date");
                break;
            }catch (Exception e){}

            // Check if popup is displayed
            try {
                if (closePopUpBtn.isDisplayed()) {
                    // If popup is displayed, close it
                    closePopUpBtn.click();
                    System.out.println("Closed the popup.");
                }
            } catch (org.openqa.selenium.NoSuchElementException e) {
                // If popup is not found, continue with the loop
            }
        }
    }

public void selectEndDateValue() {
    while (true) {
        try {
            // If start date value is displayed, click on it
            if (endDateValue.isDisplayed()) {
                endDateValue.click();
                System.out.println("Clicked on end date 14-04-2024");
                break; // Exit the loop once start date is clicked
            }
        } catch (org.openqa.selenium.NoSuchElementException e) {

        }
        try {
            // If start date value is not found, click on next month button
            nextMonthBtn.click();
            // Wait for the start date value to be visible
            wait.until(ExpectedConditions.visibilityOf(endDateValue));
        }catch (Exception e){}
    }
}
public void clickSearchBtn()  {
    while (true){
    if (searchBtn.isDisplayed()){searchBtn.click();
        System.out.println("Click search without pop up ");
        break;}
    else if (closePopUpBtn.isDisplayed())
        {closePopUpBtn.click();
        searchBtn.click();
        System.out.println("Click search with pop up");
    break;}
    }



}
    public void findHotel()  {
        boolean hotelFound = false;
        try {
            if (closePopUpBtn.isDisplayed()) {
                // If popup is displayed, close it
                closePopUpBtn.click();
                System.out.println("Closed the popup.");
                hotelFound = true;
            }
        }catch (Exception e){}
        try {
            wait.until(ExpectedConditions.visibilityOf(hotelName));
            hotelFound = true; // If element found, set flag to true
            System.out.println("Hotel is found from first Try");
        } catch (NoSuchElementException e) {
            // If element not found, scroll down by 100 pixels
            System.out.println("Reach to catch 1");
        }

        if (!hotelFound) {
            // Attempt to find the hotelName element again
            try {
                //scrollDownUsingPixel(1000);
                scrollDownUsingPixelJs(1000);
                wait.until(ExpectedConditions.visibilityOf(hotelName)).click();
                System.out.println("Hotel not found! 2");

            } catch (NoSuchElementException e) {
                // If element still not found, scroll down by another 100 pixels
                System.out.println("Still hotelName isn't found 2");
            }
        }

         //If hotel found, wait for it to be visible and then click
        if (hotelFound) {
            wait.until(ExpectedConditions.visibilityOf(hotelName)).click();
            System.out.println("Hotel found 3");
        } else {
            System.out.println("Hotel not found! 3");
        }
    }
    public String hotelTitle(){
        wait.until(ExpectedConditions.visibilityOf(hotelName)).getText();
        return hotelName.getText();
    }

}
