package SeleniumHomeworks.Homeworks1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;
import utils.BrowserUtils;
/*
Step 1. Go to https://practice-cybertekschool.herokuapp.com
Step 2. Click on “Multiple Buttons”
Step 3. Click on “Button 1”
Verify that result message is displayed: “Clicked on button one!”
 */

public class TestCase3 {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        BrowserUtils.wait(5);
        driver.findElement(By.xpath("//a [@href='/multiple_buttons']")).click();
        BrowserUtils.wait(5);
        driver.findElement(By.xpath("//button [@onclick='button1()']")).click();
        String expectedResult="Clicked on button one!";
        if (driver.findElement(By.id("result")).getText().equals(expectedResult)){
            System.out.println("Test passed");
            System.out.println(driver.findElement(By.id("result")).getText());
        } else {
            System.out.println("Test failed");
        }

        driver.close();


    }
}
