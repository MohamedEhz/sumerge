package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TolipHotelPage extends PageBase{
    public TolipHotelPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//h2[contains(@class, 'pp-header')]")
    WebElement tolipHotelTitle;
    @FindBy(xpath = "//span[contains(@class, 'reservation-button')]")
    WebElement reserveBtn;
    @FindBy(xpath = "(//div[contains(@class,'bed-types-wrappe')]//input[@type='radio'])[2]")
    WebElement bedRadioBtn;
    @FindBy(xpath = "//select[@class='hprt-nos-select js-hprt-nos-select']/option[2]")
    WebElement selectFirstValue;
    @FindBy(xpath = "(//select[contains(@id,'hprt_nos_select')])[1]")
    WebElement selectList;
    public void hotelIsOpened()  {
        switchToNewPage();
            wait.until(ExpectedConditions.visibilityOf(tolipHotelTitle));
            System.out.println("Hotel is opened");
    }
    public String setTolipHotelTitle(){
        wait.until(ExpectedConditions.visibilityOf(tolipHotelTitle));
        return tolipHotelTitle.getText();
    }
    public void clickReserveBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(reserveBtn)).click();
    }
    public void clickBedRadioBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(bedRadioBtn)).click();
    }
    public void clickOnSelectList(){
        wait.until(ExpectedConditions.elementToBeClickable(selectList)).click();
    }

    public void setSelectFirstValue(){
        wait.until(ExpectedConditions.visibilityOf(selectFirstValue)).click();
    }

}
