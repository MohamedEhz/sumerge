import Pages.BookingPage;
import Pages.CheckOutPage;
import Pages.PageBase;
import Pages.TolipHotelPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Tests extends TestBase{
    BookingPage bookingPage;
    TestData testData;
    TolipHotelPage tolipHotelPage;
    CheckOutPage checkOutPage;
    PageBase pageBase;

    @Test
public void test(){
        bookingPage = new BookingPage(driver);
        tolipHotelPage= new TolipHotelPage(driver);
        checkOutPage = new CheckOutPage(driver);
        testData = new TestData();
        bookingPage.closePopUpBtnAndSelectAlex(testData.locationValue);
        bookingPage.startDateBtn();
        bookingPage.selectStartDateValue();
        bookingPage.selectEndDateValue();
        bookingPage.clickSearchBtn();
        //Assert tolip hotel is displayed in search
        Assert.assertEquals(bookingPage.hotelTitle(),"Tolip Hotel Alexandria");
        bookingPage.findHotel();
        tolipHotelPage.hotelIsOpened();
        //Assert hotel name page is tolip hotel alex
        Assert.assertEquals(tolipHotelPage.setTolipHotelTitle(),
                "Tolip Hotel Alexandria");
        System.out.println("The hotel title is "+tolipHotelPage.setTolipHotelTitle()
                +" Tolip Hotel Alexandria");
        tolipHotelPage.clickBedRadioBtn();
        tolipHotelPage.clickOnSelectList();
        tolipHotelPage.setSelectFirstValue();
        tolipHotelPage.clickReserveBtn();
        //Assert Check-in and Check-out is saved correctly
        Assert.assertEquals(checkOutPage.getSavedCheckInValue(),"Mon, Apr 1, 2024");
        Assert.assertEquals(checkOutPage.getSavedCheckOutValue(),"Sun, Apr 14, 2024");

    }

}
