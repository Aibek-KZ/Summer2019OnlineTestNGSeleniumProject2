package SeleniumHomeworks.Homeworks1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;
import utils.BrowserUtils;

/*
Step 1. Go to https://practice-cybertekschool.herokuapp.com
Step 2. Click on “Sign Up For Mailing List”
Step 3. Enter any valid name
Step 4. Enter any valid email
Step 5. Click on “Sign Up” button
Expected result: Following message should be displayed: “Thank you for signing up. Click the
button below to return to the home page.” Home button should be displayed.
 */

public class TestCase1 {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//a[@href=\"/sign_up\"]")).click();
        driver.findElement(By.xpath("//input[@name='full_name']")).sendKeys("User");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("user@gmail.com");
        driver.findElement(By.xpath("//button [@name='wooden_spoon']")).click();
        BrowserUtils.wait(4);
        String expectedResult="Thank you for signing up. Click the button below to return to the home page.";
        if (driver.findElement(By.name("signup_message")).getText().equals(expectedResult)) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
        }
        driver.findElement(By.xpath("//i [@class='icon-2x icon-signout']")).click();
        BrowserUtils.wait(4);
        String expectedPage = "https://practice-cybertekschool.herokuapp.com/";
        if (driver.getCurrentUrl().equals(expectedPage)) {
            System.out.println("Home button works fine");
        } else System.out.println("Home button doesn't work");

        driver.quit();
    }
}
