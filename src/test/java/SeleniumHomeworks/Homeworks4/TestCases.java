package SeleniumHomeworks.Homeworks4;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CalendarEventsPage;
import pages.LoginPage;
import tests.TestBase;
import utils.BrowserFactory;
import utils.BrowserUtils;
import utils.Driver;

import java.util.concurrent.TimeUnit;

public class TestCases extends TestBase {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        //explicit wait
        wait = new WebDriverWait(driver, 10);
        //implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //maximize browser
        driver.manage().window().maximize();
        driver.get("https://qa1.vytrack.com/");
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager85");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123", Keys.ENTER);

        WebElement loaderMask= null;

        if(driver.findElements(By.cssSelector("div[class='loader-mask shown']")).size()>0) {
            loaderMask = driver.findElement(By.cssSelector("div[class='loader-mask shown']"));
            wait.until(ExpectedConditions.invisibilityOf(loaderMask));
        }

        WebElement activitiesElement = driver.findElement(By.linkText("Activities"));
        wait.until(ExpectedConditions.visibilityOf(activitiesElement));
        wait.until(ExpectedConditions.elementToBeClickable(activitiesElement));
        activitiesElement.click();

        WebElement calendarEventsElement = driver.findElement(By.linkText("Calendar Events"));
        wait.until(ExpectedConditions.visibilityOf(calendarEventsElement));
        wait.until(ExpectedConditions.elementToBeClickable(calendarEventsElement));
        calendarEventsElement.click();

        wait.until(ExpectedConditions.invisibilityOf(loaderMask));
    }
    @Test(description = "Verify that “view”, “edit” and “delete” options are available")
    public void test1(){
        Actions action = new Actions(driver);
        BrowserUtils.wait(2);
        WebElement Dots = driver.findElement(By.xpath("//tbody/tr[13]/td[9]/div/div/a"));
        action.moveToElement(Dots).perform();

        WebElement View = driver.findElement(By.xpath("//i[@class='fa-eye hide-text']"));
        action.moveToElement(View).perform();
        Assert.assertTrue(View.isDisplayed());
        BrowserUtils.wait(1);
        action.moveToElement(View.findElement(By.xpath("//i[@class='fa-pencil-square-o hide-text']"))).perform();
        BrowserUtils.wait(1);
        action.moveToElement(View.findElement(By.xpath("//i[@class='fa-trash-o hide-text']"))).perform();
        BrowserUtils.wait(2);
    }

    @Test(description = "Deselect all options except “Title”,Verify that “Title” column still displayed")
    public void test2(){
        driver.findElement(By.cssSelector("[title=\"Grid Settings\"]")).click();
        for (int i=2; i<8; i++){
            driver.findElement(By.xpath("//table[@class=\'grid table-hover table table-condensed\']//tbody//tr["+i+"]//td[3]")).click();
               BrowserUtils.wait(1);
        }
        Assert.assertTrue(driver.findElement(By.xpath("//tr[1]//input[starts-with(@id,'column')]")).isDisplayed());
    }

    @Test(description = "Verify that “Save And Close”, “Save And New” and “Save” options are available")
    public void test3(){
        driver.findElement(By.cssSelector("[title=\"Create Calendar event\"]")).click();
        BrowserUtils.wait(1);
       driver.findElement(By.xpath("//span[@class='caret']")).click();
        BrowserUtils.wait(1);
        Assert.assertTrue(driver.findElement(By.xpath("//button[@class=\'action-button dropdown-item\']")).isDisplayed(),"Test failed");
        Assert.assertTrue(driver.findElement(By.xpath("//form//li[2]//button")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//form//li[3]//button")).isDisplayed());
    }

    @Test(description = "Verify that “All Calendar Events” page subtitle is displayed")
    public void test4(){
        driver.findElement(By.cssSelector("[title=\"Create Calendar event\"]")).click();
        BrowserUtils.wait(2);
        driver.findElement(By.cssSelector("[title=\"Cancel\"]")).click();
        BrowserUtils.wait(2);
        Assert.assertTrue(driver.findElement(By.cssSelector("[class=\"oro-subtitle\"]")).isDisplayed());
    }

    @Test(description = "Verify that difference between end and start time is exactly 1 hour")
    public void test5(){
        LoginPage loginPage = new LoginPage();
        loginPage.login("storemanager85","UserUser123");
        loginPage.waitUntilLoaderMaskDisappear();

        loginPage.navigateTo("Activities","Calendar Events");
        loginPage.waitUntilLoaderMaskDisappear();

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.clickToCreateCalendarEvent();
        loginPage.waitUntilLoaderMaskDisappear();

        String startTime = Driver.get().findElement(By.cssSelector("[id^='time_selector_oro_calendar_event_form_start']")).getAttribute("value");
        System.out.println(startTime);
        String endTime = Driver.get().findElement(By.cssSelector("[id^='time_selector_oro_calendar_event_form_end']")).getAttribute("value");
        System.out.println(endTime);

        int k = startTime.length();
        int l = endTime.length();
        String AM = startTime.substring(k-2, k);
        System.out.println(AM);
        String PM = endTime.substring(l-2, l);
        System.out.println(PM);
        String[] startTime1=startTime.split(":");
        String[] endTime1=endTime.split(":");
        int a=Integer.parseInt(startTime1[0]);
        int b=Integer.parseInt(endTime1[0]);
        int difference=0;
              if (AM.equals("AM") && PM.equals("PM")){
                  difference=(b-a);
        } else if (AM.equals("AM") && PM.equals("PM")){
              a=a+12;
              difference=b-a;
        }else if (AM.equals("PM") && PM.equals("AM")){
                  a=a-12;
                  difference=b-a;
        }
              Assert.assertTrue(difference==1);

    }

    @Test(description = "Verify that end time is equals to “10:00 PM”")
    public void test6(){
        driver.findElement(By.cssSelector("[title=\"Create Calendar event\"]")).click();
        BrowserUtils.wait(2);
        driver.findElement(By.xpath("//label[text()='Start']/parent::div/following-sibling::div/div/input[2]")).click();
        BrowserUtils.wait(2);
        driver.findElement(By.xpath("//div[@class='ui-timepicker-wrapper']/ul/li[43]")).click();
        WebElement EndTime = driver.findElement(By.xpath("//label[text()='End']/parent::div/following-sibling::div/div/input[2]"));
        EndTime.click();
        BrowserUtils.wait(2);
        String timeCheck = EndTime.getAttribute("value");
        System.out.println(timeCheck);
        Assert.assertEquals(timeCheck,"10:00 PM");
    }

    @Test(description = "Verify that start and end time input boxes are not displayed" +
                        " Verify that start and end date input boxes are displayed")
    public void test7(){
        driver.findElement(By.cssSelector("[title=\"Create Calendar event\"]")).click();
        BrowserUtils.wait(2);
        driver.findElement(By.xpath("//input[@name='oro_calendar_event_form[allDay]']")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("[id^='oro_calendar_event_form_allDay']")).isSelected(),"Checkbox is not selected");
        BrowserUtils.wait(2);
        Assert.assertFalse(driver.findElement(By.cssSelector("[id^='time_selector_oro_calendar_event_form_start']")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("[id^='time_selector_oro_calendar_event_form_end']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("[id^='date_selector_oro_calendar_event_form_start']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("[id^='date_selector_oro_calendar_event_form_end']")).isDisplayed());
    }

    @Test(description = "Verify that “Repeat” checkbox is selected, Verify that “Daily” is selected by default and" +
                         "following options are available in “Repeats” drop-down:")
    public void test8(){
        driver.findElement(By.cssSelector("[title=\"Create Calendar event\"]")).click();
        BrowserUtils.wait(3);
        driver.findElement(By.xpath("//input[@data-name=\'recurrence-repeat\']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//input[@data-name=\'recurrence-repeat\']")).isSelected(),"Test failed");
        driver.findElement(By.xpath("//select[@data-name=\"recurrence-repeats\"]")).click();
        BrowserUtils.wait(2);
        Assert.assertTrue(driver.findElement(By.xpath("//div//select//option[2]")).isEnabled());
        Assert.assertTrue(driver.findElement(By.xpath("//div//select//option[3]")).isEnabled());
        Assert.assertTrue(driver.findElement(By.xpath("//div//select//option[4]")).isEnabled());
    }



    @AfterMethod
    public void teardown(){
        driver.quit();
    }


}
